package com.loki.developerjdk8.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 一、Lambda 表达式基础语法：Java8中引入了一个新的操作符"->"该操作符称为箭头操作符或Lambda操作符
 * 箭头操作符将Lambda表达式拆分成两部分：
 * <p>
 * 左侧：Lambda表达式的参数列表
 * 右侧：Lambda表达式所需要执行的功能，即Lambda体
 * <p>
 * 语法格式一：无参数，无返回值 () -> System.out.println("Hello World!");
 * 语法格式二：有一个参数，无返回值 x -> System.out.println(x);
 * 语法格式三：若只有一个参数，则小括号可以省略不写
 * 语法合适四：有两个以上的参数，有返回值的，并且Lambda体中有多条语句
 * 语法格式五：若Lambda体中只有一条语句，则大括号和return都可以省略不写
 * 语法格式六：Lambda表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出数据类型，即"类型推断"
 * <p>
 * 二、Lambda表达式需要"函数式接口"的支持
 * 函数式接口：接口中只有一个抽象方法的接口，称为函数式接口，可以使用注解@FuncationalInterface 修饰
 * 可以检查是否是函数式接口
 */
public class LambdaTest3 {

    @Test
    public void test1() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Lambda!");
            }
        };

        r.run();

        Runnable r1 = () -> System.out.println("Hello Lambda!");
        r1.run();
    }

    @Test
    public void test2() {
        Consumer<String> con = s -> System.out.println(s);
        con.accept("Hello Lambda!");
    }

    @Test
    public void test3() {
        Comparator<Integer> com = (x, y) -> {
            System.out.println("Hello Lambda!");
            return Integer.compare(x, y);
        };
    }

    @Test
    public void test4() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
    }

    @Test
    public void test5() {
        System.out.println(operation(100, x -> x * 200));

        System.out.println(operation(500, x -> x + 100));
    }

    public Integer operation(Integer num, MyFun mf){
        return mf.getValue(num);
    }

}
