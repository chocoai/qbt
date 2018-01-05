package com.qbt.data.migration.pgsql.entity;

public class PgStatioAllTables {
    private Long relid;

    private String schemaname;

    private String relname;

    private Long heap_blks_read;

    private Long heap_blks_hit;

    private Long idx_blks_read;

    private Long idx_blks_hit;

    private Long toast_blks_read;

    private Long toast_blks_hit;

    private Long tidx_blks_read;

    private Long tidx_blks_hit;

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

    public Long getHeap_blks_read() {
        return heap_blks_read;
    }

    public void setHeap_blks_read(Long heap_blks_read) {
        this.heap_blks_read = heap_blks_read;
    }

    public Long getHeap_blks_hit() {
        return heap_blks_hit;
    }

    public void setHeap_blks_hit(Long heap_blks_hit) {
        this.heap_blks_hit = heap_blks_hit;
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

    public Long getToast_blks_read() {
        return toast_blks_read;
    }

    public void setToast_blks_read(Long toast_blks_read) {
        this.toast_blks_read = toast_blks_read;
    }

    public Long getToast_blks_hit() {
        return toast_blks_hit;
    }

    public void setToast_blks_hit(Long toast_blks_hit) {
        this.toast_blks_hit = toast_blks_hit;
    }

    public Long getTidx_blks_read() {
        return tidx_blks_read;
    }

    public void setTidx_blks_read(Long tidx_blks_read) {
        this.tidx_blks_read = tidx_blks_read;
    }

    public Long getTidx_blks_hit() {
        return tidx_blks_hit;
    }

    public void setTidx_blks_hit(Long tidx_blks_hit) {
        this.tidx_blks_hit = tidx_blks_hit;
    }
}