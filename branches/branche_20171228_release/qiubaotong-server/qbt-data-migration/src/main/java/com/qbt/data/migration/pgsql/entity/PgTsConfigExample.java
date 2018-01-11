package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgTsConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgTsConfigExample() {
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

        public Criteria andCfgnameIsNull() {
            addCriterion("cfgname is null");
            return (Criteria) this;
        }

        public Criteria andCfgnameIsNotNull() {
            addCriterion("cfgname is not null");
            return (Criteria) this;
        }

        public Criteria andCfgnameEqualTo(String value) {
            addCriterion("cfgname =", value, "cfgname");
            return (Criteria) this;
        }

        public Criteria andCfgnameNotEqualTo(String value) {
            addCriterion("cfgname <>", value, "cfgname");
            return (Criteria) this;
        }

        public Criteria andCfgnameGreaterThan(String value) {
            addCriterion("cfgname >", value, "cfgname");
            return (Criteria) this;
        }

        public Criteria andCfgnameGreaterThanOrEqualTo(String value) {
            addCriterion("cfgname >=", value, "cfgname");
            return (Criteria) this;
        }

        public Criteria andCfgnameLessThan(String value) {
            addCriterion("cfgname <", value, "cfgname");
            return (Criteria) this;
        }

        public Criteria andCfgnameLessThanOrEqualTo(String value) {
            addCriterion("cfgname <=", value, "cfgname");
            return (Criteria) this;
        }

        public Criteria andCfgnameLike(String value) {
            addCriterion("cfgname like", value, "cfgname");
            return (Criteria) this;
        }

        public Criteria andCfgnameNotLike(String value) {
            addCriterion("cfgname not like", value, "cfgname");
            return (Criteria) this;
        }

        public Criteria andCfgnameIn(List<String> values) {
            addCriterion("cfgname in", values, "cfgname");
            return (Criteria) this;
        }

        public Criteria andCfgnameNotIn(List<String> values) {
            addCriterion("cfgname not in", values, "cfgname");
            return (Criteria) this;
        }

        public Criteria andCfgnameBetween(String value1, String value2) {
            addCriterion("cfgname between", value1, value2, "cfgname");
            return (Criteria) this;
        }

        public Criteria andCfgnameNotBetween(String value1, String value2) {
            addCriterion("cfgname not between", value1, value2, "cfgname");
            return (Criteria) this;
        }

        public Criteria andCfgnamespaceIsNull() {
            addCriterion("cfgnamespace is null");
            return (Criteria) this;
        }

        public Criteria andCfgnamespaceIsNotNull() {
            addCriterion("cfgnamespace is not null");
            return (Criteria) this;
        }

        public Criteria andCfgnamespaceEqualTo(Long value) {
            addCriterion("cfgnamespace =", value, "cfgnamespace");
            return (Criteria) this;
        }

        public Criteria andCfgnamespaceNotEqualTo(Long value) {
            addCriterion("cfgnamespace <>", value, "cfgnamespace");
            return (Criteria) this;
        }

        public Criteria andCfgnamespaceGreaterThan(Long value) {
            addCriterion("cfgnamespace >", value, "cfgnamespace");
            return (Criteria) this;
        }

        public Criteria andCfgnamespaceGreaterThanOrEqualTo(Long value) {
            addCriterion("cfgnamespace >=", value, "cfgnamespace");
            return (Criteria) this;
        }

        public Criteria andCfgnamespaceLessThan(Long value) {
            addCriterion("cfgnamespace <", value, "cfgnamespace");
            return (Criteria) this;
        }

        public Criteria andCfgnamespaceLessThanOrEqualTo(Long value) {
            addCriterion("cfgnamespace <=", value, "cfgnamespace");
            return (Criteria) this;
        }

        public Criteria andCfgnamespaceIn(List<Long> values) {
            addCriterion("cfgnamespace in", values, "cfgnamespace");
            return (Criteria) this;
        }

        public Criteria andCfgnamespaceNotIn(List<Long> values) {
            addCriterion("cfgnamespace not in", values, "cfgnamespace");
            return (Criteria) this;
        }

        public Criteria andCfgnamespaceBetween(Long value1, Long value2) {
            addCriterion("cfgnamespace between", value1, value2, "cfgnamespace");
            return (Criteria) this;
        }

        public Criteria andCfgnamespaceNotBetween(Long value1, Long value2) {
            addCriterion("cfgnamespace not between", value1, value2, "cfgnamespace");
            return (Criteria) this;
        }

        public Criteria andCfgownerIsNull() {
            addCriterion("cfgowner is null");
            return (Criteria) this;
        }

        public Criteria andCfgownerIsNotNull() {
            addCriterion("cfgowner is not null");
            return (Criteria) this;
        }

        public Criteria andCfgownerEqualTo(Long value) {
            addCriterion("cfgowner =", value, "cfgowner");
            return (Criteria) this;
        }

        public Criteria andCfgownerNotEqualTo(Long value) {
            addCriterion("cfgowner <>", value, "cfgowner");
            return (Criteria) this;
        }

        public Criteria andCfgownerGreaterThan(Long value) {
            addCriterion("cfgowner >", value, "cfgowner");
            return (Criteria) this;
        }

        public Criteria andCfgownerGreaterThanOrEqualTo(Long value) {
            addCriterion("cfgowner >=", value, "cfgowner");
            return (Criteria) this;
        }

        public Criteria andCfgownerLessThan(Long value) {
            addCriterion("cfgowner <", value, "cfgowner");
            return (Criteria) this;
        }

        public Criteria andCfgownerLessThanOrEqualTo(Long value) {
            addCriterion("cfgowner <=", value, "cfgowner");
            return (Criteria) this;
        }

        public Criteria andCfgownerIn(List<Long> values) {
            addCriterion("cfgowner in", values, "cfgowner");
            return (Criteria) this;
        }

        public Criteria andCfgownerNotIn(List<Long> values) {
            addCriterion("cfgowner not in", values, "cfgowner");
            return (Criteria) this;
        }

        public Criteria andCfgownerBetween(Long value1, Long value2) {
            addCriterion("cfgowner between", value1, value2, "cfgowner");
            return (Criteria) this;
        }

        public Criteria andCfgownerNotBetween(Long value1, Long value2) {
            addCriterion("cfgowner not between", value1, value2, "cfgowner");
            return (Criteria) this;
        }

        public Criteria andCfgparserIsNull() {
            addCriterion("cfgparser is null");
            return (Criteria) this;
        }

        public Criteria andCfgparserIsNotNull() {
            addCriterion("cfgparser is not null");
            return (Criteria) this;
        }

        public Criteria andCfgparserEqualTo(Long value) {
            addCriterion("cfgparser =", value, "cfgparser");
            return (Criteria) this;
        }

        public Criteria andCfgparserNotEqualTo(Long value) {
            addCriterion("cfgparser <>", value, "cfgparser");
            return (Criteria) this;
        }

        public Criteria andCfgparserGreaterThan(Long value) {
            addCriterion("cfgparser >", value, "cfgparser");
            return (Criteria) this;
        }

        public Criteria andCfgparserGreaterThanOrEqualTo(Long value) {
            addCriterion("cfgparser >=", value, "cfgparser");
            return (Criteria) this;
        }

        public Criteria andCfgparserLessThan(Long value) {
            addCriterion("cfgparser <", value, "cfgparser");
            return (Criteria) this;
        }

        public Criteria andCfgparserLessThanOrEqualTo(Long value) {
            addCriterion("cfgparser <=", value, "cfgparser");
            return (Criteria) this;
        }

        public Criteria andCfgparserIn(List<Long> values) {
            addCriterion("cfgparser in", values, "cfgparser");
            return (Criteria) this;
        }

        public Criteria andCfgparserNotIn(List<Long> values) {
            addCriterion("cfgparser not in", values, "cfgparser");
            return (Criteria) this;
        }

        public Criteria andCfgparserBetween(Long value1, Long value2) {
            addCriterion("cfgparser between", value1, value2, "cfgparser");
            return (Criteria) this;
        }

        public Criteria andCfgparserNotBetween(Long value1, Long value2) {
            addCriterion("cfgparser not between", value1, value2, "cfgparser");
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