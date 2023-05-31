package com.learn.java8.stream;

import com.learn.java8.Employee;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Project: myJava8
 * File Created at 2022-02-12 17:27:17:27
 * {@link}
 * 收集器Collector使用
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Demo7.java
 * @Desc
 * @date 2022/2/12 17:27
 */
public class Demo7 extends AbstractDemo {
    public static void main(String[] args) {
        List<Integer> ageList = employees.stream().map(Employee::getAge).collect(Collectors.toList());
        System.out.println(ageList);
        List<String> nameList = employees.stream().map(Employee::getName).collect(Collectors.toList());
        System.out.println(nameList);
        // 去重
        Set<String> nameSet = employees.stream().map(Employee::getName).collect(Collectors.toSet());
        System.out.println(nameSet);
        // 装入hashset
        HashSet<String> nameHashSet = employees.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new));
        System.out.println(nameHashSet);
        Long count = employees.stream().collect(Collectors.counting());
        System.out.println("总人数: " + count);

        Double salarySum = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println("所有人工资之和: " + salarySum);

        // 工资平均值
        Double averageSalary = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("工资平均值: " + averageSalary);
        // 工资最高员工信息
        Optional<Employee> maxSalary = employees.stream().collect(Collectors.maxBy((s1, s2) -> Double.compare(s1.getSalary(), s2.getSalary())));
        System.out.println(maxSalary.get());
    }
}
