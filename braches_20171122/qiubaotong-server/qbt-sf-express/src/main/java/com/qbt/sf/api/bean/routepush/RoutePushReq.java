/**
 * @Title: RouteReq.java
 * @Package com.qbt.sf.api.bean.route
 * @Description: TODO
 * Copyright:2016 F-Road All Rights Reserved   
 * Company:f-road.com.cn
 * 
 * @creater froad-win10 2016年8月4日
 * @version V1.0
**/

package com.qbt.sf.api.bean.routepush;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

 /**
  * @ClassName: RouteReq
  * @Description: TODO
  * @author froad-win10 2016年8月4日
  * @modify froad-win10 2016年8月4日
 */
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement(name = "Request") 
@XmlType(propOrder = {})  
public class RoutePushReq {
	@XmlAttribute
    private String service="RoutePushService";

	@XmlAttribute
    private String lang="zh-CN";
	
	@XmlElement  (name="Head")
    private String head;
    
	@XmlElementWrapper(name="Body")
	@XmlElement(name="WaybillRoute")
	private List<RoutePushReqDeliver> deliverRoute;

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public List<RoutePushReqDeliver> getDeliverRoute() {
		return deliverRoute;
	}

	public void setDeliverRoute(List<RoutePushReqDeliver> deliverRoute) {
		this.deliverRoute = deliverRoute;
	}
	
}
