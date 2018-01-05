/**
 * Project Name:qbt-system-web
 * File Name:OrderAddressRoutePageReqVo.java
 * Package Name:com.qbt.web.pojo.orderAddressRoute
 * Date:2017年3月13日下午4:30:20
 *
*/

package com.qbt.web.pojo.orderAddressRoute;

import java.util.Date;

import com.qbt.common.result.Paging;

/**
 * ClassName:OrderAddressRoutePageReqVo
 * Reason:	 TODO ADD REASON.
 * Date:     2017年3月13日 下午4:30:20
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class OrderAddressRoutePageReqVo extends Paging {
	
	private Date startOrderTime;
	
	private Date endOrderTime;
	
	private int userId;
	
	private String contact;
	
	private String mobile;

	public Date getStartOrderTime() {
		return startOrderTime;
	}

	public void setStartOrderTime(Date startOrderTime) {
		this.startOrderTime = startOrderTime;
	}

	public Date getEndOrderTime() {
		return endOrderTime;
	}

	public void setEndOrderTime(Date endOrderTime) {
		this.endOrderTime = endOrderTime;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
}
