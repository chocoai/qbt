package com.qbt.web.pojo.vipCreateInfo;

import java.util.Date;

public class VipCreateInfoVo {
	
	private int id;
	
	private Date createTime;
	
	private Date updateTime;
	
    private Integer vipCreateId;

    private String vipNo;

    private String vipRandom;

    private String vipOrderNumber;

    private Integer sellStatus;

    private Double payAmount;

    private Integer payMethod;

    private Integer activateStatus;

    private Date activateDate;

    private Integer activateMethod;

    private String remark;

    private Integer status;

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

	public Integer getVipCreateId() {
        return vipCreateId;
    }

    public void setVipCreateId(Integer vipCreateId) {
        this.vipCreateId = vipCreateId;
    }

    public String getVipNo() {
        return vipNo;
    }

    public void setVipNo(String vipNo) {
        this.vipNo = vipNo == null ? null : vipNo.trim();
    }

    public String getVipRandom() {
        return vipRandom;
    }

    public void setVipRandom(String vipRandom) {
        this.vipRandom = vipRandom == null ? null : vipRandom.trim();
    }

    public String getVipOrderNumber() {
        return vipOrderNumber;
    }

    public void setVipOrderNumber(String vipOrderNumber) {
        this.vipOrderNumber = vipOrderNumber == null ? null : vipOrderNumber.trim();
    }

    public Integer getSellStatus() {
        return sellStatus;
    }

    public void setSellStatus(Integer sellStatus) {
        this.sellStatus = sellStatus;
    }

    public Double getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(Double payAmount) {
		this.payAmount = payAmount;
	}

	public Integer getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    public Integer getActivateStatus() {
        return activateStatus;
    }

    public void setActivateStatus(Integer activateStatus) {
        this.activateStatus = activateStatus;
    }

    public Date getActivateDate() {
        return activateDate;
    }

    public void setActivateDate(Date activateDate) {
        this.activateDate = activateDate;
    }

    public Integer getActivateMethod() {
        return activateMethod;
    }

    public void setActivateMethod(Integer activateMethod) {
        this.activateMethod = activateMethod;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}