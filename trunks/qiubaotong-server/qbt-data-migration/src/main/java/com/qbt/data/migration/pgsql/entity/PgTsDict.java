package com.qbt.data.migration.pgsql.entity;

public class PgTsDict {
    private String dictname;

    private Long dictnamespace;

    private Long dictowner;

    private Long dicttemplate;

    private String dictinitoption;

    public String getDictname() {
        return dictname;
    }

    public void setDictname(String dictname) {
        this.dictname = dictname == null ? null : dictname.trim();
    }

    public Long getDictnamespace() {
        return dictnamespace;
    }

    public void setDictnamespace(Long dictnamespace) {
        this.dictnamespace = dictnamespace;
    }

    public Long getDictowner() {
        return dictowner;
    }

    public void setDictowner(Long dictowner) {
        this.dictowner = dictowner;
    }

    public Long getDicttemplate() {
        return dicttemplate;
    }

    public void setDicttemplate(Long dicttemplate) {
        this.dicttemplate = dicttemplate;
    }

    public String getDictinitoption() {
        return dictinitoption;
    }

    public void setDictinitoption(String dictinitoption) {
        this.dictinitoption = dictinitoption == null ? null : dictinitoption.trim();
    }
}