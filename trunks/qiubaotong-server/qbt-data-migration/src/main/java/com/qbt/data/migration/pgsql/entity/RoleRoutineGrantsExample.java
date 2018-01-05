package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class RoleRoutineGrantsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoleRoutineGrantsExample() {
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

        public Criteria andSpecific_catalogIsNull() {
            addCriterion("specific_catalog is null");
            return (Criteria) this;
        }

        public Criteria andSpecific_catalogIsNotNull() {
            addCriterion("specific_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andSpecific_catalogEqualTo(Object value) {
            addCriterion("specific_catalog =", value, "specific_catalog");
            return (Criteria) this;
        }

        public Criteria andSpecific_catalogNotEqualTo(Object value) {
            addCriterion("specific_catalog <>", value, "specific_catalog");
            return (Criteria) this;
        }

        public Criteria andSpecific_catalogGreaterThan(Object value) {
            addCriterion("specific_catalog >", value, "specific_catalog");
            return (Criteria) this;
        }

        public Criteria andSpecific_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("specific_catalog >=", value, "specific_catalog");
            return (Criteria) this;
        }

        public Criteria andSpecific_catalogLessThan(Object value) {
            addCriterion("specific_catalog <", value, "specific_catalog");
            return (Criteria) this;
        }

        public Criteria andSpecific_catalogLessThanOrEqualTo(Object value) {
            addCriterion("specific_catalog <=", value, "specific_catalog");
            return (Criteria) this;
        }

        public Criteria andSpecific_catalogIn(List<Object> values) {
            addCriterion("specific_catalog in", values, "specific_catalog");
            return (Criteria) this;
        }

        public Criteria andSpecific_catalogNotIn(List<Object> values) {
            addCriterion("specific_catalog not in", values, "specific_catalog");
            return (Criteria) this;
        }

        public Criteria andSpecific_catalogBetween(Object value1, Object value2) {
            addCriterion("specific_catalog between", value1, value2, "specific_catalog");
            return (Criteria) this;
        }

        public Criteria andSpecific_catalogNotBetween(Object value1, Object value2) {
            addCriterion("specific_catalog not between", value1, value2, "specific_catalog");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaIsNull() {
            addCriterion("specific_schema is null");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaIsNotNull() {
            addCriterion("specific_schema is not null");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaEqualTo(Object value) {
            addCriterion("specific_schema =", value, "specific_schema");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaNotEqualTo(Object value) {
            addCriterion("specific_schema <>", value, "specific_schema");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaGreaterThan(Object value) {
            addCriterion("specific_schema >", value, "specific_schema");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("specific_schema >=", value, "specific_schema");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaLessThan(Object value) {
            addCriterion("specific_schema <", value, "specific_schema");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaLessThanOrEqualTo(Object value) {
            addCriterion("specific_schema <=", value, "specific_schema");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaIn(List<Object> values) {
            addCriterion("specific_schema in", values, "specific_schema");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaNotIn(List<Object> values) {
            addCriterion("specific_schema not in", values, "specific_schema");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaBetween(Object value1, Object value2) {
            addCriterion("specific_schema between", value1, value2, "specific_schema");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaNotBetween(Object value1, Object value2) {
            addCriterion("specific_schema not between", value1, value2, "specific_schema");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameIsNull() {
            addCriterion("specific_name is null");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameIsNotNull() {
            addCriterion("specific_name is not null");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameEqualTo(Object value) {
            addCriterion("specific_name =", value, "specific_name");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameNotEqualTo(Object value) {
            addCriterion("specific_name <>", value, "specific_name");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameGreaterThan(Object value) {
            addCriterion("specific_name >", value, "specific_name");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("specific_name >=", value, "specific_name");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameLessThan(Object value) {
            addCriterion("specific_name <", value, "specific_name");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameLessThanOrEqualTo(Object value) {
            addCriterion("specific_name <=", value, "specific_name");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameIn(List<Object> values) {
            addCriterion("specific_name in", values, "specific_name");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameNotIn(List<Object> values) {
            addCriterion("specific_name not in", values, "specific_name");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameBetween(Object value1, Object value2) {
            addCriterion("specific_name between", value1, value2, "specific_name");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameNotBetween(Object value1, Object value2) {
            addCriterion("specific_name not between", value1, value2, "specific_name");
            return (Criteria) this;
        }

        public Criteria andRoutine_catalogIsNull() {
            addCriterion("routine_catalog is null");
            return (Criteria) this;
        }

        public Criteria andRoutine_catalogIsNotNull() {
            addCriterion("routine_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andRoutine_catalogEqualTo(Object value) {
            addCriterion("routine_catalog =", value, "routine_catalog");
            return (Criteria) this;
        }

        public Criteria andRoutine_catalogNotEqualTo(Object value) {
            addCriterion("routine_catalog <>", value, "routine_catalog");
            return (Criteria) this;
        }

        public Criteria andRoutine_catalogGreaterThan(Object value) {
            addCriterion("routine_catalog >", value, "routine_catalog");
            return (Criteria) this;
        }

        public Criteria andRoutine_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("routine_catalog >=", value, "routine_catalog");
            return (Criteria) this;
        }

        public Criteria andRoutine_catalogLessThan(Object value) {
            addCriterion("routine_catalog <", value, "routine_catalog");
            return (Criteria) this;
        }

        public Criteria andRoutine_catalogLessThanOrEqualTo(Object value) {
            addCriterion("routine_catalog <=", value, "routine_catalog");
            return (Criteria) this;
        }

        public Criteria andRoutine_catalogIn(List<Object> values) {
            addCriterion("routine_catalog in", values, "routine_catalog");
            return (Criteria) this;
        }

        public Criteria andRoutine_catalogNotIn(List<Object> values) {
            addCriterion("routine_catalog not in", values, "routine_catalog");
            return (Criteria) this;
        }

        public Criteria andRoutine_catalogBetween(Object value1, Object value2) {
            addCriterion("routine_catalog between", value1, value2, "routine_catalog");
            return (Criteria) this;
        }

        public Criteria andRoutine_catalogNotBetween(Object value1, Object value2) {
            addCriterion("routine_catalog not between", value1, value2, "routine_catalog");
            return (Criteria) this;
        }

        public Criteria andRoutine_schemaIsNull() {
            addCriterion("routine_schema is null");
            return (Criteria) this;
        }

        public Criteria andRoutine_schemaIsNotNull() {
            addCriterion("routine_schema is not null");
            return (Criteria) this;
        }

        public Criteria andRoutine_schemaEqualTo(Object value) {
            addCriterion("routine_schema =", value, "routine_schema");
            return (Criteria) this;
        }

        public Criteria andRoutine_schemaNotEqualTo(Object value) {
            addCriterion("routine_schema <>", value, "routine_schema");
            return (Criteria) this;
        }

        public Criteria andRoutine_schemaGreaterThan(Object value) {
            addCriterion("routine_schema >", value, "routine_schema");
            return (Criteria) this;
        }

        public Criteria andRoutine_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("routine_schema >=", value, "routine_schema");
            return (Criteria) this;
        }

        public Criteria andRoutine_schemaLessThan(Object value) {
            addCriterion("routine_schema <", value, "routine_schema");
            return (Criteria) this;
        }

        public Criteria andRoutine_schemaLessThanOrEqualTo(Object value) {
            addCriterion("routine_schema <=", value, "routine_schema");
            return (Criteria) this;
        }

        public Criteria andRoutine_schemaIn(List<Object> values) {
            addCriterion("routine_schema in", values, "routine_schema");
            return (Criteria) this;
        }

        public Criteria andRoutine_schemaNotIn(List<Object> values) {
            addCriterion("routine_schema not in", values, "routine_schema");
            return (Criteria) this;
        }

        public Criteria andRoutine_schemaBetween(Object value1, Object value2) {
            addCriterion("routine_schema between", value1, value2, "routine_schema");
            return (Criteria) this;
        }

        public Criteria andRoutine_schemaNotBetween(Object value1, Object value2) {
            addCriterion("routine_schema not between", value1, value2, "routine_schema");
            return (Criteria) this;
        }

        public Criteria andRoutine_nameIsNull() {
            addCriterion("routine_name is null");
            return (Criteria) this;
        }

        public Criteria andRoutine_nameIsNotNull() {
            addCriterion("routine_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoutine_nameEqualTo(Object value) {
            addCriterion("routine_name =", value, "routine_name");
            return (Criteria) this;
        }

        public Criteria andRoutine_nameNotEqualTo(Object value) {
            addCriterion("routine_name <>", value, "routine_name");
            return (Criteria) this;
        }

        public Criteria andRoutine_nameGreaterThan(Object value) {
            addCriterion("routine_name >", value, "routine_name");
            return (Criteria) this;
        }

        public Criteria andRoutine_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("routine_name >=", value, "routine_name");
            return (Criteria) this;
        }

        public Criteria andRoutine_nameLessThan(Object value) {
            addCriterion("routine_name <", value, "routine_name");
            return (Criteria) this;
        }

        public Criteria andRoutine_nameLessThanOrEqualTo(Object value) {
            addCriterion("routine_name <=", value, "routine_name");
            return (Criteria) this;
        }

        public Criteria andRoutine_nameIn(List<Object> values) {
            addCriterion("routine_name in", values, "routine_name");
            return (Criteria) this;
        }

        public Criteria andRoutine_nameNotIn(List<Object> values) {
            addCriterion("routine_name not in", values, "routine_name");
            return (Criteria) this;
        }

        public Criteria andRoutine_nameBetween(Object value1, Object value2) {
            addCriterion("routine_name between", value1, value2, "routine_name");
            return (Criteria) this;
        }

        public Criteria andRoutine_nameNotBetween(Object value1, Object value2) {
            addCriterion("routine_name not between", value1, value2, "routine_name");
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