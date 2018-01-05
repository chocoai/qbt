package com.qbt.web.pojo.baseSFPrice;

import com.qbt.common.result.Paging;

public class BaseSFPricePageReqVo extends Paging {
	
	private String startProvince;

	private String startCity;

	private String endProvince;

	private String endCity;

	public String getStartProvince() {
		return startProvince;
	}

	public void setStartProvince(String startProvince) {
		this.startProvince = startProvince;
	}

	public String getStartCity() {
		return startCity;
	}

	public void setStartCity(String startCity) {
		this.startCity = startCity;
	}
	public String getEndProvince() {
		return endProvince;
	}

	public void setEndProvince(String endProvince) {
		this.endProvince = endProvince;
	}

	public String getEndCity() {
		return endCity;
	}

	public void setEndCity(String endCity) {
		this.endCity = endCity;
	}

}
