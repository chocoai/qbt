package com.qbt.data.migration.pgsql.entity;

public class PgStatXactSysTables {
    private Long relid;

    private String schemaname;

    private String relname;

    private Long seq_scan;

    private Long seq_tup_read;

    private Long idx_scan;

    private Long idx_tup_fetch;

    private Long n_tup_ins;

    private Long n_tup_upd;

    private Long n_tup_del;

    private Long n_tup_hot_upd;

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

    public Long getSeq_scan() {
        return seq_scan;
    }

    public void setSeq_scan(Long seq_scan) {
        this.seq_scan = seq_scan;
    }

    public Long getSeq_tup_read() {
        return seq_tup_read;
    }

    public void setSeq_tup_read(Long seq_tup_read) {
        this.seq_tup_read = seq_tup_read;
    }

    public Long getIdx_scan() {
        return idx_scan;
    }

    public void setIdx_scan(Long idx_scan) {
        this.idx_scan = idx_scan;
    }

    public Long getIdx_tup_fetch() {
        return idx_tup_fetch;
    }

    public void setIdx_tup_fetch(Long idx_tup_fetch) {
        this.idx_tup_fetch = idx_tup_fetch;
    }

    public Long getN_tup_ins() {
        return n_tup_ins;
    }

    public void setN_tup_ins(Long n_tup_ins) {
        this.n_tup_ins = n_tup_ins;
    }

    public Long getN_tup_upd() {
        return n_tup_upd;
    }

    public void setN_tup_upd(Long n_tup_upd) {
        this.n_tup_upd = n_tup_upd;
    }

    public Long getN_tup_del() {
        return n_tup_del;
    }

    public void setN_tup_del(Long n_tup_del) {
        this.n_tup_del = n_tup_del;
    }

    public Long getN_tup_hot_upd() {
        return n_tup_hot_upd;
    }

    public void setN_tup_hot_upd(Long n_tup_hot_upd) {
        this.n_tup_hot_upd = n_tup_hot_upd;
    }
}