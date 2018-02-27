package com.ccnu.xiahongyun.stmanagementsystem.mapper;

import com.ccnu.xiahongyun.stmanagementsystem.model.Student;
import com.ccnu.xiahongyun.stmanagementsystem.query.SQLProvider;
import com.ccnu.xiahongyun.stmanagementsystem.query.StudentQuery;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {



    @Select("select * from student")
    List<Student> findAllStudent();

    @Select("select * from student where sid = #{sid}")
    Student findStudentBysId(@Param("sid") Integer sid);

    @Insert("insert into student (name,id,sid) values ( #{name}, #{id},#{sid}) ")
    void insertStudent(@Param("name") String name,@Param("id") String id,@Param("sid") Integer sid);


    @Update("update student set name=#{name},id=#{id} where sid= #{sid}")
    void updateStudent(@Param("name") String name,@Param("id") String id,@Param("sid") Integer sid);

    @Delete("delete from student where sid = #{sid}")
    void deleteStudent(@Param("sid") Integer sid);

    @SelectProvider(type = SQLProvider.class, method = "selectStudent")
    List<Student> findStudentByLimit(StudentQuery student);

    @SelectProvider(type = SQLProvider.class, method = "selectStudentCount")
    Integer findStudentCount(StudentQuery student);

}
