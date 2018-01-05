package com.qbt.web.pojo.sysLogs;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class SysLogsVo {
	
	private int id;
	
	@NotNull(message = "类型不能为空")
	private int type;
	
	@NotNull(message = "描述不能为空")
	private String memo;
	
	@NotNull(message = "状态不能为空")
	private int status;
	
	private Date createTime;
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

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
	
}
