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

    @Select("select * from classroom ")
    List<Classroom> findAllClassroom();

    @Select("select * from classroom where id = #{id}")
    Classroom findClassroomById(@Param("id") Integer id);

    @Insert("insert into classroom( size, position, isEnable) values(#{size}, #{position}, #{isEnable})")
    void insertClassroom(@Param("size") Integer size,@Param("position") String position, @Param("isEnable") Boolean isEnable);

    @Update("update classroom set size= #{size},position = #{position}, isEnable = #{isEnable} where id= #{id}")
    void updateClassroom(@Param("size") Integer size,@Param("position") String position, @Param("isEnable") Boolean isEnable, @Param("id") Integer id);

    @Delete("delete from classroom where id = #{id}")
    void deleteClassroom(@Param("id") Integer id);

    @SelectProvider(type = SQLProvider.class, method = "selectClassroom")
    List<Classroom> findClassroomByLimit(ClassroomQuery classroom);

}
