package com.qbt.web.pojo.urgent;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class UrgentVo {
	
	private int id;//id

    private Date createTime;//创建时间
    private Date updateTime;//创建时间
    
    @NotNull(message = "名称不能为空")
    private String name;//活动名称
    
    private Integer price;//价格
    
    @NotNull(message = "原寄地省不能为空")
    private String fromProvince;// 原寄地省
    @NotNull(message = "原寄地市不能为空")
    private String fromCity;// 原寄地市
    @NotNull(message = "目的地省不能为空")
    private String toProvince;// 目的地省
    @NotNull(message = "目的地市不能为空")
    private String toCity;// 目的地市
    
    private String description;
    
    private Integer operator; // 操作人
    
    private String operatorName; // 操作人

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getFromProvince() {
		return fromProvince;
	}

	public void setFromProvince(String fromProvince) {
		this.fromProvince = fromProvince;
	}

	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public String getToProvince() {
		return toProvince;
	}

	public void setToProvince(String toProvince) {
		this.toProvince = toProvince;
	}

	public String getToCity() {
		return toCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getOperator() {
		return operator;
	}

	public void setOperator(Integer operator) {
		this.operator = operator;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	
}
