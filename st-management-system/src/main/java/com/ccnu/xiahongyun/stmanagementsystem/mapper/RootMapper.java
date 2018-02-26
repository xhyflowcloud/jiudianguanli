package com.ccnu.xiahongyun.stmanagementsystem.mapper;


import com.ccnu.xiahongyun.stmanagementsystem.model.Root;
import org.apache.ibatis.annotations.*;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RootMapper {
    @Select("select * from root ")
    List<Root> findAllRoot();

    @Select("select * from root where id = #{id}")
    Root findRootById(@Param("id") Integer id);

    @Select("select * from root where email = #{email}")
    Root findRootByEmail(@Param("email") String email);

    @Insert("insert into root(email,auth,enable) values(#{email},#{auth},#{enable})")
    void insertRoot(@Param("email") String email, @Param("auth") Integer auth, @Param("enable") Boolean enable);

    @Update("update root set email=#{email},auth=#{auth},enable=#{enable} where id= #{id}")
    void updateRoot(@Param("id") Integer id,@Param("email") String email, @Param("auth") Integer auth,@Param("enable") Boolean enable);

    @Delete("delete from root where id = #{id}")
    void deleteRoot(@Param("id") Integer id);
}
