package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgTsParserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgTsParserExample() {
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

        public Criteria andPrsnameIsNull() {
            addCriterion("prsname is null");
            return (Criteria) this;
        }

        public Criteria andPrsnameIsNotNull() {
            addCriterion("prsname is not null");
            return (Criteria) this;
        }

        public Criteria andPrsnameEqualTo(String value) {
            addCriterion("prsname =", value, "prsname");
            return (Criteria) this;
        }

        public Criteria andPrsnameNotEqualTo(String value) {
            addCriterion("prsname <>", value, "prsname");
            return (Criteria) this;
        }

        public Criteria andPrsnameGreaterThan(String value) {
            addCriterion("prsname >", value, "prsname");
            return (Criteria) this;
        }

        public Criteria andPrsnameGreaterThanOrEqualTo(String value) {
            addCriterion("prsname >=", value, "prsname");
            return (Criteria) this;
        }

        public Criteria andPrsnameLessThan(String value) {
            addCriterion("prsname <", value, "prsname");
            return (Criteria) this;
        }

        public Criteria andPrsnameLessThanOrEqualTo(String value) {
            addCriterion("prsname <=", value, "prsname");
            return (Criteria) this;
        }

        public Criteria andPrsnameLike(String value) {
            addCriterion("prsname like", value, "prsname");
            return (Criteria) this;
        }

        public Criteria andPrsnameNotLike(String value) {
            addCriterion("prsname not like", value, "prsname");
            return (Criteria) this;
        }

        public Criteria andPrsnameIn(List<String> values) {
            addCriterion("prsname in", values, "prsname");
            return (Criteria) this;
        }

        public Criteria andPrsnameNotIn(List<String> values) {
            addCriterion("prsname not in", values, "prsname");
            return (Criteria) this;
        }

        public Criteria andPrsnameBetween(String value1, String value2) {
            addCriterion("prsname between", value1, value2, "prsname");
            return (Criteria) this;
        }

        public Criteria andPrsnameNotBetween(String value1, String value2) {
            addCriterion("prsname not between", value1, value2, "prsname");
            return (Criteria) this;
        }

        public Criteria andPrsnamespaceIsNull() {
            addCriterion("prsnamespace is null");
            return (Criteria) this;
        }

        public Criteria andPrsnamespaceIsNotNull() {
            addCriterion("prsnamespace is not null");
            return (Criteria) this;
        }

        public Criteria andPrsnamespaceEqualTo(Long value) {
            addCriterion("prsnamespace =", value, "prsnamespace");
            return (Criteria) this;
        }

        public Criteria andPrsnamespaceNotEqualTo(Long value) {
            addCriterion("prsnamespace <>", value, "prsnamespace");
            return (Criteria) this;
        }

        public Criteria andPrsnamespaceGreaterThan(Long value) {
            addCriterion("prsnamespace >", value, "prsnamespace");
            return (Criteria) this;
        }

        public Criteria andPrsnamespaceGreaterThanOrEqualTo(Long value) {
            addCriterion("prsnamespace >=", value, "prsnamespace");
            return (Criteria) this;
        }

        public Criteria andPrsnamespaceLessThan(Long value) {
            addCriterion("prsnamespace <", value, "prsnamespace");
            return (Criteria) this;
        }

        public Criteria andPrsnamespaceLessThanOrEqualTo(Long value) {
            addCriterion("prsnamespace <=", value, "prsnamespace");
            return (Criteria) this;
        }

        public Criteria andPrsnamespaceIn(List<Long> values) {
            addCriterion("prsnamespace in", values, "prsnamespace");
            return (Criteria) this;
        }

        public Criteria andPrsnamespaceNotIn(List<Long> values) {
            addCriterion("prsnamespace not in", values, "prsnamespace");
            return (Criteria) this;
        }

        public Criteria andPrsnamespaceBetween(Long value1, Long value2) {
            addCriterion("prsnamespace between", value1, value2, "prsnamespace");
            return (Criteria) this;
        }

        public Criteria andPrsnamespaceNotBetween(Long value1, Long value2) {
            addCriterion("prsnamespace not between", value1, value2, "prsnamespace");
            return (Criteria) this;
        }

        public Criteria andPrsstartIsNull() {
            addCriterion("prsstart is null");
            return (Criteria) this;
        }

        public Criteria andPrsstartIsNotNull() {
            addCriterion("prsstart is not null");
            return (Criteria) this;
        }

        public Criteria andPrsstartEqualTo(Object value) {
            addCriterion("prsstart =", value, "prsstart");
            return (Criteria) this;
        }

        public Criteria andPrsstartNotEqualTo(Object value) {
            addCriterion("prsstart <>", value, "prsstart");
            return (Criteria) this;
        }

        public Criteria andPrsstartGreaterThan(Object value) {
            addCriterion("prsstart >", value, "prsstart");
            return (Criteria) this;
        }

        public Criteria andPrsstartGreaterThanOrEqualTo(Object value) {
            addCriterion("prsstart >=", value, "prsstart");
            return (Criteria) this;
        }

        public Criteria andPrsstartLessThan(Object value) {
            addCriterion("prsstart <", value, "prsstart");
            return (Criteria) this;
        }

        public Criteria andPrsstartLessThanOrEqualTo(Object value) {
            addCriterion("prsstart <=", value, "prsstart");
            return (Criteria) this;
        }

        public Criteria andPrsstartIn(List<Object> values) {
            addCriterion("prsstart in", values, "prsstart");
            return (Criteria) this;
        }

        public Criteria andPrsstartNotIn(List<Object> values) {
            addCriterion("prsstart not in", values, "prsstart");
            return (Criteria) this;
        }

        public Criteria andPrsstartBetween(Object value1, Object value2) {
            addCriterion("prsstart between", value1, value2, "prsstart");
            return (Criteria) this;
        }

        public Criteria andPrsstartNotBetween(Object value1, Object value2) {
            addCriterion("prsstart not between", value1, value2, "prsstart");
            return (Criteria) this;
        }

        public Criteria andPrstokenIsNull() {
            addCriterion("prstoken is null");
            return (Criteria) this;
        }

        public Criteria andPrstokenIsNotNull() {
            addCriterion("prstoken is not null");
            return (Criteria) this;
        }

        public Criteria andPrstokenEqualTo(Object value) {
            addCriterion("prstoken =", value, "prstoken");
            return (Criteria) this;
        }

        public Criteria andPrstokenNotEqualTo(Object value) {
            addCriterion("prstoken <>", value, "prstoken");
            return (Criteria) this;
        }

        public Criteria andPrstokenGreaterThan(Object value) {
            addCriterion("prstoken >", value, "prstoken");
            return (Criteria) this;
        }

        public Criteria andPrstokenGreaterThanOrEqualTo(Object value) {
            addCriterion("prstoken >=", value, "prstoken");
            return (Criteria) this;
        }

        public Criteria andPrstokenLessThan(Object value) {
            addCriterion("prstoken <", value, "prstoken");
            return (Criteria) this;
        }

        public Criteria andPrstokenLessThanOrEqualTo(Object value) {
            addCriterion("prstoken <=", value, "prstoken");
            return (Criteria) this;
        }

        public Criteria andPrstokenIn(List<Object> values) {
            addCriterion("prstoken in", values, "prstoken");
            return (Criteria) this;
        }

        public Criteria andPrstokenNotIn(List<Object> values) {
            addCriterion("prstoken not in", values, "prstoken");
            return (Criteria) this;
        }

        public Criteria andPrstokenBetween(Object value1, Object value2) {
            addCriterion("prstoken between", value1, value2, "prstoken");
            return (Criteria) this;
        }

        public Criteria andPrstokenNotBetween(Object value1, Object value2) {
            addCriterion("prstoken not between", value1, value2, "prstoken");
            return (Criteria) this;
        }

        public Criteria andPrsendIsNull() {
            addCriterion("prsend is null");
            return (Criteria) this;
        }

        public Criteria andPrsendIsNotNull() {
            addCriterion("prsend is not null");
            return (Criteria) this;
        }

        public Criteria andPrsendEqualTo(Object value) {
            addCriterion("prsend =", value, "prsend");
            return (Criteria) this;
        }

        public Criteria andPrsendNotEqualTo(Object value) {
            addCriterion("prsend <>", value, "prsend");
            return (Criteria) this;
        }

        public Criteria andPrsendGreaterThan(Object value) {
            addCriterion("prsend >", value, "prsend");
            return (Criteria) this;
        }

        public Criteria andPrsendGreaterThanOrEqualTo(Object value) {
            addCriterion("prsend >=", value, "prsend");
            return (Criteria) this;
        }

        public Criteria andPrsendLessThan(Object value) {
            addCriterion("prsend <", value, "prsend");
            return (Criteria) this;
        }

        public Criteria andPrsendLessThanOrEqualTo(Object value) {
            addCriterion("prsend <=", value, "prsend");
            return (Criteria) this;
        }

        public Criteria andPrsendIn(List<Object> values) {
            addCriterion("prsend in", values, "prsend");
            return (Criteria) this;
        }

        public Criteria andPrsendNotIn(List<Object> values) {
            addCriterion("prsend not in", values, "prsend");
            return (Criteria) this;
        }

        public Criteria andPrsendBetween(Object value1, Object value2) {
            addCriterion("prsend between", value1, value2, "prsend");
            return (Criteria) this;
        }

        public Criteria andPrsendNotBetween(Object value1, Object value2) {
            addCriterion("prsend not between", value1, value2, "prsend");
            return (Criteria) this;
        }

        public Criteria andPrsheadlineIsNull() {
            addCriterion("prsheadline is null");
            return (Criteria) this;
        }

        public Criteria andPrsheadlineIsNotNull() {
            addCriterion("prsheadline is not null");
            return (Criteria) this;
        }

        public Criteria andPrsheadlineEqualTo(Object value) {
            addCriterion("prsheadline =", value, "prsheadline");
            return (Criteria) this;
        }

        public Criteria andPrsheadlineNotEqualTo(Object value) {
            addCriterion("prsheadline <>", value, "prsheadline");
            return (Criteria) this;
        }

        public Criteria andPrsheadlineGreaterThan(Object value) {
            addCriterion("prsheadline >", value, "prsheadline");
            return (Criteria) this;
        }

        public Criteria andPrsheadlineGreaterThanOrEqualTo(Object value) {
            addCriterion("prsheadline >=", value, "prsheadline");
            return (Criteria) this;
        }

        public Criteria andPrsheadlineLessThan(Object value) {
            addCriterion("prsheadline <", value, "prsheadline");
            return (Criteria) this;
        }

        public Criteria andPrsheadlineLessThanOrEqualTo(Object value) {
            addCriterion("prsheadline <=", value, "prsheadline");
            return (Criteria) this;
        }

        public Criteria andPrsheadlineIn(List<Object> values) {
            addCriterion("prsheadline in", values, "prsheadline");
            return (Criteria) this;
        }

        public Criteria andPrsheadlineNotIn(List<Object> values) {
            addCriterion("prsheadline not in", values, "prsheadline");
            return (Criteria) this;
        }

        public Criteria andPrsheadlineBetween(Object value1, Object value2) {
            addCriterion("prsheadline between", value1, value2, "prsheadline");
            return (Criteria) this;
        }

        public Criteria andPrsheadlineNotBetween(Object value1, Object value2) {
            addCriterion("prsheadline not between", value1, value2, "prsheadline");
            return (Criteria) this;
        }

        public Criteria andPrslextypeIsNull() {
            addCriterion("prslextype is null");
            return (Criteria) this;
        }

        public Criteria andPrslextypeIsNotNull() {
            addCriterion("prslextype is not null");
            return (Criteria) this;
        }

        public Criteria andPrslextypeEqualTo(Object value) {
            addCriterion("prslextype =", value, "prslextype");
            return (Criteria) this;
        }

        public Criteria andPrslextypeNotEqualTo(Object value) {
            addCriterion("prslextype <>", value, "prslextype");
            return (Criteria) this;
        }

        public Criteria andPrslextypeGreaterThan(Object value) {
            addCriterion("prslextype >", value, "prslextype");
            return (Criteria) this;
        }

        public Criteria andPrslextypeGreaterThanOrEqualTo(Object value) {
            addCriterion("prslextype >=", value, "prslextype");
            return (Criteria) this;
        }

        public Criteria andPrslextypeLessThan(Object value) {
            addCriterion("prslextype <", value, "prslextype");
            return (Criteria) this;
        }

        public Criteria andPrslextypeLessThanOrEqualTo(Object value) {
            addCriterion("prslextype <=", value, "prslextype");
            return (Criteria) this;
        }

        public Criteria andPrslextypeIn(List<Object> values) {
            addCriterion("prslextype in", values, "prslextype");
            return (Criteria) this;
        }

        public Criteria andPrslextypeNotIn(List<Object> values) {
            addCriterion("prslextype not in", values, "prslextype");
            return (Criteria) this;
        }

        public Criteria andPrslextypeBetween(Object value1, Object value2) {
            addCriterion("prslextype between", value1, value2, "prslextype");
            return (Criteria) this;
        }

        public Criteria andPrslextypeNotBetween(Object value1, Object value2) {
            addCriterion("prslextype not between", value1, value2, "prslextype");
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