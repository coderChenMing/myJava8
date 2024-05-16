package com.learn.java8.common.beanutils.convert;

import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * 此处简单写一个转换器，用于将 Cat 对象转换为 CatDto 对象
 *
 */
public class CatConverter implements Converter {
    @Override
    public <T> T convert(Class<T> type, Object value) {
        try {
            if (!(value instanceof Cat)) {
                throw new IllegalArgumentException("参数类型错误！");
            }
            if (type != CatDto.class) {
                throw new IllegalArgumentException("参数类型错误！");
            }
            String name = (String) PropertyUtils.getProperty(value, "name");
            Integer age = (Integer) PropertyUtils.getProperty(value, "age");
            T newInstance = type.getDeclaredConstructor().newInstance();
            PropertyUtils.setProperty(newInstance, "name", name);
            PropertyUtils.setProperty(newInstance, "age", age);
            return newInstance;
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}
