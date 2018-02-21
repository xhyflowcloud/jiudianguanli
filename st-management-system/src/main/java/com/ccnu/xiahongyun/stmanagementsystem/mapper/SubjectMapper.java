package com.ccnu.xiahongyun.stmanagementsystem.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SubjectMapper {

    @Insert("insert into subject(name, datetime) values(#{name}, #{datetime})")
    void insertSubject(@Param("name") String name, @Param("datetime") Long datetime);

    @Update("update subject set name = #{name} where id = #{id}")
    void updateSubjectForName(@Param("id") Integer id, @Param("name") String name);

    @Update("update subject set datetime = #{datetime} where id = #{id}")
    void updateSubjectForDatetime(@Param("id") Integer id, @Param("datetime") String datetime);

    @Delete("delete from subject where id = #{id}")
    void daleteSubject(@Param("id") Integer id);

    @Select("select * from where id = #{id}")
    List<Subject> selectSubjectById(@Param("id") Integer id);

    @Select("select id from subject where name = #{name}")
    Integer getIdByName(@Param("name") String name);
}
