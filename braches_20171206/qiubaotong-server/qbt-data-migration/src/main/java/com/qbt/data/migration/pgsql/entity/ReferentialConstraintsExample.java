package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class ReferentialConstraintsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReferentialConstraintsExample() {
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

        public Criteria andConstraint_catalogIsNull() {
            addCriterion("constraint_catalog is null");
            return (Criteria) this;
        }

        public Criteria andConstraint_catalogIsNotNull() {
            addCriterion("constraint_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andConstraint_catalogEqualTo(Object value) {
            addCriterion("constraint_catalog =", value, "constraint_catalog");
            return (Criteria) this;
        }

        public Criteria andConstraint_catalogNotEqualTo(Object value) {
            addCriterion("constraint_catalog <>", value, "constraint_catalog");
            return (Criteria) this;
        }

        public Criteria andConstraint_catalogGreaterThan(Object value) {
            addCriterion("constraint_catalog >", value, "constraint_catalog");
            return (Criteria) this;
        }

        public Criteria andConstraint_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("constraint_catalog >=", value, "constraint_catalog");
            return (Criteria) this;
        }

        public Criteria andConstraint_catalogLessThan(Object value) {
            addCriterion("constraint_catalog <", value, "constraint_catalog");
            return (Criteria) this;
        }

        public Criteria andConstraint_catalogLessThanOrEqualTo(Object value) {
            addCriterion("constraint_catalog <=", value, "constraint_catalog");
            return (Criteria) this;
        }

        public Criteria andConstraint_catalogIn(List<Object> values) {
            addCriterion("constraint_catalog in", values, "constraint_catalog");
            return (Criteria) this;
        }

        public Criteria andConstraint_catalogNotIn(List<Object> values) {
            addCriterion("constraint_catalog not in", values, "constraint_catalog");
            return (Criteria) this;
        }

        public Criteria andConstraint_catalogBetween(Object value1, Object value2) {
            addCriterion("constraint_catalog between", value1, value2, "constraint_catalog");
            return (Criteria) this;
        }

        public Criteria andConstraint_catalogNotBetween(Object value1, Object value2) {
            addCriterion("constraint_catalog not between", value1, value2, "constraint_catalog");
            return (Criteria) this;
        }

        public Criteria andConstraint_schemaIsNull() {
            addCriterion("constraint_schema is null");
            return (Criteria) this;
        }

        public Criteria andConstraint_schemaIsNotNull() {
            addCriterion("constraint_schema is not null");
            return (Criteria) this;
        }

        public Criteria andConstraint_schemaEqualTo(Object value) {
            addCriterion("constraint_schema =", value, "constraint_schema");
            return (Criteria) this;
        }

        public Criteria andConstraint_schemaNotEqualTo(Object value) {
            addCriterion("constraint_schema <>", value, "constraint_schema");
            return (Criteria) this;
        }

        public Criteria andConstraint_schemaGreaterThan(Object value) {
            addCriterion("constraint_schema >", value, "constraint_schema");
            return (Criteria) this;
        }

        public Criteria andConstraint_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("constraint_schema >=", value, "constraint_schema");
            return (Criteria) this;
        }

        public Criteria andConstraint_schemaLessThan(Object value) {
            addCriterion("constraint_schema <", value, "constraint_schema");
            return (Criteria) this;
        }

        public Criteria andConstraint_schemaLessThanOrEqualTo(Object value) {
            addCriterion("constraint_schema <=", value, "constraint_schema");
            return (Criteria) this;
        }

        public Criteria andConstraint_schemaIn(List<Object> values) {
            addCriterion("constraint_schema in", values, "constraint_schema");
            return (Criteria) this;
        }

        public Criteria andConstraint_schemaNotIn(List<Object> values) {
            addCriterion("constraint_schema not in", values, "constraint_schema");
            return (Criteria) this;
        }

        public Criteria andConstraint_schemaBetween(Object value1, Object value2) {
            addCriterion("constraint_schema between", value1, value2, "constraint_schema");
            return (Criteria) this;
        }

        public Criteria andConstraint_schemaNotBetween(Object value1, Object value2) {
            addCriterion("constraint_schema not between", value1, value2, "constraint_schema");
            return (Criteria) this;
        }

        public Criteria andConstraint_nameIsNull() {
            addCriterion("constraint_name is null");
            return (Criteria) this;
        }

        public Criteria andConstraint_nameIsNotNull() {
            addCriterion("constraint_name is not null");
            return (Criteria) this;
        }

        public Criteria andConstraint_nameEqualTo(Object value) {
            addCriterion("constraint_name =", value, "constraint_name");
            return (Criteria) this;
        }

        public Criteria andConstraint_nameNotEqualTo(Object value) {
            addCriterion("constraint_name <>", value, "constraint_name");
            return (Criteria) this;
        }

        public Criteria andConstraint_nameGreaterThan(Object value) {
            addCriterion("constraint_name >", value, "constraint_name");
            return (Criteria) this;
        }

        public Criteria andConstraint_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("constraint_name >=", value, "constraint_name");
            return (Criteria) this;
        }

        public Criteria andConstraint_nameLessThan(Object value) {
            addCriterion("constraint_name <", value, "constraint_name");
            return (Criteria) this;
        }

        public Criteria andConstraint_nameLessThanOrEqualTo(Object value) {
            addCriterion("constraint_name <=", value, "constraint_name");
            return (Criteria) this;
        }

        public Criteria andConstraint_nameIn(List<Object> values) {
            addCriterion("constraint_name in", values, "constraint_name");
            return (Criteria) this;
        }

        public Criteria andConstraint_nameNotIn(List<Object> values) {
            addCriterion("constraint_name not in", values, "constraint_name");
            return (Criteria) this;
        }

        public Criteria andConstraint_nameBetween(Object value1, Object value2) {
            addCriterion("constraint_name between", value1, value2, "constraint_name");
            return (Criteria) this;
        }

        public Criteria andConstraint_nameNotBetween(Object value1, Object value2) {
            addCriterion("constraint_name not between", value1, value2, "constraint_name");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_catalogIsNull() {
            addCriterion("unique_constraint_catalog is null");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_catalogIsNotNull() {
            addCriterion("unique_constraint_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_catalogEqualTo(Object value) {
            addCriterion("unique_constraint_catalog =", value, "unique_constraint_catalog");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_catalogNotEqualTo(Object value) {
            addCriterion("unique_constraint_catalog <>", value, "unique_constraint_catalog");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_catalogGreaterThan(Object value) {
            addCriterion("unique_constraint_catalog >", value, "unique_constraint_catalog");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("unique_constraint_catalog >=", value, "unique_constraint_catalog");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_catalogLessThan(Object value) {
            addCriterion("unique_constraint_catalog <", value, "unique_constraint_catalog");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_catalogLessThanOrEqualTo(Object value) {
            addCriterion("unique_constraint_catalog <=", value, "unique_constraint_catalog");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_catalogIn(List<Object> values) {
            addCriterion("unique_constraint_catalog in", values, "unique_constraint_catalog");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_catalogNotIn(List<Object> values) {
            addCriterion("unique_constraint_catalog not in", values, "unique_constraint_catalog");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_catalogBetween(Object value1, Object value2) {
            addCriterion("unique_constraint_catalog between", value1, value2, "unique_constraint_catalog");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_catalogNotBetween(Object value1, Object value2) {
            addCriterion("unique_constraint_catalog not between", value1, value2, "unique_constraint_catalog");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_schemaIsNull() {
            addCriterion("unique_constraint_schema is null");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_schemaIsNotNull() {
            addCriterion("unique_constraint_schema is not null");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_schemaEqualTo(Object value) {
            addCriterion("unique_constraint_schema =", value, "unique_constraint_schema");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_schemaNotEqualTo(Object value) {
            addCriterion("unique_constraint_schema <>", value, "unique_constraint_schema");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_schemaGreaterThan(Object value) {
            addCriterion("unique_constraint_schema >", value, "unique_constraint_schema");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("unique_constraint_schema >=", value, "unique_constraint_schema");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_schemaLessThan(Object value) {
            addCriterion("unique_constraint_schema <", value, "unique_constraint_schema");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_schemaLessThanOrEqualTo(Object value) {
            addCriterion("unique_constraint_schema <=", value, "unique_constraint_schema");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_schemaIn(List<Object> values) {
            addCriterion("unique_constraint_schema in", values, "unique_constraint_schema");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_schemaNotIn(List<Object> values) {
            addCriterion("unique_constraint_schema not in", values, "unique_constraint_schema");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_schemaBetween(Object value1, Object value2) {
            addCriterion("unique_constraint_schema between", value1, value2, "unique_constraint_schema");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_schemaNotBetween(Object value1, Object value2) {
            addCriterion("unique_constraint_schema not between", value1, value2, "unique_constraint_schema");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_nameIsNull() {
            addCriterion("unique_constraint_name is null");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_nameIsNotNull() {
            addCriterion("unique_constraint_name is not null");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_nameEqualTo(Object value) {
            addCriterion("unique_constraint_name =", value, "unique_constraint_name");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_nameNotEqualTo(Object value) {
            addCriterion("unique_constraint_name <>", value, "unique_constraint_name");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_nameGreaterThan(Object value) {
            addCriterion("unique_constraint_name >", value, "unique_constraint_name");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("unique_constraint_name >=", value, "unique_constraint_name");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_nameLessThan(Object value) {
            addCriterion("unique_constraint_name <", value, "unique_constraint_name");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_nameLessThanOrEqualTo(Object value) {
            addCriterion("unique_constraint_name <=", value, "unique_constraint_name");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_nameIn(List<Object> values) {
            addCriterion("unique_constraint_name in", values, "unique_constraint_name");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_nameNotIn(List<Object> values) {
            addCriterion("unique_constraint_name not in", values, "unique_constraint_name");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_nameBetween(Object value1, Object value2) {
            addCriterion("unique_constraint_name between", value1, value2, "unique_constraint_name");
            return (Criteria) this;
        }

        public Criteria andUnique_constraint_nameNotBetween(Object value1, Object value2) {
            addCriterion("unique_constraint_name not between", value1, value2, "unique_constraint_name");
            return (Criteria) this;
        }

        public Criteria andMatch_optionIsNull() {
            addCriterion("match_option is null");
            return (Criteria) this;
        }

        public Criteria andMatch_optionIsNotNull() {
            addCriterion("match_option is not null");
            return (Criteria) this;
        }

        public Criteria andMatch_optionEqualTo(Object value) {
            addCriterion("match_option =", value, "match_option");
            return (Criteria) this;
        }

        public Criteria andMatch_optionNotEqualTo(Object value) {
            addCriterion("match_option <>", value, "match_option");
            return (Criteria) this;
        }

        public Criteria andMatch_optionGreaterThan(Object value) {
            addCriterion("match_option >", value, "match_option");
            return (Criteria) this;
        }

        public Criteria andMatch_optionGreaterThanOrEqualTo(Object value) {
            addCriterion("match_option >=", value, "match_option");
            return (Criteria) this;
        }

        public Criteria andMatch_optionLessThan(Object value) {
            addCriterion("match_option <", value, "match_option");
            return (Criteria) this;
        }

        public Criteria andMatch_optionLessThanOrEqualTo(Object value) {
            addCriterion("match_option <=", value, "match_option");
            return (Criteria) this;
        }

        public Criteria andMatch_optionIn(List<Object> values) {
            addCriterion("match_option in", values, "match_option");
            return (Criteria) this;
        }

        public Criteria andMatch_optionNotIn(List<Object> values) {
            addCriterion("match_option not in", values, "match_option");
            return (Criteria) this;
        }

        public Criteria andMatch_optionBetween(Object value1, Object value2) {
            addCriterion("match_option between", value1, value2, "match_option");
            return (Criteria) this;
        }

        public Criteria andMatch_optionNotBetween(Object value1, Object value2) {
            addCriterion("match_option not between", value1, value2, "match_option");
            return (Criteria) this;
        }

        public Criteria andUpdate_ruleIsNull() {
            addCriterion("update_rule is null");
            return (Criteria) this;
        }

        public Criteria andUpdate_ruleIsNotNull() {
            addCriterion("update_rule is not null");
            return (Criteria) this;
        }

        public Criteria andUpdate_ruleEqualTo(Object value) {
            addCriterion("update_rule =", value, "update_rule");
            return (Criteria) this;
        }

        public Criteria andUpdate_ruleNotEqualTo(Object value) {
            addCriterion("update_rule <>", value, "update_rule");
            return (Criteria) this;
        }

        public Criteria andUpdate_ruleGreaterThan(Object value) {
            addCriterion("update_rule >", value, "update_rule");
            return (Criteria) this;
        }

        public Criteria andUpdate_ruleGreaterThanOrEqualTo(Object value) {
            addCriterion("update_rule >=", value, "update_rule");
            return (Criteria) this;
        }

        public Criteria andUpdate_ruleLessThan(Object value) {
            addCriterion("update_rule <", value, "update_rule");
            return (Criteria) this;
        }

        public Criteria andUpdate_ruleLessThanOrEqualTo(Object value) {
            addCriterion("update_rule <=", value, "update_rule");
            return (Criteria) this;
        }

        public Criteria andUpdate_ruleIn(List<Object> values) {
            addCriterion("update_rule in", values, "update_rule");
            return (Criteria) this;
        }

        public Criteria andUpdate_ruleNotIn(List<Object> values) {
            addCriterion("update_rule not in", values, "update_rule");
            return (Criteria) this;
        }

        public Criteria andUpdate_ruleBetween(Object value1, Object value2) {
            addCriterion("update_rule between", value1, value2, "update_rule");
            return (Criteria) this;
        }

        public Criteria andUpdate_ruleNotBetween(Object value1, Object value2) {
            addCriterion("update_rule not between", value1, value2, "update_rule");
            return (Criteria) this;
        }

        public Criteria andDelete_ruleIsNull() {
            addCriterion("delete_rule is null");
            return (Criteria) this;
        }

        public Criteria andDelete_ruleIsNotNull() {
            addCriterion("delete_rule is not null");
            return (Criteria) this;
        }

        public Criteria andDelete_ruleEqualTo(Object value) {
            addCriterion("delete_rule =", value, "delete_rule");
            return (Criteria) this;
        }

        public Criteria andDelete_ruleNotEqualTo(Object value) {
            addCriterion("delete_rule <>", value, "delete_rule");
            return (Criteria) this;
        }

        public Criteria andDelete_ruleGreaterThan(Object value) {
            addCriterion("delete_rule >", value, "delete_rule");
            return (Criteria) this;
        }

        public Criteria andDelete_ruleGreaterThanOrEqualTo(Object value) {
            addCriterion("delete_rule >=", value, "delete_rule");
            return (Criteria) this;
        }

        public Criteria andDelete_ruleLessThan(Object value) {
            addCriterion("delete_rule <", value, "delete_rule");
            return (Criteria) this;
        }

        public Criteria andDelete_ruleLessThanOrEqualTo(Object value) {
            addCriterion("delete_rule <=", value, "delete_rule");
            return (Criteria) this;
        }

        public Criteria andDelete_ruleIn(List<Object> values) {
            addCriterion("delete_rule in", values, "delete_rule");
            return (Criteria) this;
        }

        public Criteria andDelete_ruleNotIn(List<Object> values) {
            addCriterion("delete_rule not in", values, "delete_rule");
            return (Criteria) this;
        }

        public Criteria andDelete_ruleBetween(Object value1, Object value2) {
            addCriterion("delete_rule between", value1, value2, "delete_rule");
            return (Criteria) this;
        }

        public Criteria andDelete_ruleNotBetween(Object value1, Object value2) {
            addCriterion("delete_rule not between", value1, value2, "delete_rule");
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