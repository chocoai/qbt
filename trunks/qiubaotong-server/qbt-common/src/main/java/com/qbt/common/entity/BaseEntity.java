package com.qbt.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *  基础属性
 * @author Administrator
 *
 */
public class BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 数据ID，不需要主动维护
	 */
	private int id;
	
	/**
	 * 数据创建时间，不需要主动维护
	 */
	private Date createTime = new Date();
	
	private Date updateTime = new Date();
	
	/**
	 * 不同属性的个数
	 */
	private int diffCount;
	
	private int rownum;
	
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
		this.createTime = createTime == null ? new Date() : createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime == null ? new Date() : updateTime;
	}

	public int getDiffCount() {
		return diffCount;
	}

	public void setDiffCount(int diffCount) {
		this.diffCount = diffCount;
	}

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

}
