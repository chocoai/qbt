package com.qbt.data.migration.pgsql.entity;

public class PgPltemplate {
    private String tmplname;

    private Boolean tmpltrusted;

    private Boolean tmpldbacreate;

    private String tmplhandler;

    private String tmplinline;

    private String tmplvalidator;

    private String tmpllibrary;

    private Object tmplacl;

    public String getTmplname() {
        return tmplname;
    }

    public void setTmplname(String tmplname) {
        this.tmplname = tmplname == null ? null : tmplname.trim();
    }

    public Boolean getTmpltrusted() {
        return tmpltrusted;
    }

    public void setTmpltrusted(Boolean tmpltrusted) {
        this.tmpltrusted = tmpltrusted;
    }

    public Boolean getTmpldbacreate() {
        return tmpldbacreate;
    }

    public void setTmpldbacreate(Boolean tmpldbacreate) {
        this.tmpldbacreate = tmpldbacreate;
    }

    public String getTmplhandler() {
        return tmplhandler;
    }

    public void setTmplhandler(String tmplhandler) {
        this.tmplhandler = tmplhandler == null ? null : tmplhandler.trim();
    }

    public String getTmplinline() {
        return tmplinline;
    }

    public void setTmplinline(String tmplinline) {
        this.tmplinline = tmplinline == null ? null : tmplinline.trim();
    }

    public String getTmplvalidator() {
        return tmplvalidator;
    }

    public void setTmplvalidator(String tmplvalidator) {
        this.tmplvalidator = tmplvalidator == null ? null : tmplvalidator.trim();
    }

    public String getTmpllibrary() {
        return tmpllibrary;
    }

    public void setTmpllibrary(String tmpllibrary) {
        this.tmpllibrary = tmpllibrary == null ? null : tmpllibrary.trim();
    }

    public Object getTmplacl() {
        return tmplacl;
    }

    public void setTmplacl(Object tmplacl) {
        this.tmplacl = tmplacl;
    }
}