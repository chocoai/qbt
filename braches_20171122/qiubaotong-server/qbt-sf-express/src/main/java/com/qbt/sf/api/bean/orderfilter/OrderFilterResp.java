package com.qbt.sf.api.bean.orderfilter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement(name = "Response") 
@XmlType(propOrder = {}) 
public class OrderFilterResp {
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

	public OrderFilterReqBody getBody() {
		return body;
	}

	public void setBody(OrderFilterReqBody body) {
		this.body = body;
	}

	public OrderFilterRespErr getError() {
		return error;
	}

	public void setError(OrderFilterRespErr error) {
		this.error = error;
	}

	@XmlAttribute
	    private String service="OrderFilteronfirmService";
	    
	    @XmlElement(name="Head")
	    private String  head;
	    
	    @XmlElement(name="Body")
	    private OrderFilterReqBody body;
	    
	    @XmlElement(name="ERROR")
	    private OrderFilterRespErr error;

}
