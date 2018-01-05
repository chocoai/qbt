package com.qbt.persistent.entity;

import com.qbt.common.entity.BaseEntity;

public class BaseVersion extends BaseEntity {

    private String version;//version

    private String reversion;//子版本号

    private String publishedOn;//发布日期

    private String description;//版本描述

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getReversion() {
        return reversion;
    }

    public void setReversion(String reversion) {
        this.reversion = reversion == null ? null : reversion.trim();
    }

    public String getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(String publishedOn) {
        this.publishedOn = publishedOn == null ? null : publishedOn.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}