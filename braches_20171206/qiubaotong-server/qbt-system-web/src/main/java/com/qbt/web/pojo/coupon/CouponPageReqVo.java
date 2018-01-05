package com.qbt.web.pojo.coupon;

import com.qbt.common.result.Paging;

public class CouponPageReqVo extends Paging {
	
	private Integer activityId;//活动id
	
	private String activityName;//活动名称
	
	private String code;//优惠码
	
	private String userName;

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
		this.activityName = activityName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
