package com.qbt.sf.api.bean.identity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.qbt.sf.api.bean.RespErr;
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement(name = "Response") 
@XmlType(propOrder = {}) 
public class IdentitySearchResp {
	 @XmlAttribute
    private String  service="IdentitySearchService";
    
    @XmlElement(name="Head")
    private String  head;
    
    
    @XmlElement(name="Body")
    private IdentitySearchResqBody body;
    
    
    @XmlElement(name="ERROR")
    private IdentitySearchRespErr error;


	@Override
	public String toString() {
		return "IdentitySearchResp [service=" + service + ", head=" + head
				+ ", body=" + body + ", error=" + error + "]";
	}


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


	public IdentitySearchResqBody getBody() {
		return body;
	}


	public void setBody(IdentitySearchResqBody body) {
		this.body = body;
	}


	public IdentitySearchRespErr getError() {
		return error;
	}


	public void setError(IdentitySearchRespErr error) {
		this.error = error;
	}
}
