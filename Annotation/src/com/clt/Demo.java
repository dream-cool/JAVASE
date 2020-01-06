package com.clt;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/**
 * 使用反射读取注解信息
 */
public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
       Class clz=Class.forName("com.clt.CltStudent");
        Annotation[] annotations=clz.getAnnotations();
        for (Annotation a:annotations
        ) {
            System.out.println(a);
        }
        Table t = (Table)clz.getAnnotation(Table.class);
        System.out.println(t.value());

        Field f=clz.getDeclaredField("studentName");
        Clt_Field clt_field=f.getAnnotation(Clt_Field.class);
        System.out.println(clt_field.columnName()+"--"+clt_field.type()+"--"+clt_field.legth());

    }
}
