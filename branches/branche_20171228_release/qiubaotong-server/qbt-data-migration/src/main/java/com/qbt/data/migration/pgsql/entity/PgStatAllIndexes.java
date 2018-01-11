package com.qbt.data.migration.pgsql.entity;

public class PgStatAllIndexes {
    private Long relid;

    private Long indexrelid;

    private String schemaname;

    private String relname;

    private String indexrelname;

    private Long idx_scan;

    private Long idx_tup_read;

    private Long idx_tup_fetch;

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

    public Long getIdx_scan() {
        return idx_scan;
    }

    public void setIdx_scan(Long idx_scan) {
        this.idx_scan = idx_scan;
    }

    public Long getIdx_tup_read() {
        return idx_tup_read;
    }

    public void setIdx_tup_read(Long idx_tup_read) {
        this.idx_tup_read = idx_tup_read;
    }

    public Long getIdx_tup_fetch() {
        return idx_tup_fetch;
    }

    public void setIdx_tup_fetch(Long idx_tup_fetch) {
        this.idx_tup_fetch = idx_tup_fetch;
    }
}