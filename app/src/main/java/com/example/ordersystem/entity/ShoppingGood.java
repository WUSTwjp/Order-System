package com.example.ordersystem.entity;

public class ShoppingGood extends Good {

    public ShoppingGood(Integer goodId, String goodName, String type, Integer drawableId, String goodDetail) {
        super(goodId, goodName, type, drawableId, goodDetail);
    }

    public ShoppingGood(Good good) {
        super(good.getGoodId(), good.getGoodName(), good.getType(), good.getDrawableId(), good.getGoodDetail());
        this.count=1;
    }

    public ShoppingGood(String goodName, Integer drawableId, String goodDetail) {
        super(goodName, drawableId, goodDetail);
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
