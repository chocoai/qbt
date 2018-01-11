package com.qbt.persistent.entity;

import com.qbt.common.entity.BaseEntity;

public class UserKfTimeRange extends BaseEntity {
	//星期: 1-7
    private Integer weekDay;
    //起始时间
    private Integer begin;
    //结束时间
    private Integer end;
    //顺丰客服id
    private Integer serviceId;

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