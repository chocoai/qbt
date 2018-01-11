package com.qbt.web.pojo.baseSfExpressLog;

import java.util.Date;

public class BaseSfExpressLogPageVo {

	//id
	private int id;
	
	//时间
	private Date createTime;
	
	//关键字
    private String keyword;
    
    //状态 1-成功 2-失败
    private Integer status;
    
    //类型
    /*
     * orderService 顺丰正向下单
     * orderReverseService 顺丰反向下单
     * deliverTmService 顺丰时效查询
     * deliverTmServiceBySfWebSite 顺丰官网时效查询
     * */
    private String serviceName;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	/*private String serviceName;

    private String requestBody;

    private String responseBody;*/
    
}
