package com.qbt.data.migration.pgsql.entity;

public class PgUserMappings {
    private Long oid;

    private Object umoptions;

    private Long umuser;

    private Object authorization_identifier;

    private Object foreign_server_catalog;

    private Object foreign_server_name;

    private Object srvowner;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Object getUmoptions() {
        return umoptions;
    }

    public void setUmoptions(Object umoptions) {
        this.umoptions = umoptions;
    }

    public Long getUmuser() {
        return umuser;
    }

    public void setUmuser(Long umuser) {
        this.umuser = umuser;
    }

    public Object getAuthorization_identifier() {
        return authorization_identifier;
    }

    public void setAuthorization_identifier(Object authorization_identifier) {
        this.authorization_identifier = authorization_identifier;
    }

    public Object getForeign_server_catalog() {
        return foreign_server_catalog;
    }

    public void setForeign_server_catalog(Object foreign_server_catalog) {
        this.foreign_server_catalog = foreign_server_catalog;
    }

    public Object getForeign_server_name() {
        return foreign_server_name;
    }

    public void setForeign_server_name(Object foreign_server_name) {
        this.foreign_server_name = foreign_server_name;
    }

    public Object getSrvowner() {
        return srvowner;
    }

    public void setSrvowner(Object srvowner) {
        this.srvowner = srvowner;
    }
}