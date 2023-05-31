package com.learn.java8.stream;

import com.learn.java8.Employee;

import java.util.stream.Stream;

/**
 * Project: myJava8
 * File Created at 2022-02-12 11:37:11:37
 * {@link}
 * Stream的中间操作
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Demo2.java
 * @Desc
 * @date 2022/2/12 11:37
 */
public class Demo2 extends AbstractDemo {


    public static void main(String[] args) {
        // streamTest1();
        // streamTest2();
        // streamTest3();
        streamTest4();

    }

    public static void streamTest1() {
        Stream<Employee> employeeStream = employees.stream().filter(e -> e.getAge() > 35);
        employeeStream.forEach(System.out::println);

        // 演示中间操作不作任何处理
        Stream<Employee> s = employees.stream().filter((e) -> {
            System.out.println("执行中间操作");
            return e.getSalary() > 5000;
        });
        // 执行终止操作,才会打印
        s.forEach(System.out::println);
        // 连续执行两次终止操作会报 stream has already been operated upon or closed
        // 终止操作只能执行一次,stream流就会关闭

        // limit(long size):截断流,使元素数量不超过size
        s.limit(2).forEach(System.out::println);
    }

    public static void streamTest2() {
        // skip(long n):调过n个元素,返回扔掉了n个元素的流,若元素不足n个,则返回一个空流
        Stream<Employee> stream = employees.stream().filter((e) -> e.getSalary() > 3000);
        stream.skip(1).forEach(System.out::println);
    }

    public static void streamTest3() {
        // skip(long n):调过n个元素,返回扔掉了n个元素的流,若元素不足n个,则返回一个空流
        Stream<Employee> stream = employees.stream().filter((e) -> e.getSalary() > 3000);
        stream.skip(10).forEach(System.out::println);
    }

    public static void streamTest4() {
        // 筛选,通过流所生成元素的hashCode()和equals()去除重复元素
        Stream<Employee> stream = employees.stream();
        stream.distinct().forEach(System.out::println);
    }

}
