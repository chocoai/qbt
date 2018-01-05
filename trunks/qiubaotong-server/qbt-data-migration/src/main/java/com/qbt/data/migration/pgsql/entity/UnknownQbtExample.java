package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UnknownQbtExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UnknownQbtExample() {
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

        public Criteria andJ_provinceIsNull() {
            addCriterion("j_province is null");
            return (Criteria) this;
        }

        public Criteria andJ_provinceIsNotNull() {
            addCriterion("j_province is not null");
            return (Criteria) this;
        }

        public Criteria andJ_provinceEqualTo(String value) {
            addCriterion("j_province =", value, "j_province");
            return (Criteria) this;
        }

        public Criteria andJ_provinceNotEqualTo(String value) {
            addCriterion("j_province <>", value, "j_province");
            return (Criteria) this;
        }

        public Criteria andJ_provinceGreaterThan(String value) {
            addCriterion("j_province >", value, "j_province");
            return (Criteria) this;
        }

        public Criteria andJ_provinceGreaterThanOrEqualTo(String value) {
            addCriterion("j_province >=", value, "j_province");
            return (Criteria) this;
        }

        public Criteria andJ_provinceLessThan(String value) {
            addCriterion("j_province <", value, "j_province");
            return (Criteria) this;
        }

        public Criteria andJ_provinceLessThanOrEqualTo(String value) {
            addCriterion("j_province <=", value, "j_province");
            return (Criteria) this;
        }

        public Criteria andJ_provinceLike(String value) {
            addCriterion("j_province like", value, "j_province");
            return (Criteria) this;
        }

        public Criteria andJ_provinceNotLike(String value) {
            addCriterion("j_province not like", value, "j_province");
            return (Criteria) this;
        }

        public Criteria andJ_provinceIn(List<String> values) {
            addCriterion("j_province in", values, "j_province");
            return (Criteria) this;
        }

        public Criteria andJ_provinceNotIn(List<String> values) {
            addCriterion("j_province not in", values, "j_province");
            return (Criteria) this;
        }

        public Criteria andJ_provinceBetween(String value1, String value2) {
            addCriterion("j_province between", value1, value2, "j_province");
            return (Criteria) this;
        }

        public Criteria andJ_provinceNotBetween(String value1, String value2) {
            addCriterion("j_province not between", value1, value2, "j_province");
            return (Criteria) this;
        }

        public Criteria andJ_cityIsNull() {
            addCriterion("j_city is null");
            return (Criteria) this;
        }

        public Criteria andJ_cityIsNotNull() {
            addCriterion("j_city is not null");
            return (Criteria) this;
        }

        public Criteria andJ_cityEqualTo(String value) {
            addCriterion("j_city =", value, "j_city");
            return (Criteria) this;
        }

        public Criteria andJ_cityNotEqualTo(String value) {
            addCriterion("j_city <>", value, "j_city");
            return (Criteria) this;
        }

        public Criteria andJ_cityGreaterThan(String value) {
            addCriterion("j_city >", value, "j_city");
            return (Criteria) this;
        }

        public Criteria andJ_cityGreaterThanOrEqualTo(String value) {
            addCriterion("j_city >=", value, "j_city");
            return (Criteria) this;
        }

        public Criteria andJ_cityLessThan(String value) {
            addCriterion("j_city <", value, "j_city");
            return (Criteria) this;
        }

        public Criteria andJ_cityLessThanOrEqualTo(String value) {
            addCriterion("j_city <=", value, "j_city");
            return (Criteria) this;
        }

        public Criteria andJ_cityLike(String value) {
            addCriterion("j_city like", value, "j_city");
            return (Criteria) this;
        }

        public Criteria andJ_cityNotLike(String value) {
            addCriterion("j_city not like", value, "j_city");
            return (Criteria) this;
        }

        public Criteria andJ_cityIn(List<String> values) {
            addCriterion("j_city in", values, "j_city");
            return (Criteria) this;
        }

        public Criteria andJ_cityNotIn(List<String> values) {
            addCriterion("j_city not in", values, "j_city");
            return (Criteria) this;
        }

        public Criteria andJ_cityBetween(String value1, String value2) {
            addCriterion("j_city between", value1, value2, "j_city");
            return (Criteria) this;
        }

        public Criteria andJ_cityNotBetween(String value1, String value2) {
            addCriterion("j_city not between", value1, value2, "j_city");
            return (Criteria) this;
        }

        public Criteria andJ_countyIsNull() {
            addCriterion("j_county is null");
            return (Criteria) this;
        }

        public Criteria andJ_countyIsNotNull() {
            addCriterion("j_county is not null");
            return (Criteria) this;
        }

        public Criteria andJ_countyEqualTo(String value) {
            addCriterion("j_county =", value, "j_county");
            return (Criteria) this;
        }

        public Criteria andJ_countyNotEqualTo(String value) {
            addCriterion("j_county <>", value, "j_county");
            return (Criteria) this;
        }

        public Criteria andJ_countyGreaterThan(String value) {
            addCriterion("j_county >", value, "j_county");
            return (Criteria) this;
        }

        public Criteria andJ_countyGreaterThanOrEqualTo(String value) {
            addCriterion("j_county >=", value, "j_county");
            return (Criteria) this;
        }

        public Criteria andJ_countyLessThan(String value) {
            addCriterion("j_county <", value, "j_county");
            return (Criteria) this;
        }

        public Criteria andJ_countyLessThanOrEqualTo(String value) {
            addCriterion("j_county <=", value, "j_county");
            return (Criteria) this;
        }

        public Criteria andJ_countyLike(String value) {
            addCriterion("j_county like", value, "j_county");
            return (Criteria) this;
        }

        public Criteria andJ_countyNotLike(String value) {
            addCriterion("j_county not like", value, "j_county");
            return (Criteria) this;
        }

        public Criteria andJ_countyIn(List<String> values) {
            addCriterion("j_county in", values, "j_county");
            return (Criteria) this;
        }

        public Criteria andJ_countyNotIn(List<String> values) {
            addCriterion("j_county not in", values, "j_county");
            return (Criteria) this;
        }

        public Criteria andJ_countyBetween(String value1, String value2) {
            addCriterion("j_county between", value1, value2, "j_county");
            return (Criteria) this;
        }

        public Criteria andJ_countyNotBetween(String value1, String value2) {
            addCriterion("j_county not between", value1, value2, "j_county");
            return (Criteria) this;
        }

        public Criteria andJ_addressIsNull() {
            addCriterion("j_address is null");
            return (Criteria) this;
        }

        public Criteria andJ_addressIsNotNull() {
            addCriterion("j_address is not null");
            return (Criteria) this;
        }

        public Criteria andJ_addressEqualTo(String value) {
            addCriterion("j_address =", value, "j_address");
            return (Criteria) this;
        }

        public Criteria andJ_addressNotEqualTo(String value) {
            addCriterion("j_address <>", value, "j_address");
            return (Criteria) this;
        }

        public Criteria andJ_addressGreaterThan(String value) {
            addCriterion("j_address >", value, "j_address");
            return (Criteria) this;
        }

        public Criteria andJ_addressGreaterThanOrEqualTo(String value) {
            addCriterion("j_address >=", value, "j_address");
            return (Criteria) this;
        }

        public Criteria andJ_addressLessThan(String value) {
            addCriterion("j_address <", value, "j_address");
            return (Criteria) this;
        }

        public Criteria andJ_addressLessThanOrEqualTo(String value) {
            addCriterion("j_address <=", value, "j_address");
            return (Criteria) this;
        }

        public Criteria andJ_addressLike(String value) {
            addCriterion("j_address like", value, "j_address");
            return (Criteria) this;
        }

        public Criteria andJ_addressNotLike(String value) {
            addCriterion("j_address not like", value, "j_address");
            return (Criteria) this;
        }

        public Criteria andJ_addressIn(List<String> values) {
            addCriterion("j_address in", values, "j_address");
            return (Criteria) this;
        }

        public Criteria andJ_addressNotIn(List<String> values) {
            addCriterion("j_address not in", values, "j_address");
            return (Criteria) this;
        }

        public Criteria andJ_addressBetween(String value1, String value2) {
            addCriterion("j_address between", value1, value2, "j_address");
            return (Criteria) this;
        }

        public Criteria andJ_addressNotBetween(String value1, String value2) {
            addCriterion("j_address not between", value1, value2, "j_address");
            return (Criteria) this;
        }

        public Criteria andD_provinceIsNull() {
            addCriterion("d_province is null");
            return (Criteria) this;
        }

        public Criteria andD_provinceIsNotNull() {
            addCriterion("d_province is not null");
            return (Criteria) this;
        }

        public Criteria andD_provinceEqualTo(String value) {
            addCriterion("d_province =", value, "d_province");
            return (Criteria) this;
        }

        public Criteria andD_provinceNotEqualTo(String value) {
            addCriterion("d_province <>", value, "d_province");
            return (Criteria) this;
        }

        public Criteria andD_provinceGreaterThan(String value) {
            addCriterion("d_province >", value, "d_province");
            return (Criteria) this;
        }

        public Criteria andD_provinceGreaterThanOrEqualTo(String value) {
            addCriterion("d_province >=", value, "d_province");
            return (Criteria) this;
        }

        public Criteria andD_provinceLessThan(String value) {
            addCriterion("d_province <", value, "d_province");
            return (Criteria) this;
        }

        public Criteria andD_provinceLessThanOrEqualTo(String value) {
            addCriterion("d_province <=", value, "d_province");
            return (Criteria) this;
        }

        public Criteria andD_provinceLike(String value) {
            addCriterion("d_province like", value, "d_province");
            return (Criteria) this;
        }

        public Criteria andD_provinceNotLike(String value) {
            addCriterion("d_province not like", value, "d_province");
            return (Criteria) this;
        }

        public Criteria andD_provinceIn(List<String> values) {
            addCriterion("d_province in", values, "d_province");
            return (Criteria) this;
        }

        public Criteria andD_provinceNotIn(List<String> values) {
            addCriterion("d_province not in", values, "d_province");
            return (Criteria) this;
        }

        public Criteria andD_provinceBetween(String value1, String value2) {
            addCriterion("d_province between", value1, value2, "d_province");
            return (Criteria) this;
        }

        public Criteria andD_provinceNotBetween(String value1, String value2) {
            addCriterion("d_province not between", value1, value2, "d_province");
            return (Criteria) this;
        }

        public Criteria andD_cityIsNull() {
            addCriterion("d_city is null");
            return (Criteria) this;
        }

        public Criteria andD_cityIsNotNull() {
            addCriterion("d_city is not null");
            return (Criteria) this;
        }

        public Criteria andD_cityEqualTo(String value) {
            addCriterion("d_city =", value, "d_city");
            return (Criteria) this;
        }

        public Criteria andD_cityNotEqualTo(String value) {
            addCriterion("d_city <>", value, "d_city");
            return (Criteria) this;
        }

        public Criteria andD_cityGreaterThan(String value) {
            addCriterion("d_city >", value, "d_city");
            return (Criteria) this;
        }

        public Criteria andD_cityGreaterThanOrEqualTo(String value) {
            addCriterion("d_city >=", value, "d_city");
            return (Criteria) this;
        }

        public Criteria andD_cityLessThan(String value) {
            addCriterion("d_city <", value, "d_city");
            return (Criteria) this;
        }

        public Criteria andD_cityLessThanOrEqualTo(String value) {
            addCriterion("d_city <=", value, "d_city");
            return (Criteria) this;
        }

        public Criteria andD_cityLike(String value) {
            addCriterion("d_city like", value, "d_city");
            return (Criteria) this;
        }

        public Criteria andD_cityNotLike(String value) {
            addCriterion("d_city not like", value, "d_city");
            return (Criteria) this;
        }

        public Criteria andD_cityIn(List<String> values) {
            addCriterion("d_city in", values, "d_city");
            return (Criteria) this;
        }

        public Criteria andD_cityNotIn(List<String> values) {
            addCriterion("d_city not in", values, "d_city");
            return (Criteria) this;
        }

        public Criteria andD_cityBetween(String value1, String value2) {
            addCriterion("d_city between", value1, value2, "d_city");
            return (Criteria) this;
        }

        public Criteria andD_cityNotBetween(String value1, String value2) {
            addCriterion("d_city not between", value1, value2, "d_city");
            return (Criteria) this;
        }

        public Criteria andD_countyIsNull() {
            addCriterion("d_county is null");
            return (Criteria) this;
        }

        public Criteria andD_countyIsNotNull() {
            addCriterion("d_county is not null");
            return (Criteria) this;
        }

        public Criteria andD_countyEqualTo(String value) {
            addCriterion("d_county =", value, "d_county");
            return (Criteria) this;
        }

        public Criteria andD_countyNotEqualTo(String value) {
            addCriterion("d_county <>", value, "d_county");
            return (Criteria) this;
        }

        public Criteria andD_countyGreaterThan(String value) {
            addCriterion("d_county >", value, "d_county");
            return (Criteria) this;
        }

        public Criteria andD_countyGreaterThanOrEqualTo(String value) {
            addCriterion("d_county >=", value, "d_county");
            return (Criteria) this;
        }

        public Criteria andD_countyLessThan(String value) {
            addCriterion("d_county <", value, "d_county");
            return (Criteria) this;
        }

        public Criteria andD_countyLessThanOrEqualTo(String value) {
            addCriterion("d_county <=", value, "d_county");
            return (Criteria) this;
        }

        public Criteria andD_countyLike(String value) {
            addCriterion("d_county like", value, "d_county");
            return (Criteria) this;
        }

        public Criteria andD_countyNotLike(String value) {
            addCriterion("d_county not like", value, "d_county");
            return (Criteria) this;
        }

        public Criteria andD_countyIn(List<String> values) {
            addCriterion("d_county in", values, "d_county");
            return (Criteria) this;
        }

        public Criteria andD_countyNotIn(List<String> values) {
            addCriterion("d_county not in", values, "d_county");
            return (Criteria) this;
        }

        public Criteria andD_countyBetween(String value1, String value2) {
            addCriterion("d_county between", value1, value2, "d_county");
            return (Criteria) this;
        }

        public Criteria andD_countyNotBetween(String value1, String value2) {
            addCriterion("d_county not between", value1, value2, "d_county");
            return (Criteria) this;
        }

        public Criteria andD_addressIsNull() {
            addCriterion("d_address is null");
            return (Criteria) this;
        }

        public Criteria andD_addressIsNotNull() {
            addCriterion("d_address is not null");
            return (Criteria) this;
        }

        public Criteria andD_addressEqualTo(String value) {
            addCriterion("d_address =", value, "d_address");
            return (Criteria) this;
        }

        public Criteria andD_addressNotEqualTo(String value) {
            addCriterion("d_address <>", value, "d_address");
            return (Criteria) this;
        }

        public Criteria andD_addressGreaterThan(String value) {
            addCriterion("d_address >", value, "d_address");
            return (Criteria) this;
        }

        public Criteria andD_addressGreaterThanOrEqualTo(String value) {
            addCriterion("d_address >=", value, "d_address");
            return (Criteria) this;
        }

        public Criteria andD_addressLessThan(String value) {
            addCriterion("d_address <", value, "d_address");
            return (Criteria) this;
        }

        public Criteria andD_addressLessThanOrEqualTo(String value) {
            addCriterion("d_address <=", value, "d_address");
            return (Criteria) this;
        }

        public Criteria andD_addressLike(String value) {
            addCriterion("d_address like", value, "d_address");
            return (Criteria) this;
        }

        public Criteria andD_addressNotLike(String value) {
            addCriterion("d_address not like", value, "d_address");
            return (Criteria) this;
        }

        public Criteria andD_addressIn(List<String> values) {
            addCriterion("d_address in", values, "d_address");
            return (Criteria) this;
        }

        public Criteria andD_addressNotIn(List<String> values) {
            addCriterion("d_address not in", values, "d_address");
            return (Criteria) this;
        }

        public Criteria andD_addressBetween(String value1, String value2) {
            addCriterion("d_address between", value1, value2, "d_address");
            return (Criteria) this;
        }

        public Criteria andD_addressNotBetween(String value1, String value2) {
            addCriterion("d_address not between", value1, value2, "d_address");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
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

        public Criteria andExpress_typeIsNull() {
            addCriterion("express_type is null");
            return (Criteria) this;
        }

        public Criteria andExpress_typeIsNotNull() {
            addCriterion("express_type is not null");
            return (Criteria) this;
        }

        public Criteria andExpress_typeEqualTo(String value) {
            addCriterion("express_type =", value, "express_type");
            return (Criteria) this;
        }

        public Criteria andExpress_typeNotEqualTo(String value) {
            addCriterion("express_type <>", value, "express_type");
            return (Criteria) this;
        }

        public Criteria andExpress_typeGreaterThan(String value) {
            addCriterion("express_type >", value, "express_type");
            return (Criteria) this;
        }

        public Criteria andExpress_typeGreaterThanOrEqualTo(String value) {
            addCriterion("express_type >=", value, "express_type");
            return (Criteria) this;
        }

        public Criteria andExpress_typeLessThan(String value) {
            addCriterion("express_type <", value, "express_type");
            return (Criteria) this;
        }

        public Criteria andExpress_typeLessThanOrEqualTo(String value) {
            addCriterion("express_type <=", value, "express_type");
            return (Criteria) this;
        }

        public Criteria andExpress_typeLike(String value) {
            addCriterion("express_type like", value, "express_type");
            return (Criteria) this;
        }

        public Criteria andExpress_typeNotLike(String value) {
            addCriterion("express_type not like", value, "express_type");
            return (Criteria) this;
        }

        public Criteria andExpress_typeIn(List<String> values) {
            addCriterion("express_type in", values, "express_type");
            return (Criteria) this;
        }

        public Criteria andExpress_typeNotIn(List<String> values) {
            addCriterion("express_type not in", values, "express_type");
            return (Criteria) this;
        }

        public Criteria andExpress_typeBetween(String value1, String value2) {
            addCriterion("express_type between", value1, value2, "express_type");
            return (Criteria) this;
        }

        public Criteria andExpress_typeNotBetween(String value1, String value2) {
            addCriterion("express_type not between", value1, value2, "express_type");
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