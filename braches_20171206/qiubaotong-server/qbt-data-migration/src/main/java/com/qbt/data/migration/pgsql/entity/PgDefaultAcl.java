package com.qbt.data.migration.pgsql.entity;

public class PgDefaultAcl {
    private Long defaclrole;

    private Long defaclnamespace;

    private String defaclobjtype;

    private Object defaclacl;

    public Long getDefaclrole() {
        return defaclrole;
    }

    public void setDefaclrole(Long defaclrole) {
        this.defaclrole = defaclrole;
    }

    public Long getDefaclnamespace() {
        return defaclnamespace;
    }

    public void setDefaclnamespace(Long defaclnamespace) {
        this.defaclnamespace = defaclnamespace;
    }

    public String getDefaclobjtype() {
        return defaclobjtype;
    }

    public void setDefaclobjtype(String defaclobjtype) {
        this.defaclobjtype = defaclobjtype == null ? null : defaclobjtype.trim();
    }

    public Object getDefaclacl() {
        return defaclacl;
    }

    public void setDefaclacl(Object defaclacl) {
        this.defaclacl = defaclacl;
    }
}