use std::marker::PhantomData;

use itertools::Itertools;

use super::tags::{CompareOp, ConjunctionOp, TagName, TagQueryEncoder};
use crate::error::Error;

pub struct TagSqlEncoder<'e, EN, EV> {
    pub enc_name: EN,
    pub enc_value: EV,
    pub arguments: Vec<Vec<u8>>,
    _pd: PhantomData<&'e ()>,
}

impl<'e, EN, EV> TagSqlEncoder<'e, EN, EV>
where
    EN: Fn(&str) -> Result<Vec<u8>, Error> + 'e,
    EV: Fn(&str) -> Result<Vec<u8>, Error> + 'e,
{
    pub fn new(enc_name: EN, enc_value: EV) -> Self {
        Self {
            enc_name,
            enc_value,
            arguments: vec![],
            _pd: PhantomData,
        }
    }
}

impl<'e, EN, EV> TagQueryEncoder for TagSqlEncoder<'e, EN, EV>
where
    EN: Fn(&str) -> Result<Vec<u8>, Error> + 'e,
    EV: Fn(&str) -> Result<Vec<u8>, Error> + 'e,
{
    type Arg = Vec<u8>;
    type Clause = String;
    type JoinClause = String;

    fn encode_name(&mut self, name: &TagName) -> Result<Self::Arg, Error> {
        Ok(match name {
            TagName::Encrypted(name) | TagName::Plaintext(name) => (&self.enc_name)(name)?,
        })
    }

    fn encode_value(&mut self, value: &String, is_plaintext: bool) -> Result<Self::Arg, Error> {
        Ok(if is_plaintext {
            value.as_bytes().to_vec()
        } else {
            (&self.enc_value)(value)?
        })
    }

    fn encode_op_clause(
        &mut self,
        op: CompareOp,
        enc_name: Self::Arg,
        enc_value: Self::Arg,
        is_plaintext: bool,
        clause_id: &str,
    ) -> Result<Option<(Self::Clause, Self::JoinClause)>, Error> {
        let idx = self.arguments.len();
        let (op_prefix, match_prefix) = match (is_plaintext, op.as_sql_str_for_prefix()) {
            (false, Some(pfx_op)) if enc_value.len() > 12 => {
                // the first 12 characters of an encrypted tag is the nonce, based
                // on an HMAC of the rest of the value. it serves as an effective index
                // on its own
                let match_prefix = enc_value[..12].to_vec();
                (
                    format!(" AND SUBSTR({}.value, 1, 12) {} ${}", clause_id, pfx_op, idx + 3),
                    Some(match_prefix),
                )
            }
            _ => (String::new(), None),
        };
        self.arguments.push(enc_name);
        self.arguments.push(enc_value);
        if let Some(v) = match_prefix {
            self.arguments.push(v);
        }

        let query = format!(
            "({}.name = ${} AND {}.value {} ${}{} AND {}.plaintext = {}) ",
            clause_id,
            idx + 1,
            clause_id,
            op.as_sql_str(),
            idx + 2,
            op_prefix.as_str(),
            clause_id,
            if is_plaintext { 1 } else { 0 }
        );

        let join = format!(
            " LEFT JOIN items_tags {} on {}.item_id = i.id",
            clause_id,
            clause_id,
        );
        debug!("Let's create a join! {}", join);

        Ok(Some((query, join)))
    }

    fn encode_and_clause(
        &mut self,
        enc_name: Self::Arg,
        enc_values: Vec<Self::Arg>,
        is_plaintext: bool,
        negate: bool,
        clause_id: &str,
    ) -> Result<Option<(Self::Clause, Self::JoinClause)>, Error> {
        // return Ok(Some(("".to_string(), "".to_string())));
        let args_in = Itertools::intersperse(std::iter::repeat("$$").take(enc_values.len()), ", ")
            .collect::<String>();
        let query = format!(
            "{}.name = $$ AND {}.value {} ({}) AND {}.plaintext = {})",
            clause_id,
            clause_id,
            if negate { "NOT AND" } else { "AND" },
            args_in,
            clause_id,
            if is_plaintext { 1 } else { 0 }
        );
        self.arguments.push(enc_name);
        self.arguments.extend(enc_values);

        let join = format!(
            " LEFT JOIN items_tags {} on {}.item_id = i.id",
            clause_id,
            clause_id,
        );
        debug!("Let's create a join! {}", join);

        Ok(Some((query, join)))

    }

    fn encode_exist_clause(
        &mut self,
        enc_name: Self::Arg,
        is_plaintext: bool,
        negate: bool,
        clause_id: &str,
    ) -> Result<Option<(Self::Clause, Self::JoinClause)>, Error> {
        let query = format!(
            "i.id {} (SELECT item_id FROM items_tags WHERE name = $$ AND plaintext = {})",
            if negate { "NOT IN" } else { "IN" },
            if is_plaintext { 1 } else { 0 }
        );
        self.arguments.push(enc_name);

        let join = format!(
            " LEFT JOIN items_tags {} on {}.item_id = i.id",
            clause_id,
            clause_id,
        );
        debug!("Let's create a join! {}", join);

        Ok(Some((query, join)))
    }

    fn encode_conj_clause(
        &mut self,
        op: ConjunctionOp,
        clauses: Vec<Self::Clause>,
        joins: Vec<Self::JoinClause>,
        _clause_id: &str,
    ) -> Result<Option<(Self::Clause, Self::JoinClause)>, Error> {
        let qc = clauses.len();
        if qc == 0 {
            if op == ConjunctionOp::Or {
                return Ok(Some(("0".to_string(), "".to_string())));
            } else {
                return Ok(None);
            }
        }
        let mut s = String::new();
        let mut js = String::new();
        if qc > 1 {
            s.push('(');
        }
        for (index, clause) in clauses.into_iter().enumerate() {
            if index > 0 {
                s.push_str(op.as_sql_str());
            }
            s.push_str(&clause);
        }
        for (index, join_clause) in joins.into_iter().enumerate() {
            if index > 0 {
                js.push_str("\n");
            }
            js.push_str(&join_clause);
        }
        if qc > 1 {
            s.push(')');
        }
        Ok(Some((s, js)))
    }
}

