package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class TriggeredUpdateColumnsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TriggeredUpdateColumnsExample() {
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

        public Criteria andTrigger_catalogIsNull() {
            addCriterion("trigger_catalog is null");
            return (Criteria) this;
        }

        public Criteria andTrigger_catalogIsNotNull() {
            addCriterion("trigger_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andTrigger_catalogEqualTo(Object value) {
            addCriterion("trigger_catalog =", value, "trigger_catalog");
            return (Criteria) this;
        }

        public Criteria andTrigger_catalogNotEqualTo(Object value) {
            addCriterion("trigger_catalog <>", value, "trigger_catalog");
            return (Criteria) this;
        }

        public Criteria andTrigger_catalogGreaterThan(Object value) {
            addCriterion("trigger_catalog >", value, "trigger_catalog");
            return (Criteria) this;
        }

        public Criteria andTrigger_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("trigger_catalog >=", value, "trigger_catalog");
            return (Criteria) this;
        }

        public Criteria andTrigger_catalogLessThan(Object value) {
            addCriterion("trigger_catalog <", value, "trigger_catalog");
            return (Criteria) this;
        }

        public Criteria andTrigger_catalogLessThanOrEqualTo(Object value) {
            addCriterion("trigger_catalog <=", value, "trigger_catalog");
            return (Criteria) this;
        }

        public Criteria andTrigger_catalogIn(List<Object> values) {
            addCriterion("trigger_catalog in", values, "trigger_catalog");
            return (Criteria) this;
        }

        public Criteria andTrigger_catalogNotIn(List<Object> values) {
            addCriterion("trigger_catalog not in", values, "trigger_catalog");
            return (Criteria) this;
        }

        public Criteria andTrigger_catalogBetween(Object value1, Object value2) {
            addCriterion("trigger_catalog between", value1, value2, "trigger_catalog");
            return (Criteria) this;
        }

        public Criteria andTrigger_catalogNotBetween(Object value1, Object value2) {
            addCriterion("trigger_catalog not between", value1, value2, "trigger_catalog");
            return (Criteria) this;
        }

        public Criteria andTrigger_schemaIsNull() {
            addCriterion("trigger_schema is null");
            return (Criteria) this;
        }

        public Criteria andTrigger_schemaIsNotNull() {
            addCriterion("trigger_schema is not null");
            return (Criteria) this;
        }

        public Criteria andTrigger_schemaEqualTo(Object value) {
            addCriterion("trigger_schema =", value, "trigger_schema");
            return (Criteria) this;
        }

        public Criteria andTrigger_schemaNotEqualTo(Object value) {
            addCriterion("trigger_schema <>", value, "trigger_schema");
            return (Criteria) this;
        }

        public Criteria andTrigger_schemaGreaterThan(Object value) {
            addCriterion("trigger_schema >", value, "trigger_schema");
            return (Criteria) this;
        }

        public Criteria andTrigger_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("trigger_schema >=", value, "trigger_schema");
            return (Criteria) this;
        }

        public Criteria andTrigger_schemaLessThan(Object value) {
            addCriterion("trigger_schema <", value, "trigger_schema");
            return (Criteria) this;
        }

        public Criteria andTrigger_schemaLessThanOrEqualTo(Object value) {
            addCriterion("trigger_schema <=", value, "trigger_schema");
            return (Criteria) this;
        }

        public Criteria andTrigger_schemaIn(List<Object> values) {
            addCriterion("trigger_schema in", values, "trigger_schema");
            return (Criteria) this;
        }

        public Criteria andTrigger_schemaNotIn(List<Object> values) {
            addCriterion("trigger_schema not in", values, "trigger_schema");
            return (Criteria) this;
        }

        public Criteria andTrigger_schemaBetween(Object value1, Object value2) {
            addCriterion("trigger_schema between", value1, value2, "trigger_schema");
            return (Criteria) this;
        }

        public Criteria andTrigger_schemaNotBetween(Object value1, Object value2) {
            addCriterion("trigger_schema not between", value1, value2, "trigger_schema");
            return (Criteria) this;
        }

        public Criteria andTrigger_nameIsNull() {
            addCriterion("trigger_name is null");
            return (Criteria) this;
        }

        public Criteria andTrigger_nameIsNotNull() {
            addCriterion("trigger_name is not null");
            return (Criteria) this;
        }

        public Criteria andTrigger_nameEqualTo(Object value) {
            addCriterion("trigger_name =", value, "trigger_name");
            return (Criteria) this;
        }

        public Criteria andTrigger_nameNotEqualTo(Object value) {
            addCriterion("trigger_name <>", value, "trigger_name");
            return (Criteria) this;
        }

        public Criteria andTrigger_nameGreaterThan(Object value) {
            addCriterion("trigger_name >", value, "trigger_name");
            return (Criteria) this;
        }

        public Criteria andTrigger_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("trigger_name >=", value, "trigger_name");
            return (Criteria) this;
        }

        public Criteria andTrigger_nameLessThan(Object value) {
            addCriterion("trigger_name <", value, "trigger_name");
            return (Criteria) this;
        }

        public Criteria andTrigger_nameLessThanOrEqualTo(Object value) {
            addCriterion("trigger_name <=", value, "trigger_name");
            return (Criteria) this;
        }

        public Criteria andTrigger_nameIn(List<Object> values) {
            addCriterion("trigger_name in", values, "trigger_name");
            return (Criteria) this;
        }

        public Criteria andTrigger_nameNotIn(List<Object> values) {
            addCriterion("trigger_name not in", values, "trigger_name");
            return (Criteria) this;
        }

        public Criteria andTrigger_nameBetween(Object value1, Object value2) {
            addCriterion("trigger_name between", value1, value2, "trigger_name");
            return (Criteria) this;
        }

        public Criteria andTrigger_nameNotBetween(Object value1, Object value2) {
            addCriterion("trigger_name not between", value1, value2, "trigger_name");
            return (Criteria) this;
        }

        public Criteria andEvent_object_catalogIsNull() {
            addCriterion("event_object_catalog is null");
            return (Criteria) this;
        }

        public Criteria andEvent_object_catalogIsNotNull() {
            addCriterion("event_object_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andEvent_object_catalogEqualTo(Object value) {
            addCriterion("event_object_catalog =", value, "event_object_catalog");
            return (Criteria) this;
        }

        public Criteria andEvent_object_catalogNotEqualTo(Object value) {
            addCriterion("event_object_catalog <>", value, "event_object_catalog");
            return (Criteria) this;
        }

        public Criteria andEvent_object_catalogGreaterThan(Object value) {
            addCriterion("event_object_catalog >", value, "event_object_catalog");
            return (Criteria) this;
        }

        public Criteria andEvent_object_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("event_object_catalog >=", value, "event_object_catalog");
            return (Criteria) this;
        }

        public Criteria andEvent_object_catalogLessThan(Object value) {
            addCriterion("event_object_catalog <", value, "event_object_catalog");
            return (Criteria) this;
        }

        public Criteria andEvent_object_catalogLessThanOrEqualTo(Object value) {
            addCriterion("event_object_catalog <=", value, "event_object_catalog");
            return (Criteria) this;
        }

        public Criteria andEvent_object_catalogIn(List<Object> values) {
            addCriterion("event_object_catalog in", values, "event_object_catalog");
            return (Criteria) this;
        }

        public Criteria andEvent_object_catalogNotIn(List<Object> values) {
            addCriterion("event_object_catalog not in", values, "event_object_catalog");
            return (Criteria) this;
        }

        public Criteria andEvent_object_catalogBetween(Object value1, Object value2) {
            addCriterion("event_object_catalog between", value1, value2, "event_object_catalog");
            return (Criteria) this;
        }

        public Criteria andEvent_object_catalogNotBetween(Object value1, Object value2) {
            addCriterion("event_object_catalog not between", value1, value2, "event_object_catalog");
            return (Criteria) this;
        }

        public Criteria andEvent_object_schemaIsNull() {
            addCriterion("event_object_schema is null");
            return (Criteria) this;
        }

        public Criteria andEvent_object_schemaIsNotNull() {
            addCriterion("event_object_schema is not null");
            return (Criteria) this;
        }

        public Criteria andEvent_object_schemaEqualTo(Object value) {
            addCriterion("event_object_schema =", value, "event_object_schema");
            return (Criteria) this;
        }

        public Criteria andEvent_object_schemaNotEqualTo(Object value) {
            addCriterion("event_object_schema <>", value, "event_object_schema");
            return (Criteria) this;
        }

        public Criteria andEvent_object_schemaGreaterThan(Object value) {
            addCriterion("event_object_schema >", value, "event_object_schema");
            return (Criteria) this;
        }

        public Criteria andEvent_object_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("event_object_schema >=", value, "event_object_schema");
            return (Criteria) this;
        }

        public Criteria andEvent_object_schemaLessThan(Object value) {
            addCriterion("event_object_schema <", value, "event_object_schema");
            return (Criteria) this;
        }

        public Criteria andEvent_object_schemaLessThanOrEqualTo(Object value) {
            addCriterion("event_object_schema <=", value, "event_object_schema");
            return (Criteria) this;
        }

        public Criteria andEvent_object_schemaIn(List<Object> values) {
            addCriterion("event_object_schema in", values, "event_object_schema");
            return (Criteria) this;
        }

        public Criteria andEvent_object_schemaNotIn(List<Object> values) {
            addCriterion("event_object_schema not in", values, "event_object_schema");
            return (Criteria) this;
        }

        public Criteria andEvent_object_schemaBetween(Object value1, Object value2) {
            addCriterion("event_object_schema between", value1, value2, "event_object_schema");
            return (Criteria) this;
        }

        public Criteria andEvent_object_schemaNotBetween(Object value1, Object value2) {
            addCriterion("event_object_schema not between", value1, value2, "event_object_schema");
            return (Criteria) this;
        }

        public Criteria andEvent_object_tableIsNull() {
            addCriterion("event_object_table is null");
            return (Criteria) this;
        }

        public Criteria andEvent_object_tableIsNotNull() {
            addCriterion("event_object_table is not null");
            return (Criteria) this;
        }

        public Criteria andEvent_object_tableEqualTo(Object value) {
            addCriterion("event_object_table =", value, "event_object_table");
            return (Criteria) this;
        }

        public Criteria andEvent_object_tableNotEqualTo(Object value) {
            addCriterion("event_object_table <>", value, "event_object_table");
            return (Criteria) this;
        }

        public Criteria andEvent_object_tableGreaterThan(Object value) {
            addCriterion("event_object_table >", value, "event_object_table");
            return (Criteria) this;
        }

        public Criteria andEvent_object_tableGreaterThanOrEqualTo(Object value) {
            addCriterion("event_object_table >=", value, "event_object_table");
            return (Criteria) this;
        }

        public Criteria andEvent_object_tableLessThan(Object value) {
            addCriterion("event_object_table <", value, "event_object_table");
            return (Criteria) this;
        }

        public Criteria andEvent_object_tableLessThanOrEqualTo(Object value) {
            addCriterion("event_object_table <=", value, "event_object_table");
            return (Criteria) this;
        }

        public Criteria andEvent_object_tableIn(List<Object> values) {
            addCriterion("event_object_table in", values, "event_object_table");
            return (Criteria) this;
        }

        public Criteria andEvent_object_tableNotIn(List<Object> values) {
            addCriterion("event_object_table not in", values, "event_object_table");
            return (Criteria) this;
        }

        public Criteria andEvent_object_tableBetween(Object value1, Object value2) {
            addCriterion("event_object_table between", value1, value2, "event_object_table");
            return (Criteria) this;
        }

        public Criteria andEvent_object_tableNotBetween(Object value1, Object value2) {
            addCriterion("event_object_table not between", value1, value2, "event_object_table");
            return (Criteria) this;
        }

        public Criteria andEvent_object_columnIsNull() {
            addCriterion("event_object_column is null");
            return (Criteria) this;
        }

        public Criteria andEvent_object_columnIsNotNull() {
            addCriterion("event_object_column is not null");
            return (Criteria) this;
        }

        public Criteria andEvent_object_columnEqualTo(Object value) {
            addCriterion("event_object_column =", value, "event_object_column");
            return (Criteria) this;
        }

        public Criteria andEvent_object_columnNotEqualTo(Object value) {
            addCriterion("event_object_column <>", value, "event_object_column");
            return (Criteria) this;
        }

        public Criteria andEvent_object_columnGreaterThan(Object value) {
            addCriterion("event_object_column >", value, "event_object_column");
            return (Criteria) this;
        }

        public Criteria andEvent_object_columnGreaterThanOrEqualTo(Object value) {
            addCriterion("event_object_column >=", value, "event_object_column");
            return (Criteria) this;
        }

        public Criteria andEvent_object_columnLessThan(Object value) {
            addCriterion("event_object_column <", value, "event_object_column");
            return (Criteria) this;
        }

        public Criteria andEvent_object_columnLessThanOrEqualTo(Object value) {
            addCriterion("event_object_column <=", value, "event_object_column");
            return (Criteria) this;
        }

        public Criteria andEvent_object_columnIn(List<Object> values) {
            addCriterion("event_object_column in", values, "event_object_column");
            return (Criteria) this;
        }

        public Criteria andEvent_object_columnNotIn(List<Object> values) {
            addCriterion("event_object_column not in", values, "event_object_column");
            return (Criteria) this;
        }

        public Criteria andEvent_object_columnBetween(Object value1, Object value2) {
            addCriterion("event_object_column between", value1, value2, "event_object_column");
            return (Criteria) this;
        }

        public Criteria andEvent_object_columnNotBetween(Object value1, Object value2) {
            addCriterion("event_object_column not between", value1, value2, "event_object_column");
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