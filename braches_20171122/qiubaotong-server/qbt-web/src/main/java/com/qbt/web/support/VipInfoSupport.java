/**
 * Project Name:qbt-web
 * File Name:VipInfoSupport.java
 * Package Name:com.qbt.web.support
 * Date:2017年2月20日下午3:00:38
 *
*/

package com.qbt.web.support;

import com.qbt.bussiness.pojo.vip.VipOrderConfirmRequest;
import com.qbt.web.pojo.vip.VipOrderConfirmVo;

/**
 * ClassName:VipInfoSupport
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月20日 下午3:00:38
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public interface VipInfoSupport {
	
	
	VipOrderConfirmVo checkVipOrderByUser(VipOrderConfirmRequest vipOrderConfirmRequest);
	
}
