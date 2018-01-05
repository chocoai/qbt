package com.qbt.bussiness.template;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.qbt.common.enums.AssistantApplyType;
import com.qbt.common.enums.ExceptionTypeEnum;
import com.qbt.common.enums.ExpressTypeEnum;
import com.qbt.common.util.Constants;
import com.qbt.common.util.DateUtil;
import com.qbt.persistent.dto.UserCouponActivity;
import com.qbt.persistent.entity.OrderExceptionBook;
import com.qbt.persistent.entity.OrderInfo;
import com.qbt.persistent.entity.OrderRefund;
import com.qbt.persistent.entity.OrderShoppingCart;
import com.qbt.persistent.entity.SaleUser;
import com.qbt.persistent.entity.UserActivityOrder;
import com.qbt.persistent.entity.UserAssistant;
import com.qbt.persistent.entity.UserAssistantApply;
import com.qbt.persistent.entity.UserProxy;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.persistent.entity.VipInfo;
import com.qbt.wechat.entity.Template;

public class WechatTemplate {

	/**
	  * {{first.DATA}}
		订单编号：{{keyword1.DATA}}
		时间：{{keyword2.DATA}}
		{{remark.DATA}}
	  * @Title: createOrder
	  * @Description: TODO
	  * @author: share 2016年8月17日
	  * @modify: share 2016年8月17日
	  * @param orderInfo
	  * @return
	 */
	public static Template createOrder(OrderInfo orderInfo){
		String openid = orderInfo.getOpenid();
		Template template = new Template();
		template.setTouser(openid);
		template.setUrl("");
		Map<String,Map<String,String>> data = new HashMap<String,Map<String,String>>();
		
		Map<String,String> firstValue = new HashMap<String, String>();
		

		if(ExpressTypeEnum.after_tomorow.getType().equals(orderInfo.getExpressType())){
			long days = DateUtil.getDiffDaysForDay(
					orderInfo.getSendSfUserTime(), 
					DateUtil.str2Date(orderInfo.getDeliverDate(), DateUtil.DATE_TIME_FORMAT_01)
					);
			firstValue.put("value", "客户您好，您已经下单成功"
					+ "\n预约取包："+DateUtil.formatDate(orderInfo.getSendSfUserTime(), DateUtil.DATE_TIME_FORMAT_01)
					+ "\n预计到达："+ days+"天后");	
		}else{
			firstValue.put("value", "客户您好，您已经下单成功"
					+ "\n预约取包："+DateUtil.formatDate(orderInfo.getSendSfUserTime(), DateUtil.DATE_TIME_FORMAT_01)
					+ "\n预计到达："+orderInfo.getDeliverDate());	
		}
	
		firstValue.put("color", "#173177");
		data.put("first", firstValue);
		
		Map<String,String> keyword1Value = new HashMap<String, String>();
		keyword1Value.put("value", orderInfo.getNumber());
		keyword1Value.put("color", "#173177");
		data.put("keyword1", keyword1Value);
		
		Map<String,String> keyword2Value = new HashMap<String, String>();
		keyword2Value.put("value", DateUtil.formatDate(orderInfo.getPayTime(), DateUtil.DATE_TIME_FORMAT_01));
		keyword2Value.put("color", "#173177");
		data.put("keyword2", keyword2Value);
		
		Map<String,String> remarkValue = new HashMap<String, String>();
		remarkValue.put("value", "取包信息："+orderInfo.getjContact()+","+orderInfo.getjMobile()+","+getJInfo(orderInfo)
								 +"\n送包信息："+orderInfo.getdContact()+","+orderInfo.getdMobile()+","+getdInfo(orderInfo)
								 +"\n请在球包上粘贴寄件人姓名，方便识别和取包");
		remarkValue.put("color", "#173177");
		data.put("remark", remarkValue);
		
		template.setData(data);
		return template;
	}
	
	/**
	  * {{first.DATA}}
	  * 
	  * 订单号：{{order_id.DATA}}
	  * 包裹单号：{{package_id.DATA}}
	  * {{remark.DATA}}
	  * 
	  * {{first.DATA}} = 客户您好, 您的球包订单已取件成功
	  * {{order_id.DATA}={球包通订单单号}
	  * {{package_id.DATA}}={无}
	  * {{remark.DATA}}=取包时间:{取件时间}\n取包信息:{寄件人},{寄件电话},{寄件人地址}\n
	  * 送包信息: {收件人},{收件电话},{收件人地址}\n
	  * 预计到达: {预计到达时间}
	  * 
	  * 订单收取
	  * @Title: createOrderRecive
	  * @Description: TODO
	  * @author: share 2016年8月29日
	  * @modify: share 2016年8月29日
	  * @param orderInfo
	  * @return
	 */
	public static Template createOrderRecive(OrderInfo orderInfo,String acceptime){
		String openid = orderInfo.getOpenid();
		Template template = new Template();
		template.setTouser(openid);
		template.setUrl("");
		Map<String,Map<String,String>> data = new HashMap<String,Map<String,String>>();
		
		Map<String,String> firstValue = new HashMap<String, String>();
		firstValue.put("value", "客户您好，您的球包订单已取件成功");
		firstValue.put("color", "#173177");
		data.put("first", firstValue);
		
		Map<String,String> orderIdValue = new HashMap<String, String>();
		orderIdValue.put("value", orderInfo.getNumber());
		orderIdValue.put("color", "#173177");
		data.put("order_id", orderIdValue);
		
		Map<String,String> packageIdValue = new HashMap<String, String>();
		packageIdValue.put("value", "");
		packageIdValue.put("color", "#173177");
		data.put("package_id", packageIdValue);
		
		Map<String,String> remarkValue = new HashMap<String, String>();
		remarkValue.put("value", "取包时间："+acceptime+"\n预计到达："+orderInfo.getDeliverDate()+"\n取包信息："+orderInfo.getjContact()+","+orderInfo.getjMobile()+","+getJInfo(orderInfo)+"\n送包信息："+orderInfo.getdContact()+","+orderInfo.getdMobile()+","+getdInfo(orderInfo));
		remarkValue.put("color", "#173177");
		data.put("remark", remarkValue);
		
		template.setData(data);
		return template;
	}
	
