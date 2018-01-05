
 /**
 * @Title: OrderAddressRoute.java
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
  * @ClassName: OrderAddressRoute
  * @Description: TODO
  * @author chenxiaocong 2017年3月10日
  * @modify chenxiaocong 2017年3月10日
  */

public class OrderAddressRoute {

	private int id;
	private Date createTime;
	private int orderId;
	private Date orderTime;
	private int jUserOrderAddressId;
	private String jUserOrderAddressUuid;
	private int dUserOrderAddressId;
	private String dUserOrderAddressUuid;
	
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
	 * @Title: getjUserOrderAddressId
	 * @return the jUserOrderAddressId
	 */
	
	public int getjUserOrderAddressId() {
		return jUserOrderAddressId;
	}
	
	/**
	* setter method
	* @param jUserOrderAddressId the jUserOrderAddressId to set
	*/
	
	public void setjUserOrderAddressId(int jUserOrderAddressId) {
		this.jUserOrderAddressId = jUserOrderAddressId;
	}
	
	/**
	 * getter method 
	 * @Title: getjUserOrderAddressUuid
	 * @return the jUserOrderAddressUuid
	 */
	
	public String getjUserOrderAddressUuid() {
		return jUserOrderAddressUuid;
	}
	
	/**
	* setter method
	* @param jUserOrderAddressUuid the jUserOrderAddressUuid to set
	*/
	
	public void setjUserOrderAddressUuid(String jUserOrderAddressUuid) {
		this.jUserOrderAddressUuid = jUserOrderAddressUuid;
	}
	
	/**
	 * getter method 
	 * @Title: getdUserOrderAddressId
	 * @return the dUserOrderAddressId
	 */
	
	public int getdUserOrderAddressId() {
		return dUserOrderAddressId;
	}
	
	/**
	* setter method
	* @param dUserOrderAddressId the dUserOrderAddressId to set
	*/
	
	public void setdUserOrderAddressId(int dUserOrderAddressId) {
		this.dUserOrderAddressId = dUserOrderAddressId;
	}
	
	/**
	 * getter method 
	 * @Title: getdUserOrderAddressUuid
	 * @return the dUserOrderAddressUuid
	 */
	
	public String getdUserOrderAddressUuid() {
		return dUserOrderAddressUuid;
	}
	
	/**
	* setter method
	* @param dUserOrderAddressUuid the dUserOrderAddressUuid to set
	*/
	
	public void setdUserOrderAddressUuid(String dUserOrderAddressUuid) {
		this.dUserOrderAddressUuid = dUserOrderAddressUuid;
	}
	
	

}
