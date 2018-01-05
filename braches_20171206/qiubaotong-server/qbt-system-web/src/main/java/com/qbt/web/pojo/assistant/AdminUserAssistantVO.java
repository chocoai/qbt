package com.qbt.web.pojo.assistant;

import java.util.Date;

public class AdminUserAssistantVO {
	
	private int id;
	
	private Integer userId;

    private String name;
    //球场
    private String siteName;
    
	private String userWeixinNickName;
	 
	private Integer userWeixinSex;
	 
    private String email;

    private String mobile;

    private Date createTime;
 	
	private Integer status;
	 
	private String memo;
	
	private int type;
    
    public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getUserWeixinNickName() {
		return userWeixinNickName;
	}

	public void setUserWeixinNickName(String userWeixinNickName) {
		this.userWeixinNickName = userWeixinNickName;
	}

	public Integer getUserWeixinSex() {
		return userWeixinSex;
	}

	public void setUserWeixinSex(Integer userWeixinSex) {
		this.userWeixinSex = userWeixinSex;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
