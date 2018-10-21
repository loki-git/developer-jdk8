package com.loki.developerjdk8.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

/**
 * @ClassName LambdaTest2
 * @Desc
 * @Author xujs
 * @Date 2018/10/21 12:29
 * @Version 1.0
 */
public class LambdaTest2 {

    List<Student> studentList = Arrays.asList(
            new Student("张三", 16, "男", 500),
            new Student("李丽", 17, "女", 450),
            new Student("王五", 19, "男", 530),
            new Student("赵六", 18, "男", 600),
            new Student("田七", 17, "女", 570)
    );

    @Test
    public void test1() {
        // 如果年龄相等，则按照名字比较，否则就按照年龄比较
        Collections.sort(studentList, (s1, s2) -> {
            if (s1.getAge() == s2.getAge()) {
                return s1.getName().compareTo(s2.getName());
            } else {
                return Integer.compare(s1.getAge(), s2.getAge());
            }
        });

        studentList.forEach(System.out::println);
    }

    @Test
    public void test2() {
        // 将字符串中所有的小写字母转换成大写
        System.out.println(strHandler("Lambda test2", s -> s.toUpperCase()));

        // 截取字符串位置2-5
        System.out.println(strHandler("Lambda test2", s -> s.substring(2, 5)));
    }

    public String strHandler(String str, MyFunction myFun) {
        return myFun.getValue(str);
    }

    @Test
    public void test3() {
        // 两数相加
        System.out.println(opNum(100l, 200l, (x, y) -> x + y));

        // 两数积
        System.out.println(opNum(10l, 50l, (x, y) -> x * y));
    }

    public Long opNum(Long l1, Long l2, MyNumFunction<Long, Long> myFun) {
        return myFun.getValue(l1, l2);
    }

}
