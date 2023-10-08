package com.stone.module5;

import com.stone.module5.dto.Student;
import com.stone.module5.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestStudentMapper {
    @Autowired
    StudentMapper studentMapper;

    @Test//测试的入口 测试查询所有
    public void test1() {
        System.out.println(1);
        List<Student> all = studentMapper.findAll();
        for (Student stu : all) {
//            System.out.println(stu.getId() + " " + stu.getName());
        }
    }

    @Test//测试的入口 测试根据id查询
    public void test2() {
        System.out.println(2);
        Student stu = studentMapper.findById(1);
//        System.out.println(stu.getId()+" "+stu.getName());
    }

    @Test
    public void test3() {
//        studentMapper.insert(6,"Qian Qi");
        Student stu=new Student(7,"Zhou Ba");
        studentMapper.insert(stu);
    }

    @Test
    public void test4() {
        Student stu=new Student(7,"Li Li");
        studentMapper.update(stu);
    }

    @Test
    public void test5() {
        studentMapper.delete(7);
    }
}
