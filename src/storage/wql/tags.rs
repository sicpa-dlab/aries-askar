use super::{AbstractQuery, Query};
use crate::error::Error;

pub type TagQuery = AbstractQuery<TagName, String>;

pub fn tag_query(query: Query) -> Result<TagQuery, Error> {
    let result = query
        .map_names(|k| {
            if k.starts_with("~") {
                Result::<_, ()>::Ok(TagName::Plaintext(k[1..].to_string()))
            } else {
                Ok(TagName::Encrypted(k))
            }
        })
        .unwrap();
    validate_tag_query(&result)?;
    Ok(result)
}

pub fn validate_tag_query(_query: &TagQuery) -> Result<(), Error> {
    // FIXME only equality comparison supported for encrypted keys
    Ok(())
}

#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord)]
pub enum TagName {
    Encrypted(String),
    Plaintext(String),
}

impl ToString for TagName {
    fn to_string(&self) -> String {
        match self {
            Self::Encrypted(v) => v.to_string(),
            Self::Plaintext(v) => format!("~{}", v),
        }
    }
}

impl Into<String> for &TagName {
    fn into(self) -> String {
        self.to_string()
    }
}

pub trait TagQueryEncoder {
    type Arg;
    type Clause;
    type JoinClause;

    fn encode_query(&mut self, query: &TagQuery) -> Result<Option<(Self::Clause, Self::JoinClause)>, Error>
    where
        Self: Sized,
    {
        encode_tag_query(query, self, false, &"it2".to_string())
    }

    fn encode_name(&mut self, name: &TagName) -> Result<Self::Arg, Error>;

    fn encode_value(&mut self, value: &String, is_plaintext: bool) -> Result<Self::Arg, Error>;

    fn encode_op_clause(
        &mut self,
        op: CompareOp,
        enc_name: Self::Arg,
        enc_value: Self::Arg,
        is_plaintext: bool,
        clause_id: &str,
    ) -> Result<Option<(Self::Clause, Self::JoinClause)>, Error>;

    fn encode_and_clause(
        &mut self,
        enc_name: Self::Arg,
        enc_values: Vec<Self::Arg>,
        is_plaintext: bool,
        negate: bool,
        clause_id: &str,
    ) -> Result<Option<(Self::Clause, Self::JoinClause)>, Error>;

    fn encode_exist_clause(
        &mut self,
        enc_name: Self::Arg,
        is_plaintext: bool,
        negate: bool,
        clause_id: &str,
    ) -> Result<Option<(Self::Clause, Self::JoinClause)>, Error>;

    fn encode_conj_clause(
        &mut self,
        op: ConjunctionOp,
        clauses: Vec<Self::Clause>,
        clause_id: &str,
    ) -> Result<Option<(Self::Clause, Self::JoinClause)>, Error>;
}

#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum CompareOp {
    Eq,
    Neq,
    Gt,
    Gte,
    Lt,
    Lte,
    Like,
    NotLike,
}

impl CompareOp {
    pub fn as_sql_str(&self) -> &'static str {
        match self {
            Self::Eq => "=",
            Self::Neq => "!=",
            Self::Gt => ">",
            Self::Gte => ">=",
            Self::Lt => "<",
            Self::Lte => "<=",
            Self::Like => "LIKE",
            Self::NotLike => "NOT LIKE",
        }
    }

    pub const fn as_sql_str_for_prefix(&self) -> Option<&'static str> {
        match self {
            Self::Eq => Some("="),
            Self::Neq => Some("!="),
            Self::Gt | Self::Gte => Some(">="),
            Self::Lt | Self::Lte => Some("<="),
            _ => None,
        }
    }

    pub fn negate(&self) -> Self {
        match self {
            Self::Eq => Self::Neq,
            Self::Neq => Self::Eq,
            Self::Gt => Self::Lte,
            Self::Gte => Self::Lt,
            Self::Lt => Self::Gte,
            Self::Lte => Self::Gt,
            Self::Like => Self::NotLike,
            Self::NotLike => Self::Like,
        }
    }
}

#[derive(Debug, Clone, Copy, PartialEq, Eq)]
pub enum ConjunctionOp {
    And,
    Or,
}

impl ConjunctionOp {
    pub fn as_sql_str(&self) -> &'static str {
        match self {
            Self::And => " AND ",
            Self::Or => " OR ",
        }
    }

    pub fn negate(&self) -> Self {
        match self {
            Self::And => Self::Or,
            Self::Or => Self::And,
        }
    }
}

