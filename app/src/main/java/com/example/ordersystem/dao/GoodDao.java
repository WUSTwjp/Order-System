package com.example.ordersystem.dao;

import com.example.ordersystem.entity.Good;

import java.util.List;

public interface GoodDao {

    List<String> getAllName();

    List<Good> getByType(String type);

    Good getByName(String name);

}