	/**
	  * {{first.DATA}}
	  *
	  * 订单号：{{order_id.DATA}}
	  * 包裹单号：{{package_id.DATA}}
	  * {{remark.DATA}}
	  * 
	  * {{first.DATA}} = 客户您好, 您的球包订单已进入运输途中
	  * {{order_id.DATA}={球包通订单单号}
	  * {{package_id.DATA}}={无}
	  * {{remark.DATA}}=运输时间:{当前时间}\n预计到达: {预计到达时间}
	  * 
	  * 订单运输中
	  * @Title: createOrderTransport
	  * @Description: TODO
	  * @author: share 2016年8月29日
	  * @modify: share 2016年8月29日
	  * @param orderInfo
	  * @param acceptime
	  * @return
	 */
	public static Template createOrderTransport(OrderInfo orderInfo,String acceptime){
		String openid = orderInfo.getOpenid();
		Template template = new Template();
		template.setTouser(openid);
		template.setUrl("");
		Map<String,Map<String,String>> data = new HashMap<String,Map<String,String>>();
		
		Map<String,String> firstValue = new HashMap<String, String>();
		firstValue.put("value", "客户您好，您的球包订单已进入运输途中");
		firstValue.put("color", "#173177");
		data.put("first", firstValue);
		
		Map<String,String> orderIdValue = new HashMap<String, String>();
		orderIdValue.put("value", orderInfo.getNumber());
		orderIdValue.put("color", "#173177");
		data.put("order_id", orderIdValue);
		
		Map<String,String> packageIdValue = new HashMap<String, String>();
		packageIdValue.put("value", "");
		packageIdValue.put("color", "#173177");
		data.put("package_id", packageIdValue);
		
		Map<String,String> remarkValue = new HashMap<String, String>();
		remarkValue.put("value", "运输时间："+acceptime+"\n预计到达："+orderInfo.getDeliverDate());
		remarkValue.put("color", "#173177");
		data.put("remark", remarkValue);
		
		template.setData(data);
		return template;
	}
	
	/**
	  * {{first.DATA}}
	  *
	  * 订单号：{{order_id.DATA}}
	  * 包裹单号：{{package_id.DATA}}
	  * {{remark.DATA}}
	  * 
	  * {{first.DATA}} = 客户您好, 您的球包订单已签收
	  * {{{order_id.DATA}={球包通订单单号}
	  * {{package_id.DATA}}={无}
	  * {{remark.DATA}}=签收时间:{当前时间}\n送包地址: {收件地址}
	  * 
	  * 订单签收
	  * @Title: createOrderSign
	  * @Description: TODO
	  * @author: share 2016年8月29日
	  * @modify: share 2016年8月29日
	  * @param orderInfo
	  * @param acceptime
	  * @return
	 */
	public static Template createOrderSign(OrderInfo orderInfo,String acceptime){
		String openid = orderInfo.getOpenid();
		Template template = new Template();
		template.setTouser(openid);
		template.setUrl("");
		Map<String,Map<String,String>> data = new HashMap<String,Map<String,String>>();
		
		Map<String,String> firstValue = new HashMap<String, String>();
		firstValue.put("value", "客户您好，您的球包订单已送达");
		firstValue.put("color", "#173177");
		data.put("first", firstValue);
		
		Map<String,String> orderIdValue = new HashMap<String, String>();
		orderIdValue.put("value", orderInfo.getNumber());
		orderIdValue.put("color", "#173177");
		data.put("order_id", orderIdValue);
		
		Map<String,String> packageIdValue = new HashMap<String, String>();
		packageIdValue.put("value", "");
		packageIdValue.put("color", "#173177");
		data.put("package_id", packageIdValue);
		
		Map<String,String> remarkValue = new HashMap<String, String>();
		remarkValue.put("value", "送达时间："+acceptime+"\n送包地址："+getdInfo(orderInfo));
		remarkValue.put("color", "#173177");
		data.put("remark", remarkValue);
		
		template.setData(data);
		return template;
	}
	
	/**
	  * {{first.DATA}} = 客服注意，新订单，请确认\n预约取包: {预约取包时间}, {时效类型}
	  * {{keyword1.DATA}={球包通订单单号}
	  * {{keyword2.DATA}}={付款时间}
	  * {{remark.DATA}}=取包信息:{寄件人},{寄件电话},{寄件人地址}\n送包信息: {收件人},{收件电话},{收件人地址}\n预计到达: {预计到达时间}
	  * 
	  * @Title: createOrderKf
	  * @Description: TODO
	  * @author: share 2016年8月17日
	  * @modify: share 2016年8月17日
	  * @param orderInfo
	  * @return
	 */
	public static Template createOrderKf(OrderInfo orderInfo,String openid){
		Template template = new Template();
		template.setTouser(openid);
		template.setUrl("");
		Map<String,Map<String,String>> data = new HashMap<String,Map<String,String>>();
		
		String businessType = orderInfo.getExpressType();
		if("1".equals(businessType)){
			businessType = "次日达";
		}else if("2".equals(businessType)){
			businessType = "隔日达";
		}else{
			businessType = "次午达";
		}
		
		Map<String,String> firstValue = new HashMap<String, String>();
		firstValue.put("value", " 客服注意，新订单，请确认\n预约取包："+DateUtil.formatDate(orderInfo.getSendSfUserTime(), DateUtil.DATE_TIME_FORMAT_01)+"，"+businessType);
		firstValue.put("color", "#173177");
		data.put("first", firstValue);
		
		Map<String,String> keyword1Value = new HashMap<String, String>();
		keyword1Value.put("value", orderInfo.getNumber());
		keyword1Value.put("color", "#173177");
		data.put("keyword1", keyword1Value);
		
		Map<String,String> keyword2Value = new HashMap<String, String>();
		keyword2Value.put("value", DateUtil.formatDate(orderInfo.getPayTime(), DateUtil.DATE_TIME_FORMAT_01));
		keyword2Value.put("color", "#173177");
		data.put("keyword2", keyword2Value);
		
		Map<String,String> remarkValue = new HashMap<String, String>();
		remarkValue.put("value", "取包信息："+orderInfo.getjContact()+"，"+orderInfo.getjMobile()+"，"+getJInfo(orderInfo)+"\n送包信息："+orderInfo.getdContact()+"，"+orderInfo.getdMobile()+"，"+getdInfo(orderInfo)+"\n预计到达："+orderInfo.getDeliverDate());
		remarkValue.put("color", "#173177");
		data.put("remark", remarkValue);
		
		template.setData(data);
		return template;
	}
	
