package com.qbt.data.migration.pgsql.entity;

public class PgLocks {
    private String locktype;

    private Long database;

    private Long relation;

    private Integer page;

    private Short tuple;

    private String virtualxid;

    private Object transactionid;

    private Long classid;

    private Long objid;

    private Short objsubid;

    private String virtualtransaction;

    private Integer pid;

    private String mode;

    private Boolean granted;

    private Boolean fastpath;

    public String getLocktype() {
        return locktype;
    }

    public void setLocktype(String locktype) {
        this.locktype = locktype == null ? null : locktype.trim();
    }

    public Long getDatabase() {
        return database;
    }

    public void setDatabase(Long database) {
        this.database = database;
    }

    public Long getRelation() {
        return relation;
    }

    public void setRelation(Long relation) {
        this.relation = relation;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Short getTuple() {
        return tuple;
    }

    public void setTuple(Short tuple) {
        this.tuple = tuple;
    }

    public String getVirtualxid() {
        return virtualxid;
    }

    public void setVirtualxid(String virtualxid) {
        this.virtualxid = virtualxid == null ? null : virtualxid.trim();
    }

    public Object getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(Object transactionid) {
        this.transactionid = transactionid;
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

    public Short getObjsubid() {
        return objsubid;
    }

    public void setObjsubid(Short objsubid) {
        this.objsubid = objsubid;
    }

    public String getVirtualtransaction() {
        return virtualtransaction;
    }

    public void setVirtualtransaction(String virtualtransaction) {
        this.virtualtransaction = virtualtransaction == null ? null : virtualtransaction.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode == null ? null : mode.trim();
    }

    public Boolean getGranted() {
        return granted;
    }

    public void setGranted(Boolean granted) {
        this.granted = granted;
    }

    public Boolean getFastpath() {
        return fastpath;
    }

    public void setFastpath(Boolean fastpath) {
        this.fastpath = fastpath;
    }
}