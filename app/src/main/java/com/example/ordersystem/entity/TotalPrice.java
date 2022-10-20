package com.example.ordersystem.entity;
public class TotalPrice {
    float totalPrice;
    private static TotalPrice instance = null;
    private TotalPrice(){
        totalPrice = 0;
    }
    public static TotalPrice getInstance(){
        if(instance == null){
            instance =new TotalPrice();
        }
        return instance;
    }
}

