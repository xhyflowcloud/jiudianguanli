package com.ccnu.xiahongyun.stmanagementsystem.mapper;


import org.apache.ibatis.annotations.*;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository

public interface Subject {
    /*@Insert({"insert into subject( name, starttime,duration,number) values (#{name}, #{starttime},#{duration},#{number} )"})
    void insert();*/

    @Select({"select *from subject"})
    List<Subject> selectAll();

    @Select({"select *from subject where name = #{name}"})
    Subject selectByName(@Param("name") String name);
}
