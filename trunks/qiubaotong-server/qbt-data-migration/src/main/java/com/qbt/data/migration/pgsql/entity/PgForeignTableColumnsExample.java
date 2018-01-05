package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgForeignTableColumnsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgForeignTableColumnsExample() {
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

        public Criteria andNspnameIsNull() {
            addCriterion("nspname is null");
            return (Criteria) this;
        }

        public Criteria andNspnameIsNotNull() {
            addCriterion("nspname is not null");
            return (Criteria) this;
        }

        public Criteria andNspnameEqualTo(String value) {
            addCriterion("nspname =", value, "nspname");
            return (Criteria) this;
        }

        public Criteria andNspnameNotEqualTo(String value) {
            addCriterion("nspname <>", value, "nspname");
            return (Criteria) this;
        }

        public Criteria andNspnameGreaterThan(String value) {
            addCriterion("nspname >", value, "nspname");
            return (Criteria) this;
        }

        public Criteria andNspnameGreaterThanOrEqualTo(String value) {
            addCriterion("nspname >=", value, "nspname");
            return (Criteria) this;
        }

        public Criteria andNspnameLessThan(String value) {
            addCriterion("nspname <", value, "nspname");
            return (Criteria) this;
        }

        public Criteria andNspnameLessThanOrEqualTo(String value) {
            addCriterion("nspname <=", value, "nspname");
            return (Criteria) this;
        }

        public Criteria andNspnameLike(String value) {
            addCriterion("nspname like", value, "nspname");
            return (Criteria) this;
        }

        public Criteria andNspnameNotLike(String value) {
            addCriterion("nspname not like", value, "nspname");
            return (Criteria) this;
        }

        public Criteria andNspnameIn(List<String> values) {
            addCriterion("nspname in", values, "nspname");
            return (Criteria) this;
        }

        public Criteria andNspnameNotIn(List<String> values) {
            addCriterion("nspname not in", values, "nspname");
            return (Criteria) this;
        }

        public Criteria andNspnameBetween(String value1, String value2) {
            addCriterion("nspname between", value1, value2, "nspname");
            return (Criteria) this;
        }

        public Criteria andNspnameNotBetween(String value1, String value2) {
            addCriterion("nspname not between", value1, value2, "nspname");
            return (Criteria) this;
        }

        public Criteria andRelnameIsNull() {
            addCriterion("relname is null");
            return (Criteria) this;
        }

        public Criteria andRelnameIsNotNull() {
            addCriterion("relname is not null");
            return (Criteria) this;
        }

        public Criteria andRelnameEqualTo(String value) {
            addCriterion("relname =", value, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameNotEqualTo(String value) {
            addCriterion("relname <>", value, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameGreaterThan(String value) {
            addCriterion("relname >", value, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameGreaterThanOrEqualTo(String value) {
            addCriterion("relname >=", value, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameLessThan(String value) {
            addCriterion("relname <", value, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameLessThanOrEqualTo(String value) {
            addCriterion("relname <=", value, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameLike(String value) {
            addCriterion("relname like", value, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameNotLike(String value) {
            addCriterion("relname not like", value, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameIn(List<String> values) {
            addCriterion("relname in", values, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameNotIn(List<String> values) {
            addCriterion("relname not in", values, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameBetween(String value1, String value2) {
            addCriterion("relname between", value1, value2, "relname");
            return (Criteria) this;
        }

        public Criteria andRelnameNotBetween(String value1, String value2) {
            addCriterion("relname not between", value1, value2, "relname");
            return (Criteria) this;
        }

        public Criteria andAttnameIsNull() {
            addCriterion("attname is null");
            return (Criteria) this;
        }

        public Criteria andAttnameIsNotNull() {
            addCriterion("attname is not null");
            return (Criteria) this;
        }

        public Criteria andAttnameEqualTo(String value) {
            addCriterion("attname =", value, "attname");
            return (Criteria) this;
        }

        public Criteria andAttnameNotEqualTo(String value) {
            addCriterion("attname <>", value, "attname");
            return (Criteria) this;
        }

        public Criteria andAttnameGreaterThan(String value) {
            addCriterion("attname >", value, "attname");
            return (Criteria) this;
        }

        public Criteria andAttnameGreaterThanOrEqualTo(String value) {
            addCriterion("attname >=", value, "attname");
            return (Criteria) this;
        }

        public Criteria andAttnameLessThan(String value) {
            addCriterion("attname <", value, "attname");
            return (Criteria) this;
        }

        public Criteria andAttnameLessThanOrEqualTo(String value) {
            addCriterion("attname <=", value, "attname");
            return (Criteria) this;
        }

        public Criteria andAttnameLike(String value) {
            addCriterion("attname like", value, "attname");
            return (Criteria) this;
        }

        public Criteria andAttnameNotLike(String value) {
            addCriterion("attname not like", value, "attname");
            return (Criteria) this;
        }

        public Criteria andAttnameIn(List<String> values) {
            addCriterion("attname in", values, "attname");
            return (Criteria) this;
        }

        public Criteria andAttnameNotIn(List<String> values) {
            addCriterion("attname not in", values, "attname");
            return (Criteria) this;
        }

        public Criteria andAttnameBetween(String value1, String value2) {
            addCriterion("attname between", value1, value2, "attname");
            return (Criteria) this;
        }

        public Criteria andAttnameNotBetween(String value1, String value2) {
            addCriterion("attname not between", value1, value2, "attname");
            return (Criteria) this;
        }

        public Criteria andAttfdwoptionsIsNull() {
            addCriterion("attfdwoptions is null");
            return (Criteria) this;
        }

        public Criteria andAttfdwoptionsIsNotNull() {
            addCriterion("attfdwoptions is not null");
            return (Criteria) this;
        }

        public Criteria andAttfdwoptionsEqualTo(Object value) {
            addCriterion("attfdwoptions =", value, "attfdwoptions");
            return (Criteria) this;
        }

        public Criteria andAttfdwoptionsNotEqualTo(Object value) {
            addCriterion("attfdwoptions <>", value, "attfdwoptions");
            return (Criteria) this;
        }

        public Criteria andAttfdwoptionsGreaterThan(Object value) {
            addCriterion("attfdwoptions >", value, "attfdwoptions");
            return (Criteria) this;
        }

        public Criteria andAttfdwoptionsGreaterThanOrEqualTo(Object value) {
            addCriterion("attfdwoptions >=", value, "attfdwoptions");
            return (Criteria) this;
        }

        public Criteria andAttfdwoptionsLessThan(Object value) {
            addCriterion("attfdwoptions <", value, "attfdwoptions");
            return (Criteria) this;
        }

        public Criteria andAttfdwoptionsLessThanOrEqualTo(Object value) {
            addCriterion("attfdwoptions <=", value, "attfdwoptions");
            return (Criteria) this;
        }

        public Criteria andAttfdwoptionsIn(List<Object> values) {
            addCriterion("attfdwoptions in", values, "attfdwoptions");
            return (Criteria) this;
        }

        public Criteria andAttfdwoptionsNotIn(List<Object> values) {
            addCriterion("attfdwoptions not in", values, "attfdwoptions");
            return (Criteria) this;
        }

        public Criteria andAttfdwoptionsBetween(Object value1, Object value2) {
            addCriterion("attfdwoptions between", value1, value2, "attfdwoptions");
            return (Criteria) this;
        }

        public Criteria andAttfdwoptionsNotBetween(Object value1, Object value2) {
            addCriterion("attfdwoptions not between", value1, value2, "attfdwoptions");
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