package com.ccnu.xiahongyun.stmanagementsystem.mapper;

import com.ccnu.xiahongyun.stmanagementsystem.model.StudentInformation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentInfoMapper {


    @Select("select * from studentinformation where studentId = #{studentId}")
    List<StudentInformation> findStudentInfoByStudentId(@Param("studentId") Integer studentId);

    @Select("select * from studentinformation where subjectId = #{subjectId}")
    List<StudentInformation>  findStudentInfoBySubjectId(@Param("subjectId") Integer subjectId);

    @Insert("insert into studentinformation(subjectId, studentId) values(#{subjectId}, #{studentId})")
    void insertStudentInfo(@Param("subjectId") Integer subjectId, @Param("studentId") Integer studentId);

    @Delete("delete from studentinformation where studentId  = #{studentId}")
    void deleteStudentInfoByStudentId (@Param("studentId") Integer studentId);

    @Delete("delete from studentinformation where subjectId = #{subjectId}")
    void deleteStudentInfoBySubjectId(@Param("subjectId") Integer subjectId);

    @Delete("delete from studentinformation where subjectId = #{subjectId} and studentId = #{studentId}")
    void deleteStudentInfo(@Param("subjectId") Integer subjectId, @Param("studentId") Integer studentId);

}
