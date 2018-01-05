package com.qbt.data.migration.pgsql.entity;

public class PgTsTemplate {
    private String tmplname;

    private Long tmplnamespace;

    private Object tmplinit;

    private Object tmpllexize;

    public String getTmplname() {
        return tmplname;
    }

    public void setTmplname(String tmplname) {
        this.tmplname = tmplname == null ? null : tmplname.trim();
    }

    public Long getTmplnamespace() {
        return tmplnamespace;
    }

    public void setTmplnamespace(Long tmplnamespace) {
        this.tmplnamespace = tmplnamespace;
    }

    public Object getTmplinit() {
        return tmplinit;
    }

    public void setTmplinit(Object tmplinit) {
        this.tmplinit = tmplinit;
    }

    public Object getTmpllexize() {
        return tmpllexize;
    }

    public void setTmpllexize(Object tmpllexize) {
        this.tmpllexize = tmpllexize;
    }
}