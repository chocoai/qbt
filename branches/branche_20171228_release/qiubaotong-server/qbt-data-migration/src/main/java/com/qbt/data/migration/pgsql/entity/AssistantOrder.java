package com.qbt.data.migration.pgsql.entity;

import java.util.Date;

public class AssistantOrder {
    private Integer id;

    private Long group_id;

    private String number;

    private String waybill;

    private Long assistant_bag_id;

    private String assistant_bag_owner_name;

    private String assistant_bag_owner_mobile;

    private Integer assistant_bag_bag_cover;

    private Long sender_id;

    private String sender_name;

    private String sender_mobile;

    private Long receiver_id;

    private String receiver_name;

    private String receiver_mobile;

    private Integer status;

    private Date created_at;

    private Date deleted_at;

    private Date updated_at;

    private Integer version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Long group_id) {
        this.group_id = group_id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getWaybill() {
        return waybill;
    }

    public void setWaybill(String waybill) {
        this.waybill = waybill == null ? null : waybill.trim();
    }

    public Long getAssistant_bag_id() {
        return assistant_bag_id;
    }

    public void setAssistant_bag_id(Long assistant_bag_id) {
        this.assistant_bag_id = assistant_bag_id;
    }

    public String getAssistant_bag_owner_name() {
        return assistant_bag_owner_name;
    }

    public void setAssistant_bag_owner_name(String assistant_bag_owner_name) {
        this.assistant_bag_owner_name = assistant_bag_owner_name == null ? null : assistant_bag_owner_name.trim();
    }

    public String getAssistant_bag_owner_mobile() {
        return assistant_bag_owner_mobile;
    }

    public void setAssistant_bag_owner_mobile(String assistant_bag_owner_mobile) {
        this.assistant_bag_owner_mobile = assistant_bag_owner_mobile == null ? null : assistant_bag_owner_mobile.trim();
    }

    public Integer getAssistant_bag_bag_cover() {
        return assistant_bag_bag_cover;
    }

    public void setAssistant_bag_bag_cover(Integer assistant_bag_bag_cover) {
        this.assistant_bag_bag_cover = assistant_bag_bag_cover;
    }

    public Long getSender_id() {
        return sender_id;
    }

    public void setSender_id(Long sender_id) {
        this.sender_id = sender_id;
    }

    public String getSender_name() {
        return sender_name;
    }

    public void setSender_name(String sender_name) {
        this.sender_name = sender_name == null ? null : sender_name.trim();
    }

    public String getSender_mobile() {
        return sender_mobile;
    }

    public void setSender_mobile(String sender_mobile) {
        this.sender_mobile = sender_mobile == null ? null : sender_mobile.trim();
    }

    public Long getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(Long receiver_id) {
        this.receiver_id = receiver_id;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name == null ? null : receiver_name.trim();
    }

    public String getReceiver_mobile() {
        return receiver_mobile;
    }

    public void setReceiver_mobile(String receiver_mobile) {
        this.receiver_mobile = receiver_mobile == null ? null : receiver_mobile.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Date deleted_at) {
        this.deleted_at = deleted_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}