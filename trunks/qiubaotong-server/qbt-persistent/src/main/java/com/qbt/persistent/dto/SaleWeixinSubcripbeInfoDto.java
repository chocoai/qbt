/**
 * Project Name:qbt-persistent
 * File Name:SaleWeixinSubcripbeInfoDto.java
 * Package Name:com.qbt.persistent.dto
 * Date:2017年2月8日下午4:49:13
 *
*/

package com.qbt.persistent.dto;

import java.util.Date;

import com.qbt.persistent.entity.SaleWeixinSubcripbeInfo;

/**
 * ClassName:SaleWeixinSubcripbeInfoDto
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月8日 下午4:49:13
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class SaleWeixinSubcripbeInfoDto extends SaleWeixinSubcripbeInfo {
	
	private Date startDate;
	
	private Date endDate;
	
	private Integer settleNumber;
	
	private Double settleAmount;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getSettleNumber() {
		return settleNumber;
	}

	public void setSettleNumber(Integer settleNumber) {
		this.settleNumber = settleNumber;
	}

	public Double getSettleAmount() {
		return settleAmount;
	}

	public void setSettleAmount(Double settleAmount) {
		this.settleAmount = settleAmount;
	}
	
}
