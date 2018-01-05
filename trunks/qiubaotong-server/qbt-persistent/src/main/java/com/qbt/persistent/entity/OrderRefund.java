package com.qbt.persistent.entity;

import com.qbt.common.entity.BaseEntity;

public class OrderRefund extends BaseEntity {
   
    private String uuid;

    private Integer orderId;

    private double amount;
    
    private double realAmount;
    
    private double fee;

    private Integer status;

    private Integer userId;

    private String userName;

    private String mobile;

    private String kfName;

    private String kfMobile;

    private Boolean isNotice;
    
    private Integer orderPayType;
    
    private String remark;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getKfName() {
        return kfName;
    }

    public void setKfName(String kfName) {
        this.kfName = kfName == null ? null : kfName.trim();
    }

    public String getKfMobile() {
        return kfMobile;
    }

    public void setKfMobile(String kfMobile) {
        this.kfMobile = kfMobile == null ? null : kfMobile.trim();
    }

    public Boolean getIsNotice() {
        return isNotice;
    }

    public void setIsNotice(Boolean isNotice) {
        this.isNotice = isNotice;
    }

	public Integer getOrderPayType() {
		return orderPayType;
	}

	public void setOrderPayType(Integer orderPayType) {
		this.orderPayType = orderPayType;
	}

	public double getRealAmount() {
		return realAmount;
	}

	public void setRealAmount(double realAmount) {
		this.realAmount = realAmount;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
    
}