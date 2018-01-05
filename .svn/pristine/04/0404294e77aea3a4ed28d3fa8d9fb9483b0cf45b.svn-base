package com.qbt.bussiness.template;

import com.qbt.common.enums.ExpressTypeEnum;
import com.qbt.common.util.Constants;
import com.qbt.common.util.DateUtil;
import com.qbt.persistent.dto.UserCouponActivity;
import com.qbt.persistent.entity.OrderExceptionBook;
import com.qbt.persistent.entity.OrderInfo;
import com.qbt.persistent.entity.SaleUser;
import com.qbt.persistent.entity.UserProxy;

public class SmsMessageTemplate {

	public static String[] createM_112387(OrderInfo orderInfo){
		String[] msgs = new String[6];
		msgs[0] = getOrderNumber(orderInfo);
		msgs[1] = getOrderPayTime(orderInfo);
		msgs[2] = getSendSfUserTime(orderInfo);
		msgs[3] = getJInfo(orderInfo);
		msgs[4] = getdInfo(orderInfo);
		
		
		if(ExpressTypeEnum.after_tomorow.getType().equals(orderInfo.getExpressType())){
			long days = DateUtil.getDiffDaysForDay(
					orderInfo.getSendSfUserTime(), 
					DateUtil.str2Date(orderInfo.getDeliverDate(), DateUtil.DATE_TIME_FORMAT_01)
					);
			msgs[5] = days+"天后";
		}else{
			msgs[5] = orderInfo.getDeliverDate();
		}
		
	
		return msgs;
	}
	
	public static String[] createM_112388(OrderInfo orderInfo) {
		String[] msgs = new String[6];
		msgs[0] = getOrderNumber(orderInfo);
		msgs[1] = getOrderPayTime(orderInfo);
		msgs[2] = getSendSfUserTime(orderInfo);
		msgs[3] = getJInfo(orderInfo);
		msgs[4] = getdInfo(orderInfo);
		msgs[5] = orderInfo.getDeliverDate();
		return msgs;
	}
	
	public static String[] createM_112392(OrderInfo orderInfo) {
		String[] msgs = new String[5];
		msgs[0] = getOrderNumber(orderInfo);
		msgs[1] = getSendSfUserTime(orderInfo);
		msgs[2] = getJInfo(orderInfo);
		msgs[3] = getdInfo(orderInfo);
		msgs[4] = orderInfo.getDeliverDate();
		return msgs;
	}
	
	public static String[] createM_112393(OrderInfo orderInfo) {
		String[] msgs = new String[5];
		msgs[0] = getOrderNumber(orderInfo);
		msgs[1] = getSendSfUserTime(orderInfo);
		msgs[2] = getJInfo(orderInfo);
		msgs[3] = getdInfo(orderInfo);
		msgs[4] = orderInfo.getDeliverDate();
		return msgs;
	}
	
	public static String[] createM_112645(OrderInfo orderInfo) {
		String[] msgs = new String[3];
		msgs[0] = getOrderNumber(orderInfo);
		msgs[1] = getSendSfUserTime(orderInfo);
		msgs[2] = orderInfo.getDeliverDate();
		return msgs;
	}
	
	public static String[] createM_112400(OrderInfo orderInfo) {
		String[] msgs = new String[5];
		msgs[0] = getOrderNumber(orderInfo);
		msgs[1] = DateUtil.formatDate(orderInfo.getSendSfUserTime(),DateUtil.DATE_TIME_FORMAT_01);
		msgs[2] = getJInfo(orderInfo);
		msgs[3] = getdInfo(orderInfo);
		msgs[4] = orderInfo.getDeliverDate();
		return msgs;
	}
	
	public static String[] createM_112395(OrderInfo orderInfo,String acceptTime){
		String[] messages = new String[4];
		messages[0] = acceptTime;
		messages[1] = orderInfo.getNumber();
		String address = "";
		if(orderInfo.getjAddrType() != 4){
			address = orderInfo.getjAddrName();
		}else{
			address = orderInfo.getjAddress();
		}
		messages[2] = orderInfo.getjTreePath().replace(",", "")+address;
		if(orderInfo.getdAddrType() != 4){
			address = orderInfo.getdAddrName();
		}else{
			address = orderInfo.getdAddress();
		}
		messages[3] = orderInfo.getdTreePath().replace(",", "")+address;
		return messages;
	}
	
