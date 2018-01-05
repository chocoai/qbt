package com.qbt.persistent.entity;

import java.util.Date;

import com.qbt.common.entity.BaseEntity;

public class OrderShoppingCart extends BaseEntity{

    private Integer userId;

    private Integer orderSource;

    private Date sendSfUserTime;

    private double freight;

    private String deliverDate;

    private String sendTimeSection;

    private double insuredValue;

    private double insuredRates;

    private double insuredFee;

    private String remark;

    private Integer jAddrType;

    private Integer jAddrId;

    private String jAddrName;

    private String jContact;

    private String jMobile;

    private Integer jAreaId;

    private String jTreePath;

    private String jAddress;

    private Integer dAddrType;

    private Integer dAddrId;

    private String dAddrName;

    private String dContact;

    private String dMobile;

    private Integer dAreaId;

    private String dTreePath;

    private String dAddress;

    private Integer quantity;
    
    private String expressType;

    private String md5;
    // 代下单用户Id
    private Integer proxyUserId = 0;
    // 满减信息
    private boolean jActivity = false;
	
	private boolean dActivity = false;
	
	private double jActivityAmount;
	
	private double dActivityAmount;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(Integer orderSource) {
        this.orderSource = orderSource;
    }

    public Date getSendSfUserTime() {
        return sendSfUserTime;
    }

    public void setSendSfUserTime(Date sendSfUserTime) {
        this.sendSfUserTime = sendSfUserTime;
    }

    public double getFreight() {
        return freight;
    }

    public void setFreight(double freight) {
        this.freight = freight;
    }

    public String getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(String deliverDate) {
        this.deliverDate = deliverDate == null ? null : deliverDate.trim();
    }

    public String getSendTimeSection() {
        return sendTimeSection;
    }

    public void setSendTimeSection(String sendTimeSection) {
        this.sendTimeSection = sendTimeSection == null ? null : sendTimeSection.trim();
    }

    public double getInsuredValue() {
        return insuredValue;
    }

    public void setInsuredValue(double insuredValue) {
        this.insuredValue = insuredValue;
    }

    public double getInsuredRates() {
        return insuredRates;
    }

    public void setInsuredRates(double insuredRates) {
        this.insuredRates = insuredRates;
    }

    public double getInsuredFee() {
        return insuredFee;
    }

    public void setInsuredFee(double insuredFee) {
        this.insuredFee = insuredFee;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getjAddrType() {
        return jAddrType;
    }

    public void setjAddrType(Integer jAddrType) {
        this.jAddrType = jAddrType;
    }

    public Integer getjAddrId() {
        return jAddrId;
    }

    public void setjAddrId(Integer jAddrId) {
        this.jAddrId = jAddrId;
    }

    public String getjAddrName() {
        return jAddrName;
    }

    public void setjAddrName(String jAddrName) {
        this.jAddrName = jAddrName == null ? null : jAddrName.trim();
    }

    public String getjContact() {
        return jContact;
    }

    public void setjContact(String jContact) {
        this.jContact = jContact == null ? null : jContact.trim();
    }

    public String getjMobile() {
        return jMobile;
    }

    public void setjMobile(String jMobile) {
        this.jMobile = jMobile == null ? null : jMobile.trim();
    }

    public Integer getjAreaId() {
        return jAreaId;
    }

    public void setjAreaId(Integer jAreaId) {
        this.jAreaId = jAreaId;
    }

    public String getjTreePath() {
        return jTreePath;
    }

    public void setjTreePath(String jTreePath) {
        this.jTreePath = jTreePath == null ? null : jTreePath.trim();
    }

    public String getjAddress() {
        return jAddress;
    }

    public void setjAddress(String jAddress) {
        this.jAddress = jAddress == null ? null : jAddress.trim();
    }

    public Integer getdAddrType() {
        return dAddrType;
    }

    public void setdAddrType(Integer dAddrType) {
        this.dAddrType = dAddrType;
    }

    public Integer getdAddrId() {
        return dAddrId;
    }

    public void setdAddrId(Integer dAddrId) {
        this.dAddrId = dAddrId;
    }

    public String getdAddrName() {
        return dAddrName;
    }

    public void setdAddrName(String dAddrName) {
        this.dAddrName = dAddrName == null ? null : dAddrName.trim();
    }

    public String getdContact() {
        return dContact;
    }

    public void setdContact(String dContact) {
        this.dContact = dContact == null ? null : dContact.trim();
    }

    public String getdMobile() {
        return dMobile;
    }

    public void setdMobile(String dMobile) {
        this.dMobile = dMobile == null ? null : dMobile.trim();
    }

    public Integer getdAreaId() {
        return dAreaId;
    }

    public void setdAreaId(Integer dAreaId) {
        this.dAreaId = dAreaId;
    }

    public String getdTreePath() {
        return dTreePath;
    }

    public void setdTreePath(String dTreePath) {
        this.dTreePath = dTreePath == null ? null : dTreePath.trim();
    }

    public String getdAddress() {
        return dAddress;
    }

    public void setdAddress(String dAddress) {
        this.dAddress = dAddress == null ? null : dAddress.trim();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5 == null ? null : md5.trim();
    }

	public String getExpressType() {
		return expressType;
	}

	public void setExpressType(String expressType) {
		this.expressType = expressType;
	}

	public boolean isjActivity() {
		return jActivity;
	}

	public void setjActivity(boolean jActivity) {
		this.jActivity = jActivity;
	}

	public boolean isdActivity() {
		return dActivity;
	}

	public void setdActivity(boolean dActivity) {
		this.dActivity = dActivity;
	}

	public double getjActivityAmount() {
		return jActivityAmount;
	}

	public void setjActivityAmount(double jActivityAmount) {
		this.jActivityAmount = jActivityAmount;
	}

	public double getdActivityAmount() {
		return dActivityAmount;
	}

	public void setdActivityAmount(double dActivityAmount) {
		this.dActivityAmount = dActivityAmount;
	}

	public Integer getProxyUserId() {
		return proxyUserId;
	}

	public void setProxyUserId(Integer proxyUserId) {
		this.proxyUserId = proxyUserId;
	}

}