
 /**
 * @Title: DeliverTmReqDeliver.java
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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
  * @ClassName: DeliverTmReqDeliver
  * @Description: TODO
  * @author win10 2016年8月5日
  * @modify win10 2016年8月5日
  */
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {}) 
public class DeliverTmReqDeliver {
	
	@XmlAttribute(name="business_type")
	private String  business_type;
	
	@XmlAttribute
	private String weight;
	
	@XmlAttribute
	private String volumn;
	
	@XmlAttribute(name="consigned_time")
	private String consigned_time;
	
	
	@XmlElement(name="SrcAddress")
	private Address srcAddress;
	
	@XmlElement(name="DestAddress")
	private Address destAddress;

	
	
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
	 * @Title: getWeight
	 * @return the weight
	 */
	
	public String getWeight() {
		return weight;
	}

	
	/**
	* setter method
	* @param weight the weight to set
	*/
	
	public void setWeight(String weight) {
		this.weight = weight;
	}

	
	/**
	 * getter method 
	 * @Title: getVolumn
	 * @return the volumn
	 */
	
	public String getVolumn() {
		return volumn;
	}

	
	/**
	* setter method
	* @param volumn the volumn to set
	*/
	
	public void setVolumn(String volumn) {
		this.volumn = volumn;
	}

	
	/**
	 * getter method 
	 * @Title: getConsigned_time
	 * @return the consigned_time
	 */
	
	public String getConsigned_time() {
		return consigned_time;
	}

	
	/**
	* setter method
	* @param consigned_time the consigned_time to set
	*/
	
	public void setConsigned_time(String consigned_time) {
		this.consigned_time = consigned_time;
	}

	
	/**
	 * getter method 
	 * @Title: getSrcAddress
	 * @return the srcAddress
	 */
	
	public Address getSrcAddress() {
		return srcAddress;
	}

	
	/**
	* setter method
	* @param srcAddress the srcAddress to set
	*/
	
	public void setSrcAddress(Address srcAddress) {
		this.srcAddress = srcAddress;
	}

	
	/**
	 * getter method 
	 * @Title: getDestAddress
	 * @return the destAddress
	 */
	
	public Address getDestAddress() {
		return destAddress;
	}

	
	/**
	* setter method
	* @param destAddress the destAddress to set
	*/
	
	public void setDestAddress(Address destAddress) {
		this.destAddress = destAddress;
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
		return "DeliverTmReqDeliver [business_type=" + business_type + ", weight=" + weight + ", volumn=" + volumn
				+ ", consigned_time=" + consigned_time + ", srcAddress=" + srcAddress + ", destAddress=" + destAddress
				+ "]";
	}
	
	
	

}
