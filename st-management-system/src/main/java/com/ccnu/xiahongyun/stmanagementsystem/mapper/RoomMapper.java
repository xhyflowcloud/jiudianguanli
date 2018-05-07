package com.ccnu.xiahongyun.stmanagementsystem.mapper;

import com.ccnu.xiahongyun.stmanagementsystem.model.Room;
import com.ccnu.xiahongyun.stmanagementsystem.query.RoomQuery;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RoomMapper {

 @Insert(" insert into Room(roomId, roomName, pURL, type )  values (roomId=#{roomId},roomName= #{roomName}, pURL=#{pURL},type=#{type} ) ")
 void insertRoom(Room room);

 @Delete("delete from Room where roomId = #{roomId} ")
 void deleteRoom(Room room);

 @Update( "update Room set roomName = #{roomName},pURL=#{pURL},type=#{type} ")
 void updateRoom(Room room);

 @Select("select * from Room A, RoomCheckIn B where A.roomId = B.roomId and A.roomId not in(select roomId from B where B.timeEnd > CURRENT_DATE and (B.timeBegin < #{timeEnd} and B.timeBegin > #{timeBegin}) or (B.timeEnd < #{timeEnd} and B.timeEnd > #{timeBegin}) or B.timeEnd > #{timeEnd} and B.timeBegin < #{timeBegin})")
 List<Room> selectRoomByQuery(RoomQuery roomQuery);

}
