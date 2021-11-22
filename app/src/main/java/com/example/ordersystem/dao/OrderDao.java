package com.example.ordersystem.dao;

import static com.example.ordersystem.common.GoodsDB.order;

import com.example.ordersystem.entity.Order;

public interface OrderDao {
    void setAddressAndPay(String address, String mode);

    Order getOrder();
}
