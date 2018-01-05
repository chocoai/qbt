
 /**
 * @Title: Assistant.java
 * @Package com.qbt.web.pojo.assistant
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater win10 2016年8月18日
 * @version V1.0
 **/

package com.qbt.web.pojo.assistant;

import javax.validation.constraints.NotNull;

/**
  * @ClassName: Assistant
  * @Description: TODO
  * @author win10 2016年8月18日
  * @modify win10 2016年8月18日
  */

public class Assistant {
	@NotNull(message="手机号不能为空")
	private String mobile;
	@NotNull(message="姓名不能为空")
	private String name;
	private String idCode;
	private String[] pics;
	@NotNull(message="申请助理类型不能为空")
	private Integer applyType;
	@NotNull(message="工作场所不能为空")
	private Integer applyId;
	@NotNull(message="申请助理类型名称不能为空")
	private String applyName;
	@NotNull(message="短信验证token不能为空")
	private String smsToken;
	@NotNull(message="短信验证码不能为空")
	private String smsCode;
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
	public String getIdCode() {
		return idCode;
	}
	public void setIdCode(String idCode) {
		this.idCode = idCode;
	}
	public String[] getPics() {
		return pics;
	}
	public void setPics(String[] pics) {
		this.pics = pics;
	}
	public Integer getApplyType() {
		return applyType;
	}
	public void setApplyType(Integer applyType) {
		this.applyType = applyType;
	}
	public Integer getApplyId() {
		return applyId;
	}
	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}
	public String getApplyName() {
		return applyName;
	}
	public void setApplyName(String applyName) {
		this.applyName = applyName;
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
