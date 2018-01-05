package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgAggregateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgAggregateExample() {
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

        public Criteria andAggfnoidIsNull() {
            addCriterion("aggfnoid is null");
            return (Criteria) this;
        }

        public Criteria andAggfnoidIsNotNull() {
            addCriterion("aggfnoid is not null");
            return (Criteria) this;
        }

        public Criteria andAggfnoidEqualTo(Object value) {
            addCriterion("aggfnoid =", value, "aggfnoid");
            return (Criteria) this;
        }

        public Criteria andAggfnoidNotEqualTo(Object value) {
            addCriterion("aggfnoid <>", value, "aggfnoid");
            return (Criteria) this;
        }

        public Criteria andAggfnoidGreaterThan(Object value) {
            addCriterion("aggfnoid >", value, "aggfnoid");
            return (Criteria) this;
        }

        public Criteria andAggfnoidGreaterThanOrEqualTo(Object value) {
            addCriterion("aggfnoid >=", value, "aggfnoid");
            return (Criteria) this;
        }

        public Criteria andAggfnoidLessThan(Object value) {
            addCriterion("aggfnoid <", value, "aggfnoid");
            return (Criteria) this;
        }

        public Criteria andAggfnoidLessThanOrEqualTo(Object value) {
            addCriterion("aggfnoid <=", value, "aggfnoid");
            return (Criteria) this;
        }

        public Criteria andAggfnoidIn(List<Object> values) {
            addCriterion("aggfnoid in", values, "aggfnoid");
            return (Criteria) this;
        }

        public Criteria andAggfnoidNotIn(List<Object> values) {
            addCriterion("aggfnoid not in", values, "aggfnoid");
            return (Criteria) this;
        }

        public Criteria andAggfnoidBetween(Object value1, Object value2) {
            addCriterion("aggfnoid between", value1, value2, "aggfnoid");
            return (Criteria) this;
        }

        public Criteria andAggfnoidNotBetween(Object value1, Object value2) {
            addCriterion("aggfnoid not between", value1, value2, "aggfnoid");
            return (Criteria) this;
        }

        public Criteria andAggtransfnIsNull() {
            addCriterion("aggtransfn is null");
            return (Criteria) this;
        }

        public Criteria andAggtransfnIsNotNull() {
            addCriterion("aggtransfn is not null");
            return (Criteria) this;
        }

        public Criteria andAggtransfnEqualTo(Object value) {
            addCriterion("aggtransfn =", value, "aggtransfn");
            return (Criteria) this;
        }

        public Criteria andAggtransfnNotEqualTo(Object value) {
            addCriterion("aggtransfn <>", value, "aggtransfn");
            return (Criteria) this;
        }

        public Criteria andAggtransfnGreaterThan(Object value) {
            addCriterion("aggtransfn >", value, "aggtransfn");
            return (Criteria) this;
        }

        public Criteria andAggtransfnGreaterThanOrEqualTo(Object value) {
            addCriterion("aggtransfn >=", value, "aggtransfn");
            return (Criteria) this;
        }

        public Criteria andAggtransfnLessThan(Object value) {
            addCriterion("aggtransfn <", value, "aggtransfn");
            return (Criteria) this;
        }

        public Criteria andAggtransfnLessThanOrEqualTo(Object value) {
            addCriterion("aggtransfn <=", value, "aggtransfn");
            return (Criteria) this;
        }

        public Criteria andAggtransfnIn(List<Object> values) {
            addCriterion("aggtransfn in", values, "aggtransfn");
            return (Criteria) this;
        }

        public Criteria andAggtransfnNotIn(List<Object> values) {
            addCriterion("aggtransfn not in", values, "aggtransfn");
            return (Criteria) this;
        }

        public Criteria andAggtransfnBetween(Object value1, Object value2) {
            addCriterion("aggtransfn between", value1, value2, "aggtransfn");
            return (Criteria) this;
        }

        public Criteria andAggtransfnNotBetween(Object value1, Object value2) {
            addCriterion("aggtransfn not between", value1, value2, "aggtransfn");
            return (Criteria) this;
        }

        public Criteria andAggfinalfnIsNull() {
            addCriterion("aggfinalfn is null");
            return (Criteria) this;
        }

        public Criteria andAggfinalfnIsNotNull() {
            addCriterion("aggfinalfn is not null");
            return (Criteria) this;
        }

        public Criteria andAggfinalfnEqualTo(Object value) {
            addCriterion("aggfinalfn =", value, "aggfinalfn");
            return (Criteria) this;
        }

        public Criteria andAggfinalfnNotEqualTo(Object value) {
            addCriterion("aggfinalfn <>", value, "aggfinalfn");
            return (Criteria) this;
        }

        public Criteria andAggfinalfnGreaterThan(Object value) {
            addCriterion("aggfinalfn >", value, "aggfinalfn");
            return (Criteria) this;
        }

        public Criteria andAggfinalfnGreaterThanOrEqualTo(Object value) {
            addCriterion("aggfinalfn >=", value, "aggfinalfn");
            return (Criteria) this;
        }

        public Criteria andAggfinalfnLessThan(Object value) {
            addCriterion("aggfinalfn <", value, "aggfinalfn");
            return (Criteria) this;
        }

        public Criteria andAggfinalfnLessThanOrEqualTo(Object value) {
            addCriterion("aggfinalfn <=", value, "aggfinalfn");
            return (Criteria) this;
        }

        public Criteria andAggfinalfnIn(List<Object> values) {
            addCriterion("aggfinalfn in", values, "aggfinalfn");
            return (Criteria) this;
        }

        public Criteria andAggfinalfnNotIn(List<Object> values) {
            addCriterion("aggfinalfn not in", values, "aggfinalfn");
            return (Criteria) this;
        }

        public Criteria andAggfinalfnBetween(Object value1, Object value2) {
            addCriterion("aggfinalfn between", value1, value2, "aggfinalfn");
            return (Criteria) this;
        }

        public Criteria andAggfinalfnNotBetween(Object value1, Object value2) {
            addCriterion("aggfinalfn not between", value1, value2, "aggfinalfn");
            return (Criteria) this;
        }

        public Criteria andAggsortopIsNull() {
            addCriterion("aggsortop is null");
            return (Criteria) this;
        }

        public Criteria andAggsortopIsNotNull() {
            addCriterion("aggsortop is not null");
            return (Criteria) this;
        }

        public Criteria andAggsortopEqualTo(Long value) {
            addCriterion("aggsortop =", value, "aggsortop");
            return (Criteria) this;
        }

        public Criteria andAggsortopNotEqualTo(Long value) {
            addCriterion("aggsortop <>", value, "aggsortop");
            return (Criteria) this;
        }

        public Criteria andAggsortopGreaterThan(Long value) {
            addCriterion("aggsortop >", value, "aggsortop");
            return (Criteria) this;
        }

        public Criteria andAggsortopGreaterThanOrEqualTo(Long value) {
            addCriterion("aggsortop >=", value, "aggsortop");
            return (Criteria) this;
        }

        public Criteria andAggsortopLessThan(Long value) {
            addCriterion("aggsortop <", value, "aggsortop");
            return (Criteria) this;
        }

        public Criteria andAggsortopLessThanOrEqualTo(Long value) {
            addCriterion("aggsortop <=", value, "aggsortop");
            return (Criteria) this;
        }

        public Criteria andAggsortopIn(List<Long> values) {
            addCriterion("aggsortop in", values, "aggsortop");
            return (Criteria) this;
        }

        public Criteria andAggsortopNotIn(List<Long> values) {
            addCriterion("aggsortop not in", values, "aggsortop");
            return (Criteria) this;
        }

        public Criteria andAggsortopBetween(Long value1, Long value2) {
            addCriterion("aggsortop between", value1, value2, "aggsortop");
            return (Criteria) this;
        }

        public Criteria andAggsortopNotBetween(Long value1, Long value2) {
            addCriterion("aggsortop not between", value1, value2, "aggsortop");
            return (Criteria) this;
        }

        public Criteria andAggtranstypeIsNull() {
            addCriterion("aggtranstype is null");
            return (Criteria) this;
        }

        public Criteria andAggtranstypeIsNotNull() {
            addCriterion("aggtranstype is not null");
            return (Criteria) this;
        }

        public Criteria andAggtranstypeEqualTo(Long value) {
            addCriterion("aggtranstype =", value, "aggtranstype");
            return (Criteria) this;
        }

        public Criteria andAggtranstypeNotEqualTo(Long value) {
            addCriterion("aggtranstype <>", value, "aggtranstype");
            return (Criteria) this;
        }

        public Criteria andAggtranstypeGreaterThan(Long value) {
            addCriterion("aggtranstype >", value, "aggtranstype");
            return (Criteria) this;
        }

        public Criteria andAggtranstypeGreaterThanOrEqualTo(Long value) {
            addCriterion("aggtranstype >=", value, "aggtranstype");
            return (Criteria) this;
        }

        public Criteria andAggtranstypeLessThan(Long value) {
            addCriterion("aggtranstype <", value, "aggtranstype");
            return (Criteria) this;
        }

        public Criteria andAggtranstypeLessThanOrEqualTo(Long value) {
            addCriterion("aggtranstype <=", value, "aggtranstype");
            return (Criteria) this;
        }

        public Criteria andAggtranstypeIn(List<Long> values) {
            addCriterion("aggtranstype in", values, "aggtranstype");
            return (Criteria) this;
        }

        public Criteria andAggtranstypeNotIn(List<Long> values) {
            addCriterion("aggtranstype not in", values, "aggtranstype");
            return (Criteria) this;
        }

        public Criteria andAggtranstypeBetween(Long value1, Long value2) {
            addCriterion("aggtranstype between", value1, value2, "aggtranstype");
            return (Criteria) this;
        }

        public Criteria andAggtranstypeNotBetween(Long value1, Long value2) {
            addCriterion("aggtranstype not between", value1, value2, "aggtranstype");
            return (Criteria) this;
        }

        public Criteria andAgginitvalIsNull() {
            addCriterion("agginitval is null");
            return (Criteria) this;
        }

        public Criteria andAgginitvalIsNotNull() {
            addCriterion("agginitval is not null");
            return (Criteria) this;
        }

        public Criteria andAgginitvalEqualTo(String value) {
            addCriterion("agginitval =", value, "agginitval");
            return (Criteria) this;
        }

        public Criteria andAgginitvalNotEqualTo(String value) {
            addCriterion("agginitval <>", value, "agginitval");
            return (Criteria) this;
        }

        public Criteria andAgginitvalGreaterThan(String value) {
            addCriterion("agginitval >", value, "agginitval");
            return (Criteria) this;
        }

        public Criteria andAgginitvalGreaterThanOrEqualTo(String value) {
            addCriterion("agginitval >=", value, "agginitval");
            return (Criteria) this;
        }

        public Criteria andAgginitvalLessThan(String value) {
            addCriterion("agginitval <", value, "agginitval");
            return (Criteria) this;
        }

        public Criteria andAgginitvalLessThanOrEqualTo(String value) {
            addCriterion("agginitval <=", value, "agginitval");
            return (Criteria) this;
        }

        public Criteria andAgginitvalLike(String value) {
            addCriterion("agginitval like", value, "agginitval");
            return (Criteria) this;
        }

        public Criteria andAgginitvalNotLike(String value) {
            addCriterion("agginitval not like", value, "agginitval");
            return (Criteria) this;
        }

        public Criteria andAgginitvalIn(List<String> values) {
            addCriterion("agginitval in", values, "agginitval");
            return (Criteria) this;
        }

        public Criteria andAgginitvalNotIn(List<String> values) {
            addCriterion("agginitval not in", values, "agginitval");
            return (Criteria) this;
        }

        public Criteria andAgginitvalBetween(String value1, String value2) {
            addCriterion("agginitval between", value1, value2, "agginitval");
            return (Criteria) this;
        }

        public Criteria andAgginitvalNotBetween(String value1, String value2) {
            addCriterion("agginitval not between", value1, value2, "agginitval");
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