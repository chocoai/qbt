package com.qbt.web.pojo.baseSfExpressLog;

import java.util.Date;

public class BaseSfExpressLogVo {

	//时间
	private Date createTime;
	
	//方法名称
	/*
	 * orderService 顺丰正向下单
     * orderReverseService 顺丰反向下单
     * deliverTmService 顺丰时效查询
     * deliverTmServiceBySfWebSite 顺丰官网时效查询
	 * */
	private String serviceName;

	//关键字
    private String keyword;
    
    //请求报文
    private String requestBody;

    //响应报文
    private String responseBody;

    //状态 1-成功 2-失败
    private Integer status;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

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

	public String getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}

	public String getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
    
}
