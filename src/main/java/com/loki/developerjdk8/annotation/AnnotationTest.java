package com.loki.developerjdk8.annotation;

import org.junit.Test;
import org.springframework.lang.NonNull;

import java.lang.reflect.Method;

/**
 * @ClassName AnnotationTest
 * @Desc 重复注解与类型注解
 * @Author xujs
 * @Date 2018/10/25 10:08
 * @Version 1.0
 */
public class AnnotationTest {

    // java8还不支持@NonNull，可利用checker framework框架
    private /*@NonNull*/ Object obj = null;

    @Test
    public void test() throws NoSuchMethodException {
        Class<AnnotationTest> clazz = AnnotationTest.class;
        Method m = clazz.getMethod("show");

        MyAnnotation[] mas = m.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation ma : mas) {
            System.out.println(ma.value());
        }
    }

    @MyAnnotation("Hello")
    @MyAnnotation("World")
    public void show(@MyAnnotation("aaa") String str) {

    }

}
