package com.qbt.web.pojo.baseSfSite;

import com.qbt.common.result.Paging;

public class BaseSfSitePageReqVo extends Paging{

	private String name;
	
	private Boolean isDelete;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
	
}
