package com.learn.java8.jvm;

public class A<T extends C> {
    public C test(String name) {
        System.out.println("A.test");
        return new C();
    }

    public void test(T c) {
        System.out.println("A.桥接");
    }

    /* java 语法 中A和B 分别返回C和D，方法名和参数相同，返回值不同，但是返回值构成父子关系，所以方法test同样构成重写
     *  然后在java虚拟机中对于重写必须保证参数和返回类型严格一致，即时返回值是父子关系也不行
     * */
    public static void test2() {
        System.out.println("A.test2");
    }
}
