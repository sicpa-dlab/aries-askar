use std::collections::BTreeMap;
use std::fmt::{self, Debug, Formatter};
use std::sync::Arc;

use async_stream::try_stream;

use futures_lite::{
    pin,
    stream::{Stream, StreamExt},
};

use sqlx::{
    pool::PoolConnection,
    postgres::{PgPool, Postgres},
    Row,
};

use crate::{
    backend::{
        db_utils::{
            decode_tags, decrypt_scan_batch, encode_profile_key, encode_tag_filter,
            expiry_timestamp, extend_query, prepare_tags, random_profile_name,
            replace_arg_placeholders, DbSession, DbSessionActive, DbSessionRef, EncScanEntry,
            ExtDatabase, QueryParams, QueryPrepare, PAGE_SIZE,
        },
        types::{Backend, QueryBackend},
    },
    error::Error,
    future::{unblock, BoxFuture},
    protect::{EntryEncryptor, KeyCache, PassKey, ProfileId, ProfileKey, StoreKeyMethod},
    storage::{EncEntryTag, Entry, EntryKind, EntryOperation, EntryTag, Scan, TagFilter},
};

const COUNT_QUERY: &'static str = "SELECT COUNT(*) FROM items i
    WHERE profile_id = $1 AND kind = $2 AND category = $3
    AND (expiry IS NULL OR expiry > CURRENT_TIMESTAMP)";
const DELETE_QUERY: &'static str = "DELETE FROM items
    WHERE profile_id = $1 AND kind = $2 AND category = $3 AND name = $4";
const FETCH_QUERY: &'static str = "SELECT id, value,
    (SELECT ARRAY_TO_STRING(ARRAY_AGG(it.plaintext || ':'
        || ENCODE(it.name, 'hex') || ':' || ENCODE(it.value, 'hex')), ',')
        FROM items_tags it WHERE it.item_id = i.id) tags
    FROM items i
    WHERE profile_id = $1 AND kind = $2 AND category = $3 AND name = $4
    AND (expiry IS NULL OR expiry > CURRENT_TIMESTAMP)";
const FETCH_QUERY_UPDATE: &'static str = "SELECT id, value,
    (SELECT ARRAY_TO_STRING(ARRAY_AGG(it.plaintext || ':'
        || ENCODE(it.name, 'hex') || ':' || ENCODE(it.value, 'hex')), ',')
        FROM items_tags it WHERE it.item_id = i.id) tags
    FROM items i
    WHERE profile_id = $1 AND kind = $2 AND category = $3 AND name = $4
    AND (expiry IS NULL OR expiry > CURRENT_TIMESTAMP) FOR UPDATE";
const INSERT_QUERY: &'static str =
    "INSERT INTO items (profile_id, kind, category, name, value, expiry)
    VALUES ($1, $2, $3, $4, $5, $6)
    ON CONFLICT DO NOTHING RETURNING id";
const SCAN_QUERY: &'static str = "SELECT id, name, value,
    (SELECT ARRAY_TO_STRING(ARRAY_AGG(it.plaintext || ':'
        || ENCODE(it.name, 'hex') || ':' || ENCODE(it.value, 'hex')), ',')
        FROM items_tags it WHERE it.item_id = i.id) tags
    FROM items i WHERE profile_id = $1 AND kind = $2 AND category = $3
    AND (expiry IS NULL OR expiry > CURRENT_TIMESTAMP)";
const DELETE_ALL_QUERY: &'static str = "DELETE FROM items i
    WHERE i.profile_id = $1 AND i.kind = $2 AND i.category = $3";
const TAG_INSERT_QUERY: &'static str = "INSERT INTO items_tags
    (item_id, name, value, plaintext) VALUES ($1, $2, $3, $4)";

mod provision;
pub use provision::PostgresStoreOptions;

#[cfg(any(test, feature = "pg_test"))]
pub mod test_db;

/// A PostgreSQL database store
pub struct PostgresStore {
    conn_pool: PgPool,
    default_profile: String,
    key_cache: Arc<KeyCache>,
    host: String,
    name: String,
}

impl PostgresStore {
    pub(crate) fn new(
        conn_pool: PgPool,
        default_profile: String,
        key_cache: KeyCache,
        host: String,
        name: String,
    ) -> Self {
        Self {
            conn_pool,
            default_profile,
            key_cache: Arc::new(key_cache),
            host,
            name,
        }
    }
}

