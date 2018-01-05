package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgCastExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgCastExample() {
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

        public Criteria andCastsourceIsNull() {
            addCriterion("castsource is null");
            return (Criteria) this;
        }

        public Criteria andCastsourceIsNotNull() {
            addCriterion("castsource is not null");
            return (Criteria) this;
        }

        public Criteria andCastsourceEqualTo(Long value) {
            addCriterion("castsource =", value, "castsource");
            return (Criteria) this;
        }

        public Criteria andCastsourceNotEqualTo(Long value) {
            addCriterion("castsource <>", value, "castsource");
            return (Criteria) this;
        }

        public Criteria andCastsourceGreaterThan(Long value) {
            addCriterion("castsource >", value, "castsource");
            return (Criteria) this;
        }

        public Criteria andCastsourceGreaterThanOrEqualTo(Long value) {
            addCriterion("castsource >=", value, "castsource");
            return (Criteria) this;
        }

        public Criteria andCastsourceLessThan(Long value) {
            addCriterion("castsource <", value, "castsource");
            return (Criteria) this;
        }

        public Criteria andCastsourceLessThanOrEqualTo(Long value) {
            addCriterion("castsource <=", value, "castsource");
            return (Criteria) this;
        }

        public Criteria andCastsourceIn(List<Long> values) {
            addCriterion("castsource in", values, "castsource");
            return (Criteria) this;
        }

        public Criteria andCastsourceNotIn(List<Long> values) {
            addCriterion("castsource not in", values, "castsource");
            return (Criteria) this;
        }

        public Criteria andCastsourceBetween(Long value1, Long value2) {
            addCriterion("castsource between", value1, value2, "castsource");
            return (Criteria) this;
        }

        public Criteria andCastsourceNotBetween(Long value1, Long value2) {
            addCriterion("castsource not between", value1, value2, "castsource");
            return (Criteria) this;
        }

        public Criteria andCasttargetIsNull() {
            addCriterion("casttarget is null");
            return (Criteria) this;
        }

        public Criteria andCasttargetIsNotNull() {
            addCriterion("casttarget is not null");
            return (Criteria) this;
        }

        public Criteria andCasttargetEqualTo(Long value) {
            addCriterion("casttarget =", value, "casttarget");
            return (Criteria) this;
        }

        public Criteria andCasttargetNotEqualTo(Long value) {
            addCriterion("casttarget <>", value, "casttarget");
            return (Criteria) this;
        }

        public Criteria andCasttargetGreaterThan(Long value) {
            addCriterion("casttarget >", value, "casttarget");
            return (Criteria) this;
        }

        public Criteria andCasttargetGreaterThanOrEqualTo(Long value) {
            addCriterion("casttarget >=", value, "casttarget");
            return (Criteria) this;
        }

        public Criteria andCasttargetLessThan(Long value) {
            addCriterion("casttarget <", value, "casttarget");
            return (Criteria) this;
        }

        public Criteria andCasttargetLessThanOrEqualTo(Long value) {
            addCriterion("casttarget <=", value, "casttarget");
            return (Criteria) this;
        }

        public Criteria andCasttargetIn(List<Long> values) {
            addCriterion("casttarget in", values, "casttarget");
            return (Criteria) this;
        }

        public Criteria andCasttargetNotIn(List<Long> values) {
            addCriterion("casttarget not in", values, "casttarget");
            return (Criteria) this;
        }

        public Criteria andCasttargetBetween(Long value1, Long value2) {
            addCriterion("casttarget between", value1, value2, "casttarget");
            return (Criteria) this;
        }

        public Criteria andCasttargetNotBetween(Long value1, Long value2) {
            addCriterion("casttarget not between", value1, value2, "casttarget");
            return (Criteria) this;
        }

        public Criteria andCastfuncIsNull() {
            addCriterion("castfunc is null");
            return (Criteria) this;
        }

        public Criteria andCastfuncIsNotNull() {
            addCriterion("castfunc is not null");
            return (Criteria) this;
        }

        public Criteria andCastfuncEqualTo(Long value) {
            addCriterion("castfunc =", value, "castfunc");
            return (Criteria) this;
        }

        public Criteria andCastfuncNotEqualTo(Long value) {
            addCriterion("castfunc <>", value, "castfunc");
            return (Criteria) this;
        }

        public Criteria andCastfuncGreaterThan(Long value) {
            addCriterion("castfunc >", value, "castfunc");
            return (Criteria) this;
        }

        public Criteria andCastfuncGreaterThanOrEqualTo(Long value) {
            addCriterion("castfunc >=", value, "castfunc");
            return (Criteria) this;
        }

        public Criteria andCastfuncLessThan(Long value) {
            addCriterion("castfunc <", value, "castfunc");
            return (Criteria) this;
        }

        public Criteria andCastfuncLessThanOrEqualTo(Long value) {
            addCriterion("castfunc <=", value, "castfunc");
            return (Criteria) this;
        }

        public Criteria andCastfuncIn(List<Long> values) {
            addCriterion("castfunc in", values, "castfunc");
            return (Criteria) this;
        }

        public Criteria andCastfuncNotIn(List<Long> values) {
            addCriterion("castfunc not in", values, "castfunc");
            return (Criteria) this;
        }

        public Criteria andCastfuncBetween(Long value1, Long value2) {
            addCriterion("castfunc between", value1, value2, "castfunc");
            return (Criteria) this;
        }

        public Criteria andCastfuncNotBetween(Long value1, Long value2) {
            addCriterion("castfunc not between", value1, value2, "castfunc");
            return (Criteria) this;
        }

        public Criteria andCastcontextIsNull() {
            addCriterion("castcontext is null");
            return (Criteria) this;
        }

        public Criteria andCastcontextIsNotNull() {
            addCriterion("castcontext is not null");
            return (Criteria) this;
        }

        public Criteria andCastcontextEqualTo(String value) {
            addCriterion("castcontext =", value, "castcontext");
            return (Criteria) this;
        }

        public Criteria andCastcontextNotEqualTo(String value) {
            addCriterion("castcontext <>", value, "castcontext");
            return (Criteria) this;
        }

        public Criteria andCastcontextGreaterThan(String value) {
            addCriterion("castcontext >", value, "castcontext");
            return (Criteria) this;
        }

        public Criteria andCastcontextGreaterThanOrEqualTo(String value) {
            addCriterion("castcontext >=", value, "castcontext");
            return (Criteria) this;
        }

        public Criteria andCastcontextLessThan(String value) {
            addCriterion("castcontext <", value, "castcontext");
            return (Criteria) this;
        }

        public Criteria andCastcontextLessThanOrEqualTo(String value) {
            addCriterion("castcontext <=", value, "castcontext");
            return (Criteria) this;
        }

        public Criteria andCastcontextLike(String value) {
            addCriterion("castcontext like", value, "castcontext");
            return (Criteria) this;
        }

        public Criteria andCastcontextNotLike(String value) {
            addCriterion("castcontext not like", value, "castcontext");
            return (Criteria) this;
        }

        public Criteria andCastcontextIn(List<String> values) {
            addCriterion("castcontext in", values, "castcontext");
            return (Criteria) this;
        }

        public Criteria andCastcontextNotIn(List<String> values) {
            addCriterion("castcontext not in", values, "castcontext");
            return (Criteria) this;
        }

        public Criteria andCastcontextBetween(String value1, String value2) {
            addCriterion("castcontext between", value1, value2, "castcontext");
            return (Criteria) this;
        }

        public Criteria andCastcontextNotBetween(String value1, String value2) {
            addCriterion("castcontext not between", value1, value2, "castcontext");
            return (Criteria) this;
        }

        public Criteria andCastmethodIsNull() {
            addCriterion("castmethod is null");
            return (Criteria) this;
        }

        public Criteria andCastmethodIsNotNull() {
            addCriterion("castmethod is not null");
            return (Criteria) this;
        }

        public Criteria andCastmethodEqualTo(String value) {
            addCriterion("castmethod =", value, "castmethod");
            return (Criteria) this;
        }

        public Criteria andCastmethodNotEqualTo(String value) {
            addCriterion("castmethod <>", value, "castmethod");
            return (Criteria) this;
        }

        public Criteria andCastmethodGreaterThan(String value) {
            addCriterion("castmethod >", value, "castmethod");
            return (Criteria) this;
        }

        public Criteria andCastmethodGreaterThanOrEqualTo(String value) {
            addCriterion("castmethod >=", value, "castmethod");
            return (Criteria) this;
        }

        public Criteria andCastmethodLessThan(String value) {
            addCriterion("castmethod <", value, "castmethod");
            return (Criteria) this;
        }

        public Criteria andCastmethodLessThanOrEqualTo(String value) {
            addCriterion("castmethod <=", value, "castmethod");
            return (Criteria) this;
        }

        public Criteria andCastmethodLike(String value) {
            addCriterion("castmethod like", value, "castmethod");
            return (Criteria) this;
        }

        public Criteria andCastmethodNotLike(String value) {
            addCriterion("castmethod not like", value, "castmethod");
            return (Criteria) this;
        }

        public Criteria andCastmethodIn(List<String> values) {
            addCriterion("castmethod in", values, "castmethod");
            return (Criteria) this;
        }

        public Criteria andCastmethodNotIn(List<String> values) {
            addCriterion("castmethod not in", values, "castmethod");
            return (Criteria) this;
        }

        public Criteria andCastmethodBetween(String value1, String value2) {
            addCriterion("castmethod between", value1, value2, "castmethod");
            return (Criteria) this;
        }

        public Criteria andCastmethodNotBetween(String value1, String value2) {
            addCriterion("castmethod not between", value1, value2, "castmethod");
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