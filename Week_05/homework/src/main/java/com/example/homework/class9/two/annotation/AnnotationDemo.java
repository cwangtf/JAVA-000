package com.example.homework.class9.two.annotation;

import com.example.homework.class9.two.bean.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangtf
 * @date 2021/2/15
 */
@Configuration
public class AnnotationDemo {

    public static void main(String[] args) {

    }

    @Bean(name = "student")
    public Student student() {
        return new Student();
    }
}
