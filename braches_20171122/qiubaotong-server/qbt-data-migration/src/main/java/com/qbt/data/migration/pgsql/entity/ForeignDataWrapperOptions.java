package com.qbt.data.migration.pgsql.entity;

public class ForeignDataWrapperOptions {
    private Object foreign_data_wrapper_catalog;

    private Object foreign_data_wrapper_name;

    private Object option_name;

    private Object option_value;

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