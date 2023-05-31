package com.learn.java8.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

public class CGLibProxyTest {
    public static void main(String[] args) {
        // 创建被代理实例
        Microsoft microsoft = new Microsoft();

        // 创建Cglib代理类实例
        CglibProxy cglibProxy = new CglibProxy(microsoft);

        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass( microsoft.getClass() );
        // 回调方法的参数为Cglib代理类对象
        enhancer.setCallback(cglibProxy);

        // 获取经Cglib代理后被增加的MicroSoft实例
        Microsoft microsoftCglibProxy = (Microsoft) enhancer.create();

        microsoftCglibProxy.releaseOS();
        microsoftCglibProxy.releaseOffice();
    }
}
