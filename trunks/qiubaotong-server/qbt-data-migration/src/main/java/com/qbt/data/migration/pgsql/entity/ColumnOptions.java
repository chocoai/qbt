package com.qbt.data.migration.pgsql.entity;

public class ColumnOptions {
    private Object table_catalog;

    private String table_schema;

    private String table_name;

    private String column_name;

    private Object option_name;

    private Object option_value;

    public Object getTable_catalog() {
        return table_catalog;
    }

    public void setTable_catalog(Object table_catalog) {
        this.table_catalog = table_catalog;
    }

    public String getTable_schema() {
        return table_schema;
    }

    public void setTable_schema(String table_schema) {
        this.table_schema = table_schema == null ? null : table_schema.trim();
    }

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name == null ? null : table_name.trim();
    }

    public String getColumn_name() {
        return column_name;
    }

    public void setColumn_name(String column_name) {
        this.column_name = column_name == null ? null : column_name.trim();
    }

    public Object getOption_name() {
        return option_name;
    }

    public void setOption_name(Object option_name) {
        this.option_name = option_name;
    }

    public Object getOption_value() {
        return option_value;
    }

    public void setOption_value(Object option_value) {
        this.option_value = option_value;
    }
}