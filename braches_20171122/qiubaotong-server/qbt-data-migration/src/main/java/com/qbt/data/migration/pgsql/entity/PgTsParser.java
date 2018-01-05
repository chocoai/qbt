package com.qbt.data.migration.pgsql.entity;

public class PgTsParser {
    private String prsname;

    private Long prsnamespace;

    private Object prsstart;

    private Object prstoken;

    private Object prsend;

    private Object prsheadline;

    private Object prslextype;

    public String getPrsname() {
        return prsname;
    }

    public void setPrsname(String prsname) {
        this.prsname = prsname == null ? null : prsname.trim();
    }

    public Long getPrsnamespace() {
        return prsnamespace;
    }

    public void setPrsnamespace(Long prsnamespace) {
        this.prsnamespace = prsnamespace;
    }

    public Object getPrsstart() {
        return prsstart;
    }

    public void setPrsstart(Object prsstart) {
        this.prsstart = prsstart;
    }

    public Object getPrstoken() {
        return prstoken;
    }

    public void setPrstoken(Object prstoken) {
        this.prstoken = prstoken;
    }

    public Object getPrsend() {
        return prsend;
    }

    public void setPrsend(Object prsend) {
        this.prsend = prsend;
    }

    public Object getPrsheadline() {
        return prsheadline;
    }

    public void setPrsheadline(Object prsheadline) {
        this.prsheadline = prsheadline;
    }

    public Object getPrslextype() {
        return prslextype;
    }

    public void setPrslextype(Object prslextype) {
        this.prslextype = prslextype;
    }
}