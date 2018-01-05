package com.qbt.data.migration.pgsql.entity;

import java.util.Date;

public class OperateLog {
    private Integer id;

    private Integer operator_type;

    private Integer operator_id;

    private String operator_name;

    private Date operated_at;

    private Date created_at;

    private Short operate_type;

    private Long order_id;

    private String description;

    private String action;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOperator_type() {
        return operator_type;
    }

    public void setOperator_type(Integer operator_type) {
        this.operator_type = operator_type;
    }

    public Integer getOperator_id() {
        return operator_id;
    }

    public void setOperator_id(Integer operator_id) {
        this.operator_id = operator_id;
    }

    public String getOperator_name() {
        return operator_name;
    }

    public void setOperator_name(String operator_name) {
        this.operator_name = operator_name == null ? null : operator_name.trim();
    }

    public Date getOperated_at() {
        return operated_at;
    }

    public void setOperated_at(Date operated_at) {
        this.operated_at = operated_at;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Short getOperate_type() {
        return operate_type;
    }

    public void setOperate_type(Short operate_type) {
        this.operate_type = operate_type;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }
}