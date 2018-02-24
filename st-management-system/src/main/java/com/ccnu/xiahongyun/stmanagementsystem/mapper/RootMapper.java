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
    List<Root> findAllroot();

    @Select("select * from root where id = #{id}")
    Root findRootById(@Param("id") Integer id);

    @Select("select * from root where email = #{email}")
    Root findRootByEmail(@Param("email") String email);

    @Insert("insert into root(email,pwd,auth,last_pwd_change,enable) values(#{email},#{pwd},#{auth},#{last_pwd_change},#{enable})")
    void insertroot(@Param("email") String email, @Param("pwd") String pwd, @Param("auth") Integer auth, @Param("last_pwd_change") Long last_pwd_change, @Param("enable") Boolean enable);

    @Update("update root set email=#{email}, pwd=#{pwd},auth=#{auth} ,last_pwd_change=#{last_pwd_change} ,enable=#{enable} where id= #{id}")
    void updateroot(@Param("id") Integer id,@Param("email") String email, @Param("pwd") String pwd, @Param("auth") Integer auth, @Param("last_pwd_change") Long last_pwd_change, @Param("enable") Boolean enable);

    @Delete("delete from root where id = #{id}")
    void deleteroot(@Param("id") Integer id);
}
