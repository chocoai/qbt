package com.qbt.data.migration.pgsql.entity;

public class Tables {
    private Object table_catalog;

    private Object table_schema;

    private Object table_name;

    private Object table_type;

    private Object self_referencing_column_name;

    private Object reference_generation;

    private Object user_defined_type_catalog;

    private Object user_defined_type_schema;

    private Object user_defined_type_name;

    private Object is_insertable_into;

    private Object is_typed;

    private Object commit_action;

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

    public Object getTable_type() {
        return table_type;
    }

    public void setTable_type(Object table_type) {
        this.table_type = table_type;
    }

    public Object getSelf_referencing_column_name() {
        return self_referencing_column_name;
    }

    public void setSelf_referencing_column_name(Object self_referencing_column_name) {
        this.self_referencing_column_name = self_referencing_column_name;
    }

    public Object getReference_generation() {
        return reference_generation;
    }

    public void setReference_generation(Object reference_generation) {
        this.reference_generation = reference_generation;
    }

    public Object getUser_defined_type_catalog() {
        return user_defined_type_catalog;
    }

    public void setUser_defined_type_catalog(Object user_defined_type_catalog) {
        this.user_defined_type_catalog = user_defined_type_catalog;
    }

    public Object getUser_defined_type_schema() {
        return user_defined_type_schema;
    }

    public void setUser_defined_type_schema(Object user_defined_type_schema) {
        this.user_defined_type_schema = user_defined_type_schema;
    }

    public Object getUser_defined_type_name() {
        return user_defined_type_name;
    }

    public void setUser_defined_type_name(Object user_defined_type_name) {
        this.user_defined_type_name = user_defined_type_name;
    }

    public Object getIs_insertable_into() {
        return is_insertable_into;
    }

    public void setIs_insertable_into(Object is_insertable_into) {
        this.is_insertable_into = is_insertable_into;
    }

    public Object getIs_typed() {
        return is_typed;
    }

    public void setIs_typed(Object is_typed) {
        this.is_typed = is_typed;
    }

    public Object getCommit_action() {
        return commit_action;
    }

    public void setCommit_action(Object commit_action) {
        this.commit_action = commit_action;
    }
}