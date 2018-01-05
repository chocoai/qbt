package com.qbt.persistent.entity;

import com.qbt.common.entity.BaseEntity;

public class UserAssistant extends BaseEntity{
	/**
	* @Fields serialVersionUID : TODO
	*/
	private static final long serialVersionUID = 1L;

	private Integer userId;

    private String name;

    private String email;

    private String mobile;

    private String password;

    private String salt;

    private Boolean enjoyAssistantFee;
    
    private Integer status;
    
    private String memo;

    // 连表冗余信息
    private Integer applyId;

    private String applyName;
    
    private Integer applyType;
    
    private String siteName;
    
	private String userWeixinNickName;
	 
	private Integer userWeixinSex;
    
	private int type;

	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Boolean getEnjoyAssistantFee() {
        return enjoyAssistantFee;
    }

    public void setEnjoyAssistantFee(Boolean enjoyAssistantFee) {
        this.enjoyAssistantFee = enjoyAssistantFee;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

	
	/**
	 * getter method 
	 * @Title: getMemo
	 * @return the memo
	 */
	
	public String getMemo() {
		return memo;
	}

	
	/**
	* setter method
	* @param memo the memo to set
	*/
	
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 *  订单类型：1-course球场，2-airport机场,3-bank银行,4-address个人地址 5-顺丰站点
	 *  助理申请类型
		1-球场官方工作人员
		2-球场私人工作人员
		3-银行站点工作人员
		4-顺丰站点工作人员
		5-顺丰机场工作人员
	  * @Title: getApplyId
	  * @Description: TODO
	  * @author: share 2016年8月20日
	  * @modify: share 2016年8月20日
	  * @return
	 */
	public Integer getApplyId() {
		return applyId;
	}

	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}

	public String getApplyName() {
		return applyName;
	}

	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}

	public Integer getApplyType() {
		return applyType;
	}

	public void setApplyType(Integer applyType) {
		this.applyType = applyType;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getUserWeixinNickName() {
		return userWeixinNickName;
	}

	public void setUserWeixinNickName(String userWeixinNickName) {
		this.userWeixinNickName = userWeixinNickName;
	}

	public Integer getUserWeixinSex() {
		return userWeixinSex;
	}

	public void setUserWeixinSex(Integer userWeixinSex) {
		this.userWeixinSex = userWeixinSex;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}


    
    
}