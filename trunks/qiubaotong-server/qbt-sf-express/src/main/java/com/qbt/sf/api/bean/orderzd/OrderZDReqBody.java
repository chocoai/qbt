package com.qbt.sf.api.bean.orderzd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
  * @ClassName: DeliverTmReqBody
  * @Description: TODO
  * @author win10 2016年8月5日
  * @modify win10 2016年8月5日
  */
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {}) 
public class OrderZDReqBody {
	
	 @XmlElement(name="OrderZDRequest")
	  private OrderZDReqDeliver orderZDReq;

	 public OrderZDReqDeliver getOrderZDReq() {
		return orderZDReq;
	}

	public void setOrderZDReq(OrderZDReqDeliver orderZDReq) {
		this.orderZDReq = orderZDReq;
	}
	/**
	  * @Title: toString
	  * @Description: TODO
	  * @author: win10 2016年8月5日
	  * @modify: win10 2016年8月5日
	  * @return
	  * @see java.lang.Object#toString()
	  */

	@Override
	public String toString() {
		return "OrderZDReqBody [orderZDReq=" + orderZDReq + "]";
	}
	
	

}
