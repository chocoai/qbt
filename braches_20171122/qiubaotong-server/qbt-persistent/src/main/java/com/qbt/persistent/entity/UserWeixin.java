package com.qbt.persistent.entity;

import java.util.Date;

public class UserWeixin {
    private Integer id;

    private Date createTime;

    private String name;

    private String email;

    private String mobile;

    private String password;

    private Integer sex;

    private String salt;

    private Boolean acceptPush;

    private Boolean acceptPromotion;

    private Boolean isValidated;

    private String openid;

    private String nickname;

    private String headImgUrl;

    private String lastlon;

    private String lastlat;

    private String coordsrc;

    private String province;

    private String city;

    private String county;

    private String firstLetter;
    
    private Integer subscribeStatus; //0-未知 1-已关注 2-取消关注
    
    private String salesmanCode; // 业务员编号
    
    private Integer salesmanId; // 业务员ID"
    
    private Date subscribeTime; // 关注时间
    
    private Date unSubscribeTime; // 取消关注时间
    
    private Boolean isNew = false;//是否新关注
    
    private String ChannelQrcodeCode;//渠道二维码识别码标识

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
        this.name = name == null ? null : name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Boolean getAcceptPush() {
        return acceptPush;
    }

    public void setAcceptPush(Boolean acceptPush) {
        this.acceptPush = acceptPush;
    }

    public Boolean getAcceptPromotion() {
        return acceptPromotion;
    }

    public void setAcceptPromotion(Boolean acceptPromotion) {
        this.acceptPromotion = acceptPromotion;
    }

    public Boolean getIsValidated() {
        return isValidated;
    }

    public void setIsValidated(Boolean isValidated) {
        this.isValidated = isValidated;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl == null ? null : headImgUrl.trim();
    }

    public String getLastlon() {
        return lastlon;
    }

    public void setLastlon(String lastlon) {
        this.lastlon = lastlon == null ? null : lastlon.trim();
    }

    public String getLastlat() {
        return lastlat;
    }

    public void setLastlat(String lastlat) {
        this.lastlat = lastlat == null ? null : lastlat.trim();
    }

    public String getCoordsrc() {
        return coordsrc;
    }

    public void setCoordsrc(String coordsrc) {
        this.coordsrc = coordsrc == null ? null : coordsrc.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter == null ? null : firstLetter.trim();
    }

	public Integer getSubscribeStatus() {
		return subscribeStatus;
	}

	public void setSubscribeStatus(Integer subscribeStatus) {
		this.subscribeStatus = subscribeStatus;
	}

	public String getSalesmanCode() {
		return salesmanCode;
	}

	public void setSalesmanCode(String salesmanCode) {
		this.salesmanCode = salesmanCode;
	}

	public Integer getSalesmanId() {
		return salesmanId;
	}

	public void setSalesmanId(Integer salesmanId) {
		this.salesmanId = salesmanId;
	}

	public Date getSubscribeTime() {
		return subscribeTime;
	}

	public void setSubscribeTime(Date subscribeTime) {
		this.subscribeTime = subscribeTime;
	}

	public Date getUnSubscribeTime() {
		return unSubscribeTime;
	}

	public void setUnSubscribeTime(Date unSubscribeTime) {
		this.unSubscribeTime = unSubscribeTime;
	}

	public Boolean getIsNew() {
		return isNew;
	}

	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}

	public String getChannelQrcodeCode() {
		return ChannelQrcodeCode;
	}

	public void setChannelQrcodeCode(String channelQrcodeCode) {
		ChannelQrcodeCode = channelQrcodeCode;
	}
	
}