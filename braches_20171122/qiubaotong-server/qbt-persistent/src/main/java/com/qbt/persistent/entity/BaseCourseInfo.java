package com.qbt.persistent.entity;

import java.util.Date;

public class BaseCourseInfo {
    private Integer courseId;

    private Integer golfHole;

    private String telephone;

    private String contact;

    private String mobile;

    private String remark;

    private String website;

    private String wechat;

    private Boolean hasAssistant;

    private String signPlace;

    private String sendPlace;

    private String startWorkTime;

    private String endWorkTime;

    private Float bagDepositCharge;

    private Short teeTimeInterval;

    private String teeTimeEarliest;

    private String teeTimeLatest;

    private String transitionClosedBeginTime;

    private String transitionClosedEndTime;

    private String weather;
    
    private String description;

    private String introducing;

    private String introducingHref;

    private String productIntro;

    private String featureIntro;

    private String foodIntro;

    private String otherIntro;
    
    //球场是否配有酒店（名称）
    private Boolean isHotel;
    //球场酒店地址
    private String hotelAddress;
    //球场酒店客房数量
    private int hotelRoomNumber;
    //球场酒店等级
    private int hotelLevel;
    //是否有区域限制
    private Boolean hotelAreaLimit;
    //是否有车辆限制
    private Boolean hotelCarLimit;
    //车辆进入球场是否需要交钱
    private Boolean isFee;
    //球场开业时间
    private String startTime;
    //球场简况
    private String brief;
    //开票信息
    private String checkMessage;
    //淡旺季开场时间
    private String lightVigorousTime;
    //每日营业时间
    private String businessTime;
    //每年打球人次
    private int playerNumber;
    //淡旺季打球人次（区间）
    private String lightVigorousPlayer;
    //本地打球人次
    private int localPlayerNumber;
    //距离最近顺丰配送点（公里）
    private String nearestSf;
    //网点发出班次时间
    private String siteTime;
    //顺丰网点统一收件时间
    private String sfTime;
    //球场平均气温
    private String temperature;
    //雨季分布情况
    private String rain;
    //距离最近的工坊（公里/km）
    private String nearestWorkshop;
    //距离球场最近酒店名称
    private String nearestHotel;
    //最近酒店客房数量
    private int nearestHotelRoomNumber;
    //最近酒店等级
    private int nearestHotelLevel;
    //距离最近高铁站名称
    private String nearestRail;
    //高速公路出口到球场的距离（公里/km）
    private String highwayCourse;
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
    //夜间派送地方
    private String nightAddress;
    //球场负责人（姓名/联系方式）
    private String courseWorker;
    //球场前台负责人（姓名/联系方式）
    private String courseFrontWorker;
    //保安联系方式
    private String police;
    //紧急联络人电话（姓名/联系方式）
    private String urgentPerson;
    //是否放指示牌
    private Boolean isNote;
    //是否放宣传页
    private Boolean isDeclare;
    //是否放易拉宝
    private Boolean isYlb;
    //是否协助客户下单
    private Boolean isOrder;
    //是否放球包贴
    private Boolean isPosts;
    //是否宣传球包快递服务
    private Boolean isDeclareService;
    
    //工作休息调整时间
    private String restTime;
    //外地打球人次
    private int otherPlayerNumber;
    //附近有哪些物流公司可到达
    private String goodsCompany; 
    //距离最近的练习场（公里/km）
    private String nearestPracticeArea;
    //距离球场最近酒店地址
    private String nearestHotelAddress;
    //距离最近机场(公里/km)
    private String  nearestAirport;
    //球场销售负责人（姓名/联系方式）
    private String managerSale;
    //紧急联络人微信
    private String urgentPersonWechat;
    
    private String nearestHightRail;
    
    //前台负责人电话
    private String managerFrontMobile;
    //负责人电话
    private String manageMobile;
    
    private String managerSaleMobile;
    
    //专人负责球包（联系方式）
    private String bagWorkerMobile;
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getIntroducing() {
        return introducing;
    }

    public void setIntroducing(String introducing) {
        this.introducing = introducing == null ? null : introducing.trim();
    }

    public String getIntroducingHref() {
        return introducingHref;
    }

    public void setIntroducingHref(String introducingHref) {
        this.introducingHref = introducingHref == null ? null : introducingHref.trim();
    }

    public String getProductIntro() {
        return productIntro;
    }

    public void setProductIntro(String productIntro) {
        this.productIntro = productIntro == null ? null : productIntro.trim();
    }

    public String getFeatureIntro() {
        return featureIntro;
    }

    public void setFeatureIntro(String featureIntro) {
        this.featureIntro = featureIntro == null ? null : featureIntro.trim();
    }

    public String getFoodIntro() {
        return foodIntro;
    }

    public void setFoodIntro(String foodIntro) {
        this.foodIntro = foodIntro == null ? null : foodIntro.trim();
    }

    public String getOtherIntro() {
        return otherIntro;
    }

    public void setOtherIntro(String otherIntro) {
        this.otherIntro = otherIntro == null ? null : otherIntro.trim();
    }


    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getGolfHole() {
        return golfHole;
    }

