package com.qbt.web.pojo.baseTravelAgency;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class BaseTravelAgencyVo {
	private int id;
	
	//成立时间
	private String foundTime;
	
	private Date createTime;
	//旅行社名称	
	@NotNull(message = "旅行社名称不能为空")
    private String name;
	
	private String treePath;
	
	private String treeId;
	
	@NotNull(message = "地址ID不能为空")
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
    @NotNull(message = "是否赛前微信公众号宣传不能为空")
    private Boolean isWechatDeclare = false;
    //旅行社主办方讲解球包通使用方法
    private String qbtWay;
    //是否协助客户下单
    @NotNull(message = "是否协助客户下单不能为空")
    private Boolean isOrder = false;
    //是否放指示牌
    @NotNull(message = "是否放指示牌不能为空")
    private Boolean isNote = false;
    //是否放宣传页
    @NotNull(message = "是否放宣传页不能为空")
    private Boolean isDeclare  = false;
    //是否放易拉宝
    @NotNull(message = "是否放易拉宝不能为空")
    private Boolean isYlb  = false;
    
    //经度
    private Double lon;
    //纬度
    private Double lat;
    //负责人电话
    private String manageMobile;
    //前台负责人电话
    private String managerFrontMobile;
    
    
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
		this.group = group;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getFrontManager() {
		return frontManager;
	}
	public void setFrontManager(String frontManager) {
		this.frontManager = frontManager;
	}
	public String getBrif() {
		return brif;
	}
	public void setBrif(String brif) {
		this.brif = brif;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
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
		this.qbtWay = qbtWay;
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
	public String getTreeId() {
		return treeId;
	}
	public void setTreeId(String treeId) {
		this.treeId = treeId;
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
