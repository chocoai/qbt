/**
 * Project Name:qbt-system-web
 * File Name:PopUpPageReqVo.java
 * Package Name:com.qbt.web.pojo.popUp
 * Date:2017年1月17日上午10:03:46
 *
*/

package com.qbt.web.pojo.popUp;

import com.qbt.common.result.Paging;

/**
 * ClassName:PopUpPageReqVo
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月17日 上午10:03:46
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class PopUpPageReqVo extends Paging {
	
	private String name;
	
	private Integer platform;
	
	private Integer conditionType;
	
	private Integer sort;
	
	private Integer status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPlatform() {
		return platform;
	}

	public void setPlatform(Integer platform) {
		this.platform = platform;
	}

	public Integer getConditionType() {
		return conditionType;
	}

	public void setConditionType(Integer conditionType) {
		this.conditionType = conditionType;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
