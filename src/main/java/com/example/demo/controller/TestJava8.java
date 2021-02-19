package com.example.demo.controller;

import com.example.demo.service.JavaFunctionsService;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description：TODO
 * @author     ：hzd
 * @date       ：2021-02-18 9:58
 */
@RestController()
@Data
@RequestMapping("java8")
public class TestJava8 {
    @Resource
    private JavaFunctionsService javaFunctionsService;

    @GetMapping("/testJava8")
    public void testJava8(){
        /*java8自带的常用函数式接口*/
        //Predicate test(T t) 判断真假
        javaFunctionsService.testPredicate();
        //Consumer accept(T t) 消费消息
        javaFunctionsService.testConsumer();
        //Function R apply(T t) 将T映射为R（转换功能）
        javaFunctionsService.testFunction();
        //Supplier T get() 生产消息
        javaFunctionsService.testSupplier();
    }

    @GetMapping("/collect")
    public void collect(){
        javaFunctionsService.testCollect();
     }
    @GetMapping("/filter")
    public void filter(){
        javaFunctionsService.testFilter();
     }

    @GetMapping("/maxAndMin")
    public void maxAndMin(){
        javaFunctionsService.testMaxAndMin();
    }

    @GetMapping("/count")
    public void count(){
        javaFunctionsService.testCount();
    }

    @GetMapping("/map")
    public void map(){
        javaFunctionsService.testMap();
    }


}
