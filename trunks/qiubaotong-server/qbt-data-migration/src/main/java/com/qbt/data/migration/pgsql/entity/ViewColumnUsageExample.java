package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class ViewColumnUsageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ViewColumnUsageExample() {
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

        public Criteria andView_catalogIsNull() {
            addCriterion("view_catalog is null");
            return (Criteria) this;
        }

        public Criteria andView_catalogIsNotNull() {
            addCriterion("view_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andView_catalogEqualTo(Object value) {
            addCriterion("view_catalog =", value, "view_catalog");
            return (Criteria) this;
        }

        public Criteria andView_catalogNotEqualTo(Object value) {
            addCriterion("view_catalog <>", value, "view_catalog");
            return (Criteria) this;
        }

        public Criteria andView_catalogGreaterThan(Object value) {
            addCriterion("view_catalog >", value, "view_catalog");
            return (Criteria) this;
        }

        public Criteria andView_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("view_catalog >=", value, "view_catalog");
            return (Criteria) this;
        }

        public Criteria andView_catalogLessThan(Object value) {
            addCriterion("view_catalog <", value, "view_catalog");
            return (Criteria) this;
        }

        public Criteria andView_catalogLessThanOrEqualTo(Object value) {
            addCriterion("view_catalog <=", value, "view_catalog");
            return (Criteria) this;
        }

        public Criteria andView_catalogIn(List<Object> values) {
            addCriterion("view_catalog in", values, "view_catalog");
            return (Criteria) this;
        }

        public Criteria andView_catalogNotIn(List<Object> values) {
            addCriterion("view_catalog not in", values, "view_catalog");
            return (Criteria) this;
        }

        public Criteria andView_catalogBetween(Object value1, Object value2) {
            addCriterion("view_catalog between", value1, value2, "view_catalog");
            return (Criteria) this;
        }

        public Criteria andView_catalogNotBetween(Object value1, Object value2) {
            addCriterion("view_catalog not between", value1, value2, "view_catalog");
            return (Criteria) this;
        }

        public Criteria andView_schemaIsNull() {
            addCriterion("view_schema is null");
            return (Criteria) this;
        }

        public Criteria andView_schemaIsNotNull() {
            addCriterion("view_schema is not null");
            return (Criteria) this;
        }

        public Criteria andView_schemaEqualTo(Object value) {
            addCriterion("view_schema =", value, "view_schema");
            return (Criteria) this;
        }

        public Criteria andView_schemaNotEqualTo(Object value) {
            addCriterion("view_schema <>", value, "view_schema");
            return (Criteria) this;
        }

        public Criteria andView_schemaGreaterThan(Object value) {
            addCriterion("view_schema >", value, "view_schema");
            return (Criteria) this;
        }

        public Criteria andView_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("view_schema >=", value, "view_schema");
            return (Criteria) this;
        }

        public Criteria andView_schemaLessThan(Object value) {
            addCriterion("view_schema <", value, "view_schema");
            return (Criteria) this;
        }

        public Criteria andView_schemaLessThanOrEqualTo(Object value) {
            addCriterion("view_schema <=", value, "view_schema");
            return (Criteria) this;
        }

        public Criteria andView_schemaIn(List<Object> values) {
            addCriterion("view_schema in", values, "view_schema");
            return (Criteria) this;
        }

        public Criteria andView_schemaNotIn(List<Object> values) {
            addCriterion("view_schema not in", values, "view_schema");
            return (Criteria) this;
        }

        public Criteria andView_schemaBetween(Object value1, Object value2) {
            addCriterion("view_schema between", value1, value2, "view_schema");
            return (Criteria) this;
        }

        public Criteria andView_schemaNotBetween(Object value1, Object value2) {
            addCriterion("view_schema not between", value1, value2, "view_schema");
            return (Criteria) this;
        }

        public Criteria andView_nameIsNull() {
            addCriterion("view_name is null");
            return (Criteria) this;
        }

        public Criteria andView_nameIsNotNull() {
            addCriterion("view_name is not null");
            return (Criteria) this;
        }

        public Criteria andView_nameEqualTo(Object value) {
            addCriterion("view_name =", value, "view_name");
            return (Criteria) this;
        }

        public Criteria andView_nameNotEqualTo(Object value) {
            addCriterion("view_name <>", value, "view_name");
            return (Criteria) this;
        }

        public Criteria andView_nameGreaterThan(Object value) {
            addCriterion("view_name >", value, "view_name");
            return (Criteria) this;
        }

        public Criteria andView_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("view_name >=", value, "view_name");
            return (Criteria) this;
        }

        public Criteria andView_nameLessThan(Object value) {
            addCriterion("view_name <", value, "view_name");
            return (Criteria) this;
        }

        public Criteria andView_nameLessThanOrEqualTo(Object value) {
            addCriterion("view_name <=", value, "view_name");
            return (Criteria) this;
        }

        public Criteria andView_nameIn(List<Object> values) {
            addCriterion("view_name in", values, "view_name");
            return (Criteria) this;
        }

        public Criteria andView_nameNotIn(List<Object> values) {
            addCriterion("view_name not in", values, "view_name");
            return (Criteria) this;
        }

        public Criteria andView_nameBetween(Object value1, Object value2) {
            addCriterion("view_name between", value1, value2, "view_name");
            return (Criteria) this;
        }

        public Criteria andView_nameNotBetween(Object value1, Object value2) {
            addCriterion("view_name not between", value1, value2, "view_name");
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

        public Criteria andColumn_nameIsNull() {
            addCriterion("column_name is null");
            return (Criteria) this;
        }

        public Criteria andColumn_nameIsNotNull() {
            addCriterion("column_name is not null");
            return (Criteria) this;
        }

        public Criteria andColumn_nameEqualTo(Object value) {
            addCriterion("column_name =", value, "column_name");
            return (Criteria) this;
        }

        public Criteria andColumn_nameNotEqualTo(Object value) {
            addCriterion("column_name <>", value, "column_name");
            return (Criteria) this;
        }

        public Criteria andColumn_nameGreaterThan(Object value) {
            addCriterion("column_name >", value, "column_name");
            return (Criteria) this;
        }

        public Criteria andColumn_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("column_name >=", value, "column_name");
            return (Criteria) this;
        }

        public Criteria andColumn_nameLessThan(Object value) {
            addCriterion("column_name <", value, "column_name");
            return (Criteria) this;
        }

        public Criteria andColumn_nameLessThanOrEqualTo(Object value) {
            addCriterion("column_name <=", value, "column_name");
            return (Criteria) this;
        }

        public Criteria andColumn_nameIn(List<Object> values) {
            addCriterion("column_name in", values, "column_name");
            return (Criteria) this;
        }

        public Criteria andColumn_nameNotIn(List<Object> values) {
            addCriterion("column_name not in", values, "column_name");
            return (Criteria) this;
        }

        public Criteria andColumn_nameBetween(Object value1, Object value2) {
            addCriterion("column_name between", value1, value2, "column_name");
            return (Criteria) this;
        }

        public Criteria andColumn_nameNotBetween(Object value1, Object value2) {
            addCriterion("column_name not between", value1, value2, "column_name");
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