package com.qbt.data.migration.pgsql.entity;

public class PgNamespace {
    private String nspname;

    private Long nspowner;

    private Object nspacl;

    public String getNspname() {
        return nspname;
    }

    public void setNspname(String nspname) {
        this.nspname = nspname == null ? null : nspname.trim();
    }

    public Long getNspowner() {
        return nspowner;
    }

    public void setNspowner(Long nspowner) {
        this.nspowner = nspowner;
    }

    public Object getNspacl() {
        return nspacl;
    }

    public void setNspacl(Object nspacl) {
        this.nspacl = nspacl;
    }
}