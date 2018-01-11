package com.qbt.data.migration.pgsql.entity;

import java.util.Date;

public class PgStatActivity {
    private Long datid;

    private String datname;

    private Integer pid;

    private Long usesysid;

    private String usename;

    private String application_name;

    private Object client_addr;

    private String client_hostname;

    private Integer client_port;

    private Date backend_start;

    private Date xact_start;

    private Date query_start;

    private Date state_change;

    private Boolean waiting;

    private String state;

    private String query;

    public Long getDatid() {
        return datid;
    }

    public void setDatid(Long datid) {
        this.datid = datid;
    }

    public String getDatname() {
        return datname;
    }

    public void setDatname(String datname) {
        this.datname = datname == null ? null : datname.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Long getUsesysid() {
        return usesysid;
    }

    public void setUsesysid(Long usesysid) {
        this.usesysid = usesysid;
    }

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename == null ? null : usename.trim();
    }

    public String getApplication_name() {
        return application_name;
    }

    public void setApplication_name(String application_name) {
        this.application_name = application_name == null ? null : application_name.trim();
    }

    public Object getClient_addr() {
        return client_addr;
    }

    public void setClient_addr(Object client_addr) {
        this.client_addr = client_addr;
    }

    public String getClient_hostname() {
        return client_hostname;
    }

    public void setClient_hostname(String client_hostname) {
        this.client_hostname = client_hostname == null ? null : client_hostname.trim();
    }

    public Integer getClient_port() {
        return client_port;
    }

    public void setClient_port(Integer client_port) {
        this.client_port = client_port;
    }

    public Date getBackend_start() {
        return backend_start;
    }

    public void setBackend_start(Date backend_start) {
        this.backend_start = backend_start;
    }

    public Date getXact_start() {
        return xact_start;
    }

    public void setXact_start(Date xact_start) {
        this.xact_start = xact_start;
    }

    public Date getQuery_start() {
        return query_start;
    }

    public void setQuery_start(Date query_start) {
        this.query_start = query_start;
    }

    public Date getState_change() {
        return state_change;
    }

    public void setState_change(Date state_change) {
        this.state_change = state_change;
    }

    public Boolean getWaiting() {
        return waiting;
    }

    public void setWaiting(Boolean waiting) {
        this.waiting = waiting;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query == null ? null : query.trim();
    }
}