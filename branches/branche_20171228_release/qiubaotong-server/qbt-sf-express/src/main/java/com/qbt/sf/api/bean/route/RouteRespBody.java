package com.qbt.sf.api.bean.route;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {})
public class RouteRespBody {
	
	@XmlElement(name="RouteResponse")
	private RouteRespDeliver deliverRoute;

	public RouteRespDeliver getDeliverRoute() {
		return deliverRoute;
	}

	public void setDeliverRoute(RouteRespDeliver deliverRoute) {
		this.deliverRoute = deliverRoute;
	}
	
}
	
	