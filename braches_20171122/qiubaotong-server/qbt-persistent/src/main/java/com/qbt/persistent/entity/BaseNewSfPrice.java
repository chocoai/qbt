package com.qbt.persistent.entity;

import com.qbt.common.entity.BaseEntity;

public class BaseNewSfPrice extends BaseEntity {

    private String startArea;

    private String endArea;

    private double cichenFavourablePrice;

    private double cichenQbtPrice;

    private double ciriFavourablePrice;

    private double ciriQbtPrice;

    private double geriFavourablePrice;

    private double geriQbtPrice;

    public String getStartArea() {
        return startArea;
    }

    public void setStartArea(String startArea) {
        this.startArea = startArea == null ? null : startArea.trim();
    }

    public String getEndArea() {
        return endArea;
    }

    public void setEndArea(String endArea) {
        this.endArea = endArea == null ? null : endArea.trim();
    }

    public double getCichenFavourablePrice() {
        return cichenFavourablePrice;
    }

    public void setCichenFavourablePrice(double cichenFavourablePrice) {
        this.cichenFavourablePrice = cichenFavourablePrice;
    }

    public double getCichenQbtPrice() {
        return cichenQbtPrice;
    }

    public void setCichenQbtPrice(double cichenQbtPrice) {
        this.cichenQbtPrice = cichenQbtPrice;
    }

    public double getCiriFavourablePrice() {
        return ciriFavourablePrice;
    }

    public void setCiriFavourablePrice(double ciriFavourablePrice) {
        this.ciriFavourablePrice = ciriFavourablePrice;
    }

    public double getCiriQbtPrice() {
        return ciriQbtPrice;
    }

    public void setCiriQbtPrice(double ciriQbtPrice) {
        this.ciriQbtPrice = ciriQbtPrice;
    }

    public double getGeriFavourablePrice() {
        return geriFavourablePrice;
    }

    public void setGeriFavourablePrice(double geriFavourablePrice) {
        this.geriFavourablePrice = geriFavourablePrice;
    }

    public double getGeriQbtPrice() {
        return geriQbtPrice;
    }

    public void setGeriQbtPrice(double geriQbtPrice) {
        this.geriQbtPrice = geriQbtPrice;
    }
}