package com.qbt.web.pojo.brand;

import com.qbt.common.result.Paging;

public class BrandPageReqVo extends Paging {

	// 寄件人名字
	private String contactName;

	// 球包牌号码
	private String bagNo;

	// rfid编码
	private String rfidNo;

	// 状态 1-有效 2-无效
	private Integer state;
	
	// 备注
	private String remark;

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getBagNo() {
		return bagNo;
	}

	public void setBagNo(String bagNo) {
		this.bagNo = bagNo;
	}

	public String getRfidNo() {
		return rfidNo;
	}

	public void setRfidNo(String rfidNo) {
		this.rfidNo = rfidNo;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
