
 /**
 * @Title: CouponActivity.java
 * @Package com.qbt.web.pojo.base
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater win10 2016年8月10日
 * @version V1.0
 **/

package com.qbt.web.pojo.coupon;

import java.util.Date;
import java.util.List;

/**
  * @ClassName: CouponActivity
  * @Description: TODO
  * @author win10 2016年8月10日
  * @modify win10 2016年8月10日
  */

public class CouponActivity {
	
    private Integer type;

    private Double chlidAmount;

    private String description;

    private Integer status;
    
    private Date startTime;
    
    private Date endTime;
    
    private String name;
    
    private List<String> childCodes;

	private Double limitAmount;
    
	private int couponCount;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Double getChlidAmount() {
		return chlidAmount;
	}

	public void setChlidAmount(Double chlidAmount) {
		this.chlidAmount = chlidAmount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getChildCodes() {
		return childCodes;
	}

	public void setChildCodes(List<String> childCodes) {
		this.childCodes = childCodes;
	}

	public Double getLimitAmount() {
		return limitAmount;
	}

	public void setLimitAmount(Double limitAmount) {
		this.limitAmount = limitAmount;
	}

	public int getCouponCount() {
		return couponCount;
	}

	public void setCouponCount(int couponCount) {
		this.couponCount = couponCount;
	}
	
}
