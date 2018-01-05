package com.qbt.web.pojo.feedBack;

import com.qbt.common.result.Paging;

public class FeedbackPageReqVo extends Paging {

	//联系人电话号码
    private String mobile;
    //内容
    private String content;
    //微信用户昵称
    private String userNickname;
    
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
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
}
