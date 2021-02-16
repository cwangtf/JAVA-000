package com.example.homework.class9.two.xml;

import com.example.homework.class9.two.bean.Student;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangtf
 * @date 2021/2/15
 */
public class XmlDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/config/spring-bean.xml");
        Student student = beanFactory.getBean(Student.class);
        student.say();
        System.out.println(student);
    }
}
