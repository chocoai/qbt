package com.qbt.data.migration.pgsql.entity;

public class ViewTableUsage {
    private Object view_catalog;

    private Object view_schema;

    private Object view_name;

    private Object table_catalog;

    private Object table_schema;

    private Object table_name;

    public Object getView_catalog() {
        return view_catalog;
    }

    public void setView_catalog(Object view_catalog) {
        this.view_catalog = view_catalog;
    }

    public Object getView_schema() {
        return view_schema;
    }

    public void setView_schema(Object view_schema) {
        this.view_schema = view_schema;
    }

    public Object getView_name() {
        return view_name;
    }

    public void setView_name(Object view_name) {
        this.view_name = view_name;
    }

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
}