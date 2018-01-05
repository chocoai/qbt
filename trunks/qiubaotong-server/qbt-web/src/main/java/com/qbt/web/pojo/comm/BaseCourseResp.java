
 /**
 * @Title: BaseCourseResp.java
 * @Package com.qbt.web.pojo.comm
 * @Description: TODO
 * Copyright:2017 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater chenxiaocong 2017年3月6日
 * @version V1.0
 **/

package com.qbt.web.pojo.comm;


 /**
  * @ClassName: BaseCourseResp
  * @Description: TODO
  * @author chenxiaocong 2017年3月6日
  * @modify chenxiaocong 2017年3月6日
  */

public class BaseCourseResp {


	private Long id;
	
	private String name;

    private Integer areaId;

    private String address;

    private Integer status;

	
	/**
	 * getter method 
	 * @Title: getId
	 * @return the id
	 */
	
	public Long getId() {
		return id;
	}

	
	/**
	* setter method
	* @param id the id to set
	*/
	
	public void setId(Long id) {
		this.id = id;
	}

	
	/**
	 * getter method 
	 * @Title: getName
	 * @return the name
	 */
	
	public String getName() {
		return name;
	}

	
	/**
	* setter method
	* @param name the name to set
	*/
	
	public void setName(String name) {
		this.name = name;
	}

	
	/**
	 * getter method 
	 * @Title: getAreaId
	 * @return the areaId
	 */
	
	public Integer getAreaId() {
		return areaId;
	}

	
	/**
	* setter method
	* @param areaId the areaId to set
	*/
	
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
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
	 * @Title: getStatus
	 * @return the status
	 */
	
	public Integer getStatus() {
		return status;
	}

	
	/**
	* setter method
	* @param status the status to set
	*/
	
	public void setStatus(Integer status) {
		this.status = status;
	}

    
    
}
