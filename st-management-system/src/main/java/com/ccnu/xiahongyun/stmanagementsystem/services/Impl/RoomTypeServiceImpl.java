package com.ccnu.xiahongyun.stmanagementsystem.services.Impl;

import com.ccnu.xiahongyun.stmanagementsystem.mapper.RoomTypeMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.RoomType;
import com.ccnu.xiahongyun.stmanagementsystem.services.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomTypeServiceImpl implements RoomTypeService{
    @Autowired
    private RoomTypeMapper roomTypeMapper;

    @Override
    public void insertRoomType(RoomType roomType) {
        roomTypeMapper.insertRoomType(roomType);
    }

    @Override
    public void deleteRoomType(RoomType roomType) {
        roomTypeMapper.deleteRoomType(roomType);
    }

    @Override
    public void updateRoomType(RoomType roomType) {
        roomTypeMapper.updateRoomType(roomType);
    }
}
