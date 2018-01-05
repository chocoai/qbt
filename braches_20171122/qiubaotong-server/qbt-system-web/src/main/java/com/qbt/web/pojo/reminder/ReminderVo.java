package com.qbt.web.pojo.reminder;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class ReminderVo {
	
	private int id;//id

    private Date createTime;//创建时间
    
    @NotNull(message = "提示名字不能为空")
    private String name;//活动名称
    
    @NotNull(message = "提示图片不能为空")
    private String image;//图片
    
    @NotNull(message = "提示描述不能为空")
    private String description;//活动描述
    
    private String comments;// 备注
    
    private String detailImage;//详细大图 
    
    private Integer status = 1;//状态：1-正常，2-禁用
    
    // 排序
    private Integer orderNumber = 1;

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
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getDetailImage() {
		return detailImage;
	}

	public void setDetailImage(String detailImage) {
		this.detailImage = detailImage;
	} 
	
}
