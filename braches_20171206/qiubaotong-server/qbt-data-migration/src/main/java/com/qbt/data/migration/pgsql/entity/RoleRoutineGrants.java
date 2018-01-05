package com.qbt.data.migration.pgsql.entity;

public class RoleRoutineGrants {
    private Object grantor;

    private Object grantee;

    private Object specific_catalog;

    private Object specific_schema;

    private Object specific_name;

    private Object routine_catalog;

    private Object routine_schema;

    private Object routine_name;

    private Object privilege_type;

    private Object is_grantable;

    public Object getGrantor() {
        return grantor;
    }

    public void setGrantor(Object grantor) {
        this.grantor = grantor;
    }

    public Object getGrantee() {
        return grantee;
    }

    public void setGrantee(Object grantee) {
        this.grantee = grantee;
    }

    public Object getSpecific_catalog() {
        return specific_catalog;
    }

    public void setSpecific_catalog(Object specific_catalog) {
        this.specific_catalog = specific_catalog;
    }

    public Object getSpecific_schema() {
        return specific_schema;
    }

    public void setSpecific_schema(Object specific_schema) {
        this.specific_schema = specific_schema;
    }

    public Object getSpecific_name() {
        return specific_name;
    }

    public void setSpecific_name(Object specific_name) {
        this.specific_name = specific_name;
    }

    public Object getRoutine_catalog() {
        return routine_catalog;
    }

    public void setRoutine_catalog(Object routine_catalog) {
        this.routine_catalog = routine_catalog;
    }

    public Object getRoutine_schema() {
        return routine_schema;
    }

    public void setRoutine_schema(Object routine_schema) {
        this.routine_schema = routine_schema;
    }

    public Object getRoutine_name() {
        return routine_name;
    }

    public void setRoutine_name(Object routine_name) {
        this.routine_name = routine_name;
    }

    public Object getPrivilege_type() {
        return privilege_type;
    }

    public void setPrivilege_type(Object privilege_type) {
        this.privilege_type = privilege_type;
    }

    public Object getIs_grantable() {
        return is_grantable;
    }

    public void setIs_grantable(Object is_grantable) {
        this.is_grantable = is_grantable;
    }
}