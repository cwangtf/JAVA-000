package com.example.homework.class9.three.bean;

import lombok.Data;

/**
 * @author wangtf
 * @date 2021/2/15
 */
@Data
public class School implements ISchool {

    Klass class1;

    Student student100;

    @Override
    public void ding() {
        System.out.println("Class1 have " + this.class1.getStudents().size() + " students and one is " + this.student100);
    }
}
