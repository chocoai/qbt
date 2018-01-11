package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PriceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PriceExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCity_fromIsNull() {
            addCriterion("city_from is null");
            return (Criteria) this;
        }

        public Criteria andCity_fromIsNotNull() {
            addCriterion("city_from is not null");
            return (Criteria) this;
        }

        public Criteria andCity_fromEqualTo(String value) {
            addCriterion("city_from =", value, "city_from");
            return (Criteria) this;
        }

        public Criteria andCity_fromNotEqualTo(String value) {
            addCriterion("city_from <>", value, "city_from");
            return (Criteria) this;
        }

        public Criteria andCity_fromGreaterThan(String value) {
            addCriterion("city_from >", value, "city_from");
            return (Criteria) this;
        }

        public Criteria andCity_fromGreaterThanOrEqualTo(String value) {
            addCriterion("city_from >=", value, "city_from");
            return (Criteria) this;
        }

        public Criteria andCity_fromLessThan(String value) {
            addCriterion("city_from <", value, "city_from");
            return (Criteria) this;
        }

        public Criteria andCity_fromLessThanOrEqualTo(String value) {
            addCriterion("city_from <=", value, "city_from");
            return (Criteria) this;
        }

        public Criteria andCity_fromLike(String value) {
            addCriterion("city_from like", value, "city_from");
            return (Criteria) this;
        }

        public Criteria andCity_fromNotLike(String value) {
            addCriterion("city_from not like", value, "city_from");
            return (Criteria) this;
        }

        public Criteria andCity_fromIn(List<String> values) {
            addCriterion("city_from in", values, "city_from");
            return (Criteria) this;
        }

        public Criteria andCity_fromNotIn(List<String> values) {
            addCriterion("city_from not in", values, "city_from");
            return (Criteria) this;
        }

        public Criteria andCity_fromBetween(String value1, String value2) {
            addCriterion("city_from between", value1, value2, "city_from");
            return (Criteria) this;
        }

        public Criteria andCity_fromNotBetween(String value1, String value2) {
            addCriterion("city_from not between", value1, value2, "city_from");
            return (Criteria) this;
        }

        public Criteria andCity_toIsNull() {
            addCriterion("city_to is null");
            return (Criteria) this;
        }

        public Criteria andCity_toIsNotNull() {
            addCriterion("city_to is not null");
            return (Criteria) this;
        }

        public Criteria andCity_toEqualTo(String value) {
            addCriterion("city_to =", value, "city_to");
            return (Criteria) this;
        }

        public Criteria andCity_toNotEqualTo(String value) {
            addCriterion("city_to <>", value, "city_to");
            return (Criteria) this;
        }

        public Criteria andCity_toGreaterThan(String value) {
            addCriterion("city_to >", value, "city_to");
            return (Criteria) this;
        }

        public Criteria andCity_toGreaterThanOrEqualTo(String value) {
            addCriterion("city_to >=", value, "city_to");
            return (Criteria) this;
        }

        public Criteria andCity_toLessThan(String value) {
            addCriterion("city_to <", value, "city_to");
            return (Criteria) this;
        }

        public Criteria andCity_toLessThanOrEqualTo(String value) {
            addCriterion("city_to <=", value, "city_to");
            return (Criteria) this;
        }

        public Criteria andCity_toLike(String value) {
            addCriterion("city_to like", value, "city_to");
            return (Criteria) this;
        }

        public Criteria andCity_toNotLike(String value) {
            addCriterion("city_to not like", value, "city_to");
            return (Criteria) this;
        }

        public Criteria andCity_toIn(List<String> values) {
            addCriterion("city_to in", values, "city_to");
            return (Criteria) this;
        }

        public Criteria andCity_toNotIn(List<String> values) {
            addCriterion("city_to not in", values, "city_to");
            return (Criteria) this;
        }

        public Criteria andCity_toBetween(String value1, String value2) {
            addCriterion("city_to between", value1, value2, "city_to");
            return (Criteria) this;
        }

        public Criteria andCity_toNotBetween(String value1, String value2) {
            addCriterion("city_to not between", value1, value2, "city_to");
            return (Criteria) this;
        }

        public Criteria andAmoutIsNull() {
            addCriterion("amout is null");
            return (Criteria) this;
        }

        public Criteria andAmoutIsNotNull() {
            addCriterion("amout is not null");
            return (Criteria) this;
        }

        public Criteria andAmoutEqualTo(String value) {
            addCriterion("amout =", value, "amout");
            return (Criteria) this;
        }

        public Criteria andAmoutNotEqualTo(String value) {
            addCriterion("amout <>", value, "amout");
            return (Criteria) this;
        }

        public Criteria andAmoutGreaterThan(String value) {
            addCriterion("amout >", value, "amout");
            return (Criteria) this;
        }

        public Criteria andAmoutGreaterThanOrEqualTo(String value) {
            addCriterion("amout >=", value, "amout");
            return (Criteria) this;
        }

        public Criteria andAmoutLessThan(String value) {
            addCriterion("amout <", value, "amout");
            return (Criteria) this;
        }

        public Criteria andAmoutLessThanOrEqualTo(String value) {
            addCriterion("amout <=", value, "amout");
            return (Criteria) this;
        }

        public Criteria andAmoutLike(String value) {
            addCriterion("amout like", value, "amout");
            return (Criteria) this;
        }

        public Criteria andAmoutNotLike(String value) {
            addCriterion("amout not like", value, "amout");
            return (Criteria) this;
        }

        public Criteria andAmoutIn(List<String> values) {
            addCriterion("amout in", values, "amout");
            return (Criteria) this;
        }

        public Criteria andAmoutNotIn(List<String> values) {
            addCriterion("amout not in", values, "amout");
            return (Criteria) this;
        }

        public Criteria andAmoutBetween(String value1, String value2) {
            addCriterion("amout between", value1, value2, "amout");
            return (Criteria) this;
        }

        public Criteria andAmoutNotBetween(String value1, String value2) {
            addCriterion("amout not between", value1, value2, "amout");
            return (Criteria) this;
        }

        public Criteria andCreated_atIsNull() {
            addCriterion("created_at is null");
            return (Criteria) this;
        }

        public Criteria andCreated_atIsNotNull() {
            addCriterion("created_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreated_atEqualTo(Date value) {
            addCriterion("created_at =", value, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atNotEqualTo(Date value) {
            addCriterion("created_at <>", value, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atGreaterThan(Date value) {
            addCriterion("created_at >", value, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atGreaterThanOrEqualTo(Date value) {
            addCriterion("created_at >=", value, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atLessThan(Date value) {
            addCriterion("created_at <", value, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atLessThanOrEqualTo(Date value) {
            addCriterion("created_at <=", value, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atIn(List<Date> values) {
            addCriterion("created_at in", values, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atNotIn(List<Date> values) {
            addCriterion("created_at not in", values, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atBetween(Date value1, Date value2) {
            addCriterion("created_at between", value1, value2, "created_at");
            return (Criteria) this;
        }

        public Criteria andCreated_atNotBetween(Date value1, Date value2) {
            addCriterion("created_at not between", value1, value2, "created_at");
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