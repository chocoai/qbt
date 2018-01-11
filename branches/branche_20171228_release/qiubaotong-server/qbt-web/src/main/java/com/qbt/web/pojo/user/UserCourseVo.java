
 /**
 * @Title: UserCourse.java
 * @Package com.qbt.web.pojo.user
 * @Description: TODO
 * Copyright:2017 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater chenxiaocong 2017年4月11日
 * @version V1.0
 **/

package com.qbt.web.pojo.user;


 /**
  * @ClassName: UserCourse
  * @Description: TODO
  * @author chenxiaocong 2017年4月11日
  * @modify chenxiaocong 2017年4月11日
  */

public class UserCourseVo {

	private int id;

	private String name;

	private String address;

	private double juli;

	private String juliStr;

	private int areaId;

	private int status;

	private Boolean isOutRange; // 是否偏远

	private double outRangeTime;// 偏远时效

	private double outRangePrice;// 偏远价格

	private Boolean isTip;//是否微信提示

	private String wechatTip;//提示语
	
	private String contact;
	
	private String mobile;

	
	/**
	 * getter method 
	 * @Title: getId
	 * @return the id
	 */
	
	public Integer getId() {
		return id;
	}

	
	/**
	* setter method
	* @param id the id to set
	*/
	
	public void setId(Integer id) {
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
	 * @Title: getJuli
	 * @return the juli
	 */
	
	public double getJuli() {
		return juli;
	}

	
	/**
	* setter method
	* @param juli the juli to set
	*/
	
	public void setJuli(double juli) {
		this.juli = juli;
	}

	
	/**
	 * getter method 
	 * @Title: getJuliStr
	 * @return the juliStr
	 */
	
	public String getJuliStr() {
		return juliStr;
	}

	
	/**
	* setter method
	* @param juliStr the juliStr to set
	*/
	
	public void setJuliStr(String juliStr) {
		this.juliStr = juliStr;
	}

	
	/**
	 * getter method 
	 * @Title: getAreaId
	 * @return the areaId
	 */
	
	public int getAreaId() {
		return areaId;
	}

	
	/**
	* setter method
	* @param areaId the areaId to set
	*/
	
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	
	/**
	 * getter method 
	 * @Title: getStatus
	 * @return the status
	 */
	
	public int getStatus() {
		return status;
	}

	
	/**
	* setter method
	* @param status the status to set
	*/
	
	public void setStatus(int status) {
		this.status = status;
	}

	
	/**
	 * getter method 
	 * @Title: getIsOutRange
	 * @return the isOutRange
	 */
	
	public Boolean getIsOutRange() {
		return isOutRange;
	}

	
	/**
	* setter method
	* @param isOutRange the isOutRange to set
	*/
	
	public void setIsOutRange(Boolean isOutRange) {
		this.isOutRange = isOutRange;
	}

	
	/**
	 * getter method 
	 * @Title: getOutRangeTime
	 * @return the outRangeTime
	 */
	
	public double getOutRangeTime() {
		return outRangeTime;
	}

	
	/**
	* setter method
	* @param outRangeTime the outRangeTime to set
	*/
	
	public void setOutRangeTime(double outRangeTime) {
		this.outRangeTime = outRangeTime;
	}

	
	/**
	 * getter method 
	 * @Title: getOutRangePrice
	 * @return the outRangePrice
	 */
	
	public double getOutRangePrice() {
		return outRangePrice;
	}

	
	/**
	* setter method
	* @param outRangePrice the outRangePrice to set
	*/
	
	public void setOutRangePrice(double outRangePrice) {
		this.outRangePrice = outRangePrice;
	}

	
	/**
	 * getter method 
	 * @Title: getIsTip
	 * @return the isTip
	 */
	
	public Boolean getIsTip() {
		return isTip;
	}

	
	/**
	* setter method
	* @param isTip the isTip to set
	*/
	
	public void setIsTip(Boolean isTip) {
		this.isTip = isTip;
	}

	
	/**
	 * getter method 
	 * @Title: getWechatTip
	 * @return the wechatTip
	 */
	
	public String getWechatTip() {
		return wechatTip;
	}

	
	/**
	* setter method
	* @param wechatTip the wechatTip to set
	*/
	
	public void setWechatTip(String wechatTip) {
		this.wechatTip = wechatTip;
	}

	
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
