package com.qbt.data.migration.pgsql.entity;

public class PgShdescription {
    private Long objoid;

    private Long classoid;

    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}