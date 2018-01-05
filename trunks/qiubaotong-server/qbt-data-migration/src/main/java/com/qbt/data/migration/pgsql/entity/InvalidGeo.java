package com.qbt.data.migration.pgsql.entity;

import java.util.Date;

public class InvalidGeo {
    private Integer id;

    private String pcc;

    private String result;

    private Date created;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPcc() {
        return pcc;
    }

    public void setPcc(String pcc) {
        this.pcc = pcc == null ? null : pcc.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}