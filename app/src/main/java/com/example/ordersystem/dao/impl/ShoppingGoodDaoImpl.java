package com.example.ordersystem.dao.impl;

import com.example.ordersystem.dao.ShoppingGoodDao;
import com.example.ordersystem.entity.ShoppingGood;

import static com.example.ordersystem.common.GoodsDB.shoppingList;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.List;

public class ShoppingGoodDaoImpl implements ShoppingGoodDao {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void addShoppingGood(ShoppingGood shoppingGood) {
        boolean isPresent = shoppingList.parallelStream().anyMatch(s -> s.getGoodId().equals(shoppingGood.getGoodId()));
        if (!isPresent) {
            shoppingList.add(shoppingGood);
        } else {
            countAdd(shoppingGood.getGoodId(), 1);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void countAdd(Integer shoppingGoodId, Integer count) {
        shoppingList.parallelStream()
                .filter(s -> s.getGoodId().equals(shoppingGoodId))
                .findFirst()
                .ifPresent(s -> {
                    s.setCount(s.getCount() + count);
                    if (s.getCount() < 1) {
                        remove(s);
                    }
                });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void updateCount(Integer shoppingGoodId, Integer count) {
        shoppingList.parallelStream()
                .filter(s -> s.getGoodId().equals(shoppingGoodId))
                .findFirst()
                .ifPresent(s -> {
                    s.setCount(count);
                    if (s.getCount() < 1) {
                        remove(s);
                    }
                });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void updateCount(String shoppingGoodName, Integer count) {
        shoppingList.parallelStream()
                .filter(s -> s.getGoodName().equals(shoppingGoodName))
                .findFirst()
                .ifPresent(s -> {
                    s.setCount(count);
                    if (s.getCount() < 1) {
                        remove(s);
                    }
                });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void countAdd(String shoppingGoodName, Integer count) {
        shoppingList.parallelStream()
                .filter(s -> s.getGoodName().equals(shoppingGoodName))
                .findFirst()
                .ifPresent(s -> s.setCount(s.getCount() + count));
    }

    public List<ShoppingGood> getAllShoppingGoods() {
        return shoppingList;
    }

    public void remove(int id) {
        shoppingList.remove(id);
    }

    public void remove(ShoppingGood good) {
        shoppingList.remove(good);
    }

}
