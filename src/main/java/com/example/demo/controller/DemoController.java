package com.example.demo.controller;

import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：hzd
 * @description：
 * @date ：2021/1/20 0020 16:30
 */
@RestController
public class DemoController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/testJava7")
    public void testJava7(){
        List<String> myList = Arrays.asList("a1","a2","b1","b2","c1","c2","c3");
        List<String> newList = new ArrayList<>();
        for (String s : myList) {
            if(s.contains("c")){
                newList.add(s);
            }
        }
        List<String> newList2 = new ArrayList<>();
        for (String s : newList) {
            s.toUpperCase();
            newList2.add(s);

        }
        //java8
        newList2.sort(String::compareTo);
        for (String s : newList2) {
            System.out.println(s);
        }
    }

    @GetMapping("/testJava8Stream")
    public void testJava8Stream(){
        List<String> myList = Arrays.asList("a1","a2","b1","b2","c1","c2","c3");
        //创建流
        myList.stream()
                //执行过滤
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

    }
}
