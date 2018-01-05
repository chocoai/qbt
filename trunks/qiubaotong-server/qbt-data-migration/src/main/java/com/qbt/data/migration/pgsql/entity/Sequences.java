package com.qbt.data.migration.pgsql.entity;

public class Sequences {
    private Object sequence_catalog;

    private Object sequence_schema;

    private Object sequence_name;

    private Object data_type;

    private Object numeric_precision;

    private Object numeric_precision_radix;

    private Object numeric_scale;

    private Object start_value;

    private Object minimum_value;

    private Object maximum_value;

    private Object increment;

    private Object cycle_option;

    public Object getSequence_catalog() {
        return sequence_catalog;
    }

    public void setSequence_catalog(Object sequence_catalog) {
        this.sequence_catalog = sequence_catalog;
    }

    public Object getSequence_schema() {
        return sequence_schema;
    }

    public void setSequence_schema(Object sequence_schema) {
        this.sequence_schema = sequence_schema;
    }

    public Object getSequence_name() {
        return sequence_name;
    }

    public void setSequence_name(Object sequence_name) {
        this.sequence_name = sequence_name;
    }

    public Object getData_type() {
        return data_type;
    }

    public void setData_type(Object data_type) {
        this.data_type = data_type;
    }

    public Object getNumeric_precision() {
        return numeric_precision;
    }

    public void setNumeric_precision(Object numeric_precision) {
        this.numeric_precision = numeric_precision;
    }

    public Object getNumeric_precision_radix() {
        return numeric_precision_radix;
    }

    public void setNumeric_precision_radix(Object numeric_precision_radix) {
        this.numeric_precision_radix = numeric_precision_radix;
    }

    public Object getNumeric_scale() {
        return numeric_scale;
    }

    public void setNumeric_scale(Object numeric_scale) {
        this.numeric_scale = numeric_scale;
    }

    public Object getStart_value() {
        return start_value;
    }

    public void setStart_value(Object start_value) {
        this.start_value = start_value;
    }

    public Object getMinimum_value() {
        return minimum_value;
    }

    public void setMinimum_value(Object minimum_value) {
        this.minimum_value = minimum_value;
    }

    public Object getMaximum_value() {
        return maximum_value;
    }

    public void setMaximum_value(Object maximum_value) {
        this.maximum_value = maximum_value;
    }

    public Object getIncrement() {
        return increment;
    }

    public void setIncrement(Object increment) {
        this.increment = increment;
    }

    public Object getCycle_option() {
        return cycle_option;
    }

    public void setCycle_option(Object cycle_option) {
        this.cycle_option = cycle_option;
    }
}