#[cfg(test)]
mod tests {
    use super::super::tags::TagQuery;
    use super::*;

    #[test]
    fn tag_query_encode() {
        let condition_1 = TagQuery::And(vec![
            TagQuery::Eq(
                TagName::Encrypted("enctag".to_string()),
                "noncenonce12encval".to_string(),
            ),
            TagQuery::Eq(
                TagName::Plaintext("plaintag".to_string()),
                "plainval".to_string(),
            ),
        ]);
        let condition_2 = TagQuery::And(vec![
            TagQuery::Eq(
                TagName::Encrypted("enctag".to_string()),
                "noncenonce12encval".to_string(),
            ),
            TagQuery::Not(Box::new(TagQuery::Eq(
                TagName::Plaintext("plaintag".to_string()),
                "eggs".to_string(),
            ))),
        ]);
        let query = TagQuery::Or(vec![condition_1, condition_2]);
        let mut enc = TagSqlEncoder::new(
            |name: &str| Ok(format!("--{}--", name).into_bytes()),
            |value: &str| Ok(value.to_uppercase().into_bytes()),
        );
        let (query_str, join_str) = enc.encode_query(&query).unwrap().unwrap();
        print!("Joins: \n{}\n\n", join_str);
        assert_eq!(join_str, " LEFT JOIN items_tags it2_0_0 on it2_0_0.item_id = i.id\n LEFT JOIN items_tags it2_0_1 on it2_0_1.item_id = i.id\n LEFT JOIN items_tags it2_1_0 on it2_1_0.item_id = i.id\n LEFT JOIN items_tags it2_1_1 on it2_1_1.item_id = i.id");
        print!("Joins: \nJoins passed!\n\n");
        assert_eq!(query_str, "(((it2_0_0.name = $1 AND it2_0_0.value = $2 AND SUBSTR(it2_0_0.value, 1, 12) = $3 AND it2_0_0.plaintext = 0)  AND (it2_0_1.name = $4 AND it2_0_1.value = $5 AND it2_0_1.plaintext = 1) ) OR ((it2_1_0.name = $6 AND it2_1_0.value = $7 AND SUBSTR(it2_1_0.value, 1, 12) = $8 AND it2_1_0.plaintext = 0)  AND (it2_1_1.name = $9 AND it2_1_1.value != $10 AND it2_1_1.plaintext = 1) ))");
        let args = enc.arguments;
        assert_eq!(
            args,
            vec![
                b"--enctag--".to_vec(),
                b"NONCENONCE12ENCVAL".to_vec(),
                b"NONCENONCE12".to_vec(),
                b"--plaintag--".to_vec(),
                b"plainval".to_vec(),
                b"--enctag--".to_vec(),
                b"NONCENONCE12ENCVAL".to_vec(),
                b"NONCENONCE12".to_vec(),
                b"--plaintag--".to_vec(),
                b"eggs".to_vec()
            ]
        );
    }
}
