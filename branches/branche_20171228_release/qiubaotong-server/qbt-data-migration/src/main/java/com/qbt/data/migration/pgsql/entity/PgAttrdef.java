package com.qbt.data.migration.pgsql.entity;

public class PgAttrdef {
    private Long adrelid;

    private Short adnum;

    private Object adbin;

    private String adsrc;

    public Long getAdrelid() {
        return adrelid;
    }

    public void setAdrelid(Long adrelid) {
        this.adrelid = adrelid;
    }

    public Short getAdnum() {
        return adnum;
    }

    public void setAdnum(Short adnum) {
        this.adnum = adnum;
    }

    public Object getAdbin() {
        return adbin;
    }

    public void setAdbin(Object adbin) {
        this.adbin = adbin;
    }

    public String getAdsrc() {
        return adsrc;
    }

    public void setAdsrc(String adsrc) {
        this.adsrc = adsrc == null ? null : adsrc.trim();
    }
}