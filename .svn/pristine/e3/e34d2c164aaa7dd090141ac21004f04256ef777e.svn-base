package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgForeignDataWrapperExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgForeignDataWrapperExample() {
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

        public Criteria andFdwnameIsNull() {
            addCriterion("fdwname is null");
            return (Criteria) this;
        }

        public Criteria andFdwnameIsNotNull() {
            addCriterion("fdwname is not null");
            return (Criteria) this;
        }

        public Criteria andFdwnameEqualTo(String value) {
            addCriterion("fdwname =", value, "fdwname");
            return (Criteria) this;
        }

        public Criteria andFdwnameNotEqualTo(String value) {
            addCriterion("fdwname <>", value, "fdwname");
            return (Criteria) this;
        }

        public Criteria andFdwnameGreaterThan(String value) {
            addCriterion("fdwname >", value, "fdwname");
            return (Criteria) this;
        }

        public Criteria andFdwnameGreaterThanOrEqualTo(String value) {
            addCriterion("fdwname >=", value, "fdwname");
            return (Criteria) this;
        }

        public Criteria andFdwnameLessThan(String value) {
            addCriterion("fdwname <", value, "fdwname");
            return (Criteria) this;
        }

        public Criteria andFdwnameLessThanOrEqualTo(String value) {
            addCriterion("fdwname <=", value, "fdwname");
            return (Criteria) this;
        }

        public Criteria andFdwnameLike(String value) {
            addCriterion("fdwname like", value, "fdwname");
            return (Criteria) this;
        }

        public Criteria andFdwnameNotLike(String value) {
            addCriterion("fdwname not like", value, "fdwname");
            return (Criteria) this;
        }

        public Criteria andFdwnameIn(List<String> values) {
            addCriterion("fdwname in", values, "fdwname");
            return (Criteria) this;
        }

        public Criteria andFdwnameNotIn(List<String> values) {
            addCriterion("fdwname not in", values, "fdwname");
            return (Criteria) this;
        }

        public Criteria andFdwnameBetween(String value1, String value2) {
            addCriterion("fdwname between", value1, value2, "fdwname");
            return (Criteria) this;
        }

        public Criteria andFdwnameNotBetween(String value1, String value2) {
            addCriterion("fdwname not between", value1, value2, "fdwname");
            return (Criteria) this;
        }

        public Criteria andFdwownerIsNull() {
            addCriterion("fdwowner is null");
            return (Criteria) this;
        }

        public Criteria andFdwownerIsNotNull() {
            addCriterion("fdwowner is not null");
            return (Criteria) this;
        }

        public Criteria andFdwownerEqualTo(Long value) {
            addCriterion("fdwowner =", value, "fdwowner");
            return (Criteria) this;
        }

        public Criteria andFdwownerNotEqualTo(Long value) {
            addCriterion("fdwowner <>", value, "fdwowner");
            return (Criteria) this;
        }

        public Criteria andFdwownerGreaterThan(Long value) {
            addCriterion("fdwowner >", value, "fdwowner");
            return (Criteria) this;
        }

        public Criteria andFdwownerGreaterThanOrEqualTo(Long value) {
            addCriterion("fdwowner >=", value, "fdwowner");
            return (Criteria) this;
        }

        public Criteria andFdwownerLessThan(Long value) {
            addCriterion("fdwowner <", value, "fdwowner");
            return (Criteria) this;
        }

        public Criteria andFdwownerLessThanOrEqualTo(Long value) {
            addCriterion("fdwowner <=", value, "fdwowner");
            return (Criteria) this;
        }

        public Criteria andFdwownerIn(List<Long> values) {
            addCriterion("fdwowner in", values, "fdwowner");
            return (Criteria) this;
        }

        public Criteria andFdwownerNotIn(List<Long> values) {
            addCriterion("fdwowner not in", values, "fdwowner");
            return (Criteria) this;
        }

        public Criteria andFdwownerBetween(Long value1, Long value2) {
            addCriterion("fdwowner between", value1, value2, "fdwowner");
            return (Criteria) this;
        }

        public Criteria andFdwownerNotBetween(Long value1, Long value2) {
            addCriterion("fdwowner not between", value1, value2, "fdwowner");
            return (Criteria) this;
        }

        public Criteria andFdwhandlerIsNull() {
            addCriterion("fdwhandler is null");
            return (Criteria) this;
        }

        public Criteria andFdwhandlerIsNotNull() {
            addCriterion("fdwhandler is not null");
            return (Criteria) this;
        }

        public Criteria andFdwhandlerEqualTo(Long value) {
            addCriterion("fdwhandler =", value, "fdwhandler");
            return (Criteria) this;
        }

        public Criteria andFdwhandlerNotEqualTo(Long value) {
            addCriterion("fdwhandler <>", value, "fdwhandler");
            return (Criteria) this;
        }

        public Criteria andFdwhandlerGreaterThan(Long value) {
            addCriterion("fdwhandler >", value, "fdwhandler");
            return (Criteria) this;
        }

        public Criteria andFdwhandlerGreaterThanOrEqualTo(Long value) {
            addCriterion("fdwhandler >=", value, "fdwhandler");
            return (Criteria) this;
        }

        public Criteria andFdwhandlerLessThan(Long value) {
            addCriterion("fdwhandler <", value, "fdwhandler");
            return (Criteria) this;
        }

        public Criteria andFdwhandlerLessThanOrEqualTo(Long value) {
            addCriterion("fdwhandler <=", value, "fdwhandler");
            return (Criteria) this;
        }

        public Criteria andFdwhandlerIn(List<Long> values) {
            addCriterion("fdwhandler in", values, "fdwhandler");
            return (Criteria) this;
        }

        public Criteria andFdwhandlerNotIn(List<Long> values) {
            addCriterion("fdwhandler not in", values, "fdwhandler");
            return (Criteria) this;
        }

        public Criteria andFdwhandlerBetween(Long value1, Long value2) {
            addCriterion("fdwhandler between", value1, value2, "fdwhandler");
            return (Criteria) this;
        }

        public Criteria andFdwhandlerNotBetween(Long value1, Long value2) {
            addCriterion("fdwhandler not between", value1, value2, "fdwhandler");
            return (Criteria) this;
        }

        public Criteria andFdwvalidatorIsNull() {
            addCriterion("fdwvalidator is null");
            return (Criteria) this;
        }

        public Criteria andFdwvalidatorIsNotNull() {
            addCriterion("fdwvalidator is not null");
            return (Criteria) this;
        }

        public Criteria andFdwvalidatorEqualTo(Long value) {
            addCriterion("fdwvalidator =", value, "fdwvalidator");
            return (Criteria) this;
        }

        public Criteria andFdwvalidatorNotEqualTo(Long value) {
            addCriterion("fdwvalidator <>", value, "fdwvalidator");
            return (Criteria) this;
        }

        public Criteria andFdwvalidatorGreaterThan(Long value) {
            addCriterion("fdwvalidator >", value, "fdwvalidator");
            return (Criteria) this;
        }

        public Criteria andFdwvalidatorGreaterThanOrEqualTo(Long value) {
            addCriterion("fdwvalidator >=", value, "fdwvalidator");
            return (Criteria) this;
        }

        public Criteria andFdwvalidatorLessThan(Long value) {
            addCriterion("fdwvalidator <", value, "fdwvalidator");
            return (Criteria) this;
        }

        public Criteria andFdwvalidatorLessThanOrEqualTo(Long value) {
            addCriterion("fdwvalidator <=", value, "fdwvalidator");
            return (Criteria) this;
        }

        public Criteria andFdwvalidatorIn(List<Long> values) {
            addCriterion("fdwvalidator in", values, "fdwvalidator");
            return (Criteria) this;
        }

        public Criteria andFdwvalidatorNotIn(List<Long> values) {
            addCriterion("fdwvalidator not in", values, "fdwvalidator");
            return (Criteria) this;
        }

        public Criteria andFdwvalidatorBetween(Long value1, Long value2) {
            addCriterion("fdwvalidator between", value1, value2, "fdwvalidator");
            return (Criteria) this;
        }

        public Criteria andFdwvalidatorNotBetween(Long value1, Long value2) {
            addCriterion("fdwvalidator not between", value1, value2, "fdwvalidator");
            return (Criteria) this;
        }

        public Criteria andFdwaclIsNull() {
            addCriterion("fdwacl is null");
            return (Criteria) this;
        }

        public Criteria andFdwaclIsNotNull() {
            addCriterion("fdwacl is not null");
            return (Criteria) this;
        }

        public Criteria andFdwaclEqualTo(Object value) {
            addCriterion("fdwacl =", value, "fdwacl");
            return (Criteria) this;
        }

        public Criteria andFdwaclNotEqualTo(Object value) {
            addCriterion("fdwacl <>", value, "fdwacl");
            return (Criteria) this;
        }

        public Criteria andFdwaclGreaterThan(Object value) {
            addCriterion("fdwacl >", value, "fdwacl");
            return (Criteria) this;
        }

        public Criteria andFdwaclGreaterThanOrEqualTo(Object value) {
            addCriterion("fdwacl >=", value, "fdwacl");
            return (Criteria) this;
        }

        public Criteria andFdwaclLessThan(Object value) {
            addCriterion("fdwacl <", value, "fdwacl");
            return (Criteria) this;
        }

        public Criteria andFdwaclLessThanOrEqualTo(Object value) {
            addCriterion("fdwacl <=", value, "fdwacl");
            return (Criteria) this;
        }

        public Criteria andFdwaclIn(List<Object> values) {
            addCriterion("fdwacl in", values, "fdwacl");
            return (Criteria) this;
        }

        public Criteria andFdwaclNotIn(List<Object> values) {
            addCriterion("fdwacl not in", values, "fdwacl");
            return (Criteria) this;
        }

        public Criteria andFdwaclBetween(Object value1, Object value2) {
            addCriterion("fdwacl between", value1, value2, "fdwacl");
            return (Criteria) this;
        }

        public Criteria andFdwaclNotBetween(Object value1, Object value2) {
            addCriterion("fdwacl not between", value1, value2, "fdwacl");
            return (Criteria) this;
        }

        public Criteria andFdwoptionsIsNull() {
            addCriterion("fdwoptions is null");
            return (Criteria) this;
        }

        public Criteria andFdwoptionsIsNotNull() {
            addCriterion("fdwoptions is not null");
            return (Criteria) this;
        }

        public Criteria andFdwoptionsEqualTo(Object value) {
            addCriterion("fdwoptions =", value, "fdwoptions");
            return (Criteria) this;
        }

        public Criteria andFdwoptionsNotEqualTo(Object value) {
            addCriterion("fdwoptions <>", value, "fdwoptions");
            return (Criteria) this;
        }

        public Criteria andFdwoptionsGreaterThan(Object value) {
            addCriterion("fdwoptions >", value, "fdwoptions");
            return (Criteria) this;
        }

        public Criteria andFdwoptionsGreaterThanOrEqualTo(Object value) {
            addCriterion("fdwoptions >=", value, "fdwoptions");
            return (Criteria) this;
        }

        public Criteria andFdwoptionsLessThan(Object value) {
            addCriterion("fdwoptions <", value, "fdwoptions");
            return (Criteria) this;
        }

        public Criteria andFdwoptionsLessThanOrEqualTo(Object value) {
            addCriterion("fdwoptions <=", value, "fdwoptions");
            return (Criteria) this;
        }

        public Criteria andFdwoptionsIn(List<Object> values) {
            addCriterion("fdwoptions in", values, "fdwoptions");
            return (Criteria) this;
        }

        public Criteria andFdwoptionsNotIn(List<Object> values) {
            addCriterion("fdwoptions not in", values, "fdwoptions");
            return (Criteria) this;
        }

        public Criteria andFdwoptionsBetween(Object value1, Object value2) {
            addCriterion("fdwoptions between", value1, value2, "fdwoptions");
            return (Criteria) this;
        }

        public Criteria andFdwoptionsNotBetween(Object value1, Object value2) {
            addCriterion("fdwoptions not between", value1, value2, "fdwoptions");
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