package com.qbt.sf.api.bean.orderfilterpush;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement(name = "Response") 
@XmlType(propOrder = {}) 
public class OrderFilterPushResp {
	@XmlAttribute
    private String service="OrderFilterPushService ";
    
    @XmlElement(name="Head")
    private String  head;
    
    @XmlElement(name="Body")
    private OrderFilterPushResqBody body;
    
    @XmlElement(name="ERROR")
    private OrderFilterPushRespErr error;
    
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
	
	public OrderFilterPushRespErr getError() {
		return error;
	}

	public void setError(OrderFilterPushRespErr error) {
		this.error = error;
	}

}
