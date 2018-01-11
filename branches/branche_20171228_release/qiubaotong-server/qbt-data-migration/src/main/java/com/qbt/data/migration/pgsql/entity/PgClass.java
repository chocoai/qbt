package com.qbt.data.migration.pgsql.entity;

public class PgClass {
    private String relname;

    private Long relnamespace;

    private Long reltype;

    private Long reloftype;

    private Long relowner;

    private Long relam;

    private Long relfilenode;

    private Long reltablespace;

    private Integer relpages;

    private Float reltuples;

    private Integer relallvisible;

    private Long reltoastrelid;

    private Long reltoastidxid;

    private Boolean relhasindex;

    private Boolean relisshared;

    private String relpersistence;

    private String relkind;

    private Short relnatts;

    private Short relchecks;

    private Boolean relhasoids;

    private Boolean relhaspkey;

    private Boolean relhasrules;

    private Boolean relhastriggers;

    private Boolean relhassubclass;

    private Object relfrozenxid;

    private Object relacl;

    private Object reloptions;

    public String getRelname() {
        return relname;
    }

    public void setRelname(String relname) {
        this.relname = relname == null ? null : relname.trim();
    }

    public Long getRelnamespace() {
        return relnamespace;
    }

    public void setRelnamespace(Long relnamespace) {
        this.relnamespace = relnamespace;
    }

    public Long getReltype() {
        return reltype;
    }

    public void setReltype(Long reltype) {
        this.reltype = reltype;
    }

    public Long getReloftype() {
        return reloftype;
    }

    public void setReloftype(Long reloftype) {
        this.reloftype = reloftype;
    }

    public Long getRelowner() {
        return relowner;
    }

    public void setRelowner(Long relowner) {
        this.relowner = relowner;
    }

    public Long getRelam() {
        return relam;
    }

    public void setRelam(Long relam) {
        this.relam = relam;
    }

    public Long getRelfilenode() {
        return relfilenode;
    }

    public void setRelfilenode(Long relfilenode) {
        this.relfilenode = relfilenode;
    }

    public Long getReltablespace() {
        return reltablespace;
    }

    public void setReltablespace(Long reltablespace) {
        this.reltablespace = reltablespace;
    }

    public Integer getRelpages() {
        return relpages;
    }

    public void setRelpages(Integer relpages) {
        this.relpages = relpages;
    }

    public Float getReltuples() {
        return reltuples;
    }

    public void setReltuples(Float reltuples) {
        this.reltuples = reltuples;
    }

    public Integer getRelallvisible() {
        return relallvisible;
    }

    public void setRelallvisible(Integer relallvisible) {
        this.relallvisible = relallvisible;
    }

    public Long getReltoastrelid() {
        return reltoastrelid;
    }

    public void setReltoastrelid(Long reltoastrelid) {
        this.reltoastrelid = reltoastrelid;
    }

    public Long getReltoastidxid() {
        return reltoastidxid;
    }

    public void setReltoastidxid(Long reltoastidxid) {
        this.reltoastidxid = reltoastidxid;
    }

    public Boolean getRelhasindex() {
        return relhasindex;
    }

    public void setRelhasindex(Boolean relhasindex) {
        this.relhasindex = relhasindex;
    }

    public Boolean getRelisshared() {
        return relisshared;
    }

    public void setRelisshared(Boolean relisshared) {
        this.relisshared = relisshared;
    }

    public String getRelpersistence() {
        return relpersistence;
    }

    public void setRelpersistence(String relpersistence) {
        this.relpersistence = relpersistence == null ? null : relpersistence.trim();
    }

    public String getRelkind() {
        return relkind;
    }

    public void setRelkind(String relkind) {
        this.relkind = relkind == null ? null : relkind.trim();
    }

    public Short getRelnatts() {
        return relnatts;
    }

    public void setRelnatts(Short relnatts) {
        this.relnatts = relnatts;
    }

    public Short getRelchecks() {
        return relchecks;
    }

    public void setRelchecks(Short relchecks) {
        this.relchecks = relchecks;
    }

    public Boolean getRelhasoids() {
        return relhasoids;
    }

    public void setRelhasoids(Boolean relhasoids) {
        this.relhasoids = relhasoids;
    }

    public Boolean getRelhaspkey() {
        return relhaspkey;
    }

    public void setRelhaspkey(Boolean relhaspkey) {
        this.relhaspkey = relhaspkey;
    }

    public Boolean getRelhasrules() {
        return relhasrules;
    }

    public void setRelhasrules(Boolean relhasrules) {
        this.relhasrules = relhasrules;
    }

    public Boolean getRelhastriggers() {
        return relhastriggers;
    }

    public void setRelhastriggers(Boolean relhastriggers) {
        this.relhastriggers = relhastriggers;
    }

    public Boolean getRelhassubclass() {
        return relhassubclass;
    }

    public void setRelhassubclass(Boolean relhassubclass) {
        this.relhassubclass = relhassubclass;
    }

    public Object getRelfrozenxid() {
        return relfrozenxid;
    }

    public void setRelfrozenxid(Object relfrozenxid) {
        this.relfrozenxid = relfrozenxid;
    }

    public Object getRelacl() {
        return relacl;
    }

    public void setRelacl(Object relacl) {
        this.relacl = relacl;
    }

    public Object getReloptions() {
        return reloptions;
    }

    public void setReloptions(Object reloptions) {
        this.reloptions = reloptions;
    }
}