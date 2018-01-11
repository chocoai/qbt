package com.qbt.web.pojo.sfkf;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class UserSfKfVo {
	
	private int id;//id
	
    private Date createTime;//创建时间
    
    @NotNull(message = "客户名称不能为空")
    private String name;//客服名称
    
    @NotNull(message = "手机号不能为空")
    private String mobile;//电话

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
    
}
