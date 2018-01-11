package com.qbt.data.migration.pgsql.entity;

public class CheckConstraintRoutineUsage {
    private Object constraint_catalog;

    private Object constraint_schema;

    private Object constraint_name;

    private Object specific_catalog;

    private Object specific_schema;

    private Object specific_name;

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