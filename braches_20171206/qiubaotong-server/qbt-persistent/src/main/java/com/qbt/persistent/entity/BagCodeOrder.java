package com.qbt.persistent.entity;

import com.qbt.common.entity.BaseEntity;

public class BagCodeOrder extends BaseEntity {

    private Integer bagCodePartnerId;

    private String bagCodePartnerName;

    private String bagCode;

    private Integer userId;

    private String nickname;

    private String name;

    private String mobile;

    private Integer activityId;

    private String activityName;

    private Integer orderId;

    private String orderNumber;

    private Integer status;

    private String result;

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

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }
}