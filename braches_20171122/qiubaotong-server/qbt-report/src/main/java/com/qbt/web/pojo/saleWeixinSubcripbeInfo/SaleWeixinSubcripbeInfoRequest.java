package com.qbt.web.pojo.saleWeixinSubcripbeInfo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.qbt.common.result.Paging;

public class SaleWeixinSubcripbeInfoRequest extends Paging {

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	
	//销售人员ID
	private Integer saleId;

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

	public Integer getSaleId() {
		return saleId;
	}

	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}
	
}