fn encode_tag_query<V, JC, E>(query: &TagQuery, enc: &mut E, negate: bool, clause_id: &str) -> Result<Option<(V, JC)>, Error>
where
    E: TagQueryEncoder<Clause = V, JoinClause = JC>,
{
    let mut new_clause_id: String = clause_id.to_owned();
    new_clause_id.push_str("_1");
    match query {
        TagQuery::Eq(tag_name, target_value) => {
            encode_tag_op(CompareOp::Eq, tag_name, target_value, enc, negate, &new_clause_id)
        }
        TagQuery::Neq(tag_name, target_value) => {
            encode_tag_op(CompareOp::Neq, tag_name, target_value, enc, negate, &new_clause_id)
        }
        TagQuery::Gt(tag_name, target_value) => {
            encode_tag_op(CompareOp::Gt, tag_name, target_value, enc, negate, &new_clause_id)
        }
        TagQuery::Gte(tag_name, target_value) => {
            encode_tag_op(CompareOp::Gte, tag_name, target_value, enc, negate, &new_clause_id)
        }
        TagQuery::Lt(tag_name, target_value) => {
            encode_tag_op(CompareOp::Lt, tag_name, target_value, enc, negate, &new_clause_id)
        }
        TagQuery::Lte(tag_name, target_value) => {
            encode_tag_op(CompareOp::Lte, tag_name, target_value, enc, negate, &new_clause_id)
        }
        TagQuery::Like(tag_name, target_value) => {
            encode_tag_op(CompareOp::Like, tag_name, target_value, enc, negate, &new_clause_id)
        }
        TagQuery::In(tag_name, target_values) => {
            encode_tag_in(tag_name, target_values, enc, negate, &new_clause_id)
        }
        TagQuery::Exist(tag_names) => encode_tag_exist(tag_names, enc, negate, &new_clause_id),
        TagQuery::And(subqueries) => encode_tag_conj(ConjunctionOp::And, subqueries, enc, negate, &new_clause_id),
        TagQuery::Or(subqueries) => encode_tag_conj(ConjunctionOp::Or, subqueries, enc, negate, &new_clause_id),
        TagQuery::Not(subquery) => encode_tag_query(subquery, enc, !negate, &new_clause_id),
    }
}

fn encode_tag_op<V, JC, E>(
    op: CompareOp,
    name: &TagName,
    value: &String,
    enc: &mut E,
    negate: bool,
    clause_id: &String,
) -> Result<Option<(V, JC)>, Error>
where
    E: TagQueryEncoder<Clause = V, JoinClause = JC>,
{
    let is_plaintext = match &name {
        TagName::Plaintext(_) => true,
        _ => false,
    };
    let enc_name = enc.encode_name(name)?;
    let enc_value = enc.encode_value(value, is_plaintext)?;
    let op = if negate { op.negate() } else { op };

    enc.encode_op_clause(op, enc_name, enc_value, is_plaintext, clause_id)
}

fn encode_tag_in<V, JC, E>(
    name: &TagName,
    values: &Vec<String>,
    enc: &mut E,
    negate: bool,
    clause_id: &str
) -> Result<Option<(V, JC)>, Error>
where
    E: TagQueryEncoder<Clause = V, JoinClause = JC>,
{
    let is_plaintext = match &name {
        TagName::Plaintext(_) => true,
        _ => false,
    };
    let enc_name = enc.encode_name(name)?;
    let enc_values = values
        .into_iter()
        .map(|val| enc.encode_value(val, is_plaintext))
        .collect::<Result<Vec<_>, Error>>()?;

    enc.encode_and_clause(enc_name, enc_values, is_plaintext, negate, clause_id)
}

fn encode_tag_exist<V, JC, E>(names: &[TagName], enc: &mut E, negate: bool, clause_id: &str) -> Result<Option<(V, JC)>, Error>
where
    E: TagQueryEncoder<Clause = V, JoinClause = JC>,
{
    match names.len() {
        0 => Ok(None),
        1 => {
            let is_plaintext = match names[0] {
                TagName::Plaintext(_) => true,
                _ => false,
            };
            let enc_name = enc.encode_name(&names[0])?;
            enc.encode_exist_clause(enc_name, is_plaintext, negate, clause_id)
        }
        n => {
            let mut cs = Vec::with_capacity(n);
            for idx in 0..n {
                if let Some((clause, join)) = encode_tag_exist(&names[idx..=idx], enc, negate, clause_id)? {
                    cs.push(clause);
                }
            }
            enc.encode_conj_clause(ConjunctionOp::And, cs, clause_id)
        }
    }
}

fn encode_tag_conj<V, JC, E>(
    op: ConjunctionOp,
    subqueries: &Vec<TagQuery>,
    enc: &mut E,
    negate: bool,
    clause_id: &str
) -> Result<Option<(V, JC)>, Error>
where
    E: TagQueryEncoder<Clause = V, JoinClause = JC>,
{
    let op = if negate { op.negate() } else { op };
    let clauses = subqueries
        .into_iter()
        .flat_map(|q| {
            // let c = encode_tag_query(q, enc, negate, clause_id).transpose();
            let (clause, join) = encode_tag_query(q, enc, negate, clause_id).unwrap().unwrap();
            Some(Ok(clause))
        })
        .collect::<Result<Vec<_>, Error>>()?;

    enc.encode_conj_clause(op, clauses, clause_id)
}

#[cfg(test)]
mod tests {
    use itertools::Itertools;

    use super::*;

    struct TestEncoder {}

    impl TagQueryEncoder for TestEncoder {
        type Arg = String;
        type Clause = String;

