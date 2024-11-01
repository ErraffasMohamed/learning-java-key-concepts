package reflection;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;


import java.lang.reflect.Array;
public class XMLSerializer {

    public static <T> void serializeToXML(List<T> objects) {
        if (objects == null || objects.isEmpty()) {
            System.out.println("The object list is empty.");
            return;
        }

        Class<?> clazz = objects.get(0).getClass();
        String className = clazz.getSimpleName();
        String fileName = className + ".xml";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("<" + className + "s>\n");

            for (T obj : objects) {
                writer.write("  <" + className + ">\n");
                serializeObject(obj, clazz, writer, "    ");
                writer.write("  </" + className + ">\n");
            }

            writer.write("</" + className + "s>");
            System.out.println("XML file created: " + fileName);

        } catch (IOException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void serializeObject(Object obj, Class<?> clazz, FileWriter writer, String indent)
            throws IOException, IllegalAccessException {
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            Object fieldValue = field.get(obj);

            if (fieldValue == null) {
                writer.write(indent + "<" + field.getName() + ">null</" + field.getName() + ">\n");
            } else if (isPrimitiveOrWrapper(field.getType()) || fieldValue instanceof String) {
                writer.write(indent + "<" + field.getName() + ">" + fieldValue + "</" + field.getName() + ">\n");
            } else if (fieldValue.getClass().isArray()) {
                // Handle array
                writer.write(indent + "<" + field.getName() + "s>\n");
                int length = Array.getLength(fieldValue);
                for (int i = 0; i < length; i++) {
                    Object arrayElement = Array.get(fieldValue, i);
                    writer.write(indent + "  <item>\n");
                    serializeObject(arrayElement, arrayElement.getClass(), writer, indent + "    ");
                    writer.write(indent + "  </item>\n");
                }
                writer.write(indent + "</" + field.getName() + "s>\n");
            } else if (fieldValue instanceof List) {
                // Handle list
                writer.write(indent + "<" + field.getName() + "s>\n");
                for (Object listItem : (List<?>) fieldValue) {
                    writer.write(indent + "  <item>\n");
                    serializeObject(listItem, listItem.getClass(), writer, indent + "    ");
                    writer.write(indent + "  </item>\n");
                }
                writer.write(indent + "</" + field.getName() + "s>\n");
            } else {
                // Nested object
                writer.write(indent + "<" + field.getName() + ">\n");
                serializeObject(fieldValue, fieldValue.getClass(), writer, indent + "  ");
                writer.write(indent + "</" + field.getName() + ">\n");
            }
        }
    }

    private static boolean isPrimitiveOrWrapper(Class<?> type) {
        return type.isPrimitive() ||
                type == Integer.class || type == Long.class || type == Double.class ||
                type == Float.class || type == Boolean.class || type == Character.class ||
                type == Byte.class || type == Short.class;
    }
}
