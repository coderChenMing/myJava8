package com.learn.java8.methodRef;

import java.util.function.BiPredicate;

/**
 * Project: myJava8
 * File Created at 2022-02-12 00:38:0:38
 * {@link}
 * 类名::实例方法名   方法引用示例
 * 注意:接口方法的第一个参数和调用实例方法的对象类型要一致,接口方法的第二个参数要和被调用的实例方法的参数保持一致
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Test3.java
 * @Desc
 * @date 2022/2/12 0:38
 */
public class Test3 {
    public static void main(String[] args) {
        BiPredicate<String, String> biPredicate = (x, y) -> x.equals(y);
        System.out.println(biPredicate.test("zhangsan", "zhangsan"));

        BiPredicate<String, String> biPredicate1 = String::equals;
        System.out.println(biPredicate1.test("zhangsan", "lisi"));
    }
}
