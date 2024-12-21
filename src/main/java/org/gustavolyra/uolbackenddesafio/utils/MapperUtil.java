package org.gustavolyra.uolbackenddesafio.utils;

import org.gustavolyra.uolbackenddesafio.utils.exceptions.MapperException;

import java.lang.reflect.Field;

public class MapperUtil {

    private MapperUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static <T> T map(Object source, Class<T> targetClass) {
        try {
            T target = targetClass.getDeclaredConstructor().newInstance();
            Field[] sourceFields = source.getClass().getDeclaredFields();
            for (Field sourceField : sourceFields) {
                sourceField.setAccessible(true);
                Object value = sourceField.get(source);
                try {
                    Field targetField = targetClass.getDeclaredField(sourceField.getName());
                    targetField.setAccessible(true);
                    targetField.set(target, value);
                } catch (Exception ignored) {
                    //igonre...
                }
            }
            return target;
        } catch (Exception e) {
            throw new MapperException("ErrorDTO mapping object");
        }
    }


}
