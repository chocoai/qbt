package com.qbt.persistent.entity;

import com.qbt.common.entity.BaseEntity;

public class EmailTemplate extends BaseEntity {
	
	private String name;
	
    private String subject;

    private String content;

    private String code;

    private String platType;

    private Integer operatorId;

    private String operatorName;
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getPlatType() {
        return platType;
    }

    public void setPlatType(String platType) {
        this.platType = platType == null ? null : platType.trim();
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }
}