/**
 * Project Name:qbt-shansong
 * File Name:OrderCalcResult.java
 * Package Name:com.qbt.shansong.entity.ordercalc
 * Date:2017年2月23日下午3:15:13
 *
*/

package com.qbt.shansong.entity.ordercalc;
/**
 * ClassName:OrderCalcResult
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月23日 下午3:15:13
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class OrderCalcResult {
	
	//金额(单位: 分)
	private Double amount;
	
	//距离(单位:米)
	private Double distance;
	
	//重量(单位:公斤)
	private Double weight;
	
	//优惠金额(单位:分)
	private Double cutAmount;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getCutAmount() {
		return cutAmount;
	}

	public void setCutAmount(Double cutAmount) {
		this.cutAmount = cutAmount;
	}
	
}
