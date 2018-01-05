package com.qbt.data.migration.pgsql.entity;

public class PgShseclabel {
    private Long objoid;

    private Long classoid;

    private String provider;

    private String label;

    public Long getObjoid() {
        return objoid;
    }

    public void setObjoid(Long objoid) {
        this.objoid = objoid;
    }

    public Long getClassoid() {
        return classoid;
    }

    public void setClassoid(Long classoid) {
        this.classoid = classoid;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider == null ? null : provider.trim();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }
}