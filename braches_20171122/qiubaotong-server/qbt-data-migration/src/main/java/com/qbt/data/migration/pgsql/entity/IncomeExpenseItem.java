package com.qbt.data.migration.pgsql.entity;

import java.util.Date;

public class IncomeExpenseItem {
    private Integer id;

    private String number;

    private Date occurred_at;

    private Boolean is_income;

    private Double amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Date getOccurred_at() {
        return occurred_at;
    }

    public void setOccurred_at(Date occurred_at) {
        this.occurred_at = occurred_at;
    }

    public Boolean getIs_income() {
        return is_income;
    }

    public void setIs_income(Boolean is_income) {
        this.is_income = is_income;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}