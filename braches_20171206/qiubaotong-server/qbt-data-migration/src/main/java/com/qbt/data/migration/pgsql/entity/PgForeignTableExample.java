package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgForeignTableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgForeignTableExample() {
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

        public Criteria andFtrelidIsNull() {
            addCriterion("ftrelid is null");
            return (Criteria) this;
        }

        public Criteria andFtrelidIsNotNull() {
            addCriterion("ftrelid is not null");
            return (Criteria) this;
        }

        public Criteria andFtrelidEqualTo(Long value) {
            addCriterion("ftrelid =", value, "ftrelid");
            return (Criteria) this;
        }

        public Criteria andFtrelidNotEqualTo(Long value) {
            addCriterion("ftrelid <>", value, "ftrelid");
            return (Criteria) this;
        }

        public Criteria andFtrelidGreaterThan(Long value) {
            addCriterion("ftrelid >", value, "ftrelid");
            return (Criteria) this;
        }

        public Criteria andFtrelidGreaterThanOrEqualTo(Long value) {
            addCriterion("ftrelid >=", value, "ftrelid");
            return (Criteria) this;
        }

        public Criteria andFtrelidLessThan(Long value) {
            addCriterion("ftrelid <", value, "ftrelid");
            return (Criteria) this;
        }

        public Criteria andFtrelidLessThanOrEqualTo(Long value) {
            addCriterion("ftrelid <=", value, "ftrelid");
            return (Criteria) this;
        }

        public Criteria andFtrelidIn(List<Long> values) {
            addCriterion("ftrelid in", values, "ftrelid");
            return (Criteria) this;
        }

        public Criteria andFtrelidNotIn(List<Long> values) {
            addCriterion("ftrelid not in", values, "ftrelid");
            return (Criteria) this;
        }

        public Criteria andFtrelidBetween(Long value1, Long value2) {
            addCriterion("ftrelid between", value1, value2, "ftrelid");
            return (Criteria) this;
        }

        public Criteria andFtrelidNotBetween(Long value1, Long value2) {
            addCriterion("ftrelid not between", value1, value2, "ftrelid");
            return (Criteria) this;
        }

        public Criteria andFtserverIsNull() {
            addCriterion("ftserver is null");
            return (Criteria) this;
        }

        public Criteria andFtserverIsNotNull() {
            addCriterion("ftserver is not null");
            return (Criteria) this;
        }

        public Criteria andFtserverEqualTo(Long value) {
            addCriterion("ftserver =", value, "ftserver");
            return (Criteria) this;
        }

        public Criteria andFtserverNotEqualTo(Long value) {
            addCriterion("ftserver <>", value, "ftserver");
            return (Criteria) this;
        }

        public Criteria andFtserverGreaterThan(Long value) {
            addCriterion("ftserver >", value, "ftserver");
            return (Criteria) this;
        }

        public Criteria andFtserverGreaterThanOrEqualTo(Long value) {
            addCriterion("ftserver >=", value, "ftserver");
            return (Criteria) this;
        }

        public Criteria andFtserverLessThan(Long value) {
            addCriterion("ftserver <", value, "ftserver");
            return (Criteria) this;
        }

        public Criteria andFtserverLessThanOrEqualTo(Long value) {
            addCriterion("ftserver <=", value, "ftserver");
            return (Criteria) this;
        }

        public Criteria andFtserverIn(List<Long> values) {
            addCriterion("ftserver in", values, "ftserver");
            return (Criteria) this;
        }

        public Criteria andFtserverNotIn(List<Long> values) {
            addCriterion("ftserver not in", values, "ftserver");
            return (Criteria) this;
        }

        public Criteria andFtserverBetween(Long value1, Long value2) {
            addCriterion("ftserver between", value1, value2, "ftserver");
            return (Criteria) this;
        }

        public Criteria andFtserverNotBetween(Long value1, Long value2) {
            addCriterion("ftserver not between", value1, value2, "ftserver");
            return (Criteria) this;
        }

        public Criteria andFtoptionsIsNull() {
            addCriterion("ftoptions is null");
            return (Criteria) this;
        }

        public Criteria andFtoptionsIsNotNull() {
            addCriterion("ftoptions is not null");
            return (Criteria) this;
        }

        public Criteria andFtoptionsEqualTo(Object value) {
            addCriterion("ftoptions =", value, "ftoptions");
            return (Criteria) this;
        }

        public Criteria andFtoptionsNotEqualTo(Object value) {
            addCriterion("ftoptions <>", value, "ftoptions");
            return (Criteria) this;
        }

        public Criteria andFtoptionsGreaterThan(Object value) {
            addCriterion("ftoptions >", value, "ftoptions");
            return (Criteria) this;
        }

        public Criteria andFtoptionsGreaterThanOrEqualTo(Object value) {
            addCriterion("ftoptions >=", value, "ftoptions");
            return (Criteria) this;
        }

        public Criteria andFtoptionsLessThan(Object value) {
            addCriterion("ftoptions <", value, "ftoptions");
            return (Criteria) this;
        }

        public Criteria andFtoptionsLessThanOrEqualTo(Object value) {
            addCriterion("ftoptions <=", value, "ftoptions");
            return (Criteria) this;
        }

        public Criteria andFtoptionsIn(List<Object> values) {
            addCriterion("ftoptions in", values, "ftoptions");
            return (Criteria) this;
        }

        public Criteria andFtoptionsNotIn(List<Object> values) {
            addCriterion("ftoptions not in", values, "ftoptions");
            return (Criteria) this;
        }

        public Criteria andFtoptionsBetween(Object value1, Object value2) {
            addCriterion("ftoptions between", value1, value2, "ftoptions");
            return (Criteria) this;
        }

        public Criteria andFtoptionsNotBetween(Object value1, Object value2) {
            addCriterion("ftoptions not between", value1, value2, "ftoptions");
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