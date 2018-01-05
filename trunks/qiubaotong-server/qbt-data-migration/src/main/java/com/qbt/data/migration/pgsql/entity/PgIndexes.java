package com.qbt.data.migration.pgsql.entity;

public class PgIndexes {
    private String schemaname;

    private String tablename;

    private String indexname;

    private String tablespace;

    private String indexdef;

    public String getSchemaname() {
        return schemaname;
    }

    public void setSchemaname(String schemaname) {
        this.schemaname = schemaname == null ? null : schemaname.trim();
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename == null ? null : tablename.trim();
    }

    public String getIndexname() {
        return indexname;
    }

    public void setIndexname(String indexname) {
        this.indexname = indexname == null ? null : indexname.trim();
    }

    public String getTablespace() {
        return tablespace;
    }

    public void setTablespace(String tablespace) {
        this.tablespace = tablespace == null ? null : tablespace.trim();
    }

    public String getIndexdef() {
        return indexdef;
    }

    public void setIndexdef(String indexdef) {
        this.indexdef = indexdef == null ? null : indexdef.trim();
    }
}