package com.qbt.web.pojo.assistant;

public class AssistantLoginResp {
	
	/**
	 * 0-未注册
	 * 1-审核状态
	 * 2-审核通过
	 * 3-审核拒绝
	 */
	private int status;
	private String memo;
	private int applyId;
	private int applyType;
	private String applyName;
	private String token;
	private int salesmanStatus;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public int getApplyId() {
		return applyId;
	}
	public void setApplyId(int applyId) {
		this.applyId = applyId;
	}
	public String getApplyName() {
		return applyName;
	}
	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getApplyType() {
		return applyType;
	}
	public void setApplyType(int applyType) {
		this.applyType = applyType;
	}
	public int getSalesmanStatus() {
		return salesmanStatus;
	}
	public void setSalesmanStatus(int salesmanStatus) {
		this.salesmanStatus = salesmanStatus;
	}
	
}
