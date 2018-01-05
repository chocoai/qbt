/**
 * Project Name:qbt-system-web
 * File Name:VipCreateGenerate.java
 * Package Name:com.qbt.web.pojo.vipCreate
 * Date:2017年1月4日上午11:33:18
 *
*/

package com.qbt.web.pojo.vipCreate;

import java.util.Date;

import javax.validation.constraints.NotNull;

/**
 * ClassName:VipCreateGenerate
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月4日 上午11:33:18
 * @author   huangyihao
 * @version  
 * @see 	 
 */
public class VipCreateGenerate {
	
	@NotNull(message = "发行名称不能为空")
	private String name;
	
	@NotNull(message = "发行数量不能为空")
	private Integer number;
	
	@NotNull(message = "激活截至日期不能为空")
    private Date endTime;
	
	@NotNull(message = "会员卡类型不能为空")
    private Integer vipTypeId;
	
	private Double payAmount;

    private Integer payMethod;
    
    private Integer sellStatus;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getVipTypeId() {
		return vipTypeId;
	}

	public void setVipTypeId(Integer vipTypeId) {
		this.vipTypeId = vipTypeId;
	}

	public Double getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(Double payAmount) {
		this.payAmount = payAmount;
	}

	public Integer getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(Integer payMethod) {
		this.payMethod = payMethod;
	}

	public Integer getSellStatus() {
		return sellStatus;
	}

	public void setSellStatus(Integer sellStatus) {
		this.sellStatus = sellStatus;
	}
    
}
