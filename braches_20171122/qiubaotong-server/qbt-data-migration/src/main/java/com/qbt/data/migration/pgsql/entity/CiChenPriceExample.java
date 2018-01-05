package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class CiChenPriceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CiChenPriceExample() {
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

        public Criteria andStart_provinceIsNull() {
            addCriterion("start_province is null");
            return (Criteria) this;
        }

        public Criteria andStart_provinceIsNotNull() {
            addCriterion("start_province is not null");
            return (Criteria) this;
        }

        public Criteria andStart_provinceEqualTo(String value) {
            addCriterion("start_province =", value, "start_province");
            return (Criteria) this;
        }

        public Criteria andStart_provinceNotEqualTo(String value) {
            addCriterion("start_province <>", value, "start_province");
            return (Criteria) this;
        }

        public Criteria andStart_provinceGreaterThan(String value) {
            addCriterion("start_province >", value, "start_province");
            return (Criteria) this;
        }

        public Criteria andStart_provinceGreaterThanOrEqualTo(String value) {
            addCriterion("start_province >=", value, "start_province");
            return (Criteria) this;
        }

        public Criteria andStart_provinceLessThan(String value) {
            addCriterion("start_province <", value, "start_province");
            return (Criteria) this;
        }

        public Criteria andStart_provinceLessThanOrEqualTo(String value) {
            addCriterion("start_province <=", value, "start_province");
            return (Criteria) this;
        }

        public Criteria andStart_provinceLike(String value) {
            addCriterion("start_province like", value, "start_province");
            return (Criteria) this;
        }

        public Criteria andStart_provinceNotLike(String value) {
            addCriterion("start_province not like", value, "start_province");
            return (Criteria) this;
        }

        public Criteria andStart_provinceIn(List<String> values) {
            addCriterion("start_province in", values, "start_province");
            return (Criteria) this;
        }

        public Criteria andStart_provinceNotIn(List<String> values) {
            addCriterion("start_province not in", values, "start_province");
            return (Criteria) this;
        }

        public Criteria andStart_provinceBetween(String value1, String value2) {
            addCriterion("start_province between", value1, value2, "start_province");
            return (Criteria) this;
        }

        public Criteria andStart_provinceNotBetween(String value1, String value2) {
            addCriterion("start_province not between", value1, value2, "start_province");
            return (Criteria) this;
        }

        public Criteria andStart_cityIsNull() {
            addCriterion("start_city is null");
            return (Criteria) this;
        }

        public Criteria andStart_cityIsNotNull() {
            addCriterion("start_city is not null");
            return (Criteria) this;
        }

        public Criteria andStart_cityEqualTo(String value) {
            addCriterion("start_city =", value, "start_city");
            return (Criteria) this;
        }

        public Criteria andStart_cityNotEqualTo(String value) {
            addCriterion("start_city <>", value, "start_city");
            return (Criteria) this;
        }

        public Criteria andStart_cityGreaterThan(String value) {
            addCriterion("start_city >", value, "start_city");
            return (Criteria) this;
        }

        public Criteria andStart_cityGreaterThanOrEqualTo(String value) {
            addCriterion("start_city >=", value, "start_city");
            return (Criteria) this;
        }

        public Criteria andStart_cityLessThan(String value) {
            addCriterion("start_city <", value, "start_city");
            return (Criteria) this;
        }

        public Criteria andStart_cityLessThanOrEqualTo(String value) {
            addCriterion("start_city <=", value, "start_city");
            return (Criteria) this;
        }

        public Criteria andStart_cityLike(String value) {
            addCriterion("start_city like", value, "start_city");
            return (Criteria) this;
        }

        public Criteria andStart_cityNotLike(String value) {
            addCriterion("start_city not like", value, "start_city");
            return (Criteria) this;
        }

        public Criteria andStart_cityIn(List<String> values) {
            addCriterion("start_city in", values, "start_city");
            return (Criteria) this;
        }

        public Criteria andStart_cityNotIn(List<String> values) {
            addCriterion("start_city not in", values, "start_city");
            return (Criteria) this;
        }

        public Criteria andStart_cityBetween(String value1, String value2) {
            addCriterion("start_city between", value1, value2, "start_city");
            return (Criteria) this;
        }

        public Criteria andStart_cityNotBetween(String value1, String value2) {
            addCriterion("start_city not between", value1, value2, "start_city");
            return (Criteria) this;
        }

        public Criteria andStart_districtIsNull() {
            addCriterion("start_district is null");
            return (Criteria) this;
        }

        public Criteria andStart_districtIsNotNull() {
            addCriterion("start_district is not null");
            return (Criteria) this;
        }

        public Criteria andStart_districtEqualTo(String value) {
            addCriterion("start_district =", value, "start_district");
            return (Criteria) this;
        }

        public Criteria andStart_districtNotEqualTo(String value) {
            addCriterion("start_district <>", value, "start_district");
            return (Criteria) this;
        }

        public Criteria andStart_districtGreaterThan(String value) {
            addCriterion("start_district >", value, "start_district");
            return (Criteria) this;
        }

        public Criteria andStart_districtGreaterThanOrEqualTo(String value) {
            addCriterion("start_district >=", value, "start_district");
            return (Criteria) this;
        }

        public Criteria andStart_districtLessThan(String value) {
            addCriterion("start_district <", value, "start_district");
            return (Criteria) this;
        }

        public Criteria andStart_districtLessThanOrEqualTo(String value) {
            addCriterion("start_district <=", value, "start_district");
            return (Criteria) this;
        }

        public Criteria andStart_districtLike(String value) {
            addCriterion("start_district like", value, "start_district");
            return (Criteria) this;
        }

        public Criteria andStart_districtNotLike(String value) {
            addCriterion("start_district not like", value, "start_district");
            return (Criteria) this;
        }

        public Criteria andStart_districtIn(List<String> values) {
            addCriterion("start_district in", values, "start_district");
            return (Criteria) this;
        }

        public Criteria andStart_districtNotIn(List<String> values) {
            addCriterion("start_district not in", values, "start_district");
            return (Criteria) this;
        }

        public Criteria andStart_districtBetween(String value1, String value2) {
            addCriterion("start_district between", value1, value2, "start_district");
            return (Criteria) this;
        }

        public Criteria andStart_districtNotBetween(String value1, String value2) {
            addCriterion("start_district not between", value1, value2, "start_district");
            return (Criteria) this;
        }

        public Criteria andEnd_provinceIsNull() {
            addCriterion("end_province is null");
            return (Criteria) this;
        }

        public Criteria andEnd_provinceIsNotNull() {
            addCriterion("end_province is not null");
            return (Criteria) this;
        }

        public Criteria andEnd_provinceEqualTo(String value) {
            addCriterion("end_province =", value, "end_province");
            return (Criteria) this;
        }

        public Criteria andEnd_provinceNotEqualTo(String value) {
            addCriterion("end_province <>", value, "end_province");
            return (Criteria) this;
        }

        public Criteria andEnd_provinceGreaterThan(String value) {
            addCriterion("end_province >", value, "end_province");
            return (Criteria) this;
        }

        public Criteria andEnd_provinceGreaterThanOrEqualTo(String value) {
            addCriterion("end_province >=", value, "end_province");
            return (Criteria) this;
        }

        public Criteria andEnd_provinceLessThan(String value) {
            addCriterion("end_province <", value, "end_province");
            return (Criteria) this;
        }

        public Criteria andEnd_provinceLessThanOrEqualTo(String value) {
            addCriterion("end_province <=", value, "end_province");
            return (Criteria) this;
        }

        public Criteria andEnd_provinceLike(String value) {
            addCriterion("end_province like", value, "end_province");
            return (Criteria) this;
        }

        public Criteria andEnd_provinceNotLike(String value) {
            addCriterion("end_province not like", value, "end_province");
            return (Criteria) this;
        }

        public Criteria andEnd_provinceIn(List<String> values) {
            addCriterion("end_province in", values, "end_province");
            return (Criteria) this;
        }

        public Criteria andEnd_provinceNotIn(List<String> values) {
            addCriterion("end_province not in", values, "end_province");
            return (Criteria) this;
        }

        public Criteria andEnd_provinceBetween(String value1, String value2) {
            addCriterion("end_province between", value1, value2, "end_province");
            return (Criteria) this;
        }

        public Criteria andEnd_provinceNotBetween(String value1, String value2) {
            addCriterion("end_province not between", value1, value2, "end_province");
            return (Criteria) this;
        }

        public Criteria andEnd_cityIsNull() {
            addCriterion("end_city is null");
            return (Criteria) this;
        }

        public Criteria andEnd_cityIsNotNull() {
            addCriterion("end_city is not null");
            return (Criteria) this;
        }

        public Criteria andEnd_cityEqualTo(String value) {
            addCriterion("end_city =", value, "end_city");
            return (Criteria) this;
        }

        public Criteria andEnd_cityNotEqualTo(String value) {
            addCriterion("end_city <>", value, "end_city");
            return (Criteria) this;
        }

        public Criteria andEnd_cityGreaterThan(String value) {
            addCriterion("end_city >", value, "end_city");
            return (Criteria) this;
        }

        public Criteria andEnd_cityGreaterThanOrEqualTo(String value) {
            addCriterion("end_city >=", value, "end_city");
            return (Criteria) this;
        }

        public Criteria andEnd_cityLessThan(String value) {
            addCriterion("end_city <", value, "end_city");
            return (Criteria) this;
        }

        public Criteria andEnd_cityLessThanOrEqualTo(String value) {
            addCriterion("end_city <=", value, "end_city");
            return (Criteria) this;
        }

        public Criteria andEnd_cityLike(String value) {
            addCriterion("end_city like", value, "end_city");
            return (Criteria) this;
        }

        public Criteria andEnd_cityNotLike(String value) {
            addCriterion("end_city not like", value, "end_city");
            return (Criteria) this;
        }

        public Criteria andEnd_cityIn(List<String> values) {
            addCriterion("end_city in", values, "end_city");
            return (Criteria) this;
        }

        public Criteria andEnd_cityNotIn(List<String> values) {
            addCriterion("end_city not in", values, "end_city");
            return (Criteria) this;
        }

        public Criteria andEnd_cityBetween(String value1, String value2) {
            addCriterion("end_city between", value1, value2, "end_city");
            return (Criteria) this;
        }

        public Criteria andEnd_cityNotBetween(String value1, String value2) {
            addCriterion("end_city not between", value1, value2, "end_city");
            return (Criteria) this;
        }

        public Criteria andEnd_districtIsNull() {
            addCriterion("end_district is null");
            return (Criteria) this;
        }

        public Criteria andEnd_districtIsNotNull() {
            addCriterion("end_district is not null");
            return (Criteria) this;
        }

        public Criteria andEnd_districtEqualTo(String value) {
            addCriterion("end_district =", value, "end_district");
            return (Criteria) this;
        }

        public Criteria andEnd_districtNotEqualTo(String value) {
            addCriterion("end_district <>", value, "end_district");
            return (Criteria) this;
        }

        public Criteria andEnd_districtGreaterThan(String value) {
            addCriterion("end_district >", value, "end_district");
            return (Criteria) this;
        }

        public Criteria andEnd_districtGreaterThanOrEqualTo(String value) {
            addCriterion("end_district >=", value, "end_district");
            return (Criteria) this;
        }

        public Criteria andEnd_districtLessThan(String value) {
            addCriterion("end_district <", value, "end_district");
            return (Criteria) this;
        }

        public Criteria andEnd_districtLessThanOrEqualTo(String value) {
            addCriterion("end_district <=", value, "end_district");
            return (Criteria) this;
        }

        public Criteria andEnd_districtLike(String value) {
            addCriterion("end_district like", value, "end_district");
            return (Criteria) this;
        }

        public Criteria andEnd_districtNotLike(String value) {
            addCriterion("end_district not like", value, "end_district");
            return (Criteria) this;
        }

        public Criteria andEnd_districtIn(List<String> values) {
            addCriterion("end_district in", values, "end_district");
            return (Criteria) this;
        }

        public Criteria andEnd_districtNotIn(List<String> values) {
            addCriterion("end_district not in", values, "end_district");
            return (Criteria) this;
        }

        public Criteria andEnd_districtBetween(String value1, String value2) {
            addCriterion("end_district between", value1, value2, "end_district");
            return (Criteria) this;
        }

        public Criteria andEnd_districtNotBetween(String value1, String value2) {
            addCriterion("end_district not between", value1, value2, "end_district");
            return (Criteria) this;
        }

        public Criteria andFirst_priceIsNull() {
            addCriterion("first_price is null");
            return (Criteria) this;
        }

        public Criteria andFirst_priceIsNotNull() {
            addCriterion("first_price is not null");
            return (Criteria) this;
        }

        public Criteria andFirst_priceEqualTo(Double value) {
            addCriterion("first_price =", value, "first_price");
            return (Criteria) this;
        }

        public Criteria andFirst_priceNotEqualTo(Double value) {
            addCriterion("first_price <>", value, "first_price");
            return (Criteria) this;
        }

        public Criteria andFirst_priceGreaterThan(Double value) {
            addCriterion("first_price >", value, "first_price");
            return (Criteria) this;
        }

        public Criteria andFirst_priceGreaterThanOrEqualTo(Double value) {
            addCriterion("first_price >=", value, "first_price");
            return (Criteria) this;
        }

        public Criteria andFirst_priceLessThan(Double value) {
            addCriterion("first_price <", value, "first_price");
            return (Criteria) this;
        }

        public Criteria andFirst_priceLessThanOrEqualTo(Double value) {
            addCriterion("first_price <=", value, "first_price");
            return (Criteria) this;
        }

        public Criteria andFirst_priceIn(List<Double> values) {
            addCriterion("first_price in", values, "first_price");
            return (Criteria) this;
        }

        public Criteria andFirst_priceNotIn(List<Double> values) {
            addCriterion("first_price not in", values, "first_price");
            return (Criteria) this;
        }

        public Criteria andFirst_priceBetween(Double value1, Double value2) {
            addCriterion("first_price between", value1, value2, "first_price");
            return (Criteria) this;
        }

        public Criteria andFirst_priceNotBetween(Double value1, Double value2) {
            addCriterion("first_price not between", value1, value2, "first_price");
            return (Criteria) this;
        }

        public Criteria andSecond_priceIsNull() {
            addCriterion("second_price is null");
            return (Criteria) this;
        }

        public Criteria andSecond_priceIsNotNull() {
            addCriterion("second_price is not null");
            return (Criteria) this;
        }

        public Criteria andSecond_priceEqualTo(Double value) {
            addCriterion("second_price =", value, "second_price");
            return (Criteria) this;
        }

        public Criteria andSecond_priceNotEqualTo(Double value) {
            addCriterion("second_price <>", value, "second_price");
            return (Criteria) this;
        }

        public Criteria andSecond_priceGreaterThan(Double value) {
            addCriterion("second_price >", value, "second_price");
            return (Criteria) this;
        }

        public Criteria andSecond_priceGreaterThanOrEqualTo(Double value) {
            addCriterion("second_price >=", value, "second_price");
            return (Criteria) this;
        }

        public Criteria andSecond_priceLessThan(Double value) {
            addCriterion("second_price <", value, "second_price");
            return (Criteria) this;
        }

        public Criteria andSecond_priceLessThanOrEqualTo(Double value) {
            addCriterion("second_price <=", value, "second_price");
            return (Criteria) this;
        }

        public Criteria andSecond_priceIn(List<Double> values) {
            addCriterion("second_price in", values, "second_price");
            return (Criteria) this;
        }

        public Criteria andSecond_priceNotIn(List<Double> values) {
            addCriterion("second_price not in", values, "second_price");
            return (Criteria) this;
        }

        public Criteria andSecond_priceBetween(Double value1, Double value2) {
            addCriterion("second_price between", value1, value2, "second_price");
            return (Criteria) this;
        }

        public Criteria andSecond_priceNotBetween(Double value1, Double value2) {
            addCriterion("second_price not between", value1, value2, "second_price");
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