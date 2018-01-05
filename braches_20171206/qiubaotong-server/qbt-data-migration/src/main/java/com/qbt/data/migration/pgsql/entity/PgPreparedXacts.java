package com.qbt.data.migration.pgsql.entity;

import java.util.Date;

public class PgPreparedXacts {
    private Object transaction;

    private String gid;

    private Date prepared;

    private String owner;

    private String database;

    public Object getTransaction() {
        return transaction;
    }

    public void setTransaction(Object transaction) {
        this.transaction = transaction;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid == null ? null : gid.trim();
    }

    public Date getPrepared() {
        return prepared;
    }

    public void setPrepared(Date prepared) {
        this.prepared = prepared;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database == null ? null : database.trim();
    }
}