package com.qbt.web.pojo.order;

import java.util.Date;
import java.util.List;

public class OrderCommentInfo {

	private int id;

	private Date createTime;

	// 寄件地区路径
	private String jTreePath;

	// 收件地区路径
	private String dTreePath;

	// 用户微信昵称
	private String userName;

	// 微信头像URL
	private String headImgUrl;
	
	//客服评星
	private Integer kfLevel;

	// 顺丰包装评星
	private Integer sfPackLevel;

	// 顺丰送货速度评星
	private Integer sfDeliverLevel;

	// 顺丰配送服务评星
	private Integer sfServiceLevel;
	
	// 总评星
	private Double totalLevel;

	// 评论内容
	private String content;
	
	//客服回复
	private String memo;
	
	//图片url
	private List<String> imgUrls;

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

	public String getjTreePath() {
		return jTreePath;
	}

	public void setjTreePath(String jTreePath) {
		this.jTreePath = jTreePath;
	}

	public String getdTreePath() {
		return dTreePath;
	}

	public void setdTreePath(String dTreePath) {
		this.dTreePath = dTreePath;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getHeadImgUrl() {
		return headImgUrl;
	}

	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}

	public Integer getKfLevel() {
		return kfLevel;
	}

	public void setKfLevel(Integer kfLevel) {
		this.kfLevel = kfLevel;
	}

	public Integer getSfPackLevel() {
		return sfPackLevel;
	}

	public void setSfPackLevel(Integer sfPackLevel) {
		this.sfPackLevel = sfPackLevel;
	}

	public Integer getSfDeliverLevel() {
		return sfDeliverLevel;
	}

	public void setSfDeliverLevel(Integer sfDeliverLevel) {
		this.sfDeliverLevel = sfDeliverLevel;
	}

	public Integer getSfServiceLevel() {
		return sfServiceLevel;
	}

	public void setSfServiceLevel(Integer sfServiceLevel) {
		this.sfServiceLevel = sfServiceLevel;
	}

	public Double getTotalLevel() {
		return totalLevel;
	}

	public void setTotalLevel(Double totalLevel) {
		this.totalLevel = totalLevel;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<String> getImgUrls() {
		return imgUrls;
	}

	public void setImgUrls(List<String> imgUrls) {
		this.imgUrls = imgUrls;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
}