	public static String[] createM_112397(OrderInfo orderInfo, String acceptTime) {
		String[] messages = new String[5];
		messages[0] = orderInfo.getNumber();
		messages[1] = acceptTime;
		String address = "";
		if(orderInfo.getjAddrType() != 4){
			address = orderInfo.getjAddrName();
		}else{
			address = orderInfo.getjAddress();
		}
		messages[2] = orderInfo.getjTreePath().replace(",", "")+address;
		if(orderInfo.getdAddrType() != 4){
			address = orderInfo.getdAddrName();
		}else{
			address = orderInfo.getdAddress();
		}
		messages[3] = orderInfo.getdTreePath().replace(",", "")+address;
		messages[4] = orderInfo.getDeliverDate();
		return messages;
	}
	
	public static String[] createM_112396(OrderInfo orderInfo,String acceptTime) {
		String[] msgs = new String[5];
		msgs[0] = getOrderNumber(orderInfo);
		msgs[1] = acceptTime;
		msgs[2] = getJInfo(orderInfo);
		msgs[3] = getdInfo(orderInfo);
		msgs[4] = orderInfo.getDeliverDate();
		return msgs;
	}

	public static String[] createM_112398(OrderInfo orderInfo) {
		String[] msgs = new String[5];
		msgs[0] = getOrderNumber(orderInfo);
		msgs[1] = getSendSfUserTime(orderInfo);
		msgs[2] = getJInfo(orderInfo);
		msgs[3] = getdInfo(orderInfo);
		msgs[4] = orderInfo.getDeliverDate();
		return msgs;
	}
	
	public static String[] createM_112399(OrderInfo orderInfo, String acceptTime) {
		String address = "";
		if(orderInfo.getdAddrType() != 4){
			address = orderInfo.getdAddrName();
		}else{
			address = orderInfo.getdAddress();
		}
		String[] msgs = new String[3];
		msgs[0] = address;
		msgs[1] = getOrderNumber(orderInfo);
		msgs[2] = acceptTime;
		return msgs;
	}
	
	public static String createM_113080(OrderInfo orderInfo){
		String address = "";
		if(orderInfo.getdAddrType() != 4){
			address = orderInfo.getdAddrName();
		}else{
			address = orderInfo.getdAddress();
		}
		return address;
	}
	
	public static String[] createM_121174(OrderInfo orderInfo){
		String address = "";
		if(orderInfo.getdAddrType() != 4){
			address = orderInfo.getdAddrName();
		}else{
			address = orderInfo.getdAddress();
		}
		String[] msgs = new String[2];
		msgs[0] = orderInfo.getNumber();
		msgs[1] = address;
		return msgs;
	}
	
	public static String[] createM_124162(OrderInfo orderInfo){
		String[] msgs = new String[6];
		msgs[0] = getOrderNumber(orderInfo);
		msgs[1] = getOrderPayTime(orderInfo);
		msgs[2] = getSendSfUserTime(orderInfo);
		msgs[3] = getJInfo(orderInfo);
		msgs[4] = getdInfo(orderInfo);
		msgs[5] = orderInfo.getDeliverDate();
		return msgs;
	}
	
	public static String[] createM_124161(OrderInfo orderInfo) {
		String[] msgs = new String[6];
		msgs[0] = getOrderNumber(orderInfo);
		msgs[1] = getOrderPayTime(orderInfo);
		msgs[2] = getSendSfUserTime(orderInfo);
		msgs[3] = getJInfo(orderInfo);
		msgs[4] = getdInfo(orderInfo);
		msgs[5] = orderInfo.getDeliverDate();
		return msgs;
	}
	
	public static String[] createM_124160(OrderInfo orderInfo) {
		String[] msgs = new String[5];
		msgs[0] = getOrderNumber(orderInfo);
		msgs[1] = getSendSfUserTime(orderInfo);
		msgs[2] = getJInfo(orderInfo);
		msgs[3] = getdInfo(orderInfo);
		msgs[4] = orderInfo.getDeliverDate();
		return msgs;
	}
	
	public static String[] createM_124159(OrderInfo orderInfo) {
		String[] msgs = new String[5];
		msgs[0] = getOrderNumber(orderInfo);
		msgs[1] = getSendSfUserTime(orderInfo);
		msgs[2] = getJInfo(orderInfo);
		msgs[3] = getdInfo(orderInfo);
		msgs[4] = orderInfo.getDeliverDate();
		return msgs;
	}
	
