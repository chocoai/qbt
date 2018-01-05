package com.qbt.persistent.entity;

import com.qbt.common.entity.BaseEntity;

public class SaleQrcodeCreateInfo extends BaseEntity {

    private String name;

    private Integer number;

    private Integer applyNumber;

    private String company;

    private Integer type;

    private Double typeValue;

    private Double subscribeValue;
    
    private Integer createType;
    
    private Integer firstType;
    
    private Double firstTypeValue;
    
    private Integer orderDayType;
    
    private Integer orderDayValue;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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
        this.company = company == null ? null : company.trim();
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

	public Double getSubscribeValue() {
		return subscribeValue;
	}

	public void setSubscribeValue(Double subscribeValue) {
		this.subscribeValue = subscribeValue;
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