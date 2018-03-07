package com.ccnu.xiahongyun.stmanagementsystem.services.Impl;

import com.ccnu.xiahongyun.stmanagementsystem.mapper.RegisterMapper;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.RootMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.Register;
import com.ccnu.xiahongyun.stmanagementsystem.model.Root;
import com.ccnu.xiahongyun.stmanagementsystem.services.RegisterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterServiceImpl implements RegisterService{

    private final RegisterMapper registerMapper;
    private final RootMapper rootMapper;

    public RegisterServiceImpl(RegisterMapper registerMapper, RootMapper rootMapper) {
        this.registerMapper = registerMapper;
        this.rootMapper = rootMapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void addRegister(Register register) {
        registerMapper.insertRegister(register);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Register findRegisterById(String email) {

        Register register = registerMapper.findRegisterByEmail(email);
        return register;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Boolean checkRoles(String email) {
        Root root = rootMapper.findRootByEmail(email);
        if(root != null && root.getAuth() > 10){
            return true;
        }else{
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Register queryIdenty(String email) {
        Register register = registerMapper.findRegisterByEmail(email);
        return register;
    }
}
