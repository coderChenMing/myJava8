package com.learn.java8.base;

import java.util.HashSet;
import java.util.Set;

public class DataTypeTest {
    public static void main(String[] args) {
        // byteScope();
        //intScope();
        //longScope();
        //integerCache();
        //integerCache2();
        //integerCache3();
        //integerCache4();
        //testMaxInt();
        //testShort();
        //testShort2();
        testFloat();
    }

    public static void byteScope() {
        System.out.println(String.format("Byte 取值: %d ~ %d ", Byte.MIN_VALUE, Byte.MAX_VALUE));
    }

    public static void intScope() {
        System.out.println(String.format("Integer 取值: %d ~ %d ", Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    public static void longScope() {
        System.out.println(String.format("Long 取值: %d ~ %d ", Long.MIN_VALUE, Long.MAX_VALUE));
    }

    public static void integerCache() {
        // Integer 高频区缓存范围 -128~127
        //变量num1为Integer类型，而127为int类型，且Integer和int之间并无继承关系，按照Java的一般处理方法，这行代码应该报错。
        //但因为自动装箱机制的存在，在为Integer类型的变量赋int类型值时，Java会自动将int类型转换为Integer类型，即
        //Integer num1 = Integer.valueOf(127);
        //valueOf()方法返回一个Integer类型值，并将其赋值给变量num1。这就是int的自动装箱。
        Integer num1 = 127;
        Integer num2 = 127;
        // Integer 取值 127 == 结果为 true（值127 num1==num2 => true）
        System.out.println("值127 num1==num2 => " + (num1 == num2));
        Integer num3 = 128;
        Integer num4 = 128;
        // Integer 取值 128 == 结果为 false（值128 num3==num4 => false）
        System.out.println("值128 num3==num4 => " + (num3 == num4));
    }

    public static void integerCache2() {
        /*每次循环时，Integer a = i和Integer b = i都会触发自动装箱，而自动装箱会将int转换Integer类型值并返回；
        我们知道Java中两个new出来的对象因为时不同的实例，无论如何==都会返回fasle。比如
        new Integer(1) == new Integer(1);
        就会返回false。
        返回true的唯一情况是比较的两个对象为同一个对象，那不妨把例子中a和b的内存地址都打印出来看看：
        */
        for (int i = 0; i < 150; i++) {
            Integer a = i;
            Integer b = i;
            System.out.println(a + " " + b + " " + System.identityHashCode(a) + " " + System.identityHashCode(b));
        }
        /*
        Integer.class在装载（Java虚拟机启动）时，其内部类型IntegerCache的static块即开始执行，实例化并暂存数值在-128到127之间的Integer类型对象。
        当自动装箱int型值在-128到127之间时，即直接返回IntegerCache中暂存的Integer类型对象。
        * */
        /*  - Float 和 Double 不会有缓存，其他包装类都有缓存。
        - Integer 是唯一一个可以修改缓存范围的包装类，在 VM optons 加入参数：
        > -XX:AutoBoxCacheMax=666 即修改缓存最大值为 `666` 。*/
    }

    public static void integerCache3() {
        //既然我们的目的是比较数值是否相等，而非判断是否为同一对象；而自动装箱又不能保证同一数值的Integer一定是同一对象或一定不是同一对象，
        // 那么就不要用==，直接用equals()好了。实际上，Integer重写了equals()方法，直接比较对象的数值是否相等。
        // 包装类因为有高频区域数据缓存，所以推荐使用 equals() 方法进行值比较。
        for (int i = 0; i < 150; i++) {
            Integer a = i;
            Integer b = i;
            System.out.println(i + " " + (a.equals(b)));
        }
        //这样返回值就全都是true了。
    }

    /*自动拆箱示例*/
    public static void integerCache4() {
        int i = 100;
        Integer j = new Integer(100);
        System.out.println(i == j);//true
        System.out.println(j.equals(i));//true
        //你发现把值改为 10000 结果也是 `true,true`，这是因为 Integer 和 int
        //比较时，会自动拆箱为 int 相当于两个 int 比较，值一定是 `true,true`。
    }

    public static void testMaxInt() {
        final int iMax = Integer.MAX_VALUE;
        System.out.println(iMax + 1);
        /*整数在内存中使用的是补码的形式表示，最高位是符号位 0 表示正数，1 表示负数，当执行 +1 时，最高位就变成了 1，结果就成了
                -2147483648。*/
    }

    public static void testShort() {
        Set<Short> set = new HashSet<>();
        for (short i = 0; i < 5; i++) {
            set.add(i);
            set.remove(i - 1);
        }
        System.out.println(set);
        System.out.println(set.size());

        /*这五个Short 类型 -1 (减1)之后转换成了 Int 类型，remove() 的时候在集合中找不到 Int
        类型的数据，所以就没有删除任何元素，执行的结果就是 5*/
    }

    public static void testShort2() {
        short s = 2;
        s += 1;
        System.out.println(s);
        //s=s+1;// 直接报错
        System.out.println(s);
        //s=s+1 会报错，s+=1 不会报错，因为 s=s+1 会导致 short 类型升级为 int 类型，所以会报错，而 s+=1 还是原来的 short
        //类型，所以不会报错。
    }

    public static void testFloat() {
        //float a=3.4;
        //因为值 3.4 是 double 类型，float 类型级别小于 double 类型，所以会报错
        System.out.println(3 * 0.1 == 0.3);
        //有些浮点数不能完全精确的表示出来
        System.out.println(3 * 0.1);//0.30000000000000004
    }
}
