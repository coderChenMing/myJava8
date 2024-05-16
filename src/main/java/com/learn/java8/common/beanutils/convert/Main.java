package com.learn.java8.common.beanutils.convert;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Cat cat = new Cat("小猫", 1);
        Cat cat2 = new Cat("小猫2", 2);

        // 1、将对象转换为字符串
        String convert = ConvertUtils.convert(cat);
        System.out.println(convert); // Cat(name=小猫, age=1)
        // 下面的内容是值得注意的，如果是数组，只转换第一个元素
        String convert20 = ConvertUtils.convert(new Cat[] {cat, cat2});
        System.out.println(convert20); // Cat(name=小猫, age=1)
        String convert40 = ConvertUtils.convert(new String[] {"小猫", "1", "随便写的内容"});
        System.out.println(convert40);
        String convert10 = ConvertUtils.convert(new Long[] {1L, 2L, 3L});
        System.out.println(convert10); // 1

        // 2、将字符串转换为指定数据类型对象
        String one = "1";
        Integer convert1 = (Integer) ConvertUtils.convert(one, Integer.class);
        System.out.println(convert1); // 1
        Object convert2 = ConvertUtils.convert(one, Boolean.class);
        System.out.println(convert2); // true
        Object convert4 = ConvertUtils.convert("true", Boolean.class);
        System.out.println(convert4); // true
        Integer[] convert5 = (Integer[]) ConvertUtils.convert("[1, 2, 3]", Integer[].class);
        for (Integer integer : convert5) {
            System.out.println(integer);
        }
        // 1
        // 2
        // 3
        // 下面无法转换！！！
        // Cat convert6 = (Cat)ConvertUtils.convert("Cat(name=小猫, age=1)", Cat.class);
        // System.out.println(convert6);
        // org.apache.commons.beanutils.ConversionException: Default conversion to com.zibo.zibo2022.convert_utils.entity.Cat failed.

        // 3、将指定值的数组转换为指定类的对象数组（如果可能）
        String[] array = {"吃老鼠", "吃鱼"};
        String[] convert3 = (String[]) ConvertUtils.convert(array, String.class);
        System.out.println(Arrays.toString(convert3)); // [吃老鼠, 吃鱼]
        String[] arr = {"true", "false"};
        Boolean[] conver4 = (Boolean[]) ConvertUtils.convert(arr, Boolean.class);
        System.out.println(Arrays.toString(conver4)); // [true, false]

        // 4、将对象转换为指定数据类型对象
        Boolean convert7 = (Boolean) ConvertUtils.convert("true", Boolean.class);
        System.out.println(convert7); // true

        // 5、注册转换器
        // 这里是自定义转换器，然后注册
        ConvertUtils.register(new CatConverter(), Cat.class);
        CatConverter catConverter = new CatConverter();
        CatDto catDto = catConverter.convert(CatDto.class, cat);
        System.out.println(catDto); // CatDto(name=小猫, age=1)

        // 6、查找指定类型的转换器
        Converter lookup = ConvertUtils.lookup(Cat.class);
        System.out.println(lookup); // com.zibo.zibo2022.convert_utils.converter.CatConverter@523884b2

        // 7、查找将指定类型转换为另一种类型的转换器
        Converter lookup2 = ConvertUtils.lookup(String.class, Boolean.class);
        System.out.println(lookup2); // ConverterFacade[BooleanConverter[UseDefault=true]]
        Converter converter = ConvertUtils.lookup(CatDto.class, Cat.class);
        System.out.println(converter); // com.zibo.zibo2022.convert_utils.converter.CatConverter@523884b2
        // 注意下面
        Converter lookup3 = ConvertUtils.lookup(Cat.class, CatDto.class);
        System.out.println(lookup3); // null

        // 8、移除指定类型的转换器
        ConvertUtils.deregister(Cat.class);
        Converter converter1 = ConvertUtils.lookup(CatDto.class, Cat.class);
        System.out.println(converter1); // null

        // 9、移除所有已经注册的转换器
        ConvertUtils.deregister();

        // 10、基本类型转换成包装类
        int i = 1;
        Integer i2 = (Integer) ConvertUtils.convert(i, Integer.class);
        System.out.println(i2); // 1
    }

}
