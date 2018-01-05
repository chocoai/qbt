/**
 * Project Name:qbt-support
 * File Name:WechatMessageSupport.java
 * Package Name:com.qbt.bussiness.support
 * Date:2017年7月31日下午4:04:27
 *
*/

package com.qbt.bussiness.support;
/**
 * ClassName:WechatMessageSupport
 * Reason:	 TODO ADD REASON.
 * Date:     2017年7月31日 下午4:04:27
 * @author   huangyihao
 * @version  
 * @see 	 
 */

import java.util.Map;

import com.qbt.persistent.dto.UserCouponActivity;
import com.qbt.persistent.entity.OrderExceptionBook;
import com.qbt.persistent.entity.OrderInfo;
import com.qbt.persistent.entity.OrderRefund;
import com.qbt.persistent.entity.SaleUser;
import com.qbt.persistent.entity.UserActivityOrder;
import com.qbt.persistent.entity.UserAssistant;
import com.qbt.persistent.entity.UserAssistantApply;
import com.qbt.persistent.entity.UserProxy;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.persistent.entity.VipInfo;

public interface WechatMessageSupport {
	
	Map<String, String> createOrderNotify(OrderInfo orderInfo);
	
	Map<String, String> orderReciveNotify(OrderInfo orderInfo, String acceptTime);
	
	Map<String, String>	orderTransportNotify(OrderInfo orderInfo, String acceptTime);
	
	Map<String, String> orderSignNotify(OrderInfo orderInfo, String acceptTime);
	
	Map<String, String> createOrderKfNotify(OrderInfo orderInfo, String openid);
	
	Map<String, String> createOrderCwNotify(OrderInfo orderInfo, String openid);
	
	Map<String, String> orderCancelNotify(OrderInfo orderInfo);
	
	Map<String, String> orderCancelKfNotify(OrderInfo orderInfo, String openid);
	
	Map<String, String> orderCancelCwNotify(OrderInfo orderInfo, String openid);
	
	Map<String, String> exceptionBookNotify(OrderExceptionBook orderExceptionBook, String openid);
	
	Map<String, String> vipSuccessPayNotify(VipInfo vipInfo);
	
	Map<String, String> proxyAddOrderNotify(OrderInfo orderInfo, String openId, String url);
	
	Map<String, String> proxyOrderNotify(OrderInfo orderInfo, UserProxy userProxy, String openId, String url);
	
	Map<String, String> scanQrcodeNotify(UserWeixin proxyUser, UserWeixin scanUser, String url);
	
	Map<String, String> expireCouponNotify(UserCouponActivity couponActivity, String openid);
	
	Map<String, String> waitPayNotify(OrderInfo orderInfo);
	
	Map<String, String> assistantApplyNotify(UserAssistantApply apply, UserAssistant assistant, String openid);
	
	Map<String, String> orderCancelNotify(OrderInfo orderInfo, OrderRefund refund);
	
	Map<String, String> orderCancelCwNotify(OrderInfo orderInfo, String openid, OrderRefund refund);
	
	Map<String, String> saleUserApplyNotify(SaleUser saleUser, String openid);
	
	Map<String, String> pushTicketPackagePaymentNotify(UserActivityOrder userActivityOrder);
}
