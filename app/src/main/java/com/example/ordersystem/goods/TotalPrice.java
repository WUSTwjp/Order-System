package com.example.ordersystem.goods;
public class TotalPrice {
    private float totalPrice;
    private static TotalPrice instance = null;
    private TotalPrice(){}
    public static TotalPrice getInstance(){
        if(instance == null){
            instance =new TotalPrice();
            instance.setTotalPrice(0);
        }
        return instance;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}

