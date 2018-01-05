package com.qbt.data.migration.pgsql.entity;

public class ViewRoutineUsage {
    private Object table_catalog;

    private Object table_schema;

    private Object table_name;

    private Object specific_catalog;

    private Object specific_schema;

    private Object specific_name;

    public Object getTable_catalog() {
        return table_catalog;
    }

    public void setTable_catalog(Object table_catalog) {
        this.table_catalog = table_catalog;
    }

    public Object getTable_schema() {
        return table_schema;
    }

    public void setTable_schema(Object table_schema) {
        this.table_schema = table_schema;
    }

    public Object getTable_name() {
        return table_name;
    }

    public void setTable_name(Object table_name) {
        this.table_name = table_name;
    }

    public Object getSpecific_catalog() {
        return specific_catalog;
    }

    public void setSpecific_catalog(Object specific_catalog) {
        this.specific_catalog = specific_catalog;
    }

    public Object getSpecific_schema() {
        return specific_schema;
    }

    public void setSpecific_schema(Object specific_schema) {
        this.specific_schema = specific_schema;
    }

    public Object getSpecific_name() {
        return specific_name;
    }

    public void setSpecific_name(Object specific_name) {
        this.specific_name = specific_name;
    }
}