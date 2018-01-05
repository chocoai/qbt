package com.qbt.data.migration.pgsql.entity;

public class PgForeignTable {
    private Long ftrelid;

    private Long ftserver;

    private Object ftoptions;

    public Long getFtrelid() {
        return ftrelid;
    }

    public void setFtrelid(Long ftrelid) {
        this.ftrelid = ftrelid;
    }

    public Long getFtserver() {
        return ftserver;
    }

    public void setFtserver(Long ftserver) {
        this.ftserver = ftserver;
    }

    public Object getFtoptions() {
        return ftoptions;
    }

    public void setFtoptions(Object ftoptions) {
        this.ftoptions = ftoptions;
    }
}