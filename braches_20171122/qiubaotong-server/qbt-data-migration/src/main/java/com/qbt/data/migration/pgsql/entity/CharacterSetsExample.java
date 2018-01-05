package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class CharacterSetsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CharacterSetsExample() {
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

        public Criteria andCharacter_set_catalogIsNull() {
            addCriterion("character_set_catalog is null");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_catalogIsNotNull() {
            addCriterion("character_set_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_catalogEqualTo(Object value) {
            addCriterion("character_set_catalog =", value, "character_set_catalog");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_catalogNotEqualTo(Object value) {
            addCriterion("character_set_catalog <>", value, "character_set_catalog");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_catalogGreaterThan(Object value) {
            addCriterion("character_set_catalog >", value, "character_set_catalog");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("character_set_catalog >=", value, "character_set_catalog");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_catalogLessThan(Object value) {
            addCriterion("character_set_catalog <", value, "character_set_catalog");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_catalogLessThanOrEqualTo(Object value) {
            addCriterion("character_set_catalog <=", value, "character_set_catalog");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_catalogIn(List<Object> values) {
            addCriterion("character_set_catalog in", values, "character_set_catalog");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_catalogNotIn(List<Object> values) {
            addCriterion("character_set_catalog not in", values, "character_set_catalog");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_catalogBetween(Object value1, Object value2) {
            addCriterion("character_set_catalog between", value1, value2, "character_set_catalog");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_catalogNotBetween(Object value1, Object value2) {
            addCriterion("character_set_catalog not between", value1, value2, "character_set_catalog");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_schemaIsNull() {
            addCriterion("character_set_schema is null");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_schemaIsNotNull() {
            addCriterion("character_set_schema is not null");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_schemaEqualTo(Object value) {
            addCriterion("character_set_schema =", value, "character_set_schema");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_schemaNotEqualTo(Object value) {
            addCriterion("character_set_schema <>", value, "character_set_schema");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_schemaGreaterThan(Object value) {
            addCriterion("character_set_schema >", value, "character_set_schema");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("character_set_schema >=", value, "character_set_schema");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_schemaLessThan(Object value) {
            addCriterion("character_set_schema <", value, "character_set_schema");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_schemaLessThanOrEqualTo(Object value) {
            addCriterion("character_set_schema <=", value, "character_set_schema");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_schemaIn(List<Object> values) {
            addCriterion("character_set_schema in", values, "character_set_schema");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_schemaNotIn(List<Object> values) {
            addCriterion("character_set_schema not in", values, "character_set_schema");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_schemaBetween(Object value1, Object value2) {
            addCriterion("character_set_schema between", value1, value2, "character_set_schema");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_schemaNotBetween(Object value1, Object value2) {
            addCriterion("character_set_schema not between", value1, value2, "character_set_schema");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_nameIsNull() {
            addCriterion("character_set_name is null");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_nameIsNotNull() {
            addCriterion("character_set_name is not null");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_nameEqualTo(Object value) {
            addCriterion("character_set_name =", value, "character_set_name");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_nameNotEqualTo(Object value) {
            addCriterion("character_set_name <>", value, "character_set_name");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_nameGreaterThan(Object value) {
            addCriterion("character_set_name >", value, "character_set_name");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("character_set_name >=", value, "character_set_name");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_nameLessThan(Object value) {
            addCriterion("character_set_name <", value, "character_set_name");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_nameLessThanOrEqualTo(Object value) {
            addCriterion("character_set_name <=", value, "character_set_name");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_nameIn(List<Object> values) {
            addCriterion("character_set_name in", values, "character_set_name");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_nameNotIn(List<Object> values) {
            addCriterion("character_set_name not in", values, "character_set_name");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_nameBetween(Object value1, Object value2) {
            addCriterion("character_set_name between", value1, value2, "character_set_name");
            return (Criteria) this;
        }

        public Criteria andCharacter_set_nameNotBetween(Object value1, Object value2) {
            addCriterion("character_set_name not between", value1, value2, "character_set_name");
            return (Criteria) this;
        }

        public Criteria andCharacter_repertoireIsNull() {
            addCriterion("character_repertoire is null");
            return (Criteria) this;
        }

        public Criteria andCharacter_repertoireIsNotNull() {
            addCriterion("character_repertoire is not null");
            return (Criteria) this;
        }

        public Criteria andCharacter_repertoireEqualTo(Object value) {
            addCriterion("character_repertoire =", value, "character_repertoire");
            return (Criteria) this;
        }

        public Criteria andCharacter_repertoireNotEqualTo(Object value) {
            addCriterion("character_repertoire <>", value, "character_repertoire");
            return (Criteria) this;
        }

        public Criteria andCharacter_repertoireGreaterThan(Object value) {
            addCriterion("character_repertoire >", value, "character_repertoire");
            return (Criteria) this;
        }

        public Criteria andCharacter_repertoireGreaterThanOrEqualTo(Object value) {
            addCriterion("character_repertoire >=", value, "character_repertoire");
            return (Criteria) this;
        }

        public Criteria andCharacter_repertoireLessThan(Object value) {
            addCriterion("character_repertoire <", value, "character_repertoire");
            return (Criteria) this;
        }

        public Criteria andCharacter_repertoireLessThanOrEqualTo(Object value) {
            addCriterion("character_repertoire <=", value, "character_repertoire");
            return (Criteria) this;
        }

        public Criteria andCharacter_repertoireIn(List<Object> values) {
            addCriterion("character_repertoire in", values, "character_repertoire");
            return (Criteria) this;
        }

        public Criteria andCharacter_repertoireNotIn(List<Object> values) {
            addCriterion("character_repertoire not in", values, "character_repertoire");
            return (Criteria) this;
        }

        public Criteria andCharacter_repertoireBetween(Object value1, Object value2) {
            addCriterion("character_repertoire between", value1, value2, "character_repertoire");
            return (Criteria) this;
        }

        public Criteria andCharacter_repertoireNotBetween(Object value1, Object value2) {
            addCriterion("character_repertoire not between", value1, value2, "character_repertoire");
            return (Criteria) this;
        }

        public Criteria andForm_of_useIsNull() {
            addCriterion("form_of_use is null");
            return (Criteria) this;
        }

        public Criteria andForm_of_useIsNotNull() {
            addCriterion("form_of_use is not null");
            return (Criteria) this;
        }

        public Criteria andForm_of_useEqualTo(Object value) {
            addCriterion("form_of_use =", value, "form_of_use");
            return (Criteria) this;
        }

        public Criteria andForm_of_useNotEqualTo(Object value) {
            addCriterion("form_of_use <>", value, "form_of_use");
            return (Criteria) this;
        }

        public Criteria andForm_of_useGreaterThan(Object value) {
            addCriterion("form_of_use >", value, "form_of_use");
            return (Criteria) this;
        }

        public Criteria andForm_of_useGreaterThanOrEqualTo(Object value) {
            addCriterion("form_of_use >=", value, "form_of_use");
            return (Criteria) this;
        }

        public Criteria andForm_of_useLessThan(Object value) {
            addCriterion("form_of_use <", value, "form_of_use");
            return (Criteria) this;
        }

        public Criteria andForm_of_useLessThanOrEqualTo(Object value) {
            addCriterion("form_of_use <=", value, "form_of_use");
            return (Criteria) this;
        }

        public Criteria andForm_of_useIn(List<Object> values) {
            addCriterion("form_of_use in", values, "form_of_use");
            return (Criteria) this;
        }

        public Criteria andForm_of_useNotIn(List<Object> values) {
            addCriterion("form_of_use not in", values, "form_of_use");
            return (Criteria) this;
        }

        public Criteria andForm_of_useBetween(Object value1, Object value2) {
            addCriterion("form_of_use between", value1, value2, "form_of_use");
            return (Criteria) this;
        }

        public Criteria andForm_of_useNotBetween(Object value1, Object value2) {
            addCriterion("form_of_use not between", value1, value2, "form_of_use");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_catalogIsNull() {
            addCriterion("default_collate_catalog is null");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_catalogIsNotNull() {
            addCriterion("default_collate_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_catalogEqualTo(Object value) {
            addCriterion("default_collate_catalog =", value, "default_collate_catalog");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_catalogNotEqualTo(Object value) {
            addCriterion("default_collate_catalog <>", value, "default_collate_catalog");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_catalogGreaterThan(Object value) {
            addCriterion("default_collate_catalog >", value, "default_collate_catalog");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("default_collate_catalog >=", value, "default_collate_catalog");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_catalogLessThan(Object value) {
            addCriterion("default_collate_catalog <", value, "default_collate_catalog");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_catalogLessThanOrEqualTo(Object value) {
            addCriterion("default_collate_catalog <=", value, "default_collate_catalog");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_catalogIn(List<Object> values) {
            addCriterion("default_collate_catalog in", values, "default_collate_catalog");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_catalogNotIn(List<Object> values) {
            addCriterion("default_collate_catalog not in", values, "default_collate_catalog");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_catalogBetween(Object value1, Object value2) {
            addCriterion("default_collate_catalog between", value1, value2, "default_collate_catalog");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_catalogNotBetween(Object value1, Object value2) {
            addCriterion("default_collate_catalog not between", value1, value2, "default_collate_catalog");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_schemaIsNull() {
            addCriterion("default_collate_schema is null");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_schemaIsNotNull() {
            addCriterion("default_collate_schema is not null");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_schemaEqualTo(Object value) {
            addCriterion("default_collate_schema =", value, "default_collate_schema");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_schemaNotEqualTo(Object value) {
            addCriterion("default_collate_schema <>", value, "default_collate_schema");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_schemaGreaterThan(Object value) {
            addCriterion("default_collate_schema >", value, "default_collate_schema");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("default_collate_schema >=", value, "default_collate_schema");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_schemaLessThan(Object value) {
            addCriterion("default_collate_schema <", value, "default_collate_schema");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_schemaLessThanOrEqualTo(Object value) {
            addCriterion("default_collate_schema <=", value, "default_collate_schema");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_schemaIn(List<Object> values) {
            addCriterion("default_collate_schema in", values, "default_collate_schema");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_schemaNotIn(List<Object> values) {
            addCriterion("default_collate_schema not in", values, "default_collate_schema");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_schemaBetween(Object value1, Object value2) {
            addCriterion("default_collate_schema between", value1, value2, "default_collate_schema");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_schemaNotBetween(Object value1, Object value2) {
            addCriterion("default_collate_schema not between", value1, value2, "default_collate_schema");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_nameIsNull() {
            addCriterion("default_collate_name is null");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_nameIsNotNull() {
            addCriterion("default_collate_name is not null");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_nameEqualTo(Object value) {
            addCriterion("default_collate_name =", value, "default_collate_name");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_nameNotEqualTo(Object value) {
            addCriterion("default_collate_name <>", value, "default_collate_name");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_nameGreaterThan(Object value) {
            addCriterion("default_collate_name >", value, "default_collate_name");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("default_collate_name >=", value, "default_collate_name");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_nameLessThan(Object value) {
            addCriterion("default_collate_name <", value, "default_collate_name");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_nameLessThanOrEqualTo(Object value) {
            addCriterion("default_collate_name <=", value, "default_collate_name");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_nameIn(List<Object> values) {
            addCriterion("default_collate_name in", values, "default_collate_name");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_nameNotIn(List<Object> values) {
            addCriterion("default_collate_name not in", values, "default_collate_name");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_nameBetween(Object value1, Object value2) {
            addCriterion("default_collate_name between", value1, value2, "default_collate_name");
            return (Criteria) this;
        }

        public Criteria andDefault_collate_nameNotBetween(Object value1, Object value2) {
            addCriterion("default_collate_name not between", value1, value2, "default_collate_name");
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