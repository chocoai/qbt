package com.qbt.persistent.entity;

import java.util.Date;

import com.qbt.common.entity.BaseEntity;

public class Feedback extends BaseEntity{

    private String mobile;

    private String content;
    
    private int userId;
    
    private String userNickname;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
}