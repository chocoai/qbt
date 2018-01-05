
 /**
 * @Title: OrderAddressType.java
 * @Package com.qbt.persistent.entity
 * @Description: TODO
 * Copyright:2017 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater chenxiaocong 2017年3月10日
 * @version V1.0
 **/

package com.qbt.persistent.entity;

import java.util.Date;

/**
  * @ClassName: OrderAddressType
  * @Description: TODO
  * @author chenxiaocong 2017年3月10日
  * @modify chenxiaocong 2017年3月10日
  */

public class OrderAddressType {

	private int id;	 
	private Date createTime;
	private int orderId;
	private Date orderTime;
	private int userOrderAddressId;
	private String userOrderAddressUuid;
	private int type;
	
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
	 * @Title: getCreateTime
	 * @return the createTime
	 */
	
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	* setter method
	* @param createTime the createTime to set
	*/
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * getter method 
	 * @Title: getOrderId
	 * @return the orderId
	 */
	
	public int getOrderId() {
		return orderId;
	}
	
	/**
	* setter method
	* @param orderId the orderId to set
	*/
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	/**
	 * getter method 
	 * @Title: getOrderTime
	 * @return the orderTime
	 */
	
	public Date getOrderTime() {
		return orderTime;
	}
	
	/**
	* setter method
	* @param orderTime the orderTime to set
	*/
	
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	
	/**
	 * getter method 
	 * @Title: getUserOrderAddressId
	 * @return the userOrderAddressId
	 */
	
	public int getUserOrderAddressId() {
		return userOrderAddressId;
	}
	
	/**
	* setter method
	* @param userOrderAddressId the userOrderAddressId to set
	*/
	
	public void setUserOrderAddressId(int userOrderAddressId) {
		this.userOrderAddressId = userOrderAddressId;
	}
	
	/**
	 * getter method 
	 * @Title: getUserOrderAddressUuid
	 * @return the userOrderAddressUuid
	 */
	
	public String getUserOrderAddressUuid() {
		return userOrderAddressUuid;
	}
	
	/**
	* setter method
	* @param userOrderAddressUuid the userOrderAddressUuid to set
	*/
	
	public void setUserOrderAddressUuid(String userOrderAddressUuid) {
		this.userOrderAddressUuid = userOrderAddressUuid;
	}
	
	/**
	 * getter method 
	 * @Title: getType
	 * @return the type
	 */
	
	public int getType() {
		return type;
	}
	
	/**
	* setter method
	* @param type the type to set
	*/
	
	public void setType(int type) {
		this.type = type;
	}
	
	

}
