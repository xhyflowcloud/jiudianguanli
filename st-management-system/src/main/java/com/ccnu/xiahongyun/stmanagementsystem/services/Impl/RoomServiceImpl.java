package com.ccnu.xiahongyun.stmanagementsystem.services.Impl;

import com.ccnu.xiahongyun.stmanagementsystem.mapper.RoomMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.Room;
import com.ccnu.xiahongyun.stmanagementsystem.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomMapper roomMapper;
    @Override
    public void insertRoom(Room room) {
        roomMapper.insertRoom(room);
    }

    @Override
    public void deleteRoom(Room room) {
        roomMapper.deleteRoom(room);
    }

    @Override
    public void updateRoom(Room room) {
        roomMapper.updateRoom(room);
    }
}
