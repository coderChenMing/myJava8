package com.learn.java8.constructorRef;

import com.learn.java8.Employee;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Project: myJava8
 * File Created at 2022-02-12 00:44:0:44
 * {@link}
 * 构造器引用实例
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Test.java
 * @Desc
 * @date 2022/2/12 0:44
 */
public class Test {
    public static void main(String[] args) {
        Supplier<Employee> supplier = () -> new Employee();
        System.out.println(supplier.get());

        Supplier<Employee> supplier1 = Employee::new;
        System.out.println(supplier1.get());

        System.out.println("----------------------------------------------------------");

        Function<Integer,Employee> function = (x) -> new Employee(x);
        System.out.println(function.apply(100));
        Function<Integer, Employee> function1 = Employee::new;
        System.out.println(function.apply(200));

        BiFunction<String,Integer,Employee> biFunction=Employee::new;
        System.out.println(biFunction.apply("张三",59));
    }
}
