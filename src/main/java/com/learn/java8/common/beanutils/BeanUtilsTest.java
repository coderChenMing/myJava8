package com.learn.java8.common.beanutils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 很多方法与 PropertyUtils 重复
 */
public class BeanUtilsTest {
    public static void main(String[] args) {

        List<String> hobbies = Arrays.asList("swimming", "running", "sleeping");
        Map<String, String> habits = new HashMap<String,String>() {{
            put("drinking", "beer");
            put("smoking", "smoking");
        }};

        Dog littleDog = new Dog("小狗***-*----的儿子", 1, "黑色", null, null, null);
        Dog dog = new Dog("小狗", 2, "黄色", littleDog, hobbies, habits);

        // 1、克隆对象 - 浅克隆
        try {
            Dog cloneBean = (Dog) BeanUtils.cloneBean(dog);
            littleDog.setName("小狗的儿子cloneBean");
            System.out.println(cloneBean);
            // Dog(name=小狗, age=2, color=黄色, son=Dog(name=小狗的儿子cloneBean, age=1, color=黑色, son=null, hobbies=null,
            // habits=null), hobbies=[swimming, running, sleeping], habits={drinking=beer, smoking=tobacco})
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // 2、复制属性 - 浅复制
        try {
            Dog dog1 = new Dog();
            BeanUtils.copyProperties(dog1, dog);
            littleDog.setName("小狗的儿子dog1");
            System.out.println(dog1);
            // Dog(name=小狗, age=2, color=黄色, son=Dog(name=小狗的儿子dog1, age=1, color=黑色, son=null, hobbies=null,
            // habits=null), hobbies=[swimming, running, sleeping], habits={drinking=beer, smoking=tobacco})
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // 3、复制属性，相当于设置属性
        // 这就是设置属性，没看出来跟复制属性有什么关系
        try {
            Dog dog2 = new Dog();
            BeanUtils.copyProperty(dog2, "name", "dog2");
            System.out.println(dog2);
            // Dog(name=dog2, age=null, color=null, son=null, hobbies=null, habits=null)
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // 4、描述 - 获取属性列表（含属性名和属性值）
        // 可借此实现判断一个类对象的所有属性是否都有值
        try {
            Map<String, String> map = BeanUtils.describe(dog);
            map.forEach((key, value) -> System.out.println(key + ":" + value));
            // habits:{drinking=beer, smoking=tobacco}
            // son:Dog(name=小狗的儿子dog1, age=1, color=黑色, son=null, hobbies=null, habits=null)
            // color:黄色
            // hobbies:swimming
            // name:小狗
            // age:2
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // 5、返回指定属性的值，作为字符串数组返回
        try {
            String[] names = BeanUtils.getArrayProperty(dog, "name");
            System.out.println(Arrays.toString(names)); // [小狗]
            String[] hobbies1 = BeanUtils.getArrayProperty(dog, "hobbies");
            System.out.println(Arrays.toString(hobbies1)); // [swimming, running, sleeping]
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // 6、获取指定索引属性值，适用于属性是list或者array的情况
        // 与 PropertyUtils 的 getIndexedProperty 本质上是同一个方法
        try {
            String name = BeanUtils.getIndexedProperty(dog, "hobbies[0]");
            System.out.println(name); // swimming
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // 7、获取指定索引属性值，适用于属性是list或者array的情况
        // 与 PropertyUtils 的 getIndexedProperty 本质上是同一个方法
        try {
            String hobby = BeanUtils.getIndexedProperty(dog, "hobbies", 0);
            System.out.println(hobby); // swimming
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // 8、获得Map属性，适用于属性是Map的情况
        // 与 PropertyUtils 的 getMappedProperty 本质上是同一个方法
        try {
            String habit = BeanUtils.getProperty(dog, "habits.smoking");
            System.out.println(habit); // tobacco
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // 9、获得Map属性，适用于属性是Map的情况
        // 与 PropertyUtils 的 getMappedProperty 本质上是同一个方法
        try {
            String habit = BeanUtils.getMappedProperty(dog, "habits", "smoking");
            System.out.println(habit); // tobacco
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // 10、获得嵌套属性，属性是对象的情况
        // 与 PropertyUtils 的 getNestedProperty 本质上是同一个方法
        try {
            String name = BeanUtils.getNestedProperty(dog, "son.name");
            System.out.println(name); // 小狗的儿子dog1
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // 11、获得属性值作为字符串返回
        try {
            String name = BeanUtils.getProperty(dog, "name");
            System.out.println(name); // 小狗
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // 12、获得属性值作为字符串返回
        // TODO 暂未发现与 getProperty 的区别
        try {
            String age = BeanUtils.getSimpleProperty(dog, "age");
            System.out.println(age); // 2
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // 13、将Map转换成对象
        try {
            Dog dog3 = new Dog();
            BeanUtils.populate(dog3, PropertyUtils.describe(dog));
            System.out.println(dog3);
            // Dog(name=小狗, age=2, color=黄色, son=Dog(name=小狗的儿子dog1, age=1, color=黑色, son=null, hobbies=null, habits=null),
            // hobbies=[swimming, running, sleeping], habits={drinking=beer, smoking=tobacco})
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // 14、设置属性值
        try {
            BeanUtils.setProperty(dog, "name", "大狗子");
            System.out.println(dog.getName()); // 大狗子
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // 15、对异常进行包装 - TODO 不知何用
        NullPointerException nullPointerException = new NullPointerException("情况一");
        NullPointerException nullPointerException1 = new NullPointerException("情况二");
        boolean initCause = BeanUtils.initCause(nullPointerException, nullPointerException1);
        System.out.println(initCause); // true

        // 16、创建缓存 - TODO 不知何用
        Map<Object, Object> cache = BeanUtils.createCache();
        System.out.println(cache); // {}

        // 17、getCacheFast - TODO 不知何用
        boolean fast = BeanUtils.getCacheFast(cache);
        System.out.println(fast); // false

        // 18、setCacheFast - TODO 不知何用
        BeanUtils.setCacheFast(cache, true);

    }

}

