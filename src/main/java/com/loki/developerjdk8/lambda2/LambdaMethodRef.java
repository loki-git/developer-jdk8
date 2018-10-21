package com.loki.developerjdk8.lambda2;

import com.loki.developerjdk8.lambda.Student;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

/**
 * 一、方法引用:若Lambda体中的内容有方法已经实现了，我们可以使用"方法引用"
 *         (可以理解为方法引用是Lambda表达式的另外一种表现形式)
 *
 * 主要有三种语法格式:
 * 对象::实例方法名
 * 类::静态方法名
 * 类::实例方法名
 *
 * 注:
 * ①Lambda体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致!
 * ②若Lambda参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数时，可以使用ClassName::method
 *
 * 二、构造器引用
 * 格式：ClassName::new
 *
 * 注:需要调用的构造器的参数列表要与函数式接口中抽象方法的参数列表保持一致！
 *
 * 三、数组引用
 * 格式：Type::new
 *
 */
public class LambdaMethodRef {

    // 对象::实例方法名
    @Test
    public void test1() {
        Consumer<String> con = s -> System.out.println(s);
        con.accept("abcdef");

        Consumer<String> con1 = System.out::println;
        con1.accept("123456");

        PrintStream ps = System.out;
        Consumer<String> con2 = ps::println;
        con2.accept("this is Lambda");
    }

    @Test
    public void test2() {
        Student stu = new Student();
        stu.setAge(18);
        stu.setName("Lambda");

        Supplier<String> su = () -> stu.getName();
        System.out.println(su.get());

        Supplier<Integer> su1 = stu::getAge;
        Integer n = su1.get();
        System.out.println(n);
    }

    // 类::静态方法名
    @Test
    public void test3() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);

        Comparator<Integer> com1 = Integer::compare;
    }

    // 类::实例方法名
    @Test
    public void test4() {
        BiPredicate<String, String> b = (x, y) -> x.equals(y);

        BiPredicate<String, String> b2 = String::equals;
    }

    // 构造器引用
    @Test
    public void test5() {
        Supplier<Student> su = () -> new Student();

        Supplier<Student> su1 = Student::new; // 构造器引用方式
    }

    @Test
    public void test6() {
        Function<Integer, Student> fun = x -> new Student(x);
        Function<Integer, Student> fun1 = Student::new;
        System.out.println(fun1.apply(101));

        BiFunction<Integer, Integer, Student> fun2 = Student::new;
    }

    // 数组引用
    @Test
    public void test7() {
        Function<Integer, String[]> fun = s -> new String[s];
        System.out.println(fun.apply(10).length);

        Function<Integer, String[]> fun1 = String[]::new;
    }

}
