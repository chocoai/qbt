package com.qbt.data.migration.pgsql.entity;

public class Route {
    private Integer id;

    private Long order_id;

    private Long route_id;

    private String mail_no;

    private String order_id2;

    private String accept_time;

    private String accept_address;

    private String remark;

    private String op_code;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Long getRoute_id() {
        return route_id;
    }

    public void setRoute_id(Long route_id) {
        this.route_id = route_id;
    }

    public String getMail_no() {
        return mail_no;
    }

    public void setMail_no(String mail_no) {
        this.mail_no = mail_no == null ? null : mail_no.trim();
    }

    public String getOrder_id2() {
        return order_id2;
    }

    public void setOrder_id2(String order_id2) {
        this.order_id2 = order_id2 == null ? null : order_id2.trim();
    }

    public String getAccept_time() {
        return accept_time;
    }

    public void setAccept_time(String accept_time) {
        this.accept_time = accept_time == null ? null : accept_time.trim();
    }

    public String getAccept_address() {
        return accept_address;
    }

    public void setAccept_address(String accept_address) {
        this.accept_address = accept_address == null ? null : accept_address.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getOp_code() {
        return op_code;
    }

    public void setOp_code(String op_code) {
        this.op_code = op_code == null ? null : op_code.trim();
    }
}