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
    private static final List<Good> goodList = new ArrayList<>();
    private static Integer counter = 0;
    private static final List<ShoppingGood> shoppingList = new ArrayList<>();
    private static final Order order=new Order();

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
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static List<String> getAllName() {
        return goodList.parallelStream().map(Good::getGoodName).collect(Collectors.toList());
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static List<Good> getByType(String type) {
        return goodList.parallelStream().filter(g -> g.getType().equals(type)).collect(Collectors.toList());
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static Good getByName(String name) {
        return goodList.parallelStream().filter(g -> g.getGoodName().equals(name)).findFirst().orElseThrow(RuntimeException::new);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void addShoppingGood(ShoppingGood shoppingGood) {
        boolean isPresent = shoppingList.parallelStream().anyMatch(s -> s.getGoodId().equals(shoppingGood.getGoodId()));
        if (!isPresent) {
            shoppingList.add(shoppingGood);
        } else {
            countAdd(shoppingGood.getGoodId(), 1);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void countAdd(Integer shoppingGoodId, Integer count) {
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
    public static void updateCount(Integer shoppingGoodId, Integer count) {
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
    public static void updateCount(String shoppingGoodName, Integer count) {
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
    public static void countAdd(String shoppingGoodName, Integer count) {
        shoppingList.parallelStream()
                .filter(s -> s.getGoodName().equals(shoppingGoodName))
                .findFirst()
                .ifPresent(s -> s.setCount(s.getCount() + count));
    }

    public static List<ShoppingGood> getAllShoppingGoods() {
        return shoppingList;
    }

    public static void remove(int id) {
        shoppingList.remove(id);
    }

    public static void remove(ShoppingGood good) {
        shoppingList.remove(good);
    }

    public static void setAddressAndPay(String address, String mode) {
        order.setAddress(address);
        order.setPaymentMode(mode);
    }
    public static Order getOrder(){
        return order;
    }
}
