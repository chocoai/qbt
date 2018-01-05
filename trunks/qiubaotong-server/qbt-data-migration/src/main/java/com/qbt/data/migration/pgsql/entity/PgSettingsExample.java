package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgSettingsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgSettingsExample() {
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

        public Criteria andSettingIsNull() {
            addCriterion("setting is null");
            return (Criteria) this;
        }

        public Criteria andSettingIsNotNull() {
            addCriterion("setting is not null");
            return (Criteria) this;
        }

        public Criteria andSettingEqualTo(String value) {
            addCriterion("setting =", value, "setting");
            return (Criteria) this;
        }

        public Criteria andSettingNotEqualTo(String value) {
            addCriterion("setting <>", value, "setting");
            return (Criteria) this;
        }

        public Criteria andSettingGreaterThan(String value) {
            addCriterion("setting >", value, "setting");
            return (Criteria) this;
        }

        public Criteria andSettingGreaterThanOrEqualTo(String value) {
            addCriterion("setting >=", value, "setting");
            return (Criteria) this;
        }

        public Criteria andSettingLessThan(String value) {
            addCriterion("setting <", value, "setting");
            return (Criteria) this;
        }

        public Criteria andSettingLessThanOrEqualTo(String value) {
            addCriterion("setting <=", value, "setting");
            return (Criteria) this;
        }

        public Criteria andSettingLike(String value) {
            addCriterion("setting like", value, "setting");
            return (Criteria) this;
        }

        public Criteria andSettingNotLike(String value) {
            addCriterion("setting not like", value, "setting");
            return (Criteria) this;
        }

        public Criteria andSettingIn(List<String> values) {
            addCriterion("setting in", values, "setting");
            return (Criteria) this;
        }

        public Criteria andSettingNotIn(List<String> values) {
            addCriterion("setting not in", values, "setting");
            return (Criteria) this;
        }

        public Criteria andSettingBetween(String value1, String value2) {
            addCriterion("setting between", value1, value2, "setting");
            return (Criteria) this;
        }

        public Criteria andSettingNotBetween(String value1, String value2) {
            addCriterion("setting not between", value1, value2, "setting");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andShort_descIsNull() {
            addCriterion("short_desc is null");
            return (Criteria) this;
        }

        public Criteria andShort_descIsNotNull() {
            addCriterion("short_desc is not null");
            return (Criteria) this;
        }

        public Criteria andShort_descEqualTo(String value) {
            addCriterion("short_desc =", value, "short_desc");
            return (Criteria) this;
        }

        public Criteria andShort_descNotEqualTo(String value) {
            addCriterion("short_desc <>", value, "short_desc");
            return (Criteria) this;
        }

        public Criteria andShort_descGreaterThan(String value) {
            addCriterion("short_desc >", value, "short_desc");
            return (Criteria) this;
        }

        public Criteria andShort_descGreaterThanOrEqualTo(String value) {
            addCriterion("short_desc >=", value, "short_desc");
            return (Criteria) this;
        }

        public Criteria andShort_descLessThan(String value) {
            addCriterion("short_desc <", value, "short_desc");
            return (Criteria) this;
        }

        public Criteria andShort_descLessThanOrEqualTo(String value) {
            addCriterion("short_desc <=", value, "short_desc");
            return (Criteria) this;
        }

        public Criteria andShort_descLike(String value) {
            addCriterion("short_desc like", value, "short_desc");
            return (Criteria) this;
        }

        public Criteria andShort_descNotLike(String value) {
            addCriterion("short_desc not like", value, "short_desc");
            return (Criteria) this;
        }

        public Criteria andShort_descIn(List<String> values) {
            addCriterion("short_desc in", values, "short_desc");
            return (Criteria) this;
        }

        public Criteria andShort_descNotIn(List<String> values) {
            addCriterion("short_desc not in", values, "short_desc");
            return (Criteria) this;
        }

        public Criteria andShort_descBetween(String value1, String value2) {
            addCriterion("short_desc between", value1, value2, "short_desc");
            return (Criteria) this;
        }

        public Criteria andShort_descNotBetween(String value1, String value2) {
            addCriterion("short_desc not between", value1, value2, "short_desc");
            return (Criteria) this;
        }

        public Criteria andExtra_descIsNull() {
            addCriterion("extra_desc is null");
            return (Criteria) this;
        }

        public Criteria andExtra_descIsNotNull() {
            addCriterion("extra_desc is not null");
            return (Criteria) this;
        }

        public Criteria andExtra_descEqualTo(String value) {
            addCriterion("extra_desc =", value, "extra_desc");
            return (Criteria) this;
        }

        public Criteria andExtra_descNotEqualTo(String value) {
            addCriterion("extra_desc <>", value, "extra_desc");
            return (Criteria) this;
        }

        public Criteria andExtra_descGreaterThan(String value) {
            addCriterion("extra_desc >", value, "extra_desc");
            return (Criteria) this;
        }

        public Criteria andExtra_descGreaterThanOrEqualTo(String value) {
            addCriterion("extra_desc >=", value, "extra_desc");
            return (Criteria) this;
        }

        public Criteria andExtra_descLessThan(String value) {
            addCriterion("extra_desc <", value, "extra_desc");
            return (Criteria) this;
        }

        public Criteria andExtra_descLessThanOrEqualTo(String value) {
            addCriterion("extra_desc <=", value, "extra_desc");
            return (Criteria) this;
        }

        public Criteria andExtra_descLike(String value) {
            addCriterion("extra_desc like", value, "extra_desc");
            return (Criteria) this;
        }

        public Criteria andExtra_descNotLike(String value) {
            addCriterion("extra_desc not like", value, "extra_desc");
            return (Criteria) this;
        }

        public Criteria andExtra_descIn(List<String> values) {
            addCriterion("extra_desc in", values, "extra_desc");
            return (Criteria) this;
        }

        public Criteria andExtra_descNotIn(List<String> values) {
            addCriterion("extra_desc not in", values, "extra_desc");
            return (Criteria) this;
        }

        public Criteria andExtra_descBetween(String value1, String value2) {
            addCriterion("extra_desc between", value1, value2, "extra_desc");
            return (Criteria) this;
        }

        public Criteria andExtra_descNotBetween(String value1, String value2) {
            addCriterion("extra_desc not between", value1, value2, "extra_desc");
            return (Criteria) this;
        }

        public Criteria andContextIsNull() {
            addCriterion("context is null");
            return (Criteria) this;
        }

        public Criteria andContextIsNotNull() {
            addCriterion("context is not null");
            return (Criteria) this;
        }

        public Criteria andContextEqualTo(String value) {
            addCriterion("context =", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotEqualTo(String value) {
            addCriterion("context <>", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextGreaterThan(String value) {
            addCriterion("context >", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextGreaterThanOrEqualTo(String value) {
            addCriterion("context >=", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextLessThan(String value) {
            addCriterion("context <", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextLessThanOrEqualTo(String value) {
            addCriterion("context <=", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextLike(String value) {
            addCriterion("context like", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotLike(String value) {
            addCriterion("context not like", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextIn(List<String> values) {
            addCriterion("context in", values, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotIn(List<String> values) {
            addCriterion("context not in", values, "context");
            return (Criteria) this;
        }

        public Criteria andContextBetween(String value1, String value2) {
            addCriterion("context between", value1, value2, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotBetween(String value1, String value2) {
            addCriterion("context not between", value1, value2, "context");
            return (Criteria) this;
        }

        public Criteria andVartypeIsNull() {
            addCriterion("vartype is null");
            return (Criteria) this;
        }

        public Criteria andVartypeIsNotNull() {
            addCriterion("vartype is not null");
            return (Criteria) this;
        }

        public Criteria andVartypeEqualTo(String value) {
            addCriterion("vartype =", value, "vartype");
            return (Criteria) this;
        }

        public Criteria andVartypeNotEqualTo(String value) {
            addCriterion("vartype <>", value, "vartype");
            return (Criteria) this;
        }

        public Criteria andVartypeGreaterThan(String value) {
            addCriterion("vartype >", value, "vartype");
            return (Criteria) this;
        }

        public Criteria andVartypeGreaterThanOrEqualTo(String value) {
            addCriterion("vartype >=", value, "vartype");
            return (Criteria) this;
        }

        public Criteria andVartypeLessThan(String value) {
            addCriterion("vartype <", value, "vartype");
            return (Criteria) this;
        }

        public Criteria andVartypeLessThanOrEqualTo(String value) {
            addCriterion("vartype <=", value, "vartype");
            return (Criteria) this;
        }

        public Criteria andVartypeLike(String value) {
            addCriterion("vartype like", value, "vartype");
            return (Criteria) this;
        }

        public Criteria andVartypeNotLike(String value) {
            addCriterion("vartype not like", value, "vartype");
            return (Criteria) this;
        }

        public Criteria andVartypeIn(List<String> values) {
            addCriterion("vartype in", values, "vartype");
            return (Criteria) this;
        }

        public Criteria andVartypeNotIn(List<String> values) {
            addCriterion("vartype not in", values, "vartype");
            return (Criteria) this;
        }

        public Criteria andVartypeBetween(String value1, String value2) {
            addCriterion("vartype between", value1, value2, "vartype");
            return (Criteria) this;
        }

        public Criteria andVartypeNotBetween(String value1, String value2) {
            addCriterion("vartype not between", value1, value2, "vartype");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andMin_valIsNull() {
            addCriterion("min_val is null");
            return (Criteria) this;
        }

        public Criteria andMin_valIsNotNull() {
            addCriterion("min_val is not null");
            return (Criteria) this;
        }

        public Criteria andMin_valEqualTo(String value) {
            addCriterion("min_val =", value, "min_val");
            return (Criteria) this;
        }

        public Criteria andMin_valNotEqualTo(String value) {
            addCriterion("min_val <>", value, "min_val");
            return (Criteria) this;
        }

        public Criteria andMin_valGreaterThan(String value) {
            addCriterion("min_val >", value, "min_val");
            return (Criteria) this;
        }

        public Criteria andMin_valGreaterThanOrEqualTo(String value) {
            addCriterion("min_val >=", value, "min_val");
            return (Criteria) this;
        }

        public Criteria andMin_valLessThan(String value) {
            addCriterion("min_val <", value, "min_val");
            return (Criteria) this;
        }

        public Criteria andMin_valLessThanOrEqualTo(String value) {
            addCriterion("min_val <=", value, "min_val");
            return (Criteria) this;
        }

        public Criteria andMin_valLike(String value) {
            addCriterion("min_val like", value, "min_val");
            return (Criteria) this;
        }

        public Criteria andMin_valNotLike(String value) {
            addCriterion("min_val not like", value, "min_val");
            return (Criteria) this;
        }

        public Criteria andMin_valIn(List<String> values) {
            addCriterion("min_val in", values, "min_val");
            return (Criteria) this;
        }

        public Criteria andMin_valNotIn(List<String> values) {
            addCriterion("min_val not in", values, "min_val");
            return (Criteria) this;
        }

        public Criteria andMin_valBetween(String value1, String value2) {
            addCriterion("min_val between", value1, value2, "min_val");
            return (Criteria) this;
        }

        public Criteria andMin_valNotBetween(String value1, String value2) {
            addCriterion("min_val not between", value1, value2, "min_val");
            return (Criteria) this;
        }

        public Criteria andMax_valIsNull() {
            addCriterion("max_val is null");
            return (Criteria) this;
        }

        public Criteria andMax_valIsNotNull() {
            addCriterion("max_val is not null");
            return (Criteria) this;
        }

        public Criteria andMax_valEqualTo(String value) {
            addCriterion("max_val =", value, "max_val");
            return (Criteria) this;
        }

        public Criteria andMax_valNotEqualTo(String value) {
            addCriterion("max_val <>", value, "max_val");
            return (Criteria) this;
        }

        public Criteria andMax_valGreaterThan(String value) {
            addCriterion("max_val >", value, "max_val");
            return (Criteria) this;
        }

        public Criteria andMax_valGreaterThanOrEqualTo(String value) {
            addCriterion("max_val >=", value, "max_val");
            return (Criteria) this;
        }

        public Criteria andMax_valLessThan(String value) {
            addCriterion("max_val <", value, "max_val");
            return (Criteria) this;
        }

        public Criteria andMax_valLessThanOrEqualTo(String value) {
            addCriterion("max_val <=", value, "max_val");
            return (Criteria) this;
        }

        public Criteria andMax_valLike(String value) {
            addCriterion("max_val like", value, "max_val");
            return (Criteria) this;
        }

        public Criteria andMax_valNotLike(String value) {
            addCriterion("max_val not like", value, "max_val");
            return (Criteria) this;
        }

        public Criteria andMax_valIn(List<String> values) {
            addCriterion("max_val in", values, "max_val");
            return (Criteria) this;
        }

        public Criteria andMax_valNotIn(List<String> values) {
            addCriterion("max_val not in", values, "max_val");
            return (Criteria) this;
        }

        public Criteria andMax_valBetween(String value1, String value2) {
            addCriterion("max_val between", value1, value2, "max_val");
            return (Criteria) this;
        }

        public Criteria andMax_valNotBetween(String value1, String value2) {
            addCriterion("max_val not between", value1, value2, "max_val");
            return (Criteria) this;
        }

        public Criteria andEnumvalsIsNull() {
            addCriterion("enumvals is null");
            return (Criteria) this;
        }

        public Criteria andEnumvalsIsNotNull() {
            addCriterion("enumvals is not null");
            return (Criteria) this;
        }

        public Criteria andEnumvalsEqualTo(Object value) {
            addCriterion("enumvals =", value, "enumvals");
            return (Criteria) this;
        }

        public Criteria andEnumvalsNotEqualTo(Object value) {
            addCriterion("enumvals <>", value, "enumvals");
            return (Criteria) this;
        }

        public Criteria andEnumvalsGreaterThan(Object value) {
            addCriterion("enumvals >", value, "enumvals");
            return (Criteria) this;
        }

        public Criteria andEnumvalsGreaterThanOrEqualTo(Object value) {
            addCriterion("enumvals >=", value, "enumvals");
            return (Criteria) this;
        }

        public Criteria andEnumvalsLessThan(Object value) {
            addCriterion("enumvals <", value, "enumvals");
            return (Criteria) this;
        }

        public Criteria andEnumvalsLessThanOrEqualTo(Object value) {
            addCriterion("enumvals <=", value, "enumvals");
            return (Criteria) this;
        }

        public Criteria andEnumvalsIn(List<Object> values) {
            addCriterion("enumvals in", values, "enumvals");
            return (Criteria) this;
        }

        public Criteria andEnumvalsNotIn(List<Object> values) {
            addCriterion("enumvals not in", values, "enumvals");
            return (Criteria) this;
        }

        public Criteria andEnumvalsBetween(Object value1, Object value2) {
            addCriterion("enumvals between", value1, value2, "enumvals");
            return (Criteria) this;
        }

        public Criteria andEnumvalsNotBetween(Object value1, Object value2) {
            addCriterion("enumvals not between", value1, value2, "enumvals");
            return (Criteria) this;
        }

        public Criteria andBoot_valIsNull() {
            addCriterion("boot_val is null");
            return (Criteria) this;
        }

        public Criteria andBoot_valIsNotNull() {
            addCriterion("boot_val is not null");
            return (Criteria) this;
        }

        public Criteria andBoot_valEqualTo(String value) {
            addCriterion("boot_val =", value, "boot_val");
            return (Criteria) this;
        }

        public Criteria andBoot_valNotEqualTo(String value) {
            addCriterion("boot_val <>", value, "boot_val");
            return (Criteria) this;
        }

        public Criteria andBoot_valGreaterThan(String value) {
            addCriterion("boot_val >", value, "boot_val");
            return (Criteria) this;
        }

        public Criteria andBoot_valGreaterThanOrEqualTo(String value) {
            addCriterion("boot_val >=", value, "boot_val");
            return (Criteria) this;
        }

        public Criteria andBoot_valLessThan(String value) {
            addCriterion("boot_val <", value, "boot_val");
            return (Criteria) this;
        }

        public Criteria andBoot_valLessThanOrEqualTo(String value) {
            addCriterion("boot_val <=", value, "boot_val");
            return (Criteria) this;
        }

        public Criteria andBoot_valLike(String value) {
            addCriterion("boot_val like", value, "boot_val");
            return (Criteria) this;
        }

        public Criteria andBoot_valNotLike(String value) {
            addCriterion("boot_val not like", value, "boot_val");
            return (Criteria) this;
        }

        public Criteria andBoot_valIn(List<String> values) {
            addCriterion("boot_val in", values, "boot_val");
            return (Criteria) this;
        }

        public Criteria andBoot_valNotIn(List<String> values) {
            addCriterion("boot_val not in", values, "boot_val");
            return (Criteria) this;
        }

        public Criteria andBoot_valBetween(String value1, String value2) {
            addCriterion("boot_val between", value1, value2, "boot_val");
            return (Criteria) this;
        }

        public Criteria andBoot_valNotBetween(String value1, String value2) {
            addCriterion("boot_val not between", value1, value2, "boot_val");
            return (Criteria) this;
        }

        public Criteria andReset_valIsNull() {
            addCriterion("reset_val is null");
            return (Criteria) this;
        }

        public Criteria andReset_valIsNotNull() {
            addCriterion("reset_val is not null");
            return (Criteria) this;
        }

        public Criteria andReset_valEqualTo(String value) {
            addCriterion("reset_val =", value, "reset_val");
            return (Criteria) this;
        }

        public Criteria andReset_valNotEqualTo(String value) {
            addCriterion("reset_val <>", value, "reset_val");
            return (Criteria) this;
        }

        public Criteria andReset_valGreaterThan(String value) {
            addCriterion("reset_val >", value, "reset_val");
            return (Criteria) this;
        }

        public Criteria andReset_valGreaterThanOrEqualTo(String value) {
            addCriterion("reset_val >=", value, "reset_val");
            return (Criteria) this;
        }

        public Criteria andReset_valLessThan(String value) {
            addCriterion("reset_val <", value, "reset_val");
            return (Criteria) this;
        }

        public Criteria andReset_valLessThanOrEqualTo(String value) {
            addCriterion("reset_val <=", value, "reset_val");
            return (Criteria) this;
        }

        public Criteria andReset_valLike(String value) {
            addCriterion("reset_val like", value, "reset_val");
            return (Criteria) this;
        }

        public Criteria andReset_valNotLike(String value) {
            addCriterion("reset_val not like", value, "reset_val");
            return (Criteria) this;
        }

        public Criteria andReset_valIn(List<String> values) {
            addCriterion("reset_val in", values, "reset_val");
            return (Criteria) this;
        }

        public Criteria andReset_valNotIn(List<String> values) {
            addCriterion("reset_val not in", values, "reset_val");
            return (Criteria) this;
        }

        public Criteria andReset_valBetween(String value1, String value2) {
            addCriterion("reset_val between", value1, value2, "reset_val");
            return (Criteria) this;
        }

        public Criteria andReset_valNotBetween(String value1, String value2) {
            addCriterion("reset_val not between", value1, value2, "reset_val");
            return (Criteria) this;
        }

        public Criteria andSourcefileIsNull() {
            addCriterion("sourcefile is null");
            return (Criteria) this;
        }

        public Criteria andSourcefileIsNotNull() {
            addCriterion("sourcefile is not null");
            return (Criteria) this;
        }

        public Criteria andSourcefileEqualTo(String value) {
            addCriterion("sourcefile =", value, "sourcefile");
            return (Criteria) this;
        }

        public Criteria andSourcefileNotEqualTo(String value) {
            addCriterion("sourcefile <>", value, "sourcefile");
            return (Criteria) this;
        }

        public Criteria andSourcefileGreaterThan(String value) {
            addCriterion("sourcefile >", value, "sourcefile");
            return (Criteria) this;
        }

        public Criteria andSourcefileGreaterThanOrEqualTo(String value) {
            addCriterion("sourcefile >=", value, "sourcefile");
            return (Criteria) this;
        }

        public Criteria andSourcefileLessThan(String value) {
            addCriterion("sourcefile <", value, "sourcefile");
            return (Criteria) this;
        }

        public Criteria andSourcefileLessThanOrEqualTo(String value) {
            addCriterion("sourcefile <=", value, "sourcefile");
            return (Criteria) this;
        }

        public Criteria andSourcefileLike(String value) {
            addCriterion("sourcefile like", value, "sourcefile");
            return (Criteria) this;
        }

        public Criteria andSourcefileNotLike(String value) {
            addCriterion("sourcefile not like", value, "sourcefile");
            return (Criteria) this;
        }

        public Criteria andSourcefileIn(List<String> values) {
            addCriterion("sourcefile in", values, "sourcefile");
            return (Criteria) this;
        }

        public Criteria andSourcefileNotIn(List<String> values) {
            addCriterion("sourcefile not in", values, "sourcefile");
            return (Criteria) this;
        }

        public Criteria andSourcefileBetween(String value1, String value2) {
            addCriterion("sourcefile between", value1, value2, "sourcefile");
            return (Criteria) this;
        }

        public Criteria andSourcefileNotBetween(String value1, String value2) {
            addCriterion("sourcefile not between", value1, value2, "sourcefile");
            return (Criteria) this;
        }

        public Criteria andSourcelineIsNull() {
            addCriterion("sourceline is null");
            return (Criteria) this;
        }

        public Criteria andSourcelineIsNotNull() {
            addCriterion("sourceline is not null");
            return (Criteria) this;
        }

        public Criteria andSourcelineEqualTo(Integer value) {
            addCriterion("sourceline =", value, "sourceline");
            return (Criteria) this;
        }

        public Criteria andSourcelineNotEqualTo(Integer value) {
            addCriterion("sourceline <>", value, "sourceline");
            return (Criteria) this;
        }

        public Criteria andSourcelineGreaterThan(Integer value) {
            addCriterion("sourceline >", value, "sourceline");
            return (Criteria) this;
        }

        public Criteria andSourcelineGreaterThanOrEqualTo(Integer value) {
            addCriterion("sourceline >=", value, "sourceline");
            return (Criteria) this;
        }

        public Criteria andSourcelineLessThan(Integer value) {
            addCriterion("sourceline <", value, "sourceline");
            return (Criteria) this;
        }

        public Criteria andSourcelineLessThanOrEqualTo(Integer value) {
            addCriterion("sourceline <=", value, "sourceline");
            return (Criteria) this;
        }

        public Criteria andSourcelineIn(List<Integer> values) {
            addCriterion("sourceline in", values, "sourceline");
            return (Criteria) this;
        }

        public Criteria andSourcelineNotIn(List<Integer> values) {
            addCriterion("sourceline not in", values, "sourceline");
            return (Criteria) this;
        }

        public Criteria andSourcelineBetween(Integer value1, Integer value2) {
            addCriterion("sourceline between", value1, value2, "sourceline");
            return (Criteria) this;
        }

        public Criteria andSourcelineNotBetween(Integer value1, Integer value2) {
            addCriterion("sourceline not between", value1, value2, "sourceline");
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