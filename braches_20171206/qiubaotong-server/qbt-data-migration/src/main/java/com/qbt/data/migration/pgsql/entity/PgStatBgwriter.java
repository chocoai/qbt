package com.qbt.data.migration.pgsql.entity;

import java.util.Date;

public class PgStatBgwriter {
    private Long checkpoints_timed;

    private Long checkpoints_req;

    private Double checkpoint_write_time;

    private Double checkpoint_sync_time;

    private Long buffers_checkpoint;

    private Long buffers_clean;

    private Long maxwritten_clean;

    private Long buffers_backend;

    private Long buffers_backend_fsync;

    private Long buffers_alloc;

    private Date stats_reset;

    public Long getCheckpoints_timed() {
        return checkpoints_timed;
    }

    public void setCheckpoints_timed(Long checkpoints_timed) {
        this.checkpoints_timed = checkpoints_timed;
    }

    public Long getCheckpoints_req() {
        return checkpoints_req;
    }

    public void setCheckpoints_req(Long checkpoints_req) {
        this.checkpoints_req = checkpoints_req;
    }

    public Double getCheckpoint_write_time() {
        return checkpoint_write_time;
    }

    public void setCheckpoint_write_time(Double checkpoint_write_time) {
        this.checkpoint_write_time = checkpoint_write_time;
    }

    public Double getCheckpoint_sync_time() {
        return checkpoint_sync_time;
    }

    public void setCheckpoint_sync_time(Double checkpoint_sync_time) {
        this.checkpoint_sync_time = checkpoint_sync_time;
    }

    public Long getBuffers_checkpoint() {
        return buffers_checkpoint;
    }

    public void setBuffers_checkpoint(Long buffers_checkpoint) {
        this.buffers_checkpoint = buffers_checkpoint;
    }

    public Long getBuffers_clean() {
        return buffers_clean;
    }

    public void setBuffers_clean(Long buffers_clean) {
        this.buffers_clean = buffers_clean;
    }

    public Long getMaxwritten_clean() {
        return maxwritten_clean;
    }

    public void setMaxwritten_clean(Long maxwritten_clean) {
        this.maxwritten_clean = maxwritten_clean;
    }

    public Long getBuffers_backend() {
        return buffers_backend;
    }

    public void setBuffers_backend(Long buffers_backend) {
        this.buffers_backend = buffers_backend;
    }

    public Long getBuffers_backend_fsync() {
        return buffers_backend_fsync;
    }

    public void setBuffers_backend_fsync(Long buffers_backend_fsync) {
        this.buffers_backend_fsync = buffers_backend_fsync;
    }

    public Long getBuffers_alloc() {
        return buffers_alloc;
    }

    public void setBuffers_alloc(Long buffers_alloc) {
        this.buffers_alloc = buffers_alloc;
    }

    public Date getStats_reset() {
        return stats_reset;
    }

    public void setStats_reset(Date stats_reset) {
        this.stats_reset = stats_reset;
    }
}