package com.qbt.data.migration.pgsql.entity;

public class AdministrableRoleAuthorizations {
    private Object grantee;

    private Object role_name;

    private Object is_grantable;

    public Object getGrantee() {
        return grantee;
    }

    public void setGrantee(Object grantee) {
        this.grantee = grantee;
    }

    public Object getRole_name() {
        return role_name;
    }

    public void setRole_name(Object role_name) {
        this.role_name = role_name;
    }

    public Object getIs_grantable() {
        return is_grantable;
    }

    public void setIs_grantable(Object is_grantable) {
        this.is_grantable = is_grantable;
    }
}