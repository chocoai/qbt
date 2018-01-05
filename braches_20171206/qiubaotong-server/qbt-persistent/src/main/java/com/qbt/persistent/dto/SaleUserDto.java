/**
 * Project Name:qbt-persistent
 * File Name:SaleUserDto.java
 * Package Name:com.qbt.persistent.dto
 * Date:2017年2月8日上午10:16:33
 *
*/

package com.qbt.persistent.dto;

import java.util.Date;
import java.util.List;

import com.qbt.persistent.entity.SaleUser;

/**
 * ClassName:SaleUserDto
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月8日 上午10:16:33
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class SaleUserDto extends SaleUser {
	
	private Boolean isApply;//是否审核通过
	
	private List<Integer> ids;//id集合
	
	private String qrcodeCreateInfoName;//生成批次名
	
	private Date startDate;
    
    private Date endDate;
	
	public Boolean getIsApply() {
		return isApply;
	}

	public void setIsApply(Boolean isApply) {
		this.isApply = isApply;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public String getQrcodeCreateInfoName() {
		return qrcodeCreateInfoName;
	}

	public void setQrcodeCreateInfoName(String qrcodeCreateInfoName) {
		this.qrcodeCreateInfoName = qrcodeCreateInfoName;
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
