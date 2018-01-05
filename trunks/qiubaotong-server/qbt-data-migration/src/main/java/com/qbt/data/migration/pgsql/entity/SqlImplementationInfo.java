package com.qbt.data.migration.pgsql.entity;

public class SqlImplementationInfo {
    private Object implementation_info_id;

    private Object implementation_info_name;

    private Object integer_value;

    private Object character_value;

    private Object comments;

    public Object getImplementation_info_id() {
        return implementation_info_id;
    }

    public void setImplementation_info_id(Object implementation_info_id) {
        this.implementation_info_id = implementation_info_id;
    }

    public Object getImplementation_info_name() {
        return implementation_info_name;
    }

    public void setImplementation_info_name(Object implementation_info_name) {
        this.implementation_info_name = implementation_info_name;
    }

    public Object getInteger_value() {
        return integer_value;
    }

    public void setInteger_value(Object integer_value) {
        this.integer_value = integer_value;
    }

    public Object getCharacter_value() {
        return character_value;
    }

    public void setCharacter_value(Object character_value) {
        this.character_value = character_value;
    }

    public Object getComments() {
        return comments;
    }

    public void setComments(Object comments) {
        this.comments = comments;
    }
}