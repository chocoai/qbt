package com.qbt.web.pojo.asAp;

import java.util.Date;

public class UserAsApVo {
	
	private Integer id;

    private Date createTime;
    
    private Integer assistantId;

    private String name;

    private String identityCode;

    private String photo1Url;

    private String photo2Url;

    private Integer applyType;

    private Integer status;

    private String applyName;
    
    private String nickname; 
    
    private Integer sex;
    
    private String mobile;
    
    private String email;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getAssistantId() {
		return assistantId;
	}

	public void setAssistantId(Integer assistantId) {
		this.assistantId = assistantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdentityCode() {
		return identityCode;
	}

	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
	}

	public String getPhoto1Url() {
		return photo1Url;
	}

	public void setPhoto1Url(String photo1Url) {
		this.photo1Url = photo1Url;
	}

	public String getPhoto2Url() {
		return photo2Url;
	}

	public void setPhoto2Url(String photo2Url) {
		this.photo2Url = photo2Url;
	}

	public Integer getApplyType() {
		return applyType;
	}

	public void setApplyType(Integer applyType) {
		this.applyType = applyType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getApplyName() {
		return applyName;
	}

	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
