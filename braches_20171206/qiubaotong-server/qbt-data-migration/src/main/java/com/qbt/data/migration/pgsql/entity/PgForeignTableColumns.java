package com.qbt.data.migration.pgsql.entity;

public class PgForeignTableColumns {
    private String nspname;

    private String relname;

    private String attname;

    private Object attfdwoptions;

    public String getNspname() {
        return nspname;
    }

    public void setNspname(String nspname) {
        this.nspname = nspname == null ? null : nspname.trim();
    }

    public String getRelname() {
        return relname;
    }

    public void setRelname(String relname) {
        this.relname = relname == null ? null : relname.trim();
    }

    public String getAttname() {
        return attname;
    }

    public void setAttname(String attname) {
        this.attname = attname == null ? null : attname.trim();
    }

    public Object getAttfdwoptions() {
        return attfdwoptions;
    }

    public void setAttfdwoptions(Object attfdwoptions) {
        this.attfdwoptions = attfdwoptions;
    }
}