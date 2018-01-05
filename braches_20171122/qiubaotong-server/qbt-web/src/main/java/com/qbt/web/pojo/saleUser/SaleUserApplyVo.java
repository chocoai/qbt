/**
 * Project Name:qbt-web
 * File Name:SaleUserApplyVo.java
 * Package Name:com.qbt.web.pojo.saleUser
 * Date:2017年2月7日下午3:00:06
 *
*/

package com.qbt.web.pojo.saleUser;

import javax.validation.constraints.NotNull;

/**
 * ClassName:SaleUserApplyVo
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月7日 下午3:00:06
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class SaleUserApplyVo {
	
	private String salesmanCode;
	
	@NotNull(message = "姓名不能为空")
	private String name;
	
	@NotNull(message = "手机号不能为空")
	private String mobile;
	
	private String idcard;
	
	private String idcardUrl;
	
	private String company;
	
	@NotNull(message="短信验证token不能为空")
	private String smsToken;
	
	@NotNull(message="短信验证码不能为空")
	private String smsCode;

	public String getSalesmanCode() {
		return salesmanCode;
	}

	public void setSalesmanCode(String salesmanCode) {
		this.salesmanCode = salesmanCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getIdcardUrl() {
		return idcardUrl;
	}

	public void setIdcardUrl(String idcardUrl) {
		this.idcardUrl = idcardUrl;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSmsToken() {
		return smsToken;
	}

	public void setSmsToken(String smsToken) {
		this.smsToken = smsToken;
	}

	public String getSmsCode() {
		return smsCode;
	}

	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}
	
}
