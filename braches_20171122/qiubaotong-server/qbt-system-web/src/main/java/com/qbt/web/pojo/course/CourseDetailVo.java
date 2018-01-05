package com.qbt.web.pojo.course;

import javax.validation.constraints.NotNull;

public class CourseDetailVo {
	
	//id
	private int id;
	
	//名称
	@NotNull(message = "球场名称不能为空")
	private String name;
	
	//简称
	@NotNull(message = "简称不能为空")
	private String shortName;
	
	//英文名称
    private String englishName;
    
    //拼音首字母
    private String initial;
    
    //球场首字母
    @NotNull(message = "球场首字母不能为空")
    private String firstLetter;
	
	//logo
	private String logo;
	
	//地区ID
	@NotNull(message = "地区Id不能为空")
	private Integer areaId;
	
	//地区ID路径
	private String treeId;
	
	//地区中文路径
    private String treePath;
    
    //地址
    @NotNull(message = "地址不能为空")
    private String address;
	
    //球场状态：1-已签约 2-未签约但可接受球包通球包 3-不接受球包通球包 4-未知状态
    @NotNull(message = "球场状态不能为空")
    private Integer status;
    
    //是否删除
    private Boolean isDelete;
    
    //经度
    private Double lon;
    
    //纬度
    private Double lat;
    
    //高尔夫球洞
    @NotNull(message = "高尔夫球洞不能为空")
    private Integer golfHole;
    
    //电话
    private String telephone;
    
    //联系人
    private String contact;
    
    //联系人电话
    private String mobile;
    
    //网址
    private String website;
    
    //微信号
    private String wechat;
    
    //是否有助理
    @NotNull(message = "是否有球场助理不能为空")
    private Boolean hasAssistant;
    
    //代签地点
    private String signPlace;
    
    //寄送取包地点
    private String sendPlace;
    
    //描述
    private String description;
    
    //备注
  	private String remark;
  	
	// 是否偏远球场
	private Boolean isOutRange = false;

	//偏远球场时效(天数)
    private Double outRangeTime = 0d;

	// 偏远球场价格
	private Double outRangePrice = 0d;

	//是否需要微信提示
    private Boolean isTip;
    
    //提示语
    private String wechatTip;
    
  //球场是否配有酒店（名称）
    private Boolean isHotel = false;
    //球场酒店地址
    private String hotelAddress;
    //球场酒店客房数量
    private int hotelRoomNumber;
    //球场酒店等级
    private int hotelLevel;
    //是否有区域限制
    private Boolean hotelAreaLimit = false;
    //是否有车辆限制
    private Boolean hotelCarLimit = false;
    //车辆进入球场是否需要交钱
    private Boolean isFee = false;
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
    private Boolean isJoinBag = false;
    //接包地点
    private String joinBagAddress;
    //是否免费存包（价格/元）
    private Boolean isFeeBag = false;
    //存包地点
    private String putBagAddress;
    //是否配合收包
    private Boolean isCollectBag = false;
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
    private Boolean isNote = false;
    //是否放宣传页
    private Boolean isDeclare = false;
    //是否放易拉宝
    private Boolean isYlb = false;
    //是否协助客户下单
    private Boolean isOrder = false;
    //是否放球包贴
    private Boolean isPosts = false;
    //是否宣传球包快递服务
    private Boolean isDeclareService = false;
    
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
   //距离最近高铁站(公里/km)
    private String nearestHightRail;
	
    //前台负责人电话
    private String managerFrontMobile;
    //负责人电话
    private String manageMobile;
    
    private String managerSaleMobile;
    
    //专人负责球包（联系方式）
    private String bagWorkerMobile;
    
    //是否练习场
    private Boolean isPractice;
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getInitial() {
		return initial;
	}

	public void setInitial(String initial) {
		this.initial = initial;
	}

	public String getFirstLetter() {
		return firstLetter;
	}

	public void setFirstLetter(String firstLetter) {
		this.firstLetter = firstLetter;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getTreeId() {
		return treeId;
	}

	public void setTreeId(String treeId) {
		this.treeId = treeId;
	}

	public String getTreePath() {
		return treePath;
	}

	public void setTreePath(String treePath) {
		this.treePath = treePath;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
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
		this.telephone = telephone;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
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
		this.signPlace = signPlace;
	}

	public String getSendPlace() {
		return sendPlace;
	}

	public void setSendPlace(String sendPlace) {
		this.sendPlace = sendPlace;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Boolean getIsOutRange() {
		return isOutRange;
	}

	public void setIsOutRange(Boolean isOutRange) {
		this.isOutRange = isOutRange;
	}

	public Double getOutRangeTime() {
		return outRangeTime;
	}

	public void setOutRangeTime(Double outRangeTime) {
		this.outRangeTime = outRangeTime;
	}

	public Double getOutRangePrice() {
		return outRangePrice;
	}

	public void setOutRangePrice(Double outRangePrice) {
		this.outRangePrice = outRangePrice;
	}

	public Boolean getIsTip() {
		return isTip;
	}

	public void setIsTip(Boolean isTip) {
		this.isTip = isTip;
	}

	public String getWechatTip() {
		return wechatTip;
	}

	public void setWechatTip(String wechatTip) {
		this.wechatTip = wechatTip;
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

	public Boolean getIsPractice() {
		return isPractice;
	}

	public void setIsPractice(Boolean isPractice) {
		this.isPractice = isPractice;
	}

}

