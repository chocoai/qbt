package com.qbt.web.pojo.contact;

import com.qbt.common.result.Paging;

public class UserContactPageReqVo extends Paging {
	
    private String name;
	
    private String mobile;
	
    private Boolean isDelete;
    
    private Integer type;//客户类型: 0-未支付客户 1-已支付客户

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

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
    
}
