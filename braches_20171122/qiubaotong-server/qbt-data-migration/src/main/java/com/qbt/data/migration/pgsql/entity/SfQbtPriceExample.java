package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SfQbtPriceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SfQbtPriceExample() {
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

        public Criteria andCichen_sf_priceIsNull() {
            addCriterion("cichen_sf_price is null");
            return (Criteria) this;
        }

        public Criteria andCichen_sf_priceIsNotNull() {
            addCriterion("cichen_sf_price is not null");
            return (Criteria) this;
        }

        public Criteria andCichen_sf_priceEqualTo(Double value) {
            addCriterion("cichen_sf_price =", value, "cichen_sf_price");
            return (Criteria) this;
        }

        public Criteria andCichen_sf_priceNotEqualTo(Double value) {
            addCriterion("cichen_sf_price <>", value, "cichen_sf_price");
            return (Criteria) this;
        }

        public Criteria andCichen_sf_priceGreaterThan(Double value) {
            addCriterion("cichen_sf_price >", value, "cichen_sf_price");
            return (Criteria) this;
        }

        public Criteria andCichen_sf_priceGreaterThanOrEqualTo(Double value) {
            addCriterion("cichen_sf_price >=", value, "cichen_sf_price");
            return (Criteria) this;
        }

        public Criteria andCichen_sf_priceLessThan(Double value) {
            addCriterion("cichen_sf_price <", value, "cichen_sf_price");
            return (Criteria) this;
        }

        public Criteria andCichen_sf_priceLessThanOrEqualTo(Double value) {
            addCriterion("cichen_sf_price <=", value, "cichen_sf_price");
            return (Criteria) this;
        }

        public Criteria andCichen_sf_priceIn(List<Double> values) {
            addCriterion("cichen_sf_price in", values, "cichen_sf_price");
            return (Criteria) this;
        }

        public Criteria andCichen_sf_priceNotIn(List<Double> values) {
            addCriterion("cichen_sf_price not in", values, "cichen_sf_price");
            return (Criteria) this;
        }

        public Criteria andCichen_sf_priceBetween(Double value1, Double value2) {
            addCriterion("cichen_sf_price between", value1, value2, "cichen_sf_price");
            return (Criteria) this;
        }

        public Criteria andCichen_sf_priceNotBetween(Double value1, Double value2) {
            addCriterion("cichen_sf_price not between", value1, value2, "cichen_sf_price");
            return (Criteria) this;
        }

        public Criteria andCichen_qbt_priceIsNull() {
            addCriterion("cichen_qbt_price is null");
            return (Criteria) this;
        }

        public Criteria andCichen_qbt_priceIsNotNull() {
            addCriterion("cichen_qbt_price is not null");
            return (Criteria) this;
        }

        public Criteria andCichen_qbt_priceEqualTo(Double value) {
            addCriterion("cichen_qbt_price =", value, "cichen_qbt_price");
            return (Criteria) this;
        }

        public Criteria andCichen_qbt_priceNotEqualTo(Double value) {
            addCriterion("cichen_qbt_price <>", value, "cichen_qbt_price");
            return (Criteria) this;
        }

        public Criteria andCichen_qbt_priceGreaterThan(Double value) {
            addCriterion("cichen_qbt_price >", value, "cichen_qbt_price");
            return (Criteria) this;
        }

        public Criteria andCichen_qbt_priceGreaterThanOrEqualTo(Double value) {
            addCriterion("cichen_qbt_price >=", value, "cichen_qbt_price");
            return (Criteria) this;
        }

        public Criteria andCichen_qbt_priceLessThan(Double value) {
            addCriterion("cichen_qbt_price <", value, "cichen_qbt_price");
            return (Criteria) this;
        }

        public Criteria andCichen_qbt_priceLessThanOrEqualTo(Double value) {
            addCriterion("cichen_qbt_price <=", value, "cichen_qbt_price");
            return (Criteria) this;
        }

        public Criteria andCichen_qbt_priceIn(List<Double> values) {
            addCriterion("cichen_qbt_price in", values, "cichen_qbt_price");
            return (Criteria) this;
        }

        public Criteria andCichen_qbt_priceNotIn(List<Double> values) {
            addCriterion("cichen_qbt_price not in", values, "cichen_qbt_price");
            return (Criteria) this;
        }

        public Criteria andCichen_qbt_priceBetween(Double value1, Double value2) {
            addCriterion("cichen_qbt_price between", value1, value2, "cichen_qbt_price");
            return (Criteria) this;
        }

        public Criteria andCichen_qbt_priceNotBetween(Double value1, Double value2) {
            addCriterion("cichen_qbt_price not between", value1, value2, "cichen_qbt_price");
            return (Criteria) this;
        }

        public Criteria andCichen_first_priceIsNull() {
            addCriterion("cichen_first_price is null");
            return (Criteria) this;
        }

        public Criteria andCichen_first_priceIsNotNull() {
            addCriterion("cichen_first_price is not null");
            return (Criteria) this;
        }

        public Criteria andCichen_first_priceEqualTo(Double value) {
            addCriterion("cichen_first_price =", value, "cichen_first_price");
            return (Criteria) this;
        }

        public Criteria andCichen_first_priceNotEqualTo(Double value) {
            addCriterion("cichen_first_price <>", value, "cichen_first_price");
            return (Criteria) this;
        }

        public Criteria andCichen_first_priceGreaterThan(Double value) {
            addCriterion("cichen_first_price >", value, "cichen_first_price");
            return (Criteria) this;
        }

        public Criteria andCichen_first_priceGreaterThanOrEqualTo(Double value) {
            addCriterion("cichen_first_price >=", value, "cichen_first_price");
            return (Criteria) this;
        }

        public Criteria andCichen_first_priceLessThan(Double value) {
            addCriterion("cichen_first_price <", value, "cichen_first_price");
            return (Criteria) this;
        }

        public Criteria andCichen_first_priceLessThanOrEqualTo(Double value) {
            addCriterion("cichen_first_price <=", value, "cichen_first_price");
            return (Criteria) this;
        }

        public Criteria andCichen_first_priceIn(List<Double> values) {
            addCriterion("cichen_first_price in", values, "cichen_first_price");
            return (Criteria) this;
        }

        public Criteria andCichen_first_priceNotIn(List<Double> values) {
            addCriterion("cichen_first_price not in", values, "cichen_first_price");
            return (Criteria) this;
        }

        public Criteria andCichen_first_priceBetween(Double value1, Double value2) {
            addCriterion("cichen_first_price between", value1, value2, "cichen_first_price");
            return (Criteria) this;
        }

        public Criteria andCichen_first_priceNotBetween(Double value1, Double value2) {
            addCriterion("cichen_first_price not between", value1, value2, "cichen_first_price");
            return (Criteria) this;
        }

        public Criteria andCichen_second_priceIsNull() {
            addCriterion("cichen_second_price is null");
            return (Criteria) this;
        }

        public Criteria andCichen_second_priceIsNotNull() {
            addCriterion("cichen_second_price is not null");
            return (Criteria) this;
        }

        public Criteria andCichen_second_priceEqualTo(Double value) {
            addCriterion("cichen_second_price =", value, "cichen_second_price");
            return (Criteria) this;
        }

        public Criteria andCichen_second_priceNotEqualTo(Double value) {
            addCriterion("cichen_second_price <>", value, "cichen_second_price");
            return (Criteria) this;
        }

        public Criteria andCichen_second_priceGreaterThan(Double value) {
            addCriterion("cichen_second_price >", value, "cichen_second_price");
            return (Criteria) this;
        }

        public Criteria andCichen_second_priceGreaterThanOrEqualTo(Double value) {
            addCriterion("cichen_second_price >=", value, "cichen_second_price");
            return (Criteria) this;
        }

        public Criteria andCichen_second_priceLessThan(Double value) {
            addCriterion("cichen_second_price <", value, "cichen_second_price");
            return (Criteria) this;
        }

        public Criteria andCichen_second_priceLessThanOrEqualTo(Double value) {
            addCriterion("cichen_second_price <=", value, "cichen_second_price");
            return (Criteria) this;
        }

        public Criteria andCichen_second_priceIn(List<Double> values) {
            addCriterion("cichen_second_price in", values, "cichen_second_price");
            return (Criteria) this;
        }

        public Criteria andCichen_second_priceNotIn(List<Double> values) {
            addCriterion("cichen_second_price not in", values, "cichen_second_price");
            return (Criteria) this;
        }

        public Criteria andCichen_second_priceBetween(Double value1, Double value2) {
            addCriterion("cichen_second_price between", value1, value2, "cichen_second_price");
            return (Criteria) this;
        }

        public Criteria andCichen_second_priceNotBetween(Double value1, Double value2) {
            addCriterion("cichen_second_price not between", value1, value2, "cichen_second_price");
            return (Criteria) this;
        }

        public Criteria andCiri_sf_priceIsNull() {
            addCriterion("ciri_sf_price is null");
            return (Criteria) this;
        }

        public Criteria andCiri_sf_priceIsNotNull() {
            addCriterion("ciri_sf_price is not null");
            return (Criteria) this;
        }

        public Criteria andCiri_sf_priceEqualTo(Double value) {
            addCriterion("ciri_sf_price =", value, "ciri_sf_price");
            return (Criteria) this;
        }

        public Criteria andCiri_sf_priceNotEqualTo(Double value) {
            addCriterion("ciri_sf_price <>", value, "ciri_sf_price");
            return (Criteria) this;
        }

        public Criteria andCiri_sf_priceGreaterThan(Double value) {
            addCriterion("ciri_sf_price >", value, "ciri_sf_price");
            return (Criteria) this;
        }

        public Criteria andCiri_sf_priceGreaterThanOrEqualTo(Double value) {
            addCriterion("ciri_sf_price >=", value, "ciri_sf_price");
            return (Criteria) this;
        }

        public Criteria andCiri_sf_priceLessThan(Double value) {
            addCriterion("ciri_sf_price <", value, "ciri_sf_price");
            return (Criteria) this;
        }

        public Criteria andCiri_sf_priceLessThanOrEqualTo(Double value) {
            addCriterion("ciri_sf_price <=", value, "ciri_sf_price");
            return (Criteria) this;
        }

        public Criteria andCiri_sf_priceIn(List<Double> values) {
            addCriterion("ciri_sf_price in", values, "ciri_sf_price");
            return (Criteria) this;
        }

        public Criteria andCiri_sf_priceNotIn(List<Double> values) {
            addCriterion("ciri_sf_price not in", values, "ciri_sf_price");
            return (Criteria) this;
        }

        public Criteria andCiri_sf_priceBetween(Double value1, Double value2) {
            addCriterion("ciri_sf_price between", value1, value2, "ciri_sf_price");
            return (Criteria) this;
        }

        public Criteria andCiri_sf_priceNotBetween(Double value1, Double value2) {
            addCriterion("ciri_sf_price not between", value1, value2, "ciri_sf_price");
            return (Criteria) this;
        }

        public Criteria andCiri_qbt_priceIsNull() {
            addCriterion("ciri_qbt_price is null");
            return (Criteria) this;
        }

        public Criteria andCiri_qbt_priceIsNotNull() {
            addCriterion("ciri_qbt_price is not null");
            return (Criteria) this;
        }

        public Criteria andCiri_qbt_priceEqualTo(Double value) {
            addCriterion("ciri_qbt_price =", value, "ciri_qbt_price");
            return (Criteria) this;
        }

        public Criteria andCiri_qbt_priceNotEqualTo(Double value) {
            addCriterion("ciri_qbt_price <>", value, "ciri_qbt_price");
            return (Criteria) this;
        }

        public Criteria andCiri_qbt_priceGreaterThan(Double value) {
            addCriterion("ciri_qbt_price >", value, "ciri_qbt_price");
            return (Criteria) this;
        }

        public Criteria andCiri_qbt_priceGreaterThanOrEqualTo(Double value) {
            addCriterion("ciri_qbt_price >=", value, "ciri_qbt_price");
            return (Criteria) this;
        }

        public Criteria andCiri_qbt_priceLessThan(Double value) {
            addCriterion("ciri_qbt_price <", value, "ciri_qbt_price");
            return (Criteria) this;
        }

        public Criteria andCiri_qbt_priceLessThanOrEqualTo(Double value) {
            addCriterion("ciri_qbt_price <=", value, "ciri_qbt_price");
            return (Criteria) this;
        }

        public Criteria andCiri_qbt_priceIn(List<Double> values) {
            addCriterion("ciri_qbt_price in", values, "ciri_qbt_price");
            return (Criteria) this;
        }

        public Criteria andCiri_qbt_priceNotIn(List<Double> values) {
            addCriterion("ciri_qbt_price not in", values, "ciri_qbt_price");
            return (Criteria) this;
        }

        public Criteria andCiri_qbt_priceBetween(Double value1, Double value2) {
            addCriterion("ciri_qbt_price between", value1, value2, "ciri_qbt_price");
            return (Criteria) this;
        }

        public Criteria andCiri_qbt_priceNotBetween(Double value1, Double value2) {
            addCriterion("ciri_qbt_price not between", value1, value2, "ciri_qbt_price");
            return (Criteria) this;
        }

        public Criteria andCiri_first_priceIsNull() {
            addCriterion("ciri_first_price is null");
            return (Criteria) this;
        }

        public Criteria andCiri_first_priceIsNotNull() {
            addCriterion("ciri_first_price is not null");
            return (Criteria) this;
        }

        public Criteria andCiri_first_priceEqualTo(Double value) {
            addCriterion("ciri_first_price =", value, "ciri_first_price");
            return (Criteria) this;
        }

        public Criteria andCiri_first_priceNotEqualTo(Double value) {
            addCriterion("ciri_first_price <>", value, "ciri_first_price");
            return (Criteria) this;
        }

        public Criteria andCiri_first_priceGreaterThan(Double value) {
            addCriterion("ciri_first_price >", value, "ciri_first_price");
            return (Criteria) this;
        }

        public Criteria andCiri_first_priceGreaterThanOrEqualTo(Double value) {
            addCriterion("ciri_first_price >=", value, "ciri_first_price");
            return (Criteria) this;
        }

        public Criteria andCiri_first_priceLessThan(Double value) {
            addCriterion("ciri_first_price <", value, "ciri_first_price");
            return (Criteria) this;
        }

        public Criteria andCiri_first_priceLessThanOrEqualTo(Double value) {
            addCriterion("ciri_first_price <=", value, "ciri_first_price");
            return (Criteria) this;
        }

        public Criteria andCiri_first_priceIn(List<Double> values) {
            addCriterion("ciri_first_price in", values, "ciri_first_price");
            return (Criteria) this;
        }

        public Criteria andCiri_first_priceNotIn(List<Double> values) {
            addCriterion("ciri_first_price not in", values, "ciri_first_price");
            return (Criteria) this;
        }

        public Criteria andCiri_first_priceBetween(Double value1, Double value2) {
            addCriterion("ciri_first_price between", value1, value2, "ciri_first_price");
            return (Criteria) this;
        }

        public Criteria andCiri_first_priceNotBetween(Double value1, Double value2) {
            addCriterion("ciri_first_price not between", value1, value2, "ciri_first_price");
            return (Criteria) this;
        }

        public Criteria andCiri_second_priceIsNull() {
            addCriterion("ciri_second_price is null");
            return (Criteria) this;
        }

        public Criteria andCiri_second_priceIsNotNull() {
            addCriterion("ciri_second_price is not null");
            return (Criteria) this;
        }

        public Criteria andCiri_second_priceEqualTo(Double value) {
            addCriterion("ciri_second_price =", value, "ciri_second_price");
            return (Criteria) this;
        }

        public Criteria andCiri_second_priceNotEqualTo(Double value) {
            addCriterion("ciri_second_price <>", value, "ciri_second_price");
            return (Criteria) this;
        }

        public Criteria andCiri_second_priceGreaterThan(Double value) {
            addCriterion("ciri_second_price >", value, "ciri_second_price");
            return (Criteria) this;
        }

        public Criteria andCiri_second_priceGreaterThanOrEqualTo(Double value) {
            addCriterion("ciri_second_price >=", value, "ciri_second_price");
            return (Criteria) this;
        }

        public Criteria andCiri_second_priceLessThan(Double value) {
            addCriterion("ciri_second_price <", value, "ciri_second_price");
            return (Criteria) this;
        }

        public Criteria andCiri_second_priceLessThanOrEqualTo(Double value) {
            addCriterion("ciri_second_price <=", value, "ciri_second_price");
            return (Criteria) this;
        }

        public Criteria andCiri_second_priceIn(List<Double> values) {
            addCriterion("ciri_second_price in", values, "ciri_second_price");
            return (Criteria) this;
        }

        public Criteria andCiri_second_priceNotIn(List<Double> values) {
            addCriterion("ciri_second_price not in", values, "ciri_second_price");
            return (Criteria) this;
        }

        public Criteria andCiri_second_priceBetween(Double value1, Double value2) {
            addCriterion("ciri_second_price between", value1, value2, "ciri_second_price");
            return (Criteria) this;
        }

        public Criteria andCiri_second_priceNotBetween(Double value1, Double value2) {
            addCriterion("ciri_second_price not between", value1, value2, "ciri_second_price");
            return (Criteria) this;
        }

        public Criteria andJiri_sf_priceIsNull() {
            addCriterion("jiri_sf_price is null");
            return (Criteria) this;
        }

        public Criteria andJiri_sf_priceIsNotNull() {
            addCriterion("jiri_sf_price is not null");
            return (Criteria) this;
        }

        public Criteria andJiri_sf_priceEqualTo(Double value) {
            addCriterion("jiri_sf_price =", value, "jiri_sf_price");
            return (Criteria) this;
        }

        public Criteria andJiri_sf_priceNotEqualTo(Double value) {
            addCriterion("jiri_sf_price <>", value, "jiri_sf_price");
            return (Criteria) this;
        }

        public Criteria andJiri_sf_priceGreaterThan(Double value) {
            addCriterion("jiri_sf_price >", value, "jiri_sf_price");
            return (Criteria) this;
        }

        public Criteria andJiri_sf_priceGreaterThanOrEqualTo(Double value) {
            addCriterion("jiri_sf_price >=", value, "jiri_sf_price");
            return (Criteria) this;
        }

        public Criteria andJiri_sf_priceLessThan(Double value) {
            addCriterion("jiri_sf_price <", value, "jiri_sf_price");
            return (Criteria) this;
        }

        public Criteria andJiri_sf_priceLessThanOrEqualTo(Double value) {
            addCriterion("jiri_sf_price <=", value, "jiri_sf_price");
            return (Criteria) this;
        }

        public Criteria andJiri_sf_priceIn(List<Double> values) {
            addCriterion("jiri_sf_price in", values, "jiri_sf_price");
            return (Criteria) this;
        }

        public Criteria andJiri_sf_priceNotIn(List<Double> values) {
            addCriterion("jiri_sf_price not in", values, "jiri_sf_price");
            return (Criteria) this;
        }

        public Criteria andJiri_sf_priceBetween(Double value1, Double value2) {
            addCriterion("jiri_sf_price between", value1, value2, "jiri_sf_price");
            return (Criteria) this;
        }

        public Criteria andJiri_sf_priceNotBetween(Double value1, Double value2) {
            addCriterion("jiri_sf_price not between", value1, value2, "jiri_sf_price");
            return (Criteria) this;
        }

        public Criteria andJiri_qbt_priceIsNull() {
            addCriterion("jiri_qbt_price is null");
            return (Criteria) this;
        }

        public Criteria andJiri_qbt_priceIsNotNull() {
            addCriterion("jiri_qbt_price is not null");
            return (Criteria) this;
        }

        public Criteria andJiri_qbt_priceEqualTo(Double value) {
            addCriterion("jiri_qbt_price =", value, "jiri_qbt_price");
            return (Criteria) this;
        }

        public Criteria andJiri_qbt_priceNotEqualTo(Double value) {
            addCriterion("jiri_qbt_price <>", value, "jiri_qbt_price");
            return (Criteria) this;
        }

        public Criteria andJiri_qbt_priceGreaterThan(Double value) {
            addCriterion("jiri_qbt_price >", value, "jiri_qbt_price");
            return (Criteria) this;
        }

        public Criteria andJiri_qbt_priceGreaterThanOrEqualTo(Double value) {
            addCriterion("jiri_qbt_price >=", value, "jiri_qbt_price");
            return (Criteria) this;
        }

        public Criteria andJiri_qbt_priceLessThan(Double value) {
            addCriterion("jiri_qbt_price <", value, "jiri_qbt_price");
            return (Criteria) this;
        }

        public Criteria andJiri_qbt_priceLessThanOrEqualTo(Double value) {
            addCriterion("jiri_qbt_price <=", value, "jiri_qbt_price");
            return (Criteria) this;
        }

        public Criteria andJiri_qbt_priceIn(List<Double> values) {
            addCriterion("jiri_qbt_price in", values, "jiri_qbt_price");
            return (Criteria) this;
        }

        public Criteria andJiri_qbt_priceNotIn(List<Double> values) {
            addCriterion("jiri_qbt_price not in", values, "jiri_qbt_price");
            return (Criteria) this;
        }

        public Criteria andJiri_qbt_priceBetween(Double value1, Double value2) {
            addCriterion("jiri_qbt_price between", value1, value2, "jiri_qbt_price");
            return (Criteria) this;
        }

        public Criteria andJiri_qbt_priceNotBetween(Double value1, Double value2) {
            addCriterion("jiri_qbt_price not between", value1, value2, "jiri_qbt_price");
            return (Criteria) this;
        }

        public Criteria andJiri_first_priceIsNull() {
            addCriterion("jiri_first_price is null");
            return (Criteria) this;
        }

        public Criteria andJiri_first_priceIsNotNull() {
            addCriterion("jiri_first_price is not null");
            return (Criteria) this;
        }

        public Criteria andJiri_first_priceEqualTo(Double value) {
            addCriterion("jiri_first_price =", value, "jiri_first_price");
            return (Criteria) this;
        }

        public Criteria andJiri_first_priceNotEqualTo(Double value) {
            addCriterion("jiri_first_price <>", value, "jiri_first_price");
            return (Criteria) this;
        }

        public Criteria andJiri_first_priceGreaterThan(Double value) {
            addCriterion("jiri_first_price >", value, "jiri_first_price");
            return (Criteria) this;
        }

        public Criteria andJiri_first_priceGreaterThanOrEqualTo(Double value) {
            addCriterion("jiri_first_price >=", value, "jiri_first_price");
            return (Criteria) this;
        }

        public Criteria andJiri_first_priceLessThan(Double value) {
            addCriterion("jiri_first_price <", value, "jiri_first_price");
            return (Criteria) this;
        }

        public Criteria andJiri_first_priceLessThanOrEqualTo(Double value) {
            addCriterion("jiri_first_price <=", value, "jiri_first_price");
            return (Criteria) this;
        }

        public Criteria andJiri_first_priceIn(List<Double> values) {
            addCriterion("jiri_first_price in", values, "jiri_first_price");
            return (Criteria) this;
        }

        public Criteria andJiri_first_priceNotIn(List<Double> values) {
            addCriterion("jiri_first_price not in", values, "jiri_first_price");
            return (Criteria) this;
        }

        public Criteria andJiri_first_priceBetween(Double value1, Double value2) {
            addCriterion("jiri_first_price between", value1, value2, "jiri_first_price");
            return (Criteria) this;
        }

        public Criteria andJiri_first_priceNotBetween(Double value1, Double value2) {
            addCriterion("jiri_first_price not between", value1, value2, "jiri_first_price");
            return (Criteria) this;
        }

        public Criteria andJiri_second_priceIsNull() {
            addCriterion("jiri_second_price is null");
            return (Criteria) this;
        }

        public Criteria andJiri_second_priceIsNotNull() {
            addCriterion("jiri_second_price is not null");
            return (Criteria) this;
        }

        public Criteria andJiri_second_priceEqualTo(Double value) {
            addCriterion("jiri_second_price =", value, "jiri_second_price");
            return (Criteria) this;
        }

        public Criteria andJiri_second_priceNotEqualTo(Double value) {
            addCriterion("jiri_second_price <>", value, "jiri_second_price");
            return (Criteria) this;
        }

        public Criteria andJiri_second_priceGreaterThan(Double value) {
            addCriterion("jiri_second_price >", value, "jiri_second_price");
            return (Criteria) this;
        }

        public Criteria andJiri_second_priceGreaterThanOrEqualTo(Double value) {
            addCriterion("jiri_second_price >=", value, "jiri_second_price");
            return (Criteria) this;
        }

        public Criteria andJiri_second_priceLessThan(Double value) {
            addCriterion("jiri_second_price <", value, "jiri_second_price");
            return (Criteria) this;
        }

        public Criteria andJiri_second_priceLessThanOrEqualTo(Double value) {
            addCriterion("jiri_second_price <=", value, "jiri_second_price");
            return (Criteria) this;
        }

        public Criteria andJiri_second_priceIn(List<Double> values) {
            addCriterion("jiri_second_price in", values, "jiri_second_price");
            return (Criteria) this;
        }

        public Criteria andJiri_second_priceNotIn(List<Double> values) {
            addCriterion("jiri_second_price not in", values, "jiri_second_price");
            return (Criteria) this;
        }

        public Criteria andJiri_second_priceBetween(Double value1, Double value2) {
            addCriterion("jiri_second_price between", value1, value2, "jiri_second_price");
            return (Criteria) this;
        }

        public Criteria andJiri_second_priceNotBetween(Double value1, Double value2) {
            addCriterion("jiri_second_price not between", value1, value2, "jiri_second_price");
            return (Criteria) this;
        }

        public Criteria andGeri_sf_priceIsNull() {
            addCriterion("geri_sf_price is null");
            return (Criteria) this;
        }

        public Criteria andGeri_sf_priceIsNotNull() {
            addCriterion("geri_sf_price is not null");
            return (Criteria) this;
        }

        public Criteria andGeri_sf_priceEqualTo(Double value) {
            addCriterion("geri_sf_price =", value, "geri_sf_price");
            return (Criteria) this;
        }

        public Criteria andGeri_sf_priceNotEqualTo(Double value) {
            addCriterion("geri_sf_price <>", value, "geri_sf_price");
            return (Criteria) this;
        }

        public Criteria andGeri_sf_priceGreaterThan(Double value) {
            addCriterion("geri_sf_price >", value, "geri_sf_price");
            return (Criteria) this;
        }

        public Criteria andGeri_sf_priceGreaterThanOrEqualTo(Double value) {
            addCriterion("geri_sf_price >=", value, "geri_sf_price");
            return (Criteria) this;
        }

        public Criteria andGeri_sf_priceLessThan(Double value) {
            addCriterion("geri_sf_price <", value, "geri_sf_price");
            return (Criteria) this;
        }

        public Criteria andGeri_sf_priceLessThanOrEqualTo(Double value) {
            addCriterion("geri_sf_price <=", value, "geri_sf_price");
            return (Criteria) this;
        }

        public Criteria andGeri_sf_priceIn(List<Double> values) {
            addCriterion("geri_sf_price in", values, "geri_sf_price");
            return (Criteria) this;
        }

        public Criteria andGeri_sf_priceNotIn(List<Double> values) {
            addCriterion("geri_sf_price not in", values, "geri_sf_price");
            return (Criteria) this;
        }

        public Criteria andGeri_sf_priceBetween(Double value1, Double value2) {
            addCriterion("geri_sf_price between", value1, value2, "geri_sf_price");
            return (Criteria) this;
        }

        public Criteria andGeri_sf_priceNotBetween(Double value1, Double value2) {
            addCriterion("geri_sf_price not between", value1, value2, "geri_sf_price");
            return (Criteria) this;
        }

        public Criteria andGeri_qbt_priceIsNull() {
            addCriterion("geri_qbt_price is null");
            return (Criteria) this;
        }

        public Criteria andGeri_qbt_priceIsNotNull() {
            addCriterion("geri_qbt_price is not null");
            return (Criteria) this;
        }

        public Criteria andGeri_qbt_priceEqualTo(Double value) {
            addCriterion("geri_qbt_price =", value, "geri_qbt_price");
            return (Criteria) this;
        }

        public Criteria andGeri_qbt_priceNotEqualTo(Double value) {
            addCriterion("geri_qbt_price <>", value, "geri_qbt_price");
            return (Criteria) this;
        }

        public Criteria andGeri_qbt_priceGreaterThan(Double value) {
            addCriterion("geri_qbt_price >", value, "geri_qbt_price");
            return (Criteria) this;
        }

        public Criteria andGeri_qbt_priceGreaterThanOrEqualTo(Double value) {
            addCriterion("geri_qbt_price >=", value, "geri_qbt_price");
            return (Criteria) this;
        }

        public Criteria andGeri_qbt_priceLessThan(Double value) {
            addCriterion("geri_qbt_price <", value, "geri_qbt_price");
            return (Criteria) this;
        }

        public Criteria andGeri_qbt_priceLessThanOrEqualTo(Double value) {
            addCriterion("geri_qbt_price <=", value, "geri_qbt_price");
            return (Criteria) this;
        }

        public Criteria andGeri_qbt_priceIn(List<Double> values) {
            addCriterion("geri_qbt_price in", values, "geri_qbt_price");
            return (Criteria) this;
        }

        public Criteria andGeri_qbt_priceNotIn(List<Double> values) {
            addCriterion("geri_qbt_price not in", values, "geri_qbt_price");
            return (Criteria) this;
        }

        public Criteria andGeri_qbt_priceBetween(Double value1, Double value2) {
            addCriterion("geri_qbt_price between", value1, value2, "geri_qbt_price");
            return (Criteria) this;
        }

        public Criteria andGeri_qbt_priceNotBetween(Double value1, Double value2) {
            addCriterion("geri_qbt_price not between", value1, value2, "geri_qbt_price");
            return (Criteria) this;
        }

        public Criteria andGeri_first_priceIsNull() {
            addCriterion("geri_first_price is null");
            return (Criteria) this;
        }

        public Criteria andGeri_first_priceIsNotNull() {
            addCriterion("geri_first_price is not null");
            return (Criteria) this;
        }

        public Criteria andGeri_first_priceEqualTo(Double value) {
            addCriterion("geri_first_price =", value, "geri_first_price");
            return (Criteria) this;
        }

        public Criteria andGeri_first_priceNotEqualTo(Double value) {
            addCriterion("geri_first_price <>", value, "geri_first_price");
            return (Criteria) this;
        }

        public Criteria andGeri_first_priceGreaterThan(Double value) {
            addCriterion("geri_first_price >", value, "geri_first_price");
            return (Criteria) this;
        }

        public Criteria andGeri_first_priceGreaterThanOrEqualTo(Double value) {
            addCriterion("geri_first_price >=", value, "geri_first_price");
            return (Criteria) this;
        }

        public Criteria andGeri_first_priceLessThan(Double value) {
            addCriterion("geri_first_price <", value, "geri_first_price");
            return (Criteria) this;
        }

        public Criteria andGeri_first_priceLessThanOrEqualTo(Double value) {
            addCriterion("geri_first_price <=", value, "geri_first_price");
            return (Criteria) this;
        }

        public Criteria andGeri_first_priceIn(List<Double> values) {
            addCriterion("geri_first_price in", values, "geri_first_price");
            return (Criteria) this;
        }

        public Criteria andGeri_first_priceNotIn(List<Double> values) {
            addCriterion("geri_first_price not in", values, "geri_first_price");
            return (Criteria) this;
        }

        public Criteria andGeri_first_priceBetween(Double value1, Double value2) {
            addCriterion("geri_first_price between", value1, value2, "geri_first_price");
            return (Criteria) this;
        }

        public Criteria andGeri_first_priceNotBetween(Double value1, Double value2) {
            addCriterion("geri_first_price not between", value1, value2, "geri_first_price");
            return (Criteria) this;
        }

        public Criteria andGeri_second_priceIsNull() {
            addCriterion("geri_second_price is null");
            return (Criteria) this;
        }

        public Criteria andGeri_second_priceIsNotNull() {
            addCriterion("geri_second_price is not null");
            return (Criteria) this;
        }

        public Criteria andGeri_second_priceEqualTo(Double value) {
            addCriterion("geri_second_price =", value, "geri_second_price");
            return (Criteria) this;
        }

        public Criteria andGeri_second_priceNotEqualTo(Double value) {
            addCriterion("geri_second_price <>", value, "geri_second_price");
            return (Criteria) this;
        }

        public Criteria andGeri_second_priceGreaterThan(Double value) {
            addCriterion("geri_second_price >", value, "geri_second_price");
            return (Criteria) this;
        }

        public Criteria andGeri_second_priceGreaterThanOrEqualTo(Double value) {
            addCriterion("geri_second_price >=", value, "geri_second_price");
            return (Criteria) this;
        }

        public Criteria andGeri_second_priceLessThan(Double value) {
            addCriterion("geri_second_price <", value, "geri_second_price");
            return (Criteria) this;
        }

        public Criteria andGeri_second_priceLessThanOrEqualTo(Double value) {
            addCriterion("geri_second_price <=", value, "geri_second_price");
            return (Criteria) this;
        }

        public Criteria andGeri_second_priceIn(List<Double> values) {
            addCriterion("geri_second_price in", values, "geri_second_price");
            return (Criteria) this;
        }

        public Criteria andGeri_second_priceNotIn(List<Double> values) {
            addCriterion("geri_second_price not in", values, "geri_second_price");
            return (Criteria) this;
        }

        public Criteria andGeri_second_priceBetween(Double value1, Double value2) {
            addCriterion("geri_second_price between", value1, value2, "geri_second_price");
            return (Criteria) this;
        }

        public Criteria andGeri_second_priceNotBetween(Double value1, Double value2) {
            addCriterion("geri_second_price not between", value1, value2, "geri_second_price");
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

        public Criteria andDeleted_atIsNull() {
            addCriterion("deleted_at is null");
            return (Criteria) this;
        }

        public Criteria andDeleted_atIsNotNull() {
            addCriterion("deleted_at is not null");
            return (Criteria) this;
        }

        public Criteria andDeleted_atEqualTo(Date value) {
            addCriterion("deleted_at =", value, "deleted_at");
            return (Criteria) this;
        }

        public Criteria andDeleted_atNotEqualTo(Date value) {
            addCriterion("deleted_at <>", value, "deleted_at");
            return (Criteria) this;
        }

        public Criteria andDeleted_atGreaterThan(Date value) {
            addCriterion("deleted_at >", value, "deleted_at");
            return (Criteria) this;
        }

        public Criteria andDeleted_atGreaterThanOrEqualTo(Date value) {
            addCriterion("deleted_at >=", value, "deleted_at");
            return (Criteria) this;
        }

        public Criteria andDeleted_atLessThan(Date value) {
            addCriterion("deleted_at <", value, "deleted_at");
            return (Criteria) this;
        }

        public Criteria andDeleted_atLessThanOrEqualTo(Date value) {
            addCriterion("deleted_at <=", value, "deleted_at");
            return (Criteria) this;
        }

        public Criteria andDeleted_atIn(List<Date> values) {
            addCriterion("deleted_at in", values, "deleted_at");
            return (Criteria) this;
        }

        public Criteria andDeleted_atNotIn(List<Date> values) {
            addCriterion("deleted_at not in", values, "deleted_at");
            return (Criteria) this;
        }

        public Criteria andDeleted_atBetween(Date value1, Date value2) {
            addCriterion("deleted_at between", value1, value2, "deleted_at");
            return (Criteria) this;
        }

        public Criteria andDeleted_atNotBetween(Date value1, Date value2) {
            addCriterion("deleted_at not between", value1, value2, "deleted_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atIsNull() {
            addCriterion("updated_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdated_atIsNotNull() {
            addCriterion("updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdated_atEqualTo(Date value) {
            addCriterion("updated_at =", value, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atNotEqualTo(Date value) {
            addCriterion("updated_at <>", value, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atGreaterThan(Date value) {
            addCriterion("updated_at >", value, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_at >=", value, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atLessThan(Date value) {
            addCriterion("updated_at <", value, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atLessThanOrEqualTo(Date value) {
            addCriterion("updated_at <=", value, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atIn(List<Date> values) {
            addCriterion("updated_at in", values, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atNotIn(List<Date> values) {
            addCriterion("updated_at not in", values, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atBetween(Date value1, Date value2) {
            addCriterion("updated_at between", value1, value2, "updated_at");
            return (Criteria) this;
        }

        public Criteria andUpdated_atNotBetween(Date value1, Date value2) {
            addCriterion("updated_at not between", value1, value2, "updated_at");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "version");
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