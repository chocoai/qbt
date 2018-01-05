package com.qbt.data.migration.pgsql.entity;

import java.util.Date;

public class AssistantFee {
    private Integer id;

    private Long course_user_id;

    private Long order_id;

    private Float fee;

    private Boolean paid;

    private Date paid_at;

    private Short type;

    private Date created_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCourse_user_id() {
        return course_user_id;
    }

    public void setCourse_user_id(Long course_user_id) {
        this.course_user_id = course_user_id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Float getFee() {
        return fee;
    }

    public void setFee(Float fee) {
        this.fee = fee;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Date getPaid_at() {
        return paid_at;
    }

    public void setPaid_at(Date paid_at) {
        this.paid_at = paid_at;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}