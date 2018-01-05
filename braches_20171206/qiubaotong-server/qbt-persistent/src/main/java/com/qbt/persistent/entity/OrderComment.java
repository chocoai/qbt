package com.qbt.persistent.entity;

import com.qbt.common.entity.BaseEntity;

public class OrderComment extends BaseEntity {
	
	//订单ID
	private Integer orderId;
	
	//订单编号
	private String orderNumber;
	
	//寄件地区路径
	private String jTreePath;
	
	//收件地区路径
	private String dTreePath;
	
	//用户ID
	private Integer userId;
	
	//用户微信昵称
	private String userName;
	
	//微信头像URL
	private String headImgUrl;
	
	//客服评星
	private Integer kfLevel;
	
	//顺丰包装评星
	private Integer sfPackLevel;
		
	//顺丰送货速度评星
	private Integer sfDeliverLevel;
	
	//顺丰配送服务评星
	private Integer sfServiceLevel;
	
	//总评星
	private Double totalLevel;
	
	//评论内容
	private String content;
	
	//图片1
	private String url1;
	
	//图片2
	private String url2;	
	
	//图片3
	private String url3;
	
	//1-待审核 2-审核通过 3-审核不通过
	private Integer status;
	
	//是否置顶
	private Boolean isTop;
	
	//审核人员ID
	private Integer sysUserId;
	
	//审核人员名称
	private String sysUserName;
	
	//客服回复
	private String memo;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getjTreePath() {
		return jTreePath;
	}

	public void setjTreePath(String jTreePath) {
		this.jTreePath = jTreePath;
	}

	public String getdTreePath() {
		return dTreePath;
	}

	public void setdTreePath(String dTreePath) {
		this.dTreePath = dTreePath;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getHeadImgUrl() {
		return headImgUrl;
	}

	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}

	public Integer getKfLevel() {
		return kfLevel;
	}

	public void setKfLevel(Integer kfLevel) {
		this.kfLevel = kfLevel;
	}

	public Integer getSfPackLevel() {
		return sfPackLevel;
	}

	public void setSfPackLevel(Integer sfPackLevel) {
		this.sfPackLevel = sfPackLevel;
	}

	public Integer getSfDeliverLevel() {
		return sfDeliverLevel;
	}

	public void setSfDeliverLevel(Integer sfDeliverLevel) {
		this.sfDeliverLevel = sfDeliverLevel;
	}

	public Integer getSfServiceLevel() {
		return sfServiceLevel;
	}

	public void setSfServiceLevel(Integer sfServiceLevel) {
		this.sfServiceLevel = sfServiceLevel;
	}

	public Double getTotalLevel() {
		return totalLevel;
	}

	public void setTotalLevel(Double totalLevel) {
		this.totalLevel = totalLevel;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl1() {
		return url1;
	}

	public void setUrl1(String url1) {
		this.url1 = url1;
	}

	public String getUrl2() {
		return url2;
	}

	public void setUrl2(String url2) {
		this.url2 = url2;
	}

	public String getUrl3() {
		return url3;
	}

	public void setUrl3(String url3) {
		this.url3 = url3;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Boolean getIsTop() {
		return isTop;
	}

	public void setIsTop(Boolean isTop) {
		this.isTop = isTop;
	}

	public Integer getSysUserId() {
		return sysUserId;
	}

	public void setSysUserId(Integer sysUserId) {
		this.sysUserId = sysUserId;
	}

	public String getSysUserName() {
		return sysUserName;
	}

	public void setSysUserName(String sysUserName) {
		this.sysUserName = sysUserName;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
