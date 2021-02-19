package com.example.demo.controller;

import com.example.demo.service.JavaService;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author ：hzd
 * @description：
 * @date ：2021/1/20 0020 16:30
 */
@RestController()
@Data
@RequestMapping("demo")

public class DemoController {

    @Resource
    private JavaService javaService;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/testJava7")
    public void testJava7(){
        javaService.testJava7();
    }

    @GetMapping("/testJava8Stream")
    public void testJava8Stream(){
        javaService.testStream();
    }
}
