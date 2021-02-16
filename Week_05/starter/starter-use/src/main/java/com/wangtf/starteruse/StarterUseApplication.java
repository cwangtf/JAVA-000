package com.wangtf.starteruse;

import com.wangtf.starter.bean.Klass;
import com.wangtf.starter.bean.School;
import com.wangtf.starter.bean.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Collections;

@SpringBootApplication
public class StarterUseApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(StarterUseApplication.class, args);

        Student student = applicationContext.getBean(Student.class);
        System.out.println(student.toString());
        Student student1 = student.create();
        Klass klass = applicationContext.getBean(Klass.class);
        klass.dong();
        School school = new School();
        klass.setStudents(Collections.singletonList(student1));
        school.setClass1(klass);
        school.setStudent100(student1);
        school.ding();
    }

}
