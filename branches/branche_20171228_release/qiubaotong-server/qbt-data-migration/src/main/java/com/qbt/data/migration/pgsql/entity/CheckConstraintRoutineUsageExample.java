package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class CheckConstraintRoutineUsageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CheckConstraintRoutineUsageExample() {
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

        public Criteria andConstraint_catalogIsNull() {
            addCriterion("constraint_catalog is null");
            return (Criteria) this;
        }

        public Criteria andConstraint_catalogIsNotNull() {
            addCriterion("constraint_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andConstraint_catalogEqualTo(Object value) {
            addCriterion("constraint_catalog =", value, "constraint_catalog");
            return (Criteria) this;
        }

        public Criteria andConstraint_catalogNotEqualTo(Object value) {
            addCriterion("constraint_catalog <>", value, "constraint_catalog");
            return (Criteria) this;
        }

        public Criteria andConstraint_catalogGreaterThan(Object value) {
            addCriterion("constraint_catalog >", value, "constraint_catalog");
            return (Criteria) this;
        }

        public Criteria andConstraint_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("constraint_catalog >=", value, "constraint_catalog");
            return (Criteria) this;
        }

        public Criteria andConstraint_catalogLessThan(Object value) {
            addCriterion("constraint_catalog <", value, "constraint_catalog");
            return (Criteria) this;
        }

        public Criteria andConstraint_catalogLessThanOrEqualTo(Object value) {
            addCriterion("constraint_catalog <=", value, "constraint_catalog");
            return (Criteria) this;
        }

        public Criteria andConstraint_catalogIn(List<Object> values) {
            addCriterion("constraint_catalog in", values, "constraint_catalog");
            return (Criteria) this;
        }

        public Criteria andConstraint_catalogNotIn(List<Object> values) {
            addCriterion("constraint_catalog not in", values, "constraint_catalog");
            return (Criteria) this;
        }

        public Criteria andConstraint_catalogBetween(Object value1, Object value2) {
            addCriterion("constraint_catalog between", value1, value2, "constraint_catalog");
            return (Criteria) this;
        }

        public Criteria andConstraint_catalogNotBetween(Object value1, Object value2) {
            addCriterion("constraint_catalog not between", value1, value2, "constraint_catalog");
            return (Criteria) this;
        }

        public Criteria andConstraint_schemaIsNull() {
            addCriterion("constraint_schema is null");
            return (Criteria) this;
        }

        public Criteria andConstraint_schemaIsNotNull() {
            addCriterion("constraint_schema is not null");
            return (Criteria) this;
        }

        public Criteria andConstraint_schemaEqualTo(Object value) {
            addCriterion("constraint_schema =", value, "constraint_schema");
            return (Criteria) this;
        }

        public Criteria andConstraint_schemaNotEqualTo(Object value) {
            addCriterion("constraint_schema <>", value, "constraint_schema");
            return (Criteria) this;
        }

        public Criteria andConstraint_schemaGreaterThan(Object value) {
            addCriterion("constraint_schema >", value, "constraint_schema");
            return (Criteria) this;
        }

        public Criteria andConstraint_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("constraint_schema >=", value, "constraint_schema");
            return (Criteria) this;
        }

        public Criteria andConstraint_schemaLessThan(Object value) {
            addCriterion("constraint_schema <", value, "constraint_schema");
            return (Criteria) this;
        }

        public Criteria andConstraint_schemaLessThanOrEqualTo(Object value) {
            addCriterion("constraint_schema <=", value, "constraint_schema");
            return (Criteria) this;
        }

        public Criteria andConstraint_schemaIn(List<Object> values) {
            addCriterion("constraint_schema in", values, "constraint_schema");
            return (Criteria) this;
        }

        public Criteria andConstraint_schemaNotIn(List<Object> values) {
            addCriterion("constraint_schema not in", values, "constraint_schema");
            return (Criteria) this;
        }

        public Criteria andConstraint_schemaBetween(Object value1, Object value2) {
            addCriterion("constraint_schema between", value1, value2, "constraint_schema");
            return (Criteria) this;
        }

        public Criteria andConstraint_schemaNotBetween(Object value1, Object value2) {
            addCriterion("constraint_schema not between", value1, value2, "constraint_schema");
            return (Criteria) this;
        }

        public Criteria andConstraint_nameIsNull() {
            addCriterion("constraint_name is null");
            return (Criteria) this;
        }

        public Criteria andConstraint_nameIsNotNull() {
            addCriterion("constraint_name is not null");
            return (Criteria) this;
        }

        public Criteria andConstraint_nameEqualTo(Object value) {
            addCriterion("constraint_name =", value, "constraint_name");
            return (Criteria) this;
        }

        public Criteria andConstraint_nameNotEqualTo(Object value) {
            addCriterion("constraint_name <>", value, "constraint_name");
            return (Criteria) this;
        }

        public Criteria andConstraint_nameGreaterThan(Object value) {
            addCriterion("constraint_name >", value, "constraint_name");
            return (Criteria) this;
        }

        public Criteria andConstraint_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("constraint_name >=", value, "constraint_name");
            return (Criteria) this;
        }

        public Criteria andConstraint_nameLessThan(Object value) {
            addCriterion("constraint_name <", value, "constraint_name");
            return (Criteria) this;
        }

        public Criteria andConstraint_nameLessThanOrEqualTo(Object value) {
            addCriterion("constraint_name <=", value, "constraint_name");
            return (Criteria) this;
        }

        public Criteria andConstraint_nameIn(List<Object> values) {
            addCriterion("constraint_name in", values, "constraint_name");
            return (Criteria) this;
        }

        public Criteria andConstraint_nameNotIn(List<Object> values) {
            addCriterion("constraint_name not in", values, "constraint_name");
            return (Criteria) this;
        }

        public Criteria andConstraint_nameBetween(Object value1, Object value2) {
            addCriterion("constraint_name between", value1, value2, "constraint_name");
            return (Criteria) this;
        }

        public Criteria andConstraint_nameNotBetween(Object value1, Object value2) {
            addCriterion("constraint_name not between", value1, value2, "constraint_name");
            return (Criteria) this;
        }

        public Criteria andSpecific_catalogIsNull() {
            addCriterion("specific_catalog is null");
            return (Criteria) this;
        }

        public Criteria andSpecific_catalogIsNotNull() {
            addCriterion("specific_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andSpecific_catalogEqualTo(Object value) {
            addCriterion("specific_catalog =", value, "specific_catalog");
            return (Criteria) this;
        }

        public Criteria andSpecific_catalogNotEqualTo(Object value) {
            addCriterion("specific_catalog <>", value, "specific_catalog");
            return (Criteria) this;
        }

        public Criteria andSpecific_catalogGreaterThan(Object value) {
            addCriterion("specific_catalog >", value, "specific_catalog");
            return (Criteria) this;
        }

        public Criteria andSpecific_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("specific_catalog >=", value, "specific_catalog");
            return (Criteria) this;
        }

        public Criteria andSpecific_catalogLessThan(Object value) {
            addCriterion("specific_catalog <", value, "specific_catalog");
            return (Criteria) this;
        }

        public Criteria andSpecific_catalogLessThanOrEqualTo(Object value) {
            addCriterion("specific_catalog <=", value, "specific_catalog");
            return (Criteria) this;
        }

        public Criteria andSpecific_catalogIn(List<Object> values) {
            addCriterion("specific_catalog in", values, "specific_catalog");
            return (Criteria) this;
        }

        public Criteria andSpecific_catalogNotIn(List<Object> values) {
            addCriterion("specific_catalog not in", values, "specific_catalog");
            return (Criteria) this;
        }

        public Criteria andSpecific_catalogBetween(Object value1, Object value2) {
            addCriterion("specific_catalog between", value1, value2, "specific_catalog");
            return (Criteria) this;
        }

        public Criteria andSpecific_catalogNotBetween(Object value1, Object value2) {
            addCriterion("specific_catalog not between", value1, value2, "specific_catalog");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaIsNull() {
            addCriterion("specific_schema is null");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaIsNotNull() {
            addCriterion("specific_schema is not null");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaEqualTo(Object value) {
            addCriterion("specific_schema =", value, "specific_schema");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaNotEqualTo(Object value) {
            addCriterion("specific_schema <>", value, "specific_schema");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaGreaterThan(Object value) {
            addCriterion("specific_schema >", value, "specific_schema");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("specific_schema >=", value, "specific_schema");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaLessThan(Object value) {
            addCriterion("specific_schema <", value, "specific_schema");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaLessThanOrEqualTo(Object value) {
            addCriterion("specific_schema <=", value, "specific_schema");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaIn(List<Object> values) {
            addCriterion("specific_schema in", values, "specific_schema");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaNotIn(List<Object> values) {
            addCriterion("specific_schema not in", values, "specific_schema");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaBetween(Object value1, Object value2) {
            addCriterion("specific_schema between", value1, value2, "specific_schema");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaNotBetween(Object value1, Object value2) {
            addCriterion("specific_schema not between", value1, value2, "specific_schema");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameIsNull() {
            addCriterion("specific_name is null");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameIsNotNull() {
            addCriterion("specific_name is not null");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameEqualTo(Object value) {
            addCriterion("specific_name =", value, "specific_name");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameNotEqualTo(Object value) {
            addCriterion("specific_name <>", value, "specific_name");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameGreaterThan(Object value) {
            addCriterion("specific_name >", value, "specific_name");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("specific_name >=", value, "specific_name");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameLessThan(Object value) {
            addCriterion("specific_name <", value, "specific_name");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameLessThanOrEqualTo(Object value) {
            addCriterion("specific_name <=", value, "specific_name");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameIn(List<Object> values) {
            addCriterion("specific_name in", values, "specific_name");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameNotIn(List<Object> values) {
            addCriterion("specific_name not in", values, "specific_name");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameBetween(Object value1, Object value2) {
            addCriterion("specific_name between", value1, value2, "specific_name");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameNotBetween(Object value1, Object value2) {
            addCriterion("specific_name not between", value1, value2, "specific_name");
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