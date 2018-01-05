package com.qbt.web.pojo.vipOrder;

import java.math.BigDecimal;
import java.util.Date;

public class VipOrderVo {	

	private int id;

    private Date createTime;

    private Date updateTime;

    private String number;

    private String vipNo;

    private Integer userId;

    private BigDecimal payAmount;

    private Integer payMethod;

    private String name;

    private String userName;

    private String mobile;

    private String validDesc;

    private Integer valid;

    private Integer settlementStatus;

    private Integer payId;

    private String payNumber;

    private String payBakNo;

    private Integer vipTypeId;
    
    // '1-电子卡 2-实体卡'
    private Integer vipCardType;
    
    //销售人员
    private String salesmanName;
    
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

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public BigDecimal getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	public Integer getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(Integer payMethod) {
		this.payMethod = payMethod;
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

	public String getValidDesc() {
		return validDesc;
	}

	public void setValidDesc(String validDesc) {
		this.validDesc = validDesc;
	}

	public Integer getValid() {
		return valid;
	}

	public void setValid(Integer valid) {
		this.valid = valid;
	}

	public Integer getSettlementStatus() {
		return settlementStatus;
	}

	public void setSettlementStatus(Integer settlementStatus) {
		this.settlementStatus = settlementStatus;
	}

	public Integer getPayId() {
		return payId;
	}

	public void setPayId(Integer payId) {
		this.payId = payId;
	}

	public String getPayNumber() {
		return payNumber;
	}

	public void setPayNumber(String payNumber) {
		this.payNumber = payNumber;
	}

	public String getPayBakNo() {
		return payBakNo;
	}

	public void setPayBakNo(String payBakNo) {
		this.payBakNo = payBakNo;
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

	public Integer getVipCardType() {
		return vipCardType;
	}

	public void setVipCardType(Integer vipCardType) {
		this.vipCardType = vipCardType;
	}

	public String getSalesmanName() {
		return salesmanName;
	}

	public void setSalesmanName(String salesmanName) {
		this.salesmanName = salesmanName;
	}
	
    
    
}
