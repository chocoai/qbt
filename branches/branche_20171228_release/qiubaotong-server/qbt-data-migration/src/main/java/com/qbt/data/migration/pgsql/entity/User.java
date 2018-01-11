package com.qbt.data.migration.pgsql.entity;

import java.util.Date;

public class User {
    private Integer id;

    private String name;

    private String email;

    private String mobile;

    private String password;

    private Short sex;

    private String verify_code;

    private String salt;

    private String course_ids;

    private Date created_at;

    private Boolean accept_push;

    private Boolean accept_promotion;

    private Boolean is_validated;

    private Long course_id;

    private String openid;

    private String nickname;

    private String head_img_url;

    private Double lastlon;

    private Double lastlat;

    private String coordsrc;

    private String province;

    private String city;

    private String county;

    private String first_letter;

    private String remark;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    public String getVerify_code() {
        return verify_code;
    }

    public void setVerify_code(String verify_code) {
        this.verify_code = verify_code == null ? null : verify_code.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getCourse_ids() {
        return course_ids;
    }

    public void setCourse_ids(String course_ids) {
        this.course_ids = course_ids == null ? null : course_ids.trim();
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Boolean getAccept_push() {
        return accept_push;
    }

    public void setAccept_push(Boolean accept_push) {
        this.accept_push = accept_push;
    }

    public Boolean getAccept_promotion() {
        return accept_promotion;
    }

    public void setAccept_promotion(Boolean accept_promotion) {
        this.accept_promotion = accept_promotion;
    }

    public Boolean getIs_validated() {
        return is_validated;
    }

    public void setIs_validated(Boolean is_validated) {
        this.is_validated = is_validated;
    }

    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getHead_img_url() {
        return head_img_url;
    }

    public void setHead_img_url(String head_img_url) {
        this.head_img_url = head_img_url == null ? null : head_img_url.trim();
    }

    public Double getLastlon() {
        return lastlon;
    }

    public void setLastlon(Double lastlon) {
        this.lastlon = lastlon;
    }

    public Double getLastlat() {
        return lastlat;
    }

    public void setLastlat(Double lastlat) {
        this.lastlat = lastlat;
    }

    public String getCoordsrc() {
        return coordsrc;
    }

    public void setCoordsrc(String coordsrc) {
        this.coordsrc = coordsrc == null ? null : coordsrc.trim();
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
}