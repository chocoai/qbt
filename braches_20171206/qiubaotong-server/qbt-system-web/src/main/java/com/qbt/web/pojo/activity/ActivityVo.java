package com.qbt.web.pojo.activity;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class ActivityVo {
	
	private int id;//id

    private Date createTime;//创建时间
    
    @NotNull(message = "活动名称不能为空")
    private String name;//活动名称
    
    private Date startTime;//券码开始时间
    
    private Date endTime;//券码结束时间
    
//    @NotNull(message = "暗码不能为空")
//    @Pattern(regexp = "[0-9a-zA-Z]{4,8}", message = "暗号为4-8位的英文字母和数字组合")
    private String code;//暗码，唯一索引(暗号为4-6位的英文字母和数字组合)
    
    private String desc;//活动描述
    
    private Integer maxPerOne = 1;//个人领取次数
    
    @NotNull(message = "活动开始时间不能为空")
    private Date activityStartTime;//活动开始时间
    
    @NotNull(message = "活动结束时间不能为空")
    private Date activityEndTime;//活动结束时间
    
    private Integer status = 1;//状态：1-正常，2-禁用
    
    private int ruleId; // 规则ID
    
    private String ruleName = "无"; // 规则name
    
    private int couponCount; // 优惠券数量
    
    private Integer type = 1; //活动类型 1-限量现金券活动 2-不限量现金券活动
    
    private double couponAmount; //券优惠金额
    
    private double couponLimitAmount; //券限额金额
    
    private int couponLimitDay; //券限制天数
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getMaxPerOne() {
		return maxPerOne;
	}

	public void setMaxPerOne(Integer maxPerOne) {
		this.maxPerOne = maxPerOne;
	}

	public Date getActivityStartTime() {
		return activityStartTime;
	}

	public void setActivityStartTime(Date activityStartTime) {
		this.activityStartTime = activityStartTime;
	}

	public Date getActivityEndTime() {
		return activityEndTime;
	}

	public void setActivityEndTime(Date activityEndTime) {
		this.activityEndTime = activityEndTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public int getRuleId() {
		return ruleId;
	}

	public void setRuleId(int ruleId) {
		this.ruleId = ruleId;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public int getCouponCount() {
		return couponCount;
	}

	public void setCouponCount(int couponCount) {
		this.couponCount = couponCount;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public double getCouponAmount() {
		return couponAmount;
	}

	public void setCouponAmount(double couponAmount) {
		this.couponAmount = couponAmount;
	}

	public double getCouponLimitAmount() {
		return couponLimitAmount;
	}

	public void setCouponLimitAmount(double couponLimitAmount) {
		this.couponLimitAmount = couponLimitAmount;
	}

	public int getCouponLimitDay() {
		return couponLimitDay;
	}

	public void setCouponLimitDay(int couponLimitDay) {
		this.couponLimitDay = couponLimitDay;
	}
    
}
