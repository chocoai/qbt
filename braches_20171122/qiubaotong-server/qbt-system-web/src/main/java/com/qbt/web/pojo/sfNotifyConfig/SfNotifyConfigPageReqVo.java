package com.qbt.web.pojo.sfNotifyConfig;

import com.qbt.common.result.Paging;

public class SfNotifyConfigPageReqVo extends Paging {
	
	private String orderNumber;//订单号

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
}
