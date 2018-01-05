package com.qbt.data.migration.pgsql.entity;

public class ColumnDomainUsage {
    private Object domain_catalog;

    private Object domain_schema;

    private Object domain_name;

    private Object table_catalog;

    private Object table_schema;

    private Object table_name;

    private Object column_name;

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