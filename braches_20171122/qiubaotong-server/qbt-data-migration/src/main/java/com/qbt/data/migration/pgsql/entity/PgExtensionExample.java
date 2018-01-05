package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgExtensionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgExtensionExample() {
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

        public Criteria andExtnameIsNull() {
            addCriterion("extname is null");
            return (Criteria) this;
        }

        public Criteria andExtnameIsNotNull() {
            addCriterion("extname is not null");
            return (Criteria) this;
        }

        public Criteria andExtnameEqualTo(String value) {
            addCriterion("extname =", value, "extname");
            return (Criteria) this;
        }

        public Criteria andExtnameNotEqualTo(String value) {
            addCriterion("extname <>", value, "extname");
            return (Criteria) this;
        }

        public Criteria andExtnameGreaterThan(String value) {
            addCriterion("extname >", value, "extname");
            return (Criteria) this;
        }

        public Criteria andExtnameGreaterThanOrEqualTo(String value) {
            addCriterion("extname >=", value, "extname");
            return (Criteria) this;
        }

        public Criteria andExtnameLessThan(String value) {
            addCriterion("extname <", value, "extname");
            return (Criteria) this;
        }

        public Criteria andExtnameLessThanOrEqualTo(String value) {
            addCriterion("extname <=", value, "extname");
            return (Criteria) this;
        }

        public Criteria andExtnameLike(String value) {
            addCriterion("extname like", value, "extname");
            return (Criteria) this;
        }

        public Criteria andExtnameNotLike(String value) {
            addCriterion("extname not like", value, "extname");
            return (Criteria) this;
        }

        public Criteria andExtnameIn(List<String> values) {
            addCriterion("extname in", values, "extname");
            return (Criteria) this;
        }

        public Criteria andExtnameNotIn(List<String> values) {
            addCriterion("extname not in", values, "extname");
            return (Criteria) this;
        }

        public Criteria andExtnameBetween(String value1, String value2) {
            addCriterion("extname between", value1, value2, "extname");
            return (Criteria) this;
        }

        public Criteria andExtnameNotBetween(String value1, String value2) {
            addCriterion("extname not between", value1, value2, "extname");
            return (Criteria) this;
        }

        public Criteria andExtownerIsNull() {
            addCriterion("extowner is null");
            return (Criteria) this;
        }

        public Criteria andExtownerIsNotNull() {
            addCriterion("extowner is not null");
            return (Criteria) this;
        }

        public Criteria andExtownerEqualTo(Long value) {
            addCriterion("extowner =", value, "extowner");
            return (Criteria) this;
        }

        public Criteria andExtownerNotEqualTo(Long value) {
            addCriterion("extowner <>", value, "extowner");
            return (Criteria) this;
        }

        public Criteria andExtownerGreaterThan(Long value) {
            addCriterion("extowner >", value, "extowner");
            return (Criteria) this;
        }

        public Criteria andExtownerGreaterThanOrEqualTo(Long value) {
            addCriterion("extowner >=", value, "extowner");
            return (Criteria) this;
        }

        public Criteria andExtownerLessThan(Long value) {
            addCriterion("extowner <", value, "extowner");
            return (Criteria) this;
        }

        public Criteria andExtownerLessThanOrEqualTo(Long value) {
            addCriterion("extowner <=", value, "extowner");
            return (Criteria) this;
        }

        public Criteria andExtownerIn(List<Long> values) {
            addCriterion("extowner in", values, "extowner");
            return (Criteria) this;
        }

        public Criteria andExtownerNotIn(List<Long> values) {
            addCriterion("extowner not in", values, "extowner");
            return (Criteria) this;
        }

        public Criteria andExtownerBetween(Long value1, Long value2) {
            addCriterion("extowner between", value1, value2, "extowner");
            return (Criteria) this;
        }

        public Criteria andExtownerNotBetween(Long value1, Long value2) {
            addCriterion("extowner not between", value1, value2, "extowner");
            return (Criteria) this;
        }

        public Criteria andExtnamespaceIsNull() {
            addCriterion("extnamespace is null");
            return (Criteria) this;
        }

        public Criteria andExtnamespaceIsNotNull() {
            addCriterion("extnamespace is not null");
            return (Criteria) this;
        }

        public Criteria andExtnamespaceEqualTo(Long value) {
            addCriterion("extnamespace =", value, "extnamespace");
            return (Criteria) this;
        }

        public Criteria andExtnamespaceNotEqualTo(Long value) {
            addCriterion("extnamespace <>", value, "extnamespace");
            return (Criteria) this;
        }

        public Criteria andExtnamespaceGreaterThan(Long value) {
            addCriterion("extnamespace >", value, "extnamespace");
            return (Criteria) this;
        }

        public Criteria andExtnamespaceGreaterThanOrEqualTo(Long value) {
            addCriterion("extnamespace >=", value, "extnamespace");
            return (Criteria) this;
        }

        public Criteria andExtnamespaceLessThan(Long value) {
            addCriterion("extnamespace <", value, "extnamespace");
            return (Criteria) this;
        }

        public Criteria andExtnamespaceLessThanOrEqualTo(Long value) {
            addCriterion("extnamespace <=", value, "extnamespace");
            return (Criteria) this;
        }

        public Criteria andExtnamespaceIn(List<Long> values) {
            addCriterion("extnamespace in", values, "extnamespace");
            return (Criteria) this;
        }

        public Criteria andExtnamespaceNotIn(List<Long> values) {
            addCriterion("extnamespace not in", values, "extnamespace");
            return (Criteria) this;
        }

        public Criteria andExtnamespaceBetween(Long value1, Long value2) {
            addCriterion("extnamespace between", value1, value2, "extnamespace");
            return (Criteria) this;
        }

        public Criteria andExtnamespaceNotBetween(Long value1, Long value2) {
            addCriterion("extnamespace not between", value1, value2, "extnamespace");
            return (Criteria) this;
        }

        public Criteria andExtrelocatableIsNull() {
            addCriterion("extrelocatable is null");
            return (Criteria) this;
        }

        public Criteria andExtrelocatableIsNotNull() {
            addCriterion("extrelocatable is not null");
            return (Criteria) this;
        }

        public Criteria andExtrelocatableEqualTo(Boolean value) {
            addCriterion("extrelocatable =", value, "extrelocatable");
            return (Criteria) this;
        }

        public Criteria andExtrelocatableNotEqualTo(Boolean value) {
            addCriterion("extrelocatable <>", value, "extrelocatable");
            return (Criteria) this;
        }

        public Criteria andExtrelocatableGreaterThan(Boolean value) {
            addCriterion("extrelocatable >", value, "extrelocatable");
            return (Criteria) this;
        }

        public Criteria andExtrelocatableGreaterThanOrEqualTo(Boolean value) {
            addCriterion("extrelocatable >=", value, "extrelocatable");
            return (Criteria) this;
        }

        public Criteria andExtrelocatableLessThan(Boolean value) {
            addCriterion("extrelocatable <", value, "extrelocatable");
            return (Criteria) this;
        }

        public Criteria andExtrelocatableLessThanOrEqualTo(Boolean value) {
            addCriterion("extrelocatable <=", value, "extrelocatable");
            return (Criteria) this;
        }

        public Criteria andExtrelocatableIn(List<Boolean> values) {
            addCriterion("extrelocatable in", values, "extrelocatable");
            return (Criteria) this;
        }

        public Criteria andExtrelocatableNotIn(List<Boolean> values) {
            addCriterion("extrelocatable not in", values, "extrelocatable");
            return (Criteria) this;
        }

        public Criteria andExtrelocatableBetween(Boolean value1, Boolean value2) {
            addCriterion("extrelocatable between", value1, value2, "extrelocatable");
            return (Criteria) this;
        }

        public Criteria andExtrelocatableNotBetween(Boolean value1, Boolean value2) {
            addCriterion("extrelocatable not between", value1, value2, "extrelocatable");
            return (Criteria) this;
        }

        public Criteria andExtversionIsNull() {
            addCriterion("extversion is null");
            return (Criteria) this;
        }

        public Criteria andExtversionIsNotNull() {
            addCriterion("extversion is not null");
            return (Criteria) this;
        }

        public Criteria andExtversionEqualTo(String value) {
            addCriterion("extversion =", value, "extversion");
            return (Criteria) this;
        }

        public Criteria andExtversionNotEqualTo(String value) {
            addCriterion("extversion <>", value, "extversion");
            return (Criteria) this;
        }

        public Criteria andExtversionGreaterThan(String value) {
            addCriterion("extversion >", value, "extversion");
            return (Criteria) this;
        }

        public Criteria andExtversionGreaterThanOrEqualTo(String value) {
            addCriterion("extversion >=", value, "extversion");
            return (Criteria) this;
        }

        public Criteria andExtversionLessThan(String value) {
            addCriterion("extversion <", value, "extversion");
            return (Criteria) this;
        }

        public Criteria andExtversionLessThanOrEqualTo(String value) {
            addCriterion("extversion <=", value, "extversion");
            return (Criteria) this;
        }

        public Criteria andExtversionLike(String value) {
            addCriterion("extversion like", value, "extversion");
            return (Criteria) this;
        }

        public Criteria andExtversionNotLike(String value) {
            addCriterion("extversion not like", value, "extversion");
            return (Criteria) this;
        }

        public Criteria andExtversionIn(List<String> values) {
            addCriterion("extversion in", values, "extversion");
            return (Criteria) this;
        }

        public Criteria andExtversionNotIn(List<String> values) {
            addCriterion("extversion not in", values, "extversion");
            return (Criteria) this;
        }

        public Criteria andExtversionBetween(String value1, String value2) {
            addCriterion("extversion between", value1, value2, "extversion");
            return (Criteria) this;
        }

        public Criteria andExtversionNotBetween(String value1, String value2) {
            addCriterion("extversion not between", value1, value2, "extversion");
            return (Criteria) this;
        }

        public Criteria andExtconfigIsNull() {
            addCriterion("extconfig is null");
            return (Criteria) this;
        }

        public Criteria andExtconfigIsNotNull() {
            addCriterion("extconfig is not null");
            return (Criteria) this;
        }

        public Criteria andExtconfigEqualTo(Object value) {
            addCriterion("extconfig =", value, "extconfig");
            return (Criteria) this;
        }

        public Criteria andExtconfigNotEqualTo(Object value) {
            addCriterion("extconfig <>", value, "extconfig");
            return (Criteria) this;
        }

        public Criteria andExtconfigGreaterThan(Object value) {
            addCriterion("extconfig >", value, "extconfig");
            return (Criteria) this;
        }

        public Criteria andExtconfigGreaterThanOrEqualTo(Object value) {
            addCriterion("extconfig >=", value, "extconfig");
            return (Criteria) this;
        }

        public Criteria andExtconfigLessThan(Object value) {
            addCriterion("extconfig <", value, "extconfig");
            return (Criteria) this;
        }

        public Criteria andExtconfigLessThanOrEqualTo(Object value) {
            addCriterion("extconfig <=", value, "extconfig");
            return (Criteria) this;
        }

        public Criteria andExtconfigIn(List<Object> values) {
            addCriterion("extconfig in", values, "extconfig");
            return (Criteria) this;
        }

        public Criteria andExtconfigNotIn(List<Object> values) {
            addCriterion("extconfig not in", values, "extconfig");
            return (Criteria) this;
        }

        public Criteria andExtconfigBetween(Object value1, Object value2) {
            addCriterion("extconfig between", value1, value2, "extconfig");
            return (Criteria) this;
        }

        public Criteria andExtconfigNotBetween(Object value1, Object value2) {
            addCriterion("extconfig not between", value1, value2, "extconfig");
            return (Criteria) this;
        }

        public Criteria andExtconditionIsNull() {
            addCriterion("extcondition is null");
            return (Criteria) this;
        }

        public Criteria andExtconditionIsNotNull() {
            addCriterion("extcondition is not null");
            return (Criteria) this;
        }

        public Criteria andExtconditionEqualTo(Object value) {
            addCriterion("extcondition =", value, "extcondition");
            return (Criteria) this;
        }

        public Criteria andExtconditionNotEqualTo(Object value) {
            addCriterion("extcondition <>", value, "extcondition");
            return (Criteria) this;
        }

        public Criteria andExtconditionGreaterThan(Object value) {
            addCriterion("extcondition >", value, "extcondition");
            return (Criteria) this;
        }

        public Criteria andExtconditionGreaterThanOrEqualTo(Object value) {
            addCriterion("extcondition >=", value, "extcondition");
            return (Criteria) this;
        }

        public Criteria andExtconditionLessThan(Object value) {
            addCriterion("extcondition <", value, "extcondition");
            return (Criteria) this;
        }

        public Criteria andExtconditionLessThanOrEqualTo(Object value) {
            addCriterion("extcondition <=", value, "extcondition");
            return (Criteria) this;
        }

        public Criteria andExtconditionIn(List<Object> values) {
            addCriterion("extcondition in", values, "extcondition");
            return (Criteria) this;
        }

        public Criteria andExtconditionNotIn(List<Object> values) {
            addCriterion("extcondition not in", values, "extcondition");
            return (Criteria) this;
        }

        public Criteria andExtconditionBetween(Object value1, Object value2) {
            addCriterion("extcondition between", value1, value2, "extcondition");
            return (Criteria) this;
        }

        public Criteria andExtconditionNotBetween(Object value1, Object value2) {
            addCriterion("extcondition not between", value1, value2, "extcondition");
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