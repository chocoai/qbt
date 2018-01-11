package com.qbt.persistent.entity;

import com.qbt.common.entity.BaseEntity;

public class UserSfKf extends BaseEntity {
	//姓名
    private String name;
    //电话
    private String mobile;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }
}