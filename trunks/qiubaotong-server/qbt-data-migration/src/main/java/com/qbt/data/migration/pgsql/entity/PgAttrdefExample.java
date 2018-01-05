package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgAttrdefExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgAttrdefExample() {
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

        public Criteria andAdrelidIsNull() {
            addCriterion("adrelid is null");
            return (Criteria) this;
        }

        public Criteria andAdrelidIsNotNull() {
            addCriterion("adrelid is not null");
            return (Criteria) this;
        }

        public Criteria andAdrelidEqualTo(Long value) {
            addCriterion("adrelid =", value, "adrelid");
            return (Criteria) this;
        }

        public Criteria andAdrelidNotEqualTo(Long value) {
            addCriterion("adrelid <>", value, "adrelid");
            return (Criteria) this;
        }

        public Criteria andAdrelidGreaterThan(Long value) {
            addCriterion("adrelid >", value, "adrelid");
            return (Criteria) this;
        }

        public Criteria andAdrelidGreaterThanOrEqualTo(Long value) {
            addCriterion("adrelid >=", value, "adrelid");
            return (Criteria) this;
        }

        public Criteria andAdrelidLessThan(Long value) {
            addCriterion("adrelid <", value, "adrelid");
            return (Criteria) this;
        }

        public Criteria andAdrelidLessThanOrEqualTo(Long value) {
            addCriterion("adrelid <=", value, "adrelid");
            return (Criteria) this;
        }

        public Criteria andAdrelidIn(List<Long> values) {
            addCriterion("adrelid in", values, "adrelid");
            return (Criteria) this;
        }

        public Criteria andAdrelidNotIn(List<Long> values) {
            addCriterion("adrelid not in", values, "adrelid");
            return (Criteria) this;
        }

        public Criteria andAdrelidBetween(Long value1, Long value2) {
            addCriterion("adrelid between", value1, value2, "adrelid");
            return (Criteria) this;
        }

        public Criteria andAdrelidNotBetween(Long value1, Long value2) {
            addCriterion("adrelid not between", value1, value2, "adrelid");
            return (Criteria) this;
        }

        public Criteria andAdnumIsNull() {
            addCriterion("adnum is null");
            return (Criteria) this;
        }

        public Criteria andAdnumIsNotNull() {
            addCriterion("adnum is not null");
            return (Criteria) this;
        }

        public Criteria andAdnumEqualTo(Short value) {
            addCriterion("adnum =", value, "adnum");
            return (Criteria) this;
        }

        public Criteria andAdnumNotEqualTo(Short value) {
            addCriterion("adnum <>", value, "adnum");
            return (Criteria) this;
        }

        public Criteria andAdnumGreaterThan(Short value) {
            addCriterion("adnum >", value, "adnum");
            return (Criteria) this;
        }

        public Criteria andAdnumGreaterThanOrEqualTo(Short value) {
            addCriterion("adnum >=", value, "adnum");
            return (Criteria) this;
        }

        public Criteria andAdnumLessThan(Short value) {
            addCriterion("adnum <", value, "adnum");
            return (Criteria) this;
        }

        public Criteria andAdnumLessThanOrEqualTo(Short value) {
            addCriterion("adnum <=", value, "adnum");
            return (Criteria) this;
        }

        public Criteria andAdnumIn(List<Short> values) {
            addCriterion("adnum in", values, "adnum");
            return (Criteria) this;
        }

        public Criteria andAdnumNotIn(List<Short> values) {
            addCriterion("adnum not in", values, "adnum");
            return (Criteria) this;
        }

        public Criteria andAdnumBetween(Short value1, Short value2) {
            addCriterion("adnum between", value1, value2, "adnum");
            return (Criteria) this;
        }

        public Criteria andAdnumNotBetween(Short value1, Short value2) {
            addCriterion("adnum not between", value1, value2, "adnum");
            return (Criteria) this;
        }

        public Criteria andAdbinIsNull() {
            addCriterion("adbin is null");
            return (Criteria) this;
        }

        public Criteria andAdbinIsNotNull() {
            addCriterion("adbin is not null");
            return (Criteria) this;
        }

        public Criteria andAdbinEqualTo(Object value) {
            addCriterion("adbin =", value, "adbin");
            return (Criteria) this;
        }

        public Criteria andAdbinNotEqualTo(Object value) {
            addCriterion("adbin <>", value, "adbin");
            return (Criteria) this;
        }

        public Criteria andAdbinGreaterThan(Object value) {
            addCriterion("adbin >", value, "adbin");
            return (Criteria) this;
        }

        public Criteria andAdbinGreaterThanOrEqualTo(Object value) {
            addCriterion("adbin >=", value, "adbin");
            return (Criteria) this;
        }

        public Criteria andAdbinLessThan(Object value) {
            addCriterion("adbin <", value, "adbin");
            return (Criteria) this;
        }

        public Criteria andAdbinLessThanOrEqualTo(Object value) {
            addCriterion("adbin <=", value, "adbin");
            return (Criteria) this;
        }

        public Criteria andAdbinIn(List<Object> values) {
            addCriterion("adbin in", values, "adbin");
            return (Criteria) this;
        }

        public Criteria andAdbinNotIn(List<Object> values) {
            addCriterion("adbin not in", values, "adbin");
            return (Criteria) this;
        }

        public Criteria andAdbinBetween(Object value1, Object value2) {
            addCriterion("adbin between", value1, value2, "adbin");
            return (Criteria) this;
        }

        public Criteria andAdbinNotBetween(Object value1, Object value2) {
            addCriterion("adbin not between", value1, value2, "adbin");
            return (Criteria) this;
        }

        public Criteria andAdsrcIsNull() {
            addCriterion("adsrc is null");
            return (Criteria) this;
        }

        public Criteria andAdsrcIsNotNull() {
            addCriterion("adsrc is not null");
            return (Criteria) this;
        }

        public Criteria andAdsrcEqualTo(String value) {
            addCriterion("adsrc =", value, "adsrc");
            return (Criteria) this;
        }

        public Criteria andAdsrcNotEqualTo(String value) {
            addCriterion("adsrc <>", value, "adsrc");
            return (Criteria) this;
        }

        public Criteria andAdsrcGreaterThan(String value) {
            addCriterion("adsrc >", value, "adsrc");
            return (Criteria) this;
        }

        public Criteria andAdsrcGreaterThanOrEqualTo(String value) {
            addCriterion("adsrc >=", value, "adsrc");
            return (Criteria) this;
        }

        public Criteria andAdsrcLessThan(String value) {
            addCriterion("adsrc <", value, "adsrc");
            return (Criteria) this;
        }

        public Criteria andAdsrcLessThanOrEqualTo(String value) {
            addCriterion("adsrc <=", value, "adsrc");
            return (Criteria) this;
        }

        public Criteria andAdsrcLike(String value) {
            addCriterion("adsrc like", value, "adsrc");
            return (Criteria) this;
        }

        public Criteria andAdsrcNotLike(String value) {
            addCriterion("adsrc not like", value, "adsrc");
            return (Criteria) this;
        }

        public Criteria andAdsrcIn(List<String> values) {
            addCriterion("adsrc in", values, "adsrc");
            return (Criteria) this;
        }

        public Criteria andAdsrcNotIn(List<String> values) {
            addCriterion("adsrc not in", values, "adsrc");
            return (Criteria) this;
        }

        public Criteria andAdsrcBetween(String value1, String value2) {
            addCriterion("adsrc between", value1, value2, "adsrc");
            return (Criteria) this;
        }

        public Criteria andAdsrcNotBetween(String value1, String value2) {
            addCriterion("adsrc not between", value1, value2, "adsrc");
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