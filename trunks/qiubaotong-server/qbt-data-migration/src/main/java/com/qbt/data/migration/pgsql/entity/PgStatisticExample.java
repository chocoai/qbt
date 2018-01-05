package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgStatisticExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgStatisticExample() {
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

        public Criteria andStarelidIsNull() {
            addCriterion("starelid is null");
            return (Criteria) this;
        }

        public Criteria andStarelidIsNotNull() {
            addCriterion("starelid is not null");
            return (Criteria) this;
        }

        public Criteria andStarelidEqualTo(Long value) {
            addCriterion("starelid =", value, "starelid");
            return (Criteria) this;
        }

        public Criteria andStarelidNotEqualTo(Long value) {
            addCriterion("starelid <>", value, "starelid");
            return (Criteria) this;
        }

        public Criteria andStarelidGreaterThan(Long value) {
            addCriterion("starelid >", value, "starelid");
            return (Criteria) this;
        }

        public Criteria andStarelidGreaterThanOrEqualTo(Long value) {
            addCriterion("starelid >=", value, "starelid");
            return (Criteria) this;
        }

        public Criteria andStarelidLessThan(Long value) {
            addCriterion("starelid <", value, "starelid");
            return (Criteria) this;
        }

        public Criteria andStarelidLessThanOrEqualTo(Long value) {
            addCriterion("starelid <=", value, "starelid");
            return (Criteria) this;
        }

        public Criteria andStarelidIn(List<Long> values) {
            addCriterion("starelid in", values, "starelid");
            return (Criteria) this;
        }

        public Criteria andStarelidNotIn(List<Long> values) {
            addCriterion("starelid not in", values, "starelid");
            return (Criteria) this;
        }

        public Criteria andStarelidBetween(Long value1, Long value2) {
            addCriterion("starelid between", value1, value2, "starelid");
            return (Criteria) this;
        }

        public Criteria andStarelidNotBetween(Long value1, Long value2) {
            addCriterion("starelid not between", value1, value2, "starelid");
            return (Criteria) this;
        }

        public Criteria andStaattnumIsNull() {
            addCriterion("staattnum is null");
            return (Criteria) this;
        }

        public Criteria andStaattnumIsNotNull() {
            addCriterion("staattnum is not null");
            return (Criteria) this;
        }

        public Criteria andStaattnumEqualTo(Short value) {
            addCriterion("staattnum =", value, "staattnum");
            return (Criteria) this;
        }

        public Criteria andStaattnumNotEqualTo(Short value) {
            addCriterion("staattnum <>", value, "staattnum");
            return (Criteria) this;
        }

        public Criteria andStaattnumGreaterThan(Short value) {
            addCriterion("staattnum >", value, "staattnum");
            return (Criteria) this;
        }

        public Criteria andStaattnumGreaterThanOrEqualTo(Short value) {
            addCriterion("staattnum >=", value, "staattnum");
            return (Criteria) this;
        }

        public Criteria andStaattnumLessThan(Short value) {
            addCriterion("staattnum <", value, "staattnum");
            return (Criteria) this;
        }

        public Criteria andStaattnumLessThanOrEqualTo(Short value) {
            addCriterion("staattnum <=", value, "staattnum");
            return (Criteria) this;
        }

        public Criteria andStaattnumIn(List<Short> values) {
            addCriterion("staattnum in", values, "staattnum");
            return (Criteria) this;
        }

        public Criteria andStaattnumNotIn(List<Short> values) {
            addCriterion("staattnum not in", values, "staattnum");
            return (Criteria) this;
        }

        public Criteria andStaattnumBetween(Short value1, Short value2) {
            addCriterion("staattnum between", value1, value2, "staattnum");
            return (Criteria) this;
        }

        public Criteria andStaattnumNotBetween(Short value1, Short value2) {
            addCriterion("staattnum not between", value1, value2, "staattnum");
            return (Criteria) this;
        }

        public Criteria andStainheritIsNull() {
            addCriterion("stainherit is null");
            return (Criteria) this;
        }

        public Criteria andStainheritIsNotNull() {
            addCriterion("stainherit is not null");
            return (Criteria) this;
        }

        public Criteria andStainheritEqualTo(Boolean value) {
            addCriterion("stainherit =", value, "stainherit");
            return (Criteria) this;
        }

        public Criteria andStainheritNotEqualTo(Boolean value) {
            addCriterion("stainherit <>", value, "stainherit");
            return (Criteria) this;
        }

        public Criteria andStainheritGreaterThan(Boolean value) {
            addCriterion("stainherit >", value, "stainherit");
            return (Criteria) this;
        }

        public Criteria andStainheritGreaterThanOrEqualTo(Boolean value) {
            addCriterion("stainherit >=", value, "stainherit");
            return (Criteria) this;
        }

        public Criteria andStainheritLessThan(Boolean value) {
            addCriterion("stainherit <", value, "stainherit");
            return (Criteria) this;
        }

        public Criteria andStainheritLessThanOrEqualTo(Boolean value) {
            addCriterion("stainherit <=", value, "stainherit");
            return (Criteria) this;
        }

        public Criteria andStainheritIn(List<Boolean> values) {
            addCriterion("stainherit in", values, "stainherit");
            return (Criteria) this;
        }

        public Criteria andStainheritNotIn(List<Boolean> values) {
            addCriterion("stainherit not in", values, "stainherit");
            return (Criteria) this;
        }

        public Criteria andStainheritBetween(Boolean value1, Boolean value2) {
            addCriterion("stainherit between", value1, value2, "stainherit");
            return (Criteria) this;
        }

        public Criteria andStainheritNotBetween(Boolean value1, Boolean value2) {
            addCriterion("stainherit not between", value1, value2, "stainherit");
            return (Criteria) this;
        }

        public Criteria andStanullfracIsNull() {
            addCriterion("stanullfrac is null");
            return (Criteria) this;
        }

        public Criteria andStanullfracIsNotNull() {
            addCriterion("stanullfrac is not null");
            return (Criteria) this;
        }

        public Criteria andStanullfracEqualTo(Float value) {
            addCriterion("stanullfrac =", value, "stanullfrac");
            return (Criteria) this;
        }

        public Criteria andStanullfracNotEqualTo(Float value) {
            addCriterion("stanullfrac <>", value, "stanullfrac");
            return (Criteria) this;
        }

        public Criteria andStanullfracGreaterThan(Float value) {
            addCriterion("stanullfrac >", value, "stanullfrac");
            return (Criteria) this;
        }

        public Criteria andStanullfracGreaterThanOrEqualTo(Float value) {
            addCriterion("stanullfrac >=", value, "stanullfrac");
            return (Criteria) this;
        }

        public Criteria andStanullfracLessThan(Float value) {
            addCriterion("stanullfrac <", value, "stanullfrac");
            return (Criteria) this;
        }

        public Criteria andStanullfracLessThanOrEqualTo(Float value) {
            addCriterion("stanullfrac <=", value, "stanullfrac");
            return (Criteria) this;
        }

        public Criteria andStanullfracIn(List<Float> values) {
            addCriterion("stanullfrac in", values, "stanullfrac");
            return (Criteria) this;
        }

        public Criteria andStanullfracNotIn(List<Float> values) {
            addCriterion("stanullfrac not in", values, "stanullfrac");
            return (Criteria) this;
        }

        public Criteria andStanullfracBetween(Float value1, Float value2) {
            addCriterion("stanullfrac between", value1, value2, "stanullfrac");
            return (Criteria) this;
        }

        public Criteria andStanullfracNotBetween(Float value1, Float value2) {
            addCriterion("stanullfrac not between", value1, value2, "stanullfrac");
            return (Criteria) this;
        }

        public Criteria andStawidthIsNull() {
            addCriterion("stawidth is null");
            return (Criteria) this;
        }

        public Criteria andStawidthIsNotNull() {
            addCriterion("stawidth is not null");
            return (Criteria) this;
        }

        public Criteria andStawidthEqualTo(Integer value) {
            addCriterion("stawidth =", value, "stawidth");
            return (Criteria) this;
        }

        public Criteria andStawidthNotEqualTo(Integer value) {
            addCriterion("stawidth <>", value, "stawidth");
            return (Criteria) this;
        }

        public Criteria andStawidthGreaterThan(Integer value) {
            addCriterion("stawidth >", value, "stawidth");
            return (Criteria) this;
        }

        public Criteria andStawidthGreaterThanOrEqualTo(Integer value) {
            addCriterion("stawidth >=", value, "stawidth");
            return (Criteria) this;
        }

        public Criteria andStawidthLessThan(Integer value) {
            addCriterion("stawidth <", value, "stawidth");
            return (Criteria) this;
        }

        public Criteria andStawidthLessThanOrEqualTo(Integer value) {
            addCriterion("stawidth <=", value, "stawidth");
            return (Criteria) this;
        }

        public Criteria andStawidthIn(List<Integer> values) {
            addCriterion("stawidth in", values, "stawidth");
            return (Criteria) this;
        }

        public Criteria andStawidthNotIn(List<Integer> values) {
            addCriterion("stawidth not in", values, "stawidth");
            return (Criteria) this;
        }

        public Criteria andStawidthBetween(Integer value1, Integer value2) {
            addCriterion("stawidth between", value1, value2, "stawidth");
            return (Criteria) this;
        }

        public Criteria andStawidthNotBetween(Integer value1, Integer value2) {
            addCriterion("stawidth not between", value1, value2, "stawidth");
            return (Criteria) this;
        }

        public Criteria andStadistinctIsNull() {
            addCriterion("stadistinct is null");
            return (Criteria) this;
        }

        public Criteria andStadistinctIsNotNull() {
            addCriterion("stadistinct is not null");
            return (Criteria) this;
        }

        public Criteria andStadistinctEqualTo(Float value) {
            addCriterion("stadistinct =", value, "stadistinct");
            return (Criteria) this;
        }

        public Criteria andStadistinctNotEqualTo(Float value) {
            addCriterion("stadistinct <>", value, "stadistinct");
            return (Criteria) this;
        }

        public Criteria andStadistinctGreaterThan(Float value) {
            addCriterion("stadistinct >", value, "stadistinct");
            return (Criteria) this;
        }

        public Criteria andStadistinctGreaterThanOrEqualTo(Float value) {
            addCriterion("stadistinct >=", value, "stadistinct");
            return (Criteria) this;
        }

        public Criteria andStadistinctLessThan(Float value) {
            addCriterion("stadistinct <", value, "stadistinct");
            return (Criteria) this;
        }

        public Criteria andStadistinctLessThanOrEqualTo(Float value) {
            addCriterion("stadistinct <=", value, "stadistinct");
            return (Criteria) this;
        }

        public Criteria andStadistinctIn(List<Float> values) {
            addCriterion("stadistinct in", values, "stadistinct");
            return (Criteria) this;
        }

        public Criteria andStadistinctNotIn(List<Float> values) {
            addCriterion("stadistinct not in", values, "stadistinct");
            return (Criteria) this;
        }

        public Criteria andStadistinctBetween(Float value1, Float value2) {
            addCriterion("stadistinct between", value1, value2, "stadistinct");
            return (Criteria) this;
        }

        public Criteria andStadistinctNotBetween(Float value1, Float value2) {
            addCriterion("stadistinct not between", value1, value2, "stadistinct");
            return (Criteria) this;
        }

        public Criteria andStakind1IsNull() {
            addCriterion("stakind1 is null");
            return (Criteria) this;
        }

        public Criteria andStakind1IsNotNull() {
            addCriterion("stakind1 is not null");
            return (Criteria) this;
        }

        public Criteria andStakind1EqualTo(Short value) {
            addCriterion("stakind1 =", value, "stakind1");
            return (Criteria) this;
        }

        public Criteria andStakind1NotEqualTo(Short value) {
            addCriterion("stakind1 <>", value, "stakind1");
            return (Criteria) this;
        }

        public Criteria andStakind1GreaterThan(Short value) {
            addCriterion("stakind1 >", value, "stakind1");
            return (Criteria) this;
        }

        public Criteria andStakind1GreaterThanOrEqualTo(Short value) {
            addCriterion("stakind1 >=", value, "stakind1");
            return (Criteria) this;
        }

        public Criteria andStakind1LessThan(Short value) {
            addCriterion("stakind1 <", value, "stakind1");
            return (Criteria) this;
        }

        public Criteria andStakind1LessThanOrEqualTo(Short value) {
            addCriterion("stakind1 <=", value, "stakind1");
            return (Criteria) this;
        }

        public Criteria andStakind1In(List<Short> values) {
            addCriterion("stakind1 in", values, "stakind1");
            return (Criteria) this;
        }

        public Criteria andStakind1NotIn(List<Short> values) {
            addCriterion("stakind1 not in", values, "stakind1");
            return (Criteria) this;
        }

        public Criteria andStakind1Between(Short value1, Short value2) {
            addCriterion("stakind1 between", value1, value2, "stakind1");
            return (Criteria) this;
        }

        public Criteria andStakind1NotBetween(Short value1, Short value2) {
            addCriterion("stakind1 not between", value1, value2, "stakind1");
            return (Criteria) this;
        }

        public Criteria andStakind2IsNull() {
            addCriterion("stakind2 is null");
            return (Criteria) this;
        }

        public Criteria andStakind2IsNotNull() {
            addCriterion("stakind2 is not null");
            return (Criteria) this;
        }

        public Criteria andStakind2EqualTo(Short value) {
            addCriterion("stakind2 =", value, "stakind2");
            return (Criteria) this;
        }

        public Criteria andStakind2NotEqualTo(Short value) {
            addCriterion("stakind2 <>", value, "stakind2");
            return (Criteria) this;
        }

        public Criteria andStakind2GreaterThan(Short value) {
            addCriterion("stakind2 >", value, "stakind2");
            return (Criteria) this;
        }

        public Criteria andStakind2GreaterThanOrEqualTo(Short value) {
            addCriterion("stakind2 >=", value, "stakind2");
            return (Criteria) this;
        }

        public Criteria andStakind2LessThan(Short value) {
            addCriterion("stakind2 <", value, "stakind2");
            return (Criteria) this;
        }

        public Criteria andStakind2LessThanOrEqualTo(Short value) {
            addCriterion("stakind2 <=", value, "stakind2");
            return (Criteria) this;
        }

        public Criteria andStakind2In(List<Short> values) {
            addCriterion("stakind2 in", values, "stakind2");
            return (Criteria) this;
        }

        public Criteria andStakind2NotIn(List<Short> values) {
            addCriterion("stakind2 not in", values, "stakind2");
            return (Criteria) this;
        }

        public Criteria andStakind2Between(Short value1, Short value2) {
            addCriterion("stakind2 between", value1, value2, "stakind2");
            return (Criteria) this;
        }

        public Criteria andStakind2NotBetween(Short value1, Short value2) {
            addCriterion("stakind2 not between", value1, value2, "stakind2");
            return (Criteria) this;
        }

        public Criteria andStakind3IsNull() {
            addCriterion("stakind3 is null");
            return (Criteria) this;
        }

        public Criteria andStakind3IsNotNull() {
            addCriterion("stakind3 is not null");
            return (Criteria) this;
        }

        public Criteria andStakind3EqualTo(Short value) {
            addCriterion("stakind3 =", value, "stakind3");
            return (Criteria) this;
        }

        public Criteria andStakind3NotEqualTo(Short value) {
            addCriterion("stakind3 <>", value, "stakind3");
            return (Criteria) this;
        }

        public Criteria andStakind3GreaterThan(Short value) {
            addCriterion("stakind3 >", value, "stakind3");
            return (Criteria) this;
        }

        public Criteria andStakind3GreaterThanOrEqualTo(Short value) {
            addCriterion("stakind3 >=", value, "stakind3");
            return (Criteria) this;
        }

        public Criteria andStakind3LessThan(Short value) {
            addCriterion("stakind3 <", value, "stakind3");
            return (Criteria) this;
        }

        public Criteria andStakind3LessThanOrEqualTo(Short value) {
            addCriterion("stakind3 <=", value, "stakind3");
            return (Criteria) this;
        }

        public Criteria andStakind3In(List<Short> values) {
            addCriterion("stakind3 in", values, "stakind3");
            return (Criteria) this;
        }

        public Criteria andStakind3NotIn(List<Short> values) {
            addCriterion("stakind3 not in", values, "stakind3");
            return (Criteria) this;
        }

        public Criteria andStakind3Between(Short value1, Short value2) {
            addCriterion("stakind3 between", value1, value2, "stakind3");
            return (Criteria) this;
        }

        public Criteria andStakind3NotBetween(Short value1, Short value2) {
            addCriterion("stakind3 not between", value1, value2, "stakind3");
            return (Criteria) this;
        }

        public Criteria andStakind4IsNull() {
            addCriterion("stakind4 is null");
            return (Criteria) this;
        }

        public Criteria andStakind4IsNotNull() {
            addCriterion("stakind4 is not null");
            return (Criteria) this;
        }

        public Criteria andStakind4EqualTo(Short value) {
            addCriterion("stakind4 =", value, "stakind4");
            return (Criteria) this;
        }

        public Criteria andStakind4NotEqualTo(Short value) {
            addCriterion("stakind4 <>", value, "stakind4");
            return (Criteria) this;
        }

        public Criteria andStakind4GreaterThan(Short value) {
            addCriterion("stakind4 >", value, "stakind4");
            return (Criteria) this;
        }

        public Criteria andStakind4GreaterThanOrEqualTo(Short value) {
            addCriterion("stakind4 >=", value, "stakind4");
            return (Criteria) this;
        }

        public Criteria andStakind4LessThan(Short value) {
            addCriterion("stakind4 <", value, "stakind4");
            return (Criteria) this;
        }

        public Criteria andStakind4LessThanOrEqualTo(Short value) {
            addCriterion("stakind4 <=", value, "stakind4");
            return (Criteria) this;
        }

        public Criteria andStakind4In(List<Short> values) {
            addCriterion("stakind4 in", values, "stakind4");
            return (Criteria) this;
        }

        public Criteria andStakind4NotIn(List<Short> values) {
            addCriterion("stakind4 not in", values, "stakind4");
            return (Criteria) this;
        }

        public Criteria andStakind4Between(Short value1, Short value2) {
            addCriterion("stakind4 between", value1, value2, "stakind4");
            return (Criteria) this;
        }

        public Criteria andStakind4NotBetween(Short value1, Short value2) {
            addCriterion("stakind4 not between", value1, value2, "stakind4");
            return (Criteria) this;
        }

        public Criteria andStakind5IsNull() {
            addCriterion("stakind5 is null");
            return (Criteria) this;
        }

        public Criteria andStakind5IsNotNull() {
            addCriterion("stakind5 is not null");
            return (Criteria) this;
        }

        public Criteria andStakind5EqualTo(Short value) {
            addCriterion("stakind5 =", value, "stakind5");
            return (Criteria) this;
        }

        public Criteria andStakind5NotEqualTo(Short value) {
            addCriterion("stakind5 <>", value, "stakind5");
            return (Criteria) this;
        }

        public Criteria andStakind5GreaterThan(Short value) {
            addCriterion("stakind5 >", value, "stakind5");
            return (Criteria) this;
        }

        public Criteria andStakind5GreaterThanOrEqualTo(Short value) {
            addCriterion("stakind5 >=", value, "stakind5");
            return (Criteria) this;
        }

        public Criteria andStakind5LessThan(Short value) {
            addCriterion("stakind5 <", value, "stakind5");
            return (Criteria) this;
        }

        public Criteria andStakind5LessThanOrEqualTo(Short value) {
            addCriterion("stakind5 <=", value, "stakind5");
            return (Criteria) this;
        }

        public Criteria andStakind5In(List<Short> values) {
            addCriterion("stakind5 in", values, "stakind5");
            return (Criteria) this;
        }

        public Criteria andStakind5NotIn(List<Short> values) {
            addCriterion("stakind5 not in", values, "stakind5");
            return (Criteria) this;
        }

        public Criteria andStakind5Between(Short value1, Short value2) {
            addCriterion("stakind5 between", value1, value2, "stakind5");
            return (Criteria) this;
        }

        public Criteria andStakind5NotBetween(Short value1, Short value2) {
            addCriterion("stakind5 not between", value1, value2, "stakind5");
            return (Criteria) this;
        }

        public Criteria andStaop1IsNull() {
            addCriterion("staop1 is null");
            return (Criteria) this;
        }

        public Criteria andStaop1IsNotNull() {
            addCriterion("staop1 is not null");
            return (Criteria) this;
        }

        public Criteria andStaop1EqualTo(Long value) {
            addCriterion("staop1 =", value, "staop1");
            return (Criteria) this;
        }

        public Criteria andStaop1NotEqualTo(Long value) {
            addCriterion("staop1 <>", value, "staop1");
            return (Criteria) this;
        }

        public Criteria andStaop1GreaterThan(Long value) {
            addCriterion("staop1 >", value, "staop1");
            return (Criteria) this;
        }

        public Criteria andStaop1GreaterThanOrEqualTo(Long value) {
            addCriterion("staop1 >=", value, "staop1");
            return (Criteria) this;
        }

        public Criteria andStaop1LessThan(Long value) {
            addCriterion("staop1 <", value, "staop1");
            return (Criteria) this;
        }

        public Criteria andStaop1LessThanOrEqualTo(Long value) {
            addCriterion("staop1 <=", value, "staop1");
            return (Criteria) this;
        }

        public Criteria andStaop1In(List<Long> values) {
            addCriterion("staop1 in", values, "staop1");
            return (Criteria) this;
        }

        public Criteria andStaop1NotIn(List<Long> values) {
            addCriterion("staop1 not in", values, "staop1");
            return (Criteria) this;
        }

        public Criteria andStaop1Between(Long value1, Long value2) {
            addCriterion("staop1 between", value1, value2, "staop1");
            return (Criteria) this;
        }

        public Criteria andStaop1NotBetween(Long value1, Long value2) {
            addCriterion("staop1 not between", value1, value2, "staop1");
            return (Criteria) this;
        }

        public Criteria andStaop2IsNull() {
            addCriterion("staop2 is null");
            return (Criteria) this;
        }

        public Criteria andStaop2IsNotNull() {
            addCriterion("staop2 is not null");
            return (Criteria) this;
        }

        public Criteria andStaop2EqualTo(Long value) {
            addCriterion("staop2 =", value, "staop2");
            return (Criteria) this;
        }

        public Criteria andStaop2NotEqualTo(Long value) {
            addCriterion("staop2 <>", value, "staop2");
            return (Criteria) this;
        }

        public Criteria andStaop2GreaterThan(Long value) {
            addCriterion("staop2 >", value, "staop2");
            return (Criteria) this;
        }

        public Criteria andStaop2GreaterThanOrEqualTo(Long value) {
            addCriterion("staop2 >=", value, "staop2");
            return (Criteria) this;
        }

        public Criteria andStaop2LessThan(Long value) {
            addCriterion("staop2 <", value, "staop2");
            return (Criteria) this;
        }

        public Criteria andStaop2LessThanOrEqualTo(Long value) {
            addCriterion("staop2 <=", value, "staop2");
            return (Criteria) this;
        }

        public Criteria andStaop2In(List<Long> values) {
            addCriterion("staop2 in", values, "staop2");
            return (Criteria) this;
        }

        public Criteria andStaop2NotIn(List<Long> values) {
            addCriterion("staop2 not in", values, "staop2");
            return (Criteria) this;
        }

        public Criteria andStaop2Between(Long value1, Long value2) {
            addCriterion("staop2 between", value1, value2, "staop2");
            return (Criteria) this;
        }

        public Criteria andStaop2NotBetween(Long value1, Long value2) {
            addCriterion("staop2 not between", value1, value2, "staop2");
            return (Criteria) this;
        }

        public Criteria andStaop3IsNull() {
            addCriterion("staop3 is null");
            return (Criteria) this;
        }

        public Criteria andStaop3IsNotNull() {
            addCriterion("staop3 is not null");
            return (Criteria) this;
        }

        public Criteria andStaop3EqualTo(Long value) {
            addCriterion("staop3 =", value, "staop3");
            return (Criteria) this;
        }

        public Criteria andStaop3NotEqualTo(Long value) {
            addCriterion("staop3 <>", value, "staop3");
            return (Criteria) this;
        }

        public Criteria andStaop3GreaterThan(Long value) {
            addCriterion("staop3 >", value, "staop3");
            return (Criteria) this;
        }

        public Criteria andStaop3GreaterThanOrEqualTo(Long value) {
            addCriterion("staop3 >=", value, "staop3");
            return (Criteria) this;
        }

        public Criteria andStaop3LessThan(Long value) {
            addCriterion("staop3 <", value, "staop3");
            return (Criteria) this;
        }

        public Criteria andStaop3LessThanOrEqualTo(Long value) {
            addCriterion("staop3 <=", value, "staop3");
            return (Criteria) this;
        }

        public Criteria andStaop3In(List<Long> values) {
            addCriterion("staop3 in", values, "staop3");
            return (Criteria) this;
        }

        public Criteria andStaop3NotIn(List<Long> values) {
            addCriterion("staop3 not in", values, "staop3");
            return (Criteria) this;
        }

        public Criteria andStaop3Between(Long value1, Long value2) {
            addCriterion("staop3 between", value1, value2, "staop3");
            return (Criteria) this;
        }

        public Criteria andStaop3NotBetween(Long value1, Long value2) {
            addCriterion("staop3 not between", value1, value2, "staop3");
            return (Criteria) this;
        }

        public Criteria andStaop4IsNull() {
            addCriterion("staop4 is null");
            return (Criteria) this;
        }

        public Criteria andStaop4IsNotNull() {
            addCriterion("staop4 is not null");
            return (Criteria) this;
        }

        public Criteria andStaop4EqualTo(Long value) {
            addCriterion("staop4 =", value, "staop4");
            return (Criteria) this;
        }

        public Criteria andStaop4NotEqualTo(Long value) {
            addCriterion("staop4 <>", value, "staop4");
            return (Criteria) this;
        }

        public Criteria andStaop4GreaterThan(Long value) {
            addCriterion("staop4 >", value, "staop4");
            return (Criteria) this;
        }

        public Criteria andStaop4GreaterThanOrEqualTo(Long value) {
            addCriterion("staop4 >=", value, "staop4");
            return (Criteria) this;
        }

        public Criteria andStaop4LessThan(Long value) {
            addCriterion("staop4 <", value, "staop4");
            return (Criteria) this;
        }

        public Criteria andStaop4LessThanOrEqualTo(Long value) {
            addCriterion("staop4 <=", value, "staop4");
            return (Criteria) this;
        }

        public Criteria andStaop4In(List<Long> values) {
            addCriterion("staop4 in", values, "staop4");
            return (Criteria) this;
        }

        public Criteria andStaop4NotIn(List<Long> values) {
            addCriterion("staop4 not in", values, "staop4");
            return (Criteria) this;
        }

        public Criteria andStaop4Between(Long value1, Long value2) {
            addCriterion("staop4 between", value1, value2, "staop4");
            return (Criteria) this;
        }

        public Criteria andStaop4NotBetween(Long value1, Long value2) {
            addCriterion("staop4 not between", value1, value2, "staop4");
            return (Criteria) this;
        }

        public Criteria andStaop5IsNull() {
            addCriterion("staop5 is null");
            return (Criteria) this;
        }

        public Criteria andStaop5IsNotNull() {
            addCriterion("staop5 is not null");
            return (Criteria) this;
        }

        public Criteria andStaop5EqualTo(Long value) {
            addCriterion("staop5 =", value, "staop5");
            return (Criteria) this;
        }

        public Criteria andStaop5NotEqualTo(Long value) {
            addCriterion("staop5 <>", value, "staop5");
            return (Criteria) this;
        }

        public Criteria andStaop5GreaterThan(Long value) {
            addCriterion("staop5 >", value, "staop5");
            return (Criteria) this;
        }

        public Criteria andStaop5GreaterThanOrEqualTo(Long value) {
            addCriterion("staop5 >=", value, "staop5");
            return (Criteria) this;
        }

        public Criteria andStaop5LessThan(Long value) {
            addCriterion("staop5 <", value, "staop5");
            return (Criteria) this;
        }

        public Criteria andStaop5LessThanOrEqualTo(Long value) {
            addCriterion("staop5 <=", value, "staop5");
            return (Criteria) this;
        }

        public Criteria andStaop5In(List<Long> values) {
            addCriterion("staop5 in", values, "staop5");
            return (Criteria) this;
        }

        public Criteria andStaop5NotIn(List<Long> values) {
            addCriterion("staop5 not in", values, "staop5");
            return (Criteria) this;
        }

        public Criteria andStaop5Between(Long value1, Long value2) {
            addCriterion("staop5 between", value1, value2, "staop5");
            return (Criteria) this;
        }

        public Criteria andStaop5NotBetween(Long value1, Long value2) {
            addCriterion("staop5 not between", value1, value2, "staop5");
            return (Criteria) this;
        }

        public Criteria andStanumbers1IsNull() {
            addCriterion("stanumbers1 is null");
            return (Criteria) this;
        }

        public Criteria andStanumbers1IsNotNull() {
            addCriterion("stanumbers1 is not null");
            return (Criteria) this;
        }

        public Criteria andStanumbers1EqualTo(Object value) {
            addCriterion("stanumbers1 =", value, "stanumbers1");
            return (Criteria) this;
        }

        public Criteria andStanumbers1NotEqualTo(Object value) {
            addCriterion("stanumbers1 <>", value, "stanumbers1");
            return (Criteria) this;
        }

        public Criteria andStanumbers1GreaterThan(Object value) {
            addCriterion("stanumbers1 >", value, "stanumbers1");
            return (Criteria) this;
        }

        public Criteria andStanumbers1GreaterThanOrEqualTo(Object value) {
            addCriterion("stanumbers1 >=", value, "stanumbers1");
            return (Criteria) this;
        }

        public Criteria andStanumbers1LessThan(Object value) {
            addCriterion("stanumbers1 <", value, "stanumbers1");
            return (Criteria) this;
        }

        public Criteria andStanumbers1LessThanOrEqualTo(Object value) {
            addCriterion("stanumbers1 <=", value, "stanumbers1");
            return (Criteria) this;
        }

        public Criteria andStanumbers1In(List<Object> values) {
            addCriterion("stanumbers1 in", values, "stanumbers1");
            return (Criteria) this;
        }

        public Criteria andStanumbers1NotIn(List<Object> values) {
            addCriterion("stanumbers1 not in", values, "stanumbers1");
            return (Criteria) this;
        }

        public Criteria andStanumbers1Between(Object value1, Object value2) {
            addCriterion("stanumbers1 between", value1, value2, "stanumbers1");
            return (Criteria) this;
        }

        public Criteria andStanumbers1NotBetween(Object value1, Object value2) {
            addCriterion("stanumbers1 not between", value1, value2, "stanumbers1");
            return (Criteria) this;
        }

        public Criteria andStanumbers2IsNull() {
            addCriterion("stanumbers2 is null");
            return (Criteria) this;
        }

        public Criteria andStanumbers2IsNotNull() {
            addCriterion("stanumbers2 is not null");
            return (Criteria) this;
        }

        public Criteria andStanumbers2EqualTo(Object value) {
            addCriterion("stanumbers2 =", value, "stanumbers2");
            return (Criteria) this;
        }

        public Criteria andStanumbers2NotEqualTo(Object value) {
            addCriterion("stanumbers2 <>", value, "stanumbers2");
            return (Criteria) this;
        }

        public Criteria andStanumbers2GreaterThan(Object value) {
            addCriterion("stanumbers2 >", value, "stanumbers2");
            return (Criteria) this;
        }

        public Criteria andStanumbers2GreaterThanOrEqualTo(Object value) {
            addCriterion("stanumbers2 >=", value, "stanumbers2");
            return (Criteria) this;
        }

        public Criteria andStanumbers2LessThan(Object value) {
            addCriterion("stanumbers2 <", value, "stanumbers2");
            return (Criteria) this;
        }

        public Criteria andStanumbers2LessThanOrEqualTo(Object value) {
            addCriterion("stanumbers2 <=", value, "stanumbers2");
            return (Criteria) this;
        }

        public Criteria andStanumbers2In(List<Object> values) {
            addCriterion("stanumbers2 in", values, "stanumbers2");
            return (Criteria) this;
        }

        public Criteria andStanumbers2NotIn(List<Object> values) {
            addCriterion("stanumbers2 not in", values, "stanumbers2");
            return (Criteria) this;
        }

        public Criteria andStanumbers2Between(Object value1, Object value2) {
            addCriterion("stanumbers2 between", value1, value2, "stanumbers2");
            return (Criteria) this;
        }

        public Criteria andStanumbers2NotBetween(Object value1, Object value2) {
            addCriterion("stanumbers2 not between", value1, value2, "stanumbers2");
            return (Criteria) this;
        }

        public Criteria andStanumbers3IsNull() {
            addCriterion("stanumbers3 is null");
            return (Criteria) this;
        }

        public Criteria andStanumbers3IsNotNull() {
            addCriterion("stanumbers3 is not null");
            return (Criteria) this;
        }

        public Criteria andStanumbers3EqualTo(Object value) {
            addCriterion("stanumbers3 =", value, "stanumbers3");
            return (Criteria) this;
        }

        public Criteria andStanumbers3NotEqualTo(Object value) {
            addCriterion("stanumbers3 <>", value, "stanumbers3");
            return (Criteria) this;
        }

        public Criteria andStanumbers3GreaterThan(Object value) {
            addCriterion("stanumbers3 >", value, "stanumbers3");
            return (Criteria) this;
        }

        public Criteria andStanumbers3GreaterThanOrEqualTo(Object value) {
            addCriterion("stanumbers3 >=", value, "stanumbers3");
            return (Criteria) this;
        }

        public Criteria andStanumbers3LessThan(Object value) {
            addCriterion("stanumbers3 <", value, "stanumbers3");
            return (Criteria) this;
        }

        public Criteria andStanumbers3LessThanOrEqualTo(Object value) {
            addCriterion("stanumbers3 <=", value, "stanumbers3");
            return (Criteria) this;
        }

        public Criteria andStanumbers3In(List<Object> values) {
            addCriterion("stanumbers3 in", values, "stanumbers3");
            return (Criteria) this;
        }

        public Criteria andStanumbers3NotIn(List<Object> values) {
            addCriterion("stanumbers3 not in", values, "stanumbers3");
            return (Criteria) this;
        }

        public Criteria andStanumbers3Between(Object value1, Object value2) {
            addCriterion("stanumbers3 between", value1, value2, "stanumbers3");
            return (Criteria) this;
        }

        public Criteria andStanumbers3NotBetween(Object value1, Object value2) {
            addCriterion("stanumbers3 not between", value1, value2, "stanumbers3");
            return (Criteria) this;
        }

        public Criteria andStanumbers4IsNull() {
            addCriterion("stanumbers4 is null");
            return (Criteria) this;
        }

        public Criteria andStanumbers4IsNotNull() {
            addCriterion("stanumbers4 is not null");
            return (Criteria) this;
        }

        public Criteria andStanumbers4EqualTo(Object value) {
            addCriterion("stanumbers4 =", value, "stanumbers4");
            return (Criteria) this;
        }

        public Criteria andStanumbers4NotEqualTo(Object value) {
            addCriterion("stanumbers4 <>", value, "stanumbers4");
            return (Criteria) this;
        }

        public Criteria andStanumbers4GreaterThan(Object value) {
            addCriterion("stanumbers4 >", value, "stanumbers4");
            return (Criteria) this;
        }

        public Criteria andStanumbers4GreaterThanOrEqualTo(Object value) {
            addCriterion("stanumbers4 >=", value, "stanumbers4");
            return (Criteria) this;
        }

        public Criteria andStanumbers4LessThan(Object value) {
            addCriterion("stanumbers4 <", value, "stanumbers4");
            return (Criteria) this;
        }

        public Criteria andStanumbers4LessThanOrEqualTo(Object value) {
            addCriterion("stanumbers4 <=", value, "stanumbers4");
            return (Criteria) this;
        }

        public Criteria andStanumbers4In(List<Object> values) {
            addCriterion("stanumbers4 in", values, "stanumbers4");
            return (Criteria) this;
        }

        public Criteria andStanumbers4NotIn(List<Object> values) {
            addCriterion("stanumbers4 not in", values, "stanumbers4");
            return (Criteria) this;
        }

        public Criteria andStanumbers4Between(Object value1, Object value2) {
            addCriterion("stanumbers4 between", value1, value2, "stanumbers4");
            return (Criteria) this;
        }

        public Criteria andStanumbers4NotBetween(Object value1, Object value2) {
            addCriterion("stanumbers4 not between", value1, value2, "stanumbers4");
            return (Criteria) this;
        }

        public Criteria andStanumbers5IsNull() {
            addCriterion("stanumbers5 is null");
            return (Criteria) this;
        }

        public Criteria andStanumbers5IsNotNull() {
            addCriterion("stanumbers5 is not null");
            return (Criteria) this;
        }

        public Criteria andStanumbers5EqualTo(Object value) {
            addCriterion("stanumbers5 =", value, "stanumbers5");
            return (Criteria) this;
        }

        public Criteria andStanumbers5NotEqualTo(Object value) {
            addCriterion("stanumbers5 <>", value, "stanumbers5");
            return (Criteria) this;
        }

        public Criteria andStanumbers5GreaterThan(Object value) {
            addCriterion("stanumbers5 >", value, "stanumbers5");
            return (Criteria) this;
        }

        public Criteria andStanumbers5GreaterThanOrEqualTo(Object value) {
            addCriterion("stanumbers5 >=", value, "stanumbers5");
            return (Criteria) this;
        }

        public Criteria andStanumbers5LessThan(Object value) {
            addCriterion("stanumbers5 <", value, "stanumbers5");
            return (Criteria) this;
        }

        public Criteria andStanumbers5LessThanOrEqualTo(Object value) {
            addCriterion("stanumbers5 <=", value, "stanumbers5");
            return (Criteria) this;
        }

        public Criteria andStanumbers5In(List<Object> values) {
            addCriterion("stanumbers5 in", values, "stanumbers5");
            return (Criteria) this;
        }

        public Criteria andStanumbers5NotIn(List<Object> values) {
            addCriterion("stanumbers5 not in", values, "stanumbers5");
            return (Criteria) this;
        }

        public Criteria andStanumbers5Between(Object value1, Object value2) {
            addCriterion("stanumbers5 between", value1, value2, "stanumbers5");
            return (Criteria) this;
        }

        public Criteria andStanumbers5NotBetween(Object value1, Object value2) {
            addCriterion("stanumbers5 not between", value1, value2, "stanumbers5");
            return (Criteria) this;
        }

        public Criteria andStavalues1IsNull() {
            addCriterion("stavalues1 is null");
            return (Criteria) this;
        }

        public Criteria andStavalues1IsNotNull() {
            addCriterion("stavalues1 is not null");
            return (Criteria) this;
        }

        public Criteria andStavalues1EqualTo(Object value) {
            addCriterion("stavalues1 =", value, "stavalues1");
            return (Criteria) this;
        }

        public Criteria andStavalues1NotEqualTo(Object value) {
            addCriterion("stavalues1 <>", value, "stavalues1");
            return (Criteria) this;
        }

        public Criteria andStavalues1GreaterThan(Object value) {
            addCriterion("stavalues1 >", value, "stavalues1");
            return (Criteria) this;
        }

        public Criteria andStavalues1GreaterThanOrEqualTo(Object value) {
            addCriterion("stavalues1 >=", value, "stavalues1");
            return (Criteria) this;
        }

        public Criteria andStavalues1LessThan(Object value) {
            addCriterion("stavalues1 <", value, "stavalues1");
            return (Criteria) this;
        }

        public Criteria andStavalues1LessThanOrEqualTo(Object value) {
            addCriterion("stavalues1 <=", value, "stavalues1");
            return (Criteria) this;
        }

        public Criteria andStavalues1In(List<Object> values) {
            addCriterion("stavalues1 in", values, "stavalues1");
            return (Criteria) this;
        }

        public Criteria andStavalues1NotIn(List<Object> values) {
            addCriterion("stavalues1 not in", values, "stavalues1");
            return (Criteria) this;
        }

        public Criteria andStavalues1Between(Object value1, Object value2) {
            addCriterion("stavalues1 between", value1, value2, "stavalues1");
            return (Criteria) this;
        }

        public Criteria andStavalues1NotBetween(Object value1, Object value2) {
            addCriterion("stavalues1 not between", value1, value2, "stavalues1");
            return (Criteria) this;
        }

        public Criteria andStavalues2IsNull() {
            addCriterion("stavalues2 is null");
            return (Criteria) this;
        }

        public Criteria andStavalues2IsNotNull() {
            addCriterion("stavalues2 is not null");
            return (Criteria) this;
        }

        public Criteria andStavalues2EqualTo(Object value) {
            addCriterion("stavalues2 =", value, "stavalues2");
            return (Criteria) this;
        }

        public Criteria andStavalues2NotEqualTo(Object value) {
            addCriterion("stavalues2 <>", value, "stavalues2");
            return (Criteria) this;
        }

        public Criteria andStavalues2GreaterThan(Object value) {
            addCriterion("stavalues2 >", value, "stavalues2");
            return (Criteria) this;
        }

        public Criteria andStavalues2GreaterThanOrEqualTo(Object value) {
            addCriterion("stavalues2 >=", value, "stavalues2");
            return (Criteria) this;
        }

        public Criteria andStavalues2LessThan(Object value) {
            addCriterion("stavalues2 <", value, "stavalues2");
            return (Criteria) this;
        }

        public Criteria andStavalues2LessThanOrEqualTo(Object value) {
            addCriterion("stavalues2 <=", value, "stavalues2");
            return (Criteria) this;
        }

        public Criteria andStavalues2In(List<Object> values) {
            addCriterion("stavalues2 in", values, "stavalues2");
            return (Criteria) this;
        }

        public Criteria andStavalues2NotIn(List<Object> values) {
            addCriterion("stavalues2 not in", values, "stavalues2");
            return (Criteria) this;
        }

        public Criteria andStavalues2Between(Object value1, Object value2) {
            addCriterion("stavalues2 between", value1, value2, "stavalues2");
            return (Criteria) this;
        }

        public Criteria andStavalues2NotBetween(Object value1, Object value2) {
            addCriterion("stavalues2 not between", value1, value2, "stavalues2");
            return (Criteria) this;
        }

        public Criteria andStavalues3IsNull() {
            addCriterion("stavalues3 is null");
            return (Criteria) this;
        }

        public Criteria andStavalues3IsNotNull() {
            addCriterion("stavalues3 is not null");
            return (Criteria) this;
        }

        public Criteria andStavalues3EqualTo(Object value) {
            addCriterion("stavalues3 =", value, "stavalues3");
            return (Criteria) this;
        }

        public Criteria andStavalues3NotEqualTo(Object value) {
            addCriterion("stavalues3 <>", value, "stavalues3");
            return (Criteria) this;
        }

        public Criteria andStavalues3GreaterThan(Object value) {
            addCriterion("stavalues3 >", value, "stavalues3");
            return (Criteria) this;
        }

        public Criteria andStavalues3GreaterThanOrEqualTo(Object value) {
            addCriterion("stavalues3 >=", value, "stavalues3");
            return (Criteria) this;
        }

        public Criteria andStavalues3LessThan(Object value) {
            addCriterion("stavalues3 <", value, "stavalues3");
            return (Criteria) this;
        }

        public Criteria andStavalues3LessThanOrEqualTo(Object value) {
            addCriterion("stavalues3 <=", value, "stavalues3");
            return (Criteria) this;
        }

        public Criteria andStavalues3In(List<Object> values) {
            addCriterion("stavalues3 in", values, "stavalues3");
            return (Criteria) this;
        }

        public Criteria andStavalues3NotIn(List<Object> values) {
            addCriterion("stavalues3 not in", values, "stavalues3");
            return (Criteria) this;
        }

        public Criteria andStavalues3Between(Object value1, Object value2) {
            addCriterion("stavalues3 between", value1, value2, "stavalues3");
            return (Criteria) this;
        }

        public Criteria andStavalues3NotBetween(Object value1, Object value2) {
            addCriterion("stavalues3 not between", value1, value2, "stavalues3");
            return (Criteria) this;
        }

        public Criteria andStavalues4IsNull() {
            addCriterion("stavalues4 is null");
            return (Criteria) this;
        }

        public Criteria andStavalues4IsNotNull() {
            addCriterion("stavalues4 is not null");
            return (Criteria) this;
        }

        public Criteria andStavalues4EqualTo(Object value) {
            addCriterion("stavalues4 =", value, "stavalues4");
            return (Criteria) this;
        }

        public Criteria andStavalues4NotEqualTo(Object value) {
            addCriterion("stavalues4 <>", value, "stavalues4");
            return (Criteria) this;
        }

        public Criteria andStavalues4GreaterThan(Object value) {
            addCriterion("stavalues4 >", value, "stavalues4");
            return (Criteria) this;
        }

        public Criteria andStavalues4GreaterThanOrEqualTo(Object value) {
            addCriterion("stavalues4 >=", value, "stavalues4");
            return (Criteria) this;
        }

        public Criteria andStavalues4LessThan(Object value) {
            addCriterion("stavalues4 <", value, "stavalues4");
            return (Criteria) this;
        }

        public Criteria andStavalues4LessThanOrEqualTo(Object value) {
            addCriterion("stavalues4 <=", value, "stavalues4");
            return (Criteria) this;
        }

        public Criteria andStavalues4In(List<Object> values) {
            addCriterion("stavalues4 in", values, "stavalues4");
            return (Criteria) this;
        }

        public Criteria andStavalues4NotIn(List<Object> values) {
            addCriterion("stavalues4 not in", values, "stavalues4");
            return (Criteria) this;
        }

        public Criteria andStavalues4Between(Object value1, Object value2) {
            addCriterion("stavalues4 between", value1, value2, "stavalues4");
            return (Criteria) this;
        }

        public Criteria andStavalues4NotBetween(Object value1, Object value2) {
            addCriterion("stavalues4 not between", value1, value2, "stavalues4");
            return (Criteria) this;
        }

        public Criteria andStavalues5IsNull() {
            addCriterion("stavalues5 is null");
            return (Criteria) this;
        }

        public Criteria andStavalues5IsNotNull() {
            addCriterion("stavalues5 is not null");
            return (Criteria) this;
        }

        public Criteria andStavalues5EqualTo(Object value) {
            addCriterion("stavalues5 =", value, "stavalues5");
            return (Criteria) this;
        }

        public Criteria andStavalues5NotEqualTo(Object value) {
            addCriterion("stavalues5 <>", value, "stavalues5");
            return (Criteria) this;
        }

        public Criteria andStavalues5GreaterThan(Object value) {
            addCriterion("stavalues5 >", value, "stavalues5");
            return (Criteria) this;
        }

        public Criteria andStavalues5GreaterThanOrEqualTo(Object value) {
            addCriterion("stavalues5 >=", value, "stavalues5");
            return (Criteria) this;
        }

        public Criteria andStavalues5LessThan(Object value) {
            addCriterion("stavalues5 <", value, "stavalues5");
            return (Criteria) this;
        }

        public Criteria andStavalues5LessThanOrEqualTo(Object value) {
            addCriterion("stavalues5 <=", value, "stavalues5");
            return (Criteria) this;
        }

        public Criteria andStavalues5In(List<Object> values) {
            addCriterion("stavalues5 in", values, "stavalues5");
            return (Criteria) this;
        }

        public Criteria andStavalues5NotIn(List<Object> values) {
            addCriterion("stavalues5 not in", values, "stavalues5");
            return (Criteria) this;
        }

        public Criteria andStavalues5Between(Object value1, Object value2) {
            addCriterion("stavalues5 between", value1, value2, "stavalues5");
            return (Criteria) this;
        }

        public Criteria andStavalues5NotBetween(Object value1, Object value2) {
            addCriterion("stavalues5 not between", value1, value2, "stavalues5");
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