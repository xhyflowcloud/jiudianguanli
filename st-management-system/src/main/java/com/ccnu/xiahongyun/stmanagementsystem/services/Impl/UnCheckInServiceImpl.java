package com.ccnu.xiahongyun.stmanagementsystem.services.Impl;

import com.ccnu.xiahongyun.stmanagementsystem.mapper.RoomMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.Room;
import com.ccnu.xiahongyun.stmanagementsystem.query.QueryViewPage;
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
    public QueryViewPage<Room> getRoomByQuery(RoomQuery roomQuery) throws Exception{
        QueryViewPage<Room> roomQueryViewPage = new QueryViewPage<>();
        roomQuery.getTotal();
        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
        roomQuery.setTimeBegin(time.parse(time.format(roomQuery.getTimeBegin())));
        roomQuery.setTimeEnd(time.parse(time.format(roomQuery.getTimeEnd())));
        roomQueryViewPage.setResults(roomMapper.selectRoomByQuery(roomQuery));
        roomQueryViewPage.setTotalPage((roomMapper.selectRoomByQueryCount(roomQuery)));
        return roomQueryViewPage;
    }
}