impl Backend for PostgresStore {
    type Session = DbSession<Postgres>;

    fn create_profile(&self, name: Option<String>) -> BoxFuture<'_, Result<String, Error>> {
        let name = name.unwrap_or_else(random_profile_name);
        Box::pin(async move {
            let store_key = self.key_cache.store_key.clone();
            let (profile_key, enc_key) = unblock(move || {
                let profile_key = ProfileKey::new()?;
                let enc_key = encode_profile_key(&profile_key, &store_key)?;
                Result::<_, Error>::Ok((profile_key, enc_key))
            })
            .await?;
            let mut conn = self.conn_pool.acquire().await?;
            if let Some(pid) = sqlx::query_scalar(
                "INSERT INTO profiles (name, profile_key) VALUES ($1, $2) 
                ON CONFLICT DO NOTHING RETURNING id",
            )
            .bind(&name)
            .bind(enc_key)
            .fetch_optional(&mut conn)
            .await?
            {
                self.key_cache
                    .add_profile(name.clone(), pid, Arc::new(profile_key))
                    .await;
                Ok(name)
            } else {
                Err(err_msg!(Duplicate, "Duplicate profile name"))
            }
        })
    }

    fn get_profile_name(&self) -> &str {
        self.default_profile.as_str()
    }

    fn remove_profile(&self, name: String) -> BoxFuture<'_, Result<bool, Error>> {
        Box::pin(async move {
            let mut conn = self.conn_pool.acquire().await?;
            Ok(sqlx::query("DELETE FROM profiles WHERE name=$1")
                .bind(&name)
                .execute(&mut conn)
                .await?
                .rows_affected()
                != 0)
        })
    }

    

    fn rekey_backend(
        &mut self,
        method: StoreKeyMethod,
        pass_key: PassKey<'_>,
    ) -> BoxFuture<'_, Result<(), Error>> {
        info!("rekey");

        let pass_key = pass_key.into_owned();
        Box::pin(async move {
            let (store_key, store_key_ref) = unblock(move || method.resolve(pass_key)).await?;
            let store_key = Arc::new(store_key);
            let mut txn = self.conn_pool.begin().await?;

            let handle_rekey_backend = || async {
                let mut rows = sqlx::query("SELECT id, profile_key FROM profiles").fetch(&mut txn);
                let mut upd_keys = BTreeMap::<ProfileId, Vec<u8>>::new();
                while let Some(row) = rows.next().await {
                    let row = row?;
                    let pid = row.try_get(0)?;
                    let enc_key = row.try_get(1)?;
                    let profile_key = self.key_cache.load_key(enc_key).await?;
                    let upd_key = unblock({
                        let store_key = store_key.clone();
                        move || encode_profile_key(&profile_key, &store_key)
                    })
                    .await?;
                    upd_keys.insert(pid, upd_key);
                }
                drop(rows);
                for (pid, key) in upd_keys {
                    if sqlx::query("UPDATE profiles SET profile_key=$1 WHERE id=$2")
                        .bind(key)
                        .bind(pid)
                        .execute(&mut txn)
                        .await?
                        .rows_affected()
                        != 1
                    {
                        return Err(err_msg!(Backend, "Error updating profile key"));
                    }
                }
                if sqlx::query("UPDATE config SET value=$1 WHERE name='key'")
                    .bind(store_key_ref.into_uri())
                    .execute(&mut txn)
                    .await?
                    .rows_affected()
                    != 1
                {
                    return Err(err_msg!(Backend, "Error updating store key"));
                }
                Ok(())
            };

            let rekey = handle_rekey_backend().await;

            match rekey {
                Ok(())  => (),
                Err(e) => {
                    txn.rollback().await?;
                    return Err(e)
                },
            } 

            txn.commit().await?;
            self.key_cache = Arc::new(KeyCache::new(store_key));
            Ok(())
        })
    }

    fn scan(
        &self,
        profile: Option<String>,
        kind: EntryKind,
        category: String,
        tag_filter: Option<TagFilter>,
        offset: Option<i64>,
        limit: Option<i64>,
    ) -> BoxFuture<'_, Result<Scan<'static, Entry>, Error>> {
        Box::pin(async move {
            let session = self.session(profile, false)?;
            let mut active = session.owned_ref();
            let (profile_id, key) = acquire_key(&mut *active).await?;
            let scan = perform_scan(
                active,
                profile_id,
                key.clone(),
                kind,
                category.clone(),
                tag_filter,
                offset,
                limit,
                false,
            );
            let stream = scan.then(move |enc_rows| {
                let category = category.clone();
                let key = key.clone();
                unblock(move || decrypt_scan_batch(category, enc_rows?, &key))
            });
            Ok(Scan::new(stream, PAGE_SIZE))
        })
    }

    fn session(&self, profile: Option<String>, transaction: bool) -> Result<Self::Session, Error> {
        Ok(DbSession::new(
            self.conn_pool.clone(),
            self.key_cache.clone(),
            profile.unwrap_or_else(|| self.default_profile.clone()),
            transaction,
        ))
    }

    fn close(&self) -> BoxFuture<'_, Result<(), Error>> {
        Box::pin(async move {
            self.conn_pool.close().await;
            Ok(())
        })
    }
}

