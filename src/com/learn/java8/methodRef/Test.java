package com.learn.java8.methodRef;

import com.learn.java8.Employee;

import java.io.PrintStream;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Project: myJava8
 * File Created at 2022-02-11 23:12:23:12
 * {@link}
 * 对象::实例方法名  方法引用示例
 * 注意：需要调用的构造器的参数列表与函数式接口的参数列表保持一致
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Test.java
 * @Desc
 * @date 2022/2/11 23:12
 */
public class Test {
    public static void main(String[] args) {
        // 方法引用示例
        Consumer<String> consumer = x -> System.out.println(x);
        consumer.accept("100");

        PrintStream ps1 = System.out;
        Consumer<String> consumer3 = x -> ps1.println(x);
        consumer3.accept("100");

        PrintStream ps = System.out;
        Consumer<String> consumer1=ps::println;
        consumer1.accept("200");

        System.out.println("-----------------------升级-----------------------------");

        Consumer<String> consumer2=System.out::println;
        consumer2.accept("300");

        System.out.println("-----------------------------示例2--------------------------------------");
        Employee emp = new Employee("张三", 22, 6666.11);
        Supplier<String> supplier=emp::getName;
        System.out.println(supplier.get());

        Supplier<Integer> supplier2=emp::getAge;
        System.out.println(supplier2.get());

        Supplier<Double> supplier3 = emp::getSalary;
        System.out.println(supplier3.get());

    }
}
