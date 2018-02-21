package com.ccnu.xiahongyun.stmanagementsystem.mapper;

import com.ccnu.xiahongyun.stmanagementsystem.model.Teacher;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TeacherMapper {

    @Insert("insert into teacher(name, isInvigilator, numInvigilator, accInvigilator) values(#{name}, #{isInvigilator}, #{numInvigilator}, #{accInvigilator})")
    void insertTeacher(@Param("name") String name, @Param("isInvigilator") Boolean isInvigilator, @Param("numInvigilator") Integer numInvigilator, @Param("accInvigilator") Integer accInvigilator);

    @Update("update teacher set name = #{name}, isInvigilator = #{isInvigilator}, numInvigilator = #{numInvigilator}, accInvigilator = #{accInvigilator} where id = #{id}")
    void updateTeacher(@Param("id") Integer id, @Param("name") String name, @Param("isInvigilator") Boolean isInvigilator, @Param("numInvigilator") Integer numInvigilator, @Param("accInvigilator") Integer accInvigilator);

    @Delete("delete from teacher where id = #{id}")
    void deleteTeacher(@Param("id") Integer id);

    @Select("select * from Teacher where id = #{id}")
    List<Teacher> selectTeacherById(@Param("id") Integer id);
}
