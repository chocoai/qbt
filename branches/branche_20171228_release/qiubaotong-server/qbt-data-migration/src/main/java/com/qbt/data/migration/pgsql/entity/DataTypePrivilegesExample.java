package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class DataTypePrivilegesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DataTypePrivilegesExample() {
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

        public Criteria andObject_catalogIsNull() {
            addCriterion("object_catalog is null");
            return (Criteria) this;
        }

        public Criteria andObject_catalogIsNotNull() {
            addCriterion("object_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andObject_catalogEqualTo(Object value) {
            addCriterion("object_catalog =", value, "object_catalog");
            return (Criteria) this;
        }

        public Criteria andObject_catalogNotEqualTo(Object value) {
            addCriterion("object_catalog <>", value, "object_catalog");
            return (Criteria) this;
        }

        public Criteria andObject_catalogGreaterThan(Object value) {
            addCriterion("object_catalog >", value, "object_catalog");
            return (Criteria) this;
        }

        public Criteria andObject_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("object_catalog >=", value, "object_catalog");
            return (Criteria) this;
        }

        public Criteria andObject_catalogLessThan(Object value) {
            addCriterion("object_catalog <", value, "object_catalog");
            return (Criteria) this;
        }

        public Criteria andObject_catalogLessThanOrEqualTo(Object value) {
            addCriterion("object_catalog <=", value, "object_catalog");
            return (Criteria) this;
        }

        public Criteria andObject_catalogIn(List<Object> values) {
            addCriterion("object_catalog in", values, "object_catalog");
            return (Criteria) this;
        }

        public Criteria andObject_catalogNotIn(List<Object> values) {
            addCriterion("object_catalog not in", values, "object_catalog");
            return (Criteria) this;
        }

        public Criteria andObject_catalogBetween(Object value1, Object value2) {
            addCriterion("object_catalog between", value1, value2, "object_catalog");
            return (Criteria) this;
        }

        public Criteria andObject_catalogNotBetween(Object value1, Object value2) {
            addCriterion("object_catalog not between", value1, value2, "object_catalog");
            return (Criteria) this;
        }

        public Criteria andObject_schemaIsNull() {
            addCriterion("object_schema is null");
            return (Criteria) this;
        }

        public Criteria andObject_schemaIsNotNull() {
            addCriterion("object_schema is not null");
            return (Criteria) this;
        }

        public Criteria andObject_schemaEqualTo(Object value) {
            addCriterion("object_schema =", value, "object_schema");
            return (Criteria) this;
        }

        public Criteria andObject_schemaNotEqualTo(Object value) {
            addCriterion("object_schema <>", value, "object_schema");
            return (Criteria) this;
        }

        public Criteria andObject_schemaGreaterThan(Object value) {
            addCriterion("object_schema >", value, "object_schema");
            return (Criteria) this;
        }

        public Criteria andObject_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("object_schema >=", value, "object_schema");
            return (Criteria) this;
        }

        public Criteria andObject_schemaLessThan(Object value) {
            addCriterion("object_schema <", value, "object_schema");
            return (Criteria) this;
        }

        public Criteria andObject_schemaLessThanOrEqualTo(Object value) {
            addCriterion("object_schema <=", value, "object_schema");
            return (Criteria) this;
        }

        public Criteria andObject_schemaIn(List<Object> values) {
            addCriterion("object_schema in", values, "object_schema");
            return (Criteria) this;
        }

        public Criteria andObject_schemaNotIn(List<Object> values) {
            addCriterion("object_schema not in", values, "object_schema");
            return (Criteria) this;
        }

        public Criteria andObject_schemaBetween(Object value1, Object value2) {
            addCriterion("object_schema between", value1, value2, "object_schema");
            return (Criteria) this;
        }

        public Criteria andObject_schemaNotBetween(Object value1, Object value2) {
            addCriterion("object_schema not between", value1, value2, "object_schema");
            return (Criteria) this;
        }

        public Criteria andObject_nameIsNull() {
            addCriterion("object_name is null");
            return (Criteria) this;
        }

        public Criteria andObject_nameIsNotNull() {
            addCriterion("object_name is not null");
            return (Criteria) this;
        }

        public Criteria andObject_nameEqualTo(Object value) {
            addCriterion("object_name =", value, "object_name");
            return (Criteria) this;
        }

        public Criteria andObject_nameNotEqualTo(Object value) {
            addCriterion("object_name <>", value, "object_name");
            return (Criteria) this;
        }

        public Criteria andObject_nameGreaterThan(Object value) {
            addCriterion("object_name >", value, "object_name");
            return (Criteria) this;
        }

        public Criteria andObject_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("object_name >=", value, "object_name");
            return (Criteria) this;
        }

        public Criteria andObject_nameLessThan(Object value) {
            addCriterion("object_name <", value, "object_name");
            return (Criteria) this;
        }

        public Criteria andObject_nameLessThanOrEqualTo(Object value) {
            addCriterion("object_name <=", value, "object_name");
            return (Criteria) this;
        }

        public Criteria andObject_nameIn(List<Object> values) {
            addCriterion("object_name in", values, "object_name");
            return (Criteria) this;
        }

        public Criteria andObject_nameNotIn(List<Object> values) {
            addCriterion("object_name not in", values, "object_name");
            return (Criteria) this;
        }

        public Criteria andObject_nameBetween(Object value1, Object value2) {
            addCriterion("object_name between", value1, value2, "object_name");
            return (Criteria) this;
        }

        public Criteria andObject_nameNotBetween(Object value1, Object value2) {
            addCriterion("object_name not between", value1, value2, "object_name");
            return (Criteria) this;
        }

        public Criteria andObject_typeIsNull() {
            addCriterion("object_type is null");
            return (Criteria) this;
        }

        public Criteria andObject_typeIsNotNull() {
            addCriterion("object_type is not null");
            return (Criteria) this;
        }

        public Criteria andObject_typeEqualTo(Object value) {
            addCriterion("object_type =", value, "object_type");
            return (Criteria) this;
        }

        public Criteria andObject_typeNotEqualTo(Object value) {
            addCriterion("object_type <>", value, "object_type");
            return (Criteria) this;
        }

        public Criteria andObject_typeGreaterThan(Object value) {
            addCriterion("object_type >", value, "object_type");
            return (Criteria) this;
        }

        public Criteria andObject_typeGreaterThanOrEqualTo(Object value) {
            addCriterion("object_type >=", value, "object_type");
            return (Criteria) this;
        }

        public Criteria andObject_typeLessThan(Object value) {
            addCriterion("object_type <", value, "object_type");
            return (Criteria) this;
        }

        public Criteria andObject_typeLessThanOrEqualTo(Object value) {
            addCriterion("object_type <=", value, "object_type");
            return (Criteria) this;
        }

        public Criteria andObject_typeIn(List<Object> values) {
            addCriterion("object_type in", values, "object_type");
            return (Criteria) this;
        }

        public Criteria andObject_typeNotIn(List<Object> values) {
            addCriterion("object_type not in", values, "object_type");
            return (Criteria) this;
        }

        public Criteria andObject_typeBetween(Object value1, Object value2) {
            addCriterion("object_type between", value1, value2, "object_type");
            return (Criteria) this;
        }

        public Criteria andObject_typeNotBetween(Object value1, Object value2) {
            addCriterion("object_type not between", value1, value2, "object_type");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierIsNull() {
            addCriterion("dtd_identifier is null");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierIsNotNull() {
            addCriterion("dtd_identifier is not null");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierEqualTo(Object value) {
            addCriterion("dtd_identifier =", value, "dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierNotEqualTo(Object value) {
            addCriterion("dtd_identifier <>", value, "dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierGreaterThan(Object value) {
            addCriterion("dtd_identifier >", value, "dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierGreaterThanOrEqualTo(Object value) {
            addCriterion("dtd_identifier >=", value, "dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierLessThan(Object value) {
            addCriterion("dtd_identifier <", value, "dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierLessThanOrEqualTo(Object value) {
            addCriterion("dtd_identifier <=", value, "dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierIn(List<Object> values) {
            addCriterion("dtd_identifier in", values, "dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierNotIn(List<Object> values) {
            addCriterion("dtd_identifier not in", values, "dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierBetween(Object value1, Object value2) {
            addCriterion("dtd_identifier between", value1, value2, "dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierNotBetween(Object value1, Object value2) {
            addCriterion("dtd_identifier not between", value1, value2, "dtd_identifier");
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