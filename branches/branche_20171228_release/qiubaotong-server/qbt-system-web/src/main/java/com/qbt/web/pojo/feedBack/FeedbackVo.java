package com.qbt.web.pojo.feedBack;

import java.util.Date;

public class FeedbackVo {
	//id
	private Integer id;
	//联系人电话号码
    private String mobile;
    //内容
    private String content;
    //创建时间
    private Date createTime;
    //微信用户id
    private int userId;
    //微信用户昵称
    private String userNickname;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
