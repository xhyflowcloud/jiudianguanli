package com.ccnu.xiahongyun.stmanagementsystem.mapper;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StudentExamroominfoMapper {
    @Select("select examroomid from studentexamroominfo where studentId = #{studentId} and subjectid =#{subjectId}")
    Integer findStudentExamroomById(@Param("studentId") Integer studentId, @Param("subjectId") Integer subjectId);

    @Insert("insert into  studentexamroominfo(examroomId, studentId, subjectId) values(#{examroomId}, #{studentId}, #{subjectId})")
    void insertStudentExamroomInfo(@Param("examroomId") Integer examroomId, @Param("studentId") Integer studentId, @Param("subjectId") Integer subjectId);

    @Delete("delete from  studentexamroominfo where studentId  = #{studentId} and subjectId = #{subjectId}")
    void deleteStudentExamroomById (@Param("studentId") Integer studentId,  @Param("subjectId") Integer subjectId);

}
