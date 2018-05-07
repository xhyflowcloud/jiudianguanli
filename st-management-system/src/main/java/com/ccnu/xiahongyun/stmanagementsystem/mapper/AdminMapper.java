package com.ccnu.xiahongyun.stmanagementsystem.mapper;

import com.ccnu.xiahongyun.stmanagementsystem.model.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AdminMapper {

    @Insert("insert into Admin(username, password) values(username=#{username}, password=#{password})")
    void InsertAdmin(Admin admin);

    @Select("select id, username, password from Admin where username=#{username}")
    Admin SelectAdminByUsername(String username);
}