impl Debug for PostgresStore {
    fn fmt(&self, f: &mut Formatter<'_>) -> fmt::Result {
        f.debug_struct("PostgresStore")
            .field("default_profile", &self.default_profile)
            .field("host", &self.host)
            .field("name", &self.name)
            .finish()
    }
}

impl QueryBackend for DbSession<Postgres> {
    fn count<'q>(
        &'q mut self,
        kind: EntryKind,
        category: &'q str,
        tag_filter: Option<TagFilter>,
    ) -> BoxFuture<'q, Result<i64, Error>> {
        let category = ProfileKey::prepare_input(category.as_bytes());

        Box::pin(async move {
            let (profile_id, key) = acquire_key(&mut *self).await?;
            let mut params = QueryParams::new();
            params.push(profile_id);
            params.push(kind as i16);
            let (enc_category, tag_filter) = unblock({
                let params_len = params.len() + 1; // plus category
                move || {
                    Result::<_, Error>::Ok((
                        key.encrypt_entry_category(category)?,
                        encode_tag_filter::<PostgresStore>(tag_filter, &key, params_len)?,
                    ))
                }
            })
            .await?;
            params.push(enc_category);
            let query =
                extend_query::<PostgresStore>(COUNT_QUERY, &mut params, tag_filter, None, None)?;
            let mut active = acquire_session(&mut *self).await?;
            let count = sqlx::query_scalar_with(query.as_str(), params)
                .fetch_one(active.connection_mut())
                .await?;
            Ok(count)
        })
    }

    fn fetch(
        &mut self,
        kind: EntryKind,
        category: &str,
        name: &str,
        for_update: bool,
    ) -> BoxFuture<'_, Result<Option<Entry>, Error>> {
        let category = category.to_string();
        let name = name.to_string();

        Box::pin(async move {
            let (profile_id, key) = acquire_key(&mut *self).await?;
            let (enc_category, enc_name) = unblock({
                let key = key.clone();
                let category = ProfileKey::prepare_input(category.as_bytes());
                let name = ProfileKey::prepare_input(name.as_bytes());
                move || {
                    Result::<_, Error>::Ok((
                        key.encrypt_entry_category(category)?,
                        key.encrypt_entry_name(name)?,
                    ))
                }
            })
            .await?;
            let mut active = acquire_session(&mut *self).await?;
            if let Some(row) = sqlx::query(if for_update && active.is_transaction() {
                FETCH_QUERY_UPDATE
            } else {
                FETCH_QUERY
            })
            .bind(profile_id)
            .bind(kind as i16)
            .bind(enc_category)
            .bind(enc_name)
            .fetch_optional(active.connection_mut())
            .await?
            {
                let value = row.try_get(1)?;
                let tags = row.try_get::<Option<String>, _>(2)?.map(String::into_bytes);
                let (category, name, value, tags) = unblock(move || {
                    let value = key.decrypt_entry_value(category.as_ref(), name.as_ref(), value)?;
                    let tags = if let Some(enc_tags) = tags {
                        key.decrypt_entry_tags(
                            decode_tags(enc_tags)
                                .map_err(|_| err_msg!(Unexpected, "Error decoding tags"))?,
                        )?
                    } else {
                        Vec::new()
                    };
                    Result::<_, Error>::Ok((category, name, value, tags))
                })
                .await?;
                Ok(Some(Entry::new(category, name, value, tags)))
            } else {
                Ok(None)
            }
        })
    }

    fn fetch_all<'q>(
        &'q mut self,
        kind: EntryKind,
        category: &'q str,
        tag_filter: Option<TagFilter>,
        limit: Option<i64>,
        for_update: bool,
    ) -> BoxFuture<'q, Result<Vec<Entry>, Error>> {
        let category = category.to_string();
        Box::pin(async move {
            let for_update = for_update && self.is_transaction();
            let mut active = self.borrow_mut();
            let (profile_id, key) = acquire_key(&mut *active).await?;
            let scan = perform_scan(
                active,
                profile_id,
                key.clone(),
                kind,
                category.clone(),
                tag_filter,
                None,
                limit,
                for_update,
            );
            pin!(scan);
            let mut enc_rows = vec![];
            loop {
                if let Some(rows) = scan.try_next().await? {
                    enc_rows.extend(rows)
                } else {
                    break;
                }
            }
            unblock(move || decrypt_scan_batch(category, enc_rows, &key)).await
        })
    }

    fn remove_all<'q>(
        &'q mut self,
        kind: EntryKind,
        category: &'q str,
        tag_filter: Option<TagFilter>,
    ) -> BoxFuture<'q, Result<i64, Error>> {
        let category = ProfileKey::prepare_input(category.as_bytes());

        Box::pin(async move {
            let (profile_id, key) = acquire_key(&mut *self).await?;
            let mut params = QueryParams::new();
            params.push(profile_id);
            params.push(kind as i16);
            let (enc_category, tag_filter) = unblock({
                let params_len = params.len() + 1; // plus category
                move || {
                    Result::<_, Error>::Ok((
                        key.encrypt_entry_category(category)?,
                        encode_tag_filter::<PostgresStore>(tag_filter, &key, params_len)?,
                    ))
                }
            })
            .await?;
            params.push(enc_category);
            let query = extend_query::<PostgresStore>(
                DELETE_ALL_QUERY,
                &mut params,
                tag_filter,
                None,
                None,
            )?;

            let mut active = acquire_session(&mut *self).await?;
            let removed = sqlx::query_with(query.as_str(), params)
                .execute(active.connection_mut())
                .await?
                .rows_affected();
            Ok(removed as i64)
        })
    }

    fn update<'q>(
        &'q mut self,
        kind: EntryKind,
        operation: EntryOperation,
        category: &'q str,
        name: &'q str,
        value: Option<&'q [u8]>,
        tags: Option<&'q [EntryTag]>,
        expiry_ms: Option<i64>,
    ) -> BoxFuture<'q, Result<(), Error>> {
        info!("update");

        let category = ProfileKey::prepare_input(category.as_bytes());
        let name = ProfileKey::prepare_input(name.as_bytes());

        match operation {
            EntryOperation::Insert => {
                let value = ProfileKey::prepare_input(value.unwrap());
                let tags = tags.map(prepare_tags);
                Box::pin(async move {
                    let (_, key) = acquire_key(&mut *self).await?;
                    let (enc_category, enc_name, enc_value, enc_tags) = unblock(move || {
                        let enc_value =
                            key.encrypt_entry_value(category.as_ref(), name.as_ref(), value)?;
                        Result::<_, Error>::Ok((
                            key.encrypt_entry_category(category)?,
                            key.encrypt_entry_name(name)?,
                            enc_value,
                            tags.transpose()?
                                .map(|t| key.encrypt_entry_tags(t))
                                .transpose()?,
                        ))
                    })
                    .await?;
                    let mut active = acquire_session(&mut *self).await?;
                    let mut txn = active.as_transaction().await?;
                    let insert = perform_insert(
                        &mut txn,
                        kind,
                        &enc_category,
                        &enc_name,
                        &enc_value,
                        enc_tags,
                        expiry_ms,
                    )
                    .await;
                    match insert {
                        Ok(())  => (),
                        Err(e) => {
                            txn.rollback().await?;
                            return Err(e)
                        },
                    } 
                    txn.commit().await?;
                    Ok(())
                })
            }
            EntryOperation::Replace => {
                let value = ProfileKey::prepare_input(value.unwrap());
                let tags = tags.map(prepare_tags);
                Box::pin(async move {
                    let (_, key) = acquire_key(&mut *self).await?;
                    let (enc_category, enc_name, enc_value, enc_tags) = unblock(move || {
                        let enc_value =
                            key.encrypt_entry_value(category.as_ref(), name.as_ref(), value)?;
                        Result::<_, Error>::Ok((
                            key.encrypt_entry_category(category)?,
                            key.encrypt_entry_name(name)?,
                            enc_value,
                            tags.transpose()?
                                .map(|t| key.encrypt_entry_tags(t))
                                .transpose()?,
                        ))
                    })
                    .await?;

                    let mut active = acquire_session(&mut *self).await?;
                    let mut txn = active.as_transaction().await?;
                    let remove = perform_remove(&mut txn, kind, &enc_category, &enc_name, false).await;

                    match remove {
                        Ok(())  => (),
                        Err(e) => {
                            txn.rollback().await?;
                            return Err(e)
                        },
                    } 

                    let insert = perform_insert(
                        &mut txn,
                        kind,
                        &enc_category,
                        &enc_name,
                        &enc_value,
                        enc_tags,
                        expiry_ms,
                    )
                    .await;

                    match insert {
                        Ok(())  => (),
                        Err(e) => {
                            txn.rollback().await?;
                            return Err(e)
                        },
                    } 
                    txn.commit().await?;
                    Ok(())
                })
            }

            EntryOperation::Remove => Box::pin(async move {
                let (_, key) = acquire_key(&mut *self).await?;
                let (enc_category, enc_name) = unblock(move || {
                    Result::<_, Error>::Ok((
                        key.encrypt_entry_category(category)?,
                        key.encrypt_entry_name(name)?,
                    ))
                })
                .await?;
                let mut active = acquire_session(&mut *self).await?;
                Ok(perform_remove(&mut active, kind, &enc_category, &enc_name, false).await?)
            }),
        }
    }

    fn close(self, commit: bool) -> BoxFuture<'static, Result<(), Error>> {
        Box::pin(DbSession::close(self, commit))
    }
}

