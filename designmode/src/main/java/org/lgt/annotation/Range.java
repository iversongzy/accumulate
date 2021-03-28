package org.lgt.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description
 * @Author liuguotai
 * @Date2021/1/27 10:59
 **/
@Target({
        ElementType.TYPE,
        ElementType.FIELD
})
@Retention(RetentionPolicy.RUNTIME)
public @interface Range {
    int order() default -1;

    int length() default -1;

    String type() default "";
}
