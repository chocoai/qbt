package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class UsagePrivilegesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UsagePrivilegesExample() {
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

        public Criteria andGrantorIsNull() {
            addCriterion("grantor is null");
            return (Criteria) this;
        }

        public Criteria andGrantorIsNotNull() {
            addCriterion("grantor is not null");
            return (Criteria) this;
        }

        public Criteria andGrantorEqualTo(Object value) {
            addCriterion("grantor =", value, "grantor");
            return (Criteria) this;
        }

        public Criteria andGrantorNotEqualTo(Object value) {
            addCriterion("grantor <>", value, "grantor");
            return (Criteria) this;
        }

        public Criteria andGrantorGreaterThan(Object value) {
            addCriterion("grantor >", value, "grantor");
            return (Criteria) this;
        }

        public Criteria andGrantorGreaterThanOrEqualTo(Object value) {
            addCriterion("grantor >=", value, "grantor");
            return (Criteria) this;
        }

        public Criteria andGrantorLessThan(Object value) {
            addCriterion("grantor <", value, "grantor");
            return (Criteria) this;
        }

        public Criteria andGrantorLessThanOrEqualTo(Object value) {
            addCriterion("grantor <=", value, "grantor");
            return (Criteria) this;
        }

        public Criteria andGrantorIn(List<Object> values) {
            addCriterion("grantor in", values, "grantor");
            return (Criteria) this;
        }

        public Criteria andGrantorNotIn(List<Object> values) {
            addCriterion("grantor not in", values, "grantor");
            return (Criteria) this;
        }

        public Criteria andGrantorBetween(Object value1, Object value2) {
            addCriterion("grantor between", value1, value2, "grantor");
            return (Criteria) this;
        }

        public Criteria andGrantorNotBetween(Object value1, Object value2) {
            addCriterion("grantor not between", value1, value2, "grantor");
            return (Criteria) this;
        }

        public Criteria andGranteeIsNull() {
            addCriterion("grantee is null");
            return (Criteria) this;
        }

        public Criteria andGranteeIsNotNull() {
            addCriterion("grantee is not null");
            return (Criteria) this;
        }

        public Criteria andGranteeEqualTo(Object value) {
            addCriterion("grantee =", value, "grantee");
            return (Criteria) this;
        }

        public Criteria andGranteeNotEqualTo(Object value) {
            addCriterion("grantee <>", value, "grantee");
            return (Criteria) this;
        }

        public Criteria andGranteeGreaterThan(Object value) {
            addCriterion("grantee >", value, "grantee");
            return (Criteria) this;
        }

        public Criteria andGranteeGreaterThanOrEqualTo(Object value) {
            addCriterion("grantee >=", value, "grantee");
            return (Criteria) this;
        }

        public Criteria andGranteeLessThan(Object value) {
            addCriterion("grantee <", value, "grantee");
            return (Criteria) this;
        }

        public Criteria andGranteeLessThanOrEqualTo(Object value) {
            addCriterion("grantee <=", value, "grantee");
            return (Criteria) this;
        }

        public Criteria andGranteeIn(List<Object> values) {
            addCriterion("grantee in", values, "grantee");
            return (Criteria) this;
        }

        public Criteria andGranteeNotIn(List<Object> values) {
            addCriterion("grantee not in", values, "grantee");
            return (Criteria) this;
        }

        public Criteria andGranteeBetween(Object value1, Object value2) {
            addCriterion("grantee between", value1, value2, "grantee");
            return (Criteria) this;
        }

        public Criteria andGranteeNotBetween(Object value1, Object value2) {
            addCriterion("grantee not between", value1, value2, "grantee");
            return (Criteria) this;
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

        public Criteria andPrivilege_typeIsNull() {
            addCriterion("privilege_type is null");
            return (Criteria) this;
        }

        public Criteria andPrivilege_typeIsNotNull() {
            addCriterion("privilege_type is not null");
            return (Criteria) this;
        }

        public Criteria andPrivilege_typeEqualTo(Object value) {
            addCriterion("privilege_type =", value, "privilege_type");
            return (Criteria) this;
        }

        public Criteria andPrivilege_typeNotEqualTo(Object value) {
            addCriterion("privilege_type <>", value, "privilege_type");
            return (Criteria) this;
        }

        public Criteria andPrivilege_typeGreaterThan(Object value) {
            addCriterion("privilege_type >", value, "privilege_type");
            return (Criteria) this;
        }

        public Criteria andPrivilege_typeGreaterThanOrEqualTo(Object value) {
            addCriterion("privilege_type >=", value, "privilege_type");
            return (Criteria) this;
        }

        public Criteria andPrivilege_typeLessThan(Object value) {
            addCriterion("privilege_type <", value, "privilege_type");
            return (Criteria) this;
        }

        public Criteria andPrivilege_typeLessThanOrEqualTo(Object value) {
            addCriterion("privilege_type <=", value, "privilege_type");
            return (Criteria) this;
        }

        public Criteria andPrivilege_typeIn(List<Object> values) {
            addCriterion("privilege_type in", values, "privilege_type");
            return (Criteria) this;
        }

        public Criteria andPrivilege_typeNotIn(List<Object> values) {
            addCriterion("privilege_type not in", values, "privilege_type");
            return (Criteria) this;
        }

        public Criteria andPrivilege_typeBetween(Object value1, Object value2) {
            addCriterion("privilege_type between", value1, value2, "privilege_type");
            return (Criteria) this;
        }

        public Criteria andPrivilege_typeNotBetween(Object value1, Object value2) {
            addCriterion("privilege_type not between", value1, value2, "privilege_type");
            return (Criteria) this;
        }

        public Criteria andIs_grantableIsNull() {
            addCriterion("is_grantable is null");
            return (Criteria) this;
        }

        public Criteria andIs_grantableIsNotNull() {
            addCriterion("is_grantable is not null");
            return (Criteria) this;
        }

        public Criteria andIs_grantableEqualTo(Object value) {
            addCriterion("is_grantable =", value, "is_grantable");
            return (Criteria) this;
        }

        public Criteria andIs_grantableNotEqualTo(Object value) {
            addCriterion("is_grantable <>", value, "is_grantable");
            return (Criteria) this;
        }

        public Criteria andIs_grantableGreaterThan(Object value) {
            addCriterion("is_grantable >", value, "is_grantable");
            return (Criteria) this;
        }

        public Criteria andIs_grantableGreaterThanOrEqualTo(Object value) {
            addCriterion("is_grantable >=", value, "is_grantable");
            return (Criteria) this;
        }

        public Criteria andIs_grantableLessThan(Object value) {
            addCriterion("is_grantable <", value, "is_grantable");
            return (Criteria) this;
        }

        public Criteria andIs_grantableLessThanOrEqualTo(Object value) {
            addCriterion("is_grantable <=", value, "is_grantable");
            return (Criteria) this;
        }

        public Criteria andIs_grantableIn(List<Object> values) {
            addCriterion("is_grantable in", values, "is_grantable");
            return (Criteria) this;
        }

        public Criteria andIs_grantableNotIn(List<Object> values) {
            addCriterion("is_grantable not in", values, "is_grantable");
            return (Criteria) this;
        }

        public Criteria andIs_grantableBetween(Object value1, Object value2) {
            addCriterion("is_grantable between", value1, value2, "is_grantable");
            return (Criteria) this;
        }

        public Criteria andIs_grantableNotBetween(Object value1, Object value2) {
            addCriterion("is_grantable not between", value1, value2, "is_grantable");
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