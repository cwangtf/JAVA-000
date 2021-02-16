package com.example.homework.class9.three;

import com.example.homework.class9.three.bean.School;
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
@ContextConfiguration(value = "classpath:/config/spring-context.xml")
public class XmlTest {

    @Resource
    private School school;

    @Test
    public void test() {
        System.out.println(school.toString());
    }
}
