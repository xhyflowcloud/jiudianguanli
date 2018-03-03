package com.ccnu.xiahongyun.stmanagementsystem.services.Impl;

import com.ccnu.xiahongyun.stmanagementsystem.mapper.RootMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.Root;
import com.ccnu.xiahongyun.stmanagementsystem.services.AuthorityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorityServiceImpl implements AuthorityService{

    private final RootMapper rootMapper;

    public AuthorityServiceImpl(RootMapper rootMapper){
        this.rootMapper = rootMapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Root getRootByEmail(String email) {

        Root root = rootMapper.findRootByEmail(email);
        return root;
    }
}
