package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class RoutinesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoutinesExample() {
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

        public Criteria andSpecific_catalogIsNull() {
            addCriterion("specific_catalog is null");
            return (Criteria) this;
        }

        public Criteria andSpecific_catalogIsNotNull() {
            addCriterion("specific_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andSpecific_catalogEqualTo(Object value) {
            addCriterion("specific_catalog =", value, "specific_catalog");
            return (Criteria) this;
        }

        public Criteria andSpecific_catalogNotEqualTo(Object value) {
            addCriterion("specific_catalog <>", value, "specific_catalog");
            return (Criteria) this;
        }

        public Criteria andSpecific_catalogGreaterThan(Object value) {
            addCriterion("specific_catalog >", value, "specific_catalog");
            return (Criteria) this;
        }

        public Criteria andSpecific_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("specific_catalog >=", value, "specific_catalog");
            return (Criteria) this;
        }

        public Criteria andSpecific_catalogLessThan(Object value) {
            addCriterion("specific_catalog <", value, "specific_catalog");
            return (Criteria) this;
        }

        public Criteria andSpecific_catalogLessThanOrEqualTo(Object value) {
            addCriterion("specific_catalog <=", value, "specific_catalog");
            return (Criteria) this;
        }

        public Criteria andSpecific_catalogIn(List<Object> values) {
            addCriterion("specific_catalog in", values, "specific_catalog");
            return (Criteria) this;
        }

        public Criteria andSpecific_catalogNotIn(List<Object> values) {
            addCriterion("specific_catalog not in", values, "specific_catalog");
            return (Criteria) this;
        }

        public Criteria andSpecific_catalogBetween(Object value1, Object value2) {
            addCriterion("specific_catalog between", value1, value2, "specific_catalog");
            return (Criteria) this;
        }

        public Criteria andSpecific_catalogNotBetween(Object value1, Object value2) {
            addCriterion("specific_catalog not between", value1, value2, "specific_catalog");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaIsNull() {
            addCriterion("specific_schema is null");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaIsNotNull() {
            addCriterion("specific_schema is not null");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaEqualTo(Object value) {
            addCriterion("specific_schema =", value, "specific_schema");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaNotEqualTo(Object value) {
            addCriterion("specific_schema <>", value, "specific_schema");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaGreaterThan(Object value) {
            addCriterion("specific_schema >", value, "specific_schema");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("specific_schema >=", value, "specific_schema");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaLessThan(Object value) {
            addCriterion("specific_schema <", value, "specific_schema");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaLessThanOrEqualTo(Object value) {
            addCriterion("specific_schema <=", value, "specific_schema");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaIn(List<Object> values) {
            addCriterion("specific_schema in", values, "specific_schema");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaNotIn(List<Object> values) {
            addCriterion("specific_schema not in", values, "specific_schema");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaBetween(Object value1, Object value2) {
            addCriterion("specific_schema between", value1, value2, "specific_schema");
            return (Criteria) this;
        }

        public Criteria andSpecific_schemaNotBetween(Object value1, Object value2) {
            addCriterion("specific_schema not between", value1, value2, "specific_schema");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameIsNull() {
            addCriterion("specific_name is null");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameIsNotNull() {
            addCriterion("specific_name is not null");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameEqualTo(Object value) {
            addCriterion("specific_name =", value, "specific_name");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameNotEqualTo(Object value) {
            addCriterion("specific_name <>", value, "specific_name");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameGreaterThan(Object value) {
            addCriterion("specific_name >", value, "specific_name");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("specific_name >=", value, "specific_name");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameLessThan(Object value) {
            addCriterion("specific_name <", value, "specific_name");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameLessThanOrEqualTo(Object value) {
            addCriterion("specific_name <=", value, "specific_name");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameIn(List<Object> values) {
            addCriterion("specific_name in", values, "specific_name");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameNotIn(List<Object> values) {
            addCriterion("specific_name not in", values, "specific_name");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameBetween(Object value1, Object value2) {
            addCriterion("specific_name between", value1, value2, "specific_name");
            return (Criteria) this;
        }

        public Criteria andSpecific_nameNotBetween(Object value1, Object value2) {
            addCriterion("specific_name not between", value1, value2, "specific_name");
            return (Criteria) this;
        }

        public Criteria andRoutine_catalogIsNull() {
            addCriterion("routine_catalog is null");
            return (Criteria) this;
        }

        public Criteria andRoutine_catalogIsNotNull() {
            addCriterion("routine_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andRoutine_catalogEqualTo(Object value) {
            addCriterion("routine_catalog =", value, "routine_catalog");
            return (Criteria) this;
        }

        public Criteria andRoutine_catalogNotEqualTo(Object value) {
            addCriterion("routine_catalog <>", value, "routine_catalog");
            return (Criteria) this;
        }

        public Criteria andRoutine_catalogGreaterThan(Object value) {
            addCriterion("routine_catalog >", value, "routine_catalog");
            return (Criteria) this;
        }

        public Criteria andRoutine_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("routine_catalog >=", value, "routine_catalog");
            return (Criteria) this;
        }

        public Criteria andRoutine_catalogLessThan(Object value) {
            addCriterion("routine_catalog <", value, "routine_catalog");
            return (Criteria) this;
        }

        public Criteria andRoutine_catalogLessThanOrEqualTo(Object value) {
            addCriterion("routine_catalog <=", value, "routine_catalog");
            return (Criteria) this;
        }

        public Criteria andRoutine_catalogIn(List<Object> values) {
            addCriterion("routine_catalog in", values, "routine_catalog");
            return (Criteria) this;
        }

        public Criteria andRoutine_catalogNotIn(List<Object> values) {
            addCriterion("routine_catalog not in", values, "routine_catalog");
            return (Criteria) this;
        }

        public Criteria andRoutine_catalogBetween(Object value1, Object value2) {
            addCriterion("routine_catalog between", value1, value2, "routine_catalog");
            return (Criteria) this;
        }

        public Criteria andRoutine_catalogNotBetween(Object value1, Object value2) {
            addCriterion("routine_catalog not between", value1, value2, "routine_catalog");
            return (Criteria) this;
        }

        public Criteria andRoutine_schemaIsNull() {
            addCriterion("routine_schema is null");
            return (Criteria) this;
        }

        public Criteria andRoutine_schemaIsNotNull() {
            addCriterion("routine_schema is not null");
            return (Criteria) this;
        }

        public Criteria andRoutine_schemaEqualTo(Object value) {
            addCriterion("routine_schema =", value, "routine_schema");
            return (Criteria) this;
        }

        public Criteria andRoutine_schemaNotEqualTo(Object value) {
            addCriterion("routine_schema <>", value, "routine_schema");
            return (Criteria) this;
        }

        public Criteria andRoutine_schemaGreaterThan(Object value) {
            addCriterion("routine_schema >", value, "routine_schema");
            return (Criteria) this;
        }

        public Criteria andRoutine_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("routine_schema >=", value, "routine_schema");
            return (Criteria) this;
        }

        public Criteria andRoutine_schemaLessThan(Object value) {
            addCriterion("routine_schema <", value, "routine_schema");
            return (Criteria) this;
        }

        public Criteria andRoutine_schemaLessThanOrEqualTo(Object value) {
            addCriterion("routine_schema <=", value, "routine_schema");
            return (Criteria) this;
        }

        public Criteria andRoutine_schemaIn(List<Object> values) {
            addCriterion("routine_schema in", values, "routine_schema");
            return (Criteria) this;
        }

        public Criteria andRoutine_schemaNotIn(List<Object> values) {
            addCriterion("routine_schema not in", values, "routine_schema");
            return (Criteria) this;
        }

        public Criteria andRoutine_schemaBetween(Object value1, Object value2) {
            addCriterion("routine_schema between", value1, value2, "routine_schema");
            return (Criteria) this;
        }

        public Criteria andRoutine_schemaNotBetween(Object value1, Object value2) {
            addCriterion("routine_schema not between", value1, value2, "routine_schema");
            return (Criteria) this;
        }

        public Criteria andRoutine_nameIsNull() {
            addCriterion("routine_name is null");
            return (Criteria) this;
        }

        public Criteria andRoutine_nameIsNotNull() {
            addCriterion("routine_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoutine_nameEqualTo(Object value) {
            addCriterion("routine_name =", value, "routine_name");
            return (Criteria) this;
        }

        public Criteria andRoutine_nameNotEqualTo(Object value) {
            addCriterion("routine_name <>", value, "routine_name");
            return (Criteria) this;
        }

        public Criteria andRoutine_nameGreaterThan(Object value) {
            addCriterion("routine_name >", value, "routine_name");
            return (Criteria) this;
        }

        public Criteria andRoutine_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("routine_name >=", value, "routine_name");
            return (Criteria) this;
        }

        public Criteria andRoutine_nameLessThan(Object value) {
            addCriterion("routine_name <", value, "routine_name");
            return (Criteria) this;
        }

        public Criteria andRoutine_nameLessThanOrEqualTo(Object value) {
            addCriterion("routine_name <=", value, "routine_name");
            return (Criteria) this;
        }

        public Criteria andRoutine_nameIn(List<Object> values) {
            addCriterion("routine_name in", values, "routine_name");
            return (Criteria) this;
        }

        public Criteria andRoutine_nameNotIn(List<Object> values) {
            addCriterion("routine_name not in", values, "routine_name");
            return (Criteria) this;
        }

        public Criteria andRoutine_nameBetween(Object value1, Object value2) {
            addCriterion("routine_name between", value1, value2, "routine_name");
            return (Criteria) this;
        }

        public Criteria andRoutine_nameNotBetween(Object value1, Object value2) {
            addCriterion("routine_name not between", value1, value2, "routine_name");
            return (Criteria) this;
        }

        public Criteria andRoutine_typeIsNull() {
            addCriterion("routine_type is null");
            return (Criteria) this;
        }

        public Criteria andRoutine_typeIsNotNull() {
            addCriterion("routine_type is not null");
            return (Criteria) this;
        }

        public Criteria andRoutine_typeEqualTo(Object value) {
            addCriterion("routine_type =", value, "routine_type");
            return (Criteria) this;
        }

        public Criteria andRoutine_typeNotEqualTo(Object value) {
            addCriterion("routine_type <>", value, "routine_type");
            return (Criteria) this;
        }

        public Criteria andRoutine_typeGreaterThan(Object value) {
            addCriterion("routine_type >", value, "routine_type");
            return (Criteria) this;
        }

        public Criteria andRoutine_typeGreaterThanOrEqualTo(Object value) {
            addCriterion("routine_type >=", value, "routine_type");
            return (Criteria) this;
        }

        public Criteria andRoutine_typeLessThan(Object value) {
            addCriterion("routine_type <", value, "routine_type");
            return (Criteria) this;
        }

        public Criteria andRoutine_typeLessThanOrEqualTo(Object value) {
            addCriterion("routine_type <=", value, "routine_type");
            return (Criteria) this;
        }

        public Criteria andRoutine_typeIn(List<Object> values) {
            addCriterion("routine_type in", values, "routine_type");
            return (Criteria) this;
        }

        public Criteria andRoutine_typeNotIn(List<Object> values) {
            addCriterion("routine_type not in", values, "routine_type");
            return (Criteria) this;
        }

        public Criteria andRoutine_typeBetween(Object value1, Object value2) {
            addCriterion("routine_type between", value1, value2, "routine_type");
            return (Criteria) this;
        }

        public Criteria andRoutine_typeNotBetween(Object value1, Object value2) {
            addCriterion("routine_type not between", value1, value2, "routine_type");
            return (Criteria) this;
        }

        public Criteria andModule_catalogIsNull() {
            addCriterion("module_catalog is null");
            return (Criteria) this;
        }

        public Criteria andModule_catalogIsNotNull() {
            addCriterion("module_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andModule_catalogEqualTo(Object value) {
            addCriterion("module_catalog =", value, "module_catalog");
            return (Criteria) this;
        }

        public Criteria andModule_catalogNotEqualTo(Object value) {
            addCriterion("module_catalog <>", value, "module_catalog");
            return (Criteria) this;
        }

        public Criteria andModule_catalogGreaterThan(Object value) {
            addCriterion("module_catalog >", value, "module_catalog");
            return (Criteria) this;
        }

        public Criteria andModule_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("module_catalog >=", value, "module_catalog");
            return (Criteria) this;
        }

        public Criteria andModule_catalogLessThan(Object value) {
            addCriterion("module_catalog <", value, "module_catalog");
            return (Criteria) this;
        }

        public Criteria andModule_catalogLessThanOrEqualTo(Object value) {
            addCriterion("module_catalog <=", value, "module_catalog");
            return (Criteria) this;
        }

        public Criteria andModule_catalogIn(List<Object> values) {
            addCriterion("module_catalog in", values, "module_catalog");
            return (Criteria) this;
        }

        public Criteria andModule_catalogNotIn(List<Object> values) {
            addCriterion("module_catalog not in", values, "module_catalog");
            return (Criteria) this;
        }

        public Criteria andModule_catalogBetween(Object value1, Object value2) {
            addCriterion("module_catalog between", value1, value2, "module_catalog");
            return (Criteria) this;
        }

        public Criteria andModule_catalogNotBetween(Object value1, Object value2) {
            addCriterion("module_catalog not between", value1, value2, "module_catalog");
            return (Criteria) this;
        }

        public Criteria andModule_schemaIsNull() {
            addCriterion("module_schema is null");
            return (Criteria) this;
        }

        public Criteria andModule_schemaIsNotNull() {
            addCriterion("module_schema is not null");
            return (Criteria) this;
        }

        public Criteria andModule_schemaEqualTo(Object value) {
            addCriterion("module_schema =", value, "module_schema");
            return (Criteria) this;
        }

        public Criteria andModule_schemaNotEqualTo(Object value) {
            addCriterion("module_schema <>", value, "module_schema");
            return (Criteria) this;
        }

        public Criteria andModule_schemaGreaterThan(Object value) {
            addCriterion("module_schema >", value, "module_schema");
            return (Criteria) this;
        }

        public Criteria andModule_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("module_schema >=", value, "module_schema");
            return (Criteria) this;
        }

        public Criteria andModule_schemaLessThan(Object value) {
            addCriterion("module_schema <", value, "module_schema");
            return (Criteria) this;
        }

        public Criteria andModule_schemaLessThanOrEqualTo(Object value) {
            addCriterion("module_schema <=", value, "module_schema");
            return (Criteria) this;
        }

        public Criteria andModule_schemaIn(List<Object> values) {
            addCriterion("module_schema in", values, "module_schema");
            return (Criteria) this;
        }

        public Criteria andModule_schemaNotIn(List<Object> values) {
            addCriterion("module_schema not in", values, "module_schema");
            return (Criteria) this;
        }

        public Criteria andModule_schemaBetween(Object value1, Object value2) {
            addCriterion("module_schema between", value1, value2, "module_schema");
            return (Criteria) this;
        }

        public Criteria andModule_schemaNotBetween(Object value1, Object value2) {
            addCriterion("module_schema not between", value1, value2, "module_schema");
            return (Criteria) this;
        }

        public Criteria andModule_nameIsNull() {
            addCriterion("module_name is null");
            return (Criteria) this;
        }

        public Criteria andModule_nameIsNotNull() {
            addCriterion("module_name is not null");
            return (Criteria) this;
        }

        public Criteria andModule_nameEqualTo(Object value) {
            addCriterion("module_name =", value, "module_name");
            return (Criteria) this;
        }

        public Criteria andModule_nameNotEqualTo(Object value) {
            addCriterion("module_name <>", value, "module_name");
            return (Criteria) this;
        }

        public Criteria andModule_nameGreaterThan(Object value) {
            addCriterion("module_name >", value, "module_name");
            return (Criteria) this;
        }

        public Criteria andModule_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("module_name >=", value, "module_name");
            return (Criteria) this;
        }

        public Criteria andModule_nameLessThan(Object value) {
            addCriterion("module_name <", value, "module_name");
            return (Criteria) this;
        }

        public Criteria andModule_nameLessThanOrEqualTo(Object value) {
            addCriterion("module_name <=", value, "module_name");
            return (Criteria) this;
        }

        public Criteria andModule_nameIn(List<Object> values) {
            addCriterion("module_name in", values, "module_name");
            return (Criteria) this;
        }

        public Criteria andModule_nameNotIn(List<Object> values) {
            addCriterion("module_name not in", values, "module_name");
            return (Criteria) this;
        }

        public Criteria andModule_nameBetween(Object value1, Object value2) {
            addCriterion("module_name between", value1, value2, "module_name");
            return (Criteria) this;
        }

        public Criteria andModule_nameNotBetween(Object value1, Object value2) {
            addCriterion("module_name not between", value1, value2, "module_name");
            return (Criteria) this;
        }

        public Criteria andUdt_catalogIsNull() {
            addCriterion("udt_catalog is null");
            return (Criteria) this;
        }

        public Criteria andUdt_catalogIsNotNull() {
            addCriterion("udt_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andUdt_catalogEqualTo(Object value) {
            addCriterion("udt_catalog =", value, "udt_catalog");
            return (Criteria) this;
        }

        public Criteria andUdt_catalogNotEqualTo(Object value) {
            addCriterion("udt_catalog <>", value, "udt_catalog");
            return (Criteria) this;
        }

        public Criteria andUdt_catalogGreaterThan(Object value) {
            addCriterion("udt_catalog >", value, "udt_catalog");
            return (Criteria) this;
        }

        public Criteria andUdt_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("udt_catalog >=", value, "udt_catalog");
            return (Criteria) this;
        }

        public Criteria andUdt_catalogLessThan(Object value) {
            addCriterion("udt_catalog <", value, "udt_catalog");
            return (Criteria) this;
        }

        public Criteria andUdt_catalogLessThanOrEqualTo(Object value) {
            addCriterion("udt_catalog <=", value, "udt_catalog");
            return (Criteria) this;
        }

        public Criteria andUdt_catalogIn(List<Object> values) {
            addCriterion("udt_catalog in", values, "udt_catalog");
            return (Criteria) this;
        }

        public Criteria andUdt_catalogNotIn(List<Object> values) {
            addCriterion("udt_catalog not in", values, "udt_catalog");
            return (Criteria) this;
        }

        public Criteria andUdt_catalogBetween(Object value1, Object value2) {
            addCriterion("udt_catalog between", value1, value2, "udt_catalog");
            return (Criteria) this;
        }

        public Criteria andUdt_catalogNotBetween(Object value1, Object value2) {
            addCriterion("udt_catalog not between", value1, value2, "udt_catalog");
            return (Criteria) this;
        }

        public Criteria andUdt_schemaIsNull() {
            addCriterion("udt_schema is null");
            return (Criteria) this;
        }

        public Criteria andUdt_schemaIsNotNull() {
            addCriterion("udt_schema is not null");
            return (Criteria) this;
        }

        public Criteria andUdt_schemaEqualTo(Object value) {
            addCriterion("udt_schema =", value, "udt_schema");
            return (Criteria) this;
        }

        public Criteria andUdt_schemaNotEqualTo(Object value) {
            addCriterion("udt_schema <>", value, "udt_schema");
            return (Criteria) this;
        }

        public Criteria andUdt_schemaGreaterThan(Object value) {
            addCriterion("udt_schema >", value, "udt_schema");
            return (Criteria) this;
        }

        public Criteria andUdt_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("udt_schema >=", value, "udt_schema");
            return (Criteria) this;
        }

        public Criteria andUdt_schemaLessThan(Object value) {
            addCriterion("udt_schema <", value, "udt_schema");
            return (Criteria) this;
        }

        public Criteria andUdt_schemaLessThanOrEqualTo(Object value) {
            addCriterion("udt_schema <=", value, "udt_schema");
            return (Criteria) this;
        }

        public Criteria andUdt_schemaIn(List<Object> values) {
            addCriterion("udt_schema in", values, "udt_schema");
            return (Criteria) this;
        }

        public Criteria andUdt_schemaNotIn(List<Object> values) {
            addCriterion("udt_schema not in", values, "udt_schema");
            return (Criteria) this;
        }

        public Criteria andUdt_schemaBetween(Object value1, Object value2) {
            addCriterion("udt_schema between", value1, value2, "udt_schema");
            return (Criteria) this;
        }

        public Criteria andUdt_schemaNotBetween(Object value1, Object value2) {
            addCriterion("udt_schema not between", value1, value2, "udt_schema");
            return (Criteria) this;
        }

        public Criteria andUdt_nameIsNull() {
            addCriterion("udt_name is null");
            return (Criteria) this;
        }

        public Criteria andUdt_nameIsNotNull() {
            addCriterion("udt_name is not null");
            return (Criteria) this;
        }

        public Criteria andUdt_nameEqualTo(Object value) {
            addCriterion("udt_name =", value, "udt_name");
            return (Criteria) this;
        }

        public Criteria andUdt_nameNotEqualTo(Object value) {
            addCriterion("udt_name <>", value, "udt_name");
            return (Criteria) this;
        }

        public Criteria andUdt_nameGreaterThan(Object value) {
            addCriterion("udt_name >", value, "udt_name");
            return (Criteria) this;
        }

        public Criteria andUdt_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("udt_name >=", value, "udt_name");
            return (Criteria) this;
        }

        public Criteria andUdt_nameLessThan(Object value) {
            addCriterion("udt_name <", value, "udt_name");
            return (Criteria) this;
        }

        public Criteria andUdt_nameLessThanOrEqualTo(Object value) {
            addCriterion("udt_name <=", value, "udt_name");
            return (Criteria) this;
        }

        public Criteria andUdt_nameIn(List<Object> values) {
            addCriterion("udt_name in", values, "udt_name");
            return (Criteria) this;
        }

        public Criteria andUdt_nameNotIn(List<Object> values) {
            addCriterion("udt_name not in", values, "udt_name");
            return (Criteria) this;
        }

        public Criteria andUdt_nameBetween(Object value1, Object value2) {
            addCriterion("udt_name between", value1, value2, "udt_name");
            return (Criteria) this;
        }

        public Criteria andUdt_nameNotBetween(Object value1, Object value2) {
            addCriterion("udt_name not between", value1, value2, "udt_name");
            return (Criteria) this;
        }

        public Criteria andData_typeIsNull() {
            addCriterion("data_type is null");
            return (Criteria) this;
        }

        public Criteria andData_typeIsNotNull() {
            addCriterion("data_type is not null");
            return (Criteria) this;
        }

        public Criteria andData_typeEqualTo(Object value) {
            addCriterion("data_type =", value, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeNotEqualTo(Object value) {
            addCriterion("data_type <>", value, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeGreaterThan(Object value) {
            addCriterion("data_type >", value, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeGreaterThanOrEqualTo(Object value) {
            addCriterion("data_type >=", value, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeLessThan(Object value) {
            addCriterion("data_type <", value, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeLessThanOrEqualTo(Object value) {
            addCriterion("data_type <=", value, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeIn(List<Object> values) {
            addCriterion("data_type in", values, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeNotIn(List<Object> values) {
            addCriterion("data_type not in", values, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeBetween(Object value1, Object value2) {
            addCriterion("data_type between", value1, value2, "data_type");
            return (Criteria) this;
        }

        public Criteria andData_typeNotBetween(Object value1, Object value2) {
            addCriterion("data_type not between", value1, value2, "data_type");
            return (Criteria) this;
        }

        public Criteria andCharacter_maximum_lengthIsNull() {
            addCriterion("character_maximum_length is null");
            return (Criteria) this;
        }

        public Criteria andCharacter_maximum_lengthIsNotNull() {
            addCriterion("character_maximum_length is not null");
            return (Criteria) this;
        }

        public Criteria andCharacter_maximum_lengthEqualTo(Object value) {
            addCriterion("character_maximum_length =", value, "character_maximum_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_maximum_lengthNotEqualTo(Object value) {
            addCriterion("character_maximum_length <>", value, "character_maximum_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_maximum_lengthGreaterThan(Object value) {
            addCriterion("character_maximum_length >", value, "character_maximum_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_maximum_lengthGreaterThanOrEqualTo(Object value) {
            addCriterion("character_maximum_length >=", value, "character_maximum_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_maximum_lengthLessThan(Object value) {
            addCriterion("character_maximum_length <", value, "character_maximum_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_maximum_lengthLessThanOrEqualTo(Object value) {
            addCriterion("character_maximum_length <=", value, "character_maximum_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_maximum_lengthIn(List<Object> values) {
            addCriterion("character_maximum_length in", values, "character_maximum_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_maximum_lengthNotIn(List<Object> values) {
            addCriterion("character_maximum_length not in", values, "character_maximum_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_maximum_lengthBetween(Object value1, Object value2) {
            addCriterion("character_maximum_length between", value1, value2, "character_maximum_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_maximum_lengthNotBetween(Object value1, Object value2) {
            addCriterion("character_maximum_length not between", value1, value2, "character_maximum_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_octet_lengthIsNull() {
            addCriterion("character_octet_length is null");
            return (Criteria) this;
        }

        public Criteria andCharacter_octet_lengthIsNotNull() {
            addCriterion("character_octet_length is not null");
            return (Criteria) this;
        }

        public Criteria andCharacter_octet_lengthEqualTo(Object value) {
            addCriterion("character_octet_length =", value, "character_octet_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_octet_lengthNotEqualTo(Object value) {
            addCriterion("character_octet_length <>", value, "character_octet_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_octet_lengthGreaterThan(Object value) {
            addCriterion("character_octet_length >", value, "character_octet_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_octet_lengthGreaterThanOrEqualTo(Object value) {
            addCriterion("character_octet_length >=", value, "character_octet_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_octet_lengthLessThan(Object value) {
            addCriterion("character_octet_length <", value, "character_octet_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_octet_lengthLessThanOrEqualTo(Object value) {
            addCriterion("character_octet_length <=", value, "character_octet_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_octet_lengthIn(List<Object> values) {
            addCriterion("character_octet_length in", values, "character_octet_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_octet_lengthNotIn(List<Object> values) {
            addCriterion("character_octet_length not in", values, "character_octet_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_octet_lengthBetween(Object value1, Object value2) {
            addCriterion("character_octet_length between", value1, value2, "character_octet_length");
            return (Criteria) this;
        }

        public Criteria andCharacter_octet_lengthNotBetween(Object value1, Object value2) {
            addCriterion("character_octet_length not between", value1, value2, "character_octet_length");
            return (Criteria) this;
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

        public Criteria andCollation_catalogIsNull() {
            addCriterion("collation_catalog is null");
            return (Criteria) this;
        }

        public Criteria andCollation_catalogIsNotNull() {
            addCriterion("collation_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andCollation_catalogEqualTo(Object value) {
            addCriterion("collation_catalog =", value, "collation_catalog");
            return (Criteria) this;
        }

        public Criteria andCollation_catalogNotEqualTo(Object value) {
            addCriterion("collation_catalog <>", value, "collation_catalog");
            return (Criteria) this;
        }

        public Criteria andCollation_catalogGreaterThan(Object value) {
            addCriterion("collation_catalog >", value, "collation_catalog");
            return (Criteria) this;
        }

        public Criteria andCollation_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("collation_catalog >=", value, "collation_catalog");
            return (Criteria) this;
        }

        public Criteria andCollation_catalogLessThan(Object value) {
            addCriterion("collation_catalog <", value, "collation_catalog");
            return (Criteria) this;
        }

        public Criteria andCollation_catalogLessThanOrEqualTo(Object value) {
            addCriterion("collation_catalog <=", value, "collation_catalog");
            return (Criteria) this;
        }

        public Criteria andCollation_catalogIn(List<Object> values) {
            addCriterion("collation_catalog in", values, "collation_catalog");
            return (Criteria) this;
        }

        public Criteria andCollation_catalogNotIn(List<Object> values) {
            addCriterion("collation_catalog not in", values, "collation_catalog");
            return (Criteria) this;
        }

        public Criteria andCollation_catalogBetween(Object value1, Object value2) {
            addCriterion("collation_catalog between", value1, value2, "collation_catalog");
            return (Criteria) this;
        }

        public Criteria andCollation_catalogNotBetween(Object value1, Object value2) {
            addCriterion("collation_catalog not between", value1, value2, "collation_catalog");
            return (Criteria) this;
        }

        public Criteria andCollation_schemaIsNull() {
            addCriterion("collation_schema is null");
            return (Criteria) this;
        }

        public Criteria andCollation_schemaIsNotNull() {
            addCriterion("collation_schema is not null");
            return (Criteria) this;
        }

        public Criteria andCollation_schemaEqualTo(Object value) {
            addCriterion("collation_schema =", value, "collation_schema");
            return (Criteria) this;
        }

        public Criteria andCollation_schemaNotEqualTo(Object value) {
            addCriterion("collation_schema <>", value, "collation_schema");
            return (Criteria) this;
        }

        public Criteria andCollation_schemaGreaterThan(Object value) {
            addCriterion("collation_schema >", value, "collation_schema");
            return (Criteria) this;
        }

        public Criteria andCollation_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("collation_schema >=", value, "collation_schema");
            return (Criteria) this;
        }

        public Criteria andCollation_schemaLessThan(Object value) {
            addCriterion("collation_schema <", value, "collation_schema");
            return (Criteria) this;
        }

        public Criteria andCollation_schemaLessThanOrEqualTo(Object value) {
            addCriterion("collation_schema <=", value, "collation_schema");
            return (Criteria) this;
        }

        public Criteria andCollation_schemaIn(List<Object> values) {
            addCriterion("collation_schema in", values, "collation_schema");
            return (Criteria) this;
        }

        public Criteria andCollation_schemaNotIn(List<Object> values) {
            addCriterion("collation_schema not in", values, "collation_schema");
            return (Criteria) this;
        }

        public Criteria andCollation_schemaBetween(Object value1, Object value2) {
            addCriterion("collation_schema between", value1, value2, "collation_schema");
            return (Criteria) this;
        }

        public Criteria andCollation_schemaNotBetween(Object value1, Object value2) {
            addCriterion("collation_schema not between", value1, value2, "collation_schema");
            return (Criteria) this;
        }

        public Criteria andCollation_nameIsNull() {
            addCriterion("collation_name is null");
            return (Criteria) this;
        }

        public Criteria andCollation_nameIsNotNull() {
            addCriterion("collation_name is not null");
            return (Criteria) this;
        }

        public Criteria andCollation_nameEqualTo(Object value) {
            addCriterion("collation_name =", value, "collation_name");
            return (Criteria) this;
        }

        public Criteria andCollation_nameNotEqualTo(Object value) {
            addCriterion("collation_name <>", value, "collation_name");
            return (Criteria) this;
        }

        public Criteria andCollation_nameGreaterThan(Object value) {
            addCriterion("collation_name >", value, "collation_name");
            return (Criteria) this;
        }

        public Criteria andCollation_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("collation_name >=", value, "collation_name");
            return (Criteria) this;
        }

        public Criteria andCollation_nameLessThan(Object value) {
            addCriterion("collation_name <", value, "collation_name");
            return (Criteria) this;
        }

        public Criteria andCollation_nameLessThanOrEqualTo(Object value) {
            addCriterion("collation_name <=", value, "collation_name");
            return (Criteria) this;
        }

        public Criteria andCollation_nameIn(List<Object> values) {
            addCriterion("collation_name in", values, "collation_name");
            return (Criteria) this;
        }

        public Criteria andCollation_nameNotIn(List<Object> values) {
            addCriterion("collation_name not in", values, "collation_name");
            return (Criteria) this;
        }

        public Criteria andCollation_nameBetween(Object value1, Object value2) {
            addCriterion("collation_name between", value1, value2, "collation_name");
            return (Criteria) this;
        }

        public Criteria andCollation_nameNotBetween(Object value1, Object value2) {
            addCriterion("collation_name not between", value1, value2, "collation_name");
            return (Criteria) this;
        }

        public Criteria andNumeric_precisionIsNull() {
            addCriterion("numeric_precision is null");
            return (Criteria) this;
        }

        public Criteria andNumeric_precisionIsNotNull() {
            addCriterion("numeric_precision is not null");
            return (Criteria) this;
        }

        public Criteria andNumeric_precisionEqualTo(Object value) {
            addCriterion("numeric_precision =", value, "numeric_precision");
            return (Criteria) this;
        }

        public Criteria andNumeric_precisionNotEqualTo(Object value) {
            addCriterion("numeric_precision <>", value, "numeric_precision");
            return (Criteria) this;
        }

        public Criteria andNumeric_precisionGreaterThan(Object value) {
            addCriterion("numeric_precision >", value, "numeric_precision");
            return (Criteria) this;
        }

        public Criteria andNumeric_precisionGreaterThanOrEqualTo(Object value) {
            addCriterion("numeric_precision >=", value, "numeric_precision");
            return (Criteria) this;
        }

        public Criteria andNumeric_precisionLessThan(Object value) {
            addCriterion("numeric_precision <", value, "numeric_precision");
            return (Criteria) this;
        }

        public Criteria andNumeric_precisionLessThanOrEqualTo(Object value) {
            addCriterion("numeric_precision <=", value, "numeric_precision");
            return (Criteria) this;
        }

        public Criteria andNumeric_precisionIn(List<Object> values) {
            addCriterion("numeric_precision in", values, "numeric_precision");
            return (Criteria) this;
        }

        public Criteria andNumeric_precisionNotIn(List<Object> values) {
            addCriterion("numeric_precision not in", values, "numeric_precision");
            return (Criteria) this;
        }

        public Criteria andNumeric_precisionBetween(Object value1, Object value2) {
            addCriterion("numeric_precision between", value1, value2, "numeric_precision");
            return (Criteria) this;
        }

        public Criteria andNumeric_precisionNotBetween(Object value1, Object value2) {
            addCriterion("numeric_precision not between", value1, value2, "numeric_precision");
            return (Criteria) this;
        }

        public Criteria andNumeric_precision_radixIsNull() {
            addCriterion("numeric_precision_radix is null");
            return (Criteria) this;
        }

        public Criteria andNumeric_precision_radixIsNotNull() {
            addCriterion("numeric_precision_radix is not null");
            return (Criteria) this;
        }

        public Criteria andNumeric_precision_radixEqualTo(Object value) {
            addCriterion("numeric_precision_radix =", value, "numeric_precision_radix");
            return (Criteria) this;
        }

        public Criteria andNumeric_precision_radixNotEqualTo(Object value) {
            addCriterion("numeric_precision_radix <>", value, "numeric_precision_radix");
            return (Criteria) this;
        }

        public Criteria andNumeric_precision_radixGreaterThan(Object value) {
            addCriterion("numeric_precision_radix >", value, "numeric_precision_radix");
            return (Criteria) this;
        }

        public Criteria andNumeric_precision_radixGreaterThanOrEqualTo(Object value) {
            addCriterion("numeric_precision_radix >=", value, "numeric_precision_radix");
            return (Criteria) this;
        }

        public Criteria andNumeric_precision_radixLessThan(Object value) {
            addCriterion("numeric_precision_radix <", value, "numeric_precision_radix");
            return (Criteria) this;
        }

        public Criteria andNumeric_precision_radixLessThanOrEqualTo(Object value) {
            addCriterion("numeric_precision_radix <=", value, "numeric_precision_radix");
            return (Criteria) this;
        }

        public Criteria andNumeric_precision_radixIn(List<Object> values) {
            addCriterion("numeric_precision_radix in", values, "numeric_precision_radix");
            return (Criteria) this;
        }

        public Criteria andNumeric_precision_radixNotIn(List<Object> values) {
            addCriterion("numeric_precision_radix not in", values, "numeric_precision_radix");
            return (Criteria) this;
        }

        public Criteria andNumeric_precision_radixBetween(Object value1, Object value2) {
            addCriterion("numeric_precision_radix between", value1, value2, "numeric_precision_radix");
            return (Criteria) this;
        }

        public Criteria andNumeric_precision_radixNotBetween(Object value1, Object value2) {
            addCriterion("numeric_precision_radix not between", value1, value2, "numeric_precision_radix");
            return (Criteria) this;
        }

        public Criteria andNumeric_scaleIsNull() {
            addCriterion("numeric_scale is null");
            return (Criteria) this;
        }

        public Criteria andNumeric_scaleIsNotNull() {
            addCriterion("numeric_scale is not null");
            return (Criteria) this;
        }

        public Criteria andNumeric_scaleEqualTo(Object value) {
            addCriterion("numeric_scale =", value, "numeric_scale");
            return (Criteria) this;
        }

        public Criteria andNumeric_scaleNotEqualTo(Object value) {
            addCriterion("numeric_scale <>", value, "numeric_scale");
            return (Criteria) this;
        }

        public Criteria andNumeric_scaleGreaterThan(Object value) {
            addCriterion("numeric_scale >", value, "numeric_scale");
            return (Criteria) this;
        }

        public Criteria andNumeric_scaleGreaterThanOrEqualTo(Object value) {
            addCriterion("numeric_scale >=", value, "numeric_scale");
            return (Criteria) this;
        }

        public Criteria andNumeric_scaleLessThan(Object value) {
            addCriterion("numeric_scale <", value, "numeric_scale");
            return (Criteria) this;
        }

        public Criteria andNumeric_scaleLessThanOrEqualTo(Object value) {
            addCriterion("numeric_scale <=", value, "numeric_scale");
            return (Criteria) this;
        }

        public Criteria andNumeric_scaleIn(List<Object> values) {
            addCriterion("numeric_scale in", values, "numeric_scale");
            return (Criteria) this;
        }

        public Criteria andNumeric_scaleNotIn(List<Object> values) {
            addCriterion("numeric_scale not in", values, "numeric_scale");
            return (Criteria) this;
        }

        public Criteria andNumeric_scaleBetween(Object value1, Object value2) {
            addCriterion("numeric_scale between", value1, value2, "numeric_scale");
            return (Criteria) this;
        }

        public Criteria andNumeric_scaleNotBetween(Object value1, Object value2) {
            addCriterion("numeric_scale not between", value1, value2, "numeric_scale");
            return (Criteria) this;
        }

        public Criteria andDatetime_precisionIsNull() {
            addCriterion("datetime_precision is null");
            return (Criteria) this;
        }

        public Criteria andDatetime_precisionIsNotNull() {
            addCriterion("datetime_precision is not null");
            return (Criteria) this;
        }

        public Criteria andDatetime_precisionEqualTo(Object value) {
            addCriterion("datetime_precision =", value, "datetime_precision");
            return (Criteria) this;
        }

        public Criteria andDatetime_precisionNotEqualTo(Object value) {
            addCriterion("datetime_precision <>", value, "datetime_precision");
            return (Criteria) this;
        }

        public Criteria andDatetime_precisionGreaterThan(Object value) {
            addCriterion("datetime_precision >", value, "datetime_precision");
            return (Criteria) this;
        }

        public Criteria andDatetime_precisionGreaterThanOrEqualTo(Object value) {
            addCriterion("datetime_precision >=", value, "datetime_precision");
            return (Criteria) this;
        }

        public Criteria andDatetime_precisionLessThan(Object value) {
            addCriterion("datetime_precision <", value, "datetime_precision");
            return (Criteria) this;
        }

        public Criteria andDatetime_precisionLessThanOrEqualTo(Object value) {
            addCriterion("datetime_precision <=", value, "datetime_precision");
            return (Criteria) this;
        }

        public Criteria andDatetime_precisionIn(List<Object> values) {
            addCriterion("datetime_precision in", values, "datetime_precision");
            return (Criteria) this;
        }

        public Criteria andDatetime_precisionNotIn(List<Object> values) {
            addCriterion("datetime_precision not in", values, "datetime_precision");
            return (Criteria) this;
        }

        public Criteria andDatetime_precisionBetween(Object value1, Object value2) {
            addCriterion("datetime_precision between", value1, value2, "datetime_precision");
            return (Criteria) this;
        }

        public Criteria andDatetime_precisionNotBetween(Object value1, Object value2) {
            addCriterion("datetime_precision not between", value1, value2, "datetime_precision");
            return (Criteria) this;
        }

        public Criteria andInterval_typeIsNull() {
            addCriterion("interval_type is null");
            return (Criteria) this;
        }

        public Criteria andInterval_typeIsNotNull() {
            addCriterion("interval_type is not null");
            return (Criteria) this;
        }

        public Criteria andInterval_typeEqualTo(Object value) {
            addCriterion("interval_type =", value, "interval_type");
            return (Criteria) this;
        }

        public Criteria andInterval_typeNotEqualTo(Object value) {
            addCriterion("interval_type <>", value, "interval_type");
            return (Criteria) this;
        }

        public Criteria andInterval_typeGreaterThan(Object value) {
            addCriterion("interval_type >", value, "interval_type");
            return (Criteria) this;
        }

        public Criteria andInterval_typeGreaterThanOrEqualTo(Object value) {
            addCriterion("interval_type >=", value, "interval_type");
            return (Criteria) this;
        }

        public Criteria andInterval_typeLessThan(Object value) {
            addCriterion("interval_type <", value, "interval_type");
            return (Criteria) this;
        }

        public Criteria andInterval_typeLessThanOrEqualTo(Object value) {
            addCriterion("interval_type <=", value, "interval_type");
            return (Criteria) this;
        }

        public Criteria andInterval_typeIn(List<Object> values) {
            addCriterion("interval_type in", values, "interval_type");
            return (Criteria) this;
        }

        public Criteria andInterval_typeNotIn(List<Object> values) {
            addCriterion("interval_type not in", values, "interval_type");
            return (Criteria) this;
        }

        public Criteria andInterval_typeBetween(Object value1, Object value2) {
            addCriterion("interval_type between", value1, value2, "interval_type");
            return (Criteria) this;
        }

        public Criteria andInterval_typeNotBetween(Object value1, Object value2) {
            addCriterion("interval_type not between", value1, value2, "interval_type");
            return (Criteria) this;
        }

        public Criteria andInterval_precisionIsNull() {
            addCriterion("interval_precision is null");
            return (Criteria) this;
        }

        public Criteria andInterval_precisionIsNotNull() {
            addCriterion("interval_precision is not null");
            return (Criteria) this;
        }

        public Criteria andInterval_precisionEqualTo(Object value) {
            addCriterion("interval_precision =", value, "interval_precision");
            return (Criteria) this;
        }

        public Criteria andInterval_precisionNotEqualTo(Object value) {
            addCriterion("interval_precision <>", value, "interval_precision");
            return (Criteria) this;
        }

        public Criteria andInterval_precisionGreaterThan(Object value) {
            addCriterion("interval_precision >", value, "interval_precision");
            return (Criteria) this;
        }

        public Criteria andInterval_precisionGreaterThanOrEqualTo(Object value) {
            addCriterion("interval_precision >=", value, "interval_precision");
            return (Criteria) this;
        }

        public Criteria andInterval_precisionLessThan(Object value) {
            addCriterion("interval_precision <", value, "interval_precision");
            return (Criteria) this;
        }

        public Criteria andInterval_precisionLessThanOrEqualTo(Object value) {
            addCriterion("interval_precision <=", value, "interval_precision");
            return (Criteria) this;
        }

        public Criteria andInterval_precisionIn(List<Object> values) {
            addCriterion("interval_precision in", values, "interval_precision");
            return (Criteria) this;
        }

        public Criteria andInterval_precisionNotIn(List<Object> values) {
            addCriterion("interval_precision not in", values, "interval_precision");
            return (Criteria) this;
        }

        public Criteria andInterval_precisionBetween(Object value1, Object value2) {
            addCriterion("interval_precision between", value1, value2, "interval_precision");
            return (Criteria) this;
        }

        public Criteria andInterval_precisionNotBetween(Object value1, Object value2) {
            addCriterion("interval_precision not between", value1, value2, "interval_precision");
            return (Criteria) this;
        }

        public Criteria andType_udt_catalogIsNull() {
            addCriterion("type_udt_catalog is null");
            return (Criteria) this;
        }

        public Criteria andType_udt_catalogIsNotNull() {
            addCriterion("type_udt_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andType_udt_catalogEqualTo(Object value) {
            addCriterion("type_udt_catalog =", value, "type_udt_catalog");
            return (Criteria) this;
        }

        public Criteria andType_udt_catalogNotEqualTo(Object value) {
            addCriterion("type_udt_catalog <>", value, "type_udt_catalog");
            return (Criteria) this;
        }

        public Criteria andType_udt_catalogGreaterThan(Object value) {
            addCriterion("type_udt_catalog >", value, "type_udt_catalog");
            return (Criteria) this;
        }

        public Criteria andType_udt_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("type_udt_catalog >=", value, "type_udt_catalog");
            return (Criteria) this;
        }

        public Criteria andType_udt_catalogLessThan(Object value) {
            addCriterion("type_udt_catalog <", value, "type_udt_catalog");
            return (Criteria) this;
        }

        public Criteria andType_udt_catalogLessThanOrEqualTo(Object value) {
            addCriterion("type_udt_catalog <=", value, "type_udt_catalog");
            return (Criteria) this;
        }

        public Criteria andType_udt_catalogIn(List<Object> values) {
            addCriterion("type_udt_catalog in", values, "type_udt_catalog");
            return (Criteria) this;
        }

        public Criteria andType_udt_catalogNotIn(List<Object> values) {
            addCriterion("type_udt_catalog not in", values, "type_udt_catalog");
            return (Criteria) this;
        }

        public Criteria andType_udt_catalogBetween(Object value1, Object value2) {
            addCriterion("type_udt_catalog between", value1, value2, "type_udt_catalog");
            return (Criteria) this;
        }

        public Criteria andType_udt_catalogNotBetween(Object value1, Object value2) {
            addCriterion("type_udt_catalog not between", value1, value2, "type_udt_catalog");
            return (Criteria) this;
        }

        public Criteria andType_udt_schemaIsNull() {
            addCriterion("type_udt_schema is null");
            return (Criteria) this;
        }

        public Criteria andType_udt_schemaIsNotNull() {
            addCriterion("type_udt_schema is not null");
            return (Criteria) this;
        }

        public Criteria andType_udt_schemaEqualTo(Object value) {
            addCriterion("type_udt_schema =", value, "type_udt_schema");
            return (Criteria) this;
        }

        public Criteria andType_udt_schemaNotEqualTo(Object value) {
            addCriterion("type_udt_schema <>", value, "type_udt_schema");
            return (Criteria) this;
        }

        public Criteria andType_udt_schemaGreaterThan(Object value) {
            addCriterion("type_udt_schema >", value, "type_udt_schema");
            return (Criteria) this;
        }

        public Criteria andType_udt_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("type_udt_schema >=", value, "type_udt_schema");
            return (Criteria) this;
        }

        public Criteria andType_udt_schemaLessThan(Object value) {
            addCriterion("type_udt_schema <", value, "type_udt_schema");
            return (Criteria) this;
        }

        public Criteria andType_udt_schemaLessThanOrEqualTo(Object value) {
            addCriterion("type_udt_schema <=", value, "type_udt_schema");
            return (Criteria) this;
        }

        public Criteria andType_udt_schemaIn(List<Object> values) {
            addCriterion("type_udt_schema in", values, "type_udt_schema");
            return (Criteria) this;
        }

        public Criteria andType_udt_schemaNotIn(List<Object> values) {
            addCriterion("type_udt_schema not in", values, "type_udt_schema");
            return (Criteria) this;
        }

        public Criteria andType_udt_schemaBetween(Object value1, Object value2) {
            addCriterion("type_udt_schema between", value1, value2, "type_udt_schema");
            return (Criteria) this;
        }

        public Criteria andType_udt_schemaNotBetween(Object value1, Object value2) {
            addCriterion("type_udt_schema not between", value1, value2, "type_udt_schema");
            return (Criteria) this;
        }

        public Criteria andType_udt_nameIsNull() {
            addCriterion("type_udt_name is null");
            return (Criteria) this;
        }

        public Criteria andType_udt_nameIsNotNull() {
            addCriterion("type_udt_name is not null");
            return (Criteria) this;
        }

        public Criteria andType_udt_nameEqualTo(Object value) {
            addCriterion("type_udt_name =", value, "type_udt_name");
            return (Criteria) this;
        }

        public Criteria andType_udt_nameNotEqualTo(Object value) {
            addCriterion("type_udt_name <>", value, "type_udt_name");
            return (Criteria) this;
        }

        public Criteria andType_udt_nameGreaterThan(Object value) {
            addCriterion("type_udt_name >", value, "type_udt_name");
            return (Criteria) this;
        }

        public Criteria andType_udt_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("type_udt_name >=", value, "type_udt_name");
            return (Criteria) this;
        }

        public Criteria andType_udt_nameLessThan(Object value) {
            addCriterion("type_udt_name <", value, "type_udt_name");
            return (Criteria) this;
        }

        public Criteria andType_udt_nameLessThanOrEqualTo(Object value) {
            addCriterion("type_udt_name <=", value, "type_udt_name");
            return (Criteria) this;
        }

        public Criteria andType_udt_nameIn(List<Object> values) {
            addCriterion("type_udt_name in", values, "type_udt_name");
            return (Criteria) this;
        }

        public Criteria andType_udt_nameNotIn(List<Object> values) {
            addCriterion("type_udt_name not in", values, "type_udt_name");
            return (Criteria) this;
        }

        public Criteria andType_udt_nameBetween(Object value1, Object value2) {
            addCriterion("type_udt_name between", value1, value2, "type_udt_name");
            return (Criteria) this;
        }

        public Criteria andType_udt_nameNotBetween(Object value1, Object value2) {
            addCriterion("type_udt_name not between", value1, value2, "type_udt_name");
            return (Criteria) this;
        }

        public Criteria andScope_catalogIsNull() {
            addCriterion("scope_catalog is null");
            return (Criteria) this;
        }

        public Criteria andScope_catalogIsNotNull() {
            addCriterion("scope_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andScope_catalogEqualTo(Object value) {
            addCriterion("scope_catalog =", value, "scope_catalog");
            return (Criteria) this;
        }

        public Criteria andScope_catalogNotEqualTo(Object value) {
            addCriterion("scope_catalog <>", value, "scope_catalog");
            return (Criteria) this;
        }

        public Criteria andScope_catalogGreaterThan(Object value) {
            addCriterion("scope_catalog >", value, "scope_catalog");
            return (Criteria) this;
        }

        public Criteria andScope_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("scope_catalog >=", value, "scope_catalog");
            return (Criteria) this;
        }

        public Criteria andScope_catalogLessThan(Object value) {
            addCriterion("scope_catalog <", value, "scope_catalog");
            return (Criteria) this;
        }

        public Criteria andScope_catalogLessThanOrEqualTo(Object value) {
            addCriterion("scope_catalog <=", value, "scope_catalog");
            return (Criteria) this;
        }

        public Criteria andScope_catalogIn(List<Object> values) {
            addCriterion("scope_catalog in", values, "scope_catalog");
            return (Criteria) this;
        }

        public Criteria andScope_catalogNotIn(List<Object> values) {
            addCriterion("scope_catalog not in", values, "scope_catalog");
            return (Criteria) this;
        }

        public Criteria andScope_catalogBetween(Object value1, Object value2) {
            addCriterion("scope_catalog between", value1, value2, "scope_catalog");
            return (Criteria) this;
        }

        public Criteria andScope_catalogNotBetween(Object value1, Object value2) {
            addCriterion("scope_catalog not between", value1, value2, "scope_catalog");
            return (Criteria) this;
        }

        public Criteria andScope_schemaIsNull() {
            addCriterion("scope_schema is null");
            return (Criteria) this;
        }

        public Criteria andScope_schemaIsNotNull() {
            addCriterion("scope_schema is not null");
            return (Criteria) this;
        }

        public Criteria andScope_schemaEqualTo(Object value) {
            addCriterion("scope_schema =", value, "scope_schema");
            return (Criteria) this;
        }

        public Criteria andScope_schemaNotEqualTo(Object value) {
            addCriterion("scope_schema <>", value, "scope_schema");
            return (Criteria) this;
        }

        public Criteria andScope_schemaGreaterThan(Object value) {
            addCriterion("scope_schema >", value, "scope_schema");
            return (Criteria) this;
        }

        public Criteria andScope_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("scope_schema >=", value, "scope_schema");
            return (Criteria) this;
        }

        public Criteria andScope_schemaLessThan(Object value) {
            addCriterion("scope_schema <", value, "scope_schema");
            return (Criteria) this;
        }

        public Criteria andScope_schemaLessThanOrEqualTo(Object value) {
            addCriterion("scope_schema <=", value, "scope_schema");
            return (Criteria) this;
        }

        public Criteria andScope_schemaIn(List<Object> values) {
            addCriterion("scope_schema in", values, "scope_schema");
            return (Criteria) this;
        }

        public Criteria andScope_schemaNotIn(List<Object> values) {
            addCriterion("scope_schema not in", values, "scope_schema");
            return (Criteria) this;
        }

        public Criteria andScope_schemaBetween(Object value1, Object value2) {
            addCriterion("scope_schema between", value1, value2, "scope_schema");
            return (Criteria) this;
        }

        public Criteria andScope_schemaNotBetween(Object value1, Object value2) {
            addCriterion("scope_schema not between", value1, value2, "scope_schema");
            return (Criteria) this;
        }

        public Criteria andScope_nameIsNull() {
            addCriterion("scope_name is null");
            return (Criteria) this;
        }

        public Criteria andScope_nameIsNotNull() {
            addCriterion("scope_name is not null");
            return (Criteria) this;
        }

        public Criteria andScope_nameEqualTo(Object value) {
            addCriterion("scope_name =", value, "scope_name");
            return (Criteria) this;
        }

        public Criteria andScope_nameNotEqualTo(Object value) {
            addCriterion("scope_name <>", value, "scope_name");
            return (Criteria) this;
        }

        public Criteria andScope_nameGreaterThan(Object value) {
            addCriterion("scope_name >", value, "scope_name");
            return (Criteria) this;
        }

        public Criteria andScope_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("scope_name >=", value, "scope_name");
            return (Criteria) this;
        }

        public Criteria andScope_nameLessThan(Object value) {
            addCriterion("scope_name <", value, "scope_name");
            return (Criteria) this;
        }

        public Criteria andScope_nameLessThanOrEqualTo(Object value) {
            addCriterion("scope_name <=", value, "scope_name");
            return (Criteria) this;
        }

        public Criteria andScope_nameIn(List<Object> values) {
            addCriterion("scope_name in", values, "scope_name");
            return (Criteria) this;
        }

        public Criteria andScope_nameNotIn(List<Object> values) {
            addCriterion("scope_name not in", values, "scope_name");
            return (Criteria) this;
        }

        public Criteria andScope_nameBetween(Object value1, Object value2) {
            addCriterion("scope_name between", value1, value2, "scope_name");
            return (Criteria) this;
        }

        public Criteria andScope_nameNotBetween(Object value1, Object value2) {
            addCriterion("scope_name not between", value1, value2, "scope_name");
            return (Criteria) this;
        }

        public Criteria andMaximum_cardinalityIsNull() {
            addCriterion("maximum_cardinality is null");
            return (Criteria) this;
        }

        public Criteria andMaximum_cardinalityIsNotNull() {
            addCriterion("maximum_cardinality is not null");
            return (Criteria) this;
        }

        public Criteria andMaximum_cardinalityEqualTo(Object value) {
            addCriterion("maximum_cardinality =", value, "maximum_cardinality");
            return (Criteria) this;
        }

        public Criteria andMaximum_cardinalityNotEqualTo(Object value) {
            addCriterion("maximum_cardinality <>", value, "maximum_cardinality");
            return (Criteria) this;
        }

        public Criteria andMaximum_cardinalityGreaterThan(Object value) {
            addCriterion("maximum_cardinality >", value, "maximum_cardinality");
            return (Criteria) this;
        }

        public Criteria andMaximum_cardinalityGreaterThanOrEqualTo(Object value) {
            addCriterion("maximum_cardinality >=", value, "maximum_cardinality");
            return (Criteria) this;
        }

        public Criteria andMaximum_cardinalityLessThan(Object value) {
            addCriterion("maximum_cardinality <", value, "maximum_cardinality");
            return (Criteria) this;
        }

        public Criteria andMaximum_cardinalityLessThanOrEqualTo(Object value) {
            addCriterion("maximum_cardinality <=", value, "maximum_cardinality");
            return (Criteria) this;
        }

        public Criteria andMaximum_cardinalityIn(List<Object> values) {
            addCriterion("maximum_cardinality in", values, "maximum_cardinality");
            return (Criteria) this;
        }

        public Criteria andMaximum_cardinalityNotIn(List<Object> values) {
            addCriterion("maximum_cardinality not in", values, "maximum_cardinality");
            return (Criteria) this;
        }

        public Criteria andMaximum_cardinalityBetween(Object value1, Object value2) {
            addCriterion("maximum_cardinality between", value1, value2, "maximum_cardinality");
            return (Criteria) this;
        }

        public Criteria andMaximum_cardinalityNotBetween(Object value1, Object value2) {
            addCriterion("maximum_cardinality not between", value1, value2, "maximum_cardinality");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierIsNull() {
            addCriterion("dtd_identifier is null");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierIsNotNull() {
            addCriterion("dtd_identifier is not null");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierEqualTo(Object value) {
            addCriterion("dtd_identifier =", value, "dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierNotEqualTo(Object value) {
            addCriterion("dtd_identifier <>", value, "dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierGreaterThan(Object value) {
            addCriterion("dtd_identifier >", value, "dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierGreaterThanOrEqualTo(Object value) {
            addCriterion("dtd_identifier >=", value, "dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierLessThan(Object value) {
            addCriterion("dtd_identifier <", value, "dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierLessThanOrEqualTo(Object value) {
            addCriterion("dtd_identifier <=", value, "dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierIn(List<Object> values) {
            addCriterion("dtd_identifier in", values, "dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierNotIn(List<Object> values) {
            addCriterion("dtd_identifier not in", values, "dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierBetween(Object value1, Object value2) {
            addCriterion("dtd_identifier between", value1, value2, "dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andDtd_identifierNotBetween(Object value1, Object value2) {
            addCriterion("dtd_identifier not between", value1, value2, "dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andRoutine_bodyIsNull() {
            addCriterion("routine_body is null");
            return (Criteria) this;
        }

        public Criteria andRoutine_bodyIsNotNull() {
            addCriterion("routine_body is not null");
            return (Criteria) this;
        }

        public Criteria andRoutine_bodyEqualTo(Object value) {
            addCriterion("routine_body =", value, "routine_body");
            return (Criteria) this;
        }

        public Criteria andRoutine_bodyNotEqualTo(Object value) {
            addCriterion("routine_body <>", value, "routine_body");
            return (Criteria) this;
        }

        public Criteria andRoutine_bodyGreaterThan(Object value) {
            addCriterion("routine_body >", value, "routine_body");
            return (Criteria) this;
        }

        public Criteria andRoutine_bodyGreaterThanOrEqualTo(Object value) {
            addCriterion("routine_body >=", value, "routine_body");
            return (Criteria) this;
        }

        public Criteria andRoutine_bodyLessThan(Object value) {
            addCriterion("routine_body <", value, "routine_body");
            return (Criteria) this;
        }

        public Criteria andRoutine_bodyLessThanOrEqualTo(Object value) {
            addCriterion("routine_body <=", value, "routine_body");
            return (Criteria) this;
        }

        public Criteria andRoutine_bodyIn(List<Object> values) {
            addCriterion("routine_body in", values, "routine_body");
            return (Criteria) this;
        }

        public Criteria andRoutine_bodyNotIn(List<Object> values) {
            addCriterion("routine_body not in", values, "routine_body");
            return (Criteria) this;
        }

        public Criteria andRoutine_bodyBetween(Object value1, Object value2) {
            addCriterion("routine_body between", value1, value2, "routine_body");
            return (Criteria) this;
        }

        public Criteria andRoutine_bodyNotBetween(Object value1, Object value2) {
            addCriterion("routine_body not between", value1, value2, "routine_body");
            return (Criteria) this;
        }

        public Criteria andRoutine_definitionIsNull() {
            addCriterion("routine_definition is null");
            return (Criteria) this;
        }

        public Criteria andRoutine_definitionIsNotNull() {
            addCriterion("routine_definition is not null");
            return (Criteria) this;
        }

        public Criteria andRoutine_definitionEqualTo(Object value) {
            addCriterion("routine_definition =", value, "routine_definition");
            return (Criteria) this;
        }

        public Criteria andRoutine_definitionNotEqualTo(Object value) {
            addCriterion("routine_definition <>", value, "routine_definition");
            return (Criteria) this;
        }

        public Criteria andRoutine_definitionGreaterThan(Object value) {
            addCriterion("routine_definition >", value, "routine_definition");
            return (Criteria) this;
        }

        public Criteria andRoutine_definitionGreaterThanOrEqualTo(Object value) {
            addCriterion("routine_definition >=", value, "routine_definition");
            return (Criteria) this;
        }

        public Criteria andRoutine_definitionLessThan(Object value) {
            addCriterion("routine_definition <", value, "routine_definition");
            return (Criteria) this;
        }

        public Criteria andRoutine_definitionLessThanOrEqualTo(Object value) {
            addCriterion("routine_definition <=", value, "routine_definition");
            return (Criteria) this;
        }

        public Criteria andRoutine_definitionIn(List<Object> values) {
            addCriterion("routine_definition in", values, "routine_definition");
            return (Criteria) this;
        }

        public Criteria andRoutine_definitionNotIn(List<Object> values) {
            addCriterion("routine_definition not in", values, "routine_definition");
            return (Criteria) this;
        }

        public Criteria andRoutine_definitionBetween(Object value1, Object value2) {
            addCriterion("routine_definition between", value1, value2, "routine_definition");
            return (Criteria) this;
        }

        public Criteria andRoutine_definitionNotBetween(Object value1, Object value2) {
            addCriterion("routine_definition not between", value1, value2, "routine_definition");
            return (Criteria) this;
        }

        public Criteria andExternal_nameIsNull() {
            addCriterion("external_name is null");
            return (Criteria) this;
        }

        public Criteria andExternal_nameIsNotNull() {
            addCriterion("external_name is not null");
            return (Criteria) this;
        }

        public Criteria andExternal_nameEqualTo(Object value) {
            addCriterion("external_name =", value, "external_name");
            return (Criteria) this;
        }

        public Criteria andExternal_nameNotEqualTo(Object value) {
            addCriterion("external_name <>", value, "external_name");
            return (Criteria) this;
        }

        public Criteria andExternal_nameGreaterThan(Object value) {
            addCriterion("external_name >", value, "external_name");
            return (Criteria) this;
        }

        public Criteria andExternal_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("external_name >=", value, "external_name");
            return (Criteria) this;
        }

        public Criteria andExternal_nameLessThan(Object value) {
            addCriterion("external_name <", value, "external_name");
            return (Criteria) this;
        }

        public Criteria andExternal_nameLessThanOrEqualTo(Object value) {
            addCriterion("external_name <=", value, "external_name");
            return (Criteria) this;
        }

        public Criteria andExternal_nameIn(List<Object> values) {
            addCriterion("external_name in", values, "external_name");
            return (Criteria) this;
        }

        public Criteria andExternal_nameNotIn(List<Object> values) {
            addCriterion("external_name not in", values, "external_name");
            return (Criteria) this;
        }

        public Criteria andExternal_nameBetween(Object value1, Object value2) {
            addCriterion("external_name between", value1, value2, "external_name");
            return (Criteria) this;
        }

        public Criteria andExternal_nameNotBetween(Object value1, Object value2) {
            addCriterion("external_name not between", value1, value2, "external_name");
            return (Criteria) this;
        }

        public Criteria andExternal_languageIsNull() {
            addCriterion("external_language is null");
            return (Criteria) this;
        }

        public Criteria andExternal_languageIsNotNull() {
            addCriterion("external_language is not null");
            return (Criteria) this;
        }

        public Criteria andExternal_languageEqualTo(Object value) {
            addCriterion("external_language =", value, "external_language");
            return (Criteria) this;
        }

        public Criteria andExternal_languageNotEqualTo(Object value) {
            addCriterion("external_language <>", value, "external_language");
            return (Criteria) this;
        }

        public Criteria andExternal_languageGreaterThan(Object value) {
            addCriterion("external_language >", value, "external_language");
            return (Criteria) this;
        }

        public Criteria andExternal_languageGreaterThanOrEqualTo(Object value) {
            addCriterion("external_language >=", value, "external_language");
            return (Criteria) this;
        }

        public Criteria andExternal_languageLessThan(Object value) {
            addCriterion("external_language <", value, "external_language");
            return (Criteria) this;
        }

        public Criteria andExternal_languageLessThanOrEqualTo(Object value) {
            addCriterion("external_language <=", value, "external_language");
            return (Criteria) this;
        }

        public Criteria andExternal_languageIn(List<Object> values) {
            addCriterion("external_language in", values, "external_language");
            return (Criteria) this;
        }

        public Criteria andExternal_languageNotIn(List<Object> values) {
            addCriterion("external_language not in", values, "external_language");
            return (Criteria) this;
        }

        public Criteria andExternal_languageBetween(Object value1, Object value2) {
            addCriterion("external_language between", value1, value2, "external_language");
            return (Criteria) this;
        }

        public Criteria andExternal_languageNotBetween(Object value1, Object value2) {
            addCriterion("external_language not between", value1, value2, "external_language");
            return (Criteria) this;
        }

        public Criteria andParameter_styleIsNull() {
            addCriterion("parameter_style is null");
            return (Criteria) this;
        }

        public Criteria andParameter_styleIsNotNull() {
            addCriterion("parameter_style is not null");
            return (Criteria) this;
        }

        public Criteria andParameter_styleEqualTo(Object value) {
            addCriterion("parameter_style =", value, "parameter_style");
            return (Criteria) this;
        }

        public Criteria andParameter_styleNotEqualTo(Object value) {
            addCriterion("parameter_style <>", value, "parameter_style");
            return (Criteria) this;
        }

        public Criteria andParameter_styleGreaterThan(Object value) {
            addCriterion("parameter_style >", value, "parameter_style");
            return (Criteria) this;
        }

        public Criteria andParameter_styleGreaterThanOrEqualTo(Object value) {
            addCriterion("parameter_style >=", value, "parameter_style");
            return (Criteria) this;
        }

        public Criteria andParameter_styleLessThan(Object value) {
            addCriterion("parameter_style <", value, "parameter_style");
            return (Criteria) this;
        }

        public Criteria andParameter_styleLessThanOrEqualTo(Object value) {
            addCriterion("parameter_style <=", value, "parameter_style");
            return (Criteria) this;
        }

        public Criteria andParameter_styleIn(List<Object> values) {
            addCriterion("parameter_style in", values, "parameter_style");
            return (Criteria) this;
        }

        public Criteria andParameter_styleNotIn(List<Object> values) {
            addCriterion("parameter_style not in", values, "parameter_style");
            return (Criteria) this;
        }

        public Criteria andParameter_styleBetween(Object value1, Object value2) {
            addCriterion("parameter_style between", value1, value2, "parameter_style");
            return (Criteria) this;
        }

        public Criteria andParameter_styleNotBetween(Object value1, Object value2) {
            addCriterion("parameter_style not between", value1, value2, "parameter_style");
            return (Criteria) this;
        }

        public Criteria andIs_deterministicIsNull() {
            addCriterion("is_deterministic is null");
            return (Criteria) this;
        }

        public Criteria andIs_deterministicIsNotNull() {
            addCriterion("is_deterministic is not null");
            return (Criteria) this;
        }

        public Criteria andIs_deterministicEqualTo(Object value) {
            addCriterion("is_deterministic =", value, "is_deterministic");
            return (Criteria) this;
        }

        public Criteria andIs_deterministicNotEqualTo(Object value) {
            addCriterion("is_deterministic <>", value, "is_deterministic");
            return (Criteria) this;
        }

        public Criteria andIs_deterministicGreaterThan(Object value) {
            addCriterion("is_deterministic >", value, "is_deterministic");
            return (Criteria) this;
        }

        public Criteria andIs_deterministicGreaterThanOrEqualTo(Object value) {
            addCriterion("is_deterministic >=", value, "is_deterministic");
            return (Criteria) this;
        }

        public Criteria andIs_deterministicLessThan(Object value) {
            addCriterion("is_deterministic <", value, "is_deterministic");
            return (Criteria) this;
        }

        public Criteria andIs_deterministicLessThanOrEqualTo(Object value) {
            addCriterion("is_deterministic <=", value, "is_deterministic");
            return (Criteria) this;
        }

        public Criteria andIs_deterministicIn(List<Object> values) {
            addCriterion("is_deterministic in", values, "is_deterministic");
            return (Criteria) this;
        }

        public Criteria andIs_deterministicNotIn(List<Object> values) {
            addCriterion("is_deterministic not in", values, "is_deterministic");
            return (Criteria) this;
        }

        public Criteria andIs_deterministicBetween(Object value1, Object value2) {
            addCriterion("is_deterministic between", value1, value2, "is_deterministic");
            return (Criteria) this;
        }

        public Criteria andIs_deterministicNotBetween(Object value1, Object value2) {
            addCriterion("is_deterministic not between", value1, value2, "is_deterministic");
            return (Criteria) this;
        }

        public Criteria andSql_data_accessIsNull() {
            addCriterion("sql_data_access is null");
            return (Criteria) this;
        }

        public Criteria andSql_data_accessIsNotNull() {
            addCriterion("sql_data_access is not null");
            return (Criteria) this;
        }

        public Criteria andSql_data_accessEqualTo(Object value) {
            addCriterion("sql_data_access =", value, "sql_data_access");
            return (Criteria) this;
        }

        public Criteria andSql_data_accessNotEqualTo(Object value) {
            addCriterion("sql_data_access <>", value, "sql_data_access");
            return (Criteria) this;
        }

        public Criteria andSql_data_accessGreaterThan(Object value) {
            addCriterion("sql_data_access >", value, "sql_data_access");
            return (Criteria) this;
        }

        public Criteria andSql_data_accessGreaterThanOrEqualTo(Object value) {
            addCriterion("sql_data_access >=", value, "sql_data_access");
            return (Criteria) this;
        }

        public Criteria andSql_data_accessLessThan(Object value) {
            addCriterion("sql_data_access <", value, "sql_data_access");
            return (Criteria) this;
        }

        public Criteria andSql_data_accessLessThanOrEqualTo(Object value) {
            addCriterion("sql_data_access <=", value, "sql_data_access");
            return (Criteria) this;
        }

        public Criteria andSql_data_accessIn(List<Object> values) {
            addCriterion("sql_data_access in", values, "sql_data_access");
            return (Criteria) this;
        }

        public Criteria andSql_data_accessNotIn(List<Object> values) {
            addCriterion("sql_data_access not in", values, "sql_data_access");
            return (Criteria) this;
        }

        public Criteria andSql_data_accessBetween(Object value1, Object value2) {
            addCriterion("sql_data_access between", value1, value2, "sql_data_access");
            return (Criteria) this;
        }

        public Criteria andSql_data_accessNotBetween(Object value1, Object value2) {
            addCriterion("sql_data_access not between", value1, value2, "sql_data_access");
            return (Criteria) this;
        }

        public Criteria andIs_null_callIsNull() {
            addCriterion("is_null_call is null");
            return (Criteria) this;
        }

        public Criteria andIs_null_callIsNotNull() {
            addCriterion("is_null_call is not null");
            return (Criteria) this;
        }

        public Criteria andIs_null_callEqualTo(Object value) {
            addCriterion("is_null_call =", value, "is_null_call");
            return (Criteria) this;
        }

        public Criteria andIs_null_callNotEqualTo(Object value) {
            addCriterion("is_null_call <>", value, "is_null_call");
            return (Criteria) this;
        }

        public Criteria andIs_null_callGreaterThan(Object value) {
            addCriterion("is_null_call >", value, "is_null_call");
            return (Criteria) this;
        }

        public Criteria andIs_null_callGreaterThanOrEqualTo(Object value) {
            addCriterion("is_null_call >=", value, "is_null_call");
            return (Criteria) this;
        }

        public Criteria andIs_null_callLessThan(Object value) {
            addCriterion("is_null_call <", value, "is_null_call");
            return (Criteria) this;
        }

        public Criteria andIs_null_callLessThanOrEqualTo(Object value) {
            addCriterion("is_null_call <=", value, "is_null_call");
            return (Criteria) this;
        }

        public Criteria andIs_null_callIn(List<Object> values) {
            addCriterion("is_null_call in", values, "is_null_call");
            return (Criteria) this;
        }

        public Criteria andIs_null_callNotIn(List<Object> values) {
            addCriterion("is_null_call not in", values, "is_null_call");
            return (Criteria) this;
        }

        public Criteria andIs_null_callBetween(Object value1, Object value2) {
            addCriterion("is_null_call between", value1, value2, "is_null_call");
            return (Criteria) this;
        }

        public Criteria andIs_null_callNotBetween(Object value1, Object value2) {
            addCriterion("is_null_call not between", value1, value2, "is_null_call");
            return (Criteria) this;
        }

        public Criteria andSql_pathIsNull() {
            addCriterion("sql_path is null");
            return (Criteria) this;
        }

        public Criteria andSql_pathIsNotNull() {
            addCriterion("sql_path is not null");
            return (Criteria) this;
        }

        public Criteria andSql_pathEqualTo(Object value) {
            addCriterion("sql_path =", value, "sql_path");
            return (Criteria) this;
        }

        public Criteria andSql_pathNotEqualTo(Object value) {
            addCriterion("sql_path <>", value, "sql_path");
            return (Criteria) this;
        }

        public Criteria andSql_pathGreaterThan(Object value) {
            addCriterion("sql_path >", value, "sql_path");
            return (Criteria) this;
        }

        public Criteria andSql_pathGreaterThanOrEqualTo(Object value) {
            addCriterion("sql_path >=", value, "sql_path");
            return (Criteria) this;
        }

        public Criteria andSql_pathLessThan(Object value) {
            addCriterion("sql_path <", value, "sql_path");
            return (Criteria) this;
        }

        public Criteria andSql_pathLessThanOrEqualTo(Object value) {
            addCriterion("sql_path <=", value, "sql_path");
            return (Criteria) this;
        }

        public Criteria andSql_pathIn(List<Object> values) {
            addCriterion("sql_path in", values, "sql_path");
            return (Criteria) this;
        }

        public Criteria andSql_pathNotIn(List<Object> values) {
            addCriterion("sql_path not in", values, "sql_path");
            return (Criteria) this;
        }

        public Criteria andSql_pathBetween(Object value1, Object value2) {
            addCriterion("sql_path between", value1, value2, "sql_path");
            return (Criteria) this;
        }

        public Criteria andSql_pathNotBetween(Object value1, Object value2) {
            addCriterion("sql_path not between", value1, value2, "sql_path");
            return (Criteria) this;
        }

        public Criteria andSchema_level_routineIsNull() {
            addCriterion("schema_level_routine is null");
            return (Criteria) this;
        }

        public Criteria andSchema_level_routineIsNotNull() {
            addCriterion("schema_level_routine is not null");
            return (Criteria) this;
        }

        public Criteria andSchema_level_routineEqualTo(Object value) {
            addCriterion("schema_level_routine =", value, "schema_level_routine");
            return (Criteria) this;
        }

        public Criteria andSchema_level_routineNotEqualTo(Object value) {
            addCriterion("schema_level_routine <>", value, "schema_level_routine");
            return (Criteria) this;
        }

        public Criteria andSchema_level_routineGreaterThan(Object value) {
            addCriterion("schema_level_routine >", value, "schema_level_routine");
            return (Criteria) this;
        }

        public Criteria andSchema_level_routineGreaterThanOrEqualTo(Object value) {
            addCriterion("schema_level_routine >=", value, "schema_level_routine");
            return (Criteria) this;
        }

        public Criteria andSchema_level_routineLessThan(Object value) {
            addCriterion("schema_level_routine <", value, "schema_level_routine");
            return (Criteria) this;
        }

        public Criteria andSchema_level_routineLessThanOrEqualTo(Object value) {
            addCriterion("schema_level_routine <=", value, "schema_level_routine");
            return (Criteria) this;
        }

        public Criteria andSchema_level_routineIn(List<Object> values) {
            addCriterion("schema_level_routine in", values, "schema_level_routine");
            return (Criteria) this;
        }

        public Criteria andSchema_level_routineNotIn(List<Object> values) {
            addCriterion("schema_level_routine not in", values, "schema_level_routine");
            return (Criteria) this;
        }

        public Criteria andSchema_level_routineBetween(Object value1, Object value2) {
            addCriterion("schema_level_routine between", value1, value2, "schema_level_routine");
            return (Criteria) this;
        }

        public Criteria andSchema_level_routineNotBetween(Object value1, Object value2) {
            addCriterion("schema_level_routine not between", value1, value2, "schema_level_routine");
            return (Criteria) this;
        }

        public Criteria andMax_dynamic_result_setsIsNull() {
            addCriterion("max_dynamic_result_sets is null");
            return (Criteria) this;
        }

        public Criteria andMax_dynamic_result_setsIsNotNull() {
            addCriterion("max_dynamic_result_sets is not null");
            return (Criteria) this;
        }

        public Criteria andMax_dynamic_result_setsEqualTo(Object value) {
            addCriterion("max_dynamic_result_sets =", value, "max_dynamic_result_sets");
            return (Criteria) this;
        }

        public Criteria andMax_dynamic_result_setsNotEqualTo(Object value) {
            addCriterion("max_dynamic_result_sets <>", value, "max_dynamic_result_sets");
            return (Criteria) this;
        }

        public Criteria andMax_dynamic_result_setsGreaterThan(Object value) {
            addCriterion("max_dynamic_result_sets >", value, "max_dynamic_result_sets");
            return (Criteria) this;
        }

        public Criteria andMax_dynamic_result_setsGreaterThanOrEqualTo(Object value) {
            addCriterion("max_dynamic_result_sets >=", value, "max_dynamic_result_sets");
            return (Criteria) this;
        }

        public Criteria andMax_dynamic_result_setsLessThan(Object value) {
            addCriterion("max_dynamic_result_sets <", value, "max_dynamic_result_sets");
            return (Criteria) this;
        }

        public Criteria andMax_dynamic_result_setsLessThanOrEqualTo(Object value) {
            addCriterion("max_dynamic_result_sets <=", value, "max_dynamic_result_sets");
            return (Criteria) this;
        }

        public Criteria andMax_dynamic_result_setsIn(List<Object> values) {
            addCriterion("max_dynamic_result_sets in", values, "max_dynamic_result_sets");
            return (Criteria) this;
        }

        public Criteria andMax_dynamic_result_setsNotIn(List<Object> values) {
            addCriterion("max_dynamic_result_sets not in", values, "max_dynamic_result_sets");
            return (Criteria) this;
        }

        public Criteria andMax_dynamic_result_setsBetween(Object value1, Object value2) {
            addCriterion("max_dynamic_result_sets between", value1, value2, "max_dynamic_result_sets");
            return (Criteria) this;
        }

        public Criteria andMax_dynamic_result_setsNotBetween(Object value1, Object value2) {
            addCriterion("max_dynamic_result_sets not between", value1, value2, "max_dynamic_result_sets");
            return (Criteria) this;
        }

        public Criteria andIs_user_defined_castIsNull() {
            addCriterion("is_user_defined_cast is null");
            return (Criteria) this;
        }

        public Criteria andIs_user_defined_castIsNotNull() {
            addCriterion("is_user_defined_cast is not null");
            return (Criteria) this;
        }

        public Criteria andIs_user_defined_castEqualTo(Object value) {
            addCriterion("is_user_defined_cast =", value, "is_user_defined_cast");
            return (Criteria) this;
        }

        public Criteria andIs_user_defined_castNotEqualTo(Object value) {
            addCriterion("is_user_defined_cast <>", value, "is_user_defined_cast");
            return (Criteria) this;
        }

        public Criteria andIs_user_defined_castGreaterThan(Object value) {
            addCriterion("is_user_defined_cast >", value, "is_user_defined_cast");
            return (Criteria) this;
        }

        public Criteria andIs_user_defined_castGreaterThanOrEqualTo(Object value) {
            addCriterion("is_user_defined_cast >=", value, "is_user_defined_cast");
            return (Criteria) this;
        }

        public Criteria andIs_user_defined_castLessThan(Object value) {
            addCriterion("is_user_defined_cast <", value, "is_user_defined_cast");
            return (Criteria) this;
        }

        public Criteria andIs_user_defined_castLessThanOrEqualTo(Object value) {
            addCriterion("is_user_defined_cast <=", value, "is_user_defined_cast");
            return (Criteria) this;
        }

        public Criteria andIs_user_defined_castIn(List<Object> values) {
            addCriterion("is_user_defined_cast in", values, "is_user_defined_cast");
            return (Criteria) this;
        }

        public Criteria andIs_user_defined_castNotIn(List<Object> values) {
            addCriterion("is_user_defined_cast not in", values, "is_user_defined_cast");
            return (Criteria) this;
        }

        public Criteria andIs_user_defined_castBetween(Object value1, Object value2) {
            addCriterion("is_user_defined_cast between", value1, value2, "is_user_defined_cast");
            return (Criteria) this;
        }

        public Criteria andIs_user_defined_castNotBetween(Object value1, Object value2) {
            addCriterion("is_user_defined_cast not between", value1, value2, "is_user_defined_cast");
            return (Criteria) this;
        }

        public Criteria andIs_implicitly_invocableIsNull() {
            addCriterion("is_implicitly_invocable is null");
            return (Criteria) this;
        }

        public Criteria andIs_implicitly_invocableIsNotNull() {
            addCriterion("is_implicitly_invocable is not null");
            return (Criteria) this;
        }

        public Criteria andIs_implicitly_invocableEqualTo(Object value) {
            addCriterion("is_implicitly_invocable =", value, "is_implicitly_invocable");
            return (Criteria) this;
        }

        public Criteria andIs_implicitly_invocableNotEqualTo(Object value) {
            addCriterion("is_implicitly_invocable <>", value, "is_implicitly_invocable");
            return (Criteria) this;
        }

        public Criteria andIs_implicitly_invocableGreaterThan(Object value) {
            addCriterion("is_implicitly_invocable >", value, "is_implicitly_invocable");
            return (Criteria) this;
        }

        public Criteria andIs_implicitly_invocableGreaterThanOrEqualTo(Object value) {
            addCriterion("is_implicitly_invocable >=", value, "is_implicitly_invocable");
            return (Criteria) this;
        }

        public Criteria andIs_implicitly_invocableLessThan(Object value) {
            addCriterion("is_implicitly_invocable <", value, "is_implicitly_invocable");
            return (Criteria) this;
        }

        public Criteria andIs_implicitly_invocableLessThanOrEqualTo(Object value) {
            addCriterion("is_implicitly_invocable <=", value, "is_implicitly_invocable");
            return (Criteria) this;
        }

        public Criteria andIs_implicitly_invocableIn(List<Object> values) {
            addCriterion("is_implicitly_invocable in", values, "is_implicitly_invocable");
            return (Criteria) this;
        }

        public Criteria andIs_implicitly_invocableNotIn(List<Object> values) {
            addCriterion("is_implicitly_invocable not in", values, "is_implicitly_invocable");
            return (Criteria) this;
        }

        public Criteria andIs_implicitly_invocableBetween(Object value1, Object value2) {
            addCriterion("is_implicitly_invocable between", value1, value2, "is_implicitly_invocable");
            return (Criteria) this;
        }

        public Criteria andIs_implicitly_invocableNotBetween(Object value1, Object value2) {
            addCriterion("is_implicitly_invocable not between", value1, value2, "is_implicitly_invocable");
            return (Criteria) this;
        }

        public Criteria andSecurity_typeIsNull() {
            addCriterion("security_type is null");
            return (Criteria) this;
        }

        public Criteria andSecurity_typeIsNotNull() {
            addCriterion("security_type is not null");
            return (Criteria) this;
        }

        public Criteria andSecurity_typeEqualTo(Object value) {
            addCriterion("security_type =", value, "security_type");
            return (Criteria) this;
        }

        public Criteria andSecurity_typeNotEqualTo(Object value) {
            addCriterion("security_type <>", value, "security_type");
            return (Criteria) this;
        }

        public Criteria andSecurity_typeGreaterThan(Object value) {
            addCriterion("security_type >", value, "security_type");
            return (Criteria) this;
        }

        public Criteria andSecurity_typeGreaterThanOrEqualTo(Object value) {
            addCriterion("security_type >=", value, "security_type");
            return (Criteria) this;
        }

        public Criteria andSecurity_typeLessThan(Object value) {
            addCriterion("security_type <", value, "security_type");
            return (Criteria) this;
        }

        public Criteria andSecurity_typeLessThanOrEqualTo(Object value) {
            addCriterion("security_type <=", value, "security_type");
            return (Criteria) this;
        }

        public Criteria andSecurity_typeIn(List<Object> values) {
            addCriterion("security_type in", values, "security_type");
            return (Criteria) this;
        }

        public Criteria andSecurity_typeNotIn(List<Object> values) {
            addCriterion("security_type not in", values, "security_type");
            return (Criteria) this;
        }

        public Criteria andSecurity_typeBetween(Object value1, Object value2) {
            addCriterion("security_type between", value1, value2, "security_type");
            return (Criteria) this;
        }

        public Criteria andSecurity_typeNotBetween(Object value1, Object value2) {
            addCriterion("security_type not between", value1, value2, "security_type");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_catalogIsNull() {
            addCriterion("to_sql_specific_catalog is null");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_catalogIsNotNull() {
            addCriterion("to_sql_specific_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_catalogEqualTo(Object value) {
            addCriterion("to_sql_specific_catalog =", value, "to_sql_specific_catalog");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_catalogNotEqualTo(Object value) {
            addCriterion("to_sql_specific_catalog <>", value, "to_sql_specific_catalog");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_catalogGreaterThan(Object value) {
            addCriterion("to_sql_specific_catalog >", value, "to_sql_specific_catalog");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("to_sql_specific_catalog >=", value, "to_sql_specific_catalog");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_catalogLessThan(Object value) {
            addCriterion("to_sql_specific_catalog <", value, "to_sql_specific_catalog");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_catalogLessThanOrEqualTo(Object value) {
            addCriterion("to_sql_specific_catalog <=", value, "to_sql_specific_catalog");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_catalogIn(List<Object> values) {
            addCriterion("to_sql_specific_catalog in", values, "to_sql_specific_catalog");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_catalogNotIn(List<Object> values) {
            addCriterion("to_sql_specific_catalog not in", values, "to_sql_specific_catalog");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_catalogBetween(Object value1, Object value2) {
            addCriterion("to_sql_specific_catalog between", value1, value2, "to_sql_specific_catalog");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_catalogNotBetween(Object value1, Object value2) {
            addCriterion("to_sql_specific_catalog not between", value1, value2, "to_sql_specific_catalog");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_schemaIsNull() {
            addCriterion("to_sql_specific_schema is null");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_schemaIsNotNull() {
            addCriterion("to_sql_specific_schema is not null");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_schemaEqualTo(Object value) {
            addCriterion("to_sql_specific_schema =", value, "to_sql_specific_schema");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_schemaNotEqualTo(Object value) {
            addCriterion("to_sql_specific_schema <>", value, "to_sql_specific_schema");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_schemaGreaterThan(Object value) {
            addCriterion("to_sql_specific_schema >", value, "to_sql_specific_schema");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("to_sql_specific_schema >=", value, "to_sql_specific_schema");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_schemaLessThan(Object value) {
            addCriterion("to_sql_specific_schema <", value, "to_sql_specific_schema");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_schemaLessThanOrEqualTo(Object value) {
            addCriterion("to_sql_specific_schema <=", value, "to_sql_specific_schema");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_schemaIn(List<Object> values) {
            addCriterion("to_sql_specific_schema in", values, "to_sql_specific_schema");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_schemaNotIn(List<Object> values) {
            addCriterion("to_sql_specific_schema not in", values, "to_sql_specific_schema");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_schemaBetween(Object value1, Object value2) {
            addCriterion("to_sql_specific_schema between", value1, value2, "to_sql_specific_schema");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_schemaNotBetween(Object value1, Object value2) {
            addCriterion("to_sql_specific_schema not between", value1, value2, "to_sql_specific_schema");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_nameIsNull() {
            addCriterion("to_sql_specific_name is null");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_nameIsNotNull() {
            addCriterion("to_sql_specific_name is not null");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_nameEqualTo(Object value) {
            addCriterion("to_sql_specific_name =", value, "to_sql_specific_name");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_nameNotEqualTo(Object value) {
            addCriterion("to_sql_specific_name <>", value, "to_sql_specific_name");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_nameGreaterThan(Object value) {
            addCriterion("to_sql_specific_name >", value, "to_sql_specific_name");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("to_sql_specific_name >=", value, "to_sql_specific_name");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_nameLessThan(Object value) {
            addCriterion("to_sql_specific_name <", value, "to_sql_specific_name");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_nameLessThanOrEqualTo(Object value) {
            addCriterion("to_sql_specific_name <=", value, "to_sql_specific_name");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_nameIn(List<Object> values) {
            addCriterion("to_sql_specific_name in", values, "to_sql_specific_name");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_nameNotIn(List<Object> values) {
            addCriterion("to_sql_specific_name not in", values, "to_sql_specific_name");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_nameBetween(Object value1, Object value2) {
            addCriterion("to_sql_specific_name between", value1, value2, "to_sql_specific_name");
            return (Criteria) this;
        }

        public Criteria andTo_sql_specific_nameNotBetween(Object value1, Object value2) {
            addCriterion("to_sql_specific_name not between", value1, value2, "to_sql_specific_name");
            return (Criteria) this;
        }

        public Criteria andAs_locatorIsNull() {
            addCriterion("as_locator is null");
            return (Criteria) this;
        }

        public Criteria andAs_locatorIsNotNull() {
            addCriterion("as_locator is not null");
            return (Criteria) this;
        }

        public Criteria andAs_locatorEqualTo(Object value) {
            addCriterion("as_locator =", value, "as_locator");
            return (Criteria) this;
        }

        public Criteria andAs_locatorNotEqualTo(Object value) {
            addCriterion("as_locator <>", value, "as_locator");
            return (Criteria) this;
        }

        public Criteria andAs_locatorGreaterThan(Object value) {
            addCriterion("as_locator >", value, "as_locator");
            return (Criteria) this;
        }

        public Criteria andAs_locatorGreaterThanOrEqualTo(Object value) {
            addCriterion("as_locator >=", value, "as_locator");
            return (Criteria) this;
        }

        public Criteria andAs_locatorLessThan(Object value) {
            addCriterion("as_locator <", value, "as_locator");
            return (Criteria) this;
        }

        public Criteria andAs_locatorLessThanOrEqualTo(Object value) {
            addCriterion("as_locator <=", value, "as_locator");
            return (Criteria) this;
        }

        public Criteria andAs_locatorIn(List<Object> values) {
            addCriterion("as_locator in", values, "as_locator");
            return (Criteria) this;
        }

        public Criteria andAs_locatorNotIn(List<Object> values) {
            addCriterion("as_locator not in", values, "as_locator");
            return (Criteria) this;
        }

        public Criteria andAs_locatorBetween(Object value1, Object value2) {
            addCriterion("as_locator between", value1, value2, "as_locator");
            return (Criteria) this;
        }

        public Criteria andAs_locatorNotBetween(Object value1, Object value2) {
            addCriterion("as_locator not between", value1, value2, "as_locator");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Object value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Object value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Object value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Object value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Object value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Object value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Object> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Object> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Object value1, Object value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Object value1, Object value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andLast_alteredIsNull() {
            addCriterion("last_altered is null");
            return (Criteria) this;
        }

        public Criteria andLast_alteredIsNotNull() {
            addCriterion("last_altered is not null");
            return (Criteria) this;
        }

        public Criteria andLast_alteredEqualTo(Object value) {
            addCriterion("last_altered =", value, "last_altered");
            return (Criteria) this;
        }

        public Criteria andLast_alteredNotEqualTo(Object value) {
            addCriterion("last_altered <>", value, "last_altered");
            return (Criteria) this;
        }

        public Criteria andLast_alteredGreaterThan(Object value) {
            addCriterion("last_altered >", value, "last_altered");
            return (Criteria) this;
        }

        public Criteria andLast_alteredGreaterThanOrEqualTo(Object value) {
            addCriterion("last_altered >=", value, "last_altered");
            return (Criteria) this;
        }

        public Criteria andLast_alteredLessThan(Object value) {
            addCriterion("last_altered <", value, "last_altered");
            return (Criteria) this;
        }

        public Criteria andLast_alteredLessThanOrEqualTo(Object value) {
            addCriterion("last_altered <=", value, "last_altered");
            return (Criteria) this;
        }

        public Criteria andLast_alteredIn(List<Object> values) {
            addCriterion("last_altered in", values, "last_altered");
            return (Criteria) this;
        }

        public Criteria andLast_alteredNotIn(List<Object> values) {
            addCriterion("last_altered not in", values, "last_altered");
            return (Criteria) this;
        }

        public Criteria andLast_alteredBetween(Object value1, Object value2) {
            addCriterion("last_altered between", value1, value2, "last_altered");
            return (Criteria) this;
        }

        public Criteria andLast_alteredNotBetween(Object value1, Object value2) {
            addCriterion("last_altered not between", value1, value2, "last_altered");
            return (Criteria) this;
        }

        public Criteria andNew_savepoint_levelIsNull() {
            addCriterion("new_savepoint_level is null");
            return (Criteria) this;
        }

        public Criteria andNew_savepoint_levelIsNotNull() {
            addCriterion("new_savepoint_level is not null");
            return (Criteria) this;
        }

        public Criteria andNew_savepoint_levelEqualTo(Object value) {
            addCriterion("new_savepoint_level =", value, "new_savepoint_level");
            return (Criteria) this;
        }

        public Criteria andNew_savepoint_levelNotEqualTo(Object value) {
            addCriterion("new_savepoint_level <>", value, "new_savepoint_level");
            return (Criteria) this;
        }

        public Criteria andNew_savepoint_levelGreaterThan(Object value) {
            addCriterion("new_savepoint_level >", value, "new_savepoint_level");
            return (Criteria) this;
        }

        public Criteria andNew_savepoint_levelGreaterThanOrEqualTo(Object value) {
            addCriterion("new_savepoint_level >=", value, "new_savepoint_level");
            return (Criteria) this;
        }

        public Criteria andNew_savepoint_levelLessThan(Object value) {
            addCriterion("new_savepoint_level <", value, "new_savepoint_level");
            return (Criteria) this;
        }

        public Criteria andNew_savepoint_levelLessThanOrEqualTo(Object value) {
            addCriterion("new_savepoint_level <=", value, "new_savepoint_level");
            return (Criteria) this;
        }

        public Criteria andNew_savepoint_levelIn(List<Object> values) {
            addCriterion("new_savepoint_level in", values, "new_savepoint_level");
            return (Criteria) this;
        }

        public Criteria andNew_savepoint_levelNotIn(List<Object> values) {
            addCriterion("new_savepoint_level not in", values, "new_savepoint_level");
            return (Criteria) this;
        }

        public Criteria andNew_savepoint_levelBetween(Object value1, Object value2) {
            addCriterion("new_savepoint_level between", value1, value2, "new_savepoint_level");
            return (Criteria) this;
        }

        public Criteria andNew_savepoint_levelNotBetween(Object value1, Object value2) {
            addCriterion("new_savepoint_level not between", value1, value2, "new_savepoint_level");
            return (Criteria) this;
        }

        public Criteria andIs_udt_dependentIsNull() {
            addCriterion("is_udt_dependent is null");
            return (Criteria) this;
        }

        public Criteria andIs_udt_dependentIsNotNull() {
            addCriterion("is_udt_dependent is not null");
            return (Criteria) this;
        }

        public Criteria andIs_udt_dependentEqualTo(Object value) {
            addCriterion("is_udt_dependent =", value, "is_udt_dependent");
            return (Criteria) this;
        }

        public Criteria andIs_udt_dependentNotEqualTo(Object value) {
            addCriterion("is_udt_dependent <>", value, "is_udt_dependent");
            return (Criteria) this;
        }

        public Criteria andIs_udt_dependentGreaterThan(Object value) {
            addCriterion("is_udt_dependent >", value, "is_udt_dependent");
            return (Criteria) this;
        }

        public Criteria andIs_udt_dependentGreaterThanOrEqualTo(Object value) {
            addCriterion("is_udt_dependent >=", value, "is_udt_dependent");
            return (Criteria) this;
        }

        public Criteria andIs_udt_dependentLessThan(Object value) {
            addCriterion("is_udt_dependent <", value, "is_udt_dependent");
            return (Criteria) this;
        }

        public Criteria andIs_udt_dependentLessThanOrEqualTo(Object value) {
            addCriterion("is_udt_dependent <=", value, "is_udt_dependent");
            return (Criteria) this;
        }

        public Criteria andIs_udt_dependentIn(List<Object> values) {
            addCriterion("is_udt_dependent in", values, "is_udt_dependent");
            return (Criteria) this;
        }

        public Criteria andIs_udt_dependentNotIn(List<Object> values) {
            addCriterion("is_udt_dependent not in", values, "is_udt_dependent");
            return (Criteria) this;
        }

        public Criteria andIs_udt_dependentBetween(Object value1, Object value2) {
            addCriterion("is_udt_dependent between", value1, value2, "is_udt_dependent");
            return (Criteria) this;
        }

        public Criteria andIs_udt_dependentNotBetween(Object value1, Object value2) {
            addCriterion("is_udt_dependent not between", value1, value2, "is_udt_dependent");
            return (Criteria) this;
        }

        public Criteria andResult_cast_from_data_typeIsNull() {
            addCriterion("result_cast_from_data_type is null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_from_data_typeIsNotNull() {
            addCriterion("result_cast_from_data_type is not null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_from_data_typeEqualTo(Object value) {
            addCriterion("result_cast_from_data_type =", value, "result_cast_from_data_type");
            return (Criteria) this;
        }

        public Criteria andResult_cast_from_data_typeNotEqualTo(Object value) {
            addCriterion("result_cast_from_data_type <>", value, "result_cast_from_data_type");
            return (Criteria) this;
        }

        public Criteria andResult_cast_from_data_typeGreaterThan(Object value) {
            addCriterion("result_cast_from_data_type >", value, "result_cast_from_data_type");
            return (Criteria) this;
        }

        public Criteria andResult_cast_from_data_typeGreaterThanOrEqualTo(Object value) {
            addCriterion("result_cast_from_data_type >=", value, "result_cast_from_data_type");
            return (Criteria) this;
        }

        public Criteria andResult_cast_from_data_typeLessThan(Object value) {
            addCriterion("result_cast_from_data_type <", value, "result_cast_from_data_type");
            return (Criteria) this;
        }

        public Criteria andResult_cast_from_data_typeLessThanOrEqualTo(Object value) {
            addCriterion("result_cast_from_data_type <=", value, "result_cast_from_data_type");
            return (Criteria) this;
        }

        public Criteria andResult_cast_from_data_typeIn(List<Object> values) {
            addCriterion("result_cast_from_data_type in", values, "result_cast_from_data_type");
            return (Criteria) this;
        }

        public Criteria andResult_cast_from_data_typeNotIn(List<Object> values) {
            addCriterion("result_cast_from_data_type not in", values, "result_cast_from_data_type");
            return (Criteria) this;
        }

        public Criteria andResult_cast_from_data_typeBetween(Object value1, Object value2) {
            addCriterion("result_cast_from_data_type between", value1, value2, "result_cast_from_data_type");
            return (Criteria) this;
        }

        public Criteria andResult_cast_from_data_typeNotBetween(Object value1, Object value2) {
            addCriterion("result_cast_from_data_type not between", value1, value2, "result_cast_from_data_type");
            return (Criteria) this;
        }

        public Criteria andResult_cast_as_locatorIsNull() {
            addCriterion("result_cast_as_locator is null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_as_locatorIsNotNull() {
            addCriterion("result_cast_as_locator is not null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_as_locatorEqualTo(Object value) {
            addCriterion("result_cast_as_locator =", value, "result_cast_as_locator");
            return (Criteria) this;
        }

        public Criteria andResult_cast_as_locatorNotEqualTo(Object value) {
            addCriterion("result_cast_as_locator <>", value, "result_cast_as_locator");
            return (Criteria) this;
        }

        public Criteria andResult_cast_as_locatorGreaterThan(Object value) {
            addCriterion("result_cast_as_locator >", value, "result_cast_as_locator");
            return (Criteria) this;
        }

        public Criteria andResult_cast_as_locatorGreaterThanOrEqualTo(Object value) {
            addCriterion("result_cast_as_locator >=", value, "result_cast_as_locator");
            return (Criteria) this;
        }

        public Criteria andResult_cast_as_locatorLessThan(Object value) {
            addCriterion("result_cast_as_locator <", value, "result_cast_as_locator");
            return (Criteria) this;
        }

        public Criteria andResult_cast_as_locatorLessThanOrEqualTo(Object value) {
            addCriterion("result_cast_as_locator <=", value, "result_cast_as_locator");
            return (Criteria) this;
        }

        public Criteria andResult_cast_as_locatorIn(List<Object> values) {
            addCriterion("result_cast_as_locator in", values, "result_cast_as_locator");
            return (Criteria) this;
        }

        public Criteria andResult_cast_as_locatorNotIn(List<Object> values) {
            addCriterion("result_cast_as_locator not in", values, "result_cast_as_locator");
            return (Criteria) this;
        }

        public Criteria andResult_cast_as_locatorBetween(Object value1, Object value2) {
            addCriterion("result_cast_as_locator between", value1, value2, "result_cast_as_locator");
            return (Criteria) this;
        }

        public Criteria andResult_cast_as_locatorNotBetween(Object value1, Object value2) {
            addCriterion("result_cast_as_locator not between", value1, value2, "result_cast_as_locator");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_max_lengthIsNull() {
            addCriterion("result_cast_char_max_length is null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_max_lengthIsNotNull() {
            addCriterion("result_cast_char_max_length is not null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_max_lengthEqualTo(Object value) {
            addCriterion("result_cast_char_max_length =", value, "result_cast_char_max_length");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_max_lengthNotEqualTo(Object value) {
            addCriterion("result_cast_char_max_length <>", value, "result_cast_char_max_length");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_max_lengthGreaterThan(Object value) {
            addCriterion("result_cast_char_max_length >", value, "result_cast_char_max_length");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_max_lengthGreaterThanOrEqualTo(Object value) {
            addCriterion("result_cast_char_max_length >=", value, "result_cast_char_max_length");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_max_lengthLessThan(Object value) {
            addCriterion("result_cast_char_max_length <", value, "result_cast_char_max_length");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_max_lengthLessThanOrEqualTo(Object value) {
            addCriterion("result_cast_char_max_length <=", value, "result_cast_char_max_length");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_max_lengthIn(List<Object> values) {
            addCriterion("result_cast_char_max_length in", values, "result_cast_char_max_length");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_max_lengthNotIn(List<Object> values) {
            addCriterion("result_cast_char_max_length not in", values, "result_cast_char_max_length");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_max_lengthBetween(Object value1, Object value2) {
            addCriterion("result_cast_char_max_length between", value1, value2, "result_cast_char_max_length");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_max_lengthNotBetween(Object value1, Object value2) {
            addCriterion("result_cast_char_max_length not between", value1, value2, "result_cast_char_max_length");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_octet_lengthIsNull() {
            addCriterion("result_cast_char_octet_length is null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_octet_lengthIsNotNull() {
            addCriterion("result_cast_char_octet_length is not null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_octet_lengthEqualTo(Object value) {
            addCriterion("result_cast_char_octet_length =", value, "result_cast_char_octet_length");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_octet_lengthNotEqualTo(Object value) {
            addCriterion("result_cast_char_octet_length <>", value, "result_cast_char_octet_length");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_octet_lengthGreaterThan(Object value) {
            addCriterion("result_cast_char_octet_length >", value, "result_cast_char_octet_length");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_octet_lengthGreaterThanOrEqualTo(Object value) {
            addCriterion("result_cast_char_octet_length >=", value, "result_cast_char_octet_length");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_octet_lengthLessThan(Object value) {
            addCriterion("result_cast_char_octet_length <", value, "result_cast_char_octet_length");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_octet_lengthLessThanOrEqualTo(Object value) {
            addCriterion("result_cast_char_octet_length <=", value, "result_cast_char_octet_length");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_octet_lengthIn(List<Object> values) {
            addCriterion("result_cast_char_octet_length in", values, "result_cast_char_octet_length");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_octet_lengthNotIn(List<Object> values) {
            addCriterion("result_cast_char_octet_length not in", values, "result_cast_char_octet_length");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_octet_lengthBetween(Object value1, Object value2) {
            addCriterion("result_cast_char_octet_length between", value1, value2, "result_cast_char_octet_length");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_octet_lengthNotBetween(Object value1, Object value2) {
            addCriterion("result_cast_char_octet_length not between", value1, value2, "result_cast_char_octet_length");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_set_catalogIsNull() {
            addCriterion("result_cast_char_set_catalog is null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_set_catalogIsNotNull() {
            addCriterion("result_cast_char_set_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_set_catalogEqualTo(Object value) {
            addCriterion("result_cast_char_set_catalog =", value, "result_cast_char_set_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_set_catalogNotEqualTo(Object value) {
            addCriterion("result_cast_char_set_catalog <>", value, "result_cast_char_set_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_set_catalogGreaterThan(Object value) {
            addCriterion("result_cast_char_set_catalog >", value, "result_cast_char_set_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_set_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("result_cast_char_set_catalog >=", value, "result_cast_char_set_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_set_catalogLessThan(Object value) {
            addCriterion("result_cast_char_set_catalog <", value, "result_cast_char_set_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_set_catalogLessThanOrEqualTo(Object value) {
            addCriterion("result_cast_char_set_catalog <=", value, "result_cast_char_set_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_set_catalogIn(List<Object> values) {
            addCriterion("result_cast_char_set_catalog in", values, "result_cast_char_set_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_set_catalogNotIn(List<Object> values) {
            addCriterion("result_cast_char_set_catalog not in", values, "result_cast_char_set_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_set_catalogBetween(Object value1, Object value2) {
            addCriterion("result_cast_char_set_catalog between", value1, value2, "result_cast_char_set_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_set_catalogNotBetween(Object value1, Object value2) {
            addCriterion("result_cast_char_set_catalog not between", value1, value2, "result_cast_char_set_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_set_schemaIsNull() {
            addCriterion("result_cast_char_set_schema is null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_set_schemaIsNotNull() {
            addCriterion("result_cast_char_set_schema is not null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_set_schemaEqualTo(Object value) {
            addCriterion("result_cast_char_set_schema =", value, "result_cast_char_set_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_set_schemaNotEqualTo(Object value) {
            addCriterion("result_cast_char_set_schema <>", value, "result_cast_char_set_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_set_schemaGreaterThan(Object value) {
            addCriterion("result_cast_char_set_schema >", value, "result_cast_char_set_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_set_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("result_cast_char_set_schema >=", value, "result_cast_char_set_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_set_schemaLessThan(Object value) {
            addCriterion("result_cast_char_set_schema <", value, "result_cast_char_set_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_set_schemaLessThanOrEqualTo(Object value) {
            addCriterion("result_cast_char_set_schema <=", value, "result_cast_char_set_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_set_schemaIn(List<Object> values) {
            addCriterion("result_cast_char_set_schema in", values, "result_cast_char_set_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_set_schemaNotIn(List<Object> values) {
            addCriterion("result_cast_char_set_schema not in", values, "result_cast_char_set_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_set_schemaBetween(Object value1, Object value2) {
            addCriterion("result_cast_char_set_schema between", value1, value2, "result_cast_char_set_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_char_set_schemaNotBetween(Object value1, Object value2) {
            addCriterion("result_cast_char_set_schema not between", value1, value2, "result_cast_char_set_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_character_set_nameIsNull() {
            addCriterion("result_cast_character_set_name is null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_character_set_nameIsNotNull() {
            addCriterion("result_cast_character_set_name is not null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_character_set_nameEqualTo(Object value) {
            addCriterion("result_cast_character_set_name =", value, "result_cast_character_set_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_character_set_nameNotEqualTo(Object value) {
            addCriterion("result_cast_character_set_name <>", value, "result_cast_character_set_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_character_set_nameGreaterThan(Object value) {
            addCriterion("result_cast_character_set_name >", value, "result_cast_character_set_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_character_set_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("result_cast_character_set_name >=", value, "result_cast_character_set_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_character_set_nameLessThan(Object value) {
            addCriterion("result_cast_character_set_name <", value, "result_cast_character_set_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_character_set_nameLessThanOrEqualTo(Object value) {
            addCriterion("result_cast_character_set_name <=", value, "result_cast_character_set_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_character_set_nameIn(List<Object> values) {
            addCriterion("result_cast_character_set_name in", values, "result_cast_character_set_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_character_set_nameNotIn(List<Object> values) {
            addCriterion("result_cast_character_set_name not in", values, "result_cast_character_set_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_character_set_nameBetween(Object value1, Object value2) {
            addCriterion("result_cast_character_set_name between", value1, value2, "result_cast_character_set_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_character_set_nameNotBetween(Object value1, Object value2) {
            addCriterion("result_cast_character_set_name not between", value1, value2, "result_cast_character_set_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_catalogIsNull() {
            addCriterion("result_cast_collation_catalog is null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_catalogIsNotNull() {
            addCriterion("result_cast_collation_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_catalogEqualTo(Object value) {
            addCriterion("result_cast_collation_catalog =", value, "result_cast_collation_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_catalogNotEqualTo(Object value) {
            addCriterion("result_cast_collation_catalog <>", value, "result_cast_collation_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_catalogGreaterThan(Object value) {
            addCriterion("result_cast_collation_catalog >", value, "result_cast_collation_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("result_cast_collation_catalog >=", value, "result_cast_collation_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_catalogLessThan(Object value) {
            addCriterion("result_cast_collation_catalog <", value, "result_cast_collation_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_catalogLessThanOrEqualTo(Object value) {
            addCriterion("result_cast_collation_catalog <=", value, "result_cast_collation_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_catalogIn(List<Object> values) {
            addCriterion("result_cast_collation_catalog in", values, "result_cast_collation_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_catalogNotIn(List<Object> values) {
            addCriterion("result_cast_collation_catalog not in", values, "result_cast_collation_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_catalogBetween(Object value1, Object value2) {
            addCriterion("result_cast_collation_catalog between", value1, value2, "result_cast_collation_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_catalogNotBetween(Object value1, Object value2) {
            addCriterion("result_cast_collation_catalog not between", value1, value2, "result_cast_collation_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_schemaIsNull() {
            addCriterion("result_cast_collation_schema is null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_schemaIsNotNull() {
            addCriterion("result_cast_collation_schema is not null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_schemaEqualTo(Object value) {
            addCriterion("result_cast_collation_schema =", value, "result_cast_collation_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_schemaNotEqualTo(Object value) {
            addCriterion("result_cast_collation_schema <>", value, "result_cast_collation_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_schemaGreaterThan(Object value) {
            addCriterion("result_cast_collation_schema >", value, "result_cast_collation_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("result_cast_collation_schema >=", value, "result_cast_collation_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_schemaLessThan(Object value) {
            addCriterion("result_cast_collation_schema <", value, "result_cast_collation_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_schemaLessThanOrEqualTo(Object value) {
            addCriterion("result_cast_collation_schema <=", value, "result_cast_collation_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_schemaIn(List<Object> values) {
            addCriterion("result_cast_collation_schema in", values, "result_cast_collation_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_schemaNotIn(List<Object> values) {
            addCriterion("result_cast_collation_schema not in", values, "result_cast_collation_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_schemaBetween(Object value1, Object value2) {
            addCriterion("result_cast_collation_schema between", value1, value2, "result_cast_collation_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_schemaNotBetween(Object value1, Object value2) {
            addCriterion("result_cast_collation_schema not between", value1, value2, "result_cast_collation_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_nameIsNull() {
            addCriterion("result_cast_collation_name is null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_nameIsNotNull() {
            addCriterion("result_cast_collation_name is not null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_nameEqualTo(Object value) {
            addCriterion("result_cast_collation_name =", value, "result_cast_collation_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_nameNotEqualTo(Object value) {
            addCriterion("result_cast_collation_name <>", value, "result_cast_collation_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_nameGreaterThan(Object value) {
            addCriterion("result_cast_collation_name >", value, "result_cast_collation_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("result_cast_collation_name >=", value, "result_cast_collation_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_nameLessThan(Object value) {
            addCriterion("result_cast_collation_name <", value, "result_cast_collation_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_nameLessThanOrEqualTo(Object value) {
            addCriterion("result_cast_collation_name <=", value, "result_cast_collation_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_nameIn(List<Object> values) {
            addCriterion("result_cast_collation_name in", values, "result_cast_collation_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_nameNotIn(List<Object> values) {
            addCriterion("result_cast_collation_name not in", values, "result_cast_collation_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_nameBetween(Object value1, Object value2) {
            addCriterion("result_cast_collation_name between", value1, value2, "result_cast_collation_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_collation_nameNotBetween(Object value1, Object value2) {
            addCriterion("result_cast_collation_name not between", value1, value2, "result_cast_collation_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_precisionIsNull() {
            addCriterion("result_cast_numeric_precision is null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_precisionIsNotNull() {
            addCriterion("result_cast_numeric_precision is not null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_precisionEqualTo(Object value) {
            addCriterion("result_cast_numeric_precision =", value, "result_cast_numeric_precision");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_precisionNotEqualTo(Object value) {
            addCriterion("result_cast_numeric_precision <>", value, "result_cast_numeric_precision");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_precisionGreaterThan(Object value) {
            addCriterion("result_cast_numeric_precision >", value, "result_cast_numeric_precision");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_precisionGreaterThanOrEqualTo(Object value) {
            addCriterion("result_cast_numeric_precision >=", value, "result_cast_numeric_precision");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_precisionLessThan(Object value) {
            addCriterion("result_cast_numeric_precision <", value, "result_cast_numeric_precision");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_precisionLessThanOrEqualTo(Object value) {
            addCriterion("result_cast_numeric_precision <=", value, "result_cast_numeric_precision");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_precisionIn(List<Object> values) {
            addCriterion("result_cast_numeric_precision in", values, "result_cast_numeric_precision");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_precisionNotIn(List<Object> values) {
            addCriterion("result_cast_numeric_precision not in", values, "result_cast_numeric_precision");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_precisionBetween(Object value1, Object value2) {
            addCriterion("result_cast_numeric_precision between", value1, value2, "result_cast_numeric_precision");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_precisionNotBetween(Object value1, Object value2) {
            addCriterion("result_cast_numeric_precision not between", value1, value2, "result_cast_numeric_precision");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_precision_radixIsNull() {
            addCriterion("result_cast_numeric_precision_radix is null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_precision_radixIsNotNull() {
            addCriterion("result_cast_numeric_precision_radix is not null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_precision_radixEqualTo(Object value) {
            addCriterion("result_cast_numeric_precision_radix =", value, "result_cast_numeric_precision_radix");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_precision_radixNotEqualTo(Object value) {
            addCriterion("result_cast_numeric_precision_radix <>", value, "result_cast_numeric_precision_radix");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_precision_radixGreaterThan(Object value) {
            addCriterion("result_cast_numeric_precision_radix >", value, "result_cast_numeric_precision_radix");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_precision_radixGreaterThanOrEqualTo(Object value) {
            addCriterion("result_cast_numeric_precision_radix >=", value, "result_cast_numeric_precision_radix");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_precision_radixLessThan(Object value) {
            addCriterion("result_cast_numeric_precision_radix <", value, "result_cast_numeric_precision_radix");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_precision_radixLessThanOrEqualTo(Object value) {
            addCriterion("result_cast_numeric_precision_radix <=", value, "result_cast_numeric_precision_radix");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_precision_radixIn(List<Object> values) {
            addCriterion("result_cast_numeric_precision_radix in", values, "result_cast_numeric_precision_radix");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_precision_radixNotIn(List<Object> values) {
            addCriterion("result_cast_numeric_precision_radix not in", values, "result_cast_numeric_precision_radix");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_precision_radixBetween(Object value1, Object value2) {
            addCriterion("result_cast_numeric_precision_radix between", value1, value2, "result_cast_numeric_precision_radix");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_precision_radixNotBetween(Object value1, Object value2) {
            addCriterion("result_cast_numeric_precision_radix not between", value1, value2, "result_cast_numeric_precision_radix");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_scaleIsNull() {
            addCriterion("result_cast_numeric_scale is null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_scaleIsNotNull() {
            addCriterion("result_cast_numeric_scale is not null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_scaleEqualTo(Object value) {
            addCriterion("result_cast_numeric_scale =", value, "result_cast_numeric_scale");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_scaleNotEqualTo(Object value) {
            addCriterion("result_cast_numeric_scale <>", value, "result_cast_numeric_scale");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_scaleGreaterThan(Object value) {
            addCriterion("result_cast_numeric_scale >", value, "result_cast_numeric_scale");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_scaleGreaterThanOrEqualTo(Object value) {
            addCriterion("result_cast_numeric_scale >=", value, "result_cast_numeric_scale");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_scaleLessThan(Object value) {
            addCriterion("result_cast_numeric_scale <", value, "result_cast_numeric_scale");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_scaleLessThanOrEqualTo(Object value) {
            addCriterion("result_cast_numeric_scale <=", value, "result_cast_numeric_scale");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_scaleIn(List<Object> values) {
            addCriterion("result_cast_numeric_scale in", values, "result_cast_numeric_scale");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_scaleNotIn(List<Object> values) {
            addCriterion("result_cast_numeric_scale not in", values, "result_cast_numeric_scale");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_scaleBetween(Object value1, Object value2) {
            addCriterion("result_cast_numeric_scale between", value1, value2, "result_cast_numeric_scale");
            return (Criteria) this;
        }

        public Criteria andResult_cast_numeric_scaleNotBetween(Object value1, Object value2) {
            addCriterion("result_cast_numeric_scale not between", value1, value2, "result_cast_numeric_scale");
            return (Criteria) this;
        }

        public Criteria andResult_cast_datetime_precisionIsNull() {
            addCriterion("result_cast_datetime_precision is null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_datetime_precisionIsNotNull() {
            addCriterion("result_cast_datetime_precision is not null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_datetime_precisionEqualTo(Object value) {
            addCriterion("result_cast_datetime_precision =", value, "result_cast_datetime_precision");
            return (Criteria) this;
        }

        public Criteria andResult_cast_datetime_precisionNotEqualTo(Object value) {
            addCriterion("result_cast_datetime_precision <>", value, "result_cast_datetime_precision");
            return (Criteria) this;
        }

        public Criteria andResult_cast_datetime_precisionGreaterThan(Object value) {
            addCriterion("result_cast_datetime_precision >", value, "result_cast_datetime_precision");
            return (Criteria) this;
        }

        public Criteria andResult_cast_datetime_precisionGreaterThanOrEqualTo(Object value) {
            addCriterion("result_cast_datetime_precision >=", value, "result_cast_datetime_precision");
            return (Criteria) this;
        }

        public Criteria andResult_cast_datetime_precisionLessThan(Object value) {
            addCriterion("result_cast_datetime_precision <", value, "result_cast_datetime_precision");
            return (Criteria) this;
        }

        public Criteria andResult_cast_datetime_precisionLessThanOrEqualTo(Object value) {
            addCriterion("result_cast_datetime_precision <=", value, "result_cast_datetime_precision");
            return (Criteria) this;
        }

        public Criteria andResult_cast_datetime_precisionIn(List<Object> values) {
            addCriterion("result_cast_datetime_precision in", values, "result_cast_datetime_precision");
            return (Criteria) this;
        }

        public Criteria andResult_cast_datetime_precisionNotIn(List<Object> values) {
            addCriterion("result_cast_datetime_precision not in", values, "result_cast_datetime_precision");
            return (Criteria) this;
        }

        public Criteria andResult_cast_datetime_precisionBetween(Object value1, Object value2) {
            addCriterion("result_cast_datetime_precision between", value1, value2, "result_cast_datetime_precision");
            return (Criteria) this;
        }

        public Criteria andResult_cast_datetime_precisionNotBetween(Object value1, Object value2) {
            addCriterion("result_cast_datetime_precision not between", value1, value2, "result_cast_datetime_precision");
            return (Criteria) this;
        }

        public Criteria andResult_cast_interval_typeIsNull() {
            addCriterion("result_cast_interval_type is null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_interval_typeIsNotNull() {
            addCriterion("result_cast_interval_type is not null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_interval_typeEqualTo(Object value) {
            addCriterion("result_cast_interval_type =", value, "result_cast_interval_type");
            return (Criteria) this;
        }

        public Criteria andResult_cast_interval_typeNotEqualTo(Object value) {
            addCriterion("result_cast_interval_type <>", value, "result_cast_interval_type");
            return (Criteria) this;
        }

        public Criteria andResult_cast_interval_typeGreaterThan(Object value) {
            addCriterion("result_cast_interval_type >", value, "result_cast_interval_type");
            return (Criteria) this;
        }

        public Criteria andResult_cast_interval_typeGreaterThanOrEqualTo(Object value) {
            addCriterion("result_cast_interval_type >=", value, "result_cast_interval_type");
            return (Criteria) this;
        }

        public Criteria andResult_cast_interval_typeLessThan(Object value) {
            addCriterion("result_cast_interval_type <", value, "result_cast_interval_type");
            return (Criteria) this;
        }

        public Criteria andResult_cast_interval_typeLessThanOrEqualTo(Object value) {
            addCriterion("result_cast_interval_type <=", value, "result_cast_interval_type");
            return (Criteria) this;
        }

        public Criteria andResult_cast_interval_typeIn(List<Object> values) {
            addCriterion("result_cast_interval_type in", values, "result_cast_interval_type");
            return (Criteria) this;
        }

        public Criteria andResult_cast_interval_typeNotIn(List<Object> values) {
            addCriterion("result_cast_interval_type not in", values, "result_cast_interval_type");
            return (Criteria) this;
        }

        public Criteria andResult_cast_interval_typeBetween(Object value1, Object value2) {
            addCriterion("result_cast_interval_type between", value1, value2, "result_cast_interval_type");
            return (Criteria) this;
        }

        public Criteria andResult_cast_interval_typeNotBetween(Object value1, Object value2) {
            addCriterion("result_cast_interval_type not between", value1, value2, "result_cast_interval_type");
            return (Criteria) this;
        }

        public Criteria andResult_cast_interval_precisionIsNull() {
            addCriterion("result_cast_interval_precision is null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_interval_precisionIsNotNull() {
            addCriterion("result_cast_interval_precision is not null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_interval_precisionEqualTo(Object value) {
            addCriterion("result_cast_interval_precision =", value, "result_cast_interval_precision");
            return (Criteria) this;
        }

        public Criteria andResult_cast_interval_precisionNotEqualTo(Object value) {
            addCriterion("result_cast_interval_precision <>", value, "result_cast_interval_precision");
            return (Criteria) this;
        }

        public Criteria andResult_cast_interval_precisionGreaterThan(Object value) {
            addCriterion("result_cast_interval_precision >", value, "result_cast_interval_precision");
            return (Criteria) this;
        }

        public Criteria andResult_cast_interval_precisionGreaterThanOrEqualTo(Object value) {
            addCriterion("result_cast_interval_precision >=", value, "result_cast_interval_precision");
            return (Criteria) this;
        }

        public Criteria andResult_cast_interval_precisionLessThan(Object value) {
            addCriterion("result_cast_interval_precision <", value, "result_cast_interval_precision");
            return (Criteria) this;
        }

        public Criteria andResult_cast_interval_precisionLessThanOrEqualTo(Object value) {
            addCriterion("result_cast_interval_precision <=", value, "result_cast_interval_precision");
            return (Criteria) this;
        }

        public Criteria andResult_cast_interval_precisionIn(List<Object> values) {
            addCriterion("result_cast_interval_precision in", values, "result_cast_interval_precision");
            return (Criteria) this;
        }

        public Criteria andResult_cast_interval_precisionNotIn(List<Object> values) {
            addCriterion("result_cast_interval_precision not in", values, "result_cast_interval_precision");
            return (Criteria) this;
        }

        public Criteria andResult_cast_interval_precisionBetween(Object value1, Object value2) {
            addCriterion("result_cast_interval_precision between", value1, value2, "result_cast_interval_precision");
            return (Criteria) this;
        }

        public Criteria andResult_cast_interval_precisionNotBetween(Object value1, Object value2) {
            addCriterion("result_cast_interval_precision not between", value1, value2, "result_cast_interval_precision");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_catalogIsNull() {
            addCriterion("result_cast_type_udt_catalog is null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_catalogIsNotNull() {
            addCriterion("result_cast_type_udt_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_catalogEqualTo(Object value) {
            addCriterion("result_cast_type_udt_catalog =", value, "result_cast_type_udt_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_catalogNotEqualTo(Object value) {
            addCriterion("result_cast_type_udt_catalog <>", value, "result_cast_type_udt_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_catalogGreaterThan(Object value) {
            addCriterion("result_cast_type_udt_catalog >", value, "result_cast_type_udt_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("result_cast_type_udt_catalog >=", value, "result_cast_type_udt_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_catalogLessThan(Object value) {
            addCriterion("result_cast_type_udt_catalog <", value, "result_cast_type_udt_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_catalogLessThanOrEqualTo(Object value) {
            addCriterion("result_cast_type_udt_catalog <=", value, "result_cast_type_udt_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_catalogIn(List<Object> values) {
            addCriterion("result_cast_type_udt_catalog in", values, "result_cast_type_udt_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_catalogNotIn(List<Object> values) {
            addCriterion("result_cast_type_udt_catalog not in", values, "result_cast_type_udt_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_catalogBetween(Object value1, Object value2) {
            addCriterion("result_cast_type_udt_catalog between", value1, value2, "result_cast_type_udt_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_catalogNotBetween(Object value1, Object value2) {
            addCriterion("result_cast_type_udt_catalog not between", value1, value2, "result_cast_type_udt_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_schemaIsNull() {
            addCriterion("result_cast_type_udt_schema is null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_schemaIsNotNull() {
            addCriterion("result_cast_type_udt_schema is not null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_schemaEqualTo(Object value) {
            addCriterion("result_cast_type_udt_schema =", value, "result_cast_type_udt_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_schemaNotEqualTo(Object value) {
            addCriterion("result_cast_type_udt_schema <>", value, "result_cast_type_udt_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_schemaGreaterThan(Object value) {
            addCriterion("result_cast_type_udt_schema >", value, "result_cast_type_udt_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("result_cast_type_udt_schema >=", value, "result_cast_type_udt_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_schemaLessThan(Object value) {
            addCriterion("result_cast_type_udt_schema <", value, "result_cast_type_udt_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_schemaLessThanOrEqualTo(Object value) {
            addCriterion("result_cast_type_udt_schema <=", value, "result_cast_type_udt_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_schemaIn(List<Object> values) {
            addCriterion("result_cast_type_udt_schema in", values, "result_cast_type_udt_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_schemaNotIn(List<Object> values) {
            addCriterion("result_cast_type_udt_schema not in", values, "result_cast_type_udt_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_schemaBetween(Object value1, Object value2) {
            addCriterion("result_cast_type_udt_schema between", value1, value2, "result_cast_type_udt_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_schemaNotBetween(Object value1, Object value2) {
            addCriterion("result_cast_type_udt_schema not between", value1, value2, "result_cast_type_udt_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_nameIsNull() {
            addCriterion("result_cast_type_udt_name is null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_nameIsNotNull() {
            addCriterion("result_cast_type_udt_name is not null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_nameEqualTo(Object value) {
            addCriterion("result_cast_type_udt_name =", value, "result_cast_type_udt_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_nameNotEqualTo(Object value) {
            addCriterion("result_cast_type_udt_name <>", value, "result_cast_type_udt_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_nameGreaterThan(Object value) {
            addCriterion("result_cast_type_udt_name >", value, "result_cast_type_udt_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("result_cast_type_udt_name >=", value, "result_cast_type_udt_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_nameLessThan(Object value) {
            addCriterion("result_cast_type_udt_name <", value, "result_cast_type_udt_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_nameLessThanOrEqualTo(Object value) {
            addCriterion("result_cast_type_udt_name <=", value, "result_cast_type_udt_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_nameIn(List<Object> values) {
            addCriterion("result_cast_type_udt_name in", values, "result_cast_type_udt_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_nameNotIn(List<Object> values) {
            addCriterion("result_cast_type_udt_name not in", values, "result_cast_type_udt_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_nameBetween(Object value1, Object value2) {
            addCriterion("result_cast_type_udt_name between", value1, value2, "result_cast_type_udt_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_type_udt_nameNotBetween(Object value1, Object value2) {
            addCriterion("result_cast_type_udt_name not between", value1, value2, "result_cast_type_udt_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_catalogIsNull() {
            addCriterion("result_cast_scope_catalog is null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_catalogIsNotNull() {
            addCriterion("result_cast_scope_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_catalogEqualTo(Object value) {
            addCriterion("result_cast_scope_catalog =", value, "result_cast_scope_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_catalogNotEqualTo(Object value) {
            addCriterion("result_cast_scope_catalog <>", value, "result_cast_scope_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_catalogGreaterThan(Object value) {
            addCriterion("result_cast_scope_catalog >", value, "result_cast_scope_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("result_cast_scope_catalog >=", value, "result_cast_scope_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_catalogLessThan(Object value) {
            addCriterion("result_cast_scope_catalog <", value, "result_cast_scope_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_catalogLessThanOrEqualTo(Object value) {
            addCriterion("result_cast_scope_catalog <=", value, "result_cast_scope_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_catalogIn(List<Object> values) {
            addCriterion("result_cast_scope_catalog in", values, "result_cast_scope_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_catalogNotIn(List<Object> values) {
            addCriterion("result_cast_scope_catalog not in", values, "result_cast_scope_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_catalogBetween(Object value1, Object value2) {
            addCriterion("result_cast_scope_catalog between", value1, value2, "result_cast_scope_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_catalogNotBetween(Object value1, Object value2) {
            addCriterion("result_cast_scope_catalog not between", value1, value2, "result_cast_scope_catalog");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_schemaIsNull() {
            addCriterion("result_cast_scope_schema is null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_schemaIsNotNull() {
            addCriterion("result_cast_scope_schema is not null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_schemaEqualTo(Object value) {
            addCriterion("result_cast_scope_schema =", value, "result_cast_scope_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_schemaNotEqualTo(Object value) {
            addCriterion("result_cast_scope_schema <>", value, "result_cast_scope_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_schemaGreaterThan(Object value) {
            addCriterion("result_cast_scope_schema >", value, "result_cast_scope_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("result_cast_scope_schema >=", value, "result_cast_scope_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_schemaLessThan(Object value) {
            addCriterion("result_cast_scope_schema <", value, "result_cast_scope_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_schemaLessThanOrEqualTo(Object value) {
            addCriterion("result_cast_scope_schema <=", value, "result_cast_scope_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_schemaIn(List<Object> values) {
            addCriterion("result_cast_scope_schema in", values, "result_cast_scope_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_schemaNotIn(List<Object> values) {
            addCriterion("result_cast_scope_schema not in", values, "result_cast_scope_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_schemaBetween(Object value1, Object value2) {
            addCriterion("result_cast_scope_schema between", value1, value2, "result_cast_scope_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_schemaNotBetween(Object value1, Object value2) {
            addCriterion("result_cast_scope_schema not between", value1, value2, "result_cast_scope_schema");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_nameIsNull() {
            addCriterion("result_cast_scope_name is null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_nameIsNotNull() {
            addCriterion("result_cast_scope_name is not null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_nameEqualTo(Object value) {
            addCriterion("result_cast_scope_name =", value, "result_cast_scope_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_nameNotEqualTo(Object value) {
            addCriterion("result_cast_scope_name <>", value, "result_cast_scope_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_nameGreaterThan(Object value) {
            addCriterion("result_cast_scope_name >", value, "result_cast_scope_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("result_cast_scope_name >=", value, "result_cast_scope_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_nameLessThan(Object value) {
            addCriterion("result_cast_scope_name <", value, "result_cast_scope_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_nameLessThanOrEqualTo(Object value) {
            addCriterion("result_cast_scope_name <=", value, "result_cast_scope_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_nameIn(List<Object> values) {
            addCriterion("result_cast_scope_name in", values, "result_cast_scope_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_nameNotIn(List<Object> values) {
            addCriterion("result_cast_scope_name not in", values, "result_cast_scope_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_nameBetween(Object value1, Object value2) {
            addCriterion("result_cast_scope_name between", value1, value2, "result_cast_scope_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_scope_nameNotBetween(Object value1, Object value2) {
            addCriterion("result_cast_scope_name not between", value1, value2, "result_cast_scope_name");
            return (Criteria) this;
        }

        public Criteria andResult_cast_maximum_cardinalityIsNull() {
            addCriterion("result_cast_maximum_cardinality is null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_maximum_cardinalityIsNotNull() {
            addCriterion("result_cast_maximum_cardinality is not null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_maximum_cardinalityEqualTo(Object value) {
            addCriterion("result_cast_maximum_cardinality =", value, "result_cast_maximum_cardinality");
            return (Criteria) this;
        }

        public Criteria andResult_cast_maximum_cardinalityNotEqualTo(Object value) {
            addCriterion("result_cast_maximum_cardinality <>", value, "result_cast_maximum_cardinality");
            return (Criteria) this;
        }

        public Criteria andResult_cast_maximum_cardinalityGreaterThan(Object value) {
            addCriterion("result_cast_maximum_cardinality >", value, "result_cast_maximum_cardinality");
            return (Criteria) this;
        }

        public Criteria andResult_cast_maximum_cardinalityGreaterThanOrEqualTo(Object value) {
            addCriterion("result_cast_maximum_cardinality >=", value, "result_cast_maximum_cardinality");
            return (Criteria) this;
        }

        public Criteria andResult_cast_maximum_cardinalityLessThan(Object value) {
            addCriterion("result_cast_maximum_cardinality <", value, "result_cast_maximum_cardinality");
            return (Criteria) this;
        }

        public Criteria andResult_cast_maximum_cardinalityLessThanOrEqualTo(Object value) {
            addCriterion("result_cast_maximum_cardinality <=", value, "result_cast_maximum_cardinality");
            return (Criteria) this;
        }

        public Criteria andResult_cast_maximum_cardinalityIn(List<Object> values) {
            addCriterion("result_cast_maximum_cardinality in", values, "result_cast_maximum_cardinality");
            return (Criteria) this;
        }

        public Criteria andResult_cast_maximum_cardinalityNotIn(List<Object> values) {
            addCriterion("result_cast_maximum_cardinality not in", values, "result_cast_maximum_cardinality");
            return (Criteria) this;
        }

        public Criteria andResult_cast_maximum_cardinalityBetween(Object value1, Object value2) {
            addCriterion("result_cast_maximum_cardinality between", value1, value2, "result_cast_maximum_cardinality");
            return (Criteria) this;
        }

        public Criteria andResult_cast_maximum_cardinalityNotBetween(Object value1, Object value2) {
            addCriterion("result_cast_maximum_cardinality not between", value1, value2, "result_cast_maximum_cardinality");
            return (Criteria) this;
        }

        public Criteria andResult_cast_dtd_identifierIsNull() {
            addCriterion("result_cast_dtd_identifier is null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_dtd_identifierIsNotNull() {
            addCriterion("result_cast_dtd_identifier is not null");
            return (Criteria) this;
        }

        public Criteria andResult_cast_dtd_identifierEqualTo(Object value) {
            addCriterion("result_cast_dtd_identifier =", value, "result_cast_dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andResult_cast_dtd_identifierNotEqualTo(Object value) {
            addCriterion("result_cast_dtd_identifier <>", value, "result_cast_dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andResult_cast_dtd_identifierGreaterThan(Object value) {
            addCriterion("result_cast_dtd_identifier >", value, "result_cast_dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andResult_cast_dtd_identifierGreaterThanOrEqualTo(Object value) {
            addCriterion("result_cast_dtd_identifier >=", value, "result_cast_dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andResult_cast_dtd_identifierLessThan(Object value) {
            addCriterion("result_cast_dtd_identifier <", value, "result_cast_dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andResult_cast_dtd_identifierLessThanOrEqualTo(Object value) {
            addCriterion("result_cast_dtd_identifier <=", value, "result_cast_dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andResult_cast_dtd_identifierIn(List<Object> values) {
            addCriterion("result_cast_dtd_identifier in", values, "result_cast_dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andResult_cast_dtd_identifierNotIn(List<Object> values) {
            addCriterion("result_cast_dtd_identifier not in", values, "result_cast_dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andResult_cast_dtd_identifierBetween(Object value1, Object value2) {
            addCriterion("result_cast_dtd_identifier between", value1, value2, "result_cast_dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andResult_cast_dtd_identifierNotBetween(Object value1, Object value2) {
            addCriterion("result_cast_dtd_identifier not between", value1, value2, "result_cast_dtd_identifier");
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