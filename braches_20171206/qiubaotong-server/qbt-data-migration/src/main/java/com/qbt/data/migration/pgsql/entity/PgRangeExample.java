package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgRangeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgRangeExample() {
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

        public Criteria andRngtypidIsNull() {
            addCriterion("rngtypid is null");
            return (Criteria) this;
        }

        public Criteria andRngtypidIsNotNull() {
            addCriterion("rngtypid is not null");
            return (Criteria) this;
        }

        public Criteria andRngtypidEqualTo(Long value) {
            addCriterion("rngtypid =", value, "rngtypid");
            return (Criteria) this;
        }

        public Criteria andRngtypidNotEqualTo(Long value) {
            addCriterion("rngtypid <>", value, "rngtypid");
            return (Criteria) this;
        }

        public Criteria andRngtypidGreaterThan(Long value) {
            addCriterion("rngtypid >", value, "rngtypid");
            return (Criteria) this;
        }

        public Criteria andRngtypidGreaterThanOrEqualTo(Long value) {
            addCriterion("rngtypid >=", value, "rngtypid");
            return (Criteria) this;
        }

        public Criteria andRngtypidLessThan(Long value) {
            addCriterion("rngtypid <", value, "rngtypid");
            return (Criteria) this;
        }

        public Criteria andRngtypidLessThanOrEqualTo(Long value) {
            addCriterion("rngtypid <=", value, "rngtypid");
            return (Criteria) this;
        }

        public Criteria andRngtypidIn(List<Long> values) {
            addCriterion("rngtypid in", values, "rngtypid");
            return (Criteria) this;
        }

        public Criteria andRngtypidNotIn(List<Long> values) {
            addCriterion("rngtypid not in", values, "rngtypid");
            return (Criteria) this;
        }

        public Criteria andRngtypidBetween(Long value1, Long value2) {
            addCriterion("rngtypid between", value1, value2, "rngtypid");
            return (Criteria) this;
        }

        public Criteria andRngtypidNotBetween(Long value1, Long value2) {
            addCriterion("rngtypid not between", value1, value2, "rngtypid");
            return (Criteria) this;
        }

        public Criteria andRngsubtypeIsNull() {
            addCriterion("rngsubtype is null");
            return (Criteria) this;
        }

        public Criteria andRngsubtypeIsNotNull() {
            addCriterion("rngsubtype is not null");
            return (Criteria) this;
        }

        public Criteria andRngsubtypeEqualTo(Long value) {
            addCriterion("rngsubtype =", value, "rngsubtype");
            return (Criteria) this;
        }

        public Criteria andRngsubtypeNotEqualTo(Long value) {
            addCriterion("rngsubtype <>", value, "rngsubtype");
            return (Criteria) this;
        }

        public Criteria andRngsubtypeGreaterThan(Long value) {
            addCriterion("rngsubtype >", value, "rngsubtype");
            return (Criteria) this;
        }

        public Criteria andRngsubtypeGreaterThanOrEqualTo(Long value) {
            addCriterion("rngsubtype >=", value, "rngsubtype");
            return (Criteria) this;
        }

        public Criteria andRngsubtypeLessThan(Long value) {
            addCriterion("rngsubtype <", value, "rngsubtype");
            return (Criteria) this;
        }

        public Criteria andRngsubtypeLessThanOrEqualTo(Long value) {
            addCriterion("rngsubtype <=", value, "rngsubtype");
            return (Criteria) this;
        }

        public Criteria andRngsubtypeIn(List<Long> values) {
            addCriterion("rngsubtype in", values, "rngsubtype");
            return (Criteria) this;
        }

        public Criteria andRngsubtypeNotIn(List<Long> values) {
            addCriterion("rngsubtype not in", values, "rngsubtype");
            return (Criteria) this;
        }

        public Criteria andRngsubtypeBetween(Long value1, Long value2) {
            addCriterion("rngsubtype between", value1, value2, "rngsubtype");
            return (Criteria) this;
        }

        public Criteria andRngsubtypeNotBetween(Long value1, Long value2) {
            addCriterion("rngsubtype not between", value1, value2, "rngsubtype");
            return (Criteria) this;
        }

        public Criteria andRngcollationIsNull() {
            addCriterion("rngcollation is null");
            return (Criteria) this;
        }

        public Criteria andRngcollationIsNotNull() {
            addCriterion("rngcollation is not null");
            return (Criteria) this;
        }

        public Criteria andRngcollationEqualTo(Long value) {
            addCriterion("rngcollation =", value, "rngcollation");
            return (Criteria) this;
        }

        public Criteria andRngcollationNotEqualTo(Long value) {
            addCriterion("rngcollation <>", value, "rngcollation");
            return (Criteria) this;
        }

        public Criteria andRngcollationGreaterThan(Long value) {
            addCriterion("rngcollation >", value, "rngcollation");
            return (Criteria) this;
        }

        public Criteria andRngcollationGreaterThanOrEqualTo(Long value) {
            addCriterion("rngcollation >=", value, "rngcollation");
            return (Criteria) this;
        }

        public Criteria andRngcollationLessThan(Long value) {
            addCriterion("rngcollation <", value, "rngcollation");
            return (Criteria) this;
        }

        public Criteria andRngcollationLessThanOrEqualTo(Long value) {
            addCriterion("rngcollation <=", value, "rngcollation");
            return (Criteria) this;
        }

        public Criteria andRngcollationIn(List<Long> values) {
            addCriterion("rngcollation in", values, "rngcollation");
            return (Criteria) this;
        }

        public Criteria andRngcollationNotIn(List<Long> values) {
            addCriterion("rngcollation not in", values, "rngcollation");
            return (Criteria) this;
        }

        public Criteria andRngcollationBetween(Long value1, Long value2) {
            addCriterion("rngcollation between", value1, value2, "rngcollation");
            return (Criteria) this;
        }

        public Criteria andRngcollationNotBetween(Long value1, Long value2) {
            addCriterion("rngcollation not between", value1, value2, "rngcollation");
            return (Criteria) this;
        }

        public Criteria andRngsubopcIsNull() {
            addCriterion("rngsubopc is null");
            return (Criteria) this;
        }

        public Criteria andRngsubopcIsNotNull() {
            addCriterion("rngsubopc is not null");
            return (Criteria) this;
        }

        public Criteria andRngsubopcEqualTo(Long value) {
            addCriterion("rngsubopc =", value, "rngsubopc");
            return (Criteria) this;
        }

        public Criteria andRngsubopcNotEqualTo(Long value) {
            addCriterion("rngsubopc <>", value, "rngsubopc");
            return (Criteria) this;
        }

        public Criteria andRngsubopcGreaterThan(Long value) {
            addCriterion("rngsubopc >", value, "rngsubopc");
            return (Criteria) this;
        }

        public Criteria andRngsubopcGreaterThanOrEqualTo(Long value) {
            addCriterion("rngsubopc >=", value, "rngsubopc");
            return (Criteria) this;
        }

        public Criteria andRngsubopcLessThan(Long value) {
            addCriterion("rngsubopc <", value, "rngsubopc");
            return (Criteria) this;
        }

        public Criteria andRngsubopcLessThanOrEqualTo(Long value) {
            addCriterion("rngsubopc <=", value, "rngsubopc");
            return (Criteria) this;
        }

        public Criteria andRngsubopcIn(List<Long> values) {
            addCriterion("rngsubopc in", values, "rngsubopc");
            return (Criteria) this;
        }

        public Criteria andRngsubopcNotIn(List<Long> values) {
            addCriterion("rngsubopc not in", values, "rngsubopc");
            return (Criteria) this;
        }

        public Criteria andRngsubopcBetween(Long value1, Long value2) {
            addCriterion("rngsubopc between", value1, value2, "rngsubopc");
            return (Criteria) this;
        }

        public Criteria andRngsubopcNotBetween(Long value1, Long value2) {
            addCriterion("rngsubopc not between", value1, value2, "rngsubopc");
            return (Criteria) this;
        }

        public Criteria andRngcanonicalIsNull() {
            addCriterion("rngcanonical is null");
            return (Criteria) this;
        }

        public Criteria andRngcanonicalIsNotNull() {
            addCriterion("rngcanonical is not null");
            return (Criteria) this;
        }

        public Criteria andRngcanonicalEqualTo(Object value) {
            addCriterion("rngcanonical =", value, "rngcanonical");
            return (Criteria) this;
        }

        public Criteria andRngcanonicalNotEqualTo(Object value) {
            addCriterion("rngcanonical <>", value, "rngcanonical");
            return (Criteria) this;
        }

        public Criteria andRngcanonicalGreaterThan(Object value) {
            addCriterion("rngcanonical >", value, "rngcanonical");
            return (Criteria) this;
        }

        public Criteria andRngcanonicalGreaterThanOrEqualTo(Object value) {
            addCriterion("rngcanonical >=", value, "rngcanonical");
            return (Criteria) this;
        }

        public Criteria andRngcanonicalLessThan(Object value) {
            addCriterion("rngcanonical <", value, "rngcanonical");
            return (Criteria) this;
        }

        public Criteria andRngcanonicalLessThanOrEqualTo(Object value) {
            addCriterion("rngcanonical <=", value, "rngcanonical");
            return (Criteria) this;
        }

        public Criteria andRngcanonicalIn(List<Object> values) {
            addCriterion("rngcanonical in", values, "rngcanonical");
            return (Criteria) this;
        }

        public Criteria andRngcanonicalNotIn(List<Object> values) {
            addCriterion("rngcanonical not in", values, "rngcanonical");
            return (Criteria) this;
        }

        public Criteria andRngcanonicalBetween(Object value1, Object value2) {
            addCriterion("rngcanonical between", value1, value2, "rngcanonical");
            return (Criteria) this;
        }

        public Criteria andRngcanonicalNotBetween(Object value1, Object value2) {
            addCriterion("rngcanonical not between", value1, value2, "rngcanonical");
            return (Criteria) this;
        }

        public Criteria andRngsubdiffIsNull() {
            addCriterion("rngsubdiff is null");
            return (Criteria) this;
        }

        public Criteria andRngsubdiffIsNotNull() {
            addCriterion("rngsubdiff is not null");
            return (Criteria) this;
        }

        public Criteria andRngsubdiffEqualTo(Object value) {
            addCriterion("rngsubdiff =", value, "rngsubdiff");
            return (Criteria) this;
        }

        public Criteria andRngsubdiffNotEqualTo(Object value) {
            addCriterion("rngsubdiff <>", value, "rngsubdiff");
            return (Criteria) this;
        }

        public Criteria andRngsubdiffGreaterThan(Object value) {
            addCriterion("rngsubdiff >", value, "rngsubdiff");
            return (Criteria) this;
        }

        public Criteria andRngsubdiffGreaterThanOrEqualTo(Object value) {
            addCriterion("rngsubdiff >=", value, "rngsubdiff");
            return (Criteria) this;
        }

        public Criteria andRngsubdiffLessThan(Object value) {
            addCriterion("rngsubdiff <", value, "rngsubdiff");
            return (Criteria) this;
        }

        public Criteria andRngsubdiffLessThanOrEqualTo(Object value) {
            addCriterion("rngsubdiff <=", value, "rngsubdiff");
            return (Criteria) this;
        }

        public Criteria andRngsubdiffIn(List<Object> values) {
            addCriterion("rngsubdiff in", values, "rngsubdiff");
            return (Criteria) this;
        }

        public Criteria andRngsubdiffNotIn(List<Object> values) {
            addCriterion("rngsubdiff not in", values, "rngsubdiff");
            return (Criteria) this;
        }

        public Criteria andRngsubdiffBetween(Object value1, Object value2) {
            addCriterion("rngsubdiff between", value1, value2, "rngsubdiff");
            return (Criteria) this;
        }

        public Criteria andRngsubdiffNotBetween(Object value1, Object value2) {
            addCriterion("rngsubdiff not between", value1, value2, "rngsubdiff");
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