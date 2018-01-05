/**
 * @Title: OrderZDReq.java
 * @Package com.qbt.sf.api.bean.orderzdservice
 * @Description: TODO
 * Copyright:2016 F-Road All Rights Reserved   
 * Company:f-road.com.cn
 * 
 * @creater froad-win10 2016年8月4日
 * @version V1.0
**/

package com.qbt.sf.api.bean.orderzd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

 /**
  * @ClassName: OrderZDReq
  * @Description: TODO
  * @author froad-win10 2016年8月4日
  * @modify froad-win10 2016年8月4日
 */
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {}) 
public class OrderZDReqDeliver {
	@XmlAttribute(name="orderid")
	private String  orderid;
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public int getParcel_quantity() {
		return parcel_quantity;
	}
	public void setParcel_quantity(int parcel_quantity) {
		this.parcel_quantity = parcel_quantity;
	}
	@XmlAttribute(name="parcel_quantity")
	private int parcel_quantity;

}