	public static String[] createM_124158(OrderInfo orderInfo,String acceptTime){
		String[] messages = new String[4];
		messages[0] = acceptTime;
		messages[1] = orderInfo.getNumber();
		String address = "";
		if(orderInfo.getjAddrType() != 4){
			address = orderInfo.getjAddrName();
		}else{
			address = orderInfo.getjAddress();
		}
		messages[2] = orderInfo.getjTreePath().replace(",", "")+address;
		if(orderInfo.getdAddrType() != 4){
			address = orderInfo.getdAddrName();
		}else{
			address = orderInfo.getdAddress();
		}
		messages[3] = orderInfo.getdTreePath().replace(",", "")+address;
		return messages;
	}
	
	public static String[] createM_124157(OrderInfo orderInfo,String acceptTime) {
		String[] msgs = new String[5];
		msgs[0] = getOrderNumber(orderInfo);
		msgs[1] = acceptTime;
		msgs[2] = getJInfo(orderInfo);
		msgs[3] = getdInfo(orderInfo);
		msgs[4] = orderInfo.getDeliverDate();
		return msgs;
	}
	
	public static String[] createM_124155(OrderInfo orderInfo, String acceptTime) {
		String[] messages = new String[5];
		messages[0] = orderInfo.getNumber();
		messages[1] = acceptTime;
		String address = "";
		if(orderInfo.getjAddrType() != 4){
			address = orderInfo.getjAddrName();
		}else{
			address = orderInfo.getjAddress();
		}
		messages[2] = orderInfo.getjTreePath().replace(",", "")+address;
		if(orderInfo.getdAddrType() != 4){
			address = orderInfo.getdAddrName();
		}else{
			address = orderInfo.getdAddress();
		}
		messages[3] = orderInfo.getdTreePath().replace(",", "")+address;
		messages[4] = orderInfo.getDeliverDate();
		return messages;
	}
	
	public static String[] createM_124153(OrderInfo orderInfo) {
		String[] msgs = new String[5];
		msgs[0] = getOrderNumber(orderInfo);
		msgs[1] = getSendSfUserTime(orderInfo);
		msgs[2] = getJInfo(orderInfo);
		msgs[3] = getdInfo(orderInfo);
		msgs[4] = orderInfo.getDeliverDate();
		return msgs;
	}
	
	public static String[] createM_124152(OrderInfo orderInfo) {
		String[] msgs = new String[5];
		msgs[0] = getOrderNumber(orderInfo);
		msgs[1] = DateUtil.formatDate(orderInfo.getSendSfUserTime(),DateUtil.DATE_TIME_FORMAT_01);
		msgs[2] = getJInfo(orderInfo);
		msgs[3] = getdInfo(orderInfo);
		msgs[4] = orderInfo.getDeliverDate();
		return msgs;
	}
	
	public static String[] createM_130835(OrderInfo orderInfo){
		String[] msgs = new String[7];
		msgs[0] = orderInfo.getjContact();
		msgs[1] = getOrderNumber(orderInfo);
		msgs[2] = getOrderPayTime(orderInfo);
		msgs[3] = getSendSfUserTime(orderInfo);
		msgs[4] = getJInfo(orderInfo);
		msgs[5] = getdInfo(orderInfo);
		msgs[6] = orderInfo.getDeliverDate();
		return msgs;
	}
	
	public static String[] createM_130788(OrderInfo orderInfo) {
		String[] msgs = new String[7];
		msgs[0] = orderInfo.getdContact();
		msgs[1] = getOrderNumber(orderInfo);
		msgs[2] = getOrderPayTime(orderInfo);
		msgs[3] = getSendSfUserTime(orderInfo);
		msgs[4] = getJInfo(orderInfo);
		msgs[5] = getdInfo(orderInfo);
		msgs[6] = orderInfo.getDeliverDate();
		return msgs;
	}
	
	public static String[] createM_130777(OrderInfo orderInfo,String acceptTime){
		String[] messages = new String[5];
		messages[0] = orderInfo.getjContact();
		messages[1] = acceptTime;
		messages[2] = orderInfo.getNumber();
		String address = "";
		if(orderInfo.getjAddrType() != 4){
			address = orderInfo.getjAddrName();
		}else{
			address = orderInfo.getjAddress();
		}
		messages[3] = orderInfo.getjTreePath().replace(",", "")+address;
		if(orderInfo.getdAddrType() != 4){
			address = orderInfo.getdAddrName();
		}else{
			address = orderInfo.getdAddress();
		}
		messages[4] = orderInfo.getdTreePath().replace(",", "")+address;
		return messages;
	}
	
