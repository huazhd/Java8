package com.example.demo.service.impl;

import com.example.demo.service.JavaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaServiceImplTest {
    @Autowired
    JavaService javaService;

    @Test
    void testJava7() {
        javaService.testJava7();
    }

    @Test
    void testStream() {
        javaService.testStream();
    }
}