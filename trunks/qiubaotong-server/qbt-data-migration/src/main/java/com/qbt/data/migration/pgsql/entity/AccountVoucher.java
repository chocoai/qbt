package com.qbt.data.migration.pgsql.entity;

import java.util.Date;

public class AccountVoucher {
    private Integer id;

    private Long account_weixin_id;

    private Boolean used;

    private Date created;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getAccount_weixin_id() {
        return account_weixin_id;
    }

    public void setAccount_weixin_id(Long account_weixin_id) {
        this.account_weixin_id = account_weixin_id;
    }

    public Boolean getUsed() {
        return used;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}