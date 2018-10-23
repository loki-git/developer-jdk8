package com.loki.developerjdk8.stream;

import com.loki.developerjdk8.lambda.Student;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 一、Stream的三个操作步骤
 * 1、创建Stream
 * 2、中间操作
 * 3、终止操作（终端操作）
 */
public class StreamTest3 {

    List<Student> list = Arrays.asList(
            new Student("张三", 16, "男", 500),
            new Student("李丽", 17, "女", 450),
            new Student("王五", 19, "男", 530),
            new Student("赵六", 18, "男", 600),
            new Student("田七", 17, "女", 570)
    );

    // 中间操作
    /**
     * sorted():自然排序Comparable
     * sorted(Comparator com):定制排序 Comparator
     */
    @Test
    public void test1() {
        List<String> li = Arrays.asList("dd", "cc", "aa", "ee", "bb");

        li.stream()
                .sorted()
                .forEach(System.out::println);

        list.stream()
                .sorted((s1, s2) -> {
                    if (s1.getAge() == s2.getAge()) {
                        return s1.getName().compareTo(s2.getName());
                    } else {
                        return Integer.compare(s1.getAge(), s2.getAge());
                    }
                })
                .forEach(System.out::println);
    }

}
