package com.qbt.persistent.entity;

import java.util.Date;

import com.qbt.common.entity.BaseEntity;

public class BaseSpecialStore extends BaseEntity {
	//专卖店名称
    private String name;
    
    //成立时间
   	private String foundTime;
    
    private String treePath;
	
   	private Integer areaId;
    //专卖店地址
    private String address;
    //有多少家分店
    private Integer storesNumber;
    //每日营业时间
    private String businessTime;
    //经度
    private Double lon;
    //纬度
    private Double lat;
    //专卖店负责人
    private String manager;
    //专卖店前台负责人
    private String frontManager;
    //专卖店销售负责人
    private String managerSale;
    //专卖店经营范围
    private String businessScope;
    //距离最近的球场（公里/km）
    private String nearestCourse;
    //距离最近的工坊（公里/km
    private String nearestWorkshop;
    //距离最近的练习场（公里/km）
    private String nearestPracticRange;
    //距离最近高铁站名称
    private String nearestRailName;
    //距离最近高铁站（公里/km）
    private String nearestRail;
    //高速公路出口到专卖店的距离（公里/km）
    private String highwayStore;
    //距离最近机场(公里/km)
    private String nearestAirport;
    //距离最近顺丰配送点（公里）
    private String nearestSf;
    //附近有哪些物流公司可到达
    private String goodsCompany;
    //是否配合接包
    private Boolean isJoinBag;
    //接包地点
    private String joinBagAddress;
    //是否免费存包（价格/元）
    private Boolean isFeeBag;
    //存包地点
    private String putBagAddress;
    //是否配合收包
    private Boolean isCollectBag;
    //收包地点
    private String collectBagAddress;
    //（接包、取包、收包）部门
    private String department;
    //专人负责球包（姓名/联系方式）
    private String bagWorker;
    //是否放指示牌
    private Boolean isNote;
    //是否放宣传页
    private Boolean isDeclare;
    //是否放球包贴
    private Boolean isPosts;
    //是否放易拉宝
    private Boolean isYlb;
    //是否协助客户下单
    private Boolean isOrder;
    //是否宣传球包快递服务
    private Boolean isDeclareService;
    
    //专卖店负责人电话
    private String manageMobile;
    //专卖店前台负责人电话
    private String managerFrontMobile;
    //专卖店销售负责人电话
    private String managerSaleMobile;
    
    //专人负责球包（联系方式）
    private String bagWorkerMobile;
    
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

    public Integer getStoresNumber() {
        return storesNumber;
    }

    public void setStoresNumber(Integer storesNumber) {
        this.storesNumber = storesNumber;
    }

    public String getBusinessTime() {
        return businessTime;
    }

