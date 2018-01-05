package com.qbt.persistent.entity;

import com.qbt.common.entity.BaseEntity;

public class UserProxy extends BaseEntity {

    private Integer userId;
    
    private Integer proxyUserId;

    private String name;

    private String mobile;
    
    private String nickname;

    private String headImgUrl;
    
    private Integer orderDayValue;
    
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getProxyUserId() {
		return proxyUserId;
	}

	public void setProxyUserId(Integer proxyUserId) {
		this.proxyUserId = proxyUserId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getHeadImgUrl() {
		return headImgUrl;
	}

	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}

	public Integer getOrderDayValue() {
		return orderDayValue;
	}

	public void setOrderDayValue(Integer orderDayValue) {
		this.orderDayValue = orderDayValue;
	}
    
    
}