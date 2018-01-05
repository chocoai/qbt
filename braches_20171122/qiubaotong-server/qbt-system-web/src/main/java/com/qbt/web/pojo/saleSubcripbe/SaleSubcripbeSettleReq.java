/**
 * Project Name:qbt-system-web
 * File Name:SaleOrderSettleReq.java
 * Package Name:com.qbt.web.pojo.saleOrderInfo
 * Date:2017年2月8日下午5:06:22
 *
*/

package com.qbt.web.pojo.saleSubcripbe;

import java.util.Date;

import javax.validation.constraints.NotNull;

/**
 * ClassName:SaleOrderSettleReq
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月8日 下午5:06:22
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class SaleSubcripbeSettleReq {
	
	private Date startDate;
	
	private Date endDate;
	
	@NotNull(message = "销售人员Id不能为空")
	private Integer saleId;
	
	private Integer settleMethod;
	
	private String remark;

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

	public Integer getSaleId() {
		return saleId;
	}

	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}

	public Integer getSettleMethod() {
		return settleMethod;
	}

	public void setSettleMethod(Integer settleMethod) {
		this.settleMethod = settleMethod;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
