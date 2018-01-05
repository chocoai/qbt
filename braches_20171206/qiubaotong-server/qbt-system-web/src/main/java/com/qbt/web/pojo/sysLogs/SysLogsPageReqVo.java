package com.qbt.web.pojo.sysLogs;

import java.util.Date;

import com.qbt.common.result.Paging;

public class SysLogsPageReqVo extends Paging{
	
	private Date startTime;
	
	private Date endTime;

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	
	
}
