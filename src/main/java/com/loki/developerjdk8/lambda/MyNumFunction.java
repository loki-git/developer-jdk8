package com.loki.developerjdk8.lambda;

/**
 * @Author xujs
 * @Description 自定义函数式接口
 */
@FunctionalInterface
public interface MyNumFunction<T, R> {

    public R getValue(T t1, T t2);

}