	/**
	 * 
	 * {{first.DATA}} = 财务人员注意\n
		用户：{用户}
		{{keyword1.DATA}={球包通订单单号}
		{{keyword2.DATA}}={付款时间}
		{{remark.DATA}}= 订单金额:{订单金额}\n
		实际支付:{实际金额}\n
		原因:{原因}
		注：原因XXX，如果不用优惠券，参数为“无”，如果有用优惠券，参数为“优惠”
	 * 
	  * @Title: createOrderCw
	  * @Description: TODO
	  * @author: share 2016年8月29日
	  * @modify: share 2016年8月29日
	  * @param orderInfo
	  * @param openid
	  * @return
	 */
	public static Template createOrderCw(OrderInfo orderInfo,String openid){
		Template template = new Template();
		template.setTouser(openid);
		template.setUrl("");
		Map<String,Map<String,String>> data = new HashMap<String,Map<String,String>>();
		
		Map<String,String> firstValue = new HashMap<String, String>();
		firstValue.put("value", " 财务人员注意\n用户："+orderInfo.getjContact()+"支付一笔新的订单");
		firstValue.put("color", "#173177");
		data.put("first", firstValue);
		
		Map<String,String> keyword1Value = new HashMap<String, String>();
		keyword1Value.put("value", orderInfo.getNumber());
		keyword1Value.put("color", "#173177");
		data.put("keyword1", keyword1Value);
		
		Map<String,String> keyword2Value = new HashMap<String, String>();
		keyword2Value.put("value", DateUtil.formatDate(orderInfo.getPayTime(), DateUtil.DATE_TIME_FORMAT_01));
		keyword2Value.put("color", "#173177");
		data.put("keyword2", keyword2Value);
		
		Map<String,String> remarkValue = new HashMap<String, String>();
		String discountStr =  "";
		discountStr = (orderInfo.getDiscount() > 0?"普通优惠：有":"普通优惠：无");
		if(orderInfo.getInputDiscount() > 0){
			discountStr += ",BOSS人工优惠：有";
		}
		remarkValue.put("value", "订单金额："+orderInfo.getTotalAmount()+"\n实际支付："+orderInfo.getAmount()+"\n原因："+discountStr+"");
		remarkValue.put("color", "#173177");
		data.put("remark", remarkValue);
		
		template.setData(data);
		return template;
	}
	
	/**
	  * {{first.DATA}} = 客服注意, 用户取消已支付订单
		{{keyword1.DATA}}=用户取消
		{{keyword2.DATA}}={取消为操作时间}
		{{remark.DATA}}=订单号:{球包通订单号}\n取包信息: {寄件人},{寄件电话},{寄件人地址}\n送包信息:{收件人},{收件电话},{收件人地址}\n预约取包: {预约取包时间}\n预计到达: {预计到达时间}

	  * @Title: createOrder
	  * @Description: TODO
	  * @author: share 2016年8月17日
	  * @modify: share 2016年8月17日
	  * @param orderInfo
	  * @return
	 */
	public static Template createOrderCancelKf(OrderInfo orderInfo,String openid){
		Template template = new Template();
		template.setTouser(openid);
		template.setUrl("");
		Map<String,Map<String,String>> data = new HashMap<String,Map<String,String>>();
		
		Map<String,String> firstValue = new HashMap<String, String>();
		firstValue.put("value", "客服注意，用户取消已支付订单");
		firstValue.put("color", "#173177");
		data.put("first", firstValue);
		
		Map<String,String> keyword1Value = new HashMap<String, String>();
		keyword1Value.put("value", "用户取消");
		keyword1Value.put("color", "#173177");
		data.put("keyword1", keyword1Value);
		
		Map<String,String> keyword2Value = new HashMap<String, String>();
		keyword2Value.put("value", DateUtil.formatDate(orderInfo.getUpdateTime(), DateUtil.DATE_TIME_FORMAT_01));
		keyword2Value.put("color", "#173177");
		data.put("keyword2", keyword2Value);
		
		Map<String,String> remarkValue = new HashMap<String, String>();
		remarkValue.put("value", "订单号："+orderInfo.getNumber()+"\n取包信息："+orderInfo.getjContact()+"，"+orderInfo.getjMobile()+"，"+getJInfo(orderInfo)+"\n送包信息："+orderInfo.getdContact()+"，"+orderInfo.getdMobile()+"，"+getdInfo(orderInfo)+"\n预约取包："+DateUtil.formatDate(orderInfo.getSendSfUserTime(), DateUtil.DATE_TIME_FORMAT_01)+"\n预计到达："+orderInfo.getDeliverDate());
		remarkValue.put("color", "#173177");
		data.put("remark", remarkValue);
		
		template.setData(data);
		return template;
	}
	
	/**
	  * {{first.DATA}}
	  * 订单号：{{keyword1.DATA}}
	  * 预约时间：{{keyword2.DATA}}
	  * 取消时间：{{keyword3.DATA}}
	  * 退款金额：{{keyword4.DATA}}
	  * {{remark.DATA}}
	  * 
	  * {{first.DATA}} = 尊敬的用户您好，您的订单已取消
	  * {{keyword1.DATA}={球包通订单单号}
	  * {{keyword2.DATA}}={预约取件时间}
	  * {{keyword3.DATA}}={取消为操作时间}
	  * {{keyword4.DATA}}={实际支付金额}
	  * {{remark.DATA}}=取包信息: {寄件人},{寄件电话},{寄件人地址}\n送包信息:{收件人},{收件电话},{收件人地址}\n预计两个工作日内会退款到账, 如有任何疑问，请拨打：400-803-0106
	  * 
	  * 订单取消通知下单人
	  * @Title: createOrderCancel
	  * @Description: TODO
	  * @author: share 2016年8月17日
	  * @modify: share 2016年8月17日
	  * @param orderInfo
	  * @return
	 */
	public static Template createOrderCancel(OrderInfo orderInfo){
		String openid = orderInfo.getOpenid();
		Template template = new Template();
		template.setTouser(openid);
		template.setUrl("");
		Map<String,Map<String,String>> data = new HashMap<String,Map<String,String>>();
		
		Map<String,String> firstValue = new HashMap<String, String>();
		firstValue.put("value", "尊敬的用户您好，您的订单已取消");
		firstValue.put("color", "#173177");
		data.put("first", firstValue);
		
		Map<String,String> keyword1Value = new HashMap<String, String>();
		keyword1Value.put("value", orderInfo.getNumber());
		keyword1Value.put("color", "#173177");
		data.put("keyword1", keyword1Value);
		
		Map<String,String> keyword2Value = new HashMap<String, String>();
		keyword2Value.put("value", DateUtil.formatDate(orderInfo.getSendSfUserTime(), DateUtil.DATE_TIME_FORMAT_01));
		keyword2Value.put("color", "#173177");
		data.put("keyword2", keyword2Value);
		
		Map<String,String> keyword3Value = new HashMap<String, String>();
		keyword3Value.put("value", DateUtil.formatDate(new Date(), DateUtil.DATE_TIME_FORMAT_01));
		keyword3Value.put("color", "#173177");
		data.put("keyword3", keyword3Value);
		
		Map<String,String> keyword4Value = new HashMap<String, String>();
		keyword4Value.put("value", orderInfo.getAmount().toString());
		keyword4Value.put("color", "#173177");
		data.put("keyword4", keyword4Value);
		
		Map<String,String> remarkValue = new HashMap<String, String>();
		remarkValue.put("value", "取包信息："+orderInfo.getjContact()+"，"+orderInfo.getjMobile()+"，"+getJInfo(orderInfo)+"\n送包信息："+orderInfo.getdContact()+"，"+orderInfo.getdMobile()+"，"+getdInfo(orderInfo)+"\n预计两个工作日内会退款到账，如有任何疑问，请拨打："+Constants.QBT_KF_TEL);
		remarkValue.put("color", "#173177");
		data.put("remark", remarkValue);
		
		template.setData(data);
		return template;
	}
	
