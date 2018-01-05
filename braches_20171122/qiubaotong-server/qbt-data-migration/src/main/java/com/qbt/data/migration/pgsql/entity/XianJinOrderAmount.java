package com.qbt.data.migration.pgsql.entity;

public class XianJinOrderAmount {
    private Integer id;

    private Double xian_jin_denomination;

    private Double min_order_amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getXian_jin_denomination() {
        return xian_jin_denomination;
    }

    public void setXian_jin_denomination(Double xian_jin_denomination) {
        this.xian_jin_denomination = xian_jin_denomination;
    }

    public Double getMin_order_amount() {
        return min_order_amount;
    }

    public void setMin_order_amount(Double min_order_amount) {
        this.min_order_amount = min_order_amount;
    }
}