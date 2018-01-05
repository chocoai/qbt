package com.qbt.bussiness.template;

import java.util.Date;

import com.qbt.common.enums.ExpressTypeEnum;
import com.qbt.common.util.Arith;
import com.qbt.common.util.DateUtil;
import com.qbt.common.util.StringUtil;
import com.qbt.persistent.entity.OrderChangeBook;
import com.qbt.persistent.entity.OrderInfo;

/**
 *  邮箱内容模板
  * @ClassName: EmailTemplate
  * @Description: TODO
  * @author share 2016年9月2日
  * @modify share 2016年9月2日
 */
public class EmailTemplate {

	/**
	 *  订单创建
	  * @Title: orderPaySucc
	  * @Description: TODO
	  * @author: share 2016年9月2日
	  * @modify: share 2016年9月2日
	  * @param orderInfo
	  * @return
	 */
	public static String[] orderPaySucc(OrderInfo orderInfo){
		
		
		String currendDate = DateUtil.formatDate(new Date(), DateUtil.DATE_TIME_FORMAT_01);
		String subject =  "【球包通】"+currendDate+"下单保价通知--"+"运单号："+orderInfo.getMailNo();
		
		StringBuilder sb = new StringBuilder();
		sb.append("尊敬的顺丰客服您好！<br/>");
		sb.append("球包通Boss系统温馨提醒：<br/>");
		sb.append("下单时间：").append(currendDate).append("<br/>");
		sb.append("时效类型：").append(ExpressTypeEnum.getByType(orderInfo.getExpressType()).getDesc()).append("<br/>");
		sb.append("要求取件时间：").append(getSendSfUserTime(orderInfo)).append("<br/>");
		sb.append("要求到达时间：").append(orderInfo.getDeliverDate()).append("<br/>");
		sb.append("球包通订单号：").append(orderInfo.getNumber()).append("<br/>");
		sb.append("顺丰订单号：").append(orderInfo.getMailNo()).append("<br/>");
		sb.append("取包地址：").append(getJInfo(orderInfo)).append("<br/>");
		sb.append("送包地址：").append(getdInfo(orderInfo)).append("<br/>");
		if(orderInfo.getInsuredValue() == 0){
			sb.append("保价金额：1.0<br/>");
		}else{
			sb.append("保价金额：").append(Arith.mul(orderInfo.getInsuredValue(),10000)).append("<br/>");
		}
		sb.append("请知悉！\r<br/>");

		return new String[]{subject,sb.toString()};
	}
	
	/**
	 *  订单取消
	  * @Title: orderCancle
	  * @Description: TODO
	  * @author: share 2016年9月2日
	  * @modify: share 2016年9月2日
	  * @param orderInfo
	  * @return
	 */
	public static String[] orderCancle(OrderInfo orderInfo){
		
		String currendDate = DateUtil.formatDate(new Date(), DateUtil.DATE_TIME_FORMAT_01);
		String subject =  "【球包通】"+currendDate+"取消订单通知--"+"运单号："+orderInfo.getMailNo();
		
		StringBuilder sb = new StringBuilder();
		sb.append("尊敬的顺丰客服您好！<br/>");
		sb.append("球包通Boss系统温馨提醒：<br/>");
		sb.append("取消时间：").append(currendDate).append("<br/>");
		sb.append("时效类型：").append(ExpressTypeEnum.getByType(orderInfo.getExpressType()).getDesc()).append("<br/>");
		sb.append("要求取件时间：").append(getSendSfUserTime(orderInfo)).append("<br/>");
		sb.append("要求到达时间：").append(orderInfo.getDeliverDate()).append("<br/>");
		sb.append("球包通订单号：").append(orderInfo.getNumber()).append("<br/>");
		sb.append("顺丰订单号：").append(orderInfo.getMailNo()).append("<br/>");
		sb.append("取包地址：").append(getJInfo(orderInfo)).append("<br/>");
		sb.append("送包地址：").append(getdInfo(orderInfo)).append("<br/>");
		if(orderInfo.getInsuredValue() == 0){
			sb.append("保价金额：1.0<br/>");
		}else{
			sb.append("保价金额：").append(Arith.mul(orderInfo.getInsuredValue(),10000)).append("<br/>");
		}
		sb.append("请知悉！<br/>");
	    
		return new String[]{subject,sb.toString()};
	}
	
	/**
	 *  订单修改
	  * @Title: orderModify
	  * @Description: TODO
	  * @author: share 2016年9月2日
	  * @modify: share 2016年9月2日
	  * @param orderInfo
	  * @param book
	  * @return
	 */
	public static String[] orderModify(OrderInfo orderInfo,OrderChangeBook book){
		
		String currendDate = DateUtil.formatDate(new Date(), DateUtil.DATE_TIME_FORMAT_01);
		String subject =  "【球包通】"+currendDate+"修改订单及保价通知--"+"运单号："+orderInfo.getMailNo();
		
		StringBuilder sb = new StringBuilder();
		sb.append("尊敬的顺丰客服您好！<br/>");
		sb.append("球包通Boss系统温馨提醒：<br/>");
		sb.append("修改时间：").append(currendDate).append("<br/>");
		sb.append("时效类型：").append(ExpressTypeEnum.getByType(orderInfo.getExpressType()).getDesc()).append("<br/>");
		sb.append("要求取件时间：").append(getSendSfUserTime(orderInfo)).append("<br/>");
		sb.append("要求到达时间：").append(orderInfo.getDeliverDate()).append("<br/>");
		sb.append("球包通取消订单号：").append(book.getOldOrderNumber()).append("<br/>");
		sb.append("球包通新订单号：").append(book.getNewOrderNumber()).append("<br/>");
		sb.append("顺丰取消订单号：").append(book.getOldMailNo()).append("<br/>");
		sb.append("顺丰新订单号：").append(book.getNewMailNo()).append("<br/>");
		sb.append("取包地址：").append(getJInfo(orderInfo)).append("<br/>");
		sb.append("送包地址：").append(getdInfo(orderInfo)).append("<br/>");
		if(orderInfo.getInsuredValue() == 0){
			sb.append("保价金额：1.0<br/>");
		}else{
			sb.append("保价金额：").append(Arith.mul(orderInfo.getInsuredValue(),10000)).append("<br/>");
		}
		sb.append("请知悉！<br/>");
	    
		return new String[]{subject,sb.toString()};
	}
	
	private static String getSendSfUserTime(OrderInfo orderInfo){
		return DateUtil.formatDate(orderInfo.getSendSfUserTime(),DateUtil.DATE_TIME_FORMAT_01);
	}
	
	public static String getJInfo(OrderInfo orderInfo){
		StringBuilder msgsb = new StringBuilder();
		String addrName = orderInfo.getjAddrName();
		if(!StringUtil.isEmpty(addrName)){
			addrName = "("+addrName+")";
		}
		msgsb.append(addrName)
			.append(orderInfo.getjTreePath().replace(",", ""))
			.append(orderInfo.getjAddress());
		return msgsb.toString();
	}
	
	public static String getdInfo(OrderInfo orderInfo){
		StringBuilder msgsb = new StringBuilder();
		String addrName = orderInfo.getdAddrName();
		if(!StringUtil.isEmpty(addrName)){
			addrName = "("+addrName+")";
		}
		msgsb.append(addrName)
			.append(orderInfo.getdTreePath().replace(",", ""))
			.append(orderInfo.getdAddress());
		return msgsb.toString();
	}
}
