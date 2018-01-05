package com.qbt.web.pojo.sfkf;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class UserKfTimeRangeVo {
	
	private int id;
	
	@NotNull(message = "自然周不能为空")
	@Min(value = 1, message = "自然周不能小于1")
	@Max(value = 7, message = "自然周不能大于7")
    private Integer weekDay;//星期: 1-7
    
	@NotNull(message = "起始时间不能为空")
	@Min(value = 0, message = "起始时间不能小于0")
	@Max(value = 24, message = "起始时间不能大于24")
    private Integer begin;//起始时间
	
	@NotNull(message = "结束时间不能为空")
	@Min(value = 0, message = "结束时间不能小于0")
	@Max(value = 24, message = "结束时间不能大于24")
    private Integer end;//结束时间
	
    @NotNull(message = "顺丰客服id为空")
    private Integer serviceId;//顺丰客服id
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getWeekDay() {
		return weekDay;
	}
	public void setWeekDay(Integer weekDay) {
		this.weekDay = weekDay;
	}
	public Integer getBegin() {
		return begin;
	}
	public void setBegin(Integer begin) {
		this.begin = begin;
	}
	public Integer getEnd() {
		return end;
	}
	public void setEnd(Integer end) {
		this.end = end;
	}
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
    
}
