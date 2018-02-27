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
 /*   id int AUTO_INCREMENT PRIMARY KEY ,
    name VARCHAR(20),
    starttime BIGINT,
    endtime BIGINT,
    bmstarttime BIGINT,
    bmendtime BIGINT,
    maxnumber int,
    minnumber int*/



    @Insert("insert into subject(name, starttime,endtime,bmstarttime,bmendtime,maxnumber,minnumber) values(#{name}, #{starttime} , #{endtime}, #{bmstarttime}, #{bmendtime}, #{maxnumber}, #{minnumber})")
    void insertSubject(@Param("name") String name, @Param("starttime") Long starttime,
                       @Param("endtime") Long endtime, @Param("bmstarttime") Long bmstarttime,
                       @Param("bmendtime") Long bmendtime,@Param("maxnumber") Integer maxnumber,
                       @Param("minnumber") Integer minnumber);

    @Update("update subject set starttime=#{starttime}, endtime=#{endtime}  where id = #{id}")
    void updateSubjectForTime( @Param("starttime") Long starttime,
                              @Param("endtime") Long endtime,@Param("id") Integer id);



    @Update("update subject set bmstarttime=#{bmstarttime} ,bmendtime=#{bmendtime} where id = #{id}")
    void updateSubjectForBMTime( @Param("bmstarttime") Long bmstarttime,
                                 @Param("bmendtime") Long bmendtime,@Param("id") Integer id);


    @Update("update subject set maxnumber=#{maxnumber},minnumber=#{minnumber} where id = #{id}")
    void updateSubjectForNumber( @Param("maxnumber") Long maxnumber,
                                 @Param("minnumber") Long minnumber,@Param("id") Integer id);

    @Update("update subject set name=#{name} where id = #{id}")
    void updateSubjectForName( @Param("name") Long name
                                 ,@Param("id") Integer id);


    @Delete("delete from subject where id = #{id}")
    void deleteSubject(@Param("id") Integer id);

    @Select("select * from where id = #{id}")
    Subject selectSubjectById(@Param("id") Integer id);


    @SelectProvider(type = SQLProvider.class, method = "selectSubject")
    List<Subject> findStudentByLimit(SubjectQuery subjectQuery);

    @SelectProvider(type = SQLProvider.class, method = "selectSubjectCount")
    Integer findStudentCount(SubjectQuery subjectQuery);
}
