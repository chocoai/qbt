/**
 * Project Name:qbt-persistent
 * File Name:BagCodeOrderDto.java
 * Package Name:com.qbt.persistent.dto
 * Date:2017年8月25日下午3:33:39
 *
*/

package com.qbt.persistent.dto;

import java.util.Date;

import com.qbt.persistent.entity.BagCodeOrder;

/**
 * ClassName:BagCodeOrderDto
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月25日 下午3:33:39
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class BagCodeOrderDto extends BagCodeOrder {
	
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
