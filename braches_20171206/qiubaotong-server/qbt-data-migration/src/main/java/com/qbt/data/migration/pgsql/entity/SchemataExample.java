package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class SchemataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SchemataExample() {
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

        public Criteria andCatalog_nameIsNull() {
            addCriterion("catalog_name is null");
            return (Criteria) this;
        }

        public Criteria andCatalog_nameIsNotNull() {
            addCriterion("catalog_name is not null");
            return (Criteria) this;
        }

        public Criteria andCatalog_nameEqualTo(Object value) {
            addCriterion("catalog_name =", value, "catalog_name");
            return (Criteria) this;
        }

        public Criteria andCatalog_nameNotEqualTo(Object value) {
            addCriterion("catalog_name <>", value, "catalog_name");
            return (Criteria) this;
        }

        public Criteria andCatalog_nameGreaterThan(Object value) {
            addCriterion("catalog_name >", value, "catalog_name");
            return (Criteria) this;
        }

        public Criteria andCatalog_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("catalog_name >=", value, "catalog_name");
            return (Criteria) this;
        }

        public Criteria andCatalog_nameLessThan(Object value) {
            addCriterion("catalog_name <", value, "catalog_name");
            return (Criteria) this;
        }

        public Criteria andCatalog_nameLessThanOrEqualTo(Object value) {
            addCriterion("catalog_name <=", value, "catalog_name");
            return (Criteria) this;
        }

        public Criteria andCatalog_nameIn(List<Object> values) {
            addCriterion("catalog_name in", values, "catalog_name");
            return (Criteria) this;
        }

        public Criteria andCatalog_nameNotIn(List<Object> values) {
            addCriterion("catalog_name not in", values, "catalog_name");
            return (Criteria) this;
        }

        public Criteria andCatalog_nameBetween(Object value1, Object value2) {
            addCriterion("catalog_name between", value1, value2, "catalog_name");
            return (Criteria) this;
        }

        public Criteria andCatalog_nameNotBetween(Object value1, Object value2) {
            addCriterion("catalog_name not between", value1, value2, "catalog_name");
            return (Criteria) this;
        }

        public Criteria andSchema_nameIsNull() {
            addCriterion("schema_name is null");
            return (Criteria) this;
        }

        public Criteria andSchema_nameIsNotNull() {
            addCriterion("schema_name is not null");
            return (Criteria) this;
        }

        public Criteria andSchema_nameEqualTo(Object value) {
            addCriterion("schema_name =", value, "schema_name");
            return (Criteria) this;
        }

        public Criteria andSchema_nameNotEqualTo(Object value) {
            addCriterion("schema_name <>", value, "schema_name");
            return (Criteria) this;
        }

        public Criteria andSchema_nameGreaterThan(Object value) {
            addCriterion("schema_name >", value, "schema_name");
            return (Criteria) this;
        }

        public Criteria andSchema_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("schema_name >=", value, "schema_name");
            return (Criteria) this;
        }

        public Criteria andSchema_nameLessThan(Object value) {
            addCriterion("schema_name <", value, "schema_name");
            return (Criteria) this;
        }

        public Criteria andSchema_nameLessThanOrEqualTo(Object value) {
            addCriterion("schema_name <=", value, "schema_name");
            return (Criteria) this;
        }

        public Criteria andSchema_nameIn(List<Object> values) {
            addCriterion("schema_name in", values, "schema_name");
            return (Criteria) this;
        }

        public Criteria andSchema_nameNotIn(List<Object> values) {
            addCriterion("schema_name not in", values, "schema_name");
            return (Criteria) this;
        }

        public Criteria andSchema_nameBetween(Object value1, Object value2) {
            addCriterion("schema_name between", value1, value2, "schema_name");
            return (Criteria) this;
        }

        public Criteria andSchema_nameNotBetween(Object value1, Object value2) {
            addCriterion("schema_name not between", value1, value2, "schema_name");
            return (Criteria) this;
        }

        public Criteria andSchema_ownerIsNull() {
            addCriterion("schema_owner is null");
            return (Criteria) this;
        }

        public Criteria andSchema_ownerIsNotNull() {
            addCriterion("schema_owner is not null");
            return (Criteria) this;
        }

        public Criteria andSchema_ownerEqualTo(Object value) {
            addCriterion("schema_owner =", value, "schema_owner");
            return (Criteria) this;
        }

        public Criteria andSchema_ownerNotEqualTo(Object value) {
            addCriterion("schema_owner <>", value, "schema_owner");
            return (Criteria) this;
        }

        public Criteria andSchema_ownerGreaterThan(Object value) {
            addCriterion("schema_owner >", value, "schema_owner");
            return (Criteria) this;
        }

        public Criteria andSchema_ownerGreaterThanOrEqualTo(Object value) {
            addCriterion("schema_owner >=", value, "schema_owner");
            return (Criteria) this;
        }

        public Criteria andSchema_ownerLessThan(Object value) {
            addCriterion("schema_owner <", value, "schema_owner");
            return (Criteria) this;
        }

        public Criteria andSchema_ownerLessThanOrEqualTo(Object value) {
            addCriterion("schema_owner <=", value, "schema_owner");
            return (Criteria) this;
        }

        public Criteria andSchema_ownerIn(List<Object> values) {
            addCriterion("schema_owner in", values, "schema_owner");
            return (Criteria) this;
        }

        public Criteria andSchema_ownerNotIn(List<Object> values) {
            addCriterion("schema_owner not in", values, "schema_owner");
            return (Criteria) this;
        }

        public Criteria andSchema_ownerBetween(Object value1, Object value2) {
            addCriterion("schema_owner between", value1, value2, "schema_owner");
            return (Criteria) this;
        }

        public Criteria andSchema_ownerNotBetween(Object value1, Object value2) {
            addCriterion("schema_owner not between", value1, value2, "schema_owner");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_catalogIsNull() {
            addCriterion("default_character_set_catalog is null");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_catalogIsNotNull() {
            addCriterion("default_character_set_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_catalogEqualTo(Object value) {
            addCriterion("default_character_set_catalog =", value, "default_character_set_catalog");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_catalogNotEqualTo(Object value) {
            addCriterion("default_character_set_catalog <>", value, "default_character_set_catalog");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_catalogGreaterThan(Object value) {
            addCriterion("default_character_set_catalog >", value, "default_character_set_catalog");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("default_character_set_catalog >=", value, "default_character_set_catalog");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_catalogLessThan(Object value) {
            addCriterion("default_character_set_catalog <", value, "default_character_set_catalog");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_catalogLessThanOrEqualTo(Object value) {
            addCriterion("default_character_set_catalog <=", value, "default_character_set_catalog");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_catalogIn(List<Object> values) {
            addCriterion("default_character_set_catalog in", values, "default_character_set_catalog");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_catalogNotIn(List<Object> values) {
            addCriterion("default_character_set_catalog not in", values, "default_character_set_catalog");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_catalogBetween(Object value1, Object value2) {
            addCriterion("default_character_set_catalog between", value1, value2, "default_character_set_catalog");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_catalogNotBetween(Object value1, Object value2) {
            addCriterion("default_character_set_catalog not between", value1, value2, "default_character_set_catalog");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_schemaIsNull() {
            addCriterion("default_character_set_schema is null");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_schemaIsNotNull() {
            addCriterion("default_character_set_schema is not null");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_schemaEqualTo(Object value) {
            addCriterion("default_character_set_schema =", value, "default_character_set_schema");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_schemaNotEqualTo(Object value) {
            addCriterion("default_character_set_schema <>", value, "default_character_set_schema");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_schemaGreaterThan(Object value) {
            addCriterion("default_character_set_schema >", value, "default_character_set_schema");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("default_character_set_schema >=", value, "default_character_set_schema");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_schemaLessThan(Object value) {
            addCriterion("default_character_set_schema <", value, "default_character_set_schema");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_schemaLessThanOrEqualTo(Object value) {
            addCriterion("default_character_set_schema <=", value, "default_character_set_schema");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_schemaIn(List<Object> values) {
            addCriterion("default_character_set_schema in", values, "default_character_set_schema");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_schemaNotIn(List<Object> values) {
            addCriterion("default_character_set_schema not in", values, "default_character_set_schema");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_schemaBetween(Object value1, Object value2) {
            addCriterion("default_character_set_schema between", value1, value2, "default_character_set_schema");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_schemaNotBetween(Object value1, Object value2) {
            addCriterion("default_character_set_schema not between", value1, value2, "default_character_set_schema");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_nameIsNull() {
            addCriterion("default_character_set_name is null");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_nameIsNotNull() {
            addCriterion("default_character_set_name is not null");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_nameEqualTo(Object value) {
            addCriterion("default_character_set_name =", value, "default_character_set_name");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_nameNotEqualTo(Object value) {
            addCriterion("default_character_set_name <>", value, "default_character_set_name");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_nameGreaterThan(Object value) {
            addCriterion("default_character_set_name >", value, "default_character_set_name");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("default_character_set_name >=", value, "default_character_set_name");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_nameLessThan(Object value) {
            addCriterion("default_character_set_name <", value, "default_character_set_name");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_nameLessThanOrEqualTo(Object value) {
            addCriterion("default_character_set_name <=", value, "default_character_set_name");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_nameIn(List<Object> values) {
            addCriterion("default_character_set_name in", values, "default_character_set_name");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_nameNotIn(List<Object> values) {
            addCriterion("default_character_set_name not in", values, "default_character_set_name");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_nameBetween(Object value1, Object value2) {
            addCriterion("default_character_set_name between", value1, value2, "default_character_set_name");
            return (Criteria) this;
        }

        public Criteria andDefault_character_set_nameNotBetween(Object value1, Object value2) {
            addCriterion("default_character_set_name not between", value1, value2, "default_character_set_name");
            return (Criteria) this;
        }

        public Criteria andSql_pathIsNull() {
            addCriterion("sql_path is null");
            return (Criteria) this;
        }

        public Criteria andSql_pathIsNotNull() {
            addCriterion("sql_path is not null");
            return (Criteria) this;
        }

        public Criteria andSql_pathEqualTo(Object value) {
            addCriterion("sql_path =", value, "sql_path");
            return (Criteria) this;
        }

        public Criteria andSql_pathNotEqualTo(Object value) {
            addCriterion("sql_path <>", value, "sql_path");
            return (Criteria) this;
        }

        public Criteria andSql_pathGreaterThan(Object value) {
            addCriterion("sql_path >", value, "sql_path");
            return (Criteria) this;
        }

        public Criteria andSql_pathGreaterThanOrEqualTo(Object value) {
            addCriterion("sql_path >=", value, "sql_path");
            return (Criteria) this;
        }

        public Criteria andSql_pathLessThan(Object value) {
            addCriterion("sql_path <", value, "sql_path");
            return (Criteria) this;
        }

        public Criteria andSql_pathLessThanOrEqualTo(Object value) {
            addCriterion("sql_path <=", value, "sql_path");
            return (Criteria) this;
        }

        public Criteria andSql_pathIn(List<Object> values) {
            addCriterion("sql_path in", values, "sql_path");
            return (Criteria) this;
        }

        public Criteria andSql_pathNotIn(List<Object> values) {
            addCriterion("sql_path not in", values, "sql_path");
            return (Criteria) this;
        }

        public Criteria andSql_pathBetween(Object value1, Object value2) {
            addCriterion("sql_path between", value1, value2, "sql_path");
            return (Criteria) this;
        }

        public Criteria andSql_pathNotBetween(Object value1, Object value2) {
            addCriterion("sql_path not between", value1, value2, "sql_path");
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