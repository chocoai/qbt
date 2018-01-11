package com.qbt.data.migration.pgsql.entity;

public class UserMappings {
    private Object authorization_identifier;

    private Object foreign_server_catalog;

    private Object foreign_server_name;

    public Object getAuthorization_identifier() {
        return authorization_identifier;
    }

    public void setAuthorization_identifier(Object authorization_identifier) {
        this.authorization_identifier = authorization_identifier;
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
}