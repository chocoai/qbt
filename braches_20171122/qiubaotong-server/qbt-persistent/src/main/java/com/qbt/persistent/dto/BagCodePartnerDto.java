/**
 * Project Name:qbt-persistent
 * File Name:BagCodePartnerDto.java
 * Package Name:com.qbt.persistent.dto
 * Date:2017年8月25日上午11:05:16
 *
*/

package com.qbt.persistent.dto;

import java.util.Date;

import com.qbt.persistent.entity.BagCodePartner;

/**
 * ClassName:BagCodePartnerDto
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月25日 上午11:05:16
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class BagCodePartnerDto extends BagCodePartner {
	
	//关键字(合作方名称、包包码)
	private String keyword;
	
	private Date startTime;
	
	private Date endTime;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword == null ? null : keyword.trim();
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
}
