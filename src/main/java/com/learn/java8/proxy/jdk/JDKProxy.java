package com.learn.java8.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * JDK代理: 中介类, 其必须实现InvocationHandler接口
 */
public class JDKProxy implements InvocationHandler {

    private Object object;

    public JDKProxy(Object o) {
        this.object = o;
    }

    /**
     * 动态代理实例内部通过调用该方法，实现行为增强
     * @param proxy 动态代理类实例
     * @param method 方法
     * @param args 方法参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK Proxy: Start");
        System.out.println("[proxy class name] : " + proxy.getClass().getName());
        System.out.println("[method] : " + method.toString());

        // 调用被代理对象相应的方法
        Object result = method.invoke(object, args);
        System.out.println(proxy.getClass().getName());
        System.out.println("JDK Proxy: End\n");
        return result;
    }
}
