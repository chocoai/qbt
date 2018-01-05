package com.qbt.data.migration.pgsql.entity;

public class ConstraintColumnUsage {
    private Object table_catalog;

    private Object table_schema;

    private Object table_name;

    private Object column_name;

    private Object constraint_catalog;

    private Object constraint_schema;

    private Object constraint_name;

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

    public Object getConstraint_catalog() {
        return constraint_catalog;
    }

    public void setConstraint_catalog(Object constraint_catalog) {
        this.constraint_catalog = constraint_catalog;
    }

    public Object getConstraint_schema() {
        return constraint_schema;
    }

    public void setConstraint_schema(Object constraint_schema) {
        this.constraint_schema = constraint_schema;
    }

    public Object getConstraint_name() {
        return constraint_name;
    }

    public void setConstraint_name(Object constraint_name) {
        this.constraint_name = constraint_name;
    }
}