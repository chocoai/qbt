/**
 * Project Name:qbt-shansong
 * File Name:OrderCalcMerchant.java
 * Package Name:com.qbt.shansong.entity.ordercalc
 * Date:2017年2月23日下午3:52:51
 *
*/

package com.qbt.shansong.entity.ordercalc;
/**
 * ClassName:OrderCalcMerchant
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月23日 下午3:52:51
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class OrderCalcMerchant {
	
	//商户唯一ID
	private String id;
	
	//商户手机号
	private String mobile;
	
	//商户机构名称
	private String name;
	
	//商户凭证(在线支付用,若不使用在线支付,可传null-即寄付)
	private String token;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
