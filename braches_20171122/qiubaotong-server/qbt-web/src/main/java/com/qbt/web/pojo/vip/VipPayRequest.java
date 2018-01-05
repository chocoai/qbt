package com.qbt.web.pojo.vip;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class VipPayRequest {
	
	/**
	 * 用户ID
	 */
	private int userId;
	
	
	/**
	 * 
	 */
	private String openid;

	
	/**
	 * 订单金额
	 */
	@Min(value=0,message="订单金额不能为0")
	private BigDecimal price;
	
	
	/**
	 * 会员卡类型ID-会员卡类型
	 */
	private int vipTypeId;
	

	/**
	 * 用户名
	 */
	@NotNull(message = "用户名不能为空")
	private String user_name;
	
	/**
	 * 手机号
	 */
	@NotNull(message = "手机号不能为空")
	private String mobile;
	
	/**
	 * 用户图片id
	 */
	private Integer userImgId;
	

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
	 * @Title: getOpenid
	 * @return the openid
	 */
	
	public String getOpenid() {
		return openid;
	}

	
	/**
	* setter method
	* @param openid the openid to set
	*/
	
	public void setOpenid(String openid) {
		this.openid = openid;
	}


	
	/**
	 * getter method 
	 * @Title: getPrice
	 * @return the price
	 */
	
	public BigDecimal getPrice() {
		return price;
	}


	
	/**
	* setter method
	* @param price the price to set
	*/
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	


	
	/**
	 * getter method 
	 * @Title: getUser_name
	 * @return the user_name
	 */
	
	public String getUser_name() {
		return user_name;
	}


	
	/**
	* setter method
	* @param user_name the user_name to set
	*/
	
	public void setUser_name(String user_name) {
		this.user_name = user_name;
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
	 * @Title: getVipTypeId
	 * @return the vipTypeId
	 */
	
	public int getVipTypeId() {
		return vipTypeId;
	}


	
	/**
	* setter method
	* @param vipTypeId the vipTypeId to set
	*/
	
	public void setVipTypeId(int vipTypeId) {
		this.vipTypeId = vipTypeId;
	}


	public Integer getUserImgId() {
		return userImgId;
	}


	public void setUserImgId(Integer userImgId) {
		this.userImgId = userImgId;
	}
	
	
}
