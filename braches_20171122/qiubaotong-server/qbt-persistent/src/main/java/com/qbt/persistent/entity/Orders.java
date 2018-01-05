package com.qbt.persistent.entity;

import java.util.Date;

import com.qbt.common.entity.BaseEntity;

public class Orders extends BaseEntity{

    private Integer userId;

    private String number;
    
    private String subNumber;

    private Date payTime;

    private Integer payMethod;

    private Integer payStatus;

    private Integer orderStatus;

    private Integer quantity;

    private Boolean isHelped;

    private Boolean isDelete;

    private Date deleteTime;

    private String openId;

    private String assistantName;

    private Integer thirdType;

    private Integer thirdId;

    private String thirdName;

    private Integer orderSource;

    private String jAddrName;

    private String jContact;

    private String jMobile;

    private String jTreePath;

    private String dAddrName;

    private String dContact;

    private String dMobile;

    private String dTreePath;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Integer getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean getIsHelped() {
        return isHelped;
    }

    public void setIsHelped(Boolean isHelped) {
        this.isHelped = isHelped;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getAssistantName() {
        return assistantName;
    }

    public void setAssistantName(String assistantName) {
        this.assistantName = assistantName == null ? null : assistantName.trim();
    }

    public Integer getThirdType() {
        return thirdType;
    }

    public void setThirdType(Integer thirdType) {
        this.thirdType = thirdType;
    }

    public Integer getThirdId() {
        return thirdId;
    }

    public void setThirdId(Integer thirdId) {
        this.thirdId = thirdId;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName == null ? null : thirdName.trim();
    }

    public Integer getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(Integer orderSource) {
        this.orderSource = orderSource;
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

    public String getjTreePath() {
        return jTreePath;
    }

    public void setjTreePath(String jTreePath) {
        this.jTreePath = jTreePath == null ? null : jTreePath.trim();
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

    public String getdTreePath() {
        return dTreePath;
    }

    public void setdTreePath(String dTreePath) {
        this.dTreePath = dTreePath == null ? null : dTreePath.trim();
    }

	public String getSubNumber() {
		return subNumber;
	}

	public void setSubNumber(String subNumber) {
		this.subNumber = subNumber;
	}
}