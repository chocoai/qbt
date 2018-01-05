package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgViewsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgViewsExample() {
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

        public Criteria andViewnameIsNull() {
            addCriterion("viewname is null");
            return (Criteria) this;
        }

        public Criteria andViewnameIsNotNull() {
            addCriterion("viewname is not null");
            return (Criteria) this;
        }

        public Criteria andViewnameEqualTo(String value) {
            addCriterion("viewname =", value, "viewname");
            return (Criteria) this;
        }

        public Criteria andViewnameNotEqualTo(String value) {
            addCriterion("viewname <>", value, "viewname");
            return (Criteria) this;
        }

        public Criteria andViewnameGreaterThan(String value) {
            addCriterion("viewname >", value, "viewname");
            return (Criteria) this;
        }

        public Criteria andViewnameGreaterThanOrEqualTo(String value) {
            addCriterion("viewname >=", value, "viewname");
            return (Criteria) this;
        }

        public Criteria andViewnameLessThan(String value) {
            addCriterion("viewname <", value, "viewname");
            return (Criteria) this;
        }

        public Criteria andViewnameLessThanOrEqualTo(String value) {
            addCriterion("viewname <=", value, "viewname");
            return (Criteria) this;
        }

        public Criteria andViewnameLike(String value) {
            addCriterion("viewname like", value, "viewname");
            return (Criteria) this;
        }

        public Criteria andViewnameNotLike(String value) {
            addCriterion("viewname not like", value, "viewname");
            return (Criteria) this;
        }

        public Criteria andViewnameIn(List<String> values) {
            addCriterion("viewname in", values, "viewname");
            return (Criteria) this;
        }

        public Criteria andViewnameNotIn(List<String> values) {
            addCriterion("viewname not in", values, "viewname");
            return (Criteria) this;
        }

        public Criteria andViewnameBetween(String value1, String value2) {
            addCriterion("viewname between", value1, value2, "viewname");
            return (Criteria) this;
        }

        public Criteria andViewnameNotBetween(String value1, String value2) {
            addCriterion("viewname not between", value1, value2, "viewname");
            return (Criteria) this;
        }

        public Criteria andViewownerIsNull() {
            addCriterion("viewowner is null");
            return (Criteria) this;
        }

        public Criteria andViewownerIsNotNull() {
            addCriterion("viewowner is not null");
            return (Criteria) this;
        }

        public Criteria andViewownerEqualTo(String value) {
            addCriterion("viewowner =", value, "viewowner");
            return (Criteria) this;
        }

        public Criteria andViewownerNotEqualTo(String value) {
            addCriterion("viewowner <>", value, "viewowner");
            return (Criteria) this;
        }

        public Criteria andViewownerGreaterThan(String value) {
            addCriterion("viewowner >", value, "viewowner");
            return (Criteria) this;
        }

        public Criteria andViewownerGreaterThanOrEqualTo(String value) {
            addCriterion("viewowner >=", value, "viewowner");
            return (Criteria) this;
        }

        public Criteria andViewownerLessThan(String value) {
            addCriterion("viewowner <", value, "viewowner");
            return (Criteria) this;
        }

        public Criteria andViewownerLessThanOrEqualTo(String value) {
            addCriterion("viewowner <=", value, "viewowner");
            return (Criteria) this;
        }

        public Criteria andViewownerLike(String value) {
            addCriterion("viewowner like", value, "viewowner");
            return (Criteria) this;
        }

        public Criteria andViewownerNotLike(String value) {
            addCriterion("viewowner not like", value, "viewowner");
            return (Criteria) this;
        }

        public Criteria andViewownerIn(List<String> values) {
            addCriterion("viewowner in", values, "viewowner");
            return (Criteria) this;
        }

        public Criteria andViewownerNotIn(List<String> values) {
            addCriterion("viewowner not in", values, "viewowner");
            return (Criteria) this;
        }

        public Criteria andViewownerBetween(String value1, String value2) {
            addCriterion("viewowner between", value1, value2, "viewowner");
            return (Criteria) this;
        }

        public Criteria andViewownerNotBetween(String value1, String value2) {
            addCriterion("viewowner not between", value1, value2, "viewowner");
            return (Criteria) this;
        }

        public Criteria andDefinitionIsNull() {
            addCriterion("definition is null");
            return (Criteria) this;
        }

        public Criteria andDefinitionIsNotNull() {
            addCriterion("definition is not null");
            return (Criteria) this;
        }

        public Criteria andDefinitionEqualTo(String value) {
            addCriterion("definition =", value, "definition");
            return (Criteria) this;
        }

        public Criteria andDefinitionNotEqualTo(String value) {
            addCriterion("definition <>", value, "definition");
            return (Criteria) this;
        }

        public Criteria andDefinitionGreaterThan(String value) {
            addCriterion("definition >", value, "definition");
            return (Criteria) this;
        }

        public Criteria andDefinitionGreaterThanOrEqualTo(String value) {
            addCriterion("definition >=", value, "definition");
            return (Criteria) this;
        }

        public Criteria andDefinitionLessThan(String value) {
            addCriterion("definition <", value, "definition");
            return (Criteria) this;
        }

        public Criteria andDefinitionLessThanOrEqualTo(String value) {
            addCriterion("definition <=", value, "definition");
            return (Criteria) this;
        }

        public Criteria andDefinitionLike(String value) {
            addCriterion("definition like", value, "definition");
            return (Criteria) this;
        }

        public Criteria andDefinitionNotLike(String value) {
            addCriterion("definition not like", value, "definition");
            return (Criteria) this;
        }

        public Criteria andDefinitionIn(List<String> values) {
            addCriterion("definition in", values, "definition");
            return (Criteria) this;
        }

        public Criteria andDefinitionNotIn(List<String> values) {
            addCriterion("definition not in", values, "definition");
            return (Criteria) this;
        }

        public Criteria andDefinitionBetween(String value1, String value2) {
            addCriterion("definition between", value1, value2, "definition");
            return (Criteria) this;
        }

        public Criteria andDefinitionNotBetween(String value1, String value2) {
            addCriterion("definition not between", value1, value2, "definition");
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