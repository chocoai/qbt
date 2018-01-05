package com.qbt.data.migration.pgsql.entity;

import java.util.Date;

public class Coupon {
    private Integer id;

    private Integer activity_id;

    private String code;

    private Integer type;

    private Double amount;

    private Double discount;

    private Double special_amount;

    private Double amount_denomination;

    private String description;

    private Boolean valid;

    private Date created_at;

    private Boolean locked;

    private Integer version;

    private Long which_order_lock;

    private Date lock_time;

    private Boolean is_claim;

    private Long claim_user_id;

    private String claim_user_name;

    private Boolean is_distribute;

    private Long distribute_user_id;

    private String distribute_user_name;

    private Integer xian_jin_type;

    private Integer li_bao_id;

    private Integer li_bao_index;

    private Double li_bao_worth;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(Integer activity_id) {
        this.activity_id = activity_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getSpecial_amount() {
        return special_amount;
    }

    public void setSpecial_amount(Double special_amount) {
        this.special_amount = special_amount;
    }

    public Double getAmount_denomination() {
        return amount_denomination;
    }

    public void setAmount_denomination(Double amount_denomination) {
        this.amount_denomination = amount_denomination;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Long getWhich_order_lock() {
        return which_order_lock;
    }

    public void setWhich_order_lock(Long which_order_lock) {
        this.which_order_lock = which_order_lock;
    }

    public Date getLock_time() {
        return lock_time;
    }

    public void setLock_time(Date lock_time) {
        this.lock_time = lock_time;
    }

    public Boolean getIs_claim() {
        return is_claim;
    }

    public void setIs_claim(Boolean is_claim) {
        this.is_claim = is_claim;
    }

    public Long getClaim_user_id() {
        return claim_user_id;
    }

    public void setClaim_user_id(Long claim_user_id) {
        this.claim_user_id = claim_user_id;
    }

    public String getClaim_user_name() {
        return claim_user_name;
    }

    public void setClaim_user_name(String claim_user_name) {
        this.claim_user_name = claim_user_name == null ? null : claim_user_name.trim();
    }

    public Boolean getIs_distribute() {
        return is_distribute;
    }

    public void setIs_distribute(Boolean is_distribute) {
        this.is_distribute = is_distribute;
    }

    public Long getDistribute_user_id() {
        return distribute_user_id;
    }

    public void setDistribute_user_id(Long distribute_user_id) {
        this.distribute_user_id = distribute_user_id;
    }

    public String getDistribute_user_name() {
        return distribute_user_name;
    }

    public void setDistribute_user_name(String distribute_user_name) {
        this.distribute_user_name = distribute_user_name == null ? null : distribute_user_name.trim();
    }

    public Integer getXian_jin_type() {
        return xian_jin_type;
    }

    public void setXian_jin_type(Integer xian_jin_type) {
        this.xian_jin_type = xian_jin_type;
    }

    public Integer getLi_bao_id() {
        return li_bao_id;
    }

    public void setLi_bao_id(Integer li_bao_id) {
        this.li_bao_id = li_bao_id;
    }

    public Integer getLi_bao_index() {
        return li_bao_index;
    }

    public void setLi_bao_index(Integer li_bao_index) {
        this.li_bao_index = li_bao_index;
    }

    public Double getLi_bao_worth() {
        return li_bao_worth;
    }

    public void setLi_bao_worth(Double li_bao_worth) {
        this.li_bao_worth = li_bao_worth;
    }
}