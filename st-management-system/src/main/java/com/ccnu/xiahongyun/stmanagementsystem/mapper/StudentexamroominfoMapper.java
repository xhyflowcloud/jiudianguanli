package com.ccnu.xiahongyun.stmanagementsystem.mapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.Studentexamroominfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentexamroominfoMapper {
    @Select("select * from studentexamroominfo where studentId = #{studentId}")
    List<Studentexamroominfo> findStuexamByStudentId(@Param("studentId") Integer studentId);

    @Select("select * from studentexamroominfo where examroomId = #{examroomId}")
    List<Studentexamroominfo>  findStuexamByExamroomId(@Param("examroomId") Integer examroomId);

    @Insert("insert into  studentexamroominfo(examroomId, studentId) values(#{examroomId}, #{studentId})")
    void insertStuexam(@Param("examroomId") Integer examroomId, @Param("studentId") Integer studentId);

    @Delete("delete from  studentexamroominfo where studentId  = #{studentId}")
    void deleteStuexamByStudentId (@Param("studentId") Integer studentId);

    @Delete("delete from  studentexamroominfo where examroomId = #{examroomId}")
    void deleteStuexamByExamroomId(@Param("examroomId") Integer examroomId);

    @Delete("delete from  studentexamroominfo where subjectId = #{subjectId} and studentId = #{studentId}")
    void deleteStuexam(@Param("subjectId") Integer subjectId, @Param("studentId") Integer studentId);

}
