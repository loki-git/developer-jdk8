package com.loki.developerjdk8.stream;

import com.loki.developerjdk8.lambda.Student;
import com.loki.developerjdk8.lambda.Student.Status;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 3、终止操作（终端操作）
 */
public class StreamTest5 {

    List<Student> stus = Arrays.asList(
            new Student("张三", 16, "男", 500, Student.Status.BUSY),
            new Student("李丽", 17, "女", 450, Student.Status.FREE),
            new Student("王五", 19, "男", 530, Student.Status.FREE),
            new Student("赵六", 18, "男", 600, Student.Status.VOCATION),
            new Student("田七", 17, "女", 570, Student.Status.BUSY),
            new Student("田七", 17, "女", 570, Student.Status.BUSY)
    );

    /**
     * 归约
     * reduce(T identity, BinaryOperator) / reduce(BinaryOperator):可以将流中元素反复结合起来,得到一个流
     */
    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Integer num = list.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println(num);

        Optional<Integer> op = stus.stream()
                .map(Student::getScore)
                .reduce(Integer::sum);
        System.out.println(op.get());
    }

    /**
     * 收集
     * collect:将流转换为其他形式.接收一个Collector接口的实现,用于给Stream中元素做汇总的方法
     */
    @Test
    public void test2() {
        stus.stream()
                .map(Student::getName)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("-------------------------------------------------");

        stus.stream()
                .map(Student::getName)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("-------------------------------------------");

        stus.stream()
                .map(Student::getName)
                .collect(Collectors.toCollection(HashSet::new))
                .forEach(System.out::println);
    }

    @Test
    public void test3() {
        // 总数
        Long count = stus.stream()
                .collect(Collectors.counting());
        System.out.println(count);

        System.out.println("----------------------------------------");

        // 平均值
        Double avg = stus.stream()
                .collect(Collectors.averagingDouble(Student::getScore));
        System.out.println(avg);

        // 总和
        Double s = stus.stream()
                .collect(Collectors.summingDouble(Student::getScore));
        System.out.println(s);

        // 最大值
        Optional<Student> op = stus.stream()
                .collect(Collectors.maxBy((s1, s2) -> Integer.compare(s1.getScore(), s2.getScore())));
        System.out.println(op.get());

        // 最小值
        Optional<Integer> op1 = stus.stream()
                .map(Student::getScore)
                .collect(Collectors.minBy(Integer::compare));
        System.out.println(op1.get());
    }

    @Test
    public void test4() {
        // 分组
        Map<Status, List<Student>> map = stus.stream()
                .collect(Collectors.groupingBy(Student::getStatus));
        System.out.println(map);

        // 多级分组
        Map<Status, Map<String, List<Student>>> map1 = stus.stream()
                .collect(Collectors.groupingBy(Student::getStatus, Collectors.groupingBy(s -> {
                    if (((Student) s).getScore() <= 500) {
                        return "C";
                    } else if (((Student) s).getScore() < 600) {
                        return "B";
                    } else {
                        return "A";
                    }
                })));

        System.out.println(map1);
    }

    // 分区
    @Test
    public void test5() {
        Map<Boolean, List<Student>> map = stus.stream()
                .collect(Collectors.partitioningBy(s -> "男".equals(s.getSex())));
        System.out.println(map);
    }

    @Test
    public void test6() {
        DoubleSummaryStatistics dss = stus.stream()
                .collect(Collectors.summarizingDouble(Student::getScore));
        System.out.println(dss.getCount());
        System.out.println(dss.getMax());
        System.out.println(dss.getMin());
        System.out.println(dss.getAverage());
        System.out.println(dss.getSum());
    }

    @Test
    public void test7() {
        String str = stus.stream()
                .map(Student::getName)
                .collect(Collectors.joining(",", "姓名:", "."));
        System.out.println(str);
    }

}
