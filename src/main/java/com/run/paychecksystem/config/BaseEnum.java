package com.run.paychecksystem.config;

import java.util.stream.Stream;

/**
 * User: ADROITWOLF
 * Time: 2019/10/18 17:07
 * Description: :枚举类的接口
 */
public interface BaseEnum<T> {


    static <V, E extends BaseEnum<V>> E ValueConvertToEnum(Class<E> enumType, V value) {
        return Stream.of(enumType.getEnumConstants())
                .filter(item -> item.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("未知的数据类型" + value));
    }

}
