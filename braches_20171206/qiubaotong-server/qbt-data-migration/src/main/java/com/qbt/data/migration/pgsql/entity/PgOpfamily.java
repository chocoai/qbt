package com.qbt.data.migration.pgsql.entity;

public class PgOpfamily {
    private Long opfmethod;

    private String opfname;

    private Long opfnamespace;

    private Long opfowner;

    public Long getOpfmethod() {
        return opfmethod;
    }

    public void setOpfmethod(Long opfmethod) {
        this.opfmethod = opfmethod;
    }

    public String getOpfname() {
        return opfname;
    }

    public void setOpfname(String opfname) {
        this.opfname = opfname == null ? null : opfname.trim();
    }

    public Long getOpfnamespace() {
        return opfnamespace;
    }

    public void setOpfnamespace(Long opfnamespace) {
        this.opfnamespace = opfnamespace;
    }

    public Long getOpfowner() {
        return opfowner;
    }

    public void setOpfowner(Long opfowner) {
        this.opfowner = opfowner;
    }
}