package com.qbt.data.migration.pgsql.entity;

import java.util.Date;

public class RemindPlayballTask {
    private Integer id;

    private Long order_id;

    private Date playball_time;

    private Boolean status;

    private Date created_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Date getPlayball_time() {
        return playball_time;
    }

    public void setPlayball_time(Date playball_time) {
        this.playball_time = playball_time;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}