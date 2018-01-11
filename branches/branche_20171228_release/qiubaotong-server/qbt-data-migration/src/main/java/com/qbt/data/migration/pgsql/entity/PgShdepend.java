package com.qbt.data.migration.pgsql.entity;

public class PgShdepend {
    private Long dbid;

    private Long classid;

    private Long objid;

    private Integer objsubid;

    private Long refclassid;

    private Long refobjid;

    private String deptype;

    public Long getDbid() {
        return dbid;
    }

    public void setDbid(Long dbid) {
        this.dbid = dbid;
    }

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

    public String getDeptype() {
        return deptype;
    }

    public void setDeptype(String deptype) {
        this.deptype = deptype == null ? null : deptype.trim();
    }
}