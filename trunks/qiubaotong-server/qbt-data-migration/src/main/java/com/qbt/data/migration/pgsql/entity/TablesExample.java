package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class TablesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TablesExample() {
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

        public Criteria andTable_catalogIsNull() {
            addCriterion("table_catalog is null");
            return (Criteria) this;
        }

        public Criteria andTable_catalogIsNotNull() {
            addCriterion("table_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andTable_catalogEqualTo(Object value) {
            addCriterion("table_catalog =", value, "table_catalog");
            return (Criteria) this;
        }

        public Criteria andTable_catalogNotEqualTo(Object value) {
            addCriterion("table_catalog <>", value, "table_catalog");
            return (Criteria) this;
        }

        public Criteria andTable_catalogGreaterThan(Object value) {
            addCriterion("table_catalog >", value, "table_catalog");
            return (Criteria) this;
        }

        public Criteria andTable_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("table_catalog >=", value, "table_catalog");
            return (Criteria) this;
        }

        public Criteria andTable_catalogLessThan(Object value) {
            addCriterion("table_catalog <", value, "table_catalog");
            return (Criteria) this;
        }

        public Criteria andTable_catalogLessThanOrEqualTo(Object value) {
            addCriterion("table_catalog <=", value, "table_catalog");
            return (Criteria) this;
        }

        public Criteria andTable_catalogIn(List<Object> values) {
            addCriterion("table_catalog in", values, "table_catalog");
            return (Criteria) this;
        }

        public Criteria andTable_catalogNotIn(List<Object> values) {
            addCriterion("table_catalog not in", values, "table_catalog");
            return (Criteria) this;
        }

        public Criteria andTable_catalogBetween(Object value1, Object value2) {
            addCriterion("table_catalog between", value1, value2, "table_catalog");
            return (Criteria) this;
        }

        public Criteria andTable_catalogNotBetween(Object value1, Object value2) {
            addCriterion("table_catalog not between", value1, value2, "table_catalog");
            return (Criteria) this;
        }

        public Criteria andTable_schemaIsNull() {
            addCriterion("table_schema is null");
            return (Criteria) this;
        }

        public Criteria andTable_schemaIsNotNull() {
            addCriterion("table_schema is not null");
            return (Criteria) this;
        }

        public Criteria andTable_schemaEqualTo(Object value) {
            addCriterion("table_schema =", value, "table_schema");
            return (Criteria) this;
        }

        public Criteria andTable_schemaNotEqualTo(Object value) {
            addCriterion("table_schema <>", value, "table_schema");
            return (Criteria) this;
        }

        public Criteria andTable_schemaGreaterThan(Object value) {
            addCriterion("table_schema >", value, "table_schema");
            return (Criteria) this;
        }

        public Criteria andTable_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("table_schema >=", value, "table_schema");
            return (Criteria) this;
        }

        public Criteria andTable_schemaLessThan(Object value) {
            addCriterion("table_schema <", value, "table_schema");
            return (Criteria) this;
        }

        public Criteria andTable_schemaLessThanOrEqualTo(Object value) {
            addCriterion("table_schema <=", value, "table_schema");
            return (Criteria) this;
        }

        public Criteria andTable_schemaIn(List<Object> values) {
            addCriterion("table_schema in", values, "table_schema");
            return (Criteria) this;
        }

        public Criteria andTable_schemaNotIn(List<Object> values) {
            addCriterion("table_schema not in", values, "table_schema");
            return (Criteria) this;
        }

        public Criteria andTable_schemaBetween(Object value1, Object value2) {
            addCriterion("table_schema between", value1, value2, "table_schema");
            return (Criteria) this;
        }

        public Criteria andTable_schemaNotBetween(Object value1, Object value2) {
            addCriterion("table_schema not between", value1, value2, "table_schema");
            return (Criteria) this;
        }

        public Criteria andTable_nameIsNull() {
            addCriterion("table_name is null");
            return (Criteria) this;
        }

        public Criteria andTable_nameIsNotNull() {
            addCriterion("table_name is not null");
            return (Criteria) this;
        }

        public Criteria andTable_nameEqualTo(Object value) {
            addCriterion("table_name =", value, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameNotEqualTo(Object value) {
            addCriterion("table_name <>", value, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameGreaterThan(Object value) {
            addCriterion("table_name >", value, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("table_name >=", value, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameLessThan(Object value) {
            addCriterion("table_name <", value, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameLessThanOrEqualTo(Object value) {
            addCriterion("table_name <=", value, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameIn(List<Object> values) {
            addCriterion("table_name in", values, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameNotIn(List<Object> values) {
            addCriterion("table_name not in", values, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameBetween(Object value1, Object value2) {
            addCriterion("table_name between", value1, value2, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameNotBetween(Object value1, Object value2) {
            addCriterion("table_name not between", value1, value2, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_typeIsNull() {
            addCriterion("table_type is null");
            return (Criteria) this;
        }

        public Criteria andTable_typeIsNotNull() {
            addCriterion("table_type is not null");
            return (Criteria) this;
        }

        public Criteria andTable_typeEqualTo(Object value) {
            addCriterion("table_type =", value, "table_type");
            return (Criteria) this;
        }

        public Criteria andTable_typeNotEqualTo(Object value) {
            addCriterion("table_type <>", value, "table_type");
            return (Criteria) this;
        }

        public Criteria andTable_typeGreaterThan(Object value) {
            addCriterion("table_type >", value, "table_type");
            return (Criteria) this;
        }

        public Criteria andTable_typeGreaterThanOrEqualTo(Object value) {
            addCriterion("table_type >=", value, "table_type");
            return (Criteria) this;
        }

        public Criteria andTable_typeLessThan(Object value) {
            addCriterion("table_type <", value, "table_type");
            return (Criteria) this;
        }

        public Criteria andTable_typeLessThanOrEqualTo(Object value) {
            addCriterion("table_type <=", value, "table_type");
            return (Criteria) this;
        }

        public Criteria andTable_typeIn(List<Object> values) {
            addCriterion("table_type in", values, "table_type");
            return (Criteria) this;
        }

        public Criteria andTable_typeNotIn(List<Object> values) {
            addCriterion("table_type not in", values, "table_type");
            return (Criteria) this;
        }

        public Criteria andTable_typeBetween(Object value1, Object value2) {
            addCriterion("table_type between", value1, value2, "table_type");
            return (Criteria) this;
        }

        public Criteria andTable_typeNotBetween(Object value1, Object value2) {
            addCriterion("table_type not between", value1, value2, "table_type");
            return (Criteria) this;
        }

        public Criteria andSelf_referencing_column_nameIsNull() {
            addCriterion("self_referencing_column_name is null");
            return (Criteria) this;
        }

        public Criteria andSelf_referencing_column_nameIsNotNull() {
            addCriterion("self_referencing_column_name is not null");
            return (Criteria) this;
        }

        public Criteria andSelf_referencing_column_nameEqualTo(Object value) {
            addCriterion("self_referencing_column_name =", value, "self_referencing_column_name");
            return (Criteria) this;
        }

        public Criteria andSelf_referencing_column_nameNotEqualTo(Object value) {
            addCriterion("self_referencing_column_name <>", value, "self_referencing_column_name");
            return (Criteria) this;
        }

        public Criteria andSelf_referencing_column_nameGreaterThan(Object value) {
            addCriterion("self_referencing_column_name >", value, "self_referencing_column_name");
            return (Criteria) this;
        }

        public Criteria andSelf_referencing_column_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("self_referencing_column_name >=", value, "self_referencing_column_name");
            return (Criteria) this;
        }

        public Criteria andSelf_referencing_column_nameLessThan(Object value) {
            addCriterion("self_referencing_column_name <", value, "self_referencing_column_name");
            return (Criteria) this;
        }

        public Criteria andSelf_referencing_column_nameLessThanOrEqualTo(Object value) {
            addCriterion("self_referencing_column_name <=", value, "self_referencing_column_name");
            return (Criteria) this;
        }

        public Criteria andSelf_referencing_column_nameIn(List<Object> values) {
            addCriterion("self_referencing_column_name in", values, "self_referencing_column_name");
            return (Criteria) this;
        }

        public Criteria andSelf_referencing_column_nameNotIn(List<Object> values) {
            addCriterion("self_referencing_column_name not in", values, "self_referencing_column_name");
            return (Criteria) this;
        }

        public Criteria andSelf_referencing_column_nameBetween(Object value1, Object value2) {
            addCriterion("self_referencing_column_name between", value1, value2, "self_referencing_column_name");
            return (Criteria) this;
        }

        public Criteria andSelf_referencing_column_nameNotBetween(Object value1, Object value2) {
            addCriterion("self_referencing_column_name not between", value1, value2, "self_referencing_column_name");
            return (Criteria) this;
        }

        public Criteria andReference_generationIsNull() {
            addCriterion("reference_generation is null");
            return (Criteria) this;
        }

        public Criteria andReference_generationIsNotNull() {
            addCriterion("reference_generation is not null");
            return (Criteria) this;
        }

        public Criteria andReference_generationEqualTo(Object value) {
            addCriterion("reference_generation =", value, "reference_generation");
            return (Criteria) this;
        }

        public Criteria andReference_generationNotEqualTo(Object value) {
            addCriterion("reference_generation <>", value, "reference_generation");
            return (Criteria) this;
        }

        public Criteria andReference_generationGreaterThan(Object value) {
            addCriterion("reference_generation >", value, "reference_generation");
            return (Criteria) this;
        }

        public Criteria andReference_generationGreaterThanOrEqualTo(Object value) {
            addCriterion("reference_generation >=", value, "reference_generation");
            return (Criteria) this;
        }

        public Criteria andReference_generationLessThan(Object value) {
            addCriterion("reference_generation <", value, "reference_generation");
            return (Criteria) this;
        }

        public Criteria andReference_generationLessThanOrEqualTo(Object value) {
            addCriterion("reference_generation <=", value, "reference_generation");
            return (Criteria) this;
        }

        public Criteria andReference_generationIn(List<Object> values) {
            addCriterion("reference_generation in", values, "reference_generation");
            return (Criteria) this;
        }

        public Criteria andReference_generationNotIn(List<Object> values) {
            addCriterion("reference_generation not in", values, "reference_generation");
            return (Criteria) this;
        }

        public Criteria andReference_generationBetween(Object value1, Object value2) {
            addCriterion("reference_generation between", value1, value2, "reference_generation");
            return (Criteria) this;
        }

        public Criteria andReference_generationNotBetween(Object value1, Object value2) {
            addCriterion("reference_generation not between", value1, value2, "reference_generation");
            return (Criteria) this;
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

        public Criteria andIs_insertable_intoIsNull() {
            addCriterion("is_insertable_into is null");
            return (Criteria) this;
        }

        public Criteria andIs_insertable_intoIsNotNull() {
            addCriterion("is_insertable_into is not null");
            return (Criteria) this;
        }

        public Criteria andIs_insertable_intoEqualTo(Object value) {
            addCriterion("is_insertable_into =", value, "is_insertable_into");
            return (Criteria) this;
        }

        public Criteria andIs_insertable_intoNotEqualTo(Object value) {
            addCriterion("is_insertable_into <>", value, "is_insertable_into");
            return (Criteria) this;
        }

        public Criteria andIs_insertable_intoGreaterThan(Object value) {
            addCriterion("is_insertable_into >", value, "is_insertable_into");
            return (Criteria) this;
        }

        public Criteria andIs_insertable_intoGreaterThanOrEqualTo(Object value) {
            addCriterion("is_insertable_into >=", value, "is_insertable_into");
            return (Criteria) this;
        }

        public Criteria andIs_insertable_intoLessThan(Object value) {
            addCriterion("is_insertable_into <", value, "is_insertable_into");
            return (Criteria) this;
        }

        public Criteria andIs_insertable_intoLessThanOrEqualTo(Object value) {
            addCriterion("is_insertable_into <=", value, "is_insertable_into");
            return (Criteria) this;
        }

        public Criteria andIs_insertable_intoIn(List<Object> values) {
            addCriterion("is_insertable_into in", values, "is_insertable_into");
            return (Criteria) this;
        }

        public Criteria andIs_insertable_intoNotIn(List<Object> values) {
            addCriterion("is_insertable_into not in", values, "is_insertable_into");
            return (Criteria) this;
        }

        public Criteria andIs_insertable_intoBetween(Object value1, Object value2) {
            addCriterion("is_insertable_into between", value1, value2, "is_insertable_into");
            return (Criteria) this;
        }

        public Criteria andIs_insertable_intoNotBetween(Object value1, Object value2) {
            addCriterion("is_insertable_into not between", value1, value2, "is_insertable_into");
            return (Criteria) this;
        }

        public Criteria andIs_typedIsNull() {
            addCriterion("is_typed is null");
            return (Criteria) this;
        }

        public Criteria andIs_typedIsNotNull() {
            addCriterion("is_typed is not null");
            return (Criteria) this;
        }

        public Criteria andIs_typedEqualTo(Object value) {
            addCriterion("is_typed =", value, "is_typed");
            return (Criteria) this;
        }

        public Criteria andIs_typedNotEqualTo(Object value) {
            addCriterion("is_typed <>", value, "is_typed");
            return (Criteria) this;
        }

        public Criteria andIs_typedGreaterThan(Object value) {
            addCriterion("is_typed >", value, "is_typed");
            return (Criteria) this;
        }

        public Criteria andIs_typedGreaterThanOrEqualTo(Object value) {
            addCriterion("is_typed >=", value, "is_typed");
            return (Criteria) this;
        }

        public Criteria andIs_typedLessThan(Object value) {
            addCriterion("is_typed <", value, "is_typed");
            return (Criteria) this;
        }

        public Criteria andIs_typedLessThanOrEqualTo(Object value) {
            addCriterion("is_typed <=", value, "is_typed");
            return (Criteria) this;
        }

        public Criteria andIs_typedIn(List<Object> values) {
            addCriterion("is_typed in", values, "is_typed");
            return (Criteria) this;
        }

        public Criteria andIs_typedNotIn(List<Object> values) {
            addCriterion("is_typed not in", values, "is_typed");
            return (Criteria) this;
        }

        public Criteria andIs_typedBetween(Object value1, Object value2) {
            addCriterion("is_typed between", value1, value2, "is_typed");
            return (Criteria) this;
        }

        public Criteria andIs_typedNotBetween(Object value1, Object value2) {
            addCriterion("is_typed not between", value1, value2, "is_typed");
            return (Criteria) this;
        }

        public Criteria andCommit_actionIsNull() {
            addCriterion("commit_action is null");
            return (Criteria) this;
        }

        public Criteria andCommit_actionIsNotNull() {
            addCriterion("commit_action is not null");
            return (Criteria) this;
        }

        public Criteria andCommit_actionEqualTo(Object value) {
            addCriterion("commit_action =", value, "commit_action");
            return (Criteria) this;
        }

        public Criteria andCommit_actionNotEqualTo(Object value) {
            addCriterion("commit_action <>", value, "commit_action");
            return (Criteria) this;
        }

        public Criteria andCommit_actionGreaterThan(Object value) {
            addCriterion("commit_action >", value, "commit_action");
            return (Criteria) this;
        }

        public Criteria andCommit_actionGreaterThanOrEqualTo(Object value) {
            addCriterion("commit_action >=", value, "commit_action");
            return (Criteria) this;
        }

        public Criteria andCommit_actionLessThan(Object value) {
            addCriterion("commit_action <", value, "commit_action");
            return (Criteria) this;
        }

        public Criteria andCommit_actionLessThanOrEqualTo(Object value) {
            addCriterion("commit_action <=", value, "commit_action");
            return (Criteria) this;
        }

        public Criteria andCommit_actionIn(List<Object> values) {
            addCriterion("commit_action in", values, "commit_action");
            return (Criteria) this;
        }

        public Criteria andCommit_actionNotIn(List<Object> values) {
            addCriterion("commit_action not in", values, "commit_action");
            return (Criteria) this;
        }

        public Criteria andCommit_actionBetween(Object value1, Object value2) {
            addCriterion("commit_action between", value1, value2, "commit_action");
            return (Criteria) this;
        }

        public Criteria andCommit_actionNotBetween(Object value1, Object value2) {
            addCriterion("commit_action not between", value1, value2, "commit_action");
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