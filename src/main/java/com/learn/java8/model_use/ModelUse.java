package com.learn.java8.model_use;

import com.learn.java8.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Project: myJava8
 * File Created at 2022-02-11 22:49:22:49
 * {@link}
 * java8提供了
 * {@link java.util.function.Consumer} 有入参,无返回值
 * {@link java.util.function.Supplier} 无入参,有返回值
 * {@link java.util.function.Function} 有入参,有返回值
 * {@link java.util.function.Predicate} 有入参,返回boolean
 * 供使用,很多时候我们无需定义函数式接口(只有一个抽象方法的接口,可以通过@FunctionalInterface来校验),直接使用就行
 * 对于复杂参数,同样可以区java.util.function下找对应接口
 * 于是开始的项目还可以进一步优化
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type ModelUse.java
 * @Desc
 * @date 2022/2/11 22:49
 */
public class ModelUse {
    static List<Employee> employees = Arrays.asList(
        new Employee("张三", 16, 5555.88),
        new Employee("李四", 36, 2222),
        new Employee("王五", 56, 6666.22),
        new Employee("何六", 66, 8888.88),
        new Employee("田七", 26, 10000)
    );

    public static void main(String[] args) {
        System.out.println("---------------------------java8 定义函数使用---------------------------------");
        System.out.println(getList(employees, e -> e.getAge() >= 35));
        System.out.println(getList(employees, e -> e.getSalary() >= 5000));
    }

    public static List<Employee> getList(List<Employee> employees, Predicate<Employee> predicate) {
        List<Employee> list = new ArrayList<>();
        for (Employee employee : employees) {
            if (predicate.test(employee)) {
                list.add(employee);
            }
        }
        return list;
    }
}
