package com.qbt.web.pojo.popUp;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class PopUpVo {
	
	private int id;
	
	private Date createTime;
	
	private Date updateTime;
	
	@NotNull(message = "弹框名称不能为空")
    private String name;
	
	@NotNull(message = "平台不能为空")
    private Integer platform;
	
	@NotNull(message = "触发条件不能为空")
    private Integer conditionType;

	@NotNull(message = "顺序不能为空")
    private Integer sort;

	@NotNull(message = "内容类型不能为空")
    private Integer contentType;

    private String content;

    private Integer status;
    
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

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    public Integer getConditionType() {
        return conditionType;
    }

    public void setConditionType(Integer conditionType) {
        this.conditionType = conditionType;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}