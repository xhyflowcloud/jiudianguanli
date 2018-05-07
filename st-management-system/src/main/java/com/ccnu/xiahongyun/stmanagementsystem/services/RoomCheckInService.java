package com.ccnu.xiahongyun.stmanagementsystem.services;

import com.ccnu.xiahongyun.stmanagementsystem.model.RoomCheckIn;

public interface RoomCheckInService {
    void insertRoomCheckIn(RoomCheckIn roomCheckIn);

    void deleteRoomCheckIn(RoomCheckIn roomCheckIn);

    void updateRoomCheckin(RoomCheckIn roomCheckIn);
}
