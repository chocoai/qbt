package com.qbt.web.pojo.baseWorkShop;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class BaseWorkshopVo {
	
	private int id;
	//创建时间
	private Date createTime;
	
	//工坊名称
	@NotNull(message = "名称不能为空")
    private String name;
	
	//成立时间
	private String foundTime;
	
	private String treePath;
	
	private String treeId;
	
	@NotNull(message = "地址ID不能为空")
	private Integer areaId;
	
    //工坊地址
    @NotNull(message = "工坊地址不能为空")
    private String address;
    //工坊附近的球场id
    @NotNull(message = "工坊附近的球场id不能为空")
    private Integer courseId;
    //工坊附近的球场
    private String nearestCourse;
    //球场地址
    private String CourseAddress;
    //经度
    private Double lon;
    //纬度
    private Double lat;
    //球场距离工坊的距离
    private String courseWorkshop;
    //工坊营业时间
    @NotNull(message = "工坊营业时间不能为空")
    private String businessTime;
    //有多少个师傅
    @NotNull(message = "有多少个师傅不能为空")
    private Integer teacherNumber = 0;
    //距离最近顺丰配送点（公里）
    private String nearestDeliver;
    //附近有哪些物流公司可到达
    private String goodsCompany;
    //工坊负责人
    private String manager;
    //工坊简况
    private String brif;
    //是否提供保养服务
    private Boolean isKeepService = false;
    //是否提供维修服务
    @NotNull(message = "是否提供维修服务不能为空")
    private Boolean isRepairService = false;
    //是否提供换杆服务
    @NotNull(message = "是否提供换杆服务不能为空")
    private Boolean isBrassieService = false;
    //是否提供定制球杆服务
    @NotNull(message = "是否提供定制球杆服务不能为空")
    private Boolean isMakeBrassieService = false;
    //是否提供存包服务
    @NotNull(message = "是否提供存包服务不能为空")
    private Boolean isSave = false;
    //是否提供更换握把
    @NotNull(message = "是否提供更换握把不能为空")
    private Boolean isChangeGrip = false;
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
    
    //球场名称
    private String courseName;
	
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
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
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
	public String getCourseWorkshop() {
		return courseWorkshop;
	}
	public void setCourseWorkshop(String courseWorkshop) {
		this.courseWorkshop = courseWorkshop;
	}
	public String getBusinessTime() {
		return businessTime;
	}
	public void setBusinessTime(String businessTime) {
		this.businessTime = businessTime;
	}
	public Integer getTeacherNumber() {
		return teacherNumber;
	}
	public void setTeacherNumber(Integer teacherNumber) {
		this.teacherNumber = teacherNumber;
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
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getBrif() {
		return brif;
	}
	public void setBrif(String brif) {
		this.brif = brif;
	}
	public Boolean getIsKeepService() {
		return isKeepService;
	}
	public void setIsKeepService(Boolean isKeepService) {
		this.isKeepService = isKeepService;
	}
	public Boolean getIsRepairService() {
		return isRepairService;
	}
	public void setIsRepairService(Boolean isRepairService) {
		this.isRepairService = isRepairService;
	}
	public Boolean getIsBrassieService() {
		return isBrassieService;
	}
	public void setIsBrassieService(Boolean isBrassieService) {
		this.isBrassieService = isBrassieService;
	}
	public Boolean getIsMakeBrassieService() {
		return isMakeBrassieService;
	}
	public void setIsMakeBrassieService(Boolean isMakeBrassieService) {
		this.isMakeBrassieService = isMakeBrassieService;
	}
	public Boolean getIsSave() {
		return isSave;
	}
	public void setIsSave(Boolean isSave) {
		this.isSave = isSave;
	}
	public Boolean getIsChangeGrip() {
		return isChangeGrip;
	}
	public void setIsChangeGrip(Boolean isChangeGrip) {
		this.isChangeGrip = isChangeGrip;
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
	public String getNearestCourse() {
		return nearestCourse;
	}
	public void setNearestCourse(String nearestCourse) {
		this.nearestCourse = nearestCourse;
	}
	public String getCourseAddress() {
		return CourseAddress;
	}
	public void setCourseAddress(String courseAddress) {
		CourseAddress = courseAddress;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
		
}
