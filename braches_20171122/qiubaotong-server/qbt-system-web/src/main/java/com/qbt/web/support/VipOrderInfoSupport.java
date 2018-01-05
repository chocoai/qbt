/**
 * Project Name:qbt-system-web
 * File Name:VipOrderInfoSupport.java
 * Package Name:com.qbt.web.support
 * Date:2016年11月4日下午3:04:19
 *
*/

package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.vipOrderInfo.VipOrderInfoPageReqVo;
import com.qbt.web.pojo.vipOrderInfo.VipOrderInfoVo;

/**
 * 会员卡订单管理
 * ClassName:VipOrderInfoSupport
 * Reason:	 TODO ADD REASON.
 * Date:     2016年11月4日 下午3:04:19
 * @author   haungyihao
 * @version  
 * @see 	 
 */
public interface VipOrderInfoSupport {
	
	List<VipOrderInfoVo> findByPage(VipOrderInfoPageReqVo reqVo);
	
}
