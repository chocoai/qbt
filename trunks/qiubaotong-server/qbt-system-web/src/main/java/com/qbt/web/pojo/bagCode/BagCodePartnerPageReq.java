/**
 * Project Name:qbt-system-web
 * File Name:BagCodePartnerPageReq.java
 * Package Name:com.qbt.web.pojo.bagCode
 * Date:2017年8月25日上午11:27:32
 *
*/

package com.qbt.web.pojo.bagCode;

import java.util.Date;

import com.qbt.common.result.Paging;

/**
 * ClassName:BagCodePartnerPageReq
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月25日 上午11:27:32
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class BagCodePartnerPageReq extends Paging {
	
	private String keyword;
	
	private Integer status;
	
	private Date startDate;
	
	private Date endDate;
	
	private Date startTime;
	
	private Date endTime;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
