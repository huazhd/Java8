package com.example.demo.service.impl;

import com.example.demo.service.JavaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：hzd
 * @description：
 * @date ：2021/2/19 0019 10:05
 */
@Service
public class JavaServiceImpl  implements JavaService {
    @Override
    public void testJava7() {
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

    @Override
    public void testStream() {
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