impl ExtDatabase for Postgres {}

impl QueryPrepare for PostgresStore {
    type DB = Postgres;

    fn placeholder(index: i64) -> String {
        format!("${}", index)
    }

    fn limit_query<'q>(
        mut query: String,
        args: &mut QueryParams<'q, Self::DB>,
        offset: Option<i64>,
        limit: Option<i64>,
    ) -> String
    where
        i64: for<'e> sqlx::Encode<'e, Self::DB> + sqlx::Type<Self::DB>,
    {
        if offset.is_some() || limit.is_some() {
            let last_idx = (args.len() + 1) as i64;
            args.push(limit);
            args.push(offset.unwrap_or(0));
            let limit = replace_arg_placeholders::<Self>(" LIMIT $$ OFFSET $$", last_idx);
            query.push_str(&limit);
        }
        query
    }
}

async fn acquire_key(
    session: &mut DbSession<Postgres>,
) -> Result<(ProfileId, Arc<ProfileKey>), Error> {
    if let Some(ret) = session.profile_and_key() {
        Ok(ret)
    } else {
        session.make_active(&resolve_profile_key).await?;
        Ok(session.profile_and_key().unwrap())
    }
}

async fn acquire_session<'q>(
    session: &'q mut DbSession<Postgres>,
) -> Result<DbSessionActive<'q, Postgres>, Error> {
    session.make_active(&resolve_profile_key).await
}

