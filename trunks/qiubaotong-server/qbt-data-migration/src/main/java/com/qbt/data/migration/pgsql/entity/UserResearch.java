package com.qbt.data.migration.pgsql.entity;

public class UserResearch {
    private Integer id;

    private Long user_id;

    private Long research_id;

    private Boolean coupon;

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

    public Long getResearch_id() {
        return research_id;
    }

    public void setResearch_id(Long research_id) {
        this.research_id = research_id;
    }

    public Boolean getCoupon() {
        return coupon;
    }

    public void setCoupon(Boolean coupon) {
        this.coupon = coupon;
    }
}