package com.qbt.data.migration.pgsql.entity;

import java.util.ArrayList;
import java.util.List;

public class TriggersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TriggersExample() {
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

        public Criteria andTrigger_catalogIsNull() {
            addCriterion("trigger_catalog is null");
            return (Criteria) this;
        }

        public Criteria andTrigger_catalogIsNotNull() {
            addCriterion("trigger_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andTrigger_catalogEqualTo(Object value) {
            addCriterion("trigger_catalog =", value, "trigger_catalog");
            return (Criteria) this;
        }

        public Criteria andTrigger_catalogNotEqualTo(Object value) {
            addCriterion("trigger_catalog <>", value, "trigger_catalog");
            return (Criteria) this;
        }

        public Criteria andTrigger_catalogGreaterThan(Object value) {
            addCriterion("trigger_catalog >", value, "trigger_catalog");
            return (Criteria) this;
        }

        public Criteria andTrigger_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("trigger_catalog >=", value, "trigger_catalog");
            return (Criteria) this;
        }

        public Criteria andTrigger_catalogLessThan(Object value) {
            addCriterion("trigger_catalog <", value, "trigger_catalog");
            return (Criteria) this;
        }

        public Criteria andTrigger_catalogLessThanOrEqualTo(Object value) {
            addCriterion("trigger_catalog <=", value, "trigger_catalog");
            return (Criteria) this;
        }

        public Criteria andTrigger_catalogIn(List<Object> values) {
            addCriterion("trigger_catalog in", values, "trigger_catalog");
            return (Criteria) this;
        }

        public Criteria andTrigger_catalogNotIn(List<Object> values) {
            addCriterion("trigger_catalog not in", values, "trigger_catalog");
            return (Criteria) this;
        }

        public Criteria andTrigger_catalogBetween(Object value1, Object value2) {
            addCriterion("trigger_catalog between", value1, value2, "trigger_catalog");
            return (Criteria) this;
        }

        public Criteria andTrigger_catalogNotBetween(Object value1, Object value2) {
            addCriterion("trigger_catalog not between", value1, value2, "trigger_catalog");
            return (Criteria) this;
        }

        public Criteria andTrigger_schemaIsNull() {
            addCriterion("trigger_schema is null");
            return (Criteria) this;
        }

        public Criteria andTrigger_schemaIsNotNull() {
            addCriterion("trigger_schema is not null");
            return (Criteria) this;
        }

        public Criteria andTrigger_schemaEqualTo(Object value) {
            addCriterion("trigger_schema =", value, "trigger_schema");
            return (Criteria) this;
        }

        public Criteria andTrigger_schemaNotEqualTo(Object value) {
            addCriterion("trigger_schema <>", value, "trigger_schema");
            return (Criteria) this;
        }

        public Criteria andTrigger_schemaGreaterThan(Object value) {
            addCriterion("trigger_schema >", value, "trigger_schema");
            return (Criteria) this;
        }

