package com.qbt.web.pojo.userWeixin;

import com.qbt.common.result.Paging;

public class UserWeixinPageReqVo extends Paging {
	
	private Integer id;
	
	private String name;
	
	private String nickname;
	
	private String mobile;
	
	private Integer sex;
	
	private String email;
	
	private String channelQrcodeCode;//渠道二维码识别码标识
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getChannelQrcodeCode() {
		return channelQrcodeCode;
	}

	public void setChannelQrcodeCode(String channelQrcodeCode) {
		this.channelQrcodeCode = channelQrcodeCode;
	}
}
