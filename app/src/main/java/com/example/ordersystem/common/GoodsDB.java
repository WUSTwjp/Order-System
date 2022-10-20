package com.example.ordersystem.common;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.ordersystem.R;
import com.example.ordersystem.entity.Good;
import com.example.ordersystem.entity.Order;
import com.example.ordersystem.entity.ShoppingGood;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GoodsDB {
    public static final List<Good> goodList = new ArrayList<>();
    private static Integer counter = 0;
    public static final List<ShoppingGood> shoppingList = new ArrayList<>();
    public static final Order order=new Order();

    static {
        goodList.add(new Good(counter++, "可乐", TypeConst.FUN, R.drawable.drink, "可口可乐，很好喝，",10));
        goodList.add(new Good(counter++, "加糖可乐", TypeConst.DIS, R.drawable.drink, "可口可乐，很好喝，",10));
        goodList.add(new Good(counter++, "加冰可乐", TypeConst.DIS, R.drawable.drink, "可口可乐，很好喝，",10));
        goodList.add(new Good(counter++, "加冰加糖可乐", TypeConst.DIS, R.drawable.drink, "可口可乐，很好喝，",10));
        goodList.add(new Good(counter++, "果粒橙", TypeConst.FUN, R.drawable.drink, "果粒橙，很好喝，",10));
        goodList.add(new Good(counter++, "农夫山泉", TypeConst.FUN, R.drawable.drink, "农夫山泉有点甜，,",10));
        goodList.add(new Good(counter++, "旺仔牛奶", TypeConst.DRINK, R.drawable.drink, "旺仔牛奶，yyds，",10));
        goodList.add(new Good(counter++, "香辣鸡腿堡", TypeConst.DRINK, R.drawable.drink, "薯片（原味）很好吃，",9));
        goodList.add(new Good(counter++, "牛肉堡", TypeConst.DRINK, R.drawable.eat, "薯片（番茄味），很好吃",9));
        goodList.add(new Good(counter++, "薯片（青柠味）", TypeConst.DRINK, R.drawable.eat, "薯片（青柠味）",9));
        goodList.add(new Good(counter++, "薯片（红烧味）", TypeConst.EAT, R.drawable.eat, "薯片（红烧味）",9));
        goodList.add(new Good(counter++, "薯片（黄瓜味）", TypeConst.EAT, R.drawable.eat, "薯片（黄瓜味）",9));
        goodList.add(new Good(counter++, "照烧鸡排饭", TypeConst.EAT, R.drawable.eat, "照烧鸡排饭，很好吃",9));
        goodList.add(new Good(counter++, "可乐鸡翅饭", TypeConst.EAT, R.drawable.eat, "可乐鸡翅饭，很好吃",9));

    }

}
