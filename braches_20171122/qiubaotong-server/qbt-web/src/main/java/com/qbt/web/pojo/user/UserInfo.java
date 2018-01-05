package com.qbt.web.pojo.user;

import javax.validation.constraints.NotNull;

import com.qbt.web.pojo.vip.VipUser;

public class UserInfo {
	
	@NotNull(message = "姓名不能为空")
    private String name;

    private String email;

    @NotNull(message = "手机号不能为空")
    private String mobile;

    private Integer sex;

    private String nickname;

    private String headImgUrl;
    
    private boolean isVip;
    
    private boolean assistantUser;
    
    private double vipAmount;
    
    private VipUser vipUser;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getHeadImgUrl() {
		return headImgUrl;
	}

	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}

	public boolean isVip() {
		return isVip;
	}

	public void setVip(boolean isVip) {
		this.isVip = isVip;
	}

	public VipUser getVipInfo() {
		return vipUser;
	}

	public void setVipInfo(VipUser vipUser) {
		this.vipUser = vipUser;
	}

	public double getVipAmount() {
		return vipAmount;
	}

	public void setVipAmount(double vipAmount) {
		this.vipAmount = vipAmount;
	}

	public VipUser getVipUser() {
		return vipUser;
	}

	public void setVipUser(VipUser vipUser) {
		this.vipUser = vipUser;
	}

	public boolean isAssistantUser() {
		return assistantUser;
	}

	public void setAssistantUser(boolean assistantUser) {
		this.assistantUser = assistantUser;
	}

}
