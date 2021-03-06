package com.qbt.data.migration.pgsql.entity;

public class Holiday {
    private Integer id;

    private String name;

    private String start;

    private String end;

    private Double price;

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

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start == null ? null : start.trim();
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end == null ? null : end.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}