        public Criteria andTrigger_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("trigger_schema >=", value, "trigger_schema");
            return (Criteria) this;
        }

        public Criteria andTrigger_schemaLessThan(Object value) {
            addCriterion("trigger_schema <", value, "trigger_schema");
            return (Criteria) this;
        }

        public Criteria andTrigger_schemaLessThanOrEqualTo(Object value) {
            addCriterion("trigger_schema <=", value, "trigger_schema");
            return (Criteria) this;
        }

        public Criteria andTrigger_schemaIn(List<Object> values) {
            addCriterion("trigger_schema in", values, "trigger_schema");
            return (Criteria) this;
        }

        public Criteria andTrigger_schemaNotIn(List<Object> values) {
            addCriterion("trigger_schema not in", values, "trigger_schema");
            return (Criteria) this;
        }

        public Criteria andTrigger_schemaBetween(Object value1, Object value2) {
            addCriterion("trigger_schema between", value1, value2, "trigger_schema");
            return (Criteria) this;
        }

        public Criteria andTrigger_schemaNotBetween(Object value1, Object value2) {
            addCriterion("trigger_schema not between", value1, value2, "trigger_schema");
            return (Criteria) this;
        }

        public Criteria andTrigger_nameIsNull() {
            addCriterion("trigger_name is null");
            return (Criteria) this;
        }

        public Criteria andTrigger_nameIsNotNull() {
            addCriterion("trigger_name is not null");
            return (Criteria) this;
        }

        public Criteria andTrigger_nameEqualTo(Object value) {
            addCriterion("trigger_name =", value, "trigger_name");
            return (Criteria) this;
        }

        public Criteria andTrigger_nameNotEqualTo(Object value) {
            addCriterion("trigger_name <>", value, "trigger_name");
            return (Criteria) this;
        }

        public Criteria andTrigger_nameGreaterThan(Object value) {
            addCriterion("trigger_name >", value, "trigger_name");
            return (Criteria) this;
        }

        public Criteria andTrigger_nameGreaterThanOrEqualTo(Object value) {
            addCriterion("trigger_name >=", value, "trigger_name");
            return (Criteria) this;
        }

        public Criteria andTrigger_nameLessThan(Object value) {
            addCriterion("trigger_name <", value, "trigger_name");
            return (Criteria) this;
        }

        public Criteria andTrigger_nameLessThanOrEqualTo(Object value) {
            addCriterion("trigger_name <=", value, "trigger_name");
            return (Criteria) this;
        }

        public Criteria andTrigger_nameIn(List<Object> values) {
            addCriterion("trigger_name in", values, "trigger_name");
            return (Criteria) this;
        }

        public Criteria andTrigger_nameNotIn(List<Object> values) {
            addCriterion("trigger_name not in", values, "trigger_name");
            return (Criteria) this;
        }

        public Criteria andTrigger_nameBetween(Object value1, Object value2) {
            addCriterion("trigger_name between", value1, value2, "trigger_name");
            return (Criteria) this;
        }

        public Criteria andTrigger_nameNotBetween(Object value1, Object value2) {
            addCriterion("trigger_name not between", value1, value2, "trigger_name");
            return (Criteria) this;
        }

        public Criteria andEvent_manipulationIsNull() {
            addCriterion("event_manipulation is null");
            return (Criteria) this;
        }

        public Criteria andEvent_manipulationIsNotNull() {
            addCriterion("event_manipulation is not null");
            return (Criteria) this;
        }

        public Criteria andEvent_manipulationEqualTo(Object value) {
            addCriterion("event_manipulation =", value, "event_manipulation");
            return (Criteria) this;
        }

        public Criteria andEvent_manipulationNotEqualTo(Object value) {
            addCriterion("event_manipulation <>", value, "event_manipulation");
            return (Criteria) this;
        }

        public Criteria andEvent_manipulationGreaterThan(Object value) {
            addCriterion("event_manipulation >", value, "event_manipulation");
            return (Criteria) this;
        }

        public Criteria andEvent_manipulationGreaterThanOrEqualTo(Object value) {
            addCriterion("event_manipulation >=", value, "event_manipulation");
            return (Criteria) this;
        }

        public Criteria andEvent_manipulationLessThan(Object value) {
            addCriterion("event_manipulation <", value, "event_manipulation");
            return (Criteria) this;
        }

        public Criteria andEvent_manipulationLessThanOrEqualTo(Object value) {
            addCriterion("event_manipulation <=", value, "event_manipulation");
            return (Criteria) this;
        }

        public Criteria andEvent_manipulationIn(List<Object> values) {
            addCriterion("event_manipulation in", values, "event_manipulation");
            return (Criteria) this;
        }

        public Criteria andEvent_manipulationNotIn(List<Object> values) {
            addCriterion("event_manipulation not in", values, "event_manipulation");
            return (Criteria) this;
        }

        public Criteria andEvent_manipulationBetween(Object value1, Object value2) {
            addCriterion("event_manipulation between", value1, value2, "event_manipulation");
            return (Criteria) this;
        }

        public Criteria andEvent_manipulationNotBetween(Object value1, Object value2) {
            addCriterion("event_manipulation not between", value1, value2, "event_manipulation");
            return (Criteria) this;
        }

        public Criteria andEvent_object_catalogIsNull() {
            addCriterion("event_object_catalog is null");
            return (Criteria) this;
        }

        public Criteria andEvent_object_catalogIsNotNull() {
            addCriterion("event_object_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andEvent_object_catalogEqualTo(Object value) {
            addCriterion("event_object_catalog =", value, "event_object_catalog");
            return (Criteria) this;
        }

        public Criteria andEvent_object_catalogNotEqualTo(Object value) {
            addCriterion("event_object_catalog <>", value, "event_object_catalog");
            return (Criteria) this;
        }

        public Criteria andEvent_object_catalogGreaterThan(Object value) {
            addCriterion("event_object_catalog >", value, "event_object_catalog");
            return (Criteria) this;
        }

        public Criteria andEvent_object_catalogGreaterThanOrEqualTo(Object value) {
            addCriterion("event_object_catalog >=", value, "event_object_catalog");
            return (Criteria) this;
        }

        public Criteria andEvent_object_catalogLessThan(Object value) {
            addCriterion("event_object_catalog <", value, "event_object_catalog");
            return (Criteria) this;
        }

        public Criteria andEvent_object_catalogLessThanOrEqualTo(Object value) {
            addCriterion("event_object_catalog <=", value, "event_object_catalog");
            return (Criteria) this;
        }

        public Criteria andEvent_object_catalogIn(List<Object> values) {
            addCriterion("event_object_catalog in", values, "event_object_catalog");
            return (Criteria) this;
        }

        public Criteria andEvent_object_catalogNotIn(List<Object> values) {
            addCriterion("event_object_catalog not in", values, "event_object_catalog");
            return (Criteria) this;
        }

        public Criteria andEvent_object_catalogBetween(Object value1, Object value2) {
            addCriterion("event_object_catalog between", value1, value2, "event_object_catalog");
            return (Criteria) this;
        }

        public Criteria andEvent_object_catalogNotBetween(Object value1, Object value2) {
            addCriterion("event_object_catalog not between", value1, value2, "event_object_catalog");
            return (Criteria) this;
        }

        public Criteria andEvent_object_schemaIsNull() {
            addCriterion("event_object_schema is null");
            return (Criteria) this;
        }

        public Criteria andEvent_object_schemaIsNotNull() {
            addCriterion("event_object_schema is not null");
            return (Criteria) this;
        }

        public Criteria andEvent_object_schemaEqualTo(Object value) {
            addCriterion("event_object_schema =", value, "event_object_schema");
            return (Criteria) this;
        }

        public Criteria andEvent_object_schemaNotEqualTo(Object value) {
            addCriterion("event_object_schema <>", value, "event_object_schema");
            return (Criteria) this;
        }

        public Criteria andEvent_object_schemaGreaterThan(Object value) {
            addCriterion("event_object_schema >", value, "event_object_schema");
            return (Criteria) this;
        }

        public Criteria andEvent_object_schemaGreaterThanOrEqualTo(Object value) {
            addCriterion("event_object_schema >=", value, "event_object_schema");
            return (Criteria) this;
        }

        public Criteria andEvent_object_schemaLessThan(Object value) {
            addCriterion("event_object_schema <", value, "event_object_schema");
            return (Criteria) this;
        }

        public Criteria andEvent_object_schemaLessThanOrEqualTo(Object value) {
            addCriterion("event_object_schema <=", value, "event_object_schema");
            return (Criteria) this;
        }

        public Criteria andEvent_object_schemaIn(List<Object> values) {
            addCriterion("event_object_schema in", values, "event_object_schema");
            return (Criteria) this;
        }

        public Criteria andEvent_object_schemaNotIn(List<Object> values) {
            addCriterion("event_object_schema not in", values, "event_object_schema");
            return (Criteria) this;
        }

        public Criteria andEvent_object_schemaBetween(Object value1, Object value2) {
            addCriterion("event_object_schema between", value1, value2, "event_object_schema");
            return (Criteria) this;
        }

        public Criteria andEvent_object_schemaNotBetween(Object value1, Object value2) {
            addCriterion("event_object_schema not between", value1, value2, "event_object_schema");
            return (Criteria) this;
        }

        public Criteria andEvent_object_tableIsNull() {
            addCriterion("event_object_table is null");
            return (Criteria) this;
        }

        public Criteria andEvent_object_tableIsNotNull() {
            addCriterion("event_object_table is not null");
            return (Criteria) this;
        }

        public Criteria andEvent_object_tableEqualTo(Object value) {
            addCriterion("event_object_table =", value, "event_object_table");
            return (Criteria) this;
        }

        public Criteria andEvent_object_tableNotEqualTo(Object value) {
            addCriterion("event_object_table <>", value, "event_object_table");
            return (Criteria) this;
        }

        public Criteria andEvent_object_tableGreaterThan(Object value) {
            addCriterion("event_object_table >", value, "event_object_table");
            return (Criteria) this;
        }

        public Criteria andEvent_object_tableGreaterThanOrEqualTo(Object value) {
            addCriterion("event_object_table >=", value, "event_object_table");
            return (Criteria) this;
        }

        public Criteria andEvent_object_tableLessThan(Object value) {
            addCriterion("event_object_table <", value, "event_object_table");
            return (Criteria) this;
        }

        public Criteria andEvent_object_tableLessThanOrEqualTo(Object value) {
            addCriterion("event_object_table <=", value, "event_object_table");
            return (Criteria) this;
        }

        public Criteria andEvent_object_tableIn(List<Object> values) {
            addCriterion("event_object_table in", values, "event_object_table");
            return (Criteria) this;
        }

        public Criteria andEvent_object_tableNotIn(List<Object> values) {
            addCriterion("event_object_table not in", values, "event_object_table");
            return (Criteria) this;
        }

        public Criteria andEvent_object_tableBetween(Object value1, Object value2) {
            addCriterion("event_object_table between", value1, value2, "event_object_table");
            return (Criteria) this;
        }

        public Criteria andEvent_object_tableNotBetween(Object value1, Object value2) {
            addCriterion("event_object_table not between", value1, value2, "event_object_table");
            return (Criteria) this;
        }

        public Criteria andAction_orderIsNull() {
            addCriterion("action_order is null");
            return (Criteria) this;
        }

        public Criteria andAction_orderIsNotNull() {
            addCriterion("action_order is not null");
            return (Criteria) this;
        }

        public Criteria andAction_orderEqualTo(Object value) {
            addCriterion("action_order =", value, "action_order");
            return (Criteria) this;
        }

        public Criteria andAction_orderNotEqualTo(Object value) {
            addCriterion("action_order <>", value, "action_order");
            return (Criteria) this;
        }

        public Criteria andAction_orderGreaterThan(Object value) {
            addCriterion("action_order >", value, "action_order");
            return (Criteria) this;
        }

        public Criteria andAction_orderGreaterThanOrEqualTo(Object value) {
            addCriterion("action_order >=", value, "action_order");
            return (Criteria) this;
        }

        public Criteria andAction_orderLessThan(Object value) {
            addCriterion("action_order <", value, "action_order");
            return (Criteria) this;
        }

        public Criteria andAction_orderLessThanOrEqualTo(Object value) {
            addCriterion("action_order <=", value, "action_order");
            return (Criteria) this;
        }

        public Criteria andAction_orderIn(List<Object> values) {
            addCriterion("action_order in", values, "action_order");
            return (Criteria) this;
        }

        public Criteria andAction_orderNotIn(List<Object> values) {
            addCriterion("action_order not in", values, "action_order");
            return (Criteria) this;
        }

        public Criteria andAction_orderBetween(Object value1, Object value2) {
            addCriterion("action_order between", value1, value2, "action_order");
            return (Criteria) this;
        }

        public Criteria andAction_orderNotBetween(Object value1, Object value2) {
            addCriterion("action_order not between", value1, value2, "action_order");
            return (Criteria) this;
        }

        public Criteria andAction_conditionIsNull() {
            addCriterion("action_condition is null");
            return (Criteria) this;
        }

        public Criteria andAction_conditionIsNotNull() {
            addCriterion("action_condition is not null");
            return (Criteria) this;
        }

        public Criteria andAction_conditionEqualTo(Object value) {
            addCriterion("action_condition =", value, "action_condition");
            return (Criteria) this;
        }

        public Criteria andAction_conditionNotEqualTo(Object value) {
            addCriterion("action_condition <>", value, "action_condition");
            return (Criteria) this;
        }

        public Criteria andAction_conditionGreaterThan(Object value) {
            addCriterion("action_condition >", value, "action_condition");
            return (Criteria) this;
        }

        public Criteria andAction_conditionGreaterThanOrEqualTo(Object value) {
            addCriterion("action_condition >=", value, "action_condition");
            return (Criteria) this;
        }

        public Criteria andAction_conditionLessThan(Object value) {
            addCriterion("action_condition <", value, "action_condition");
            return (Criteria) this;
        }

        public Criteria andAction_conditionLessThanOrEqualTo(Object value) {
            addCriterion("action_condition <=", value, "action_condition");
            return (Criteria) this;
        }

        public Criteria andAction_conditionIn(List<Object> values) {
            addCriterion("action_condition in", values, "action_condition");
            return (Criteria) this;
        }

        public Criteria andAction_conditionNotIn(List<Object> values) {
            addCriterion("action_condition not in", values, "action_condition");
            return (Criteria) this;
        }

        public Criteria andAction_conditionBetween(Object value1, Object value2) {
            addCriterion("action_condition between", value1, value2, "action_condition");
            return (Criteria) this;
        }

        public Criteria andAction_conditionNotBetween(Object value1, Object value2) {
            addCriterion("action_condition not between", value1, value2, "action_condition");
            return (Criteria) this;
        }

        public Criteria andAction_statementIsNull() {
            addCriterion("action_statement is null");
            return (Criteria) this;
        }

        public Criteria andAction_statementIsNotNull() {
            addCriterion("action_statement is not null");
            return (Criteria) this;
        }

        public Criteria andAction_statementEqualTo(Object value) {
            addCriterion("action_statement =", value, "action_statement");
            return (Criteria) this;
        }

        public Criteria andAction_statementNotEqualTo(Object value) {
            addCriterion("action_statement <>", value, "action_statement");
            return (Criteria) this;
        }

        public Criteria andAction_statementGreaterThan(Object value) {
            addCriterion("action_statement >", value, "action_statement");
            return (Criteria) this;
        }

        public Criteria andAction_statementGreaterThanOrEqualTo(Object value) {
            addCriterion("action_statement >=", value, "action_statement");
            return (Criteria) this;
        }

        public Criteria andAction_statementLessThan(Object value) {
            addCriterion("action_statement <", value, "action_statement");
            return (Criteria) this;
        }

        public Criteria andAction_statementLessThanOrEqualTo(Object value) {
            addCriterion("action_statement <=", value, "action_statement");
            return (Criteria) this;
        }

        public Criteria andAction_statementIn(List<Object> values) {
            addCriterion("action_statement in", values, "action_statement");
            return (Criteria) this;
        }

        public Criteria andAction_statementNotIn(List<Object> values) {
            addCriterion("action_statement not in", values, "action_statement");
            return (Criteria) this;
        }

        public Criteria andAction_statementBetween(Object value1, Object value2) {
            addCriterion("action_statement between", value1, value2, "action_statement");
            return (Criteria) this;
        }

        public Criteria andAction_statementNotBetween(Object value1, Object value2) {
            addCriterion("action_statement not between", value1, value2, "action_statement");
            return (Criteria) this;
        }

        public Criteria andAction_orientationIsNull() {
            addCriterion("action_orientation is null");
            return (Criteria) this;
        }

        public Criteria andAction_orientationIsNotNull() {
            addCriterion("action_orientation is not null");
            return (Criteria) this;
        }

        public Criteria andAction_orientationEqualTo(Object value) {
            addCriterion("action_orientation =", value, "action_orientation");
            return (Criteria) this;
        }

        public Criteria andAction_orientationNotEqualTo(Object value) {
            addCriterion("action_orientation <>", value, "action_orientation");
            return (Criteria) this;
        }

        public Criteria andAction_orientationGreaterThan(Object value) {
            addCriterion("action_orientation >", value, "action_orientation");
            return (Criteria) this;
        }

        public Criteria andAction_orientationGreaterThanOrEqualTo(Object value) {
            addCriterion("action_orientation >=", value, "action_orientation");
            return (Criteria) this;
        }

        public Criteria andAction_orientationLessThan(Object value) {
            addCriterion("action_orientation <", value, "action_orientation");
            return (Criteria) this;
        }

        public Criteria andAction_orientationLessThanOrEqualTo(Object value) {
            addCriterion("action_orientation <=", value, "action_orientation");
            return (Criteria) this;
        }

        public Criteria andAction_orientationIn(List<Object> values) {
            addCriterion("action_orientation in", values, "action_orientation");
            return (Criteria) this;
        }

        public Criteria andAction_orientationNotIn(List<Object> values) {
            addCriterion("action_orientation not in", values, "action_orientation");
            return (Criteria) this;
        }

        public Criteria andAction_orientationBetween(Object value1, Object value2) {
            addCriterion("action_orientation between", value1, value2, "action_orientation");
            return (Criteria) this;
        }

        public Criteria andAction_orientationNotBetween(Object value1, Object value2) {
            addCriterion("action_orientation not between", value1, value2, "action_orientation");
            return (Criteria) this;
        }

        public Criteria andAction_timingIsNull() {
            addCriterion("action_timing is null");
            return (Criteria) this;
        }

        public Criteria andAction_timingIsNotNull() {
            addCriterion("action_timing is not null");
            return (Criteria) this;
        }

        public Criteria andAction_timingEqualTo(Object value) {
            addCriterion("action_timing =", value, "action_timing");
            return (Criteria) this;
        }

        public Criteria andAction_timingNotEqualTo(Object value) {
            addCriterion("action_timing <>", value, "action_timing");
            return (Criteria) this;
        }

        public Criteria andAction_timingGreaterThan(Object value) {
            addCriterion("action_timing >", value, "action_timing");
            return (Criteria) this;
        }

        public Criteria andAction_timingGreaterThanOrEqualTo(Object value) {
            addCriterion("action_timing >=", value, "action_timing");
            return (Criteria) this;
        }

        public Criteria andAction_timingLessThan(Object value) {
            addCriterion("action_timing <", value, "action_timing");
            return (Criteria) this;
        }

        public Criteria andAction_timingLessThanOrEqualTo(Object value) {
            addCriterion("action_timing <=", value, "action_timing");
            return (Criteria) this;
        }

        public Criteria andAction_timingIn(List<Object> values) {
            addCriterion("action_timing in", values, "action_timing");
            return (Criteria) this;
        }

        public Criteria andAction_timingNotIn(List<Object> values) {
            addCriterion("action_timing not in", values, "action_timing");
            return (Criteria) this;
        }

        public Criteria andAction_timingBetween(Object value1, Object value2) {
            addCriterion("action_timing between", value1, value2, "action_timing");
            return (Criteria) this;
        }

        public Criteria andAction_timingNotBetween(Object value1, Object value2) {
            addCriterion("action_timing not between", value1, value2, "action_timing");
            return (Criteria) this;
        }

        public Criteria andAction_reference_old_tableIsNull() {
            addCriterion("action_reference_old_table is null");
            return (Criteria) this;
        }

        public Criteria andAction_reference_old_tableIsNotNull() {
            addCriterion("action_reference_old_table is not null");
            return (Criteria) this;
        }

        public Criteria andAction_reference_old_tableEqualTo(Object value) {
            addCriterion("action_reference_old_table =", value, "action_reference_old_table");
            return (Criteria) this;
        }

        public Criteria andAction_reference_old_tableNotEqualTo(Object value) {
            addCriterion("action_reference_old_table <>", value, "action_reference_old_table");
            return (Criteria) this;
        }

        public Criteria andAction_reference_old_tableGreaterThan(Object value) {
            addCriterion("action_reference_old_table >", value, "action_reference_old_table");
            return (Criteria) this;
        }

        public Criteria andAction_reference_old_tableGreaterThanOrEqualTo(Object value) {
            addCriterion("action_reference_old_table >=", value, "action_reference_old_table");
            return (Criteria) this;
        }

        public Criteria andAction_reference_old_tableLessThan(Object value) {
            addCriterion("action_reference_old_table <", value, "action_reference_old_table");
            return (Criteria) this;
        }

        public Criteria andAction_reference_old_tableLessThanOrEqualTo(Object value) {
            addCriterion("action_reference_old_table <=", value, "action_reference_old_table");
            return (Criteria) this;
        }

        public Criteria andAction_reference_old_tableIn(List<Object> values) {
            addCriterion("action_reference_old_table in", values, "action_reference_old_table");
            return (Criteria) this;
        }

        public Criteria andAction_reference_old_tableNotIn(List<Object> values) {
            addCriterion("action_reference_old_table not in", values, "action_reference_old_table");
            return (Criteria) this;
        }

        public Criteria andAction_reference_old_tableBetween(Object value1, Object value2) {
            addCriterion("action_reference_old_table between", value1, value2, "action_reference_old_table");
            return (Criteria) this;
        }

        public Criteria andAction_reference_old_tableNotBetween(Object value1, Object value2) {
            addCriterion("action_reference_old_table not between", value1, value2, "action_reference_old_table");
            return (Criteria) this;
        }

        public Criteria andAction_reference_new_tableIsNull() {
            addCriterion("action_reference_new_table is null");
            return (Criteria) this;
        }

        public Criteria andAction_reference_new_tableIsNotNull() {
            addCriterion("action_reference_new_table is not null");
            return (Criteria) this;
        }

        public Criteria andAction_reference_new_tableEqualTo(Object value) {
            addCriterion("action_reference_new_table =", value, "action_reference_new_table");
            return (Criteria) this;
        }

        public Criteria andAction_reference_new_tableNotEqualTo(Object value) {
            addCriterion("action_reference_new_table <>", value, "action_reference_new_table");
            return (Criteria) this;
        }

        public Criteria andAction_reference_new_tableGreaterThan(Object value) {
            addCriterion("action_reference_new_table >", value, "action_reference_new_table");
            return (Criteria) this;
        }

        public Criteria andAction_reference_new_tableGreaterThanOrEqualTo(Object value) {
            addCriterion("action_reference_new_table >=", value, "action_reference_new_table");
            return (Criteria) this;
        }

        public Criteria andAction_reference_new_tableLessThan(Object value) {
            addCriterion("action_reference_new_table <", value, "action_reference_new_table");
            return (Criteria) this;
        }

        public Criteria andAction_reference_new_tableLessThanOrEqualTo(Object value) {
            addCriterion("action_reference_new_table <=", value, "action_reference_new_table");
            return (Criteria) this;
        }

        public Criteria andAction_reference_new_tableIn(List<Object> values) {
            addCriterion("action_reference_new_table in", values, "action_reference_new_table");
            return (Criteria) this;
        }

        public Criteria andAction_reference_new_tableNotIn(List<Object> values) {
            addCriterion("action_reference_new_table not in", values, "action_reference_new_table");
            return (Criteria) this;
        }

        public Criteria andAction_reference_new_tableBetween(Object value1, Object value2) {
            addCriterion("action_reference_new_table between", value1, value2, "action_reference_new_table");
            return (Criteria) this;
        }

        public Criteria andAction_reference_new_tableNotBetween(Object value1, Object value2) {
            addCriterion("action_reference_new_table not between", value1, value2, "action_reference_new_table");
            return (Criteria) this;
        }

        public Criteria andAction_reference_old_rowIsNull() {
            addCriterion("action_reference_old_row is null");
            return (Criteria) this;
        }

        public Criteria andAction_reference_old_rowIsNotNull() {
            addCriterion("action_reference_old_row is not null");
            return (Criteria) this;
        }

        public Criteria andAction_reference_old_rowEqualTo(Object value) {
            addCriterion("action_reference_old_row =", value, "action_reference_old_row");
            return (Criteria) this;
        }

        public Criteria andAction_reference_old_rowNotEqualTo(Object value) {
            addCriterion("action_reference_old_row <>", value, "action_reference_old_row");
            return (Criteria) this;
        }

        public Criteria andAction_reference_old_rowGreaterThan(Object value) {
            addCriterion("action_reference_old_row >", value, "action_reference_old_row");
            return (Criteria) this;
        }

        public Criteria andAction_reference_old_rowGreaterThanOrEqualTo(Object value) {
            addCriterion("action_reference_old_row >=", value, "action_reference_old_row");
            return (Criteria) this;
        }

        public Criteria andAction_reference_old_rowLessThan(Object value) {
            addCriterion("action_reference_old_row <", value, "action_reference_old_row");
            return (Criteria) this;
        }

        public Criteria andAction_reference_old_rowLessThanOrEqualTo(Object value) {
            addCriterion("action_reference_old_row <=", value, "action_reference_old_row");
            return (Criteria) this;
        }

        public Criteria andAction_reference_old_rowIn(List<Object> values) {
            addCriterion("action_reference_old_row in", values, "action_reference_old_row");
            return (Criteria) this;
        }

        public Criteria andAction_reference_old_rowNotIn(List<Object> values) {
            addCriterion("action_reference_old_row not in", values, "action_reference_old_row");
            return (Criteria) this;
        }

        public Criteria andAction_reference_old_rowBetween(Object value1, Object value2) {
            addCriterion("action_reference_old_row between", value1, value2, "action_reference_old_row");
            return (Criteria) this;
        }

        public Criteria andAction_reference_old_rowNotBetween(Object value1, Object value2) {
            addCriterion("action_reference_old_row not between", value1, value2, "action_reference_old_row");
            return (Criteria) this;
        }

        public Criteria andAction_reference_new_rowIsNull() {
            addCriterion("action_reference_new_row is null");
            return (Criteria) this;
        }

        public Criteria andAction_reference_new_rowIsNotNull() {
            addCriterion("action_reference_new_row is not null");
            return (Criteria) this;
        }

        public Criteria andAction_reference_new_rowEqualTo(Object value) {
            addCriterion("action_reference_new_row =", value, "action_reference_new_row");
            return (Criteria) this;
        }

        public Criteria andAction_reference_new_rowNotEqualTo(Object value) {
            addCriterion("action_reference_new_row <>", value, "action_reference_new_row");
            return (Criteria) this;
        }

        public Criteria andAction_reference_new_rowGreaterThan(Object value) {
            addCriterion("action_reference_new_row >", value, "action_reference_new_row");
            return (Criteria) this;
        }

        public Criteria andAction_reference_new_rowGreaterThanOrEqualTo(Object value) {
            addCriterion("action_reference_new_row >=", value, "action_reference_new_row");
            return (Criteria) this;
        }

        public Criteria andAction_reference_new_rowLessThan(Object value) {
            addCriterion("action_reference_new_row <", value, "action_reference_new_row");
            return (Criteria) this;
        }

        public Criteria andAction_reference_new_rowLessThanOrEqualTo(Object value) {
            addCriterion("action_reference_new_row <=", value, "action_reference_new_row");
            return (Criteria) this;
        }

        public Criteria andAction_reference_new_rowIn(List<Object> values) {
            addCriterion("action_reference_new_row in", values, "action_reference_new_row");
            return (Criteria) this;
        }

        public Criteria andAction_reference_new_rowNotIn(List<Object> values) {
            addCriterion("action_reference_new_row not in", values, "action_reference_new_row");
            return (Criteria) this;
        }

        public Criteria andAction_reference_new_rowBetween(Object value1, Object value2) {
            addCriterion("action_reference_new_row between", value1, value2, "action_reference_new_row");
            return (Criteria) this;
        }

        public Criteria andAction_reference_new_rowNotBetween(Object value1, Object value2) {
            addCriterion("action_reference_new_row not between", value1, value2, "action_reference_new_row");
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