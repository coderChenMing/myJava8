package com.learn.java8.jvm;

public class A {
    public C test(String name) {
        System.out.println("A.test");
        return new C();
    }

    /* java 语法 中A和B 分别返回C和D，方法名和参数相同，返回值不同，但是返回值构成父子关系，所以方法test同样构成重写
     *  然后在java虚拟机中对于重写必须保证参数和返回类型严格一致，即时返回值是父子关系也不行
     * */
}
