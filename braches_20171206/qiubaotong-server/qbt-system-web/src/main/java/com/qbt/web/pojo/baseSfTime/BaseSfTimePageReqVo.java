package com.qbt.web.pojo.baseSfTime;

import java.util.Date;

import com.qbt.common.result.Paging;

public class BaseSfTimePageReqVo extends Paging {

	//起始日期（年度）
	private Date startDate;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
}
