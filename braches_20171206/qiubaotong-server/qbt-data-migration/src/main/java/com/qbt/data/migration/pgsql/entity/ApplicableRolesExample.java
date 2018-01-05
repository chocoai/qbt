package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class ApplicableRolesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApplicableRolesExample() {
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

        public Criteria andRole_nameIsNull() {
            addCriterion("role_name is null");
            return (Criteria) this;
        }

        public Criteria andRole_nameIsNotNull() {
            addCriterion("role_name is not null");
            return (Criteria) this;
        }

        public Criteria andRole_nameEqualTo(Object value) {
            addCriterion("role_name =", value, "role_name");
            return (Criteria) this;
        }

        public Criteria andRole_nameNotEqualTo(Object value) {
            addCriterion("role_name <>", value, "role_name");
            return (Criteria) this;
        }

        public Criteria andRole_nameGreaterThan(Object value) {
            addCriterion("role_name >", value, "role_name");
            return (Criteria) this;
        }

        public Criteria andRole_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("role_name >=", value, "role_name");
            return (Criteria) this;
        }

        public Criteria andRole_nameLessThan(Object value) {
            addCriterion("role_name <", value, "role_name");
            return (Criteria) this;
        }

        public Criteria andRole_nameLessThanOrEqualTo(Object value) {
            addCriterion("role_name <=", value, "role_name");
            return (Criteria) this;
        }

        public Criteria andRole_nameIn(List<Object> values) {
            addCriterion("role_name in", values, "role_name");
            return (Criteria) this;
        }

        public Criteria andRole_nameNotIn(List<Object> values) {
            addCriterion("role_name not in", values, "role_name");
            return (Criteria) this;
        }

        public Criteria andRole_nameBetween(Object value1, Object value2) {
            addCriterion("role_name between", value1, value2, "role_name");
            return (Criteria) this;
        }

        public Criteria andRole_nameNotBetween(Object value1, Object value2) {
            addCriterion("role_name not between", value1, value2, "role_name");
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