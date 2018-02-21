package com.ccnu.xiahongyun.stmanagementsystem.mapper;

import com.ccnu.xiahongyun.stmanagementsystem.model.Classroom;
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

    @Insert("insert into classroom( size, position) values(#{size}, #{position} )")
    void insertClassroom(@Param("size") Integer size,@Param("position") String position);

    @Update("update classroom set size= #{size},position = #{position} where id= #{id}")
    void updateClassroom(@Param("size") Integer size,@Param("position") String position);

    @Delete("delete from classroom where id = #{id}")
    void deleteClassroom(@Param("id") Integer id);


}
