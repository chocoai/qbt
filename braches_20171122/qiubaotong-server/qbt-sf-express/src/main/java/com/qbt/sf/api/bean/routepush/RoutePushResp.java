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

package com.qbt.sf.api.bean.routepush;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.qbt.sf.api.bean.RespErr;

 /**
  * @ClassName: RouteResp
  * @Description: TODO
  * @author froad-win10 2016年8月4日
  * @modify froad-win10 2016年8月4日
 */

@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement(name = "Response") 
@XmlType(propOrder = {})  
public class RoutePushResp {
	@XmlAttribute
    private String  service="RoutePushService";
    
    @XmlElement(name="Head")
    private String  head = "OK";
    
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
}
