package com.ccnu.xiahongyun.stmanagementsystem.services.Impl;

import com.ccnu.xiahongyun.stmanagementsystem.mapper.RoomCheckInMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.RoomCheckIn;
import com.ccnu.xiahongyun.stmanagementsystem.services.RoomCheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomCheckInServiceImpl implements RoomCheckInService{
    @Autowired
    private RoomCheckInMapper roomCheckInMapper;

    @Override
    public void insertRoomCheckIn(RoomCheckIn roomCheckIn) {
        roomCheckInMapper.insertRoomCheckIn(roomCheckIn);
    }

    @Override
    public void deleteRoomCheckIn(RoomCheckIn roomCheckIn) {
        roomCheckInMapper.deleteRoomCheckIn(roomCheckIn);
    }

    @Override
    public void updateRoomCheckin(RoomCheckIn roomCheckIn) {
        roomCheckInMapper.updateRoomCheckIn(roomCheckIn);
    }
}
