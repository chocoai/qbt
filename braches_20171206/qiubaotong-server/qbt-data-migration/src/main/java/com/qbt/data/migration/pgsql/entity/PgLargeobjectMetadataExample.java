package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgLargeobjectMetadataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgLargeobjectMetadataExample() {
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

        public Criteria andLomownerIsNull() {
            addCriterion("lomowner is null");
            return (Criteria) this;
        }

        public Criteria andLomownerIsNotNull() {
            addCriterion("lomowner is not null");
            return (Criteria) this;
        }

        public Criteria andLomownerEqualTo(Long value) {
            addCriterion("lomowner =", value, "lomowner");
            return (Criteria) this;
        }

        public Criteria andLomownerNotEqualTo(Long value) {
            addCriterion("lomowner <>", value, "lomowner");
            return (Criteria) this;
        }

        public Criteria andLomownerGreaterThan(Long value) {
            addCriterion("lomowner >", value, "lomowner");
            return (Criteria) this;
        }

        public Criteria andLomownerGreaterThanOrEqualTo(Long value) {
            addCriterion("lomowner >=", value, "lomowner");
            return (Criteria) this;
        }

        public Criteria andLomownerLessThan(Long value) {
            addCriterion("lomowner <", value, "lomowner");
            return (Criteria) this;
        }

        public Criteria andLomownerLessThanOrEqualTo(Long value) {
            addCriterion("lomowner <=", value, "lomowner");
            return (Criteria) this;
        }

        public Criteria andLomownerIn(List<Long> values) {
            addCriterion("lomowner in", values, "lomowner");
            return (Criteria) this;
        }

        public Criteria andLomownerNotIn(List<Long> values) {
            addCriterion("lomowner not in", values, "lomowner");
            return (Criteria) this;
        }

        public Criteria andLomownerBetween(Long value1, Long value2) {
            addCriterion("lomowner between", value1, value2, "lomowner");
            return (Criteria) this;
        }

        public Criteria andLomownerNotBetween(Long value1, Long value2) {
            addCriterion("lomowner not between", value1, value2, "lomowner");
            return (Criteria) this;
        }

        public Criteria andLomaclIsNull() {
            addCriterion("lomacl is null");
            return (Criteria) this;
        }

        public Criteria andLomaclIsNotNull() {
            addCriterion("lomacl is not null");
            return (Criteria) this;
        }

        public Criteria andLomaclEqualTo(Object value) {
            addCriterion("lomacl =", value, "lomacl");
            return (Criteria) this;
        }

        public Criteria andLomaclNotEqualTo(Object value) {
            addCriterion("lomacl <>", value, "lomacl");
            return (Criteria) this;
        }

        public Criteria andLomaclGreaterThan(Object value) {
            addCriterion("lomacl >", value, "lomacl");
            return (Criteria) this;
        }

        public Criteria andLomaclGreaterThanOrEqualTo(Object value) {
            addCriterion("lomacl >=", value, "lomacl");
            return (Criteria) this;
        }

        public Criteria andLomaclLessThan(Object value) {
            addCriterion("lomacl <", value, "lomacl");
            return (Criteria) this;
        }

        public Criteria andLomaclLessThanOrEqualTo(Object value) {
            addCriterion("lomacl <=", value, "lomacl");
            return (Criteria) this;
        }

        public Criteria andLomaclIn(List<Object> values) {
            addCriterion("lomacl in", values, "lomacl");
            return (Criteria) this;
        }

        public Criteria andLomaclNotIn(List<Object> values) {
            addCriterion("lomacl not in", values, "lomacl");
            return (Criteria) this;
        }

        public Criteria andLomaclBetween(Object value1, Object value2) {
            addCriterion("lomacl between", value1, value2, "lomacl");
            return (Criteria) this;
        }

        public Criteria andLomaclNotBetween(Object value1, Object value2) {
            addCriterion("lomacl not between", value1, value2, "lomacl");
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