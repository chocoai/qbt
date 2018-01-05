package com.qbt.data.migration.pgsql.entity;

public class PgStatioUserSequences {
    private Long relid;

    private String schemaname;

    private String relname;

    private Long blks_read;

    private Long blks_hit;

    public Long getRelid() {
        return relid;
    }

    public void setRelid(Long relid) {
        this.relid = relid;
    }

    public String getSchemaname() {
        return schemaname;
    }

    public void setSchemaname(String schemaname) {
        this.schemaname = schemaname == null ? null : schemaname.trim();
    }

    public String getRelname() {
        return relname;
    }

    public void setRelname(String relname) {
        this.relname = relname == null ? null : relname.trim();
    }

    public Long getBlks_read() {
        return blks_read;
    }

    public void setBlks_read(Long blks_read) {
        this.blks_read = blks_read;
    }

    public Long getBlks_hit() {
        return blks_hit;
    }

    public void setBlks_hit(Long blks_hit) {
        this.blks_hit = blks_hit;
    }
}