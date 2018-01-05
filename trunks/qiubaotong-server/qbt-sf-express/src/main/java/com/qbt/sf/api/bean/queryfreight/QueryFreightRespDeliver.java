package com.qbt.sf.api.bean.queryfreight;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {}) 
public class QueryFreightRespDeliver {
	@XmlAttribute(name="freight_fee")
	private int freight_fee;
	
	@XmlAttribute(name="remark")
	private int remark;

	@Override
	public String toString() {
		return "QueryFreightRespDeliver [freight_fee=" + freight_fee
				+ ", remark=" + remark + "]";
	}

	public int getFreight_fee() {
		return freight_fee;
	}

	public void setFreight_fee(int freight_fee) {
		this.freight_fee = freight_fee;
	}

	public int getRemark() {
		return remark;
	}

	public void setRemark(int remark) {
		this.remark = remark;
	}
}

