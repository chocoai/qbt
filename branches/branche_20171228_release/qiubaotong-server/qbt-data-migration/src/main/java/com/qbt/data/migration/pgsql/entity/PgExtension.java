package com.qbt.data.migration.pgsql.entity;

public class PgExtension {
    private String extname;

    private Long extowner;

    private Long extnamespace;

    private Boolean extrelocatable;

    private String extversion;

    private Object extconfig;

    private Object extcondition;

    public String getExtname() {
        return extname;
    }

    public void setExtname(String extname) {
        this.extname = extname == null ? null : extname.trim();
    }

    public Long getExtowner() {
        return extowner;
    }

    public void setExtowner(Long extowner) {
        this.extowner = extowner;
    }

    public Long getExtnamespace() {
        return extnamespace;
    }

    public void setExtnamespace(Long extnamespace) {
        this.extnamespace = extnamespace;
    }

    public Boolean getExtrelocatable() {
        return extrelocatable;
    }

    public void setExtrelocatable(Boolean extrelocatable) {
        this.extrelocatable = extrelocatable;
    }

    public String getExtversion() {
        return extversion;
    }

    public void setExtversion(String extversion) {
        this.extversion = extversion == null ? null : extversion.trim();
    }

    public Object getExtconfig() {
        return extconfig;
    }

    public void setExtconfig(Object extconfig) {
        this.extconfig = extconfig;
    }

    public Object getExtcondition() {
        return extcondition;
    }

    public void setExtcondition(Object extcondition) {
        this.extcondition = extcondition;
    }
}