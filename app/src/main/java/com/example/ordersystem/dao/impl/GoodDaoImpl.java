package com.example.ordersystem.dao.impl;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.ordersystem.dao.GoodDao;
import com.example.ordersystem.entity.Good;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.ordersystem.common.GoodsDB.goodList;

public class GoodDaoImpl implements GoodDao {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<String> getAllName() {
        return goodList.parallelStream().map(Good::getGoodName).collect(Collectors.toList());
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Good> getByType(String type) {
        return goodList.parallelStream().filter(g -> g.getType().equals(type)).collect(Collectors.toList());
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Good getByName(String name) {
        return goodList.parallelStream().filter(g -> g.getGoodName().equals(name)).findFirst().orElseThrow(RuntimeException::new);
    }
}
