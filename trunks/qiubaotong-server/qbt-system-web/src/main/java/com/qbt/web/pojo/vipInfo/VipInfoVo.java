package com.qbt.web.pojo.vipInfo;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class VipInfoVo {
	
	private int id;
	
	private Date createTime;
	
	private Date updateTime;
	
	private Integer vipTypeId;
	
    private String name;
    @NotNull(message = "用户名不能为空")
    private String userName;
    @NotNull(message = "手机号不能为空")
    private String mobile;
    
    private Double orderAmount;
    
    private String vipNo;

    private Date validTime;

    private Integer updateMobileCount;
    
    private Integer userId;
    
    private String openId;

    private String nickname;

    private Integer status;//1-正常 2-禁用
    
    private Integer activateStatus;
    
    private Integer activateMethod;
    
    private Boolean usedOrder;
    
    private Integer userImgId;
    
    private String userImageUrl;
    
    //操作人
    private String operatorName;
    
    //销售人员
    private String salesmanName;
    
    //操作人id
    private Integer operatorId;
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Integer getVipTypeId() {
		return vipTypeId;
	}

	public void setVipTypeId(Integer vipTypeId) {
		this.vipTypeId = vipTypeId;
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

	public String getVipNo() {
		return vipNo;
	}

	public void setVipNo(String vipNo) {
        this.vipNo = vipNo == null ? null : vipNo.trim();
	}

	public Date getValidTime() {
		return validTime;
	}

	public void setValidTime(Date validTime) {
		this.validTime = validTime;
	}

	public Integer getUpdateMobileCount() {
		return updateMobileCount;
	}

	public void setUpdateMobileCount(Integer updateMobileCount) {
		this.updateMobileCount = updateMobileCount;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getActivateStatus() {
		return activateStatus;
	}

	public void setActivateStatus(Integer activateStatus) {
		this.activateStatus = activateStatus;
	}

	public Integer getActivateMethod() {
		return activateMethod;
	}

	public void setActivateMethod(Integer activateMethod) {
		this.activateMethod = activateMethod;
	}

	public Boolean getUsedOrder() {
		return usedOrder;
	}

	public void setUsedOrder(Boolean usedOrder) {
		this.usedOrder = usedOrder;
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

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getSalesmanName() {
		return salesmanName;
	}

	public void setSalesmanName(String salesmanName) {
		this.salesmanName = salesmanName;
	}

	public Integer getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}

}