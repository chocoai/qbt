package com.qbt.data.migration.pgsql.entity;

import java.util.Date;

public class GolfBag {
    private Integer id;

    private Long user_id;

    private String name;

    private Integer woods;

    private Integer irons;

    private Integer putter;

    private Integer head_cover;

    private Integer bag_cover;

    private Boolean umbrella;

    private Boolean is_default;

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

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getWoods() {
        return woods;
    }

    public void setWoods(Integer woods) {
        this.woods = woods;
    }

    public Integer getIrons() {
        return irons;
    }

    public void setIrons(Integer irons) {
        this.irons = irons;
    }

    public Integer getPutter() {
        return putter;
    }

    public void setPutter(Integer putter) {
        this.putter = putter;
    }

    public Integer getHead_cover() {
        return head_cover;
    }

    public void setHead_cover(Integer head_cover) {
        this.head_cover = head_cover;
    }

    public Integer getBag_cover() {
        return bag_cover;
    }

    public void setBag_cover(Integer bag_cover) {
        this.bag_cover = bag_cover;
    }

    public Boolean getUmbrella() {
        return umbrella;
    }

    public void setUmbrella(Boolean umbrella) {
        this.umbrella = umbrella;
    }

    public Boolean getIs_default() {
        return is_default;
    }

    public void setIs_default(Boolean is_default) {
        this.is_default = is_default;
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