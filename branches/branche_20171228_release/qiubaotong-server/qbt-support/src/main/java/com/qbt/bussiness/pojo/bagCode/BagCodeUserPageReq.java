/**
 * Project Name:qbt-system-web
 * File Name:BagCodeUserPageReq.java
 * Package Name:com.qbt.web.pojo.bagCode
 * Date:2017年8月25日下午2:38:08
 *
*/

package com.qbt.bussiness.pojo.bagCode;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.qbt.common.result.Paging;

/**
 * ClassName:BagCodeUserPageReq
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月25日 下午2:38:08
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class BagCodeUserPageReq extends Paging {
	
	private String keyword;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startTime;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endTime;
	
	private Integer bagCodePartnerId;

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

	public Integer getBagCodePartnerId() {
		return bagCodePartnerId;
	}

	public void setBagCodePartnerId(Integer bagCodePartnerId) {
		this.bagCodePartnerId = bagCodePartnerId;
	}
	
}
