package com.employer.util;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class EntityDtoMapper {

    private EntityDtoMapper() {

    }

    public static <D, E> D mapEntityToDto(E entity, Class<D> dtoClass) {
        D dto = instantiateDto(dtoClass);
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    private static <T> T instantiateDto(Class<T> dtoClass) {
        try {
            return dtoClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            throw new RuntimeException("Failed to instantiate DTO class", e);
        }
    }
}
