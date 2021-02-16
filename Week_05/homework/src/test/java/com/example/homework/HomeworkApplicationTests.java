package com.example.homework;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
public class HomeworkApplicationTests {

    @BeforeAll
    public void init() {
        System.out.println("test begin...");
    }

    @AfterAll
    public void after() {
        System.out.println("test after...");
    }

}
