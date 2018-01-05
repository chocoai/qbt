package com.qbt.data.migration.pgsql.entity;

public class CiChenPrice {
    private Integer id;

    private String start_province;

    private String start_city;

    private String start_district;

    private String end_province;

    private String end_city;

    private String end_district;

    private Double first_price;

    private Double second_price;

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

    public Double getFirst_price() {
        return first_price;
    }

    public void setFirst_price(Double first_price) {
        this.first_price = first_price;
    }

    public Double getSecond_price() {
        return second_price;
    }

    public void setSecond_price(Double second_price) {
        this.second_price = second_price;
    }
}