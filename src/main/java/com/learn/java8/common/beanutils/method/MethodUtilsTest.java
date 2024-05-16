package com.learn.java8.common.beanutils.method;

import org.apache.commons.beanutils.MethodUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodUtilsTest {

    public static void main(String[] args) {
        People people = new People("zibo", 18, "beijing");
        // 1、设置是否应该缓存方法以获得更高的性能，默认为true。
        MethodUtils.setCacheMethods(true);
        // 2、清空方法缓存
        MethodUtils.clearCache();

        // 3、执行方法：单个参数 + 自动获取类型
        try {
            // 参数：对象，方法名，参数
            MethodUtils.invokeMethod(people, "setName", "大哥");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("name: " + people.getName()); // name: 大哥

        // 4、执行方法：多个参数 + 自动获取类型
        Object[] args1 = new Object[] {26};
        try {
            // 参数：对象，方法名，参数列表，参数类型列表
            MethodUtils.invokeMethod(people, "setAge", args1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("age: " + people.getAge()); // age: 26

        // 5、执行方法：单个参数 + 手动设置类型
        Object[] args2 = new Object[] {"河南省"};
        Class<?>[] types = new Class[] {String.class};
        try {
            // 参数：对象，方法名，参数，参数类型
            MethodUtils.invokeMethod(people, "setAddress", args2, types);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("address: " + people.getAddress()); // address: 河南省

        // 6、精确执行方法，此处我们精确调用有 1 个参数的方法 + 自动获取类型
        try {
            // 参数：对象，方法名，参数
            MethodUtils.invokeExactMethod(people, "setName", "大哥刘备");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("name: " + people.getName()); // name: 大哥刘备

        // 6、精确执行方法：此处我们精确调用有 2 个参数的方法 + 自动获取类型
        Object[] args3 = new Object[] {"大哥的名字叫做", "刘备"};
        try {
            // 参数：对象，方法名，参数列表，参数类型列表
            MethodUtils.invokeExactMethod(people, "setName", args3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("name: " + people.getName()); // name: 大哥的名字叫做刘备

        // 7、精确执行方法：此处我们精确调用有 2 个参数的方法 + 手动设置类型
        Class<?>[] types1 = new Class[] {String.class, String.class};
        try {
            // 参数：对象，方法名，参数列表，参数类型列表
            MethodUtils.invokeExactMethod(people, "setName", args3, types1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("name: " + people.getName()); // name: 大哥的名字叫做刘备

        // 8、精确执行静态方法：单个参数 + 自动获取类型
        try {
            // 参数：类名，方法名，参数
            MethodUtils.invokeStaticMethod(People.class, "say", "大哥，快来啦！");
            // 大哥，快来啦！
            // 单参数静态方法：say
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 9、精确执行静态方法：多个参数 + 自动获取类型
        Object[] args4 = new Object[] {"大哥，快来啦！", "大哥，快来啦！"};
        try {
            // 参数：类名，方法名，参数列表，参数类型列表
            MethodUtils.invokeStaticMethod(People.class, "say", args4);
            // 大哥，快来啦！大哥，快来啦！
            // 多参数静态方法：say
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 10、精确执行静态方法：多个参数 + 手动设置类型
        Object[] args5 = new Object[] {"大哥，快来啦！", "大哥，快来啦！"};
        Class<?>[] types2 = new Class[] {String.class, String.class};
        try {
            // 参数：类名，方法名，参数列表，参数类型列表
            MethodUtils.invokeStaticMethod(People.class, "say", args5, types2);
            // 大哥，快来啦！大哥，快来啦！
            // 多参数静态方法：say
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 11、精确执行静态方法：无参数
        try {
            // 参数：类名，方法名，参数
            // 参数设置为 null 可调用无参方法
            MethodUtils.invokeStaticMethod(People.class, "say", null);
            // 无参数静态方法：say
        } catch (Exception e) {
            e.printStackTrace();
        }


        // 12、获取一个可访问的方法：类名，方法名，参数类型
        Method method = MethodUtils.getAccessibleMethod(People.class, "setName", String.class);
        try {
            method.invoke(people, "二哥关羽");
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("name: " + people.getName()); // name: 二哥关羽

        // 13、获取一个可访问的方法：类名，方法名，参数类型列表
        Class<?>[] types3 = new Class[] {String.class, String.class};
        Method method1 = MethodUtils.getAccessibleMethod(People.class, "setName", types3);
        try {
            method1.invoke(people, "二哥关羽", "三哥张飞");
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("name: " + people.getName()); // name: 二哥关羽三哥张飞

        // 14、获取指定方法的可访问方法：找不到这个方法返回空（测试1）
        try {
            Method setName = People.class.getDeclaredMethod("setName", String.class);
            Method accessibleMethod = MethodUtils.getAccessibleMethod(setName);
            accessibleMethod.invoke(people, "四哥赵云");
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("name: " + people.getName()); // name: 四哥赵云

        // 15、获取指定方法的可访问方法：找不到这个方法返回空（测试2）
        // 备注：如果不用工具，此时没有这个方法，会被捕捉到 NoSuchMethodException 异常，搞不懂为何还需要 getAccessibleMethod 这个方法！
        try {
            Method setName = People.class.getDeclaredMethod("setNumber", Integer.class);
            // java.lang.NoSuchMethodException: com.zibo.zibo2022.entity.People.setNumber(java.lang.Integer)
            Method accessibleMethod = MethodUtils.getAccessibleMethod(setName);
            System.out.println(accessibleMethod);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        // 16、获取指定方法的可访问方法：找不到这个方法返回空（测试3）
        // 使用工具获取方法：我知道了，因为使用工具获取方法，如果没有也不会报错，因此使用这个方法来判断是否有此方法！
        Method method2 = MethodUtils.getAccessibleMethod(People.class, "setNumber", types3);
        Method method3 = MethodUtils.getAccessibleMethod(method2);
        System.out.println(method3); // null

        // 17、获取指定方法的可访问方法：类 + 方法
        Method method4 = MethodUtils.getAccessibleMethod(People.class, method2);
        System.out.println(method4); // null

        // 18、获取与指定方法名称相同且与参数类型列表匹配的可访问方法
        Method method5 = MethodUtils.getMatchingAccessibleMethod(People.class, "setName", types3);
        try {
            method5.invoke(people, "二哥关羽", "三哥张飞");
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("name: " + people.getName()); // name: 二哥关羽三哥张飞

        // 19、确定一个类型是否可以用作方法调用中的参数。
        boolean isAssignableFrom = MethodUtils.isAssignmentCompatible(String.class, Integer.class);
        System.out.println(isAssignableFrom); // false
        isAssignableFrom = MethodUtils.isAssignmentCompatible(String.class, String.class);
        System.out.println(isAssignableFrom); // true
        isAssignableFrom = MethodUtils.isAssignmentCompatible(String.class, Object.class);
        System.out.println(isAssignableFrom); // false
        isAssignableFrom = MethodUtils.isAssignmentCompatible(Integer.class, Object.class);
        System.out.println(isAssignableFrom); // false
        isAssignableFrom = MethodUtils.isAssignmentCompatible(Integer.class, Long.class);
        System.out.println(isAssignableFrom); // false

        // 20、获取一个基本类型的包装类型
        Class<?> primitiveType = MethodUtils.getPrimitiveWrapper(int.class);
        System.out.println(primitiveType); // class java.lang.Integer

        // 21、获得包装类的基本数据类型
        Class<?> primitiveType2 = MethodUtils.getPrimitiveType(Integer.class);
        System.out.println(primitiveType2); // int

        // 22、如果是简单数据类型则返回对应的包装类，否则返回本身
        Class<?> primitiveType3 = MethodUtils.toNonPrimitiveClass(int.class);
        System.out.println(primitiveType3); // class java.lang.Integer
        Class<?> primitiveType4 = MethodUtils.toNonPrimitiveClass(Integer.class);
        System.out.println(primitiveType4); // class java.lang.Integer

    }

}
