package com.ccnu.xiahongyun.stmanagementsystem.mapper;

import com.ccnu.xiahongyun.stmanagementsystem.model.StudentImformation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentInfoMapper {

    @Select("select * from studentinformation where examid = #{examid}")
    List<StudentImformation> findStudentInfoByExamid(@Param("examid") Integer examid);

    @Select("select * from studentinformation where sbid = #{sbid}")
    List<StudentImformation>  findStudentInfoBySbid(@Param("sbid") Integer sbid);

    @Insert("insert into studentinformation(examid, sbid) values(#{examid}, #{sbid})")
    void insertStudentInfo(@Param("examid") Integer examid, @Param("sbid") Integer sbid);

    @Delete("delete from studentinformation where examid = #{examid}")
    void deleteStudentInfoByExamid(@Param("examid") Integer examid);

    @Delete("delete from studentinformation where sbid = #{sbid}")
    void deleteStudentInfoBySbid(@Param("sbid") Integer sbid);

    @Delete("delete from studentinformation where examid = #{examid} and sbid = #{sbid}")
    void deleteStudentInfo(@Param("examid") Integer examid, @Param("sbid") Integer sbid);

}
