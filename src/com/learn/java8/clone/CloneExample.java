package com.learn.java8.clone;

import com.learn.java8.bean.People;

import java.util.Arrays;

/**
 * Project: myJava8
 * File Created at 2022-04-12 09:29:9:29
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type CloneExample.java
 * @Description
 * @date 2022/4/12 9:29
 */
public class CloneExample {
    public static void main(String[] args) throws Exception {

        testPeople();
       // testArray();
    }

    public static void testPeople() throws CloneNotSupportedException {
        People p1 = new People();
        p1.setId(1);
        p1.setName("张三");
        People p2 = (People) p1.clone();
        // 克隆对象与原型对象地址值不等
        System.out.println(p1 == p2);
        // 克隆对象与原型对象同一类型
        System.out.println(p1.getClass() == p2.getClass());
        // 克隆对象与原型对象属性值相等
        System.out.println(p1.equals(p2));
        System.out.println(p2.getName());
    }

    public static void testArray() {
        Integer[] nums = {1, 2, 3, 4};
        Integer[] nums2 = Arrays.copyOf(nums, nums.length);
        // 修改克隆对象
        nums2[0] = 5;
        System.out.println("nums: " + Arrays.toString(nums));
        System.out.println("nums2: " + Arrays.toString(nums2));
    }
}
