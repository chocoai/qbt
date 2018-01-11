package com.qbt.data.migration.pgsql.entity;

import java.util.Date;

public class AssistantApply {
    private Integer id;

    private Long assistant_id;

    private String name;

    private String identity_code;

    private String photo1_url;

    private String photo2_url;

    private Long course_id;

    private Short status;

    private String reject_reason;

    private Date created_at;

    private Integer apply_type;

    private Long sf_site_id;

    private Long airport_id;

    private Long bank_id;

    private Long apply_id;

    private String apply_name;

    private String remark;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdentity_code() {
        return identity_code;
    }

    public void setIdentity_code(String identity_code) {
        this.identity_code = identity_code == null ? null : identity_code.trim();
    }

    public String getPhoto1_url() {
        return photo1_url;
    }

    public void setPhoto1_url(String photo1_url) {
        this.photo1_url = photo1_url == null ? null : photo1_url.trim();
    }

    public String getPhoto2_url() {
        return photo2_url;
    }

    public void setPhoto2_url(String photo2_url) {
        this.photo2_url = photo2_url == null ? null : photo2_url.trim();
    }

    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getReject_reason() {
        return reject_reason;
    }

    public void setReject_reason(String reject_reason) {
        this.reject_reason = reject_reason == null ? null : reject_reason.trim();
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Integer getApply_type() {
        return apply_type;
    }

    public void setApply_type(Integer apply_type) {
        this.apply_type = apply_type;
    }

    public Long getSf_site_id() {
        return sf_site_id;
    }

    public void setSf_site_id(Long sf_site_id) {
        this.sf_site_id = sf_site_id;
    }

    public Long getAirport_id() {
        return airport_id;
    }

    public void setAirport_id(Long airport_id) {
        this.airport_id = airport_id;
    }

    public Long getBank_id() {
        return bank_id;
    }

    public void setBank_id(Long bank_id) {
        this.bank_id = bank_id;
    }

    public Long getApply_id() {
        return apply_id;
    }

    public void setApply_id(Long apply_id) {
        this.apply_id = apply_id;
    }

    public String getApply_name() {
        return apply_name;
    }

    public void setApply_name(String apply_name) {
        this.apply_name = apply_name == null ? null : apply_name.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}