	public static String[] createM_130807(OrderInfo orderInfo,String acceptTime){
		String[] messages = new String[5];
		messages[0] = orderInfo.getdContact();
		messages[1] = acceptTime;
		messages[2] = orderInfo.getNumber();
		String address = "";
		if(orderInfo.getjAddrType() != 4){
			address = orderInfo.getjAddrName();
		}else{
			address = orderInfo.getjAddress();
		}
		messages[3] = orderInfo.getjTreePath().replace(",", "")+address;
		if(orderInfo.getdAddrType() != 4){
			address = orderInfo.getdAddrName();
		}else{
			address = orderInfo.getdAddress();
		}
		messages[4] = orderInfo.getdTreePath().replace(",", "")+address;
		return messages;
	}
	
	public static String[] createM_130813(OrderInfo orderInfo, String acceptTime) {
		String[] messages = new String[6];
		messages[0] = orderInfo.getjContact();
		messages[1] = orderInfo.getNumber();
		messages[2] = acceptTime;
		String address = "";
		if(orderInfo.getjAddrType() != 4){
			address = orderInfo.getjAddrName();
		}else{
			address = orderInfo.getjAddress();
		}
		messages[3] = orderInfo.getjTreePath().replace(",", "")+address;
		if(orderInfo.getdAddrType() != 4){
			address = orderInfo.getdAddrName();
		}else{
			address = orderInfo.getdAddress();
		}
		messages[4] = orderInfo.getdTreePath().replace(",", "")+address;
		messages[5] = orderInfo.getDeliverDate();
		return messages;
	}
	
	public static String[] createM_130815(OrderInfo orderInfo, String acceptTime) {
		String[] messages = new String[6];
		messages[0] = orderInfo.getdContact();
		messages[1] = orderInfo.getNumber();
		messages[2] = acceptTime;
		String address = "";
		if(orderInfo.getjAddrType() != 4){
			address = orderInfo.getjAddrName();
		}else{
			address = orderInfo.getjAddress();
		}
		messages[3] = orderInfo.getjTreePath().replace(",", "")+address;
		if(orderInfo.getdAddrType() != 4){
			address = orderInfo.getdAddrName();
		}else{
			address = orderInfo.getdAddress();
		}
		messages[4] = orderInfo.getdTreePath().replace(",", "")+address;
		messages[5] = orderInfo.getDeliverDate();
		return messages;
	}
	
	public static String[] createM_130816(OrderInfo orderInfo){
		String address = "";
		if(orderInfo.getdAddrType() != 4){
			address = orderInfo.getdAddrName();
		}else{
			address = orderInfo.getdAddress();
		}
		String[] msgs = new String[3];
		msgs[0] = orderInfo.getjContact();
		msgs[1] = orderInfo.getNumber();
		msgs[2] = address;
		return msgs;
	}
	
	public static String[] createM_130817(OrderInfo orderInfo){
		String address = "";
		if(orderInfo.getdAddrType() != 4){
			address = orderInfo.getdAddrName();
		}else{
			address = orderInfo.getdAddress();
		}
		String[] msgs = new String[3];
		msgs[0] = orderInfo.getdContact();
		msgs[1] = orderInfo.getNumber();
		msgs[2] = address;
		return msgs;
	}
	
	public static String[] createM_130818(OrderInfo orderInfo) {
		String[] msgs = new String[6];
		msgs[0] = orderInfo.getjContact();
		msgs[1] = getOrderNumber(orderInfo);
		msgs[2] = DateUtil.formatDate(orderInfo.getSendSfUserTime(),DateUtil.DATE_TIME_FORMAT_01);
		msgs[3] = getJInfo(orderInfo);
		msgs[4] = getdInfo(orderInfo);
		msgs[5] = orderInfo.getDeliverDate();
		return msgs;
	}
	
	public static String[] createM_130819(OrderInfo orderInfo) {
		String[] msgs = new String[6];
		msgs[0] = orderInfo.getdContact();
		msgs[1] = getOrderNumber(orderInfo);
		msgs[2] = DateUtil.formatDate(orderInfo.getSendSfUserTime(),DateUtil.DATE_TIME_FORMAT_01);
		msgs[3] = getJInfo(orderInfo);
		msgs[4] = getdInfo(orderInfo);
		msgs[5] = orderInfo.getDeliverDate();
		return msgs;
	}
	
