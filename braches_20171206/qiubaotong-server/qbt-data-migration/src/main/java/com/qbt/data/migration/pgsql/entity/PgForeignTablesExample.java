package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgForeignTablesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgForeignTablesExample() {
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

        public Criteria andForeign_table_catalogIsNull() {
            addCriterion("foreign_table_catalog is null");
            return (Criteria) this;
        }

        public Criteria andForeign_table_catalogIsNotNull() {
            addCriterion("foreign_table_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andForeign_table_catalogEqualTo(Object value) {
            addCriterion("foreign_table_catalog =", value, "foreign_table_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_table_catalogNotEqualTo(Object value) {
            addCriterion("foreign_table_catalog <>", value, "foreign_table_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_table_catalogGreaterThan(Object value) {
            addCriterion("foreign_table_catalog >", value, "foreign_table_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_table_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("foreign_table_catalog >=", value, "foreign_table_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_table_catalogLessThan(Object value) {
            addCriterion("foreign_table_catalog <", value, "foreign_table_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_table_catalogLessThanOrEqualTo(Object value) {
            addCriterion("foreign_table_catalog <=", value, "foreign_table_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_table_catalogIn(List<Object> values) {
            addCriterion("foreign_table_catalog in", values, "foreign_table_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_table_catalogNotIn(List<Object> values) {
            addCriterion("foreign_table_catalog not in", values, "foreign_table_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_table_catalogBetween(Object value1, Object value2) {
            addCriterion("foreign_table_catalog between", value1, value2, "foreign_table_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_table_catalogNotBetween(Object value1, Object value2) {
            addCriterion("foreign_table_catalog not between", value1, value2, "foreign_table_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_table_schemaIsNull() {
            addCriterion("foreign_table_schema is null");
            return (Criteria) this;
        }

        public Criteria andForeign_table_schemaIsNotNull() {
            addCriterion("foreign_table_schema is not null");
            return (Criteria) this;
        }

        public Criteria andForeign_table_schemaEqualTo(String value) {
            addCriterion("foreign_table_schema =", value, "foreign_table_schema");
            return (Criteria) this;
        }

        public Criteria andForeign_table_schemaNotEqualTo(String value) {
            addCriterion("foreign_table_schema <>", value, "foreign_table_schema");
            return (Criteria) this;
        }

        public Criteria andForeign_table_schemaGreaterThan(String value) {
            addCriterion("foreign_table_schema >", value, "foreign_table_schema");
            return (Criteria) this;
        }

        public Criteria andForeign_table_schemaGreaterThanOrEqualTo(String value) {
            addCriterion("foreign_table_schema >=", value, "foreign_table_schema");
            return (Criteria) this;
        }

        public Criteria andForeign_table_schemaLessThan(String value) {
            addCriterion("foreign_table_schema <", value, "foreign_table_schema");
            return (Criteria) this;
        }

        public Criteria andForeign_table_schemaLessThanOrEqualTo(String value) {
            addCriterion("foreign_table_schema <=", value, "foreign_table_schema");
            return (Criteria) this;
        }

        public Criteria andForeign_table_schemaLike(String value) {
            addCriterion("foreign_table_schema like", value, "foreign_table_schema");
            return (Criteria) this;
        }

        public Criteria andForeign_table_schemaNotLike(String value) {
            addCriterion("foreign_table_schema not like", value, "foreign_table_schema");
            return (Criteria) this;
        }

        public Criteria andForeign_table_schemaIn(List<String> values) {
            addCriterion("foreign_table_schema in", values, "foreign_table_schema");
            return (Criteria) this;
        }

        public Criteria andForeign_table_schemaNotIn(List<String> values) {
            addCriterion("foreign_table_schema not in", values, "foreign_table_schema");
            return (Criteria) this;
        }

        public Criteria andForeign_table_schemaBetween(String value1, String value2) {
            addCriterion("foreign_table_schema between", value1, value2, "foreign_table_schema");
            return (Criteria) this;
        }

        public Criteria andForeign_table_schemaNotBetween(String value1, String value2) {
            addCriterion("foreign_table_schema not between", value1, value2, "foreign_table_schema");
            return (Criteria) this;
        }

        public Criteria andForeign_table_nameIsNull() {
            addCriterion("foreign_table_name is null");
            return (Criteria) this;
        }

        public Criteria andForeign_table_nameIsNotNull() {
            addCriterion("foreign_table_name is not null");
            return (Criteria) this;
        }

        public Criteria andForeign_table_nameEqualTo(String value) {
            addCriterion("foreign_table_name =", value, "foreign_table_name");
            return (Criteria) this;
        }

        public Criteria andForeign_table_nameNotEqualTo(String value) {
            addCriterion("foreign_table_name <>", value, "foreign_table_name");
            return (Criteria) this;
        }

        public Criteria andForeign_table_nameGreaterThan(String value) {
            addCriterion("foreign_table_name >", value, "foreign_table_name");
            return (Criteria) this;
        }

        public Criteria andForeign_table_nameGreaterThanOrEqualTo(String value) {
            addCriterion("foreign_table_name >=", value, "foreign_table_name");
            return (Criteria) this;
        }

        public Criteria andForeign_table_nameLessThan(String value) {
            addCriterion("foreign_table_name <", value, "foreign_table_name");
            return (Criteria) this;
        }

        public Criteria andForeign_table_nameLessThanOrEqualTo(String value) {
            addCriterion("foreign_table_name <=", value, "foreign_table_name");
            return (Criteria) this;
        }

        public Criteria andForeign_table_nameLike(String value) {
            addCriterion("foreign_table_name like", value, "foreign_table_name");
            return (Criteria) this;
        }

        public Criteria andForeign_table_nameNotLike(String value) {
            addCriterion("foreign_table_name not like", value, "foreign_table_name");
            return (Criteria) this;
        }

        public Criteria andForeign_table_nameIn(List<String> values) {
            addCriterion("foreign_table_name in", values, "foreign_table_name");
            return (Criteria) this;
        }

        public Criteria andForeign_table_nameNotIn(List<String> values) {
            addCriterion("foreign_table_name not in", values, "foreign_table_name");
            return (Criteria) this;
        }

        public Criteria andForeign_table_nameBetween(String value1, String value2) {
            addCriterion("foreign_table_name between", value1, value2, "foreign_table_name");
            return (Criteria) this;
        }

        public Criteria andForeign_table_nameNotBetween(String value1, String value2) {
            addCriterion("foreign_table_name not between", value1, value2, "foreign_table_name");
            return (Criteria) this;
        }

        public Criteria andFtoptionsIsNull() {
            addCriterion("ftoptions is null");
            return (Criteria) this;
        }

        public Criteria andFtoptionsIsNotNull() {
            addCriterion("ftoptions is not null");
            return (Criteria) this;
        }

        public Criteria andFtoptionsEqualTo(Object value) {
            addCriterion("ftoptions =", value, "ftoptions");
            return (Criteria) this;
        }

        public Criteria andFtoptionsNotEqualTo(Object value) {
            addCriterion("ftoptions <>", value, "ftoptions");
            return (Criteria) this;
        }

        public Criteria andFtoptionsGreaterThan(Object value) {
            addCriterion("ftoptions >", value, "ftoptions");
            return (Criteria) this;
        }

        public Criteria andFtoptionsGreaterThanOrEqualTo(Object value) {
            addCriterion("ftoptions >=", value, "ftoptions");
            return (Criteria) this;
        }

        public Criteria andFtoptionsLessThan(Object value) {
            addCriterion("ftoptions <", value, "ftoptions");
            return (Criteria) this;
        }

        public Criteria andFtoptionsLessThanOrEqualTo(Object value) {
            addCriterion("ftoptions <=", value, "ftoptions");
            return (Criteria) this;
        }

        public Criteria andFtoptionsIn(List<Object> values) {
            addCriterion("ftoptions in", values, "ftoptions");
            return (Criteria) this;
        }

        public Criteria andFtoptionsNotIn(List<Object> values) {
            addCriterion("ftoptions not in", values, "ftoptions");
            return (Criteria) this;
        }

        public Criteria andFtoptionsBetween(Object value1, Object value2) {
            addCriterion("ftoptions between", value1, value2, "ftoptions");
            return (Criteria) this;
        }

        public Criteria andFtoptionsNotBetween(Object value1, Object value2) {
            addCriterion("ftoptions not between", value1, value2, "ftoptions");
            return (Criteria) this;
        }

        public Criteria andForeign_server_catalogIsNull() {
            addCriterion("foreign_server_catalog is null");
            return (Criteria) this;
        }

        public Criteria andForeign_server_catalogIsNotNull() {
            addCriterion("foreign_server_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andForeign_server_catalogEqualTo(Object value) {
            addCriterion("foreign_server_catalog =", value, "foreign_server_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_server_catalogNotEqualTo(Object value) {
            addCriterion("foreign_server_catalog <>", value, "foreign_server_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_server_catalogGreaterThan(Object value) {
            addCriterion("foreign_server_catalog >", value, "foreign_server_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_server_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("foreign_server_catalog >=", value, "foreign_server_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_server_catalogLessThan(Object value) {
            addCriterion("foreign_server_catalog <", value, "foreign_server_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_server_catalogLessThanOrEqualTo(Object value) {
            addCriterion("foreign_server_catalog <=", value, "foreign_server_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_server_catalogIn(List<Object> values) {
            addCriterion("foreign_server_catalog in", values, "foreign_server_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_server_catalogNotIn(List<Object> values) {
            addCriterion("foreign_server_catalog not in", values, "foreign_server_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_server_catalogBetween(Object value1, Object value2) {
            addCriterion("foreign_server_catalog between", value1, value2, "foreign_server_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_server_catalogNotBetween(Object value1, Object value2) {
            addCriterion("foreign_server_catalog not between", value1, value2, "foreign_server_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_server_nameIsNull() {
            addCriterion("foreign_server_name is null");
            return (Criteria) this;
        }

        public Criteria andForeign_server_nameIsNotNull() {
            addCriterion("foreign_server_name is not null");
            return (Criteria) this;
        }

        public Criteria andForeign_server_nameEqualTo(Object value) {
            addCriterion("foreign_server_name =", value, "foreign_server_name");
            return (Criteria) this;
        }

        public Criteria andForeign_server_nameNotEqualTo(Object value) {
            addCriterion("foreign_server_name <>", value, "foreign_server_name");
            return (Criteria) this;
        }

        public Criteria andForeign_server_nameGreaterThan(Object value) {
            addCriterion("foreign_server_name >", value, "foreign_server_name");
            return (Criteria) this;
        }

        public Criteria andForeign_server_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("foreign_server_name >=", value, "foreign_server_name");
            return (Criteria) this;
        }

        public Criteria andForeign_server_nameLessThan(Object value) {
            addCriterion("foreign_server_name <", value, "foreign_server_name");
            return (Criteria) this;
        }

        public Criteria andForeign_server_nameLessThanOrEqualTo(Object value) {
            addCriterion("foreign_server_name <=", value, "foreign_server_name");
            return (Criteria) this;
        }

        public Criteria andForeign_server_nameIn(List<Object> values) {
            addCriterion("foreign_server_name in", values, "foreign_server_name");
            return (Criteria) this;
        }

        public Criteria andForeign_server_nameNotIn(List<Object> values) {
            addCriterion("foreign_server_name not in", values, "foreign_server_name");
            return (Criteria) this;
        }

        public Criteria andForeign_server_nameBetween(Object value1, Object value2) {
            addCriterion("foreign_server_name between", value1, value2, "foreign_server_name");
            return (Criteria) this;
        }

        public Criteria andForeign_server_nameNotBetween(Object value1, Object value2) {
            addCriterion("foreign_server_name not between", value1, value2, "foreign_server_name");
            return (Criteria) this;
        }

        public Criteria andAuthorization_identifierIsNull() {
            addCriterion("authorization_identifier is null");
            return (Criteria) this;
        }

        public Criteria andAuthorization_identifierIsNotNull() {
            addCriterion("authorization_identifier is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorization_identifierEqualTo(Object value) {
            addCriterion("authorization_identifier =", value, "authorization_identifier");
            return (Criteria) this;
        }

        public Criteria andAuthorization_identifierNotEqualTo(Object value) {
            addCriterion("authorization_identifier <>", value, "authorization_identifier");
            return (Criteria) this;
        }

        public Criteria andAuthorization_identifierGreaterThan(Object value) {
            addCriterion("authorization_identifier >", value, "authorization_identifier");
            return (Criteria) this;
        }

        public Criteria andAuthorization_identifierGreaterThanOrEqualTo(Object value) {
            addCriterion("authorization_identifier >=", value, "authorization_identifier");
            return (Criteria) this;
        }

        public Criteria andAuthorization_identifierLessThan(Object value) {
            addCriterion("authorization_identifier <", value, "authorization_identifier");
            return (Criteria) this;
        }

        public Criteria andAuthorization_identifierLessThanOrEqualTo(Object value) {
            addCriterion("authorization_identifier <=", value, "authorization_identifier");
            return (Criteria) this;
        }

        public Criteria andAuthorization_identifierIn(List<Object> values) {
            addCriterion("authorization_identifier in", values, "authorization_identifier");
            return (Criteria) this;
        }

        public Criteria andAuthorization_identifierNotIn(List<Object> values) {
            addCriterion("authorization_identifier not in", values, "authorization_identifier");
            return (Criteria) this;
        }

        public Criteria andAuthorization_identifierBetween(Object value1, Object value2) {
            addCriterion("authorization_identifier between", value1, value2, "authorization_identifier");
            return (Criteria) this;
        }

        public Criteria andAuthorization_identifierNotBetween(Object value1, Object value2) {
            addCriterion("authorization_identifier not between", value1, value2, "authorization_identifier");
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