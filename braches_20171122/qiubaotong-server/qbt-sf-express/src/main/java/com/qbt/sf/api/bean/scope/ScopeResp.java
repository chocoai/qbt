/**
 * @Title: ScopeResp.java
 * @Package com.qbt.sf.api.bean.scope
 * @Description: TODO
 * Copyright:2016 F-Road All Rights Reserved   
 * Company:f-road.com.cn
 * 
 * @creater froad-win10 2016年8月4日
 * @version V1.0
**/

package com.qbt.sf.api.bean.scope;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

 /**
  * @ClassName: ScopeResp
  * @Description: TODO
  * @author froad-win10 2016年8月4日
  * @modify froad-win10 2016年8月4日
 */
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement(name = "Response") 
@XmlType(propOrder = {})  
public class ScopeResp {

	@XmlAttribute
    private String  service="ScopeService";

	@XmlElement(name="Head")
    private String  head;
    
    @XmlElement(name="Body")
    private ScopeRespBody body;
    
    @XmlElement(name="ERROR")
    private ScopeRespErr error;
    
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

	public ScopeRespBody getBody() {
		return body;
	}

	public void setBody(ScopeRespBody body) {
		this.body = body;
	}

	public ScopeRespErr getError() {
		return error;
	}

	public void setError(ScopeRespErr error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "ScopeResp [service=" + service + ", head=" + head + ", body="
				+ body + ", error=" + error + "]";
	}
}
