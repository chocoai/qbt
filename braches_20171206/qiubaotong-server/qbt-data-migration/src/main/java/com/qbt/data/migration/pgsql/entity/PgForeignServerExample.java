package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgForeignServerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgForeignServerExample() {
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

        public Criteria andSrvnameIsNull() {
            addCriterion("srvname is null");
            return (Criteria) this;
        }

        public Criteria andSrvnameIsNotNull() {
            addCriterion("srvname is not null");
            return (Criteria) this;
        }

        public Criteria andSrvnameEqualTo(String value) {
            addCriterion("srvname =", value, "srvname");
            return (Criteria) this;
        }

        public Criteria andSrvnameNotEqualTo(String value) {
            addCriterion("srvname <>", value, "srvname");
            return (Criteria) this;
        }

        public Criteria andSrvnameGreaterThan(String value) {
            addCriterion("srvname >", value, "srvname");
            return (Criteria) this;
        }

        public Criteria andSrvnameGreaterThanOrEqualTo(String value) {
            addCriterion("srvname >=", value, "srvname");
            return (Criteria) this;
        }

        public Criteria andSrvnameLessThan(String value) {
            addCriterion("srvname <", value, "srvname");
            return (Criteria) this;
        }

        public Criteria andSrvnameLessThanOrEqualTo(String value) {
            addCriterion("srvname <=", value, "srvname");
            return (Criteria) this;
        }

        public Criteria andSrvnameLike(String value) {
            addCriterion("srvname like", value, "srvname");
            return (Criteria) this;
        }

        public Criteria andSrvnameNotLike(String value) {
            addCriterion("srvname not like", value, "srvname");
            return (Criteria) this;
        }

        public Criteria andSrvnameIn(List<String> values) {
            addCriterion("srvname in", values, "srvname");
            return (Criteria) this;
        }

        public Criteria andSrvnameNotIn(List<String> values) {
            addCriterion("srvname not in", values, "srvname");
            return (Criteria) this;
        }

        public Criteria andSrvnameBetween(String value1, String value2) {
            addCriterion("srvname between", value1, value2, "srvname");
            return (Criteria) this;
        }

        public Criteria andSrvnameNotBetween(String value1, String value2) {
            addCriterion("srvname not between", value1, value2, "srvname");
            return (Criteria) this;
        }

        public Criteria andSrvownerIsNull() {
            addCriterion("srvowner is null");
            return (Criteria) this;
        }

        public Criteria andSrvownerIsNotNull() {
            addCriterion("srvowner is not null");
            return (Criteria) this;
        }

        public Criteria andSrvownerEqualTo(Long value) {
            addCriterion("srvowner =", value, "srvowner");
            return (Criteria) this;
        }

        public Criteria andSrvownerNotEqualTo(Long value) {
            addCriterion("srvowner <>", value, "srvowner");
            return (Criteria) this;
        }

        public Criteria andSrvownerGreaterThan(Long value) {
            addCriterion("srvowner >", value, "srvowner");
            return (Criteria) this;
        }

        public Criteria andSrvownerGreaterThanOrEqualTo(Long value) {
            addCriterion("srvowner >=", value, "srvowner");
            return (Criteria) this;
        }

        public Criteria andSrvownerLessThan(Long value) {
            addCriterion("srvowner <", value, "srvowner");
            return (Criteria) this;
        }

        public Criteria andSrvownerLessThanOrEqualTo(Long value) {
            addCriterion("srvowner <=", value, "srvowner");
            return (Criteria) this;
        }

        public Criteria andSrvownerIn(List<Long> values) {
            addCriterion("srvowner in", values, "srvowner");
            return (Criteria) this;
        }

        public Criteria andSrvownerNotIn(List<Long> values) {
            addCriterion("srvowner not in", values, "srvowner");
            return (Criteria) this;
        }

        public Criteria andSrvownerBetween(Long value1, Long value2) {
            addCriterion("srvowner between", value1, value2, "srvowner");
            return (Criteria) this;
        }

        public Criteria andSrvownerNotBetween(Long value1, Long value2) {
            addCriterion("srvowner not between", value1, value2, "srvowner");
            return (Criteria) this;
        }

        public Criteria andSrvfdwIsNull() {
            addCriterion("srvfdw is null");
            return (Criteria) this;
        }

        public Criteria andSrvfdwIsNotNull() {
            addCriterion("srvfdw is not null");
            return (Criteria) this;
        }

        public Criteria andSrvfdwEqualTo(Long value) {
            addCriterion("srvfdw =", value, "srvfdw");
            return (Criteria) this;
        }

        public Criteria andSrvfdwNotEqualTo(Long value) {
            addCriterion("srvfdw <>", value, "srvfdw");
            return (Criteria) this;
        }

        public Criteria andSrvfdwGreaterThan(Long value) {
            addCriterion("srvfdw >", value, "srvfdw");
            return (Criteria) this;
        }

        public Criteria andSrvfdwGreaterThanOrEqualTo(Long value) {
            addCriterion("srvfdw >=", value, "srvfdw");
            return (Criteria) this;
        }

        public Criteria andSrvfdwLessThan(Long value) {
            addCriterion("srvfdw <", value, "srvfdw");
            return (Criteria) this;
        }

        public Criteria andSrvfdwLessThanOrEqualTo(Long value) {
            addCriterion("srvfdw <=", value, "srvfdw");
            return (Criteria) this;
        }

        public Criteria andSrvfdwIn(List<Long> values) {
            addCriterion("srvfdw in", values, "srvfdw");
            return (Criteria) this;
        }

        public Criteria andSrvfdwNotIn(List<Long> values) {
            addCriterion("srvfdw not in", values, "srvfdw");
            return (Criteria) this;
        }

        public Criteria andSrvfdwBetween(Long value1, Long value2) {
            addCriterion("srvfdw between", value1, value2, "srvfdw");
            return (Criteria) this;
        }

        public Criteria andSrvfdwNotBetween(Long value1, Long value2) {
            addCriterion("srvfdw not between", value1, value2, "srvfdw");
            return (Criteria) this;
        }

        public Criteria andSrvtypeIsNull() {
            addCriterion("srvtype is null");
            return (Criteria) this;
        }

        public Criteria andSrvtypeIsNotNull() {
            addCriterion("srvtype is not null");
            return (Criteria) this;
        }

        public Criteria andSrvtypeEqualTo(String value) {
            addCriterion("srvtype =", value, "srvtype");
            return (Criteria) this;
        }

        public Criteria andSrvtypeNotEqualTo(String value) {
            addCriterion("srvtype <>", value, "srvtype");
            return (Criteria) this;
        }

        public Criteria andSrvtypeGreaterThan(String value) {
            addCriterion("srvtype >", value, "srvtype");
            return (Criteria) this;
        }

        public Criteria andSrvtypeGreaterThanOrEqualTo(String value) {
            addCriterion("srvtype >=", value, "srvtype");
            return (Criteria) this;
        }

        public Criteria andSrvtypeLessThan(String value) {
            addCriterion("srvtype <", value, "srvtype");
            return (Criteria) this;
        }

        public Criteria andSrvtypeLessThanOrEqualTo(String value) {
            addCriterion("srvtype <=", value, "srvtype");
            return (Criteria) this;
        }

        public Criteria andSrvtypeLike(String value) {
            addCriterion("srvtype like", value, "srvtype");
            return (Criteria) this;
        }

        public Criteria andSrvtypeNotLike(String value) {
            addCriterion("srvtype not like", value, "srvtype");
            return (Criteria) this;
        }

        public Criteria andSrvtypeIn(List<String> values) {
            addCriterion("srvtype in", values, "srvtype");
            return (Criteria) this;
        }

        public Criteria andSrvtypeNotIn(List<String> values) {
            addCriterion("srvtype not in", values, "srvtype");
            return (Criteria) this;
        }

        public Criteria andSrvtypeBetween(String value1, String value2) {
            addCriterion("srvtype between", value1, value2, "srvtype");
            return (Criteria) this;
        }

        public Criteria andSrvtypeNotBetween(String value1, String value2) {
            addCriterion("srvtype not between", value1, value2, "srvtype");
            return (Criteria) this;
        }

        public Criteria andSrvversionIsNull() {
            addCriterion("srvversion is null");
            return (Criteria) this;
        }

        public Criteria andSrvversionIsNotNull() {
            addCriterion("srvversion is not null");
            return (Criteria) this;
        }

        public Criteria andSrvversionEqualTo(String value) {
            addCriterion("srvversion =", value, "srvversion");
            return (Criteria) this;
        }

        public Criteria andSrvversionNotEqualTo(String value) {
            addCriterion("srvversion <>", value, "srvversion");
            return (Criteria) this;
        }

        public Criteria andSrvversionGreaterThan(String value) {
            addCriterion("srvversion >", value, "srvversion");
            return (Criteria) this;
        }

        public Criteria andSrvversionGreaterThanOrEqualTo(String value) {
            addCriterion("srvversion >=", value, "srvversion");
            return (Criteria) this;
        }

        public Criteria andSrvversionLessThan(String value) {
            addCriterion("srvversion <", value, "srvversion");
            return (Criteria) this;
        }

        public Criteria andSrvversionLessThanOrEqualTo(String value) {
            addCriterion("srvversion <=", value, "srvversion");
            return (Criteria) this;
        }

        public Criteria andSrvversionLike(String value) {
            addCriterion("srvversion like", value, "srvversion");
            return (Criteria) this;
        }

        public Criteria andSrvversionNotLike(String value) {
            addCriterion("srvversion not like", value, "srvversion");
            return (Criteria) this;
        }

        public Criteria andSrvversionIn(List<String> values) {
            addCriterion("srvversion in", values, "srvversion");
            return (Criteria) this;
        }

        public Criteria andSrvversionNotIn(List<String> values) {
            addCriterion("srvversion not in", values, "srvversion");
            return (Criteria) this;
        }

        public Criteria andSrvversionBetween(String value1, String value2) {
            addCriterion("srvversion between", value1, value2, "srvversion");
            return (Criteria) this;
        }

        public Criteria andSrvversionNotBetween(String value1, String value2) {
            addCriterion("srvversion not between", value1, value2, "srvversion");
            return (Criteria) this;
        }

        public Criteria andSrvaclIsNull() {
            addCriterion("srvacl is null");
            return (Criteria) this;
        }

        public Criteria andSrvaclIsNotNull() {
            addCriterion("srvacl is not null");
            return (Criteria) this;
        }

        public Criteria andSrvaclEqualTo(Object value) {
            addCriterion("srvacl =", value, "srvacl");
            return (Criteria) this;
        }

        public Criteria andSrvaclNotEqualTo(Object value) {
            addCriterion("srvacl <>", value, "srvacl");
            return (Criteria) this;
        }

        public Criteria andSrvaclGreaterThan(Object value) {
            addCriterion("srvacl >", value, "srvacl");
            return (Criteria) this;
        }

        public Criteria andSrvaclGreaterThanOrEqualTo(Object value) {
            addCriterion("srvacl >=", value, "srvacl");
            return (Criteria) this;
        }

        public Criteria andSrvaclLessThan(Object value) {
            addCriterion("srvacl <", value, "srvacl");
            return (Criteria) this;
        }

        public Criteria andSrvaclLessThanOrEqualTo(Object value) {
            addCriterion("srvacl <=", value, "srvacl");
            return (Criteria) this;
        }

        public Criteria andSrvaclIn(List<Object> values) {
            addCriterion("srvacl in", values, "srvacl");
            return (Criteria) this;
        }

        public Criteria andSrvaclNotIn(List<Object> values) {
            addCriterion("srvacl not in", values, "srvacl");
            return (Criteria) this;
        }

        public Criteria andSrvaclBetween(Object value1, Object value2) {
            addCriterion("srvacl between", value1, value2, "srvacl");
            return (Criteria) this;
        }

        public Criteria andSrvaclNotBetween(Object value1, Object value2) {
            addCriterion("srvacl not between", value1, value2, "srvacl");
            return (Criteria) this;
        }

        public Criteria andSrvoptionsIsNull() {
            addCriterion("srvoptions is null");
            return (Criteria) this;
        }

        public Criteria andSrvoptionsIsNotNull() {
            addCriterion("srvoptions is not null");
            return (Criteria) this;
        }

        public Criteria andSrvoptionsEqualTo(Object value) {
            addCriterion("srvoptions =", value, "srvoptions");
            return (Criteria) this;
        }

        public Criteria andSrvoptionsNotEqualTo(Object value) {
            addCriterion("srvoptions <>", value, "srvoptions");
            return (Criteria) this;
        }

        public Criteria andSrvoptionsGreaterThan(Object value) {
            addCriterion("srvoptions >", value, "srvoptions");
            return (Criteria) this;
        }

        public Criteria andSrvoptionsGreaterThanOrEqualTo(Object value) {
            addCriterion("srvoptions >=", value, "srvoptions");
            return (Criteria) this;
        }

        public Criteria andSrvoptionsLessThan(Object value) {
            addCriterion("srvoptions <", value, "srvoptions");
            return (Criteria) this;
        }

        public Criteria andSrvoptionsLessThanOrEqualTo(Object value) {
            addCriterion("srvoptions <=", value, "srvoptions");
            return (Criteria) this;
        }

        public Criteria andSrvoptionsIn(List<Object> values) {
            addCriterion("srvoptions in", values, "srvoptions");
            return (Criteria) this;
        }

        public Criteria andSrvoptionsNotIn(List<Object> values) {
            addCriterion("srvoptions not in", values, "srvoptions");
            return (Criteria) this;
        }

        public Criteria andSrvoptionsBetween(Object value1, Object value2) {
            addCriterion("srvoptions between", value1, value2, "srvoptions");
            return (Criteria) this;
        }

        public Criteria andSrvoptionsNotBetween(Object value1, Object value2) {
            addCriterion("srvoptions not between", value1, value2, "srvoptions");
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