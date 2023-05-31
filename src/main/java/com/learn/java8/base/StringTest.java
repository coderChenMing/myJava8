package com.learn.java8.base;

/**
 * Project: myJava8
 * File Created at 2022-08-18 15:19:15:19
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type StringTest.java
 * @Description
 * @date 2022/8/18 15:19
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        System.out.printf("%s==%s is %s\n", s1, s2, s1 == s2);

        // string 非基本类型,==比较的是地址值
        // string 作为使用最多的变量类型,java 在很多地方对string做了优化
        // 1.增加字符串常量池结构,创建字符串优先从常量池获取,没有则创建新字符串,并添加到常量池
        String s3 = new String("abc");
        String s4 = new String("abc");
        System.out.printf("%s==%s is %s\n", s1, s3, s1 == s3); // false
        System.out.printf("%s==%s is %s\n", s3, s4, s3 == s4); // false
        System.out.printf("%s equals %s is %s\n", s3, s4, s3.equals(s4)); // true

        // 2.编译优化,对于编译前就知道string 内容的,直接放入常量池
        String str1 = "ab" + "cd";
        String str2 = "abcd";
        System.out.printf("%s==%s is %s\n", str1, str2, str1 == str2); // true
        // String str1  = "ab" + "cd"，编译器优化介绍了确定值可以进行优化，编译器会优化成  String str1 = “abcd”，指向了常量池

        System.out.println("--------------------------");
        String str31 = "ab";
        String str32 = "cd";
        String str33 = str31 + str32;
        String str34 = "abcd";
        System.out.printf("%s==%s is %s\n", str33, str34, str33 == str34);// false
        // String str33 = str31 + str32 中的 str31 和 str32 需要在运行时才能确定值
        // 编译器为了减少对象生成，也会进行优化，将其优化成 String str33 = new StringBuilder().append( str31)).append(str32).toString()，
        // StringBuilder  的 toString 我们可以发现其实就是 new String() 对象

        String str41 = "b";
        String str42 = "a" + str41;
        String str43 = "ab";
        System.out.printf("%s==%s is %s\n", str42, str43, str42 == str43);

        str42 = str42.intern();
        System.out.printf("%s==%s is %s\n", str42, str43, str42 == str43);
        // intern 方法会从字符串常量池中查询当前字符串是否存在，如果存在，就直接返回当前字符串；
        // 如果不存在就会将当前字符串放入常量池中，之后再返回


        final String str51 = "b";
        String str52 = "a" + str51;
        String str53 = "ab";
        System.out.printf("%s==%s is %s\n", str52, str53, str52 == str53);
        // 变量 str51 用了final 修饰，在编译器就可以确定值，因此也可以合并优化成 String str42 = "ab"，故 str52 = str53 结果为 true。


        // String s3 = new String("abc") 你知道生成了几个对象吗？
        // 常量池有 abc 字段是1个，常量池没有 "abc" 字段则是2个，是不是很简单。
    }
}