    public void setBusinessTime(String businessTime) {
        this.businessTime = businessTime == null ? null : businessTime.trim();
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

    public String getManagerSale() {
        return managerSale;
    }

    public void setManagerSale(String managerSale) {
        this.managerSale = managerSale == null ? null : managerSale.trim();
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope == null ? null : businessScope.trim();
    }

    public String getNearestCourse() {
        return nearestCourse;
    }

    public void setNearestCourse(String nearestCourse) {
        this.nearestCourse = nearestCourse == null ? null : nearestCourse.trim();
    }

    public String getNearestWorkshop() {
        return nearestWorkshop;
    }

    public void setNearestWorkshop(String nearestWorkshop) {
        this.nearestWorkshop = nearestWorkshop == null ? null : nearestWorkshop.trim();
    }

    public String getNearestPracticRange() {
        return nearestPracticRange;
    }

    public void setNearestPracticRange(String nearestPracticRange) {
        this.nearestPracticRange = nearestPracticRange == null ? null : nearestPracticRange.trim();
    }

    public String getNearestRailName() {
        return nearestRailName;
    }

    public void setNearestRailName(String nearestRailName) {
        this.nearestRailName = nearestRailName == null ? null : nearestRailName.trim();
    }

    public String getNearestRail() {
        return nearestRail;
    }

    public void setNearestRail(String nearestRail) {
        this.nearestRail = nearestRail == null ? null : nearestRail.trim();
    }

    public String getHighwayStore() {
        return highwayStore;
    }

    public void setHighwayStore(String highwayStore) {
        this.highwayStore = highwayStore == null ? null : highwayStore.trim();
    }

    public String getNearestAirport() {
        return nearestAirport;
    }

    public void setNearestAirport(String nearestAirport) {
        this.nearestAirport = nearestAirport == null ? null : nearestAirport.trim();
    }

    public String getNearestSf() {
        return nearestSf;
    }

    public void setNearestSf(String nearestSf) {
        this.nearestSf = nearestSf == null ? null : nearestSf.trim();
    }

    public String getGoodsCompany() {
        return goodsCompany;
    }

    public void setGoodsCompany(String goodsCompany) {
        this.goodsCompany = goodsCompany == null ? null : goodsCompany.trim();
    }

    public Boolean getIsJoinBag() {
        return isJoinBag;
    }

    public void setIsJoinBag(Boolean isJoinBag) {
        this.isJoinBag = isJoinBag;
    }

    public String getJoinBagAddress() {
        return joinBagAddress;
    }

    public void setJoinBagAddress(String joinBagAddress) {
        this.joinBagAddress = joinBagAddress == null ? null : joinBagAddress.trim();
    }

    public Boolean getIsFeeBag() {
        return isFeeBag;
    }

    public void setIsFeeBag(Boolean isFeeBag) {
        this.isFeeBag = isFeeBag;
    }

    public String getPutBagAddress() {
        return putBagAddress;
    }

    public void setPutBagAddress(String putBagAddress) {
        this.putBagAddress = putBagAddress == null ? null : putBagAddress.trim();
    }

    public Boolean getIsCollectBag() {
        return isCollectBag;
    }

    public void setIsCollectBag(Boolean isCollectBag) {
        this.isCollectBag = isCollectBag;
    }

    public String getCollectBagAddress() {
        return collectBagAddress;
    }

    public void setCollectBagAddress(String collectBagAddress) {
        this.collectBagAddress = collectBagAddress == null ? null : collectBagAddress.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getBagWorker() {
        return bagWorker;
    }

    public void setBagWorker(String bagWorker) {
        this.bagWorker = bagWorker == null ? null : bagWorker.trim();
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

    public Boolean getIsPosts() {
        return isPosts;
    }

    public void setIsPosts(Boolean isPosts) {
        this.isPosts = isPosts;
    }

    public Boolean getIsYlb() {
        return isYlb;
    }

    public void setIsYlb(Boolean isYlb) {
        this.isYlb = isYlb;
    }

    public Boolean getIsOrder() {
        return isOrder;
    }

    public void setIsOrder(Boolean isOrder) {
        this.isOrder = isOrder;
    }

    public Boolean getIsDeclareService() {
        return isDeclareService;
    }

    public void setIsDeclareService(Boolean isDeclareService) {
        this.isDeclareService = isDeclareService;
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

	public String getManageMobile() {
		return manageMobile;
	}

	public void setManageMobile(String manageMobile) {
		this.manageMobile = manageMobile;
	}

	public String getManagerSaleMobile() {
		return managerSaleMobile;
	}

	public void setManagerSaleMobile(String managerSaleMobile) {
		this.managerSaleMobile = managerSaleMobile;
	}

	public String getManagerFrontMobile() {
		return managerFrontMobile;
	}

	public void setManagerFrontMobile(String managerFrontMobile) {
		this.managerFrontMobile = managerFrontMobile;
	}

	public String getBagWorkerMobile() {
		return bagWorkerMobile;
	}

	public void setBagWorkerMobile(String bagWorkerMobile) {
		this.bagWorkerMobile = bagWorkerMobile;
	}

	
}