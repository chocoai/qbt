/**
 * Project Name:qbt-support
 * File Name:BagCodeOrderPageReq.java
 * Package Name:com.qbt.bussiness.pojo.bagCode
 * Date:2017年8月25日下午3:42:10
 *
*/

package com.qbt.bussiness.pojo.bagCode;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.qbt.common.result.Paging;

/**
 * ClassName:BagCodeOrderPageReq
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月25日 下午3:42:10
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class BagCodeOrderPageReq extends Paging {
	
	private String keyword;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startTime;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endTime;
	
	private Integer status;
	
	private String bagCode;
	
	private String orderNumber;

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getBagCode() {
		return bagCode;
	}

	public void setBagCode(String bagCode) {
		this.bagCode = bagCode;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
}
