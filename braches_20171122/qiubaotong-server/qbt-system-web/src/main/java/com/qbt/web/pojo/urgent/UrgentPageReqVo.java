package com.qbt.web.pojo.urgent;

import com.qbt.common.result.Paging;

public class UrgentPageReqVo extends Paging {
	
	private String name;//名称
	private String fromProvince;// 原寄地省
    private String fromCity;// 原寄地市
    
    private String toProvince;// 目的地省
    private String toCity;// 目的地市

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFromProvince() {
		return fromProvince;
	}

	public void setFromProvince(String fromProvince) {
		this.fromProvince = fromProvince;
	}

	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public String getToProvince() {
		return toProvince;
	}

	public void setToProvince(String toProvince) {
		this.toProvince = toProvince;
	}

	public String getToCity() {
		return toCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	
}