	public static String[] createM_162514J(OrderInfo orderInfo){
		String[] msgs = new String[8];
		msgs[0] = orderInfo.getjContact();
		msgs[1] = getOrderNumber(orderInfo);
		msgs[2] = getOrderPayTime(orderInfo);
		msgs[3] = getSendSfUserTime(orderInfo);
		msgs[4] = getJInfo(orderInfo);
		msgs[5] = getdInfo(orderInfo);
		msgs[6] = orderInfo.getDeliverDate();
		msgs[7] = Constants.QBT_KF_TEL;
		return msgs;
	}
	
	public static String[] createM_162514D(OrderInfo orderInfo) {
		String[] msgs = new String[8];
		msgs[0] = orderInfo.getdContact();
		msgs[1] = getOrderNumber(orderInfo);
		msgs[2] = getOrderPayTime(orderInfo);
		msgs[3] = getSendSfUserTime(orderInfo);
		msgs[4] = getJInfo(orderInfo);
		msgs[5] = getdInfo(orderInfo);
		msgs[6] = orderInfo.getDeliverDate();
		msgs[7] = Constants.QBT_KF_TEL;
		return msgs;
	}
	
	public static String[] createM_162520J(OrderInfo orderInfo,String acceptTime){
		String[] messages = new String[6];
		messages[0] = orderInfo.getjContact();
		messages[1] = acceptTime;
		messages[2] = orderInfo.getNumber();
		String address = "";
		if(orderInfo.getjAddrType() != 4){
			address = orderInfo.getjAddrName();
		}else{
			address = orderInfo.getjAddress();
		}
		messages[3] = orderInfo.getjTreePath().replace(",", "")+address;
		if(orderInfo.getdAddrType() != 4){
			address = orderInfo.getdAddrName();
		}else{
			address = orderInfo.getdAddress();
		}
		messages[4] = orderInfo.getdTreePath().replace(",", "")+address;
		messages[5] = Constants.QBT_KF_TEL;
		return messages;
	}
	
	public static String[] createM_162520D(OrderInfo orderInfo,String acceptTime){
		String[] messages = new String[6];
		messages[0] = orderInfo.getdContact();
		messages[1] = acceptTime;
		messages[2] = orderInfo.getNumber();
		String address = "";
		if(orderInfo.getjAddrType() != 4){
			address = orderInfo.getjAddrName();
		}else{
			address = orderInfo.getjAddress();
		}
		messages[3] = orderInfo.getjTreePath().replace(",", "")+address;
		if(orderInfo.getdAddrType() != 4){
			address = orderInfo.getdAddrName();
		}else{
			address = orderInfo.getdAddress();
		}
		messages[4] = orderInfo.getdTreePath().replace(",", "")+address;
		messages[5] = Constants.QBT_KF_TEL;
		return messages;
	}
	
	public static String[] createM_162523J(OrderInfo orderInfo, String acceptTime) {
		String[] messages = new String[7];
		messages[0] = orderInfo.getjContact();
		messages[1] = orderInfo.getNumber();
		messages[2] = acceptTime;
		String address = "";
		if(orderInfo.getjAddrType() != 4){
			address = orderInfo.getjAddrName();
		}else{
			address = orderInfo.getjAddress();
		}
		messages[3] = orderInfo.getjTreePath().replace(",", "")+address;
		if(orderInfo.getdAddrType() != 4){
			address = orderInfo.getdAddrName();
		}else{
			address = orderInfo.getdAddress();
		}
		messages[4] = orderInfo.getdTreePath().replace(",", "")+address;
		messages[5] = orderInfo.getDeliverDate();
		messages[6] = Constants.QBT_KF_TEL;
		return messages;
	}
	
	public static String[] createM_162523D(OrderInfo orderInfo, String acceptTime) {
		String[] messages = new String[7];
		messages[0] = orderInfo.getdContact();
		messages[1] = orderInfo.getNumber();
		messages[2] = acceptTime;
		String address = "";
		if(orderInfo.getjAddrType() != 4){
			address = orderInfo.getjAddrName();
		}else{
			address = orderInfo.getjAddress();
		}
		messages[3] = orderInfo.getjTreePath().replace(",", "")+address;
		if(orderInfo.getdAddrType() != 4){
			address = orderInfo.getdAddrName();
		}else{
			address = orderInfo.getdAddress();
		}
		messages[4] = orderInfo.getdTreePath().replace(",", "")+address;
		messages[5] = orderInfo.getDeliverDate();
		messages[6] = Constants.QBT_KF_TEL;
		return messages;
	}
	
