package com.example.homework.class9.one;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author wangtf
 * @date 2021/2/13
 */
public class DynamicBootstrap {

    public static void main(String[] args) {
        ExampleServiceImpl exampleService = new ExampleServiceImpl();
        ClassLoader classLoader = exampleService.getClass().getClassLoader();
        Class[] interfaces = exampleService.getClass().getInterfaces();
        InvocationHandler handler = new DynamicProxy(exampleService);

        ExampleService proxy = (ExampleService) Proxy.newProxyInstance(classLoader, interfaces, handler);
        proxy.info();
    }
}
