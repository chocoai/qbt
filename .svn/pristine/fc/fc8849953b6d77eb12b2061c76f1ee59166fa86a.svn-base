package com.qbt.sf.api.bean.orderfilter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.qbt.sf.api.bean.orderconfirm.OrderConfirmReqBody;

/**
 * @ClassName: OrderConfirmReq
 * @Description: TODO
 * @author wuwang-win8 2016年8月4日
 * @modify wuwang-win8 2016年8月4日
*/
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement(name = "Request") 
@XmlType(propOrder = {})
public class OrderFilterReq {
	@XmlAttribute
    private String service="OrderFilterService";

	@XmlAttribute
    private String lang="zh-CN";
    
    @XmlElement  (name="Head")
    private String head;
    
    @XmlElement(name="Body")
    private OrderFilterReqBody body;

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

	public OrderFilterReqBody getBody() {
		return body;
	}

	public void setBody(OrderFilterReqBody body) {
		this.body = body;
	}
	
}
