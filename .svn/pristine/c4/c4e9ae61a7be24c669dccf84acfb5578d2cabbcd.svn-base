package com.qbt.web.pojo.activity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.qbt.common.result.Paging;
import com.qbt.common.util.DateUtil;

public class ActivityRequest  extends Paging {
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	
	private String startTimeStr;
	
	private String endTimeStr;
	
	private String name;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getStartTimeStr() {
		if(this.startDate != null){
			return DateUtil.formatDate(this.startDate, DateUtil.DATE_FORMAT_02);
		}
		return startTimeStr;
	}

	public String getEndTimeStr() {
		if(this.endDate != null){
			return DateUtil.formatDate(this.endDate, DateUtil.DATE_FORMAT_02);
		}
		return endTimeStr;
	}
	
	
	
}