	public static String[] createM_162525J(OrderInfo orderInfo){
		String address = "";
		if(orderInfo.getdAddrType() != 4){
			address = orderInfo.getdAddrName();
		}else{
			address = orderInfo.getdAddress();
		}
		String[] msgs = new String[4];
		msgs[0] = orderInfo.getjContact();
		msgs[1] = orderInfo.getNumber();
		msgs[2] = address;
		msgs[3] = Constants.QBT_KF_TEL;
		return msgs;
	}
	
	public static String[] createM_162525D(OrderInfo orderInfo){
		String address = "";
		if(orderInfo.getdAddrType() != 4){
			address = orderInfo.getdAddrName();
		}else{
			address = orderInfo.getdAddress();
		}
		String[] msgs = new String[4];
		msgs[0] = orderInfo.getdContact();
		msgs[1] = orderInfo.getNumber();
		msgs[2] = address;
		msgs[3] = Constants.QBT_KF_TEL;
		return msgs;
	}
	
	public static String[] createM_162527J(OrderInfo orderInfo) {
		String[] msgs = new String[7];
		msgs[0] = orderInfo.getjContact();
		msgs[1] = orderInfo.getNumber();
		msgs[2] = DateUtil.formatDate(orderInfo.getSendSfUserTime(),DateUtil.DATE_TIME_FORMAT_01);
		msgs[3] = getJInfo(orderInfo);
		msgs[4] = getdInfo(orderInfo);
		msgs[5] = orderInfo.getDeliverDate();
		msgs[6] = Constants.QBT_KF_TEL;
		return msgs;
	}
	
	public static String[] createM_162527D(OrderInfo orderInfo) {
		String[] msgs = new String[7];
		msgs[0] = orderInfo.getdContact();
		msgs[1] = orderInfo.getNumber();
		msgs[2] = DateUtil.formatDate(orderInfo.getSendSfUserTime(),DateUtil.DATE_TIME_FORMAT_01);
		msgs[3] = getJInfo(orderInfo);
		msgs[4] = getdInfo(orderInfo);
		msgs[5] = orderInfo.getDeliverDate();
		msgs[6] = Constants.QBT_KF_TEL;
		return msgs;
	}
	
	private static String getOrderNumber(OrderInfo orderInfo){
		return orderInfo.getNumber();
	}
	private static String getOrderPayTime(OrderInfo orderInfo){
		return DateUtil.formatDate(orderInfo.getPayTime(),DateUtil.DATE_TIME_FORMAT_01);
	}
	private static String getSendSfUserTime(OrderInfo orderInfo){
		return DateUtil.formatDate(orderInfo.getSendSfUserTime(),DateUtil.DATE_TIME_FORMAT_01);
	}
	
	public static String getJInfo(OrderInfo orderInfo){
		StringBuilder msgsb = new StringBuilder(orderInfo.getjContact()).append("，");
		msgsb.append(orderInfo.getjMobile()).append("，");
		msgsb.append(orderInfo.getjTreePath().replace(",", ""));
		if(orderInfo.getjAddrType() != 4){
			msgsb.append(orderInfo.getjAddrName());
		}else{
			msgsb.append(orderInfo.getjAddress());
		}
		return msgsb.toString();
	}
	
	public static String getdInfo(OrderInfo orderInfo){
		StringBuilder msgsb = new StringBuilder(orderInfo.getdContact()).append("，");
		msgsb.append(orderInfo.getdMobile()).append("，");
		msgsb.append(orderInfo.getdTreePath().replace(",", ""));
		if(orderInfo.getdAddrType() != 4){
			msgsb.append(orderInfo.getdAddrName());
		}else{
			msgsb.append(orderInfo.getdAddress());
		}
		return msgsb.toString();
	}

	public static String getdInfo2(OrderInfo orderInfo){
		StringBuilder msgsb = new StringBuilder(orderInfo.getNumber()).append("，");
		msgsb.append("送包信息:" + orderInfo.getdContact()).append("，");
		msgsb.append(orderInfo.getdMobile()).append("，");
		if(orderInfo.getdAddrType().equals(1)){
			//球场
			msgsb.append(orderInfo.getdAddrName()).append("，");
		}else{
			String provinces = orderInfo.getdTreePath().replaceAll(",", "");
			msgsb.append(provinces + orderInfo.getdAddress()).append("，");
		}
		
		if(ExpressTypeEnum.after_tomorow.getType().equals(orderInfo.getExpressType())){
			long days = DateUtil.getDiffDaysForDay(
					orderInfo.getSendSfUserTime(), 
					DateUtil.str2Date(orderInfo.getDeliverDate(), DateUtil.DATE_TIME_FORMAT_01)
					);
			msgsb.append("预计到达时间:" +days+"天后");
		}else{
			msgsb.append("预计到达时间:" + orderInfo.getDeliverDate());
		}
		
		return msgsb.toString();
	}
	
