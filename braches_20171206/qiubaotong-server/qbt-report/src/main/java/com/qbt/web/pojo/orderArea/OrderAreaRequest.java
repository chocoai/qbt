package com.qbt.web.pojo.orderArea;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.qbt.common.result.Paging;

public class OrderAreaRequest extends Paging {
	
	// 开始时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;

	// 结束时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	
	// 寄件地区id
	private Integer jAreaId;
	
	// 收件件地区id
	private Integer dAreaId;

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

	public Integer getjAreaId() {
		return jAreaId;
	}

	public void setjAreaId(Integer jAreaId) {
		this.jAreaId = jAreaId;
	}

	public Integer getdAreaId() {
		return dAreaId;
	}

	public void setdAreaId(Integer dAreaId) {
		this.dAreaId = dAreaId;
	}
	
}
