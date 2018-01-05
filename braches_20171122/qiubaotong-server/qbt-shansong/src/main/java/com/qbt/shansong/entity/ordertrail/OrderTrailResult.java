/**
 * Project Name:qbt-shansong
 * File Name:OrderTrailResult.java
 * Package Name:com.qbt.shansong.entity.ordertrail
 * Date:2017年2月24日上午11:00:41
 *
*/

package com.qbt.shansong.entity.ordertrail;

import java.util.List;

/**
 * ClassName:OrderTrailResult
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月24日 上午11:00:41
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class OrderTrailResult {
	
	//合作伙伴订单号
	private String orderNo;
	
	//闪送员手机号
	private String courier;
	
	private List<OrderTrailMessage> trialMessage;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getCourier() {
		return courier;
	}

	public void setCourier(String courier) {
		this.courier = courier;
	}

	public List<OrderTrailMessage> getTrialMessage() {
		return trialMessage;
	}

	public void setTrialMessage(List<OrderTrailMessage> trialMessage) {
		this.trialMessage = trialMessage;
	}
	
}