async fn resolve_profile_key(
    conn: &mut PoolConnection<Postgres>,
    cache: Arc<KeyCache>,
    profile: String,
) -> Result<(ProfileId, Arc<ProfileKey>), Error> {
    if let Some((pid, key)) = cache.get_profile(profile.as_str()).await {
        Ok((pid, key))
    } else {
        if let Some(row) = sqlx::query("SELECT id, profile_key FROM profiles WHERE name=$1")
            .bind(profile.as_str())
            .fetch_optional(conn)
            .await?
        {
            let pid = row.try_get(0)?;
            let key = Arc::new(cache.load_key(row.try_get(1)?).await?);
            cache.add_profile(profile, pid, key.clone()).await;
            Ok((pid, key))
        } else {
            Err(err_msg!(NotFound, "Profile not found"))
        }
    }
}

async fn perform_insert<'q>(
    active: &mut DbSessionActive<'q, Postgres>,
    kind: EntryKind,
    enc_category: &[u8],
    enc_name: &[u8],
    enc_value: &[u8],
    enc_tags: Option<Vec<EncEntryTag>>,
    expiry_ms: Option<i64>,
) -> Result<(), Error> {
    trace!("Insert entry");
    let row_id: i64 = sqlx::query_scalar(INSERT_QUERY)
        .bind(active.profile_id)
        .bind(kind as i16)
        .bind(enc_category)
        .bind(enc_name)
        .bind(enc_value)
        .bind(expiry_ms.map(expiry_timestamp).transpose()?)
        .fetch_optional(active.connection_mut())
        .await?
        .ok_or_else(|| err_msg!(Duplicate, "Duplicate row"))?;
    if let Some(tags) = enc_tags {
        for tag in tags {
            sqlx::query(TAG_INSERT_QUERY)
                .bind(row_id)
                .bind(&tag.name)
                .bind(&tag.value)
                .bind(tag.plaintext as i16)
                .execute(active.connection_mut())
                .await?;
        }
    }
    Ok(())
}

