package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class PgTsDictExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PgTsDictExample() {
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

        public Criteria andDictnameIsNull() {
            addCriterion("dictname is null");
            return (Criteria) this;
        }

        public Criteria andDictnameIsNotNull() {
            addCriterion("dictname is not null");
            return (Criteria) this;
        }

        public Criteria andDictnameEqualTo(String value) {
            addCriterion("dictname =", value, "dictname");
            return (Criteria) this;
        }

        public Criteria andDictnameNotEqualTo(String value) {
            addCriterion("dictname <>", value, "dictname");
            return (Criteria) this;
        }

        public Criteria andDictnameGreaterThan(String value) {
            addCriterion("dictname >", value, "dictname");
            return (Criteria) this;
        }

        public Criteria andDictnameGreaterThanOrEqualTo(String value) {
            addCriterion("dictname >=", value, "dictname");
            return (Criteria) this;
        }

        public Criteria andDictnameLessThan(String value) {
            addCriterion("dictname <", value, "dictname");
            return (Criteria) this;
        }

        public Criteria andDictnameLessThanOrEqualTo(String value) {
            addCriterion("dictname <=", value, "dictname");
            return (Criteria) this;
        }

        public Criteria andDictnameLike(String value) {
            addCriterion("dictname like", value, "dictname");
            return (Criteria) this;
        }

        public Criteria andDictnameNotLike(String value) {
            addCriterion("dictname not like", value, "dictname");
            return (Criteria) this;
        }

        public Criteria andDictnameIn(List<String> values) {
            addCriterion("dictname in", values, "dictname");
            return (Criteria) this;
        }

        public Criteria andDictnameNotIn(List<String> values) {
            addCriterion("dictname not in", values, "dictname");
            return (Criteria) this;
        }

        public Criteria andDictnameBetween(String value1, String value2) {
            addCriterion("dictname between", value1, value2, "dictname");
            return (Criteria) this;
        }

        public Criteria andDictnameNotBetween(String value1, String value2) {
            addCriterion("dictname not between", value1, value2, "dictname");
            return (Criteria) this;
        }

        public Criteria andDictnamespaceIsNull() {
            addCriterion("dictnamespace is null");
            return (Criteria) this;
        }

        public Criteria andDictnamespaceIsNotNull() {
            addCriterion("dictnamespace is not null");
            return (Criteria) this;
        }

        public Criteria andDictnamespaceEqualTo(Long value) {
            addCriterion("dictnamespace =", value, "dictnamespace");
            return (Criteria) this;
        }

        public Criteria andDictnamespaceNotEqualTo(Long value) {
            addCriterion("dictnamespace <>", value, "dictnamespace");
            return (Criteria) this;
        }

        public Criteria andDictnamespaceGreaterThan(Long value) {
            addCriterion("dictnamespace >", value, "dictnamespace");
            return (Criteria) this;
        }

        public Criteria andDictnamespaceGreaterThanOrEqualTo(Long value) {
            addCriterion("dictnamespace >=", value, "dictnamespace");
            return (Criteria) this;
        }

        public Criteria andDictnamespaceLessThan(Long value) {
            addCriterion("dictnamespace <", value, "dictnamespace");
            return (Criteria) this;
        }

        public Criteria andDictnamespaceLessThanOrEqualTo(Long value) {
            addCriterion("dictnamespace <=", value, "dictnamespace");
            return (Criteria) this;
        }

        public Criteria andDictnamespaceIn(List<Long> values) {
            addCriterion("dictnamespace in", values, "dictnamespace");
            return (Criteria) this;
        }

        public Criteria andDictnamespaceNotIn(List<Long> values) {
            addCriterion("dictnamespace not in", values, "dictnamespace");
            return (Criteria) this;
        }

        public Criteria andDictnamespaceBetween(Long value1, Long value2) {
            addCriterion("dictnamespace between", value1, value2, "dictnamespace");
            return (Criteria) this;
        }

        public Criteria andDictnamespaceNotBetween(Long value1, Long value2) {
            addCriterion("dictnamespace not between", value1, value2, "dictnamespace");
            return (Criteria) this;
        }

        public Criteria andDictownerIsNull() {
            addCriterion("dictowner is null");
            return (Criteria) this;
        }

        public Criteria andDictownerIsNotNull() {
            addCriterion("dictowner is not null");
            return (Criteria) this;
        }

        public Criteria andDictownerEqualTo(Long value) {
            addCriterion("dictowner =", value, "dictowner");
            return (Criteria) this;
        }

        public Criteria andDictownerNotEqualTo(Long value) {
            addCriterion("dictowner <>", value, "dictowner");
            return (Criteria) this;
        }

        public Criteria andDictownerGreaterThan(Long value) {
            addCriterion("dictowner >", value, "dictowner");
            return (Criteria) this;
        }

        public Criteria andDictownerGreaterThanOrEqualTo(Long value) {
            addCriterion("dictowner >=", value, "dictowner");
            return (Criteria) this;
        }

        public Criteria andDictownerLessThan(Long value) {
            addCriterion("dictowner <", value, "dictowner");
            return (Criteria) this;
        }

        public Criteria andDictownerLessThanOrEqualTo(Long value) {
            addCriterion("dictowner <=", value, "dictowner");
            return (Criteria) this;
        }

        public Criteria andDictownerIn(List<Long> values) {
            addCriterion("dictowner in", values, "dictowner");
            return (Criteria) this;
        }

        public Criteria andDictownerNotIn(List<Long> values) {
            addCriterion("dictowner not in", values, "dictowner");
            return (Criteria) this;
        }

        public Criteria andDictownerBetween(Long value1, Long value2) {
            addCriterion("dictowner between", value1, value2, "dictowner");
            return (Criteria) this;
        }

        public Criteria andDictownerNotBetween(Long value1, Long value2) {
            addCriterion("dictowner not between", value1, value2, "dictowner");
            return (Criteria) this;
        }

        public Criteria andDicttemplateIsNull() {
            addCriterion("dicttemplate is null");
            return (Criteria) this;
        }

        public Criteria andDicttemplateIsNotNull() {
            addCriterion("dicttemplate is not null");
            return (Criteria) this;
        }

        public Criteria andDicttemplateEqualTo(Long value) {
            addCriterion("dicttemplate =", value, "dicttemplate");
            return (Criteria) this;
        }

        public Criteria andDicttemplateNotEqualTo(Long value) {
            addCriterion("dicttemplate <>", value, "dicttemplate");
            return (Criteria) this;
        }

        public Criteria andDicttemplateGreaterThan(Long value) {
            addCriterion("dicttemplate >", value, "dicttemplate");
            return (Criteria) this;
        }

        public Criteria andDicttemplateGreaterThanOrEqualTo(Long value) {
            addCriterion("dicttemplate >=", value, "dicttemplate");
            return (Criteria) this;
        }

        public Criteria andDicttemplateLessThan(Long value) {
            addCriterion("dicttemplate <", value, "dicttemplate");
            return (Criteria) this;
        }

        public Criteria andDicttemplateLessThanOrEqualTo(Long value) {
            addCriterion("dicttemplate <=", value, "dicttemplate");
            return (Criteria) this;
        }

        public Criteria andDicttemplateIn(List<Long> values) {
            addCriterion("dicttemplate in", values, "dicttemplate");
            return (Criteria) this;
        }

        public Criteria andDicttemplateNotIn(List<Long> values) {
            addCriterion("dicttemplate not in", values, "dicttemplate");
            return (Criteria) this;
        }

        public Criteria andDicttemplateBetween(Long value1, Long value2) {
            addCriterion("dicttemplate between", value1, value2, "dicttemplate");
            return (Criteria) this;
        }

        public Criteria andDicttemplateNotBetween(Long value1, Long value2) {
            addCriterion("dicttemplate not between", value1, value2, "dicttemplate");
            return (Criteria) this;
        }

        public Criteria andDictinitoptionIsNull() {
            addCriterion("dictinitoption is null");
            return (Criteria) this;
        }

        public Criteria andDictinitoptionIsNotNull() {
            addCriterion("dictinitoption is not null");
            return (Criteria) this;
        }

        public Criteria andDictinitoptionEqualTo(String value) {
            addCriterion("dictinitoption =", value, "dictinitoption");
            return (Criteria) this;
        }

        public Criteria andDictinitoptionNotEqualTo(String value) {
            addCriterion("dictinitoption <>", value, "dictinitoption");
            return (Criteria) this;
        }

        public Criteria andDictinitoptionGreaterThan(String value) {
            addCriterion("dictinitoption >", value, "dictinitoption");
            return (Criteria) this;
        }

        public Criteria andDictinitoptionGreaterThanOrEqualTo(String value) {
            addCriterion("dictinitoption >=", value, "dictinitoption");
            return (Criteria) this;
        }

        public Criteria andDictinitoptionLessThan(String value) {
            addCriterion("dictinitoption <", value, "dictinitoption");
            return (Criteria) this;
        }

        public Criteria andDictinitoptionLessThanOrEqualTo(String value) {
            addCriterion("dictinitoption <=", value, "dictinitoption");
            return (Criteria) this;
        }

        public Criteria andDictinitoptionLike(String value) {
            addCriterion("dictinitoption like", value, "dictinitoption");
            return (Criteria) this;
        }

        public Criteria andDictinitoptionNotLike(String value) {
            addCriterion("dictinitoption not like", value, "dictinitoption");
            return (Criteria) this;
        }

        public Criteria andDictinitoptionIn(List<String> values) {
            addCriterion("dictinitoption in", values, "dictinitoption");
            return (Criteria) this;
        }

        public Criteria andDictinitoptionNotIn(List<String> values) {
            addCriterion("dictinitoption not in", values, "dictinitoption");
            return (Criteria) this;
        }

        public Criteria andDictinitoptionBetween(String value1, String value2) {
            addCriterion("dictinitoption between", value1, value2, "dictinitoption");
            return (Criteria) this;
        }

        public Criteria andDictinitoptionNotBetween(String value1, String value2) {
            addCriterion("dictinitoption not between", value1, value2, "dictinitoption");
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