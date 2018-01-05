/**
 * Project Name:qbt-support
 * File Name:SmsMessageSupport.java
 * Package Name:com.qbt.bussiness.support
 * Date:2017年7月31日下午1:21:05
 *
*/

package com.qbt.bussiness.support;
/**
 * ClassName:SmsMsgSupport
 * Reason:	 TODO ADD REASON.
 * Date:     2017年7月31日 下午1:21:05
 * @author   huangyihao
 * @version  
 * @see 	 
 */

import java.util.HashMap;

import com.qbt.persistent.dto.UserCouponActivity;
import com.qbt.persistent.entity.OrderInfo;
import com.qbt.persistent.entity.SaleUser;
import com.qbt.persistent.entity.UserProxy;

public interface SmsMsgSupport {
	
	//----------日语消息--------
	HashMap<String, Object> createOrderJpMsgToJContact(OrderInfo orderInfo);
	
	HashMap<String, Object> createOrderJpMsgToDContact(OrderInfo orderInfo);
	
	HashMap<String, Object> sendOrderCancelJpMsgToJContact(OrderInfo orderInfo);
	
	HashMap<String, Object> sendOrderCancelJpMsgToDContact(OrderInfo orderInfo);
	
	HashMap<String, Object> sendOrderSignJpMsgToJContact(OrderInfo orderInfo);
	
	HashMap<String, Object> sendOrderSignJpMsgToDContact(OrderInfo orderInfo);
	
	//----------中文消息--------
	HashMap<String, Object> createOrderMsgToJContact(OrderInfo orderInfo);
	
	HashMap<String, Object> createOrderMsgToDContact(OrderInfo orderInfo);
	
	HashMap<String, Object> sendOrderSignMsgToJContact(OrderInfo orderInfo);
	
	HashMap<String, Object> sendOrderSignMsgToDContact(OrderInfo orderInfo);
	
	HashMap<String, Object> sendOrderCancelMsgToJContact(OrderInfo orderInfo);
	
	HashMap<String, Object> sendOrderCancelMsgToDContact(OrderInfo orderInfo);
	
	HashMap<String, Object> sendOrderModifyMsgToJContact(OrderInfo before, OrderInfo after);
	
	HashMap<String, Object> sendOrderModifyMsgToDContact(OrderInfo before, OrderInfo after);
	
	HashMap<String, Object> sendProxySelfOrderMsg(UserProxy userProxy);
	
	HashMap<String, Object> sendSaleProxyOrderMsg(SaleUser saleUser, UserProxy userProxy, OrderInfo orderInfo);
	
	HashMap<String, Object> sendOrderCouponMsg(OrderInfo orderInfo, UserCouponActivity uca);
}
