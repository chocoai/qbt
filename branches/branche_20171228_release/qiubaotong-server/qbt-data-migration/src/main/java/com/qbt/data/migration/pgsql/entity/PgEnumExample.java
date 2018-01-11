package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgEnumExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgEnumExample() {
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

        public Criteria andEnumtypidIsNull() {
            addCriterion("enumtypid is null");
            return (Criteria) this;
        }

        public Criteria andEnumtypidIsNotNull() {
            addCriterion("enumtypid is not null");
            return (Criteria) this;
        }

        public Criteria andEnumtypidEqualTo(Long value) {
            addCriterion("enumtypid =", value, "enumtypid");
            return (Criteria) this;
        }

        public Criteria andEnumtypidNotEqualTo(Long value) {
            addCriterion("enumtypid <>", value, "enumtypid");
            return (Criteria) this;
        }

        public Criteria andEnumtypidGreaterThan(Long value) {
            addCriterion("enumtypid >", value, "enumtypid");
            return (Criteria) this;
        }

        public Criteria andEnumtypidGreaterThanOrEqualTo(Long value) {
            addCriterion("enumtypid >=", value, "enumtypid");
            return (Criteria) this;
        }

        public Criteria andEnumtypidLessThan(Long value) {
            addCriterion("enumtypid <", value, "enumtypid");
            return (Criteria) this;
        }

        public Criteria andEnumtypidLessThanOrEqualTo(Long value) {
            addCriterion("enumtypid <=", value, "enumtypid");
            return (Criteria) this;
        }

        public Criteria andEnumtypidIn(List<Long> values) {
            addCriterion("enumtypid in", values, "enumtypid");
            return (Criteria) this;
        }

        public Criteria andEnumtypidNotIn(List<Long> values) {
            addCriterion("enumtypid not in", values, "enumtypid");
            return (Criteria) this;
        }

        public Criteria andEnumtypidBetween(Long value1, Long value2) {
            addCriterion("enumtypid between", value1, value2, "enumtypid");
            return (Criteria) this;
        }

        public Criteria andEnumtypidNotBetween(Long value1, Long value2) {
            addCriterion("enumtypid not between", value1, value2, "enumtypid");
            return (Criteria) this;
        }

        public Criteria andEnumsortorderIsNull() {
            addCriterion("enumsortorder is null");
            return (Criteria) this;
        }

        public Criteria andEnumsortorderIsNotNull() {
            addCriterion("enumsortorder is not null");
            return (Criteria) this;
        }

        public Criteria andEnumsortorderEqualTo(Float value) {
            addCriterion("enumsortorder =", value, "enumsortorder");
            return (Criteria) this;
        }

        public Criteria andEnumsortorderNotEqualTo(Float value) {
            addCriterion("enumsortorder <>", value, "enumsortorder");
            return (Criteria) this;
        }

        public Criteria andEnumsortorderGreaterThan(Float value) {
            addCriterion("enumsortorder >", value, "enumsortorder");
            return (Criteria) this;
        }

        public Criteria andEnumsortorderGreaterThanOrEqualTo(Float value) {
            addCriterion("enumsortorder >=", value, "enumsortorder");
            return (Criteria) this;
        }

        public Criteria andEnumsortorderLessThan(Float value) {
            addCriterion("enumsortorder <", value, "enumsortorder");
            return (Criteria) this;
        }

        public Criteria andEnumsortorderLessThanOrEqualTo(Float value) {
            addCriterion("enumsortorder <=", value, "enumsortorder");
            return (Criteria) this;
        }

        public Criteria andEnumsortorderIn(List<Float> values) {
            addCriterion("enumsortorder in", values, "enumsortorder");
            return (Criteria) this;
        }

        public Criteria andEnumsortorderNotIn(List<Float> values) {
            addCriterion("enumsortorder not in", values, "enumsortorder");
            return (Criteria) this;
        }

        public Criteria andEnumsortorderBetween(Float value1, Float value2) {
            addCriterion("enumsortorder between", value1, value2, "enumsortorder");
            return (Criteria) this;
        }

        public Criteria andEnumsortorderNotBetween(Float value1, Float value2) {
            addCriterion("enumsortorder not between", value1, value2, "enumsortorder");
            return (Criteria) this;
        }

        public Criteria andEnumlabelIsNull() {
            addCriterion("enumlabel is null");
            return (Criteria) this;
        }

        public Criteria andEnumlabelIsNotNull() {
            addCriterion("enumlabel is not null");
            return (Criteria) this;
        }

        public Criteria andEnumlabelEqualTo(String value) {
            addCriterion("enumlabel =", value, "enumlabel");
            return (Criteria) this;
        }

        public Criteria andEnumlabelNotEqualTo(String value) {
            addCriterion("enumlabel <>", value, "enumlabel");
            return (Criteria) this;
        }

        public Criteria andEnumlabelGreaterThan(String value) {
            addCriterion("enumlabel >", value, "enumlabel");
            return (Criteria) this;
        }

        public Criteria andEnumlabelGreaterThanOrEqualTo(String value) {
            addCriterion("enumlabel >=", value, "enumlabel");
            return (Criteria) this;
        }

        public Criteria andEnumlabelLessThan(String value) {
            addCriterion("enumlabel <", value, "enumlabel");
            return (Criteria) this;
        }

        public Criteria andEnumlabelLessThanOrEqualTo(String value) {
            addCriterion("enumlabel <=", value, "enumlabel");
            return (Criteria) this;
        }

        public Criteria andEnumlabelLike(String value) {
            addCriterion("enumlabel like", value, "enumlabel");
            return (Criteria) this;
        }

        public Criteria andEnumlabelNotLike(String value) {
            addCriterion("enumlabel not like", value, "enumlabel");
            return (Criteria) this;
        }

        public Criteria andEnumlabelIn(List<String> values) {
            addCriterion("enumlabel in", values, "enumlabel");
            return (Criteria) this;
        }

        public Criteria andEnumlabelNotIn(List<String> values) {
            addCriterion("enumlabel not in", values, "enumlabel");
            return (Criteria) this;
        }

        public Criteria andEnumlabelBetween(String value1, String value2) {
            addCriterion("enumlabel between", value1, value2, "enumlabel");
            return (Criteria) this;
        }

        public Criteria andEnumlabelNotBetween(String value1, String value2) {
            addCriterion("enumlabel not between", value1, value2, "enumlabel");
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