package com.qbt.persistent.entity;

import java.util.Date;

public class OrderWaybill {
	
	//id
    private Integer id;
    
    //订单ID
    private Integer orderId;
    
    //运单号码，从路由推送而来
    private String mailNo;
    
    //sf订单号码，从路由推送而来
    private String sfId;
    
    //路由节点产生的时间,格式:YYYY- MM-DD HH24:MM:SS,示例:2012-7- 30 09:30:00
    private Date acceptTime;
    
    //路由节点发生的城市
    private String acceptAddress;
    
    //路由节点具体描述
    private String remark;
    
    //路由节点操作码
    private String opCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getMailNo() {
        return mailNo;
    }

    public void setMailNo(String mailNo) {
        this.mailNo = mailNo == null ? null : mailNo.trim();
    }

    public String getSfId() {
        return sfId;
    }

    public void setSfId(String sfId) {
        this.sfId = sfId == null ? null : sfId.trim();
    }

    public Date getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(Date acceptTime) {
        this.acceptTime = acceptTime;
    }

    public String getAcceptAddress() {
        return acceptAddress;
    }

    public void setAcceptAddress(String acceptAddress) {
        this.acceptAddress = acceptAddress == null ? null : acceptAddress.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getOpCode() {
        return opCode;
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode == null ? null : opCode.trim();
    }
}