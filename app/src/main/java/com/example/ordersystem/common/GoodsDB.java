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
        goodList.add(new Good(counter++, "可乐", TypeConst.DRINK, R.drawable.drink, "可口可乐，很好喝，后面我就乱打了，因为要显得，商品详情多一些，所以我要一直打字，我想不出来，每一个要怎么写，我就都写一样的了"));
        goodList.add(new Good(counter++, "果粒橙", TypeConst.DRINK, R.drawable.drink, "果粒橙，很好喝，后面我就乱打了，因为要显得，商品详情多一些，所以我要一直打字，我想不出来，每一个要怎么写，我就都写一样的了"));
        goodList.add(new Good(counter++, "农夫山泉", TypeConst.DRINK, R.drawable.drink, "农夫山泉有点甜，后面我就乱打了，因为要显得，商品详情多一些，所以我要一直打字，我想不出来，每一个要怎么写，我就都写一样的了"));
        goodList.add(new Good(counter++, "旺仔牛奶", TypeConst.DRINK, R.drawable.drink, "旺仔牛奶，yyds，后面我就乱打了，因为要显得，商品详情多一些，所以我要一直打字，我想不出来，每一个要怎么写，我就都写一样的了"));
        goodList.add(new Good(counter++, "薯片（原味）", TypeConst.EAT, R.drawable.eat, "薯片（原味）很好吃，后面我就乱打了，因为要显得，商品详情多一些，所以我要一直打字，我想不出来，每一个要怎么写，我就都写一样的了"));
        goodList.add(new Good(counter++, "薯片（番茄味）", TypeConst.EAT, R.drawable.eat, "薯片（番茄味），很好吃，后面我就乱打了，因为要显得，商品详情多一些，所以我要一直打字，我想不出来，每一个要怎么写，我就都写一样的了"));
        goodList.add(new Good(counter++, "薯片（青柠味）", TypeConst.EAT, R.drawable.eat, "薯片（青柠味），很好吃，后面我就乱打了，因为要显得，商品详情多一些，所以我要一直打字，我想不出来，每一个要怎么写，我就都写一样的了"));
        goodList.add(new Good(counter++, "薯片（红烧味）", TypeConst.EAT, R.drawable.eat, "薯片（红烧味），很好吃，后面我就乱打了，因为要显得，商品详情多一些，所以我要一直打字，我想不出来，每一个要怎么写，我就都写一样的了"));
        goodList.add(new Good(counter++, "薯片（黄瓜味）", TypeConst.EAT, R.drawable.eat, "薯片（黄瓜味），很好吃，后面我就乱打了，因为要显得，商品详情多一些，所以我要一直打字，我想不出来，每一个要怎么写，我就都写一样的了"));
        goodList.add(new Good(counter++, "照烧鸡排饭", TypeConst.EAT, R.drawable.eat, "照烧鸡排饭，很好吃，后面我就乱打了，因为要显得，商品详情多一些，所以我要一直打字，我想不出来，每一个要怎么写，我就都写一样的了"));
        goodList.add(new Good(counter++, "可乐鸡翅饭", TypeConst.EAT, R.drawable.eat, "可乐鸡翅饭，很好吃，后面我就乱打了，因为要显得，商品详情多一些，所以我要一直打字，我想不出来，每一个要怎么写，我就都写一样的了"));
        goodList.add(new Good(counter++, "黄焖鸡米饭", TypeConst.EAT, R.drawable.eat, "黄焖鸡米饭，很好吃，后面我就乱打了，因为要显得，商品详情多一些，所以我要一直打字，我想不出来，每一个要怎么写，我就都写一样的了"));
        goodList.add(new Good(counter++, "外婆鸡汤饭", TypeConst.EAT, R.drawable.eat, "外婆鸡汤饭，很好吃，后面我就乱打了，因为要显得，商品详情多一些，所以我要一直打字，我想不出来，每一个要怎么写，我就都写一样的了"));
        goodList.add(new Good(counter++, "冰淇淋蛋糕", TypeConst.FUN, R.drawable.fun, "冰淇淋蛋糕，很好吃，后面我就乱打了，因为要显得，商品详情多一些，所以我要一直打字，我想不出来，每一个要怎么写，我就都写一样的了"));
        goodList.add(new Good(counter++, "提拉米苏", TypeConst.FUN, R.drawable.fun, "提拉米苏，很好吃，后面我就乱打了，因为要显得，商品详情多一些，所以我要一直打字，我想不出来，每一个要怎么写，我就都写一样的了"));
    }

}
