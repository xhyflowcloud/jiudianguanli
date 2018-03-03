package com.ccnu.xiahongyun.stmanagementsystem.mapper;

import com.ccnu.xiahongyun.stmanagementsystem.model.Teacher;
import com.ccnu.xiahongyun.stmanagementsystem.query.SQLProvider;
import com.ccnu.xiahongyun.stmanagementsystem.query.TeacherQuery;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TeacherMapper {

    @Insert("insert into teacher(name, starttime,endtime,isInvigilator, numInvigilator, accInvigilator) values(#{name},#{starttime},#{endtime} ,#{isInvigilator}, #{numInvigilator}, #{accInvigilator})")
    void insertTeacher(Teacher teacher);

    @Update("update teacher set name = #{name}, starttime=#{starttime} , endtime=#{endtime},isInvigilator = #{isInvigilator}, numInvigilator = #{numInvigilator}, accInvigilator = #{accInvigilator} where id = #{id}")
    void updateTeacher(Teacher teacher);

    @Delete("delete from teacher where id = #{id}")
    void deleteTeacher(@Param("id") Integer id);

    @Select("select * from Teacher where id = #{id}")
    Teacher selectTeacherById(@Param("id") Integer id);

    @Select("select * from Teacher ")
    List<Teacher> selectAllTeacher();

    @Select("select * from Teacher where name = #{name}")
    Teacher selectTeacherByName(@Param("name") String name);

    @SelectProvider(type = SQLProvider.class, method = "selectTeacherCount")
    Integer findTeacherCount(TeacherQuery teacher);

    @SelectProvider(type = SQLProvider.class, method = "selectTeacher")
    List<Teacher> findTeacherByLimit(TeacherQuery teacher);

}
