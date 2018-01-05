package com.qbt.data.migration.pgsql.entity;

public class SqlSizing {
    private Object sizing_id;

    private Object sizing_name;

    private Object supported_value;

    private Object comments;

    public Object getSizing_id() {
        return sizing_id;
    }

    public void setSizing_id(Object sizing_id) {
        this.sizing_id = sizing_id;
    }

    public Object getSizing_name() {
        return sizing_name;
    }

    public void setSizing_name(Object sizing_name) {
        this.sizing_name = sizing_name;
    }

    public Object getSupported_value() {
        return supported_value;
    }

    public void setSupported_value(Object supported_value) {
        this.supported_value = supported_value;
    }

    public Object getComments() {
        return comments;
    }

    public void setComments(Object comments) {
        this.comments = comments;
    }
}