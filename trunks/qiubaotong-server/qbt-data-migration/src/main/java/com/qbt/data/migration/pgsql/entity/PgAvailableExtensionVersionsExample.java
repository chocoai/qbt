package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgAvailableExtensionVersionsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgAvailableExtensionVersionsExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andInstalledIsNull() {
            addCriterion("installed is null");
            return (Criteria) this;
        }

        public Criteria andInstalledIsNotNull() {
            addCriterion("installed is not null");
            return (Criteria) this;
        }

        public Criteria andInstalledEqualTo(Boolean value) {
            addCriterion("installed =", value, "installed");
            return (Criteria) this;
        }

        public Criteria andInstalledNotEqualTo(Boolean value) {
            addCriterion("installed <>", value, "installed");
            return (Criteria) this;
        }

        public Criteria andInstalledGreaterThan(Boolean value) {
            addCriterion("installed >", value, "installed");
            return (Criteria) this;
        }

        public Criteria andInstalledGreaterThanOrEqualTo(Boolean value) {
            addCriterion("installed >=", value, "installed");
            return (Criteria) this;
        }

        public Criteria andInstalledLessThan(Boolean value) {
            addCriterion("installed <", value, "installed");
            return (Criteria) this;
        }

        public Criteria andInstalledLessThanOrEqualTo(Boolean value) {
            addCriterion("installed <=", value, "installed");
            return (Criteria) this;
        }

        public Criteria andInstalledIn(List<Boolean> values) {
            addCriterion("installed in", values, "installed");
            return (Criteria) this;
        }

        public Criteria andInstalledNotIn(List<Boolean> values) {
            addCriterion("installed not in", values, "installed");
            return (Criteria) this;
        }

        public Criteria andInstalledBetween(Boolean value1, Boolean value2) {
            addCriterion("installed between", value1, value2, "installed");
            return (Criteria) this;
        }

        public Criteria andInstalledNotBetween(Boolean value1, Boolean value2) {
            addCriterion("installed not between", value1, value2, "installed");
            return (Criteria) this;
        }

        public Criteria andSuperuserIsNull() {
            addCriterion("superuser is null");
            return (Criteria) this;
        }

        public Criteria andSuperuserIsNotNull() {
            addCriterion("superuser is not null");
            return (Criteria) this;
        }

        public Criteria andSuperuserEqualTo(Boolean value) {
            addCriterion("superuser =", value, "superuser");
            return (Criteria) this;
        }

        public Criteria andSuperuserNotEqualTo(Boolean value) {
            addCriterion("superuser <>", value, "superuser");
            return (Criteria) this;
        }

        public Criteria andSuperuserGreaterThan(Boolean value) {
            addCriterion("superuser >", value, "superuser");
            return (Criteria) this;
        }

        public Criteria andSuperuserGreaterThanOrEqualTo(Boolean value) {
            addCriterion("superuser >=", value, "superuser");
            return (Criteria) this;
        }

        public Criteria andSuperuserLessThan(Boolean value) {
            addCriterion("superuser <", value, "superuser");
            return (Criteria) this;
        }

        public Criteria andSuperuserLessThanOrEqualTo(Boolean value) {
            addCriterion("superuser <=", value, "superuser");
            return (Criteria) this;
        }

        public Criteria andSuperuserIn(List<Boolean> values) {
            addCriterion("superuser in", values, "superuser");
            return (Criteria) this;
        }

        public Criteria andSuperuserNotIn(List<Boolean> values) {
            addCriterion("superuser not in", values, "superuser");
            return (Criteria) this;
        }

        public Criteria andSuperuserBetween(Boolean value1, Boolean value2) {
            addCriterion("superuser between", value1, value2, "superuser");
            return (Criteria) this;
        }

        public Criteria andSuperuserNotBetween(Boolean value1, Boolean value2) {
            addCriterion("superuser not between", value1, value2, "superuser");
            return (Criteria) this;
        }

        public Criteria andRelocatableIsNull() {
            addCriterion("relocatable is null");
            return (Criteria) this;
        }

        public Criteria andRelocatableIsNotNull() {
            addCriterion("relocatable is not null");
            return (Criteria) this;
        }

        public Criteria andRelocatableEqualTo(Boolean value) {
            addCriterion("relocatable =", value, "relocatable");
            return (Criteria) this;
        }

        public Criteria andRelocatableNotEqualTo(Boolean value) {
            addCriterion("relocatable <>", value, "relocatable");
            return (Criteria) this;
        }

        public Criteria andRelocatableGreaterThan(Boolean value) {
            addCriterion("relocatable >", value, "relocatable");
            return (Criteria) this;
        }

        public Criteria andRelocatableGreaterThanOrEqualTo(Boolean value) {
            addCriterion("relocatable >=", value, "relocatable");
            return (Criteria) this;
        }

        public Criteria andRelocatableLessThan(Boolean value) {
            addCriterion("relocatable <", value, "relocatable");
            return (Criteria) this;
        }

        public Criteria andRelocatableLessThanOrEqualTo(Boolean value) {
            addCriterion("relocatable <=", value, "relocatable");
            return (Criteria) this;
        }

        public Criteria andRelocatableIn(List<Boolean> values) {
            addCriterion("relocatable in", values, "relocatable");
            return (Criteria) this;
        }

        public Criteria andRelocatableNotIn(List<Boolean> values) {
            addCriterion("relocatable not in", values, "relocatable");
            return (Criteria) this;
        }

        public Criteria andRelocatableBetween(Boolean value1, Boolean value2) {
            addCriterion("relocatable between", value1, value2, "relocatable");
            return (Criteria) this;
        }

        public Criteria andRelocatableNotBetween(Boolean value1, Boolean value2) {
            addCriterion("relocatable not between", value1, value2, "relocatable");
            return (Criteria) this;
        }

        public Criteria andSchemaIsNull() {
            addCriterion("schema is null");
            return (Criteria) this;
        }

        public Criteria andSchemaIsNotNull() {
            addCriterion("schema is not null");
            return (Criteria) this;
        }

        public Criteria andSchemaEqualTo(String value) {
            addCriterion("schema =", value, "schema");
            return (Criteria) this;
        }

        public Criteria andSchemaNotEqualTo(String value) {
            addCriterion("schema <>", value, "schema");
            return (Criteria) this;
        }

        public Criteria andSchemaGreaterThan(String value) {
            addCriterion("schema >", value, "schema");
            return (Criteria) this;
        }

        public Criteria andSchemaGreaterThanOrEqualTo(String value) {
            addCriterion("schema >=", value, "schema");
            return (Criteria) this;
        }

        public Criteria andSchemaLessThan(String value) {
            addCriterion("schema <", value, "schema");
            return (Criteria) this;
        }

        public Criteria andSchemaLessThanOrEqualTo(String value) {
            addCriterion("schema <=", value, "schema");
            return (Criteria) this;
        }

        public Criteria andSchemaLike(String value) {
            addCriterion("schema like", value, "schema");
            return (Criteria) this;
        }

        public Criteria andSchemaNotLike(String value) {
            addCriterion("schema not like", value, "schema");
            return (Criteria) this;
        }

        public Criteria andSchemaIn(List<String> values) {
            addCriterion("schema in", values, "schema");
            return (Criteria) this;
        }

        public Criteria andSchemaNotIn(List<String> values) {
            addCriterion("schema not in", values, "schema");
            return (Criteria) this;
        }

        public Criteria andSchemaBetween(String value1, String value2) {
            addCriterion("schema between", value1, value2, "schema");
            return (Criteria) this;
        }

        public Criteria andSchemaNotBetween(String value1, String value2) {
            addCriterion("schema not between", value1, value2, "schema");
            return (Criteria) this;
        }

        public Criteria andRequiresIsNull() {
            addCriterion("requires is null");
            return (Criteria) this;
        }

        public Criteria andRequiresIsNotNull() {
            addCriterion("requires is not null");
            return (Criteria) this;
        }

        public Criteria andRequiresEqualTo(Object value) {
            addCriterion("requires =", value, "requires");
            return (Criteria) this;
        }

        public Criteria andRequiresNotEqualTo(Object value) {
            addCriterion("requires <>", value, "requires");
            return (Criteria) this;
        }

        public Criteria andRequiresGreaterThan(Object value) {
            addCriterion("requires >", value, "requires");
            return (Criteria) this;
        }

        public Criteria andRequiresGreaterThanOrEqualTo(Object value) {
            addCriterion("requires >=", value, "requires");
            return (Criteria) this;
        }

        public Criteria andRequiresLessThan(Object value) {
            addCriterion("requires <", value, "requires");
            return (Criteria) this;
        }

        public Criteria andRequiresLessThanOrEqualTo(Object value) {
            addCriterion("requires <=", value, "requires");
            return (Criteria) this;
        }

        public Criteria andRequiresIn(List<Object> values) {
            addCriterion("requires in", values, "requires");
            return (Criteria) this;
        }

        public Criteria andRequiresNotIn(List<Object> values) {
            addCriterion("requires not in", values, "requires");
            return (Criteria) this;
        }

        public Criteria andRequiresBetween(Object value1, Object value2) {
            addCriterion("requires between", value1, value2, "requires");
            return (Criteria) this;
        }

        public Criteria andRequiresNotBetween(Object value1, Object value2) {
            addCriterion("requires not between", value1, value2, "requires");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
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