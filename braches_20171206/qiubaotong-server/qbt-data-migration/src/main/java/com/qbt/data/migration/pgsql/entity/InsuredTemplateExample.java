package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InsuredTemplateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InsuredTemplateExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andInsured_ratesIsNull() {
            addCriterion("insured_rates is null");
            return (Criteria) this;
        }

        public Criteria andInsured_ratesIsNotNull() {
            addCriterion("insured_rates is not null");
            return (Criteria) this;
        }

        public Criteria andInsured_ratesEqualTo(Double value) {
            addCriterion("insured_rates =", value, "insured_rates");
            return (Criteria) this;
        }

        public Criteria andInsured_ratesNotEqualTo(Double value) {
            addCriterion("insured_rates <>", value, "insured_rates");
            return (Criteria) this;
        }

        public Criteria andInsured_ratesGreaterThan(Double value) {
            addCriterion("insured_rates >", value, "insured_rates");
            return (Criteria) this;
        }

        public Criteria andInsured_ratesGreaterThanOrEqualTo(Double value) {
            addCriterion("insured_rates >=", value, "insured_rates");
            return (Criteria) this;
        }

        public Criteria andInsured_ratesLessThan(Double value) {
            addCriterion("insured_rates <", value, "insured_rates");
            return (Criteria) this;
        }

        public Criteria andInsured_ratesLessThanOrEqualTo(Double value) {
            addCriterion("insured_rates <=", value, "insured_rates");
            return (Criteria) this;
        }

        public Criteria andInsured_ratesIn(List<Double> values) {
            addCriterion("insured_rates in", values, "insured_rates");
            return (Criteria) this;
        }

        public Criteria andInsured_ratesNotIn(List<Double> values) {
            addCriterion("insured_rates not in", values, "insured_rates");
            return (Criteria) this;
        }

        public Criteria andInsured_ratesBetween(Double value1, Double value2) {
            addCriterion("insured_rates between", value1, value2, "insured_rates");
            return (Criteria) this;
        }

        public Criteria andInsured_ratesNotBetween(Double value1, Double value2) {
            addCriterion("insured_rates not between", value1, value2, "insured_rates");
            return (Criteria) this;
        }

        public Criteria andFree_insuredIsNull() {
            addCriterion("free_insured is null");
            return (Criteria) this;
        }

        public Criteria andFree_insuredIsNotNull() {
            addCriterion("free_insured is not null");
            return (Criteria) this;
        }

        public Criteria andFree_insuredEqualTo(Double value) {
            addCriterion("free_insured =", value, "free_insured");
            return (Criteria) this;
        }

        public Criteria andFree_insuredNotEqualTo(Double value) {
            addCriterion("free_insured <>", value, "free_insured");
            return (Criteria) this;
        }

        public Criteria andFree_insuredGreaterThan(Double value) {
            addCriterion("free_insured >", value, "free_insured");
            return (Criteria) this;
        }

        public Criteria andFree_insuredGreaterThanOrEqualTo(Double value) {
            addCriterion("free_insured >=", value, "free_insured");
            return (Criteria) this;
        }

        public Criteria andFree_insuredLessThan(Double value) {
            addCriterion("free_insured <", value, "free_insured");
            return (Criteria) this;
        }

        public Criteria andFree_insuredLessThanOrEqualTo(Double value) {
            addCriterion("free_insured <=", value, "free_insured");
            return (Criteria) this;
        }

        public Criteria andFree_insuredIn(List<Double> values) {
            addCriterion("free_insured in", values, "free_insured");
            return (Criteria) this;
        }

        public Criteria andFree_insuredNotIn(List<Double> values) {
            addCriterion("free_insured not in", values, "free_insured");
            return (Criteria) this;
        }

        public Criteria andFree_insuredBetween(Double value1, Double value2) {
            addCriterion("free_insured between", value1, value2, "free_insured");
            return (Criteria) this;
        }

        public Criteria andFree_insuredNotBetween(Double value1, Double value2) {
            addCriterion("free_insured not between", value1, value2, "free_insured");
            return (Criteria) this;
        }

        public Criteria andInsured_minimumIsNull() {
            addCriterion("insured_minimum is null");
            return (Criteria) this;
        }

        public Criteria andInsured_minimumIsNotNull() {
            addCriterion("insured_minimum is not null");
            return (Criteria) this;
        }

        public Criteria andInsured_minimumEqualTo(Double value) {
            addCriterion("insured_minimum =", value, "insured_minimum");
            return (Criteria) this;
        }

        public Criteria andInsured_minimumNotEqualTo(Double value) {
            addCriterion("insured_minimum <>", value, "insured_minimum");
            return (Criteria) this;
        }

        public Criteria andInsured_minimumGreaterThan(Double value) {
            addCriterion("insured_minimum >", value, "insured_minimum");
            return (Criteria) this;
        }

        public Criteria andInsured_minimumGreaterThanOrEqualTo(Double value) {
            addCriterion("insured_minimum >=", value, "insured_minimum");
            return (Criteria) this;
        }

        public Criteria andInsured_minimumLessThan(Double value) {
            addCriterion("insured_minimum <", value, "insured_minimum");
            return (Criteria) this;
        }

        public Criteria andInsured_minimumLessThanOrEqualTo(Double value) {
            addCriterion("insured_minimum <=", value, "insured_minimum");
            return (Criteria) this;
        }

        public Criteria andInsured_minimumIn(List<Double> values) {
            addCriterion("insured_minimum in", values, "insured_minimum");
            return (Criteria) this;
        }

        public Criteria andInsured_minimumNotIn(List<Double> values) {
            addCriterion("insured_minimum not in", values, "insured_minimum");
            return (Criteria) this;
        }

        public Criteria andInsured_minimumBetween(Double value1, Double value2) {
            addCriterion("insured_minimum between", value1, value2, "insured_minimum");
            return (Criteria) this;
        }

        public Criteria andInsured_minimumNotBetween(Double value1, Double value2) {
            addCriterion("insured_minimum not between", value1, value2, "insured_minimum");
            return (Criteria) this;
        }

        public Criteria andInsured_maximumIsNull() {
            addCriterion("insured_maximum is null");
            return (Criteria) this;
        }

        public Criteria andInsured_maximumIsNotNull() {
            addCriterion("insured_maximum is not null");
            return (Criteria) this;
        }

        public Criteria andInsured_maximumEqualTo(Double value) {
            addCriterion("insured_maximum =", value, "insured_maximum");
            return (Criteria) this;
        }

        public Criteria andInsured_maximumNotEqualTo(Double value) {
            addCriterion("insured_maximum <>", value, "insured_maximum");
            return (Criteria) this;
        }

        public Criteria andInsured_maximumGreaterThan(Double value) {
            addCriterion("insured_maximum >", value, "insured_maximum");
            return (Criteria) this;
        }

        public Criteria andInsured_maximumGreaterThanOrEqualTo(Double value) {
            addCriterion("insured_maximum >=", value, "insured_maximum");
            return (Criteria) this;
        }

        public Criteria andInsured_maximumLessThan(Double value) {
            addCriterion("insured_maximum <", value, "insured_maximum");
            return (Criteria) this;
        }

        public Criteria andInsured_maximumLessThanOrEqualTo(Double value) {
            addCriterion("insured_maximum <=", value, "insured_maximum");
            return (Criteria) this;
        }

        public Criteria andInsured_maximumIn(List<Double> values) {
            addCriterion("insured_maximum in", values, "insured_maximum");
            return (Criteria) this;
        }

        public Criteria andInsured_maximumNotIn(List<Double> values) {
            addCriterion("insured_maximum not in", values, "insured_maximum");
            return (Criteria) this;
        }

        public Criteria andInsured_maximumBetween(Double value1, Double value2) {
            addCriterion("insured_maximum between", value1, value2, "insured_maximum");
            return (Criteria) this;
        }

        public Criteria andInsured_maximumNotBetween(Double value1, Double value2) {
            addCriterion("insured_maximum not between", value1, value2, "insured_maximum");
            return (Criteria) this;
        }

        public Criteria andDesc_insured_minimumIsNull() {
            addCriterion("desc_insured_minimum is null");
            return (Criteria) this;
        }

        public Criteria andDesc_insured_minimumIsNotNull() {
            addCriterion("desc_insured_minimum is not null");
            return (Criteria) this;
        }

        public Criteria andDesc_insured_minimumEqualTo(String value) {
            addCriterion("desc_insured_minimum =", value, "desc_insured_minimum");
            return (Criteria) this;
        }

        public Criteria andDesc_insured_minimumNotEqualTo(String value) {
            addCriterion("desc_insured_minimum <>", value, "desc_insured_minimum");
            return (Criteria) this;
        }

        public Criteria andDesc_insured_minimumGreaterThan(String value) {
            addCriterion("desc_insured_minimum >", value, "desc_insured_minimum");
            return (Criteria) this;
        }

        public Criteria andDesc_insured_minimumGreaterThanOrEqualTo(String value) {
            addCriterion("desc_insured_minimum >=", value, "desc_insured_minimum");
            return (Criteria) this;
        }

        public Criteria andDesc_insured_minimumLessThan(String value) {
            addCriterion("desc_insured_minimum <", value, "desc_insured_minimum");
            return (Criteria) this;
        }

        public Criteria andDesc_insured_minimumLessThanOrEqualTo(String value) {
            addCriterion("desc_insured_minimum <=", value, "desc_insured_minimum");
            return (Criteria) this;
        }

        public Criteria andDesc_insured_minimumLike(String value) {
            addCriterion("desc_insured_minimum like", value, "desc_insured_minimum");
            return (Criteria) this;
        }

        public Criteria andDesc_insured_minimumNotLike(String value) {
            addCriterion("desc_insured_minimum not like", value, "desc_insured_minimum");
            return (Criteria) this;
        }

        public Criteria andDesc_insured_minimumIn(List<String> values) {
            addCriterion("desc_insured_minimum in", values, "desc_insured_minimum");
            return (Criteria) this;
        }

        public Criteria andDesc_insured_minimumNotIn(List<String> values) {
            addCriterion("desc_insured_minimum not in", values, "desc_insured_minimum");
            return (Criteria) this;
        }

        public Criteria andDesc_insured_minimumBetween(String value1, String value2) {
            addCriterion("desc_insured_minimum between", value1, value2, "desc_insured_minimum");
            return (Criteria) this;
        }

        public Criteria andDesc_insured_minimumNotBetween(String value1, String value2) {
            addCriterion("desc_insured_minimum not between", value1, value2, "desc_insured_minimum");
            return (Criteria) this;
        }

        public Criteria andDesc_insured_maximumIsNull() {
            addCriterion("desc_insured_maximum is null");
            return (Criteria) this;
        }

        public Criteria andDesc_insured_maximumIsNotNull() {
            addCriterion("desc_insured_maximum is not null");
            return (Criteria) this;
        }

        public Criteria andDesc_insured_maximumEqualTo(String value) {
            addCriterion("desc_insured_maximum =", value, "desc_insured_maximum");
            return (Criteria) this;
        }

        public Criteria andDesc_insured_maximumNotEqualTo(String value) {
            addCriterion("desc_insured_maximum <>", value, "desc_insured_maximum");
            return (Criteria) this;
        }

        public Criteria andDesc_insured_maximumGreaterThan(String value) {
            addCriterion("desc_insured_maximum >", value, "desc_insured_maximum");
            return (Criteria) this;
        }

        public Criteria andDesc_insured_maximumGreaterThanOrEqualTo(String value) {
            addCriterion("desc_insured_maximum >=", value, "desc_insured_maximum");
            return (Criteria) this;
        }

        public Criteria andDesc_insured_maximumLessThan(String value) {
            addCriterion("desc_insured_maximum <", value, "desc_insured_maximum");
            return (Criteria) this;
        }

        public Criteria andDesc_insured_maximumLessThanOrEqualTo(String value) {
            addCriterion("desc_insured_maximum <=", value, "desc_insured_maximum");
            return (Criteria) this;
        }

        public Criteria andDesc_insured_maximumLike(String value) {
            addCriterion("desc_insured_maximum like", value, "desc_insured_maximum");
            return (Criteria) this;
        }

        public Criteria andDesc_insured_maximumNotLike(String value) {
            addCriterion("desc_insured_maximum not like", value, "desc_insured_maximum");
            return (Criteria) this;
        }

        public Criteria andDesc_insured_maximumIn(List<String> values) {
            addCriterion("desc_insured_maximum in", values, "desc_insured_maximum");
            return (Criteria) this;
        }

        public Criteria andDesc_insured_maximumNotIn(List<String> values) {
            addCriterion("desc_insured_maximum not in", values, "desc_insured_maximum");
            return (Criteria) this;
        }

        public Criteria andDesc_insured_maximumBetween(String value1, String value2) {
            addCriterion("desc_insured_maximum between", value1, value2, "desc_insured_maximum");
            return (Criteria) this;
        }

        public Criteria andDesc_insured_maximumNotBetween(String value1, String value2) {
            addCriterion("desc_insured_maximum not between", value1, value2, "desc_insured_maximum");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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