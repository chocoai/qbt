/**
 * Project Name:qbt-report
 * File Name:ReportCostItemPageRequest.java
 * Package Name:com.qbt.web.pojo.orderCostItem
 * Date:2017年1月19日下午5:08:33
 *
*/

package com.qbt.web.pojo.orderCostItem;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.qbt.common.result.Paging;

/**
 * ClassName:ReportCostItemPageRequest
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月19日 下午5:08:33
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class ReportCostItemRequest extends Paging {
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;

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
	
}
