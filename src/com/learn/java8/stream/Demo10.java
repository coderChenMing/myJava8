package com.learn.java8.stream;

import com.learn.java8.bean.Student;

import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;

/**
 * Project: myJava8
 * File Created at 2022-02-12 18:03:18:03
 * {@link}
 * 统计
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Demo10.java
 * @Desc
 * @date 2022/2/12 18:03
 */
public class Demo10 extends AbstractDemo {
    public static void main(String[] args) {
        DoubleSummaryStatistics dss = students.stream().collect(Collectors.summarizingDouble(Student::getScore));
        System.out.println("最大分值: " + dss.getMax());
        System.out.println("最小分值: " + dss.getMin());
        System.out.println("平均分值: " + dss.getAverage());
        System.out.println("总分: " + dss.getSum());
        System.out.println("统计的分值个数: " + dss.getCount());

        // 格式转换
        // 拼接姓名
        String nameStr = students.stream().map(Student::getName).collect(Collectors.joining("~"));
        System.out.println(nameStr);
    }
}
