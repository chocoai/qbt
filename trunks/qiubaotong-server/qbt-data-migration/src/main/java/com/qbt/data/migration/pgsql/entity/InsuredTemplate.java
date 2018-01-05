package com.qbt.data.migration.pgsql.entity;

import java.util.Date;

public class InsuredTemplate {
    private Integer id;

    private String name;

    private Double insured_rates;

    private Double free_insured;

    private Double insured_minimum;

    private Double insured_maximum;

    private String desc_insured_minimum;

    private String desc_insured_maximum;

    private Integer state;

    private String remark;

    private Date created_at;

    private Date deleted_at;

    private Date updated_at;

    private Integer version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getInsured_rates() {
        return insured_rates;
    }

    public void setInsured_rates(Double insured_rates) {
        this.insured_rates = insured_rates;
    }

    public Double getFree_insured() {
        return free_insured;
    }

    public void setFree_insured(Double free_insured) {
        this.free_insured = free_insured;
    }

    public Double getInsured_minimum() {
        return insured_minimum;
    }

    public void setInsured_minimum(Double insured_minimum) {
        this.insured_minimum = insured_minimum;
    }

    public Double getInsured_maximum() {
        return insured_maximum;
    }

    public void setInsured_maximum(Double insured_maximum) {
        this.insured_maximum = insured_maximum;
    }

    public String getDesc_insured_minimum() {
        return desc_insured_minimum;
    }

    public void setDesc_insured_minimum(String desc_insured_minimum) {
        this.desc_insured_minimum = desc_insured_minimum == null ? null : desc_insured_minimum.trim();
    }

    public String getDesc_insured_maximum() {
        return desc_insured_maximum;
    }

    public void setDesc_insured_maximum(String desc_insured_maximum) {
        this.desc_insured_maximum = desc_insured_maximum == null ? null : desc_insured_maximum.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Date deleted_at) {
        this.deleted_at = deleted_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}