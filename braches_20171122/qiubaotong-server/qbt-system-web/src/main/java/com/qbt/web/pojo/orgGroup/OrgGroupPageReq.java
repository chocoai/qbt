/**
 * Project Name:qbt-system-web
 * File Name:OrgGroupPageReq.java
 * Package Name:com.qbt.web.pojo.orgGroup
 * Date:2017年8月1日下午5:39:46
 *
*/

package com.qbt.web.pojo.orgGroup;

import java.util.Date;

import com.qbt.common.result.Paging;

/**
 * ClassName:OrgGroupPageReq
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月1日 下午5:39:46
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class OrgGroupPageReq extends Paging {
	
	private String name;
	
	private Integer status;
	
	private Date startDate;
	
	private Date endDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
}
