package com.qbt.persistent.entity;

import com.qbt.common.entity.BaseEntity;

public class OrderEmailInsured extends BaseEntity{
	
    private Integer min;

    private Integer max;

    private Integer orderEmailId;

    private String insuredChannel;

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getOrderEmailId() {
        return orderEmailId;
    }

    public void setOrderEmailId(Integer orderEmailId) {
        this.orderEmailId = orderEmailId;
    }

	public String getInsuredChannel() {
		return insuredChannel;
	}

	public void setInsuredChannel(String insuredChannel) {
		this.insuredChannel = insuredChannel;
	}

}