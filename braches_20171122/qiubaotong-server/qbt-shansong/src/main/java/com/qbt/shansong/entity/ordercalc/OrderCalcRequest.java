/**
 * Project Name:qbt-shansong
 * File Name:OrderCalcRequest.java
 * Package Name:com.qbt.shansong.entity.ordercalc
 * Date:2017年2月23日下午2:48:16
 *
*/

package com.qbt.shansong.entity.ordercalc;

import com.qbt.shansong.entity.ShansongRequest;

/**
 * ClassName:OrderCalcRequest
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月23日 下午2:48:16
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class OrderCalcRequest extends ShansongRequest {
	
	//订单信息
	private CalcOrderInfo order;

	public CalcOrderInfo getOrder() {
		return order;
	}

	public void setOrder(CalcOrderInfo order) {
		this.order = order;
	}
	
}
