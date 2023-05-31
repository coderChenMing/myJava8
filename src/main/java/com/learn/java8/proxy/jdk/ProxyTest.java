package com.learn.java8.proxy.jdk;

import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        // 创建被代理实例
        Apple apple = new Apple();
        // 创建中介类实例
        JDKProxy jdkProxy = new JDKProxy(apple);

        // [可选地]: 将生成的动态代理类 Class 文件保存到指定路径下
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        // 获取动态代理类实例
        Sell sell = (Sell) Proxy.newProxyInstance(
                jdkProxy.getClass().getClassLoader(),  // 指定ClassLoader类加载器实例, 用于加载动态代理类的实例
                new Class[] {Sell.class},       // 指定代理类实例实现的接口类型数组
                jdkProxy);                  // 指定代理类实例所关联的InvocationHandler对象


        System.out.println("[sell class name] : " + sell.getClass().getName());

        sell.sellPhone();
        sell.sellPc();
    }
}
