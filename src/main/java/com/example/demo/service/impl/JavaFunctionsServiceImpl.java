package com.example.demo.service.impl;

import com.example.demo.pojo.People;
import com.example.demo.pojo.Student;
import com.example.demo.service.JavaFunctionsService;
import org.springframework.stereotype.Service;

import javax.swing.text.Style;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ：hzd
 * @description：
 * @date ：2021/2/19 0019 10:12
 */
@Service
public class JavaFunctionsServiceImpl implements JavaFunctionsService {
    Student student = new Student("9龙",23,175);
    @Override
    public void testPredicate() {
        Predicate<Integer> predicate  = x -> x>185;
        Student student = new Student("9龙",23,175);
        System.out.println("1------->9龙的身高超过185了么？："+predicate.test(student.getStature()));
    }

    @Override
    public void testConsumer() {
        Consumer<String> consumer = System.out::println;
        consumer.accept("我命由我不由他");
    }

    @Override
    public void testFunction() {
        Function<Student,String> function = Student::getName;
        String name = function.apply(student);
        System.out.println(name);
    }

    @Override
    public void testSupplier() {
        Supplier<Integer> supplier = () ->Integer.valueOf(BigDecimal.TEN.toString());
        System.out.println(supplier.get());
    }

    @Override
    public void testCollect() {
        List<Student> studentList = Stream.of(new Student("小一",22,158),
                new Student("小二",25,168),
                new Student("小三",21,176)).collect(Collectors.toList());
        System.out.println(studentList);
    }

    @Override
    public void testCount() {
        List<Student> students = new ArrayList<>(3);
        students.add(new Student("小一",21,155));
        students.add(new Student("小二",22,185));
        students.add(new Student("小三",23,175));

        List<Student> list = students.stream().filter(s -> s.getStature()>180).collect(Collectors.toList());
        System.out.println(list);
    }

    @Override
    public void testMaxAndMin() {
        List<Student> students = new ArrayList<>(3);
        students.add(new Student("路飞", 22, 175));
        students.add(new Student("红发", 40, 180));
        students.add(new Student("白胡子", 50, 185));

        Optional<Student> max = students.stream().max(Comparator.comparing(stu -> stu.getStature()));
        System.out.println(max);

        Optional<Student> min = students.stream().min(Comparator.comparing(stu -> stu.getAge()));
        System.out.println(min);
    }

    @Override
    public void testFilter() {
        List<Student> students = new ArrayList<>(3);
        students.add(new Student("路飞", 22, 175));
        students.add(new Student("红发", 40, 180));
        students.add(new Student("白胡子", 50, 185));

        AtomicReference<Optional<Style>> style;
        students.sort(Comparator.comparing(s -> s.getAge()));

        long count = students.stream().filter(s -> s.getStature()>178).count();
        System.out.println(count);
    }

    @Override
    public void testMap() {
        List<People> peopleList = new ArrayList<People>();
        peopleList.add(new People(1,"张三","男",38));
        peopleList.add(new People(2,"小小","女",2));
        peopleList.add(new People(3,"李四","男",65));
        peopleList.add(new People(4,"王五","女",20));
        peopleList.add(new People(5,"赵六","男",38));
        peopleList.add(new People(6,"大大","男",65));

        List<String> names = peopleList.stream().map(People::getName).collect(Collectors.toList());

        names.forEach(System.out::println);
    }
}
