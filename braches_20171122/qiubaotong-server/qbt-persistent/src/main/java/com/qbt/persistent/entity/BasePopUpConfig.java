package com.qbt.persistent.entity;

import com.qbt.common.entity.BaseEntity;

public class BasePopUpConfig extends BaseEntity {

    private Integer popUpId;

    private String popUpName;
    
    private Integer conditionType;

    private Integer conditionId;

    private String conditionName;

    public Integer getPopUpId() {
        return popUpId;
    }

    public void setPopUpId(Integer popUpId) {
        this.popUpId = popUpId;
    }

    public String getPopUpName() {
        return popUpName;
    }

    public void setPopUpName(String popUpName) {
        this.popUpName = popUpName == null ? null : popUpName.trim();
    }

    public Integer getConditionId() {
        return conditionId;
    }

    public void setConditionId(Integer conditionId) {
        this.conditionId = conditionId;
    }

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName == null ? null : conditionName.trim();
    }

	public Integer getConditionType() {
		return conditionType;
	}

	public void setConditionType(Integer conditionType) {
		this.conditionType = conditionType;
	}
}