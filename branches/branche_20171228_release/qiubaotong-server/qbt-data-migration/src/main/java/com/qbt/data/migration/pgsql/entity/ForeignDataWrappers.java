package com.qbt.data.migration.pgsql.entity;

public class ForeignDataWrappers {
    private Object foreign_data_wrapper_catalog;

    private Object foreign_data_wrapper_name;

    private Object authorization_identifier;

    private Object library_name;

    private Object foreign_data_wrapper_language;

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

    public Object getAuthorization_identifier() {
        return authorization_identifier;
    }

    public void setAuthorization_identifier(Object authorization_identifier) {
        this.authorization_identifier = authorization_identifier;
    }

    public Object getLibrary_name() {
        return library_name;
    }

    public void setLibrary_name(Object library_name) {
        this.library_name = library_name;
    }

    public Object getForeign_data_wrapper_language() {
        return foreign_data_wrapper_language;
    }

    public void setForeign_data_wrapper_language(Object foreign_data_wrapper_language) {
        this.foreign_data_wrapper_language = foreign_data_wrapper_language;
    }
}