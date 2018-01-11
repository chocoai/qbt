/**
 * Project Name:qbt-persistent
 * File Name:OrgGroupUserDto.java
 * Package Name:com.qbt.persistent.dto
 * Date:2017年8月2日上午12:34:12
 *
*/

package com.qbt.persistent.dto;

import java.util.Date;

import com.qbt.persistent.entity.OrgGroupUser;

/**
 * ClassName:OrgGroupUserDto
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月2日 上午12:34:12
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class OrgGroupUserDto extends OrgGroupUser {
	
	private Date startCreateTime;
	
	private Date endCreateTime;

	public Date getStartCreateTime() {
		return startCreateTime;
	}

	public void setStartCreateTime(Date startCreateTime) {
		this.startCreateTime = startCreateTime;
	}

	public Date getEndCreateTime() {
		return endCreateTime;
	}

	public void setEndCreateTime(Date endCreateTime) {
		this.endCreateTime = endCreateTime;
	}
	
}
