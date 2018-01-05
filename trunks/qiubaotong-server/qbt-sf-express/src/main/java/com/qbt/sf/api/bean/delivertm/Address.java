
 /**
 * @Title: DestAddress.java
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
  * @ClassName: DestAddress
  * @Description: TODO
  * @author win10 2016年8月5日
  * @modify win10 2016年8月5日
  */
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {}) 
public class Address {
	@XmlAttribute
	private String province;
	
	@XmlAttribute
	private String city;
	
	@XmlAttribute
	private String district;
	
	@XmlAttribute
	private String address;
	
	@XmlAttribute
	private String code;

	
	/**
	 * getter method 
	 * @Title: getProvince
	 * @return the province
	 */
	
	public String getProvince() {
		return province;
	}

	
	/**
	* setter method
	* @param province the province to set
	*/
	
	public void setProvince(String province) {
		this.province = province;
	}

	
	/**
	 * getter method 
	 * @Title: getCity
	 * @return the city
	 */
	
	public String getCity() {
		return city;
	}

	
	/**
	* setter method
	* @param city the city to set
	*/
	
	public void setCity(String city) {
		this.city = city;
	}

	
	/**
	 * getter method 
	 * @Title: getDistrict
	 * @return the district
	 */
	
	public String getDistrict() {
		return district;
	}

	
	/**
	* setter method
	* @param district the district to set
	*/
	
	public void setDistrict(String district) {
		this.district = district;
	}

	
	/**
	 * getter method 
	 * @Title: getAddress
	 * @return the address
	 */
	
	public String getAddress() {
		return address;
	}

	
	/**
	* setter method
	* @param address the address to set
	*/
	
	public void setAddress(String address) {
		this.address = address;
	}

	
	/**
	 * getter method 
	 * @Title: getCode
	 * @return the code
	 */
	
	public String getCode() {
		return code;
	}

	
	/**
	* setter method
	* @param code the code to set
	*/
	
	public void setCode(String code) {
		this.code = code;
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
		return "Address [province=" + province + ", city=" + city + ", district=" + district + ", address=" + address
				+ ", code=" + code + "]";
	}
	
	
	
}
