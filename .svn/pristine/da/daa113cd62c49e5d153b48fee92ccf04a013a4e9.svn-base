package com.qbt.persistent.entity;

import com.qbt.common.entity.BaseEntity;

public class Reminder extends BaseEntity {
	
    private String name;// 提示名称

    private String image;// 提示图片

    private String description;// 提示详细描述
    
    private Integer status;// 状态：1-正常，2-禁用
    
    private Integer orderNumber; // 排序数字
    
    private String comments;// 备注
    
    private String detailImage;//详细大图
    
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image == null? null: image.trim();
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }    

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc == null ? null : desc.trim();
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