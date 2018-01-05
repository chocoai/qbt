package com.qbt.data.migration.pgsql.entity;

import java.util.Date;

public class UnknownQbt {
    private Integer id;

    private String j_province;

    private String j_city;

    private String j_county;

    private String j_address;

    private String d_province;

    private String d_city;

    private String d_county;

    private String d_address;

    private String reason;

    private Date created_at;

    private Date updated_at;

    private Integer version;

    private Date deleted_at;

    private String express_type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJ_province() {
        return j_province;
    }

    public void setJ_province(String j_province) {
        this.j_province = j_province == null ? null : j_province.trim();
    }

    public String getJ_city() {
        return j_city;
    }

    public void setJ_city(String j_city) {
        this.j_city = j_city == null ? null : j_city.trim();
    }

    public String getJ_county() {
        return j_county;
    }

    public void setJ_county(String j_county) {
        this.j_county = j_county == null ? null : j_county.trim();
    }

    public String getJ_address() {
        return j_address;
    }

    public void setJ_address(String j_address) {
        this.j_address = j_address == null ? null : j_address.trim();
    }

    public String getD_province() {
        return d_province;
    }

    public void setD_province(String d_province) {
        this.d_province = d_province == null ? null : d_province.trim();
    }

    public String getD_city() {
        return d_city;
    }

    public void setD_city(String d_city) {
        this.d_city = d_city == null ? null : d_city.trim();
    }

    public String getD_county() {
        return d_county;
    }

    public void setD_county(String d_county) {
        this.d_county = d_county == null ? null : d_county.trim();
    }

    public String getD_address() {
        return d_address;
    }

    public void setD_address(String d_address) {
        this.d_address = d_address == null ? null : d_address.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
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

    public String getExpress_type() {
        return express_type;
    }

    public void setExpress_type(String express_type) {
        this.express_type = express_type == null ? null : express_type.trim();
    }
}