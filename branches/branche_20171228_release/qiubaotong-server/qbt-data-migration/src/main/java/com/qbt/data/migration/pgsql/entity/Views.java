package com.qbt.data.migration.pgsql.entity;

public class Views {
    private Object table_catalog;

    private Object table_schema;

    private Object table_name;

    private Object view_definition;

    private Object check_option;

    private Object is_updatable;

    private Object is_insertable_into;

    private Object is_trigger_updatable;

    private Object is_trigger_deletable;

    private Object is_trigger_insertable_into;

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

    public Object getView_definition() {
        return view_definition;
    }

    public void setView_definition(Object view_definition) {
        this.view_definition = view_definition;
    }

    public Object getCheck_option() {
        return check_option;
    }

    public void setCheck_option(Object check_option) {
        this.check_option = check_option;
    }

    public Object getIs_updatable() {
        return is_updatable;
    }

    public void setIs_updatable(Object is_updatable) {
        this.is_updatable = is_updatable;
    }

    public Object getIs_insertable_into() {
        return is_insertable_into;
    }

    public void setIs_insertable_into(Object is_insertable_into) {
        this.is_insertable_into = is_insertable_into;
    }

    public Object getIs_trigger_updatable() {
        return is_trigger_updatable;
    }

    public void setIs_trigger_updatable(Object is_trigger_updatable) {
        this.is_trigger_updatable = is_trigger_updatable;
    }

    public Object getIs_trigger_deletable() {
        return is_trigger_deletable;
    }

    public void setIs_trigger_deletable(Object is_trigger_deletable) {
        this.is_trigger_deletable = is_trigger_deletable;
    }

    public Object getIs_trigger_insertable_into() {
        return is_trigger_insertable_into;
    }

    public void setIs_trigger_insertable_into(Object is_trigger_insertable_into) {
        this.is_trigger_insertable_into = is_trigger_insertable_into;
    }
}