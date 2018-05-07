package com.ccnu.xiahongyun.stmanagementsystem.services;

import com.ccnu.xiahongyun.stmanagementsystem.model.Room;
import com.ccnu.xiahongyun.stmanagementsystem.query.RoomQuery;

import java.util.List;

public interface UnCheckInService {

    List<Room> getRoomByQuery(RoomQuery roomQuery) throws Exception;
}
