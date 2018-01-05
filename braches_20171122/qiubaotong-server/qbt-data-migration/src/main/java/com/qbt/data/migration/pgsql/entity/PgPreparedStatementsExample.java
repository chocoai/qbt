package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PgPreparedStatementsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgPreparedStatementsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andStatementIsNull() {
            addCriterion("statement is null");
            return (Criteria) this;
        }

        public Criteria andStatementIsNotNull() {
            addCriterion("statement is not null");
            return (Criteria) this;
        }

        public Criteria andStatementEqualTo(String value) {
            addCriterion("statement =", value, "statement");
            return (Criteria) this;
        }

        public Criteria andStatementNotEqualTo(String value) {
            addCriterion("statement <>", value, "statement");
            return (Criteria) this;
        }

        public Criteria andStatementGreaterThan(String value) {
            addCriterion("statement >", value, "statement");
            return (Criteria) this;
        }

        public Criteria andStatementGreaterThanOrEqualTo(String value) {
            addCriterion("statement >=", value, "statement");
            return (Criteria) this;
        }

        public Criteria andStatementLessThan(String value) {
            addCriterion("statement <", value, "statement");
            return (Criteria) this;
        }

        public Criteria andStatementLessThanOrEqualTo(String value) {
            addCriterion("statement <=", value, "statement");
            return (Criteria) this;
        }

        public Criteria andStatementLike(String value) {
            addCriterion("statement like", value, "statement");
            return (Criteria) this;
        }

        public Criteria andStatementNotLike(String value) {
            addCriterion("statement not like", value, "statement");
            return (Criteria) this;
        }

        public Criteria andStatementIn(List<String> values) {
            addCriterion("statement in", values, "statement");
            return (Criteria) this;
        }

        public Criteria andStatementNotIn(List<String> values) {
            addCriterion("statement not in", values, "statement");
            return (Criteria) this;
        }

        public Criteria andStatementBetween(String value1, String value2) {
            addCriterion("statement between", value1, value2, "statement");
            return (Criteria) this;
        }

        public Criteria andStatementNotBetween(String value1, String value2) {
            addCriterion("statement not between", value1, value2, "statement");
            return (Criteria) this;
        }

        public Criteria andPrepare_timeIsNull() {
            addCriterion("prepare_time is null");
            return (Criteria) this;
        }

        public Criteria andPrepare_timeIsNotNull() {
            addCriterion("prepare_time is not null");
            return (Criteria) this;
        }

        public Criteria andPrepare_timeEqualTo(Date value) {
            addCriterion("prepare_time =", value, "prepare_time");
            return (Criteria) this;
        }

        public Criteria andPrepare_timeNotEqualTo(Date value) {
            addCriterion("prepare_time <>", value, "prepare_time");
            return (Criteria) this;
        }

        public Criteria andPrepare_timeGreaterThan(Date value) {
            addCriterion("prepare_time >", value, "prepare_time");
            return (Criteria) this;
        }

        public Criteria andPrepare_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("prepare_time >=", value, "prepare_time");
            return (Criteria) this;
        }

        public Criteria andPrepare_timeLessThan(Date value) {
            addCriterion("prepare_time <", value, "prepare_time");
            return (Criteria) this;
        }

        public Criteria andPrepare_timeLessThanOrEqualTo(Date value) {
            addCriterion("prepare_time <=", value, "prepare_time");
            return (Criteria) this;
        }

        public Criteria andPrepare_timeIn(List<Date> values) {
            addCriterion("prepare_time in", values, "prepare_time");
            return (Criteria) this;
        }

        public Criteria andPrepare_timeNotIn(List<Date> values) {
            addCriterion("prepare_time not in", values, "prepare_time");
            return (Criteria) this;
        }

        public Criteria andPrepare_timeBetween(Date value1, Date value2) {
            addCriterion("prepare_time between", value1, value2, "prepare_time");
            return (Criteria) this;
        }

        public Criteria andPrepare_timeNotBetween(Date value1, Date value2) {
            addCriterion("prepare_time not between", value1, value2, "prepare_time");
            return (Criteria) this;
        }

        public Criteria andParameter_typesIsNull() {
            addCriterion("parameter_types is null");
            return (Criteria) this;
        }

        public Criteria andParameter_typesIsNotNull() {
            addCriterion("parameter_types is not null");
            return (Criteria) this;
        }

        public Criteria andParameter_typesEqualTo(Object value) {
            addCriterion("parameter_types =", value, "parameter_types");
            return (Criteria) this;
        }

        public Criteria andParameter_typesNotEqualTo(Object value) {
            addCriterion("parameter_types <>", value, "parameter_types");
            return (Criteria) this;
        }

        public Criteria andParameter_typesGreaterThan(Object value) {
            addCriterion("parameter_types >", value, "parameter_types");
            return (Criteria) this;
        }

        public Criteria andParameter_typesGreaterThanOrEqualTo(Object value) {
            addCriterion("parameter_types >=", value, "parameter_types");
            return (Criteria) this;
        }

        public Criteria andParameter_typesLessThan(Object value) {
            addCriterion("parameter_types <", value, "parameter_types");
            return (Criteria) this;
        }

        public Criteria andParameter_typesLessThanOrEqualTo(Object value) {
            addCriterion("parameter_types <=", value, "parameter_types");
            return (Criteria) this;
        }

        public Criteria andParameter_typesIn(List<Object> values) {
            addCriterion("parameter_types in", values, "parameter_types");
            return (Criteria) this;
        }

        public Criteria andParameter_typesNotIn(List<Object> values) {
            addCriterion("parameter_types not in", values, "parameter_types");
            return (Criteria) this;
        }

        public Criteria andParameter_typesBetween(Object value1, Object value2) {
            addCriterion("parameter_types between", value1, value2, "parameter_types");
            return (Criteria) this;
        }

        public Criteria andParameter_typesNotBetween(Object value1, Object value2) {
            addCriterion("parameter_types not between", value1, value2, "parameter_types");
            return (Criteria) this;
        }

        public Criteria andFrom_sqlIsNull() {
            addCriterion("from_sql is null");
            return (Criteria) this;
        }

        public Criteria andFrom_sqlIsNotNull() {
            addCriterion("from_sql is not null");
            return (Criteria) this;
        }

        public Criteria andFrom_sqlEqualTo(Boolean value) {
            addCriterion("from_sql =", value, "from_sql");
            return (Criteria) this;
        }

        public Criteria andFrom_sqlNotEqualTo(Boolean value) {
            addCriterion("from_sql <>", value, "from_sql");
            return (Criteria) this;
        }

        public Criteria andFrom_sqlGreaterThan(Boolean value) {
            addCriterion("from_sql >", value, "from_sql");
            return (Criteria) this;
        }

        public Criteria andFrom_sqlGreaterThanOrEqualTo(Boolean value) {
            addCriterion("from_sql >=", value, "from_sql");
            return (Criteria) this;
        }

        public Criteria andFrom_sqlLessThan(Boolean value) {
            addCriterion("from_sql <", value, "from_sql");
            return (Criteria) this;
        }

        public Criteria andFrom_sqlLessThanOrEqualTo(Boolean value) {
            addCriterion("from_sql <=", value, "from_sql");
            return (Criteria) this;
        }

        public Criteria andFrom_sqlIn(List<Boolean> values) {
            addCriterion("from_sql in", values, "from_sql");
            return (Criteria) this;
        }

        public Criteria andFrom_sqlNotIn(List<Boolean> values) {
            addCriterion("from_sql not in", values, "from_sql");
            return (Criteria) this;
        }

        public Criteria andFrom_sqlBetween(Boolean value1, Boolean value2) {
            addCriterion("from_sql between", value1, value2, "from_sql");
            return (Criteria) this;
        }

        public Criteria andFrom_sqlNotBetween(Boolean value1, Boolean value2) {
            addCriterion("from_sql not between", value1, value2, "from_sql");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}