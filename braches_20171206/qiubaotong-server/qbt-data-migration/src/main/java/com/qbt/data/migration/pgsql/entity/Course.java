package com.qbt.data.migration.pgsql.entity;

import java.util.Date;

public class Course {
    private Integer id;

    private String name;

    private String short_name;

    private String english_name;

    private String initial;

    private Short golf_hole;

    private String logo;

    private String province;

    private String city;

    private String county;

    private String address;

    private String telephone;

    private String description;

    private Short status;

    private Date created_at;

    private Date updated_at;

    private String contact;

    private String mobile;

    private Double lon;

    private Double lat;

    private String first_letter;

    private String remark;

    private String introducing;

    private String website;

    private String wechat;

    private String introducing_href;

    private Boolean has_assistant;

    private String sign_place;

    private String send_place;

    private String start_work_time;

    private String end_work_time;

    private String product_intro;

    private String feature_intro;

    private String food_intro;

    private String other_intro;

    private Float bag_deposit_charge;

    private Short tee_time_interval;

    private String tee_time_earliest;

    private String tee_time_latest;

    private Short transition_closed_time;

    private String weather;

    private String transition_closed_begin_time;

    private String transition_closed_end_time;

    private String introduction_href;

    private Date deleted_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name == null ? null : short_name.trim();
    }

    public String getEnglish_name() {
        return english_name;
    }

    public void setEnglish_name(String english_name) {
        this.english_name = english_name == null ? null : english_name.trim();
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial == null ? null : initial.trim();
    }

    public Short getGolf_hole() {
        return golf_hole;
    }

    public void setGolf_hole(Short golf_hole) {
        this.golf_hole = golf_hole;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public String getFirst_letter() {
        return first_letter;
    }

    public void setFirst_letter(String first_letter) {
        this.first_letter = first_letter == null ? null : first_letter.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getIntroducing() {
        return introducing;
    }

    public void setIntroducing(String introducing) {
        this.introducing = introducing == null ? null : introducing.trim();
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public String getIntroducing_href() {
        return introducing_href;
    }

    public void setIntroducing_href(String introducing_href) {
        this.introducing_href = introducing_href == null ? null : introducing_href.trim();
    }

    public Boolean getHas_assistant() {
        return has_assistant;
    }

    public void setHas_assistant(Boolean has_assistant) {
        this.has_assistant = has_assistant;
    }

    public String getSign_place() {
        return sign_place;
    }

    public void setSign_place(String sign_place) {
        this.sign_place = sign_place == null ? null : sign_place.trim();
    }

    public String getSend_place() {
        return send_place;
    }

    public void setSend_place(String send_place) {
        this.send_place = send_place == null ? null : send_place.trim();
    }

    public String getStart_work_time() {
        return start_work_time;
    }

    public void setStart_work_time(String start_work_time) {
        this.start_work_time = start_work_time == null ? null : start_work_time.trim();
    }

    public String getEnd_work_time() {
        return end_work_time;
    }

    public void setEnd_work_time(String end_work_time) {
        this.end_work_time = end_work_time == null ? null : end_work_time.trim();
    }

    public String getProduct_intro() {
        return product_intro;
    }

    public void setProduct_intro(String product_intro) {
        this.product_intro = product_intro == null ? null : product_intro.trim();
    }

    public String getFeature_intro() {
        return feature_intro;
    }

    public void setFeature_intro(String feature_intro) {
        this.feature_intro = feature_intro == null ? null : feature_intro.trim();
    }

    public String getFood_intro() {
        return food_intro;
    }

    public void setFood_intro(String food_intro) {
        this.food_intro = food_intro == null ? null : food_intro.trim();
    }

    public String getOther_intro() {
        return other_intro;
    }

    public void setOther_intro(String other_intro) {
        this.other_intro = other_intro == null ? null : other_intro.trim();
    }

    public Float getBag_deposit_charge() {
        return bag_deposit_charge;
    }

    public void setBag_deposit_charge(Float bag_deposit_charge) {
        this.bag_deposit_charge = bag_deposit_charge;
    }

    public Short getTee_time_interval() {
        return tee_time_interval;
    }

    public void setTee_time_interval(Short tee_time_interval) {
        this.tee_time_interval = tee_time_interval;
    }

    public String getTee_time_earliest() {
        return tee_time_earliest;
    }

    public void setTee_time_earliest(String tee_time_earliest) {
        this.tee_time_earliest = tee_time_earliest == null ? null : tee_time_earliest.trim();
    }

    public String getTee_time_latest() {
        return tee_time_latest;
    }

    public void setTee_time_latest(String tee_time_latest) {
        this.tee_time_latest = tee_time_latest == null ? null : tee_time_latest.trim();
    }

    public Short getTransition_closed_time() {
        return transition_closed_time;
    }

    public void setTransition_closed_time(Short transition_closed_time) {
        this.transition_closed_time = transition_closed_time;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather == null ? null : weather.trim();
    }

    public String getTransition_closed_begin_time() {
        return transition_closed_begin_time;
    }

    public void setTransition_closed_begin_time(String transition_closed_begin_time) {
        this.transition_closed_begin_time = transition_closed_begin_time == null ? null : transition_closed_begin_time.trim();
    }

    public String getTransition_closed_end_time() {
        return transition_closed_end_time;
    }

    public void setTransition_closed_end_time(String transition_closed_end_time) {
        this.transition_closed_end_time = transition_closed_end_time == null ? null : transition_closed_end_time.trim();
    }

    public String getIntroduction_href() {
        return introduction_href;
    }

    public void setIntroduction_href(String introduction_href) {
        this.introduction_href = introduction_href == null ? null : introduction_href.trim();
    }

    public Date getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Date deleted_at) {
        this.deleted_at = deleted_at;
    }
}