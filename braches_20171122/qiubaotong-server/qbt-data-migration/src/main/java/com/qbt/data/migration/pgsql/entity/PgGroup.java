package com.qbt.data.migration.pgsql.entity;

public class PgGroup {
    private String groname;

    private Long grosysid;

    private Object grolist;

    public String getGroname() {
        return groname;
    }

    public void setGroname(String groname) {
        this.groname = groname == null ? null : groname.trim();
    }

    public Long getGrosysid() {
        return grosysid;
    }

    public void setGrosysid(Long grosysid) {
        this.grosysid = grosysid;
    }

    public Object getGrolist() {
        return grolist;
    }

    public void setGrolist(Object grolist) {
        this.grolist = grolist;
    }
}