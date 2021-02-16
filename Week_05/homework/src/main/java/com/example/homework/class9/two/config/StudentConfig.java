package com.example.homework.class9.two.config;

import com.example.homework.class9.two.bean.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangtf
 * @date 2021/2/15
 */
@Configuration
public class StudentConfig {

    @Bean
    public Student student() {
        return new Student();
    }
}
