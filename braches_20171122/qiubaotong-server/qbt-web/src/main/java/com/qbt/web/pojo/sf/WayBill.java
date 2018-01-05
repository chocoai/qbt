package com.qbt.web.pojo.sf;


public class WayBill {

	//运单编号
	private String mailNo;
	
	//物流公司
	private String deliverCompany ;
	
    //路由节点产生的时间,格式:YYYY- MM-DD HH24:MM:SS,示例:2012-7- 30 09:30:00
    private long acceptTime;
    
    //路由节点发生的城市
    private String acceptAddress;
    
    //路由节点具体描述
    private String remark;

	public String getMailNo() {
		return mailNo;
	}

	public void setMailNo(String mailNo) {
		this.mailNo = mailNo;
	}

	public String getDeliverCompany() {
		return deliverCompany;
	}

	public void setDeliverCompany(String deliverCompany) {
		this.deliverCompany = deliverCompany;
	}

	public long getAcceptTime() {
		return acceptTime;
	}

	public void setAcceptTime(long acceptTime) {
		this.acceptTime = acceptTime;
	}

	public String getAcceptAddress() {
		return acceptAddress;
	}

	public void setAcceptAddress(String acceptAddress) {
		this.acceptAddress = acceptAddress;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
    
    
}
