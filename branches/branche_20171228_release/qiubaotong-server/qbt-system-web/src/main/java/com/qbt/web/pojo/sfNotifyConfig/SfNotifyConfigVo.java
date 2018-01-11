package com.qbt.web.pojo.sfNotifyConfig;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class SfNotifyConfigVo {
	
	private int id;//id

    private Date createTime;//创建时间
    private Date updateTime;//更新时间
    
    @NotNull(message = "订单不能为空")
    private String orderNumber;//活动名称
    
    private Integer operator; // 操作人
    
    private String operatorName; // 操作人

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Integer getOperator() {
		return operator;
	}

	public void setOperator(Integer operator) {
		this.operator = operator;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

}
