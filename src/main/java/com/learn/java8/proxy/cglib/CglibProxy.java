package com.learn.java8.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLIB 代理对象
 */
public class CglibProxy implements MethodInterceptor {
    private Object object;

    public CglibProxy(Object o) {
        this.object = o;
    }

    /**
     * 被增加的实例通过调用该方法，实现行为增强
     * @param o
     * @param method 方法
     * @param args 方法参数
     * @param proxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("Cglib Proxy: Start");
        System.out.println("proxy :"+o.getClass().getName());
        System.out.println("被代理类:"+object.getClass().getName());
        Object result = method.invoke(object, args);

        System.out.println("Cglib Proxy: End\n");
        return result;
    }
}