
 /**
 * @Title: UserOrderAddress.java
 * @Package com.qbt.persistent.entity
 * @Description: TODO
 * Copyright:2017 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater chenxiaocong 2017年3月10日
 * @version V1.0
 **/

package com.qbt.persistent.entity;


 /**
  * @ClassName: UserOrderAddress
  * @Description: TODO
  * @author chenxiaocong 2017年3月10日
  * @modify chenxiaocong 2017年3月10日
  */

public class UserOrderAddress {

	private int id;
	private int userId;
	private int addrType;
	private int countryAreaId;
	private String countryAreaName;
	private int provinceAreaId;
	private String provinceAreaName;
	private int cityAreaId;
	private String cityAreaName;
	private int districtAreaId;
	private String districtAreaName;
	private String treePath;
	private int addrId;
	private String addrName;
	private String address;
	private String contact;
	private String mobile;
	private String uuid;
	
	/**
	 * getter method 
	 * @Title: getId
	 * @return the id
	 */
	
	public int getId() {
		return id;
	}
	
	/**
	* setter method
	* @param id the id to set
	*/
	
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * getter method 
	 * @Title: getUserId
	 * @return the userId
	 */
	
	public int getUserId() {
		return userId;
	}
	
	/**
	* setter method
	* @param userId the userId to set
	*/
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	/**
	 * getter method 
	 * @Title: getAddrType
	 * @return the addrType
	 */
	
	public int getAddrType() {
		return addrType;
	}
	
	/**
	* setter method
	* @param addrType the addrType to set
	*/
	
	public void setAddrType(int addrType) {
		this.addrType = addrType;
	}
	
	/**
	 * getter method 
	 * @Title: getCountryAreaId
	 * @return the countryAreaId
	 */
	
	public int getCountryAreaId() {
		return countryAreaId;
	}
	
	/**
	* setter method
	* @param countryAreaId the countryAreaId to set
	*/
	
	public void setCountryAreaId(int countryAreaId) {
		this.countryAreaId = countryAreaId;
	}
	
	/**
	 * getter method 
	 * @Title: getCountryAreaName
	 * @return the countryAreaName
	 */
	
	public String getCountryAreaName() {
		return countryAreaName;
	}
	
	/**
	* setter method
	* @param countryAreaName the countryAreaName to set
	*/
	
	public void setCountryAreaName(String countryAreaName) {
		this.countryAreaName = countryAreaName;
	}
	
	/**
	 * getter method 
	 * @Title: getProvinceAreaId
	 * @return the provinceAreaId
	 */
	
	public int getProvinceAreaId() {
		return provinceAreaId;
	}
	
	/**
	* setter method
	* @param provinceAreaId the provinceAreaId to set
	*/
	
	public void setProvinceAreaId(int provinceAreaId) {
		this.provinceAreaId = provinceAreaId;
	}
	
	/**
	 * getter method 
	 * @Title: getProvinceAreaName
	 * @return the provinceAreaName
	 */
	
	public String getProvinceAreaName() {
		return provinceAreaName;
	}
	
	/**
	* setter method
	* @param provinceAreaName the provinceAreaName to set
	*/
	
	public void setProvinceAreaName(String provinceAreaName) {
		this.provinceAreaName = provinceAreaName;
	}
	
	/**
	 * getter method 
	 * @Title: getCityAreaId
	 * @return the cityAreaId
	 */
	
	public int getCityAreaId() {
		return cityAreaId;
	}
	
	/**
	* setter method
	* @param cityAreaId the cityAreaId to set
	*/
	
	public void setCityAreaId(int cityAreaId) {
		this.cityAreaId = cityAreaId;
	}
	
	/**
	 * getter method 
	 * @Title: getCityAreaName
	 * @return the cityAreaName
	 */
	
	public String getCityAreaName() {
		return cityAreaName;
	}
	
	/**
	* setter method
	* @param cityAreaName the cityAreaName to set
	*/
	
	public void setCityAreaName(String cityAreaName) {
		this.cityAreaName = cityAreaName;
	}
	
	/**
	 * getter method 
	 * @Title: getDistrictAreaId
	 * @return the districtAreaId
	 */
	
	public int getDistrictAreaId() {
		return districtAreaId;
	}
	
	/**
	* setter method
	* @param districtAreaId the districtAreaId to set
	*/
	
	public void setDistrictAreaId(int districtAreaId) {
		this.districtAreaId = districtAreaId;
	}
	
	/**
	 * getter method 
	 * @Title: getDistrictAreaName
	 * @return the districtAreaName
	 */
	
	public String getDistrictAreaName() {
		return districtAreaName;
	}
	
	/**
	* setter method
	* @param districtAreaName the districtAreaName to set
	*/
	
	public void setDistrictAreaName(String districtAreaName) {
		this.districtAreaName = districtAreaName;
	}
	
	/**
	 * getter method 
	 * @Title: getTreePath
	 * @return the treePath
	 */
	
	public String getTreePath() {
		return treePath;
	}
	
	/**
	* setter method
	* @param treePath the treePath to set
	*/
	
	public void setTreePath(String treePath) {
		this.treePath = treePath;
	}
	
	/**
	 * getter method 
	 * @Title: getAddrId
	 * @return the addrId
	 */
	
	public int getAddrId() {
		return addrId;
	}
	
	/**
	* setter method
	* @param addrId the addrId to set
	*/
	
	public void setAddrId(int addrId) {
		this.addrId = addrId;
	}
	
	/**
	 * getter method 
	 * @Title: getAddrName
	 * @return the addrName
	 */
	
	public String getAddrName() {
		return addrName;
	}
	
	/**
	* setter method
	* @param addrName the addrName to set
	*/
	
	public void setAddrName(String addrName) {
		this.addrName = addrName;
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
	
	/**
	 * getter method 
	 * @Title: getUuid
	 * @return the uuid
	 */
	
	public String getUuid() {
		return uuid;
	}
	
	/**
	* setter method
	* @param uuid the uuid to set
	*/
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	
}