	/**
	 * {{first.DATA}}
	 * 订单号：{{keyword1.DATA}}
	 * 预约时间：{{keyword2.DATA}}
	 * 取消时间：{{keyword3.DATA}}
	 * 退款金额：{{keyword4.DATA}}
	 * {{remark.DATA}}
	 * 
	 * {{first.DATA}} = 财务人员注意, 用户已取消支付订单\n微信支付码:XXX
	 * {{keyword1.DATA}={球包通订单单号}
	 * {{keyword2.DATA}}={预约取件时间}
	 * {{keyword3.DATA}}={取消为操作时间}
	 * {{keyword4.DATA}}={实际支付金额}
	 * {{remark.DATA}}="请及时核查并退款", "#173177"
	 * 注：#173177表示颜色
	 * 
	 * 订单取消通知财务人员
	 * @param orderInfo
	 * @param openid
	 * @return
	 */
	public static Template createOrderCancelCw(OrderInfo orderInfo,String openid){
		Template template = new Template();
		template.setTouser(openid);
		template.setUrl("");
		Map<String,Map<String,String>> data = new HashMap<String,Map<String,String>>();
		
		Map<String,String> firstValue = new HashMap<String, String>();
		firstValue.put("value", "财务人员注意，用户已取消支付订单：");
		firstValue.put("color", "#173177");
		data.put("first", firstValue);
		
		Map<String,String> keyword1Value = new HashMap<String, String>();
		keyword1Value.put("value", orderInfo.getNumber());
		keyword1Value.put("color", "#173177");
		data.put("keyword1", keyword1Value);
		
		Map<String,String> keyword2Value = new HashMap<String, String>();
		keyword2Value.put("value", DateUtil.formatDate(orderInfo.getSendSfUserTime(), DateUtil.DATE_TIME_FORMAT_01));
		keyword2Value.put("color", "#173177");
		data.put("keyword2", keyword2Value);
		
		Map<String,String> keyword3Value = new HashMap<String, String>();
		keyword3Value.put("value", DateUtil.formatDate(orderInfo.getUpdateTime(), DateUtil.DATE_TIME_FORMAT_01));
		keyword3Value.put("color", "#173177");
		data.put("keyword3", keyword3Value);
		
		Map<String,String> keyword4Value = new HashMap<String, String>();
		keyword4Value.put("value", orderInfo.getAmount().toString());
		keyword4Value.put("color", "#173177");
		data.put("keyword4", keyword4Value);
		
		Map<String,String> remarkValue = new HashMap<String, String>();
		remarkValue.put("value", "请及时核查并退款");
		remarkValue.put("color", "#173177");
		data.put("remark", remarkValue);
		
		template.setData(data);
		return template;
	}
	

	/**
	 * 
	 * 仪表盘微信通知
	 * {{first.DATA}}=订单编号: {订单号}
	 * {{keyword1.DATA}}={文档中规则的“任务类型”中文}
	 * {{keyword2.DATA}}={文档中规则的“描述”中文}
	 * {{keyword3.DATA}}={当期那时间：年-月-日 时：分：秒}
	 * {{keyword4.DATA}}= 球包通
	 * {{remark.DATA}}=请客服到后台管理查看处理
	 * 
	 * 仪表盘微信通知
	 * @param openid
	 * @return
	 */
	public static Template createExceptionBook(OrderExceptionBook exceptionBook, String openid){
		Template template = new Template();
		template.setTouser(openid);
		template.setUrl("");
		
		Map<String,Map<String,String>> data = new HashMap<String,Map<String,String>>();
		Map<String,String> firstValue = new HashMap<String, String>();
		firstValue.put("value", "订单编号：" + exceptionBook.getOrderNumber());
		firstValue.put("color", "#173177");
		data.put("first", firstValue);
		
		Map<String,String> keyword1Value = new HashMap<String, String>();
		keyword1Value.put("value", ExceptionTypeEnum.getByType(exceptionBook.getType()).getDesc());
		keyword1Value.put("color", "#173177");
		data.put("keyword1", keyword1Value);
		
		Map<String,String> keyword2Value = new HashMap<String, String>();
		keyword2Value.put("value", exceptionBook.getDescription());
		keyword2Value.put("color", "#173177");
		data.put("keyword2", keyword2Value);
		
		Map<String,String> keyword3Value = new HashMap<String, String>();
		keyword3Value.put("value", DateUtil.formatDate(exceptionBook.getCreateTime(), DateUtil.DATE_TIME_FORMAT_01));
		keyword3Value.put("color", "#173177");
		data.put("keyword3", keyword3Value);
		
		Map<String,String> keyword4Value = new HashMap<String, String>();
		keyword4Value.put("value", "球包通");
		keyword4Value.put("color", "#173177");
		data.put("keyword4", keyword4Value);
		
		Map<String,String> remarkValue = new HashMap<String, String>();
		remarkValue.put("value", "请客服到后台管理查看处理");
		remarkValue.put("color", "#173177");
		data.put("remark", remarkValue);
		
		template.setData(data);
		return template;
	}
	
	/**
	 * {{first.DATA}}
   	  * 用户名：{{keyword1.DATA}}
	  * 开通时间：{{keyword2.DATA}}
	  * 到期时间：{{keyword3.DATA}}
	  * {{remark.DATA}}
	  * @Title: vipSuccessPay
	  * @Description: TODO
	  * @author: chenxiaocong 2016年11月5日
	  * @modify: chenxiaocong 2016年11月5日
	  * @param vipInfo
	  * @return
	 */
	public static Template vipSuccessPay(VipInfo vipInfo){
		String openid = vipInfo.getOpenId();
		Template template = new Template();
		template.setTouser(openid);
		template.setUrl("");
		Map<String,Map<String,String>> data = new HashMap<String,Map<String,String>>();
		
		Map<String,String> firstValue = new HashMap<String, String>();
		firstValue.put("value", "尊敬的用户您好！您已成功购买球包通【"+vipInfo.getName()+"】会员卡。");
		firstValue.put("color", "#173177");
		data.put("first", firstValue);
		
		Map<String,String> keyword1Value = new HashMap<String, String>();
		keyword1Value.put("value", vipInfo.getUserName());
		keyword1Value.put("color", "#173177");
		data.put("keyword1", keyword1Value);
		
		Map<String,String> keyword2Value = new HashMap<String, String>();
		keyword2Value.put("value", DateUtil.formatDate(vipInfo.getCreateTime(), DateUtil.DATE_FORMAT_01));
		keyword2Value.put("color", "#173177");
		data.put("keyword2", keyword2Value);
		
		Map<String,String> orderIdValue = new HashMap<String, String>();
		orderIdValue.put("value", DateUtil.formatDate(vipInfo.getValidTime(), DateUtil.DATE_FORMAT_01));
		orderIdValue.put("color", "#173177");
		data.put("keyword3", orderIdValue);
		
		
		Map<String,String> remarkValue = new HashMap<String, String>();
		StringBuffer remark = new StringBuffer();
		remark.append("");
		remarkValue.put("value", remark.toString());
		remarkValue.put("color", "#173177");
		data.put("remark", remarkValue);
		
		template.setData(data);
		return template;
	}
	
