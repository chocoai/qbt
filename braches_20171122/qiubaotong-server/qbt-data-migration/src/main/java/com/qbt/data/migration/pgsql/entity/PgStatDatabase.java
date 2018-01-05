package com.qbt.data.migration.pgsql.entity;

import java.util.Date;

public class PgStatDatabase {
    private Long datid;

    private String datname;

    private Integer numbackends;

    private Long xact_commit;

    private Long xact_rollback;

    private Long blks_read;

    private Long blks_hit;

    private Long tup_returned;

    private Long tup_fetched;

    private Long tup_inserted;

    private Long tup_updated;

    private Long tup_deleted;

    private Long conflicts;

    private Long temp_files;

    private Long temp_bytes;

    private Long deadlocks;

    private Double blk_read_time;

    private Double blk_write_time;

    private Date stats_reset;

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

    public Integer getNumbackends() {
        return numbackends;
    }

    public void setNumbackends(Integer numbackends) {
        this.numbackends = numbackends;
    }

    public Long getXact_commit() {
        return xact_commit;
    }

    public void setXact_commit(Long xact_commit) {
        this.xact_commit = xact_commit;
    }

    public Long getXact_rollback() {
        return xact_rollback;
    }

    public void setXact_rollback(Long xact_rollback) {
        this.xact_rollback = xact_rollback;
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

    public Long getTup_returned() {
        return tup_returned;
    }

    public void setTup_returned(Long tup_returned) {
        this.tup_returned = tup_returned;
    }

    public Long getTup_fetched() {
        return tup_fetched;
    }

    public void setTup_fetched(Long tup_fetched) {
        this.tup_fetched = tup_fetched;
    }

    public Long getTup_inserted() {
        return tup_inserted;
    }

    public void setTup_inserted(Long tup_inserted) {
        this.tup_inserted = tup_inserted;
    }

    public Long getTup_updated() {
        return tup_updated;
    }

    public void setTup_updated(Long tup_updated) {
        this.tup_updated = tup_updated;
    }

    public Long getTup_deleted() {
        return tup_deleted;
    }

    public void setTup_deleted(Long tup_deleted) {
        this.tup_deleted = tup_deleted;
    }

    public Long getConflicts() {
        return conflicts;
    }

    public void setConflicts(Long conflicts) {
        this.conflicts = conflicts;
    }

    public Long getTemp_files() {
        return temp_files;
    }

    public void setTemp_files(Long temp_files) {
        this.temp_files = temp_files;
    }

    public Long getTemp_bytes() {
        return temp_bytes;
    }

    public void setTemp_bytes(Long temp_bytes) {
        this.temp_bytes = temp_bytes;
    }

    public Long getDeadlocks() {
        return deadlocks;
    }

    public void setDeadlocks(Long deadlocks) {
        this.deadlocks = deadlocks;
    }

    public Double getBlk_read_time() {
        return blk_read_time;
    }

    public void setBlk_read_time(Double blk_read_time) {
        this.blk_read_time = blk_read_time;
    }

    public Double getBlk_write_time() {
        return blk_write_time;
    }

    public void setBlk_write_time(Double blk_write_time) {
        this.blk_write_time = blk_write_time;
    }

    public Date getStats_reset() {
        return stats_reset;
    }

    public void setStats_reset(Date stats_reset) {
        this.stats_reset = stats_reset;
    }
}