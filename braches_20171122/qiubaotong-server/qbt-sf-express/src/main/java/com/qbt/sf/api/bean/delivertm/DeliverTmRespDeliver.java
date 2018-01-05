
 /**
 * @Title: DeliverTmRespDeliver.java
 * @Package com.qbt.sf.api.bean.delivertm
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater win10 2016年8月5日
 * @version V1.0
 **/

package com.qbt.sf.api.bean.delivertm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
  * @ClassName: DeliverTmRespDeliver
  * @Description: TODO
  * @author win10 2016年8月5日
  * @modify win10 2016年8月5日
  */
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {}) 
public class DeliverTmRespDeliver {
	
	@XmlAttribute(name="business_type")
	private String business_type;
	
	@XmlAttribute(name="business_type_desc")
	private String business_type_desc;
	
	@XmlAttribute(name="deliver_time")
	private String deliver_time;
	
	private double price;

	
	/**
	 * getter method 
	 * @Title: getBusiness_type
	 * @return the business_type
	 */
	
	public String getBusiness_type() {
		return business_type;
	}

	
	/**
	* setter method
	* @param business_type the business_type to set
	*/
	public void setBusiness_type(String business_type) {
		this.business_type = business_type;
	}

	
	/**
	 * getter method 
	 * @Title: getBusiness_type_desc
	 * @return the business_type_desc
	 */
	
	public String getBusiness_type_desc() {
		return business_type_desc;
	}

	
	/**
	* setter method
	* @param business_type_desc the business_type_desc to set
	*/
	
	public void setBusiness_type_desc(String business_type_desc) {
		this.business_type_desc = business_type_desc;
	}

	
	/**
	 * getter method 
	 * @Title: getDeliver_time
	 * @return the deliver_time
	 */
	
	public String getDeliver_time() {
		return deliver_time;
	}

	
	/**
	* setter method
	* @param deliver_time the deliver_time to set
	*/
	
	public void setDeliver_time(String deliver_time) {
		this.deliver_time = deliver_time;
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
		return "DeliverTmRespDeliver [business_type=" + business_type + ", business_type_desc=" + business_type_desc
				+ ", deliver_time=" + deliver_time + "]";
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
}
