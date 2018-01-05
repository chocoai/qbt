package com.qbt.data.migration.pgsql.entity;

public class PgUserMapping {
    private Long umuser;

    private Long umserver;

    private Object umoptions;

    public Long getUmuser() {
        return umuser;
    }

    public void setUmuser(Long umuser) {
        this.umuser = umuser;
    }

    public Long getUmserver() {
        return umserver;
    }

    public void setUmserver(Long umserver) {
        this.umserver = umserver;
    }

    public Object getUmoptions() {
        return umoptions;
    }

    public void setUmoptions(Object umoptions) {
        this.umoptions = umoptions;
    }
}