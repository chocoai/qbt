package com.qbt.data.migration.pgsql.entity;

import java.util.Date;

public class PgStatReplication {
    private Integer pid;

    private Long usesysid;

    private String usename;

    private String application_name;

    private Object client_addr;

    private String client_hostname;

    private Integer client_port;

    private Date backend_start;

    private String state;

    private String sent_location;

    private String write_location;

    private String flush_location;

    private String replay_location;

    private Integer sync_priority;

    private String sync_state;

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getSent_location() {
        return sent_location;
    }

    public void setSent_location(String sent_location) {
        this.sent_location = sent_location == null ? null : sent_location.trim();
    }

    public String getWrite_location() {
        return write_location;
    }

    public void setWrite_location(String write_location) {
        this.write_location = write_location == null ? null : write_location.trim();
    }

    public String getFlush_location() {
        return flush_location;
    }

    public void setFlush_location(String flush_location) {
        this.flush_location = flush_location == null ? null : flush_location.trim();
    }

    public String getReplay_location() {
        return replay_location;
    }

    public void setReplay_location(String replay_location) {
        this.replay_location = replay_location == null ? null : replay_location.trim();
    }

    public Integer getSync_priority() {
        return sync_priority;
    }

    public void setSync_priority(Integer sync_priority) {
        this.sync_priority = sync_priority;
    }

    public String getSync_state() {
        return sync_state;
    }

    public void setSync_state(String sync_state) {
        this.sync_state = sync_state == null ? null : sync_state.trim();
    }
}