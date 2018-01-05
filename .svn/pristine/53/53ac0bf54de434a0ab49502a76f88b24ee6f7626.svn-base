package com.qbt.web.pojo.orderJCourse;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.qbt.common.result.Paging;

public class OrderJCourseRequest extends Paging {
	
	//开始时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	
	//结束时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	
	//寄件人姓名
	private String jContact;

	//寄件手机号
    private String jMobile;
    
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

	public String getjContact() {
		return jContact;
	}

	public void setjContact(String jContact) {
		this.jContact = jContact;
	}

	public String getjMobile() {
		return jMobile;
	}

	public void setjMobile(String jMobile) {
		this.jMobile = jMobile;
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
