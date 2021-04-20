package org.lgt.annotation;

import java.lang.reflect.Method;

/**
 * @Description
 * @Author liuguotai
 * @Date2021/1/27 11:04
 **/

@Range(length = 100)
public class Hello {

    @Range(order = 111)
    public String name = "aaa";


    public static void main(String[] args) {
        Hello hello = new Hello();
        boolean annotationPresent = hello.getClass().isAnnotationPresent(Range.class);
        if(annotationPresent) {
            Range annotation = hello.getClass().getAnnotation(Range.class);
            System.out.println(annotation.length());
        }
        Method[] declaredMethods = hello.getClass().getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if(declaredMethod.isAnnotationPresent(Range.class)) {
                Range annotation = declaredMethod.getAnnotation(Range.class);
                System.out.println(annotation.order());
            }
        }
    }
}
