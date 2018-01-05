package com.qbt.sf.api.bean.orderconfirm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {}) 
public class OrderConfirmRespDeliver {
	@XmlAttribute(name="orderid")
	private String orderid;
	@XmlAttribute(name="mailno")
	private String mailno;
	
	
	@XmlElement(name = "Route")
	private Route route;
	/*@XmlAttribute(name="res_status")
	private int res_status;*/
	
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
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
	/*public int getRes_status() {
		return res_status;
	}
	public void setRes_status(int res_status) {
		this.res_status = res_status;
	}*/
	@Override
	public String toString() {
		return "OrderConfirmRespDeliver [orderid=" + orderid + ", mailno="
				+ mailno + ", route=" + route + "]";
	}
}



	
	