package com.qbt.persistent.entity;

import java.util.Date;

import com.qbt.common.entity.BaseEntity;

public class BaseTravelAgency extends BaseEntity {
	//旅行社名称	
    private String name;
    
    //成立时间
   	private String foundTime;
    
    private String treePath;
	
   	private Integer areaId;
    //旅行社地址
    private String address;
    //国内有多少条线路
    private Integer homeRouteNumber;
    //出境游有多少条线路
    private Integer abroadRouteNumber;
    //面向什么样的群体
    private String group;
    //旅行社负责人
    private String manager;
    //旅行社前台负责人
    private String frontManager;
    //旅行社简况
    private String brif;
    //最近三个月活动安排
    private String activity;
    //是否赛前微信公众号宣传
    private Boolean isWechatDeclare;
    //旅行社主办方讲解球包通使用方法
    private String qbtWay;
    //是否协助客户下单
    private Boolean isOrder;
    //是否放指示牌
    private Boolean isNote;
    //是否放宣传页
    private Boolean isDeclare;
    //是否放易拉宝
    private Boolean isYlb;
    
    //经度
    private Double lon;
    //纬度
    private Double lat;
    //负责人电话
    private String manageMobile;
    //前台负责人电话
    private String managerFrontMobile;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getHomeRouteNumber() {
        return homeRouteNumber;
    }

    public void setHomeRouteNumber(Integer homeRouteNumber) {
        this.homeRouteNumber = homeRouteNumber;
    }

    public Integer getAbroadRouteNumber() {
        return abroadRouteNumber;
    }

    public void setAbroadRouteNumber(Integer abroadRouteNumber) {
        this.abroadRouteNumber = abroadRouteNumber;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group == null ? null : group.trim();
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public String getFrontManager() {
        return frontManager;
    }

    public void setFrontManager(String frontManager) {
        this.frontManager = frontManager == null ? null : frontManager.trim();
    }

    public String getBrif() {
        return brif;
    }

    public void setBrif(String brif) {
        this.brif = brif == null ? null : brif.trim();
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity == null ? null : activity.trim();
    }

    public Boolean getIsWechatDeclare() {
        return isWechatDeclare;
    }

    public void setIsWechatDeclare(Boolean isWechatDeclare) {
        this.isWechatDeclare = isWechatDeclare;
    }

    public String getQbtWay() {
        return qbtWay;
    }

    public void setQbtWay(String qbtWay) {
        this.qbtWay = qbtWay == null ? null : qbtWay.trim();
    }

    public Boolean getIsOrder() {
        return isOrder;
    }

    public void setIsOrder(Boolean isOrder) {
        this.isOrder = isOrder;
    }

    public Boolean getIsNote() {
        return isNote;
    }

    public void setIsNote(Boolean isNote) {
        this.isNote = isNote;
    }

    public Boolean getIsDeclare() {
        return isDeclare;
    }

    public void setIsDeclare(Boolean isDeclare) {
        this.isDeclare = isDeclare;
    }

    public Boolean getIsYlb() {
        return isYlb;
    }

    public void setIsYlb(Boolean isYlb) {
        this.isYlb = isYlb;
    }

	public String getTreePath() {
		return treePath;
	}

	public void setTreePath(String treePath) {
		this.treePath = treePath;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getFoundTime() {
		return foundTime;
	}

	public void setFoundTime(String foundTime) {
		this.foundTime = foundTime;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public String getManageMobile() {
		return manageMobile;
	}

	public void setManageMobile(String manageMobile) {
		this.manageMobile = manageMobile;
	}

	public String getManagerFrontMobile() {
		return managerFrontMobile;
	}

	public void setManagerFrontMobile(String managerFrontMobile) {
		this.managerFrontMobile = managerFrontMobile;
	}


}