package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class ForeignServersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ForeignServersExample() {
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

        public Criteria andForeign_data_wrapper_catalogIsNull() {
            addCriterion("foreign_data_wrapper_catalog is null");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_catalogIsNotNull() {
            addCriterion("foreign_data_wrapper_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_catalogEqualTo(Object value) {
            addCriterion("foreign_data_wrapper_catalog =", value, "foreign_data_wrapper_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_catalogNotEqualTo(Object value) {
            addCriterion("foreign_data_wrapper_catalog <>", value, "foreign_data_wrapper_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_catalogGreaterThan(Object value) {
            addCriterion("foreign_data_wrapper_catalog >", value, "foreign_data_wrapper_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("foreign_data_wrapper_catalog >=", value, "foreign_data_wrapper_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_catalogLessThan(Object value) {
            addCriterion("foreign_data_wrapper_catalog <", value, "foreign_data_wrapper_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_catalogLessThanOrEqualTo(Object value) {
            addCriterion("foreign_data_wrapper_catalog <=", value, "foreign_data_wrapper_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_catalogIn(List<Object> values) {
            addCriterion("foreign_data_wrapper_catalog in", values, "foreign_data_wrapper_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_catalogNotIn(List<Object> values) {
            addCriterion("foreign_data_wrapper_catalog not in", values, "foreign_data_wrapper_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_catalogBetween(Object value1, Object value2) {
            addCriterion("foreign_data_wrapper_catalog between", value1, value2, "foreign_data_wrapper_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_catalogNotBetween(Object value1, Object value2) {
            addCriterion("foreign_data_wrapper_catalog not between", value1, value2, "foreign_data_wrapper_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_nameIsNull() {
            addCriterion("foreign_data_wrapper_name is null");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_nameIsNotNull() {
            addCriterion("foreign_data_wrapper_name is not null");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_nameEqualTo(Object value) {
            addCriterion("foreign_data_wrapper_name =", value, "foreign_data_wrapper_name");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_nameNotEqualTo(Object value) {
            addCriterion("foreign_data_wrapper_name <>", value, "foreign_data_wrapper_name");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_nameGreaterThan(Object value) {
            addCriterion("foreign_data_wrapper_name >", value, "foreign_data_wrapper_name");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("foreign_data_wrapper_name >=", value, "foreign_data_wrapper_name");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_nameLessThan(Object value) {
            addCriterion("foreign_data_wrapper_name <", value, "foreign_data_wrapper_name");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_nameLessThanOrEqualTo(Object value) {
            addCriterion("foreign_data_wrapper_name <=", value, "foreign_data_wrapper_name");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_nameIn(List<Object> values) {
            addCriterion("foreign_data_wrapper_name in", values, "foreign_data_wrapper_name");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_nameNotIn(List<Object> values) {
            addCriterion("foreign_data_wrapper_name not in", values, "foreign_data_wrapper_name");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_nameBetween(Object value1, Object value2) {
            addCriterion("foreign_data_wrapper_name between", value1, value2, "foreign_data_wrapper_name");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_nameNotBetween(Object value1, Object value2) {
            addCriterion("foreign_data_wrapper_name not between", value1, value2, "foreign_data_wrapper_name");
            return (Criteria) this;
        }

        public Criteria andForeign_server_typeIsNull() {
            addCriterion("foreign_server_type is null");
            return (Criteria) this;
        }

        public Criteria andForeign_server_typeIsNotNull() {
            addCriterion("foreign_server_type is not null");
            return (Criteria) this;
        }

        public Criteria andForeign_server_typeEqualTo(Object value) {
            addCriterion("foreign_server_type =", value, "foreign_server_type");
            return (Criteria) this;
        }

        public Criteria andForeign_server_typeNotEqualTo(Object value) {
            addCriterion("foreign_server_type <>", value, "foreign_server_type");
            return (Criteria) this;
        }

        public Criteria andForeign_server_typeGreaterThan(Object value) {
            addCriterion("foreign_server_type >", value, "foreign_server_type");
            return (Criteria) this;
        }

        public Criteria andForeign_server_typeGreaterThanOrEqualTo(Object value) {
            addCriterion("foreign_server_type >=", value, "foreign_server_type");
            return (Criteria) this;
        }

        public Criteria andForeign_server_typeLessThan(Object value) {
            addCriterion("foreign_server_type <", value, "foreign_server_type");
            return (Criteria) this;
        }

        public Criteria andForeign_server_typeLessThanOrEqualTo(Object value) {
            addCriterion("foreign_server_type <=", value, "foreign_server_type");
            return (Criteria) this;
        }

        public Criteria andForeign_server_typeIn(List<Object> values) {
            addCriterion("foreign_server_type in", values, "foreign_server_type");
            return (Criteria) this;
        }

        public Criteria andForeign_server_typeNotIn(List<Object> values) {
            addCriterion("foreign_server_type not in", values, "foreign_server_type");
            return (Criteria) this;
        }

        public Criteria andForeign_server_typeBetween(Object value1, Object value2) {
            addCriterion("foreign_server_type between", value1, value2, "foreign_server_type");
            return (Criteria) this;
        }

        public Criteria andForeign_server_typeNotBetween(Object value1, Object value2) {
            addCriterion("foreign_server_type not between", value1, value2, "foreign_server_type");
            return (Criteria) this;
        }

        public Criteria andForeign_server_versionIsNull() {
            addCriterion("foreign_server_version is null");
            return (Criteria) this;
        }

        public Criteria andForeign_server_versionIsNotNull() {
            addCriterion("foreign_server_version is not null");
            return (Criteria) this;
        }

        public Criteria andForeign_server_versionEqualTo(Object value) {
            addCriterion("foreign_server_version =", value, "foreign_server_version");
            return (Criteria) this;
        }

        public Criteria andForeign_server_versionNotEqualTo(Object value) {
            addCriterion("foreign_server_version <>", value, "foreign_server_version");
            return (Criteria) this;
        }

        public Criteria andForeign_server_versionGreaterThan(Object value) {
            addCriterion("foreign_server_version >", value, "foreign_server_version");
            return (Criteria) this;
        }

        public Criteria andForeign_server_versionGreaterThanOrEqualTo(Object value) {
            addCriterion("foreign_server_version >=", value, "foreign_server_version");
            return (Criteria) this;
        }

        public Criteria andForeign_server_versionLessThan(Object value) {
            addCriterion("foreign_server_version <", value, "foreign_server_version");
            return (Criteria) this;
        }

        public Criteria andForeign_server_versionLessThanOrEqualTo(Object value) {
            addCriterion("foreign_server_version <=", value, "foreign_server_version");
            return (Criteria) this;
        }

        public Criteria andForeign_server_versionIn(List<Object> values) {
            addCriterion("foreign_server_version in", values, "foreign_server_version");
            return (Criteria) this;
        }

        public Criteria andForeign_server_versionNotIn(List<Object> values) {
            addCriterion("foreign_server_version not in", values, "foreign_server_version");
            return (Criteria) this;
        }

        public Criteria andForeign_server_versionBetween(Object value1, Object value2) {
            addCriterion("foreign_server_version between", value1, value2, "foreign_server_version");
            return (Criteria) this;
        }

        public Criteria andForeign_server_versionNotBetween(Object value1, Object value2) {
            addCriterion("foreign_server_version not between", value1, value2, "foreign_server_version");
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