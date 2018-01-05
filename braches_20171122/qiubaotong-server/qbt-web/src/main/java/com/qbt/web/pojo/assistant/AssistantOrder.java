package com.qbt.web.pojo.assistant;

import javax.validation.constraints.NotNull;

public class AssistantOrder {

	@NotNull(message="类型不能为空")
	private Integer applyType;
	@NotNull(message="工作场所不能为空")
	private Integer applyId;
	@NotNull(message="订单类型不能为空")
	private Integer type;  // 1-收 2-寄
	private String keyword;
	public Integer getApplyType() {
		return applyType;
	}
	public void setApplyType(Integer applyType) {
		this.applyType = applyType;
	}
	public Integer getApplyId() {
		return applyId;
	}
	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
}
