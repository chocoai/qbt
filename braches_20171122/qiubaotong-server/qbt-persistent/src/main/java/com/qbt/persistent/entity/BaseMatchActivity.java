package com.qbt.persistent.entity;

import java.util.Date;

import com.qbt.common.entity.BaseEntity;

public class BaseMatchActivity extends BaseEntity{
	//赛事名称
    private String name;
    
    //成立时间
   	private String foundTime;
    
    private String treePath;
	
   	private Integer areaId;
    //赛事地址
    private String address;
    //赛事球场id
    private Integer courseid;
    //举办单位
    private String sponsor;
    //主赞助商
    private String mainSeller;
    //面向什么样的群体
    private String group;
    //活动报名方式
    private String signWay;
    //赛事参加人数
    private Integer joinNumber;
    //赛事活动推广人员
    private String activityPerson;
    //球包通参与方式类型
    private String joinQbtWay;
    //类型数量
    private Integer typeNumber;
    //价值总金额
    private String valueTotal;
    //赛事负责人
    private String courseManager;
    //赛事前台负责人
    private String managerFront;
    //赛事销售负责人
    private String managerSale;
    //赛事简况
    private String brif;
    //最近三个月活动安排
    private String activity;
    //是否背景板等体现公司品牌logo
    private Boolean isBackLogo;
    //是否球场内1张单独广告球道板
    private Boolean isSingleAd;
    //是否赛前微信公众号宣传
    private Boolean isWechatDeclare;
    //赛事主办方讲解球包通使用方法
    private String qbtWay;
    //是否宣传球包快递服务
    private Boolean isDeclareService;
    //是否可以微信群宣传
    private Boolean isWechatGroupDeclare;
    //是否参加新闻发布会及颁奖晚宴嘉宾
    private Boolean isNews;
    //是否网络/微信媒体报道
    private Boolean isWeb;
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
    
    private String managerSaleMobile;
    
    //加type：类型（球场1，教学中心2）
    private int type;
    //赛事活动推广人员电话
    private String activityPersonMobile;
    
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

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor == null ? null : sponsor.trim();
    }

    public String getMainSeller() {
		return mainSeller;
	}

	public void setMainSeller(String mainSeller) {
		this.mainSeller = mainSeller;
	}

	public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group == null ? null : group.trim();
    }

    public String getSignWay() {
        return signWay;
    }

    public void setSignWay(String signWay) {
        this.signWay = signWay == null ? null : signWay.trim();
    }

    public Integer getJoinNumber() {
        return joinNumber;
    }

    public void setJoinNumber(Integer joinNumber) {
        this.joinNumber = joinNumber;
    }

    public String getActivityPerson() {
        return activityPerson;
    }

    public void setActivityPerson(String activityPerson) {
        this.activityPerson = activityPerson == null ? null : activityPerson.trim();
    }

    public String getJoinQbtWay() {
        return joinQbtWay;
    }

    public void setJoinQbtWay(String joinQbtWay) {
        this.joinQbtWay = joinQbtWay == null ? null : joinQbtWay.trim();
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
        this.valueTotal = valueTotal == null ? null : valueTotal.trim();
    }

    public String getCourseManager() {
        return courseManager;
    }

    public void setCourseManager(String courseManager) {
        this.courseManager = courseManager == null ? null : courseManager.trim();
    }

    public String getManagerFront() {
        return managerFront;
    }

    public void setManagerFront(String managerFront) {
        this.managerFront = managerFront == null ? null : managerFront.trim();
    }

    public String getManagerSale() {
        return managerSale;
    }

    public void setManagerSale(String managerSale) {
        this.managerSale = managerSale == null ? null : managerSale.trim();
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
        this.qbtWay = qbtWay == null ? null : qbtWay.trim();
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

	public String getManagerSaleMobile() {
		return managerSaleMobile;
	}

	public void setManagerSaleMobile(String managerSaleMobile) {
		this.managerSaleMobile = managerSaleMobile;
	}

	public String getActivityPersonMobile() {
		return activityPersonMobile;
	}

	public void setActivityPersonMobile(String activityPersonMobile) {
		this.activityPersonMobile = activityPersonMobile;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}