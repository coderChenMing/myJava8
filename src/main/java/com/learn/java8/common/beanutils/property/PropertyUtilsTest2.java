package com.learn.java8.common.beanutils.property;

import org.apache.commons.beanutils.BeanIntrospector;
import org.apache.commons.beanutils.DefaultBeanIntrospector;
import org.apache.commons.beanutils.PropertyUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class PropertyUtilsTest2 {

    public static void main(String[] args) {
        Map<String, String> schoolMap = new HashMap<>();
        schoolMap.put("高中", "某高中");
        schoolMap.put("大学", "某大学");
        Student student = new Student("张三", 22, "北京", new Student.Friend("刘备", 26, "北京"), Arrays.asList("篮球", "足球"), schoolMap);

        // 看不懂，暂且搁置
        // 1、清空所有属性的描述信息
        // 说明：清除任何类加载器加载的所有类的任何缓存属性描述符信息。这在丢弃类加载器以实现类重新加载的情况下很有用。
        PropertyUtils.clearDescriptors();

        // 2、重置 BeanIntrospectors 的缓存属性描述符信息
        // 说明：将注册的 BeanIntrospector 对象重置为初始默认状态。
        PropertyUtils.resetBeanIntrospectors();

        // 3、添加一个 BeanIntrospector
        // 说明：添加一个 BeanIntrospector ，当需要获取类的属性描述符时调用该对象。
        PropertyUtils.addBeanIntrospector(DefaultBeanIntrospector.INSTANCE);

        // 4、移除一个 BeanIntrospector
        // 说明：移除指定的 BeanIntrospector 。
        BeanIntrospector instance = DefaultBeanIntrospector.INSTANCE;
        PropertyUtils.removeBeanIntrospector(instance);

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

        // 6、获取属性描述
        // 说明：经测试发现，含所有属性和 class 属性
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

        // 7、指定索引属性值，适用于属性是 list 或 array 的情况
        try {
            Object property = PropertyUtils.getIndexedProperty(student, "hobbies[0]");
            System.out.println(property); // 篮球
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // 8、指定索引属性值，适用于属性是 list 或 array 的情况
        try {
            Object property = PropertyUtils.getIndexedProperty(student, "hobbies", 1);
            System.out.println(property); // 足球
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // 9、获取 map 属性，适用于属性是 map 的情况
        try {
            Object property = PropertyUtils.getMappedProperty(student, "schoolMap(高中)");
            System.out.println(property); // 某高中
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // 10、获取 map 属性，适用于属性是 map 的情况
        try {
            Object property = PropertyUtils.getMappedProperty(student, "schoolMap", "大学");
            System.out.println(property); // 某大学
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // 11、获取嵌套属性，属性是对象的情况
        try {
            Object property = PropertyUtils.getNestedProperty(student, "friend.name");
            System.out.println(property); // 刘备
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // 12、获取属性
        try {
            Object property = PropertyUtils.getProperty(student, "name");
            System.out.println(property); // 訾博
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // 13、获取属性描述 - 通过对象
        try {
            PropertyDescriptor propertyDescriptor = PropertyUtils.getPropertyDescriptor(student, "name");
            System.out.println(propertyDescriptor);
            // 好强大呀！
            // java.beans.PropertyDescriptor[name=name; values={expert=false; visualUpdate=false; hidden=false;
            // enumerationValues=[Ljava.lang.Object;@204f30ec; required=false}; propertyType=class java.lang.String;
            // readMethod=public java.lang.String com.zibo.zibo2022.property_utils.entity.Student.getName();
            // writeMethod=public void com.zibo.zibo2022.property_utils.entity.Student.setName(java.lang.String)]
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // 14、获取属性描述 - 通过类
        try {
            PropertyDescriptor propertyDescriptor = PropertyUtils.getPropertyDescriptor(Student.class, "name");
            System.out.println(propertyDescriptor);
            // java.beans.PropertyDescriptor[name=name; values={expert=false; visualUpdate=false; hidden=false;
            // enumerationValues=[Ljava.lang.Object;@527740a2; required=false}; propertyType=class java.lang.String;
            // readMethod=public java.lang.String java.lang.Class.getName()]
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // 15、获取属性描述数组
        PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(student);
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            System.out.println(propertyDescriptor); // 太多了，不写了
        }

        // 16、获取已为此属性注册的任何显式 PropertyEditor Class
        try {
            Class<?> propertyEditorClass = PropertyUtils.getPropertyEditorClass(student, "name");
            System.out.println(propertyEditorClass); // 此处返回为 null ，具体不知道何用
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // 17、获取属性类型
        try {
            Class<?> propertyType = PropertyUtils.getPropertyType(student, "name");
            System.out.println(propertyType); // class java.lang.String
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // 18、判断一个属性是否为可读属性
        boolean isReadable = PropertyUtils.isReadable(student, "name");
        System.out.println(isReadable); // true

        // 19、判断一个属性是否为可写属性
        boolean isWriteable = PropertyUtils.isWriteable(student, "name");
        System.out.println(isWriteable); // true

        // 20、设置指定索引属性值，适用于属性是list或者array的情况
        try {
            PropertyUtils.setIndexedProperty(student, "hobbies[0]", "da篮球");
            System.out.println(student.getHobbies()); // [da篮球, 足球]
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // 21、设置指定索引属性值，适用于属性是list或者array的情况
        try {
            PropertyUtils.setIndexedProperty(student, "hobbies", 1, "足da球");
            System.out.println(student.getHobbies()); // [da篮球, 足da球]
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // 22、设置指定属性值，适用于属性是 map 的情况
        try {
            PropertyUtils.setMappedProperty(student, "schoolMap(高中)", "某da高中");
            System.out.println(student.getSchoolMap()); // {大学=某大学, 高中=某da高中}
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // 23、设置指定属性值，适用于属性是 map 的情况
        try {
            PropertyUtils.setMappedProperty(student, "schoolMap", "大学", "某da大学");
            System.out.println(student.getSchoolMap()); // {大学=某da大学, 高中=某da高中}
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // 24、设置属性值
        try {
            PropertyUtils.setProperty(student, "name", "某da学生");
            System.out.println(student.getName()); // 某da学生
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // 25、设置属性值
        try {
            PropertyUtils.setSimpleProperty(student, "name", "某da&da学生");
            System.out.println(student.getName()); // 某da学生
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }

}
