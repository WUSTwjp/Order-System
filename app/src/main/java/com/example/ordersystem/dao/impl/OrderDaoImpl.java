package com.example.ordersystem.dao.impl;

import com.example.ordersystem.dao.OrderDao;
import com.example.ordersystem.entity.Order;

import static com.example.ordersystem.common.GoodsDB.order;

public class OrderDaoImpl implements OrderDao {
    public  void setAddressAndPay(String address, String mode) {
        order.setAddress(address);
        order.setPaymentMode(mode);
    }

    public  Order getOrder() {
        return order;
    }
}