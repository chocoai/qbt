package com.qbt.data.migration.pgsql.entity;

public class PgAmproc {
    private Long amprocfamily;

    private Long amproclefttype;

    private Long amprocrighttype;

    private Short amprocnum;

    private Object amproc;

    public Long getAmprocfamily() {
        return amprocfamily;
    }

    public void setAmprocfamily(Long amprocfamily) {
        this.amprocfamily = amprocfamily;
    }

    public Long getAmproclefttype() {
        return amproclefttype;
    }

    public void setAmproclefttype(Long amproclefttype) {
        this.amproclefttype = amproclefttype;
    }

    public Long getAmprocrighttype() {
        return amprocrighttype;
    }

    public void setAmprocrighttype(Long amprocrighttype) {
        this.amprocrighttype = amprocrighttype;
    }

    public Short getAmprocnum() {
        return amprocnum;
    }

    public void setAmprocnum(Short amprocnum) {
        this.amprocnum = amprocnum;
    }

    public Object getAmproc() {
        return amproc;
    }

    public void setAmproc(Object amproc) {
        this.amproc = amproc;
    }
}