	private static String getJInfo(OrderInfo orderInfo){
		StringBuilder msgsb = new StringBuilder();
		msgsb.append(orderInfo.getjTreePath().replace(",", ""));
		if(orderInfo.getjAddrType() != 4){
			msgsb.append(orderInfo.getjAddrName());
		}else{
			msgsb.append(orderInfo.getjAddress());
		}
		return msgsb.toString();
	}
	
	private static String getdInfo(OrderInfo orderInfo){
		StringBuilder msgsb = new StringBuilder();
		msgsb.append(orderInfo.getdTreePath().replace(",", ""));
		if(orderInfo.getdAddrType() != 4){
			msgsb.append(orderInfo.getdAddrName());
		}else{
			msgsb.append(orderInfo.getdAddress());
		}
		return msgsb.toString();
	}
	
	private static String getJCartInfo(OrderShoppingCart cart){
		StringBuilder msgsb = new StringBuilder();
		msgsb.append(cart.getjTreePath().replace(",", ""));
		if(cart.getjAddrType() != 4){
			msgsb.append(cart.getjAddrName());
		}else{
			msgsb.append(cart.getjAddress());
		}
		return msgsb.toString();
	}
	
	private static String getdCartInfo(OrderShoppingCart cart){
		StringBuilder msgsb = new StringBuilder();
		msgsb.append(cart.getdTreePath().replace(",", ""));
		if(cart.getdAddrType() != 4){
			msgsb.append(cart.getdAddrName());
		}else{
			msgsb.append(cart.getdAddress());
		}
		return msgsb.toString();
	}

	/**
	 *  订单未支付通知

		{{first.DATA}}

		下单时间：{{ordertape.DATA}}
		订单号：{{ordeID.DATA}}
		{{remark.DATA}}
		
		尊敬的(客户姓名)贵宾，您好！您的订单已为您准备好，请付款。
 		
 		下单时间：{{ordertape.DATA}}
		订单号：{{ordeID.DATA}}
		取包时间：yyyy-mm-dd hh:mm
		预计到达：yyyy-mm-dd hh:mm
		取包信息：姓名 电话
		地址
		送包信息：姓名 电话
		地址
		点击本消息进行付款。
	  * @Title: proxyAddShoppingCart
	  * @Description: TODO
	  * @author: share 2017年2月9日
	  * @modify: share 2017年2月9日
	  * @param vipInfo
	  * @return
	 */
	public static Template proxyAddOrder(OrderInfo order,String openId,String url){
		Template template = new Template();
		template.setTouser(openId);
		template.setUrl(url);
		Map<String,Map<String,String>> data = new HashMap<String,Map<String,String>>();
		
		Map<String,String> firstValue = new HashMap<String, String>();
		firstValue.put("value", "尊敬的贵宾，您好！您的订单已为您准备好，请付款。");
		firstValue.put("color", "#173177");
		data.put("first", firstValue);
		
		Map<String,String> keyword1Value = new HashMap<String, String>();
		keyword1Value.put("value", DateUtil.formatDate(order.getCreateTime(), DateUtil.DATE_TIME_FORMAT_02));
		keyword1Value.put("color", "#173177");
		data.put("ordertape", keyword1Value);
		
		Map<String,String> keyword2Value = new HashMap<String, String>();
		keyword2Value.put("value", order.getOrderNumber());
		keyword2Value.put("color", "#173177");
		data.put("ordeID", keyword2Value);
		
		Map<String,String> remarkValue = new HashMap<String, String>();
		StringBuffer remark = new StringBuffer();
		remark.append("取包时间："+DateUtil.formatDate(order.getSendSfUserTime(), DateUtil.DATE_TIME_FORMAT_02));
		remark.append("\n预计到达："+order.getDeliverDate());
		remark.append("\n取包信息："+order.getjContact()+" "+order.getjMobile()).append("\n"+getJInfo(order));
		remark.append("\n送包信息："+order.getdContact()+" "+order.getdMobile()).append("\n"+getdInfo(order));
		remark.append("\n点击此消息进行付款。");
		remarkValue.put("value", remark.toString());
		remarkValue.put("color", "#173177");
		data.put("remark", remarkValue);
		
		template.setData(data);
		return template;
	}
	
	/**
	 *  标题代下单成功通知

		详细内容
		{{first.DATA}}
		寄包地址：{{keyword1.DATA}}
		取包时间：{{keyword2.DATA}}
		收包地址：{{keyword3.DATA}}
		预计到达：{{keyword4.DATA}}
		{{remark.DATA}}
		
		内容示例
		尊敬的用户，您好！销售代表已为您代下单。
		寄包地址：广东省珠诲市香洲区端丰大厦6A
		取包时间：2014年7月21日 18:00
		收包地址：广东中山温泉高尔夫球场
		预计到达：2014年7月22日 18:00
		点击此消息进行付款。
	  * @Title: proxyAddShoppingCart
	  * @Description: TODO
	  * @author: share 2017年2月9日
	  * @modify: share 2017年2月9日
	  * @param vipInfo
	  * @return
	 */
	public static Template proxyOrder(OrderInfo orderInfo,UserProxy userProxy,String openId,String url){
		Template template = new Template();
		template.setTouser(openId);
		template.setUrl(url);
		Map<String,Map<String,String>> data = new HashMap<String,Map<String,String>>();
		
		Map<String,String> firstValue = new HashMap<String, String>();
		StringBuffer first = new StringBuffer();
		first.append("你已成功为客户代下单");
		first.append("\n支付状态:"+(orderInfo.getOrderStatus().intValue() == 3?"已支付":"未支付"));
		if(userProxy.getName()==null){
			first.append("\n客户姓名:"+"");
		}else{
			first.append("\n客户姓名:"+userProxy.getName());
		}
		if(userProxy.getMobile()==null){
			first.append("\n电话号码:"+"");
		}else{
			first.append("\n电话号码:"+userProxy.getMobile());
		}
		first.append("\n客户编号:"+StringUtils.leftPad(String.valueOf(userProxy.getUserId()), 6, '0'));
		firstValue.put("value", first.toString());
		firstValue.put("color", "#173177");
		data.put("first", firstValue);
		
		Map<String,String> keyword1Value = new HashMap<String, String>();
		keyword1Value.put("value", getJInfo(orderInfo));
		keyword1Value.put("color", "#173177");
		data.put("keyword1", keyword1Value);
		
		Map<String,String> keyword2Value = new HashMap<String, String>();
		keyword2Value.put("value", DateUtil.formatDate(orderInfo.getSendSfUserTime(), DateUtil.DATE_TIME_FORMAT_02));
		keyword2Value.put("color", "#173177");
		data.put("keyword2", keyword2Value);
		
		Map<String,String> keyword3Value = new HashMap<String, String>();
		keyword3Value.put("value",  getdInfo(orderInfo));
		keyword3Value.put("color", "#173177");
		data.put("keyword3", keyword3Value);
		
		Map<String,String> keyword4Value = new HashMap<String, String>();
		
		if(ExpressTypeEnum.after_tomorow.getType().equals(orderInfo.getExpressType())){
			long days = DateUtil.getDiffDaysForDay(
					orderInfo.getSendSfUserTime(), 
					DateUtil.str2Date(orderInfo.getDeliverDate(), DateUtil.DATE_TIME_FORMAT_01)
					);
			keyword4Value.put("value", days+"天后");
		}else{
			keyword4Value.put("value", orderInfo.getDeliverDate());
		}
		
	
		keyword4Value.put("color", "#173177");
		data.put("keyword4", keyword4Value);
		
		
		Map<String,String> remarkValue = new HashMap<String, String>();
		remarkValue.put("value", "");
		remarkValue.put("color", "#173177");
		data.put("remark", remarkValue);
		
		template.setData(data);
		return template;
	}
	
