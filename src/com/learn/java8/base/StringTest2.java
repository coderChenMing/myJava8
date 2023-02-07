package com.learn.java8.base;

public class StringTest2 {
    public static void main(String[] args) {
        //test1();
        //testStringBuffer();
        //testStringBuffer2();
        //testSubString();
        //testSubString2();
        //testEquals();
        //testChange();
        testIntern();
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

    public static void testStringBuffer2() {
        StringBuffer sf = new StringBuffer("hi,");
        changeSf(sf);
        System.out.println(sf);
        //String 为不可变类型，在方法内对 String 修改的时候，相当修改传递过来的是一个 String 副本，所以 String
        //本身的值是不会被修改的，而 StringBuffer 为可变类型，参数传递过来的是对象的引用，对其修改它本身就会发生改变。
    }
    public static void changeSf(StringBuffer sf){
        sf.append("laowang");
    }
    public static void testSubString() {
        String str = "laowang";
        str.substring(0, 1);
        System.out.println(str);// laowang
    }

    public static void testSubString2() {
        String str = "abcdef";
        System.out.println(str.substring(3, 3));// 起始索引和结束索引一致，截取内容为""
    }

    public static void testEquals() {
        String s1 = "hi," + "lao" + "wang";
        String s2 = "hi,";
        s2 += "lao";
        s2 += "wang";
        String s3 = "hi,laowang";
        System.out.println(s1 == s2);//false
        System.out.println(s1 == s3);//true
        System.out.println(s2 == s3);//false
        //String s1 = "hi," + "lao" + "wang" 代码会被 JVM 优化为：
        // String s1 ="hi,laowang"，这样就和 s3 完全相同，s1 创建的时候会把字符"hi,laowang"放入常量池，s3
        //创建的时候，常量池中已经存在对应的缓存，会直接把引用返回给 s3，所以 `s1==s3` 就为 true，而 s2 使用了 `+=`
        //其引用地址就和其他两个不同。
    }

    public static void testChange() {
        String str = new String("laowang");
        change(str);
        System.out.println(str);// laowang
    }

    public static void change(String str) {
        str = "xiaowang";
        //String 为不可变类型，在方法内对 String 修改的时候，相当修改传递过来的是一个 String 副本，所以 String
        //本身的值是不会被修改的，而 StringBuffer 为可变类型，参数传递过来的是对象的引用，对其修改它本身就会发生改变。
    }

    public static void testIntern() {
        String s = "laowang";
        String s2 = s.intern();
        System.out.println(s == s2); // 返回 true
    }

}
