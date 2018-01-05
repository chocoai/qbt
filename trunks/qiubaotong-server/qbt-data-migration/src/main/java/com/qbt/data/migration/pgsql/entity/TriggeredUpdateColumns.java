package com.qbt.data.migration.pgsql.entity;

public class TriggeredUpdateColumns {
    private Object trigger_catalog;

    private Object trigger_schema;

    private Object trigger_name;

    private Object event_object_catalog;

    private Object event_object_schema;

    private Object event_object_table;

    private Object event_object_column;

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

    public Object getEvent_object_column() {
        return event_object_column;
    }

    public void setEvent_object_column(Object event_object_column) {
        this.event_object_column = event_object_column;
    }
}