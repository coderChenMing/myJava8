package com.learn.java8.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectMethod {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        Class clazz = Class.forName("com.learn.java8.reflection.Circle");

        //根据参数获取public的Method,包含继承自父类的方法
        Method method = clazz.getMethod("draw",int.class,String.class);

        System.out.println("method:"+method);

        //获取所有public的方法:
        Method[] methods =clazz.getMethods();
        for (Method m:methods){
            System.out.println("m::"+m);
        }

        System.out.println("=========================================");

        //获取当前类的方法包含private,该方法无法获取继承自父类的method
        Method method1 = clazz.getDeclaredMethod("drawCircle");
        System.out.println("method1::"+method1);
        //获取当前类的所有方法包含private,该方法无法获取继承自父类的method
        Method[] methods1=clazz.getDeclaredMethods();
        for (Method m:methods1){
            System.out.println("m1::"+m);
        }
        //创建对象
        Circle circle = (Circle) clazz.newInstance();
        //获取指定参数的方法对象Method
        Method method2 = clazz.getMethod("draw",int.class,String.class);
        //通过Method对象的invoke(Object obj,Object... args)方法调用
        method2.invoke(circle,15,"圈圈");
        //对私有无参方法的操作
        Method method3 = clazz.getDeclaredMethod("drawCircle");
        //修改私有方法的访问标识
        method3.setAccessible(true);
        method3.invoke(circle);
        //对有返回值得方法操作
        Method method4 =clazz.getDeclaredMethod("getAllCount");
        Integer count = (Integer) method4.invoke(circle);
        System.out.println("count:"+count);
    }
}

class Shape {
    public void draw(){
        System.out.println("draw");
    }

    public void draw(int count , String name){
        System.out.println("draw "+ name +",count="+count);
    }

}
class Circle extends Shape{

    private void drawCircle(){
        System.out.println("drawCircle");
    }
    public int getAllCount(){
        return 100;
    }
}
