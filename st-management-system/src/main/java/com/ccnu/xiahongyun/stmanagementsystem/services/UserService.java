package com.ccnu.xiahongyun.stmanagementsystem.services;

import com.ccnu.xiahongyun.stmanagementsystem.model.User;
import org.springframework.stereotype.Service;

public interface UserService {

    void insertUsers(User user);

    void deleteUsers(User user);

    void updateUsers(User user);
}
