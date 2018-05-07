package com.ccnu.xiahongyun.stmanagementsystem.services.Impl;

import com.ccnu.xiahongyun.stmanagementsystem.mapper.AdminMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.Admin;
import com.ccnu.xiahongyun.stmanagementsystem.services.RegisterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterServiceImpl implements RegisterService{

    private final AdminMapper adminMapper;

    public RegisterServiceImpl(AdminMapper adminMapper) {
       this.adminMapper = adminMapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Admin SelectAdminByUsername(String username) {
        return adminMapper.SelectAdminByUsername(username);
    }
}
