package com.qbt.data.migration.pgsql.entity;

import java.util.Date;

public class AssistantBag {
    private Integer id;

    private Long assistant_id;

    private String owner_name;

    private String owner_mobile;

    private Integer bag_cover;

    private String remark;

    private Date created_at;

    private Date updated_at;

    private Integer version;

    private Date deleted_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getAssistant_id() {
        return assistant_id;
    }

    public void setAssistant_id(Long assistant_id) {
        this.assistant_id = assistant_id;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name == null ? null : owner_name.trim();
    }

    public String getOwner_mobile() {
        return owner_mobile;
    }

    public void setOwner_mobile(String owner_mobile) {
        this.owner_mobile = owner_mobile == null ? null : owner_mobile.trim();
    }

    public Integer getBag_cover() {
        return bag_cover;
    }

    public void setBag_cover(Integer bag_cover) {
        this.bag_cover = bag_cover;
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

    public Date getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Date deleted_at) {
        this.deleted_at = deleted_at;
    }
}