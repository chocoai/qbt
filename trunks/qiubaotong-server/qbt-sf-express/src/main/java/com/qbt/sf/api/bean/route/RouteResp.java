/**
 * @Title: RouteResp.java
 * @Package com.qbt.sf.api.bean.route
 * @Description: TODO
 * Copyright:2016 F-Road All Rights Reserved   
 * Company:f-road.com.cn
 * 
 * @creater froad-win10 2016年8月4日
 * @version V1.0
**/

package com.qbt.sf.api.bean.route;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.qbt.sf.api.bean.orderconfirm.OrderConfirmRespErr;

 /**
  * @ClassName: RouteResp
  * @Description: TODO
  * @author froad-win10 2016年8月4日
  * @modify froad-win10 2016年8月4日
 */

@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement(name = "Response") 
@XmlType(propOrder = {})  
public class RouteResp {
	@XmlAttribute
    private String  service="RouteService";
    
    @XmlElement(name="Head")
    private String  head;
    
    @XmlElement(name="Body")
    private RouteRespBody body;
    
    @XmlElement(name="ERROR")
    private OrderConfirmRespErr error;

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

	public OrderConfirmRespErr getError() {
		return error;
	}

	public void setError(OrderConfirmRespErr error) {
		this.error = error;
	}

	public RouteRespBody getBody() {
		return body;
	}

	public void setBody(RouteRespBody body) {
		this.body = body;
	}
	
}
