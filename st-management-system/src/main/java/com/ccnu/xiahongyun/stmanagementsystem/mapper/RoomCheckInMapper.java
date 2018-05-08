package com.ccnu.xiahongyun.stmanagementsystem.mapper;

import com.ccnu.xiahongyun.stmanagementsystem.model.RoomCheckIn;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RoomCheckInMapper {
    @Insert("insert into RoomCheckIn (timeBegin,timeEnd,userId,roomId,swimming,gym,freeDinks,totPrice)" +
            " values(#{timeBegin},#{timeEnd},#{userId},#{roomId},#{swimming},#{gym},#{freeDinks},#{totPrice} )")
    void insertRoomCheckIn(RoomCheckIn roomCheckIn);

    @Delete("delete from RoomCheckIn where roomCheckInId =#{roomCheckInId }")
    void deleteRoomCheckIn(RoomCheckIn roomCheckIn);

    @Update("update RoomCheckIn set timebegin=#{timeBegin},timeEnd=#{timeEnd},userId=#{userId},roomId=#{roomId},swimming=#{swimming},gym=#{gym},freeDinks=#{freeDinks},totPrice=#{totPrice} " +
            "where RoomCheckInId=#{RoomCheckInId}")
    void updateRoomCheckIn(RoomCheckIn roomCheckIn);


}
