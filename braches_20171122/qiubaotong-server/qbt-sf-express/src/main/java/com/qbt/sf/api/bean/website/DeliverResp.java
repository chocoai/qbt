package com.qbt.sf.api.bean.website;

public class DeliverResp {

	private String currencyName;
	
	private String destCurrencyName;
	
	private double freight;
	
	private String limitTypeName;
	
	private String weight;
	
	private String deliverTime;
	
	private String addTime;
	
	private String businessType;

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public String getDestCurrencyName() {
		return destCurrencyName;
	}

	public void setDestCurrencyName(String destCurrencyName) {
		this.destCurrencyName = destCurrencyName;
	}

	public double getFreight() {
		return freight;
	}

	public void setFreight(double freight) {
		this.freight = freight;
	}

	public String getLimitTypeName() {
		return limitTypeName;
	}

	/**
	 * 1-次日达
	   2-隔日达
	   5-次午达
	  * @Title: setLimitTypeName
	  * @Description: TODO
	  * @author: share 2016年8月23日
	  * @modify: share 2016年8月23日
	  * @param limitTypeName
	 */
	public void setLimitTypeName(String limitTypeName) {
		if("顺丰次晨".equalsIgnoreCase(limitTypeName)){
			this.businessType = "5";
		}else if("顺丰次日".equalsIgnoreCase(limitTypeName)){
			this.businessType = "1";
		}else if("顺丰隔日".equalsIgnoreCase(limitTypeName)){
			this.businessType = "2";
		}else if("顺丰标快".equalsIgnoreCase(limitTypeName)){
			this.businessType = "1";
		}else if("顺丰特惠".equalsIgnoreCase(limitTypeName)){
			this.businessType = "2";
		}
		
		this.limitTypeName = limitTypeName;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getDeliverTime() {
		return deliverTime;
	}

	public void setDeliverTime(String deliverTime) {
		this.deliverTime = deliverTime;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	
	
	
}
