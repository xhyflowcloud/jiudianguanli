package com.ccnu.xiahongyun.stmanagementsystem.services.Impl;

import com.ccnu.xiahongyun.stmanagementsystem.mapper.RoomMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.Room;
import com.ccnu.xiahongyun.stmanagementsystem.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomMapper roomMapper;
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void insertRoom(Room room) {
        roomMapper.insertRoom(room);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void deleteRoom(Room room) {
        roomMapper.deleteRoom(room);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void updateRoom(Room room) {
        roomMapper.updateRoom(room);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Map<String, Object> getRoomById(Integer roomId) {
        Room room = roomMapper.selectRoomById(roomId);
        Double price = roomMapper.getPriceByType(room.getType());

        Map<String, Object> roomInfo = new HashMap<>();
        roomInfo.put("roomId", room.getRoomId());
        roomInfo.put("roomName", room.getRoomName());
        roomInfo.put("pURL", room.getpURL());
        roomInfo.put("type", room.getType());
        roomInfo.put("price", price);
        return roomInfo;
    }
}
