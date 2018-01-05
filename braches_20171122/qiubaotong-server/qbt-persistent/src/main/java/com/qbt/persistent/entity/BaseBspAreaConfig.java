package com.qbt.persistent.entity;

import com.qbt.common.entity.BaseEntity;

public class BaseBspAreaConfig extends BaseEntity {

	// 源省
	private String srcProvince;

	// 源市
	private String srcCity;

	// 源区
	private String srcCountry;

	// 目标省
	private String destProvince;

	// 目标市
	private String destCity;

	// 目标区
	private String destCountry;

	public String getSrcProvince() {
		return srcProvince;
	}

	public void setSrcProvince(String srcProvince) {
		this.srcProvince = srcProvince;
	}

	public String getSrcCity() {
		return srcCity;
	}

	public void setSrcCity(String srcCity) {
		this.srcCity = srcCity;
	}

	public String getSrcCountry() {
		return srcCountry;
	}

	public void setSrcCountry(String srcCountry) {
		this.srcCountry = srcCountry;
	}

	public String getDestProvince() {
		return destProvince;
	}

	public void setDestProvince(String destProvince) {
		this.destProvince = destProvince;
	}

	public String getDestCity() {
		return destCity;
	}

	public void setDestCity(String destCity) {
		this.destCity = destCity;
	}

	public String getDestCountry() {
		return destCountry;
	}

	public void setDestCountry(String destCountry) {
		this.destCountry = destCountry;
	}

}
