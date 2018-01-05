package com.qbt.sf.api.bean.orderconfirm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {}) 
public class OrderConfirmRepOrder {
	@XmlAttribute(name="orderid")
    private String orderid;
	@XmlAttribute(name="mailno")
	private String mailno;
	@XmlAttribute(name="dealtype")
	private int dealtype;
	/*@XmlElement(name = "OrderConfirmOption")  
    private List<OrderConfirmOption> orderConfirmOptionList;*/
	@XmlElement(name = "OrderConfirmOption")
	private OrderConfirmOption orderConfirmOption;

	public OrderConfirmOption getOrderConfirmOption() {
		return orderConfirmOption;
	}

	public void setOrderConfirmOption(OrderConfirmOption orderConfirmOption) {
		this.orderConfirmOption = orderConfirmOption;
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

	public int getDealtype() {
		return dealtype;
	}

	public void setDealtype(int dealtype) {
		this.dealtype = dealtype;
	}

	@Override
	public String toString() {
		return "OrderConfirmRepOrder [orderid=" + orderid + ", mailno="
				+ mailno + ", dealtype=" + dealtype + ", orderConfirmOption="
				+ orderConfirmOption + "]";
	}

}
