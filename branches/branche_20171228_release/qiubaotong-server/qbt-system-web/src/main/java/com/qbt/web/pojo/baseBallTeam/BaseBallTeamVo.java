package com.qbt.web.pojo.baseBallTeam;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class BaseBallTeamVo {
	private int id;
	//球队名称
	@NotNull(message = "球队名称不能为空")
    private String name;
	
	//成立时间
	private String foundTime;
    
	private String treePath;
	
	private String treeId;
	
	@NotNull(message = "地址ID不能为空")
	private Integer areaId;
    //球队地址
	@NotNull(message = "球队地址不能为空")
    private String address;
    //面向什么样的群体
    private String group;
    //活动报名方式
    private String signWay;
    //球队成立时间
    private Date createTime;
    //球队会员人数
    @NotNull(message = "球队会员人数不能为空")
    private Integer memberNumber = 0;
    //活动频次
    private String activityRate;
    //球包通参与方式类型
    private String joinQbtWay;
    //类型数量
    private Integer typeNumber;
    //价值总金额
    private String valueTotal;
    //球队负责人
    private String courseManager;
    //球队秘书负责人
    private String secretaryManager;
    //球队简况
    private String brif;
    //最近三个月活动安排
    private String activity;
    //是否背景板等体现公司品牌logo
    @NotNull(message = "是否背景板等体现公司品牌logo不能为空")
    private Boolean isBackLogo = false;
    //是否球场内1张单独广告球道板
    @NotNull(message = "是否球场内1张单独广告球道板不能为空")
    private Boolean isSingleAd = false;
    //是否赛前微信公众号宣传
    @NotNull(message = "是否赛前微信公众号宣传不能为空")
    private Boolean isWechatDeclare = false;
    //球队主办方讲解球包通使用方法
    private String qbtWay;
    //是否宣传球包快递服务
    @NotNull(message = "是否宣传球包快递服务不能为空")
    private Boolean isDeclareService = false;
    //是否可以微信群宣传
    @NotNull(message = "是否可以微信群宣传不能为空")
    private Boolean isWechatGroupDeclare = false;
    //是否参加新闻发布会及颁奖晚宴嘉宾	
    @NotNull(message = "是否参加新闻发布会及颁奖晚宴嘉宾不能为空")
    private Boolean isNews = false;
    //是否网络/微信媒体报道
    @NotNull(message = "是否网络/微信媒体报道不能为空")
    private Boolean isWeb = false;
    //是否放指示牌
    @NotNull(message = "是否背景板等体现公司品牌logo")
    private Boolean isNote = false;
    //是否放宣传页
    @NotNull(message = "是否背景板等体现公司品牌logo")
    private Boolean isDeclare = false;
    //是否放易拉宝
    @NotNull(message = "是否背景板等体现公司品牌logo")
    private Boolean isYlb = false;
    
    //经度
    private Double lon;
    //纬度
    private Double lat;
    //负责人电话
    private String manageMobile;
    //球队秘书负责人
    private String secretaryManagerMobile;
    
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
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getSignWay() {
		return signWay;
	}
	public void setSignWay(String signWay) {
		this.signWay = signWay;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(Integer memberNumber) {
		this.memberNumber = memberNumber;
	}
	public String getActivityRate() {
		return activityRate;
	}
	public void setActivityRate(String activityRate) {
		this.activityRate = activityRate;
	}
	public String getJoinQbtWay() {
		return joinQbtWay;
	}
	public void setJoinQbtWay(String joinQbtWay) {
		this.joinQbtWay = joinQbtWay;
	}
	public Integer getTypeNumber() {
		return typeNumber;
	}
	public void setTypeNumber(Integer typeNumber) {
		this.typeNumber = typeNumber;
	}
	public String getValueTotal() {
		return valueTotal;
	}
	public void setValueTotal(String valueTotal) {
		this.valueTotal = valueTotal;
	}
	public String getCourseManager() {
		return courseManager;
	}
	public void setCourseManager(String courseManager) {
		this.courseManager = courseManager;
	}
	public String getSecretaryManager() {
		return secretaryManager;
	}
	public void setSecretaryManager(String secretaryManager) {
		this.secretaryManager = secretaryManager;
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
	public Boolean getIsBackLogo() {
		return isBackLogo;
	}
	public void setIsBackLogo(Boolean isBackLogo) {
		this.isBackLogo = isBackLogo;
	}
	public Boolean getIsSingleAd() {
		return isSingleAd;
	}
	public void setIsSingleAd(Boolean isSingleAd) {
		this.isSingleAd = isSingleAd;
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
	public Boolean getIsDeclareService() {
		return isDeclareService;
	}
	public void setIsDeclareService(Boolean isDeclareService) {
		this.isDeclareService = isDeclareService;
	}
	public Boolean getIsWechatGroupDeclare() {
		return isWechatGroupDeclare;
	}
	public void setIsWechatGroupDeclare(Boolean isWechatGroupDeclare) {
		this.isWechatGroupDeclare = isWechatGroupDeclare;
	}
	public Boolean getIsNews() {
		return isNews;
	}
	public void setIsNews(Boolean isNews) {
		this.isNews = isNews;
	}
	public Boolean getIsWeb() {
		return isWeb;
	}
	public void setIsWeb(Boolean isWeb) {
		this.isWeb = isWeb;
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
	public String getSecretaryManagerMobile() {
		return secretaryManagerMobile;
	}
	public void setSecretaryManagerMobile(String secretaryManagerMobile) {
		this.secretaryManagerMobile = secretaryManagerMobile;
	}

}