async fn perform_remove<'q>(
    active: &mut DbSessionActive<'q, Postgres>,
    kind: EntryKind,
    enc_category: &[u8],
    enc_name: &[u8],
    ignore_error: bool,
) -> Result<(), Error> {
    trace!("Remove entry");
    let done = sqlx::query(DELETE_QUERY)
        .bind(active.profile_id)
        .bind(kind as i16)
        .bind(enc_category)
        .bind(enc_name)
        .execute(active.connection_mut())
        .await?;
    if done.rows_affected() == 0 && !ignore_error {
        Err(err_msg!(NotFound, "Entry not found"))
    } else {
        Ok(())
    }
}

fn perform_scan<'q>(
    mut active: DbSessionRef<'q, Postgres>,
    profile_id: ProfileId,
    key: Arc<ProfileKey>,
    kind: EntryKind,
    category: String,
    tag_filter: Option<TagFilter>,
    offset: Option<i64>,
    limit: Option<i64>,
    for_update: bool,
) -> impl Stream<Item = Result<Vec<EncScanEntry>, Error>> + 'q {
    try_stream! {
        let mut params = QueryParams::new();
        params.push(profile_id);
        params.push(kind as i16);
        let (enc_category, tag_filter) = unblock({
            let key = key.clone();
            let category = ProfileKey::prepare_input(category.as_bytes());
            let params_len = params.len() + 1; // plus category
            move || {
                Result::<_, Error>::Ok((
                    key.encrypt_entry_category(category)?,
                    encode_tag_filter::<PostgresStore>(tag_filter, &key, params_len)?
                ))
            }
        }).await?;
        params.push(enc_category);
        let mut query = extend_query::<PostgresStore>(SCAN_QUERY, &mut params, tag_filter, offset, limit)?;
        if for_update {
            query.push_str(" FOR UPDATE");
        }
        let mut batch = Vec::with_capacity(PAGE_SIZE);

        let mut acquired = acquire_session(&mut *active).await?;
        let mut rows = sqlx::query_with(query.as_str(), params).fetch(acquired.connection_mut());
        while let Some(row) = rows.try_next().await? {
            let tags = row.try_get::<Option<String>, _>(3)?.map(String::into_bytes).unwrap_or_default();
            batch.push(EncScanEntry {
                name: row.try_get(1)?, value: row.try_get(2)?, tags
            });
            if batch.len() == PAGE_SIZE {
                yield batch.split_off(0);
            }
        }
        drop(rows);
        drop(acquired);
        drop(active);

        if batch.len() > 0 {
            yield batch;
        }
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use crate::backend::db_utils::replace_arg_placeholders;

    #[test]
    fn postgres_simple_and_convert_args_works() {
        assert_eq!(
            &replace_arg_placeholders::<PostgresStore>("This $$ is $10 a $$ string!", 3),
            "This $3 is $12 a $5 string!",
        );
    }
}