    public void setGolfHole(Integer golfHole) {
        this.golfHole = golfHole;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public Boolean getHasAssistant() {
        return hasAssistant;
    }

    public void setHasAssistant(Boolean hasAssistant) {
        this.hasAssistant = hasAssistant;
    }

    public String getSignPlace() {
        return signPlace;
    }

    public void setSignPlace(String signPlace) {
        this.signPlace = signPlace == null ? null : signPlace.trim();
    }

    public String getSendPlace() {
        return sendPlace;
    }

    public void setSendPlace(String sendPlace) {
        this.sendPlace = sendPlace == null ? null : sendPlace.trim();
    }

    public String getStartWorkTime() {
        return startWorkTime;
    }

    public void setStartWorkTime(String startWorkTime) {
        this.startWorkTime = startWorkTime == null ? null : startWorkTime.trim();
    }

    public String getEndWorkTime() {
        return endWorkTime;
    }

    public void setEndWorkTime(String endWorkTime) {
        this.endWorkTime = endWorkTime == null ? null : endWorkTime.trim();
    }

    public Float getBagDepositCharge() {
        return bagDepositCharge;
    }

    public void setBagDepositCharge(Float bagDepositCharge) {
        this.bagDepositCharge = bagDepositCharge;
    }

    public Short getTeeTimeInterval() {
        return teeTimeInterval;
    }

    public void setTeeTimeInterval(Short teeTimeInterval) {
        this.teeTimeInterval = teeTimeInterval;
    }

    public String getTeeTimeEarliest() {
        return teeTimeEarliest;
    }

    public void setTeeTimeEarliest(String teeTimeEarliest) {
        this.teeTimeEarliest = teeTimeEarliest == null ? null : teeTimeEarliest.trim();
    }

    public String getTeeTimeLatest() {
        return teeTimeLatest;
    }

    public void setTeeTimeLatest(String teeTimeLatest) {
        this.teeTimeLatest = teeTimeLatest == null ? null : teeTimeLatest.trim();
    }

    public String getTransitionClosedBeginTime() {
        return transitionClosedBeginTime;
    }

    public void setTransitionClosedBeginTime(String transitionClosedBeginTime) {
        this.transitionClosedBeginTime = transitionClosedBeginTime == null ? null : transitionClosedBeginTime.trim();
    }

    public String getTransitionClosedEndTime() {
        return transitionClosedEndTime;
    }

    public void setTransitionClosedEndTime(String transitionClosedEndTime) {
        this.transitionClosedEndTime = transitionClosedEndTime == null ? null : transitionClosedEndTime.trim();
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather == null ? null : weather.trim();
    }

	public Boolean getIsHotel() {
		return isHotel;
	}

	public void setIsHotel(Boolean isHotel) {
		this.isHotel = isHotel;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public int getHotelRoomNumber() {
		return hotelRoomNumber;
	}

	public void setHotelRoomNumber(int hotelRoomNumber) {
		this.hotelRoomNumber = hotelRoomNumber;
	}

	public int getHotelLevel() {
		return hotelLevel;
	}

	public void setHotelLevel(int hotelLevel) {
		this.hotelLevel = hotelLevel;
	}

	public Boolean getHotelAreaLimit() {
		return hotelAreaLimit;
	}

	public void setHotelAreaLimit(Boolean hotelAreaLimit) {
		this.hotelAreaLimit = hotelAreaLimit;
	}

	public Boolean getHotelCarLimit() {
		return hotelCarLimit;
	}

	public void setHotelCarLimit(Boolean hotelCarLimit) {
		this.hotelCarLimit = hotelCarLimit;
	}

	public Boolean getIsFee() {
		return isFee;
	}

	public void setIsFee(Boolean isFee) {
		this.isFee = isFee;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getCheckMessage() {
		return checkMessage;
	}

	public void setCheckMessage(String checkMessage) {
		this.checkMessage = checkMessage;
	}

	public String getLightVigorousTime() {
		return lightVigorousTime;
	}

	public void setLightVigorousTime(String lightVigorousTime) {
		this.lightVigorousTime = lightVigorousTime;
	}

	public int getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	public String getLightVigorousPlayer() {
		return lightVigorousPlayer;
	}

	public void setLightVigorousPlayer(String lightVigorousPlayer) {
		this.lightVigorousPlayer = lightVigorousPlayer;
	}

	public int getLocalPlayerNumber() {
		return localPlayerNumber;
	}

	public void setLocalPlayerNumber(int localPlayerNumber) {
		this.localPlayerNumber = localPlayerNumber;
	}

	public String getNearestSf() {
		return nearestSf;
	}

	public void setNearestSf(String nearestSf) {
		this.nearestSf = nearestSf;
	}

	public String getSiteTime() {
		return siteTime;
	}

	public void setSiteTime(String siteTime) {
		this.siteTime = siteTime;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getRain() {
		return rain;
	}

	public void setRain(String rain) {
		this.rain = rain;
	}

	public String getNearestWorkshop() {
		return nearestWorkshop;
	}

	public void setNearestWorkshop(String nearestWorkshop) {
		this.nearestWorkshop = nearestWorkshop;
	}

	public String getNearestHotel() {
		return nearestHotel;
	}

	public void setNearestHotel(String nearestHotel) {
		this.nearestHotel = nearestHotel;
	}

	public int getNearestHotelRoomNumber() {
		return nearestHotelRoomNumber;
	}

	public void setNearestHotelRoomNumber(int nearestHotelRoomNumber) {
		this.nearestHotelRoomNumber = nearestHotelRoomNumber;
	}

	public int getNearestHotelLevel() {
		return nearestHotelLevel;
	}

	public void setNearestHotelLevel(int nearestHotelLevel) {
		this.nearestHotelLevel = nearestHotelLevel;
	}

	public String getNearestRail() {
		return nearestRail;
	}

	public void setNearestRail(String nearestRail) {
		this.nearestRail = nearestRail;
	}

	public String getHighwayCourse() {
		return highwayCourse;
	}

	public void setHighwayCourse(String highwayCourse) {
		this.highwayCourse = highwayCourse;
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
		this.joinBagAddress = joinBagAddress;
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
		this.putBagAddress = putBagAddress;
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
		this.collectBagAddress = collectBagAddress;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getBagWorker() {
		return bagWorker;
	}

	public void setBagWorker(String bagWorker) {
		this.bagWorker = bagWorker;
	}

	public String getNightAddress() {
		return nightAddress;
	}

	public void setNightAddress(String nightAddress) {
		this.nightAddress = nightAddress;
	}

	public String getCourseWorker() {
		return courseWorker;
	}

	public void setCourseWorker(String courseWorker) {
		this.courseWorker = courseWorker;
	}

	public String getCourseFrontWorker() {
		return courseFrontWorker;
	}

	public void setCourseFrontWorker(String courseFrontWorker) {
		this.courseFrontWorker = courseFrontWorker;
	}

	public String getPolice() {
		return police;
	}

	public void setPolice(String police) {
		this.police = police;
	}

	public String getUrgentPerson() {
		return urgentPerson;
	}

	public void setUrgentPerson(String urgentPerson) {
		this.urgentPerson = urgentPerson;
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

	public Boolean getIsOrder() {
		return isOrder;
	}

	public void setIsOrder(Boolean isOrder) {
		this.isOrder = isOrder;
	}

	public Boolean getIsPosts() {
		return isPosts;
	}

	public void setIsPosts(Boolean isPosts) {
		this.isPosts = isPosts;
	}

	public Boolean getIsDeclareService() {
		return isDeclareService;
	}

	public void setIsDeclareService(Boolean isDeclareService) {
		this.isDeclareService = isDeclareService;
	}

	public String getRestTime() {
		return restTime;
	}

	public void setRestTime(String restTime) {
		this.restTime = restTime;
	}

	public int getOtherPlayerNumber() {
		return otherPlayerNumber;
	}

	public void setOtherPlayerNumber(int otherPlayerNumber) {
		this.otherPlayerNumber = otherPlayerNumber;
	}

	public String getGoodsCompany() {
		return goodsCompany;
	}

	public void setGoodsCompany(String goodsCompany) {
		this.goodsCompany = goodsCompany;
	}

	public String getNearestPracticeArea() {
		return nearestPracticeArea;
	}

	public void setNearestPracticeArea(String nearestPracticeArea) {
		this.nearestPracticeArea = nearestPracticeArea;
	}

	public String getNearestHotelAddress() {
		return nearestHotelAddress;
	}

	public void setNearestHotelAddress(String nearestHotelAddress) {
		this.nearestHotelAddress = nearestHotelAddress;
	}

	public String getNearestAirport() {
		return nearestAirport;
	}

	public void setNearestAirport(String nearestAirport) {
		this.nearestAirport = nearestAirport;
	}

	public String getManagerSale() {
		return managerSale;
	}

	public void setManagerSale(String managerSale) {
		this.managerSale = managerSale;
	}

	public String getUrgentPersonWechat() {
		return urgentPersonWechat;
	}

	public void setUrgentPersonWechat(String urgentPersonWechat) {
		this.urgentPersonWechat = urgentPersonWechat;
	}

	public String getNearestHightRail() {
		return nearestHightRail;
	}

	public void setNearestHightRail(String nearestHightRail) {
		this.nearestHightRail = nearestHightRail;
	}

	public String getBusinessTime() {
		return businessTime;
	}

	public void setBusinessTime(String businessTime) {
		this.businessTime = businessTime;
	}

	public String getManagerFrontMobile() {
		return managerFrontMobile;
	}

	public void setManagerFrontMobile(String managerFrontMobile) {
		this.managerFrontMobile = managerFrontMobile;
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

	public String getSfTime() {
		return sfTime;
	}

	public void setSfTime(String sfTime) {
		this.sfTime = sfTime;
	}

	public String getBagWorkerMobile() {
		return bagWorkerMobile;
	}

	public void setBagWorkerMobile(String bagWorkerMobile) {
		this.bagWorkerMobile = bagWorkerMobile;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

}