
 /**
 * @Title: UserCourse.java
 * @Package com.qbt.persistent.entity
 * @Description: TODO
 * Copyright:2017 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater chenxiaocong 2017年4月11日
 * @version V1.0
 **/

package com.qbt.persistent.entity;


 /**
  * @ClassName: UserCourse
  * @Description: TODO
  * @author chenxiaocong 2017年4月11日
  * @modify chenxiaocong 2017年4月11日
  */

public class UserCourse extends BaseCourse{

	private static final long serialVersionUID = 1L;

	private String contact;
	
	private String mobile;

	
	/**
	 * getter method 
	 * @Title: getContact
	 * @return the contact
	 */
	
	public String getContact() {
		return contact;
	}

	
	/**
	* setter method
	* @param contact the contact to set
	*/
	
	public void setContact(String contact) {
		this.contact = contact;
	}

	
	/**
	 * getter method 
	 * @Title: getMobile
	 * @return the mobile
	 */
	
	public String getMobile() {
		return mobile;
	}

	
	/**
	* setter method
	* @param mobile the mobile to set
	*/
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
}
