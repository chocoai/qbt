package com.qbt.web.pojo.popUp;

public class PopUpConfigVo {
	
	private int id;

    private Integer popUpId;

    private String popUpName;

    private Integer conditionId;

    private String conditionName;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
}