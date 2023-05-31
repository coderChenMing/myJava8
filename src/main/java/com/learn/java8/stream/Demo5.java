package com.learn.java8.stream;

import com.learn.java8.bean.Student;

import java.util.Optional;

/**
 * Project: myJava8
 * File Created at 2022-02-12 16:24:16:24
 * {@link}
 * 终止操作:查找与匹配
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Demo5.java
 * @Desc
 * @date 2022/2/12 16:24
 */
public class Demo5 extends AbstractDemo {
    public static void main(String[] args) {
        // allMatch:检查是否匹配所有元素
        boolean b = students.stream().allMatch(e -> e.getStatus().equals(Student.Status.BUSY));
        System.out.println("是否所有学生都很忙:" + b);
        // anyMatch:检查是否至少匹配一个元素
        boolean busy = students.stream().anyMatch(e -> e.getStatus().equals(Student.Status.BUSY));
        System.out.println("是否至少有一个学生很忙:" + busy);
        // noneMatch:检查是否没有元素匹配
        boolean busy2 = students.stream().noneMatch(e -> e.getStatus().equals(Student.Status.BUSY));
        System.out.println("是否没有一个学生忙:" + busy2);
        // findFirst:返回第一个元素
        // 按照分数排序,获取分数最高的
        Optional<Student> first = students.stream().sorted((s1, s2) -> -Double.compare(s1.getScore(), s2.getScore())).findFirst();
        System.out.println(first.get());
        // findAny:返回流中满足条件的任意一个元素
        Optional<Student> any = students.stream().filter(s -> s.getStatus().equals(Student.Status.FREE)).findAny();
        System.out.println(any.get());
        // 并行流:开启多个线程查找
        Optional<Student> any1 = students.parallelStream().filter(e -> e.getStatus().equals(Student.Status.VOCATION)).findAny();
        System.out.println(any1.get());
        // count:统计流中元素总数
        long count = students.stream().count();
        System.out.println("元素个数: " + count);
        // max:返回流中最大值
        Optional<Student> max = students.stream().max((s1, s2) -> Integer.compare(s1.getAge(), s2.getAge()));
        System.out.println("年龄最大的学生是" + max.get());
        // min:返回流中最小值
        Optional<Student> min = students.stream().min((s1, s2) -> Integer.compare(s1.getAge(), s2.getAge()));
        System.out.println("年龄最小的学生是" + min.get());

        Optional<Double> minScore = students.stream().map(Student::getScore).min(Double::compare);
        System.out.println("最低分数:" + minScore.get());
    }
}
