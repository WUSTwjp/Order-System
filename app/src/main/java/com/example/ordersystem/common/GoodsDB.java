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
        goodList.add(new Good(counter++, "可乐", TypeConst.FUN, R.drawable.coke, "配料：水、可口可乐",10));
        goodList.add(new Good(counter++, "加糖可乐", TypeConst.DIS, R.drawable.coke, "配料：水、可口可乐，",11));
        goodList.add(new Good(counter++, "加冰可乐", TypeConst.DIS, R.drawable.coke, "配料：水、可口可乐",11));
        goodList.add(new Good(counter++, "加冰加糖可乐", TypeConst.DIS, R.drawable.coke, "配料：水、可口可乐",12));
        goodList.add(new Good(counter++, "牛奶", TypeConst.FUN, R.drawable.milk, "配料：水、纯牛奶",10));
        goodList.add(new Good(counter++, "加糖牛奶", TypeConst.DIS, R.drawable.milk, "配料：水、纯牛奶",11));
        goodList.add(new Good(counter++, "加冰牛奶", TypeConst.DIS, R.drawable.milk, "配料：水、纯牛奶",11));
        goodList.add(new Good(counter++, "加冰加糖牛奶", TypeConst.DIS, R.drawable.milk, "配料：水、纯牛奶",12));
        goodList.add(new Good(counter++, "咖啡", TypeConst.FUN, R.drawable.coffee, "配料：水、速溶咖啡",10));
        goodList.add(new Good(counter++, "加糖咖啡", TypeConst.DIS, R.drawable.coffee, "配料：水、速溶咖啡,",11));
        goodList.add(new Good(counter++, "加冰咖啡", TypeConst.DIS, R.drawable.coffee, "配料：水、速溶咖啡",11));
        goodList.add(new Good(counter++, "加冰加糖咖啡", TypeConst.DIS, R.drawable.coffee, "配料：水、速溶咖啡",12));
        goodList.add(new Good(counter++, "炸鸡翅", TypeConst.DRINK, R.drawable.zhajichi, "好吃的炸鸡翅",8));
        goodList.add(new Good(counter++, "炸鸡腿", TypeConst.DRINK, R.drawable.zhajitui, "又大又好吃的炸鸡腿",9));
        goodList.add(new Good(counter++, "炸全鸡", TypeConst.DRINK, R.drawable.zhaji, "超级好吃的炸鸡",20));
        goodList.add(new Good(counter++, "炸鸡汉堡", TypeConst.DRINK, R.drawable.burger, "健康美味的炸鸡汉堡）",15));
        goodList.add(new Good(counter++, "烤鸡翅", TypeConst.EAT, R.drawable.kaojichi, "好吃的烤鸡翅",8));
        goodList.add(new Good(counter++, "烤鸡腿", TypeConst.EAT, R.drawable.kaojitui, "又大又好吃的烤鸡腿",9));
        goodList.add(new Good(counter++, "烤全鸡", TypeConst.EAT, R.drawable.kaoji, "超级好吃的烤鸡",20));
        goodList.add(new Good(counter++, "烤鸡汉堡", TypeConst.EAT, R.drawable.hambur, "健康美味的烤鸡汉堡",15));

    }

}
