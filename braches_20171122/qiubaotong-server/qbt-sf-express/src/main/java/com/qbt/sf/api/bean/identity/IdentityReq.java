/**
 * @Title: IdentityReq.java
 * @Package com.qbt.sf.api.bean.identity
 * @Description: TODO
 * Copyright:2016 F-Road All Rights Reserved   
 * Company:f-road.com.cn
 * 
 * @creater froad-win10 2016年8月4日
 * @version V1.0
**/

package com.qbt.sf.api.bean.identity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

 /**
  * @ClassName: IdentityReq
  * @Description: TODO
  * @author froad-win10 2016年8月4日
  * @modify froad-win10 2016年8月4日
 */
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement(name = "Request") 
@XmlType(propOrder = {})  
public class IdentityReq {
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
