package com.simple.designpatterns.pattern23.structuretype.proxy.one.annotation;

import java.lang.annotation.*;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-06-27 12:53
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Select {
    /**
     * sql
     * @return
     */

    String value() default "";
}