        fn encode_name(&mut self, name: &TagName) -> Result<String, Error> {
            Ok(name.to_string())
        }

        fn encode_value(&mut self, value: &String, _is_plaintext: bool) -> Result<String, Error> {
            Ok(value.clone())
        }

        fn encode_op_clause(
            &mut self,
            op: CompareOp,
            name: Self::Arg,
            value: Self::Arg,
            _is_plaintext: bool,
            clause_id: &str,
        ) -> Result<Option<Self::Clause>, Error> {
            Ok(Some(format!("{} {} {}", name, op.as_sql_str(), value, 1)))
        }

        fn encode_exist_clause(
            &mut self,
            name: Self::Arg,
            _is_plaintext: bool,
            negate: bool,
        ) -> Result<Option<Self::Clause>, Error> {
            let op = if negate { "NOT EXIST" } else { "EXIST" };
            Ok(Some(format!("{}({})", op, name)))
        }

        fn encode_and_clause(
            &mut self,
            name: Self::Arg,
            values: Vec<Self::Arg>,
            _is_plaintext: bool,
            negate: bool,
        ) -> Result<Option<Self::Clause>, Error> {
            let op = if negate { "AND NOT" } else { "AND" };
            let value =
                Itertools::intersperse(values.iter().map(|v| v.as_str()), ", ").collect::<String>();
            Ok(Some(format!("{} {} ({})", name, op, value)))
        }

        fn encode_conj_clause(
            &mut self,
            op: ConjunctionOp,
            clauses: Vec<Self::Clause>,
        ) -> Result<Option<Self::Clause>, Error> {
            let mut r = String::new();
            r.push_str("(");
            r.extend(Itertools::intersperse(
                clauses.iter().map(String::as_str),
                op.as_sql_str(),
            ));
            r.push_str(")");
            Ok(Some(r))
        }
    }

    #[test]
    fn test_from_query() {
        let query = Query::And(vec![
            Query::Eq("enctag".to_string(), "encval".to_string()),
            Query::Eq("~plaintag".to_string(), "plainval".to_string()),
        ]);
        let result = tag_query(query).unwrap();
        assert_eq!(
            result,
            TagQuery::And(vec![
                TagQuery::Eq(
                    TagName::Encrypted("enctag".to_string()),
                    "encval".to_string(),
                ),
                TagQuery::Eq(
                    TagName::Plaintext("plaintag".to_string()),
                    "plainval".to_string(),
                ),
            ])
        );
    }

    #[test]
    fn test_serialize() {
        let query = TagQuery::And(vec![
            TagQuery::Eq(
                TagName::Encrypted("enctag".to_string()),
                "encval".to_string(),
            ),
            TagQuery::Eq(
                TagName::Plaintext("plaintag".to_string()),
                "plainval".to_string(),
            ),
        ]);
        let result = serde_json::to_string(&query).unwrap();
        assert_eq!(
            result,
            r#"{"$and":[{"enctag":"encval"},{"~plaintag":"plainval"}]}"#
        );
    }

    #[test]
    fn test_simple_and() {
        let condition_1 = TagQuery::And(vec![
            TagQuery::Eq(
                TagName::Encrypted("enctag".to_string()),
                "encval".to_string(),
            ),
            TagQuery::Eq(
                TagName::Plaintext("plaintag".to_string()),
                "plainval".to_string(),
            ),
        ]);
        let condition_2 = TagQuery::And(vec![
            TagQuery::Eq(
                TagName::Encrypted("enctag".to_string()),
                "encval".to_string(),
            ),
            TagQuery::Not(Box::new(TagQuery::Eq(
                TagName::Plaintext("plaintag".to_string()),
                "eggs".to_string(),
            ))),
        ]);
        let query = TagQuery::Or(vec![condition_1, condition_2]);
        let query_str = TestEncoder {}.encode_query(&query).unwrap().unwrap();
        assert_eq!(query_str, "((enctag = encval AND ~plaintag = plainval) OR (enctag = encval AND ~plaintag != eggs))")
    }

    #[test]
    fn test_negate_conj() {
        let condition_1 = TagQuery::And(vec![
            TagQuery::Eq(
                TagName::Encrypted("enctag".to_string()),
                "encval".to_string(),
            ),
            TagQuery::Eq(
                TagName::Plaintext("plaintag".to_string()),
                "plainval".to_string(),
            ),
        ]);
        let condition_2 = TagQuery::And(vec![
            TagQuery::Eq(
                TagName::Encrypted("enctag".to_string()),
                "encval".to_string(),
            ),
            TagQuery::Not(Box::new(TagQuery::Eq(
                TagName::Plaintext("plaintag".to_string()),
                "eggs".to_string(),
            ))),
        ]);
        let query = TagQuery::Not(Box::new(TagQuery::Or(vec![condition_1, condition_2])));
        let query_str = TestEncoder {}.encode_query(&query).unwrap().unwrap();
        assert_eq!(query_str, "((enctag != encval OR ~plaintag != plainval) AND (enctag != encval OR ~plaintag = eggs))")
    }
}
