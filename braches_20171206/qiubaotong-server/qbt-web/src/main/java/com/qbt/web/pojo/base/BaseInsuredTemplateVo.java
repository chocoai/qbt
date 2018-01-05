package com.qbt.web.pojo.base;

/**
 *  保价模板
 * @author share
 *
 */
public class BaseInsuredTemplateVo{

    private double min;

    private double max;
    
    private double insuredPrice;

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getInsuredPrice() {
		return insuredPrice;
	}

	public void setInsuredPrice(double insuredPrice) {
		this.insuredPrice = insuredPrice;
	}

    
}