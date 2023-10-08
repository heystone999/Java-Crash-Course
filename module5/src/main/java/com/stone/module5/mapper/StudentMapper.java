package com.stone.module5.mapper;

import com.stone.module5.dto.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper//这是一个专用于CURD的接口
//实现类(mybatis和spring),可以通过@Autowired依赖注入获取实现类对象
public interface StudentMapper {
    @Select("""
            select id, name
            from student
            """)
    List<Student> findAll();

    @Select("""
            select id, name
            from student
            where id=#{id}
            """)
    Student findById(int id);

    /*@Insert("""
            insert into student(id,name)
            values (#{id},#{name})
            """)
    void insert(@Param("id") int i, @Param("name") String n);*/

    @Insert("""
            insert into student(id,name)
            values (#{id},#{name})
            """)
    void insert(Student stu);

    @Update("""
            update student set name=#{name}
            where id=#{id}
            """)
    void update(Student stu);

    @Delete("""
            delete from student where id=#{id}
            """)
    void delete(int id);
}
