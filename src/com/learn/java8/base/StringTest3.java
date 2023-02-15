package com.learn.java8.base;

public class StringTest3 {
    public static void main(String[] args) {
        String str1 = null;
        String str2 = null;
        String str3 = str1 == null ? str2 == null ? "未知" : str2 : str1;
        System.out.println(str3);
    }
}
