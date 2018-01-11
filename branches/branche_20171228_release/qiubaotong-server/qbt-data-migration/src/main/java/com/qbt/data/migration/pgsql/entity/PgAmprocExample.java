package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgAmprocExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgAmprocExample() {
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

        public Criteria andAmprocfamilyIsNull() {
            addCriterion("amprocfamily is null");
            return (Criteria) this;
        }

        public Criteria andAmprocfamilyIsNotNull() {
            addCriterion("amprocfamily is not null");
            return (Criteria) this;
        }

        public Criteria andAmprocfamilyEqualTo(Long value) {
            addCriterion("amprocfamily =", value, "amprocfamily");
            return (Criteria) this;
        }

        public Criteria andAmprocfamilyNotEqualTo(Long value) {
            addCriterion("amprocfamily <>", value, "amprocfamily");
            return (Criteria) this;
        }

        public Criteria andAmprocfamilyGreaterThan(Long value) {
            addCriterion("amprocfamily >", value, "amprocfamily");
            return (Criteria) this;
        }

        public Criteria andAmprocfamilyGreaterThanOrEqualTo(Long value) {
            addCriterion("amprocfamily >=", value, "amprocfamily");
            return (Criteria) this;
        }

        public Criteria andAmprocfamilyLessThan(Long value) {
            addCriterion("amprocfamily <", value, "amprocfamily");
            return (Criteria) this;
        }

        public Criteria andAmprocfamilyLessThanOrEqualTo(Long value) {
            addCriterion("amprocfamily <=", value, "amprocfamily");
            return (Criteria) this;
        }

        public Criteria andAmprocfamilyIn(List<Long> values) {
            addCriterion("amprocfamily in", values, "amprocfamily");
            return (Criteria) this;
        }

        public Criteria andAmprocfamilyNotIn(List<Long> values) {
            addCriterion("amprocfamily not in", values, "amprocfamily");
            return (Criteria) this;
        }

        public Criteria andAmprocfamilyBetween(Long value1, Long value2) {
            addCriterion("amprocfamily between", value1, value2, "amprocfamily");
            return (Criteria) this;
        }

        public Criteria andAmprocfamilyNotBetween(Long value1, Long value2) {
            addCriterion("amprocfamily not between", value1, value2, "amprocfamily");
            return (Criteria) this;
        }

        public Criteria andAmproclefttypeIsNull() {
            addCriterion("amproclefttype is null");
            return (Criteria) this;
        }

        public Criteria andAmproclefttypeIsNotNull() {
            addCriterion("amproclefttype is not null");
            return (Criteria) this;
        }

        public Criteria andAmproclefttypeEqualTo(Long value) {
            addCriterion("amproclefttype =", value, "amproclefttype");
            return (Criteria) this;
        }

        public Criteria andAmproclefttypeNotEqualTo(Long value) {
            addCriterion("amproclefttype <>", value, "amproclefttype");
            return (Criteria) this;
        }

        public Criteria andAmproclefttypeGreaterThan(Long value) {
            addCriterion("amproclefttype >", value, "amproclefttype");
            return (Criteria) this;
        }

        public Criteria andAmproclefttypeGreaterThanOrEqualTo(Long value) {
            addCriterion("amproclefttype >=", value, "amproclefttype");
            return (Criteria) this;
        }

        public Criteria andAmproclefttypeLessThan(Long value) {
            addCriterion("amproclefttype <", value, "amproclefttype");
            return (Criteria) this;
        }

        public Criteria andAmproclefttypeLessThanOrEqualTo(Long value) {
            addCriterion("amproclefttype <=", value, "amproclefttype");
            return (Criteria) this;
        }

        public Criteria andAmproclefttypeIn(List<Long> values) {
            addCriterion("amproclefttype in", values, "amproclefttype");
            return (Criteria) this;
        }

        public Criteria andAmproclefttypeNotIn(List<Long> values) {
            addCriterion("amproclefttype not in", values, "amproclefttype");
            return (Criteria) this;
        }

        public Criteria andAmproclefttypeBetween(Long value1, Long value2) {
            addCriterion("amproclefttype between", value1, value2, "amproclefttype");
            return (Criteria) this;
        }

        public Criteria andAmproclefttypeNotBetween(Long value1, Long value2) {
            addCriterion("amproclefttype not between", value1, value2, "amproclefttype");
            return (Criteria) this;
        }

        public Criteria andAmprocrighttypeIsNull() {
            addCriterion("amprocrighttype is null");
            return (Criteria) this;
        }

        public Criteria andAmprocrighttypeIsNotNull() {
            addCriterion("amprocrighttype is not null");
            return (Criteria) this;
        }

        public Criteria andAmprocrighttypeEqualTo(Long value) {
            addCriterion("amprocrighttype =", value, "amprocrighttype");
            return (Criteria) this;
        }

        public Criteria andAmprocrighttypeNotEqualTo(Long value) {
            addCriterion("amprocrighttype <>", value, "amprocrighttype");
            return (Criteria) this;
        }

        public Criteria andAmprocrighttypeGreaterThan(Long value) {
            addCriterion("amprocrighttype >", value, "amprocrighttype");
            return (Criteria) this;
        }

        public Criteria andAmprocrighttypeGreaterThanOrEqualTo(Long value) {
            addCriterion("amprocrighttype >=", value, "amprocrighttype");
            return (Criteria) this;
        }

        public Criteria andAmprocrighttypeLessThan(Long value) {
            addCriterion("amprocrighttype <", value, "amprocrighttype");
            return (Criteria) this;
        }

        public Criteria andAmprocrighttypeLessThanOrEqualTo(Long value) {
            addCriterion("amprocrighttype <=", value, "amprocrighttype");
            return (Criteria) this;
        }

        public Criteria andAmprocrighttypeIn(List<Long> values) {
            addCriterion("amprocrighttype in", values, "amprocrighttype");
            return (Criteria) this;
        }

        public Criteria andAmprocrighttypeNotIn(List<Long> values) {
            addCriterion("amprocrighttype not in", values, "amprocrighttype");
            return (Criteria) this;
        }

        public Criteria andAmprocrighttypeBetween(Long value1, Long value2) {
            addCriterion("amprocrighttype between", value1, value2, "amprocrighttype");
            return (Criteria) this;
        }

        public Criteria andAmprocrighttypeNotBetween(Long value1, Long value2) {
            addCriterion("amprocrighttype not between", value1, value2, "amprocrighttype");
            return (Criteria) this;
        }

        public Criteria andAmprocnumIsNull() {
            addCriterion("amprocnum is null");
            return (Criteria) this;
        }

        public Criteria andAmprocnumIsNotNull() {
            addCriterion("amprocnum is not null");
            return (Criteria) this;
        }

        public Criteria andAmprocnumEqualTo(Short value) {
            addCriterion("amprocnum =", value, "amprocnum");
            return (Criteria) this;
        }

        public Criteria andAmprocnumNotEqualTo(Short value) {
            addCriterion("amprocnum <>", value, "amprocnum");
            return (Criteria) this;
        }

        public Criteria andAmprocnumGreaterThan(Short value) {
            addCriterion("amprocnum >", value, "amprocnum");
            return (Criteria) this;
        }

        public Criteria andAmprocnumGreaterThanOrEqualTo(Short value) {
            addCriterion("amprocnum >=", value, "amprocnum");
            return (Criteria) this;
        }

        public Criteria andAmprocnumLessThan(Short value) {
            addCriterion("amprocnum <", value, "amprocnum");
            return (Criteria) this;
        }

        public Criteria andAmprocnumLessThanOrEqualTo(Short value) {
            addCriterion("amprocnum <=", value, "amprocnum");
            return (Criteria) this;
        }

        public Criteria andAmprocnumIn(List<Short> values) {
            addCriterion("amprocnum in", values, "amprocnum");
            return (Criteria) this;
        }

        public Criteria andAmprocnumNotIn(List<Short> values) {
            addCriterion("amprocnum not in", values, "amprocnum");
            return (Criteria) this;
        }

        public Criteria andAmprocnumBetween(Short value1, Short value2) {
            addCriterion("amprocnum between", value1, value2, "amprocnum");
            return (Criteria) this;
        }

        public Criteria andAmprocnumNotBetween(Short value1, Short value2) {
            addCriterion("amprocnum not between", value1, value2, "amprocnum");
            return (Criteria) this;
        }

        public Criteria andAmprocIsNull() {
            addCriterion("amproc is null");
            return (Criteria) this;
        }

        public Criteria andAmprocIsNotNull() {
            addCriterion("amproc is not null");
            return (Criteria) this;
        }

        public Criteria andAmprocEqualTo(Object value) {
            addCriterion("amproc =", value, "amproc");
            return (Criteria) this;
        }

        public Criteria andAmprocNotEqualTo(Object value) {
            addCriterion("amproc <>", value, "amproc");
            return (Criteria) this;
        }

        public Criteria andAmprocGreaterThan(Object value) {
            addCriterion("amproc >", value, "amproc");
            return (Criteria) this;
        }

        public Criteria andAmprocGreaterThanOrEqualTo(Object value) {
            addCriterion("amproc >=", value, "amproc");
            return (Criteria) this;
        }

        public Criteria andAmprocLessThan(Object value) {
            addCriterion("amproc <", value, "amproc");
            return (Criteria) this;
        }

        public Criteria andAmprocLessThanOrEqualTo(Object value) {
            addCriterion("amproc <=", value, "amproc");
            return (Criteria) this;
        }

        public Criteria andAmprocIn(List<Object> values) {
            addCriterion("amproc in", values, "amproc");
            return (Criteria) this;
        }

        public Criteria andAmprocNotIn(List<Object> values) {
            addCriterion("amproc not in", values, "amproc");
            return (Criteria) this;
        }

        public Criteria andAmprocBetween(Object value1, Object value2) {
            addCriterion("amproc between", value1, value2, "amproc");
            return (Criteria) this;
        }

        public Criteria andAmprocNotBetween(Object value1, Object value2) {
            addCriterion("amproc not between", value1, value2, "amproc");
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