package com.qbt.web.pojo.orderCourse;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.qbt.common.result.Paging;

public class OrderCourseRequest extends Paging {
	
	//开始时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	
	//结束时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	
    //寄件球场id
    private Integer jAddrId;
    
    //收件球场id
    private Integer dAddrId;

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

	public Integer getjAddrId() {
		return jAddrId;
	}

	public void setjAddrId(Integer jAddrId) {
		this.jAddrId = jAddrId;
	}

	public Integer getdAddrId() {
		return dAddrId;
	}

	public void setdAddrId(Integer dAddrId) {
		this.dAddrId = dAddrId;
	}

}
