package com.qbt.data.migration.pgsql.entity;

public class PgEnum {
    private Long enumtypid;

    private Float enumsortorder;

    private String enumlabel;

    public Long getEnumtypid() {
        return enumtypid;
    }

    public void setEnumtypid(Long enumtypid) {
        this.enumtypid = enumtypid;
    }

    public Float getEnumsortorder() {
        return enumsortorder;
    }

    public void setEnumsortorder(Float enumsortorder) {
        this.enumsortorder = enumsortorder;
    }

    public String getEnumlabel() {
        return enumlabel;
    }

    public void setEnumlabel(String enumlabel) {
        this.enumlabel = enumlabel == null ? null : enumlabel.trim();
    }
}