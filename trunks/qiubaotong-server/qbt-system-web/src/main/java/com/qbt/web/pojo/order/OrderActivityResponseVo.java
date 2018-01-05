package com.qbt.web.pojo.order;

public class OrderActivityResponseVo {

	  private Boolean jActivity = false;
	  
	  private Boolean dActivity = false;
	  
	  private double jAmount;
	  
	  private double dAmount;
	  
	  private int activityId;
	  
	  private String activitName;
	  
	  private int activityType;

	public Boolean getjActivity() {
		return jActivity;
	}

	public void setjActivity(Boolean jActivity) {
		this.jActivity = jActivity;
	}

	public Boolean getdActivity() {
		return dActivity;
	}

	public void setdActivity(Boolean dActivity) {
		this.dActivity = dActivity;
	}

	public double getjAmount() {
		return jAmount;
	}

	public void setjAmount(double jAmount) {
		this.jAmount = jAmount;
	}

	public double getdAmount() {
		return dAmount;
	}

	public void setdAmount(double dAmount) {
		this.dAmount = dAmount;
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public String getActivitName() {
		return activitName;
	}

	public void setActivitName(String activitName) {
		this.activitName = activitName;
	}

	public int getActivityType() {
		return activityType;
	}

	public void setActivityType(int activityType) {
		this.activityType = activityType;
	}
	  
	
}
