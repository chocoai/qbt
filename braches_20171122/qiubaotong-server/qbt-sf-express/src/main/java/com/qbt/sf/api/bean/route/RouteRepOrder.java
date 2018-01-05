package com.qbt.sf.api.bean.route;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {}) 
public class RouteRepOrder {
	
	@XmlAttribute(name="tracking_type")
    private int tracking_type;
	
	@XmlAttribute(name="tracking_number")
	private String tracking_number;
	
	@XmlAttribute(name="method_type")
	private String method_type ;

	public int getTracking_type() {
		return tracking_type;
	}

	public void setTracking_type(int tracking_type) {
		this.tracking_type = tracking_type;
	}

	public String getTracking_number() {
		return tracking_number;
	}

	public void setTracking_number(String tracking_number) {
		this.tracking_number = tracking_number;
	}

	public String getMethod_type() {
		return method_type;
	}

	public void setMethod_type(String method_type) {
		this.method_type = method_type;
	}
	
}
