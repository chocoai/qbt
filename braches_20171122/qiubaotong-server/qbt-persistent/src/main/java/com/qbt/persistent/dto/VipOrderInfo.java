/**
 * Project Name:qbt-persistent
 * File Name:VipOrderInfo.java
 * Package Name:com.qbt.persistent.entity
 * Date:2016年11月4日下午2:39:21
 *
*/

package com.qbt.persistent.dto;

import com.qbt.persistent.entity.OrderInfo;

/**
 * ClassName:VipOrderInfo
 * Reason:	 TODO ADD REASON.
 * Date:     2016年11月4日 下午2:39:21
 * @author   haungyihao
 * @version  
 * @see 	 
 */
public class VipOrderInfo extends OrderInfo {
	
	// 会员名
	private String userName;
	
	// 会员手机号
	private String mobile;
	
	// 会员卡号
	private String vipNo;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getVipNo() {
		return vipNo;
	}

	public void setVipNo(String vipNo) {
		this.vipNo = vipNo;
	}
	
}
