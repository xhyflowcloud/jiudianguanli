package com.ccnu.xiahongyun.stmanagementsystem.mapper;

import com.ccnu.xiahongyun.stmanagementsystem.model.RoomType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RoomTypeMapper {

    @Insert("insert into RoomType (type,price) values(#{type},#{price})")
    void insertRoomType(RoomType roomType);

    @Delete("delete from RoomType where RoomTypeId = #{RoomTypeId}")
    void deleteRoomType(RoomType roomType);

    @Update("update RoomType set type=#{type},price=#{price}  where RoomTypeId = #{RoomTypeId}")
    void updateRoomType(RoomType roomType);
}
