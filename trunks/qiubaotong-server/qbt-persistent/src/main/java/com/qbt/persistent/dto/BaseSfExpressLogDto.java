package com.qbt.persistent.dto;

import java.util.Date;

public class BaseSfExpressLogDto {

	//类型
	private String serviceName;
	
	//关键字
    private String keyword;
    
    //状态
    private Integer status;
    
    //开始时间
    private String beginTime;
    
    //结束时间
    private String endTime;

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
