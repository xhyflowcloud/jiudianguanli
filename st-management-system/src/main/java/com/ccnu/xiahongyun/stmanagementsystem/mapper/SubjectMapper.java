package com.ccnu.xiahongyun.stmanagementsystem.mapper;

import com.ccnu.xiahongyun.stmanagementsystem.model.Subject;
import com.ccnu.xiahongyun.stmanagementsystem.query.SQLProvider;
import com.ccnu.xiahongyun.stmanagementsystem.query.SubjectQuery;
import org.apache.ibatis.annotations.*;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SubjectMapper {

    @Insert("insert into subject(name, starttime,endtime,bmstarttime,bmendtime,maxnumber,minnumber) values(#{name}, #{starttime} , #{endtime}, #{bmstarttime}, #{bmendtime}, #{maxnumber}, #{minnumber})")
    void insertSubject(Subject subject);

    @Update("update subject set minnumber = #{minnumber} where id = #{id}")
    void updateSubjectMinnumber(Subject subject);

    @Delete("delete from subject where id = #{id}")
    void deleteSubject(@Param("id") Integer id);

    @Select("select * from subject")
    List<Subject> selectAllSubject();

    @Select("select * from subject where id = #{id}")
    Subject selectSubjectById(@Param("id") Integer id);


    @SelectProvider(type = SQLProvider.class, method = "selectSubject")
    List<Subject> findSubjectByLimit(SubjectQuery subjectQuery);

    @SelectProvider(type = SQLProvider.class, method = "selectSubjectCount")
    Integer findSubjectCount(SubjectQuery subjectQuery);
}
