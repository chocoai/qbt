package com.qbt.sf.api.bean.identity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement(name = "Request") 
@XmlType(propOrder = {})  
public class IdentitySearchReq {
	@XmlAttribute
	private String service = "IdentitySearchService";

	@XmlAttribute
	private String lang = "zh-CN";

	@XmlElement(name = "Head")
	private String head;
	
	@XmlElement(name = "Body")
	private IdentitySearchReqBody body;

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

	public IdentitySearchReqBody getBody() {
		return body;
	}

	public void setBody(IdentitySearchReqBody body) {
		this.body = body;
	}

	
}
