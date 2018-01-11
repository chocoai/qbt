package com.qbt.sf.api.bean.orderconfirm;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

import com.qbt.sf.api.bean.delivertm.DeliverTmRespDeliver;

@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {}) 
public class OrderConfirmResqBody {
	@XmlElementWrapper(name="OrderConfirmResponse")
	@XmlElement(name="OrderConfirmResponse")
	private List<OrderConfirmRespDeliver> orderConfirmRespDeliver;

	public List<OrderConfirmRespDeliver> getOrderConfirmRespDeliver() {
		return orderConfirmRespDeliver;
	}

	public void setOrderConfirmRespDeliver(
			List<OrderConfirmRespDeliver> orderConfirmRespDeliver) {
		this.orderConfirmRespDeliver = orderConfirmRespDeliver;
	}

	@Override
	public String toString() {
		return "OrderConfirmResqBody [getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}


	
	
