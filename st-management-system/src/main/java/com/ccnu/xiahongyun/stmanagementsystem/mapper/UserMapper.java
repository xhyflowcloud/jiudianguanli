package com.ccnu.xiahongyun.stmanagementsystem.mapper;

import com.ccnu.xiahongyun.stmanagementsystem.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    @Insert("insert into Users (userName,userIDNum,phone) values(userName=#{userName},userIDNum=#{userIDNum},phone=#{phone} )")
    void insertUsers(User user);

    @Delete("delete from Users where UserId =#{UserId}")
    void deleteUsers(User user);

    @Update("update Users set userName=#{userName},userIDNum=#{userIDNum},phone=#{phone} where UserId=#{UserId}")
    void updateUsers(User user);
}
