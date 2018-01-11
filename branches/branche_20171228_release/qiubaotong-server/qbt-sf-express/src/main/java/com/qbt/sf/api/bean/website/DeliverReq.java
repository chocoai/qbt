package com.qbt.sf.api.bean.website;

public class DeliverReq {

	private String srcCode;
	
	private String destCode;
	
	private String time;
	
	private Integer srcAreaId;
	
	private Integer destAreaId;

	public String getSrcCode() {
		return srcCode;
	}

	public void setSrcCode(String srcCode) {
		this.srcCode = srcCode;
	}

	public String getDestCode() {
		return destCode;
	}

	public void setDestCode(String destCode) {
		this.destCode = destCode;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getSrcAreaId() {
		return srcAreaId;
	}

	public void setSrcAreaId(Integer srcAreaId) {
		this.srcAreaId = srcAreaId;
	}

	public Integer getDestAreaId() {
		return destAreaId;
	}

	public void setDestAreaId(Integer destAreaId) {
		this.destAreaId = destAreaId;
	}
	
	
}
