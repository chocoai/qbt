package com.qbt.data.migration.pgsql.entity;

public class PgConstraint {
    private String conname;

    private Long connamespace;

    private String contype;

    private Boolean condeferrable;

    private Boolean condeferred;

    private Boolean convalidated;

    private Long conrelid;

    private Long contypid;

    private Long conindid;

    private Long confrelid;

    private String confupdtype;

    private String confdeltype;

    private String confmatchtype;

    private Boolean conislocal;

    private Integer coninhcount;

    private Boolean connoinherit;

    private Object conkey;

    private Object confkey;

    private Object conpfeqop;

    private Object conppeqop;

    private Object conffeqop;

    private Object conexclop;

    private Object conbin;

    private String consrc;

    public String getConname() {
        return conname;
    }

    public void setConname(String conname) {
        this.conname = conname == null ? null : conname.trim();
    }

    public Long getConnamespace() {
        return connamespace;
    }

    public void setConnamespace(Long connamespace) {
        this.connamespace = connamespace;
    }

    public String getContype() {
        return contype;
    }

    public void setContype(String contype) {
        this.contype = contype == null ? null : contype.trim();
    }

    public Boolean getCondeferrable() {
        return condeferrable;
    }

    public void setCondeferrable(Boolean condeferrable) {
        this.condeferrable = condeferrable;
    }

    public Boolean getCondeferred() {
        return condeferred;
    }

    public void setCondeferred(Boolean condeferred) {
        this.condeferred = condeferred;
    }

    public Boolean getConvalidated() {
        return convalidated;
    }

    public void setConvalidated(Boolean convalidated) {
        this.convalidated = convalidated;
    }

    public Long getConrelid() {
        return conrelid;
    }

    public void setConrelid(Long conrelid) {
        this.conrelid = conrelid;
    }

    public Long getContypid() {
        return contypid;
    }

    public void setContypid(Long contypid) {
        this.contypid = contypid;
    }

    public Long getConindid() {
        return conindid;
    }

    public void setConindid(Long conindid) {
        this.conindid = conindid;
    }

    public Long getConfrelid() {
        return confrelid;
    }

    public void setConfrelid(Long confrelid) {
        this.confrelid = confrelid;
    }

    public String getConfupdtype() {
        return confupdtype;
    }

    public void setConfupdtype(String confupdtype) {
        this.confupdtype = confupdtype == null ? null : confupdtype.trim();
    }

    public String getConfdeltype() {
        return confdeltype;
    }

    public void setConfdeltype(String confdeltype) {
        this.confdeltype = confdeltype == null ? null : confdeltype.trim();
    }

    public String getConfmatchtype() {
        return confmatchtype;
    }

    public void setConfmatchtype(String confmatchtype) {
        this.confmatchtype = confmatchtype == null ? null : confmatchtype.trim();
    }

    public Boolean getConislocal() {
        return conislocal;
    }

    public void setConislocal(Boolean conislocal) {
        this.conislocal = conislocal;
    }

    public Integer getConinhcount() {
        return coninhcount;
    }

    public void setConinhcount(Integer coninhcount) {
        this.coninhcount = coninhcount;
    }

    public Boolean getConnoinherit() {
        return connoinherit;
    }

    public void setConnoinherit(Boolean connoinherit) {
        this.connoinherit = connoinherit;
    }

    public Object getConkey() {
        return conkey;
    }

    public void setConkey(Object conkey) {
        this.conkey = conkey;
    }

    public Object getConfkey() {
        return confkey;
    }

    public void setConfkey(Object confkey) {
        this.confkey = confkey;
    }

    public Object getConpfeqop() {
        return conpfeqop;
    }

    public void setConpfeqop(Object conpfeqop) {
        this.conpfeqop = conpfeqop;
    }

    public Object getConppeqop() {
        return conppeqop;
    }

    public void setConppeqop(Object conppeqop) {
        this.conppeqop = conppeqop;
    }

    public Object getConffeqop() {
        return conffeqop;
    }

    public void setConffeqop(Object conffeqop) {
        this.conffeqop = conffeqop;
    }

    public Object getConexclop() {
        return conexclop;
    }

    public void setConexclop(Object conexclop) {
        this.conexclop = conexclop;
    }

    public Object getConbin() {
        return conbin;
    }

    public void setConbin(Object conbin) {
        this.conbin = conbin;
    }

    public String getConsrc() {
        return consrc;
    }

    public void setConsrc(String consrc) {
        this.consrc = consrc == null ? null : consrc.trim();
    }
}