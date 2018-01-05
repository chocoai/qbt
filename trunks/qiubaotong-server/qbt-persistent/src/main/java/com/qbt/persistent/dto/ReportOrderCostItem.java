/**
 * Project Name:qbt-persistent
 * File Name:ReportOrderCostItem.java
 * Package Name:com.qbt.persistent.entity
 * Date:2017年1月19日下午3:52:43
 *
*/

package com.qbt.persistent.dto;

import com.qbt.persistent.entity.OrderInfo;

/**
 * ClassName:ReportOrderCostItem
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月19日 下午3:52:43
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class ReportOrderCostItem extends OrderInfo {
	
	private Integer payMethod;
	
	private String item;
	
	private Double itemAmount;
	
	private String itemRemark;

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
