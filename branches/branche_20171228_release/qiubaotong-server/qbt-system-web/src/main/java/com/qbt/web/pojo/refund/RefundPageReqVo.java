package com.qbt.web.pojo.refund;

import java.util.Date;

import com.qbt.common.result.Paging;

public class RefundPageReqVo extends Paging {
	
    private Date startTime;
	
	private Date endTime;
	
	//订单编号
	private String orderNumber;
	
	//状态：1-待处理 2-已处理
	private Integer status;
	
	//用户名
	private String userName;
	
	//手机号
	private String mobile;
	
	//客服姓名
	private String kfName;
	
	//客服手机号
	private String kfMobile;
	
	//是否通知用户
	private Boolean isNotice;

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getKfName() {
		return kfName;
	}

	public void setKfName(String kfName) {
		this.kfName = kfName;
	}

	public String getKfMobile() {
		return kfMobile;
	}

	public void setKfMobile(String kfMobile) {
		this.kfMobile = kfMobile;
	}

	public Boolean getIsNotice() {
		return isNotice;
	}

	public void setIsNotice(Boolean isNotice) {
		this.isNotice = isNotice;
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

}
