package com.learn.java8.optional;

import com.learn.java8.Employee;

import java.util.Optional;

/**
 * Project: myJava8
 * File Created at 2022-02-12 21:19:21:19
 * {@link}
 * 容器类
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type OptionalDemo.java
 * @Desc
 * @date 2022/2/12 21:19
 */
public class OptionalDemo {
    public static void main(String[] args) {
        // test1();
        // test2();
        // test3();
        // test4();
         test5();
    }

    public static void test1() {
        Optional<Employee> employee = Optional.of(new Employee());
        System.out.println(employee.get());
        // 构造一个空的optional
        Optional<Employee> empty = Optional.empty();
        System.out.println(empty.get());
    }

    public static void test2() {
        Optional<Employee> op = Optional.of(null);
        System.out.println(op.get()); //java.lang.NullPointerException
    }

    public static void test3() {
        Optional<Employee> op1 = Optional.ofNullable(new Employee());
        System.out.println(op1.get());
        // 创建一个空optional实例
        Optional<Employee> op2 = Optional.ofNullable(null);
        System.out.println(op2.get());
    }

    public static void test4() {
        Optional<Employee> zhangsan = Optional.ofNullable(new Employee("张三", 12, 9999));
        System.out.println(zhangsan.map(e->e.getSalary()).get());
        System.out.println(zhangsan.flatMap(o -> Optional.of(new Employee())).get());
    }

    public static Employee test5() {
        // Optional<Employee> op = Optional.of(null); 依旧空指针
        // Optional<Employee> op = Optional.ofNullable(new Employee("李四",36,8888));//Employee{name='李四', age=36, salary=8888.0}
        Optional<Employee> op = Optional.ofNullable(null);// Employee{name='null', age=0, salary=0.0}
        System.out.println(op.orElse(new Employee()));
        return op.orElse(new Employee());

    }
}
