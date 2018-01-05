package com.qbt.web.pojo.orderCount;

import java.util.Date;

import com.qbt.common.result.Paging;

public class OrderCountRequest extends Paging{
	
	private Date startDate;
	
	private Date endDate;

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