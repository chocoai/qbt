package com.qbt.web.pojo.orderDetail;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.qbt.common.result.Paging;

public class OrderDetailRequest extends Paging {
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	
	//是否首单：0-all 1-首单 2-不是首单
	private Integer isFirst;
	
	//偏远类型 0-非偏远 1-球场 4-地区
	private Integer outRangeType;
	
	/*
	 * 订单状态：
	 * 1-待支付 
	 * 2-支付中 
	 * 3-支付成功 
	 * 4-支付失败(可重新) 
	 * 5-订单关闭-用户取消 
	 * 6-订单关闭-系统关单 
	 * 7-订单关闭-客服取消
	 */
	private Integer orderStatus;
	
	//是否优惠：0-all 1-优惠 2-无优惠
	private Integer isFavored;
	
	//寄件类型：1-次日达 2-隔日达 5-次午达
	private String expressType;
	
	//1-普通用户  2-合作旅行社
    private Integer thirdType;
    
    //包包码
    private String bagCode;

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

	public Integer getIsFirst() {
		return isFirst;
	}

	public void setIsFirst(Integer isFirst) {
		this.isFirst = isFirst;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getIsFavored() {
		return isFavored;
	}

	public void setIsFavored(Integer isFavored) {
		this.isFavored = isFavored;
	}

	public String getExpressType() {
		return expressType;
	}

	public void setExpressType(String expressType) {
		this.expressType = expressType;
	}

	public Integer getThirdType() {
		return thirdType;
	}

	public void setThirdType(Integer thirdType) {
		this.thirdType = thirdType;
	}

	public Integer getOutRangeType() {
		return outRangeType;
	}

	public void setOutRangeType(Integer outRangeType) {
		this.outRangeType = outRangeType;
	}

	public String getBagCode() {
		return bagCode;
	}

	public void setBagCode(String bagCode) {
		this.bagCode = bagCode;
	}

}
