package com.ccnu.xiahongyun.stmanagementsystem.mapper;

import com.ccnu.xiahongyun.stmanagementsystem.model.Register;
import org.apache.ibatis.annotations.*;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RegisterMapper {
    @Select("select * from register")
    List<Register> findAllRegister();

    @Select("select * from register where id = #{id}")
    Register findRegisterById(@Param("id") Integer id);

    @Select("select * from register where email = #{email}")
    Register findRegisterByEmail(@Param("email") String email);

    @Insert("insert into register (name,email,pwd) values (#{name}, #{email}, #{pwd}) ")
    void insertRegister(Register register);

    @Update("update register set name=#{name},email=#{email},pwd=#{pwd} where id= #{id}")
    void updateRegister(@Param("name") String name,@Param("email") String email,@Param("pwd") String pwd,@Param("id") Integer id );

    @Delete("delete from register where id = #{id}")
    void deleteRegister(@Param("id") Integer id);
}
