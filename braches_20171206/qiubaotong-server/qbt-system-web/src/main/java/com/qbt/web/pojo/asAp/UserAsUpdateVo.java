package com.qbt.web.pojo.asAp;

import javax.validation.constraints.NotNull;

public class UserAsUpdateVo {
	
	@NotNull(message = "助理ID不能为空")
	private Integer assistantId;

	private String memo;
	
	@NotNull(message = "状态不能为空")
	private Integer status;
	
	public Integer getAssistantId() {
		return assistantId;
	}

	public void setAssistantId(Integer assistantId) {
		this.assistantId = assistantId;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
