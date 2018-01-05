package com.qbt.data.migration.pgsql.entity;

import java.util.Date;

public class PgRoles {
    private String rolname;

    private Boolean rolsuper;

    private Boolean rolinherit;

    private Boolean rolcreaterole;

    private Boolean rolcreatedb;

    private Boolean rolcatupdate;

    private Boolean rolcanlogin;

    private Boolean rolreplication;

    private Integer rolconnlimit;

    private String rolpassword;

    private Date rolvaliduntil;

    private Object rolconfig;

    private Long oid;

    public String getRolname() {
        return rolname;
    }

    public void setRolname(String rolname) {
        this.rolname = rolname == null ? null : rolname.trim();
    }

    public Boolean getRolsuper() {
        return rolsuper;
    }

    public void setRolsuper(Boolean rolsuper) {
        this.rolsuper = rolsuper;
    }

    public Boolean getRolinherit() {
        return rolinherit;
    }

    public void setRolinherit(Boolean rolinherit) {
        this.rolinherit = rolinherit;
    }

    public Boolean getRolcreaterole() {
        return rolcreaterole;
    }

    public void setRolcreaterole(Boolean rolcreaterole) {
        this.rolcreaterole = rolcreaterole;
    }

    public Boolean getRolcreatedb() {
        return rolcreatedb;
    }

    public void setRolcreatedb(Boolean rolcreatedb) {
        this.rolcreatedb = rolcreatedb;
    }

    public Boolean getRolcatupdate() {
        return rolcatupdate;
    }

    public void setRolcatupdate(Boolean rolcatupdate) {
        this.rolcatupdate = rolcatupdate;
    }

    public Boolean getRolcanlogin() {
        return rolcanlogin;
    }

    public void setRolcanlogin(Boolean rolcanlogin) {
        this.rolcanlogin = rolcanlogin;
    }

    public Boolean getRolreplication() {
        return rolreplication;
    }

    public void setRolreplication(Boolean rolreplication) {
        this.rolreplication = rolreplication;
    }

    public Integer getRolconnlimit() {
        return rolconnlimit;
    }

    public void setRolconnlimit(Integer rolconnlimit) {
        this.rolconnlimit = rolconnlimit;
    }

    public String getRolpassword() {
        return rolpassword;
    }

    public void setRolpassword(String rolpassword) {
        this.rolpassword = rolpassword == null ? null : rolpassword.trim();
    }

    public Date getRolvaliduntil() {
        return rolvaliduntil;
    }

    public void setRolvaliduntil(Date rolvaliduntil) {
        this.rolvaliduntil = rolvaliduntil;
    }

    public Object getRolconfig() {
        return rolconfig;
    }

    public void setRolconfig(Object rolconfig) {
        this.rolconfig = rolconfig;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }
}