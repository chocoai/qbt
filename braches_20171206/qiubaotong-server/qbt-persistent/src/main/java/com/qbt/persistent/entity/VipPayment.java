package com.qbt.persistent.entity;

import java.math.BigDecimal;
import java.util.Date;

public class VipPayment {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private String uuid;

    private Integer orderId;

    private Integer userId;

    private BigDecimal payAmount;

    private Integer payMethod;

    private Integer status;

    private Integer payStatus;

    private Integer vipTypeId;
    
    private String name;

    private String userName;

    private String mobile;

    private String validDesc;

    private Integer valid;

    private String paySign;

    private String prepayId;

    private String payBakNo;

    private Long startTime;

    private Long expireTime;

    private String paypackage;
    
    private Integer userImgId;
    
    private String userImageUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public Integer getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public String getValidDesc() {
        return validDesc;
    }

    public void setValidDesc(String validDesc) {
        this.validDesc = validDesc == null ? null : validDesc.trim();
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public String getPaySign() {
        return paySign;
    }

    public void setPaySign(String paySign) {
        this.paySign = paySign == null ? null : paySign.trim();
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId == null ? null : prepayId.trim();
    }

    public String getPayBakNo() {
        return payBakNo;
    }

    public void setPayBakNo(String payBakNo) {
        this.payBakNo = payBakNo == null ? null : payBakNo.trim();
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public String getPaypackage() {
        return paypackage;
    }

    public void setPaypackage(String paypackage) {
        this.paypackage = paypackage == null ? null : paypackage.trim();
    }

	
	/**
	 * getter method 
	 * @Title: getVipTypeId
	 * @return the vipTypeId
	 */
	
	public Integer getVipTypeId() {
		return vipTypeId;
	}

	
	/**
	* setter method
	* @param vipTypeId the vipTypeId to set
	*/
	
	public void setVipTypeId(Integer vipTypeId) {
		this.vipTypeId = vipTypeId;
	}

	public Integer getUserImgId() {
		return userImgId;
	}

	public void setUserImgId(Integer userImgId) {
		this.userImgId = userImgId;
	}

	public String getUserImageUrl() {
		return userImageUrl;
	}

	public void setUserImageUrl(String userImageUrl) {
		this.userImageUrl = userImageUrl;
	}

    
}