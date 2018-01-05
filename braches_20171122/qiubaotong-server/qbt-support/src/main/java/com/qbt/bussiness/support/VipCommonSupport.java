/**
 * Project Name:qbt-support
 * File Name:VipCommonSupport.java
 * Package Name:com.qbt.bussiness.support
 * Date:2017年9月1日上午11:36:59
 *
*/

package com.qbt.bussiness.support;

import com.qbt.bussiness.pojo.vip.VipOrderConfirmRequest;
import com.qbt.bussiness.pojo.vip.VipOrderConfirmResponse;

/**
 * ClassName:VipCommonSupport
 * Reason:	 TODO ADD REASON.
 * Date:     2017年9月1日 上午11:36:59
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface VipCommonSupport {
	
	/**
	  * 检查是否满足VIP订单
	  * @Title: checkVipOrder
	  * @Description: TODO
	  * @author: share 2016年11月5日
	  * @modify: share 2016年11月5日
	  * @param vipOrderConfirmRequest
	  * @return
	 */
	VipOrderConfirmResponse checkVipOrder(VipOrderConfirmRequest vipOrderConfirmRequest);
	
}
