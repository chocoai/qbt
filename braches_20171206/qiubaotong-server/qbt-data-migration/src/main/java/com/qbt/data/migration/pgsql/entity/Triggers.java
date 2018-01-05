package com.qbt.data.migration.pgsql.entity;

public class Triggers {
    private Object trigger_catalog;

    private Object trigger_schema;

    private Object trigger_name;

    private Object event_manipulation;

    private Object event_object_catalog;

    private Object event_object_schema;

    private Object event_object_table;

    private Object action_order;

    private Object action_condition;

    private Object action_statement;

    private Object action_orientation;

    private Object action_timing;

    private Object action_reference_old_table;

    private Object action_reference_new_table;

    private Object action_reference_old_row;

    private Object action_reference_new_row;

    private Object created;

    public Object getTrigger_catalog() {
        return trigger_catalog;
    }

    public void setTrigger_catalog(Object trigger_catalog) {
        this.trigger_catalog = trigger_catalog;
    }

    public Object getTrigger_schema() {
        return trigger_schema;
    }

    public void setTrigger_schema(Object trigger_schema) {
        this.trigger_schema = trigger_schema;
    }

    public Object getTrigger_name() {
        return trigger_name;
    }

    public void setTrigger_name(Object trigger_name) {
        this.trigger_name = trigger_name;
    }

    public Object getEvent_manipulation() {
        return event_manipulation;
    }

    public void setEvent_manipulation(Object event_manipulation) {
        this.event_manipulation = event_manipulation;
    }

    public Object getEvent_object_catalog() {
        return event_object_catalog;
    }

    public void setEvent_object_catalog(Object event_object_catalog) {
        this.event_object_catalog = event_object_catalog;
    }

    public Object getEvent_object_schema() {
        return event_object_schema;
    }

    public void setEvent_object_schema(Object event_object_schema) {
        this.event_object_schema = event_object_schema;
    }

    public Object getEvent_object_table() {
        return event_object_table;
    }

    public void setEvent_object_table(Object event_object_table) {
        this.event_object_table = event_object_table;
    }

    public Object getAction_order() {
        return action_order;
    }

    public void setAction_order(Object action_order) {
        this.action_order = action_order;
    }

    public Object getAction_condition() {
        return action_condition;
    }

    public void setAction_condition(Object action_condition) {
        this.action_condition = action_condition;
    }

    public Object getAction_statement() {
        return action_statement;
    }

    public void setAction_statement(Object action_statement) {
        this.action_statement = action_statement;
    }

    public Object getAction_orientation() {
        return action_orientation;
    }

    public void setAction_orientation(Object action_orientation) {
        this.action_orientation = action_orientation;
    }

    public Object getAction_timing() {
        return action_timing;
    }

    public void setAction_timing(Object action_timing) {
        this.action_timing = action_timing;
    }

    public Object getAction_reference_old_table() {
        return action_reference_old_table;
    }

    public void setAction_reference_old_table(Object action_reference_old_table) {
        this.action_reference_old_table = action_reference_old_table;
    }

    public Object getAction_reference_new_table() {
        return action_reference_new_table;
    }

    public void setAction_reference_new_table(Object action_reference_new_table) {
        this.action_reference_new_table = action_reference_new_table;
    }

    public Object getAction_reference_old_row() {
        return action_reference_old_row;
    }

    public void setAction_reference_old_row(Object action_reference_old_row) {
        this.action_reference_old_row = action_reference_old_row;
    }

    public Object getAction_reference_new_row() {
        return action_reference_new_row;
    }

    public void setAction_reference_new_row(Object action_reference_new_row) {
        this.action_reference_new_row = action_reference_new_row;
    }

    public Object getCreated() {
        return created;
    }

    public void setCreated(Object created) {
        this.created = created;
    }
}