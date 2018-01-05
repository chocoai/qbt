
/**
* @Title: QueryFreightReq.java
* @Package com.qbt.sf.api.bean.queryfreight
* @Description: TODO
* Copyright:2016 qiubaotong All Rights Reserved   
* Company:www.qiubaotong.com
* 
* @creater win10 2016年8月5日
* @version V1.0
**/

package com.qbt.sf.api.bean.queryfreight;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.qbt.sf.api.bean.delivertm.DeliverTmReqBody;
import com.qbt.sf.api.bean.scope.ScopeReqBody;

/**
 * @ClassName: QueryFreightReq
 * @Description: TODO
 * @author win10 2016年8月5日
 * @modify win10 2016年8月5日
 */
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement(name = "Request") 
@XmlType(propOrder = {}) 
public class QueryFreightReq {
	@XmlAttribute
	private String service = "QueryFreightService";

	@XmlAttribute
	private String lang = "zh-CN";

	@XmlElement(name = "Head")
	private String head;

	@XmlElement(name = "Body")
	private QueryFreightReqBody body;

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

	public QueryFreightReqBody getBody() {
		return body;
	}

	public void setBody(QueryFreightReqBody body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "QueryFreightReq [service=" + service + ", lang=" + lang
				+ ", head=" + head + ", body=" + body + "]";
	}
	
	
}
