package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgAuthMembersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgAuthMembersExample() {
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

        public Criteria andRoleidIsNull() {
            addCriterion("roleid is null");
            return (Criteria) this;
        }

        public Criteria andRoleidIsNotNull() {
            addCriterion("roleid is not null");
            return (Criteria) this;
        }

        public Criteria andRoleidEqualTo(Long value) {
            addCriterion("roleid =", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotEqualTo(Long value) {
            addCriterion("roleid <>", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidGreaterThan(Long value) {
            addCriterion("roleid >", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidGreaterThanOrEqualTo(Long value) {
            addCriterion("roleid >=", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidLessThan(Long value) {
            addCriterion("roleid <", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidLessThanOrEqualTo(Long value) {
            addCriterion("roleid <=", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidIn(List<Long> values) {
            addCriterion("roleid in", values, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotIn(List<Long> values) {
            addCriterion("roleid not in", values, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidBetween(Long value1, Long value2) {
            addCriterion("roleid between", value1, value2, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotBetween(Long value1, Long value2) {
            addCriterion("roleid not between", value1, value2, "roleid");
            return (Criteria) this;
        }

        public Criteria andMemberIsNull() {
            addCriterion("member is null");
            return (Criteria) this;
        }

        public Criteria andMemberIsNotNull() {
            addCriterion("member is not null");
            return (Criteria) this;
        }

        public Criteria andMemberEqualTo(Long value) {
            addCriterion("member =", value, "member");
            return (Criteria) this;
        }

        public Criteria andMemberNotEqualTo(Long value) {
            addCriterion("member <>", value, "member");
            return (Criteria) this;
        }

        public Criteria andMemberGreaterThan(Long value) {
            addCriterion("member >", value, "member");
            return (Criteria) this;
        }

        public Criteria andMemberGreaterThanOrEqualTo(Long value) {
            addCriterion("member >=", value, "member");
            return (Criteria) this;
        }

        public Criteria andMemberLessThan(Long value) {
            addCriterion("member <", value, "member");
            return (Criteria) this;
        }

        public Criteria andMemberLessThanOrEqualTo(Long value) {
            addCriterion("member <=", value, "member");
            return (Criteria) this;
        }

        public Criteria andMemberIn(List<Long> values) {
            addCriterion("member in", values, "member");
            return (Criteria) this;
        }

        public Criteria andMemberNotIn(List<Long> values) {
            addCriterion("member not in", values, "member");
            return (Criteria) this;
        }

        public Criteria andMemberBetween(Long value1, Long value2) {
            addCriterion("member between", value1, value2, "member");
            return (Criteria) this;
        }

        public Criteria andMemberNotBetween(Long value1, Long value2) {
            addCriterion("member not between", value1, value2, "member");
            return (Criteria) this;
        }

        public Criteria andGrantorIsNull() {
            addCriterion("grantor is null");
            return (Criteria) this;
        }

        public Criteria andGrantorIsNotNull() {
            addCriterion("grantor is not null");
            return (Criteria) this;
        }

        public Criteria andGrantorEqualTo(Long value) {
            addCriterion("grantor =", value, "grantor");
            return (Criteria) this;
        }

        public Criteria andGrantorNotEqualTo(Long value) {
            addCriterion("grantor <>", value, "grantor");
            return (Criteria) this;
        }

        public Criteria andGrantorGreaterThan(Long value) {
            addCriterion("grantor >", value, "grantor");
            return (Criteria) this;
        }

        public Criteria andGrantorGreaterThanOrEqualTo(Long value) {
            addCriterion("grantor >=", value, "grantor");
            return (Criteria) this;
        }

        public Criteria andGrantorLessThan(Long value) {
            addCriterion("grantor <", value, "grantor");
            return (Criteria) this;
        }

        public Criteria andGrantorLessThanOrEqualTo(Long value) {
            addCriterion("grantor <=", value, "grantor");
            return (Criteria) this;
        }

        public Criteria andGrantorIn(List<Long> values) {
            addCriterion("grantor in", values, "grantor");
            return (Criteria) this;
        }

        public Criteria andGrantorNotIn(List<Long> values) {
            addCriterion("grantor not in", values, "grantor");
            return (Criteria) this;
        }

        public Criteria andGrantorBetween(Long value1, Long value2) {
            addCriterion("grantor between", value1, value2, "grantor");
            return (Criteria) this;
        }

        public Criteria andGrantorNotBetween(Long value1, Long value2) {
            addCriterion("grantor not between", value1, value2, "grantor");
            return (Criteria) this;
        }

        public Criteria andAdmin_optionIsNull() {
            addCriterion("admin_option is null");
            return (Criteria) this;
        }

        public Criteria andAdmin_optionIsNotNull() {
            addCriterion("admin_option is not null");
            return (Criteria) this;
        }

        public Criteria andAdmin_optionEqualTo(Boolean value) {
            addCriterion("admin_option =", value, "admin_option");
            return (Criteria) this;
        }

        public Criteria andAdmin_optionNotEqualTo(Boolean value) {
            addCriterion("admin_option <>", value, "admin_option");
            return (Criteria) this;
        }

        public Criteria andAdmin_optionGreaterThan(Boolean value) {
            addCriterion("admin_option >", value, "admin_option");
            return (Criteria) this;
        }

        public Criteria andAdmin_optionGreaterThanOrEqualTo(Boolean value) {
            addCriterion("admin_option >=", value, "admin_option");
            return (Criteria) this;
        }

        public Criteria andAdmin_optionLessThan(Boolean value) {
            addCriterion("admin_option <", value, "admin_option");
            return (Criteria) this;
        }

        public Criteria andAdmin_optionLessThanOrEqualTo(Boolean value) {
            addCriterion("admin_option <=", value, "admin_option");
            return (Criteria) this;
        }

        public Criteria andAdmin_optionIn(List<Boolean> values) {
            addCriterion("admin_option in", values, "admin_option");
            return (Criteria) this;
        }

        public Criteria andAdmin_optionNotIn(List<Boolean> values) {
            addCriterion("admin_option not in", values, "admin_option");
            return (Criteria) this;
        }

        public Criteria andAdmin_optionBetween(Boolean value1, Boolean value2) {
            addCriterion("admin_option between", value1, value2, "admin_option");
            return (Criteria) this;
        }

        public Criteria andAdmin_optionNotBetween(Boolean value1, Boolean value2) {
            addCriterion("admin_option not between", value1, value2, "admin_option");
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