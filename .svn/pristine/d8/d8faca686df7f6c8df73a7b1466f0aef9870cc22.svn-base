package com.qbt.web.pojo.order;

import javax.validation.constraints.NotNull;

public class CommentRequest {

	// 订单编号
	@NotNull(message="订单编号不能为空")
	private String orderNumber;
	
	// 客服评星
	private Integer kfLevel = 0;

	// 顺丰包装评星
	private Integer sfPackLevel = 0;

	// 顺丰送货速度评星
	private Integer sfDeliverLevel = 0;

	// 顺丰配送服务评星
	private Integer sfServiceLevel = 0;

	// 评论内容
	@NotNull(message="评论内容不能为空")
	private String content;

	// 图片url
	private String[] pics;

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String[] getPics() {
		return pics;
	}

	public void setPics(String[] pics) {
		this.pics = pics;
	}

}
