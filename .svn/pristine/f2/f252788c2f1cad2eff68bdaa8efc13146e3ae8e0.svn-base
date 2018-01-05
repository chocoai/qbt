/**
 * Project Name:qbt-shansong
 * File Name:CalcOrderInfo.java
 * Package Name:com.qbt.shansong.entity.ordercalc
 * Date:2017年2月23日下午3:33:24
 *
*/

package com.qbt.shansong.entity.ordercalc;

import java.util.List;

/**
 * ClassName:CalcOrderInfo
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月23日 下午3:33:24
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class CalcOrderInfo {
	
	//订单号(您的平台里订单的唯一号)
	private String orderNo;
	
	//商户(下单人)信息
	private OrderCalcMerchant merchant;
	
	//寄件人信息
	private OrderCalcSender sender;
	
	//收件人列表(目前只支持1个收件人)
	private List<OrderCalcReceiver> receiverList;
	
	//物品
	private String goods;
	
	//单位: kg(不足整公斤则向上取整)
	private Double weight;
	
	//加价费(单位:分)
	private Double addition;
	
	//预约时间(yyyy-MM-dd HH:mm:ss)
	private String appointTime;
	
	//备注信息, 最长250字符
	private String remark;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public OrderCalcMerchant getMerchant() {
		return merchant;
	}

	public void setMerchant(OrderCalcMerchant merchant) {
		this.merchant = merchant;
	}

	public OrderCalcSender getSender() {
		return sender;
	}

	public void setSender(OrderCalcSender sender) {
		this.sender = sender;
	}

	public List<OrderCalcReceiver> getReceiverList() {
		return receiverList;
	}

	public void setReceiverList(List<OrderCalcReceiver> receiverList) {
		this.receiverList = receiverList;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getAddition() {
		return addition;
	}

	public void setAddition(Double addition) {
		this.addition = addition;
	}

	public String getAppointTime() {
		return appointTime;
	}

	public void setAppointTime(String appointTime) {
		this.appointTime = appointTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
