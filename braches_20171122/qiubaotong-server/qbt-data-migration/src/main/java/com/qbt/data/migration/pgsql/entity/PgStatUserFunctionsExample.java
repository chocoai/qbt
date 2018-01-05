package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgStatUserFunctionsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgStatUserFunctionsExample() {
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

        public Criteria andFuncidIsNull() {
            addCriterion("funcid is null");
            return (Criteria) this;
        }

        public Criteria andFuncidIsNotNull() {
            addCriterion("funcid is not null");
            return (Criteria) this;
        }

        public Criteria andFuncidEqualTo(Long value) {
            addCriterion("funcid =", value, "funcid");
            return (Criteria) this;
        }

        public Criteria andFuncidNotEqualTo(Long value) {
            addCriterion("funcid <>", value, "funcid");
            return (Criteria) this;
        }

        public Criteria andFuncidGreaterThan(Long value) {
            addCriterion("funcid >", value, "funcid");
            return (Criteria) this;
        }

        public Criteria andFuncidGreaterThanOrEqualTo(Long value) {
            addCriterion("funcid >=", value, "funcid");
            return (Criteria) this;
        }

        public Criteria andFuncidLessThan(Long value) {
            addCriterion("funcid <", value, "funcid");
            return (Criteria) this;
        }

        public Criteria andFuncidLessThanOrEqualTo(Long value) {
            addCriterion("funcid <=", value, "funcid");
            return (Criteria) this;
        }

        public Criteria andFuncidIn(List<Long> values) {
            addCriterion("funcid in", values, "funcid");
            return (Criteria) this;
        }

        public Criteria andFuncidNotIn(List<Long> values) {
            addCriterion("funcid not in", values, "funcid");
            return (Criteria) this;
        }

        public Criteria andFuncidBetween(Long value1, Long value2) {
            addCriterion("funcid between", value1, value2, "funcid");
            return (Criteria) this;
        }

        public Criteria andFuncidNotBetween(Long value1, Long value2) {
            addCriterion("funcid not between", value1, value2, "funcid");
            return (Criteria) this;
        }

        public Criteria andSchemanameIsNull() {
            addCriterion("schemaname is null");
            return (Criteria) this;
        }

        public Criteria andSchemanameIsNotNull() {
            addCriterion("schemaname is not null");
            return (Criteria) this;
        }

        public Criteria andSchemanameEqualTo(String value) {
            addCriterion("schemaname =", value, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameNotEqualTo(String value) {
            addCriterion("schemaname <>", value, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameGreaterThan(String value) {
            addCriterion("schemaname >", value, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameGreaterThanOrEqualTo(String value) {
            addCriterion("schemaname >=", value, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameLessThan(String value) {
            addCriterion("schemaname <", value, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameLessThanOrEqualTo(String value) {
            addCriterion("schemaname <=", value, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameLike(String value) {
            addCriterion("schemaname like", value, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameNotLike(String value) {
            addCriterion("schemaname not like", value, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameIn(List<String> values) {
            addCriterion("schemaname in", values, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameNotIn(List<String> values) {
            addCriterion("schemaname not in", values, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameBetween(String value1, String value2) {
            addCriterion("schemaname between", value1, value2, "schemaname");
            return (Criteria) this;
        }

        public Criteria andSchemanameNotBetween(String value1, String value2) {
            addCriterion("schemaname not between", value1, value2, "schemaname");
            return (Criteria) this;
        }

        public Criteria andFuncnameIsNull() {
            addCriterion("funcname is null");
            return (Criteria) this;
        }

        public Criteria andFuncnameIsNotNull() {
            addCriterion("funcname is not null");
            return (Criteria) this;
        }

        public Criteria andFuncnameEqualTo(String value) {
            addCriterion("funcname =", value, "funcname");
            return (Criteria) this;
        }

        public Criteria andFuncnameNotEqualTo(String value) {
            addCriterion("funcname <>", value, "funcname");
            return (Criteria) this;
        }

        public Criteria andFuncnameGreaterThan(String value) {
            addCriterion("funcname >", value, "funcname");
            return (Criteria) this;
        }

        public Criteria andFuncnameGreaterThanOrEqualTo(String value) {
            addCriterion("funcname >=", value, "funcname");
            return (Criteria) this;
        }

        public Criteria andFuncnameLessThan(String value) {
            addCriterion("funcname <", value, "funcname");
            return (Criteria) this;
        }

        public Criteria andFuncnameLessThanOrEqualTo(String value) {
            addCriterion("funcname <=", value, "funcname");
            return (Criteria) this;
        }

        public Criteria andFuncnameLike(String value) {
            addCriterion("funcname like", value, "funcname");
            return (Criteria) this;
        }

        public Criteria andFuncnameNotLike(String value) {
            addCriterion("funcname not like", value, "funcname");
            return (Criteria) this;
        }

        public Criteria andFuncnameIn(List<String> values) {
            addCriterion("funcname in", values, "funcname");
            return (Criteria) this;
        }

        public Criteria andFuncnameNotIn(List<String> values) {
            addCriterion("funcname not in", values, "funcname");
            return (Criteria) this;
        }

        public Criteria andFuncnameBetween(String value1, String value2) {
            addCriterion("funcname between", value1, value2, "funcname");
            return (Criteria) this;
        }

        public Criteria andFuncnameNotBetween(String value1, String value2) {
            addCriterion("funcname not between", value1, value2, "funcname");
            return (Criteria) this;
        }

        public Criteria andCallsIsNull() {
            addCriterion("calls is null");
            return (Criteria) this;
        }

        public Criteria andCallsIsNotNull() {
            addCriterion("calls is not null");
            return (Criteria) this;
        }

        public Criteria andCallsEqualTo(Long value) {
            addCriterion("calls =", value, "calls");
            return (Criteria) this;
        }

        public Criteria andCallsNotEqualTo(Long value) {
            addCriterion("calls <>", value, "calls");
            return (Criteria) this;
        }

        public Criteria andCallsGreaterThan(Long value) {
            addCriterion("calls >", value, "calls");
            return (Criteria) this;
        }

        public Criteria andCallsGreaterThanOrEqualTo(Long value) {
            addCriterion("calls >=", value, "calls");
            return (Criteria) this;
        }

        public Criteria andCallsLessThan(Long value) {
            addCriterion("calls <", value, "calls");
            return (Criteria) this;
        }

        public Criteria andCallsLessThanOrEqualTo(Long value) {
            addCriterion("calls <=", value, "calls");
            return (Criteria) this;
        }

        public Criteria andCallsIn(List<Long> values) {
            addCriterion("calls in", values, "calls");
            return (Criteria) this;
        }

        public Criteria andCallsNotIn(List<Long> values) {
            addCriterion("calls not in", values, "calls");
            return (Criteria) this;
        }

        public Criteria andCallsBetween(Long value1, Long value2) {
            addCriterion("calls between", value1, value2, "calls");
            return (Criteria) this;
        }

        public Criteria andCallsNotBetween(Long value1, Long value2) {
            addCriterion("calls not between", value1, value2, "calls");
            return (Criteria) this;
        }

        public Criteria andTotal_timeIsNull() {
            addCriterion("total_time is null");
            return (Criteria) this;
        }

        public Criteria andTotal_timeIsNotNull() {
            addCriterion("total_time is not null");
            return (Criteria) this;
        }

        public Criteria andTotal_timeEqualTo(Double value) {
            addCriterion("total_time =", value, "total_time");
            return (Criteria) this;
        }

        public Criteria andTotal_timeNotEqualTo(Double value) {
            addCriterion("total_time <>", value, "total_time");
            return (Criteria) this;
        }

        public Criteria andTotal_timeGreaterThan(Double value) {
            addCriterion("total_time >", value, "total_time");
            return (Criteria) this;
        }

        public Criteria andTotal_timeGreaterThanOrEqualTo(Double value) {
            addCriterion("total_time >=", value, "total_time");
            return (Criteria) this;
        }

        public Criteria andTotal_timeLessThan(Double value) {
            addCriterion("total_time <", value, "total_time");
            return (Criteria) this;
        }

        public Criteria andTotal_timeLessThanOrEqualTo(Double value) {
            addCriterion("total_time <=", value, "total_time");
            return (Criteria) this;
        }

        public Criteria andTotal_timeIn(List<Double> values) {
            addCriterion("total_time in", values, "total_time");
            return (Criteria) this;
        }

        public Criteria andTotal_timeNotIn(List<Double> values) {
            addCriterion("total_time not in", values, "total_time");
            return (Criteria) this;
        }

        public Criteria andTotal_timeBetween(Double value1, Double value2) {
            addCriterion("total_time between", value1, value2, "total_time");
            return (Criteria) this;
        }

        public Criteria andTotal_timeNotBetween(Double value1, Double value2) {
            addCriterion("total_time not between", value1, value2, "total_time");
            return (Criteria) this;
        }

        public Criteria andSelf_timeIsNull() {
            addCriterion("self_time is null");
            return (Criteria) this;
        }

        public Criteria andSelf_timeIsNotNull() {
            addCriterion("self_time is not null");
            return (Criteria) this;
        }

        public Criteria andSelf_timeEqualTo(Double value) {
            addCriterion("self_time =", value, "self_time");
            return (Criteria) this;
        }

        public Criteria andSelf_timeNotEqualTo(Double value) {
            addCriterion("self_time <>", value, "self_time");
            return (Criteria) this;
        }

        public Criteria andSelf_timeGreaterThan(Double value) {
            addCriterion("self_time >", value, "self_time");
            return (Criteria) this;
        }

        public Criteria andSelf_timeGreaterThanOrEqualTo(Double value) {
            addCriterion("self_time >=", value, "self_time");
            return (Criteria) this;
        }

        public Criteria andSelf_timeLessThan(Double value) {
            addCriterion("self_time <", value, "self_time");
            return (Criteria) this;
        }

        public Criteria andSelf_timeLessThanOrEqualTo(Double value) {
            addCriterion("self_time <=", value, "self_time");
            return (Criteria) this;
        }

        public Criteria andSelf_timeIn(List<Double> values) {
            addCriterion("self_time in", values, "self_time");
            return (Criteria) this;
        }

        public Criteria andSelf_timeNotIn(List<Double> values) {
            addCriterion("self_time not in", values, "self_time");
            return (Criteria) this;
        }

        public Criteria andSelf_timeBetween(Double value1, Double value2) {
            addCriterion("self_time between", value1, value2, "self_time");
            return (Criteria) this;
        }

        public Criteria andSelf_timeNotBetween(Double value1, Double value2) {
            addCriterion("self_time not between", value1, value2, "self_time");
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