package ru.t1consulting.test_task.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CounterControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private CounterController counterController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() throws Exception {
        Assertions.assertThat(counterController).isNotNull();
    }

    @Test
    void testRequest() throws Exception {
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/count?stringToCount=aaabbc", String.class))
                .isEqualTo("\"a\": 3, \"b\": 2, \"c\": 1");

        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/count?stringToCount=   ", String.class))
                .isEqualTo(null);
    }




}