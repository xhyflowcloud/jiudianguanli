package com.ccnu.xiahongyun.stmanagementsystem.mapper;

import com.ccnu.xiahongyun.stmanagementsystem.model.User;
import com.ccnu.xiahongyun.stmanagementsystem.query.CheckInInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    @Insert("insert into Users (userName,userIDNum,phone) values(#{userName},#{userIDNum},#{phone} )")
    void insertUsers(User user);

    @Delete("delete from Users where UserId =#{UserId}")
    void deleteUsers(User user);

    @Update("update Users set userName=#{userName},userIDNum=#{userIDNum},phone=#{phone} where UserId=#{UserId}")
    void updateUsers(User user);

    @Select("select * from RoomCheckIn A,User B where A.userId=B.userId ")
    List<CheckInInfo> selectCheckInInfo(CheckInInfo checkInInfo);
}
