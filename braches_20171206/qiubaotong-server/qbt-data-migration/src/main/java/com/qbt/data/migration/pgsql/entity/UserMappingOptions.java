package com.qbt.data.migration.pgsql.entity;

public class UserMappingOptions {
    private Object authorization_identifier;

    private Object foreign_server_catalog;

    private Object foreign_server_name;

    private Object option_name;

    private Object option_value;

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

    public Object getOption_name() {
        return option_name;
    }

    public void setOption_name(Object option_name) {
        this.option_name = option_name;
    }

    public Object getOption_value() {
        return option_value;
    }

    public void setOption_value(Object option_value) {
        this.option_value = option_value;
    }
}