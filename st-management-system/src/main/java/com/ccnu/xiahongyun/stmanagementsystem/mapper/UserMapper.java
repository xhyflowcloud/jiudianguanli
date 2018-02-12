package com.ccnu.xiahongyun.stmanagementsystem.mapper;

import com.ccnu.xiahongyun.stmanagementsystem.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    @Select("select * from User where id = #{id}")
    User findUserById(@Param("id") Long id);

    @Insert("insert into User(id, name, age) values(#{id}, #{name}, #{age})")
    void insertUser(@Param("id") Long id, @Param("name") String name, @Param("age") Integer age);
}
