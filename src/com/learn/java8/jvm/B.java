package com.learn.java8.jvm;

public class B extends A<D>{

    @Override
    public D test(String name) {
        System.out.println("B.test");
        return new D();
    }

    public void test(D d) {
        System.out.println("B.桥接");
        //子类在继承父类的一个泛型方法、或子类实现一个接口的泛型方法，编译器会在子类的 class 文件中自动生成桥接方法。
    }

    public static void test2() {
        System.out.println("B.test2");
    }

    public static void main(String[] args) {
        A.test2();
        B.test2();
        A a = new B();
        a.test("zhangsan");// B.test
        a.test(new D());
    }
}
