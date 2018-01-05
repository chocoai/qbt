package com.qbt.persistent.entity;

import com.qbt.common.entity.BaseEntity;

public class OrderExceptionBook extends BaseEntity{
    
	 /**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;
	
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
    private String remark;

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