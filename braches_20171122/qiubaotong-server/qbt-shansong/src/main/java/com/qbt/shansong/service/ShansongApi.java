/**
 * Project Name:qbt-shansong
 * File Name:ShansongApi.java
 * Package Name:com.qbt.shansong.service
 * Date:2017年2月23日下午1:54:31
 *
*/

package com.qbt.shansong.service;

import com.qbt.shansong.entity.ShansongResponse;
import com.qbt.shansong.entity.orderaccount.OrderAccountRequest;
import com.qbt.shansong.entity.ordercalc.OrderCalcRequest;
import com.qbt.shansong.entity.ordercalc.OrderCalcResult;
import com.qbt.shansong.entity.ordercancel.OrderCancelRequest;
import com.qbt.shansong.entity.ordercancel.OrderCancelResult;
import com.qbt.shansong.entity.orderinfo.OrderInfoRequest;
import com.qbt.shansong.entity.orderinfo.OrderInfoResult;
import com.qbt.shansong.entity.ordertrail.OrderTrailRequest;
import com.qbt.shansong.entity.ordertrail.OrderTrailResult;

/**
 * ClassName:ShansongApi
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月23日 下午1:54:31
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface ShansongApi {
	
	/**
	 * 
	 * orderCalc:(计算订单费用).
	 *
	 * @author huangyihao
	 * 2017年2月23日 下午4:21:11
	 * @param request
	 * @return
	 *
	 */
	public ShansongResponse<OrderCalcResult> orderCalc(OrderCalcRequest request);
	
	/**
	 * 
	 * orderSave:(下单).
	 *
	 * @author huangyihao
	 * 2017年2月23日 下午4:22:18
	 * @param request
	 * @return 闪送平台的订单编号
	 *
	 */
	public ShansongResponse<String> orderSave(OrderCalcRequest request);
	
	/**
	 * 
	 * calSignature:(计算签名值).
	 *
	 * @author huangyihao
	 * 2017年2月24日 上午10:11:34
	 * @param orderNo
	 * @return
	 *
	 */
	public String calSignature(String orderNo);
	
	/**
	 * 
	 * queryOrderInfo:(查询订单状态).
	 *
	 * @author huangyihao
	 * 2017年2月24日 上午10:46:23
	 * @param request
	 * @return
	 *
	 */
	public ShansongResponse<OrderInfoResult> queryOrderInfo(OrderInfoRequest request);
	
	/**
	 * 
	 * orderTrail:(查询闪送员轨迹).
	 *
	 * @author huangyihao
	 * 2017年2月24日 上午11:07:19
	 * @param request
	 * @return
	 *
	 */
	public ShansongResponse<OrderTrailResult> orderTrail(OrderTrailRequest request);
	
	/**
	 * 
	 * orderCancel:(取消订单).
	 *
	 * @author huangyihao
	 * 2017年2月24日 上午11:18:47
	 * @param request
	 * @return
	 *
	 */
	public ShansongResponse<OrderCancelResult> orderCancel(OrderCancelRequest request);
	
	/**
	 * 
	 * orderAccount:(账户余额查询).
	 *
	 * @author huangyihao
	 * 2017年2月24日 下午2:29:28
	 * @param request
	 * @return
	 *
	 */
	public ShansongResponse<Double> orderAccount(OrderAccountRequest request);
	
}
