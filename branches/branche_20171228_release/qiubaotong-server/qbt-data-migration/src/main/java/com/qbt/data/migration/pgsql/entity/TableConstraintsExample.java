package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class TableConstraintsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TableConstraintsExample() {
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

        public Criteria andTable_catalogIsNull() {
            addCriterion("table_catalog is null");
            return (Criteria) this;
        }

        public Criteria andTable_catalogIsNotNull() {
            addCriterion("table_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andTable_catalogEqualTo(Object value) {
            addCriterion("table_catalog =", value, "table_catalog");
            return (Criteria) this;
        }

        public Criteria andTable_catalogNotEqualTo(Object value) {
            addCriterion("table_catalog <>", value, "table_catalog");
            return (Criteria) this;
        }

        public Criteria andTable_catalogGreaterThan(Object value) {
            addCriterion("table_catalog >", value, "table_catalog");
            return (Criteria) this;
        }

        public Criteria andTable_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("table_catalog >=", value, "table_catalog");
            return (Criteria) this;
        }

        public Criteria andTable_catalogLessThan(Object value) {
            addCriterion("table_catalog <", value, "table_catalog");
            return (Criteria) this;
        }

        public Criteria andTable_catalogLessThanOrEqualTo(Object value) {
            addCriterion("table_catalog <=", value, "table_catalog");
            return (Criteria) this;
        }

        public Criteria andTable_catalogIn(List<Object> values) {
            addCriterion("table_catalog in", values, "table_catalog");
            return (Criteria) this;
        }

        public Criteria andTable_catalogNotIn(List<Object> values) {
            addCriterion("table_catalog not in", values, "table_catalog");
            return (Criteria) this;
        }

        public Criteria andTable_catalogBetween(Object value1, Object value2) {
            addCriterion("table_catalog between", value1, value2, "table_catalog");
            return (Criteria) this;
        }

        public Criteria andTable_catalogNotBetween(Object value1, Object value2) {
            addCriterion("table_catalog not between", value1, value2, "table_catalog");
            return (Criteria) this;
        }

        public Criteria andTable_schemaIsNull() {
            addCriterion("table_schema is null");
            return (Criteria) this;
        }

        public Criteria andTable_schemaIsNotNull() {
            addCriterion("table_schema is not null");
            return (Criteria) this;
        }

        public Criteria andTable_schemaEqualTo(Object value) {
            addCriterion("table_schema =", value, "table_schema");
            return (Criteria) this;
        }

        public Criteria andTable_schemaNotEqualTo(Object value) {
            addCriterion("table_schema <>", value, "table_schema");
            return (Criteria) this;
        }

        public Criteria andTable_schemaGreaterThan(Object value) {
            addCriterion("table_schema >", value, "table_schema");
            return (Criteria) this;
        }

        public Criteria andTable_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("table_schema >=", value, "table_schema");
            return (Criteria) this;
        }

        public Criteria andTable_schemaLessThan(Object value) {
            addCriterion("table_schema <", value, "table_schema");
            return (Criteria) this;
        }

        public Criteria andTable_schemaLessThanOrEqualTo(Object value) {
            addCriterion("table_schema <=", value, "table_schema");
            return (Criteria) this;
        }

        public Criteria andTable_schemaIn(List<Object> values) {
            addCriterion("table_schema in", values, "table_schema");
            return (Criteria) this;
        }

        public Criteria andTable_schemaNotIn(List<Object> values) {
            addCriterion("table_schema not in", values, "table_schema");
            return (Criteria) this;
        }

        public Criteria andTable_schemaBetween(Object value1, Object value2) {
            addCriterion("table_schema between", value1, value2, "table_schema");
            return (Criteria) this;
        }

        public Criteria andTable_schemaNotBetween(Object value1, Object value2) {
            addCriterion("table_schema not between", value1, value2, "table_schema");
            return (Criteria) this;
        }

        public Criteria andTable_nameIsNull() {
            addCriterion("table_name is null");
            return (Criteria) this;
        }

        public Criteria andTable_nameIsNotNull() {
            addCriterion("table_name is not null");
            return (Criteria) this;
        }

        public Criteria andTable_nameEqualTo(Object value) {
            addCriterion("table_name =", value, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameNotEqualTo(Object value) {
            addCriterion("table_name <>", value, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameGreaterThan(Object value) {
            addCriterion("table_name >", value, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("table_name >=", value, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameLessThan(Object value) {
            addCriterion("table_name <", value, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameLessThanOrEqualTo(Object value) {
            addCriterion("table_name <=", value, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameIn(List<Object> values) {
            addCriterion("table_name in", values, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameNotIn(List<Object> values) {
            addCriterion("table_name not in", values, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameBetween(Object value1, Object value2) {
            addCriterion("table_name between", value1, value2, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameNotBetween(Object value1, Object value2) {
            addCriterion("table_name not between", value1, value2, "table_name");
            return (Criteria) this;
        }

        public Criteria andConstraint_typeIsNull() {
            addCriterion("constraint_type is null");
            return (Criteria) this;
        }

        public Criteria andConstraint_typeIsNotNull() {
            addCriterion("constraint_type is not null");
            return (Criteria) this;
        }

        public Criteria andConstraint_typeEqualTo(Object value) {
            addCriterion("constraint_type =", value, "constraint_type");
            return (Criteria) this;
        }

        public Criteria andConstraint_typeNotEqualTo(Object value) {
            addCriterion("constraint_type <>", value, "constraint_type");
            return (Criteria) this;
        }

        public Criteria andConstraint_typeGreaterThan(Object value) {
            addCriterion("constraint_type >", value, "constraint_type");
            return (Criteria) this;
        }

        public Criteria andConstraint_typeGreaterThanOrEqualTo(Object value) {
            addCriterion("constraint_type >=", value, "constraint_type");
            return (Criteria) this;
        }

        public Criteria andConstraint_typeLessThan(Object value) {
            addCriterion("constraint_type <", value, "constraint_type");
            return (Criteria) this;
        }

        public Criteria andConstraint_typeLessThanOrEqualTo(Object value) {
            addCriterion("constraint_type <=", value, "constraint_type");
            return (Criteria) this;
        }

        public Criteria andConstraint_typeIn(List<Object> values) {
            addCriterion("constraint_type in", values, "constraint_type");
            return (Criteria) this;
        }

        public Criteria andConstraint_typeNotIn(List<Object> values) {
            addCriterion("constraint_type not in", values, "constraint_type");
            return (Criteria) this;
        }

        public Criteria andConstraint_typeBetween(Object value1, Object value2) {
            addCriterion("constraint_type between", value1, value2, "constraint_type");
            return (Criteria) this;
        }

        public Criteria andConstraint_typeNotBetween(Object value1, Object value2) {
            addCriterion("constraint_type not between", value1, value2, "constraint_type");
            return (Criteria) this;
        }

        public Criteria andIs_deferrableIsNull() {
            addCriterion("is_deferrable is null");
            return (Criteria) this;
        }

        public Criteria andIs_deferrableIsNotNull() {
            addCriterion("is_deferrable is not null");
            return (Criteria) this;
        }

        public Criteria andIs_deferrableEqualTo(Object value) {
            addCriterion("is_deferrable =", value, "is_deferrable");
            return (Criteria) this;
        }

        public Criteria andIs_deferrableNotEqualTo(Object value) {
            addCriterion("is_deferrable <>", value, "is_deferrable");
            return (Criteria) this;
        }

        public Criteria andIs_deferrableGreaterThan(Object value) {
            addCriterion("is_deferrable >", value, "is_deferrable");
            return (Criteria) this;
        }

        public Criteria andIs_deferrableGreaterThanOrEqualTo(Object value) {
            addCriterion("is_deferrable >=", value, "is_deferrable");
            return (Criteria) this;
        }

        public Criteria andIs_deferrableLessThan(Object value) {
            addCriterion("is_deferrable <", value, "is_deferrable");
            return (Criteria) this;
        }

        public Criteria andIs_deferrableLessThanOrEqualTo(Object value) {
            addCriterion("is_deferrable <=", value, "is_deferrable");
            return (Criteria) this;
        }

        public Criteria andIs_deferrableIn(List<Object> values) {
            addCriterion("is_deferrable in", values, "is_deferrable");
            return (Criteria) this;
        }

        public Criteria andIs_deferrableNotIn(List<Object> values) {
            addCriterion("is_deferrable not in", values, "is_deferrable");
            return (Criteria) this;
        }

        public Criteria andIs_deferrableBetween(Object value1, Object value2) {
            addCriterion("is_deferrable between", value1, value2, "is_deferrable");
            return (Criteria) this;
        }

        public Criteria andIs_deferrableNotBetween(Object value1, Object value2) {
            addCriterion("is_deferrable not between", value1, value2, "is_deferrable");
            return (Criteria) this;
        }

        public Criteria andInitially_deferredIsNull() {
            addCriterion("initially_deferred is null");
            return (Criteria) this;
        }

        public Criteria andInitially_deferredIsNotNull() {
            addCriterion("initially_deferred is not null");
            return (Criteria) this;
        }

        public Criteria andInitially_deferredEqualTo(Object value) {
            addCriterion("initially_deferred =", value, "initially_deferred");
            return (Criteria) this;
        }

        public Criteria andInitially_deferredNotEqualTo(Object value) {
            addCriterion("initially_deferred <>", value, "initially_deferred");
            return (Criteria) this;
        }

        public Criteria andInitially_deferredGreaterThan(Object value) {
            addCriterion("initially_deferred >", value, "initially_deferred");
            return (Criteria) this;
        }

        public Criteria andInitially_deferredGreaterThanOrEqualTo(Object value) {
            addCriterion("initially_deferred >=", value, "initially_deferred");
            return (Criteria) this;
        }

        public Criteria andInitially_deferredLessThan(Object value) {
            addCriterion("initially_deferred <", value, "initially_deferred");
            return (Criteria) this;
        }

        public Criteria andInitially_deferredLessThanOrEqualTo(Object value) {
            addCriterion("initially_deferred <=", value, "initially_deferred");
            return (Criteria) this;
        }

        public Criteria andInitially_deferredIn(List<Object> values) {
            addCriterion("initially_deferred in", values, "initially_deferred");
            return (Criteria) this;
        }

        public Criteria andInitially_deferredNotIn(List<Object> values) {
            addCriterion("initially_deferred not in", values, "initially_deferred");
            return (Criteria) this;
        }

        public Criteria andInitially_deferredBetween(Object value1, Object value2) {
            addCriterion("initially_deferred between", value1, value2, "initially_deferred");
            return (Criteria) this;
        }

        public Criteria andInitially_deferredNotBetween(Object value1, Object value2) {
            addCriterion("initially_deferred not between", value1, value2, "initially_deferred");
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