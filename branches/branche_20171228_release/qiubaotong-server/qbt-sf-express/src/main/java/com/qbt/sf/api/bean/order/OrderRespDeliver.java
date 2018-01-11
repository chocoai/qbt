package com.qbt.sf.api.bean.order;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)  
@XmlType(propOrder = {}) 
public class OrderRespDeliver {
	@XmlAttribute(name="orderid")
	private String orderid;
	@XmlAttribute(name="mailno")
	private String mailno;
	@XmlAttribute(name="return_tracking_no")
	private String return_tracking_no;
	@XmlAttribute(name="origincode")
	private String origincode;
	@XmlAttribute(name="destcode")
	private String destcode;
	@XmlAttribute(name="filter_result")
	private int filter_result;
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
	public String getReturn_tracking_no() {
		return return_tracking_no;
	}
	public void setReturn_tracking_no(String return_tracking_no) {
		this.return_tracking_no = return_tracking_no;
	}
	public String getOrigincode() {
		return origincode;
	}
	public void setOrigincode(String origincode) {
		this.origincode = origincode;
	}
	public String getDestcode() {
		return destcode;
	}
	public void setDestcode(String destcode) {
		this.destcode = destcode;
	}
	public int getFilter_result() {
		return filter_result;
	}
	public void setFilter_result(int filter_result) {
		this.filter_result = filter_result;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@XmlAttribute(name="remark")
	private String remark;
	@Override
	public String toString() {
		return "OrderRespDeliver [orderid=" + orderid + ", mailno=" + mailno
				+ ", return_tracking_no=" + return_tracking_no
				+ ", origincode=" + origincode + ", destcode=" + destcode
				+ ", filter_result=" + filter_result + ", remark=" + remark
				+ "]";
	}
}


	
