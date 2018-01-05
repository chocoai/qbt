package com.qbt.web.pojo.baseNewSfPrice;

import com.qbt.common.result.Paging;

public class BaseNewSfPricePageReqVo extends Paging {

	//寄件地区
	private String startArea;

	//收件地区
    private String endArea;

	public String getStartArea() {
		return startArea;
	}

	public void setStartArea(String startArea) {
		this.startArea = startArea;
	}

	public String getEndArea() {
		return endArea;
	}

	public void setEndArea(String endArea) {
		this.endArea = endArea;
	}
    
}
