package com.qbt.data.migration.pgsql.entity;

public class PgStatDatabaseConflicts {
    private Long datid;

    private String datname;

    private Long confl_tablespace;

    private Long confl_lock;

    private Long confl_snapshot;

    private Long confl_bufferpin;

    private Long confl_deadlock;

    public Long getDatid() {
        return datid;
    }

    public void setDatid(Long datid) {
        this.datid = datid;
    }

    public String getDatname() {
        return datname;
    }

    public void setDatname(String datname) {
        this.datname = datname == null ? null : datname.trim();
    }

    public Long getConfl_tablespace() {
        return confl_tablespace;
    }

    public void setConfl_tablespace(Long confl_tablespace) {
        this.confl_tablespace = confl_tablespace;
    }

    public Long getConfl_lock() {
        return confl_lock;
    }

    public void setConfl_lock(Long confl_lock) {
        this.confl_lock = confl_lock;
    }

    public Long getConfl_snapshot() {
        return confl_snapshot;
    }

    public void setConfl_snapshot(Long confl_snapshot) {
        this.confl_snapshot = confl_snapshot;
    }

    public Long getConfl_bufferpin() {
        return confl_bufferpin;
    }

    public void setConfl_bufferpin(Long confl_bufferpin) {
        this.confl_bufferpin = confl_bufferpin;
    }

    public Long getConfl_deadlock() {
        return confl_deadlock;
    }

    public void setConfl_deadlock(Long confl_deadlock) {
        this.confl_deadlock = confl_deadlock;
    }
}