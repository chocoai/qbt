package com.qbt.web.pojo.activity;

public class ActivityAddReqVo extends ActivityVo {
	
	//===========================活动券==============================
    private Integer couponType = 1;//优惠券类型：1:代金券;2:折扣券;3:特价券
    
    private double amount;//代金金额|折扣|特价券金额|代金券面额
    
    private int couponCount;//生成优惠券数量

	public Integer getCouponType() {
		return couponType;
	}

	public void setCouponType(Integer couponType) {
		this.couponType = couponType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getCouponCount() {
		return couponCount;
	}

	public void setCouponCount(int couponCount) {
		this.couponCount = couponCount;
	}

}
