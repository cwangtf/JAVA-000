package com.wangtf.starter.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

/**
 * @author wangtf
 * @date 2021/2/16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Configuration
@ConfigurationProperties(prefix = "student")
public class Student implements Serializable {

    private int id;
    private String name;

    public void init(){
        System.out.println("hello...........");
    }

    public Student create(){
        return new Student(101,"KK101");
    }

}
