package com.qbt.web.pojo.vipOrder;

import java.util.Date;

import com.qbt.common.result.Paging;

public class VipOrderPageReqVo extends Paging{

	private String number;
	
	private String vipNo;
	
    private String name;
	
    private String userName;
    
    private String mobile;

	private Integer vipTypeId;
	
	private Integer vipCardType;
	//1-已收款 2-未收款
    private Integer settlementStatus;
	
	private Date startDate;
	
	private Date endDate;
	
	//销售人员
    private String salesmanName;
    
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getVipNo() {
		return vipNo;
	}

	public void setVipNo(String vipNo) {
		this.vipNo = vipNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	
	/**
	 * getter method 
	 * @Title: getVipTypeId
	 * @return the vipTypeId
	 */
	
	public Integer getVipTypeId() {
		return vipTypeId;
	}

	
	/**
	* setter method
	* @param vipTypeId the vipTypeId to set
	*/
	
	public void setVipTypeId(Integer vipTypeId) {
		this.vipTypeId = vipTypeId;
	}

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

	public Integer getVipCardType() {
		return vipCardType;
	}

	public void setVipCardType(Integer vipCardType) {
		this.vipCardType = vipCardType;
	}

	public Integer getSettlementStatus() {
		return settlementStatus;
	}

	public void setSettlementStatus(Integer settlementStatus) {
		this.settlementStatus = settlementStatus;
	}

	public String getSalesmanName() {
		return salesmanName;
	}

	public void setSalesmanName(String salesmanName) {
		this.salesmanName = salesmanName;
	}
    
    
	
}
