package com.loki.developerjdk8.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName LambdaTest1
 * @Desc
 * @Author xujs
 * @Date 2018/10/21 12:25
 * @Version 1.0
 */
public class LambdaTest1 {

    List<Student> studentList = Arrays.asList(
            new Student("张三", 16, "男", 500),
            new Student("李丽", 17, "女", 450),
            new Student("王五", 19, "男", 530),
            new Student("赵六", 18, "男", 600),
            new Student("田七", 17, "女", 570)
    );

    @Test
    public void test1() {
        // 大于18岁的学生信息
        studentList.stream()
                .filter(student -> student.getAge() > 18)
                .forEach(System.out::println);

        // 分数大于500的学生信息
        studentList.stream()
                .filter(s -> s.getScore() > 500)
                .forEach(System.out::println);

        // 按照学生年龄排序输出年龄
        studentList.stream()
                .map(Student::getAge)
                .sorted()
                .forEach(System.out::println);

        // 按照学生成绩排序输出成绩
        List<Integer> newList = studentList.stream()
                .map(Student::getScore)
                .sorted()
                .collect(Collectors.toList());
        newList.forEach(System.out::println);
    }

}
