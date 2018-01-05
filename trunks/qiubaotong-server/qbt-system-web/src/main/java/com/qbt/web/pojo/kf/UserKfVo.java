package com.qbt.web.pojo.kf;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class UserKfVo {
	
	private int id;
	
	private Date createTime;
	
	@NotNull(message = "客服名字不能为空")
	private String name;
	
	@NotNull(message = "用户ID不能为空")
    private Integer userId;
	
    private String mobile;
    
    @NotNull(message = "等级不能为空")
    @Min(value = 1, message = "最低等级不能小于1")
    @Max(value = 9, message = "最高等级不能大于9")
    private Integer level;

    private String desc;
    
    @Min(value = 0, message = "非法分类")
    @Max(value = 2, message = "非法分类")
    private Integer type; // 客服分类：0-普通客服，1-财务，2-技术管理员

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

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}