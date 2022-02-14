package com.learn.java8;

import com.learn.java8.impl.AgeCondition;
import com.learn.java8.impl.SalaryCondition;
import com.learn.java8.inter.Condition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project: myJava8
 * File Created at 2022-02-11 22:38:22:38
 * {@link}
 * 只定义接口,通过lambda表达式实现最简洁的功能
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type ConditionTest.java
 * @Desc
 * @date 2022/2/11 22:38
 */
public class ConditionTest {
    static List<Employee> employees = Arrays.asList(
        new Employee("张三", 16, 5555.88),
        new Employee("李四", 36, 2222),
        new Employee("王五", 56, 6666.22),
        new Employee("何六", 66, 8888.88),
        new Employee("田七", 26, 10000)
    );

    public static void main(String[] args) {
        // ConditionTest 相比Test 只需要写一个方法就能完成
        System.out.println(getList(employees,new AgeCondition()));
        System.out.println(getList(employees,new SalaryCondition()));
        System.out.println("----------------------------升级版----------------------------");
        // 使用lambda表达式可以简化匿名内部类的实现
        // 当执行condition.condition(employee时,就是执行lambda表达式的实现方法
        System.out.println(getList(employees, e -> e.getAge() >= 35));
        System.out.println(getList(employees, e -> e.getSalary()>5000));

    }

    public static List<Employee> getList(List<Employee> employees, Condition<Employee> condition) {
        List<Employee> ageList = new ArrayList<>();
        for (Employee employee : employees) {
            if (condition.condition(employee)) {
                ageList.add(employee);
            }
        }
        return ageList;
    }
}
