package com.qbt.persistent.entity;

import com.qbt.common.entity.BaseEntity;

public class BagCodeUser extends BaseEntity {

    private Integer bagCodePartnerId;

    private String bagCodePartnerName;

    private String bagCode;

    private Integer userId;

    private String nickname;

    private String name;

    private String mobile;

    private Integer activityId;

    private String activityName;

    public Integer getBagCodePartnerId() {
        return bagCodePartnerId;
    }

    public void setBagCodePartnerId(Integer bagCodePartnerId) {
        this.bagCodePartnerId = bagCodePartnerId;
    }

    public String getBagCodePartnerName() {
        return bagCodePartnerName;
    }

    public void setBagCodePartnerName(String bagCodePartnerName) {
        this.bagCodePartnerName = bagCodePartnerName == null ? null : bagCodePartnerName.trim();
    }

    public String getBagCode() {
        return bagCode;
    }

    public void setBagCode(String bagCode) {
        this.bagCode = bagCode == null ? null : bagCode.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }
}