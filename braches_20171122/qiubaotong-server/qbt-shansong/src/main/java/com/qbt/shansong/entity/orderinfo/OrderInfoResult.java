/**
 * Project Name:qbt-shansong
 * File Name:OrderInfoResult.java
 * Package Name:com.qbt.shansong.entity.orderinfo
 * Date:2017年2月24日上午10:37:18
 *
*/

package com.qbt.shansong.entity.orderinfo;
/**
 * ClassName:OrderInfoResult
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月24日 上午10:37:18
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class OrderInfoResult {
	
	//订单状态描述
	private String orderStatusTxt;
	
	//闪送员手机号
	private String courier;
	
	//闪送员姓名
	private String courierName;
	
	//取件密码
	private String pickupPassword;
	
	//订单状态码
	private Integer orderStatus;

	public String getOrderStatusTxt() {
		return orderStatusTxt;
	}

	public void setOrderStatusTxt(String orderStatusTxt) {
		this.orderStatusTxt = orderStatusTxt;
	}

	public String getCourier() {
		return courier;
	}

	public void setCourier(String courier) {
		this.courier = courier;
	}

	public String getCourierName() {
		return courierName;
	}

	public void setCourierName(String courierName) {
		this.courierName = courierName;
	}

	public String getPickupPassword() {
		return pickupPassword;
	}

	public void setPickupPassword(String pickupPassword) {
		this.pickupPassword = pickupPassword;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	
}
