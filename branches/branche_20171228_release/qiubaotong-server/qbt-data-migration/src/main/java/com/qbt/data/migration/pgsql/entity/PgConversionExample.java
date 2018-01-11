package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgConversionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgConversionExample() {
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

        public Criteria andConnameIsNull() {
            addCriterion("conname is null");
            return (Criteria) this;
        }

        public Criteria andConnameIsNotNull() {
            addCriterion("conname is not null");
            return (Criteria) this;
        }

        public Criteria andConnameEqualTo(String value) {
            addCriterion("conname =", value, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameNotEqualTo(String value) {
            addCriterion("conname <>", value, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameGreaterThan(String value) {
            addCriterion("conname >", value, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameGreaterThanOrEqualTo(String value) {
            addCriterion("conname >=", value, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameLessThan(String value) {
            addCriterion("conname <", value, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameLessThanOrEqualTo(String value) {
            addCriterion("conname <=", value, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameLike(String value) {
            addCriterion("conname like", value, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameNotLike(String value) {
            addCriterion("conname not like", value, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameIn(List<String> values) {
            addCriterion("conname in", values, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameNotIn(List<String> values) {
            addCriterion("conname not in", values, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameBetween(String value1, String value2) {
            addCriterion("conname between", value1, value2, "conname");
            return (Criteria) this;
        }

        public Criteria andConnameNotBetween(String value1, String value2) {
            addCriterion("conname not between", value1, value2, "conname");
            return (Criteria) this;
        }

        public Criteria andConnamespaceIsNull() {
            addCriterion("connamespace is null");
            return (Criteria) this;
        }

        public Criteria andConnamespaceIsNotNull() {
            addCriterion("connamespace is not null");
            return (Criteria) this;
        }

        public Criteria andConnamespaceEqualTo(Long value) {
            addCriterion("connamespace =", value, "connamespace");
            return (Criteria) this;
        }

        public Criteria andConnamespaceNotEqualTo(Long value) {
            addCriterion("connamespace <>", value, "connamespace");
            return (Criteria) this;
        }

        public Criteria andConnamespaceGreaterThan(Long value) {
            addCriterion("connamespace >", value, "connamespace");
            return (Criteria) this;
        }

        public Criteria andConnamespaceGreaterThanOrEqualTo(Long value) {
            addCriterion("connamespace >=", value, "connamespace");
            return (Criteria) this;
        }

        public Criteria andConnamespaceLessThan(Long value) {
            addCriterion("connamespace <", value, "connamespace");
            return (Criteria) this;
        }

        public Criteria andConnamespaceLessThanOrEqualTo(Long value) {
            addCriterion("connamespace <=", value, "connamespace");
            return (Criteria) this;
        }

        public Criteria andConnamespaceIn(List<Long> values) {
            addCriterion("connamespace in", values, "connamespace");
            return (Criteria) this;
        }

        public Criteria andConnamespaceNotIn(List<Long> values) {
            addCriterion("connamespace not in", values, "connamespace");
            return (Criteria) this;
        }

        public Criteria andConnamespaceBetween(Long value1, Long value2) {
            addCriterion("connamespace between", value1, value2, "connamespace");
            return (Criteria) this;
        }

        public Criteria andConnamespaceNotBetween(Long value1, Long value2) {
            addCriterion("connamespace not between", value1, value2, "connamespace");
            return (Criteria) this;
        }

        public Criteria andConownerIsNull() {
            addCriterion("conowner is null");
            return (Criteria) this;
        }

        public Criteria andConownerIsNotNull() {
            addCriterion("conowner is not null");
            return (Criteria) this;
        }

        public Criteria andConownerEqualTo(Long value) {
            addCriterion("conowner =", value, "conowner");
            return (Criteria) this;
        }

        public Criteria andConownerNotEqualTo(Long value) {
            addCriterion("conowner <>", value, "conowner");
            return (Criteria) this;
        }

        public Criteria andConownerGreaterThan(Long value) {
            addCriterion("conowner >", value, "conowner");
            return (Criteria) this;
        }

        public Criteria andConownerGreaterThanOrEqualTo(Long value) {
            addCriterion("conowner >=", value, "conowner");
            return (Criteria) this;
        }

        public Criteria andConownerLessThan(Long value) {
            addCriterion("conowner <", value, "conowner");
            return (Criteria) this;
        }

        public Criteria andConownerLessThanOrEqualTo(Long value) {
            addCriterion("conowner <=", value, "conowner");
            return (Criteria) this;
        }

        public Criteria andConownerIn(List<Long> values) {
            addCriterion("conowner in", values, "conowner");
            return (Criteria) this;
        }

        public Criteria andConownerNotIn(List<Long> values) {
            addCriterion("conowner not in", values, "conowner");
            return (Criteria) this;
        }

        public Criteria andConownerBetween(Long value1, Long value2) {
            addCriterion("conowner between", value1, value2, "conowner");
            return (Criteria) this;
        }

        public Criteria andConownerNotBetween(Long value1, Long value2) {
            addCriterion("conowner not between", value1, value2, "conowner");
            return (Criteria) this;
        }

        public Criteria andConforencodingIsNull() {
            addCriterion("conforencoding is null");
            return (Criteria) this;
        }

        public Criteria andConforencodingIsNotNull() {
            addCriterion("conforencoding is not null");
            return (Criteria) this;
        }

        public Criteria andConforencodingEqualTo(Integer value) {
            addCriterion("conforencoding =", value, "conforencoding");
            return (Criteria) this;
        }

        public Criteria andConforencodingNotEqualTo(Integer value) {
            addCriterion("conforencoding <>", value, "conforencoding");
            return (Criteria) this;
        }

        public Criteria andConforencodingGreaterThan(Integer value) {
            addCriterion("conforencoding >", value, "conforencoding");
            return (Criteria) this;
        }

        public Criteria andConforencodingGreaterThanOrEqualTo(Integer value) {
            addCriterion("conforencoding >=", value, "conforencoding");
            return (Criteria) this;
        }

        public Criteria andConforencodingLessThan(Integer value) {
            addCriterion("conforencoding <", value, "conforencoding");
            return (Criteria) this;
        }

        public Criteria andConforencodingLessThanOrEqualTo(Integer value) {
            addCriterion("conforencoding <=", value, "conforencoding");
            return (Criteria) this;
        }

        public Criteria andConforencodingIn(List<Integer> values) {
            addCriterion("conforencoding in", values, "conforencoding");
            return (Criteria) this;
        }

        public Criteria andConforencodingNotIn(List<Integer> values) {
            addCriterion("conforencoding not in", values, "conforencoding");
            return (Criteria) this;
        }

        public Criteria andConforencodingBetween(Integer value1, Integer value2) {
            addCriterion("conforencoding between", value1, value2, "conforencoding");
            return (Criteria) this;
        }

        public Criteria andConforencodingNotBetween(Integer value1, Integer value2) {
            addCriterion("conforencoding not between", value1, value2, "conforencoding");
            return (Criteria) this;
        }

        public Criteria andContoencodingIsNull() {
            addCriterion("contoencoding is null");
            return (Criteria) this;
        }

        public Criteria andContoencodingIsNotNull() {
            addCriterion("contoencoding is not null");
            return (Criteria) this;
        }

        public Criteria andContoencodingEqualTo(Integer value) {
            addCriterion("contoencoding =", value, "contoencoding");
            return (Criteria) this;
        }

        public Criteria andContoencodingNotEqualTo(Integer value) {
            addCriterion("contoencoding <>", value, "contoencoding");
            return (Criteria) this;
        }

        public Criteria andContoencodingGreaterThan(Integer value) {
            addCriterion("contoencoding >", value, "contoencoding");
            return (Criteria) this;
        }

        public Criteria andContoencodingGreaterThanOrEqualTo(Integer value) {
            addCriterion("contoencoding >=", value, "contoencoding");
            return (Criteria) this;
        }

        public Criteria andContoencodingLessThan(Integer value) {
            addCriterion("contoencoding <", value, "contoencoding");
            return (Criteria) this;
        }

        public Criteria andContoencodingLessThanOrEqualTo(Integer value) {
            addCriterion("contoencoding <=", value, "contoencoding");
            return (Criteria) this;
        }

        public Criteria andContoencodingIn(List<Integer> values) {
            addCriterion("contoencoding in", values, "contoencoding");
            return (Criteria) this;
        }

        public Criteria andContoencodingNotIn(List<Integer> values) {
            addCriterion("contoencoding not in", values, "contoencoding");
            return (Criteria) this;
        }

        public Criteria andContoencodingBetween(Integer value1, Integer value2) {
            addCriterion("contoencoding between", value1, value2, "contoencoding");
            return (Criteria) this;
        }

        public Criteria andContoencodingNotBetween(Integer value1, Integer value2) {
            addCriterion("contoencoding not between", value1, value2, "contoencoding");
            return (Criteria) this;
        }

        public Criteria andConprocIsNull() {
            addCriterion("conproc is null");
            return (Criteria) this;
        }

        public Criteria andConprocIsNotNull() {
            addCriterion("conproc is not null");
            return (Criteria) this;
        }

        public Criteria andConprocEqualTo(Object value) {
            addCriterion("conproc =", value, "conproc");
            return (Criteria) this;
        }

        public Criteria andConprocNotEqualTo(Object value) {
            addCriterion("conproc <>", value, "conproc");
            return (Criteria) this;
        }

        public Criteria andConprocGreaterThan(Object value) {
            addCriterion("conproc >", value, "conproc");
            return (Criteria) this;
        }

        public Criteria andConprocGreaterThanOrEqualTo(Object value) {
            addCriterion("conproc >=", value, "conproc");
            return (Criteria) this;
        }

        public Criteria andConprocLessThan(Object value) {
            addCriterion("conproc <", value, "conproc");
            return (Criteria) this;
        }

        public Criteria andConprocLessThanOrEqualTo(Object value) {
            addCriterion("conproc <=", value, "conproc");
            return (Criteria) this;
        }

        public Criteria andConprocIn(List<Object> values) {
            addCriterion("conproc in", values, "conproc");
            return (Criteria) this;
        }

        public Criteria andConprocNotIn(List<Object> values) {
            addCriterion("conproc not in", values, "conproc");
            return (Criteria) this;
        }

        public Criteria andConprocBetween(Object value1, Object value2) {
            addCriterion("conproc between", value1, value2, "conproc");
            return (Criteria) this;
        }

        public Criteria andConprocNotBetween(Object value1, Object value2) {
            addCriterion("conproc not between", value1, value2, "conproc");
            return (Criteria) this;
        }

        public Criteria andCondefaultIsNull() {
            addCriterion("condefault is null");
            return (Criteria) this;
        }

        public Criteria andCondefaultIsNotNull() {
            addCriterion("condefault is not null");
            return (Criteria) this;
        }

        public Criteria andCondefaultEqualTo(Boolean value) {
            addCriterion("condefault =", value, "condefault");
            return (Criteria) this;
        }

        public Criteria andCondefaultNotEqualTo(Boolean value) {
            addCriterion("condefault <>", value, "condefault");
            return (Criteria) this;
        }

        public Criteria andCondefaultGreaterThan(Boolean value) {
            addCriterion("condefault >", value, "condefault");
            return (Criteria) this;
        }

        public Criteria andCondefaultGreaterThanOrEqualTo(Boolean value) {
            addCriterion("condefault >=", value, "condefault");
            return (Criteria) this;
        }

        public Criteria andCondefaultLessThan(Boolean value) {
            addCriterion("condefault <", value, "condefault");
            return (Criteria) this;
        }

        public Criteria andCondefaultLessThanOrEqualTo(Boolean value) {
            addCriterion("condefault <=", value, "condefault");
            return (Criteria) this;
        }

        public Criteria andCondefaultIn(List<Boolean> values) {
            addCriterion("condefault in", values, "condefault");
            return (Criteria) this;
        }

        public Criteria andCondefaultNotIn(List<Boolean> values) {
            addCriterion("condefault not in", values, "condefault");
            return (Criteria) this;
        }

        public Criteria andCondefaultBetween(Boolean value1, Boolean value2) {
            addCriterion("condefault between", value1, value2, "condefault");
            return (Criteria) this;
        }

        public Criteria andCondefaultNotBetween(Boolean value1, Boolean value2) {
            addCriterion("condefault not between", value1, value2, "condefault");
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