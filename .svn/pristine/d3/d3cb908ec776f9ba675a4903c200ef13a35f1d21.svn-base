/**
 * Project Name:qbt-system-web
 * File Name:BaseAdvertVo.java
 * Package Name:com.qbt.web.pojo.baseAdvert
 * Date:2017年10月10日上午10:06:04
 *
*/

package com.qbt.web.pojo.baseAdvert;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.qbt.persistent.entity.BaseAdvertImage;

/**
 * ClassName:BaseAdvertVo
 * Reason:	 TODO ADD REASON.
 * Date:     2017年10月10日 上午10:06:04
 * @author   wuwang
 * @version  
 * @see 	 
 */
public class BaseAdvertVo {
	
	private int id;
	
	//更新时间
	private Date updateTime;
	
	//广告位名称
	@NotNull(message = "广告位名称不能为空")
	private String name;
	
	//位置描述
	private String advertDescribe;
	
	//类型（1PC，2微信）
	@NotNull(message = "类型不能为空")
	private Integer flatType;
	
	//展开类型(1本页展开，2新页展开)
	@NotNull(message = "展开类型不能为空")
	private Integer openType;
	
	//状态（1启用，0禁用）
	private Integer status;
	
	//操作员
	private String operatorName;
	
	//备注
	private String remark;
	
	private List<BaseAdvertImage> baseAdvertImageList; 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		this.name = name;
	}

	public Integer getFlatType() {
		return flatType;
	}

	public void setFlatType(Integer flatType) {
		this.flatType = flatType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public List<BaseAdvertImage> getBaseAdvertImageList() {
		return baseAdvertImageList;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getOpenType() {
		return openType;
	}

	public void setOpenType(Integer openType) {
		this.openType = openType;
	}

	public String getAdvertDescribe() {
		return advertDescribe;
	}

	public void setAdvertDescribe(String advertDescribe) {
		this.advertDescribe = advertDescribe;
	}

	public void setBaseAdvertImageList(List<BaseAdvertImage> baseAdvertImageList) {
		this.baseAdvertImageList = baseAdvertImageList;
	}
	
}
