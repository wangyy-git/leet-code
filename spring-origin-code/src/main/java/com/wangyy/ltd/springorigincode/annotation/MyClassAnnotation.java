package com.wangyy.ltd.springorigincode.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import(ImportAnn.class)
public @interface MyClassAnnotation {
    String[] value() default {};
}
