package com.wangtf.starter.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author wangtf
 * @date 2021/2/16
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "klass")
public class Klass {

    List<Student> students;

    public void dong() {
        System.out.println(this.getStudents());
    }
}
