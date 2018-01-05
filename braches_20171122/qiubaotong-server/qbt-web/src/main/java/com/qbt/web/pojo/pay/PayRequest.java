package com.qbt.web.pojo.pay;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.qbt.common.enums.LanguagesEnum;

public class PayRequest {
	@NotNull(message="支付订单号不能为空")
	private String orderNumber;
	// 子订单ID
	@NotNull(message="支付子订单号不能为空")
	private String[] orderId;
	// 活动ID,与子订单ID一一对应
	private int[] activityId;
	// VIP订单ID
	private List<String> vipOrderIds;
	// VIP订单ID
	private List<Integer> vipIds;
	// 券码号
	private String chidCode;
	// 券码使用类型0-无优惠券 1-用户输入 2-用户选择领用券
	@NotNull(message="支付券类型不能为空")
	private int type;
	// 支付金额
	@NotNull(message="支付金额不能为空")
	private Double payAmount;
	// 用户ID
	private int userId;
	// 微信ID
	private String openId;
	// 备注
	private String remark;
	// 下单语言版本
	private String langName = LanguagesEnum.CHINA.getValue();
	
	public String getChidCode() {
		return chidCode;
	}
	public void setChidCode(String chidCode) {
		this.chidCode = chidCode;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Double getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(Double payAmount) {
		this.payAmount = payAmount;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getLangName() {
		return langName;
	}
	public void setLangName(String langName) {
		this.langName = langName;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String[] getOrderId() {
		return orderId;
	}
	public void setOrderId(String[] orderId) {
		this.orderId = orderId;
	}
	public int[] getActivityId() {
		return activityId;
	}
	public void setActivityId(int[] activityId) {
		this.activityId = activityId;
	}
	public List<String> getVipOrderIds() {
		return vipOrderIds == null? new ArrayList<String>():vipOrderIds;
	}
	public void setVipOrderIds(List<String> vipOrderIds) {
		this.vipOrderIds = vipOrderIds;
	}
	public List<Integer> getVipIds() {
		return vipIds  == null? new ArrayList<Integer>():vipIds;
	}
	public void setVipIds(List<Integer> vipIds) {
		this.vipIds = vipIds;
	}
	
	
	
}
