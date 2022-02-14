package com.learn.java8.stream;

import com.learn.java8.bean.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Project: myJava8
 * File Created at 2022-02-12 17:48:17:48
 * {@link}
 * 分组
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Demo8.java
 * @Desc
 * @date 2022/2/12 17:48
 */
public class Demo8 extends AbstractDemo {
    public static void main(String[] args) {
        // 按照status分组
        Map<Student.Status, List<Student>> groupMap = students.stream().collect(Collectors.groupingBy(Student::getStatus));
        System.out.println(groupMap);
        // 多级分组
        Map<Student.Status, Map<String, List<Student>>> stageGroup = students.stream().collect(Collectors.groupingBy(Student::getStatus, Collectors.groupingBy(
            (s) -> {
                if (s.getAge() < 18) {
                    return "未成年";
                } else if (s.getAge() >= 18 && s.getAge() <= 50) {
                    return "中年";
                } else {
                    return "老年";
                }
            }
        )));
        System.out.println(stageGroup);
    }
}
