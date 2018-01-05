package com.qbt.sf.api.bean.route;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.qbt.sf.api.bean.orderconfirm.Route;
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {}) 
public class RouteRespDeliver {
	
	@XmlAttribute(name="orderid")
	private String orderid;
	
	@XmlAttribute(name="mailno")
	private String mailno;
	
	@XmlElement(name="Route")
	private List<Route> route;

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


	public List<Route> getRoute() {
		return route;
	}


	public void setRoute(List<Route> route) {
		this.route = route;
	}

}
