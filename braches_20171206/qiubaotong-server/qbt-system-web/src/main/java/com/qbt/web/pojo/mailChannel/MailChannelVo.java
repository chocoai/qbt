package com.qbt.web.pojo.mailChannel;

import java.util.Date;

public class MailChannelVo {
	private int id;
	private Date createTime;//创建时间
    private Date updateTime;//创建时间
    private String channelName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
    
    
    
}
