package com.ccnu.xiahongyun.stmanagementsystem.services;

import com.ccnu.xiahongyun.stmanagementsystem.model.Room;

import java.util.Map;

public interface RoomService {
    void insertRoom(Room room);

    void deleteRoom(Room room);

    void updateRoom(Room room);

    Map<String, Object> getRoomById(Integer roomId);
}
