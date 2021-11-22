package com.example.ordersystem.common;

public class TypeConst {
    public static final String EAT = "EAT";
    public static final String DRINK = "DRINK";
    public static final String FUN = "FUN";

    public static int getCode(String type) {
        switch (type) {
            case EAT:
                return 0;
            case DRINK:
                return 1;
            case FUN:
                return 2;
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
            default:
                throw new RuntimeException("异常code");
        }
    }
}
