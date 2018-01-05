/**
 * Project Name:qbt-support
 * File Name:OrderWaybillCommonSupport.java
 * Package Name:com.qbt.bussiness.support
 * Date:2017年8月3日上午10:56:42
 *
*/

package com.qbt.bussiness.support;

import com.qbt.bussiness.pojo.CommonSfRoute;
import com.qbt.persistent.entity.OrderInfo;

/**
 * ClassName:OrderSfRouteCommonSupport
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月3日 上午10:56:42
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface OrderSfRouteCommonSupport {
	
	/**
	 * 
	 * orderRoute:(顺丰路由公共处理).
	 *
	 * @author huangyihao
	 * 2017年8月3日 上午11:03:21
	 * @param orderInfo
	 * @param commonSfRoute
	 *
	 */
	void orderRoute(String sfId, OrderInfo orderInfo, CommonSfRoute commonSfRoute);
	
}
