package com.example.ordersystem.entity;

public class ShoppingGood extends Good {

    public ShoppingGood(Integer goodId, String goodName, String type, Integer drawableId, String goodDetail,float goodPrice) {
        super(goodId, goodName, type, drawableId, goodDetail,goodPrice);
    }

    public ShoppingGood(Good good) {
        super(good.getGoodId(), good.getGoodName(), good.getType(), good.getDrawableId(), good.getGoodDetail(), good.getGoodPrice());
        this.count=1;
    }

    public ShoppingGood(String goodName, Integer drawableId, String goodDetail,float goodPrice) {
        super(goodName, drawableId, goodDetail,goodPrice);
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ShoppingGood{" +
                "count=" + count +
                '}';
    }

    private Integer count;
}
