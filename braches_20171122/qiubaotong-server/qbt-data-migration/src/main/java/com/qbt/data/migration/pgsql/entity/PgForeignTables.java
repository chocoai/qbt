package com.qbt.data.migration.pgsql.entity;

public class PgForeignTables {
    private Object foreign_table_catalog;

    private String foreign_table_schema;

    private String foreign_table_name;

    private Object ftoptions;

    private Object foreign_server_catalog;

    private Object foreign_server_name;

    private Object authorization_identifier;

    public Object getForeign_table_catalog() {
        return foreign_table_catalog;
    }

    public void setForeign_table_catalog(Object foreign_table_catalog) {
        this.foreign_table_catalog = foreign_table_catalog;
    }

    public String getForeign_table_schema() {
        return foreign_table_schema;
    }

    public void setForeign_table_schema(String foreign_table_schema) {
        this.foreign_table_schema = foreign_table_schema == null ? null : foreign_table_schema.trim();
    }

    public String getForeign_table_name() {
        return foreign_table_name;
    }

    public void setForeign_table_name(String foreign_table_name) {
        this.foreign_table_name = foreign_table_name == null ? null : foreign_table_name.trim();
    }

    public Object getFtoptions() {
        return ftoptions;
    }

    public void setFtoptions(Object ftoptions) {
        this.ftoptions = ftoptions;
    }

    public Object getForeign_server_catalog() {
        return foreign_server_catalog;
    }

    public void setForeign_server_catalog(Object foreign_server_catalog) {
        this.foreign_server_catalog = foreign_server_catalog;
    }

    public Object getForeign_server_name() {
        return foreign_server_name;
    }

    public void setForeign_server_name(Object foreign_server_name) {
        this.foreign_server_name = foreign_server_name;
    }

    public Object getAuthorization_identifier() {
        return authorization_identifier;
    }

    public void setAuthorization_identifier(Object authorization_identifier) {
        this.authorization_identifier = authorization_identifier;
    }
}