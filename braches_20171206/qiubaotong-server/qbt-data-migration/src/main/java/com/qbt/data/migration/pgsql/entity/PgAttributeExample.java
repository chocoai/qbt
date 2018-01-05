package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgAttributeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgAttributeExample() {
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

        public Criteria andAttrelidIsNull() {
            addCriterion("attrelid is null");
            return (Criteria) this;
        }

        public Criteria andAttrelidIsNotNull() {
            addCriterion("attrelid is not null");
            return (Criteria) this;
        }

        public Criteria andAttrelidEqualTo(Long value) {
            addCriterion("attrelid =", value, "attrelid");
            return (Criteria) this;
        }

        public Criteria andAttrelidNotEqualTo(Long value) {
            addCriterion("attrelid <>", value, "attrelid");
            return (Criteria) this;
        }

        public Criteria andAttrelidGreaterThan(Long value) {
            addCriterion("attrelid >", value, "attrelid");
            return (Criteria) this;
        }

        public Criteria andAttrelidGreaterThanOrEqualTo(Long value) {
            addCriterion("attrelid >=", value, "attrelid");
            return (Criteria) this;
        }

        public Criteria andAttrelidLessThan(Long value) {
            addCriterion("attrelid <", value, "attrelid");
            return (Criteria) this;
        }

        public Criteria andAttrelidLessThanOrEqualTo(Long value) {
            addCriterion("attrelid <=", value, "attrelid");
            return (Criteria) this;
        }

        public Criteria andAttrelidIn(List<Long> values) {
            addCriterion("attrelid in", values, "attrelid");
            return (Criteria) this;
        }

        public Criteria andAttrelidNotIn(List<Long> values) {
            addCriterion("attrelid not in", values, "attrelid");
            return (Criteria) this;
        }

        public Criteria andAttrelidBetween(Long value1, Long value2) {
            addCriterion("attrelid between", value1, value2, "attrelid");
            return (Criteria) this;
        }

        public Criteria andAttrelidNotBetween(Long value1, Long value2) {
            addCriterion("attrelid not between", value1, value2, "attrelid");
            return (Criteria) this;
        }

        public Criteria andAttnameIsNull() {
            addCriterion("attname is null");
            return (Criteria) this;
        }

        public Criteria andAttnameIsNotNull() {
            addCriterion("attname is not null");
            return (Criteria) this;
        }

        public Criteria andAttnameEqualTo(String value) {
            addCriterion("attname =", value, "attname");
            return (Criteria) this;
        }

        public Criteria andAttnameNotEqualTo(String value) {
            addCriterion("attname <>", value, "attname");
            return (Criteria) this;
        }

        public Criteria andAttnameGreaterThan(String value) {
            addCriterion("attname >", value, "attname");
            return (Criteria) this;
        }

        public Criteria andAttnameGreaterThanOrEqualTo(String value) {
            addCriterion("attname >=", value, "attname");
            return (Criteria) this;
        }

        public Criteria andAttnameLessThan(String value) {
            addCriterion("attname <", value, "attname");
            return (Criteria) this;
        }

        public Criteria andAttnameLessThanOrEqualTo(String value) {
            addCriterion("attname <=", value, "attname");
            return (Criteria) this;
        }

        public Criteria andAttnameLike(String value) {
            addCriterion("attname like", value, "attname");
            return (Criteria) this;
        }

        public Criteria andAttnameNotLike(String value) {
            addCriterion("attname not like", value, "attname");
            return (Criteria) this;
        }

        public Criteria andAttnameIn(List<String> values) {
            addCriterion("attname in", values, "attname");
            return (Criteria) this;
        }

        public Criteria andAttnameNotIn(List<String> values) {
            addCriterion("attname not in", values, "attname");
            return (Criteria) this;
        }

        public Criteria andAttnameBetween(String value1, String value2) {
            addCriterion("attname between", value1, value2, "attname");
            return (Criteria) this;
        }

        public Criteria andAttnameNotBetween(String value1, String value2) {
            addCriterion("attname not between", value1, value2, "attname");
            return (Criteria) this;
        }

        public Criteria andAtttypidIsNull() {
            addCriterion("atttypid is null");
            return (Criteria) this;
        }

        public Criteria andAtttypidIsNotNull() {
            addCriterion("atttypid is not null");
            return (Criteria) this;
        }

        public Criteria andAtttypidEqualTo(Long value) {
            addCriterion("atttypid =", value, "atttypid");
            return (Criteria) this;
        }

        public Criteria andAtttypidNotEqualTo(Long value) {
            addCriterion("atttypid <>", value, "atttypid");
            return (Criteria) this;
        }

        public Criteria andAtttypidGreaterThan(Long value) {
            addCriterion("atttypid >", value, "atttypid");
            return (Criteria) this;
        }

        public Criteria andAtttypidGreaterThanOrEqualTo(Long value) {
            addCriterion("atttypid >=", value, "atttypid");
            return (Criteria) this;
        }

        public Criteria andAtttypidLessThan(Long value) {
            addCriterion("atttypid <", value, "atttypid");
            return (Criteria) this;
        }

        public Criteria andAtttypidLessThanOrEqualTo(Long value) {
            addCriterion("atttypid <=", value, "atttypid");
            return (Criteria) this;
        }

        public Criteria andAtttypidIn(List<Long> values) {
            addCriterion("atttypid in", values, "atttypid");
            return (Criteria) this;
        }

        public Criteria andAtttypidNotIn(List<Long> values) {
            addCriterion("atttypid not in", values, "atttypid");
            return (Criteria) this;
        }

        public Criteria andAtttypidBetween(Long value1, Long value2) {
            addCriterion("atttypid between", value1, value2, "atttypid");
            return (Criteria) this;
        }

        public Criteria andAtttypidNotBetween(Long value1, Long value2) {
            addCriterion("atttypid not between", value1, value2, "atttypid");
            return (Criteria) this;
        }

        public Criteria andAttstattargetIsNull() {
            addCriterion("attstattarget is null");
            return (Criteria) this;
        }

        public Criteria andAttstattargetIsNotNull() {
            addCriterion("attstattarget is not null");
            return (Criteria) this;
        }

        public Criteria andAttstattargetEqualTo(Integer value) {
            addCriterion("attstattarget =", value, "attstattarget");
            return (Criteria) this;
        }

        public Criteria andAttstattargetNotEqualTo(Integer value) {
            addCriterion("attstattarget <>", value, "attstattarget");
            return (Criteria) this;
        }

        public Criteria andAttstattargetGreaterThan(Integer value) {
            addCriterion("attstattarget >", value, "attstattarget");
            return (Criteria) this;
        }

        public Criteria andAttstattargetGreaterThanOrEqualTo(Integer value) {
            addCriterion("attstattarget >=", value, "attstattarget");
            return (Criteria) this;
        }

        public Criteria andAttstattargetLessThan(Integer value) {
            addCriterion("attstattarget <", value, "attstattarget");
            return (Criteria) this;
        }

        public Criteria andAttstattargetLessThanOrEqualTo(Integer value) {
            addCriterion("attstattarget <=", value, "attstattarget");
            return (Criteria) this;
        }

        public Criteria andAttstattargetIn(List<Integer> values) {
            addCriterion("attstattarget in", values, "attstattarget");
            return (Criteria) this;
        }

        public Criteria andAttstattargetNotIn(List<Integer> values) {
            addCriterion("attstattarget not in", values, "attstattarget");
            return (Criteria) this;
        }

        public Criteria andAttstattargetBetween(Integer value1, Integer value2) {
            addCriterion("attstattarget between", value1, value2, "attstattarget");
            return (Criteria) this;
        }

        public Criteria andAttstattargetNotBetween(Integer value1, Integer value2) {
            addCriterion("attstattarget not between", value1, value2, "attstattarget");
            return (Criteria) this;
        }

        public Criteria andAttlenIsNull() {
            addCriterion("attlen is null");
            return (Criteria) this;
        }

        public Criteria andAttlenIsNotNull() {
            addCriterion("attlen is not null");
            return (Criteria) this;
        }

        public Criteria andAttlenEqualTo(Short value) {
            addCriterion("attlen =", value, "attlen");
            return (Criteria) this;
        }

        public Criteria andAttlenNotEqualTo(Short value) {
            addCriterion("attlen <>", value, "attlen");
            return (Criteria) this;
        }

        public Criteria andAttlenGreaterThan(Short value) {
            addCriterion("attlen >", value, "attlen");
            return (Criteria) this;
        }

        public Criteria andAttlenGreaterThanOrEqualTo(Short value) {
            addCriterion("attlen >=", value, "attlen");
            return (Criteria) this;
        }

        public Criteria andAttlenLessThan(Short value) {
            addCriterion("attlen <", value, "attlen");
            return (Criteria) this;
        }

        public Criteria andAttlenLessThanOrEqualTo(Short value) {
            addCriterion("attlen <=", value, "attlen");
            return (Criteria) this;
        }

        public Criteria andAttlenIn(List<Short> values) {
            addCriterion("attlen in", values, "attlen");
            return (Criteria) this;
        }

        public Criteria andAttlenNotIn(List<Short> values) {
            addCriterion("attlen not in", values, "attlen");
            return (Criteria) this;
        }

        public Criteria andAttlenBetween(Short value1, Short value2) {
            addCriterion("attlen between", value1, value2, "attlen");
            return (Criteria) this;
        }

        public Criteria andAttlenNotBetween(Short value1, Short value2) {
            addCriterion("attlen not between", value1, value2, "attlen");
            return (Criteria) this;
        }

        public Criteria andAttnumIsNull() {
            addCriterion("attnum is null");
            return (Criteria) this;
        }

        public Criteria andAttnumIsNotNull() {
            addCriterion("attnum is not null");
            return (Criteria) this;
        }

        public Criteria andAttnumEqualTo(Short value) {
            addCriterion("attnum =", value, "attnum");
            return (Criteria) this;
        }

        public Criteria andAttnumNotEqualTo(Short value) {
            addCriterion("attnum <>", value, "attnum");
            return (Criteria) this;
        }

        public Criteria andAttnumGreaterThan(Short value) {
            addCriterion("attnum >", value, "attnum");
            return (Criteria) this;
        }

        public Criteria andAttnumGreaterThanOrEqualTo(Short value) {
            addCriterion("attnum >=", value, "attnum");
            return (Criteria) this;
        }

        public Criteria andAttnumLessThan(Short value) {
            addCriterion("attnum <", value, "attnum");
            return (Criteria) this;
        }

        public Criteria andAttnumLessThanOrEqualTo(Short value) {
            addCriterion("attnum <=", value, "attnum");
            return (Criteria) this;
        }

        public Criteria andAttnumIn(List<Short> values) {
            addCriterion("attnum in", values, "attnum");
            return (Criteria) this;
        }

        public Criteria andAttnumNotIn(List<Short> values) {
            addCriterion("attnum not in", values, "attnum");
            return (Criteria) this;
        }

        public Criteria andAttnumBetween(Short value1, Short value2) {
            addCriterion("attnum between", value1, value2, "attnum");
            return (Criteria) this;
        }

        public Criteria andAttnumNotBetween(Short value1, Short value2) {
            addCriterion("attnum not between", value1, value2, "attnum");
            return (Criteria) this;
        }

        public Criteria andAttndimsIsNull() {
            addCriterion("attndims is null");
            return (Criteria) this;
        }

        public Criteria andAttndimsIsNotNull() {
            addCriterion("attndims is not null");
            return (Criteria) this;
        }

        public Criteria andAttndimsEqualTo(Integer value) {
            addCriterion("attndims =", value, "attndims");
            return (Criteria) this;
        }

        public Criteria andAttndimsNotEqualTo(Integer value) {
            addCriterion("attndims <>", value, "attndims");
            return (Criteria) this;
        }

        public Criteria andAttndimsGreaterThan(Integer value) {
            addCriterion("attndims >", value, "attndims");
            return (Criteria) this;
        }

        public Criteria andAttndimsGreaterThanOrEqualTo(Integer value) {
            addCriterion("attndims >=", value, "attndims");
            return (Criteria) this;
        }

        public Criteria andAttndimsLessThan(Integer value) {
            addCriterion("attndims <", value, "attndims");
            return (Criteria) this;
        }

        public Criteria andAttndimsLessThanOrEqualTo(Integer value) {
            addCriterion("attndims <=", value, "attndims");
            return (Criteria) this;
        }

        public Criteria andAttndimsIn(List<Integer> values) {
            addCriterion("attndims in", values, "attndims");
            return (Criteria) this;
        }

        public Criteria andAttndimsNotIn(List<Integer> values) {
            addCriterion("attndims not in", values, "attndims");
            return (Criteria) this;
        }

        public Criteria andAttndimsBetween(Integer value1, Integer value2) {
            addCriterion("attndims between", value1, value2, "attndims");
            return (Criteria) this;
        }

        public Criteria andAttndimsNotBetween(Integer value1, Integer value2) {
            addCriterion("attndims not between", value1, value2, "attndims");
            return (Criteria) this;
        }

        public Criteria andAttcacheoffIsNull() {
            addCriterion("attcacheoff is null");
            return (Criteria) this;
        }

        public Criteria andAttcacheoffIsNotNull() {
            addCriterion("attcacheoff is not null");
            return (Criteria) this;
        }

        public Criteria andAttcacheoffEqualTo(Integer value) {
            addCriterion("attcacheoff =", value, "attcacheoff");
            return (Criteria) this;
        }

        public Criteria andAttcacheoffNotEqualTo(Integer value) {
            addCriterion("attcacheoff <>", value, "attcacheoff");
            return (Criteria) this;
        }

        public Criteria andAttcacheoffGreaterThan(Integer value) {
            addCriterion("attcacheoff >", value, "attcacheoff");
            return (Criteria) this;
        }

        public Criteria andAttcacheoffGreaterThanOrEqualTo(Integer value) {
            addCriterion("attcacheoff >=", value, "attcacheoff");
            return (Criteria) this;
        }

        public Criteria andAttcacheoffLessThan(Integer value) {
            addCriterion("attcacheoff <", value, "attcacheoff");
            return (Criteria) this;
        }

        public Criteria andAttcacheoffLessThanOrEqualTo(Integer value) {
            addCriterion("attcacheoff <=", value, "attcacheoff");
            return (Criteria) this;
        }

        public Criteria andAttcacheoffIn(List<Integer> values) {
            addCriterion("attcacheoff in", values, "attcacheoff");
            return (Criteria) this;
        }

        public Criteria andAttcacheoffNotIn(List<Integer> values) {
            addCriterion("attcacheoff not in", values, "attcacheoff");
            return (Criteria) this;
        }

        public Criteria andAttcacheoffBetween(Integer value1, Integer value2) {
            addCriterion("attcacheoff between", value1, value2, "attcacheoff");
            return (Criteria) this;
        }

        public Criteria andAttcacheoffNotBetween(Integer value1, Integer value2) {
            addCriterion("attcacheoff not between", value1, value2, "attcacheoff");
            return (Criteria) this;
        }

        public Criteria andAtttypmodIsNull() {
            addCriterion("atttypmod is null");
            return (Criteria) this;
        }

        public Criteria andAtttypmodIsNotNull() {
            addCriterion("atttypmod is not null");
            return (Criteria) this;
        }

        public Criteria andAtttypmodEqualTo(Integer value) {
            addCriterion("atttypmod =", value, "atttypmod");
            return (Criteria) this;
        }

        public Criteria andAtttypmodNotEqualTo(Integer value) {
            addCriterion("atttypmod <>", value, "atttypmod");
            return (Criteria) this;
        }

        public Criteria andAtttypmodGreaterThan(Integer value) {
            addCriterion("atttypmod >", value, "atttypmod");
            return (Criteria) this;
        }

        public Criteria andAtttypmodGreaterThanOrEqualTo(Integer value) {
            addCriterion("atttypmod >=", value, "atttypmod");
            return (Criteria) this;
        }

        public Criteria andAtttypmodLessThan(Integer value) {
            addCriterion("atttypmod <", value, "atttypmod");
            return (Criteria) this;
        }

        public Criteria andAtttypmodLessThanOrEqualTo(Integer value) {
            addCriterion("atttypmod <=", value, "atttypmod");
            return (Criteria) this;
        }

        public Criteria andAtttypmodIn(List<Integer> values) {
            addCriterion("atttypmod in", values, "atttypmod");
            return (Criteria) this;
        }

        public Criteria andAtttypmodNotIn(List<Integer> values) {
            addCriterion("atttypmod not in", values, "atttypmod");
            return (Criteria) this;
        }

        public Criteria andAtttypmodBetween(Integer value1, Integer value2) {
            addCriterion("atttypmod between", value1, value2, "atttypmod");
            return (Criteria) this;
        }

        public Criteria andAtttypmodNotBetween(Integer value1, Integer value2) {
            addCriterion("atttypmod not between", value1, value2, "atttypmod");
            return (Criteria) this;
        }

        public Criteria andAttbyvalIsNull() {
            addCriterion("attbyval is null");
            return (Criteria) this;
        }

        public Criteria andAttbyvalIsNotNull() {
            addCriterion("attbyval is not null");
            return (Criteria) this;
        }

        public Criteria andAttbyvalEqualTo(Boolean value) {
            addCriterion("attbyval =", value, "attbyval");
            return (Criteria) this;
        }

        public Criteria andAttbyvalNotEqualTo(Boolean value) {
            addCriterion("attbyval <>", value, "attbyval");
            return (Criteria) this;
        }

        public Criteria andAttbyvalGreaterThan(Boolean value) {
            addCriterion("attbyval >", value, "attbyval");
            return (Criteria) this;
        }

        public Criteria andAttbyvalGreaterThanOrEqualTo(Boolean value) {
            addCriterion("attbyval >=", value, "attbyval");
            return (Criteria) this;
        }

        public Criteria andAttbyvalLessThan(Boolean value) {
            addCriterion("attbyval <", value, "attbyval");
            return (Criteria) this;
        }

        public Criteria andAttbyvalLessThanOrEqualTo(Boolean value) {
            addCriterion("attbyval <=", value, "attbyval");
            return (Criteria) this;
        }

        public Criteria andAttbyvalIn(List<Boolean> values) {
            addCriterion("attbyval in", values, "attbyval");
            return (Criteria) this;
        }

        public Criteria andAttbyvalNotIn(List<Boolean> values) {
            addCriterion("attbyval not in", values, "attbyval");
            return (Criteria) this;
        }

        public Criteria andAttbyvalBetween(Boolean value1, Boolean value2) {
            addCriterion("attbyval between", value1, value2, "attbyval");
            return (Criteria) this;
        }

        public Criteria andAttbyvalNotBetween(Boolean value1, Boolean value2) {
            addCriterion("attbyval not between", value1, value2, "attbyval");
            return (Criteria) this;
        }

        public Criteria andAttstorageIsNull() {
            addCriterion("attstorage is null");
            return (Criteria) this;
        }

        public Criteria andAttstorageIsNotNull() {
            addCriterion("attstorage is not null");
            return (Criteria) this;
        }

        public Criteria andAttstorageEqualTo(String value) {
            addCriterion("attstorage =", value, "attstorage");
            return (Criteria) this;
        }

        public Criteria andAttstorageNotEqualTo(String value) {
            addCriterion("attstorage <>", value, "attstorage");
            return (Criteria) this;
        }

        public Criteria andAttstorageGreaterThan(String value) {
            addCriterion("attstorage >", value, "attstorage");
            return (Criteria) this;
        }

        public Criteria andAttstorageGreaterThanOrEqualTo(String value) {
            addCriterion("attstorage >=", value, "attstorage");
            return (Criteria) this;
        }

        public Criteria andAttstorageLessThan(String value) {
            addCriterion("attstorage <", value, "attstorage");
            return (Criteria) this;
        }

        public Criteria andAttstorageLessThanOrEqualTo(String value) {
            addCriterion("attstorage <=", value, "attstorage");
            return (Criteria) this;
        }

        public Criteria andAttstorageLike(String value) {
            addCriterion("attstorage like", value, "attstorage");
            return (Criteria) this;
        }

        public Criteria andAttstorageNotLike(String value) {
            addCriterion("attstorage not like", value, "attstorage");
            return (Criteria) this;
        }

        public Criteria andAttstorageIn(List<String> values) {
            addCriterion("attstorage in", values, "attstorage");
            return (Criteria) this;
        }

        public Criteria andAttstorageNotIn(List<String> values) {
            addCriterion("attstorage not in", values, "attstorage");
            return (Criteria) this;
        }

        public Criteria andAttstorageBetween(String value1, String value2) {
            addCriterion("attstorage between", value1, value2, "attstorage");
            return (Criteria) this;
        }

        public Criteria andAttstorageNotBetween(String value1, String value2) {
            addCriterion("attstorage not between", value1, value2, "attstorage");
            return (Criteria) this;
        }

        public Criteria andAttalignIsNull() {
            addCriterion("attalign is null");
            return (Criteria) this;
        }

        public Criteria andAttalignIsNotNull() {
            addCriterion("attalign is not null");
            return (Criteria) this;
        }

        public Criteria andAttalignEqualTo(String value) {
            addCriterion("attalign =", value, "attalign");
            return (Criteria) this;
        }

        public Criteria andAttalignNotEqualTo(String value) {
            addCriterion("attalign <>", value, "attalign");
            return (Criteria) this;
        }

        public Criteria andAttalignGreaterThan(String value) {
            addCriterion("attalign >", value, "attalign");
            return (Criteria) this;
        }

        public Criteria andAttalignGreaterThanOrEqualTo(String value) {
            addCriterion("attalign >=", value, "attalign");
            return (Criteria) this;
        }

        public Criteria andAttalignLessThan(String value) {
            addCriterion("attalign <", value, "attalign");
            return (Criteria) this;
        }

        public Criteria andAttalignLessThanOrEqualTo(String value) {
            addCriterion("attalign <=", value, "attalign");
            return (Criteria) this;
        }

        public Criteria andAttalignLike(String value) {
            addCriterion("attalign like", value, "attalign");
            return (Criteria) this;
        }

        public Criteria andAttalignNotLike(String value) {
            addCriterion("attalign not like", value, "attalign");
            return (Criteria) this;
        }

        public Criteria andAttalignIn(List<String> values) {
            addCriterion("attalign in", values, "attalign");
            return (Criteria) this;
        }

        public Criteria andAttalignNotIn(List<String> values) {
            addCriterion("attalign not in", values, "attalign");
            return (Criteria) this;
        }

        public Criteria andAttalignBetween(String value1, String value2) {
            addCriterion("attalign between", value1, value2, "attalign");
            return (Criteria) this;
        }

        public Criteria andAttalignNotBetween(String value1, String value2) {
            addCriterion("attalign not between", value1, value2, "attalign");
            return (Criteria) this;
        }

        public Criteria andAttnotnullIsNull() {
            addCriterion("attnotnull is null");
            return (Criteria) this;
        }

        public Criteria andAttnotnullIsNotNull() {
            addCriterion("attnotnull is not null");
            return (Criteria) this;
        }

        public Criteria andAttnotnullEqualTo(Boolean value) {
            addCriterion("attnotnull =", value, "attnotnull");
            return (Criteria) this;
        }

        public Criteria andAttnotnullNotEqualTo(Boolean value) {
            addCriterion("attnotnull <>", value, "attnotnull");
            return (Criteria) this;
        }

        public Criteria andAttnotnullGreaterThan(Boolean value) {
            addCriterion("attnotnull >", value, "attnotnull");
            return (Criteria) this;
        }

        public Criteria andAttnotnullGreaterThanOrEqualTo(Boolean value) {
            addCriterion("attnotnull >=", value, "attnotnull");
            return (Criteria) this;
        }

        public Criteria andAttnotnullLessThan(Boolean value) {
            addCriterion("attnotnull <", value, "attnotnull");
            return (Criteria) this;
        }

        public Criteria andAttnotnullLessThanOrEqualTo(Boolean value) {
            addCriterion("attnotnull <=", value, "attnotnull");
            return (Criteria) this;
        }

        public Criteria andAttnotnullIn(List<Boolean> values) {
            addCriterion("attnotnull in", values, "attnotnull");
            return (Criteria) this;
        }

        public Criteria andAttnotnullNotIn(List<Boolean> values) {
            addCriterion("attnotnull not in", values, "attnotnull");
            return (Criteria) this;
        }

        public Criteria andAttnotnullBetween(Boolean value1, Boolean value2) {
            addCriterion("attnotnull between", value1, value2, "attnotnull");
            return (Criteria) this;
        }

        public Criteria andAttnotnullNotBetween(Boolean value1, Boolean value2) {
            addCriterion("attnotnull not between", value1, value2, "attnotnull");
            return (Criteria) this;
        }

        public Criteria andAtthasdefIsNull() {
            addCriterion("atthasdef is null");
            return (Criteria) this;
        }

        public Criteria andAtthasdefIsNotNull() {
            addCriterion("atthasdef is not null");
            return (Criteria) this;
        }

        public Criteria andAtthasdefEqualTo(Boolean value) {
            addCriterion("atthasdef =", value, "atthasdef");
            return (Criteria) this;
        }

        public Criteria andAtthasdefNotEqualTo(Boolean value) {
            addCriterion("atthasdef <>", value, "atthasdef");
            return (Criteria) this;
        }

        public Criteria andAtthasdefGreaterThan(Boolean value) {
            addCriterion("atthasdef >", value, "atthasdef");
            return (Criteria) this;
        }

        public Criteria andAtthasdefGreaterThanOrEqualTo(Boolean value) {
            addCriterion("atthasdef >=", value, "atthasdef");
            return (Criteria) this;
        }

        public Criteria andAtthasdefLessThan(Boolean value) {
            addCriterion("atthasdef <", value, "atthasdef");
            return (Criteria) this;
        }

        public Criteria andAtthasdefLessThanOrEqualTo(Boolean value) {
            addCriterion("atthasdef <=", value, "atthasdef");
            return (Criteria) this;
        }

        public Criteria andAtthasdefIn(List<Boolean> values) {
            addCriterion("atthasdef in", values, "atthasdef");
            return (Criteria) this;
        }

        public Criteria andAtthasdefNotIn(List<Boolean> values) {
            addCriterion("atthasdef not in", values, "atthasdef");
            return (Criteria) this;
        }

        public Criteria andAtthasdefBetween(Boolean value1, Boolean value2) {
            addCriterion("atthasdef between", value1, value2, "atthasdef");
            return (Criteria) this;
        }

        public Criteria andAtthasdefNotBetween(Boolean value1, Boolean value2) {
            addCriterion("atthasdef not between", value1, value2, "atthasdef");
            return (Criteria) this;
        }

        public Criteria andAttisdroppedIsNull() {
            addCriterion("attisdropped is null");
            return (Criteria) this;
        }

        public Criteria andAttisdroppedIsNotNull() {
            addCriterion("attisdropped is not null");
            return (Criteria) this;
        }

        public Criteria andAttisdroppedEqualTo(Boolean value) {
            addCriterion("attisdropped =", value, "attisdropped");
            return (Criteria) this;
        }

        public Criteria andAttisdroppedNotEqualTo(Boolean value) {
            addCriterion("attisdropped <>", value, "attisdropped");
            return (Criteria) this;
        }

        public Criteria andAttisdroppedGreaterThan(Boolean value) {
            addCriterion("attisdropped >", value, "attisdropped");
            return (Criteria) this;
        }

        public Criteria andAttisdroppedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("attisdropped >=", value, "attisdropped");
            return (Criteria) this;
        }

        public Criteria andAttisdroppedLessThan(Boolean value) {
            addCriterion("attisdropped <", value, "attisdropped");
            return (Criteria) this;
        }

        public Criteria andAttisdroppedLessThanOrEqualTo(Boolean value) {
            addCriterion("attisdropped <=", value, "attisdropped");
            return (Criteria) this;
        }

        public Criteria andAttisdroppedIn(List<Boolean> values) {
            addCriterion("attisdropped in", values, "attisdropped");
            return (Criteria) this;
        }

        public Criteria andAttisdroppedNotIn(List<Boolean> values) {
            addCriterion("attisdropped not in", values, "attisdropped");
            return (Criteria) this;
        }

        public Criteria andAttisdroppedBetween(Boolean value1, Boolean value2) {
            addCriterion("attisdropped between", value1, value2, "attisdropped");
            return (Criteria) this;
        }

        public Criteria andAttisdroppedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("attisdropped not between", value1, value2, "attisdropped");
            return (Criteria) this;
        }

        public Criteria andAttislocalIsNull() {
            addCriterion("attislocal is null");
            return (Criteria) this;
        }

        public Criteria andAttislocalIsNotNull() {
            addCriterion("attislocal is not null");
            return (Criteria) this;
        }

        public Criteria andAttislocalEqualTo(Boolean value) {
            addCriterion("attislocal =", value, "attislocal");
            return (Criteria) this;
        }

        public Criteria andAttislocalNotEqualTo(Boolean value) {
            addCriterion("attislocal <>", value, "attislocal");
            return (Criteria) this;
        }

        public Criteria andAttislocalGreaterThan(Boolean value) {
            addCriterion("attislocal >", value, "attislocal");
            return (Criteria) this;
        }

        public Criteria andAttislocalGreaterThanOrEqualTo(Boolean value) {
            addCriterion("attislocal >=", value, "attislocal");
            return (Criteria) this;
        }

        public Criteria andAttislocalLessThan(Boolean value) {
            addCriterion("attislocal <", value, "attislocal");
            return (Criteria) this;
        }

        public Criteria andAttislocalLessThanOrEqualTo(Boolean value) {
            addCriterion("attislocal <=", value, "attislocal");
            return (Criteria) this;
        }

        public Criteria andAttislocalIn(List<Boolean> values) {
            addCriterion("attislocal in", values, "attislocal");
            return (Criteria) this;
        }

        public Criteria andAttislocalNotIn(List<Boolean> values) {
            addCriterion("attislocal not in", values, "attislocal");
            return (Criteria) this;
        }

        public Criteria andAttislocalBetween(Boolean value1, Boolean value2) {
            addCriterion("attislocal between", value1, value2, "attislocal");
            return (Criteria) this;
        }

        public Criteria andAttislocalNotBetween(Boolean value1, Boolean value2) {
            addCriterion("attislocal not between", value1, value2, "attislocal");
            return (Criteria) this;
        }

        public Criteria andAttinhcountIsNull() {
            addCriterion("attinhcount is null");
            return (Criteria) this;
        }

        public Criteria andAttinhcountIsNotNull() {
            addCriterion("attinhcount is not null");
            return (Criteria) this;
        }

        public Criteria andAttinhcountEqualTo(Integer value) {
            addCriterion("attinhcount =", value, "attinhcount");
            return (Criteria) this;
        }

        public Criteria andAttinhcountNotEqualTo(Integer value) {
            addCriterion("attinhcount <>", value, "attinhcount");
            return (Criteria) this;
        }

        public Criteria andAttinhcountGreaterThan(Integer value) {
            addCriterion("attinhcount >", value, "attinhcount");
            return (Criteria) this;
        }

        public Criteria andAttinhcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("attinhcount >=", value, "attinhcount");
            return (Criteria) this;
        }

        public Criteria andAttinhcountLessThan(Integer value) {
            addCriterion("attinhcount <", value, "attinhcount");
            return (Criteria) this;
        }

        public Criteria andAttinhcountLessThanOrEqualTo(Integer value) {
            addCriterion("attinhcount <=", value, "attinhcount");
            return (Criteria) this;
        }

        public Criteria andAttinhcountIn(List<Integer> values) {
            addCriterion("attinhcount in", values, "attinhcount");
            return (Criteria) this;
        }

        public Criteria andAttinhcountNotIn(List<Integer> values) {
            addCriterion("attinhcount not in", values, "attinhcount");
            return (Criteria) this;
        }

        public Criteria andAttinhcountBetween(Integer value1, Integer value2) {
            addCriterion("attinhcount between", value1, value2, "attinhcount");
            return (Criteria) this;
        }

        public Criteria andAttinhcountNotBetween(Integer value1, Integer value2) {
            addCriterion("attinhcount not between", value1, value2, "attinhcount");
            return (Criteria) this;
        }

        public Criteria andAttcollationIsNull() {
            addCriterion("attcollation is null");
            return (Criteria) this;
        }

        public Criteria andAttcollationIsNotNull() {
            addCriterion("attcollation is not null");
            return (Criteria) this;
        }

        public Criteria andAttcollationEqualTo(Long value) {
            addCriterion("attcollation =", value, "attcollation");
            return (Criteria) this;
        }

        public Criteria andAttcollationNotEqualTo(Long value) {
            addCriterion("attcollation <>", value, "attcollation");
            return (Criteria) this;
        }

        public Criteria andAttcollationGreaterThan(Long value) {
            addCriterion("attcollation >", value, "attcollation");
            return (Criteria) this;
        }

        public Criteria andAttcollationGreaterThanOrEqualTo(Long value) {
            addCriterion("attcollation >=", value, "attcollation");
            return (Criteria) this;
        }

        public Criteria andAttcollationLessThan(Long value) {
            addCriterion("attcollation <", value, "attcollation");
            return (Criteria) this;
        }

        public Criteria andAttcollationLessThanOrEqualTo(Long value) {
            addCriterion("attcollation <=", value, "attcollation");
            return (Criteria) this;
        }

        public Criteria andAttcollationIn(List<Long> values) {
            addCriterion("attcollation in", values, "attcollation");
            return (Criteria) this;
        }

        public Criteria andAttcollationNotIn(List<Long> values) {
            addCriterion("attcollation not in", values, "attcollation");
            return (Criteria) this;
        }

        public Criteria andAttcollationBetween(Long value1, Long value2) {
            addCriterion("attcollation between", value1, value2, "attcollation");
            return (Criteria) this;
        }

        public Criteria andAttcollationNotBetween(Long value1, Long value2) {
            addCriterion("attcollation not between", value1, value2, "attcollation");
            return (Criteria) this;
        }

        public Criteria andAttaclIsNull() {
            addCriterion("attacl is null");
            return (Criteria) this;
        }

        public Criteria andAttaclIsNotNull() {
            addCriterion("attacl is not null");
            return (Criteria) this;
        }

        public Criteria andAttaclEqualTo(Object value) {
            addCriterion("attacl =", value, "attacl");
            return (Criteria) this;
        }

        public Criteria andAttaclNotEqualTo(Object value) {
            addCriterion("attacl <>", value, "attacl");
            return (Criteria) this;
        }

        public Criteria andAttaclGreaterThan(Object value) {
            addCriterion("attacl >", value, "attacl");
            return (Criteria) this;
        }

        public Criteria andAttaclGreaterThanOrEqualTo(Object value) {
            addCriterion("attacl >=", value, "attacl");
            return (Criteria) this;
        }

        public Criteria andAttaclLessThan(Object value) {
            addCriterion("attacl <", value, "attacl");
            return (Criteria) this;
        }

        public Criteria andAttaclLessThanOrEqualTo(Object value) {
            addCriterion("attacl <=", value, "attacl");
            return (Criteria) this;
        }

        public Criteria andAttaclIn(List<Object> values) {
            addCriterion("attacl in", values, "attacl");
            return (Criteria) this;
        }

        public Criteria andAttaclNotIn(List<Object> values) {
            addCriterion("attacl not in", values, "attacl");
            return (Criteria) this;
        }

        public Criteria andAttaclBetween(Object value1, Object value2) {
            addCriterion("attacl between", value1, value2, "attacl");
            return (Criteria) this;
        }

        public Criteria andAttaclNotBetween(Object value1, Object value2) {
            addCriterion("attacl not between", value1, value2, "attacl");
            return (Criteria) this;
        }

        public Criteria andAttoptionsIsNull() {
            addCriterion("attoptions is null");
            return (Criteria) this;
        }

        public Criteria andAttoptionsIsNotNull() {
            addCriterion("attoptions is not null");
            return (Criteria) this;
        }

        public Criteria andAttoptionsEqualTo(Object value) {
            addCriterion("attoptions =", value, "attoptions");
            return (Criteria) this;
        }

        public Criteria andAttoptionsNotEqualTo(Object value) {
            addCriterion("attoptions <>", value, "attoptions");
            return (Criteria) this;
        }

        public Criteria andAttoptionsGreaterThan(Object value) {
            addCriterion("attoptions >", value, "attoptions");
            return (Criteria) this;
        }

        public Criteria andAttoptionsGreaterThanOrEqualTo(Object value) {
            addCriterion("attoptions >=", value, "attoptions");
            return (Criteria) this;
        }

        public Criteria andAttoptionsLessThan(Object value) {
            addCriterion("attoptions <", value, "attoptions");
            return (Criteria) this;
        }

        public Criteria andAttoptionsLessThanOrEqualTo(Object value) {
            addCriterion("attoptions <=", value, "attoptions");
            return (Criteria) this;
        }

        public Criteria andAttoptionsIn(List<Object> values) {
            addCriterion("attoptions in", values, "attoptions");
            return (Criteria) this;
        }

        public Criteria andAttoptionsNotIn(List<Object> values) {
            addCriterion("attoptions not in", values, "attoptions");
            return (Criteria) this;
        }

        public Criteria andAttoptionsBetween(Object value1, Object value2) {
            addCriterion("attoptions between", value1, value2, "attoptions");
            return (Criteria) this;
        }

        public Criteria andAttoptionsNotBetween(Object value1, Object value2) {
            addCriterion("attoptions not between", value1, value2, "attoptions");
            return (Criteria) this;
        }

        public Criteria andAttfdwoptionsIsNull() {
            addCriterion("attfdwoptions is null");
            return (Criteria) this;
        }

        public Criteria andAttfdwoptionsIsNotNull() {
            addCriterion("attfdwoptions is not null");
            return (Criteria) this;
        }

        public Criteria andAttfdwoptionsEqualTo(Object value) {
            addCriterion("attfdwoptions =", value, "attfdwoptions");
            return (Criteria) this;
        }

        public Criteria andAttfdwoptionsNotEqualTo(Object value) {
            addCriterion("attfdwoptions <>", value, "attfdwoptions");
            return (Criteria) this;
        }

        public Criteria andAttfdwoptionsGreaterThan(Object value) {
            addCriterion("attfdwoptions >", value, "attfdwoptions");
            return (Criteria) this;
        }

        public Criteria andAttfdwoptionsGreaterThanOrEqualTo(Object value) {
            addCriterion("attfdwoptions >=", value, "attfdwoptions");
            return (Criteria) this;
        }

        public Criteria andAttfdwoptionsLessThan(Object value) {
            addCriterion("attfdwoptions <", value, "attfdwoptions");
            return (Criteria) this;
        }

        public Criteria andAttfdwoptionsLessThanOrEqualTo(Object value) {
            addCriterion("attfdwoptions <=", value, "attfdwoptions");
            return (Criteria) this;
        }

        public Criteria andAttfdwoptionsIn(List<Object> values) {
            addCriterion("attfdwoptions in", values, "attfdwoptions");
            return (Criteria) this;
        }

        public Criteria andAttfdwoptionsNotIn(List<Object> values) {
            addCriterion("attfdwoptions not in", values, "attfdwoptions");
            return (Criteria) this;
        }

        public Criteria andAttfdwoptionsBetween(Object value1, Object value2) {
            addCriterion("attfdwoptions between", value1, value2, "attfdwoptions");
            return (Criteria) this;
        }

        public Criteria andAttfdwoptionsNotBetween(Object value1, Object value2) {
            addCriterion("attfdwoptions not between", value1, value2, "attfdwoptions");
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