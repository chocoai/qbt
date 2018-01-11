package com.qbt.persistent.entity;

import java.util.Date;

import com.qbt.common.entity.BaseEntity;

public class Coupon extends BaseEntity {

    private Integer activityId;//活动id

    private String code;//优惠券编码
    
    private String childCode;//优惠券子码

    private Integer type;//优惠券类型：1:现金券;2:折扣券;3:特价券

    private Double amount;//代金金额
    
    private Double childAmount;//代金子金额
    
    private Date startTime;//券码开始时间

    private Date endTime;//券码结束时间

    private String description;//描述

    private Integer status;//1-未使用 2-已使用
    
    private int claimType;//0-未领取 1-用户领取 2-后台分发
    
    private int userId;//用户ID
   
    private String userName;//用户名称
    
    private Date claimTime;//领取时间
    
    private Double limitAmount;
    
    private Integer orderId; //绑定订单
    
    private Integer lockStatus; //锁定状态 0-非锁定 1-锁定
    
	
	
	/**
	 * getter method 
	 * @Title: getClaimTime
	 * @return the claimTime
	 */
	
	public Date getClaimTime() {
		return claimTime;
	}

	
	/**
	* setter method
	* @param claimTime the claimTime to set
	*/
	
	public void setClaimTime(Date claimTime) {
		this.claimTime = claimTime;
	}

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getStartTime() {
		return startTime;
	}


	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}


	public Date getEndTime() {
		return endTime;
	}


	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}


	public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

	
	/**
	 * getter method 
	 * @Title: getStatus
	 * @return the status
	 */
	
	public Integer getStatus() {
		return status;
	}

	
	/**
	* setter method
	* @param status the status to set
	*/
	
	public void setStatus(Integer status) {
		this.status = status;
	}

	
	/**
	 * getter method 
	 * @Title: getClaimType
	 * @return the claimType
	 */
	
	public int getClaimType() {
		return claimType;
	}

	
	/**
	* setter method
	* @param claimType the claimType to set
	*/
	
	public void setClaimType(int claimType) {
		this.claimType = claimType;
	}

	
	/**
	 * getter method 
	 * @Title: getUserId
	 * @return the userId
	 */
	
	public int getUserId() {
		return userId;
	}

	
	/**
	* setter method
	* @param userId the userId to set
	*/
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	
	/**
	 * getter method 
	 * @Title: getUserName
	 * @return the userName
	 */
	
	public String getUserName() {
		return userName;
	}

	
	/**
	* setter method
	* @param userName the userName to set
	*/
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	/**
	 * getter method 
	 * @Title: getChildCode
	 * @return the childCode
	 */
	
	public String getChildCode() {
		return childCode;
	}

	
	/**
	* setter method
	* @param childCode the childCode to set
	*/
	
	public void setChildCode(String childCode) {
		this.childCode = childCode;
	}

	
	/**
	 * getter method 
	 * @Title: getChildAmount
	 * @return the childAmount
	 */
	
	public Double getChildAmount() {
		return childAmount;
	}

	
	/**
	* setter method
	* @param childAmount the childAmount to set
	*/
	
	public void setChildAmount(Double childAmount) {
		this.childAmount = childAmount;
	}


	public Double getLimitAmount() {
		return limitAmount;
	}


	public void setLimitAmount(Double limitAmount) {
		this.limitAmount = limitAmount;
	}


	public Integer getOrderId() {
		return orderId;
	}


	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}


	public Integer getLockStatus() {
		return lockStatus;
	}


	public void setLockStatus(Integer lockStatus) {
		this.lockStatus = lockStatus;
	}

}