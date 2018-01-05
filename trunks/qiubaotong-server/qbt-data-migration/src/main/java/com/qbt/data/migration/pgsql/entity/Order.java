package com.qbt.data.migration.pgsql.entity;

import java.util.Date;

public class Order {
    private Integer id;

    private Integer user_id;

    private String number;

    private String uuid;

    private String mail_no;

    private Double amount;

    private Boolean has_bag_cover;

    private String send_start_time;

    private Double insure;

    private String remark;

    private Integer club_count;

    private Integer headcover_count;

    private Boolean is_member;

    private String member_type;

    private String deliver_date;

    private String deliver_time;

    private String play_date;

    private String play_time;

    private Long j_course_id;

    private String j_contact;

    private String j_mobile;

    private String j_province;

    private String j_city;

    private String j_county;

    private String j_address;

    private String j_course_name;

    private String j_bag_no;

    private Long d_course_id;

    private String d_contact;

    private String d_mobile;

    private String d_province;

    private String d_city;

    private String d_county;

    private String d_address;

    private String d_course_name;

    private String d_bag_no;

    private Date created_at;

    private Boolean is_paid;

    private Date paid_at;

    private Integer status;

    private Short source;

    private Long bank_id;

    private Boolean coordinate_sign;

    private String sign_remark;

    private Boolean allow_sign;

    private Short sign_location;

    private String sent_remark;

    private Boolean has_send_bag;

    private Double total_amount;

    private Long coupon_id;

    private Double voucher;

    private Double discount;

    private Double special_amount;

    private Double freight;

    private String coupon_code;

    private String voucher_items;

    private String contraband_goods_remark;

    private Boolean is_booking;

    private Integer booking_status;

    private Double booking_price;

    private String j_addr_type;

    private Long j_special_addr_id;

    private String d_addr_type;

    private Long d_special_addr_id;

    private String favorables;

    private String send_time_section;

    private String express_type;

    private Date deleted_at;

    private Double extra_amount;

    private String extra_items;

    private Integer group_coupon_id;

    private Double group_discount;

    private String group_coupon_code;

    private Integer bag_cover_type;

    private Integer order_type;

    private Long bag_id;

    private Date updated_at;

    private Integer version;

    private String bag_name;

    private Integer bag_club_count;

    private Integer bag_club_cover_count;

    private Date fetch_bag_time;

    private String arrival_time;

    private Date start_fetch_time;

    private Date end_fetch_time;

    private String business_type;

    private String start_address_type;

    private Long start_address_id;

    private String start_address_name;

    private Long start_contact_id;

    private String end_address_type;

    private Long end_address_id;

    private String end_address_name;

    private Long end_contact_id;

    private Integer coupon_type;

    private Integer cover_type;

    private Long special_coupon_id;

    private String special_code;

    private String j_place_name;

    private String d_place_name;

    private Boolean is_paid_cancel;

    private Double insured_value;

    private Double insured_rates;

    private Double insured_fee;

    private Boolean is_helped;

    private Integer coupon_status;

    private String user_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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

    public String getMail_no() {
        return mail_no;
    }

