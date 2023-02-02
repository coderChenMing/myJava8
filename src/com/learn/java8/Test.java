package com.learn.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Project: myJava8
 * File Created at 2022-02-11 22:26:22:26
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Test.java
 * @Desc
 * @date 2022/2/11 22:26
 */
public class Test {
    static List<Employee> employees = Arrays.asList(
        new Employee("张三", 16, 5555.88),
        new Employee("李四", 36, 2222),
        new Employee("王五", 56, 6666.22),
        new Employee("何六", 66, 8888.88),
        new Employee("田七", 26, 10000)
    );

    public static void main(String[] args) {
        /*List<Employee> ageList = getAgeList(employees);
        System.out.println(ageList);
        List<Employee> salaryList = getSalaryList(employees);
        System.out.println(salaryList);*/
        /*String[] split = ",0,".split(",");// 两个元素
        System.out.println(split.length);
        System.out.println(split[0]);
        System.out.println(split[1]);
        System.out.println(split[2]);*/

        HashSet<Long> set = new HashSet<>();
        set.add(null);
        System.out.println(set);
    }

    public static List<Employee> getAgeList(List<Employee> employees){
        List<Employee> list = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getAge() >= 30) {
                list.add(employee);
            }
        }
        return list;
    }
    public static List<Employee> getSalaryList(List<Employee> employees){
        List<Employee> list = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getSalary() >= 5000) {
                list.add(employee);
            }
        }
        return list;
    }
}
