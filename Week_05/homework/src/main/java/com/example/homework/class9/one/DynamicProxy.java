package com.example.homework.class9.one;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wangtf
 * @date 2021/2/13
 */
public class DynamicProxy implements InvocationHandler {

    private Object object;

    public DynamicProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy before "  + method.getName());
        Object result = method.invoke(object, args);
        System.out.println("proxy after " + method.getName());
        return result;
    }
}
