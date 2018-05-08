package com.ccnu.xiahongyun.stmanagementsystem.mapper;

import com.ccnu.xiahongyun.stmanagementsystem.model.Room;
import com.ccnu.xiahongyun.stmanagementsystem.query.RoomQuery;
import com.ccnu.xiahongyun.stmanagementsystem.query.RoomsQuery;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RoomMapper {

 @Insert(" insert into Room( roomName, pURL, type )  values ( #{roomName}, #{pURL},#{type} ) ")
 void insertRoom(Room room);

 @Delete("delete from Room where roomId = #{roomId} ")
 void deleteRoom(Room room);

 @Update( "update Room set roomName = #{roomName},pURL=#{pURL},type=#{type} where roomId = #{roomId}")
 void updateRoom(Room room);

 @Select("select * from Room A, RoomCheckIn B where A.roomId = B.roomId and A.roomId not in(select roomId from RoomCheckIn C where C.timeEnd > CURRENT_DATE and (C.timeBegin < #{timeEnd} and C.timeBegin > #{timeBegin}) or (C.timeEnd < #{timeEnd} and C.timeEnd > #{timeBegin}) or (C.timeEnd > #{timeEnd} and C.timeBegin < #{timeBegin})) limit #{total}, #{pageSize}")
 List<Room> selectRoomByQuery(RoomQuery roomQuery);

 @Select("select count(*) from Room A, RoomCheckIn B where A.roomId = B.roomId and A.roomId not in(select roomId from RoomCheckIn C where C.timeEnd > CURRENT_DATE and (C.timeBegin < #{timeEnd} and C.timeBegin > #{timeBegin}) or (C.timeEnd < #{timeEnd} and C.timeEnd > #{timeBegin}) or (C.timeEnd > #{timeEnd} and C.timeBegin < #{timeBegin})) limit #{total}, #{pageSize}")
 Integer selectRoomByQueryCount(RoomQuery roomQuery);

 @Select("select roomId,roomName,pURL,type,price from Room,RoomType where type=#{type} limit #{total} ,#{pageSize}")
 List<RoomsQuery> selectRooms(RoomsQuery roomsQuery);
 @Select("select * from Room where roomId=#{roomId}")
 Room selectRoomById(Integer roomId);

 @Select("select price from RoomType where type = #{type}")
 Double getPriceByType(String type);

}
