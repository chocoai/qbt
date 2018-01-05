package com.qbt.data.migration.pgsql.entity;

import java.util.Date;

public class AssistantOrderGroup {
    private Integer id;

    private Long assistant_id;

    private String number;

    private String uuid;

    private String sender_address_type;

    private Long sender_address_id;

    private String sender_address_name;

    private String sender_province;

    private String sender_city;

    private String sender_county;

    private String sender_address_detail;

    private String receiver_address_type;

    private Long receiver_address_id;

    private String receiver_address_name;

    private String receiver_province;

    private String receiver_city;

    private String receiver_county;

    private String receiver_address_detail;

    private Date start_fetch_time;

    private Date end_fetch_time;

    private String business_type;

    private Date arrival_time;

    private Double amount;

    private Boolean is_paid;

    private Double payment_amount;

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

    public Long getAssistant_id() {
        return assistant_id;
    }

    public void setAssistant_id(Long assistant_id) {
        this.assistant_id = assistant_id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getSender_address_type() {
        return sender_address_type;
    }

    public void setSender_address_type(String sender_address_type) {
        this.sender_address_type = sender_address_type == null ? null : sender_address_type.trim();
    }

    public Long getSender_address_id() {
        return sender_address_id;
    }

    public void setSender_address_id(Long sender_address_id) {
        this.sender_address_id = sender_address_id;
    }

    public String getSender_address_name() {
        return sender_address_name;
    }

    public void setSender_address_name(String sender_address_name) {
        this.sender_address_name = sender_address_name == null ? null : sender_address_name.trim();
    }

    public String getSender_province() {
        return sender_province;
    }

    public void setSender_province(String sender_province) {
        this.sender_province = sender_province == null ? null : sender_province.trim();
    }

    public String getSender_city() {
        return sender_city;
    }

    public void setSender_city(String sender_city) {
        this.sender_city = sender_city == null ? null : sender_city.trim();
    }

    public String getSender_county() {
        return sender_county;
    }

    public void setSender_county(String sender_county) {
        this.sender_county = sender_county == null ? null : sender_county.trim();
    }

    public String getSender_address_detail() {
        return sender_address_detail;
    }

    public void setSender_address_detail(String sender_address_detail) {
        this.sender_address_detail = sender_address_detail == null ? null : sender_address_detail.trim();
    }

    public String getReceiver_address_type() {
        return receiver_address_type;
    }

    public void setReceiver_address_type(String receiver_address_type) {
        this.receiver_address_type = receiver_address_type == null ? null : receiver_address_type.trim();
    }

    public Long getReceiver_address_id() {
        return receiver_address_id;
    }

    public void setReceiver_address_id(Long receiver_address_id) {
        this.receiver_address_id = receiver_address_id;
    }

    public String getReceiver_address_name() {
        return receiver_address_name;
    }

    public void setReceiver_address_name(String receiver_address_name) {
        this.receiver_address_name = receiver_address_name == null ? null : receiver_address_name.trim();
    }

    public String getReceiver_province() {
        return receiver_province;
    }

    public void setReceiver_province(String receiver_province) {
        this.receiver_province = receiver_province == null ? null : receiver_province.trim();
    }

    public String getReceiver_city() {
        return receiver_city;
    }

    public void setReceiver_city(String receiver_city) {
        this.receiver_city = receiver_city == null ? null : receiver_city.trim();
    }

    public String getReceiver_county() {
        return receiver_county;
    }

    public void setReceiver_county(String receiver_county) {
        this.receiver_county = receiver_county == null ? null : receiver_county.trim();
    }

    public String getReceiver_address_detail() {
        return receiver_address_detail;
    }

    public void setReceiver_address_detail(String receiver_address_detail) {
        this.receiver_address_detail = receiver_address_detail == null ? null : receiver_address_detail.trim();
    }

    public Date getStart_fetch_time() {
        return start_fetch_time;
    }

    public void setStart_fetch_time(Date start_fetch_time) {
        this.start_fetch_time = start_fetch_time;
    }

    public Date getEnd_fetch_time() {
        return end_fetch_time;
    }

    public void setEnd_fetch_time(Date end_fetch_time) {
        this.end_fetch_time = end_fetch_time;
    }

    public String getBusiness_type() {
        return business_type;
    }

    public void setBusiness_type(String business_type) {
        this.business_type = business_type == null ? null : business_type.trim();
    }

    public Date getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(Date arrival_time) {
        this.arrival_time = arrival_time;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Boolean getIs_paid() {
        return is_paid;
    }

    public void setIs_paid(Boolean is_paid) {
        this.is_paid = is_paid;
    }

    public Double getPayment_amount() {
        return payment_amount;
    }

    public void setPayment_amount(Double payment_amount) {
        this.payment_amount = payment_amount;
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