package com.qbt.data.migration.pgsql.entity;

public class PgStatioSysIndexes {
    private Long relid;

    private Long indexrelid;

    private String schemaname;

    private String relname;

    private String indexrelname;

    private Long idx_blks_read;

    private Long idx_blks_hit;

    public Long getRelid() {
        return relid;
    }

    public void setRelid(Long relid) {
        this.relid = relid;
    }

    public Long getIndexrelid() {
        return indexrelid;
    }

    public void setIndexrelid(Long indexrelid) {
        this.indexrelid = indexrelid;
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

    public String getIndexrelname() {
        return indexrelname;
    }

    public void setIndexrelname(String indexrelname) {
        this.indexrelname = indexrelname == null ? null : indexrelname.trim();
    }

    public Long getIdx_blks_read() {
        return idx_blks_read;
    }

    public void setIdx_blks_read(Long idx_blks_read) {
        this.idx_blks_read = idx_blks_read;
    }

    public Long getIdx_blks_hit() {
        return idx_blks_hit;
    }

    public void setIdx_blks_hit(Long idx_blks_hit) {
        this.idx_blks_hit = idx_blks_hit;
    }
}