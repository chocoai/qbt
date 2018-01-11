package com.qbt.data.migration.pgsql.entity;

public class ForeignServers {
    private Object foreign_server_catalog;

    private Object foreign_server_name;

    private Object foreign_data_wrapper_catalog;

    private Object foreign_data_wrapper_name;

    private Object foreign_server_type;

    private Object foreign_server_version;

    private Object authorization_identifier;

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

    public Object getForeign_data_wrapper_catalog() {
        return foreign_data_wrapper_catalog;
    }

    public void setForeign_data_wrapper_catalog(Object foreign_data_wrapper_catalog) {
        this.foreign_data_wrapper_catalog = foreign_data_wrapper_catalog;
    }

    public Object getForeign_data_wrapper_name() {
        return foreign_data_wrapper_name;
    }

    public void setForeign_data_wrapper_name(Object foreign_data_wrapper_name) {
        this.foreign_data_wrapper_name = foreign_data_wrapper_name;
    }

    public Object getForeign_server_type() {
        return foreign_server_type;
    }

    public void setForeign_server_type(Object foreign_server_type) {
        this.foreign_server_type = foreign_server_type;
    }

    public Object getForeign_server_version() {
        return foreign_server_version;
    }

    public void setForeign_server_version(Object foreign_server_version) {
        this.foreign_server_version = foreign_server_version;
    }

    public Object getAuthorization_identifier() {
        return authorization_identifier;
    }

    public void setAuthorization_identifier(Object authorization_identifier) {
        this.authorization_identifier = authorization_identifier;
    }
}