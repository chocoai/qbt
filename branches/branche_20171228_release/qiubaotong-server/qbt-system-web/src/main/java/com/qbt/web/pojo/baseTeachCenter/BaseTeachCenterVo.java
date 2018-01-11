package com.qbt.web.pojo.baseTeachCenter;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class BaseTeachCenterVo {
	private int id;
	//创建时间
	private Date createTime;
	
	//成立时间
	private String foundTime;
	
	//教学中心名称
	@NotNull(message = "教学中心名称不能为空")
    private String name;
	
	@NotNull(message = "地址ID不能为空")
	private Integer areaId;
	
	private String treeId;
   
    //教学中心地址
	@NotNull(message = "教学中心地址不能为空")
    private String address;
    //教学中心是否配有酒店（名称
    @NotNull(message = "教学中心是否配有酒店不能为空")
    private Boolean isHotel;
    //教学中心酒店地址
    private String hotelAddress;
    //教学中心酒店客房数量
    private Integer hotelRoomNumber;
    //教学中心酒店等级
    private Integer hotelLevel;
    //是否签约
    private Boolean isSign;
    //教学中心有多少个教练
    private Integer teacherNumber;
    //经度
    private Double lon;
    //纬度
    private Double lat;
    //教学中心负责人
    private String manager;
    //教学中心前台负责人
    private String managerFront;
    //教学中心销售负责人
    private String managerSale;
    //是否有区域限制
    @NotNull(message = "是否有区域限制不能为空")
    private Boolean isAreaLimit = false;
    //是否有车辆限制
    @NotNull(message = "是否有车辆限制不能为空")
    private Boolean isCarLimit = false;
    //教学中心简况
    private String brif;
    //淡旺季开场时间
    private String lightVigorousTime;
    //每日营业时间
    @NotNull(message = "每日营业时间不能为空")
    private String businessTime;
    //每年打球人次
    @NotNull(message = "每年打球人次不能为空")
    private Integer playerNumber = 0;
    //淡旺季打球人次（区间）
    private String lightVigorousNumber;
    //外地打球人次
    @NotNull(message = "外地打球人次不能为空")
    private Integer outPlayerNumber = 0;
    //本地打球人次
    @NotNull(message = "本地打球人次不能为空")
    private Integer localPlayerNumber = 0;
    //距离最近顺丰配送点（公里）
    private String nearestDeliver;
    //附近有哪些物流公司可到达
    private String goodsCompany;
    //教学中心平均气温
    private String temperature;
    //雨季分布情况
    private String rain;
    //距离教学中心最近酒店名称
    private String nearestHotel;
    //距离教学中心最近酒店地址
    private String nearestHotelAddress;
    //最近酒店客房房间数量
    private String nearestHotelRoomNumber;
    //最近酒店等级
    private String nearestHotelLevel;
    //距离最近高铁站名称
    private String nearestRailName;
    //距离最近高铁站(公里/km)
    private String nearestRail;
    //高速公路出口到教学中心的距离（公里/km）
    private String highwayCourse;
    //距离最近机场(公里/km)
    private String nearestAirport;
    //距离最近的球场（公里/km）
    private String nearestCourse;
    //是否配合接包
    @NotNull(message = "是否配合接包不能为空")
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
    @NotNull(message = "是否放指示牌不能为空")
    private Boolean isNote = false;
    //是否放宣传页
    @NotNull(message = "是否放宣传页不能为空")
    private Boolean isDeclare = false;
    //是否放球包贴
    @NotNull(message = "是否放球包贴不能为空")
    private Boolean isPosts = false;
    //是否放易拉宝
    @NotNull(message = "是否放易拉宝不能为空")
    private Boolean isYlb = false;
    //是否协助客户下单
    @NotNull(message = "是否协助客户下单不能为空")
    private Boolean isOrder = false;
    //是否宣传球包快递服务
    @NotNull(message = "是否宣传球包快递服务不能为空")
    private Boolean isDeclareService = false;
    
    //负责人电话
    private String manageMobile;
    //前台负责人电话
    private String managerFrontMobile;
    //销售负责人电话
    private String managerSaleMobile;
    
    //专人负责球包（联系方式）
    private String bagWorkerMobile;

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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public Integer getHotelRoomNumber() {
		return hotelRoomNumber;
	}
	public void setHotelRoomNumber(Integer hotelRoomNumber) {
		this.hotelRoomNumber = hotelRoomNumber;
	}
	public Integer getHotelLevel() {
		return hotelLevel;
	}
	public void setHotelLevel(Integer hotelLevel) {
		this.hotelLevel = hotelLevel;
	}
	public Boolean getIsSign() {
		return isSign;
	}
	public void setIsSign(Boolean isSign) {
		this.isSign = isSign;
	}
	public Integer getTeacherNumber() {
		return teacherNumber;
	}
	public void setTeacherNumber(Integer teacherNumber) {
		this.teacherNumber = teacherNumber;
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
		this.manager = manager;
	}
	public String getManagerFront() {
		return managerFront;
	}
	public void setManagerFront(String managerFront) {
		this.managerFront = managerFront;
	}
	public String getManagerSale() {
		return managerSale;
	}
	public void setManagerSale(String managerSale) {
		this.managerSale = managerSale;
	}
	public Boolean getIsAreaLimit() {
		return isAreaLimit;
	}
	public void setIsAreaLimit(Boolean isAreaLimit) {
		this.isAreaLimit = isAreaLimit;
	}
	public Boolean getIsCarLimit() {
		return isCarLimit;
	}
	public void setIsCarLimit(Boolean isCarLimit) {
		this.isCarLimit = isCarLimit;
	}
	public String getBrif() {
		return brif;
	}
	public void setBrif(String brif) {
		this.brif = brif;
	}
	public String getLightVigorousTime() {
		return lightVigorousTime;
	}
	public void setLightVigorousTime(String lightVigorousTime) {
		this.lightVigorousTime = lightVigorousTime;
	}
	
	public Integer getPlayerNumber() {
		return playerNumber;
	}
	public void setPlayerNumber(Integer playerNumber) {
		this.playerNumber = playerNumber;
	}
	public String getLightVigorousNumber() {
		return lightVigorousNumber;
	}
	public void setLightVigorousNumber(String lightVigorousNumber) {
		this.lightVigorousNumber = lightVigorousNumber;
	}
	public Integer getOutPlayerNumber() {
		return outPlayerNumber;
	}
	public void setOutPlayerNumber(Integer outPlayerNumber) {
		this.outPlayerNumber = outPlayerNumber;
	}
	public Integer getLocalPlayerNumber() {
		return localPlayerNumber;
	}
	public void setLocalPlayerNumber(Integer localPlayerNumber) {
		this.localPlayerNumber = localPlayerNumber;
	}
	public String getNearestDeliver() {
		return nearestDeliver;
	}
	public void setNearestDeliver(String nearestDeliver) {
		this.nearestDeliver = nearestDeliver;
	}
	public String getGoodsCompany() {
		return goodsCompany;
	}
	public void setGoodsCompany(String goodsCompany) {
		this.goodsCompany = goodsCompany;
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
	public String getNearestHotel() {
		return nearestHotel;
	}
	public void setNearestHotel(String nearestHotel) {
		this.nearestHotel = nearestHotel;
	}
	public String getNearestHotelAddress() {
		return nearestHotelAddress;
	}
	public void setNearestHotelAddress(String nearestHotelAddress) {
		this.nearestHotelAddress = nearestHotelAddress;
	}
	public String getNearestHotelRoomNumber() {
		return nearestHotelRoomNumber;
	}
	public String getBusinessTime() {
		return businessTime;
	}
	public void setBusinessTime(String businessTime) {
		this.businessTime = businessTime;
	}
	public void setNearestHotelRoomNumber(String nearestHotelRoomNumber) {
		this.nearestHotelRoomNumber = nearestHotelRoomNumber;
	}
	public String getNearestHotelLevel() {
		return nearestHotelLevel;
	}
	public void setNearestHotelLevel(String nearestHotelLevel) {
		this.nearestHotelLevel = nearestHotelLevel;
	}
	public String getNearestRailName() {
		return nearestRailName;
	}
	public void setNearestRailName(String nearestRailName) {
		this.nearestRailName = nearestRailName;
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
	public String getNearestAirport() {
		return nearestAirport;
	}
	public void setNearestAirport(String nearestAirport) {
		this.nearestAirport = nearestAirport;
	}
	public String getNearestCourse() {
		return nearestCourse;
	}
	public void setNearestCourse(String nearestCourse) {
		this.nearestCourse = nearestCourse;
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
	public String getManagerFrontMobile() {
		return managerFrontMobile;
	}
	public void setManagerFrontMobile(String managerFrontMobile) {
		this.managerFrontMobile = managerFrontMobile;
	}
	public String getManagerSaleMobile() {
		return managerSaleMobile;
	}
	public void setManagerSaleMobile(String managerSaleMobile) {
		this.managerSaleMobile = managerSaleMobile;
	}
	public String getBagWorkerMobile() {
		return bagWorkerMobile;
	}
	public void setBagWorkerMobile(String bagWorkerMobile) {
		this.bagWorkerMobile = bagWorkerMobile;
	}
	

}