	public static Template scanQrcode(UserWeixin proxyUser,UserWeixin scanUser, String url){
		Template template = new Template();
		template.setTouser(proxyUser.getOpenid());
		template.setUrl(url);
		Map<String,Map<String,String>> data = new HashMap<String,Map<String,String>>();
		
		Map<String,String> firstValue = new HashMap<String, String>();
		firstValue.put("value", "你好，有客户扫描了你的二维码，你可以代该客户下单。");
		firstValue.put("color", "#173177");
		data.put("first", firstValue);
		
		Map<String,String> keyword1Value = new HashMap<String, String>();
		keyword1Value.put("value", StringUtils.leftPad(String.valueOf(scanUser.getId()), 6, '0'));
		keyword1Value.put("color", "#173177");
		data.put("keyword1", keyword1Value);
		
		Map<String,String> keyword2Value = new HashMap<String, String>();
		keyword2Value.put("value", DateUtil.formatDate(new Date(), DateUtil.DATE_TIME_FORMAT_06));
		keyword2Value.put("color", "#173177");
		data.put("keyword2", keyword2Value);
		
		
		Map<String,String> remarkValue = new HashMap<String, String>();
		StringBuffer remark = new StringBuffer();
		remark.append("\n是否新关注：").append(scanUser.getIsNew() ? "是" : "否");
		remark.append("\n点击本消息为此客户代下单。");
		remarkValue.put("value", remark.toString());
		remarkValue.put("color", "#173177");
		data.put("remark", remarkValue);
		
		template.setData(data);
		return template;
	}
	
	/**
	 * {{first.DATA}}=客户您好，您的优惠券即将过期
	 * {{keyword1.DATA}}={优惠券过期}
	 * {{keyword2.DATA}}={过期时间}
	 * {{remark.DATA}}=金额:{金额}
	 * 
	 * 优惠券过期提醒
	 * @param couponActivity
	 * @param openid
	 * @return
	 */
	public static Template createExpireCoupon(UserCouponActivity couponActivity, String openid){
		Template template = new Template();
		template.setTouser(openid);
		template.setUrl("");
		
		Map<String,Map<String,String>> data = new HashMap<String,Map<String,String>>();
		Map<String,String> firstValue = new HashMap<String, String>();
		firstValue.put("value", "客户您好，您的优惠券即将过期");
		firstValue.put("color", "#173177");
		data.put("first", firstValue);
		
		Map<String,String> keyword1Value = new HashMap<String, String>();
		keyword1Value.put("value", String.format("现金券码(%s)", couponActivity.getChildCode()));
		keyword1Value.put("color", "#173177");
		data.put("keyword1", keyword1Value);
		
		Map<String,String> keyword2Value = new HashMap<String, String>();
		keyword2Value.put("value", DateUtil.formatDate(couponActivity.getEndTime(), DateUtil.DATE_TIME_FORMAT_01));
		keyword2Value.put("color", "#173177");
		data.put("keyword2", keyword2Value);
		
		Map<String,String> remarkValue = new HashMap<String, String>();
		remarkValue.put("value", "金额："+couponActivity.getChildAmount());
		remarkValue.put("color", "#173177");
		data.put("remark", remarkValue);
		
		template.setData(data);
		return template;
	}
	
	/**
	 * {{first.DATA}}
	 * 
	 * 下单时间：{{ordertape.DATA}}
	 * 订单号：{{ordeID.DATA}}
	 * {{remark.DATA}}
	 * 
	 * {{first.DATA}}=尊敬的用户，您好！您的订单未支付，即将关闭。
	 * {{ordertape.DATA}}=下单时间
	 * {{ordeID.DATA}}=订单编号
	 * {{remark.DATA}}=待付金额：{订单金额}\n取件时间:{订单预约取件时间}\n预计到达: {预计到达时间}\n取包信息:{寄件人},{寄件电话},{寄件人地址}\n送包信息:{收件人},{收件电话},{收件人地址}
	 * \n请及时确认支付，以防订单过期失效
	 * createWaitPay:(待支付提醒).
	 *
	 * @author haungyihao
	 * 2016年10月26日 下午1:22:46
	 * @param orderInfo
	 * @return
	 *
	 */
	public static Template createWaitPay(OrderInfo orderInfo){
		String openid = orderInfo.getOpenid();
		Template template = new Template();
		template.setTouser(openid);
		template.setUrl("");
		Map<String,Map<String,String>> data = new HashMap<String,Map<String,String>>();
		
		Map<String,String> firstValue = new HashMap<String, String>();
		firstValue.put("value", "尊敬的用户，您好！您的订单未支付，即将关闭。");
		firstValue.put("color", "#173177");
		data.put("first", firstValue);
		
		Map<String,String> ordertapeValue = new HashMap<String, String>();
		ordertapeValue.put("value", DateUtil.formatDate(orderInfo.getCreateTime(), DateUtil.DATE_TIME_FORMAT_01));
		ordertapeValue.put("color", "#173177");
		data.put("ordertape", ordertapeValue);
		
		Map<String,String> orderIdValue = new HashMap<String, String>();
		orderIdValue.put("value", orderInfo.getNumber());
		orderIdValue.put("color", "#173177");
		data.put("ordeID", orderIdValue);
		
		Map<String,String> remarkValue = new HashMap<String, String>();
		StringBuffer remark = new StringBuffer();
		remark.append("待付金额：").append(orderInfo.getAmount() > 0 ? orderInfo.getAmount().toString() : orderInfo.getTotalAmount().toString())
			.append("\n取件时间：").append(DateUtil.formatDate(orderInfo.getSendSfUserTime(), DateUtil.DATE_TIME_FORMAT_01))
			.append("\n预计到达：").append(orderInfo.getDeliverDate())
			.append("\n取包信息：").append(orderInfo.getjContact()).append("，").append(orderInfo.getjMobile()).append("，").append(getJInfo(orderInfo))
			.append("\n送包信息：").append(orderInfo.getdContact()).append("，").append(orderInfo.getdMobile()).append("，").append(getdInfo(orderInfo))
			.append("\n请及时确认支付。");
		remarkValue.put("value", remark.toString());
		remarkValue.put("color", "#173177");
		data.put("remark", remarkValue);
		
		template.setData(data);
		return template;
	}
	
