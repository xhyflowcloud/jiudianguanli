package com.ccnu.xiahongyun.stmanagementsystem.services.Impl;

import com.ccnu.xiahongyun.stmanagementsystem.mapper.UserMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.User;
import com.ccnu.xiahongyun.stmanagementsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private  UserMapper userMapper;
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void insertUsers(User user) {
        userMapper.insertUsers(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void deleteUsers(User user) {
        userMapper.deleteUsers(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void updateUsers(User user) {
        userMapper.updateUsers(user);
    }
}
