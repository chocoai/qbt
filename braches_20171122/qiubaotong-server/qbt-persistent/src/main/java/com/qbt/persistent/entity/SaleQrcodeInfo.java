package com.qbt.persistent.entity;


import com.qbt.common.entity.BaseEntity;

public class SaleQrcodeInfo extends BaseEntity{

    private String salesmanCode;

    private Integer applyStatus;

    private String company;

    private String ticket;

    private String qrcode;

    private Integer type;

    private Double typeValue;

    private Double subscribeValue;
    
    private Integer qrcodeCreateInfoId;
    
    //销售人员名称
    private String name;
    
    private String qrcodeCreateInfoName;
    
    private Integer firstType;
    
    private Double firstTypeValue;
    
    private Integer orderDayType;
    
    private Integer orderDayValue;
    
    private Integer saleUserId;

    public String getSalesmanCode() {
        return salesmanCode;
    }

    public void setSalesmanCode(String salesmanCode) {
        this.salesmanCode = salesmanCode == null ? null : salesmanCode.trim();
    }

    public Integer getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(Integer applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket == null ? null : ticket.trim();
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode == null ? null : qrcode.trim();
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

	public Integer getQrcodeCreateInfoId() {
		return qrcodeCreateInfoId;
	}

	public void setQrcodeCreateInfoId(Integer qrcodeCreateInfoId) {
		this.qrcodeCreateInfoId = qrcodeCreateInfoId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQrcodeCreateInfoName() {
		return qrcodeCreateInfoName;
	}

	public void setQrcodeCreateInfoName(String qrcodeCreateInfoName) {
		this.qrcodeCreateInfoName = qrcodeCreateInfoName;
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

	public Integer getSaleUserId() {
		return saleUserId;
	}

	public void setSaleUserId(Integer saleUserId) {
		this.saleUserId = saleUserId;
	}

	public void setOrderDayValue(Integer orderDayValue) {
		this.orderDayValue = orderDayValue;
	}

}