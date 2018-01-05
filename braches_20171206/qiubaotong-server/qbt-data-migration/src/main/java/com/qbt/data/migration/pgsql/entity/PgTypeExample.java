package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgTypeExample() {
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

        public Criteria andTypnameIsNull() {
            addCriterion("typname is null");
            return (Criteria) this;
        }

        public Criteria andTypnameIsNotNull() {
            addCriterion("typname is not null");
            return (Criteria) this;
        }

        public Criteria andTypnameEqualTo(String value) {
            addCriterion("typname =", value, "typname");
            return (Criteria) this;
        }

        public Criteria andTypnameNotEqualTo(String value) {
            addCriterion("typname <>", value, "typname");
            return (Criteria) this;
        }

        public Criteria andTypnameGreaterThan(String value) {
            addCriterion("typname >", value, "typname");
            return (Criteria) this;
        }

        public Criteria andTypnameGreaterThanOrEqualTo(String value) {
            addCriterion("typname >=", value, "typname");
            return (Criteria) this;
        }

        public Criteria andTypnameLessThan(String value) {
            addCriterion("typname <", value, "typname");
            return (Criteria) this;
        }

        public Criteria andTypnameLessThanOrEqualTo(String value) {
            addCriterion("typname <=", value, "typname");
            return (Criteria) this;
        }

        public Criteria andTypnameLike(String value) {
            addCriterion("typname like", value, "typname");
            return (Criteria) this;
        }

        public Criteria andTypnameNotLike(String value) {
            addCriterion("typname not like", value, "typname");
            return (Criteria) this;
        }

        public Criteria andTypnameIn(List<String> values) {
            addCriterion("typname in", values, "typname");
            return (Criteria) this;
        }

        public Criteria andTypnameNotIn(List<String> values) {
            addCriterion("typname not in", values, "typname");
            return (Criteria) this;
        }

        public Criteria andTypnameBetween(String value1, String value2) {
            addCriterion("typname between", value1, value2, "typname");
            return (Criteria) this;
        }

        public Criteria andTypnameNotBetween(String value1, String value2) {
            addCriterion("typname not between", value1, value2, "typname");
            return (Criteria) this;
        }

        public Criteria andTypnamespaceIsNull() {
            addCriterion("typnamespace is null");
            return (Criteria) this;
        }

        public Criteria andTypnamespaceIsNotNull() {
            addCriterion("typnamespace is not null");
            return (Criteria) this;
        }

        public Criteria andTypnamespaceEqualTo(Long value) {
            addCriterion("typnamespace =", value, "typnamespace");
            return (Criteria) this;
        }

        public Criteria andTypnamespaceNotEqualTo(Long value) {
            addCriterion("typnamespace <>", value, "typnamespace");
            return (Criteria) this;
        }

        public Criteria andTypnamespaceGreaterThan(Long value) {
            addCriterion("typnamespace >", value, "typnamespace");
            return (Criteria) this;
        }

        public Criteria andTypnamespaceGreaterThanOrEqualTo(Long value) {
            addCriterion("typnamespace >=", value, "typnamespace");
            return (Criteria) this;
        }

        public Criteria andTypnamespaceLessThan(Long value) {
            addCriterion("typnamespace <", value, "typnamespace");
            return (Criteria) this;
        }

        public Criteria andTypnamespaceLessThanOrEqualTo(Long value) {
            addCriterion("typnamespace <=", value, "typnamespace");
            return (Criteria) this;
        }

        public Criteria andTypnamespaceIn(List<Long> values) {
            addCriterion("typnamespace in", values, "typnamespace");
            return (Criteria) this;
        }

        public Criteria andTypnamespaceNotIn(List<Long> values) {
            addCriterion("typnamespace not in", values, "typnamespace");
            return (Criteria) this;
        }

        public Criteria andTypnamespaceBetween(Long value1, Long value2) {
            addCriterion("typnamespace between", value1, value2, "typnamespace");
            return (Criteria) this;
        }

        public Criteria andTypnamespaceNotBetween(Long value1, Long value2) {
            addCriterion("typnamespace not between", value1, value2, "typnamespace");
            return (Criteria) this;
        }

        public Criteria andTypownerIsNull() {
            addCriterion("typowner is null");
            return (Criteria) this;
        }

        public Criteria andTypownerIsNotNull() {
            addCriterion("typowner is not null");
            return (Criteria) this;
        }

        public Criteria andTypownerEqualTo(Long value) {
            addCriterion("typowner =", value, "typowner");
            return (Criteria) this;
        }

        public Criteria andTypownerNotEqualTo(Long value) {
            addCriterion("typowner <>", value, "typowner");
            return (Criteria) this;
        }

        public Criteria andTypownerGreaterThan(Long value) {
            addCriterion("typowner >", value, "typowner");
            return (Criteria) this;
        }

        public Criteria andTypownerGreaterThanOrEqualTo(Long value) {
            addCriterion("typowner >=", value, "typowner");
            return (Criteria) this;
        }

        public Criteria andTypownerLessThan(Long value) {
            addCriterion("typowner <", value, "typowner");
            return (Criteria) this;
        }

        public Criteria andTypownerLessThanOrEqualTo(Long value) {
            addCriterion("typowner <=", value, "typowner");
            return (Criteria) this;
        }

        public Criteria andTypownerIn(List<Long> values) {
            addCriterion("typowner in", values, "typowner");
            return (Criteria) this;
        }

        public Criteria andTypownerNotIn(List<Long> values) {
            addCriterion("typowner not in", values, "typowner");
            return (Criteria) this;
        }

        public Criteria andTypownerBetween(Long value1, Long value2) {
            addCriterion("typowner between", value1, value2, "typowner");
            return (Criteria) this;
        }

        public Criteria andTypownerNotBetween(Long value1, Long value2) {
            addCriterion("typowner not between", value1, value2, "typowner");
            return (Criteria) this;
        }

        public Criteria andTyplenIsNull() {
            addCriterion("typlen is null");
            return (Criteria) this;
        }

        public Criteria andTyplenIsNotNull() {
            addCriterion("typlen is not null");
            return (Criteria) this;
        }

        public Criteria andTyplenEqualTo(Short value) {
            addCriterion("typlen =", value, "typlen");
            return (Criteria) this;
        }

        public Criteria andTyplenNotEqualTo(Short value) {
            addCriterion("typlen <>", value, "typlen");
            return (Criteria) this;
        }

        public Criteria andTyplenGreaterThan(Short value) {
            addCriterion("typlen >", value, "typlen");
            return (Criteria) this;
        }

        public Criteria andTyplenGreaterThanOrEqualTo(Short value) {
            addCriterion("typlen >=", value, "typlen");
            return (Criteria) this;
        }

        public Criteria andTyplenLessThan(Short value) {
            addCriterion("typlen <", value, "typlen");
            return (Criteria) this;
        }

        public Criteria andTyplenLessThanOrEqualTo(Short value) {
            addCriterion("typlen <=", value, "typlen");
            return (Criteria) this;
        }

        public Criteria andTyplenIn(List<Short> values) {
            addCriterion("typlen in", values, "typlen");
            return (Criteria) this;
        }

        public Criteria andTyplenNotIn(List<Short> values) {
            addCriterion("typlen not in", values, "typlen");
            return (Criteria) this;
        }

        public Criteria andTyplenBetween(Short value1, Short value2) {
            addCriterion("typlen between", value1, value2, "typlen");
            return (Criteria) this;
        }

        public Criteria andTyplenNotBetween(Short value1, Short value2) {
            addCriterion("typlen not between", value1, value2, "typlen");
            return (Criteria) this;
        }

        public Criteria andTypbyvalIsNull() {
            addCriterion("typbyval is null");
            return (Criteria) this;
        }

        public Criteria andTypbyvalIsNotNull() {
            addCriterion("typbyval is not null");
            return (Criteria) this;
        }

        public Criteria andTypbyvalEqualTo(Boolean value) {
            addCriterion("typbyval =", value, "typbyval");
            return (Criteria) this;
        }

        public Criteria andTypbyvalNotEqualTo(Boolean value) {
            addCriterion("typbyval <>", value, "typbyval");
            return (Criteria) this;
        }

        public Criteria andTypbyvalGreaterThan(Boolean value) {
            addCriterion("typbyval >", value, "typbyval");
            return (Criteria) this;
        }

        public Criteria andTypbyvalGreaterThanOrEqualTo(Boolean value) {
            addCriterion("typbyval >=", value, "typbyval");
            return (Criteria) this;
        }

        public Criteria andTypbyvalLessThan(Boolean value) {
            addCriterion("typbyval <", value, "typbyval");
            return (Criteria) this;
        }

        public Criteria andTypbyvalLessThanOrEqualTo(Boolean value) {
            addCriterion("typbyval <=", value, "typbyval");
            return (Criteria) this;
        }

        public Criteria andTypbyvalIn(List<Boolean> values) {
            addCriterion("typbyval in", values, "typbyval");
            return (Criteria) this;
        }

        public Criteria andTypbyvalNotIn(List<Boolean> values) {
            addCriterion("typbyval not in", values, "typbyval");
            return (Criteria) this;
        }

        public Criteria andTypbyvalBetween(Boolean value1, Boolean value2) {
            addCriterion("typbyval between", value1, value2, "typbyval");
            return (Criteria) this;
        }

        public Criteria andTypbyvalNotBetween(Boolean value1, Boolean value2) {
            addCriterion("typbyval not between", value1, value2, "typbyval");
            return (Criteria) this;
        }

        public Criteria andTyptypeIsNull() {
            addCriterion("typtype is null");
            return (Criteria) this;
        }

        public Criteria andTyptypeIsNotNull() {
            addCriterion("typtype is not null");
            return (Criteria) this;
        }

        public Criteria andTyptypeEqualTo(String value) {
            addCriterion("typtype =", value, "typtype");
            return (Criteria) this;
        }

        public Criteria andTyptypeNotEqualTo(String value) {
            addCriterion("typtype <>", value, "typtype");
            return (Criteria) this;
        }

        public Criteria andTyptypeGreaterThan(String value) {
            addCriterion("typtype >", value, "typtype");
            return (Criteria) this;
        }

        public Criteria andTyptypeGreaterThanOrEqualTo(String value) {
            addCriterion("typtype >=", value, "typtype");
            return (Criteria) this;
        }

        public Criteria andTyptypeLessThan(String value) {
            addCriterion("typtype <", value, "typtype");
            return (Criteria) this;
        }

        public Criteria andTyptypeLessThanOrEqualTo(String value) {
            addCriterion("typtype <=", value, "typtype");
            return (Criteria) this;
        }

        public Criteria andTyptypeLike(String value) {
            addCriterion("typtype like", value, "typtype");
            return (Criteria) this;
        }

        public Criteria andTyptypeNotLike(String value) {
            addCriterion("typtype not like", value, "typtype");
            return (Criteria) this;
        }

        public Criteria andTyptypeIn(List<String> values) {
            addCriterion("typtype in", values, "typtype");
            return (Criteria) this;
        }

        public Criteria andTyptypeNotIn(List<String> values) {
            addCriterion("typtype not in", values, "typtype");
            return (Criteria) this;
        }

        public Criteria andTyptypeBetween(String value1, String value2) {
            addCriterion("typtype between", value1, value2, "typtype");
            return (Criteria) this;
        }

        public Criteria andTyptypeNotBetween(String value1, String value2) {
            addCriterion("typtype not between", value1, value2, "typtype");
            return (Criteria) this;
        }

        public Criteria andTypcategoryIsNull() {
            addCriterion("typcategory is null");
            return (Criteria) this;
        }

        public Criteria andTypcategoryIsNotNull() {
            addCriterion("typcategory is not null");
            return (Criteria) this;
        }

        public Criteria andTypcategoryEqualTo(String value) {
            addCriterion("typcategory =", value, "typcategory");
            return (Criteria) this;
        }

        public Criteria andTypcategoryNotEqualTo(String value) {
            addCriterion("typcategory <>", value, "typcategory");
            return (Criteria) this;
        }

        public Criteria andTypcategoryGreaterThan(String value) {
            addCriterion("typcategory >", value, "typcategory");
            return (Criteria) this;
        }

        public Criteria andTypcategoryGreaterThanOrEqualTo(String value) {
            addCriterion("typcategory >=", value, "typcategory");
            return (Criteria) this;
        }

        public Criteria andTypcategoryLessThan(String value) {
            addCriterion("typcategory <", value, "typcategory");
            return (Criteria) this;
        }

        public Criteria andTypcategoryLessThanOrEqualTo(String value) {
            addCriterion("typcategory <=", value, "typcategory");
            return (Criteria) this;
        }

        public Criteria andTypcategoryLike(String value) {
            addCriterion("typcategory like", value, "typcategory");
            return (Criteria) this;
        }

        public Criteria andTypcategoryNotLike(String value) {
            addCriterion("typcategory not like", value, "typcategory");
            return (Criteria) this;
        }

        public Criteria andTypcategoryIn(List<String> values) {
            addCriterion("typcategory in", values, "typcategory");
            return (Criteria) this;
        }

        public Criteria andTypcategoryNotIn(List<String> values) {
            addCriterion("typcategory not in", values, "typcategory");
            return (Criteria) this;
        }

        public Criteria andTypcategoryBetween(String value1, String value2) {
            addCriterion("typcategory between", value1, value2, "typcategory");
            return (Criteria) this;
        }

        public Criteria andTypcategoryNotBetween(String value1, String value2) {
            addCriterion("typcategory not between", value1, value2, "typcategory");
            return (Criteria) this;
        }

        public Criteria andTypispreferredIsNull() {
            addCriterion("typispreferred is null");
            return (Criteria) this;
        }

        public Criteria andTypispreferredIsNotNull() {
            addCriterion("typispreferred is not null");
            return (Criteria) this;
        }

        public Criteria andTypispreferredEqualTo(Boolean value) {
            addCriterion("typispreferred =", value, "typispreferred");
            return (Criteria) this;
        }

        public Criteria andTypispreferredNotEqualTo(Boolean value) {
            addCriterion("typispreferred <>", value, "typispreferred");
            return (Criteria) this;
        }

        public Criteria andTypispreferredGreaterThan(Boolean value) {
            addCriterion("typispreferred >", value, "typispreferred");
            return (Criteria) this;
        }

        public Criteria andTypispreferredGreaterThanOrEqualTo(Boolean value) {
            addCriterion("typispreferred >=", value, "typispreferred");
            return (Criteria) this;
        }

        public Criteria andTypispreferredLessThan(Boolean value) {
            addCriterion("typispreferred <", value, "typispreferred");
            return (Criteria) this;
        }

        public Criteria andTypispreferredLessThanOrEqualTo(Boolean value) {
            addCriterion("typispreferred <=", value, "typispreferred");
            return (Criteria) this;
        }

        public Criteria andTypispreferredIn(List<Boolean> values) {
            addCriterion("typispreferred in", values, "typispreferred");
            return (Criteria) this;
        }

        public Criteria andTypispreferredNotIn(List<Boolean> values) {
            addCriterion("typispreferred not in", values, "typispreferred");
            return (Criteria) this;
        }

        public Criteria andTypispreferredBetween(Boolean value1, Boolean value2) {
            addCriterion("typispreferred between", value1, value2, "typispreferred");
            return (Criteria) this;
        }

        public Criteria andTypispreferredNotBetween(Boolean value1, Boolean value2) {
            addCriterion("typispreferred not between", value1, value2, "typispreferred");
            return (Criteria) this;
        }

        public Criteria andTypisdefinedIsNull() {
            addCriterion("typisdefined is null");
            return (Criteria) this;
        }

        public Criteria andTypisdefinedIsNotNull() {
            addCriterion("typisdefined is not null");
            return (Criteria) this;
        }

        public Criteria andTypisdefinedEqualTo(Boolean value) {
            addCriterion("typisdefined =", value, "typisdefined");
            return (Criteria) this;
        }

        public Criteria andTypisdefinedNotEqualTo(Boolean value) {
            addCriterion("typisdefined <>", value, "typisdefined");
            return (Criteria) this;
        }

        public Criteria andTypisdefinedGreaterThan(Boolean value) {
            addCriterion("typisdefined >", value, "typisdefined");
            return (Criteria) this;
        }

        public Criteria andTypisdefinedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("typisdefined >=", value, "typisdefined");
            return (Criteria) this;
        }

        public Criteria andTypisdefinedLessThan(Boolean value) {
            addCriterion("typisdefined <", value, "typisdefined");
            return (Criteria) this;
        }

        public Criteria andTypisdefinedLessThanOrEqualTo(Boolean value) {
            addCriterion("typisdefined <=", value, "typisdefined");
            return (Criteria) this;
        }

        public Criteria andTypisdefinedIn(List<Boolean> values) {
            addCriterion("typisdefined in", values, "typisdefined");
            return (Criteria) this;
        }

        public Criteria andTypisdefinedNotIn(List<Boolean> values) {
            addCriterion("typisdefined not in", values, "typisdefined");
            return (Criteria) this;
        }

        public Criteria andTypisdefinedBetween(Boolean value1, Boolean value2) {
            addCriterion("typisdefined between", value1, value2, "typisdefined");
            return (Criteria) this;
        }

        public Criteria andTypisdefinedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("typisdefined not between", value1, value2, "typisdefined");
            return (Criteria) this;
        }

        public Criteria andTypdelimIsNull() {
            addCriterion("typdelim is null");
            return (Criteria) this;
        }

        public Criteria andTypdelimIsNotNull() {
            addCriterion("typdelim is not null");
            return (Criteria) this;
        }

        public Criteria andTypdelimEqualTo(String value) {
            addCriterion("typdelim =", value, "typdelim");
            return (Criteria) this;
        }

        public Criteria andTypdelimNotEqualTo(String value) {
            addCriterion("typdelim <>", value, "typdelim");
            return (Criteria) this;
        }

        public Criteria andTypdelimGreaterThan(String value) {
            addCriterion("typdelim >", value, "typdelim");
            return (Criteria) this;
        }

        public Criteria andTypdelimGreaterThanOrEqualTo(String value) {
            addCriterion("typdelim >=", value, "typdelim");
            return (Criteria) this;
        }

        public Criteria andTypdelimLessThan(String value) {
            addCriterion("typdelim <", value, "typdelim");
            return (Criteria) this;
        }

        public Criteria andTypdelimLessThanOrEqualTo(String value) {
            addCriterion("typdelim <=", value, "typdelim");
            return (Criteria) this;
        }

        public Criteria andTypdelimLike(String value) {
            addCriterion("typdelim like", value, "typdelim");
            return (Criteria) this;
        }

        public Criteria andTypdelimNotLike(String value) {
            addCriterion("typdelim not like", value, "typdelim");
            return (Criteria) this;
        }

        public Criteria andTypdelimIn(List<String> values) {
            addCriterion("typdelim in", values, "typdelim");
            return (Criteria) this;
        }

        public Criteria andTypdelimNotIn(List<String> values) {
            addCriterion("typdelim not in", values, "typdelim");
            return (Criteria) this;
        }

        public Criteria andTypdelimBetween(String value1, String value2) {
            addCriterion("typdelim between", value1, value2, "typdelim");
            return (Criteria) this;
        }

        public Criteria andTypdelimNotBetween(String value1, String value2) {
            addCriterion("typdelim not between", value1, value2, "typdelim");
            return (Criteria) this;
        }

        public Criteria andTyprelidIsNull() {
            addCriterion("typrelid is null");
            return (Criteria) this;
        }

        public Criteria andTyprelidIsNotNull() {
            addCriterion("typrelid is not null");
            return (Criteria) this;
        }

        public Criteria andTyprelidEqualTo(Long value) {
            addCriterion("typrelid =", value, "typrelid");
            return (Criteria) this;
        }

        public Criteria andTyprelidNotEqualTo(Long value) {
            addCriterion("typrelid <>", value, "typrelid");
            return (Criteria) this;
        }

        public Criteria andTyprelidGreaterThan(Long value) {
            addCriterion("typrelid >", value, "typrelid");
            return (Criteria) this;
        }

        public Criteria andTyprelidGreaterThanOrEqualTo(Long value) {
            addCriterion("typrelid >=", value, "typrelid");
            return (Criteria) this;
        }

        public Criteria andTyprelidLessThan(Long value) {
            addCriterion("typrelid <", value, "typrelid");
            return (Criteria) this;
        }

        public Criteria andTyprelidLessThanOrEqualTo(Long value) {
            addCriterion("typrelid <=", value, "typrelid");
            return (Criteria) this;
        }

        public Criteria andTyprelidIn(List<Long> values) {
            addCriterion("typrelid in", values, "typrelid");
            return (Criteria) this;
        }

        public Criteria andTyprelidNotIn(List<Long> values) {
            addCriterion("typrelid not in", values, "typrelid");
            return (Criteria) this;
        }

        public Criteria andTyprelidBetween(Long value1, Long value2) {
            addCriterion("typrelid between", value1, value2, "typrelid");
            return (Criteria) this;
        }

        public Criteria andTyprelidNotBetween(Long value1, Long value2) {
            addCriterion("typrelid not between", value1, value2, "typrelid");
            return (Criteria) this;
        }

        public Criteria andTypelemIsNull() {
            addCriterion("typelem is null");
            return (Criteria) this;
        }

        public Criteria andTypelemIsNotNull() {
            addCriterion("typelem is not null");
            return (Criteria) this;
        }

        public Criteria andTypelemEqualTo(Long value) {
            addCriterion("typelem =", value, "typelem");
            return (Criteria) this;
        }

        public Criteria andTypelemNotEqualTo(Long value) {
            addCriterion("typelem <>", value, "typelem");
            return (Criteria) this;
        }

        public Criteria andTypelemGreaterThan(Long value) {
            addCriterion("typelem >", value, "typelem");
            return (Criteria) this;
        }

        public Criteria andTypelemGreaterThanOrEqualTo(Long value) {
            addCriterion("typelem >=", value, "typelem");
            return (Criteria) this;
        }

        public Criteria andTypelemLessThan(Long value) {
            addCriterion("typelem <", value, "typelem");
            return (Criteria) this;
        }

        public Criteria andTypelemLessThanOrEqualTo(Long value) {
            addCriterion("typelem <=", value, "typelem");
            return (Criteria) this;
        }

        public Criteria andTypelemIn(List<Long> values) {
            addCriterion("typelem in", values, "typelem");
            return (Criteria) this;
        }

        public Criteria andTypelemNotIn(List<Long> values) {
            addCriterion("typelem not in", values, "typelem");
            return (Criteria) this;
        }

        public Criteria andTypelemBetween(Long value1, Long value2) {
            addCriterion("typelem between", value1, value2, "typelem");
            return (Criteria) this;
        }

        public Criteria andTypelemNotBetween(Long value1, Long value2) {
            addCriterion("typelem not between", value1, value2, "typelem");
            return (Criteria) this;
        }

        public Criteria andTyparrayIsNull() {
            addCriterion("typarray is null");
            return (Criteria) this;
        }

        public Criteria andTyparrayIsNotNull() {
            addCriterion("typarray is not null");
            return (Criteria) this;
        }

        public Criteria andTyparrayEqualTo(Long value) {
            addCriterion("typarray =", value, "typarray");
            return (Criteria) this;
        }

        public Criteria andTyparrayNotEqualTo(Long value) {
            addCriterion("typarray <>", value, "typarray");
            return (Criteria) this;
        }

        public Criteria andTyparrayGreaterThan(Long value) {
            addCriterion("typarray >", value, "typarray");
            return (Criteria) this;
        }

        public Criteria andTyparrayGreaterThanOrEqualTo(Long value) {
            addCriterion("typarray >=", value, "typarray");
            return (Criteria) this;
        }

        public Criteria andTyparrayLessThan(Long value) {
            addCriterion("typarray <", value, "typarray");
            return (Criteria) this;
        }

        public Criteria andTyparrayLessThanOrEqualTo(Long value) {
            addCriterion("typarray <=", value, "typarray");
            return (Criteria) this;
        }

        public Criteria andTyparrayIn(List<Long> values) {
            addCriterion("typarray in", values, "typarray");
            return (Criteria) this;
        }

        public Criteria andTyparrayNotIn(List<Long> values) {
            addCriterion("typarray not in", values, "typarray");
            return (Criteria) this;
        }

        public Criteria andTyparrayBetween(Long value1, Long value2) {
            addCriterion("typarray between", value1, value2, "typarray");
            return (Criteria) this;
        }

        public Criteria andTyparrayNotBetween(Long value1, Long value2) {
            addCriterion("typarray not between", value1, value2, "typarray");
            return (Criteria) this;
        }

        public Criteria andTypinputIsNull() {
            addCriterion("typinput is null");
            return (Criteria) this;
        }

        public Criteria andTypinputIsNotNull() {
            addCriterion("typinput is not null");
            return (Criteria) this;
        }

        public Criteria andTypinputEqualTo(Object value) {
            addCriterion("typinput =", value, "typinput");
            return (Criteria) this;
        }

        public Criteria andTypinputNotEqualTo(Object value) {
            addCriterion("typinput <>", value, "typinput");
            return (Criteria) this;
        }

        public Criteria andTypinputGreaterThan(Object value) {
            addCriterion("typinput >", value, "typinput");
            return (Criteria) this;
        }

        public Criteria andTypinputGreaterThanOrEqualTo(Object value) {
            addCriterion("typinput >=", value, "typinput");
            return (Criteria) this;
        }

        public Criteria andTypinputLessThan(Object value) {
            addCriterion("typinput <", value, "typinput");
            return (Criteria) this;
        }

        public Criteria andTypinputLessThanOrEqualTo(Object value) {
            addCriterion("typinput <=", value, "typinput");
            return (Criteria) this;
        }

        public Criteria andTypinputIn(List<Object> values) {
            addCriterion("typinput in", values, "typinput");
            return (Criteria) this;
        }

        public Criteria andTypinputNotIn(List<Object> values) {
            addCriterion("typinput not in", values, "typinput");
            return (Criteria) this;
        }

        public Criteria andTypinputBetween(Object value1, Object value2) {
            addCriterion("typinput between", value1, value2, "typinput");
            return (Criteria) this;
        }

        public Criteria andTypinputNotBetween(Object value1, Object value2) {
            addCriterion("typinput not between", value1, value2, "typinput");
            return (Criteria) this;
        }

        public Criteria andTypoutputIsNull() {
            addCriterion("typoutput is null");
            return (Criteria) this;
        }

        public Criteria andTypoutputIsNotNull() {
            addCriterion("typoutput is not null");
            return (Criteria) this;
        }

        public Criteria andTypoutputEqualTo(Object value) {
            addCriterion("typoutput =", value, "typoutput");
            return (Criteria) this;
        }

        public Criteria andTypoutputNotEqualTo(Object value) {
            addCriterion("typoutput <>", value, "typoutput");
            return (Criteria) this;
        }

        public Criteria andTypoutputGreaterThan(Object value) {
            addCriterion("typoutput >", value, "typoutput");
            return (Criteria) this;
        }

        public Criteria andTypoutputGreaterThanOrEqualTo(Object value) {
            addCriterion("typoutput >=", value, "typoutput");
            return (Criteria) this;
        }

        public Criteria andTypoutputLessThan(Object value) {
            addCriterion("typoutput <", value, "typoutput");
            return (Criteria) this;
        }

        public Criteria andTypoutputLessThanOrEqualTo(Object value) {
            addCriterion("typoutput <=", value, "typoutput");
            return (Criteria) this;
        }

        public Criteria andTypoutputIn(List<Object> values) {
            addCriterion("typoutput in", values, "typoutput");
            return (Criteria) this;
        }

        public Criteria andTypoutputNotIn(List<Object> values) {
            addCriterion("typoutput not in", values, "typoutput");
            return (Criteria) this;
        }

        public Criteria andTypoutputBetween(Object value1, Object value2) {
            addCriterion("typoutput between", value1, value2, "typoutput");
            return (Criteria) this;
        }

        public Criteria andTypoutputNotBetween(Object value1, Object value2) {
            addCriterion("typoutput not between", value1, value2, "typoutput");
            return (Criteria) this;
        }

        public Criteria andTypreceiveIsNull() {
            addCriterion("typreceive is null");
            return (Criteria) this;
        }

        public Criteria andTypreceiveIsNotNull() {
            addCriterion("typreceive is not null");
            return (Criteria) this;
        }

        public Criteria andTypreceiveEqualTo(Object value) {
            addCriterion("typreceive =", value, "typreceive");
            return (Criteria) this;
        }

        public Criteria andTypreceiveNotEqualTo(Object value) {
            addCriterion("typreceive <>", value, "typreceive");
            return (Criteria) this;
        }

        public Criteria andTypreceiveGreaterThan(Object value) {
            addCriterion("typreceive >", value, "typreceive");
            return (Criteria) this;
        }

        public Criteria andTypreceiveGreaterThanOrEqualTo(Object value) {
            addCriterion("typreceive >=", value, "typreceive");
            return (Criteria) this;
        }

        public Criteria andTypreceiveLessThan(Object value) {
            addCriterion("typreceive <", value, "typreceive");
            return (Criteria) this;
        }

        public Criteria andTypreceiveLessThanOrEqualTo(Object value) {
            addCriterion("typreceive <=", value, "typreceive");
            return (Criteria) this;
        }

        public Criteria andTypreceiveIn(List<Object> values) {
            addCriterion("typreceive in", values, "typreceive");
            return (Criteria) this;
        }

        public Criteria andTypreceiveNotIn(List<Object> values) {
            addCriterion("typreceive not in", values, "typreceive");
            return (Criteria) this;
        }

        public Criteria andTypreceiveBetween(Object value1, Object value2) {
            addCriterion("typreceive between", value1, value2, "typreceive");
            return (Criteria) this;
        }

        public Criteria andTypreceiveNotBetween(Object value1, Object value2) {
            addCriterion("typreceive not between", value1, value2, "typreceive");
            return (Criteria) this;
        }

        public Criteria andTypsendIsNull() {
            addCriterion("typsend is null");
            return (Criteria) this;
        }

        public Criteria andTypsendIsNotNull() {
            addCriterion("typsend is not null");
            return (Criteria) this;
        }

        public Criteria andTypsendEqualTo(Object value) {
            addCriterion("typsend =", value, "typsend");
            return (Criteria) this;
        }

        public Criteria andTypsendNotEqualTo(Object value) {
            addCriterion("typsend <>", value, "typsend");
            return (Criteria) this;
        }

        public Criteria andTypsendGreaterThan(Object value) {
            addCriterion("typsend >", value, "typsend");
            return (Criteria) this;
        }

        public Criteria andTypsendGreaterThanOrEqualTo(Object value) {
            addCriterion("typsend >=", value, "typsend");
            return (Criteria) this;
        }

        public Criteria andTypsendLessThan(Object value) {
            addCriterion("typsend <", value, "typsend");
            return (Criteria) this;
        }

        public Criteria andTypsendLessThanOrEqualTo(Object value) {
            addCriterion("typsend <=", value, "typsend");
            return (Criteria) this;
        }

        public Criteria andTypsendIn(List<Object> values) {
            addCriterion("typsend in", values, "typsend");
            return (Criteria) this;
        }

        public Criteria andTypsendNotIn(List<Object> values) {
            addCriterion("typsend not in", values, "typsend");
            return (Criteria) this;
        }

        public Criteria andTypsendBetween(Object value1, Object value2) {
            addCriterion("typsend between", value1, value2, "typsend");
            return (Criteria) this;
        }

        public Criteria andTypsendNotBetween(Object value1, Object value2) {
            addCriterion("typsend not between", value1, value2, "typsend");
            return (Criteria) this;
        }

        public Criteria andTypmodinIsNull() {
            addCriterion("typmodin is null");
            return (Criteria) this;
        }

        public Criteria andTypmodinIsNotNull() {
            addCriterion("typmodin is not null");
            return (Criteria) this;
        }

        public Criteria andTypmodinEqualTo(Object value) {
            addCriterion("typmodin =", value, "typmodin");
            return (Criteria) this;
        }

        public Criteria andTypmodinNotEqualTo(Object value) {
            addCriterion("typmodin <>", value, "typmodin");
            return (Criteria) this;
        }

        public Criteria andTypmodinGreaterThan(Object value) {
            addCriterion("typmodin >", value, "typmodin");
            return (Criteria) this;
        }

        public Criteria andTypmodinGreaterThanOrEqualTo(Object value) {
            addCriterion("typmodin >=", value, "typmodin");
            return (Criteria) this;
        }

        public Criteria andTypmodinLessThan(Object value) {
            addCriterion("typmodin <", value, "typmodin");
            return (Criteria) this;
        }

        public Criteria andTypmodinLessThanOrEqualTo(Object value) {
            addCriterion("typmodin <=", value, "typmodin");
            return (Criteria) this;
        }

        public Criteria andTypmodinIn(List<Object> values) {
            addCriterion("typmodin in", values, "typmodin");
            return (Criteria) this;
        }

        public Criteria andTypmodinNotIn(List<Object> values) {
            addCriterion("typmodin not in", values, "typmodin");
            return (Criteria) this;
        }

        public Criteria andTypmodinBetween(Object value1, Object value2) {
            addCriterion("typmodin between", value1, value2, "typmodin");
            return (Criteria) this;
        }

        public Criteria andTypmodinNotBetween(Object value1, Object value2) {
            addCriterion("typmodin not between", value1, value2, "typmodin");
            return (Criteria) this;
        }

        public Criteria andTypmodoutIsNull() {
            addCriterion("typmodout is null");
            return (Criteria) this;
        }

        public Criteria andTypmodoutIsNotNull() {
            addCriterion("typmodout is not null");
            return (Criteria) this;
        }

        public Criteria andTypmodoutEqualTo(Object value) {
            addCriterion("typmodout =", value, "typmodout");
            return (Criteria) this;
        }

        public Criteria andTypmodoutNotEqualTo(Object value) {
            addCriterion("typmodout <>", value, "typmodout");
            return (Criteria) this;
        }

        public Criteria andTypmodoutGreaterThan(Object value) {
            addCriterion("typmodout >", value, "typmodout");
            return (Criteria) this;
        }

        public Criteria andTypmodoutGreaterThanOrEqualTo(Object value) {
            addCriterion("typmodout >=", value, "typmodout");
            return (Criteria) this;
        }

        public Criteria andTypmodoutLessThan(Object value) {
            addCriterion("typmodout <", value, "typmodout");
            return (Criteria) this;
        }

        public Criteria andTypmodoutLessThanOrEqualTo(Object value) {
            addCriterion("typmodout <=", value, "typmodout");
            return (Criteria) this;
        }

        public Criteria andTypmodoutIn(List<Object> values) {
            addCriterion("typmodout in", values, "typmodout");
            return (Criteria) this;
        }

        public Criteria andTypmodoutNotIn(List<Object> values) {
            addCriterion("typmodout not in", values, "typmodout");
            return (Criteria) this;
        }

        public Criteria andTypmodoutBetween(Object value1, Object value2) {
            addCriterion("typmodout between", value1, value2, "typmodout");
            return (Criteria) this;
        }

        public Criteria andTypmodoutNotBetween(Object value1, Object value2) {
            addCriterion("typmodout not between", value1, value2, "typmodout");
            return (Criteria) this;
        }

        public Criteria andTypanalyzeIsNull() {
            addCriterion("typanalyze is null");
            return (Criteria) this;
        }

        public Criteria andTypanalyzeIsNotNull() {
            addCriterion("typanalyze is not null");
            return (Criteria) this;
        }

        public Criteria andTypanalyzeEqualTo(Object value) {
            addCriterion("typanalyze =", value, "typanalyze");
            return (Criteria) this;
        }

        public Criteria andTypanalyzeNotEqualTo(Object value) {
            addCriterion("typanalyze <>", value, "typanalyze");
            return (Criteria) this;
        }

        public Criteria andTypanalyzeGreaterThan(Object value) {
            addCriterion("typanalyze >", value, "typanalyze");
            return (Criteria) this;
        }

        public Criteria andTypanalyzeGreaterThanOrEqualTo(Object value) {
            addCriterion("typanalyze >=", value, "typanalyze");
            return (Criteria) this;
        }

        public Criteria andTypanalyzeLessThan(Object value) {
            addCriterion("typanalyze <", value, "typanalyze");
            return (Criteria) this;
        }

        public Criteria andTypanalyzeLessThanOrEqualTo(Object value) {
            addCriterion("typanalyze <=", value, "typanalyze");
            return (Criteria) this;
        }

        public Criteria andTypanalyzeIn(List<Object> values) {
            addCriterion("typanalyze in", values, "typanalyze");
            return (Criteria) this;
        }

        public Criteria andTypanalyzeNotIn(List<Object> values) {
            addCriterion("typanalyze not in", values, "typanalyze");
            return (Criteria) this;
        }

        public Criteria andTypanalyzeBetween(Object value1, Object value2) {
            addCriterion("typanalyze between", value1, value2, "typanalyze");
            return (Criteria) this;
        }

        public Criteria andTypanalyzeNotBetween(Object value1, Object value2) {
            addCriterion("typanalyze not between", value1, value2, "typanalyze");
            return (Criteria) this;
        }

        public Criteria andTypalignIsNull() {
            addCriterion("typalign is null");
            return (Criteria) this;
        }

        public Criteria andTypalignIsNotNull() {
            addCriterion("typalign is not null");
            return (Criteria) this;
        }

        public Criteria andTypalignEqualTo(String value) {
            addCriterion("typalign =", value, "typalign");
            return (Criteria) this;
        }

        public Criteria andTypalignNotEqualTo(String value) {
            addCriterion("typalign <>", value, "typalign");
            return (Criteria) this;
        }

        public Criteria andTypalignGreaterThan(String value) {
            addCriterion("typalign >", value, "typalign");
            return (Criteria) this;
        }

        public Criteria andTypalignGreaterThanOrEqualTo(String value) {
            addCriterion("typalign >=", value, "typalign");
            return (Criteria) this;
        }

        public Criteria andTypalignLessThan(String value) {
            addCriterion("typalign <", value, "typalign");
            return (Criteria) this;
        }

        public Criteria andTypalignLessThanOrEqualTo(String value) {
            addCriterion("typalign <=", value, "typalign");
            return (Criteria) this;
        }

        public Criteria andTypalignLike(String value) {
            addCriterion("typalign like", value, "typalign");
            return (Criteria) this;
        }

        public Criteria andTypalignNotLike(String value) {
            addCriterion("typalign not like", value, "typalign");
            return (Criteria) this;
        }

        public Criteria andTypalignIn(List<String> values) {
            addCriterion("typalign in", values, "typalign");
            return (Criteria) this;
        }

        public Criteria andTypalignNotIn(List<String> values) {
            addCriterion("typalign not in", values, "typalign");
            return (Criteria) this;
        }

        public Criteria andTypalignBetween(String value1, String value2) {
            addCriterion("typalign between", value1, value2, "typalign");
            return (Criteria) this;
        }

        public Criteria andTypalignNotBetween(String value1, String value2) {
            addCriterion("typalign not between", value1, value2, "typalign");
            return (Criteria) this;
        }

        public Criteria andTypstorageIsNull() {
            addCriterion("typstorage is null");
            return (Criteria) this;
        }

        public Criteria andTypstorageIsNotNull() {
            addCriterion("typstorage is not null");
            return (Criteria) this;
        }

        public Criteria andTypstorageEqualTo(String value) {
            addCriterion("typstorage =", value, "typstorage");
            return (Criteria) this;
        }

        public Criteria andTypstorageNotEqualTo(String value) {
            addCriterion("typstorage <>", value, "typstorage");
            return (Criteria) this;
        }

        public Criteria andTypstorageGreaterThan(String value) {
            addCriterion("typstorage >", value, "typstorage");
            return (Criteria) this;
        }

        public Criteria andTypstorageGreaterThanOrEqualTo(String value) {
            addCriterion("typstorage >=", value, "typstorage");
            return (Criteria) this;
        }

        public Criteria andTypstorageLessThan(String value) {
            addCriterion("typstorage <", value, "typstorage");
            return (Criteria) this;
        }

        public Criteria andTypstorageLessThanOrEqualTo(String value) {
            addCriterion("typstorage <=", value, "typstorage");
            return (Criteria) this;
        }

        public Criteria andTypstorageLike(String value) {
            addCriterion("typstorage like", value, "typstorage");
            return (Criteria) this;
        }

        public Criteria andTypstorageNotLike(String value) {
            addCriterion("typstorage not like", value, "typstorage");
            return (Criteria) this;
        }

        public Criteria andTypstorageIn(List<String> values) {
            addCriterion("typstorage in", values, "typstorage");
            return (Criteria) this;
        }

        public Criteria andTypstorageNotIn(List<String> values) {
            addCriterion("typstorage not in", values, "typstorage");
            return (Criteria) this;
        }

        public Criteria andTypstorageBetween(String value1, String value2) {
            addCriterion("typstorage between", value1, value2, "typstorage");
            return (Criteria) this;
        }

        public Criteria andTypstorageNotBetween(String value1, String value2) {
            addCriterion("typstorage not between", value1, value2, "typstorage");
            return (Criteria) this;
        }

        public Criteria andTypnotnullIsNull() {
            addCriterion("typnotnull is null");
            return (Criteria) this;
        }

        public Criteria andTypnotnullIsNotNull() {
            addCriterion("typnotnull is not null");
            return (Criteria) this;
        }

        public Criteria andTypnotnullEqualTo(Boolean value) {
            addCriterion("typnotnull =", value, "typnotnull");
            return (Criteria) this;
        }

        public Criteria andTypnotnullNotEqualTo(Boolean value) {
            addCriterion("typnotnull <>", value, "typnotnull");
            return (Criteria) this;
        }

        public Criteria andTypnotnullGreaterThan(Boolean value) {
            addCriterion("typnotnull >", value, "typnotnull");
            return (Criteria) this;
        }

        public Criteria andTypnotnullGreaterThanOrEqualTo(Boolean value) {
            addCriterion("typnotnull >=", value, "typnotnull");
            return (Criteria) this;
        }

        public Criteria andTypnotnullLessThan(Boolean value) {
            addCriterion("typnotnull <", value, "typnotnull");
            return (Criteria) this;
        }

        public Criteria andTypnotnullLessThanOrEqualTo(Boolean value) {
            addCriterion("typnotnull <=", value, "typnotnull");
            return (Criteria) this;
        }

        public Criteria andTypnotnullIn(List<Boolean> values) {
            addCriterion("typnotnull in", values, "typnotnull");
            return (Criteria) this;
        }

        public Criteria andTypnotnullNotIn(List<Boolean> values) {
            addCriterion("typnotnull not in", values, "typnotnull");
            return (Criteria) this;
        }

        public Criteria andTypnotnullBetween(Boolean value1, Boolean value2) {
            addCriterion("typnotnull between", value1, value2, "typnotnull");
            return (Criteria) this;
        }

        public Criteria andTypnotnullNotBetween(Boolean value1, Boolean value2) {
            addCriterion("typnotnull not between", value1, value2, "typnotnull");
            return (Criteria) this;
        }

        public Criteria andTypbasetypeIsNull() {
            addCriterion("typbasetype is null");
            return (Criteria) this;
        }

        public Criteria andTypbasetypeIsNotNull() {
            addCriterion("typbasetype is not null");
            return (Criteria) this;
        }

        public Criteria andTypbasetypeEqualTo(Long value) {
            addCriterion("typbasetype =", value, "typbasetype");
            return (Criteria) this;
        }

        public Criteria andTypbasetypeNotEqualTo(Long value) {
            addCriterion("typbasetype <>", value, "typbasetype");
            return (Criteria) this;
        }

        public Criteria andTypbasetypeGreaterThan(Long value) {
            addCriterion("typbasetype >", value, "typbasetype");
            return (Criteria) this;
        }

        public Criteria andTypbasetypeGreaterThanOrEqualTo(Long value) {
            addCriterion("typbasetype >=", value, "typbasetype");
            return (Criteria) this;
        }

        public Criteria andTypbasetypeLessThan(Long value) {
            addCriterion("typbasetype <", value, "typbasetype");
            return (Criteria) this;
        }

        public Criteria andTypbasetypeLessThanOrEqualTo(Long value) {
            addCriterion("typbasetype <=", value, "typbasetype");
            return (Criteria) this;
        }

        public Criteria andTypbasetypeIn(List<Long> values) {
            addCriterion("typbasetype in", values, "typbasetype");
            return (Criteria) this;
        }

        public Criteria andTypbasetypeNotIn(List<Long> values) {
            addCriterion("typbasetype not in", values, "typbasetype");
            return (Criteria) this;
        }

        public Criteria andTypbasetypeBetween(Long value1, Long value2) {
            addCriterion("typbasetype between", value1, value2, "typbasetype");
            return (Criteria) this;
        }

        public Criteria andTypbasetypeNotBetween(Long value1, Long value2) {
            addCriterion("typbasetype not between", value1, value2, "typbasetype");
            return (Criteria) this;
        }

        public Criteria andTyptypmodIsNull() {
            addCriterion("typtypmod is null");
            return (Criteria) this;
        }

        public Criteria andTyptypmodIsNotNull() {
            addCriterion("typtypmod is not null");
            return (Criteria) this;
        }

        public Criteria andTyptypmodEqualTo(Integer value) {
            addCriterion("typtypmod =", value, "typtypmod");
            return (Criteria) this;
        }

        public Criteria andTyptypmodNotEqualTo(Integer value) {
            addCriterion("typtypmod <>", value, "typtypmod");
            return (Criteria) this;
        }

        public Criteria andTyptypmodGreaterThan(Integer value) {
            addCriterion("typtypmod >", value, "typtypmod");
            return (Criteria) this;
        }

        public Criteria andTyptypmodGreaterThanOrEqualTo(Integer value) {
            addCriterion("typtypmod >=", value, "typtypmod");
            return (Criteria) this;
        }

        public Criteria andTyptypmodLessThan(Integer value) {
            addCriterion("typtypmod <", value, "typtypmod");
            return (Criteria) this;
        }

        public Criteria andTyptypmodLessThanOrEqualTo(Integer value) {
            addCriterion("typtypmod <=", value, "typtypmod");
            return (Criteria) this;
        }

        public Criteria andTyptypmodIn(List<Integer> values) {
            addCriterion("typtypmod in", values, "typtypmod");
            return (Criteria) this;
        }

        public Criteria andTyptypmodNotIn(List<Integer> values) {
            addCriterion("typtypmod not in", values, "typtypmod");
            return (Criteria) this;
        }

        public Criteria andTyptypmodBetween(Integer value1, Integer value2) {
            addCriterion("typtypmod between", value1, value2, "typtypmod");
            return (Criteria) this;
        }

        public Criteria andTyptypmodNotBetween(Integer value1, Integer value2) {
            addCriterion("typtypmod not between", value1, value2, "typtypmod");
            return (Criteria) this;
        }

        public Criteria andTypndimsIsNull() {
            addCriterion("typndims is null");
            return (Criteria) this;
        }

        public Criteria andTypndimsIsNotNull() {
            addCriterion("typndims is not null");
            return (Criteria) this;
        }

        public Criteria andTypndimsEqualTo(Integer value) {
            addCriterion("typndims =", value, "typndims");
            return (Criteria) this;
        }

        public Criteria andTypndimsNotEqualTo(Integer value) {
            addCriterion("typndims <>", value, "typndims");
            return (Criteria) this;
        }

        public Criteria andTypndimsGreaterThan(Integer value) {
            addCriterion("typndims >", value, "typndims");
            return (Criteria) this;
        }

        public Criteria andTypndimsGreaterThanOrEqualTo(Integer value) {
            addCriterion("typndims >=", value, "typndims");
            return (Criteria) this;
        }

        public Criteria andTypndimsLessThan(Integer value) {
            addCriterion("typndims <", value, "typndims");
            return (Criteria) this;
        }

        public Criteria andTypndimsLessThanOrEqualTo(Integer value) {
            addCriterion("typndims <=", value, "typndims");
            return (Criteria) this;
        }

        public Criteria andTypndimsIn(List<Integer> values) {
            addCriterion("typndims in", values, "typndims");
            return (Criteria) this;
        }

        public Criteria andTypndimsNotIn(List<Integer> values) {
            addCriterion("typndims not in", values, "typndims");
            return (Criteria) this;
        }

        public Criteria andTypndimsBetween(Integer value1, Integer value2) {
            addCriterion("typndims between", value1, value2, "typndims");
            return (Criteria) this;
        }

        public Criteria andTypndimsNotBetween(Integer value1, Integer value2) {
            addCriterion("typndims not between", value1, value2, "typndims");
            return (Criteria) this;
        }

        public Criteria andTypcollationIsNull() {
            addCriterion("typcollation is null");
            return (Criteria) this;
        }

        public Criteria andTypcollationIsNotNull() {
            addCriterion("typcollation is not null");
            return (Criteria) this;
        }

        public Criteria andTypcollationEqualTo(Long value) {
            addCriterion("typcollation =", value, "typcollation");
            return (Criteria) this;
        }

        public Criteria andTypcollationNotEqualTo(Long value) {
            addCriterion("typcollation <>", value, "typcollation");
            return (Criteria) this;
        }

        public Criteria andTypcollationGreaterThan(Long value) {
            addCriterion("typcollation >", value, "typcollation");
            return (Criteria) this;
        }

        public Criteria andTypcollationGreaterThanOrEqualTo(Long value) {
            addCriterion("typcollation >=", value, "typcollation");
            return (Criteria) this;
        }

        public Criteria andTypcollationLessThan(Long value) {
            addCriterion("typcollation <", value, "typcollation");
            return (Criteria) this;
        }

        public Criteria andTypcollationLessThanOrEqualTo(Long value) {
            addCriterion("typcollation <=", value, "typcollation");
            return (Criteria) this;
        }

        public Criteria andTypcollationIn(List<Long> values) {
            addCriterion("typcollation in", values, "typcollation");
            return (Criteria) this;
        }

        public Criteria andTypcollationNotIn(List<Long> values) {
            addCriterion("typcollation not in", values, "typcollation");
            return (Criteria) this;
        }

        public Criteria andTypcollationBetween(Long value1, Long value2) {
            addCriterion("typcollation between", value1, value2, "typcollation");
            return (Criteria) this;
        }

        public Criteria andTypcollationNotBetween(Long value1, Long value2) {
            addCriterion("typcollation not between", value1, value2, "typcollation");
            return (Criteria) this;
        }

        public Criteria andTypdefaultbinIsNull() {
            addCriterion("typdefaultbin is null");
            return (Criteria) this;
        }

        public Criteria andTypdefaultbinIsNotNull() {
            addCriterion("typdefaultbin is not null");
            return (Criteria) this;
        }

        public Criteria andTypdefaultbinEqualTo(Object value) {
            addCriterion("typdefaultbin =", value, "typdefaultbin");
            return (Criteria) this;
        }

        public Criteria andTypdefaultbinNotEqualTo(Object value) {
            addCriterion("typdefaultbin <>", value, "typdefaultbin");
            return (Criteria) this;
        }

        public Criteria andTypdefaultbinGreaterThan(Object value) {
            addCriterion("typdefaultbin >", value, "typdefaultbin");
            return (Criteria) this;
        }

        public Criteria andTypdefaultbinGreaterThanOrEqualTo(Object value) {
            addCriterion("typdefaultbin >=", value, "typdefaultbin");
            return (Criteria) this;
        }

        public Criteria andTypdefaultbinLessThan(Object value) {
            addCriterion("typdefaultbin <", value, "typdefaultbin");
            return (Criteria) this;
        }

        public Criteria andTypdefaultbinLessThanOrEqualTo(Object value) {
            addCriterion("typdefaultbin <=", value, "typdefaultbin");
            return (Criteria) this;
        }

        public Criteria andTypdefaultbinIn(List<Object> values) {
            addCriterion("typdefaultbin in", values, "typdefaultbin");
            return (Criteria) this;
        }

        public Criteria andTypdefaultbinNotIn(List<Object> values) {
            addCriterion("typdefaultbin not in", values, "typdefaultbin");
            return (Criteria) this;
        }

        public Criteria andTypdefaultbinBetween(Object value1, Object value2) {
            addCriterion("typdefaultbin between", value1, value2, "typdefaultbin");
            return (Criteria) this;
        }

        public Criteria andTypdefaultbinNotBetween(Object value1, Object value2) {
            addCriterion("typdefaultbin not between", value1, value2, "typdefaultbin");
            return (Criteria) this;
        }

        public Criteria andTypdefaultIsNull() {
            addCriterion("typdefault is null");
            return (Criteria) this;
        }

        public Criteria andTypdefaultIsNotNull() {
            addCriterion("typdefault is not null");
            return (Criteria) this;
        }

        public Criteria andTypdefaultEqualTo(String value) {
            addCriterion("typdefault =", value, "typdefault");
            return (Criteria) this;
        }

        public Criteria andTypdefaultNotEqualTo(String value) {
            addCriterion("typdefault <>", value, "typdefault");
            return (Criteria) this;
        }

        public Criteria andTypdefaultGreaterThan(String value) {
            addCriterion("typdefault >", value, "typdefault");
            return (Criteria) this;
        }

        public Criteria andTypdefaultGreaterThanOrEqualTo(String value) {
            addCriterion("typdefault >=", value, "typdefault");
            return (Criteria) this;
        }

        public Criteria andTypdefaultLessThan(String value) {
            addCriterion("typdefault <", value, "typdefault");
            return (Criteria) this;
        }

        public Criteria andTypdefaultLessThanOrEqualTo(String value) {
            addCriterion("typdefault <=", value, "typdefault");
            return (Criteria) this;
        }

        public Criteria andTypdefaultLike(String value) {
            addCriterion("typdefault like", value, "typdefault");
            return (Criteria) this;
        }

        public Criteria andTypdefaultNotLike(String value) {
            addCriterion("typdefault not like", value, "typdefault");
            return (Criteria) this;
        }

        public Criteria andTypdefaultIn(List<String> values) {
            addCriterion("typdefault in", values, "typdefault");
            return (Criteria) this;
        }

        public Criteria andTypdefaultNotIn(List<String> values) {
            addCriterion("typdefault not in", values, "typdefault");
            return (Criteria) this;
        }

        public Criteria andTypdefaultBetween(String value1, String value2) {
            addCriterion("typdefault between", value1, value2, "typdefault");
            return (Criteria) this;
        }

        public Criteria andTypdefaultNotBetween(String value1, String value2) {
            addCriterion("typdefault not between", value1, value2, "typdefault");
            return (Criteria) this;
        }

        public Criteria andTypaclIsNull() {
            addCriterion("typacl is null");
            return (Criteria) this;
        }

        public Criteria andTypaclIsNotNull() {
            addCriterion("typacl is not null");
            return (Criteria) this;
        }

        public Criteria andTypaclEqualTo(Object value) {
            addCriterion("typacl =", value, "typacl");
            return (Criteria) this;
        }

        public Criteria andTypaclNotEqualTo(Object value) {
            addCriterion("typacl <>", value, "typacl");
            return (Criteria) this;
        }

        public Criteria andTypaclGreaterThan(Object value) {
            addCriterion("typacl >", value, "typacl");
            return (Criteria) this;
        }

        public Criteria andTypaclGreaterThanOrEqualTo(Object value) {
            addCriterion("typacl >=", value, "typacl");
            return (Criteria) this;
        }

        public Criteria andTypaclLessThan(Object value) {
            addCriterion("typacl <", value, "typacl");
            return (Criteria) this;
        }

        public Criteria andTypaclLessThanOrEqualTo(Object value) {
            addCriterion("typacl <=", value, "typacl");
            return (Criteria) this;
        }

        public Criteria andTypaclIn(List<Object> values) {
            addCriterion("typacl in", values, "typacl");
            return (Criteria) this;
        }

        public Criteria andTypaclNotIn(List<Object> values) {
            addCriterion("typacl not in", values, "typacl");
            return (Criteria) this;
        }

        public Criteria andTypaclBetween(Object value1, Object value2) {
            addCriterion("typacl between", value1, value2, "typacl");
            return (Criteria) this;
        }

        public Criteria andTypaclNotBetween(Object value1, Object value2) {
            addCriterion("typacl not between", value1, value2, "typacl");
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