package com.qbt.data.migration.pgsql.entity;

import java.util.Date;

public class PgStatAllTables {
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

    private Long n_live_tup;

    private Long n_dead_tup;

    private Date last_vacuum;

    private Date last_autovacuum;

    private Date last_analyze;

    private Date last_autoanalyze;

    private Long vacuum_count;

    private Long autovacuum_count;

    private Long analyze_count;

    private Long autoanalyze_count;

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

    public Long getN_live_tup() {
        return n_live_tup;
    }

    public void setN_live_tup(Long n_live_tup) {
        this.n_live_tup = n_live_tup;
    }

    public Long getN_dead_tup() {
        return n_dead_tup;
    }

    public void setN_dead_tup(Long n_dead_tup) {
        this.n_dead_tup = n_dead_tup;
    }

    public Date getLast_vacuum() {
        return last_vacuum;
    }

    public void setLast_vacuum(Date last_vacuum) {
        this.last_vacuum = last_vacuum;
    }

    public Date getLast_autovacuum() {
        return last_autovacuum;
    }

    public void setLast_autovacuum(Date last_autovacuum) {
        this.last_autovacuum = last_autovacuum;
    }

    public Date getLast_analyze() {
        return last_analyze;
    }

    public void setLast_analyze(Date last_analyze) {
        this.last_analyze = last_analyze;
    }

    public Date getLast_autoanalyze() {
        return last_autoanalyze;
    }

    public void setLast_autoanalyze(Date last_autoanalyze) {
        this.last_autoanalyze = last_autoanalyze;
    }

    public Long getVacuum_count() {
        return vacuum_count;
    }

    public void setVacuum_count(Long vacuum_count) {
        this.vacuum_count = vacuum_count;
    }

    public Long getAutovacuum_count() {
        return autovacuum_count;
    }

    public void setAutovacuum_count(Long autovacuum_count) {
        this.autovacuum_count = autovacuum_count;
    }

    public Long getAnalyze_count() {
        return analyze_count;
    }

    public void setAnalyze_count(Long analyze_count) {
        this.analyze_count = analyze_count;
    }

    public Long getAutoanalyze_count() {
        return autoanalyze_count;
    }

    public void setAutoanalyze_count(Long autoanalyze_count) {
        this.autoanalyze_count = autoanalyze_count;
    }
}