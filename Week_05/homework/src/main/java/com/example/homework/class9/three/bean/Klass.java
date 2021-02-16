package com.example.homework.class9.three.bean;

import com.example.homework.class9.two.bean.Student;
import lombok.Data;

import java.util.List;

/**
 * @author wangtf
 * @date 2021/2/15
 */
@Data
public class Klass {

    List<Student> students;

    public void dong() {
        System.out.println(this.getStudents());
    }
}
