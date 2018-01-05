package com.qbt.web.pojo.assistant;

import javax.validation.constraints.NotNull;

public class AssistantDelivery {
	
	@NotNull(message="订单ID不能为空")
	private String orderId;
	@NotNull(message="助理场地不能为空")
	private Integer applyId;
	@NotNull(message="助理场地类型不能为空")
	private Integer applyType;
	@NotNull(message="寄件收件类型不能为空")
	private Integer type;
	@NotNull(message="操作类型不能为空")
	private Integer optType; // 1-正常件  2-异常件
	
	private String remark;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getApplyId() {
		return applyId;
	}

	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}

	public Integer getApplyType() {
		return applyType;
	}

	public void setApplyType(Integer applyType) {
		this.applyType = applyType;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getOptType() {
		return optType;
	}

	public void setOptType(Integer optType) {
		this.optType = optType;
	}

	
	
}
