package com.qbt.persistent.entity;

import com.qbt.common.entity.BaseEntity;

public class OrderEmailTemplet extends BaseEntity{

    private Integer orderEmailInsuredId;

    private String emailTemplateCode;

    private String emailConfigCode;

    public Integer getOrderEmailInsuredId() {
        return orderEmailInsuredId;
    }

    public void setOrderEmailInsuredId(Integer orderEmailInsuredId) {
        this.orderEmailInsuredId = orderEmailInsuredId;
    }

    public String getEmailTemplateCode() {
        return emailTemplateCode;
    }

    public void setEmailTemplateCode(String emailTemplateCode) {
        this.emailTemplateCode = emailTemplateCode == null ? null : emailTemplateCode.trim();
    }

    public String getEmailConfigCode() {
        return emailConfigCode;
    }

    public void setEmailConfigCode(String emailConfigCode) {
        this.emailConfigCode = emailConfigCode == null ? null : emailConfigCode.trim();
    }
}