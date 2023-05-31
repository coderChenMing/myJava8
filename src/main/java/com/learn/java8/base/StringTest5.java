package com.learn.java8.base;

public class StringTest5 {
    public static void main(String[] args) {

        String secondBegin = "备案管理办法》 ， ";
        String secondEnd = "单位的网络产品安全漏洞收集平台";
        String firstLine = "根据《网络产品安全漏洞管理规定》 《网络产品安全漏洞收集平台";
        System.out.println(firstLine.length());
        System.out.println(secondBegin.length());
        System.out.println(secondEnd.length());
        int textLength = 60;
        int split = 30;
        int line = 0;
        while ((textLength-=split) >= 0) {
            line++;
            if (textLength > 0 && textLength < split) {
                line++;
            }
        }
        System.out.println(line);
    }
}
