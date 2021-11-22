package com.example.ordersystem.dao;

import static com.example.ordersystem.common.GoodsDB.shoppingList;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.ordersystem.entity.ShoppingGood;

import java.util.List;

public interface ShoppingGoodDao {
    void addShoppingGood(ShoppingGood shoppingGood);

    void countAdd(Integer shoppingGoodId, Integer count);

    void updateCount(Integer shoppingGoodId, Integer count);

    void updateCount(String shoppingGoodName, Integer count);

    void countAdd(String shoppingGoodName, Integer count);

    List<ShoppingGood> getAllShoppingGoods();

    void remove(int id);

    void remove(ShoppingGood good);
}
