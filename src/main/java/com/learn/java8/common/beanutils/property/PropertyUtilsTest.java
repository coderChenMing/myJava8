package com.learn.java8.common.beanutils.property;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.PropertyUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class PropertyUtilsTest {
    public static void main(String[] args) {
        Map<String, String> schoolMap = new HashMap<>();
        schoolMap.put("高中", "某高中");
        schoolMap.put("大学", "某大学");
        Student student = new Student("张三", 22, "北京", new Student.Friend("刘备", 26, "北京"), Arrays.asList("篮球", "足球"), schoolMap);
        //lowCopy(student);
        //describeTest(student);
        //listType(student);
        //getPropertyDescByObj(student);
        //getPropertyDescByClass(student);
        getPropertyDescs(student);
    }

    private static void getPropertyDescs(Student student) {
        PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(student);
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            //System.out.println(propertyDescriptor); // 太多了，不写了
            String name = propertyDescriptor.getName();
            String type = propertyDescriptor.getPropertyType().toString();
            log.info(String.format("%s:%s",name,type));

        }
    }

    private static void getPropertyDescByClass(Student student) {
        try {
            PropertyDescriptor propertyDescriptor = PropertyUtils.getPropertyDescriptor(Student.class, "name");
            System.out.println(propertyDescriptor);
            // java.beans.PropertyDescriptor[name=name; values={expert=false; visualUpdate=false; hidden=false;
            // enumerationValues=[Ljava.lang.Object;@527740a2; required=false}; propertyType=class java.lang.String;
            // readMethod=public java.lang.String java.lang.Class.getName()]
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private static void getPropertyDescByObj(Student student) {
        try {
            PropertyDescriptor propertyDescriptor = PropertyUtils.getPropertyDescriptor(student, "name");
            log.info(propertyDescriptor+"");
            // 好强大呀！
            // java.beans.PropertyDescriptor[name=name; values={expert=false; visualUpdate=false; hidden=false;
            // enumerationValues=[Ljava.lang.Object;@204f30ec; required=false}; propertyType=class java.lang.String;
            // readMethod=public java.lang.String com.zibo.zibo2022.property_utils.entity.Student.getName();
            // writeMethod=public void com.zibo.zibo2022.property_utils.entity.Student.setName(java.lang.String)]
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private static void listType(Student student) {
        try {
            Object property = PropertyUtils.getIndexedProperty(student, "hobbies[0]");
            System.out.println(property); // 篮球
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private static void describeTest(Student student) {
        try {
            Map<String, Object> map = PropertyUtils.describe(student);
            map.forEach((key, value) -> System.out.println(key + ":" + value));
            // address:北京
            // hobbies:[篮球, 足球]
            // friend:Student.Friend(name=刘备, age=26, address=北京)
            // name:訾博
            // schoolMap:{大学=某大学, 高中=某高中}
            // class:class com.zibo.zibo2022.property_utils.entity.Student
            // age:22
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private static void lowCopy( Student student){
        // 5、复制属性
        // 说明：经测试这是一种浅拷贝！
        try {
            Student student1 = new Student();
            // 参数：目标对象，源对象
            PropertyUtils.copyProperties(student1, student);
            System.out.println(student);
            // Student(name=訾博, age=22, address=北京, friend=Student.Friend(name=刘备, age=26, address=北京), hobbies=[篮球, 足球], schoolMap={大学=某大学, 高中=某高中})
            System.out.println(student1);
            // Student(name=訾博, age=22, address=北京, friend=Student.Friend(name=刘备, age=26, address=北京), hobbies=[篮球, 足球], schoolMap={大学=某大学, 高中=某高中})
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
