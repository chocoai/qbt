package com.qbt.web.pojo.orderexception;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class OrderExceptionBookVo{
    
	//id
	@NotNull(message = "id不能为空")
	private Integer id;
	
	//创建时间
	private Date createTime;
	
	//更新时间
	private Date updateTime;
	
	//订单Id
	private Integer orderId;
	
	//订单号
    private String orderNumber;
    
    //任务类型：1:需对订单状态检查;2:订单状态在一定时间内没有变化;3:下单失败的;4:派送失败;5:球场端收件异常;6:快件已退回/转寄;7:快件已退回
    private Integer type;
    
    //订单最后的状态
    private Integer orderStatus;
    
    //是否被客服处理了
    private Boolean isDealed;
    
    //处理人ID
    private Integer sysUserId;
    
    //处理人名称
    private String userName;
    
    //描述
    private String description;
    
    //处理备注
    @NotNull(message = "处理备注不能为空")
    private String remark;

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Boolean getIsDealed() {
        return isDealed;
    }

    public void setIsDealed(Boolean isDealed) {
        this.isDealed = isDealed;
    }

    public Integer getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Integer sysUserId) {
        this.sysUserId = sysUserId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
}