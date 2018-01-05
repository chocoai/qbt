package com.qbt.sf.api.bean.ordersearch;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
/**
 * @ClassName: OrderReq
 * @Description: TODO
 * @author froad-win10 2016年8月4日
 * @modify froad-win10 2016年8月4日
*/
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement(name = "Request") 
@XmlType(propOrder = {}) 
public class OrderSearchResp {
	  @XmlAttribute
	    private String service="OrderSearchService";
	    
	    @XmlAttribute
	    private String lang="zh-CN";
	    
	    @XmlElement  (name="Head")
	    private String head;
	    
	    @XmlElement(name="Body")
	    private OrderSearchResqBody body;
	    
	    @XmlElement(name="ERROR")
	    private OrderSearchRespErr error;
	    
	    public OrderSearchRespErr getError() {
			return error;
		}

		public void setError(OrderSearchRespErr error) {
			this.error = error;
		}

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

		public OrderSearchResqBody getBody() {
			return body;
		}

		public void setBody(OrderSearchResqBody body) {
			this.body = body;
		}

		@Override
		public String toString() {
			return "OrderSearchResp [service=" + service + ", lang=" + lang
					+ ", head=" + head + ", body=" + body + ", error=" + error
					+ "]";
		}

		

}
