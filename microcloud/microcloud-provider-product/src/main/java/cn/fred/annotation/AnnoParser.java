package cn.fred.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class AnnoParser {

    /**
     * 通过使用注解的对象，解析注解里的值
     * @param object
     */
    public static void parserAnnotation(Object object) {
        Class<?> class1 = object.getClass();
        Field[] fields = class1.getDeclaredFields();
        for(Field field : fields) {
            AnnoExample anno = field.getAnnotation(AnnoExample.class);
            try {
                if (anno != null) {
                    field.setAccessible(true);
                    String value = (String) field.get(object);
                    field.set(object, anno.name() + value);
                }
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * 通过注解对象里的所有注解，来设置成员的值
     * @param object
     */
    public static void parserAnnotation2(Object object) {
        Class<?> class1 = object.getClass();
        Field[] fields = class1.getDeclaredFields();
        for(Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof AnnoExample) {
                    String value;
                    try {
                        value = (String) field.get(object);
                        field.set(object, ((AnnoExample)annotation).name() + value);
                    } catch (IllegalArgumentException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
