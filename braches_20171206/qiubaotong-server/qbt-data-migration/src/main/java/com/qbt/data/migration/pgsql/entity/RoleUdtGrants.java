package com.qbt.data.migration.pgsql.entity;

public class RoleUdtGrants {
    private Object grantor;

    private Object grantee;

    private Object udt_catalog;

    private Object udt_schema;

    private Object udt_name;

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

    public Object getUdt_catalog() {
        return udt_catalog;
    }

    public void setUdt_catalog(Object udt_catalog) {
        this.udt_catalog = udt_catalog;
    }

    public Object getUdt_schema() {
        return udt_schema;
    }

    public void setUdt_schema(Object udt_schema) {
        this.udt_schema = udt_schema;
    }

    public Object getUdt_name() {
        return udt_name;
    }

    public void setUdt_name(Object udt_name) {
        this.udt_name = udt_name;
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