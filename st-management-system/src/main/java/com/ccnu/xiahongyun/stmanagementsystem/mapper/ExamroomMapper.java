package com.ccnu.xiahongyun.stmanagementsystem.mapper;


import com.ccnu.xiahongyun.stmanagementsystem.model.Examroom;
import com.ccnu.xiahongyun.stmanagementsystem.query.ExamroomQuery;
import com.ccnu.xiahongyun.stmanagementsystem.query.SQLProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ExamroomMapper {
    @Select("select * from examroom")
    List<Examroom> findAllExamroom();

    @Select("select * from examroom where id = #{id}")
    Examroom findExamroomById(@Param("id") Integer id);

    @Select("select id from examroom where sid = #{sid} and tid = #{tid}")
    Integer findIdBySubAndTea(@Param("sid") Integer sid, @Param("tid") Integer tid);

    @Insert("insert into examroom(rid,tid,number,sid) values(#{rid}, #{tid}, #{number}, #{sid})")
    void insertExamroom(Examroom examroom);

    @Update("update examroom set rid=#{rid},tid=#{tid},number=#{number},tid=#{tid} where id= #{id}")
    void updateExamroom(Examroom examroom);

    @Delete("delete from examroom where id = #{id}")
    void deleteExamroom(@Param("id") Integer id);

    @Delete("delete from examroom where sid = #{sid}")
    void deleteExamroomBySubjectId(@Param("sid") Integer sid);

    @SelectProvider(type = SQLProvider.class, method = "selectExamroom")
    List<Examroom> findExamroomByLimit(ExamroomQuery examroom);

    @SelectProvider(type = SQLProvider.class, method = "selectExamroomCount")
    Integer findExamroomCount(ExamroomQuery examroom);
}
