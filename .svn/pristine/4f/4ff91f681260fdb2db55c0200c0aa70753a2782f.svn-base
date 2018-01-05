package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class ViewsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ViewsExample() {
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

        public Criteria andView_definitionIsNull() {
            addCriterion("view_definition is null");
            return (Criteria) this;
        }

        public Criteria andView_definitionIsNotNull() {
            addCriterion("view_definition is not null");
            return (Criteria) this;
        }

        public Criteria andView_definitionEqualTo(Object value) {
            addCriterion("view_definition =", value, "view_definition");
            return (Criteria) this;
        }

        public Criteria andView_definitionNotEqualTo(Object value) {
            addCriterion("view_definition <>", value, "view_definition");
            return (Criteria) this;
        }

        public Criteria andView_definitionGreaterThan(Object value) {
            addCriterion("view_definition >", value, "view_definition");
            return (Criteria) this;
        }

        public Criteria andView_definitionGreaterThanOrEqualTo(Object value) {
            addCriterion("view_definition >=", value, "view_definition");
            return (Criteria) this;
        }

        public Criteria andView_definitionLessThan(Object value) {
            addCriterion("view_definition <", value, "view_definition");
            return (Criteria) this;
        }

        public Criteria andView_definitionLessThanOrEqualTo(Object value) {
            addCriterion("view_definition <=", value, "view_definition");
            return (Criteria) this;
        }

        public Criteria andView_definitionIn(List<Object> values) {
            addCriterion("view_definition in", values, "view_definition");
            return (Criteria) this;
        }

        public Criteria andView_definitionNotIn(List<Object> values) {
            addCriterion("view_definition not in", values, "view_definition");
            return (Criteria) this;
        }

        public Criteria andView_definitionBetween(Object value1, Object value2) {
            addCriterion("view_definition between", value1, value2, "view_definition");
            return (Criteria) this;
        }

        public Criteria andView_definitionNotBetween(Object value1, Object value2) {
            addCriterion("view_definition not between", value1, value2, "view_definition");
            return (Criteria) this;
        }

        public Criteria andCheck_optionIsNull() {
            addCriterion("check_option is null");
            return (Criteria) this;
        }

        public Criteria andCheck_optionIsNotNull() {
            addCriterion("check_option is not null");
            return (Criteria) this;
        }

        public Criteria andCheck_optionEqualTo(Object value) {
            addCriterion("check_option =", value, "check_option");
            return (Criteria) this;
        }

        public Criteria andCheck_optionNotEqualTo(Object value) {
            addCriterion("check_option <>", value, "check_option");
            return (Criteria) this;
        }

        public Criteria andCheck_optionGreaterThan(Object value) {
            addCriterion("check_option >", value, "check_option");
            return (Criteria) this;
        }

        public Criteria andCheck_optionGreaterThanOrEqualTo(Object value) {
            addCriterion("check_option >=", value, "check_option");
            return (Criteria) this;
        }

        public Criteria andCheck_optionLessThan(Object value) {
            addCriterion("check_option <", value, "check_option");
            return (Criteria) this;
        }

        public Criteria andCheck_optionLessThanOrEqualTo(Object value) {
            addCriterion("check_option <=", value, "check_option");
            return (Criteria) this;
        }

        public Criteria andCheck_optionIn(List<Object> values) {
            addCriterion("check_option in", values, "check_option");
            return (Criteria) this;
        }

        public Criteria andCheck_optionNotIn(List<Object> values) {
            addCriterion("check_option not in", values, "check_option");
            return (Criteria) this;
        }

        public Criteria andCheck_optionBetween(Object value1, Object value2) {
            addCriterion("check_option between", value1, value2, "check_option");
            return (Criteria) this;
        }

        public Criteria andCheck_optionNotBetween(Object value1, Object value2) {
            addCriterion("check_option not between", value1, value2, "check_option");
            return (Criteria) this;
        }

        public Criteria andIs_updatableIsNull() {
            addCriterion("is_updatable is null");
            return (Criteria) this;
        }

        public Criteria andIs_updatableIsNotNull() {
            addCriterion("is_updatable is not null");
            return (Criteria) this;
        }

        public Criteria andIs_updatableEqualTo(Object value) {
            addCriterion("is_updatable =", value, "is_updatable");
            return (Criteria) this;
        }

        public Criteria andIs_updatableNotEqualTo(Object value) {
            addCriterion("is_updatable <>", value, "is_updatable");
            return (Criteria) this;
        }

        public Criteria andIs_updatableGreaterThan(Object value) {
            addCriterion("is_updatable >", value, "is_updatable");
            return (Criteria) this;
        }

        public Criteria andIs_updatableGreaterThanOrEqualTo(Object value) {
            addCriterion("is_updatable >=", value, "is_updatable");
            return (Criteria) this;
        }

        public Criteria andIs_updatableLessThan(Object value) {
            addCriterion("is_updatable <", value, "is_updatable");
            return (Criteria) this;
        }

        public Criteria andIs_updatableLessThanOrEqualTo(Object value) {
            addCriterion("is_updatable <=", value, "is_updatable");
            return (Criteria) this;
        }

        public Criteria andIs_updatableIn(List<Object> values) {
            addCriterion("is_updatable in", values, "is_updatable");
            return (Criteria) this;
        }

        public Criteria andIs_updatableNotIn(List<Object> values) {
            addCriterion("is_updatable not in", values, "is_updatable");
            return (Criteria) this;
        }

        public Criteria andIs_updatableBetween(Object value1, Object value2) {
            addCriterion("is_updatable between", value1, value2, "is_updatable");
            return (Criteria) this;
        }

        public Criteria andIs_updatableNotBetween(Object value1, Object value2) {
            addCriterion("is_updatable not between", value1, value2, "is_updatable");
            return (Criteria) this;
        }

        public Criteria andIs_insertable_intoIsNull() {
            addCriterion("is_insertable_into is null");
            return (Criteria) this;
        }

        public Criteria andIs_insertable_intoIsNotNull() {
            addCriterion("is_insertable_into is not null");
            return (Criteria) this;
        }

        public Criteria andIs_insertable_intoEqualTo(Object value) {
            addCriterion("is_insertable_into =", value, "is_insertable_into");
            return (Criteria) this;
        }

        public Criteria andIs_insertable_intoNotEqualTo(Object value) {
            addCriterion("is_insertable_into <>", value, "is_insertable_into");
            return (Criteria) this;
        }

        public Criteria andIs_insertable_intoGreaterThan(Object value) {
            addCriterion("is_insertable_into >", value, "is_insertable_into");
            return (Criteria) this;
        }

        public Criteria andIs_insertable_intoGreaterThanOrEqualTo(Object value) {
            addCriterion("is_insertable_into >=", value, "is_insertable_into");
            return (Criteria) this;
        }

        public Criteria andIs_insertable_intoLessThan(Object value) {
            addCriterion("is_insertable_into <", value, "is_insertable_into");
            return (Criteria) this;
        }

        public Criteria andIs_insertable_intoLessThanOrEqualTo(Object value) {
            addCriterion("is_insertable_into <=", value, "is_insertable_into");
            return (Criteria) this;
        }

        public Criteria andIs_insertable_intoIn(List<Object> values) {
            addCriterion("is_insertable_into in", values, "is_insertable_into");
            return (Criteria) this;
        }

        public Criteria andIs_insertable_intoNotIn(List<Object> values) {
            addCriterion("is_insertable_into not in", values, "is_insertable_into");
            return (Criteria) this;
        }

        public Criteria andIs_insertable_intoBetween(Object value1, Object value2) {
            addCriterion("is_insertable_into between", value1, value2, "is_insertable_into");
            return (Criteria) this;
        }

        public Criteria andIs_insertable_intoNotBetween(Object value1, Object value2) {
            addCriterion("is_insertable_into not between", value1, value2, "is_insertable_into");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_updatableIsNull() {
            addCriterion("is_trigger_updatable is null");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_updatableIsNotNull() {
            addCriterion("is_trigger_updatable is not null");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_updatableEqualTo(Object value) {
            addCriterion("is_trigger_updatable =", value, "is_trigger_updatable");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_updatableNotEqualTo(Object value) {
            addCriterion("is_trigger_updatable <>", value, "is_trigger_updatable");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_updatableGreaterThan(Object value) {
            addCriterion("is_trigger_updatable >", value, "is_trigger_updatable");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_updatableGreaterThanOrEqualTo(Object value) {
            addCriterion("is_trigger_updatable >=", value, "is_trigger_updatable");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_updatableLessThan(Object value) {
            addCriterion("is_trigger_updatable <", value, "is_trigger_updatable");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_updatableLessThanOrEqualTo(Object value) {
            addCriterion("is_trigger_updatable <=", value, "is_trigger_updatable");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_updatableIn(List<Object> values) {
            addCriterion("is_trigger_updatable in", values, "is_trigger_updatable");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_updatableNotIn(List<Object> values) {
            addCriterion("is_trigger_updatable not in", values, "is_trigger_updatable");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_updatableBetween(Object value1, Object value2) {
            addCriterion("is_trigger_updatable between", value1, value2, "is_trigger_updatable");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_updatableNotBetween(Object value1, Object value2) {
            addCriterion("is_trigger_updatable not between", value1, value2, "is_trigger_updatable");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_deletableIsNull() {
            addCriterion("is_trigger_deletable is null");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_deletableIsNotNull() {
            addCriterion("is_trigger_deletable is not null");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_deletableEqualTo(Object value) {
            addCriterion("is_trigger_deletable =", value, "is_trigger_deletable");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_deletableNotEqualTo(Object value) {
            addCriterion("is_trigger_deletable <>", value, "is_trigger_deletable");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_deletableGreaterThan(Object value) {
            addCriterion("is_trigger_deletable >", value, "is_trigger_deletable");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_deletableGreaterThanOrEqualTo(Object value) {
            addCriterion("is_trigger_deletable >=", value, "is_trigger_deletable");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_deletableLessThan(Object value) {
            addCriterion("is_trigger_deletable <", value, "is_trigger_deletable");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_deletableLessThanOrEqualTo(Object value) {
            addCriterion("is_trigger_deletable <=", value, "is_trigger_deletable");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_deletableIn(List<Object> values) {
            addCriterion("is_trigger_deletable in", values, "is_trigger_deletable");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_deletableNotIn(List<Object> values) {
            addCriterion("is_trigger_deletable not in", values, "is_trigger_deletable");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_deletableBetween(Object value1, Object value2) {
            addCriterion("is_trigger_deletable between", value1, value2, "is_trigger_deletable");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_deletableNotBetween(Object value1, Object value2) {
            addCriterion("is_trigger_deletable not between", value1, value2, "is_trigger_deletable");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_insertable_intoIsNull() {
            addCriterion("is_trigger_insertable_into is null");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_insertable_intoIsNotNull() {
            addCriterion("is_trigger_insertable_into is not null");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_insertable_intoEqualTo(Object value) {
            addCriterion("is_trigger_insertable_into =", value, "is_trigger_insertable_into");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_insertable_intoNotEqualTo(Object value) {
            addCriterion("is_trigger_insertable_into <>", value, "is_trigger_insertable_into");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_insertable_intoGreaterThan(Object value) {
            addCriterion("is_trigger_insertable_into >", value, "is_trigger_insertable_into");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_insertable_intoGreaterThanOrEqualTo(Object value) {
            addCriterion("is_trigger_insertable_into >=", value, "is_trigger_insertable_into");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_insertable_intoLessThan(Object value) {
            addCriterion("is_trigger_insertable_into <", value, "is_trigger_insertable_into");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_insertable_intoLessThanOrEqualTo(Object value) {
            addCriterion("is_trigger_insertable_into <=", value, "is_trigger_insertable_into");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_insertable_intoIn(List<Object> values) {
            addCriterion("is_trigger_insertable_into in", values, "is_trigger_insertable_into");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_insertable_intoNotIn(List<Object> values) {
            addCriterion("is_trigger_insertable_into not in", values, "is_trigger_insertable_into");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_insertable_intoBetween(Object value1, Object value2) {
            addCriterion("is_trigger_insertable_into between", value1, value2, "is_trigger_insertable_into");
            return (Criteria) this;
        }

        public Criteria andIs_trigger_insertable_intoNotBetween(Object value1, Object value2) {
            addCriterion("is_trigger_insertable_into not between", value1, value2, "is_trigger_insertable_into");
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