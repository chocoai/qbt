package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgShdependExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgShdependExample() {
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

        public Criteria andDbidIsNull() {
            addCriterion("dbid is null");
            return (Criteria) this;
        }

        public Criteria andDbidIsNotNull() {
            addCriterion("dbid is not null");
            return (Criteria) this;
        }

        public Criteria andDbidEqualTo(Long value) {
            addCriterion("dbid =", value, "dbid");
            return (Criteria) this;
        }

        public Criteria andDbidNotEqualTo(Long value) {
            addCriterion("dbid <>", value, "dbid");
            return (Criteria) this;
        }

        public Criteria andDbidGreaterThan(Long value) {
            addCriterion("dbid >", value, "dbid");
            return (Criteria) this;
        }

        public Criteria andDbidGreaterThanOrEqualTo(Long value) {
            addCriterion("dbid >=", value, "dbid");
            return (Criteria) this;
        }

        public Criteria andDbidLessThan(Long value) {
            addCriterion("dbid <", value, "dbid");
            return (Criteria) this;
        }

        public Criteria andDbidLessThanOrEqualTo(Long value) {
            addCriterion("dbid <=", value, "dbid");
            return (Criteria) this;
        }

        public Criteria andDbidIn(List<Long> values) {
            addCriterion("dbid in", values, "dbid");
            return (Criteria) this;
        }

        public Criteria andDbidNotIn(List<Long> values) {
            addCriterion("dbid not in", values, "dbid");
            return (Criteria) this;
        }

        public Criteria andDbidBetween(Long value1, Long value2) {
            addCriterion("dbid between", value1, value2, "dbid");
            return (Criteria) this;
        }

        public Criteria andDbidNotBetween(Long value1, Long value2) {
            addCriterion("dbid not between", value1, value2, "dbid");
            return (Criteria) this;
        }

        public Criteria andClassidIsNull() {
            addCriterion("classid is null");
            return (Criteria) this;
        }

        public Criteria andClassidIsNotNull() {
            addCriterion("classid is not null");
            return (Criteria) this;
        }

        public Criteria andClassidEqualTo(Long value) {
            addCriterion("classid =", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotEqualTo(Long value) {
            addCriterion("classid <>", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidGreaterThan(Long value) {
            addCriterion("classid >", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidGreaterThanOrEqualTo(Long value) {
            addCriterion("classid >=", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidLessThan(Long value) {
            addCriterion("classid <", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidLessThanOrEqualTo(Long value) {
            addCriterion("classid <=", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidIn(List<Long> values) {
            addCriterion("classid in", values, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotIn(List<Long> values) {
            addCriterion("classid not in", values, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidBetween(Long value1, Long value2) {
            addCriterion("classid between", value1, value2, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotBetween(Long value1, Long value2) {
            addCriterion("classid not between", value1, value2, "classid");
            return (Criteria) this;
        }

        public Criteria andObjidIsNull() {
            addCriterion("objid is null");
            return (Criteria) this;
        }

        public Criteria andObjidIsNotNull() {
            addCriterion("objid is not null");
            return (Criteria) this;
        }

        public Criteria andObjidEqualTo(Long value) {
            addCriterion("objid =", value, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidNotEqualTo(Long value) {
            addCriterion("objid <>", value, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidGreaterThan(Long value) {
            addCriterion("objid >", value, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidGreaterThanOrEqualTo(Long value) {
            addCriterion("objid >=", value, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidLessThan(Long value) {
            addCriterion("objid <", value, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidLessThanOrEqualTo(Long value) {
            addCriterion("objid <=", value, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidIn(List<Long> values) {
            addCriterion("objid in", values, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidNotIn(List<Long> values) {
            addCriterion("objid not in", values, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidBetween(Long value1, Long value2) {
            addCriterion("objid between", value1, value2, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidNotBetween(Long value1, Long value2) {
            addCriterion("objid not between", value1, value2, "objid");
            return (Criteria) this;
        }

        public Criteria andObjsubidIsNull() {
            addCriterion("objsubid is null");
            return (Criteria) this;
        }

        public Criteria andObjsubidIsNotNull() {
            addCriterion("objsubid is not null");
            return (Criteria) this;
        }

        public Criteria andObjsubidEqualTo(Integer value) {
            addCriterion("objsubid =", value, "objsubid");
            return (Criteria) this;
        }

        public Criteria andObjsubidNotEqualTo(Integer value) {
            addCriterion("objsubid <>", value, "objsubid");
            return (Criteria) this;
        }

        public Criteria andObjsubidGreaterThan(Integer value) {
            addCriterion("objsubid >", value, "objsubid");
            return (Criteria) this;
        }

        public Criteria andObjsubidGreaterThanOrEqualTo(Integer value) {
            addCriterion("objsubid >=", value, "objsubid");
            return (Criteria) this;
        }

        public Criteria andObjsubidLessThan(Integer value) {
            addCriterion("objsubid <", value, "objsubid");
            return (Criteria) this;
        }

        public Criteria andObjsubidLessThanOrEqualTo(Integer value) {
            addCriterion("objsubid <=", value, "objsubid");
            return (Criteria) this;
        }

        public Criteria andObjsubidIn(List<Integer> values) {
            addCriterion("objsubid in", values, "objsubid");
            return (Criteria) this;
        }

        public Criteria andObjsubidNotIn(List<Integer> values) {
            addCriterion("objsubid not in", values, "objsubid");
            return (Criteria) this;
        }

        public Criteria andObjsubidBetween(Integer value1, Integer value2) {
            addCriterion("objsubid between", value1, value2, "objsubid");
            return (Criteria) this;
        }

        public Criteria andObjsubidNotBetween(Integer value1, Integer value2) {
            addCriterion("objsubid not between", value1, value2, "objsubid");
            return (Criteria) this;
        }

        public Criteria andRefclassidIsNull() {
            addCriterion("refclassid is null");
            return (Criteria) this;
        }

        public Criteria andRefclassidIsNotNull() {
            addCriterion("refclassid is not null");
            return (Criteria) this;
        }

        public Criteria andRefclassidEqualTo(Long value) {
            addCriterion("refclassid =", value, "refclassid");
            return (Criteria) this;
        }

        public Criteria andRefclassidNotEqualTo(Long value) {
            addCriterion("refclassid <>", value, "refclassid");
            return (Criteria) this;
        }

        public Criteria andRefclassidGreaterThan(Long value) {
            addCriterion("refclassid >", value, "refclassid");
            return (Criteria) this;
        }

        public Criteria andRefclassidGreaterThanOrEqualTo(Long value) {
            addCriterion("refclassid >=", value, "refclassid");
            return (Criteria) this;
        }

        public Criteria andRefclassidLessThan(Long value) {
            addCriterion("refclassid <", value, "refclassid");
            return (Criteria) this;
        }

        public Criteria andRefclassidLessThanOrEqualTo(Long value) {
            addCriterion("refclassid <=", value, "refclassid");
            return (Criteria) this;
        }

        public Criteria andRefclassidIn(List<Long> values) {
            addCriterion("refclassid in", values, "refclassid");
            return (Criteria) this;
        }

        public Criteria andRefclassidNotIn(List<Long> values) {
            addCriterion("refclassid not in", values, "refclassid");
            return (Criteria) this;
        }

        public Criteria andRefclassidBetween(Long value1, Long value2) {
            addCriterion("refclassid between", value1, value2, "refclassid");
            return (Criteria) this;
        }

        public Criteria andRefclassidNotBetween(Long value1, Long value2) {
            addCriterion("refclassid not between", value1, value2, "refclassid");
            return (Criteria) this;
        }

        public Criteria andRefobjidIsNull() {
            addCriterion("refobjid is null");
            return (Criteria) this;
        }

        public Criteria andRefobjidIsNotNull() {
            addCriterion("refobjid is not null");
            return (Criteria) this;
        }

        public Criteria andRefobjidEqualTo(Long value) {
            addCriterion("refobjid =", value, "refobjid");
            return (Criteria) this;
        }

        public Criteria andRefobjidNotEqualTo(Long value) {
            addCriterion("refobjid <>", value, "refobjid");
            return (Criteria) this;
        }

        public Criteria andRefobjidGreaterThan(Long value) {
            addCriterion("refobjid >", value, "refobjid");
            return (Criteria) this;
        }

        public Criteria andRefobjidGreaterThanOrEqualTo(Long value) {
            addCriterion("refobjid >=", value, "refobjid");
            return (Criteria) this;
        }

        public Criteria andRefobjidLessThan(Long value) {
            addCriterion("refobjid <", value, "refobjid");
            return (Criteria) this;
        }

        public Criteria andRefobjidLessThanOrEqualTo(Long value) {
            addCriterion("refobjid <=", value, "refobjid");
            return (Criteria) this;
        }

        public Criteria andRefobjidIn(List<Long> values) {
            addCriterion("refobjid in", values, "refobjid");
            return (Criteria) this;
        }

        public Criteria andRefobjidNotIn(List<Long> values) {
            addCriterion("refobjid not in", values, "refobjid");
            return (Criteria) this;
        }

        public Criteria andRefobjidBetween(Long value1, Long value2) {
            addCriterion("refobjid between", value1, value2, "refobjid");
            return (Criteria) this;
        }

        public Criteria andRefobjidNotBetween(Long value1, Long value2) {
            addCriterion("refobjid not between", value1, value2, "refobjid");
            return (Criteria) this;
        }

        public Criteria andDeptypeIsNull() {
            addCriterion("deptype is null");
            return (Criteria) this;
        }

        public Criteria andDeptypeIsNotNull() {
            addCriterion("deptype is not null");
            return (Criteria) this;
        }

        public Criteria andDeptypeEqualTo(String value) {
            addCriterion("deptype =", value, "deptype");
            return (Criteria) this;
        }

        public Criteria andDeptypeNotEqualTo(String value) {
            addCriterion("deptype <>", value, "deptype");
            return (Criteria) this;
        }

        public Criteria andDeptypeGreaterThan(String value) {
            addCriterion("deptype >", value, "deptype");
            return (Criteria) this;
        }

        public Criteria andDeptypeGreaterThanOrEqualTo(String value) {
            addCriterion("deptype >=", value, "deptype");
            return (Criteria) this;
        }

        public Criteria andDeptypeLessThan(String value) {
            addCriterion("deptype <", value, "deptype");
            return (Criteria) this;
        }

        public Criteria andDeptypeLessThanOrEqualTo(String value) {
            addCriterion("deptype <=", value, "deptype");
            return (Criteria) this;
        }

        public Criteria andDeptypeLike(String value) {
            addCriterion("deptype like", value, "deptype");
            return (Criteria) this;
        }

        public Criteria andDeptypeNotLike(String value) {
            addCriterion("deptype not like", value, "deptype");
            return (Criteria) this;
        }

        public Criteria andDeptypeIn(List<String> values) {
            addCriterion("deptype in", values, "deptype");
            return (Criteria) this;
        }

        public Criteria andDeptypeNotIn(List<String> values) {
            addCriterion("deptype not in", values, "deptype");
            return (Criteria) this;
        }

        public Criteria andDeptypeBetween(String value1, String value2) {
            addCriterion("deptype between", value1, value2, "deptype");
            return (Criteria) this;
        }

        public Criteria andDeptypeNotBetween(String value1, String value2) {
            addCriterion("deptype not between", value1, value2, "deptype");
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