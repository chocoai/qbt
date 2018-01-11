package com.qbt.sf.api.bean.routepush;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {}) 
public class RoutePushReqDeliver {
	@XmlAttribute(name="id")
	private String id;
	@XmlAttribute(name="orderid")
	private String orderid;
	@XmlAttribute(name="mailno")
	private String mailno;
	@XmlAttribute(name="acceptTime")
	private String acceptTime;
	@XmlAttribute(name="acceptAddress")
	private String acceptAddress;
	@XmlAttribute(name="remark")
	private String remark;
	@XmlAttribute(name="opCode")
	private String opCode;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getMailno() {
		return mailno;
	}
	public void setMailno(String mailno) {
		this.mailno = mailno;
	}
	public String getAcceptTime() {
		return acceptTime;
	}
	public void setAcceptTime(String acceptTime) {
		this.acceptTime = acceptTime;
	}
	public String getAcceptAddress() {
		return acceptAddress;
	}
	public void setAcceptAddress(String acceptAddress) {
		this.acceptAddress = acceptAddress;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getOpCode() {
		return opCode;
	}
	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}
	
}
