package com.ccnu.xiahongyun.stmanagementsystem.services.Impl;

import com.ccnu.xiahongyun.stmanagementsystem.mapper.RoomCheckInMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.RoomCheckIn;
import com.ccnu.xiahongyun.stmanagementsystem.services.RoomCheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoomCheckInServiceImpl implements RoomCheckInService{
    @Autowired
    private RoomCheckInMapper roomCheckInMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void insertRoomCheckIn(RoomCheckIn roomCheckIn) {
        roomCheckInMapper.insertRoomCheckIn(roomCheckIn);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void deleteRoomCheckIn(RoomCheckIn roomCheckIn) {
        roomCheckInMapper.deleteRoomCheckIn(roomCheckIn);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void updateRoomCheckin(RoomCheckIn roomCheckIn) {
        roomCheckInMapper.updateRoomCheckIn(roomCheckIn);
    }
}
