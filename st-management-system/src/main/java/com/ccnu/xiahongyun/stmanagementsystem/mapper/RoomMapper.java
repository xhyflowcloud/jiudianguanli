package com.ccnu.xiahongyun.stmanagementsystem.mapper;

import com.ccnu.xiahongyun.stmanagementsystem.model.Room;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RoomMapper {

 @Insert(" insert into Room( roomName, pURL, type )  values ( roomName= #{roomName}, pURL=#{pURL},type=#{type} ) ")
 void insertRoom(Room room);

 @Delete("delete from Room where roomId = #{roomId} ")
 void deleteRoom(Room room);

 @Update( "update Room set roomName = #{roomName},pURL=#{pURL},type=#{type} where roomId = #{roomId}")
 void updateRoom(Room room);

}
