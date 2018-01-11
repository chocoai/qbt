package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class UserDefinedTypesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserDefinedTypesExample() {
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

        public Criteria andUser_defined_type_catalogIsNull() {
            addCriterion("user_defined_type_catalog is null");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_catalogIsNotNull() {
            addCriterion("user_defined_type_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_catalogEqualTo(Object value) {
            addCriterion("user_defined_type_catalog =", value, "user_defined_type_catalog");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_catalogNotEqualTo(Object value) {
            addCriterion("user_defined_type_catalog <>", value, "user_defined_type_catalog");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_catalogGreaterThan(Object value) {
            addCriterion("user_defined_type_catalog >", value, "user_defined_type_catalog");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("user_defined_type_catalog >=", value, "user_defined_type_catalog");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_catalogLessThan(Object value) {
            addCriterion("user_defined_type_catalog <", value, "user_defined_type_catalog");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_catalogLessThanOrEqualTo(Object value) {
            addCriterion("user_defined_type_catalog <=", value, "user_defined_type_catalog");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_catalogIn(List<Object> values) {
            addCriterion("user_defined_type_catalog in", values, "user_defined_type_catalog");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_catalogNotIn(List<Object> values) {
            addCriterion("user_defined_type_catalog not in", values, "user_defined_type_catalog");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_catalogBetween(Object value1, Object value2) {
            addCriterion("user_defined_type_catalog between", value1, value2, "user_defined_type_catalog");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_catalogNotBetween(Object value1, Object value2) {
            addCriterion("user_defined_type_catalog not between", value1, value2, "user_defined_type_catalog");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_schemaIsNull() {
            addCriterion("user_defined_type_schema is null");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_schemaIsNotNull() {
            addCriterion("user_defined_type_schema is not null");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_schemaEqualTo(Object value) {
            addCriterion("user_defined_type_schema =", value, "user_defined_type_schema");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_schemaNotEqualTo(Object value) {
            addCriterion("user_defined_type_schema <>", value, "user_defined_type_schema");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_schemaGreaterThan(Object value) {
            addCriterion("user_defined_type_schema >", value, "user_defined_type_schema");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("user_defined_type_schema >=", value, "user_defined_type_schema");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_schemaLessThan(Object value) {
            addCriterion("user_defined_type_schema <", value, "user_defined_type_schema");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_schemaLessThanOrEqualTo(Object value) {
            addCriterion("user_defined_type_schema <=", value, "user_defined_type_schema");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_schemaIn(List<Object> values) {
            addCriterion("user_defined_type_schema in", values, "user_defined_type_schema");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_schemaNotIn(List<Object> values) {
            addCriterion("user_defined_type_schema not in", values, "user_defined_type_schema");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_schemaBetween(Object value1, Object value2) {
            addCriterion("user_defined_type_schema between", value1, value2, "user_defined_type_schema");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_schemaNotBetween(Object value1, Object value2) {
            addCriterion("user_defined_type_schema not between", value1, value2, "user_defined_type_schema");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_nameIsNull() {
            addCriterion("user_defined_type_name is null");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_nameIsNotNull() {
            addCriterion("user_defined_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_nameEqualTo(Object value) {
            addCriterion("user_defined_type_name =", value, "user_defined_type_name");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_nameNotEqualTo(Object value) {
            addCriterion("user_defined_type_name <>", value, "user_defined_type_name");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_nameGreaterThan(Object value) {
            addCriterion("user_defined_type_name >", value, "user_defined_type_name");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("user_defined_type_name >=", value, "user_defined_type_name");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_nameLessThan(Object value) {
            addCriterion("user_defined_type_name <", value, "user_defined_type_name");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_nameLessThanOrEqualTo(Object value) {
            addCriterion("user_defined_type_name <=", value, "user_defined_type_name");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_nameIn(List<Object> values) {
            addCriterion("user_defined_type_name in", values, "user_defined_type_name");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_nameNotIn(List<Object> values) {
            addCriterion("user_defined_type_name not in", values, "user_defined_type_name");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_nameBetween(Object value1, Object value2) {
            addCriterion("user_defined_type_name between", value1, value2, "user_defined_type_name");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_nameNotBetween(Object value1, Object value2) {
            addCriterion("user_defined_type_name not between", value1, value2, "user_defined_type_name");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_categoryIsNull() {
            addCriterion("user_defined_type_category is null");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_categoryIsNotNull() {
            addCriterion("user_defined_type_category is not null");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_categoryEqualTo(Object value) {
            addCriterion("user_defined_type_category =", value, "user_defined_type_category");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_categoryNotEqualTo(Object value) {
            addCriterion("user_defined_type_category <>", value, "user_defined_type_category");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_categoryGreaterThan(Object value) {
            addCriterion("user_defined_type_category >", value, "user_defined_type_category");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_categoryGreaterThanOrEqualTo(Object value) {
            addCriterion("user_defined_type_category >=", value, "user_defined_type_category");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_categoryLessThan(Object value) {
            addCriterion("user_defined_type_category <", value, "user_defined_type_category");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_categoryLessThanOrEqualTo(Object value) {
            addCriterion("user_defined_type_category <=", value, "user_defined_type_category");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_categoryIn(List<Object> values) {
            addCriterion("user_defined_type_category in", values, "user_defined_type_category");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_categoryNotIn(List<Object> values) {
            addCriterion("user_defined_type_category not in", values, "user_defined_type_category");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_categoryBetween(Object value1, Object value2) {
            addCriterion("user_defined_type_category between", value1, value2, "user_defined_type_category");
            return (Criteria) this;
        }

        public Criteria andUser_defined_type_categoryNotBetween(Object value1, Object value2) {
            addCriterion("user_defined_type_category not between", value1, value2, "user_defined_type_category");
            return (Criteria) this;
        }

        public Criteria andIs_instantiableIsNull() {
            addCriterion("is_instantiable is null");
            return (Criteria) this;
        }

        public Criteria andIs_instantiableIsNotNull() {
            addCriterion("is_instantiable is not null");
            return (Criteria) this;
        }

        public Criteria andIs_instantiableEqualTo(Object value) {
            addCriterion("is_instantiable =", value, "is_instantiable");
            return (Criteria) this;
        }

        public Criteria andIs_instantiableNotEqualTo(Object value) {
            addCriterion("is_instantiable <>", value, "is_instantiable");
            return (Criteria) this;
        }

        public Criteria andIs_instantiableGreaterThan(Object value) {
            addCriterion("is_instantiable >", value, "is_instantiable");
            return (Criteria) this;
        }

        public Criteria andIs_instantiableGreaterThanOrEqualTo(Object value) {
            addCriterion("is_instantiable >=", value, "is_instantiable");
            return (Criteria) this;
        }

        public Criteria andIs_instantiableLessThan(Object value) {
            addCriterion("is_instantiable <", value, "is_instantiable");
            return (Criteria) this;
        }

        public Criteria andIs_instantiableLessThanOrEqualTo(Object value) {
            addCriterion("is_instantiable <=", value, "is_instantiable");
            return (Criteria) this;
        }

        public Criteria andIs_instantiableIn(List<Object> values) {
            addCriterion("is_instantiable in", values, "is_instantiable");
            return (Criteria) this;
        }

        public Criteria andIs_instantiableNotIn(List<Object> values) {
            addCriterion("is_instantiable not in", values, "is_instantiable");
            return (Criteria) this;
        }

        public Criteria andIs_instantiableBetween(Object value1, Object value2) {
            addCriterion("is_instantiable between", value1, value2, "is_instantiable");
            return (Criteria) this;
        }

        public Criteria andIs_instantiableNotBetween(Object value1, Object value2) {
            addCriterion("is_instantiable not between", value1, value2, "is_instantiable");
            return (Criteria) this;
        }

        public Criteria andIs_finalIsNull() {
            addCriterion("is_final is null");
            return (Criteria) this;
        }

        public Criteria andIs_finalIsNotNull() {
            addCriterion("is_final is not null");
            return (Criteria) this;
        }

        public Criteria andIs_finalEqualTo(Object value) {
            addCriterion("is_final =", value, "is_final");
            return (Criteria) this;
        }

        public Criteria andIs_finalNotEqualTo(Object value) {
            addCriterion("is_final <>", value, "is_final");
            return (Criteria) this;
        }

        public Criteria andIs_finalGreaterThan(Object value) {
            addCriterion("is_final >", value, "is_final");
            return (Criteria) this;
        }

        public Criteria andIs_finalGreaterThanOrEqualTo(Object value) {
            addCriterion("is_final >=", value, "is_final");
            return (Criteria) this;
        }

        public Criteria andIs_finalLessThan(Object value) {
            addCriterion("is_final <", value, "is_final");
            return (Criteria) this;
        }

        public Criteria andIs_finalLessThanOrEqualTo(Object value) {
            addCriterion("is_final <=", value, "is_final");
            return (Criteria) this;
        }

        public Criteria andIs_finalIn(List<Object> values) {
            addCriterion("is_final in", values, "is_final");
            return (Criteria) this;
        }

        public Criteria andIs_finalNotIn(List<Object> values) {
            addCriterion("is_final not in", values, "is_final");
            return (Criteria) this;
        }

        public Criteria andIs_finalBetween(Object value1, Object value2) {
            addCriterion("is_final between", value1, value2, "is_final");
            return (Criteria) this;
        }

        public Criteria andIs_finalNotBetween(Object value1, Object value2) {
            addCriterion("is_final not between", value1, value2, "is_final");
            return (Criteria) this;
        }

        public Criteria andOrdering_formIsNull() {
            addCriterion("ordering_form is null");
            return (Criteria) this;
        }

        public Criteria andOrdering_formIsNotNull() {
            addCriterion("ordering_form is not null");
            return (Criteria) this;
        }

        public Criteria andOrdering_formEqualTo(Object value) {
            addCriterion("ordering_form =", value, "ordering_form");
            return (Criteria) this;
        }

        public Criteria andOrdering_formNotEqualTo(Object value) {
            addCriterion("ordering_form <>", value, "ordering_form");
            return (Criteria) this;
        }

        public Criteria andOrdering_formGreaterThan(Object value) {
            addCriterion("ordering_form >", value, "ordering_form");
            return (Criteria) this;
        }

        public Criteria andOrdering_formGreaterThanOrEqualTo(Object value) {
            addCriterion("ordering_form >=", value, "ordering_form");
            return (Criteria) this;
        }

        public Criteria andOrdering_formLessThan(Object value) {
            addCriterion("ordering_form <", value, "ordering_form");
            return (Criteria) this;
        }

        public Criteria andOrdering_formLessThanOrEqualTo(Object value) {
            addCriterion("ordering_form <=", value, "ordering_form");
            return (Criteria) this;
        }

        public Criteria andOrdering_formIn(List<Object> values) {
            addCriterion("ordering_form in", values, "ordering_form");
            return (Criteria) this;
        }

        public Criteria andOrdering_formNotIn(List<Object> values) {
            addCriterion("ordering_form not in", values, "ordering_form");
            return (Criteria) this;
        }

        public Criteria andOrdering_formBetween(Object value1, Object value2) {
            addCriterion("ordering_form between", value1, value2, "ordering_form");
            return (Criteria) this;
        }

        public Criteria andOrdering_formNotBetween(Object value1, Object value2) {
            addCriterion("ordering_form not between", value1, value2, "ordering_form");
            return (Criteria) this;
        }

        public Criteria andOrdering_categoryIsNull() {
            addCriterion("ordering_category is null");
            return (Criteria) this;
        }

        public Criteria andOrdering_categoryIsNotNull() {
            addCriterion("ordering_category is not null");
            return (Criteria) this;
        }

        public Criteria andOrdering_categoryEqualTo(Object value) {
            addCriterion("ordering_category =", value, "ordering_category");
            return (Criteria) this;
        }

        public Criteria andOrdering_categoryNotEqualTo(Object value) {
            addCriterion("ordering_category <>", value, "ordering_category");
            return (Criteria) this;
        }

        public Criteria andOrdering_categoryGreaterThan(Object value) {
            addCriterion("ordering_category >", value, "ordering_category");
            return (Criteria) this;
        }

        public Criteria andOrdering_categoryGreaterThanOrEqualTo(Object value) {
            addCriterion("ordering_category >=", value, "ordering_category");
            return (Criteria) this;
        }

        public Criteria andOrdering_categoryLessThan(Object value) {
            addCriterion("ordering_category <", value, "ordering_category");
            return (Criteria) this;
        }

        public Criteria andOrdering_categoryLessThanOrEqualTo(Object value) {
            addCriterion("ordering_category <=", value, "ordering_category");
            return (Criteria) this;
        }

        public Criteria andOrdering_categoryIn(List<Object> values) {
            addCriterion("ordering_category in", values, "ordering_category");
            return (Criteria) this;
        }

        public Criteria andOrdering_categoryNotIn(List<Object> values) {
            addCriterion("ordering_category not in", values, "ordering_category");
            return (Criteria) this;
        }

        public Criteria andOrdering_categoryBetween(Object value1, Object value2) {
            addCriterion("ordering_category between", value1, value2, "ordering_category");
            return (Criteria) this;
        }

        public Criteria andOrdering_categoryNotBetween(Object value1, Object value2) {
            addCriterion("ordering_category not between", value1, value2, "ordering_category");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_catalogIsNull() {
            addCriterion("ordering_routine_catalog is null");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_catalogIsNotNull() {
            addCriterion("ordering_routine_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_catalogEqualTo(Object value) {
            addCriterion("ordering_routine_catalog =", value, "ordering_routine_catalog");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_catalogNotEqualTo(Object value) {
            addCriterion("ordering_routine_catalog <>", value, "ordering_routine_catalog");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_catalogGreaterThan(Object value) {
            addCriterion("ordering_routine_catalog >", value, "ordering_routine_catalog");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("ordering_routine_catalog >=", value, "ordering_routine_catalog");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_catalogLessThan(Object value) {
            addCriterion("ordering_routine_catalog <", value, "ordering_routine_catalog");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_catalogLessThanOrEqualTo(Object value) {
            addCriterion("ordering_routine_catalog <=", value, "ordering_routine_catalog");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_catalogIn(List<Object> values) {
            addCriterion("ordering_routine_catalog in", values, "ordering_routine_catalog");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_catalogNotIn(List<Object> values) {
            addCriterion("ordering_routine_catalog not in", values, "ordering_routine_catalog");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_catalogBetween(Object value1, Object value2) {
            addCriterion("ordering_routine_catalog between", value1, value2, "ordering_routine_catalog");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_catalogNotBetween(Object value1, Object value2) {
            addCriterion("ordering_routine_catalog not between", value1, value2, "ordering_routine_catalog");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_schemaIsNull() {
            addCriterion("ordering_routine_schema is null");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_schemaIsNotNull() {
            addCriterion("ordering_routine_schema is not null");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_schemaEqualTo(Object value) {
            addCriterion("ordering_routine_schema =", value, "ordering_routine_schema");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_schemaNotEqualTo(Object value) {
            addCriterion("ordering_routine_schema <>", value, "ordering_routine_schema");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_schemaGreaterThan(Object value) {
            addCriterion("ordering_routine_schema >", value, "ordering_routine_schema");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("ordering_routine_schema >=", value, "ordering_routine_schema");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_schemaLessThan(Object value) {
            addCriterion("ordering_routine_schema <", value, "ordering_routine_schema");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_schemaLessThanOrEqualTo(Object value) {
            addCriterion("ordering_routine_schema <=", value, "ordering_routine_schema");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_schemaIn(List<Object> values) {
            addCriterion("ordering_routine_schema in", values, "ordering_routine_schema");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_schemaNotIn(List<Object> values) {
            addCriterion("ordering_routine_schema not in", values, "ordering_routine_schema");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_schemaBetween(Object value1, Object value2) {
            addCriterion("ordering_routine_schema between", value1, value2, "ordering_routine_schema");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_schemaNotBetween(Object value1, Object value2) {
            addCriterion("ordering_routine_schema not between", value1, value2, "ordering_routine_schema");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_nameIsNull() {
            addCriterion("ordering_routine_name is null");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_nameIsNotNull() {
            addCriterion("ordering_routine_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_nameEqualTo(Object value) {
            addCriterion("ordering_routine_name =", value, "ordering_routine_name");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_nameNotEqualTo(Object value) {
            addCriterion("ordering_routine_name <>", value, "ordering_routine_name");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_nameGreaterThan(Object value) {
            addCriterion("ordering_routine_name >", value, "ordering_routine_name");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("ordering_routine_name >=", value, "ordering_routine_name");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_nameLessThan(Object value) {
            addCriterion("ordering_routine_name <", value, "ordering_routine_name");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_nameLessThanOrEqualTo(Object value) {
            addCriterion("ordering_routine_name <=", value, "ordering_routine_name");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_nameIn(List<Object> values) {
            addCriterion("ordering_routine_name in", values, "ordering_routine_name");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_nameNotIn(List<Object> values) {
            addCriterion("ordering_routine_name not in", values, "ordering_routine_name");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_nameBetween(Object value1, Object value2) {
            addCriterion("ordering_routine_name between", value1, value2, "ordering_routine_name");
            return (Criteria) this;
        }

        public Criteria andOrdering_routine_nameNotBetween(Object value1, Object value2) {
            addCriterion("ordering_routine_name not between", value1, value2, "ordering_routine_name");
            return (Criteria) this;
        }

        public Criteria andReference_typeIsNull() {
            addCriterion("reference_type is null");
            return (Criteria) this;
        }

        public Criteria andReference_typeIsNotNull() {
            addCriterion("reference_type is not null");
            return (Criteria) this;
        }

        public Criteria andReference_typeEqualTo(Object value) {
            addCriterion("reference_type =", value, "reference_type");
            return (Criteria) this;
        }

        public Criteria andReference_typeNotEqualTo(Object value) {
            addCriterion("reference_type <>", value, "reference_type");
            return (Criteria) this;
        }

        public Criteria andReference_typeGreaterThan(Object value) {
            addCriterion("reference_type >", value, "reference_type");
            return (Criteria) this;
        }

        public Criteria andReference_typeGreaterThanOrEqualTo(Object value) {
            addCriterion("reference_type >=", value, "reference_type");
            return (Criteria) this;
        }

        public Criteria andReference_typeLessThan(Object value) {
            addCriterion("reference_type <", value, "reference_type");
            return (Criteria) this;
        }

        public Criteria andReference_typeLessThanOrEqualTo(Object value) {
            addCriterion("reference_type <=", value, "reference_type");
            return (Criteria) this;
        }

        public Criteria andReference_typeIn(List<Object> values) {
            addCriterion("reference_type in", values, "reference_type");
            return (Criteria) this;
        }

        public Criteria andReference_typeNotIn(List<Object> values) {
            addCriterion("reference_type not in", values, "reference_type");
            return (Criteria) this;
        }

        public Criteria andReference_typeBetween(Object value1, Object value2) {
            addCriterion("reference_type between", value1, value2, "reference_type");
            return (Criteria) this;
        }

        public Criteria andReference_typeNotBetween(Object value1, Object value2) {
            addCriterion("reference_type not between", value1, value2, "reference_type");
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

        public Criteria andSource_dtd_identifierIsNull() {
            addCriterion("source_dtd_identifier is null");
            return (Criteria) this;
        }

        public Criteria andSource_dtd_identifierIsNotNull() {
            addCriterion("source_dtd_identifier is not null");
            return (Criteria) this;
        }

        public Criteria andSource_dtd_identifierEqualTo(Object value) {
            addCriterion("source_dtd_identifier =", value, "source_dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andSource_dtd_identifierNotEqualTo(Object value) {
            addCriterion("source_dtd_identifier <>", value, "source_dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andSource_dtd_identifierGreaterThan(Object value) {
            addCriterion("source_dtd_identifier >", value, "source_dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andSource_dtd_identifierGreaterThanOrEqualTo(Object value) {
            addCriterion("source_dtd_identifier >=", value, "source_dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andSource_dtd_identifierLessThan(Object value) {
            addCriterion("source_dtd_identifier <", value, "source_dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andSource_dtd_identifierLessThanOrEqualTo(Object value) {
            addCriterion("source_dtd_identifier <=", value, "source_dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andSource_dtd_identifierIn(List<Object> values) {
            addCriterion("source_dtd_identifier in", values, "source_dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andSource_dtd_identifierNotIn(List<Object> values) {
            addCriterion("source_dtd_identifier not in", values, "source_dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andSource_dtd_identifierBetween(Object value1, Object value2) {
            addCriterion("source_dtd_identifier between", value1, value2, "source_dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andSource_dtd_identifierNotBetween(Object value1, Object value2) {
            addCriterion("source_dtd_identifier not between", value1, value2, "source_dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andRef_dtd_identifierIsNull() {
            addCriterion("ref_dtd_identifier is null");
            return (Criteria) this;
        }

        public Criteria andRef_dtd_identifierIsNotNull() {
            addCriterion("ref_dtd_identifier is not null");
            return (Criteria) this;
        }

        public Criteria andRef_dtd_identifierEqualTo(Object value) {
            addCriterion("ref_dtd_identifier =", value, "ref_dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andRef_dtd_identifierNotEqualTo(Object value) {
            addCriterion("ref_dtd_identifier <>", value, "ref_dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andRef_dtd_identifierGreaterThan(Object value) {
            addCriterion("ref_dtd_identifier >", value, "ref_dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andRef_dtd_identifierGreaterThanOrEqualTo(Object value) {
            addCriterion("ref_dtd_identifier >=", value, "ref_dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andRef_dtd_identifierLessThan(Object value) {
            addCriterion("ref_dtd_identifier <", value, "ref_dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andRef_dtd_identifierLessThanOrEqualTo(Object value) {
            addCriterion("ref_dtd_identifier <=", value, "ref_dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andRef_dtd_identifierIn(List<Object> values) {
            addCriterion("ref_dtd_identifier in", values, "ref_dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andRef_dtd_identifierNotIn(List<Object> values) {
            addCriterion("ref_dtd_identifier not in", values, "ref_dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andRef_dtd_identifierBetween(Object value1, Object value2) {
            addCriterion("ref_dtd_identifier between", value1, value2, "ref_dtd_identifier");
            return (Criteria) this;
        }

        public Criteria andRef_dtd_identifierNotBetween(Object value1, Object value2) {
            addCriterion("ref_dtd_identifier not between", value1, value2, "ref_dtd_identifier");
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