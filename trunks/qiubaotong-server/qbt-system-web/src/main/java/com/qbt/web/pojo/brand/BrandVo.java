package com.qbt.web.pojo.brand;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class BrandVo{
	
	//id
	private int id;
	
	//创建时间
	private Date createTime;
	
	//更新时间
	private Date updateTime;
	
	//寄件人id
	private int contactId;
	
	//寄件人名字
	private String contactName;
	
	//球包牌号码
	@NotNull(message = "球包牌号码不能为空")
    private String bagNo;
	
	//rfid编码
	@NotNull(message = "rfid编码不能为空")
    private String rfidNo;
    
    //状态 1-有效 2-无效
	@NotNull(message = "状态不能为空")
	@Min(value = 1, message = "非法状态")
	@Max(value = 2, message = "非法状态")
    private Integer state;
    
    //备注
	@NotNull(message = "备注不能为空")
    private String remark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

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
