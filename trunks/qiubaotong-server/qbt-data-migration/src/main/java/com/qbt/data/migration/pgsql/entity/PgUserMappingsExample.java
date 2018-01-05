package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgUserMappingsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgUserMappingsExample() {
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

        public Criteria andOidIsNull() {
            addCriterion("oid is null");
            return (Criteria) this;
        }

        public Criteria andOidIsNotNull() {
            addCriterion("oid is not null");
            return (Criteria) this;
        }

        public Criteria andOidEqualTo(Long value) {
            addCriterion("oid =", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotEqualTo(Long value) {
            addCriterion("oid <>", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThan(Long value) {
            addCriterion("oid >", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThanOrEqualTo(Long value) {
            addCriterion("oid >=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThan(Long value) {
            addCriterion("oid <", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThanOrEqualTo(Long value) {
            addCriterion("oid <=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidIn(List<Long> values) {
            addCriterion("oid in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotIn(List<Long> values) {
            addCriterion("oid not in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidBetween(Long value1, Long value2) {
            addCriterion("oid between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotBetween(Long value1, Long value2) {
            addCriterion("oid not between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andUmoptionsIsNull() {
            addCriterion("umoptions is null");
            return (Criteria) this;
        }

        public Criteria andUmoptionsIsNotNull() {
            addCriterion("umoptions is not null");
            return (Criteria) this;
        }

        public Criteria andUmoptionsEqualTo(Object value) {
            addCriterion("umoptions =", value, "umoptions");
            return (Criteria) this;
        }

        public Criteria andUmoptionsNotEqualTo(Object value) {
            addCriterion("umoptions <>", value, "umoptions");
            return (Criteria) this;
        }

        public Criteria andUmoptionsGreaterThan(Object value) {
            addCriterion("umoptions >", value, "umoptions");
            return (Criteria) this;
        }

        public Criteria andUmoptionsGreaterThanOrEqualTo(Object value) {
            addCriterion("umoptions >=", value, "umoptions");
            return (Criteria) this;
        }

        public Criteria andUmoptionsLessThan(Object value) {
            addCriterion("umoptions <", value, "umoptions");
            return (Criteria) this;
        }

        public Criteria andUmoptionsLessThanOrEqualTo(Object value) {
            addCriterion("umoptions <=", value, "umoptions");
            return (Criteria) this;
        }

        public Criteria andUmoptionsIn(List<Object> values) {
            addCriterion("umoptions in", values, "umoptions");
            return (Criteria) this;
        }

        public Criteria andUmoptionsNotIn(List<Object> values) {
            addCriterion("umoptions not in", values, "umoptions");
            return (Criteria) this;
        }

        public Criteria andUmoptionsBetween(Object value1, Object value2) {
            addCriterion("umoptions between", value1, value2, "umoptions");
            return (Criteria) this;
        }

        public Criteria andUmoptionsNotBetween(Object value1, Object value2) {
            addCriterion("umoptions not between", value1, value2, "umoptions");
            return (Criteria) this;
        }

        public Criteria andUmuserIsNull() {
            addCriterion("umuser is null");
            return (Criteria) this;
        }

        public Criteria andUmuserIsNotNull() {
            addCriterion("umuser is not null");
            return (Criteria) this;
        }

        public Criteria andUmuserEqualTo(Long value) {
            addCriterion("umuser =", value, "umuser");
            return (Criteria) this;
        }

        public Criteria andUmuserNotEqualTo(Long value) {
            addCriterion("umuser <>", value, "umuser");
            return (Criteria) this;
        }

        public Criteria andUmuserGreaterThan(Long value) {
            addCriterion("umuser >", value, "umuser");
            return (Criteria) this;
        }

        public Criteria andUmuserGreaterThanOrEqualTo(Long value) {
            addCriterion("umuser >=", value, "umuser");
            return (Criteria) this;
        }

        public Criteria andUmuserLessThan(Long value) {
            addCriterion("umuser <", value, "umuser");
            return (Criteria) this;
        }

        public Criteria andUmuserLessThanOrEqualTo(Long value) {
            addCriterion("umuser <=", value, "umuser");
            return (Criteria) this;
        }

        public Criteria andUmuserIn(List<Long> values) {
            addCriterion("umuser in", values, "umuser");
            return (Criteria) this;
        }

        public Criteria andUmuserNotIn(List<Long> values) {
            addCriterion("umuser not in", values, "umuser");
            return (Criteria) this;
        }

        public Criteria andUmuserBetween(Long value1, Long value2) {
            addCriterion("umuser between", value1, value2, "umuser");
            return (Criteria) this;
        }

        public Criteria andUmuserNotBetween(Long value1, Long value2) {
            addCriterion("umuser not between", value1, value2, "umuser");
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

        public Criteria andSrvownerIsNull() {
            addCriterion("srvowner is null");
            return (Criteria) this;
        }

        public Criteria andSrvownerIsNotNull() {
            addCriterion("srvowner is not null");
            return (Criteria) this;
        }

        public Criteria andSrvownerEqualTo(Object value) {
            addCriterion("srvowner =", value, "srvowner");
            return (Criteria) this;
        }

        public Criteria andSrvownerNotEqualTo(Object value) {
            addCriterion("srvowner <>", value, "srvowner");
            return (Criteria) this;
        }

        public Criteria andSrvownerGreaterThan(Object value) {
            addCriterion("srvowner >", value, "srvowner");
            return (Criteria) this;
        }

        public Criteria andSrvownerGreaterThanOrEqualTo(Object value) {
            addCriterion("srvowner >=", value, "srvowner");
            return (Criteria) this;
        }

        public Criteria andSrvownerLessThan(Object value) {
            addCriterion("srvowner <", value, "srvowner");
            return (Criteria) this;
        }

        public Criteria andSrvownerLessThanOrEqualTo(Object value) {
            addCriterion("srvowner <=", value, "srvowner");
            return (Criteria) this;
        }

        public Criteria andSrvownerIn(List<Object> values) {
            addCriterion("srvowner in", values, "srvowner");
            return (Criteria) this;
        }

        public Criteria andSrvownerNotIn(List<Object> values) {
            addCriterion("srvowner not in", values, "srvowner");
            return (Criteria) this;
        }

        public Criteria andSrvownerBetween(Object value1, Object value2) {
            addCriterion("srvowner between", value1, value2, "srvowner");
            return (Criteria) this;
        }

        public Criteria andSrvownerNotBetween(Object value1, Object value2) {
            addCriterion("srvowner not between", value1, value2, "srvowner");
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