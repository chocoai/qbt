package com.qbt.web.pojo.order;

import java.util.List;

public class ShoppingCartOrderDetail {

	 // 是否合作方订单
    private boolean partnerOrder = false;
    // 合作方支持的语言库
    private String[] partnerLangs;
    // 大订单号
    private String orderNumber;
    // 子订单号集合
    private List<OrderDetail> subOrders;
    // 关闭订单，不能继续支付个数
    private int invalidCount = 0;
    
	public boolean isPartnerOrder() {
		return partnerOrder;
	}
	public void setPartnerOrder(boolean partnerOrder) {
		this.partnerOrder = partnerOrder;
	}
	public String[] getPartnerLangs() {
		return partnerLangs;
	}
	public void setPartnerLangs(String[] partnerLangs) {
		this.partnerLangs = partnerLangs;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public List<OrderDetail> getSubOrders() {
		return subOrders;
	}
	public void setSubOrders(List<OrderDetail> subOrders) {
		this.subOrders = subOrders;
	}
	public int getInvalidCount() {
		return invalidCount;
	}
	public void setInvalidCount(int invalidCount) {
		this.invalidCount = invalidCount;
	}
	
}
