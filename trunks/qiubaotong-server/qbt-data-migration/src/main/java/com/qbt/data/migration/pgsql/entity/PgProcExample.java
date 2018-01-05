package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgProcExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgProcExample() {
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

        public Criteria andPronameIsNull() {
            addCriterion("proname is null");
            return (Criteria) this;
        }

        public Criteria andPronameIsNotNull() {
            addCriterion("proname is not null");
            return (Criteria) this;
        }

        public Criteria andPronameEqualTo(String value) {
            addCriterion("proname =", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameNotEqualTo(String value) {
            addCriterion("proname <>", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameGreaterThan(String value) {
            addCriterion("proname >", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameGreaterThanOrEqualTo(String value) {
            addCriterion("proname >=", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameLessThan(String value) {
            addCriterion("proname <", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameLessThanOrEqualTo(String value) {
            addCriterion("proname <=", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameLike(String value) {
            addCriterion("proname like", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameNotLike(String value) {
            addCriterion("proname not like", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameIn(List<String> values) {
            addCriterion("proname in", values, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameNotIn(List<String> values) {
            addCriterion("proname not in", values, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameBetween(String value1, String value2) {
            addCriterion("proname between", value1, value2, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameNotBetween(String value1, String value2) {
            addCriterion("proname not between", value1, value2, "proname");
            return (Criteria) this;
        }

        public Criteria andPronamespaceIsNull() {
            addCriterion("pronamespace is null");
            return (Criteria) this;
        }

        public Criteria andPronamespaceIsNotNull() {
            addCriterion("pronamespace is not null");
            return (Criteria) this;
        }

        public Criteria andPronamespaceEqualTo(Long value) {
            addCriterion("pronamespace =", value, "pronamespace");
            return (Criteria) this;
        }

        public Criteria andPronamespaceNotEqualTo(Long value) {
            addCriterion("pronamespace <>", value, "pronamespace");
            return (Criteria) this;
        }

        public Criteria andPronamespaceGreaterThan(Long value) {
            addCriterion("pronamespace >", value, "pronamespace");
            return (Criteria) this;
        }

        public Criteria andPronamespaceGreaterThanOrEqualTo(Long value) {
            addCriterion("pronamespace >=", value, "pronamespace");
            return (Criteria) this;
        }

        public Criteria andPronamespaceLessThan(Long value) {
            addCriterion("pronamespace <", value, "pronamespace");
            return (Criteria) this;
        }

        public Criteria andPronamespaceLessThanOrEqualTo(Long value) {
            addCriterion("pronamespace <=", value, "pronamespace");
            return (Criteria) this;
        }

        public Criteria andPronamespaceIn(List<Long> values) {
            addCriterion("pronamespace in", values, "pronamespace");
            return (Criteria) this;
        }

        public Criteria andPronamespaceNotIn(List<Long> values) {
            addCriterion("pronamespace not in", values, "pronamespace");
            return (Criteria) this;
        }

        public Criteria andPronamespaceBetween(Long value1, Long value2) {
            addCriterion("pronamespace between", value1, value2, "pronamespace");
            return (Criteria) this;
        }

        public Criteria andPronamespaceNotBetween(Long value1, Long value2) {
            addCriterion("pronamespace not between", value1, value2, "pronamespace");
            return (Criteria) this;
        }

        public Criteria andProownerIsNull() {
            addCriterion("proowner is null");
            return (Criteria) this;
        }

        public Criteria andProownerIsNotNull() {
            addCriterion("proowner is not null");
            return (Criteria) this;
        }

        public Criteria andProownerEqualTo(Long value) {
            addCriterion("proowner =", value, "proowner");
            return (Criteria) this;
        }

        public Criteria andProownerNotEqualTo(Long value) {
            addCriterion("proowner <>", value, "proowner");
            return (Criteria) this;
        }

        public Criteria andProownerGreaterThan(Long value) {
            addCriterion("proowner >", value, "proowner");
            return (Criteria) this;
        }

        public Criteria andProownerGreaterThanOrEqualTo(Long value) {
            addCriterion("proowner >=", value, "proowner");
            return (Criteria) this;
        }

        public Criteria andProownerLessThan(Long value) {
            addCriterion("proowner <", value, "proowner");
            return (Criteria) this;
        }

        public Criteria andProownerLessThanOrEqualTo(Long value) {
            addCriterion("proowner <=", value, "proowner");
            return (Criteria) this;
        }

        public Criteria andProownerIn(List<Long> values) {
            addCriterion("proowner in", values, "proowner");
            return (Criteria) this;
        }

        public Criteria andProownerNotIn(List<Long> values) {
            addCriterion("proowner not in", values, "proowner");
            return (Criteria) this;
        }

        public Criteria andProownerBetween(Long value1, Long value2) {
            addCriterion("proowner between", value1, value2, "proowner");
            return (Criteria) this;
        }

        public Criteria andProownerNotBetween(Long value1, Long value2) {
            addCriterion("proowner not between", value1, value2, "proowner");
            return (Criteria) this;
        }

        public Criteria andProlangIsNull() {
            addCriterion("prolang is null");
            return (Criteria) this;
        }

        public Criteria andProlangIsNotNull() {
            addCriterion("prolang is not null");
            return (Criteria) this;
        }

        public Criteria andProlangEqualTo(Long value) {
            addCriterion("prolang =", value, "prolang");
            return (Criteria) this;
        }

        public Criteria andProlangNotEqualTo(Long value) {
            addCriterion("prolang <>", value, "prolang");
            return (Criteria) this;
        }

        public Criteria andProlangGreaterThan(Long value) {
            addCriterion("prolang >", value, "prolang");
            return (Criteria) this;
        }

        public Criteria andProlangGreaterThanOrEqualTo(Long value) {
            addCriterion("prolang >=", value, "prolang");
            return (Criteria) this;
        }

        public Criteria andProlangLessThan(Long value) {
            addCriterion("prolang <", value, "prolang");
            return (Criteria) this;
        }

        public Criteria andProlangLessThanOrEqualTo(Long value) {
            addCriterion("prolang <=", value, "prolang");
            return (Criteria) this;
        }

        public Criteria andProlangIn(List<Long> values) {
            addCriterion("prolang in", values, "prolang");
            return (Criteria) this;
        }

        public Criteria andProlangNotIn(List<Long> values) {
            addCriterion("prolang not in", values, "prolang");
            return (Criteria) this;
        }

        public Criteria andProlangBetween(Long value1, Long value2) {
            addCriterion("prolang between", value1, value2, "prolang");
            return (Criteria) this;
        }

        public Criteria andProlangNotBetween(Long value1, Long value2) {
            addCriterion("prolang not between", value1, value2, "prolang");
            return (Criteria) this;
        }

        public Criteria andProcostIsNull() {
            addCriterion("procost is null");
            return (Criteria) this;
        }

        public Criteria andProcostIsNotNull() {
            addCriterion("procost is not null");
            return (Criteria) this;
        }

        public Criteria andProcostEqualTo(Float value) {
            addCriterion("procost =", value, "procost");
            return (Criteria) this;
        }

        public Criteria andProcostNotEqualTo(Float value) {
            addCriterion("procost <>", value, "procost");
            return (Criteria) this;
        }

        public Criteria andProcostGreaterThan(Float value) {
            addCriterion("procost >", value, "procost");
            return (Criteria) this;
        }

        public Criteria andProcostGreaterThanOrEqualTo(Float value) {
            addCriterion("procost >=", value, "procost");
            return (Criteria) this;
        }

        public Criteria andProcostLessThan(Float value) {
            addCriterion("procost <", value, "procost");
            return (Criteria) this;
        }

        public Criteria andProcostLessThanOrEqualTo(Float value) {
            addCriterion("procost <=", value, "procost");
            return (Criteria) this;
        }

        public Criteria andProcostIn(List<Float> values) {
            addCriterion("procost in", values, "procost");
            return (Criteria) this;
        }

        public Criteria andProcostNotIn(List<Float> values) {
            addCriterion("procost not in", values, "procost");
            return (Criteria) this;
        }

        public Criteria andProcostBetween(Float value1, Float value2) {
            addCriterion("procost between", value1, value2, "procost");
            return (Criteria) this;
        }

        public Criteria andProcostNotBetween(Float value1, Float value2) {
            addCriterion("procost not between", value1, value2, "procost");
            return (Criteria) this;
        }

        public Criteria andProrowsIsNull() {
            addCriterion("prorows is null");
            return (Criteria) this;
        }

        public Criteria andProrowsIsNotNull() {
            addCriterion("prorows is not null");
            return (Criteria) this;
        }

        public Criteria andProrowsEqualTo(Float value) {
            addCriterion("prorows =", value, "prorows");
            return (Criteria) this;
        }

        public Criteria andProrowsNotEqualTo(Float value) {
            addCriterion("prorows <>", value, "prorows");
            return (Criteria) this;
        }

        public Criteria andProrowsGreaterThan(Float value) {
            addCriterion("prorows >", value, "prorows");
            return (Criteria) this;
        }

        public Criteria andProrowsGreaterThanOrEqualTo(Float value) {
            addCriterion("prorows >=", value, "prorows");
            return (Criteria) this;
        }

        public Criteria andProrowsLessThan(Float value) {
            addCriterion("prorows <", value, "prorows");
            return (Criteria) this;
        }

        public Criteria andProrowsLessThanOrEqualTo(Float value) {
            addCriterion("prorows <=", value, "prorows");
            return (Criteria) this;
        }

        public Criteria andProrowsIn(List<Float> values) {
            addCriterion("prorows in", values, "prorows");
            return (Criteria) this;
        }

        public Criteria andProrowsNotIn(List<Float> values) {
            addCriterion("prorows not in", values, "prorows");
            return (Criteria) this;
        }

        public Criteria andProrowsBetween(Float value1, Float value2) {
            addCriterion("prorows between", value1, value2, "prorows");
            return (Criteria) this;
        }

        public Criteria andProrowsNotBetween(Float value1, Float value2) {
            addCriterion("prorows not between", value1, value2, "prorows");
            return (Criteria) this;
        }

        public Criteria andProvariadicIsNull() {
            addCriterion("provariadic is null");
            return (Criteria) this;
        }

        public Criteria andProvariadicIsNotNull() {
            addCriterion("provariadic is not null");
            return (Criteria) this;
        }

        public Criteria andProvariadicEqualTo(Long value) {
            addCriterion("provariadic =", value, "provariadic");
            return (Criteria) this;
        }

        public Criteria andProvariadicNotEqualTo(Long value) {
            addCriterion("provariadic <>", value, "provariadic");
            return (Criteria) this;
        }

        public Criteria andProvariadicGreaterThan(Long value) {
            addCriterion("provariadic >", value, "provariadic");
            return (Criteria) this;
        }

        public Criteria andProvariadicGreaterThanOrEqualTo(Long value) {
            addCriterion("provariadic >=", value, "provariadic");
            return (Criteria) this;
        }

        public Criteria andProvariadicLessThan(Long value) {
            addCriterion("provariadic <", value, "provariadic");
            return (Criteria) this;
        }

        public Criteria andProvariadicLessThanOrEqualTo(Long value) {
            addCriterion("provariadic <=", value, "provariadic");
            return (Criteria) this;
        }

        public Criteria andProvariadicIn(List<Long> values) {
            addCriterion("provariadic in", values, "provariadic");
            return (Criteria) this;
        }

        public Criteria andProvariadicNotIn(List<Long> values) {
            addCriterion("provariadic not in", values, "provariadic");
            return (Criteria) this;
        }

        public Criteria andProvariadicBetween(Long value1, Long value2) {
            addCriterion("provariadic between", value1, value2, "provariadic");
            return (Criteria) this;
        }

        public Criteria andProvariadicNotBetween(Long value1, Long value2) {
            addCriterion("provariadic not between", value1, value2, "provariadic");
            return (Criteria) this;
        }

        public Criteria andProtransformIsNull() {
            addCriterion("protransform is null");
            return (Criteria) this;
        }

        public Criteria andProtransformIsNotNull() {
            addCriterion("protransform is not null");
            return (Criteria) this;
        }

        public Criteria andProtransformEqualTo(Object value) {
            addCriterion("protransform =", value, "protransform");
            return (Criteria) this;
        }

        public Criteria andProtransformNotEqualTo(Object value) {
            addCriterion("protransform <>", value, "protransform");
            return (Criteria) this;
        }

        public Criteria andProtransformGreaterThan(Object value) {
            addCriterion("protransform >", value, "protransform");
            return (Criteria) this;
        }

        public Criteria andProtransformGreaterThanOrEqualTo(Object value) {
            addCriterion("protransform >=", value, "protransform");
            return (Criteria) this;
        }

        public Criteria andProtransformLessThan(Object value) {
            addCriterion("protransform <", value, "protransform");
            return (Criteria) this;
        }

        public Criteria andProtransformLessThanOrEqualTo(Object value) {
            addCriterion("protransform <=", value, "protransform");
            return (Criteria) this;
        }

        public Criteria andProtransformIn(List<Object> values) {
            addCriterion("protransform in", values, "protransform");
            return (Criteria) this;
        }

        public Criteria andProtransformNotIn(List<Object> values) {
            addCriterion("protransform not in", values, "protransform");
            return (Criteria) this;
        }

        public Criteria andProtransformBetween(Object value1, Object value2) {
            addCriterion("protransform between", value1, value2, "protransform");
            return (Criteria) this;
        }

        public Criteria andProtransformNotBetween(Object value1, Object value2) {
            addCriterion("protransform not between", value1, value2, "protransform");
            return (Criteria) this;
        }

        public Criteria andProisaggIsNull() {
            addCriterion("proisagg is null");
            return (Criteria) this;
        }

        public Criteria andProisaggIsNotNull() {
            addCriterion("proisagg is not null");
            return (Criteria) this;
        }

        public Criteria andProisaggEqualTo(Boolean value) {
            addCriterion("proisagg =", value, "proisagg");
            return (Criteria) this;
        }

        public Criteria andProisaggNotEqualTo(Boolean value) {
            addCriterion("proisagg <>", value, "proisagg");
            return (Criteria) this;
        }

        public Criteria andProisaggGreaterThan(Boolean value) {
            addCriterion("proisagg >", value, "proisagg");
            return (Criteria) this;
        }

        public Criteria andProisaggGreaterThanOrEqualTo(Boolean value) {
            addCriterion("proisagg >=", value, "proisagg");
            return (Criteria) this;
        }

        public Criteria andProisaggLessThan(Boolean value) {
            addCriterion("proisagg <", value, "proisagg");
            return (Criteria) this;
        }

        public Criteria andProisaggLessThanOrEqualTo(Boolean value) {
            addCriterion("proisagg <=", value, "proisagg");
            return (Criteria) this;
        }

        public Criteria andProisaggIn(List<Boolean> values) {
            addCriterion("proisagg in", values, "proisagg");
            return (Criteria) this;
        }

        public Criteria andProisaggNotIn(List<Boolean> values) {
            addCriterion("proisagg not in", values, "proisagg");
            return (Criteria) this;
        }

        public Criteria andProisaggBetween(Boolean value1, Boolean value2) {
            addCriterion("proisagg between", value1, value2, "proisagg");
            return (Criteria) this;
        }

        public Criteria andProisaggNotBetween(Boolean value1, Boolean value2) {
            addCriterion("proisagg not between", value1, value2, "proisagg");
            return (Criteria) this;
        }

        public Criteria andProiswindowIsNull() {
            addCriterion("proiswindow is null");
            return (Criteria) this;
        }

        public Criteria andProiswindowIsNotNull() {
            addCriterion("proiswindow is not null");
            return (Criteria) this;
        }

        public Criteria andProiswindowEqualTo(Boolean value) {
            addCriterion("proiswindow =", value, "proiswindow");
            return (Criteria) this;
        }

        public Criteria andProiswindowNotEqualTo(Boolean value) {
            addCriterion("proiswindow <>", value, "proiswindow");
            return (Criteria) this;
        }

        public Criteria andProiswindowGreaterThan(Boolean value) {
            addCriterion("proiswindow >", value, "proiswindow");
            return (Criteria) this;
        }

        public Criteria andProiswindowGreaterThanOrEqualTo(Boolean value) {
            addCriterion("proiswindow >=", value, "proiswindow");
            return (Criteria) this;
        }

        public Criteria andProiswindowLessThan(Boolean value) {
            addCriterion("proiswindow <", value, "proiswindow");
            return (Criteria) this;
        }

        public Criteria andProiswindowLessThanOrEqualTo(Boolean value) {
            addCriterion("proiswindow <=", value, "proiswindow");
            return (Criteria) this;
        }

        public Criteria andProiswindowIn(List<Boolean> values) {
            addCriterion("proiswindow in", values, "proiswindow");
            return (Criteria) this;
        }

        public Criteria andProiswindowNotIn(List<Boolean> values) {
            addCriterion("proiswindow not in", values, "proiswindow");
            return (Criteria) this;
        }

        public Criteria andProiswindowBetween(Boolean value1, Boolean value2) {
            addCriterion("proiswindow between", value1, value2, "proiswindow");
            return (Criteria) this;
        }

        public Criteria andProiswindowNotBetween(Boolean value1, Boolean value2) {
            addCriterion("proiswindow not between", value1, value2, "proiswindow");
            return (Criteria) this;
        }

        public Criteria andProsecdefIsNull() {
            addCriterion("prosecdef is null");
            return (Criteria) this;
        }

        public Criteria andProsecdefIsNotNull() {
            addCriterion("prosecdef is not null");
            return (Criteria) this;
        }

        public Criteria andProsecdefEqualTo(Boolean value) {
            addCriterion("prosecdef =", value, "prosecdef");
            return (Criteria) this;
        }

        public Criteria andProsecdefNotEqualTo(Boolean value) {
            addCriterion("prosecdef <>", value, "prosecdef");
            return (Criteria) this;
        }

        public Criteria andProsecdefGreaterThan(Boolean value) {
            addCriterion("prosecdef >", value, "prosecdef");
            return (Criteria) this;
        }

        public Criteria andProsecdefGreaterThanOrEqualTo(Boolean value) {
            addCriterion("prosecdef >=", value, "prosecdef");
            return (Criteria) this;
        }

        public Criteria andProsecdefLessThan(Boolean value) {
            addCriterion("prosecdef <", value, "prosecdef");
            return (Criteria) this;
        }

        public Criteria andProsecdefLessThanOrEqualTo(Boolean value) {
            addCriterion("prosecdef <=", value, "prosecdef");
            return (Criteria) this;
        }

        public Criteria andProsecdefIn(List<Boolean> values) {
            addCriterion("prosecdef in", values, "prosecdef");
            return (Criteria) this;
        }

        public Criteria andProsecdefNotIn(List<Boolean> values) {
            addCriterion("prosecdef not in", values, "prosecdef");
            return (Criteria) this;
        }

        public Criteria andProsecdefBetween(Boolean value1, Boolean value2) {
            addCriterion("prosecdef between", value1, value2, "prosecdef");
            return (Criteria) this;
        }

        public Criteria andProsecdefNotBetween(Boolean value1, Boolean value2) {
            addCriterion("prosecdef not between", value1, value2, "prosecdef");
            return (Criteria) this;
        }

        public Criteria andProleakproofIsNull() {
            addCriterion("proleakproof is null");
            return (Criteria) this;
        }

        public Criteria andProleakproofIsNotNull() {
            addCriterion("proleakproof is not null");
            return (Criteria) this;
        }

        public Criteria andProleakproofEqualTo(Boolean value) {
            addCriterion("proleakproof =", value, "proleakproof");
            return (Criteria) this;
        }

        public Criteria andProleakproofNotEqualTo(Boolean value) {
            addCriterion("proleakproof <>", value, "proleakproof");
            return (Criteria) this;
        }

        public Criteria andProleakproofGreaterThan(Boolean value) {
            addCriterion("proleakproof >", value, "proleakproof");
            return (Criteria) this;
        }

        public Criteria andProleakproofGreaterThanOrEqualTo(Boolean value) {
            addCriterion("proleakproof >=", value, "proleakproof");
            return (Criteria) this;
        }

        public Criteria andProleakproofLessThan(Boolean value) {
            addCriterion("proleakproof <", value, "proleakproof");
            return (Criteria) this;
        }

        public Criteria andProleakproofLessThanOrEqualTo(Boolean value) {
            addCriterion("proleakproof <=", value, "proleakproof");
            return (Criteria) this;
        }

        public Criteria andProleakproofIn(List<Boolean> values) {
            addCriterion("proleakproof in", values, "proleakproof");
            return (Criteria) this;
        }

        public Criteria andProleakproofNotIn(List<Boolean> values) {
            addCriterion("proleakproof not in", values, "proleakproof");
            return (Criteria) this;
        }

        public Criteria andProleakproofBetween(Boolean value1, Boolean value2) {
            addCriterion("proleakproof between", value1, value2, "proleakproof");
            return (Criteria) this;
        }

        public Criteria andProleakproofNotBetween(Boolean value1, Boolean value2) {
            addCriterion("proleakproof not between", value1, value2, "proleakproof");
            return (Criteria) this;
        }

        public Criteria andProisstrictIsNull() {
            addCriterion("proisstrict is null");
            return (Criteria) this;
        }

        public Criteria andProisstrictIsNotNull() {
            addCriterion("proisstrict is not null");
            return (Criteria) this;
        }

        public Criteria andProisstrictEqualTo(Boolean value) {
            addCriterion("proisstrict =", value, "proisstrict");
            return (Criteria) this;
        }

        public Criteria andProisstrictNotEqualTo(Boolean value) {
            addCriterion("proisstrict <>", value, "proisstrict");
            return (Criteria) this;
        }

        public Criteria andProisstrictGreaterThan(Boolean value) {
            addCriterion("proisstrict >", value, "proisstrict");
            return (Criteria) this;
        }

        public Criteria andProisstrictGreaterThanOrEqualTo(Boolean value) {
            addCriterion("proisstrict >=", value, "proisstrict");
            return (Criteria) this;
        }

        public Criteria andProisstrictLessThan(Boolean value) {
            addCriterion("proisstrict <", value, "proisstrict");
            return (Criteria) this;
        }

        public Criteria andProisstrictLessThanOrEqualTo(Boolean value) {
            addCriterion("proisstrict <=", value, "proisstrict");
            return (Criteria) this;
        }

        public Criteria andProisstrictIn(List<Boolean> values) {
            addCriterion("proisstrict in", values, "proisstrict");
            return (Criteria) this;
        }

        public Criteria andProisstrictNotIn(List<Boolean> values) {
            addCriterion("proisstrict not in", values, "proisstrict");
            return (Criteria) this;
        }

        public Criteria andProisstrictBetween(Boolean value1, Boolean value2) {
            addCriterion("proisstrict between", value1, value2, "proisstrict");
            return (Criteria) this;
        }

        public Criteria andProisstrictNotBetween(Boolean value1, Boolean value2) {
            addCriterion("proisstrict not between", value1, value2, "proisstrict");
            return (Criteria) this;
        }

        public Criteria andProretsetIsNull() {
            addCriterion("proretset is null");
            return (Criteria) this;
        }

        public Criteria andProretsetIsNotNull() {
            addCriterion("proretset is not null");
            return (Criteria) this;
        }

        public Criteria andProretsetEqualTo(Boolean value) {
            addCriterion("proretset =", value, "proretset");
            return (Criteria) this;
        }

        public Criteria andProretsetNotEqualTo(Boolean value) {
            addCriterion("proretset <>", value, "proretset");
            return (Criteria) this;
        }

        public Criteria andProretsetGreaterThan(Boolean value) {
            addCriterion("proretset >", value, "proretset");
            return (Criteria) this;
        }

        public Criteria andProretsetGreaterThanOrEqualTo(Boolean value) {
            addCriterion("proretset >=", value, "proretset");
            return (Criteria) this;
        }

        public Criteria andProretsetLessThan(Boolean value) {
            addCriterion("proretset <", value, "proretset");
            return (Criteria) this;
        }

        public Criteria andProretsetLessThanOrEqualTo(Boolean value) {
            addCriterion("proretset <=", value, "proretset");
            return (Criteria) this;
        }

        public Criteria andProretsetIn(List<Boolean> values) {
            addCriterion("proretset in", values, "proretset");
            return (Criteria) this;
        }

        public Criteria andProretsetNotIn(List<Boolean> values) {
            addCriterion("proretset not in", values, "proretset");
            return (Criteria) this;
        }

        public Criteria andProretsetBetween(Boolean value1, Boolean value2) {
            addCriterion("proretset between", value1, value2, "proretset");
            return (Criteria) this;
        }

        public Criteria andProretsetNotBetween(Boolean value1, Boolean value2) {
            addCriterion("proretset not between", value1, value2, "proretset");
            return (Criteria) this;
        }

        public Criteria andProvolatileIsNull() {
            addCriterion("provolatile is null");
            return (Criteria) this;
        }

        public Criteria andProvolatileIsNotNull() {
            addCriterion("provolatile is not null");
            return (Criteria) this;
        }

        public Criteria andProvolatileEqualTo(String value) {
            addCriterion("provolatile =", value, "provolatile");
            return (Criteria) this;
        }

        public Criteria andProvolatileNotEqualTo(String value) {
            addCriterion("provolatile <>", value, "provolatile");
            return (Criteria) this;
        }

        public Criteria andProvolatileGreaterThan(String value) {
            addCriterion("provolatile >", value, "provolatile");
            return (Criteria) this;
        }

        public Criteria andProvolatileGreaterThanOrEqualTo(String value) {
            addCriterion("provolatile >=", value, "provolatile");
            return (Criteria) this;
        }

        public Criteria andProvolatileLessThan(String value) {
            addCriterion("provolatile <", value, "provolatile");
            return (Criteria) this;
        }

        public Criteria andProvolatileLessThanOrEqualTo(String value) {
            addCriterion("provolatile <=", value, "provolatile");
            return (Criteria) this;
        }

        public Criteria andProvolatileLike(String value) {
            addCriterion("provolatile like", value, "provolatile");
            return (Criteria) this;
        }

        public Criteria andProvolatileNotLike(String value) {
            addCriterion("provolatile not like", value, "provolatile");
            return (Criteria) this;
        }

        public Criteria andProvolatileIn(List<String> values) {
            addCriterion("provolatile in", values, "provolatile");
            return (Criteria) this;
        }

        public Criteria andProvolatileNotIn(List<String> values) {
            addCriterion("provolatile not in", values, "provolatile");
            return (Criteria) this;
        }

        public Criteria andProvolatileBetween(String value1, String value2) {
            addCriterion("provolatile between", value1, value2, "provolatile");
            return (Criteria) this;
        }

        public Criteria andProvolatileNotBetween(String value1, String value2) {
            addCriterion("provolatile not between", value1, value2, "provolatile");
            return (Criteria) this;
        }

        public Criteria andPronargsIsNull() {
            addCriterion("pronargs is null");
            return (Criteria) this;
        }

        public Criteria andPronargsIsNotNull() {
            addCriterion("pronargs is not null");
            return (Criteria) this;
        }

        public Criteria andPronargsEqualTo(Short value) {
            addCriterion("pronargs =", value, "pronargs");
            return (Criteria) this;
        }

        public Criteria andPronargsNotEqualTo(Short value) {
            addCriterion("pronargs <>", value, "pronargs");
            return (Criteria) this;
        }

        public Criteria andPronargsGreaterThan(Short value) {
            addCriterion("pronargs >", value, "pronargs");
            return (Criteria) this;
        }

        public Criteria andPronargsGreaterThanOrEqualTo(Short value) {
            addCriterion("pronargs >=", value, "pronargs");
            return (Criteria) this;
        }

        public Criteria andPronargsLessThan(Short value) {
            addCriterion("pronargs <", value, "pronargs");
            return (Criteria) this;
        }

        public Criteria andPronargsLessThanOrEqualTo(Short value) {
            addCriterion("pronargs <=", value, "pronargs");
            return (Criteria) this;
        }

        public Criteria andPronargsIn(List<Short> values) {
            addCriterion("pronargs in", values, "pronargs");
            return (Criteria) this;
        }

        public Criteria andPronargsNotIn(List<Short> values) {
            addCriterion("pronargs not in", values, "pronargs");
            return (Criteria) this;
        }

        public Criteria andPronargsBetween(Short value1, Short value2) {
            addCriterion("pronargs between", value1, value2, "pronargs");
            return (Criteria) this;
        }

        public Criteria andPronargsNotBetween(Short value1, Short value2) {
            addCriterion("pronargs not between", value1, value2, "pronargs");
            return (Criteria) this;
        }

        public Criteria andPronargdefaultsIsNull() {
            addCriterion("pronargdefaults is null");
            return (Criteria) this;
        }

        public Criteria andPronargdefaultsIsNotNull() {
            addCriterion("pronargdefaults is not null");
            return (Criteria) this;
        }

        public Criteria andPronargdefaultsEqualTo(Short value) {
            addCriterion("pronargdefaults =", value, "pronargdefaults");
            return (Criteria) this;
        }

        public Criteria andPronargdefaultsNotEqualTo(Short value) {
            addCriterion("pronargdefaults <>", value, "pronargdefaults");
            return (Criteria) this;
        }

        public Criteria andPronargdefaultsGreaterThan(Short value) {
            addCriterion("pronargdefaults >", value, "pronargdefaults");
            return (Criteria) this;
        }

        public Criteria andPronargdefaultsGreaterThanOrEqualTo(Short value) {
            addCriterion("pronargdefaults >=", value, "pronargdefaults");
            return (Criteria) this;
        }

        public Criteria andPronargdefaultsLessThan(Short value) {
            addCriterion("pronargdefaults <", value, "pronargdefaults");
            return (Criteria) this;
        }

        public Criteria andPronargdefaultsLessThanOrEqualTo(Short value) {
            addCriterion("pronargdefaults <=", value, "pronargdefaults");
            return (Criteria) this;
        }

        public Criteria andPronargdefaultsIn(List<Short> values) {
            addCriterion("pronargdefaults in", values, "pronargdefaults");
            return (Criteria) this;
        }

        public Criteria andPronargdefaultsNotIn(List<Short> values) {
            addCriterion("pronargdefaults not in", values, "pronargdefaults");
            return (Criteria) this;
        }

        public Criteria andPronargdefaultsBetween(Short value1, Short value2) {
            addCriterion("pronargdefaults between", value1, value2, "pronargdefaults");
            return (Criteria) this;
        }

        public Criteria andPronargdefaultsNotBetween(Short value1, Short value2) {
            addCriterion("pronargdefaults not between", value1, value2, "pronargdefaults");
            return (Criteria) this;
        }

        public Criteria andProrettypeIsNull() {
            addCriterion("prorettype is null");
            return (Criteria) this;
        }

        public Criteria andProrettypeIsNotNull() {
            addCriterion("prorettype is not null");
            return (Criteria) this;
        }

        public Criteria andProrettypeEqualTo(Long value) {
            addCriterion("prorettype =", value, "prorettype");
            return (Criteria) this;
        }

        public Criteria andProrettypeNotEqualTo(Long value) {
            addCriterion("prorettype <>", value, "prorettype");
            return (Criteria) this;
        }

        public Criteria andProrettypeGreaterThan(Long value) {
            addCriterion("prorettype >", value, "prorettype");
            return (Criteria) this;
        }

        public Criteria andProrettypeGreaterThanOrEqualTo(Long value) {
            addCriterion("prorettype >=", value, "prorettype");
            return (Criteria) this;
        }

        public Criteria andProrettypeLessThan(Long value) {
            addCriterion("prorettype <", value, "prorettype");
            return (Criteria) this;
        }

        public Criteria andProrettypeLessThanOrEqualTo(Long value) {
            addCriterion("prorettype <=", value, "prorettype");
            return (Criteria) this;
        }

        public Criteria andProrettypeIn(List<Long> values) {
            addCriterion("prorettype in", values, "prorettype");
            return (Criteria) this;
        }

        public Criteria andProrettypeNotIn(List<Long> values) {
            addCriterion("prorettype not in", values, "prorettype");
            return (Criteria) this;
        }

        public Criteria andProrettypeBetween(Long value1, Long value2) {
            addCriterion("prorettype between", value1, value2, "prorettype");
            return (Criteria) this;
        }

        public Criteria andProrettypeNotBetween(Long value1, Long value2) {
            addCriterion("prorettype not between", value1, value2, "prorettype");
            return (Criteria) this;
        }

        public Criteria andProargtypesIsNull() {
            addCriterion("proargtypes is null");
            return (Criteria) this;
        }

        public Criteria andProargtypesIsNotNull() {
            addCriterion("proargtypes is not null");
            return (Criteria) this;
        }

        public Criteria andProargtypesEqualTo(Object value) {
            addCriterion("proargtypes =", value, "proargtypes");
            return (Criteria) this;
        }

        public Criteria andProargtypesNotEqualTo(Object value) {
            addCriterion("proargtypes <>", value, "proargtypes");
            return (Criteria) this;
        }

        public Criteria andProargtypesGreaterThan(Object value) {
            addCriterion("proargtypes >", value, "proargtypes");
            return (Criteria) this;
        }

        public Criteria andProargtypesGreaterThanOrEqualTo(Object value) {
            addCriterion("proargtypes >=", value, "proargtypes");
            return (Criteria) this;
        }

        public Criteria andProargtypesLessThan(Object value) {
            addCriterion("proargtypes <", value, "proargtypes");
            return (Criteria) this;
        }

        public Criteria andProargtypesLessThanOrEqualTo(Object value) {
            addCriterion("proargtypes <=", value, "proargtypes");
            return (Criteria) this;
        }

        public Criteria andProargtypesIn(List<Object> values) {
            addCriterion("proargtypes in", values, "proargtypes");
            return (Criteria) this;
        }

        public Criteria andProargtypesNotIn(List<Object> values) {
            addCriterion("proargtypes not in", values, "proargtypes");
            return (Criteria) this;
        }

        public Criteria andProargtypesBetween(Object value1, Object value2) {
            addCriterion("proargtypes between", value1, value2, "proargtypes");
            return (Criteria) this;
        }

        public Criteria andProargtypesNotBetween(Object value1, Object value2) {
            addCriterion("proargtypes not between", value1, value2, "proargtypes");
            return (Criteria) this;
        }

        public Criteria andProallargtypesIsNull() {
            addCriterion("proallargtypes is null");
            return (Criteria) this;
        }

        public Criteria andProallargtypesIsNotNull() {
            addCriterion("proallargtypes is not null");
            return (Criteria) this;
        }

        public Criteria andProallargtypesEqualTo(Object value) {
            addCriterion("proallargtypes =", value, "proallargtypes");
            return (Criteria) this;
        }

        public Criteria andProallargtypesNotEqualTo(Object value) {
            addCriterion("proallargtypes <>", value, "proallargtypes");
            return (Criteria) this;
        }

        public Criteria andProallargtypesGreaterThan(Object value) {
            addCriterion("proallargtypes >", value, "proallargtypes");
            return (Criteria) this;
        }

        public Criteria andProallargtypesGreaterThanOrEqualTo(Object value) {
            addCriterion("proallargtypes >=", value, "proallargtypes");
            return (Criteria) this;
        }

        public Criteria andProallargtypesLessThan(Object value) {
            addCriterion("proallargtypes <", value, "proallargtypes");
            return (Criteria) this;
        }

        public Criteria andProallargtypesLessThanOrEqualTo(Object value) {
            addCriterion("proallargtypes <=", value, "proallargtypes");
            return (Criteria) this;
        }

        public Criteria andProallargtypesIn(List<Object> values) {
            addCriterion("proallargtypes in", values, "proallargtypes");
            return (Criteria) this;
        }

        public Criteria andProallargtypesNotIn(List<Object> values) {
            addCriterion("proallargtypes not in", values, "proallargtypes");
            return (Criteria) this;
        }

        public Criteria andProallargtypesBetween(Object value1, Object value2) {
            addCriterion("proallargtypes between", value1, value2, "proallargtypes");
            return (Criteria) this;
        }

        public Criteria andProallargtypesNotBetween(Object value1, Object value2) {
            addCriterion("proallargtypes not between", value1, value2, "proallargtypes");
            return (Criteria) this;
        }

        public Criteria andProargmodesIsNull() {
            addCriterion("proargmodes is null");
            return (Criteria) this;
        }

        public Criteria andProargmodesIsNotNull() {
            addCriterion("proargmodes is not null");
            return (Criteria) this;
        }

        public Criteria andProargmodesEqualTo(Object value) {
            addCriterion("proargmodes =", value, "proargmodes");
            return (Criteria) this;
        }

        public Criteria andProargmodesNotEqualTo(Object value) {
            addCriterion("proargmodes <>", value, "proargmodes");
            return (Criteria) this;
        }

        public Criteria andProargmodesGreaterThan(Object value) {
            addCriterion("proargmodes >", value, "proargmodes");
            return (Criteria) this;
        }

        public Criteria andProargmodesGreaterThanOrEqualTo(Object value) {
            addCriterion("proargmodes >=", value, "proargmodes");
            return (Criteria) this;
        }

        public Criteria andProargmodesLessThan(Object value) {
            addCriterion("proargmodes <", value, "proargmodes");
            return (Criteria) this;
        }

        public Criteria andProargmodesLessThanOrEqualTo(Object value) {
            addCriterion("proargmodes <=", value, "proargmodes");
            return (Criteria) this;
        }

        public Criteria andProargmodesIn(List<Object> values) {
            addCriterion("proargmodes in", values, "proargmodes");
            return (Criteria) this;
        }

        public Criteria andProargmodesNotIn(List<Object> values) {
            addCriterion("proargmodes not in", values, "proargmodes");
            return (Criteria) this;
        }

        public Criteria andProargmodesBetween(Object value1, Object value2) {
            addCriterion("proargmodes between", value1, value2, "proargmodes");
            return (Criteria) this;
        }

        public Criteria andProargmodesNotBetween(Object value1, Object value2) {
            addCriterion("proargmodes not between", value1, value2, "proargmodes");
            return (Criteria) this;
        }

        public Criteria andProargnamesIsNull() {
            addCriterion("proargnames is null");
            return (Criteria) this;
        }

        public Criteria andProargnamesIsNotNull() {
            addCriterion("proargnames is not null");
            return (Criteria) this;
        }

        public Criteria andProargnamesEqualTo(Object value) {
            addCriterion("proargnames =", value, "proargnames");
            return (Criteria) this;
        }

        public Criteria andProargnamesNotEqualTo(Object value) {
            addCriterion("proargnames <>", value, "proargnames");
            return (Criteria) this;
        }

        public Criteria andProargnamesGreaterThan(Object value) {
            addCriterion("proargnames >", value, "proargnames");
            return (Criteria) this;
        }

        public Criteria andProargnamesGreaterThanOrEqualTo(Object value) {
            addCriterion("proargnames >=", value, "proargnames");
            return (Criteria) this;
        }

        public Criteria andProargnamesLessThan(Object value) {
            addCriterion("proargnames <", value, "proargnames");
            return (Criteria) this;
        }

        public Criteria andProargnamesLessThanOrEqualTo(Object value) {
            addCriterion("proargnames <=", value, "proargnames");
            return (Criteria) this;
        }

        public Criteria andProargnamesIn(List<Object> values) {
            addCriterion("proargnames in", values, "proargnames");
            return (Criteria) this;
        }

        public Criteria andProargnamesNotIn(List<Object> values) {
            addCriterion("proargnames not in", values, "proargnames");
            return (Criteria) this;
        }

        public Criteria andProargnamesBetween(Object value1, Object value2) {
            addCriterion("proargnames between", value1, value2, "proargnames");
            return (Criteria) this;
        }

        public Criteria andProargnamesNotBetween(Object value1, Object value2) {
            addCriterion("proargnames not between", value1, value2, "proargnames");
            return (Criteria) this;
        }

        public Criteria andProargdefaultsIsNull() {
            addCriterion("proargdefaults is null");
            return (Criteria) this;
        }

        public Criteria andProargdefaultsIsNotNull() {
            addCriterion("proargdefaults is not null");
            return (Criteria) this;
        }

        public Criteria andProargdefaultsEqualTo(Object value) {
            addCriterion("proargdefaults =", value, "proargdefaults");
            return (Criteria) this;
        }

        public Criteria andProargdefaultsNotEqualTo(Object value) {
            addCriterion("proargdefaults <>", value, "proargdefaults");
            return (Criteria) this;
        }

        public Criteria andProargdefaultsGreaterThan(Object value) {
            addCriterion("proargdefaults >", value, "proargdefaults");
            return (Criteria) this;
        }

        public Criteria andProargdefaultsGreaterThanOrEqualTo(Object value) {
            addCriterion("proargdefaults >=", value, "proargdefaults");
            return (Criteria) this;
        }

        public Criteria andProargdefaultsLessThan(Object value) {
            addCriterion("proargdefaults <", value, "proargdefaults");
            return (Criteria) this;
        }

        public Criteria andProargdefaultsLessThanOrEqualTo(Object value) {
            addCriterion("proargdefaults <=", value, "proargdefaults");
            return (Criteria) this;
        }

        public Criteria andProargdefaultsIn(List<Object> values) {
            addCriterion("proargdefaults in", values, "proargdefaults");
            return (Criteria) this;
        }

        public Criteria andProargdefaultsNotIn(List<Object> values) {
            addCriterion("proargdefaults not in", values, "proargdefaults");
            return (Criteria) this;
        }

        public Criteria andProargdefaultsBetween(Object value1, Object value2) {
            addCriterion("proargdefaults between", value1, value2, "proargdefaults");
            return (Criteria) this;
        }

        public Criteria andProargdefaultsNotBetween(Object value1, Object value2) {
            addCriterion("proargdefaults not between", value1, value2, "proargdefaults");
            return (Criteria) this;
        }

        public Criteria andProsrcIsNull() {
            addCriterion("prosrc is null");
            return (Criteria) this;
        }

        public Criteria andProsrcIsNotNull() {
            addCriterion("prosrc is not null");
            return (Criteria) this;
        }

        public Criteria andProsrcEqualTo(String value) {
            addCriterion("prosrc =", value, "prosrc");
            return (Criteria) this;
        }

        public Criteria andProsrcNotEqualTo(String value) {
            addCriterion("prosrc <>", value, "prosrc");
            return (Criteria) this;
        }

        public Criteria andProsrcGreaterThan(String value) {
            addCriterion("prosrc >", value, "prosrc");
            return (Criteria) this;
        }

        public Criteria andProsrcGreaterThanOrEqualTo(String value) {
            addCriterion("prosrc >=", value, "prosrc");
            return (Criteria) this;
        }

        public Criteria andProsrcLessThan(String value) {
            addCriterion("prosrc <", value, "prosrc");
            return (Criteria) this;
        }

        public Criteria andProsrcLessThanOrEqualTo(String value) {
            addCriterion("prosrc <=", value, "prosrc");
            return (Criteria) this;
        }

        public Criteria andProsrcLike(String value) {
            addCriterion("prosrc like", value, "prosrc");
            return (Criteria) this;
        }

        public Criteria andProsrcNotLike(String value) {
            addCriterion("prosrc not like", value, "prosrc");
            return (Criteria) this;
        }

        public Criteria andProsrcIn(List<String> values) {
            addCriterion("prosrc in", values, "prosrc");
            return (Criteria) this;
        }

        public Criteria andProsrcNotIn(List<String> values) {
            addCriterion("prosrc not in", values, "prosrc");
            return (Criteria) this;
        }

        public Criteria andProsrcBetween(String value1, String value2) {
            addCriterion("prosrc between", value1, value2, "prosrc");
            return (Criteria) this;
        }

        public Criteria andProsrcNotBetween(String value1, String value2) {
            addCriterion("prosrc not between", value1, value2, "prosrc");
            return (Criteria) this;
        }

        public Criteria andProbinIsNull() {
            addCriterion("probin is null");
            return (Criteria) this;
        }

        public Criteria andProbinIsNotNull() {
            addCriterion("probin is not null");
            return (Criteria) this;
        }

        public Criteria andProbinEqualTo(String value) {
            addCriterion("probin =", value, "probin");
            return (Criteria) this;
        }

        public Criteria andProbinNotEqualTo(String value) {
            addCriterion("probin <>", value, "probin");
            return (Criteria) this;
        }

        public Criteria andProbinGreaterThan(String value) {
            addCriterion("probin >", value, "probin");
            return (Criteria) this;
        }

        public Criteria andProbinGreaterThanOrEqualTo(String value) {
            addCriterion("probin >=", value, "probin");
            return (Criteria) this;
        }

        public Criteria andProbinLessThan(String value) {
            addCriterion("probin <", value, "probin");
            return (Criteria) this;
        }

        public Criteria andProbinLessThanOrEqualTo(String value) {
            addCriterion("probin <=", value, "probin");
            return (Criteria) this;
        }

        public Criteria andProbinLike(String value) {
            addCriterion("probin like", value, "probin");
            return (Criteria) this;
        }

        public Criteria andProbinNotLike(String value) {
            addCriterion("probin not like", value, "probin");
            return (Criteria) this;
        }

        public Criteria andProbinIn(List<String> values) {
            addCriterion("probin in", values, "probin");
            return (Criteria) this;
        }

        public Criteria andProbinNotIn(List<String> values) {
            addCriterion("probin not in", values, "probin");
            return (Criteria) this;
        }

        public Criteria andProbinBetween(String value1, String value2) {
            addCriterion("probin between", value1, value2, "probin");
            return (Criteria) this;
        }

        public Criteria andProbinNotBetween(String value1, String value2) {
            addCriterion("probin not between", value1, value2, "probin");
            return (Criteria) this;
        }

        public Criteria andProconfigIsNull() {
            addCriterion("proconfig is null");
            return (Criteria) this;
        }

        public Criteria andProconfigIsNotNull() {
            addCriterion("proconfig is not null");
            return (Criteria) this;
        }

        public Criteria andProconfigEqualTo(Object value) {
            addCriterion("proconfig =", value, "proconfig");
            return (Criteria) this;
        }

        public Criteria andProconfigNotEqualTo(Object value) {
            addCriterion("proconfig <>", value, "proconfig");
            return (Criteria) this;
        }

        public Criteria andProconfigGreaterThan(Object value) {
            addCriterion("proconfig >", value, "proconfig");
            return (Criteria) this;
        }

        public Criteria andProconfigGreaterThanOrEqualTo(Object value) {
            addCriterion("proconfig >=", value, "proconfig");
            return (Criteria) this;
        }

        public Criteria andProconfigLessThan(Object value) {
            addCriterion("proconfig <", value, "proconfig");
            return (Criteria) this;
        }

        public Criteria andProconfigLessThanOrEqualTo(Object value) {
            addCriterion("proconfig <=", value, "proconfig");
            return (Criteria) this;
        }

        public Criteria andProconfigIn(List<Object> values) {
            addCriterion("proconfig in", values, "proconfig");
            return (Criteria) this;
        }

        public Criteria andProconfigNotIn(List<Object> values) {
            addCriterion("proconfig not in", values, "proconfig");
            return (Criteria) this;
        }

        public Criteria andProconfigBetween(Object value1, Object value2) {
            addCriterion("proconfig between", value1, value2, "proconfig");
            return (Criteria) this;
        }

        public Criteria andProconfigNotBetween(Object value1, Object value2) {
            addCriterion("proconfig not between", value1, value2, "proconfig");
            return (Criteria) this;
        }

        public Criteria andProaclIsNull() {
            addCriterion("proacl is null");
            return (Criteria) this;
        }

        public Criteria andProaclIsNotNull() {
            addCriterion("proacl is not null");
            return (Criteria) this;
        }

        public Criteria andProaclEqualTo(Object value) {
            addCriterion("proacl =", value, "proacl");
            return (Criteria) this;
        }

        public Criteria andProaclNotEqualTo(Object value) {
            addCriterion("proacl <>", value, "proacl");
            return (Criteria) this;
        }

        public Criteria andProaclGreaterThan(Object value) {
            addCriterion("proacl >", value, "proacl");
            return (Criteria) this;
        }

        public Criteria andProaclGreaterThanOrEqualTo(Object value) {
            addCriterion("proacl >=", value, "proacl");
            return (Criteria) this;
        }

        public Criteria andProaclLessThan(Object value) {
            addCriterion("proacl <", value, "proacl");
            return (Criteria) this;
        }

        public Criteria andProaclLessThanOrEqualTo(Object value) {
            addCriterion("proacl <=", value, "proacl");
            return (Criteria) this;
        }

        public Criteria andProaclIn(List<Object> values) {
            addCriterion("proacl in", values, "proacl");
            return (Criteria) this;
        }

        public Criteria andProaclNotIn(List<Object> values) {
            addCriterion("proacl not in", values, "proacl");
            return (Criteria) this;
        }

        public Criteria andProaclBetween(Object value1, Object value2) {
            addCriterion("proacl between", value1, value2, "proacl");
            return (Criteria) this;
        }

        public Criteria andProaclNotBetween(Object value1, Object value2) {
            addCriterion("proacl not between", value1, value2, "proacl");
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