package com.qbt.data.migration.pgsql.entity;

public class CheckConstraints {
    private Object constraint_catalog;

    private Object constraint_schema;

    private Object constraint_name;

    private Object check_clause;

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

    public Object getCheck_clause() {
        return check_clause;
    }

    public void setCheck_clause(Object check_clause) {
        this.check_clause = check_clause;
    }
}