package com.qbt.persistent.entity;

import java.util.Date;

import com.qbt.common.entity.BaseEntity;

public class VipInfo extends BaseEntity {
	
	private Integer vipTypeId;
	
    private String name;
    
    private Double orderAmount;

    private String userName;

    private String mobile;

    private String vipNo;

    private Date validTime;

    private Integer updateMobileCount;
    
    private Integer userId;

    private String openId;

    private String nickname;

    private Integer status;
    
    private Integer activateStatus;
    
    private Integer activateMethod;
    
    private Boolean usedOrder;
    
    private Integer userImgId;
    
    private String userImageUrl;
    
    private long lastOrderDeliverTime;
    
    private int operatorId;
    
    private String operatorName;

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

	public long getLastOrderDeliverTime() {
		return lastOrderDeliverTime;
	}

	public void setLastOrderDeliverTime(long lastOrderDeliverTime) {
		this.lastOrderDeliverTime = lastOrderDeliverTime;
	}

	public int getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	
}