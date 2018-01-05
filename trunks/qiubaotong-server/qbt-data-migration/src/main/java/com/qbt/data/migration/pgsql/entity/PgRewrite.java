package com.qbt.data.migration.pgsql.entity;

public class PgRewrite {
    private String rulename;

    private Long ev_class;

    private Short ev_attr;

    private String ev_type;

    private String ev_enabled;

    private Boolean is_instead;

    private Object ev_qual;

    private Object ev_action;

    public String getRulename() {
        return rulename;
    }

    public void setRulename(String rulename) {
        this.rulename = rulename == null ? null : rulename.trim();
    }

    public Long getEv_class() {
        return ev_class;
    }

    public void setEv_class(Long ev_class) {
        this.ev_class = ev_class;
    }

    public Short getEv_attr() {
        return ev_attr;
    }

    public void setEv_attr(Short ev_attr) {
        this.ev_attr = ev_attr;
    }

    public String getEv_type() {
        return ev_type;
    }

    public void setEv_type(String ev_type) {
        this.ev_type = ev_type == null ? null : ev_type.trim();
    }

    public String getEv_enabled() {
        return ev_enabled;
    }

    public void setEv_enabled(String ev_enabled) {
        this.ev_enabled = ev_enabled == null ? null : ev_enabled.trim();
    }

    public Boolean getIs_instead() {
        return is_instead;
    }

    public void setIs_instead(Boolean is_instead) {
        this.is_instead = is_instead;
    }

    public Object getEv_qual() {
        return ev_qual;
    }

    public void setEv_qual(Object ev_qual) {
        this.ev_qual = ev_qual;
    }

    public Object getEv_action() {
        return ev_action;
    }

    public void setEv_action(Object ev_action) {
        this.ev_action = ev_action;
    }
}