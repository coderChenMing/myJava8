package com.learn.java8.methodRef;

import java.util.Comparator;

/**
 * Project: myJava8
 * File Created at 2022-02-12 00:29:0:29
 * {@link}
 * 类名::静态方法名 形式方法引用示例
 * 注意:接口的方法签名(参数列表,返回值,方法名)中的参数列表和返回值 要与静态方法的参数列表和返回值保持一致才可以
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Test2.java
 * @Desc
 * @date 2022/2/12 0:29
 */
public class Test2 {
    public static void main(String[] args) {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        System.out.println(comparator.compare(50,100));

        Comparator<Integer> comparator1 = Integer::compare;
        System.out.println(comparator1.compare(200,100));
    }
}
