package com.learn.java8.jvm;

public class MethodSameTest {

    public void test(Integer count) {

    }
    /*public Integer test(Integer count1) {
        return 0;
    }*/
    // java语法里，对于同一个类，不允许方法名和方法类型都相同的两个方法存在，无论返回值是否相同
    // 而jvm支持方法名和方法参数相同但是返回值类型不同的重载，这是重要区别，
    // 从而可以通过使用字节码工具对字节码进行修改
}
