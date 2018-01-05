/**
 * Project Name:qbt-support
 * File Name:SmsMessageSupportImpl.java
 * Package Name:com.qbt.bussiness.support.impl
 * Date:2017年7月31日下午1:40:17
 *
*/

package com.qbt.bussiness.support.impl;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.bussiness.support.SmsMsgSupport;
import com.qbt.bussiness.template.SmsMessageTemplate;
import com.qbt.common.enums.JapaneseSmsTemplate;
import com.qbt.common.enums.SmsTemplate;
import com.qbt.persistent.dto.UserCouponActivity;
import com.qbt.persistent.entity.OrderInfo;
import com.qbt.persistent.entity.SaleUser;
import com.qbt.persistent.entity.UserProxy;
import com.qbt.sms.api.service.SmsSendService;

/**
 * ClassName:SmsMessageSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年7月31日 下午1:40:17
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class SmsMsgSupportImpl implements SmsMsgSupport {
	
	@Resource
	private SmsSendService smsSendService;

	@Override
	public HashMap<String, Object> createOrderJpMsgToJContact(OrderInfo orderInfo) {
		String[] jmobiles = new String[]{orderInfo.getjMobile()};
		return smsSendService.sendSms(jmobiles, SmsTemplate.M_120206.getCode(), JapaneseSmsTemplate.getSmsTemplate(SmsTemplate.M_112387.getCode(), SmsMessageTemplate.createM_112387(orderInfo)));
	}

	@Override
	public HashMap<String, Object> createOrderJpMsgToDContact(OrderInfo orderInfo) {
		String[] dmobiles = new String[]{orderInfo.getdMobile()};
		return smsSendService.sendSms(dmobiles, SmsTemplate.M_120206.getCode(), JapaneseSmsTemplate.getSmsTemplate(SmsTemplate.M_112388.getCode(), SmsMessageTemplate.createM_112388(orderInfo)));
	}

	@Override
	public HashMap<String, Object> sendOrderCancelJpMsgToJContact(OrderInfo orderInfo) {
		String[] jmobiles = new String[]{orderInfo.getjMobile()};
		return smsSendService.sendSms(jmobiles, SmsTemplate.M_120206.getCode(), JapaneseSmsTemplate.getSmsTemplate(SmsTemplate.M_112400.getCode(), SmsMessageTemplate.createM_112400(orderInfo)));
	}

	@Override
	public HashMap<String, Object> sendOrderCancelJpMsgToDContact(OrderInfo orderInfo) {
		String[] dmobiles = new String[]{orderInfo.getdMobile()};
		return smsSendService.sendSms(dmobiles, SmsTemplate.M_120206.getCode(), JapaneseSmsTemplate.getSmsTemplate(SmsTemplate.M_112400.getCode(), SmsMessageTemplate.createM_112400(orderInfo)));
	}

	@Override
	public HashMap<String, Object> sendOrderSignJpMsgToJContact(OrderInfo orderInfo) {
		String[] jmobiles = new String[]{orderInfo.getjMobile()};
		return smsSendService.sendSms(jmobiles, SmsTemplate.M_120206.getCode(), JapaneseSmsTemplate.getSmsTemplate(SmsTemplate.M_113080.getCode(), SmsMessageTemplate.createM_113080(orderInfo)));
	}

	@Override
	public HashMap<String, Object> sendOrderSignJpMsgToDContact(OrderInfo orderInfo) {
		String[] dmobiles = new String[]{orderInfo.getdMobile()};
		return smsSendService.sendSms(dmobiles, SmsTemplate.M_120206.getCode(), JapaneseSmsTemplate.getSmsTemplate(SmsTemplate.M_113080.getCode(), SmsMessageTemplate.createM_113080(orderInfo)));
	}
	
	@Override
	public HashMap<String, Object> createOrderMsgToJContact(OrderInfo orderInfo) {
		String[] jmobiles = new String[]{orderInfo.getjMobile()};
		return smsSendService.sendSms(jmobiles, SmsTemplate.M_176720.getCode(), SmsMessageTemplate.createM_176720J(orderInfo));
	}
	
	@Override
	public HashMap<String, Object> createOrderMsgToDContact(OrderInfo orderInfo) {
		String[] dmobiles = new String[]{orderInfo.getdMobile()};
		return smsSendService.sendSms(dmobiles, SmsTemplate.M_176721.getCode(), SmsMessageTemplate.createM_176721D(orderInfo));
	}

	@Override
	public HashMap<String, Object> sendOrderSignMsgToJContact(OrderInfo orderInfo) {
		String[] jmobiles = new String[]{orderInfo.getjMobile()};
		return smsSendService.sendSms(jmobiles, SmsTemplate.M_176723.getCode(), SmsMessageTemplate.createM_176723J(orderInfo));
	}

	@Override
	public HashMap<String, Object> sendOrderSignMsgToDContact(OrderInfo orderInfo) {
		String[] dmobiles = new String[]{orderInfo.getdMobile()};
		return smsSendService.sendSms(dmobiles, SmsTemplate.M_176723.getCode(), SmsMessageTemplate.createM_176723D(orderInfo));
	}

	@Override
	public HashMap<String, Object> sendOrderCancelMsgToJContact(OrderInfo orderInfo) {
		String[] jmobiles = new String[]{orderInfo.getjMobile()};
		return smsSendService.sendSms(jmobiles, SmsTemplate.M_176724.getCode(), SmsMessageTemplate.createM_176724J(orderInfo));
	}

	@Override
	public HashMap<String, Object> sendOrderCancelMsgToDContact(OrderInfo orderInfo) {
		String[] dmobiles = new String[]{orderInfo.getdMobile()};
		return smsSendService.sendSms(dmobiles, SmsTemplate.M_176724.getCode(),SmsMessageTemplate.createM_176724D(orderInfo));
	}

	@Override
	public HashMap<String, Object> sendOrderModifyMsgToJContact(OrderInfo before, OrderInfo after) {
		String[] jmobiles = new String[]{after.getjMobile()};
		return smsSendService.sendSms(jmobiles, SmsTemplate.M_176725.getCode(), SmsMessageTemplate.createM_176725J(before, after));
	}

	@Override
	public HashMap<String, Object> sendOrderModifyMsgToDContact(OrderInfo before, OrderInfo after) {
		String[] dmobiles = new String[]{after.getdMobile()};
		return smsSendService.sendSms(dmobiles, SmsTemplate.M_176725.getCode(), SmsMessageTemplate.createM_176725D(before, after));
	}

	@Override
	public HashMap<String, Object> sendProxySelfOrderMsg(UserProxy userProxy) {
		String userProxyMobile[] = {userProxy.getMobile()};
		return smsSendService.sendSms(userProxyMobile, SmsTemplate.M_162528.getCode(), SmsMessageTemplate.createM_162528(userProxy));
	}

	@Override
	public HashMap<String, Object> sendSaleProxyOrderMsg(SaleUser saleUser, UserProxy userProxy, OrderInfo orderInfo) {
		String saleUserMobile[] = {saleUser.getMobile()};
		return smsSendService.sendSms(saleUserMobile, SmsTemplate.M_164216.getCode(), SmsMessageTemplate.createM_164216(saleUser, userProxy, orderInfo));
	}

	@Override
	public HashMap<String, Object> sendOrderCouponMsg(OrderInfo orderInfo, UserCouponActivity uca) {
		String[] jmobiles = new String[]{orderInfo.getjMobile()};
		return smsSendService.sendSms(jmobiles, SmsTemplate.M_190132.getCode(), SmsMessageTemplate.createM_190132(orderInfo, uca));
	}

}
