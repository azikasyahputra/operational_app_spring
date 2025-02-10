package com.demo.operational.utils;

import java.lang.reflect.Field;

public class EntityHelper {
    public static <T> void copyNonNullProperties(T existingEntity, T updatedEntity) {
        // Iterate through the fields of the updatedEntity and copy non-null values
        for (Field field : updatedEntity.getClass().getDeclaredFields()) {
            field.setAccessible(true);  // Make private fields accessible

            try {
                Object updatedValue = field.get(updatedEntity);
                if (updatedValue != null) {
                    field.set(existingEntity, updatedValue);  // Copy the non-null value
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();  // Handle the exception if needed
            }
        }
    }

    public static <T> T markAsDeleted(T entity) {
        try {
            Field deletedField = entity.getClass().getDeclaredField("deleted");
            deletedField.setAccessible(true);

            deletedField.set(entity, "Ya");

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
        return entity;
    }
}
