package com.ccnu.xiahongyun.stmanagementsystem.services.Impl;

import com.ccnu.xiahongyun.stmanagementsystem.mapper.RoomTypeMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.RoomType;
import com.ccnu.xiahongyun.stmanagementsystem.services.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoomTypeServiceImpl implements RoomTypeService{
    @Autowired
    private RoomTypeMapper roomTypeMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void insertRoomType(RoomType roomType) {
        roomTypeMapper.insertRoomType(roomType);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void deleteRoomType(RoomType roomType) {
        roomTypeMapper.deleteRoomType(roomType);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void updateRoomType(RoomType roomType) {
        roomTypeMapper.updateRoomType(roomType);
    }
}
