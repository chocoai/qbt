package com.qbt.web.pojo.order;

import java.util.Date;

public class OrderOperateLogVo {
	
	//id
	private Integer id;
	
	//创建时间
	private Date createTime;
	
	//操作者类型：1:客户;2:客服;3:球场工作人员;4:顺丰系统;5:球包通系统;6:微信
	private Integer operatorType;
	
	//姓名
    private String operatorName;
    
    //订单ID
    private Integer orderId;
    
    /*
     * 操作者ID，如果是客服，对应Account.Id，
     * 如果是客户，对应 User.Id，
     * 如果是球场工作人员，对应UserCourse.Id，
     * 其余为0
     */
    private Integer operatorId;
    
    //客服操作类型
    private String action;
    
    //操作结果
    private String description;

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

	public Integer getOperatorType() {
		return operatorType;
	}

	public void setOperatorType(Integer operatorType) {
		this.operatorType = operatorType;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
}
