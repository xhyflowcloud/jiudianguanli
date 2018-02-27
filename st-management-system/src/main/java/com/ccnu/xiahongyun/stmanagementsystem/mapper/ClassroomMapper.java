package com.ccnu.xiahongyun.stmanagementsystem.mapper;

import com.ccnu.xiahongyun.stmanagementsystem.model.Classroom;
import com.ccnu.xiahongyun.stmanagementsystem.query.ClassroomQuery;
import com.ccnu.xiahongyun.stmanagementsystem.query.SQLProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClassroomMapper {




    @Insert("insert into classroom( size,starttime, endtime,position, isEnable) values(#{size},#{starttime} ,#{endtime},#{position}, #{isEnable})")
    void insertClassroom(@Param("size") Integer size,@Param("starttime") Long starttime,
                         @Param("endtime") Long endtime,@Param("position") String position,
                         @Param("isEnable") Boolean isEnable);

    @Update("update classroom set size= #{size},starttime=#{starttime},endtime=#{endtime},position = #{position}, isEnable = #{isEnable} where id= #{id}")
    void updateClassroom(@Param("size") Integer size,@Param("starttime") Long starttime,@Param("endtime") Long endtime,
                         @Param("position") String position,
                         @Param("isEnable") Boolean isEnable, @Param("id") Integer id);


    @Delete("delete from classroom where id = #{id}")
    void deleteClassroom(@Param("id") Integer id);


    @SelectProvider(type = SQLProvider.class, method = "selectClassroom")
    List<Classroom> findClassroomByLimit(ClassroomQuery classroom);

    @SelectProvider(type = SQLProvider.class, method = "selectClassroomCount")
    Integer findClassroomCount(ClassroomQuery classroom);

}
