package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgTablespaceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgTablespaceExample() {
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

        public Criteria andSpcnameIsNull() {
            addCriterion("spcname is null");
            return (Criteria) this;
        }

        public Criteria andSpcnameIsNotNull() {
            addCriterion("spcname is not null");
            return (Criteria) this;
        }

        public Criteria andSpcnameEqualTo(String value) {
            addCriterion("spcname =", value, "spcname");
            return (Criteria) this;
        }

        public Criteria andSpcnameNotEqualTo(String value) {
            addCriterion("spcname <>", value, "spcname");
            return (Criteria) this;
        }

        public Criteria andSpcnameGreaterThan(String value) {
            addCriterion("spcname >", value, "spcname");
            return (Criteria) this;
        }

        public Criteria andSpcnameGreaterThanOrEqualTo(String value) {
            addCriterion("spcname >=", value, "spcname");
            return (Criteria) this;
        }

        public Criteria andSpcnameLessThan(String value) {
            addCriterion("spcname <", value, "spcname");
            return (Criteria) this;
        }

        public Criteria andSpcnameLessThanOrEqualTo(String value) {
            addCriterion("spcname <=", value, "spcname");
            return (Criteria) this;
        }

        public Criteria andSpcnameLike(String value) {
            addCriterion("spcname like", value, "spcname");
            return (Criteria) this;
        }

        public Criteria andSpcnameNotLike(String value) {
            addCriterion("spcname not like", value, "spcname");
            return (Criteria) this;
        }

        public Criteria andSpcnameIn(List<String> values) {
            addCriterion("spcname in", values, "spcname");
            return (Criteria) this;
        }

        public Criteria andSpcnameNotIn(List<String> values) {
            addCriterion("spcname not in", values, "spcname");
            return (Criteria) this;
        }

        public Criteria andSpcnameBetween(String value1, String value2) {
            addCriterion("spcname between", value1, value2, "spcname");
            return (Criteria) this;
        }

        public Criteria andSpcnameNotBetween(String value1, String value2) {
            addCriterion("spcname not between", value1, value2, "spcname");
            return (Criteria) this;
        }

        public Criteria andSpcownerIsNull() {
            addCriterion("spcowner is null");
            return (Criteria) this;
        }

        public Criteria andSpcownerIsNotNull() {
            addCriterion("spcowner is not null");
            return (Criteria) this;
        }

        public Criteria andSpcownerEqualTo(Long value) {
            addCriterion("spcowner =", value, "spcowner");
            return (Criteria) this;
        }

        public Criteria andSpcownerNotEqualTo(Long value) {
            addCriterion("spcowner <>", value, "spcowner");
            return (Criteria) this;
        }

        public Criteria andSpcownerGreaterThan(Long value) {
            addCriterion("spcowner >", value, "spcowner");
            return (Criteria) this;
        }

        public Criteria andSpcownerGreaterThanOrEqualTo(Long value) {
            addCriterion("spcowner >=", value, "spcowner");
            return (Criteria) this;
        }

        public Criteria andSpcownerLessThan(Long value) {
            addCriterion("spcowner <", value, "spcowner");
            return (Criteria) this;
        }

        public Criteria andSpcownerLessThanOrEqualTo(Long value) {
            addCriterion("spcowner <=", value, "spcowner");
            return (Criteria) this;
        }

        public Criteria andSpcownerIn(List<Long> values) {
            addCriterion("spcowner in", values, "spcowner");
            return (Criteria) this;
        }

        public Criteria andSpcownerNotIn(List<Long> values) {
            addCriterion("spcowner not in", values, "spcowner");
            return (Criteria) this;
        }

        public Criteria andSpcownerBetween(Long value1, Long value2) {
            addCriterion("spcowner between", value1, value2, "spcowner");
            return (Criteria) this;
        }

        public Criteria andSpcownerNotBetween(Long value1, Long value2) {
            addCriterion("spcowner not between", value1, value2, "spcowner");
            return (Criteria) this;
        }

        public Criteria andSpcaclIsNull() {
            addCriterion("spcacl is null");
            return (Criteria) this;
        }

        public Criteria andSpcaclIsNotNull() {
            addCriterion("spcacl is not null");
            return (Criteria) this;
        }

        public Criteria andSpcaclEqualTo(Object value) {
            addCriterion("spcacl =", value, "spcacl");
            return (Criteria) this;
        }

        public Criteria andSpcaclNotEqualTo(Object value) {
            addCriterion("spcacl <>", value, "spcacl");
            return (Criteria) this;
        }

        public Criteria andSpcaclGreaterThan(Object value) {
            addCriterion("spcacl >", value, "spcacl");
            return (Criteria) this;
        }

        public Criteria andSpcaclGreaterThanOrEqualTo(Object value) {
            addCriterion("spcacl >=", value, "spcacl");
            return (Criteria) this;
        }

        public Criteria andSpcaclLessThan(Object value) {
            addCriterion("spcacl <", value, "spcacl");
            return (Criteria) this;
        }

        public Criteria andSpcaclLessThanOrEqualTo(Object value) {
            addCriterion("spcacl <=", value, "spcacl");
            return (Criteria) this;
        }

        public Criteria andSpcaclIn(List<Object> values) {
            addCriterion("spcacl in", values, "spcacl");
            return (Criteria) this;
        }

        public Criteria andSpcaclNotIn(List<Object> values) {
            addCriterion("spcacl not in", values, "spcacl");
            return (Criteria) this;
        }

        public Criteria andSpcaclBetween(Object value1, Object value2) {
            addCriterion("spcacl between", value1, value2, "spcacl");
            return (Criteria) this;
        }

        public Criteria andSpcaclNotBetween(Object value1, Object value2) {
            addCriterion("spcacl not between", value1, value2, "spcacl");
            return (Criteria) this;
        }

        public Criteria andSpcoptionsIsNull() {
            addCriterion("spcoptions is null");
            return (Criteria) this;
        }

        public Criteria andSpcoptionsIsNotNull() {
            addCriterion("spcoptions is not null");
            return (Criteria) this;
        }

        public Criteria andSpcoptionsEqualTo(Object value) {
            addCriterion("spcoptions =", value, "spcoptions");
            return (Criteria) this;
        }

        public Criteria andSpcoptionsNotEqualTo(Object value) {
            addCriterion("spcoptions <>", value, "spcoptions");
            return (Criteria) this;
        }

        public Criteria andSpcoptionsGreaterThan(Object value) {
            addCriterion("spcoptions >", value, "spcoptions");
            return (Criteria) this;
        }

        public Criteria andSpcoptionsGreaterThanOrEqualTo(Object value) {
            addCriterion("spcoptions >=", value, "spcoptions");
            return (Criteria) this;
        }

        public Criteria andSpcoptionsLessThan(Object value) {
            addCriterion("spcoptions <", value, "spcoptions");
            return (Criteria) this;
        }

        public Criteria andSpcoptionsLessThanOrEqualTo(Object value) {
            addCriterion("spcoptions <=", value, "spcoptions");
            return (Criteria) this;
        }

        public Criteria andSpcoptionsIn(List<Object> values) {
            addCriterion("spcoptions in", values, "spcoptions");
            return (Criteria) this;
        }

        public Criteria andSpcoptionsNotIn(List<Object> values) {
            addCriterion("spcoptions not in", values, "spcoptions");
            return (Criteria) this;
        }

        public Criteria andSpcoptionsBetween(Object value1, Object value2) {
            addCriterion("spcoptions between", value1, value2, "spcoptions");
            return (Criteria) this;
        }

        public Criteria andSpcoptionsNotBetween(Object value1, Object value2) {
            addCriterion("spcoptions not between", value1, value2, "spcoptions");
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