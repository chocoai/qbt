/**
 * Project Name:qbt-report
 * File Name:ReportCostItemVo.java
 * Package Name:com.qbt.web.pojo.orderCostItem
 * Date:2017年1月19日下午5:00:44
 *
*/

package com.qbt.web.pojo.orderCostItem;

import java.util.Date;

/**
 * ClassName:ReportCostItemVo
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月19日 下午5:00:44
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class ReportCostItemVo {
	
	private Integer orderId;
	
	private Date orderTime;
	
	private String orderNumber;
	
	private Double orderAmount;
	
	private Integer payMethod;
	
	private String item;
	
	private Double itemAmount;
	
	private String itemRemark;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Integer getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(Integer payMethod) {
		this.payMethod = payMethod;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Double getItemAmount() {
		return itemAmount;
	}

	public void setItemAmount(Double itemAmount) {
		this.itemAmount = itemAmount;
	}

	public String getItemRemark() {
		return itemRemark;
	}

	public void setItemRemark(String itemRemark) {
		this.itemRemark = itemRemark;
	}
	
}
