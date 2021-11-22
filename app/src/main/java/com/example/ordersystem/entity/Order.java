package com.example.ordersystem.entity;

public class Order {
    private String name;
    private String address;
    private String remark;
    private String shippingTime;
    private String paymentMode;
    private Boolean tableware;
    private Boolean contactless;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getShippingTime() {
        return shippingTime;
    }

    public void setShippingTime(String shippingTime) {
        this.shippingTime = shippingTime;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Boolean getTableware() {
        return tableware;
    }

    public void setTableware(Boolean tableware) {
        this.tableware = tableware;
    }

    public Boolean getContactless() {
        return contactless;
    }

    public void setContactless(Boolean contactless) {
        this.contactless = contactless;
    }
}
