package com.qbt.data.migration.pgsql.entity;

import java.util.Date;

public class PgCursors {
    private String name;

    private String statement;

    private Boolean is_holdable;

    private Boolean is_binary;

    private Boolean is_scrollable;

    private Date creation_time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement == null ? null : statement.trim();
    }

    public Boolean getIs_holdable() {
        return is_holdable;
    }

    public void setIs_holdable(Boolean is_holdable) {
        this.is_holdable = is_holdable;
    }

    public Boolean getIs_binary() {
        return is_binary;
    }

    public void setIs_binary(Boolean is_binary) {
        this.is_binary = is_binary;
    }

    public Boolean getIs_scrollable() {
        return is_scrollable;
    }

    public void setIs_scrollable(Boolean is_scrollable) {
        this.is_scrollable = is_scrollable;
    }

    public Date getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(Date creation_time) {
        this.creation_time = creation_time;
    }
}