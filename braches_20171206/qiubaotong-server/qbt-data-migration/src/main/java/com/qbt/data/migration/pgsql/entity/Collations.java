package com.qbt.data.migration.pgsql.entity;

public class Collations {
    private Object collation_catalog;

    private Object collation_schema;

    private Object collation_name;

    private Object pad_attribute;

    public Object getCollation_catalog() {
        return collation_catalog;
    }

    public void setCollation_catalog(Object collation_catalog) {
        this.collation_catalog = collation_catalog;
    }

    public Object getCollation_schema() {
        return collation_schema;
    }

    public void setCollation_schema(Object collation_schema) {
        this.collation_schema = collation_schema;
    }

    public Object getCollation_name() {
        return collation_name;
    }

    public void setCollation_name(Object collation_name) {
        this.collation_name = collation_name;
    }

    public Object getPad_attribute() {
        return pad_attribute;
    }

    public void setPad_attribute(Object pad_attribute) {
        this.pad_attribute = pad_attribute;
    }
}