/**
 * Project Name:qbt-persistent
 * File Name:BagCodeUserDto.java
 * Package Name:com.qbt.persistent.dto
 * Date:2017年8月25日下午2:26:58
 *
*/

package com.qbt.persistent.dto;

import java.util.Date;

import com.qbt.persistent.entity.BagCodeUser;

/**
 * ClassName:BagCodeUserDto
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月25日 下午2:26:58
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class BagCodeUserDto extends BagCodeUser {
	
	private String keyword;
	
	private Date startTime;
	
	private Date endTime;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
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
