package com.qbt.web.pojo.saleWeixinSubcripbeInfo;

import java.util.Date;

import com.qbt.common.result.Paging;

public class SaleWeixinSubcripbeInfoPageReqVo extends Paging {

	//销售人员ID
	private Integer saleId;
	
	//统计开始时间
	private Date startDate;
	
	//统计截至时间
	private Date endDate;

	public Integer getSaleId() {
		return saleId;
	}

	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}

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
	
}
