package com.qbt.data.migration.pgsql.entity;

import java.util.Date;

public class UserCourse {
    private Integer id;

    private String name;

    private String email;

    private String mobile;

    private String password;

    private Short sex;

    private String verify_code;

    private String salt;

    private Date created_at;

    private Boolean accept_push;

    private Boolean is_validated;

    private Long course_id;

    private Long bank_branch_id;

    private Long sf_site_id;

    private Boolean is_customer_service;

    private Boolean enjoy_assistant_fee;

    private String openid;

    private String nickname;

    private String head_img_url;

    private String first_letter;

    private Short type;

    private Long sf_airport_id;

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

    public Long getBank_branch_id() {
        return bank_branch_id;
    }

    public void setBank_branch_id(Long bank_branch_id) {
        this.bank_branch_id = bank_branch_id;
    }

    public Long getSf_site_id() {
        return sf_site_id;
    }

    public void setSf_site_id(Long sf_site_id) {
        this.sf_site_id = sf_site_id;
    }

    public Boolean getIs_customer_service() {
        return is_customer_service;
    }

    public void setIs_customer_service(Boolean is_customer_service) {
        this.is_customer_service = is_customer_service;
    }

    public Boolean getEnjoy_assistant_fee() {
        return enjoy_assistant_fee;
    }

    public void setEnjoy_assistant_fee(Boolean enjoy_assistant_fee) {
        this.enjoy_assistant_fee = enjoy_assistant_fee;
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

    public String getFirst_letter() {
        return first_letter;
    }

    public void setFirst_letter(String first_letter) {
        this.first_letter = first_letter == null ? null : first_letter.trim();
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Long getSf_airport_id() {
        return sf_airport_id;
    }

    public void setSf_airport_id(Long sf_airport_id) {
        this.sf_airport_id = sf_airport_id;
    }
}