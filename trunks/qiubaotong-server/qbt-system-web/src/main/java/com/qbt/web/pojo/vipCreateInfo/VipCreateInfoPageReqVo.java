/**
 * Project Name:qbt-system-web
 * File Name:VipCreateInfoPageReqVo.java
 * Package Name:com.qbt.web.pojo.vipCreateInfo
 * Date:2017年1月5日上午10:27:49
 *
*/

package com.qbt.web.pojo.vipCreateInfo;

import com.qbt.common.result.Paging;

/**
 * ClassName:VipCreateInfoPageReqVo
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月5日 上午10:27:49
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class VipCreateInfoPageReqVo extends Paging {
	
	private Integer vipCreateId;
	
	private String vipNo;
	
	private Integer sellStatus;
	
	private Integer payMethod;
	
	private Integer activateStatus;
	
	private Integer activateMethod;
	
	private Integer status;

	public Integer getVipCreateId() {
		return vipCreateId;
	}

	public void setVipCreateId(Integer vipCreateId) {
		this.vipCreateId = vipCreateId;
	}

	public String getVipNo() {
		return vipNo;
	}

	public void setVipNo(String vipNo) {
		this.vipNo = vipNo;
	}

	public Integer getSellStatus() {
		return sellStatus;
	}

	public void setSellStatus(Integer sellStatus) {
		this.sellStatus = sellStatus;
	}

	public Integer getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(Integer payMethod) {
		this.payMethod = payMethod;
	}

	public Integer getActivateStatus() {
		return activateStatus;
	}

	public void setActivateStatus(Integer activateStatus) {
		this.activateStatus = activateStatus;
	}

	public Integer getActivateMethod() {
		return activateMethod;
	}

	public void setActivateMethod(Integer activateMethod) {
		this.activateMethod = activateMethod;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
