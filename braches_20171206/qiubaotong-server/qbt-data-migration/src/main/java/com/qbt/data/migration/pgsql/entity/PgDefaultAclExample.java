package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgDefaultAclExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgDefaultAclExample() {
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

        public Criteria andDefaclroleIsNull() {
            addCriterion("defaclrole is null");
            return (Criteria) this;
        }

        public Criteria andDefaclroleIsNotNull() {
            addCriterion("defaclrole is not null");
            return (Criteria) this;
        }

        public Criteria andDefaclroleEqualTo(Long value) {
            addCriterion("defaclrole =", value, "defaclrole");
            return (Criteria) this;
        }

        public Criteria andDefaclroleNotEqualTo(Long value) {
            addCriterion("defaclrole <>", value, "defaclrole");
            return (Criteria) this;
        }

        public Criteria andDefaclroleGreaterThan(Long value) {
            addCriterion("defaclrole >", value, "defaclrole");
            return (Criteria) this;
        }

        public Criteria andDefaclroleGreaterThanOrEqualTo(Long value) {
            addCriterion("defaclrole >=", value, "defaclrole");
            return (Criteria) this;
        }

        public Criteria andDefaclroleLessThan(Long value) {
            addCriterion("defaclrole <", value, "defaclrole");
            return (Criteria) this;
        }

        public Criteria andDefaclroleLessThanOrEqualTo(Long value) {
            addCriterion("defaclrole <=", value, "defaclrole");
            return (Criteria) this;
        }

        public Criteria andDefaclroleIn(List<Long> values) {
            addCriterion("defaclrole in", values, "defaclrole");
            return (Criteria) this;
        }

        public Criteria andDefaclroleNotIn(List<Long> values) {
            addCriterion("defaclrole not in", values, "defaclrole");
            return (Criteria) this;
        }

        public Criteria andDefaclroleBetween(Long value1, Long value2) {
            addCriterion("defaclrole between", value1, value2, "defaclrole");
            return (Criteria) this;
        }

        public Criteria andDefaclroleNotBetween(Long value1, Long value2) {
            addCriterion("defaclrole not between", value1, value2, "defaclrole");
            return (Criteria) this;
        }

        public Criteria andDefaclnamespaceIsNull() {
            addCriterion("defaclnamespace is null");
            return (Criteria) this;
        }

        public Criteria andDefaclnamespaceIsNotNull() {
            addCriterion("defaclnamespace is not null");
            return (Criteria) this;
        }

        public Criteria andDefaclnamespaceEqualTo(Long value) {
            addCriterion("defaclnamespace =", value, "defaclnamespace");
            return (Criteria) this;
        }

        public Criteria andDefaclnamespaceNotEqualTo(Long value) {
            addCriterion("defaclnamespace <>", value, "defaclnamespace");
            return (Criteria) this;
        }

        public Criteria andDefaclnamespaceGreaterThan(Long value) {
            addCriterion("defaclnamespace >", value, "defaclnamespace");
            return (Criteria) this;
        }

        public Criteria andDefaclnamespaceGreaterThanOrEqualTo(Long value) {
            addCriterion("defaclnamespace >=", value, "defaclnamespace");
            return (Criteria) this;
        }

        public Criteria andDefaclnamespaceLessThan(Long value) {
            addCriterion("defaclnamespace <", value, "defaclnamespace");
            return (Criteria) this;
        }

        public Criteria andDefaclnamespaceLessThanOrEqualTo(Long value) {
            addCriterion("defaclnamespace <=", value, "defaclnamespace");
            return (Criteria) this;
        }

        public Criteria andDefaclnamespaceIn(List<Long> values) {
            addCriterion("defaclnamespace in", values, "defaclnamespace");
            return (Criteria) this;
        }

        public Criteria andDefaclnamespaceNotIn(List<Long> values) {
            addCriterion("defaclnamespace not in", values, "defaclnamespace");
            return (Criteria) this;
        }

        public Criteria andDefaclnamespaceBetween(Long value1, Long value2) {
            addCriterion("defaclnamespace between", value1, value2, "defaclnamespace");
            return (Criteria) this;
        }

        public Criteria andDefaclnamespaceNotBetween(Long value1, Long value2) {
            addCriterion("defaclnamespace not between", value1, value2, "defaclnamespace");
            return (Criteria) this;
        }

        public Criteria andDefaclobjtypeIsNull() {
            addCriterion("defaclobjtype is null");
            return (Criteria) this;
        }

        public Criteria andDefaclobjtypeIsNotNull() {
            addCriterion("defaclobjtype is not null");
            return (Criteria) this;
        }

        public Criteria andDefaclobjtypeEqualTo(String value) {
            addCriterion("defaclobjtype =", value, "defaclobjtype");
            return (Criteria) this;
        }

        public Criteria andDefaclobjtypeNotEqualTo(String value) {
            addCriterion("defaclobjtype <>", value, "defaclobjtype");
            return (Criteria) this;
        }

        public Criteria andDefaclobjtypeGreaterThan(String value) {
            addCriterion("defaclobjtype >", value, "defaclobjtype");
            return (Criteria) this;
        }

        public Criteria andDefaclobjtypeGreaterThanOrEqualTo(String value) {
            addCriterion("defaclobjtype >=", value, "defaclobjtype");
            return (Criteria) this;
        }

        public Criteria andDefaclobjtypeLessThan(String value) {
            addCriterion("defaclobjtype <", value, "defaclobjtype");
            return (Criteria) this;
        }

        public Criteria andDefaclobjtypeLessThanOrEqualTo(String value) {
            addCriterion("defaclobjtype <=", value, "defaclobjtype");
            return (Criteria) this;
        }

        public Criteria andDefaclobjtypeLike(String value) {
            addCriterion("defaclobjtype like", value, "defaclobjtype");
            return (Criteria) this;
        }

        public Criteria andDefaclobjtypeNotLike(String value) {
            addCriterion("defaclobjtype not like", value, "defaclobjtype");
            return (Criteria) this;
        }

        public Criteria andDefaclobjtypeIn(List<String> values) {
            addCriterion("defaclobjtype in", values, "defaclobjtype");
            return (Criteria) this;
        }

        public Criteria andDefaclobjtypeNotIn(List<String> values) {
            addCriterion("defaclobjtype not in", values, "defaclobjtype");
            return (Criteria) this;
        }

        public Criteria andDefaclobjtypeBetween(String value1, String value2) {
            addCriterion("defaclobjtype between", value1, value2, "defaclobjtype");
            return (Criteria) this;
        }

        public Criteria andDefaclobjtypeNotBetween(String value1, String value2) {
            addCriterion("defaclobjtype not between", value1, value2, "defaclobjtype");
            return (Criteria) this;
        }

        public Criteria andDefaclaclIsNull() {
            addCriterion("defaclacl is null");
            return (Criteria) this;
        }

        public Criteria andDefaclaclIsNotNull() {
            addCriterion("defaclacl is not null");
            return (Criteria) this;
        }

        public Criteria andDefaclaclEqualTo(Object value) {
            addCriterion("defaclacl =", value, "defaclacl");
            return (Criteria) this;
        }

        public Criteria andDefaclaclNotEqualTo(Object value) {
            addCriterion("defaclacl <>", value, "defaclacl");
            return (Criteria) this;
        }

        public Criteria andDefaclaclGreaterThan(Object value) {
            addCriterion("defaclacl >", value, "defaclacl");
            return (Criteria) this;
        }

        public Criteria andDefaclaclGreaterThanOrEqualTo(Object value) {
            addCriterion("defaclacl >=", value, "defaclacl");
            return (Criteria) this;
        }

        public Criteria andDefaclaclLessThan(Object value) {
            addCriterion("defaclacl <", value, "defaclacl");
            return (Criteria) this;
        }

        public Criteria andDefaclaclLessThanOrEqualTo(Object value) {
            addCriterion("defaclacl <=", value, "defaclacl");
            return (Criteria) this;
        }

        public Criteria andDefaclaclIn(List<Object> values) {
            addCriterion("defaclacl in", values, "defaclacl");
            return (Criteria) this;
        }

        public Criteria andDefaclaclNotIn(List<Object> values) {
            addCriterion("defaclacl not in", values, "defaclacl");
            return (Criteria) this;
        }

        public Criteria andDefaclaclBetween(Object value1, Object value2) {
            addCriterion("defaclacl between", value1, value2, "defaclacl");
            return (Criteria) this;
        }

        public Criteria andDefaclaclNotBetween(Object value1, Object value2) {
            addCriterion("defaclacl not between", value1, value2, "defaclacl");
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