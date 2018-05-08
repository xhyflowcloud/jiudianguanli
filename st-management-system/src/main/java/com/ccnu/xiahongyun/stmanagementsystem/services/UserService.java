package com.ccnu.xiahongyun.stmanagementsystem.services;

import com.ccnu.xiahongyun.stmanagementsystem.model.User;
import com.ccnu.xiahongyun.stmanagementsystem.query.CheckInInfo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    void insertUsers(User user);

    void deleteUsers(User user);

    void updateUsers(User user);

    List<CheckInInfo> selectCheckInInfo(CheckInInfo checkInInfo);
}
