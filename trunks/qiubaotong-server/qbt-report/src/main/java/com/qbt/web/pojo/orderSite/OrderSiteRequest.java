package com.qbt.web.pojo.orderSite;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.qbt.common.result.Paging;

public class OrderSiteRequest extends Paging {
	
	//开始时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
		
	//结束时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	
	//寄件地址类型:1-course球场，2-airport机场,3-bank银行,4-地域
	private Integer jAddrType;
	
	//寄件地域/站点id
	private Integer jSiteId;
	
	//收件地址类型:1-course球场，2-airport机场,3-bank银行,4-地域
	private Integer dAddrType;
	
	//收件地域/站点id
	private Integer dSiteId;

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

	public Integer getdAddrType() {
		return dAddrType;
	}

	public void setdAddrType(Integer dAddrType) {
		this.dAddrType = dAddrType;
	}

	public Integer getdSiteId() {
		return dSiteId;
	}

	public void setdSiteId(Integer dSiteId) {
		this.dSiteId = dSiteId;
	}
	
}
