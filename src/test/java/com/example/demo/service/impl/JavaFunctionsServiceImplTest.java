package com.example.demo.service.impl;

import com.example.demo.service.JavaFunctionsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaFunctionsServiceImplTest  {
    @Autowired
    private JavaFunctionsService javaFunctionsService;

    @Test
    void testPredicate() {
        javaFunctionsService.testPredicate();
    }

    @Test
    void testConsumer() {
        javaFunctionsService.testConsumer();
    }

    @Test
    void testFunction() {
        javaFunctionsService.testFunction();
    }

    @Test
    void testSupplier() {
        javaFunctionsService.testSupplier();
    }

    @Test
    void testCollect() {
        javaFunctionsService.testCollect();
    }

    @Test
    void testCount() {
        javaFunctionsService.testCount();
    }

    @Test
    void testMaxAndMin() {
        javaFunctionsService.testMaxAndMin();
    }

    @Test
    void testFilter() {
        javaFunctionsService.testFilter();
    }

    @Test
    void testMap() {
        javaFunctionsService.testMap();
    }
}