package com.qbt.data.migration.pgsql.entity;

import java.util.Date;

public class Activity {
    private Integer id;

    private String name;

    private Date start_time;

    private Date end_time;

    private Date created_at;

    private String code;

    private String desc;

    private Integer max_per_one;

    private Date activity_start_time;

    private Date activity_end_time;

    private Double li_bao_worth;

    private Integer li_bao_num;

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

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public Integer getMax_per_one() {
        return max_per_one;
    }

    public void setMax_per_one(Integer max_per_one) {
        this.max_per_one = max_per_one;
    }

    public Date getActivity_start_time() {
        return activity_start_time;
    }

    public void setActivity_start_time(Date activity_start_time) {
        this.activity_start_time = activity_start_time;
    }

    public Date getActivity_end_time() {
        return activity_end_time;
    }

    public void setActivity_end_time(Date activity_end_time) {
        this.activity_end_time = activity_end_time;
    }

    public Double getLi_bao_worth() {
        return li_bao_worth;
    }

    public void setLi_bao_worth(Double li_bao_worth) {
        this.li_bao_worth = li_bao_worth;
    }

    public Integer getLi_bao_num() {
        return li_bao_num;
    }

    public void setLi_bao_num(Integer li_bao_num) {
        this.li_bao_num = li_bao_num;
    }
}