package com.example.homework.class9.one;

import com.example.homework.HomeworkApplicationTests;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author wangtf
 * @date 2021/2/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class DynamicProxyTest extends HomeworkApplicationTests {

    @Test
    public void test() {
        ExampleServiceImpl exampleService = new ExampleServiceImpl();
        ClassLoader classLoader = exampleService.getClass().getClassLoader();
        Class[] interfaces = exampleService.getClass().getInterfaces();
        InvocationHandler handler = new DynamicProxy(exampleService);

        ExampleService proxy = (ExampleService) Proxy.newProxyInstance(classLoader, interfaces, handler);
        proxy.info();
    }
}
