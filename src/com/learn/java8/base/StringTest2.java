package com.learn.java8.base;

public class StringTest2 {
    public static void main(String[] args) {
        //test1();
        testStringBuffer();
    }

    public static void test1() {
        String s1 = "laowang";
        String s2 = s1;
        String s3 = new String(s1);
        System.out.println(s1 == s2); //true
        System.out.println(s1 == s3); //false
    }

    public static void testStringBuffer() {
        /*StringBuffer 在字符串拼接时使用 synchronized 来保障线程安全，因此在多线程字符串拼接中推荐使用
        StringBuffer。*/
        StringBuffer sf = new StringBuffer("lao");
        // 添加字符串到尾部
        sf.append("wang"); // 执行结果：laowang
        System.out.println(sf.toString());
        // 插入字符串到到当前字符串下标的位置
        sf.insert(0, "hi,"); // 执行结果：hi,laowang
        System.out.println(sf.toString());
        // 修改字符中某个下标的值
        sf.setCharAt(0, 'H'); // 执行结果：Hi,laowang
        System.out.println(sf.toString());
    }
}
