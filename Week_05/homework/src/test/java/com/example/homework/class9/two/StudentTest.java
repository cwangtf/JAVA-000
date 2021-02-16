package com.example.homework.class9.two;

import com.example.homework.class9.two.bean.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author wangtf
 * @date 2021/2/15
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(value = "classpath:/config/spring-bean.xml")
//@ContextConfiguration(classes = StudentConfig.class)
@ContextConfiguration(value = "classpath:/config/spring-config.xml")
public class StudentTest {

    @Resource
    private Student student;

    @Test
    public void test() {
        student.say();
    }
}
