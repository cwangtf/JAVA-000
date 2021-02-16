package com.wangtf.starter.config;

import com.wangtf.starter.bean.Klass;
import com.wangtf.starter.bean.School;
import com.wangtf.starter.bean.Student;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangtf
 * @date 2021/2/16
 */
@Configuration
@EnableConfigurationProperties({Klass.class, Student.class})
public class SchoolAutoConfiguration {

    @Bean
    public School school() {
        return new School();
    }
}
