package com.qbt.persistent.dto;

public class ReportActivity {

	private String name;// 活动名称

	private String couponTime;// 券码时间

	private String activityTime;// 活动时间

	private double expireAmount;

	private double totalAmount;

	private double usedAmount;

	private double unuseAmount;

	private int totalNum;

	private int usedNum;

	private int unuseNum;

	private int expireNum;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActivityTime() {
		return activityTime;
	}

	public void setActivityTime(String activityTime) {
		this.activityTime = activityTime;
	}

	public double getExpireAmount() {
		return expireAmount;
	}

	public void setExpireAmount(double expireAmount) {
		this.expireAmount = expireAmount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getUsedAmount() {
		return usedAmount;
	}

	public void setUsedAmount(double usedAmount) {
		this.usedAmount = usedAmount;
	}

	public double getUnuseAmount() {
		return unuseAmount;
	}

	public void setUnuseAmount(double unuseAmount) {
		this.unuseAmount = unuseAmount;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public int getUsedNum() {
		return usedNum;
	}

	public void setUsedNum(int usedNum) {
		this.usedNum = usedNum;
	}

	public int getUnuseNum() {
		return unuseNum;
	}

	public void setUnuseNum(int unuseNum) {
		this.unuseNum = unuseNum;
	}

	public int getExpireNum() {
		return expireNum;
	}

	public void setExpireNum(int expireNum) {
		this.expireNum = expireNum;
	}

	public String getCouponTime() {
		return couponTime;
	}

	public void setCouponTime(String couponTime) {
		this.couponTime = couponTime;
	}

}
