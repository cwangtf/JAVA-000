package com.example.homework.class9;

import com.example.homework.class9.three.XmlTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * @author wangtf
 * @date 2021/2/15
 */
public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(XmlTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println("测试结果：" + result.wasSuccessful());
    }
}
