package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgIndexesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgIndexesExample() {
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

        public Criteria andSchemanameIsNull() {
            addCriterion("schemaname is null");
            return (Criteria) this;
        }

        public Criteria andSchemanameIsNotNull() {
            addCriterion("schemaname is not null");
            return (Criteria) this;
        }

        public Criteria andSchemanameEqualTo(String value) {
            addCriterion("schemaname =", value, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameNotEqualTo(String value) {
            addCriterion("schemaname <>", value, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameGreaterThan(String value) {
            addCriterion("schemaname >", value, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameGreaterThanOrEqualTo(String value) {
            addCriterion("schemaname >=", value, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameLessThan(String value) {
            addCriterion("schemaname <", value, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameLessThanOrEqualTo(String value) {
            addCriterion("schemaname <=", value, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameLike(String value) {
            addCriterion("schemaname like", value, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameNotLike(String value) {
            addCriterion("schemaname not like", value, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameIn(List<String> values) {
            addCriterion("schemaname in", values, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameNotIn(List<String> values) {
            addCriterion("schemaname not in", values, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameBetween(String value1, String value2) {
            addCriterion("schemaname between", value1, value2, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameNotBetween(String value1, String value2) {
            addCriterion("schemaname not between", value1, value2, "schemaname");
            return (Criteria) this;
        }

        public Criteria andTablenameIsNull() {
            addCriterion("tablename is null");
            return (Criteria) this;
        }

        public Criteria andTablenameIsNotNull() {
            addCriterion("tablename is not null");
            return (Criteria) this;
        }

        public Criteria andTablenameEqualTo(String value) {
            addCriterion("tablename =", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotEqualTo(String value) {
            addCriterion("tablename <>", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameGreaterThan(String value) {
            addCriterion("tablename >", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameGreaterThanOrEqualTo(String value) {
            addCriterion("tablename >=", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLessThan(String value) {
            addCriterion("tablename <", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLessThanOrEqualTo(String value) {
            addCriterion("tablename <=", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLike(String value) {
            addCriterion("tablename like", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotLike(String value) {
            addCriterion("tablename not like", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameIn(List<String> values) {
            addCriterion("tablename in", values, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotIn(List<String> values) {
            addCriterion("tablename not in", values, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameBetween(String value1, String value2) {
            addCriterion("tablename between", value1, value2, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotBetween(String value1, String value2) {
            addCriterion("tablename not between", value1, value2, "tablename");
            return (Criteria) this;
        }

        public Criteria andIndexnameIsNull() {
            addCriterion("indexname is null");
            return (Criteria) this;
        }

        public Criteria andIndexnameIsNotNull() {
            addCriterion("indexname is not null");
            return (Criteria) this;
        }

        public Criteria andIndexnameEqualTo(String value) {
            addCriterion("indexname =", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameNotEqualTo(String value) {
            addCriterion("indexname <>", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameGreaterThan(String value) {
            addCriterion("indexname >", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameGreaterThanOrEqualTo(String value) {
            addCriterion("indexname >=", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameLessThan(String value) {
            addCriterion("indexname <", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameLessThanOrEqualTo(String value) {
            addCriterion("indexname <=", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameLike(String value) {
            addCriterion("indexname like", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameNotLike(String value) {
            addCriterion("indexname not like", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameIn(List<String> values) {
            addCriterion("indexname in", values, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameNotIn(List<String> values) {
            addCriterion("indexname not in", values, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameBetween(String value1, String value2) {
            addCriterion("indexname between", value1, value2, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameNotBetween(String value1, String value2) {
            addCriterion("indexname not between", value1, value2, "indexname");
            return (Criteria) this;
        }

        public Criteria andTablespaceIsNull() {
            addCriterion("tablespace is null");
            return (Criteria) this;
        }

        public Criteria andTablespaceIsNotNull() {
            addCriterion("tablespace is not null");
            return (Criteria) this;
        }

        public Criteria andTablespaceEqualTo(String value) {
            addCriterion("tablespace =", value, "tablespace");
            return (Criteria) this;
        }

        public Criteria andTablespaceNotEqualTo(String value) {
            addCriterion("tablespace <>", value, "tablespace");
            return (Criteria) this;
        }

        public Criteria andTablespaceGreaterThan(String value) {
            addCriterion("tablespace >", value, "tablespace");
            return (Criteria) this;
        }

        public Criteria andTablespaceGreaterThanOrEqualTo(String value) {
            addCriterion("tablespace >=", value, "tablespace");
            return (Criteria) this;
        }

        public Criteria andTablespaceLessThan(String value) {
            addCriterion("tablespace <", value, "tablespace");
            return (Criteria) this;
        }

        public Criteria andTablespaceLessThanOrEqualTo(String value) {
            addCriterion("tablespace <=", value, "tablespace");
            return (Criteria) this;
        }

        public Criteria andTablespaceLike(String value) {
            addCriterion("tablespace like", value, "tablespace");
            return (Criteria) this;
        }

        public Criteria andTablespaceNotLike(String value) {
            addCriterion("tablespace not like", value, "tablespace");
            return (Criteria) this;
        }

        public Criteria andTablespaceIn(List<String> values) {
            addCriterion("tablespace in", values, "tablespace");
            return (Criteria) this;
        }

        public Criteria andTablespaceNotIn(List<String> values) {
            addCriterion("tablespace not in", values, "tablespace");
            return (Criteria) this;
        }

        public Criteria andTablespaceBetween(String value1, String value2) {
            addCriterion("tablespace between", value1, value2, "tablespace");
            return (Criteria) this;
        }

        public Criteria andTablespaceNotBetween(String value1, String value2) {
            addCriterion("tablespace not between", value1, value2, "tablespace");
            return (Criteria) this;
        }

        public Criteria andIndexdefIsNull() {
            addCriterion("indexdef is null");
            return (Criteria) this;
        }

        public Criteria andIndexdefIsNotNull() {
            addCriterion("indexdef is not null");
            return (Criteria) this;
        }

        public Criteria andIndexdefEqualTo(String value) {
            addCriterion("indexdef =", value, "indexdef");
            return (Criteria) this;
        }

        public Criteria andIndexdefNotEqualTo(String value) {
            addCriterion("indexdef <>", value, "indexdef");
            return (Criteria) this;
        }

        public Criteria andIndexdefGreaterThan(String value) {
            addCriterion("indexdef >", value, "indexdef");
            return (Criteria) this;
        }

        public Criteria andIndexdefGreaterThanOrEqualTo(String value) {
            addCriterion("indexdef >=", value, "indexdef");
            return (Criteria) this;
        }

        public Criteria andIndexdefLessThan(String value) {
            addCriterion("indexdef <", value, "indexdef");
            return (Criteria) this;
        }

        public Criteria andIndexdefLessThanOrEqualTo(String value) {
            addCriterion("indexdef <=", value, "indexdef");
            return (Criteria) this;
        }

        public Criteria andIndexdefLike(String value) {
            addCriterion("indexdef like", value, "indexdef");
            return (Criteria) this;
        }

        public Criteria andIndexdefNotLike(String value) {
            addCriterion("indexdef not like", value, "indexdef");
            return (Criteria) this;
        }

        public Criteria andIndexdefIn(List<String> values) {
            addCriterion("indexdef in", values, "indexdef");
            return (Criteria) this;
        }

        public Criteria andIndexdefNotIn(List<String> values) {
            addCriterion("indexdef not in", values, "indexdef");
            return (Criteria) this;
        }

        public Criteria andIndexdefBetween(String value1, String value2) {
            addCriterion("indexdef between", value1, value2, "indexdef");
            return (Criteria) this;
        }

        public Criteria andIndexdefNotBetween(String value1, String value2) {
            addCriterion("indexdef not between", value1, value2, "indexdef");
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