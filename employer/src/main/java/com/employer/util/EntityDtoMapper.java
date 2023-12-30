package com.employer.util;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class EntityDtoMapper {

    private EntityDtoMapper() {

    }

    public static <D, E> E mapDtoToEntity(D dto, Class<E> entityClass) {
        E entity = instantiate(entityClass);
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    private static <T> T instantiate(Class<T> clazz) {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            throw new RuntimeException("Failed to instantiate DTO class", e);
        }
    }
}
