package com.example.demo.controller;

import com.example.demo.pojo.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.Style;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description：TODO
 * @author     ：hzd
 * @date       ：2021-02-18 9:58
 */
@RestController
public class TestJava8 {

    @GetMapping("/testJava8")
    public void testJava8(){
        /*java8自带的常用函数式接口*/
        //Predicate test(T t) 判断真假
        Predicate<Integer> predicate  = x -> x>185;
        Student student = new Student("9龙",23,175);
        System.out.println("1------->9龙的身高超过185了么？："+predicate.test(student.getStature()));
        //Consumer accept(T t) 消费消息
        Consumer<String> consumer = System.out::println;
        consumer.accept("我命由我不由他");
        //Function R apply(T t) 将T映射为R（转换功能）
        Function<Student,String> function = Student::getName;
        String name = function.apply(student);
        System.out.println(name);
        //Supplier T get() 生产消息
        Supplier<Integer> supplier = () ->Integer.valueOf(BigDecimal.TEN.toString());
        System.out.println(supplier.get());


    }

    @GetMapping("/collect")
    public void collect(){
        List<Student> studentList = Stream.of(new Student("小一",22,158),
                new Student("小二",25,168),
                new Student("小三",21,176)).collect(Collectors.toList());
        System.out.println(studentList);
    }
    @GetMapping("/filter")
    public void filter(){
        List<Student> students = new ArrayList<>(3);
        students.add(new Student("小一",21,155));
        students.add(new Student("小二",22,185));
        students.add(new Student("小三",23,175));

        List<Student> list = students.stream().filter(s -> s.getStature()>180).collect(Collectors.toList());
        System.out.println(list);
    }

    @GetMapping("/maxAndMin")
    public void maxAndMin(){
        List<Student> students = new ArrayList<>(3);
        students.add(new Student("路飞", 22, 175));
        students.add(new Student("红发", 40, 180));
        students.add(new Student("白胡子", 50, 185));

        Optional<Student> max = students.stream().max(Comparator.comparing(stu -> stu.getStature()));
        System.out.println(max);

        Optional<Student> min = students.stream().min(Comparator.comparing(stu -> stu.getAge()));
        System.out.println(min);
    }

    @GetMapping("/count")
    public void count(){
        List<Student> students = new ArrayList<>(3);
        students.add(new Student("路飞", 22, 175));
        students.add(new Student("红发", 40, 180));
        students.add(new Student("白胡子", 50, 185));

        AtomicReference<Optional<Style>> style;
        students.sort(Comparator.comparing(s -> s.getAge()));

        long count = students.stream().filter(s -> s.getStature()>178).count();
        System.out.println(count);
    }


}