	public static String getdInfo3(OrderInfo orderInfo){
		StringBuilder msgsb = new StringBuilder(orderInfo.getNumber()).append("，");
		
		if(ExpressTypeEnum.after_tomorow.getType().equals(orderInfo.getExpressType())){
			long days = DateUtil.getDiffDaysForDay(
					orderInfo.getSendSfUserTime(), 
					DateUtil.str2Date(orderInfo.getDeliverDate(), DateUtil.DATE_TIME_FORMAT_01)
					);
			msgsb.append("预计到达时间:" +days+"天后");
		}else{
			msgsb.append("预计到达时间:" + orderInfo.getDeliverDate());
		}
		return msgsb.toString();
	}
	
	public static String[] createM_176720J(OrderInfo orderInfo) {
		String[] msgs = new String[6];
		msgs[0] = orderInfo.getjContact();
		msgs[1] = "测距仪、防晒霜、化妆品";
		if(orderInfo.getjAddrType().equals(1)){
			//球场
			msgs[2] = "请将球包交给球场前台，告知前台届时由球包通顺丰寄走。您无需等候";
		}else if(orderInfo.getjAddress().contains("酒店")){
			//酒店
			msgs[2] = "请将球包交给酒店礼宾部，告知礼宾部届时由球包通顺丰寄走。您无需等候";
		}else{
			msgs[2] = "（提示：取件地点为酒店，请将球包交给酒店礼宾部，告知礼宾部届时由球包通顺丰寄走。您无需等候）";
		}
		msgs[3] = getdInfo2(orderInfo);
		msgs[4] = "球包动态请关注「球包通」微信公众号或访问www.qiubaotong.com/track.html 网页查询";
		msgs[5] = "客服（服务时间：7：00至21：00）：" + Constants.QBT_KF_TEL;
		return msgs;
	}
	
	public static String[] createM_176721D(OrderInfo orderInfo) {
		String[] msgs = new String[4];
		msgs[0] = orderInfo.getdContact();
		msgs[1] = "球包动态请关注「球包通」微信公众号或访问www.qiubaotong.com/track.html 网页查询";
		msgs[2] = getdInfo3(orderInfo);
		msgs[3] = "客服（服务时间：7：00至21：00）：" + Constants.QBT_KF_TEL;
		return msgs;
	}

	public static String[] createM_176723J(OrderInfo orderInfo) {
		String[] msgs = new String[5];
		msgs[0] = orderInfo.getjContact();
		if(orderInfo.getdAddrType().equals(1)){
			//球场
			msgs[1] = "球场前台";
		}else if(orderInfo.getdAddress().contains("酒店")){
			//酒店
			msgs[1] = "酒店礼宾部";
		}else{
			msgs[1] = "目的地（提示：目的地为酒店的客户请至酒店礼宾部领取）";
		}
		msgs[2] = orderInfo.getNumber();
		msgs[3] = "客服（服务时间：7：00至21：00）：" + Constants.QBT_KF_TEL;
		msgs[4] = "了解更多信息请关注「球包通」微信公众号";
		return msgs;
	}

	public static String[] createM_176723D(OrderInfo orderInfo) {
		String[] msgs = new String[5];
		msgs[0] = orderInfo.getdContact();
		if(orderInfo.getdAddrType().equals(1)){
			//球场
			msgs[1] = "球场前台";
		}else if(orderInfo.getdAddress().contains("酒店")){
			//酒店
			msgs[1] = "酒店礼宾部";
		}else{
			msgs[1] = "目的地（提示：目的地为酒店的客户请至酒店礼宾部领取）";
		}
		msgs[2] = orderInfo.getNumber();
		msgs[3] = "客服（服务时间：7：00至21：00）：" + Constants.QBT_KF_TEL;
		msgs[4] = "了解更多信息请关注「球包通」微信公众号";
		return msgs;
	}

	public static String[] createM_176724J(OrderInfo orderInfo) {
		String[] msgs = new String[4];
		msgs[0] = orderInfo.getjContact();
		msgs[1] = orderInfo.getNumber();
		msgs[2] = "客服（服务时间：7：00至21：00）：" + Constants.QBT_KF_TEL;
		msgs[3] = "了解更多信息请关注「球包通」微信公众号";
		return msgs;
	}

