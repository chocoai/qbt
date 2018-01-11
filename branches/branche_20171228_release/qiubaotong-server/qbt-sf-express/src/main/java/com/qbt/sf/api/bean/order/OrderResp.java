/**
 * @Title: OrderServiceRequestApi.java
 * @Package com.froad.iamp.xml2bean
 * @Description: TODO
 * Copyright:2016 F-Road All Rights Reserved   
 * Company:f-road.com.cn
 * 
 * @creater froad-win10 2016�?8�?3�?
 * @version V1.0
**/

package com.qbt.sf.api.bean.order;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.qbt.sf.api.bean.RespErr;

/**
  * @ClassName: OrderResp
  * @Description: TODO
  * @author win10 2016年8月5日
  * @modify win10 2016年8月5日
 */
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement(name = "Response") 
@XmlType(propOrder = {})  
public class OrderResp { 
    @XmlAttribute
    private String  service="OrderService";
    
    
    @XmlElement(name="Head")
    private String  head;
    
    
    @XmlElementWrapper(name="Body")
	@XmlElement(name="OrderResponse")
    private List<OrderRespDeliver> deliverOrder;
    
    
    @XmlElement(name="ERROR")
    private RespErr error;


	public String getService() {
		return service;
	}


	public void setService(String service) {
		this.service = service;
	}


	public String getHead() {
		return head;
	}


	public void setHead(String head) {
		this.head = head;
	}

	

	public RespErr getError() {
		return error;
	}


	public void setError(RespErr error) {
		this.error = error;
	}

    
	

	@Override
	public String toString() {
		return "OrderResp [service=" + service + ", head=" + head + ", error=" + error + "]";
	}


	public List<OrderRespDeliver> getDeliverOrder() {
		return deliverOrder;
	}


	public void setDeliverOrder(List<OrderRespDeliver> deliverOrder) {
		this.deliverOrder = deliverOrder;
	}

   
}
