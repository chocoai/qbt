package com.qbt.data.migration.pgsql.entity;

public class PgUser {
    private String usename;

    private Long usesysid;

    private Boolean usecreatedb;

    private Boolean usesuper;

    private Boolean usecatupd;

    private Boolean userepl;

    private String passwd;

    private Object valuntil;

    private Object useconfig;

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename == null ? null : usename.trim();
    }

    public Long getUsesysid() {
        return usesysid;
    }

    public void setUsesysid(Long usesysid) {
        this.usesysid = usesysid;
    }

    public Boolean getUsecreatedb() {
        return usecreatedb;
    }

    public void setUsecreatedb(Boolean usecreatedb) {
        this.usecreatedb = usecreatedb;
    }

    public Boolean getUsesuper() {
        return usesuper;
    }

    public void setUsesuper(Boolean usesuper) {
        this.usesuper = usesuper;
    }

    public Boolean getUsecatupd() {
        return usecatupd;
    }

    public void setUsecatupd(Boolean usecatupd) {
        this.usecatupd = usecatupd;
    }

    public Boolean getUserepl() {
        return userepl;
    }

    public void setUserepl(Boolean userepl) {
        this.userepl = userepl;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public Object getValuntil() {
        return valuntil;
    }

    public void setValuntil(Object valuntil) {
        this.valuntil = valuntil;
    }

    public Object getUseconfig() {
        return useconfig;
    }

    public void setUseconfig(Object useconfig) {
        this.useconfig = useconfig;
    }
}