	public static String[] createM_176724D(OrderInfo orderInfo) {
		String[] msgs = new String[4];
		msgs[0] = orderInfo.getdContact();
		msgs[1] = orderInfo.getNumber();
		msgs[2] = "客服（服务时间：7：00至21：00）：" + Constants.QBT_KF_TEL;
		msgs[3] = "了解更多信息请关注「球包通」微信公众号";
		return msgs;
	}
	
	public static String[] createM_176726(String userName) {
		String[] msgs = new String[3];
		msgs[0] = userName;
		msgs[1] = "优惠劵";
		msgs[2] = "发送至您的个人中心";
		return msgs;
	}
	
	public static String createM_70670(OrderExceptionBook exceptionBook){
		StringBuilder msgsb = new StringBuilder("系统预警通知--");
		msgsb.append("订单号：").append(exceptionBook.getOrderNumber()).append("; ");
		msgsb.append("原因：").append(exceptionBook.getDescription()).append("; ");
		msgsb.append("请客服到后台管理查看处理");
		return msgsb.toString();
	}
	
	public static String[] createM_162528(UserProxy userProxy){
		String[] msgs = new String[2];
		msgs[0] = userProxy.getName();
		msgs[1] = Constants.QBT_KF_TEL;
		return msgs;
	}
	
	public static String[] createM_164216(SaleUser saleUser, UserProxy userProxy, OrderInfo orderInfo){
		String[] msgs = new String[4];
		msgs[0] = saleUser.getName();
		msgs[1] = userProxy.getName() + " " + userProxy.getMobile() + "\n";
		msgs[2] = Constants.QBT_KF_TEL;
		msgs[3] = "\n" + "寄包信息:" + getJInfo(orderInfo) + "\n" 
				+ "取包时间:" + orderInfo.getSendTimeSection() + "\n" 
				+ "收包信息：" + getdInfo(orderInfo) + "\n"
				+ "预计到达：" + orderInfo.getDeliverDate();
		return msgs;
	}
	
	public static String[] createM_190132(OrderInfo orderInfo,UserCouponActivity uca) {
		String[] msgs = new String[4];
		msgs[0] = uca.getUserName();
		msgs[1] = orderInfo.getId()+"";
		msgs[2] = "系统赠送给你的"+uca.getName()+",现已到账且生效，可以在下次下单时使用。";
		msgs[3] = Constants.QBT_KF_TEL ;
		return msgs;
	}
	
	public static String[] createM_176725J(OrderInfo before, OrderInfo after) {
		String[] msgs = new String[6];
		msgs[0] = after.getjContact();
		msgs[1] = after.getNumber();
		msgs[2] = getJInfoAddress(before)+"---"+ getdInfoAddress(before);
		msgs[3] = getJInfoAddress(after)+"---"+ getdInfoAddress(after);
		msgs[4] = "客服（服务时间：7：00至21：00）：" + Constants.QBT_KF_TEL;
		msgs[5] = "了解更多信息请关注「球包通」微信公众号";
		return msgs;
	}

	public static String[] createM_176725D(OrderInfo before, OrderInfo after) {
		String[] msgs = new String[6];
		msgs[0] = after.getdContact();
		msgs[1] = after.getNumber();
		msgs[2] = getJInfoAddress(before)+"---"+ getdInfoAddress(before);
		msgs[3] = getJInfoAddress(after)+"---"+ getdInfoAddress(after);
		msgs[4] = "客服（服务时间：7：00至21：00）：" + Constants.QBT_KF_TEL;
		msgs[5] = "了解更多信息请关注「球包通」微信公众号";
		return msgs;
	}
	
	public static String getJInfoAddress(OrderInfo orderInfo){
		StringBuilder msgsb = new StringBuilder();
		msgsb.append(orderInfo.getjTreePath().replace(",", ""));
		if(orderInfo.getjAddrType() != 4){
			msgsb.append(orderInfo.getjAddrName());
		}else{
			msgsb.append(orderInfo.getjAddress());
		}
		return msgsb.toString();
	}
	
	public static String getdInfoAddress(OrderInfo orderInfo){
		StringBuilder msgsb = new StringBuilder();
		msgsb.append(orderInfo.getdTreePath().replace(",", ""));
		if(orderInfo.getdAddrType() != 4){
			msgsb.append(orderInfo.getdAddrName());
		}else{
			msgsb.append(orderInfo.getdAddress());
		}
		return msgsb.toString();
	}
}
