package com.qbt.web.pojo.bspAreaConfig;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class BspAreaConfigVo {
	
	private int id;
	
	private Date createTime; 
	
	// 源省
	private String srcProvince;

	// 源市
	private String srcCity;

	// 源区
	@NotNull(message = "源区不能为空")
	private String srcCountry;
	
	// 源地区ID
	@NotNull(message = "源地区ID不能为空")
	private Integer srcAreaId;

	// 目标省
	private String destProvince;

	// 目标市
	private String destCity;

	// 目标区
	@NotNull(message = "目标区不能为空")
	private String destCountry;
	
	// 目标地区ID
	@NotNull(message = "目标地区ID不能为空")
	private Integer destAreaId;

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

	public Integer getSrcAreaId() {
		return srcAreaId;
	}

	public void setSrcAreaId(Integer srcAreaId) {
		this.srcAreaId = srcAreaId;
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

	public Integer getDestAreaId() {
		return destAreaId;
	}

	public void setDestAreaId(Integer destAreaId) {
		this.destAreaId = destAreaId;
	}

}
