package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgNamespaceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgNamespaceExample() {
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

        public Criteria andNspnameIsNull() {
            addCriterion("nspname is null");
            return (Criteria) this;
        }

        public Criteria andNspnameIsNotNull() {
            addCriterion("nspname is not null");
            return (Criteria) this;
        }

        public Criteria andNspnameEqualTo(String value) {
            addCriterion("nspname =", value, "nspname");
            return (Criteria) this;
        }

        public Criteria andNspnameNotEqualTo(String value) {
            addCriterion("nspname <>", value, "nspname");
            return (Criteria) this;
        }

        public Criteria andNspnameGreaterThan(String value) {
            addCriterion("nspname >", value, "nspname");
            return (Criteria) this;
        }

        public Criteria andNspnameGreaterThanOrEqualTo(String value) {
            addCriterion("nspname >=", value, "nspname");
            return (Criteria) this;
        }

        public Criteria andNspnameLessThan(String value) {
            addCriterion("nspname <", value, "nspname");
            return (Criteria) this;
        }

        public Criteria andNspnameLessThanOrEqualTo(String value) {
            addCriterion("nspname <=", value, "nspname");
            return (Criteria) this;
        }

        public Criteria andNspnameLike(String value) {
            addCriterion("nspname like", value, "nspname");
            return (Criteria) this;
        }

        public Criteria andNspnameNotLike(String value) {
            addCriterion("nspname not like", value, "nspname");
            return (Criteria) this;
        }

        public Criteria andNspnameIn(List<String> values) {
            addCriterion("nspname in", values, "nspname");
            return (Criteria) this;
        }

        public Criteria andNspnameNotIn(List<String> values) {
            addCriterion("nspname not in", values, "nspname");
            return (Criteria) this;
        }

        public Criteria andNspnameBetween(String value1, String value2) {
            addCriterion("nspname between", value1, value2, "nspname");
            return (Criteria) this;
        }

        public Criteria andNspnameNotBetween(String value1, String value2) {
            addCriterion("nspname not between", value1, value2, "nspname");
            return (Criteria) this;
        }

        public Criteria andNspownerIsNull() {
            addCriterion("nspowner is null");
            return (Criteria) this;
        }

        public Criteria andNspownerIsNotNull() {
            addCriterion("nspowner is not null");
            return (Criteria) this;
        }

        public Criteria andNspownerEqualTo(Long value) {
            addCriterion("nspowner =", value, "nspowner");
            return (Criteria) this;
        }

        public Criteria andNspownerNotEqualTo(Long value) {
            addCriterion("nspowner <>", value, "nspowner");
            return (Criteria) this;
        }

        public Criteria andNspownerGreaterThan(Long value) {
            addCriterion("nspowner >", value, "nspowner");
            return (Criteria) this;
        }

        public Criteria andNspownerGreaterThanOrEqualTo(Long value) {
            addCriterion("nspowner >=", value, "nspowner");
            return (Criteria) this;
        }

        public Criteria andNspownerLessThan(Long value) {
            addCriterion("nspowner <", value, "nspowner");
            return (Criteria) this;
        }

        public Criteria andNspownerLessThanOrEqualTo(Long value) {
            addCriterion("nspowner <=", value, "nspowner");
            return (Criteria) this;
        }

        public Criteria andNspownerIn(List<Long> values) {
            addCriterion("nspowner in", values, "nspowner");
            return (Criteria) this;
        }

        public Criteria andNspownerNotIn(List<Long> values) {
            addCriterion("nspowner not in", values, "nspowner");
            return (Criteria) this;
        }

        public Criteria andNspownerBetween(Long value1, Long value2) {
            addCriterion("nspowner between", value1, value2, "nspowner");
            return (Criteria) this;
        }

        public Criteria andNspownerNotBetween(Long value1, Long value2) {
            addCriterion("nspowner not between", value1, value2, "nspowner");
            return (Criteria) this;
        }

        public Criteria andNspaclIsNull() {
            addCriterion("nspacl is null");
            return (Criteria) this;
        }

        public Criteria andNspaclIsNotNull() {
            addCriterion("nspacl is not null");
            return (Criteria) this;
        }

        public Criteria andNspaclEqualTo(Object value) {
            addCriterion("nspacl =", value, "nspacl");
            return (Criteria) this;
        }

        public Criteria andNspaclNotEqualTo(Object value) {
            addCriterion("nspacl <>", value, "nspacl");
            return (Criteria) this;
        }

        public Criteria andNspaclGreaterThan(Object value) {
            addCriterion("nspacl >", value, "nspacl");
            return (Criteria) this;
        }

        public Criteria andNspaclGreaterThanOrEqualTo(Object value) {
            addCriterion("nspacl >=", value, "nspacl");
            return (Criteria) this;
        }

        public Criteria andNspaclLessThan(Object value) {
            addCriterion("nspacl <", value, "nspacl");
            return (Criteria) this;
        }

        public Criteria andNspaclLessThanOrEqualTo(Object value) {
            addCriterion("nspacl <=", value, "nspacl");
            return (Criteria) this;
        }

        public Criteria andNspaclIn(List<Object> values) {
            addCriterion("nspacl in", values, "nspacl");
            return (Criteria) this;
        }

        public Criteria andNspaclNotIn(List<Object> values) {
            addCriterion("nspacl not in", values, "nspacl");
            return (Criteria) this;
        }

        public Criteria andNspaclBetween(Object value1, Object value2) {
            addCriterion("nspacl between", value1, value2, "nspacl");
            return (Criteria) this;
        }

        public Criteria andNspaclNotBetween(Object value1, Object value2) {
            addCriterion("nspacl not between", value1, value2, "nspacl");
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