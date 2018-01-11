package com.qbt.web.pojo.orderCostItem;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class OrderCostItemVo {
	
	private int id;
	
	private Date createTime;
	
	@NotNull(message = "订单ID不能为空")
    private Integer orderId;
	
	@NotNull(message = "增减项目不能为空")
    private String item;
	
	@NotNull(message = "增减金额不能为空")
    private Double amount;

    private Integer sysUserId;

    private String sysUserName;

    private String sysUserMobile;

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

	public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item == null ? null : item.trim();
    }

    public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Integer sysUserId) {
        this.sysUserId = sysUserId;
    }

    public String getSysUserName() {
        return sysUserName;
    }

    public void setSysUserName(String sysUserName) {
        this.sysUserName = sysUserName == null ? null : sysUserName.trim();
    }

    public String getSysUserMobile() {
        return sysUserMobile;
    }

    public void setSysUserMobile(String sysUserMobile) {
        this.sysUserMobile = sysUserMobile == null ? null : sysUserMobile.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}