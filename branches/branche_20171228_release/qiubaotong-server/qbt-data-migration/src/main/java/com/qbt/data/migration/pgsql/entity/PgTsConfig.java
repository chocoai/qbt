package com.qbt.data.migration.pgsql.entity;

public class PgTsConfig {
    private String cfgname;

    private Long cfgnamespace;

    private Long cfgowner;

    private Long cfgparser;

    public String getCfgname() {
        return cfgname;
    }

    public void setCfgname(String cfgname) {
        this.cfgname = cfgname == null ? null : cfgname.trim();
    }

    public Long getCfgnamespace() {
        return cfgnamespace;
    }

    public void setCfgnamespace(Long cfgnamespace) {
        this.cfgnamespace = cfgnamespace;
    }

    public Long getCfgowner() {
        return cfgowner;
    }

    public void setCfgowner(Long cfgowner) {
        this.cfgowner = cfgowner;
    }

    public Long getCfgparser() {
        return cfgparser;
    }

    public void setCfgparser(Long cfgparser) {
        this.cfgparser = cfgparser;
    }
}