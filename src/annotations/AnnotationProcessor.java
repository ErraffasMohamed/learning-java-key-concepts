package annotations;

import java.lang.reflect.Field;

public class AnnotationProcessor {

    // Method to inspect any class for the @Entity annotation
    public static <T> void inspectClassAnnotations(Class<T> clazz) {
        if (clazz.isAnnotationPresent(Entity.class)) {
            Entity entityAnnotation = clazz.getAnnotation(Entity.class);
            System.out.println("Class: " + clazz.getSimpleName());
            System.out.println("Table Name: " + entityAnnotation.tableName());

            // Process each field to check for @Column annotation
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Column.class)) {
                    Column columnAnnotation = field.getAnnotation(Column.class);
                    System.out.println("Field: " + field.getName());
                    System.out.println(" - Column Name: " + columnAnnotation.columnName());
                    System.out.println(" - Primary Key: " + columnAnnotation.isPrimaryKey());
                }
            }
        } else {
            System.out.println("Class " + clazz.getSimpleName() + " is not annotated with @Entity.");
        }
    }
}

