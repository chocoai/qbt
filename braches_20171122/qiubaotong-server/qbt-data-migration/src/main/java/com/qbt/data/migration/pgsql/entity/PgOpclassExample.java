package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgOpclassExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgOpclassExample() {
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

        public Criteria andOpcmethodIsNull() {
            addCriterion("opcmethod is null");
            return (Criteria) this;
        }

        public Criteria andOpcmethodIsNotNull() {
            addCriterion("opcmethod is not null");
            return (Criteria) this;
        }

        public Criteria andOpcmethodEqualTo(Long value) {
            addCriterion("opcmethod =", value, "opcmethod");
            return (Criteria) this;
        }

        public Criteria andOpcmethodNotEqualTo(Long value) {
            addCriterion("opcmethod <>", value, "opcmethod");
            return (Criteria) this;
        }

        public Criteria andOpcmethodGreaterThan(Long value) {
            addCriterion("opcmethod >", value, "opcmethod");
            return (Criteria) this;
        }

        public Criteria andOpcmethodGreaterThanOrEqualTo(Long value) {
            addCriterion("opcmethod >=", value, "opcmethod");
            return (Criteria) this;
        }

        public Criteria andOpcmethodLessThan(Long value) {
            addCriterion("opcmethod <", value, "opcmethod");
            return (Criteria) this;
        }

        public Criteria andOpcmethodLessThanOrEqualTo(Long value) {
            addCriterion("opcmethod <=", value, "opcmethod");
            return (Criteria) this;
        }

        public Criteria andOpcmethodIn(List<Long> values) {
            addCriterion("opcmethod in", values, "opcmethod");
            return (Criteria) this;
        }

        public Criteria andOpcmethodNotIn(List<Long> values) {
            addCriterion("opcmethod not in", values, "opcmethod");
            return (Criteria) this;
        }

        public Criteria andOpcmethodBetween(Long value1, Long value2) {
            addCriterion("opcmethod between", value1, value2, "opcmethod");
            return (Criteria) this;
        }

        public Criteria andOpcmethodNotBetween(Long value1, Long value2) {
            addCriterion("opcmethod not between", value1, value2, "opcmethod");
            return (Criteria) this;
        }

        public Criteria andOpcnameIsNull() {
            addCriterion("opcname is null");
            return (Criteria) this;
        }

        public Criteria andOpcnameIsNotNull() {
            addCriterion("opcname is not null");
            return (Criteria) this;
        }

        public Criteria andOpcnameEqualTo(String value) {
            addCriterion("opcname =", value, "opcname");
            return (Criteria) this;
        }

        public Criteria andOpcnameNotEqualTo(String value) {
            addCriterion("opcname <>", value, "opcname");
            return (Criteria) this;
        }

        public Criteria andOpcnameGreaterThan(String value) {
            addCriterion("opcname >", value, "opcname");
            return (Criteria) this;
        }

        public Criteria andOpcnameGreaterThanOrEqualTo(String value) {
            addCriterion("opcname >=", value, "opcname");
            return (Criteria) this;
        }

        public Criteria andOpcnameLessThan(String value) {
            addCriterion("opcname <", value, "opcname");
            return (Criteria) this;
        }

        public Criteria andOpcnameLessThanOrEqualTo(String value) {
            addCriterion("opcname <=", value, "opcname");
            return (Criteria) this;
        }

        public Criteria andOpcnameLike(String value) {
            addCriterion("opcname like", value, "opcname");
            return (Criteria) this;
        }

        public Criteria andOpcnameNotLike(String value) {
            addCriterion("opcname not like", value, "opcname");
            return (Criteria) this;
        }

        public Criteria andOpcnameIn(List<String> values) {
            addCriterion("opcname in", values, "opcname");
            return (Criteria) this;
        }

        public Criteria andOpcnameNotIn(List<String> values) {
            addCriterion("opcname not in", values, "opcname");
            return (Criteria) this;
        }

        public Criteria andOpcnameBetween(String value1, String value2) {
            addCriterion("opcname between", value1, value2, "opcname");
            return (Criteria) this;
        }

        public Criteria andOpcnameNotBetween(String value1, String value2) {
            addCriterion("opcname not between", value1, value2, "opcname");
            return (Criteria) this;
        }

        public Criteria andOpcnamespaceIsNull() {
            addCriterion("opcnamespace is null");
            return (Criteria) this;
        }

        public Criteria andOpcnamespaceIsNotNull() {
            addCriterion("opcnamespace is not null");
            return (Criteria) this;
        }

        public Criteria andOpcnamespaceEqualTo(Long value) {
            addCriterion("opcnamespace =", value, "opcnamespace");
            return (Criteria) this;
        }

        public Criteria andOpcnamespaceNotEqualTo(Long value) {
            addCriterion("opcnamespace <>", value, "opcnamespace");
            return (Criteria) this;
        }

        public Criteria andOpcnamespaceGreaterThan(Long value) {
            addCriterion("opcnamespace >", value, "opcnamespace");
            return (Criteria) this;
        }

        public Criteria andOpcnamespaceGreaterThanOrEqualTo(Long value) {
            addCriterion("opcnamespace >=", value, "opcnamespace");
            return (Criteria) this;
        }

        public Criteria andOpcnamespaceLessThan(Long value) {
            addCriterion("opcnamespace <", value, "opcnamespace");
            return (Criteria) this;
        }

        public Criteria andOpcnamespaceLessThanOrEqualTo(Long value) {
            addCriterion("opcnamespace <=", value, "opcnamespace");
            return (Criteria) this;
        }

        public Criteria andOpcnamespaceIn(List<Long> values) {
            addCriterion("opcnamespace in", values, "opcnamespace");
            return (Criteria) this;
        }

        public Criteria andOpcnamespaceNotIn(List<Long> values) {
            addCriterion("opcnamespace not in", values, "opcnamespace");
            return (Criteria) this;
        }

        public Criteria andOpcnamespaceBetween(Long value1, Long value2) {
            addCriterion("opcnamespace between", value1, value2, "opcnamespace");
            return (Criteria) this;
        }

        public Criteria andOpcnamespaceNotBetween(Long value1, Long value2) {
            addCriterion("opcnamespace not between", value1, value2, "opcnamespace");
            return (Criteria) this;
        }

        public Criteria andOpcownerIsNull() {
            addCriterion("opcowner is null");
            return (Criteria) this;
        }

        public Criteria andOpcownerIsNotNull() {
            addCriterion("opcowner is not null");
            return (Criteria) this;
        }

        public Criteria andOpcownerEqualTo(Long value) {
            addCriterion("opcowner =", value, "opcowner");
            return (Criteria) this;
        }

        public Criteria andOpcownerNotEqualTo(Long value) {
            addCriterion("opcowner <>", value, "opcowner");
            return (Criteria) this;
        }

        public Criteria andOpcownerGreaterThan(Long value) {
            addCriterion("opcowner >", value, "opcowner");
            return (Criteria) this;
        }

        public Criteria andOpcownerGreaterThanOrEqualTo(Long value) {
            addCriterion("opcowner >=", value, "opcowner");
            return (Criteria) this;
        }

        public Criteria andOpcownerLessThan(Long value) {
            addCriterion("opcowner <", value, "opcowner");
            return (Criteria) this;
        }

        public Criteria andOpcownerLessThanOrEqualTo(Long value) {
            addCriterion("opcowner <=", value, "opcowner");
            return (Criteria) this;
        }

        public Criteria andOpcownerIn(List<Long> values) {
            addCriterion("opcowner in", values, "opcowner");
            return (Criteria) this;
        }

        public Criteria andOpcownerNotIn(List<Long> values) {
            addCriterion("opcowner not in", values, "opcowner");
            return (Criteria) this;
        }

        public Criteria andOpcownerBetween(Long value1, Long value2) {
            addCriterion("opcowner between", value1, value2, "opcowner");
            return (Criteria) this;
        }

        public Criteria andOpcownerNotBetween(Long value1, Long value2) {
            addCriterion("opcowner not between", value1, value2, "opcowner");
            return (Criteria) this;
        }

        public Criteria andOpcfamilyIsNull() {
            addCriterion("opcfamily is null");
            return (Criteria) this;
        }

        public Criteria andOpcfamilyIsNotNull() {
            addCriterion("opcfamily is not null");
            return (Criteria) this;
        }

        public Criteria andOpcfamilyEqualTo(Long value) {
            addCriterion("opcfamily =", value, "opcfamily");
            return (Criteria) this;
        }

        public Criteria andOpcfamilyNotEqualTo(Long value) {
            addCriterion("opcfamily <>", value, "opcfamily");
            return (Criteria) this;
        }

        public Criteria andOpcfamilyGreaterThan(Long value) {
            addCriterion("opcfamily >", value, "opcfamily");
            return (Criteria) this;
        }

        public Criteria andOpcfamilyGreaterThanOrEqualTo(Long value) {
            addCriterion("opcfamily >=", value, "opcfamily");
            return (Criteria) this;
        }

        public Criteria andOpcfamilyLessThan(Long value) {
            addCriterion("opcfamily <", value, "opcfamily");
            return (Criteria) this;
        }

        public Criteria andOpcfamilyLessThanOrEqualTo(Long value) {
            addCriterion("opcfamily <=", value, "opcfamily");
            return (Criteria) this;
        }

        public Criteria andOpcfamilyIn(List<Long> values) {
            addCriterion("opcfamily in", values, "opcfamily");
            return (Criteria) this;
        }

        public Criteria andOpcfamilyNotIn(List<Long> values) {
            addCriterion("opcfamily not in", values, "opcfamily");
            return (Criteria) this;
        }

        public Criteria andOpcfamilyBetween(Long value1, Long value2) {
            addCriterion("opcfamily between", value1, value2, "opcfamily");
            return (Criteria) this;
        }

        public Criteria andOpcfamilyNotBetween(Long value1, Long value2) {
            addCriterion("opcfamily not between", value1, value2, "opcfamily");
            return (Criteria) this;
        }

        public Criteria andOpcintypeIsNull() {
            addCriterion("opcintype is null");
            return (Criteria) this;
        }

        public Criteria andOpcintypeIsNotNull() {
            addCriterion("opcintype is not null");
            return (Criteria) this;
        }

        public Criteria andOpcintypeEqualTo(Long value) {
            addCriterion("opcintype =", value, "opcintype");
            return (Criteria) this;
        }

        public Criteria andOpcintypeNotEqualTo(Long value) {
            addCriterion("opcintype <>", value, "opcintype");
            return (Criteria) this;
        }

        public Criteria andOpcintypeGreaterThan(Long value) {
            addCriterion("opcintype >", value, "opcintype");
            return (Criteria) this;
        }

        public Criteria andOpcintypeGreaterThanOrEqualTo(Long value) {
            addCriterion("opcintype >=", value, "opcintype");
            return (Criteria) this;
        }

        public Criteria andOpcintypeLessThan(Long value) {
            addCriterion("opcintype <", value, "opcintype");
            return (Criteria) this;
        }

        public Criteria andOpcintypeLessThanOrEqualTo(Long value) {
            addCriterion("opcintype <=", value, "opcintype");
            return (Criteria) this;
        }

        public Criteria andOpcintypeIn(List<Long> values) {
            addCriterion("opcintype in", values, "opcintype");
            return (Criteria) this;
        }

        public Criteria andOpcintypeNotIn(List<Long> values) {
            addCriterion("opcintype not in", values, "opcintype");
            return (Criteria) this;
        }

        public Criteria andOpcintypeBetween(Long value1, Long value2) {
            addCriterion("opcintype between", value1, value2, "opcintype");
            return (Criteria) this;
        }

        public Criteria andOpcintypeNotBetween(Long value1, Long value2) {
            addCriterion("opcintype not between", value1, value2, "opcintype");
            return (Criteria) this;
        }

        public Criteria andOpcdefaultIsNull() {
            addCriterion("opcdefault is null");
            return (Criteria) this;
        }

        public Criteria andOpcdefaultIsNotNull() {
            addCriterion("opcdefault is not null");
            return (Criteria) this;
        }

        public Criteria andOpcdefaultEqualTo(Boolean value) {
            addCriterion("opcdefault =", value, "opcdefault");
            return (Criteria) this;
        }

        public Criteria andOpcdefaultNotEqualTo(Boolean value) {
            addCriterion("opcdefault <>", value, "opcdefault");
            return (Criteria) this;
        }

        public Criteria andOpcdefaultGreaterThan(Boolean value) {
            addCriterion("opcdefault >", value, "opcdefault");
            return (Criteria) this;
        }

        public Criteria andOpcdefaultGreaterThanOrEqualTo(Boolean value) {
            addCriterion("opcdefault >=", value, "opcdefault");
            return (Criteria) this;
        }

        public Criteria andOpcdefaultLessThan(Boolean value) {
            addCriterion("opcdefault <", value, "opcdefault");
            return (Criteria) this;
        }

        public Criteria andOpcdefaultLessThanOrEqualTo(Boolean value) {
            addCriterion("opcdefault <=", value, "opcdefault");
            return (Criteria) this;
        }

        public Criteria andOpcdefaultIn(List<Boolean> values) {
            addCriterion("opcdefault in", values, "opcdefault");
            return (Criteria) this;
        }

        public Criteria andOpcdefaultNotIn(List<Boolean> values) {
            addCriterion("opcdefault not in", values, "opcdefault");
            return (Criteria) this;
        }

        public Criteria andOpcdefaultBetween(Boolean value1, Boolean value2) {
            addCriterion("opcdefault between", value1, value2, "opcdefault");
            return (Criteria) this;
        }

        public Criteria andOpcdefaultNotBetween(Boolean value1, Boolean value2) {
            addCriterion("opcdefault not between", value1, value2, "opcdefault");
            return (Criteria) this;
        }

        public Criteria andOpckeytypeIsNull() {
            addCriterion("opckeytype is null");
            return (Criteria) this;
        }

        public Criteria andOpckeytypeIsNotNull() {
            addCriterion("opckeytype is not null");
            return (Criteria) this;
        }

        public Criteria andOpckeytypeEqualTo(Long value) {
            addCriterion("opckeytype =", value, "opckeytype");
            return (Criteria) this;
        }

        public Criteria andOpckeytypeNotEqualTo(Long value) {
            addCriterion("opckeytype <>", value, "opckeytype");
            return (Criteria) this;
        }

        public Criteria andOpckeytypeGreaterThan(Long value) {
            addCriterion("opckeytype >", value, "opckeytype");
            return (Criteria) this;
        }

        public Criteria andOpckeytypeGreaterThanOrEqualTo(Long value) {
            addCriterion("opckeytype >=", value, "opckeytype");
            return (Criteria) this;
        }

        public Criteria andOpckeytypeLessThan(Long value) {
            addCriterion("opckeytype <", value, "opckeytype");
            return (Criteria) this;
        }

        public Criteria andOpckeytypeLessThanOrEqualTo(Long value) {
            addCriterion("opckeytype <=", value, "opckeytype");
            return (Criteria) this;
        }

        public Criteria andOpckeytypeIn(List<Long> values) {
            addCriterion("opckeytype in", values, "opckeytype");
            return (Criteria) this;
        }

        public Criteria andOpckeytypeNotIn(List<Long> values) {
            addCriterion("opckeytype not in", values, "opckeytype");
            return (Criteria) this;
        }

        public Criteria andOpckeytypeBetween(Long value1, Long value2) {
            addCriterion("opckeytype between", value1, value2, "opckeytype");
            return (Criteria) this;
        }

        public Criteria andOpckeytypeNotBetween(Long value1, Long value2) {
            addCriterion("opckeytype not between", value1, value2, "opckeytype");
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