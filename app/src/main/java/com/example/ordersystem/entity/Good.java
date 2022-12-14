package com.example.ordersystem.entity;

import android.content.Intent;

public class Good {
    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Integer getDrawableId() {
        return drawableId;
    }

    public void setDrawableId(Integer drawableId) {
        this.drawableId = drawableId;
    }

    public String getGoodDetail() {
        return goodDetail;
    }

    public void setGoodDetail(String goodDetail) {
        this.goodDetail = goodDetail;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public float getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(float goodPrice) {
        this.goodPrice = goodPrice;
    }
    public Good(Integer goodId, String goodName,String type, Integer drawableId, String goodDetail,float goodPrice) {
        this.goodId = goodId+80000;
        this.goodName = goodName;
        this.drawableId = drawableId;
        this.goodDetail = goodDetail;
        this.goodPrice=goodPrice;
        this.type = type;
    }

    public Good(String goodName, Integer drawableId, String goodDetail,float goodPrice) {
        this.goodName = goodName;
        this.drawableId = drawableId;
        this.goodDetail = goodDetail;
        this.goodPrice = goodPrice;
    }

    @Override
    public String toString() {
        return "Good{" +
                "goodPrice=" + goodPrice +
                "goodId=" + goodId +
                ", goodName='" + goodName + '\'' +
                ", drawableId=" + drawableId +
                ", goodDetail='" + goodDetail + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    private Integer goodId;
    private String goodName;
    private Integer drawableId;
    private String goodDetail;
    private String type;
    private float goodPrice;
}
