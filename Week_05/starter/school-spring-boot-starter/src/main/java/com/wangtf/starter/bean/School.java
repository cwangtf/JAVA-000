package com.wangtf.starter.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @author wangtf
 * @date 2021/2/16
 */
@Data
public class School implements ISchool {

    @Autowired
    Klass class1;

    @Resource
    Student student100;

    @Override
    public void ding() {

        System.out.println("Class1 have " + this.class1.getStudents().size() + " students and one is " + this.student100);

    }
}
