package com.qbt.web.pojo.coupon;

/**
 * 
 * <b>类名：</b>MyCouponsCount.java<br>
 * <p><b>标题：</b>球包通</p>
 * <p><b>描述：</b>我的优惠券数量统计类</p>
 * <p><b>版权声明：</b>Copyright (c) 2017</p>
 * <p><b>公司：</b>上海格灵科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @date  2017年4月11日 下午1:45:37
 */
public class MyCouponsCount {
	
	//未使用数量
	private int unusedCount;
	
	//已使用数量
	private int usedCount;

	//过期数量
	private int overdueCount;

	public int getUnusedCount() {
		return unusedCount;
	}

	public void setUnusedCount(int unusedCount) {
		this.unusedCount = unusedCount;
	}

	public int getUsedCount() {
		return usedCount;
	}

	public void setUsedCount(int usedCount) {
		this.usedCount = usedCount;
	}

	public int getOverdueCount() {
		return overdueCount;
	}

	public void setOverdueCount(int overdueCount) {
		this.overdueCount = overdueCount;
	}
}
