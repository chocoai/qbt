package com.qbt.data.migration.pgsql.entity;

public class DataTypePrivileges {
    private Object object_catalog;

    private Object object_schema;

    private Object object_name;

    private Object object_type;

    private Object dtd_identifier;

    public Object getObject_catalog() {
        return object_catalog;
    }

    public void setObject_catalog(Object object_catalog) {
        this.object_catalog = object_catalog;
    }

    public Object getObject_schema() {
        return object_schema;
    }

    public void setObject_schema(Object object_schema) {
        this.object_schema = object_schema;
    }

    public Object getObject_name() {
        return object_name;
    }

    public void setObject_name(Object object_name) {
        this.object_name = object_name;
    }

    public Object getObject_type() {
        return object_type;
    }

    public void setObject_type(Object object_type) {
        this.object_type = object_type;
    }

    public Object getDtd_identifier() {
        return dtd_identifier;
    }

    public void setDtd_identifier(Object dtd_identifier) {
        this.dtd_identifier = dtd_identifier;
    }
}