package com.qbt.data.migration.pgsql.entity;

public class PgRange {
    private Long rngtypid;

    private Long rngsubtype;

    private Long rngcollation;

    private Long rngsubopc;

    private Object rngcanonical;

    private Object rngsubdiff;

    public Long getRngtypid() {
        return rngtypid;
    }

    public void setRngtypid(Long rngtypid) {
        this.rngtypid = rngtypid;
    }

    public Long getRngsubtype() {
        return rngsubtype;
    }

    public void setRngsubtype(Long rngsubtype) {
        this.rngsubtype = rngsubtype;
    }

    public Long getRngcollation() {
        return rngcollation;
    }

    public void setRngcollation(Long rngcollation) {
        this.rngcollation = rngcollation;
    }

    public Long getRngsubopc() {
        return rngsubopc;
    }

    public void setRngsubopc(Long rngsubopc) {
        this.rngsubopc = rngsubopc;
    }

    public Object getRngcanonical() {
        return rngcanonical;
    }

    public void setRngcanonical(Object rngcanonical) {
        this.rngcanonical = rngcanonical;
    }

    public Object getRngsubdiff() {
        return rngsubdiff;
    }

    public void setRngsubdiff(Object rngsubdiff) {
        this.rngsubdiff = rngsubdiff;
    }
}