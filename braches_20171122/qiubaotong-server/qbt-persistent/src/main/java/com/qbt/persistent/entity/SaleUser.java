package com.qbt.persistent.entity;

import java.util.Date;

import com.qbt.common.entity.BaseEntity;

public class SaleUser extends BaseEntity {

    private String salesmanCode;

    private Integer userId;

    private String name;

    private String mobile;

    private String idcard;

    private String idcardUrl;

    private String email;

    private String company;

    private String qrcode;

    private Integer type;

    private Double typeValue;

    private Double subscribeValue;

    private Integer applyStatus;
    
    private Date applyTime;
    
    private Integer status;

    private Date statusTime;
    
    private Integer sysUserId;

    private String sysUserName;

    private String sysUserMobile;
    
    private Integer firstType;
    
    private Double firstTypeValue;
    
    private Integer orderDayType;
    
    private Integer orderDayValue;
    
    private int activityId; //现金券活动id
    
    public String getSalesmanCode() {
        return salesmanCode;
    }

    public void setSalesmanCode(String salesmanCode) {
        this.salesmanCode = salesmanCode == null ? null : salesmanCode.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getIdcardUrl() {
        return idcardUrl;
    }

    public void setIdcardUrl(String idcardUrl) {
        this.idcardUrl = idcardUrl == null ? null : idcardUrl.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
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

    public Integer getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(Integer applyStatus) {
        this.applyStatus = applyStatus;
    }

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
		this.sysUserName = sysUserName;
	}

	public String getSysUserMobile() {
		return sysUserMobile;
	}

	public void setSysUserMobile(String sysUserMobile) {
		this.sysUserMobile = sysUserMobile;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public Date getStatusTime() {
		return statusTime;
	}

	public void setStatusTime(Date statusTime) {
		this.statusTime = statusTime;
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

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

}