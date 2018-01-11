package com.qbt.persistent.entity;

import com.qbt.common.entity.BaseEntity;

public class BaseLink extends BaseEntity {

    private String name;

    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}