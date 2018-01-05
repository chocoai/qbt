package com.qbt.data.migration.pgsql.entity;

import java.util.Date;

public class SfQbtPrice {
    private Integer id;

    private String start_province;

    private String start_city;

    private String start_district;

    private String end_province;

    private String end_city;

    private String end_district;

    private Double cichen_sf_price;

    private Double cichen_qbt_price;

    private Double cichen_first_price;

    private Double cichen_second_price;

    private Double ciri_sf_price;

    private Double ciri_qbt_price;

    private Double ciri_first_price;

    private Double ciri_second_price;

    private Double jiri_sf_price;

    private Double jiri_qbt_price;

    private Double jiri_first_price;

    private Double jiri_second_price;

    private Double geri_sf_price;

    private Double geri_qbt_price;

    private Double geri_first_price;

    private Double geri_second_price;

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

    public String getStart_province() {
        return start_province;
    }

    public void setStart_province(String start_province) {
        this.start_province = start_province == null ? null : start_province.trim();
    }

    public String getStart_city() {
        return start_city;
    }

    public void setStart_city(String start_city) {
        this.start_city = start_city == null ? null : start_city.trim();
    }

    public String getStart_district() {
        return start_district;
    }

    public void setStart_district(String start_district) {
        this.start_district = start_district == null ? null : start_district.trim();
    }

    public String getEnd_province() {
        return end_province;
    }

    public void setEnd_province(String end_province) {
        this.end_province = end_province == null ? null : end_province.trim();
    }

    public String getEnd_city() {
        return end_city;
    }

    public void setEnd_city(String end_city) {
        this.end_city = end_city == null ? null : end_city.trim();
    }

    public String getEnd_district() {
        return end_district;
    }

    public void setEnd_district(String end_district) {
        this.end_district = end_district == null ? null : end_district.trim();
    }

    public Double getCichen_sf_price() {
        return cichen_sf_price;
    }

    public void setCichen_sf_price(Double cichen_sf_price) {
        this.cichen_sf_price = cichen_sf_price;
    }

    public Double getCichen_qbt_price() {
        return cichen_qbt_price;
    }

    public void setCichen_qbt_price(Double cichen_qbt_price) {
        this.cichen_qbt_price = cichen_qbt_price;
    }

    public Double getCichen_first_price() {
        return cichen_first_price;
    }

    public void setCichen_first_price(Double cichen_first_price) {
        this.cichen_first_price = cichen_first_price;
    }

    public Double getCichen_second_price() {
        return cichen_second_price;
    }

    public void setCichen_second_price(Double cichen_second_price) {
        this.cichen_second_price = cichen_second_price;
    }

    public Double getCiri_sf_price() {
        return ciri_sf_price;
    }

    public void setCiri_sf_price(Double ciri_sf_price) {
        this.ciri_sf_price = ciri_sf_price;
    }

    public Double getCiri_qbt_price() {
        return ciri_qbt_price;
    }

    public void setCiri_qbt_price(Double ciri_qbt_price) {
        this.ciri_qbt_price = ciri_qbt_price;
    }

    public Double getCiri_first_price() {
        return ciri_first_price;
    }

    public void setCiri_first_price(Double ciri_first_price) {
        this.ciri_first_price = ciri_first_price;
    }

    public Double getCiri_second_price() {
        return ciri_second_price;
    }

    public void setCiri_second_price(Double ciri_second_price) {
        this.ciri_second_price = ciri_second_price;
    }

    public Double getJiri_sf_price() {
        return jiri_sf_price;
    }

    public void setJiri_sf_price(Double jiri_sf_price) {
        this.jiri_sf_price = jiri_sf_price;
    }

    public Double getJiri_qbt_price() {
        return jiri_qbt_price;
    }

    public void setJiri_qbt_price(Double jiri_qbt_price) {
        this.jiri_qbt_price = jiri_qbt_price;
    }

    public Double getJiri_first_price() {
        return jiri_first_price;
    }

    public void setJiri_first_price(Double jiri_first_price) {
        this.jiri_first_price = jiri_first_price;
    }

    public Double getJiri_second_price() {
        return jiri_second_price;
    }

    public void setJiri_second_price(Double jiri_second_price) {
        this.jiri_second_price = jiri_second_price;
    }

    public Double getGeri_sf_price() {
        return geri_sf_price;
    }

    public void setGeri_sf_price(Double geri_sf_price) {
        this.geri_sf_price = geri_sf_price;
    }

    public Double getGeri_qbt_price() {
        return geri_qbt_price;
    }

    public void setGeri_qbt_price(Double geri_qbt_price) {
        this.geri_qbt_price = geri_qbt_price;
    }

    public Double getGeri_first_price() {
        return geri_first_price;
    }

    public void setGeri_first_price(Double geri_first_price) {
        this.geri_first_price = geri_first_price;
    }

    public Double getGeri_second_price() {
        return geri_second_price;
    }

    public void setGeri_second_price(Double geri_second_price) {
        this.geri_second_price = geri_second_price;
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