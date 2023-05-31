package com.learn.java8.jvm;

import java.util.Random;

public class Profiteer extends Merchant {
    @Override
    public double discountedPrice(double originalPrice, Customer somebody) {
        if (somebody.isVIP()) { // invokeinterface
            return originalPrice * priceDiscrimination(); // invokestatic
        } else {
            return super.discountedPrice(originalPrice, somebody); // invokespecial
        }
    }

    public static double priceDiscrimination() { // 咱们的杀熟算法太粗暴了，应该将客户城市作为随机数生成器的种子。
        return new Random() // invokespecial
                .nextDouble() // invokevirtual
                + 0.8d;
    }
}
