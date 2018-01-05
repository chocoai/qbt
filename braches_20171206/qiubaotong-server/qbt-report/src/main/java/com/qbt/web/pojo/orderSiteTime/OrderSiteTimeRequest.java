package com.qbt.web.pojo.orderSiteTime;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.qbt.common.result.Paging;

public class OrderSiteTimeRequest extends Paging {
	
	//开始时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
		
	//结束时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	
	//预约取件开始时间
	private String sendSfStartTime;
	
	//预约取件结束时间
	private String sendSfEndTime;
	
	//寄件地址类型:1-course球场，2-airport机场,3-bank银行,4-地域
	private Integer jAddrType;
	
	//寄件地域/站点id
	private Integer jSiteId;
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getSendSfStartTime() {
		return sendSfStartTime;
	}

	public void setSendSfStartTime(String sendSfStartTime) {
		this.sendSfStartTime = sendSfStartTime;
	}

	public String getSendSfEndTime() {
		return sendSfEndTime;
	}

	public void setSendSfEndTime(String sendSfEndTime) {
		this.sendSfEndTime = sendSfEndTime;
	}

	public Integer getjAddrType() {
		return jAddrType;
	}

	public void setjAddrType(Integer jAddrType) {
		this.jAddrType = jAddrType;
	}

	public Integer getjSiteId() {
		return jSiteId;
	}

	public void setjSiteId(Integer jSiteId) {
		this.jSiteId = jSiteId;
	}

}
