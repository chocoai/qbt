package com.qbt.data.migration.pgsql.entity;

public class DomainUdtUsage {
    private Object udt_catalog;

    private Object udt_schema;

    private Object udt_name;

    private Object domain_catalog;

    private Object domain_schema;

    private Object domain_name;

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
}