package com.qbt.data.migration.pgsql.entity;

public class PgDepend {
    private Long classid;

    private Long objid;

    private Integer objsubid;

    private Long refclassid;

    private Long refobjid;

    private Integer refobjsubid;

    private String deptype;

    public Long getClassid() {
        return classid;
    }

    public void setClassid(Long classid) {
        this.classid = classid;
    }

    public Long getObjid() {
        return objid;
    }

    public void setObjid(Long objid) {
        this.objid = objid;
    }

    public Integer getObjsubid() {
        return objsubid;
    }

    public void setObjsubid(Integer objsubid) {
        this.objsubid = objsubid;
    }

    public Long getRefclassid() {
        return refclassid;
    }

    public void setRefclassid(Long refclassid) {
        this.refclassid = refclassid;
    }

    public Long getRefobjid() {
        return refobjid;
    }

    public void setRefobjid(Long refobjid) {
        this.refobjid = refobjid;
    }

    public Integer getRefobjsubid() {
        return refobjsubid;
    }

    public void setRefobjsubid(Integer refobjsubid) {
        this.refobjsubid = refobjsubid;
    }

    public String getDeptype() {
        return deptype;
    }

    public void setDeptype(String deptype) {
        this.deptype = deptype == null ? null : deptype.trim();
    }
}