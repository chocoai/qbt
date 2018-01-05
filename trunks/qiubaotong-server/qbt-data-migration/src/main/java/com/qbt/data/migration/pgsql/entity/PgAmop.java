package com.qbt.data.migration.pgsql.entity;

public class PgAmop {
    private Long amopfamily;

    private Long amoplefttype;

    private Long amoprighttype;

    private Short amopstrategy;

    private String amoppurpose;

    private Long amopopr;

    private Long amopmethod;

    private Long amopsortfamily;

    public Long getAmopfamily() {
        return amopfamily;
    }

    public void setAmopfamily(Long amopfamily) {
        this.amopfamily = amopfamily;
    }

    public Long getAmoplefttype() {
        return amoplefttype;
    }

    public void setAmoplefttype(Long amoplefttype) {
        this.amoplefttype = amoplefttype;
    }

    public Long getAmoprighttype() {
        return amoprighttype;
    }

    public void setAmoprighttype(Long amoprighttype) {
        this.amoprighttype = amoprighttype;
    }

    public Short getAmopstrategy() {
        return amopstrategy;
    }

    public void setAmopstrategy(Short amopstrategy) {
        this.amopstrategy = amopstrategy;
    }

    public String getAmoppurpose() {
        return amoppurpose;
    }

    public void setAmoppurpose(String amoppurpose) {
        this.amoppurpose = amoppurpose == null ? null : amoppurpose.trim();
    }

    public Long getAmopopr() {
        return amopopr;
    }

    public void setAmopopr(Long amopopr) {
        this.amopopr = amopopr;
    }

    public Long getAmopmethod() {
        return amopmethod;
    }

    public void setAmopmethod(Long amopmethod) {
        this.amopmethod = amopmethod;
    }

    public Long getAmopsortfamily() {
        return amopsortfamily;
    }

    public void setAmopsortfamily(Long amopsortfamily) {
        this.amopsortfamily = amopsortfamily;
    }
}