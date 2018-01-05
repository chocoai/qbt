package com.qbt.data.migration.pgsql.entity;

public class TransPrice {
    private Integer id;

    private String start_province;

    private String start_city;

    private String start_district;

    private String end_province;

    private String end_city;

    private String end_district;

    private Double price_18kg;

    private Double preference_price_18kg;

    private Double price_20kg;

    private Double preference_price_20kg;

    private Double price_28kg;

    private Double preference_price_28kg;

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

    public Double getPrice_18kg() {
        return price_18kg;
    }

    public void setPrice_18kg(Double price_18kg) {
        this.price_18kg = price_18kg;
    }

    public Double getPreference_price_18kg() {
        return preference_price_18kg;
    }

    public void setPreference_price_18kg(Double preference_price_18kg) {
        this.preference_price_18kg = preference_price_18kg;
    }

    public Double getPrice_20kg() {
        return price_20kg;
    }

    public void setPrice_20kg(Double price_20kg) {
        this.price_20kg = price_20kg;
    }

    public Double getPreference_price_20kg() {
        return preference_price_20kg;
    }

    public void setPreference_price_20kg(Double preference_price_20kg) {
        this.preference_price_20kg = preference_price_20kg;
    }

    public Double getPrice_28kg() {
        return price_28kg;
    }

    public void setPrice_28kg(Double price_28kg) {
        this.price_28kg = price_28kg;
    }

    public Double getPreference_price_28kg() {
        return preference_price_28kg;
    }

    public void setPreference_price_28kg(Double preference_price_28kg) {
        this.preference_price_28kg = preference_price_28kg;
    }
}