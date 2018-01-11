/**
 * Project Name:qbt-shansong
 * File Name:OrderCancelResult.java
 * Package Name:com.qbt.shansong.entity.ordercancel
 * Date:2017年2月24日上午11:13:04
 *
*/

package com.qbt.shansong.entity.ordercancel;
/**
 * ClassName:OrderCancelResult
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月24日 上午11:13:04
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class OrderCancelResult {
	
	//是否扣费(0-否 1-是)
	private Integer isCharge;
	
	//扣费金额(单位:分)
	private Double amount;

	public Integer getIsCharge() {
		return isCharge;
	}

	public void setIsCharge(Integer isCharge) {
		this.isCharge = isCharge;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
}
