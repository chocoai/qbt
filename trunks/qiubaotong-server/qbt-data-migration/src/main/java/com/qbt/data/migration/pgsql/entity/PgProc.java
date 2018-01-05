package com.qbt.data.migration.pgsql.entity;

public class PgProc {
    private String proname;

    private Long pronamespace;

    private Long proowner;

    private Long prolang;

    private Float procost;

    private Float prorows;

    private Long provariadic;

    private Object protransform;

    private Boolean proisagg;

    private Boolean proiswindow;

    private Boolean prosecdef;

    private Boolean proleakproof;

    private Boolean proisstrict;

    private Boolean proretset;

    private String provolatile;

    private Short pronargs;

    private Short pronargdefaults;

    private Long prorettype;

    private Object proargtypes;

    private Object proallargtypes;

    private Object proargmodes;

    private Object proargnames;

    private Object proargdefaults;

    private String prosrc;

    private String probin;

    private Object proconfig;

    private Object proacl;

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname == null ? null : proname.trim();
    }

    public Long getPronamespace() {
        return pronamespace;
    }

    public void setPronamespace(Long pronamespace) {
        this.pronamespace = pronamespace;
    }

    public Long getProowner() {
        return proowner;
    }

    public void setProowner(Long proowner) {
        this.proowner = proowner;
    }

    public Long getProlang() {
        return prolang;
    }

    public void setProlang(Long prolang) {
        this.prolang = prolang;
    }

    public Float getProcost() {
        return procost;
    }

    public void setProcost(Float procost) {
        this.procost = procost;
    }

    public Float getProrows() {
        return prorows;
    }

    public void setProrows(Float prorows) {
        this.prorows = prorows;
    }

    public Long getProvariadic() {
        return provariadic;
    }

    public void setProvariadic(Long provariadic) {
        this.provariadic = provariadic;
    }

    public Object getProtransform() {
        return protransform;
    }

    public void setProtransform(Object protransform) {
        this.protransform = protransform;
    }

    public Boolean getProisagg() {
        return proisagg;
    }

    public void setProisagg(Boolean proisagg) {
        this.proisagg = proisagg;
    }

    public Boolean getProiswindow() {
        return proiswindow;
    }

    public void setProiswindow(Boolean proiswindow) {
        this.proiswindow = proiswindow;
    }

    public Boolean getProsecdef() {
        return prosecdef;
    }

    public void setProsecdef(Boolean prosecdef) {
        this.prosecdef = prosecdef;
    }

    public Boolean getProleakproof() {
        return proleakproof;
    }

    public void setProleakproof(Boolean proleakproof) {
        this.proleakproof = proleakproof;
    }

    public Boolean getProisstrict() {
        return proisstrict;
    }

    public void setProisstrict(Boolean proisstrict) {
        this.proisstrict = proisstrict;
    }

    public Boolean getProretset() {
        return proretset;
    }

    public void setProretset(Boolean proretset) {
        this.proretset = proretset;
    }

    public String getProvolatile() {
        return provolatile;
    }

    public void setProvolatile(String provolatile) {
        this.provolatile = provolatile == null ? null : provolatile.trim();
    }

    public Short getPronargs() {
        return pronargs;
    }

    public void setPronargs(Short pronargs) {
        this.pronargs = pronargs;
    }

    public Short getPronargdefaults() {
        return pronargdefaults;
    }

    public void setPronargdefaults(Short pronargdefaults) {
        this.pronargdefaults = pronargdefaults;
    }

    public Long getProrettype() {
        return prorettype;
    }

    public void setProrettype(Long prorettype) {
        this.prorettype = prorettype;
    }

    public Object getProargtypes() {
        return proargtypes;
    }

    public void setProargtypes(Object proargtypes) {
        this.proargtypes = proargtypes;
    }

    public Object getProallargtypes() {
        return proallargtypes;
    }

    public void setProallargtypes(Object proallargtypes) {
        this.proallargtypes = proallargtypes;
    }

    public Object getProargmodes() {
        return proargmodes;
    }

    public void setProargmodes(Object proargmodes) {
        this.proargmodes = proargmodes;
    }

    public Object getProargnames() {
        return proargnames;
    }

    public void setProargnames(Object proargnames) {
        this.proargnames = proargnames;
    }

    public Object getProargdefaults() {
        return proargdefaults;
    }

    public void setProargdefaults(Object proargdefaults) {
        this.proargdefaults = proargdefaults;
    }

    public String getProsrc() {
        return prosrc;
    }

    public void setProsrc(String prosrc) {
        this.prosrc = prosrc == null ? null : prosrc.trim();
    }

    public String getProbin() {
        return probin;
    }

    public void setProbin(String probin) {
        this.probin = probin == null ? null : probin.trim();
    }

    public Object getProconfig() {
        return proconfig;
    }

    public void setProconfig(Object proconfig) {
        this.proconfig = proconfig;
    }

    public Object getProacl() {
        return proacl;
    }

    public void setProacl(Object proacl) {
        this.proacl = proacl;
    }
}