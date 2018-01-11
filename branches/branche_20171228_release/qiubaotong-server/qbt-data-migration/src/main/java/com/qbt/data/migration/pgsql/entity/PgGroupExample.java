package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgGroupExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgGroupExample() {
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

        public Criteria andGronameIsNull() {
            addCriterion("groname is null");
            return (Criteria) this;
        }

        public Criteria andGronameIsNotNull() {
            addCriterion("groname is not null");
            return (Criteria) this;
        }

        public Criteria andGronameEqualTo(String value) {
            addCriterion("groname =", value, "groname");
            return (Criteria) this;
        }

        public Criteria andGronameNotEqualTo(String value) {
            addCriterion("groname <>", value, "groname");
            return (Criteria) this;
        }

        public Criteria andGronameGreaterThan(String value) {
            addCriterion("groname >", value, "groname");
            return (Criteria) this;
        }

        public Criteria andGronameGreaterThanOrEqualTo(String value) {
            addCriterion("groname >=", value, "groname");
            return (Criteria) this;
        }

        public Criteria andGronameLessThan(String value) {
            addCriterion("groname <", value, "groname");
            return (Criteria) this;
        }

        public Criteria andGronameLessThanOrEqualTo(String value) {
            addCriterion("groname <=", value, "groname");
            return (Criteria) this;
        }

        public Criteria andGronameLike(String value) {
            addCriterion("groname like", value, "groname");
            return (Criteria) this;
        }

        public Criteria andGronameNotLike(String value) {
            addCriterion("groname not like", value, "groname");
            return (Criteria) this;
        }

        public Criteria andGronameIn(List<String> values) {
            addCriterion("groname in", values, "groname");
            return (Criteria) this;
        }

        public Criteria andGronameNotIn(List<String> values) {
            addCriterion("groname not in", values, "groname");
            return (Criteria) this;
        }

        public Criteria andGronameBetween(String value1, String value2) {
            addCriterion("groname between", value1, value2, "groname");
            return (Criteria) this;
        }

        public Criteria andGronameNotBetween(String value1, String value2) {
            addCriterion("groname not between", value1, value2, "groname");
            return (Criteria) this;
        }

        public Criteria andGrosysidIsNull() {
            addCriterion("grosysid is null");
            return (Criteria) this;
        }

        public Criteria andGrosysidIsNotNull() {
            addCriterion("grosysid is not null");
            return (Criteria) this;
        }

        public Criteria andGrosysidEqualTo(Long value) {
            addCriterion("grosysid =", value, "grosysid");
            return (Criteria) this;
        }

        public Criteria andGrosysidNotEqualTo(Long value) {
            addCriterion("grosysid <>", value, "grosysid");
            return (Criteria) this;
        }

        public Criteria andGrosysidGreaterThan(Long value) {
            addCriterion("grosysid >", value, "grosysid");
            return (Criteria) this;
        }

        public Criteria andGrosysidGreaterThanOrEqualTo(Long value) {
            addCriterion("grosysid >=", value, "grosysid");
            return (Criteria) this;
        }

        public Criteria andGrosysidLessThan(Long value) {
            addCriterion("grosysid <", value, "grosysid");
            return (Criteria) this;
        }

        public Criteria andGrosysidLessThanOrEqualTo(Long value) {
            addCriterion("grosysid <=", value, "grosysid");
            return (Criteria) this;
        }

        public Criteria andGrosysidIn(List<Long> values) {
            addCriterion("grosysid in", values, "grosysid");
            return (Criteria) this;
        }

        public Criteria andGrosysidNotIn(List<Long> values) {
            addCriterion("grosysid not in", values, "grosysid");
            return (Criteria) this;
        }

        public Criteria andGrosysidBetween(Long value1, Long value2) {
            addCriterion("grosysid between", value1, value2, "grosysid");
            return (Criteria) this;
        }

        public Criteria andGrosysidNotBetween(Long value1, Long value2) {
            addCriterion("grosysid not between", value1, value2, "grosysid");
            return (Criteria) this;
        }

        public Criteria andGrolistIsNull() {
            addCriterion("grolist is null");
            return (Criteria) this;
        }

        public Criteria andGrolistIsNotNull() {
            addCriterion("grolist is not null");
            return (Criteria) this;
        }

        public Criteria andGrolistEqualTo(Object value) {
            addCriterion("grolist =", value, "grolist");
            return (Criteria) this;
        }

        public Criteria andGrolistNotEqualTo(Object value) {
            addCriterion("grolist <>", value, "grolist");
            return (Criteria) this;
        }

        public Criteria andGrolistGreaterThan(Object value) {
            addCriterion("grolist >", value, "grolist");
            return (Criteria) this;
        }

        public Criteria andGrolistGreaterThanOrEqualTo(Object value) {
            addCriterion("grolist >=", value, "grolist");
            return (Criteria) this;
        }

        public Criteria andGrolistLessThan(Object value) {
            addCriterion("grolist <", value, "grolist");
            return (Criteria) this;
        }

        public Criteria andGrolistLessThanOrEqualTo(Object value) {
            addCriterion("grolist <=", value, "grolist");
            return (Criteria) this;
        }

        public Criteria andGrolistIn(List<Object> values) {
            addCriterion("grolist in", values, "grolist");
            return (Criteria) this;
        }

        public Criteria andGrolistNotIn(List<Object> values) {
            addCriterion("grolist not in", values, "grolist");
            return (Criteria) this;
        }

        public Criteria andGrolistBetween(Object value1, Object value2) {
            addCriterion("grolist between", value1, value2, "grolist");
            return (Criteria) this;
        }

        public Criteria andGrolistNotBetween(Object value1, Object value2) {
            addCriterion("grolist not between", value1, value2, "grolist");
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