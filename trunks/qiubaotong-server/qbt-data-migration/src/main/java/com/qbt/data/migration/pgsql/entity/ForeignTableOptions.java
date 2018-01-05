package com.qbt.data.migration.pgsql.entity;

public class ForeignTableOptions {
    private Object foreign_table_catalog;

    private String foreign_table_schema;

    private String foreign_table_name;

    private Object option_name;

    private Object option_value;

    public Object getForeign_table_catalog() {
        return foreign_table_catalog;
    }

    public void setForeign_table_catalog(Object foreign_table_catalog) {
        this.foreign_table_catalog = foreign_table_catalog;
    }

    public String getForeign_table_schema() {
        return foreign_table_schema;
    }

    public void setForeign_table_schema(String foreign_table_schema) {
        this.foreign_table_schema = foreign_table_schema == null ? null : foreign_table_schema.trim();
    }

    public String getForeign_table_name() {
        return foreign_table_name;
    }

    public void setForeign_table_name(String foreign_table_name) {
        this.foreign_table_name = foreign_table_name == null ? null : foreign_table_name.trim();
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