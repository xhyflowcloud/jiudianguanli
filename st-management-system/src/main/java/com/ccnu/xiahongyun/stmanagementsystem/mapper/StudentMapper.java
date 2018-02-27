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
    @Select("select count(*) from classroom ")
    Integer findAllStudentCount();

    @Select("select * from student")
    List<Student> findAllStudent();

    @Select("select * from student where examid = #{examid}")
    Student findStudentById(@Param("examid") Integer examid);

    @Insert("insert into student (examid,name,id,sid) values (#{examid}, #{name}, #{id},#{sid}) ")
    void insertStudent(@Param("examid") Integer examid,@Param("name") String name,@Param("id") String id,@Param("sid") Integer sid);

    @Update("update student set name=#{name},id=#{id},sid=#{sid} where examid= #{examid}")
    void updateStudent(@Param("examid") Integer examid,@Param("name") String name,@Param("id") String id,@Param("sid") Integer sid);

    @Delete("delete from student where examid = #{examid}")
    void deleteStudent(@Param("examid") Integer examid);

    @SelectProvider(type = SQLProvider.class, method = "selectStudent")
    List<Student> findStudentByLimit(StudentQuery student);

}
