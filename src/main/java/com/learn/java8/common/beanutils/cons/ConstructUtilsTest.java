package com.learn.java8.common.beanutils.cons;

import org.apache.commons.beanutils.ConstructorUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructUtilsTest {
    public static void main(String[] args) {
        // 1、执行构造方法 - 单个参数 - 自动获取类型
        try {
            Student student1 = ConstructorUtils.invokeConstructor(Student.class, "张三");
            System.out.println(student1.getName()); // 张三
        } catch (NoSuchMethodException | IllegalAccessException |
                 InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        }

        // 2、执行构造方法 - 多个参数 - 自动获取类型
        try {
            // 参数列表
            Object[] args1 = new Object[] {"李四", 18};
            Student student2 = ConstructorUtils.invokeConstructor(Student.class, args1);
            System.out.println(student2.getName()); // 李四
            System.out.println(student2.getAge()); // 18
        } catch (NoSuchMethodException | IllegalAccessException |
                 InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        }

        // 3、执行构造方法 - 多个参数 - 手动设置类型
        try {
            // 参数列表
            Object[] args1 = new Object[] {"王五", 20};
            // 参数类型列表
            Class<?>[] types = new Class[] {String.class, Integer.class};
            Student student3 = ConstructorUtils.invokeConstructor(Student.class, args1, types);
            System.out.println(student3.getName()); // 王五
            System.out.println(student3.getAge()); // 20
        } catch (NoSuchMethodException | IllegalAccessException |
                 InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        }

        // 4、执行精确的构造方法 - 单个参数 - 自动获取类型
        try {
            Student student4 = ConstructorUtils.invokeExactConstructor(Student.class, "张三");
            System.out.println(student4.getName()); // 张三
        } catch (NoSuchMethodException | IllegalAccessException |
                 InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        }

        // 5、执行精确的构造方法 - 多个参数 - 自动获取类型
        try {
            // 参数列表
            Object[] args1 = new Object[] {"李四", 18};
            Student student5 = ConstructorUtils.invokeExactConstructor(Student.class, args1);
            System.out.println(student5.getName()); // 李四
            System.out.println(student5.getAge()); // 18
        } catch (NoSuchMethodException | IllegalAccessException |
                 InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        }

        // 6、执行精确的构造方法 - 多个参数 - 手动设置类型
        try {
            // 参数列表
            Object[] args1 = new Object[] {"王五", 20};
            // 参数类型列表
            Class<?>[] types = new Class[] {String.class, Integer.class};
            Student student6 = ConstructorUtils.invokeExactConstructor(Student.class, args1, types);
            System.out.println(student6.getName()); // 王五
            System.out.println(student6.getAge()); // 20
        } catch (NoSuchMethodException | IllegalAccessException |
                 InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        }

        // 7、指定一个类型，获取单参构造方法（测试1）
        try {
            Constructor<Student> constructor = ConstructorUtils.getAccessibleConstructor(Student.class, String.class);
            Student student7 = constructor.newInstance("马六");
            System.out.println(student7.getName()); // 马六
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        }

        // 8、指定一个类型，获取单参构造方法（测试2）
        try {
            Constructor<Student> constructor = ConstructorUtils.getAccessibleConstructor(Student.class, Integer.class);
            Student student8 = constructor.newInstance(26);
            System.out.println(student8.getAge()); // 26
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        }

        // 9、指定一个类型列表，获取多参构造方法
        try {
            // 参数类型列表
            Class<?>[] types = new Class[] {String.class, Integer.class};
            Constructor<Student> constructor = ConstructorUtils.getAccessibleConstructor(Student.class, types);
            Student student9 = constructor.newInstance("马六", 26);
            System.out.println(student9.getName()); // 马六
            System.out.println(student9.getAge()); // 26
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        }

        // 10、获取给定构造函数的可访问版本
        try {
            Constructor<Student> constructor = ConstructorUtils.getAccessibleConstructor(Student.class, Integer.class);
            Constructor<Student> constructor1 = ConstructorUtils.getAccessibleConstructor(constructor);
            Student student10 = constructor1.newInstance(26);
            System.out.println(student10.getAge()); // 26
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        }

    }
}
