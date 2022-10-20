package com.example.ordersystem.common;

public class TypeConst {
    public static final String EAT = "开始点餐";
    public static final String DRINK = "饮品";
    public static final String FUN = "甜品";
    public static final String DIS = "不显示";

    public static int getCode(String type) {
        switch (type) {
            case EAT:
                return 0;
            case DRINK:
                return 1;
            case FUN:
                return 2;
            case DIS:
                return 3;
            default:
                throw new RuntimeException("异常type");
        }
    }

    public static String getType(int code) {
        switch (code) {
            case 0:
                return EAT;
            case 1:
                return DRINK;
            case 2:
                return FUN;
            case 3:
                return DIS;
            default:
                throw new RuntimeException("异常code");
        }
    }
}
