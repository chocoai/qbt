package com.qbt.data.migration.pgsql.entity;

public class UsagePrivileges {
    private Object grantor;

    private Object grantee;

    private Object object_catalog;

    private Object object_schema;

    private Object object_name;

    private Object object_type;

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

    public Object getObject_catalog() {
        return object_catalog;
    }

    public void setObject_catalog(Object object_catalog) {
        this.object_catalog = object_catalog;
    }

    public Object getObject_schema() {
        return object_schema;
    }

    public void setObject_schema(Object object_schema) {
        this.object_schema = object_schema;
    }

    public Object getObject_name() {
        return object_name;
    }

    public void setObject_name(Object object_name) {
        this.object_name = object_name;
    }

    public Object getObject_type() {
        return object_type;
    }

    public void setObject_type(Object object_type) {
        this.object_type = object_type;
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