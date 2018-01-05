package com.qbt.sf.api.bean.orderfilterpush;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {}) 
public class OrderFilterPushRepOrder {
	@XmlAttribute
	private String orderid;
	
	@XmlAttribute
    private String mailno;
	
	@XmlAttribute
	private int filterResult;
	
	@XmlAttribute
    private String destCode;
	
	@XmlAttribute
	private String origincode;
	
	@XmlAttribute
	private String remark;
	 
	@XmlAttribute
	private String returnTrackingNo ;

	public String getDestCode() {
		return destCode;
	}

	public void setDestCode(String destCode) {
		this.destCode = destCode;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getMailno() {
		return mailno;
	}

	public void setMailno(String mailno) {
		this.mailno = mailno;
	}

	public int getFilterResult() {
		return filterResult;
	}

	public void setFilterResult(int filterResult) {
		this.filterResult = filterResult;
	}

	public String getOrigincode() {
		return origincode;
	}

	public void setOrigincode(String origincode) {
		this.origincode = origincode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getReturnTrackingNo() {
		return returnTrackingNo;
	}

	public void setReturnTrackingNo(String returnTrackingNo) {
		this.returnTrackingNo = returnTrackingNo;
	}
	
	
	
	
	
}
