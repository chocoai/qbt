package com.qbt.data.migration.pgsql.entity;

public class PgCast {
    private Long castsource;

    private Long casttarget;

    private Long castfunc;

    private String castcontext;

    private String castmethod;

    public Long getCastsource() {
        return castsource;
    }

    public void setCastsource(Long castsource) {
        this.castsource = castsource;
    }

    public Long getCasttarget() {
        return casttarget;
    }

    public void setCasttarget(Long casttarget) {
        this.casttarget = casttarget;
    }

    public Long getCastfunc() {
        return castfunc;
    }

    public void setCastfunc(Long castfunc) {
        this.castfunc = castfunc;
    }

    public String getCastcontext() {
        return castcontext;
    }

    public void setCastcontext(String castcontext) {
        this.castcontext = castcontext == null ? null : castcontext.trim();
    }

    public String getCastmethod() {
        return castmethod;
    }

    public void setCastmethod(String castmethod) {
        this.castmethod = castmethod == null ? null : castmethod.trim();
    }
}