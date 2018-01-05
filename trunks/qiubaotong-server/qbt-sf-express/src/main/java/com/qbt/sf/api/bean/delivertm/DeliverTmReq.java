/**
 * @Title: DeliverTmReq.java
 * @Package com.qbt.sf.api.bean.delivertm
 * @Description: TODO
 * Copyright:2016 F-Road All Rights Reserved   
 * Company:f-road.com.cn
 * 
 * @creater froad-win10 2016年8月4日
 * @version V1.0
**/

package com.qbt.sf.api.bean.delivertm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
  * @ClassName: DeliverTmReq
  * @Description: TODO
  * @author froad-win10 2016年8月4日
  * @modify froad-win10 2016年8月4日
 */
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement(name = "Request") 
@XmlType(propOrder = {})  
public class DeliverTmReq {
	@XmlAttribute
	private String service = "DeliverTmService";

	@XmlAttribute
	private String lang = "zh-CN";

	@XmlElement(name = "Head")
	private String head;

	@XmlElement(name = "Body")
	private DeliverTmReqBody body;
	
	/**
	 * getter method 
	 * @Title: getService
	 * @return the service
	 */
	public String getService() {
		return service;
	}

	
	/**
	* setter method
	* @param service the service to set
	*/
	
	public void setService(String service) {
		this.service = service;
	}

	
	/**
	 * getter method 
	 * @Title: getLang
	 * @return the lang
	 */
	
	public String getLang() {
		return lang;
	}

	
	/**
	* setter method
	* @param lang the lang to set
	*/
	
	public void setLang(String lang) {
		this.lang = lang;
	}

	
	/**
	 * getter method 
	 * @Title: getHead
	 * @return the head
	 */
	
	public String getHead() {
		return head;
	}

	
	/**
	* setter method
	* @param head the head to set
	*/
	
	public void setHead(String head) {
		this.head = head;
	}

	
	/**
	 * getter method 
	 * @Title: getBody
	 * @return the body
	 */
	
	public DeliverTmReqBody getBody() {
		return body;
	}

	
	/**
	* setter method
	* @param body the body to set
	*/
	
	public void setBody(DeliverTmReqBody body) {
		this.body = body;
	}


	
	 /**
	  * @Title: toString
	  * @Description: TODO
	  * @author: win10 2016年8月5日
	  * @modify: win10 2016年8月5日
	  * @return
	  * @see java.lang.Object#toString()
	  */
	
	@Override
	public String toString() {
		return "DeliverTmReq [service=" + service + ", lang=" + lang + ", head=" + head + ", body=" + body + "]";
	}

}
