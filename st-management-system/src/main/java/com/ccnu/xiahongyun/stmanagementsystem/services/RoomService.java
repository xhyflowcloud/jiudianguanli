package com.ccnu.xiahongyun.stmanagementsystem.services;

import com.ccnu.xiahongyun.stmanagementsystem.model.Room;
import com.ccnu.xiahongyun.stmanagementsystem.query.RoomsQuery;

import java.util.List;

import java.util.Map;

public interface RoomService {
    void insertRoom(Room room);

    void deleteRoom(Room room);

    void updateRoom(Room room);

    List<RoomsQuery> selectRooms(RoomsQuery roomsQuery);



    Map<String, Object> getRoomById(Integer roomId);
}
