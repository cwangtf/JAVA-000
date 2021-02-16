package com.example.homework.class9.two.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author wangtf
 * @date 2021/2/15
 */
@Data
@Component
public class Student {

    private int id;

    private String name;

    public void say() {
        System.out.println("This is a student");
    }
}
