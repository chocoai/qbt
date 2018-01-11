package com.qbt.data.migration.pgsql.entity;

public class DomainConstraints {
    private Object constraint_catalog;

    private Object constraint_schema;

    private Object constraint_name;

    private Object domain_catalog;

    private Object domain_schema;

    private Object domain_name;

    private Object is_deferrable;

    private Object initially_deferred;

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

    public Object getDomain_catalog() {
        return domain_catalog;
    }

    public void setDomain_catalog(Object domain_catalog) {
        this.domain_catalog = domain_catalog;
    }

    public Object getDomain_schema() {
        return domain_schema;
    }

    public void setDomain_schema(Object domain_schema) {
        this.domain_schema = domain_schema;
    }

    public Object getDomain_name() {
        return domain_name;
    }

    public void setDomain_name(Object domain_name) {
        this.domain_name = domain_name;
    }

    public Object getIs_deferrable() {
        return is_deferrable;
    }

    public void setIs_deferrable(Object is_deferrable) {
        this.is_deferrable = is_deferrable;
    }

    public Object getInitially_deferred() {
        return initially_deferred;
    }

    public void setInitially_deferred(Object initially_deferred) {
        this.initially_deferred = initially_deferred;
    }
}