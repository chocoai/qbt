package com.qbt.web.pojo.userOrderCountTime;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.qbt.common.result.Paging;
import com.qbt.common.util.DateUtil;

public class UserOrderCountTimeRequest extends Paging {
	
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
	
	private String startTimeStr;
	
	private String endTimeStr;
	
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