	/**
	 * 
	 * {{first.DATA}}={您提交的球包助理申请审核拒绝}\n
	 * 拒绝理由：{拒绝原因}
	 * {{keyword1.DATA}}={姓名}
	 * {{keyword2.DATA}}={身份证}
	 * {{keyword3.DATA}}={证件号码}
	 * {{remark.DATA}}=申请类型:{申请类型}\n
	 * 球场/站点:{球场/站点名称}
	 * 
	 * 球包助理审核申请通知
	 * @param openid
	 * @return
	 */
	public static Template createAssistantApply(UserAssistantApply apply, UserAssistant assistant, String openid){
		Template template = new Template();
		template.setTouser(openid);
		template.setUrl("");
		
		Map<String,Map<String,String>> data = new HashMap<String,Map<String,String>>();
		Map<String,String> firstValue = new HashMap<String, String>();
		if(assistant.getStatus() == 2){
			firstValue.put("value", "您提交的球包助理申请审核成功");
		}else if(assistant.getStatus() == 3){
			StringBuffer failStr = new StringBuffer("您提交的球包助理申请审核失败\n");
			failStr.append("拒绝理由：").append(assistant.getMemo());
			firstValue.put("value", failStr.toString());
		}
		firstValue.put("color", "#173177");
		data.put("first", firstValue);
		
		Map<String,String> keyword1Value = new HashMap<String, String>();
		keyword1Value.put("value", apply.getName());
		keyword1Value.put("color", "#173177");
		data.put("keyword1", keyword1Value);
		
		Map<String,String> keyword2Value = new HashMap<String, String>();
		keyword2Value.put("value", "身份证");
		keyword2Value.put("color", "#173177");
		data.put("keyword2", keyword2Value);
		
		Map<String,String> keyword3Value = new HashMap<String, String>();
		keyword3Value.put("value", apply.getIdentityCode());
		keyword3Value.put("color", "#173177");
		data.put("keyword3", keyword3Value);
		
		Map<String,String> remarkValue = new HashMap<String, String>();
		StringBuffer remarkStr = new StringBuffer("申请类型：");
		remarkStr.append(AssistantApplyType.getByType(apply.getApplyType()).getDesc())
				 .append("\n")
				 .append("球场/站点：")
				 .append(apply.getApplyName());
		remarkValue.put("value", remarkStr.toString());
		remarkValue.put("color", "#173177");
		data.put("remark", remarkValue);
		
		template.setData(data);
		return template;
	}
	
	/**
	  * {{first.DATA}}
	  * 订单号：{{keyword1.DATA}}
	  * 预约时间：{{keyword2.DATA}}
	  * 取消时间：{{keyword3.DATA}}
	  * 退款金额：{{keyword4.DATA}}
	  * {{remark.DATA}}
	  * 
	  * {{first.DATA}} = 尊敬的用户您好，您的订单已取消
	  * {{keyword1.DATA}={球包通订单单号}
	  * {{keyword2.DATA}}={预约取件时间}
	  * {{keyword3.DATA}}={取消为操作时间}
	  * {{keyword4.DATA}}={实际支付金额}
	  * {{remark.DATA}}=取包信息: {寄件人},{寄件电话},{寄件人地址}\n送包信息:{收件人},{收件电话},{收件人地址}\n预计两个工作日内会退款到账, 如有任何疑问，请拨打：400-803-0106
	 * 
	 *  订单取消通知下单人
	  * @Title: createOrderCancel
	  * @Description: TODO
	  * @author: share 2016年8月17日
	  * @modify: share 2016年8月17日
	  * @param orderInfo
	  * @return
	 */
	public static Template createOrderCancel(OrderInfo orderInfo, OrderRefund refund){
		String openid = orderInfo.getOpenid();
		Template template = new Template();
		template.setTouser(openid);
		template.setUrl("");
		Map<String,Map<String,String>> data = new HashMap<String,Map<String,String>>();
		
		Map<String,String> firstValue = new HashMap<String, String>();
		firstValue.put("value", "尊敬的用户您好，您的订单已取消");
		firstValue.put("color", "#173177");
		data.put("first", firstValue);
		
		Map<String,String> keyword1Value = new HashMap<String, String>();
		keyword1Value.put("value", orderInfo.getNumber());
		keyword1Value.put("color", "#173177");
		data.put("keyword1", keyword1Value);
		
		Map<String,String> keyword2Value = new HashMap<String, String>();
		keyword2Value.put("value", DateUtil.formatDate(orderInfo.getSendSfUserTime(), DateUtil.DATE_TIME_FORMAT_01));
		keyword2Value.put("color", "#173177");
		data.put("keyword2", keyword2Value);
		
		Map<String,String> keyword3Value = new HashMap<String, String>();
		keyword3Value.put("value", DateUtil.formatDate(new Date(), DateUtil.DATE_TIME_FORMAT_01));
		keyword3Value.put("color", "#173177");
		data.put("keyword3", keyword3Value);
		
		Map<String,String> keyword4Value = new HashMap<String, String>();
		keyword4Value.put("value", String.valueOf(refund.getRealAmount()));
		keyword4Value.put("color", "#173177");
		data.put("keyword4", keyword4Value);
		
		Map<String,String> remarkValue = new HashMap<String, String>();
		remarkValue.put("value", "取包信息："+orderInfo.getjContact()+"，"+orderInfo.getjMobile()+"，"+getJInfo(orderInfo)+"\n送包信息："+orderInfo.getdContact()+"，"+orderInfo.getdMobile()+"，"+getdInfo(orderInfo)+"\n预计两个工作日内会退款到账，如有任何疑问，请拨打："+Constants.QBT_KF_TEL);
		remarkValue.put("color", "#173177");
		data.put("remark", remarkValue);
		
		template.setData(data);
		return template;
	}
	
