package com.qbt.web.pojo.saleQrcodeCreateInfo;

import java.util.Date;

public class SaleQrcodeCreateInfoVo {

	private int id;
	
	//生成批次名称
	private String name;

	//生成数量
    private Integer number;
	 
	//已申请数量
	private Integer applyNumber;

	//工作单位
    private String company;

    //提成方式（0-未知 1-固定金额 2-订单金额比例）
    private Integer type;

    //每单提成
    private Double typeValue;
    
    //关注奖金金额
    private double subscribeValue;
	
    //生成日期
    private Date createTime;
    
    //1-人工 2-系统
    private Integer createType;
    
    //首单提成方式: 0-未知 1-固定金额 2-订单金额比例
    private Integer firstType;
    
    //每单提成
    private Double firstTypeValue;
    
    //代下单日类型 1-不限 2-有限制天数
    private Integer orderDayType;
    
    //代下单日
    private Integer orderDayValue;
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getApplyNumber() {
		return applyNumber;
	}

	public void setApplyNumber(Integer applyNumber) {
		this.applyNumber = applyNumber;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Double getTypeValue() {
		return typeValue;
	}

	public void setTypeValue(Double typeValue) {
		this.typeValue = typeValue;
	}

	public double getSubscribeValue() {
		return subscribeValue;
	}

	public void setSubscribeValue(double subscribeValue) {
		this.subscribeValue = subscribeValue;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getCreateType() {
		return createType;
	}

	public void setCreateType(Integer createType) {
		this.createType = createType;
	}

	public Integer getFirstType() {
		return firstType;
	}

	public void setFirstType(Integer firstType) {
		this.firstType = firstType;
	}

	public Double getFirstTypeValue() {
		return firstTypeValue;
	}

	public void setFirstTypeValue(Double firstTypeValue) {
		this.firstTypeValue = firstTypeValue;
	}

	public Integer getOrderDayType() {
		return orderDayType;
	}

	public void setOrderDayType(Integer orderDayType) {
		this.orderDayType = orderDayType;
	}

	public Integer getOrderDayValue() {
		return orderDayValue;
	}

	public void setOrderDayValue(Integer orderDayValue) {
		this.orderDayValue = orderDayValue;
	}

}
