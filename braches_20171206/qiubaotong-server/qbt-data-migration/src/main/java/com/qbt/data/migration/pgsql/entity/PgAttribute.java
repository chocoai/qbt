package com.qbt.data.migration.pgsql.entity;

public class PgAttribute {
    private Long attrelid;

    private String attname;

    private Long atttypid;

    private Integer attstattarget;

    private Short attlen;

    private Short attnum;

    private Integer attndims;

    private Integer attcacheoff;

    private Integer atttypmod;

    private Boolean attbyval;

    private String attstorage;

    private String attalign;

    private Boolean attnotnull;

    private Boolean atthasdef;

    private Boolean attisdropped;

    private Boolean attislocal;

    private Integer attinhcount;

    private Long attcollation;

    private Object attacl;

    private Object attoptions;

    private Object attfdwoptions;

    public Long getAttrelid() {
        return attrelid;
    }

    public void setAttrelid(Long attrelid) {
        this.attrelid = attrelid;
    }

    public String getAttname() {
        return attname;
    }

    public void setAttname(String attname) {
        this.attname = attname == null ? null : attname.trim();
    }

    public Long getAtttypid() {
        return atttypid;
    }

    public void setAtttypid(Long atttypid) {
        this.atttypid = atttypid;
    }

    public Integer getAttstattarget() {
        return attstattarget;
    }

    public void setAttstattarget(Integer attstattarget) {
        this.attstattarget = attstattarget;
    }

    public Short getAttlen() {
        return attlen;
    }

    public void setAttlen(Short attlen) {
        this.attlen = attlen;
    }

    public Short getAttnum() {
        return attnum;
    }

    public void setAttnum(Short attnum) {
        this.attnum = attnum;
    }

    public Integer getAttndims() {
        return attndims;
    }

    public void setAttndims(Integer attndims) {
        this.attndims = attndims;
    }

    public Integer getAttcacheoff() {
        return attcacheoff;
    }

    public void setAttcacheoff(Integer attcacheoff) {
        this.attcacheoff = attcacheoff;
    }

    public Integer getAtttypmod() {
        return atttypmod;
    }

    public void setAtttypmod(Integer atttypmod) {
        this.atttypmod = atttypmod;
    }

    public Boolean getAttbyval() {
        return attbyval;
    }

    public void setAttbyval(Boolean attbyval) {
        this.attbyval = attbyval;
    }

    public String getAttstorage() {
        return attstorage;
    }

    public void setAttstorage(String attstorage) {
        this.attstorage = attstorage == null ? null : attstorage.trim();
    }

    public String getAttalign() {
        return attalign;
    }

    public void setAttalign(String attalign) {
        this.attalign = attalign == null ? null : attalign.trim();
    }

    public Boolean getAttnotnull() {
        return attnotnull;
    }

    public void setAttnotnull(Boolean attnotnull) {
        this.attnotnull = attnotnull;
    }

    public Boolean getAtthasdef() {
        return atthasdef;
    }

    public void setAtthasdef(Boolean atthasdef) {
        this.atthasdef = atthasdef;
    }

    public Boolean getAttisdropped() {
        return attisdropped;
    }

    public void setAttisdropped(Boolean attisdropped) {
        this.attisdropped = attisdropped;
    }

    public Boolean getAttislocal() {
        return attislocal;
    }

    public void setAttislocal(Boolean attislocal) {
        this.attislocal = attislocal;
    }

    public Integer getAttinhcount() {
        return attinhcount;
    }

    public void setAttinhcount(Integer attinhcount) {
        this.attinhcount = attinhcount;
    }

    public Long getAttcollation() {
        return attcollation;
    }

    public void setAttcollation(Long attcollation) {
        this.attcollation = attcollation;
    }

    public Object getAttacl() {
        return attacl;
    }

    public void setAttacl(Object attacl) {
        this.attacl = attacl;
    }

    public Object getAttoptions() {
        return attoptions;
    }

    public void setAttoptions(Object attoptions) {
        this.attoptions = attoptions;
    }

    public Object getAttfdwoptions() {
        return attfdwoptions;
    }

    public void setAttfdwoptions(Object attfdwoptions) {
        this.attfdwoptions = attfdwoptions;
    }
}