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

    @Select("select max(sid) from student")
    Integer findMaxStudentSid();

    @Select("select * from student where id = #{id}")
    List<Student> findStudentById(@Param("id") String id);

    @Select("select * from student where sid = #{sid}")
    Student findStudentBysId(@Param("sid") Integer sid);

    @Select("select sid from student where id = #{id}")
    List<Integer> findSidBysId(@Param("id") String id);

    @Select("select subjectid from student where id = #{id}")
    List<Integer> findSubjectidBysId(@Param("id") String id);

    @Select("select sid from student where subjectid = #{subjectid}")
    List<Integer> findSidBySubjectId(@Param("subjectid") Integer subjectid);

    @Insert("insert into student (name,id,sid,subjectid) values ( #{name}, #{id},#{sid},#{subjectid}) ")
    void insertStudent(Student student);


    @Update("update student set name=#{name},id=#{id},subjectid=#{subjectid} where sid= #{sid}")
    void updateStudent(Student student);

    @Select("select * from  student where subjectid = #{subjectid} and sid not in (select studentid from studentexamroominfo)")
    List<Student> selectStudentNoExamroom(@Param("subjectid") Integer subjectid);

    @Delete("delete from student where sid = #{sid}")
    void deleteStudent(@Param("sid") Integer sid);

    @SelectProvider(type = SQLProvider.class, method = "selectStudent")
    List<Student> findStudentByLimit(StudentQuery student);

    @SelectProvider(type = SQLProvider.class, method = "selectStudentCount")
    Integer findStudentCount(StudentQuery student);

}
