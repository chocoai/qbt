package com.qbt.persistent.entity;

import com.qbt.common.entity.BaseEntity;

public class UserAssistantApply extends BaseEntity{

    private Integer assistantId;

    private String name;

    private String identityCode;

    private String photo1Url;

    private String photo2Url;

    private Integer applyType;

    private Integer applyId;

    private String applyName;

    private String remark;
    
    private int status;

	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	/**
	 * getter method 
	 * @Title: getAssistantId
	 * @return the assistantId
	 */
	
	public Integer getAssistantId() {
		return assistantId;
	}

	
	/**
	* setter method
	* @param assistantId the assistantId to set
	*/
	
	public void setAssistantId(Integer assistantId) {
		this.assistantId = assistantId;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdentityCode() {
        return identityCode;
    }

    public void setIdentityCode(String identityCode) {
        this.identityCode = identityCode == null ? null : identityCode.trim();
    }

    public String getPhoto1Url() {
        return photo1Url;
    }

    public void setPhoto1Url(String photo1Url) {
        this.photo1Url = photo1Url == null ? null : photo1Url.trim();
    }

    public String getPhoto2Url() {
        return photo2Url;
    }

    public void setPhoto2Url(String photo2Url) {
        this.photo2Url = photo2Url == null ? null : photo2Url.trim();
    }

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

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName == null ? null : applyName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

}