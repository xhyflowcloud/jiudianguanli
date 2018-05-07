package com.ccnu.xiahongyun.stmanagementsystem.services.Impl;

import com.ccnu.xiahongyun.stmanagementsystem.mapper.RoomMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.Room;
import com.ccnu.xiahongyun.stmanagementsystem.query.RoomQuery;
import com.ccnu.xiahongyun.stmanagementsystem.services.UnCheckInService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class UnCheckInServiceImpl implements UnCheckInService {

    private final RoomMapper roomMapper;

    public UnCheckInServiceImpl(RoomMapper roomMapper) {
        this.roomMapper = roomMapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public List<Room> getRoomByQuery(RoomQuery roomQuery) throws Exception{
        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
        roomQuery.setTimeBegin(time.parse(time.format(roomQuery.getTimeBegin())));
        roomQuery.setTimeEnd(time.parse(time.format(roomQuery.getTimeEnd())));
        return roomMapper.selectRoomByQuery(roomQuery);
    }
}
