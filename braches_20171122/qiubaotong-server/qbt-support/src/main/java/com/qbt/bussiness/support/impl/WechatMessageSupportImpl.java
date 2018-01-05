/**
 * Project Name:qbt-support
 * File Name:WechatMessageSupportImpl.java
 * Package Name:com.qbt.bussiness.support.impl
 * Date:2017年7月31日下午4:12:17
 *
*/

package com.qbt.bussiness.support.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.bussiness.support.WechatCommonSupport;
import com.qbt.bussiness.support.WechatMessageSupport;
import com.qbt.bussiness.template.WechatTemplate;
import com.qbt.persistent.dto.UserCouponActivity;
import com.qbt.persistent.entity.OrderExceptionBook;
import com.qbt.persistent.entity.OrderInfo;
import com.qbt.persistent.entity.OrderRefund;
import com.qbt.persistent.entity.SaleUser;
import com.qbt.persistent.entity.UserAssistant;
import com.qbt.persistent.entity.UserAssistantApply;
import com.qbt.persistent.entity.UserProxy;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.persistent.entity.VipInfo;
import com.qbt.wechat.api.WechatApi;

/**
 * ClassName:WechatMessageSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年7月31日 下午4:12:17
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class WechatMessageSupportImpl implements WechatMessageSupport {
	
	@Resource
	private WechatApi wechatApi;
	
	@Resource
	private WechatCommonSupport commonSupport;
	
	@Override
	public Map<String, String> createOrderNotify(OrderInfo orderInfo) {
		return wechatApi.sendTemplate(WechatTemplate.createOrder(orderInfo), commonSupport.getAccessToken(), "order");
	}

	@Override
	public Map<String, String> orderReciveNotify(OrderInfo orderInfo, String acceptTime) {
		return wechatApi.sendTemplate(WechatTemplate.createOrderRecive(orderInfo, acceptTime), commonSupport.getAccessToken(), "orderFlow");
	}

	@Override
	public Map<String, String> orderTransportNotify(OrderInfo orderInfo, String acceptTime) {
		return wechatApi.sendTemplate(WechatTemplate.createOrderTransport(orderInfo, acceptTime), commonSupport.getAccessToken(), "orderFlow");
	}

	@Override
	public Map<String, String> orderSignNotify(OrderInfo orderInfo, String acceptTime) {
		return wechatApi.sendTemplate(WechatTemplate.createOrderSign(orderInfo, acceptTime), commonSupport.getAccessToken(), "orderFlow");
	}

	@Override
	public Map<String, String> createOrderKfNotify(OrderInfo orderInfo, String openid) {
		return wechatApi.sendTemplate(WechatTemplate.createOrderKf(orderInfo, openid), commonSupport.getAccessToken(), "order");
	}

	@Override
	public Map<String, String> createOrderCwNotify(OrderInfo orderInfo, String openid) {
		return wechatApi.sendTemplate(WechatTemplate.createOrderCw(orderInfo, openid), commonSupport.getAccessToken(), "order");
	}

	@Override
	public Map<String, String> orderCancelNotify(OrderInfo orderInfo) {
		return wechatApi.sendTemplate(WechatTemplate.createOrderCancel(orderInfo), commonSupport.getAccessToken(), "orderCancel");
	}

	@Override
	public Map<String, String> orderCancelKfNotify(OrderInfo orderInfo, String openid) {
		return wechatApi.sendTemplate(WechatTemplate.createOrderCancelKf(orderInfo, openid), commonSupport.getAccessToken(), "orderCancelKf");
	}

	@Override
	public Map<String, String> orderCancelCwNotify(OrderInfo orderInfo, String openid) {
		return wechatApi.sendTemplate(WechatTemplate.createOrderCancelCw(orderInfo, openid), commonSupport.getAccessToken(), "orderCancel");
	}

	@Override
	public Map<String, String> exceptionBookNotify(OrderExceptionBook orderExceptionBook, String openid) {
		return wechatApi.sendTemplate(WechatTemplate.createExceptionBook(orderExceptionBook, openid), commonSupport.getAccessToken(), "warn");
	}

	@Override
	public Map<String, String> vipSuccessPayNotify(VipInfo vipInfo) {
		return wechatApi.sendTemplate(WechatTemplate.vipSuccessPay(vipInfo), commonSupport.getAccessToken(), "vipPay");
	}

	@Override
	public Map<String, String> proxyAddOrderNotify(OrderInfo orderInfo, String openId, String url) {
		return wechatApi.sendTemplate(WechatTemplate.proxyAddOrder(orderInfo, openId, url), commonSupport.getAccessToken(), "waitPayTip");
	}

	@Override
	public Map<String, String> proxyOrderNotify(OrderInfo orderInfo, UserProxy userProxy, String openId, String url) {
		return wechatApi.sendTemplate(WechatTemplate.proxyOrder(orderInfo, userProxy, openId, url), commonSupport.getAccessToken(), "proxyAddShoppingCart");
	}

	@Override
	public Map<String, String> scanQrcodeNotify(UserWeixin proxyUser, UserWeixin scanUser, String url) {
		return wechatApi.sendTemplate(WechatTemplate.scanQrcode(proxyUser, scanUser, url), commonSupport.getAccessToken(), "scan_weixin");
	}

	@Override
	public Map<String, String> expireCouponNotify(UserCouponActivity couponActivity, String openid) {
		return wechatApi.sendTemplate(WechatTemplate.createExpireCoupon(couponActivity, openid), commonSupport.getAccessToken(), "coupon");
	}

	@Override
	public Map<String, String> waitPayNotify(OrderInfo orderInfo) {
		return wechatApi.sendTemplate(WechatTemplate.createWaitPay(orderInfo), commonSupport.getAccessToken(), "waitPayTip");
	}

	@Override
	public Map<String, String> assistantApplyNotify(UserAssistantApply apply, UserAssistant assistant, String openid) {
		return wechatApi.sendTemplate(WechatTemplate.createAssistantApply(apply, assistant, openid), commonSupport.getAccessToken(), "assistantApply");
	}

	@Override
	public Map<String, String> orderCancelNotify(OrderInfo orderInfo, OrderRefund refund) {
		return wechatApi.sendTemplate(WechatTemplate.createOrderCancel(orderInfo, refund), commonSupport.getAccessToken(), "orderCancel");
	}

	@Override
	public Map<String, String> orderCancelCwNotify(OrderInfo orderInfo, String openid, OrderRefund refund) {
		return wechatApi.sendTemplate(WechatTemplate.createOrderCancelCw(orderInfo, openid, refund), commonSupport.getAccessToken(), "orderCancel");
	}

	@Override
	public Map<String, String> saleUserApplyNotify(SaleUser saleUser, String openid) {
		return null;
	}

}
