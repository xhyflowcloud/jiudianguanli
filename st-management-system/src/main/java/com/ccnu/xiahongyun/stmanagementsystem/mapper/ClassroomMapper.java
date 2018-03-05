package com.ccnu.xiahongyun.stmanagementsystem.mapper;

import com.ccnu.xiahongyun.stmanagementsystem.model.Classroom;
import com.ccnu.xiahongyun.stmanagementsystem.query.ClassroomQuery;
import com.ccnu.xiahongyun.stmanagementsystem.query.SQLProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClassroomMapper {

    @Select("select * from classroom")
    List<Classroom> selectAllClassroom();

    @Insert("insert into classroom( size,starttime, endtime,position, isEnable) values(#{size},#{starttime} ,#{endtime},#{position}, #{isEnable})")
    void insertClassroom(Classroom classroom);

    @Update("update classroom set size= #{size},starttime=#{starttime},endtime=#{endtime},position = #{position}, isEnable = #{isEnable} where id= #{id}")
    void updateClassroom(Classroom classroom);

    @Delete("delete from classroom where id = #{id}")
    void deleteClassroom(@Param("id") Integer id);

    @Select("select * from classroom where id = #{id}")
    Classroom findClassroomById(@Param("id") Integer id);

    @SelectProvider(type = SQLProvider.class, method = "selectClassroom")
    List<Classroom> findClassroomByLimit(ClassroomQuery classroom);

    @SelectProvider(type = SQLProvider.class, method = "selectClassroomCount")
    Integer findClassroomCount(ClassroomQuery classroom);

}
