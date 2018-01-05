package com.qbt.data.migration.pgsql.entity;

public class ColumnUdtUsage {
    private Object udt_catalog;

    private Object udt_schema;

    private Object udt_name;

    private Object table_catalog;

    private Object table_schema;

    private Object table_name;

    private Object column_name;

    public Object getUdt_catalog() {
        return udt_catalog;
    }

    public void setUdt_catalog(Object udt_catalog) {
        this.udt_catalog = udt_catalog;
    }

    public Object getUdt_schema() {
        return udt_schema;
    }

    public void setUdt_schema(Object udt_schema) {
        this.udt_schema = udt_schema;
    }

    public Object getUdt_name() {
        return udt_name;
    }

    public void setUdt_name(Object udt_name) {
        this.udt_name = udt_name;
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

    public Object getColumn_name() {
        return column_name;
    }

    public void setColumn_name(Object column_name) {
        this.column_name = column_name;
    }
}