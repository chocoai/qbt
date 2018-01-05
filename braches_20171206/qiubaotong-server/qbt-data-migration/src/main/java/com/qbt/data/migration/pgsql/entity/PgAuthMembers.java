package com.qbt.data.migration.pgsql.entity;

public class PgAuthMembers {
    private Long roleid;

    private Long member;

    private Long grantor;

    private Boolean admin_option;

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public Long getMember() {
        return member;
    }

    public void setMember(Long member) {
        this.member = member;
    }

    public Long getGrantor() {
        return grantor;
    }

    public void setGrantor(Long grantor) {
        this.grantor = grantor;
    }

    public Boolean getAdmin_option() {
        return admin_option;
    }

    public void setAdmin_option(Boolean admin_option) {
        this.admin_option = admin_option;
    }
}