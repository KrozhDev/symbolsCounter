package ru.t1consulting.test_task.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CounterServiceTest {

    @Autowired
    private CounterService counterService;


    @Test
    void getStringCounting() {
        String test1 = "AaAbBc";

        String expected = "\"a\": 3, \"b\": 2, \"c\": 1";
        String actual = counterService.getStringCounting(test1);

        Assertions.assertEquals(expected,actual);
    }
}