	/**
	 * {{first.DATA}}
	 * 订单号：{{keyword1.DATA}}
	 * 预约时间：{{keyword2.DATA}}
	 * 取消时间：{{keyword3.DATA}}
	 * 退款金额：{{keyword4.DATA}}
	 * {{remark.DATA}}
	 * 
	 * {{first.DATA}} = 财务人员注意, 用户已取消支付订单\n微信支付码:XXX
	 * {{keyword1.DATA}={球包通订单单号}
	 * {{keyword2.DATA}}={预约取件时间}
	 * {{keyword3.DATA}}={取消为操作时间}
	 * {{keyword4.DATA}}={实际支付金额}
	 * {{remark.DATA}}="请及时核查并退款", "#173177"
	 * 注：#173177表示颜色
	 * 
	 * 订单取消通知财务人员
	 * @param orderInfo
	 * @param openid
	 * @return
	 */
	public static Template createOrderCancelCw(OrderInfo orderInfo, String openid, OrderRefund refund){
		Template template = new Template();
		template.setTouser(openid);
		template.setUrl("");
		Map<String,Map<String,String>> data = new HashMap<String,Map<String,String>>();
		
		Map<String,String> firstValue = new HashMap<String, String>();
		firstValue.put("value", "财务人员注意，用户已取消支付订单：");
		firstValue.put("color", "#173177");
		data.put("first", firstValue);
		
		Map<String,String> keyword1Value = new HashMap<String, String>();
		keyword1Value.put("value", orderInfo.getNumber());
		keyword1Value.put("color", "#173177");
		data.put("keyword1", keyword1Value);
		
		Map<String,String> keyword2Value = new HashMap<String, String>();
		keyword2Value.put("value", DateUtil.formatDate(orderInfo.getSendSfUserTime(), DateUtil.DATE_TIME_FORMAT_01));
		keyword2Value.put("color", "#173177");
		data.put("keyword2", keyword2Value);
		
		Map<String,String> keyword3Value = new HashMap<String, String>();
		keyword3Value.put("value", DateUtil.formatDate(orderInfo.getUpdateTime(), DateUtil.DATE_TIME_FORMAT_01));
		keyword3Value.put("color", "#173177");
		data.put("keyword3", keyword3Value);
		
		Map<String,String> keyword4Value = new HashMap<String, String>();
		keyword4Value.put("value", String.valueOf(refund.getRealAmount()));
		keyword4Value.put("color", "#173177");
		data.put("keyword4", keyword4Value);
		
		Map<String,String> remarkValue = new HashMap<String, String>();
		remarkValue.put("value", "请及时核查并退款");
		remarkValue.put("color", "#173177");
		data.put("remark", remarkValue);
		
		template.setData(data);
		return template;
	}
	
	/**
	 * {{first.DATA}}={您提交的球包助理申请审核拒绝}\n
	 * 拒绝理由：{拒绝原因}
	 * {{keyword1.DATA}}={姓名}
	 * {{keyword2.DATA}}={身份证}
	 * {{keyword3.DATA}}={证件号码}
	 * {{remark.DATA}}=申请类型:{申请类型}\n
	 * 球场/站点:{球场/站点名称}
	 * 
	 * createSaleUserApply:(销售人员申请).
	 *
	 * @author huangyihao
	 * 2017年2月8日 上午11:34:27
	 * @param saleUser
	 * @return
	 *
	 */
	public static Template createSaleUserApply(SaleUser saleUser, String openid){
		Template template = new Template();
		template.setTouser(openid);
		template.setUrl("");
		
		Map<String,Map<String,String>> data = new HashMap<String,Map<String,String>>();
		Map<String,String> firstValue = new HashMap<String, String>();
		if(saleUser.getApplyStatus() == 2){
			firstValue.put("value", "您的销售人员申请审核成功。");
		}else if(saleUser.getApplyStatus() == 3){
			StringBuffer failStr = new StringBuffer("您的销售人员申请未获通过。");
			firstValue.put("value", failStr.toString());
		}
		firstValue.put("color", "#173177");
		data.put("first", firstValue);
		
		Map<String,String> keyword1Value = new HashMap<String, String>();
		keyword1Value.put("value", saleUser.getName());
		keyword1Value.put("color", "#173177");
		data.put("keyword1", keyword1Value);
		
		Map<String,String> keyword2Value = new HashMap<String, String>();
		keyword2Value.put("value", "身份证");
		keyword2Value.put("color", "#173177");
		data.put("keyword2", keyword2Value);
		
		Map<String,String> keyword3Value = new HashMap<String, String>();
		keyword3Value.put("value", saleUser.getIdcard());
		keyword3Value.put("color", "#173177");
		data.put("keyword3", keyword3Value);
		
		Map<String,String> remarkValue = new HashMap<String, String>();
		StringBuffer remarkStr = new StringBuffer("工作证号：");
		remarkStr.append(saleUser.getSalesmanCode());
		if(saleUser.getApplyStatus() == 2){
			remarkStr.append("\n可回复“二维码”查看您的销售二维码信息。");
		}else if(saleUser.getApplyStatus() == 3){
			remarkStr.append("\n如有疑问，请与我们联系，谢谢！");
		}
		remarkValue.put("value", remarkStr.toString());
		remarkValue.put("color", "#173177");
		data.put("remark", remarkValue);
		
		template.setData(data);
		return template;
	}

	public static Template createPushTicketPayment(UserActivityOrder orderInfo) {
		String openid = orderInfo.getOpenid();
		Template template = new Template();
		template.setTouser(openid);
		template.setUrl(orderInfo.getPaymentUrl());
		Map<String,Map<String,String>> data = new HashMap<String,Map<String,String>>();
		
		Map<String,String> firstValue = new HashMap<String, String>();
		firstValue.put("value", "尊敬的用户，您好！您在球包通购买的商品信息");
		firstValue.put("color", "#173177");
		data.put("first", firstValue);
		
		Map<String,String> ordertapeValue = new HashMap<String, String>();
		ordertapeValue.put("value", DateUtil.formatDate(orderInfo.getCreateTime(), DateUtil.DATE_TIME_FORMAT_01));
		ordertapeValue.put("color", "#173177");
		data.put("ordertape", ordertapeValue);
		
		Map<String,String> orderIdValue = new HashMap<String, String>();
		orderIdValue.put("value", orderInfo.getOrderNumber()+"");
		orderIdValue.put("color", "#173177");
		data.put("ordeID", orderIdValue);
		
		Map<String,String> remarkValue = new HashMap<String, String>();
		StringBuffer remark = new StringBuffer();
		
		String ticketType = "电子券";
		if(orderInfo.getType() == 1) {
			ticketType = "纸质券";
		}
		
		remark.append("券包名称：").append(orderInfo.getActivityName() +" (" + ticketType+")")
			.append("\n订单金额：￥").append(orderInfo.getPayAmount())
			.append("\n订单状态：").append("待支付");
		remarkValue.put("value", remark.toString());
		remarkValue.put("color", "#173177");
		data.put("remark", remarkValue);
		
		template.setData(data);
		return template;
	
	}
	
}
