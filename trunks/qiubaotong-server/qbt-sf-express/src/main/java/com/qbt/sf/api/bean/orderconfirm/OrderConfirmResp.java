package com.qbt.sf.api.bean.orderconfirm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement(name = "Response") 
@XmlType(propOrder = {})  
public class OrderConfirmResp {
	  @XmlAttribute
	    private String  service="OrderConfirmService";
	    
	    
	    @XmlElement(name="Head")
	    private String  head;
	    
	    @XmlElement(name="Body")
	    private OrderConfirmResqBody body;
	    
	    
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

		public OrderConfirmResqBody getBody() {
			return body;
		}


		public void setBody(OrderConfirmResqBody body) {
			this.body = body;
		}


		public OrderConfirmRespErr getError() {
			return error;
		}


		public void setError(OrderConfirmRespErr error) {
			this.error = error;
		}

}
