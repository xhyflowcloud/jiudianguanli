package com.ccnu.xiahongyun.stmanagementsystem.services.Impl;

import com.ccnu.xiahongyun.stmanagementsystem.mapper.RoomMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.Room;
import com.ccnu.xiahongyun.stmanagementsystem.query.RoomsQuery;
import com.ccnu.xiahongyun.stmanagementsystem.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public List<RoomsQuery> selectRooms(RoomsQuery roomsQuery) {
       return roomMapper.selectRooms(roomsQuery);
    }
}
