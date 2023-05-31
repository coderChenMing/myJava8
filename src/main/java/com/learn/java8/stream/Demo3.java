package com.learn.java8.stream;

import com.learn.java8.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Project: myJava8
 * File Created at 2022-02-12 12:12:12:12
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Demo3.java
 * @Desc
 * @date 2022/2/12 12:12
 */
public class Demo3 extends AbstractDemo {
    public static void main(String[] args) {
        // testMap();
        // testMap2();
        // list中的每一个元素作为参数传给Demo3的filterCharacter方法转换为流
        Stream<Stream<Character>> stream = list.stream().map(Demo3::filterCharacter);
        stream.forEach(s -> s.forEach(System.out::println));

        System.out.println("----------------升级---------------");
        // 使用flatMap可以简化上述操作,只需forEach一次即可
        // 类比集合add和addAll
        Stream<Character> characterStream = list.stream().flatMap(Demo3::filterCharacter);
        characterStream.forEach(System.out::println);

    }

    public static void testMap() {
        Stream<String> stringStream = list.stream().map(String::toUpperCase);
        stringStream.forEach(System.out::println);
    }

    public static void testMap2() {
        employees.stream().map(Employee::getAge).forEach(System.out::println);
        employees.stream().map(Employee::getSalary).forEach(System.out::println);
    }

    public static Stream<Character> filterCharacter(String string) {
        List<Character> list = new ArrayList<>();
        for (Character character : string.toCharArray()) {
            list.add(character);
        }
        return list.stream();
    }

}