    public void setMail_no(String mail_no) {
        this.mail_no = mail_no == null ? null : mail_no.trim();
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Boolean getHas_bag_cover() {
        return has_bag_cover;
    }

    public void setHas_bag_cover(Boolean has_bag_cover) {
        this.has_bag_cover = has_bag_cover;
    }

    public String getSend_start_time() {
        return send_start_time;
    }

    public void setSend_start_time(String send_start_time) {
        this.send_start_time = send_start_time == null ? null : send_start_time.trim();
    }

    public Double getInsure() {
        return insure;
    }

    public void setInsure(Double insure) {
        this.insure = insure;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getClub_count() {
        return club_count;
    }

    public void setClub_count(Integer club_count) {
        this.club_count = club_count;
    }

    public Integer getHeadcover_count() {
        return headcover_count;
    }

    public void setHeadcover_count(Integer headcover_count) {
        this.headcover_count = headcover_count;
    }

    public Boolean getIs_member() {
        return is_member;
    }

    public void setIs_member(Boolean is_member) {
        this.is_member = is_member;
    }

    public String getMember_type() {
        return member_type;
    }

    public void setMember_type(String member_type) {
        this.member_type = member_type == null ? null : member_type.trim();
    }

    public String getDeliver_date() {
        return deliver_date;
    }

    public void setDeliver_date(String deliver_date) {
        this.deliver_date = deliver_date == null ? null : deliver_date.trim();
    }

    public String getDeliver_time() {
        return deliver_time;
    }

    public void setDeliver_time(String deliver_time) {
        this.deliver_time = deliver_time == null ? null : deliver_time.trim();
    }

    public String getPlay_date() {
        return play_date;
    }

    public void setPlay_date(String play_date) {
        this.play_date = play_date == null ? null : play_date.trim();
    }

    public String getPlay_time() {
        return play_time;
    }

    public void setPlay_time(String play_time) {
        this.play_time = play_time == null ? null : play_time.trim();
    }

    public Long getJ_course_id() {
        return j_course_id;
    }

    public void setJ_course_id(Long j_course_id) {
        this.j_course_id = j_course_id;
    }

    public String getJ_contact() {
        return j_contact;
    }

    public void setJ_contact(String j_contact) {
        this.j_contact = j_contact == null ? null : j_contact.trim();
    }

    public String getJ_mobile() {
        return j_mobile;
    }

    public void setJ_mobile(String j_mobile) {
        this.j_mobile = j_mobile == null ? null : j_mobile.trim();
    }

    public String getJ_province() {
        return j_province;
    }

    public void setJ_province(String j_province) {
        this.j_province = j_province == null ? null : j_province.trim();
    }

    public String getJ_city() {
        return j_city;
    }

    public void setJ_city(String j_city) {
        this.j_city = j_city == null ? null : j_city.trim();
    }

    public String getJ_county() {
        return j_county;
    }

    public void setJ_county(String j_county) {
        this.j_county = j_county == null ? null : j_county.trim();
    }

    public String getJ_address() {
        return j_address;
    }

    public void setJ_address(String j_address) {
        this.j_address = j_address == null ? null : j_address.trim();
    }

    public String getJ_course_name() {
        return j_course_name;
    }

    public void setJ_course_name(String j_course_name) {
        this.j_course_name = j_course_name == null ? null : j_course_name.trim();
    }

    public String getJ_bag_no() {
        return j_bag_no;
    }

    public void setJ_bag_no(String j_bag_no) {
        this.j_bag_no = j_bag_no == null ? null : j_bag_no.trim();
    }

    public Long getD_course_id() {
        return d_course_id;
    }

    public void setD_course_id(Long d_course_id) {
        this.d_course_id = d_course_id;
    }

    public String getD_contact() {
        return d_contact;
    }

    public void setD_contact(String d_contact) {
        this.d_contact = d_contact == null ? null : d_contact.trim();
    }

    public String getD_mobile() {
        return d_mobile;
    }

    public void setD_mobile(String d_mobile) {
        this.d_mobile = d_mobile == null ? null : d_mobile.trim();
    }

    public String getD_province() {
        return d_province;
    }

    public void setD_province(String d_province) {
        this.d_province = d_province == null ? null : d_province.trim();
    }

    public String getD_city() {
        return d_city;
    }

    public void setD_city(String d_city) {
        this.d_city = d_city == null ? null : d_city.trim();
    }

    public String getD_county() {
        return d_county;
    }

    public void setD_county(String d_county) {
        this.d_county = d_county == null ? null : d_county.trim();
    }

    public String getD_address() {
        return d_address;
    }

    public void setD_address(String d_address) {
        this.d_address = d_address == null ? null : d_address.trim();
    }

    public String getD_course_name() {
        return d_course_name;
    }

    public void setD_course_name(String d_course_name) {
        this.d_course_name = d_course_name == null ? null : d_course_name.trim();
    }

    public String getD_bag_no() {
        return d_bag_no;
    }

    public void setD_bag_no(String d_bag_no) {
        this.d_bag_no = d_bag_no == null ? null : d_bag_no.trim();
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Boolean getIs_paid() {
        return is_paid;
    }

    public void setIs_paid(Boolean is_paid) {
        this.is_paid = is_paid;
    }

    public Date getPaid_at() {
        return paid_at;
    }

    public void setPaid_at(Date paid_at) {
        this.paid_at = paid_at;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Short getSource() {
        return source;
    }

    public void setSource(Short source) {
        this.source = source;
    }

    public Long getBank_id() {
        return bank_id;
    }

    public void setBank_id(Long bank_id) {
        this.bank_id = bank_id;
    }

    public Boolean getCoordinate_sign() {
        return coordinate_sign;
    }

    public void setCoordinate_sign(Boolean coordinate_sign) {
        this.coordinate_sign = coordinate_sign;
    }

    public String getSign_remark() {
        return sign_remark;
    }

    public void setSign_remark(String sign_remark) {
        this.sign_remark = sign_remark == null ? null : sign_remark.trim();
    }

    public Boolean getAllow_sign() {
        return allow_sign;
    }

    public void setAllow_sign(Boolean allow_sign) {
        this.allow_sign = allow_sign;
    }

    public Short getSign_location() {
        return sign_location;
    }

    public void setSign_location(Short sign_location) {
        this.sign_location = sign_location;
    }

    public String getSent_remark() {
        return sent_remark;
    }

    public void setSent_remark(String sent_remark) {
        this.sent_remark = sent_remark == null ? null : sent_remark.trim();
    }

    public Boolean getHas_send_bag() {
        return has_send_bag;
    }

    public void setHas_send_bag(Boolean has_send_bag) {
        this.has_send_bag = has_send_bag;
    }

    public Double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Double total_amount) {
        this.total_amount = total_amount;
    }

    public Long getCoupon_id() {
        return coupon_id;
    }

    public void setCoupon_id(Long coupon_id) {
        this.coupon_id = coupon_id;
    }

    public Double getVoucher() {
        return voucher;
    }

    public void setVoucher(Double voucher) {
        this.voucher = voucher;
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

    public Double getFreight() {
        return freight;
    }

    public void setFreight(Double freight) {
        this.freight = freight;
    }

    public String getCoupon_code() {
        return coupon_code;
    }

    public void setCoupon_code(String coupon_code) {
        this.coupon_code = coupon_code == null ? null : coupon_code.trim();
    }

    public String getVoucher_items() {
        return voucher_items;
    }

    public void setVoucher_items(String voucher_items) {
        this.voucher_items = voucher_items == null ? null : voucher_items.trim();
    }

    public String getContraband_goods_remark() {
        return contraband_goods_remark;
    }

    public void setContraband_goods_remark(String contraband_goods_remark) {
        this.contraband_goods_remark = contraband_goods_remark == null ? null : contraband_goods_remark.trim();
    }

    public Boolean getIs_booking() {
        return is_booking;
    }

    public void setIs_booking(Boolean is_booking) {
        this.is_booking = is_booking;
    }

    public Integer getBooking_status() {
        return booking_status;
    }

    public void setBooking_status(Integer booking_status) {
        this.booking_status = booking_status;
    }

    public Double getBooking_price() {
        return booking_price;
    }

    public void setBooking_price(Double booking_price) {
        this.booking_price = booking_price;
    }

    public String getJ_addr_type() {
        return j_addr_type;
    }

    public void setJ_addr_type(String j_addr_type) {
        this.j_addr_type = j_addr_type == null ? null : j_addr_type.trim();
    }

    public Long getJ_special_addr_id() {
        return j_special_addr_id;
    }

    public void setJ_special_addr_id(Long j_special_addr_id) {
        this.j_special_addr_id = j_special_addr_id;
    }

    public String getD_addr_type() {
        return d_addr_type;
    }

    public void setD_addr_type(String d_addr_type) {
        this.d_addr_type = d_addr_type == null ? null : d_addr_type.trim();
    }

    public Long getD_special_addr_id() {
        return d_special_addr_id;
    }

    public void setD_special_addr_id(Long d_special_addr_id) {
        this.d_special_addr_id = d_special_addr_id;
    }

    public String getFavorables() {
        return favorables;
    }

    public void setFavorables(String favorables) {
        this.favorables = favorables == null ? null : favorables.trim();
    }

    public String getSend_time_section() {
        return send_time_section;
    }

    public void setSend_time_section(String send_time_section) {
        this.send_time_section = send_time_section == null ? null : send_time_section.trim();
    }

    public String getExpress_type() {
        return express_type;
    }

    public void setExpress_type(String express_type) {
        this.express_type = express_type == null ? null : express_type.trim();
    }

    public Date getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Date deleted_at) {
        this.deleted_at = deleted_at;
    }

    public Double getExtra_amount() {
        return extra_amount;
    }

    public void setExtra_amount(Double extra_amount) {
        this.extra_amount = extra_amount;
    }

    public String getExtra_items() {
        return extra_items;
    }

    public void setExtra_items(String extra_items) {
        this.extra_items = extra_items == null ? null : extra_items.trim();
    }

    public Integer getGroup_coupon_id() {
        return group_coupon_id;
    }

    public void setGroup_coupon_id(Integer group_coupon_id) {
        this.group_coupon_id = group_coupon_id;
    }

    public Double getGroup_discount() {
        return group_discount;
    }

    public void setGroup_discount(Double group_discount) {
        this.group_discount = group_discount;
    }

    public String getGroup_coupon_code() {
        return group_coupon_code;
    }

    public void setGroup_coupon_code(String group_coupon_code) {
        this.group_coupon_code = group_coupon_code == null ? null : group_coupon_code.trim();
    }

    public Integer getBag_cover_type() {
        return bag_cover_type;
    }

    public void setBag_cover_type(Integer bag_cover_type) {
        this.bag_cover_type = bag_cover_type;
    }

    public Integer getOrder_type() {
        return order_type;
    }

    public void setOrder_type(Integer order_type) {
        this.order_type = order_type;
    }

    public Long getBag_id() {
        return bag_id;
    }

    public void setBag_id(Long bag_id) {
        this.bag_id = bag_id;
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

    public String getBag_name() {
        return bag_name;
    }

    public void setBag_name(String bag_name) {
        this.bag_name = bag_name == null ? null : bag_name.trim();
    }

    public Integer getBag_club_count() {
        return bag_club_count;
    }

    public void setBag_club_count(Integer bag_club_count) {
        this.bag_club_count = bag_club_count;
    }

    public Integer getBag_club_cover_count() {
        return bag_club_cover_count;
    }

    public void setBag_club_cover_count(Integer bag_club_cover_count) {
        this.bag_club_cover_count = bag_club_cover_count;
    }

    public Date getFetch_bag_time() {
        return fetch_bag_time;
    }

    public void setFetch_bag_time(Date fetch_bag_time) {
        this.fetch_bag_time = fetch_bag_time;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time == null ? null : arrival_time.trim();
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

    public String getStart_address_type() {
        return start_address_type;
    }

    public void setStart_address_type(String start_address_type) {
        this.start_address_type = start_address_type == null ? null : start_address_type.trim();
    }

    public Long getStart_address_id() {
        return start_address_id;
    }

    public void setStart_address_id(Long start_address_id) {
        this.start_address_id = start_address_id;
    }

    public String getStart_address_name() {
        return start_address_name;
    }

    public void setStart_address_name(String start_address_name) {
        this.start_address_name = start_address_name == null ? null : start_address_name.trim();
    }

    public Long getStart_contact_id() {
        return start_contact_id;
    }

    public void setStart_contact_id(Long start_contact_id) {
        this.start_contact_id = start_contact_id;
    }

    public String getEnd_address_type() {
        return end_address_type;
    }

    public void setEnd_address_type(String end_address_type) {
        this.end_address_type = end_address_type == null ? null : end_address_type.trim();
    }

    public Long getEnd_address_id() {
        return end_address_id;
    }

    public void setEnd_address_id(Long end_address_id) {
        this.end_address_id = end_address_id;
    }

    public String getEnd_address_name() {
        return end_address_name;
    }

    public void setEnd_address_name(String end_address_name) {
        this.end_address_name = end_address_name == null ? null : end_address_name.trim();
    }

    public Long getEnd_contact_id() {
        return end_contact_id;
    }

    public void setEnd_contact_id(Long end_contact_id) {
        this.end_contact_id = end_contact_id;
    }

    public Integer getCoupon_type() {
        return coupon_type;
    }

    public void setCoupon_type(Integer coupon_type) {
        this.coupon_type = coupon_type;
    }

    public Integer getCover_type() {
        return cover_type;
    }

    public void setCover_type(Integer cover_type) {
        this.cover_type = cover_type;
    }

    public Long getSpecial_coupon_id() {
        return special_coupon_id;
    }

    public void setSpecial_coupon_id(Long special_coupon_id) {
        this.special_coupon_id = special_coupon_id;
    }

    public String getSpecial_code() {
        return special_code;
    }

    public void setSpecial_code(String special_code) {
        this.special_code = special_code == null ? null : special_code.trim();
    }

    public String getJ_place_name() {
        return j_place_name;
    }

    public void setJ_place_name(String j_place_name) {
        this.j_place_name = j_place_name == null ? null : j_place_name.trim();
    }

    public String getD_place_name() {
        return d_place_name;
    }

    public void setD_place_name(String d_place_name) {
        this.d_place_name = d_place_name == null ? null : d_place_name.trim();
    }

    public Boolean getIs_paid_cancel() {
        return is_paid_cancel;
    }

    public void setIs_paid_cancel(Boolean is_paid_cancel) {
        this.is_paid_cancel = is_paid_cancel;
    }

    public Double getInsured_value() {
        return insured_value;
    }

    public void setInsured_value(Double insured_value) {
        this.insured_value = insured_value;
    }

    public Double getInsured_rates() {
        return insured_rates;
    }

    public void setInsured_rates(Double insured_rates) {
        this.insured_rates = insured_rates;
    }

    public Double getInsured_fee() {
        return insured_fee;
    }

    public void setInsured_fee(Double insured_fee) {
        this.insured_fee = insured_fee;
    }

    public Boolean getIs_helped() {
        return is_helped;
    }

    public void setIs_helped(Boolean is_helped) {
        this.is_helped = is_helped;
    }

    public Integer getCoupon_status() {
        return coupon_status;
    }

    public void setCoupon_status(Integer coupon_status) {
        this.coupon_status = coupon_status;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name == null ? null : user_name.trim();
    }
}