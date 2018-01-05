package com.qbt.web.pojo.contact;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.qbt.web.pojo.userWeixin.UserWeixinVo;

public class UserContactVo {
	
	private int id;
	
	private Date createTime;
	
	private Date updateTime;
	
	@NotNull(message="名字不能为空")
    private String name;
	
	@NotNull(message="手机号不能为空")
    private String mobile;
	
    private Boolean isDelete;
    
    private Integer type;//客户类型: 0-未支付客户 1-已支付客户
    
    private List<UserWeixinVo> uwList;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public List<UserWeixinVo> getUwList() {
		return uwList;
	}

	public void setUwList(List<UserWeixinVo> uwList) {
		this.uwList = uwList;
	}
    
}