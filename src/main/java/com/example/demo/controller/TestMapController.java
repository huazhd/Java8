package com.example.demo.controller;

import com.example.demo.pojo.People;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description：Test java8 stream map
 * @author     ：hzd
 * @date       ：2021-01-27 11:27
 */
@RestController
public class TestMapController {
   @GetMapping("/testStreamMap")
    public void testMap(){
       List<People> peopleList = new ArrayList<People>();
       peopleList.add(new People(1,"张三","男",38));
       peopleList.add(new People(2,"小小","女",2));
       peopleList.add(new People(3,"李四","男",65));
       peopleList.add(new People(4,"王五","女",20));
       peopleList.add(new People(5,"赵六","男",38));
       peopleList.add(new People(6,"大大","男",65));

       List<String> names = peopleList.stream().map(s -> s.getName()).collect(Collectors.toList());

       names.forEach(System.out::println);

   }
}
