package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class ForeignDataWrapperOptionsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ForeignDataWrapperOptionsExample() {
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

        public Criteria andForeign_data_wrapper_catalogIsNull() {
            addCriterion("foreign_data_wrapper_catalog is null");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_catalogIsNotNull() {
            addCriterion("foreign_data_wrapper_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_catalogEqualTo(Object value) {
            addCriterion("foreign_data_wrapper_catalog =", value, "foreign_data_wrapper_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_catalogNotEqualTo(Object value) {
            addCriterion("foreign_data_wrapper_catalog <>", value, "foreign_data_wrapper_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_catalogGreaterThan(Object value) {
            addCriterion("foreign_data_wrapper_catalog >", value, "foreign_data_wrapper_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("foreign_data_wrapper_catalog >=", value, "foreign_data_wrapper_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_catalogLessThan(Object value) {
            addCriterion("foreign_data_wrapper_catalog <", value, "foreign_data_wrapper_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_catalogLessThanOrEqualTo(Object value) {
            addCriterion("foreign_data_wrapper_catalog <=", value, "foreign_data_wrapper_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_catalogIn(List<Object> values) {
            addCriterion("foreign_data_wrapper_catalog in", values, "foreign_data_wrapper_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_catalogNotIn(List<Object> values) {
            addCriterion("foreign_data_wrapper_catalog not in", values, "foreign_data_wrapper_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_catalogBetween(Object value1, Object value2) {
            addCriterion("foreign_data_wrapper_catalog between", value1, value2, "foreign_data_wrapper_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_catalogNotBetween(Object value1, Object value2) {
            addCriterion("foreign_data_wrapper_catalog not between", value1, value2, "foreign_data_wrapper_catalog");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_nameIsNull() {
            addCriterion("foreign_data_wrapper_name is null");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_nameIsNotNull() {
            addCriterion("foreign_data_wrapper_name is not null");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_nameEqualTo(Object value) {
            addCriterion("foreign_data_wrapper_name =", value, "foreign_data_wrapper_name");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_nameNotEqualTo(Object value) {
            addCriterion("foreign_data_wrapper_name <>", value, "foreign_data_wrapper_name");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_nameGreaterThan(Object value) {
            addCriterion("foreign_data_wrapper_name >", value, "foreign_data_wrapper_name");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("foreign_data_wrapper_name >=", value, "foreign_data_wrapper_name");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_nameLessThan(Object value) {
            addCriterion("foreign_data_wrapper_name <", value, "foreign_data_wrapper_name");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_nameLessThanOrEqualTo(Object value) {
            addCriterion("foreign_data_wrapper_name <=", value, "foreign_data_wrapper_name");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_nameIn(List<Object> values) {
            addCriterion("foreign_data_wrapper_name in", values, "foreign_data_wrapper_name");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_nameNotIn(List<Object> values) {
            addCriterion("foreign_data_wrapper_name not in", values, "foreign_data_wrapper_name");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_nameBetween(Object value1, Object value2) {
            addCriterion("foreign_data_wrapper_name between", value1, value2, "foreign_data_wrapper_name");
            return (Criteria) this;
        }

        public Criteria andForeign_data_wrapper_nameNotBetween(Object value1, Object value2) {
            addCriterion("foreign_data_wrapper_name not between", value1, value2, "foreign_data_wrapper_name");
            return (Criteria) this;
        }

        public Criteria andOption_nameIsNull() {
            addCriterion("option_name is null");
            return (Criteria) this;
        }

        public Criteria andOption_nameIsNotNull() {
            addCriterion("option_name is not null");
            return (Criteria) this;
        }

        public Criteria andOption_nameEqualTo(Object value) {
            addCriterion("option_name =", value, "option_name");
            return (Criteria) this;
        }

        public Criteria andOption_nameNotEqualTo(Object value) {
            addCriterion("option_name <>", value, "option_name");
            return (Criteria) this;
        }

        public Criteria andOption_nameGreaterThan(Object value) {
            addCriterion("option_name >", value, "option_name");
            return (Criteria) this;
        }

        public Criteria andOption_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("option_name >=", value, "option_name");
            return (Criteria) this;
        }

        public Criteria andOption_nameLessThan(Object value) {
            addCriterion("option_name <", value, "option_name");
            return (Criteria) this;
        }

        public Criteria andOption_nameLessThanOrEqualTo(Object value) {
            addCriterion("option_name <=", value, "option_name");
            return (Criteria) this;
        }

        public Criteria andOption_nameIn(List<Object> values) {
            addCriterion("option_name in", values, "option_name");
            return (Criteria) this;
        }

        public Criteria andOption_nameNotIn(List<Object> values) {
            addCriterion("option_name not in", values, "option_name");
            return (Criteria) this;
        }

        public Criteria andOption_nameBetween(Object value1, Object value2) {
            addCriterion("option_name between", value1, value2, "option_name");
            return (Criteria) this;
        }

        public Criteria andOption_nameNotBetween(Object value1, Object value2) {
            addCriterion("option_name not between", value1, value2, "option_name");
            return (Criteria) this;
        }

        public Criteria andOption_valueIsNull() {
            addCriterion("option_value is null");
            return (Criteria) this;
        }

        public Criteria andOption_valueIsNotNull() {
            addCriterion("option_value is not null");
            return (Criteria) this;
        }

        public Criteria andOption_valueEqualTo(Object value) {
            addCriterion("option_value =", value, "option_value");
            return (Criteria) this;
        }

        public Criteria andOption_valueNotEqualTo(Object value) {
            addCriterion("option_value <>", value, "option_value");
            return (Criteria) this;
        }

        public Criteria andOption_valueGreaterThan(Object value) {
            addCriterion("option_value >", value, "option_value");
            return (Criteria) this;
        }

        public Criteria andOption_valueGreaterThanOrEqualTo(Object value) {
            addCriterion("option_value >=", value, "option_value");
            return (Criteria) this;
        }

        public Criteria andOption_valueLessThan(Object value) {
            addCriterion("option_value <", value, "option_value");
            return (Criteria) this;
        }

        public Criteria andOption_valueLessThanOrEqualTo(Object value) {
            addCriterion("option_value <=", value, "option_value");
            return (Criteria) this;
        }

        public Criteria andOption_valueIn(List<Object> values) {
            addCriterion("option_value in", values, "option_value");
            return (Criteria) this;
        }

        public Criteria andOption_valueNotIn(List<Object> values) {
            addCriterion("option_value not in", values, "option_value");
            return (Criteria) this;
        }

        public Criteria andOption_valueBetween(Object value1, Object value2) {
            addCriterion("option_value between", value1, value2, "option_value");
            return (Criteria) this;
        }

        public Criteria andOption_valueNotBetween(Object value1, Object value2) {
            addCriterion("option_value not between", value1, value2, "option_value");
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