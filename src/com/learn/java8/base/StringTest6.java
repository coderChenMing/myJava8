package com.learn.java8.base;

public class StringTest6 {
    public static void main(String[] args) {
        String str = "CNCERTCC#202301311351021000";
        String str2 = "CNCERTCC#202301311351021000中国电力建设集团有限公司网内木马僵尸事件通报";
        System.out.println(str.length());
        System.out.println(str2.substring(27));
    }
}
