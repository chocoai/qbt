package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class SequencesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SequencesExample() {
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

        public Criteria andSequence_catalogIsNull() {
            addCriterion("sequence_catalog is null");
            return (Criteria) this;
        }

        public Criteria andSequence_catalogIsNotNull() {
            addCriterion("sequence_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andSequence_catalogEqualTo(Object value) {
            addCriterion("sequence_catalog =", value, "sequence_catalog");
            return (Criteria) this;
        }

        public Criteria andSequence_catalogNotEqualTo(Object value) {
            addCriterion("sequence_catalog <>", value, "sequence_catalog");
            return (Criteria) this;
        }

        public Criteria andSequence_catalogGreaterThan(Object value) {
            addCriterion("sequence_catalog >", value, "sequence_catalog");
            return (Criteria) this;
        }

        public Criteria andSequence_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("sequence_catalog >=", value, "sequence_catalog");
            return (Criteria) this;
        }

        public Criteria andSequence_catalogLessThan(Object value) {
            addCriterion("sequence_catalog <", value, "sequence_catalog");
            return (Criteria) this;
        }

        public Criteria andSequence_catalogLessThanOrEqualTo(Object value) {
            addCriterion("sequence_catalog <=", value, "sequence_catalog");
            return (Criteria) this;
        }

        public Criteria andSequence_catalogIn(List<Object> values) {
            addCriterion("sequence_catalog in", values, "sequence_catalog");
            return (Criteria) this;
        }

        public Criteria andSequence_catalogNotIn(List<Object> values) {
            addCriterion("sequence_catalog not in", values, "sequence_catalog");
            return (Criteria) this;
        }

        public Criteria andSequence_catalogBetween(Object value1, Object value2) {
            addCriterion("sequence_catalog between", value1, value2, "sequence_catalog");
            return (Criteria) this;
        }

        public Criteria andSequence_catalogNotBetween(Object value1, Object value2) {
            addCriterion("sequence_catalog not between", value1, value2, "sequence_catalog");
            return (Criteria) this;
        }

        public Criteria andSequence_schemaIsNull() {
            addCriterion("sequence_schema is null");
            return (Criteria) this;
        }

        public Criteria andSequence_schemaIsNotNull() {
            addCriterion("sequence_schema is not null");
            return (Criteria) this;
        }

        public Criteria andSequence_schemaEqualTo(Object value) {
            addCriterion("sequence_schema =", value, "sequence_schema");
            return (Criteria) this;
        }

        public Criteria andSequence_schemaNotEqualTo(Object value) {
            addCriterion("sequence_schema <>", value, "sequence_schema");
            return (Criteria) this;
        }

        public Criteria andSequence_schemaGreaterThan(Object value) {
            addCriterion("sequence_schema >", value, "sequence_schema");
            return (Criteria) this;
        }

        public Criteria andSequence_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("sequence_schema >=", value, "sequence_schema");
            return (Criteria) this;
        }

        public Criteria andSequence_schemaLessThan(Object value) {
            addCriterion("sequence_schema <", value, "sequence_schema");
            return (Criteria) this;
        }

        public Criteria andSequence_schemaLessThanOrEqualTo(Object value) {
            addCriterion("sequence_schema <=", value, "sequence_schema");
            return (Criteria) this;
        }

        public Criteria andSequence_schemaIn(List<Object> values) {
            addCriterion("sequence_schema in", values, "sequence_schema");
            return (Criteria) this;
        }

        public Criteria andSequence_schemaNotIn(List<Object> values) {
            addCriterion("sequence_schema not in", values, "sequence_schema");
            return (Criteria) this;
        }

        public Criteria andSequence_schemaBetween(Object value1, Object value2) {
            addCriterion("sequence_schema between", value1, value2, "sequence_schema");
            return (Criteria) this;
        }

        public Criteria andSequence_schemaNotBetween(Object value1, Object value2) {
            addCriterion("sequence_schema not between", value1, value2, "sequence_schema");
            return (Criteria) this;
        }

        public Criteria andSequence_nameIsNull() {
            addCriterion("sequence_name is null");
            return (Criteria) this;
        }

        public Criteria andSequence_nameIsNotNull() {
            addCriterion("sequence_name is not null");
            return (Criteria) this;
        }

        public Criteria andSequence_nameEqualTo(Object value) {
            addCriterion("sequence_name =", value, "sequence_name");
            return (Criteria) this;
        }

        public Criteria andSequence_nameNotEqualTo(Object value) {
            addCriterion("sequence_name <>", value, "sequence_name");
            return (Criteria) this;
        }

        public Criteria andSequence_nameGreaterThan(Object value) {
            addCriterion("sequence_name >", value, "sequence_name");
            return (Criteria) this;
        }

        public Criteria andSequence_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("sequence_name >=", value, "sequence_name");
            return (Criteria) this;
        }

        public Criteria andSequence_nameLessThan(Object value) {
            addCriterion("sequence_name <", value, "sequence_name");
            return (Criteria) this;
        }

        public Criteria andSequence_nameLessThanOrEqualTo(Object value) {
            addCriterion("sequence_name <=", value, "sequence_name");
            return (Criteria) this;
        }

        public Criteria andSequence_nameIn(List<Object> values) {
            addCriterion("sequence_name in", values, "sequence_name");
            return (Criteria) this;
        }

        public Criteria andSequence_nameNotIn(List<Object> values) {
            addCriterion("sequence_name not in", values, "sequence_name");
            return (Criteria) this;
        }

        public Criteria andSequence_nameBetween(Object value1, Object value2) {
            addCriterion("sequence_name between", value1, value2, "sequence_name");
            return (Criteria) this;
        }

        public Criteria andSequence_nameNotBetween(Object value1, Object value2) {
            addCriterion("sequence_name not between", value1, value2, "sequence_name");
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

        public Criteria andStart_valueIsNull() {
            addCriterion("start_value is null");
            return (Criteria) this;
        }

        public Criteria andStart_valueIsNotNull() {
            addCriterion("start_value is not null");
            return (Criteria) this;
        }

        public Criteria andStart_valueEqualTo(Object value) {
            addCriterion("start_value =", value, "start_value");
            return (Criteria) this;
        }

        public Criteria andStart_valueNotEqualTo(Object value) {
            addCriterion("start_value <>", value, "start_value");
            return (Criteria) this;
        }

        public Criteria andStart_valueGreaterThan(Object value) {
            addCriterion("start_value >", value, "start_value");
            return (Criteria) this;
        }

        public Criteria andStart_valueGreaterThanOrEqualTo(Object value) {
            addCriterion("start_value >=", value, "start_value");
            return (Criteria) this;
        }

        public Criteria andStart_valueLessThan(Object value) {
            addCriterion("start_value <", value, "start_value");
            return (Criteria) this;
        }

        public Criteria andStart_valueLessThanOrEqualTo(Object value) {
            addCriterion("start_value <=", value, "start_value");
            return (Criteria) this;
        }

        public Criteria andStart_valueIn(List<Object> values) {
            addCriterion("start_value in", values, "start_value");
            return (Criteria) this;
        }

        public Criteria andStart_valueNotIn(List<Object> values) {
            addCriterion("start_value not in", values, "start_value");
            return (Criteria) this;
        }

        public Criteria andStart_valueBetween(Object value1, Object value2) {
            addCriterion("start_value between", value1, value2, "start_value");
            return (Criteria) this;
        }

        public Criteria andStart_valueNotBetween(Object value1, Object value2) {
            addCriterion("start_value not between", value1, value2, "start_value");
            return (Criteria) this;
        }

        public Criteria andMinimum_valueIsNull() {
            addCriterion("minimum_value is null");
            return (Criteria) this;
        }

        public Criteria andMinimum_valueIsNotNull() {
            addCriterion("minimum_value is not null");
            return (Criteria) this;
        }

        public Criteria andMinimum_valueEqualTo(Object value) {
            addCriterion("minimum_value =", value, "minimum_value");
            return (Criteria) this;
        }

        public Criteria andMinimum_valueNotEqualTo(Object value) {
            addCriterion("minimum_value <>", value, "minimum_value");
            return (Criteria) this;
        }

        public Criteria andMinimum_valueGreaterThan(Object value) {
            addCriterion("minimum_value >", value, "minimum_value");
            return (Criteria) this;
        }

        public Criteria andMinimum_valueGreaterThanOrEqualTo(Object value) {
            addCriterion("minimum_value >=", value, "minimum_value");
            return (Criteria) this;
        }

        public Criteria andMinimum_valueLessThan(Object value) {
            addCriterion("minimum_value <", value, "minimum_value");
            return (Criteria) this;
        }

        public Criteria andMinimum_valueLessThanOrEqualTo(Object value) {
            addCriterion("minimum_value <=", value, "minimum_value");
            return (Criteria) this;
        }

        public Criteria andMinimum_valueIn(List<Object> values) {
            addCriterion("minimum_value in", values, "minimum_value");
            return (Criteria) this;
        }

        public Criteria andMinimum_valueNotIn(List<Object> values) {
            addCriterion("minimum_value not in", values, "minimum_value");
            return (Criteria) this;
        }

        public Criteria andMinimum_valueBetween(Object value1, Object value2) {
            addCriterion("minimum_value between", value1, value2, "minimum_value");
            return (Criteria) this;
        }

        public Criteria andMinimum_valueNotBetween(Object value1, Object value2) {
            addCriterion("minimum_value not between", value1, value2, "minimum_value");
            return (Criteria) this;
        }

        public Criteria andMaximum_valueIsNull() {
            addCriterion("maximum_value is null");
            return (Criteria) this;
        }

        public Criteria andMaximum_valueIsNotNull() {
            addCriterion("maximum_value is not null");
            return (Criteria) this;
        }

        public Criteria andMaximum_valueEqualTo(Object value) {
            addCriterion("maximum_value =", value, "maximum_value");
            return (Criteria) this;
        }

        public Criteria andMaximum_valueNotEqualTo(Object value) {
            addCriterion("maximum_value <>", value, "maximum_value");
            return (Criteria) this;
        }

        public Criteria andMaximum_valueGreaterThan(Object value) {
            addCriterion("maximum_value >", value, "maximum_value");
            return (Criteria) this;
        }

        public Criteria andMaximum_valueGreaterThanOrEqualTo(Object value) {
            addCriterion("maximum_value >=", value, "maximum_value");
            return (Criteria) this;
        }

        public Criteria andMaximum_valueLessThan(Object value) {
            addCriterion("maximum_value <", value, "maximum_value");
            return (Criteria) this;
        }

        public Criteria andMaximum_valueLessThanOrEqualTo(Object value) {
            addCriterion("maximum_value <=", value, "maximum_value");
            return (Criteria) this;
        }

        public Criteria andMaximum_valueIn(List<Object> values) {
            addCriterion("maximum_value in", values, "maximum_value");
            return (Criteria) this;
        }

        public Criteria andMaximum_valueNotIn(List<Object> values) {
            addCriterion("maximum_value not in", values, "maximum_value");
            return (Criteria) this;
        }

        public Criteria andMaximum_valueBetween(Object value1, Object value2) {
            addCriterion("maximum_value between", value1, value2, "maximum_value");
            return (Criteria) this;
        }

        public Criteria andMaximum_valueNotBetween(Object value1, Object value2) {
            addCriterion("maximum_value not between", value1, value2, "maximum_value");
            return (Criteria) this;
        }

        public Criteria andIncrementIsNull() {
            addCriterion("increment is null");
            return (Criteria) this;
        }

        public Criteria andIncrementIsNotNull() {
            addCriterion("increment is not null");
            return (Criteria) this;
        }

        public Criteria andIncrementEqualTo(Object value) {
            addCriterion("increment =", value, "increment");
            return (Criteria) this;
        }

        public Criteria andIncrementNotEqualTo(Object value) {
            addCriterion("increment <>", value, "increment");
            return (Criteria) this;
        }

        public Criteria andIncrementGreaterThan(Object value) {
            addCriterion("increment >", value, "increment");
            return (Criteria) this;
        }

        public Criteria andIncrementGreaterThanOrEqualTo(Object value) {
            addCriterion("increment >=", value, "increment");
            return (Criteria) this;
        }

        public Criteria andIncrementLessThan(Object value) {
            addCriterion("increment <", value, "increment");
            return (Criteria) this;
        }

        public Criteria andIncrementLessThanOrEqualTo(Object value) {
            addCriterion("increment <=", value, "increment");
            return (Criteria) this;
        }

        public Criteria andIncrementIn(List<Object> values) {
            addCriterion("increment in", values, "increment");
            return (Criteria) this;
        }

        public Criteria andIncrementNotIn(List<Object> values) {
            addCriterion("increment not in", values, "increment");
            return (Criteria) this;
        }

        public Criteria andIncrementBetween(Object value1, Object value2) {
            addCriterion("increment between", value1, value2, "increment");
            return (Criteria) this;
        }

        public Criteria andIncrementNotBetween(Object value1, Object value2) {
            addCriterion("increment not between", value1, value2, "increment");
            return (Criteria) this;
        }

        public Criteria andCycle_optionIsNull() {
            addCriterion("cycle_option is null");
            return (Criteria) this;
        }

        public Criteria andCycle_optionIsNotNull() {
            addCriterion("cycle_option is not null");
            return (Criteria) this;
        }

        public Criteria andCycle_optionEqualTo(Object value) {
            addCriterion("cycle_option =", value, "cycle_option");
            return (Criteria) this;
        }

        public Criteria andCycle_optionNotEqualTo(Object value) {
            addCriterion("cycle_option <>", value, "cycle_option");
            return (Criteria) this;
        }

        public Criteria andCycle_optionGreaterThan(Object value) {
            addCriterion("cycle_option >", value, "cycle_option");
            return (Criteria) this;
        }

        public Criteria andCycle_optionGreaterThanOrEqualTo(Object value) {
            addCriterion("cycle_option >=", value, "cycle_option");
            return (Criteria) this;
        }

        public Criteria andCycle_optionLessThan(Object value) {
            addCriterion("cycle_option <", value, "cycle_option");
            return (Criteria) this;
        }

        public Criteria andCycle_optionLessThanOrEqualTo(Object value) {
            addCriterion("cycle_option <=", value, "cycle_option");
            return (Criteria) this;
        }

        public Criteria andCycle_optionIn(List<Object> values) {
            addCriterion("cycle_option in", values, "cycle_option");
            return (Criteria) this;
        }

        public Criteria andCycle_optionNotIn(List<Object> values) {
            addCriterion("cycle_option not in", values, "cycle_option");
            return (Criteria) this;
        }

        public Criteria andCycle_optionBetween(Object value1, Object value2) {
            addCriterion("cycle_option between", value1, value2, "cycle_option");
            return (Criteria) this;
        }

        public Criteria andCycle_optionNotBetween(Object value1, Object value2) {
            addCriterion("cycle_option not between", value1, value2, "cycle_option");
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