package com.qbt.persistent.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.qbt.common.entity.BaseEntity;

public class VipOrder extends BaseEntity {
	
	 /**
	 * @Fields serialVersionUID : TODO
	 */
	
	private static final long serialVersionUID = 1L;
	//订单号
    private String number;
	//会员卡号
    private String vipNo;
	//用户ID
    private Integer userId;
	//支付金额
    private Double payAmount;
	//支付方式表，1-微信支付 2-boss购买
    private Integer payMethod;
	//会员卡名称
    private String name;
	//用户名	
    private String userName;
	//手机号
    private String mobile;
	//有效期描述
    private String validDesc;
	//有效期，单位天
    private Integer valid;
	//1-已收款 2-未收款
    private Integer settlementStatus;
	//支付流水号
    private Integer payId;
	//商户支付流水号
    private String payNumber;
	//第三方支付流水号
    private String payBakNo;
    
    private Integer vipTypeId;
    
    private Date startDate;
    
    private Date endDate;
    // '1-电子卡 2-实体卡'
    private Integer vipCardType;
	
    //========================================
    private List<String> numbers;//订单编号集合
    
    private Integer cardSellStatus;//vip卡销售状态 1-未售  2-已售
    
    private String salesmanName;//销售人员名称
    
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getVipNo() {
        return vipNo;
    }

    public void setVipNo(String vipNo) {
        this.vipNo = vipNo == null ? null : vipNo.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Double payAmount) {
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
        this.name = name == null ? null : name.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getValidDesc() {
        return validDesc;
    }

    public void setValidDesc(String validDesc) {
        this.validDesc = validDesc == null ? null : validDesc.trim();
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
        this.payNumber = payNumber == null ? null : payNumber.trim();
    }

    public String getPayBakNo() {
        return payBakNo;
    }

    public void setPayBakNo(String payBakNo) {
        this.payBakNo = payBakNo == null ? null : payBakNo.trim();
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

	public List<String> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<String> numbers) {
		this.numbers = numbers;
	}

	public Integer getCardSellStatus() {
		return cardSellStatus;
	}

	public void setCardSellStatus(Integer cardSellStatus) {
		this.cardSellStatus = cardSellStatus;
	}

	public String getSalesmanName() {
		return salesmanName;
	}

	public void setSalesmanName(String salesmanName) {
		this.salesmanName = salesmanName;
	}

}